/*    */ package mzm.gsp.achievement.main;
/*    */ 
/*    */ import mzm.gsp.achievement.main.goaltype.AbstractDoneOneEventLevelTimes.Context;
/*    */ import mzm.gsp.zhenfa.event.ZhenfaStudyArg;
/*    */ import mzm.gsp.zhenfa.event.ZhenfaStudyProcedure;
/*    */ 
/*    */ public class POnZhenFaStudy
/*    */   extends ZhenfaStudyProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 12 */     AchievementManager.updateGoalTypeState(((ZhenfaStudyArg)this.arg).roleId, 4900, Integer.valueOf(1), "POnZhenFaStudy.processImp@handle STUDY_ZHEN_FA success");
/*    */     
/*    */ 
/*    */ 
/* 16 */     AbstractDoneOneEventLevelTimes.Context context = new AbstractDoneOneEventLevelTimes.Context(1, ((ZhenfaStudyArg)this.arg).zhenfaId);
/* 17 */     AchievementManager.updateGoalTypeState(((ZhenfaStudyArg)this.arg).roleId, 4901, context, "POnZhenFaStudy.processImp@handle ZHEN_FA_LEVEL success");
/*    */     
/*    */ 
/* 20 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\POnZhenFaStudy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */