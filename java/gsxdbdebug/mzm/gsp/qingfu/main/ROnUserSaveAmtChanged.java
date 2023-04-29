/*    */ package mzm.gsp.qingfu.main;
/*    */ 
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.qingfu.event.SaveAmtChangedArg;
/*    */ 
/*    */ public class ROnUserSaveAmtChanged extends mzm.gsp.qingfu.event.SaveAmtChangedRunnable
/*    */ {
/*    */   public void process() throws Exception
/*    */   {
/* 10 */     if (GameServerInfoManager.isRoamServer())
/*    */     {
/* 12 */       return;
/*    */     }
/*    */     
/* 15 */     new POnUserSaveAmtChangedForFirstRecharge(((SaveAmtChangedArg)this.arg).userid).call();
/*    */     
/* 17 */     new POnUserSaveAmtChangedForSaveAmtActivity((SaveAmtChangedArg)this.arg).call();
/*    */     
/* 19 */     new POnUserSaveAmtChangedForSaveAmtRecord(((SaveAmtChangedArg)this.arg).userid, ((SaveAmtChangedArg)this.arg).oldSaveAmt, ((SaveAmtChangedArg)this.arg).currSaveAmt).call();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\qingfu\main\ROnUserSaveAmtChanged.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */