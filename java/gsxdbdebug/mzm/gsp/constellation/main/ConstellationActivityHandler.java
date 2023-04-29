/*    */ package mzm.gsp.constellation.main;
/*    */ 
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.activity.main.ActivityHandler;
/*    */ import mzm.gsp.activity.main.ActivityHandler.ActivityStartType;
/*    */ import mzm.gsp.activity.main.ActivityStage;
/*    */ import mzm.gsp.award.main.AwardReason;
/*    */ import xbean.Constellation;
/*    */ import xbean.RoleConstellation;
/*    */ 
/*    */ 
/*    */ class ConstellationActivityHandler
/*    */   implements ActivityHandler
/*    */ {
/*    */   public List<ActivityStage> getActivityStages()
/*    */   {
/* 18 */     return null;
/*    */   }
/*    */   
/*    */ 
/*    */   public AwardReason getRecommendAwardReason()
/*    */   {
/* 24 */     return null;
/*    */   }
/*    */   
/*    */ 
/*    */   public void initData(String userid, long roleId, int turn, int activityid)
/*    */   {
/* 30 */     RoleConstellation xRoleConstellation = ConstellationManager.getXRoleConstellationIfNotExist(roleId);
/*    */     
/* 32 */     xRoleConstellation.setSet_times(0);
/* 33 */     xRoleConstellation.getAward_constellations().clear();
/* 34 */     xRoleConstellation.setSum_exp(0);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public void onActivityStart(ActivityHandler.ActivityStartType activityStartType, int activityid)
/*    */   {
/* 41 */     StartCountDownSession.clearSession();
/* 42 */     CardSession.clearSession();
/*    */     
/*    */ 
/* 45 */     Constellation xConstellation = ConstellationManager.getXConstellationIfNotExist();
/*    */     
/* 47 */     ConstellationManager.initXConstellation(xConstellation);
/*    */     
/*    */ 
/* 50 */     StartCountDownSession.newInstance();
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public void onActivityStageStart(int stage, boolean startAgain, int activityid) {}
/*    */   
/*    */ 
/*    */ 
/*    */   public void onActivityEnd(int activityid)
/*    */   {
/* 62 */     StartCountDownSession.clearSession();
/* 63 */     CardSession.clearSession();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\constellation\main\ConstellationActivityHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */