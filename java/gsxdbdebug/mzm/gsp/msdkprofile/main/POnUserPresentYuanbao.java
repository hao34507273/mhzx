/*    */ package mzm.gsp.msdkprofile.main;
/*    */ 
/*    */ import mzm.gsp.qingfu.event.PresentYuanbaoArg;
/*    */ import mzm.gsp.qingfu.event.PresentYuanbaoProcedure;
/*    */ import mzm.gsp.qingfu.main.QingfuInterface;
/*    */ 
/*    */ public class POnUserPresentYuanbao extends PresentYuanbaoProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 11 */     String userid = ((PresentYuanbaoArg)this.arg).userid;
/* 12 */     long roleid = ((PresentYuanbaoArg)this.arg).roleid;
/* 13 */     long balance = QingfuInterface.getBalance(userid, false);
/* 14 */     return MSDKProfileManager.reportRoleCash(userid, roleid, balance);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\msdkprofile\main\POnUserPresentYuanbao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */