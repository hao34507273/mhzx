/*    */ package mzm.gsp.feisheng.fight;
/*    */ 
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.feisheng.confbean.SFeiShengFightActivityCfg;
/*    */ import mzm.gsp.open.main.OpenInterface;
/*    */ import mzm.gsp.util.DateTimeUtils;
/*    */ import xbean.FeiShengFightInfo;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class FightActivityManager
/*    */ {
/*    */   public static void init()
/*    */   {
/* 16 */     ActivityInterface.registerActivityByLogicType(87, new FeiShengFightActivityHandler());
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   static boolean isFeiShengFightActivitySwitchOpenForRole(long roleid, int activityCfgid)
/*    */   {
/* 27 */     SFeiShengFightActivityCfg cfg = SFeiShengFightActivityCfg.get(activityCfgid);
/* 28 */     if (cfg == null)
/*    */     {
/* 30 */       return false;
/*    */     }
/* 32 */     if (!OpenInterface.getOpenStatus(cfg.moduleid))
/*    */     {
/* 34 */       return false;
/*    */     }
/* 36 */     if (OpenInterface.isBanPlay(roleid, cfg.moduleid))
/*    */     {
/* 38 */       OpenInterface.sendBanPlayMsg(roleid, cfg.moduleid);
/* 39 */       return false;
/*    */     }
/* 41 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   static int getDailyGetTeamMemberAwardTimes(FeiShengFightInfo xFeiShengFightInfo, long now)
/*    */   {
/* 53 */     if (DateTimeUtils.needDailyReset(xFeiShengFightInfo.getDaily_get_team_member_award_times_timestamp(), now, 0))
/*    */     {
/*    */ 
/* 56 */       xFeiShengFightInfo.setDaily_get_team_member_award_times(0);
/* 57 */       xFeiShengFightInfo.setDaily_get_team_member_award_times_timestamp(now);
/*    */     }
/* 59 */     return xFeiShengFightInfo.getDaily_get_team_member_award_times();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\feisheng\fight\FightActivityManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */