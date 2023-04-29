/*    */ package mzm.gsp.factiontask.main;
/*    */ 
/*    */ import java.util.List;
/*    */ import mzm.gsp.activity.main.ActivityHandler;
/*    */ import mzm.gsp.activity.main.ActivityHandler.ActivityStartType;
/*    */ import mzm.gsp.activity.main.ActivityStage;
/*    */ import mzm.gsp.award.main.AwardReason;
/*    */ import mzm.gsp.open.main.OpenInterface;
/*    */ import mzm.gsp.task.main.TaskInterface;
/*    */ 
/*    */ 
/*    */ public class PGangTaskInit
/*    */   implements ActivityHandler
/*    */ {
/*    */   public void initData(String userId, long roleId, int turn, int activityid)
/*    */   {
/* 17 */     GangTaskManager.initPerFect(roleId);
/*    */     
/* 19 */     initGangTask(roleId);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   private void initGangTask(long roleId)
/*    */   {
/* 26 */     int graphid = GangTaskManager.getGangTaskGraph();
/* 27 */     if ((OpenInterface.getOpenStatus(18)) && (!OpenInterface.isBanPlay(roleId, 18)))
/*    */     {
/* 29 */       openNewGangTask(roleId, graphid);
/* 30 */       return;
/*    */     }
/* 32 */     TaskInterface.closeActivityGraphWithoutEvent(roleId, graphid);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   private void openNewGangTask(long roleId, int graphid)
/*    */   {
/* 39 */     if (TaskInterface.isHaveGraphId(roleId, graphid)) {
/* 40 */       boolean ret = TaskInterface.clearGraph(graphid, roleId);
/* 41 */       if (!ret) {}
/*    */       
/*    */ 
/* 44 */       TaskInterface.goNextTask(roleId, graphid);
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */   public AwardReason getRecommendAwardReason()
/*    */   {
/* 51 */     return null;
/*    */   }
/*    */   
/*    */ 
/*    */   public List<ActivityStage> getActivityStages()
/*    */   {
/* 57 */     return null;
/*    */   }
/*    */   
/*    */   public void onActivityStart(ActivityHandler.ActivityStartType activityStartType, int activityid) {}
/*    */   
/*    */   public void onActivityStageStart(int stage, boolean startAgain, int activityid) {}
/*    */   
/*    */   public void onActivityEnd(int activityid) {}
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\factiontask\main\PGangTaskInit.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */