/*    */ package mzm.gsp.storageexp.activity;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import java.util.List;
/*    */ import java.util.concurrent.TimeUnit;
/*    */ import mzm.gsp.activity.main.ActivityHandler;
/*    */ import mzm.gsp.activity.main.ActivityHandler.ActivityStartType;
/*    */ import mzm.gsp.activity.main.ActivityStage;
/*    */ import mzm.gsp.activity.main.ActivityStage.TimeBaseLine;
/*    */ import mzm.gsp.activity.main.ActivityStage.TimeLogic;
/*    */ import mzm.gsp.activity2.confbean.LostExpConst;
/*    */ import mzm.gsp.award.main.AwardReason;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class LostExpActivityHandler
/*    */   implements ActivityHandler
/*    */ {
/*    */   public void initData(String userid, long roleId, int turn, int activityid) {}
/*    */   
/*    */   public AwardReason getRecommendAwardReason()
/*    */   {
/* 28 */     return null;
/*    */   }
/*    */   
/*    */ 
/*    */   public List<ActivityStage> getActivityStages()
/*    */   {
/* 34 */     long minute = TimeUnit.DAYS.toMinutes(LostExpConst.getInstance().collectExpInterval);
/* 35 */     ActivityStage activityStage = new ActivityStage((int)minute, ActivityStage.TimeBaseLine.BEGIN, ActivityStage.TimeLogic.FIX);
/*    */     
/* 37 */     return Arrays.asList(new ActivityStage[] { activityStage });
/*    */   }
/*    */   
/*    */   public void onActivityStart(ActivityHandler.ActivityStartType activityStartType, int activityid) {}
/*    */   
/*    */   public void onActivityStageStart(int stage, boolean startAgain, int activityid) {}
/*    */   
/*    */   public void onActivityEnd(int activityid) {}
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\storageexp\activity\LostExpActivityHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */