/*    */ package mzm.gsp.backgameactivity.main;
/*    */ 
/*    */ import mzm.gsp.activity.event.AddActivityCountArg;
/*    */ 
/*    */ public class POnAddActivityCount extends mzm.gsp.activity.event.AddActivityCountEventProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/*  9 */     BackGameActivityInterface.addPointOnFinishedActivity(((AddActivityCountArg)this.arg).roleId, ((AddActivityCountArg)this.arg).activityId, ((AddActivityCountArg)this.arg).currentActivityCount, ((AddActivityCountArg)this.arg).addedActivityCount);
/*    */     
/* 11 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\backgameactivity\main\POnAddActivityCount.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */