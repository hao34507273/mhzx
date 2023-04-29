/*    */ package mzm.gsp.factionpve.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import mzm.gsp.activity.main.ActivityHandler;
/*    */ import mzm.gsp.activity.main.ActivityHandler.ActivityStartType;
/*    */ import mzm.gsp.activity.main.ActivityStage;
/*    */ import mzm.gsp.activity.main.ActivityStage.TimeBaseLine;
/*    */ import mzm.gsp.activity.main.ActivityStage.TimeLogic;
/*    */ import mzm.gsp.award.main.AwardReason;
/*    */ import mzm.gsp.factionpve.confbean.SFactionPVEConsts;
/*    */ import xbean.RoleFactionPVE;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class FactionPVEActivityHandler
/*    */   implements ActivityHandler
/*    */ {
/*    */   public List<ActivityStage> getActivityStages()
/*    */   {
/* 22 */     List<ActivityStage> stages = new ArrayList();
/*    */     
/*    */ 
/* 25 */     ActivityStage activate = new ActivityStage(SFactionPVEConsts.getInstance().ForbidActivateBeforeEndMinutes, ActivityStage.TimeBaseLine.END, ActivityStage.TimeLogic.RELATIVE);
/*    */     
/*    */ 
/* 28 */     stages.add(activate);
/* 29 */     return stages;
/*    */   }
/*    */   
/*    */   public AwardReason getRecommendAwardReason()
/*    */   {
/* 34 */     return null;
/*    */   }
/*    */   
/*    */ 
/*    */   public void initData(String userid, long roleId, int turn, int activityid)
/*    */   {
/* 40 */     RoleFactionPVE xRolePVE = FactionPVEManager.getXRoleFactionPVEIfNotExist(roleId);
/*    */     
/* 42 */     FactionPVEManager.initXRoleFactionPVE(xRolePVE);
/*    */   }
/*    */   
/*    */   public void onActivityEnd(int activityid) {}
/*    */   
/*    */   public void onActivityStageStart(int stage, boolean startAgain, int activityid) {}
/*    */   
/*    */   public void onActivityStart(ActivityHandler.ActivityStartType activityStartType, int activityid) {}
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\factionpve\main\FactionPVEActivityHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */