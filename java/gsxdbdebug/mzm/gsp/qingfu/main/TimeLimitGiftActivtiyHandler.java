/*    */ package mzm.gsp.qingfu.main;
/*    */ 
/*    */ import java.util.List;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.activity.main.ActivityHandler;
/*    */ import mzm.gsp.activity.main.ActivityHandler.ActivityStartType;
/*    */ import mzm.gsp.activity.main.ActivityStage;
/*    */ import mzm.gsp.award.main.AwardReason;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ 
/*    */ class TimeLimitGiftActivtiyHandler
/*    */   implements ActivityHandler
/*    */ {
/*    */   public void initData(String userid, long roleId, int turn, int activityid)
/*    */   {
/* 17 */     TimeLimitGiftActivityManager.initData(userid, roleId, turn, activityid);
/*    */   }
/*    */   
/*    */ 
/*    */   public AwardReason getRecommendAwardReason()
/*    */   {
/* 23 */     return null;
/*    */   }
/*    */   
/*    */ 
/*    */   public List<ActivityStage> getActivityStages()
/*    */   {
/* 29 */     return null;
/*    */   }
/*    */   
/*    */ 
/*    */   public void onActivityStart(ActivityHandler.ActivityStartType activityStartType, int activityCfgid)
/*    */   {
/* 35 */     GameServer.logger().info(String.format("[timelimit]TimeLimitGiftActivtiyHandler.onActivityStart@activity start|activityId=%d", new Object[] { Integer.valueOf(activityCfgid) }));
/*    */     
/*    */ 
/* 38 */     TimeLimitGiftActivityManager.startOpenWelfareMailObserver(activityStartType, activityCfgid);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public void onActivityStageStart(int stage, boolean startAgain, int activityid) {}
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public void onActivityEnd(int activityid)
/*    */   {
/* 51 */     GameServer.logger().info(String.format("[timelimit]TimeLimitGiftActivtiyHandler.onActivityStart@activity end|activityId=%d", new Object[] { Integer.valueOf(activityid) }));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\qingfu\main\TimeLimitGiftActivtiyHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */