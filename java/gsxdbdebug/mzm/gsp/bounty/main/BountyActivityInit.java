/*     */ package mzm.gsp.bounty.main;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.activity.confbean.BountyConsts;
/*     */ import mzm.gsp.activity.main.ActivityHandler;
/*     */ import mzm.gsp.activity.main.ActivityHandler.ActivityStartType;
/*     */ import mzm.gsp.activity.main.ActivityStage;
/*     */ import mzm.gsp.activitycompensate.main.ActivityCompensateHandler;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.bounty.SResetBountyCount;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.task.main.AccpetTaskProcedure;
/*     */ import mzm.gsp.task.main.TaskData;
/*     */ import mzm.gsp.task.main.TaskInterface;
/*     */ import xbean.BountyInfo;
/*     */ import xdb.Procedure;
/*     */ import xtable.Role2bounty;
/*     */ 
/*     */ public class BountyActivityInit
/*     */   implements ActivityHandler, ActivityCompensateHandler
/*     */ {
/*     */   public void initData(String userId, long roleId, int turn, int activityid)
/*     */   {
/*  26 */     int num = BountyManager.getBountyConsts().DAY_UPPER_LIMIT;
/*     */     
/*  28 */     BountyInfo xBountyInfo = Role2bounty.get(Long.valueOf(roleId));
/*  29 */     if (xBountyInfo != null)
/*     */     {
/*  31 */       num = xBountyInfo.getBountycount();
/*  32 */       xBountyInfo.setBountycount(0);
/*  33 */       xBountyInfo.getDonetaskinfo().clear();
/*  34 */       OnlineManager.getInstance().send(roleId, new SResetBountyCount());
/*     */     }
/*  36 */     BountyManager.awardStore(roleId, num);
/*     */     
/*  38 */     int graphId = BountyConsts.getInstance().GUIDE_GRAPH_ID;
/*  39 */     openGuideTask(roleId, graphId);
/*     */   }
/*     */   
/*     */   private void openGuideTask(long roleId, int graphId)
/*     */   {
/*  44 */     if (graphId <= 0)
/*     */     {
/*  46 */       return;
/*     */     }
/*  48 */     TaskInterface.activeGraph(Long.valueOf(roleId), graphId);
/*  49 */     TaskData taskData = TaskInterface.getRoleGraphTask(roleId, graphId);
/*  50 */     if (taskData == null)
/*     */     {
/*  52 */       return;
/*     */     }
/*  54 */     if (taskData.getState() == 1)
/*     */     {
/*  56 */       Procedure.execute(new AccpetTaskProcedure(roleId, graphId, taskData.getTaskId()));
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public AwardReason getRecommendAwardReason()
/*     */   {
/*  64 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public List<ActivityStage> getActivityStages()
/*     */   {
/*  71 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void onActivityStart(ActivityHandler.ActivityStartType activityStartType, int activityid) {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void onActivityStageStart(int stageIndex, boolean startAgain, int activityid) {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void onActivityEnd(int activityid) {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public List<Integer> getActivitySwitchList(int activityid)
/*     */   {
/* 101 */     return Arrays.asList(new Integer[] { Integer.valueOf(3) });
/*     */   }
/*     */   
/*     */ 
/*     */   public int getCompensateAwardTimes(long roleid, int count, int activityId)
/*     */   {
/* 107 */     if (count < 0)
/*     */     {
/* 109 */       return 0;
/*     */     }
/* 111 */     int maxCount = BountyConsts.getInstance().DAY_UPPER_LIMIT;
/* 112 */     return count >= maxCount ? 0 : maxCount - count;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\bounty\main\BountyActivityInit.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */