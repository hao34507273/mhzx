/*    */ package mzm.gsp.menpaistar.main;
/*    */ 
/*    */ import java.util.List;
/*    */ import java.util.concurrent.TimeUnit;
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.common.confbean.STimeDurationCommonCfg;
/*    */ import mzm.gsp.menpaistar.confbean.SMenPaiStarConst;
/*    */ import mzm.gsp.menpaistar.confbean.SMenPaiStarNpcCfg;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class MenPaiStarConfigManager
/*    */ {
/*    */   private static final long CAMPAIGN_LAST_TIME;
/*    */   private static final long VOTE_LAST_TIME;
/*    */   
/*    */   static
/*    */   {
/* 20 */     STimeDurationCommonCfg campaignDurationCfg = STimeDurationCommonCfg.get(SMenPaiStarConst.getInstance().CAMPAIGN_BATTLE_END_TIME);
/* 21 */     CAMPAIGN_LAST_TIME = TimeUnit.DAYS.toMillis(campaignDurationCfg.lastDay) + TimeUnit.HOURS.toMillis(campaignDurationCfg.lastHour) + TimeUnit.MINUTES.toMillis(campaignDurationCfg.lastMinute);
/*    */     
/*    */ 
/*    */ 
/* 25 */     STimeDurationCommonCfg voteDurationCfg = STimeDurationCommonCfg.get(SMenPaiStarConst.getInstance().VOTE_BATTLE_END_TIME);
/* 26 */     VOTE_LAST_TIME = TimeUnit.DAYS.toMillis(voteDurationCfg.lastDay) + TimeUnit.HOURS.toMillis(voteDurationCfg.lastHour) + TimeUnit.MINUTES.toMillis(voteDurationCfg.lastMinute);
/*    */   }
/*    */   
/* 29 */   private static final List<Integer> ocpids = RoleInterface.getAllOccupationIds();
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   static long campaignFightEndTime()
/*    */   {
/* 39 */     int activityCfgid = SMenPaiStarConst.getInstance().ACTIVITY_CFG_ID;
/* 40 */     return ActivityInterface.getActivityStartTime(activityCfgid) + CAMPAIGN_LAST_TIME;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   static long voteEndTime()
/*    */   {
/* 50 */     int activityCfgid = SMenPaiStarConst.getInstance().ACTIVITY_CFG_ID;
/* 51 */     return ActivityInterface.getActivityStartTime(activityCfgid) + VOTE_LAST_TIME;
/*    */   }
/*    */   
/*    */   static List<Integer> getOcpids()
/*    */   {
/* 56 */     return ocpids;
/*    */   }
/*    */   
/*    */   static int getNpc(int ocpid)
/*    */   {
/* 61 */     SMenPaiStarNpcCfg npcCfg = SMenPaiStarNpcCfg.get(ocpid);
/* 62 */     if (npcCfg == null)
/*    */     {
/* 64 */       return -1;
/*    */     }
/* 66 */     return npcCfg.npcCfgid;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\menpaistar\main\MenPaiStarConfigManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */