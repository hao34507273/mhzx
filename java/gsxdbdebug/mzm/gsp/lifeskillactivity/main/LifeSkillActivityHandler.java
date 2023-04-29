/*    */ package mzm.gsp.lifeskillactivity.main;
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
/*    */ public class LifeSkillActivityHandler
/*    */   implements ActivityHandler
/*    */ {
/*    */   public void initData(String userid, long roleId, int turn, int activityid) {}
/*    */   
/*    */   public AwardReason getRecommendAwardReason()
/*    */   {
/* 26 */     return null;
/*    */   }
/*    */   
/*    */ 
/*    */   public List<ActivityStage> getActivityStages()
/*    */   {
/* 32 */     return null;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public void onActivityStart(ActivityHandler.ActivityStartType activityStartType, int activityid)
/*    */   {
/* 39 */     if (!LifeSkillActivityManager.isFunOpen(activityid))
/*    */     {
/* 41 */       return;
/*    */     }
/*    */     
/* 44 */     int controllerId = LifeSkillActivityManager.getNpcController(activityid);
/* 45 */     if (controllerId <= 0)
/*    */     {
/* 47 */       return;
/*    */     }
/*    */     
/* 50 */     ControllerInterface.triggerController(controllerId);
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
/* 63 */     int controllerId = LifeSkillActivityManager.getNpcController(activityid);
/* 64 */     if (controllerId <= 0)
/*    */     {
/* 66 */       return;
/*    */     }
/*    */     
/* 69 */     ControllerInterface.collectController(controllerId);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\lifeskillactivity\main\LifeSkillActivityHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */