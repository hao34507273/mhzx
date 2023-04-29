/*    */ package mzm.gsp.scochallenge.main;
/*    */ 
/*    */ import java.util.List;
/*    */ import mzm.gsp.activity.SScoActivityStartRes;
/*    */ import mzm.gsp.activity.main.ActivityHandler;
/*    */ import mzm.gsp.activity.main.ActivityHandler.ActivityStartType;
/*    */ import mzm.gsp.activity.main.ActivityStage;
/*    */ import mzm.gsp.award.main.AwardReason;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import xbean.Pod;
/*    */ import xbean.SchoolChallenge;
/*    */ import xtable.Role2schoolchallenge;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ScoChallengeActivityInit
/*    */   implements ActivityHandler
/*    */ {
/*    */   public void initData(String userid, long roleId, int turn, int activityid)
/*    */   {
/* 25 */     SchoolChallenge xSchoolChallenge = Role2schoolchallenge.get(Long.valueOf(roleId));
/* 26 */     if (xSchoolChallenge == null)
/*    */     {
/* 28 */       xSchoolChallenge = Pod.newSchoolChallenge();
/* 29 */       Role2schoolchallenge.insert(Long.valueOf(roleId), xSchoolChallenge);
/*    */     }
/* 31 */     xSchoolChallenge.setCurrentring(0);
/* 32 */     xSchoolChallenge.getTaskids().clear();
/* 33 */     xSchoolChallenge.setAwardcirclecount(0);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public AwardReason getRecommendAwardReason()
/*    */   {
/* 43 */     return null;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public List<ActivityStage> getActivityStages()
/*    */   {
/* 50 */     return null;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public void onActivityStart(ActivityHandler.ActivityStartType activityStartType, int activityid)
/*    */   {
/* 57 */     new POnScoChallengeStart().execute();
/* 58 */     SScoActivityStartRes res = new SScoActivityStartRes();
/* 59 */     OnlineManager.getInstance().sendAllAtOnce(res);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public void onActivityStageStart(int stageIndex, boolean startAgain, int activityid) {}
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public void onActivityEnd(int activityid)
/*    */   {
/* 73 */     new POnScoChallengeEnd().execute();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\scochallenge\main\ScoChallengeActivityInit.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */