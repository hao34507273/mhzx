/*    */ package mzm.gsp.circletask.main;
/*    */ 
/*    */ import java.util.List;
/*    */ import mzm.gsp.activity.main.ActivityHandler;
/*    */ import mzm.gsp.activity.main.ActivityHandler.ActivityStartType;
/*    */ import mzm.gsp.activity.main.ActivityStage;
/*    */ import mzm.gsp.award.main.AwardReason;
/*    */ import mzm.gsp.tlog.LogReason;
/*    */ import xbean.CircleTask;
/*    */ import xtable.Role2circletask;
/*    */ 
/*    */ public class CircleTaskActivityInit implements ActivityHandler
/*    */ {
/*    */   public void initData(String userId, long roleId, int turn, int activityid)
/*    */   {
/* 16 */     CircleTask xCircleTask = Role2circletask.get(Long.valueOf(roleId));
/* 17 */     if (xCircleTask == null) {
/* 18 */       return;
/*    */     }
/*    */     
/* 21 */     xCircleTask.setRenxingcounter(0);
/*    */   }
/*    */   
/*    */   public AwardReason getRecommendAwardReason()
/*    */   {
/* 26 */     return new AwardReason(LogReason.PAOHUAN_AWARD_ADD);
/*    */   }
/*    */   
/*    */   public List<ActivityStage> getActivityStages()
/*    */   {
/* 31 */     return null;
/*    */   }
/*    */   
/*    */   public void onActivityStart(ActivityHandler.ActivityStartType activityStartType, int activityid) {}
/*    */   
/*    */   public void onActivityStageStart(int stageIndex, boolean startAgain, int activityid) {}
/*    */   
/*    */   public void onActivityEnd(int activityid) {}
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\circletask\main\CircleTaskActivityInit.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */