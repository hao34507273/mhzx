/*     */ package mzm.gsp.cake.main;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.activity.main.ActivityJoinResult;
/*     */ import mzm.gsp.activity4.confbean.SCakeActivityCfg;
/*     */ import mzm.gsp.gang.main.GangInterface;
/*     */ import mzm.gsp.map.main.MapItemGatherContext;
/*     */ import mzm.gsp.map.main.MapItemGatherHandler;
/*     */ import xbean.CakeData;
/*     */ import xbean.GlobalCakeData;
/*     */ import xdb.Lockey;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Basic;
/*     */ import xtable.Gang;
/*     */ import xtable.Globalcake;
/*     */ import xtable.Team;
/*     */ import xtable.User;
/*     */ 
/*     */ public class CakeGatherItemHandler implements MapItemGatherHandler
/*     */ {
/*     */   private final int activityId;
/*     */   
/*     */   public CakeGatherItemHandler(int activityId)
/*     */   {
/*  26 */     this.activityId = activityId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public Set<Lockey> collectLocks(String userid, long roleid, long worldid, int mapCfgid, int mapItemCfgid, MapItemGatherContext context)
/*     */   {
/*  34 */     long factionId = GangInterface.getGangId(roleid);
/*     */     
/*  36 */     Long teamId = mzm.gsp.team.main.TeamInterface.getTeamidByRoleid(roleid, false);
/*     */     
/*  38 */     Set<Lockey> lockeys = new java.util.HashSet();
/*  39 */     lockeys.add(Lockeys.get(User.getTable(), mzm.gsp.role.main.RoleInterface.getUserId(roleid)));
/*  40 */     lockeys.add(Lockeys.get(Basic.getTable(), Long.valueOf(roleid)));
/*  41 */     if ((teamId != null) && (teamId.longValue() > 0L))
/*     */     {
/*  43 */       lockeys.add(Lockeys.get(Team.getTable(), teamId));
/*     */     }
/*  45 */     if (factionId > 0L)
/*     */     {
/*  47 */       lockeys.add(Lockeys.get(Gang.getTable(), Long.valueOf(factionId)));
/*     */     }
/*  49 */     lockeys.add(Lockeys.get(Globalcake.getTable(), Long.valueOf(mzm.gsp.GameServerInfoManager.getLocalId())));
/*  50 */     return lockeys;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean gatherCheck(String userid, long roleid, long worldid, int mapCfgid, int mapItemCfgid, MapItemGatherContext context)
/*     */   {
/*  57 */     SCakeActivityCfg activityCfg = SCakeActivityCfg.get(this.activityId);
/*  58 */     if (activityCfg == null)
/*     */     {
/*  60 */       return false;
/*     */     }
/*  62 */     CakeData xCakeData = CakeManager.getXCakeDataIfAbsent(roleid, this.activityId);
/*  63 */     GlobalCakeData xGlobalCakeData = CakeManager.getXGlobalCakeData(this.activityId);
/*  64 */     if (!xGlobalCakeData.getIsgoing())
/*     */     {
/*     */ 
/*  67 */       return false;
/*     */     }
/*  69 */     long factionId = GangInterface.getGangId(roleid);
/*  70 */     if (factionId <= 0L)
/*     */     {
/*     */ 
/*  73 */       CakeManager.sendCakeNotice(Arrays.asList(new Long[] { Long.valueOf(roleid) }), false, 3, new String[0]);
/*  74 */       return false;
/*     */     }
/*  76 */     if (GangInterface.getGangWorldId(factionId) != worldid)
/*     */     {
/*     */ 
/*  79 */       CakeManager.sendCakeNotice(Arrays.asList(new Long[] { Long.valueOf(roleid) }), false, 3, new String[0]);
/*  80 */       return false;
/*     */     }
/*  82 */     ActivityJoinResult res = mzm.gsp.activity.main.ActivityInterface.canJoinAndCheckInitActivityData(userid, roleid, this.activityId);
/*  83 */     if (!res.isCanJoin())
/*     */     {
/*  85 */       CakeManager.loggerError("CakeGatherItemHandler.gatherCheck@ forbid join activity!|roleId=%d|activityId=%d|factionId=%d|res=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(this.activityId), Long.valueOf(factionId), Integer.valueOf(res.getReasonValue()) });
/*     */       
/*     */ 
/*  88 */       return false;
/*     */     }
/*  90 */     if (xGlobalCakeData.getCurturn() != xCakeData.getCurturn())
/*     */     {
/*     */ 
/*  93 */       xCakeData.setCurturn(xGlobalCakeData.getCurturn());
/*  94 */       xCakeData.setCollectnum(0);
/*  95 */       xCakeData.setCookothercount(0);
/*  96 */       xCakeData.setCookselfcount(0);
/*  97 */       xCakeData.setEffectfactionid(0L);
/*     */     }
/*  99 */     if (xCakeData.getCollectnum() >= activityCfg.eachTurnCanGetMaxNum)
/*     */     {
/*     */ 
/*     */ 
/* 103 */       CakeManager.sendCakeNotice(Arrays.asList(new Long[] { Long.valueOf(roleid) }), false, 45, new String[0]);
/* 104 */       CakeManager.loggerError("CakeGatherItemHandler.gatherCheck@ collect num to max!|roleId=%d|activityId=%d|factionId=%d|ownNum=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(this.activityId), Long.valueOf(factionId), Integer.valueOf(xCakeData.getCollectnum()) });
/*     */       
/*     */ 
/* 107 */       return false;
/*     */     }
/*     */     
/* 110 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean onGather(String userid, long roleid, long worldid, int mapCfgid, int mapItemCfgid, int itemCfgid, int itemNum, MapItemGatherContext context)
/*     */   {
/* 117 */     SCakeActivityCfg activityCfg = SCakeActivityCfg.get(this.activityId);
/* 118 */     if (activityCfg == null)
/*     */     {
/* 120 */       return false;
/*     */     }
/* 122 */     CakeData xCakeData = CakeManager.getXCakeDataIfAbsent(roleid, this.activityId);
/* 123 */     xCakeData.setCollectnum(xCakeData.getCollectnum() + 1);
/* 124 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\cake\main\CakeGatherItemHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */