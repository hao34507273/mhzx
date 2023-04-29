/*    */ package mzm.gsp.achievement.main;
/*    */ 
/*    */ import mzm.gsp.signaward.event.SignArg;
/*    */ import mzm.gsp.signaward.event.SignEventProcedure;
/*    */ 
/*    */ public class POnSignEvent
/*    */   extends SignEventProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 11 */     AchievementManager.updateGoalTypeState(((SignArg)this.arg).roleid, 2406, Integer.valueOf(1), "POnSignEvent.processImp@handle SIGN_UP_COUNT finish");
/*    */     
/*    */ 
/*    */ 
/* 15 */     if (!((SignArg)this.arg).isResign)
/*    */     {
/* 17 */       AchievementManager.updateGoalTypeState(((SignArg)this.arg).roleid, 2407, null, "POnSignEvent.processImp@handle SIGN_UP_COMBO_COUNT finish");
/*    */     }
/*    */     
/*    */ 
/* 21 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\POnSignEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */