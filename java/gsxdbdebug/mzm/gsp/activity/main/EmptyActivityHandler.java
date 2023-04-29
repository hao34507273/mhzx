/*    */ package mzm.gsp.activity.main;
/*    */ 
/*    */ import java.util.List;
/*    */ import mzm.gsp.award.main.AwardReason;
/*    */ 
/*    */ class EmptyActivityHandler
/*    */   implements ActivityHandler
/*    */ {
/*  9 */   static EmptyActivityHandler instance = new EmptyActivityHandler();
/*    */   
/*    */ 
/*    */ 
/*    */   public void initData(String userid, long roleId, int turn, int activityid) {}
/*    */   
/*    */ 
/*    */ 
/*    */   public AwardReason getRecommendAwardReason()
/*    */   {
/* 19 */     return null;
/*    */   }
/*    */   
/*    */ 
/*    */   public List<ActivityStage> getActivityStages()
/*    */   {
/* 25 */     return null;
/*    */   }
/*    */   
/*    */   public void onActivityStart(ActivityHandler.ActivityStartType activityStartType, int activityid) {}
/*    */   
/*    */   public void onActivityStageStart(int stage, boolean startAgain, int activityid) {}
/*    */   
/*    */   public void onActivityEnd(int activityid) {}
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activity\main\EmptyActivityHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */