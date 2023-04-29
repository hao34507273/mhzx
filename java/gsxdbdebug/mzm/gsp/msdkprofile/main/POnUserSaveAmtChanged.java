/*    */ package mzm.gsp.msdkprofile.main;
/*    */ 
/*    */ import mzm.gsp.qingfu.event.SaveAmtChangedArg;
/*    */ import mzm.gsp.qingfu.event.SaveAmtChangedProcedure;
/*    */ import mzm.gsp.qingfu.main.QingfuInterface;
/*    */ 
/*    */ public class POnUserSaveAmtChanged extends SaveAmtChangedProcedure
/*    */ {
/*    */   private static final int RATE = 10;
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 13 */     long currSaveAmt = ((SaveAmtChangedArg)this.arg).currSaveAmt / 10L;
/* 14 */     long oldSaveAmt = ((SaveAmtChangedArg)this.arg).oldSaveAmt / 10L;
/* 15 */     String userid = ((SaveAmtChangedArg)this.arg).userid;
/*    */     
/* 17 */     long roleid = QingfuInterface.getSuitableRoleId(userid);
/* 18 */     return MSDKProfileManager.reportRoleRecharge(userid, roleid, oldSaveAmt, currSaveAmt);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\msdkprofile\main\POnUserSaveAmtChanged.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */