/*    */ package mzm.gsp.msdkprofile.main;
/*    */ 
/*    */ import mzm.gsp.qingfu.event.SaveAmtChangedArg;
/*    */ import mzm.gsp.qingfu.event.SaveAmtChangedProcedure;
/*    */ import mzm.gsp.qingfu.main.QingfuInterface;
/*    */ 
/*    */ public class POnUserYuanbaoChanged extends SaveAmtChangedProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 11 */     String userid = ((SaveAmtChangedArg)this.arg).userid;
/* 12 */     long balance = QingfuInterface.getBalance(userid, false);
/* 13 */     long roleid = QingfuInterface.getSuitableRoleId(userid);
/* 14 */     return MSDKProfileManager.reportRoleCash(userid, roleid, balance);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\msdkprofile\main\POnUserYuanbaoChanged.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */