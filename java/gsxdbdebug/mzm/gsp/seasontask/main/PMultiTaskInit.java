/*    */ package mzm.gsp.seasontask.main;
/*    */ 
/*    */ import java.util.List;
/*    */ import mzm.gsp.activity.main.ActivityHandler;
/*    */ import mzm.gsp.activity.main.ActivityHandler.ActivityStartType;
/*    */ import mzm.gsp.map.main.ControllerInterface;
/*    */ import mzm.gsp.task.main.TaskInterface;
/*    */ import xbean.SeasonTaskInfo;
/*    */ import xtable.Role2seasontaskinfo;
/*    */ 
/*    */ public class PMultiTaskInit implements ActivityHandler
/*    */ {
/*    */   public void initData(String userId, long roleId, int turn, int activityid)
/*    */   {
/* 15 */     SeasonTaskInfo xInfo = Role2seasontaskinfo.get(Long.valueOf(roleId));
/* 16 */     if (xInfo == null) {
/* 17 */       return;
/*    */     }
/* 19 */     List<Integer> steps = xInfo.getMultiinfo().getFinishsteps();
/* 20 */     if (steps == null) {
/* 21 */       return;
/*    */     }
/* 23 */     steps.clear();
/* 24 */     int graphid = SummerTaskManager.getMultiGraph();
/* 25 */     TaskInterface.closeActivityGraphWithoutEvent(roleId, graphid);
/*    */   }
/*    */   
/*    */ 
/*    */   public mzm.gsp.award.main.AwardReason getRecommendAwardReason()
/*    */   {
/* 31 */     return null;
/*    */   }
/*    */   
/*    */ 
/*    */   public List<mzm.gsp.activity.main.ActivityStage> getActivityStages()
/*    */   {
/* 37 */     return null;
/*    */   }
/*    */   
/*    */   public void onActivityStart(ActivityHandler.ActivityStartType activityStartType, int activityid)
/*    */   {
/* 42 */     ControllerInterface.triggerController(SummerTaskManager.getMultiController());
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public void onActivityStageStart(int stage, boolean startAgain, int activityid) {}
/*    */   
/*    */ 
/*    */ 
/*    */   public void onActivityEnd(int activityid)
/*    */   {
/* 53 */     ControllerInterface.collectController(SummerTaskManager.getMultiController());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\seasontask\main\PMultiTaskInit.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */