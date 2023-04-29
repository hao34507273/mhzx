/*    */ package mzm.gsp.storageexp.activity;
/*    */ 
/*    */ import mzm.gsp.bounty.event.FinishOneTaskArg;
/*    */ import mzm.gsp.bounty.event.FinishOneTaskProcedure;
/*    */ import mzm.gsp.bounty.main.BountyInterface;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class POnFinishOneBounty
/*    */   extends FinishOneTaskProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 17 */     return LostAwardManager.onActivityCountAdd(((FinishOneTaskArg)this.arg).getRoleId(), BountyInterface.getBountyActivityId(), ((FinishOneTaskArg)this.arg).getCount());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\storageexp\activity\POnFinishOneBounty.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */