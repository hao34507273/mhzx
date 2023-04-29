/*    */ package mzm.gsp.worldgoal.main;
/*    */ 
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.activity.main.ActivityLimitTimeStageEnum;
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import mzm.gsp.util.DateTimeUtils;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.WorldGoal;
/*    */ import xtable.Worldgoals;
/*    */ 
/*    */ public class PAddWorldGoalPoint
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   private final int activityCfgid;
/*    */   private final int addPonit;
/*    */   
/*    */   public PAddWorldGoalPoint(long roleid, int activityCfgid, int addPonit)
/*    */   {
/* 22 */     this.roleid = roleid;
/* 23 */     this.activityCfgid = activityCfgid;
/* 24 */     this.addPonit = addPonit;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 30 */     long now = DateTimeUtils.getCurrTimeInMillis();
/* 31 */     if (ActivityInterface.getActivityLimitTimeStage(this.activityCfgid, now) != ActivityLimitTimeStageEnum.LIMIT_TIME_NOW)
/*    */     {
/* 33 */       GmManager.getInstance().sendResultToGM(this.roleid, String.format("活动未开启|activity_cfg_id=%d", new Object[] { Integer.valueOf(this.activityCfgid) }));
/* 34 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 38 */     long globalActivityCfgid = GameServerInfoManager.toGlobalId(this.activityCfgid);
/* 39 */     WorldGoal xWorldGoal = Worldgoals.get(Long.valueOf(globalActivityCfgid));
/* 40 */     if (xWorldGoal == null)
/*    */     {
/* 42 */       GmManager.getInstance().sendResultToGM(this.roleid, String.format("db error", new Object[0]));
/* 43 */       return false;
/*    */     }
/*    */     
/* 46 */     int activityCanCommitPoint = WorldGoalManager.getActivityCanCommitPoint(this.activityCfgid);
/* 47 */     if (activityCanCommitPoint <= 0)
/*    */     {
/*    */ 
/* 50 */       GmManager.getInstance().sendResultToGM(this.roleid, String.format("活动所需分数已满|activity_cfg_id=%d", new Object[] { Integer.valueOf(this.activityCfgid) }));
/*    */       
/* 52 */       return false;
/*    */     }
/*    */     
/* 55 */     int realAddPonit = Math.min(this.addPonit, activityCanCommitPoint);
/* 56 */     WorldGoalManager.updateActivityInfoAndSendMail(this.activityCfgid, realAddPonit, now);
/* 57 */     GmManager.getInstance().sendResultToGM(this.roleid, String.format("增加世界目标活动分数成功|activityCfgid=%d|realAddPoint=%d", new Object[] { Integer.valueOf(this.activityCfgid), Integer.valueOf(realAddPonit) }));
/*    */     
/*    */ 
/* 60 */     WorldGoalManager.logger.info(String.format("[worldgoal]PAddWorldGoalPoint.processImp@add point success|roleid=%d|activity_cfg_id=%d|real_add_point=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.activityCfgid), Integer.valueOf(realAddPonit) }));
/*    */     
/*    */ 
/* 63 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\worldgoal\main\PAddWorldGoalPoint.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */