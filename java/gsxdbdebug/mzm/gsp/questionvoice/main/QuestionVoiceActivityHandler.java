/*    */ package mzm.gsp.questionvoice.main;
/*    */ 
/*    */ import java.util.List;
/*    */ import mzm.gsp.activity.main.ActivityHandler;
/*    */ import mzm.gsp.activity.main.ActivityHandler.ActivityStartType;
/*    */ import mzm.gsp.activity.main.ActivityStage;
/*    */ import mzm.gsp.award.main.AwardReason;
/*    */ import mzm.gsp.map.main.ControllerInterface;
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
/*    */ public class QuestionVoiceActivityHandler
/*    */   implements ActivityHandler
/*    */ {
/*    */   public void initData(String userid, long roleId, int turn, int activityid) {}
/*    */   
/*    */   public AwardReason getRecommendAwardReason()
/*    */   {
/* 27 */     return null;
/*    */   }
/*    */   
/*    */ 
/*    */   public List<ActivityStage> getActivityStages()
/*    */   {
/* 33 */     return null;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public void onActivityStart(ActivityHandler.ActivityStartType activityStartType, int activityid)
/*    */   {
/* 40 */     if (!QuestionVoiceManager.isFunOpen(activityid))
/*    */     {
/* 42 */       return;
/*    */     }
/*    */     
/* 45 */     int controllerId = QuestionVoiceManager.getNpcController(activityid);
/* 46 */     if (controllerId <= 0)
/*    */     {
/* 48 */       return;
/*    */     }
/*    */     
/* 51 */     ControllerInterface.triggerController(controllerId);
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
/* 64 */     int controllerId = QuestionVoiceManager.getNpcController(activityid);
/* 65 */     if (controllerId <= 0)
/*    */     {
/* 67 */       return;
/*    */     }
/*    */     
/* 70 */     ControllerInterface.collectController(controllerId);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\questionvoice\main\QuestionVoiceActivityHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */