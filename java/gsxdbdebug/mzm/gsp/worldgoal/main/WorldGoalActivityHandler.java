/*    */ package mzm.gsp.worldgoal.main;
/*    */ 
/*    */ import java.util.List;
/*    */ import mzm.gsp.activity.main.ActivityHandler;
/*    */ import mzm.gsp.activity.main.ActivityHandler.ActivityStartType;
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.activity.main.ActivityLimitTimeStageEnum;
/*    */ import mzm.gsp.activity.main.ActivityStage;
/*    */ import mzm.gsp.award.main.AwardReason;
/*    */ import mzm.gsp.util.DateTimeUtils;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class WorldGoalActivityHandler
/*    */   implements ActivityHandler
/*    */ {
/*    */   public List<ActivityStage> getActivityStages()
/*    */   {
/* 21 */     return null;
/*    */   }
/*    */   
/*    */ 
/*    */   public AwardReason getRecommendAwardReason()
/*    */   {
/* 27 */     return null;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public void initData(String userid, long roleId, int turn, int activityid) {}
/*    */   
/*    */ 
/*    */ 
/*    */   public void onActivityEnd(int activityid)
/*    */   {
/* 39 */     if (!WorldGoalManager.isWorldGoalSwitchOpen(activityid))
/*    */     {
/* 41 */       return;
/*    */     }
/* 43 */     if (ActivityInterface.getActivityLimitTimeStage(activityid, DateTimeUtils.getCurrTimeInMillis()) == ActivityLimitTimeStageEnum.LIMIT_TIME_AFTER)
/*    */     {
/* 45 */       WorldGoalManager.stopActivity(activityid, ReasonEnum.ACTIVITY_END);
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public void onActivityStageStart(int stage, boolean startAgain, int activityid) {}
/*    */   
/*    */ 
/*    */ 
/*    */   public void onActivityStart(ActivityHandler.ActivityStartType activityStartType, int activityid)
/*    */   {
/* 58 */     if (!WorldGoalManager.isWorldGoalSwitchOpen(activityid))
/*    */     {
/* 60 */       return;
/*    */     }
/* 62 */     WorldGoalManager.initActivity(activityid, false, ReasonEnum.ACTIVITY_START);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\worldgoal\main\WorldGoalActivityHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */