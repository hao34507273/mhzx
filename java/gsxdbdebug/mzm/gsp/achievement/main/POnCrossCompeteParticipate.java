/*    */ package mzm.gsp.achievement.main;
/*    */ 
/*    */ import mzm.gsp.crosscompete.event.CrossCompeteParticipateArg;
/*    */ import mzm.gsp.crosscompete.event.CrossCompeteParticipateProcedure;
/*    */ 
/*    */ public class POnCrossCompeteParticipate
/*    */   extends CrossCompeteParticipateProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */   {
/* 11 */     if (((CrossCompeteParticipateArg)this.arg).isWinner)
/*    */     {
/* 13 */       AchievementManager.updateGoalTypeState(((CrossCompeteParticipateArg)this.arg).roleid, 911, Integer.valueOf(1), "POnCrossCompeteParticipate.processImp@handle CROSS_COMPETITION_WIN success");
/*    */     }
/*    */     
/*    */ 
/* 17 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\POnCrossCompeteParticipate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */