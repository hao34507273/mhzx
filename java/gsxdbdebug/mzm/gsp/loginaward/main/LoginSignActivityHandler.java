/*    */ package mzm.gsp.loginaward.main;
/*    */ 
/*    */ import java.util.List;
/*    */ import mzm.gsp.activity.main.ActivityHandler;
/*    */ import mzm.gsp.activity.main.ActivityHandler.ActivityStartType;
/*    */ import mzm.gsp.activity.main.ActivityStage;
/*    */ import mzm.gsp.award.main.AwardReason;
/*    */ 
/*    */ public class LoginSignActivityHandler
/*    */   implements ActivityHandler
/*    */ {
/*    */   public void initData(String userid, long roleId, int turn, int activityid)
/*    */   {
/* 14 */     LoginSignActivityManager.initData(userid, roleId, activityid);
/*    */   }
/*    */   
/*    */ 
/*    */   public AwardReason getRecommendAwardReason()
/*    */   {
/* 20 */     return null;
/*    */   }
/*    */   
/*    */ 
/*    */   public List<ActivityStage> getActivityStages()
/*    */   {
/* 26 */     return null;
/*    */   }
/*    */   
/*    */   public void onActivityStart(ActivityHandler.ActivityStartType activityStartType, int activityid) {}
/*    */   
/*    */   public void onActivityStageStart(int stage, boolean startAgain, int activityid) {}
/*    */   
/*    */   public void onActivityEnd(int activityid) {}
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\loginaward\main\LoginSignActivityHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */