/*    */ package mzm.gsp.baotu.main;
/*    */ 
/*    */ import java.util.List;
/*    */ import mzm.gsp.activity.confbean.BaoTuActivityCfgConsts;
/*    */ import mzm.gsp.activity.main.ActivityHandler;
/*    */ import mzm.gsp.activity.main.ActivityHandler.ActivityStartType;
/*    */ import mzm.gsp.activity.main.ActivityStage;
/*    */ import mzm.gsp.award.main.AwardReason;
/*    */ import mzm.gsp.task.main.AccpetTaskProcedure;
/*    */ import mzm.gsp.task.main.TaskData;
/*    */ import mzm.gsp.task.main.TaskInterface;
/*    */ import mzm.gsp.tlog.LogReason;
/*    */ import xdb.Procedure;
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
/*    */ public class BatotuActivityInit
/*    */   implements ActivityHandler
/*    */ {
/*    */   public void initData(String userid, long roleId, int turn, int activityid)
/*    */   {
/* 41 */     openGuideTask(roleId, BaoTuActivityCfgConsts.getInstance().GUIDE_GRAPH_ID);
/*    */   }
/*    */   
/*    */   private void openGuideTask(long roleId, int graphId)
/*    */   {
/* 46 */     if (graphId <= 0)
/*    */     {
/* 48 */       return;
/*    */     }
/* 50 */     TaskInterface.activeGraph(Long.valueOf(roleId), graphId);
/* 51 */     TaskData taskData = TaskInterface.getRoleGraphTask(roleId, graphId);
/* 52 */     if (taskData == null)
/*    */     {
/* 54 */       return;
/*    */     }
/* 56 */     if (taskData.getState() == 1)
/*    */     {
/* 58 */       Procedure.execute(new AccpetTaskProcedure(roleId, graphId, taskData.getTaskId()));
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */   public AwardReason getRecommendAwardReason()
/*    */   {
/* 65 */     return new AwardReason(LogReason.BAOTU_ACTIVITY_RECOMMEN_ADD, 0);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public List<ActivityStage> getActivityStages()
/*    */   {
/* 72 */     return null;
/*    */   }
/*    */   
/*    */   public void onActivityStart(ActivityHandler.ActivityStartType activityStartType, int activityid) {}
/*    */   
/*    */   public void onActivityStageStart(int stageIndex, boolean startAgain, int activityid) {}
/*    */   
/*    */   public void onActivityEnd(int activityid) {}
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\baotu\main\BatotuActivityInit.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */