/*    */ package mzm.gsp.qingfu.main;
/*    */ 
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.qingfu.event.TssChangedArg;
/*    */ 
/*    */ public class ROnUserTssChanged extends mzm.gsp.qingfu.event.TssChangedRunnable
/*    */ {
/*    */   public void process() throws Exception
/*    */   {
/* 10 */     if (GameServerInfoManager.isRoamServer())
/*    */     {
/* 12 */       return;
/*    */     }
/*    */     
/* 15 */     new POnUserTssChangedForLevelGrowthFundActivity((TssChangedArg)this.arg).call();
/* 16 */     new POnUserTssChangedForMonthCardActivity(((TssChangedArg)this.arg).userid).call();
/* 17 */     new POnUserTssChangedForRMBGiftBagActivity((TssChangedArg)this.arg).call();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\qingfu\main\ROnUserTssChanged.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */