/*     */ package mzm.gsp.cake.main;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.Collection;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Random;
/*     */ import mzm.gsp.activity.main.ActivityJoinResult;
/*     */ import mzm.gsp.activity4.confbean.SCakeActivityCfg;
/*     */ import mzm.gsp.activity4.confbean.SCakeContentCfg;
/*     */ import mzm.gsp.activity4.confbean.STActivityCakeInfos;
/*     */ import mzm.gsp.gang.main.GangInterface;
/*     */ import mzm.gsp.item.main.BasicItem;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.map.main.MapInterface;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.timer.main.Session;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import xbean.CakeData;
/*     */ import xbean.CakeDetailData;
/*     */ import xbean.CakeHistoryData;
/*     */ import xbean.FactionCakeData;
/*     */ import xbean.GlobalCakeData;
/*     */ import xdb.Xdb;
/*     */ 
/*     */ public class PCMakeCakeReq extends LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final int activityId;
/*     */   private final long masterId;
/*     */   private final long uuid;
/*     */   private final int num;
/*     */   private final int clientTurn;
/*  38 */   private int historyMaxNum = 0;
/*     */   
/*     */   public PCMakeCakeReq(long roleId, int activityId, long masterId, long uuid, int num, int clientTurn)
/*     */   {
/*  42 */     this.roleId = roleId;
/*  43 */     this.activityId = activityId;
/*  44 */     this.masterId = masterId;
/*  45 */     this.uuid = uuid;
/*  46 */     this.num = num;
/*  47 */     this.clientTurn = clientTurn;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  53 */     SCakeActivityCfg activityCfg = SCakeActivityCfg.get(this.activityId);
/*  54 */     if (activityCfg == null)
/*     */     {
/*  56 */       return false;
/*     */     }
/*  58 */     if (!OpenInterface.getOpenStatus(activityCfg.switchId))
/*     */     {
/*     */ 
/*  61 */       return false;
/*     */     }
/*  63 */     this.historyMaxNum = activityCfg.historyNum;
/*  64 */     if (this.roleId != this.masterId) if (!GangInterface.isInOneGang(Arrays.asList(new Long[] { Long.valueOf(this.roleId), Long.valueOf(this.masterId) })))
/*     */       {
/*     */ 
/*  67 */         CakeManager.loggerError("PCMakeCakeReq.processImp@ not in same faction!|roleId=%d|masterId=%d|activityId=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.masterId), Integer.valueOf(this.activityId) });
/*     */         
/*  69 */         CakeManager.sendCakeNotice(Arrays.asList(new Long[] { Long.valueOf(this.roleId) }), false, 2, new String[0]);
/*  70 */         return false;
/*     */       }
/*  72 */     String masterName = RoleInterface.getName(this.masterId);
/*     */     
/*  74 */     String userId = RoleInterface.getUserId(this.roleId);
/*  75 */     lock(xtable.User.getTable(), Arrays.asList(new String[] { userId }));
/*     */     
/*  77 */     CakeData xCakeData = CakeManager.getXCakeDataIfAbsent(this.roleId, this.activityId);
/*     */     
/*  79 */     long factionId = GangInterface.getGangId(this.roleId);
/*  80 */     if (factionId <= 0L)
/*     */     {
/*     */ 
/*  83 */       CakeManager.loggerError("PCMakeCakeReq.processImp@ not in faction!|roleId=%d|activityId=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.activityId) });
/*  84 */       return false;
/*     */     }
/*     */     
/*  87 */     FactionCakeData xFactionCakeData = CakeManager.getXFactionCakeData(factionId, this.activityId);
/*  88 */     if (xFactionCakeData == null)
/*     */     {
/*  90 */       CakeManager.loggerError("PCMakeCakeReq.processImp@ xFactionCakeData is null!|roleId=%d|activityId=%d|factionId=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.activityId), Long.valueOf(factionId) });
/*     */       
/*  92 */       return false;
/*     */     }
/*  94 */     if (xFactionCakeData.getCurturn() != this.clientTurn)
/*     */     {
/*     */ 
/*  97 */       CakeManager.sendCakeNotice(Arrays.asList(new Long[] { Long.valueOf(this.roleId) }), false, 1, new String[0]);
/*  98 */       return false;
/*     */     }
/* 100 */     CakeDetailData xCakeDetailData = (CakeDetailData)xFactionCakeData.getRolecakes().get(Long.valueOf(this.masterId));
/* 101 */     if (xCakeDetailData == null)
/*     */     {
/*     */ 
/* 104 */       CakeManager.loggerError("PCMakeCakeReq.processImp@ xCakeDetailData is null!|roleId=%d|masterId=%d|activityId=%d|factionId=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.masterId), Integer.valueOf(this.activityId), Long.valueOf(factionId) });
/*     */       
/*     */ 
/* 107 */       return false;
/*     */     }
/* 109 */     ActivityJoinResult res = mzm.gsp.activity.main.ActivityInterface.canJoinAndCheckInitActivityData(userId, this.roleId, this.activityId);
/* 110 */     if (!res.isCanJoin())
/*     */     {
/* 112 */       CakeManager.loggerError("PCMakeCakeReq.processImp@ forbid join activity!|roleId=%d|activityId=%d|factionId=%d|res=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.activityId), Long.valueOf(factionId), Integer.valueOf(res.getReasonValue()) });
/*     */       
/*     */ 
/* 115 */       return false;
/*     */     }
/* 117 */     if (xCakeDetailData.getState() == 1)
/*     */     {
/*     */ 
/* 120 */       CakeManager.loggerError("PCMakeCakeReq.processImp@ is cooking!|roleId=%d|masterId=%d|activityId=%d|factionId=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.masterId), Integer.valueOf(this.activityId), Long.valueOf(factionId) });
/*     */       
/* 122 */       return false;
/*     */     }
/* 124 */     if (GangInterface.getGangId(this.roleId) != factionId)
/*     */     {
/*     */ 
/* 127 */       CakeManager.loggerError("PCMakeCakeReq.processImp@ faction changed!|roleId=%d|masterId=%d|activityId=%d|factionId=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.masterId), Integer.valueOf(this.activityId), Long.valueOf(factionId) });
/*     */       
/*     */ 
/* 130 */       return false;
/*     */     }
/* 132 */     GlobalCakeData xGlobalCakeData = CakeManager.getXGlobalCakeData(this.activityId);
/* 133 */     if (!xGlobalCakeData.getIsgoing())
/*     */     {
/*     */ 
/* 136 */       CakeManager.loggerError("PCMakeCakeReq.processImp@ cook over!|roleId=%d|masterId=%d|activityId=%d|factionId=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.masterId), Integer.valueOf(this.activityId), Long.valueOf(factionId) });
/*     */       
/* 138 */       return false;
/*     */     }
/* 140 */     if (GangInterface.getGangWorldId(factionId) != MapInterface.getRoleWorldInstanceId(this.roleId))
/*     */     {
/*     */ 
/* 143 */       CakeManager.loggerError("PCMakeCakeReq.processImp@ not in faction world!|roleId=%d|masterId=%d|activityId=%d|factionId=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.masterId), Integer.valueOf(this.activityId), Long.valueOf(factionId) });
/*     */       
/*     */ 
/* 146 */       return false;
/*     */     }
/* 148 */     if (xCakeData.getCurturn() != xGlobalCakeData.getCurturn())
/*     */     {
/*     */ 
/* 151 */       CakeManager.loggerError("PCMakeCakeReq.processImp@ not in global turn!|roleId=%d|masterId=%d|activityId=%d|factionId=%d|selfTurn=%d|globalTurn=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.masterId), Integer.valueOf(this.activityId), Long.valueOf(factionId), Integer.valueOf(xCakeData.getCurturn()), Integer.valueOf(xGlobalCakeData.getCurturn()) });
/*     */       
/*     */ 
/* 154 */       return false;
/*     */     }
/* 156 */     if (xGlobalCakeData.getCurstage() != 3)
/*     */     {
/*     */ 
/* 159 */       CakeManager.loggerError("PCMakeCakeReq.processImp@ not in cook stage!|roleId=%d|masterId=%d|activityId=%d|factionId=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.masterId), Integer.valueOf(this.activityId), Long.valueOf(factionId) });
/*     */       
/*     */ 
/* 162 */       return false;
/*     */     }
/* 164 */     if (xCakeData.getEffectfactionid() != factionId)
/*     */     {
/*     */ 
/* 167 */       CakeManager.loggerError("PCMakeCakeReq.processImp@ not in effect faction!|roleId=%d|masterId=%d|activityId=%d|factionId=%d|effectFactionId=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.masterId), Integer.valueOf(this.activityId), Long.valueOf(factionId), Long.valueOf(xCakeData.getEffectfactionid()) });
/*     */       
/*     */ 
/* 170 */       return false;
/*     */     }
/* 172 */     if (SCakeContentCfg.get(xCakeDetailData.getCakeid()).range >= activityCfg.cakeRangeMax)
/*     */     {
/*     */ 
/* 175 */       CakeManager.loggerError("PCMakeCakeReq.processImp@ range to max!|roleId=%d|masterId=%d|activityId=%d|factionId=%d|range=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.masterId), Integer.valueOf(this.activityId), Long.valueOf(factionId), Integer.valueOf(SCakeContentCfg.get(xCakeDetailData.getCakeid()).range) });
/*     */       
/*     */ 
/* 178 */       return false;
/*     */     }
/* 180 */     if (this.roleId == this.masterId)
/*     */     {
/* 182 */       if (xCakeData.getCookselfcount() >= activityCfg.selfCookCountMax)
/*     */       {
/*     */ 
/* 185 */         CakeManager.loggerError("PCMakeCakeReq.processImp@ cook self max!|roleId=%d|masterId=%d|activityId=%d|factionId=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.masterId), Integer.valueOf(this.activityId), Long.valueOf(factionId) });
/*     */         
/*     */ 
/* 188 */         return false;
/*     */       }
/*     */       
/*     */ 
/*     */     }
/* 193 */     else if (xCakeData.getCookothercount() >= activityCfg.helpCookCountMax)
/*     */     {
/*     */ 
/* 196 */       CakeManager.loggerError("PCMakeCakeReq.processImp@ cook other max!|roleId=%d|masterId=%d|activityId=%d|factionId=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.masterId), Integer.valueOf(this.activityId), Long.valueOf(factionId) });
/*     */       
/*     */ 
/* 199 */       return false;
/*     */     }
/*     */     
/* 202 */     BasicItem basicItem = ItemInterface.getItemByUuid(this.roleId, this.uuid);
/* 203 */     if ((basicItem == null) || (basicItem.getNumber() <= 0))
/*     */     {
/* 205 */       CakeManager.loggerError("PCMakeCakeReq.processImp@ item is null!|roleId=%d|masterId=%d|activityId=%d|factionId=%d|uuid=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.masterId), Integer.valueOf(this.activityId), Long.valueOf(factionId), Long.valueOf(this.uuid) });
/*     */       
/*     */ 
/* 208 */       return false;
/*     */     }
/* 210 */     int newCakeId = getNewCakeId(activityCfg, basicItem);
/* 211 */     if (newCakeId <= 0)
/*     */     {
/*     */ 
/* 214 */       CakeManager.loggerError("PCMakeCakeReq.processImp@ random cake error!|roleId=%d|masterId=%d|activityId=%d|factionId=%d|itemId=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.masterId), Integer.valueOf(this.activityId), Long.valueOf(factionId), Integer.valueOf(basicItem.getCfgId()) });
/*     */       
/*     */ 
/* 217 */       return false;
/*     */     }
/*     */     
/* 220 */     if (!ItemInterface.removeItemById(this.roleId, basicItem.getCfgId(), 1, new mzm.gsp.tlog.TLogArg(mzm.gsp.tlog.LogReason.COST_MAKE_CAKE, this.activityId)))
/*     */     {
/*     */ 
/* 223 */       CakeManager.loggerError("PCMakeCakeReq.processImp@ remove item error!|roleId=%d|masterId=%d|activityId=%d|factionId=%d|itemId=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.masterId), Integer.valueOf(this.activityId), Long.valueOf(factionId), Integer.valueOf(basicItem.getCfgId()) });
/*     */       
/*     */ 
/* 226 */       return false;
/*     */     }
/*     */     
/* 229 */     if (this.roleId == this.masterId)
/*     */     {
/* 231 */       xCakeData.setCookselfcount(xCakeData.getCookselfcount() + 1);
/*     */     }
/*     */     else
/*     */     {
/* 235 */       xCakeData.setCookothercount(xCakeData.getCookothercount() + 1);
/*     */     }
/* 237 */     long curTime = DateTimeUtils.getCurrTimeInMillis();
/*     */     
/* 239 */     xCakeDetailData.setNextcakeid(newCakeId);
/* 240 */     xCakeDetailData.setState(1);
/* 241 */     xCakeDetailData.setCookstarttime(curTime);
/*     */     
/* 243 */     new CookEndSession(activityCfg.makeCakeTime, factionId, this.roleId, this.masterId, basicItem.getCfgId());
/*     */     
/*     */ 
/* 246 */     CakeManager.synCakeStageChange(this.roleId, this.masterId, masterName, this.activityId, xCakeDetailData, 2, xFactionCakeData.getRolecakes().keySet(), factionId, basicItem.getCfgId(), xGlobalCakeData.getCurturn());
/*     */     
/*     */ 
/*     */ 
/* 250 */     return true;
/*     */   }
/*     */   
/*     */   private final class CookEndSession extends Session
/*     */   {
/*     */     private final long roleId;
/*     */     private final long masterId;
/*     */     private final int itemId;
/*     */     
/*     */     public CookEndSession(long interval, long factionId, long roleId, long masterId, int itemId)
/*     */     {
/* 261 */       super(factionId);
/* 262 */       this.roleId = roleId;
/* 263 */       this.masterId = masterId;
/* 264 */       this.itemId = itemId;
/*     */     }
/*     */     
/*     */ 
/*     */     protected void onTimeOut()
/*     */     {
/* 270 */       new OnCookEnd(super.getOwerId(), this.roleId, this.masterId, this.itemId).execute();
/*     */     }
/*     */     
/*     */     private final class OnCookEnd extends LogicProcedure
/*     */     {
/*     */       private final long factionId;
/*     */       private final long roleId;
/*     */       private final long masterId;
/*     */       private final int itemId;
/*     */       
/*     */       public OnCookEnd(long factionId, long roleId, long masterId, int itemId)
/*     */       {
/* 282 */         this.factionId = factionId;
/* 283 */         this.roleId = roleId;
/* 284 */         this.masterId = masterId;
/* 285 */         this.itemId = itemId;
/*     */       }
/*     */       
/*     */       protected boolean processImp()
/*     */         throws Exception
/*     */       {
/* 291 */         String userId = RoleInterface.getUserId(this.roleId);
/* 292 */         String makerName = RoleInterface.getName(this.roleId);
/* 293 */         String masterName = RoleInterface.getName(this.masterId);
/* 294 */         int level = RoleInterface.getLevel(this.roleId);
/*     */         
/* 296 */         FactionCakeData xFactionCakeData = CakeManager.getXFactionCakeData(this.factionId, PCMakeCakeReq.this.activityId);
/* 297 */         if (xFactionCakeData == null)
/*     */         {
/* 299 */           return false;
/*     */         }
/* 301 */         CakeDetailData xCakeDetailData = (CakeDetailData)xFactionCakeData.getRolecakes().get(Long.valueOf(this.masterId));
/* 302 */         if (xCakeDetailData == null)
/*     */         {
/*     */ 
/* 305 */           return false;
/*     */         }
/* 307 */         int orgCakeId = xCakeDetailData.getCakeid();
/* 308 */         int nextCakeId = xCakeDetailData.getNextcakeid();
/* 309 */         if (nextCakeId > 0)
/*     */         {
/* 311 */           xCakeDetailData.setCakeid(nextCakeId);
/*     */         }
/*     */         
/*     */ 
/*     */ 
/*     */ 
/* 317 */         xCakeDetailData.setNextcakeid(0);
/* 318 */         xCakeDetailData.setState(2);
/* 319 */         xCakeDetailData.setCookstarttime(0L);
/*     */         
/* 321 */         addCookHistory(makerName, masterName, xCakeDetailData, orgCakeId, nextCakeId);
/*     */         
/* 323 */         factionNotice(makerName, masterName, orgCakeId, xCakeDetailData.getCakeid());
/*     */         
/* 325 */         CakeManager.synCakeStageChange(this.roleId, this.masterId, masterName, PCMakeCakeReq.this.activityId, xCakeDetailData, 2, xFactionCakeData.getRolecakes().keySet(), this.factionId, this.itemId, xFactionCakeData.getCurturn());
/*     */         
/*     */ 
/*     */ 
/* 329 */         CakeManager.tlogBakeCake(userId, this.roleId, level, PCMakeCakeReq.this.activityId, this.masterId, this.factionId, orgCakeId, nextCakeId);
/* 330 */         return true;
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       private void factionNotice(String makerName, String masterName, int orgCakeId, int newCakeId)
/*     */       {
/* 343 */         SCakeContentCfg orgCakeCfg = SCakeContentCfg.get(orgCakeId);
/* 344 */         SCakeContentCfg newCakeCfg = SCakeContentCfg.get(newCakeId);
/* 345 */         if ((orgCakeCfg == null) || (newCakeCfg == null))
/*     */         {
/* 347 */           return;
/*     */         }
/* 349 */         int newRange = newCakeCfg.range;
/* 350 */         int res = -1;
/* 351 */         if (newRange == 1)
/*     */         {
/* 353 */           res = 61;
/*     */         }
/* 355 */         if (newRange == SCakeActivityCfg.get(PCMakeCakeReq.this.activityId).cakeRangeMax)
/*     */         {
/* 357 */           res = 60;
/*     */         }
/* 359 */         if (res > 0)
/*     */         {
/* 361 */           GangInterface.brocastInGang(CakeManager.getCakeNormalNotice(res, new String[] { makerName, masterName, String.valueOf(orgCakeCfg.range), String.valueOf(newRange) }), this.factionId);
/*     */         }
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*     */       private void addCookHistory(String makerName, String masterName, CakeDetailData xCakeDetailData, int orgCakeId, int nextCakeId)
/*     */       {
/* 369 */         CakeHistoryData xCakeHistoryData = xbean.Pod.newCakeHistoryData();
/* 370 */         xCakeHistoryData.setTimeline(DateTimeUtils.getCurrTimeInMillis());
/* 371 */         xCakeHistoryData.setHistorytype(1);
/* 372 */         xCakeHistoryData.setMastername(masterName);
/* 373 */         xCakeHistoryData.setOperrolename(makerName);
/* 374 */         xCakeHistoryData.setItemid(this.itemId);
/* 375 */         xCakeHistoryData.setBeforecakeid(orgCakeId);
/* 376 */         xCakeHistoryData.setAftercakeid(nextCakeId);
/*     */         
/* 378 */         if (xCakeDetailData.getHistory().size() >= PCMakeCakeReq.this.historyMaxNum)
/*     */         {
/* 380 */           xCakeDetailData.getHistory().remove(0);
/*     */         }
/* 382 */         xCakeDetailData.getHistory().add(xCakeHistoryData);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private int getNewCakeId(SCakeActivityCfg activityCfg, BasicItem basicItem)
/*     */   {
/* 391 */     if (basicItem.getCfgId() == activityCfg.collectMaterialItemId)
/*     */     {
/*     */ 
/* 394 */       return randomNewCakeId(true);
/*     */     }
/* 396 */     if (basicItem.getCfgId() == activityCfg.giftMaterialItemId)
/*     */     {
/*     */ 
/* 399 */       return randomNewCakeId(false);
/*     */     }
/*     */     
/* 402 */     return -1;
/*     */   }
/*     */   
/*     */   int randomNewCakeId(boolean isSuper)
/*     */   {
/* 407 */     if (isSuper)
/*     */     {
/* 409 */       return randomSuperCakeId(STActivityCakeInfos.get(this.activityId));
/*     */     }
/* 411 */     return randomNormalCakeId(STActivityCakeInfos.get(this.activityId));
/*     */   }
/*     */   
/*     */   int randomSuperCakeId(STActivityCakeInfos cfg)
/*     */   {
/* 416 */     if (cfg == null)
/*     */     {
/* 418 */       return -1;
/*     */     }
/* 420 */     int ran = Xdb.random().nextInt(cfg.totalWeight_super);
/* 421 */     int tmpWeight = 0;
/* 422 */     for (Iterator i$ = cfg.cakeInfos.values().iterator(); i$.hasNext();) { int cakeId = ((Integer)i$.next()).intValue();
/*     */       
/* 424 */       tmpWeight += SCakeContentCfg.get(cakeId).superHitWeight;
/* 425 */       if (tmpWeight > ran)
/*     */       {
/*     */ 
/*     */ 
/* 429 */         return cakeId; }
/*     */     }
/* 431 */     return -1;
/*     */   }
/*     */   
/*     */   int randomNormalCakeId(STActivityCakeInfos cfg)
/*     */   {
/* 436 */     if (cfg == null)
/*     */     {
/* 438 */       return -1;
/*     */     }
/* 440 */     int ran = Xdb.random().nextInt(cfg.totalWeight_normal);
/* 441 */     int tmpWeight = 0;
/* 442 */     for (Iterator i$ = cfg.cakeInfos.values().iterator(); i$.hasNext();) { int cakeId = ((Integer)i$.next()).intValue();
/*     */       
/* 444 */       tmpWeight += SCakeContentCfg.get(cakeId).normalHitWeight;
/* 445 */       if (tmpWeight > ran)
/*     */       {
/*     */ 
/*     */ 
/* 449 */         return cakeId; }
/*     */     }
/* 451 */     return -1;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\cake\main\PCMakeCakeReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */