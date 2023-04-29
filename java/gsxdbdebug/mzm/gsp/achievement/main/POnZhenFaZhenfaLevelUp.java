/*    */ package mzm.gsp.achievement.main;
/*    */ 
/*    */ import mzm.gsp.achievement.main.goaltype.AbstractDoneOneEventLevelTimes.Context;
/*    */ import mzm.gsp.zhenfa.event.ZhenfaLevelUpArg;
/*    */ import mzm.gsp.zhenfa.event.ZhenfaLevelUpProcedure;
/*    */ 
/*    */ public class POnZhenFaZhenfaLevelUp
/*    */   extends ZhenfaLevelUpProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 13 */     AbstractDoneOneEventLevelTimes.Context context = new AbstractDoneOneEventLevelTimes.Context(((ZhenfaLevelUpArg)this.arg).newLevel, ((ZhenfaLevelUpArg)this.arg).zhenfaId);
/* 14 */     AchievementManager.updateGoalTypeState(((ZhenfaLevelUpArg)this.arg).roleId, 4901, context, "POnZhenFaZhenfaLevelUp.processImp@handle ZHEN_FA_LEVEL success");
/*    */     
/*    */ 
/* 17 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\POnZhenFaZhenfaLevelUp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */