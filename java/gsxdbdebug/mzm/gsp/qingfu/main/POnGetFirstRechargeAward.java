/*    */ package mzm.gsp.qingfu.main;
/*    */ 
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class POnGetFirstRechargeAward extends LogicProcedure
/*    */ {
/*    */   private final String userid;
/*    */   private final long roleid;
/*    */   
/*    */   public POnGetFirstRechargeAward(String userid, long roleid)
/*    */   {
/* 12 */     this.userid = userid;
/* 13 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 19 */     SaveAmtActivityManager.trySendTipMail(this.userid, this.roleid);
/*    */     
/* 21 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\qingfu\main\POnGetFirstRechargeAward.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */