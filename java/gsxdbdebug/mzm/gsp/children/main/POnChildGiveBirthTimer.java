/*    */ package mzm.gsp.children.main;
/*    */ 
/*    */ import mzm.gsp.children.event.GiveBirthTimerEventArg;
/*    */ 
/*    */ public class POnChildGiveBirthTimer extends mzm.gsp.children.event.GiveBirthTimerEventProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/*  9 */     long marriedId = ((GiveBirthTimerEventArg)this.arg).marriedId;
/* 10 */     GiveBirthTimeOutObserver observer = new GiveBirthTimeOutObserver(((GiveBirthTimerEventArg)this.arg).intervalMillSeconds, ((GiveBirthTimerEventArg)this.arg).roleId, marriedId, ((GiveBirthTimerEventArg)this.arg).partnerRoleId, ((GiveBirthTimerEventArg)this.arg).giveBirthScoreEnoughTime);
/*    */     
/*    */ 
/*    */ 
/* 14 */     xbean.GiveBirthObserver xGiveBirthObserver = xtable.Givebirthobservers.get(Long.valueOf(marriedId));
/* 15 */     if (xGiveBirthObserver == null)
/*    */     {
/* 17 */       xGiveBirthObserver = xbean.Pod.newGiveBirthObserver();
/* 18 */       xtable.Givebirthobservers.add(Long.valueOf(marriedId), xGiveBirthObserver);
/*    */     }
/*    */     
/* 21 */     GiveBirthTimeOutObserver oldObserver = xGiveBirthObserver.getObserver();
/* 22 */     if (oldObserver != null)
/*    */     {
/* 24 */       oldObserver.stopTimer();
/*    */     }
/*    */     
/* 27 */     xGiveBirthObserver.setObserver(observer);
/*    */     
/* 29 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\main\POnChildGiveBirthTimer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */