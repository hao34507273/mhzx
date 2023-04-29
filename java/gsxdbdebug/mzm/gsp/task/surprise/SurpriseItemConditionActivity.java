/*    */ package mzm.gsp.task.surprise;
/*    */ 
/*    */ import java.util.List;
/*    */ import mzm.gsp.activity.main.ActivityHandler;
/*    */ import mzm.gsp.activity.main.ActivityHandler.ActivityStartType;
/*    */ import mzm.gsp.activity.main.ActivityStage;
/*    */ import mzm.gsp.activity3.confbean.STActivityId2serverId;
/*    */ import mzm.gsp.award.main.AwardReason;
/*    */ import mzm.gsp.server.main.ServerInterface;
/*    */ import mzm.gsp.util.DateTimeUtils;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SurpriseItemConditionActivity
/*    */   implements ActivityHandler
/*    */ {
/*    */   public void initData(String userid, long roleId, int turn, int activityid) {}
/*    */   
/*    */   public AwardReason getRecommendAwardReason()
/*    */   {
/* 30 */     return null;
/*    */   }
/*    */   
/*    */ 
/*    */   public List<ActivityStage> getActivityStages()
/*    */   {
/* 36 */     return null;
/*    */   }
/*    */   
/*    */ 
/*    */   public void onActivityStart(ActivityHandler.ActivityStartType activityStartType, int activityid)
/*    */   {
/* 42 */     openControllers(activityid);
/* 43 */     SurpriseTaskManager.loggerInfo("SurpriseItemConditionActivity.onActivityStart@ surprise item activity open!|activityId=%d", new Object[] { Integer.valueOf(activityid) });
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
/*    */   public void onActivityEnd(int activityid) {}
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   private void openControllers(int activityId)
/*    */   {
/* 61 */     SurpriseTaskManager.checkAndInitSupriseTask(STActivityId2serverId.get(activityId), ServerInterface.getCurrentServerLevel(), DateTimeUtils.getCurrTimeInMillis());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\task\surprise\SurpriseItemConditionActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */