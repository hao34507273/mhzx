/*      */ package mzm.gsp.cake.main;
/*      */ 
/*      */ import java.util.Collection;
/*      */ import java.util.HashSet;
/*      */ import java.util.Iterator;
/*      */ import java.util.Map;
/*      */ import java.util.Map.Entry;
/*      */ import java.util.Set;
/*      */ import mzm.gsp.GameServer;
/*      */ import mzm.gsp.GameServerInfoManager;
/*      */ import mzm.gsp.activity4.confbean.SCakeActivityCfg;
/*      */ import mzm.gsp.activity4.confbean.SOvenPerformanceCfg;
/*      */ import mzm.gsp.activity4.confbean.STOvenPerformanceCfg;
/*      */ import mzm.gsp.cake.SCakeInfoChangeBro;
/*      */ import mzm.gsp.cake.SCakeNormalNotice;
/*      */ import mzm.gsp.gang.main.GangInterface;
/*      */ import mzm.gsp.map.main.ControllerInterface;
/*      */ import mzm.gsp.map.main.MapInterface;
/*      */ import mzm.gsp.map.main.scene.object.MapEntityType;
/*      */ import mzm.gsp.online.main.OnlineManager;
/*      */ import mzm.gsp.timer.main.Session;
/*      */ import mzm.gsp.tlog.TLogManager;
/*      */ import mzm.gsp.util.DateTimeUtils;
/*      */ import mzm.gsp.util.LogicProcedure;
/*      */ import mzm.gsp.util.LogicRunnable;
/*      */ import org.apache.log4j.Logger;
/*      */ import xbean.CakeData;
/*      */ import xbean.CakeDetailData;
/*      */ import xbean.CakeInfo;
/*      */ import xbean.FactionCakeData;
/*      */ import xbean.FactionCakeInfo;
/*      */ import xbean.GlobalCakeData;
/*      */ import xbean.GlobalCakeInfo;
/*      */ import xbean.Pod;
/*      */ import xtable.Factioncake;
/*      */ import xtable.Globalcake;
/*      */ 
/*      */ public class CakeManager
/*      */ {
/*   40 */   private static String loggerTag = "[cake]";
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static final String ENCODING = "UTF-8";
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static CakeData getXCakeDataIfAbsent(long roleId, int activityId)
/*      */   {
/*   55 */     CakeInfo xCakeInfo = xtable.Role2cakeinfo.get(Long.valueOf(roleId));
/*   56 */     if (xCakeInfo == null)
/*      */     {
/*   58 */       xtable.Role2cakeinfo.insert(Long.valueOf(roleId), xCakeInfo = Pod.newCakeInfo());
/*      */     }
/*   60 */     CakeData xCakeData = (CakeData)xCakeInfo.getCakedatas().get(Integer.valueOf(activityId));
/*   61 */     if (xCakeData == null)
/*      */     {
/*   63 */       xCakeInfo.getCakedatas().put(Integer.valueOf(activityId), xCakeData = Pod.newCakeData());
/*      */     }
/*   65 */     return xCakeData;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static GlobalCakeData getXGlobalCakeData(int activityId)
/*      */   {
/*   78 */     GlobalCakeInfo xGlobalCakeInfo = Globalcake.get(Long.valueOf(GameServerInfoManager.getLocalId()));
/*   79 */     if (xGlobalCakeInfo == null)
/*      */     {
/*   81 */       return null;
/*      */     }
/*   83 */     return (GlobalCakeData)xGlobalCakeInfo.getFactioncakedatas().get(Integer.valueOf(activityId));
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static FactionCakeData getXFactionCakeData(long factionId, int activityId)
/*      */   {
/*   97 */     return getXFactionCakeData(factionId, activityId, true);
/*      */   }
/*      */   
/*      */   static FactionCakeData getXFactionCakeData(long factionId, int activityId, boolean remainLock)
/*      */   {
/*  102 */     FactionCakeInfo xFactionCakeInfo = remainLock ? Factioncake.get(Long.valueOf(factionId)) : Factioncake.select(Long.valueOf(factionId));
/*      */     
/*  104 */     if (xFactionCakeInfo == null)
/*      */     {
/*  106 */       return null;
/*      */     }
/*  108 */     return (FactionCakeData)xFactionCakeInfo.getFactioncakedatas().get(Integer.valueOf(activityId));
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void onPrepareStageStart(int activityId, long interval) {}
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean startCakeActivity(int activityId, int startTurn, long nextTurnStartTime)
/*      */   {
/*  126 */     SCakeActivityCfg activityCfg = SCakeActivityCfg.get(activityId);
/*  127 */     if (activityCfg == null)
/*      */     {
/*  129 */       loggerError("CakeManager.startCakeActivity@ SCakeActivityCfg is null!| activityId=%d", new Object[] { Integer.valueOf(activityId) });
/*  130 */       return false;
/*      */     }
/*  132 */     if (startTurn > getCookMaxTurn(activityCfg))
/*      */     {
/*  134 */       loggerError("CakeManager.startCakeActivity@ startTurn is over max!| activityId=%d|startTurn=%d", new Object[] { Integer.valueOf(activityId), Integer.valueOf(startTurn) });
/*      */       
/*  136 */       return false;
/*      */     }
/*  138 */     long curTime = DateTimeUtils.getCurrTimeInMillis();
/*  139 */     long interval = nextTurnStartTime - curTime;
/*  140 */     if (interval > getNeedMillsPerTurn(activityCfg))
/*      */     {
/*  142 */       loggerError("CakeManager.startCakeActivity@ nextTurnStartTime is illegal!| activityId=%d|curTime=%d|nextTurnStartTime=%d", new Object[] { Integer.valueOf(activityId), Long.valueOf(curTime), Long.valueOf(nextTurnStartTime) });
/*      */       
/*      */ 
/*  145 */       return false;
/*      */     }
/*  147 */     if (interval > activityCfg.cookTime * 1000L)
/*      */     {
/*      */ 
/*  150 */       return globalOnCollectionStart(activityId, startTurn, (interval - activityCfg.cookTime * 1000L) / 1000L, activityCfg, curTime);
/*      */     }
/*      */     
/*      */ 
/*  154 */     return globalOnCookStart(activityId, startTurn, interval / 1000L, activityCfg, curTime);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean globalOnCollectionStart(int activityId, int turn, long cookTime, SCakeActivityCfg activityCfg, long curTime)
/*      */   {
/*  164 */     loggerInfo("start collect!|activityId=%d|turn=%d", new Object[] { Integer.valueOf(activityId), Integer.valueOf(turn) });
/*      */     
/*  166 */     GlobalCakeData xGlobalCakeData = getXGlobalCakeDataIfAbsent(activityId);
/*      */     
/*  168 */     xGlobalCakeData.setCurturn(turn);
/*  169 */     xGlobalCakeData.setCurstage(2);
/*  170 */     xGlobalCakeData.setIsgoing(true);
/*  171 */     xGlobalCakeData.setStagestarttime(curTime);
/*      */     
/*  173 */     new CollectionStageEndSession(cookTime, activityId, turn, activityCfg.cookTime);
/*      */     
/*  175 */     allFactionOnCollectionStart(activityId, turn);
/*  176 */     return true;
/*      */   }
/*      */   
/*      */   static GlobalCakeData getXGlobalCakeDataIfAbsent(int activityId)
/*      */   {
/*  181 */     GlobalCakeInfo xGlobalCakeInfo = Globalcake.get(Long.valueOf(GameServerInfoManager.getLocalId()));
/*  182 */     if (xGlobalCakeInfo == null)
/*      */     {
/*  184 */       Globalcake.insert(Long.valueOf(GameServerInfoManager.getLocalId()), xGlobalCakeInfo = Pod.newGlobalCakeInfo());
/*      */     }
/*  186 */     GlobalCakeData xGlobalCakeData = (GlobalCakeData)xGlobalCakeInfo.getFactioncakedatas().get(Integer.valueOf(activityId));
/*  187 */     if (xGlobalCakeData == null)
/*      */     {
/*  189 */       xGlobalCakeInfo.getFactioncakedatas().put(Integer.valueOf(activityId), xGlobalCakeData = Pod.newGlobalCakeData());
/*      */     }
/*  191 */     return xGlobalCakeData;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void allFactionOnCollectionStart(int activityId, final int turn)
/*      */   {
/*  202 */     new LogicRunnable()
/*      */     {
/*      */ 
/*      */       public void process()
/*      */         throws Exception
/*      */       {
/*  208 */         for (Iterator i$ = CreateSceneFactionCache.getInstance().getAllJoinedFactionIds().iterator(); i$.hasNext();) { long factionId = ((Long)i$.next()).longValue();
/*      */           
/*  210 */           new CakeManager.FactionOnCollectionStart(factionId, this.val$activityId, turn).call();
/*      */         }
/*      */       }
/*      */     }.execute();
/*      */   }
/*      */   
/*      */   private static class FactionOnCollectionStart
/*      */     extends LogicProcedure
/*      */   {
/*      */     private final long factionId;
/*      */     private final int activityId;
/*      */     private final int turn;
/*      */     
/*      */     public FactionOnCollectionStart(long factionId, int activityId, int turn)
/*      */     {
/*  225 */       this.factionId = factionId;
/*  226 */       this.activityId = activityId;
/*  227 */       this.turn = turn;
/*      */     }
/*      */     
/*      */     protected boolean processImp()
/*      */       throws Exception
/*      */     {
/*  233 */       CakeManager.factionOnCollectionStart(this.factionId, this.activityId, this.turn);
/*  234 */       return true;
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private static void factionOnCollectionStart(long factionId, int activityId, int turn)
/*      */   {
/*  250 */     SCakeActivityCfg activityCfg = SCakeActivityCfg.get(activityId);
/*  251 */     if (activityCfg == null)
/*      */     {
/*  253 */       loggerError("CakeManager.startCakeActivity@ SCakeActivityCfg is null!| activityId=%d", new Object[] { Integer.valueOf(activityId) });
/*  254 */       return;
/*      */     }
/*      */     
/*  257 */     if (GangInterface.getGang(factionId, true) == null)
/*      */     {
/*  259 */       return;
/*      */     }
/*  261 */     FactionCakeInfo xFactionCakeInfo = Factioncake.get(Long.valueOf(factionId));
/*  262 */     if (xFactionCakeInfo == null)
/*      */     {
/*  264 */       Factioncake.insert(Long.valueOf(factionId), xFactionCakeInfo = Pod.newFactionCakeInfo());
/*      */     }
/*  266 */     FactionCakeData xFactionCakeData = (FactionCakeData)xFactionCakeInfo.getFactioncakedatas().get(Integer.valueOf(activityId));
/*  267 */     if (xFactionCakeData == null)
/*      */     {
/*  269 */       xFactionCakeInfo.getFactioncakedatas().put(Integer.valueOf(activityId), xFactionCakeData = Pod.newFactionCakeData());
/*      */     }
/*  271 */     long worldId = GangInterface.getGangWorldId(factionId);
/*      */     
/*  273 */     ControllerInterface.collectWorldController(worldId, activityCfg.materialController);
/*      */     
/*  275 */     if (xFactionCakeData.getCurturn() != turn - 1)
/*      */     {
/*      */ 
/*  278 */       xFactionCakeData.getRolecakes().clear();
/*      */     }
/*  280 */     xFactionCakeData.setCurturn(turn);
/*      */     
/*  282 */     sendCake(activityId, turn - 1, xFactionCakeData);
/*      */     
/*  284 */     xFactionCakeData.setAwarded(true);
/*      */     
/*  286 */     triggerControllers(activityCfg, factionId, worldId);
/*      */     
/*  288 */     changeOvenState(activityId, factionId, GangInterface.getGangWorldId(factionId), 2);
/*      */     
/*  290 */     GangInterface.brocastInGang(getCakeNormalNotice(40, new String[0]), factionId);
/*      */   }
/*      */   
/*      */   private static void sendCake(int activityId, int turn, FactionCakeData xFactionCakeData)
/*      */   {
/*  295 */     if ((xFactionCakeData.getRolecakes().isEmpty()) || (xFactionCakeData.getAwarded()))
/*      */     {
/*  297 */       return;
/*      */     }
/*      */     
/*  300 */     for (Map.Entry<Long, CakeDetailData> xEntry : xFactionCakeData.getRolecakes().entrySet())
/*      */     {
/*  302 */       long roleId = ((Long)xEntry.getKey()).longValue();
/*  303 */       CakeDetailData xCakeDetailData = (CakeDetailData)xEntry.getValue();
/*  304 */       int cakeId = xCakeDetailData.getNextcakeid() != 0 ? xCakeDetailData.getNextcakeid() : xCakeDetailData.getCakeid();
/*      */       
/*      */ 
/*  307 */       mzm.gsp.util.NoneRealTimeTaskManager.getInstance().addTask(new PAwardCake(roleId, cakeId, activityId, turn));
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private static void triggerControllers(SCakeActivityCfg activityCfg, final long factionId, long worldId)
/*      */   {
/*  322 */     xdb.Procedure.execute(new LogicProcedure()
/*      */     {
/*      */ 
/*      */       protected boolean processImp()
/*      */         throws Exception
/*      */       {
/*  328 */         ControllerInterface.triggerWorldControllerWithMaxSpawnNum(this.val$worldId, factionId.materialController, CakeManager.getTriggerNum(factionId, this.val$factionId, this.val$worldId));
/*      */         
/*  330 */         return true;
/*      */       }
/*      */     });
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private static int getTriggerNum(SCakeActivityCfg activityCfg, long factionId, long worldId)
/*      */   {
/*  345 */     int factionMembersNum = getFactionMembers(factionId, worldId).size();
/*  346 */     int triggerNum = (int)(factionMembersNum * activityCfg.triggerCountRet);
/*  347 */     if (triggerNum > activityCfg.triggerCountMax)
/*      */     {
/*  349 */       return activityCfg.triggerCountMax;
/*      */     }
/*  351 */     if (triggerNum < activityCfg.triggerCountMin)
/*      */     {
/*  353 */       return activityCfg.triggerCountMin;
/*      */     }
/*  355 */     return triggerNum;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private static Set<Long> getFactionMembers(long factionId, long worldId)
/*      */   {
/*  369 */     Set<Long> roleIds = new HashSet();
/*  370 */     for (Iterator i$ = MapInterface.getRoleList(worldId).iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*      */       
/*  372 */       if (GangInterface.getGangId(roleId) == factionId)
/*      */       {
/*      */ 
/*      */ 
/*  376 */         roleIds.add(Long.valueOf(roleId)); }
/*      */     }
/*  378 */     return roleIds;
/*      */   }
/*      */   
/*      */   private static class CollectionStageEndSession extends Session
/*      */   {
/*      */     private final int turn;
/*      */     private final long cookTime;
/*      */     
/*      */     public CollectionStageEndSession(long interval, int activityId, int turn, long cookTime)
/*      */     {
/*  388 */       super(activityId);
/*  389 */       this.turn = turn;
/*  390 */       this.cookTime = cookTime;
/*      */     }
/*      */     
/*      */ 
/*      */     protected void onTimeOut()
/*      */     {
/*  396 */       new OnCollectionStageEnd((int)super.getOwerId()).execute();
/*      */     }
/*      */     
/*      */     private final class OnCollectionStageEnd
/*      */       extends LogicProcedure
/*      */     {
/*      */       private final int activityId;
/*      */       
/*      */       public OnCollectionStageEnd(int activityId)
/*      */       {
/*  406 */         this.activityId = activityId;
/*      */       }
/*      */       
/*      */       protected boolean processImp()
/*      */         throws Exception
/*      */       {
/*  412 */         SCakeActivityCfg activityCfg = SCakeActivityCfg.get(this.activityId);
/*  413 */         if (activityCfg == null)
/*      */         {
/*  415 */           CakeManager.loggerError("OnCollectionStageEnd.processImp@ SCakeActivityCfg is null!| activityId=%d", new Object[] { Integer.valueOf(this.activityId) });
/*  416 */           return false;
/*      */         }
/*  418 */         CakeManager.globalOnCookStart(this.activityId, CakeManager.CollectionStageEndSession.this.turn, CakeManager.CollectionStageEndSession.this.cookTime, activityCfg, DateTimeUtils.getCurrTimeInMillis());
/*  419 */         return true;
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   private static class CookStageEndSession
/*      */     extends Session
/*      */   {
/*      */     private final int turn;
/*      */     private final long collectionTime;
/*      */     
/*      */     public CookStageEndSession(long interval, int activityId, int turn, long collectionTime)
/*      */     {
/*  433 */       super(activityId);
/*  434 */       this.turn = turn;
/*  435 */       this.collectionTime = collectionTime;
/*      */     }
/*      */     
/*      */ 
/*      */     protected void onTimeOut()
/*      */     {
/*  441 */       new OnCookStageEnd((int)super.getOwerId()).execute();
/*      */     }
/*      */     
/*      */     private final class OnCookStageEnd
/*      */       extends LogicProcedure
/*      */     {
/*      */       private final int activityId;
/*      */       
/*      */       public OnCookStageEnd(int activityId)
/*      */       {
/*  451 */         this.activityId = activityId;
/*      */       }
/*      */       
/*      */       protected boolean processImp()
/*      */         throws Exception
/*      */       {
/*  457 */         SCakeActivityCfg activityCfg = SCakeActivityCfg.get(this.activityId);
/*  458 */         if (activityCfg == null)
/*      */         {
/*  460 */           CakeManager.loggerError("OnCookStageEnd.processImp@ SCakeActivityCfg is null!| activityId=%d", new Object[] { Integer.valueOf(this.activityId) });
/*  461 */           return false;
/*      */         }
/*  463 */         if (CakeManager.CookStageEndSession.this.turn > CakeManager.getCookMaxTurn(activityCfg))
/*      */         {
/*      */ 
/*  466 */           CakeManager.globalOnAllCookDone(this.activityId);
/*  467 */           return true;
/*      */         }
/*      */         
/*  470 */         CakeManager.globalOnCollectionStart(this.activityId, CakeManager.CookStageEndSession.this.turn, CakeManager.CookStageEndSession.this.collectionTime, activityCfg, DateTimeUtils.getCurrTimeInMillis());
/*  471 */         return true;
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static int getCookMaxTurn(SCakeActivityCfg activityCfg)
/*      */   {
/*  484 */     return activityCfg.cookTurn;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean globalOnCookStart(int activityId, int turn, long cookEndTime, SCakeActivityCfg activityCfg, long curTime)
/*      */   {
/*  494 */     loggerInfo("start cook!|activityId=%d|turn=%d", new Object[] { Integer.valueOf(activityId), Integer.valueOf(turn) });
/*  495 */     GlobalCakeData xGlobalCakeData = getXGlobalCakeDataIfAbsent(activityId);
/*      */     
/*  497 */     xGlobalCakeData.setCurturn(turn);
/*  498 */     xGlobalCakeData.setCurstage(3);
/*  499 */     xGlobalCakeData.setIsgoing(true);
/*  500 */     xGlobalCakeData.setStagestarttime(curTime);
/*      */     
/*  502 */     new CookStageEndSession(cookEndTime, activityId, turn + 1, activityCfg.cookPrepareTime);
/*      */     
/*  504 */     allFactionOnCookStart(activityId, turn);
/*  505 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void globalOnActivityEnd(int activityId)
/*      */   {
/*  517 */     Set<Long> allOvenInstanceIds = FactionOvenCacheManager.getInstance().removeActivityOvens(activityId);
/*  518 */     for (Iterator i$ = allOvenInstanceIds.iterator(); i$.hasNext();) { long ovenInstanceId = ((Long)i$.next()).longValue();
/*      */       
/*  520 */       MapInterface.removeMapEntity(MapEntityType.MET_CAKE_OVEN, ovenInstanceId, null);
/*      */     }
/*      */     
/*  523 */     GlobalCakeInfo xGlobalCakeInfo = Globalcake.get(Long.valueOf(GameServerInfoManager.getLocalId()));
/*  524 */     if (xGlobalCakeInfo == null)
/*      */     {
/*  526 */       return;
/*      */     }
/*  528 */     GlobalCakeData xGlobalCakeData = (GlobalCakeData)xGlobalCakeInfo.getFactioncakedatas().remove(Integer.valueOf(activityId));
/*  529 */     if (xGlobalCakeData == null)
/*      */     {
/*  531 */       return;
/*      */     }
/*      */     
/*  534 */     allFactionOnActivityEnd(activityId);
/*      */     
/*  536 */     POperCookState.removeCookState(activityId);
/*      */   }
/*      */   
/*      */   static void allFactionOnActivityEnd(int activityId)
/*      */   {
/*  541 */     new LogicRunnable()
/*      */     {
/*      */ 
/*      */       public void process()
/*      */         throws Exception
/*      */       {
/*  547 */         for (Iterator i$ = CreateSceneFactionCache.getInstance().getAllJoinedFactionIds().iterator(); i$.hasNext();) { long factionId = ((Long)i$.next()).longValue();
/*      */           
/*  549 */           new CakeManager.FactionOnActivityEnd(this.val$activityId, factionId).call();
/*      */         }
/*      */       }
/*      */     }.execute();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   private static class FactionOnActivityEnd
/*      */     extends LogicProcedure
/*      */   {
/*      */     private final int activityId;
/*      */     
/*      */ 
/*      */     private final long factionId;
/*      */     
/*      */ 
/*      */ 
/*      */     public FactionOnActivityEnd(int activityId, long factionId)
/*      */     {
/*  569 */       this.activityId = activityId;
/*  570 */       this.factionId = factionId;
/*      */     }
/*      */     
/*      */     protected boolean processImp()
/*      */       throws Exception
/*      */     {
/*  576 */       SCakeActivityCfg activityCfg = SCakeActivityCfg.get(this.activityId);
/*  577 */       if (activityCfg == null)
/*      */       {
/*  579 */         CakeManager.loggerError("CakeManager.factionOnAllCookDone@ SCakeActivityCfg is null!| activityId=%d", new Object[] { Integer.valueOf(this.activityId) });
/*  580 */         return false;
/*      */       }
/*      */       
/*  583 */       if (GangInterface.getGang(this.factionId, true) == null)
/*      */       {
/*  585 */         return false;
/*      */       }
/*  587 */       FactionCakeInfo xFactionCakeInfo = Factioncake.get(Long.valueOf(this.factionId));
/*  588 */       if (xFactionCakeInfo == null)
/*      */       {
/*  590 */         return false;
/*      */       }
/*      */       
/*  593 */       xFactionCakeInfo.getFactioncakedatas().remove(Integer.valueOf(this.activityId));
/*      */       
/*  595 */       ControllerInterface.collectWorldController(GangInterface.getGangWorldId(this.factionId), activityCfg.materialController);
/*  596 */       return true;
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   static void globalOnAllCookDone(int activityId)
/*      */   {
/*  604 */     GlobalCakeInfo xGlobalCakeInfo = Globalcake.get(Long.valueOf(GameServerInfoManager.getLocalId()));
/*  605 */     if (xGlobalCakeInfo == null)
/*      */     {
/*  607 */       return;
/*      */     }
/*  609 */     GlobalCakeData xGlobalCakeData = (GlobalCakeData)xGlobalCakeInfo.getFactioncakedatas().get(Integer.valueOf(activityId));
/*  610 */     if (xGlobalCakeData == null)
/*      */     {
/*  612 */       return;
/*      */     }
/*  614 */     xGlobalCakeData.setIsgoing(false);
/*      */     
/*  616 */     allFactionOnAllCookDone(activityId);
/*      */     
/*  618 */     POperCookState.removeCookState(activityId);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void allFactionOnAllCookDone(int activityId)
/*      */   {
/*  629 */     new LogicRunnable()
/*      */     {
/*      */ 
/*      */       public void process()
/*      */         throws Exception
/*      */       {
/*  635 */         for (Iterator i$ = CreateSceneFactionCache.getInstance().getAllJoinedFactionIds().iterator(); i$.hasNext();) { long factionId = ((Long)i$.next()).longValue();
/*      */           
/*  637 */           new CakeManager.FactionOnAllCookDone(this.val$activityId, factionId).call();
/*      */         }
/*      */       }
/*      */     }.execute();
/*      */   }
/*      */   
/*      */   private static class FactionOnAllCookDone
/*      */     extends LogicProcedure
/*      */   {
/*      */     private final int activityId;
/*      */     private final long factionId;
/*      */     
/*      */     public FactionOnAllCookDone(int activityId, long factionId)
/*      */     {
/*  651 */       this.activityId = activityId;
/*  652 */       this.factionId = factionId;
/*      */     }
/*      */     
/*      */     protected boolean processImp()
/*      */       throws Exception
/*      */     {
/*  658 */       CakeManager.factionOnAllCookDone(this.activityId, this.factionId);
/*  659 */       return true;
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   static void factionOnAllCookDone(int activityId, long factionId)
/*      */   {
/*  666 */     SCakeActivityCfg activityCfg = SCakeActivityCfg.get(activityId);
/*  667 */     if (activityCfg == null)
/*      */     {
/*  669 */       loggerError("CakeManager.factionOnAllCookDone@ SCakeActivityCfg is null!| activityId=%d", new Object[] { Integer.valueOf(activityId) });
/*  670 */       return;
/*      */     }
/*      */     
/*  673 */     if (GangInterface.getGang(factionId, true) == null)
/*      */     {
/*  675 */       return;
/*      */     }
/*  677 */     FactionCakeInfo xFactionCakeInfo = Factioncake.get(Long.valueOf(factionId));
/*  678 */     if (xFactionCakeInfo == null)
/*      */     {
/*  680 */       return;
/*      */     }
/*  682 */     FactionCakeData xFactionCakeData = (FactionCakeData)xFactionCakeInfo.getFactioncakedatas().get(Integer.valueOf(activityId));
/*  683 */     if (xFactionCakeData == null)
/*      */     {
/*  685 */       return;
/*      */     }
/*      */     
/*  688 */     ControllerInterface.collectWorldController(GangInterface.getGangWorldId(factionId), activityCfg.materialController);
/*      */     
/*  690 */     if ((xFactionCakeData.getCurturn() == getCookMaxTurn(activityCfg)) && (!xFactionCakeData.getAwarded()))
/*      */     {
/*      */ 
/*  693 */       sendCake(activityId, xFactionCakeData.getCurturn(), xFactionCakeData);
/*      */     }
/*      */     
/*  696 */     xFactionCakeData.setAwarded(true);
/*      */     
/*  698 */     xFactionCakeData.getRolecakes().clear();
/*      */     
/*  700 */     changeOvenState(activityId, factionId, GangInterface.getGangWorldId(factionId), 1);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void allFactionOnCookStart(int activityId, final int turn)
/*      */   {
/*  711 */     new LogicRunnable()
/*      */     {
/*      */ 
/*      */       public void process()
/*      */         throws Exception
/*      */       {
/*  717 */         for (Iterator i$ = CreateSceneFactionCache.getInstance().getAllJoinedFactionIds().iterator(); i$.hasNext();) { long factionId = ((Long)i$.next()).longValue();
/*      */           
/*  719 */           new CakeManager.FactionOnCookStart(factionId, this.val$activityId, turn).call();
/*      */         }
/*      */       }
/*      */     }.execute();
/*      */   }
/*      */   
/*      */   private static class FactionOnCookStart
/*      */     extends LogicProcedure
/*      */   {
/*      */     private final long factionId;
/*      */     private final int activityId;
/*      */     private final int turn;
/*      */     
/*      */     public FactionOnCookStart(long factionId, int activityId, int turn)
/*      */     {
/*  734 */       this.factionId = factionId;
/*  735 */       this.activityId = activityId;
/*  736 */       this.turn = turn;
/*      */     }
/*      */     
/*      */     protected boolean processImp()
/*      */       throws Exception
/*      */     {
/*  742 */       CakeManager.factionOnCookStart(this.factionId, this.activityId, this.turn);
/*  743 */       return true;
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private static void factionOnCookStart(long factionId, int activityId, int turn)
/*      */   {
/*  759 */     SCakeActivityCfg activityCfg = SCakeActivityCfg.get(activityId);
/*  760 */     if (activityCfg == null)
/*      */     {
/*  762 */       loggerError("CakeManager.factionOnCookStart@ SCakeActivityCfg is null!| activityId=%d", new Object[] { Integer.valueOf(activityId) });
/*  763 */       return;
/*      */     }
/*      */     
/*  766 */     if (GangInterface.getGang(factionId, true) == null)
/*      */     {
/*  768 */       return;
/*      */     }
/*  770 */     FactionCakeInfo xFactionCakeInfo = Factioncake.get(Long.valueOf(factionId));
/*  771 */     if (xFactionCakeInfo == null)
/*      */     {
/*  773 */       Factioncake.insert(Long.valueOf(factionId), xFactionCakeInfo = Pod.newFactionCakeInfo());
/*      */     }
/*  775 */     FactionCakeData xFactionCakeData = (FactionCakeData)xFactionCakeInfo.getFactioncakedatas().get(Integer.valueOf(activityId));
/*  776 */     if (xFactionCakeData == null)
/*      */     {
/*  778 */       xFactionCakeInfo.getFactioncakedatas().put(Integer.valueOf(activityId), xFactionCakeData = Pod.newFactionCakeData());
/*      */     }
/*      */     
/*  781 */     xFactionCakeData.setCurturn(turn);
/*      */     
/*  783 */     xFactionCakeData.getRolecakes().clear();
/*      */     
/*  785 */     xFactionCakeData.setAwarded(false);
/*      */     
/*  787 */     changeOvenState(activityId, factionId, GangInterface.getGangWorldId(factionId), 3);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static long getNeedMillsPerTurn(SCakeActivityCfg activityCfg)
/*      */   {
/*  798 */     return (activityCfg.cookPrepareTime + activityCfg.cookTime) * 1000L;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static long getAllCookTime(SCakeActivityCfg activityCfg)
/*      */   {
/*  809 */     return getNeedMillsPerTurn(activityCfg) * getCookMaxTurn(activityCfg);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static long getTotalCookActivityTime(SCakeActivityCfg activityCfg)
/*      */   {
/*  820 */     return getAllCookTime(activityCfg) + activityCfg.prepareTime * 1000L;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static int getCookStage(SCakeActivityCfg activityCfg, long curTime)
/*      */   {
/*  832 */     long startTime = mzm.gsp.activity.main.ActivityInterface.getActivityStartTime(activityCfg.activityId);
/*  833 */     if (curTime >= mzm.gsp.activity.main.ActivityInterface.getActivityEndTime(activityCfg.activityId))
/*      */     {
/*      */ 
/*  836 */       return -1;
/*      */     }
/*  838 */     if (curTime < startTime)
/*      */     {
/*      */ 
/*  841 */       return -1;
/*      */     }
/*  843 */     if (curTime > startTime + getTotalCookActivityTime(activityCfg))
/*      */     {
/*      */ 
/*  846 */       return -1;
/*      */     }
/*  848 */     if (curTime >= startTime + activityCfg.prepareTime * 1000L)
/*      */     {
/*      */ 
/*  851 */       return 1;
/*      */     }
/*      */     
/*  854 */     return 0;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void synCakeStageChange(long roleId, long masterId, String masterName, int activityId, CakeDetailData xCakeDetailData, int reason, Set<Long> factionMembers, long factionId, int itemId, int curTurn)
/*      */   {
/*  872 */     SCakeInfoChangeBro bro = new SCakeInfoChangeBro();
/*  873 */     bro.activityid = activityId;
/*  874 */     bro.roleid = masterId;
/*  875 */     bro.makeroleid = roleId;
/*  876 */     bro.itemid = itemId;
/*  877 */     bro.reason = reason;
/*      */     try
/*      */     {
/*  880 */       bro.mastername.setString(masterName, "UTF-8");
/*      */     }
/*      */     catch (java.io.UnsupportedEncodingException e) {}
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*  887 */     fillPCakeDetailInfo(bro.cakeinfo, xCakeDetailData, curTurn);
/*      */     
/*  889 */     for (Iterator i$ = factionMembers.iterator(); i$.hasNext();) { long factionMember = ((Long)i$.next()).longValue();
/*      */       
/*      */ 
/*  892 */       new NoticeSBCakeChange(factionMember, bro, factionId).execute();
/*      */     }
/*      */   }
/*      */   
/*      */   static void fillPCakeDetailInfo(mzm.gsp.cake.CakeDetailInfo pCakeDetailInfo, CakeDetailData xCakeDetailData, int curTurn)
/*      */   {
/*  898 */     pCakeDetailInfo.cakeid = xCakeDetailData.getCakeid();
/*  899 */     pCakeDetailInfo.state = xCakeDetailData.getState();
/*  900 */     pCakeDetailInfo.curturn = curTurn;
/*  901 */     long cookStartTime = xCakeDetailData.getCookstarttime();
/*  902 */     pCakeDetailInfo.cookstarttime = (cookStartTime != 0L ? cookStartTime / 1000L : 0L);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private static void changeOvenState(int activityId, long factionId, long factionWorldId, int stage)
/*      */   {
/*  915 */     Set<Long> ovenInstanceIds = FactionOvenCacheManager.getInstance().getFactionOvenInstanceIds(activityId, factionId);
/*  916 */     if ((ovenInstanceIds == null) || (ovenInstanceIds.size() == 0))
/*      */     {
/*  918 */       return;
/*      */     }
/*  920 */     for (Iterator i$ = ovenInstanceIds.iterator(); i$.hasNext();) { long ovenInstanceId = ((Long)i$.next()).longValue();
/*      */       
/*      */ 
/*  923 */       Map<Integer, Integer> intExtraInfoEntries = new java.util.HashMap();
/*  924 */       intExtraInfoEntries.put(Integer.valueOf(1800), Integer.valueOf(stage));
/*  925 */       MapInterface.changeMapEntityExtraInfos(MapEntityType.MET_CAKE_OVEN, ovenInstanceId, intExtraInfoEntries, null, null, null, null);
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   private static class NoticeSBCakeChange
/*      */     extends LogicProcedure
/*      */   {
/*      */     private final long roleId;
/*      */     private final long factionId;
/*      */     private final SCakeInfoChangeBro pro;
/*      */     
/*      */     NoticeSBCakeChange(long roleId, SCakeInfoChangeBro pro, long factionId)
/*      */     {
/*  939 */       this.roleId = roleId;
/*  940 */       this.factionId = factionId;
/*  941 */       this.pro = pro;
/*      */     }
/*      */     
/*      */     protected boolean processImp()
/*      */       throws Exception
/*      */     {
/*  947 */       if (GangInterface.getGangId(this.roleId) != this.factionId)
/*      */       {
/*      */ 
/*  950 */         return false;
/*      */       }
/*  952 */       OnlineManager.getInstance().send(this.roleId, this.pro);
/*  953 */       return true;
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void triggerFactionOvens(int activityid, long factionId)
/*      */   {
/*  969 */     long factionWorldId = GangInterface.getGangWorldId(factionId);
/*  970 */     if (factionWorldId == -1L)
/*      */     {
/*  972 */       return;
/*      */     }
/*      */     
/*  975 */     STOvenPerformanceCfg activityOvenCfg = STOvenPerformanceCfg.get(activityid);
/*  976 */     if (activityOvenCfg == null)
/*      */     {
/*  978 */       return;
/*      */     }
/*      */     
/*  981 */     Set<Long> ovenInstanceIds = new HashSet();
/*  982 */     for (Iterator i$ = activityOvenCfg.ovenCfgIds.iterator(); i$.hasNext();) { int ovenCfgId = ((Integer)i$.next()).intValue();
/*      */       
/*  984 */       long ovenInstanceId = createOven(activityid, factionId, factionWorldId, ovenCfgId);
/*  985 */       if (ovenInstanceId != -1L)
/*      */       {
/*      */ 
/*      */ 
/*  989 */         ovenInstanceIds.add(Long.valueOf(ovenInstanceId));
/*      */       }
/*      */     }
/*  992 */     FactionOvenCacheManager.getInstance().putFactionOvenInstanceIds(activityid, factionId, ovenInstanceIds);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private static long createOven(int activityid, final long factionId, long factionWorldId, int ovenCfgId)
/*      */   {
/* 1006 */     SOvenPerformanceCfg ovenCfg = SOvenPerformanceCfg.get(ovenCfgId);
/* 1007 */     if (ovenCfg == null)
/*      */     {
/* 1009 */       return -1L;
/*      */     }
/* 1011 */     long ovenInstanceId = GlobalOvenData.getNewOvenInstanceId();
/* 1012 */     int factionMapId = GangInterface.getGangMapCfgId();
/*      */     
/* 1014 */     Map<Integer, Integer> intExtraInfoEntries = new java.util.HashMap();
/* 1015 */     intExtraInfoEntries.put(Integer.valueOf(1800), Integer.valueOf(1));
/* 1016 */     MapInterface.addMapEntity(MapEntityType.MET_CAKE_OVEN, ovenInstanceId, factionWorldId, factionMapId, ovenCfg.positionX, ovenCfg.positionY, ovenCfgId, intExtraInfoEntries, null, null, new mzm.gsp.map.main.MapCallback()
/*      */     {
/*      */ 
/*      */ 
/*      */       public boolean onResult(Boolean result)
/*      */       {
/*      */ 
/* 1023 */         CakeManager.loggerInfo("--set oven result!|activityId=%d|factionId=%d|instanceId=%d|result=%s", new Object[] { Integer.valueOf(this.val$activityid), Long.valueOf(factionId), Long.valueOf(this.val$ovenInstanceId), result.toString() });
/*      */         
/* 1025 */         return true;
/*      */       }
/*      */       
/*      */ 
/*      */       public boolean isCallInProcedure()
/*      */       {
/* 1031 */         return false;
/*      */       }
/* 1033 */     });
/* 1034 */     return ovenInstanceId;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void sendCakeNotice(Collection<Long> roleIds, boolean afterSuc, int result, String... args)
/*      */   {
/* 1047 */     if ((roleIds == null) || (roleIds.size() == 0))
/*      */     {
/* 1049 */       return;
/*      */     }
/* 1051 */     SCakeNormalNotice pro = getCakeNormalNotice(result, args);
/* 1052 */     if (afterSuc)
/*      */     {
/* 1054 */       OnlineManager.getInstance().sendMulti(pro, roleIds);
/*      */     }
/*      */     else
/*      */     {
/* 1058 */       OnlineManager.getInstance().sendMultiAtOnce(pro, roleIds);
/*      */     }
/*      */   }
/*      */   
/*      */   static SCakeNormalNotice getCakeNormalNotice(int result, String... args)
/*      */   {
/* 1064 */     SCakeNormalNotice pro = new SCakeNormalNotice();
/* 1065 */     pro.result = result;
/* 1066 */     for (String arg : args)
/*      */     {
/* 1068 */       pro.args.add(arg);
/*      */     }
/* 1070 */     return pro;
/*      */   }
/*      */   
/*      */   static void tlogAddCake(String userId, long roleId, int activityId, long factionId, int cakeId)
/*      */   {
/* 1075 */     String vGameIP = GameServerInfoManager.getHostIP();
/* 1076 */     int rolelevel = mzm.gsp.role.main.RoleInterface.getLevel(roleId);
/*      */     
/* 1078 */     Object[] colums = { vGameIP, userId, Long.valueOf(roleId), Integer.valueOf(rolelevel), Integer.valueOf(activityId), Long.valueOf(factionId), Integer.valueOf(cakeId) };
/*      */     
/* 1080 */     TLogManager.getInstance().addLog(roleId, "AddCake", colums);
/*      */   }
/*      */   
/*      */ 
/*      */   static void tlogBakeCake(String userId, long roleId, int level, int activityId, long masterId, long factionId, int oldCakeId, int newCakeId)
/*      */   {
/* 1086 */     String vGameIP = GameServerInfoManager.getHostIP();
/*      */     
/* 1088 */     Object[] colums = { vGameIP, userId, Long.valueOf(roleId), Integer.valueOf(level), Integer.valueOf(activityId), Long.valueOf(masterId), Long.valueOf(factionId), Integer.valueOf(oldCakeId), Integer.valueOf(newCakeId) };
/*      */     
/* 1090 */     TLogManager.getInstance().addLog(userId, roleId, "BakeCake", colums);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   static void loggerError(String format, Object... args)
/*      */   {
/* 1098 */     GameServer.logger().error(loggerTag + String.format(format, args));
/*      */   }
/*      */   
/*      */   static void loggerInfo(String format, Object... args)
/*      */   {
/* 1103 */     GameServer.logger().info(loggerTag + String.format(format, args));
/*      */   }
/*      */   
/*      */   static void loggerDebug(String format, Object... args)
/*      */   {
/* 1108 */     if (!GameServer.logger().isDebugEnabled())
/*      */     {
/* 1110 */       return;
/*      */     }
/* 1112 */     GameServer.logger().debug(loggerTag + String.format(format, args));
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\cake\main\CakeManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */