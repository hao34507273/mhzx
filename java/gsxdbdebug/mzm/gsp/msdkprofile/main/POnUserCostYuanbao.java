/*    */ package mzm.gsp.msdkprofile.main;
/*    */ 
/*    */ import mzm.gsp.qingfu.event.CostYuanbaoArg;
/*    */ import mzm.gsp.qingfu.event.CostYuanbaoProcedure;
/*    */ import mzm.gsp.qingfu.main.QingfuInterface;
/*    */ 
/*    */ public class POnUserCostYuanbao extends CostYuanbaoProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 11 */     String userid = ((CostYuanbaoArg)this.arg).userid;
/* 12 */     long roleid = ((CostYuanbaoArg)this.arg).roleid;
/* 13 */     long balance = QingfuInterface.getBalance(userid, false);
/* 14 */     return MSDKProfileManager.reportRoleCash(userid, roleid, balance);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\msdkprofile\main\POnUserCostYuanbao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */