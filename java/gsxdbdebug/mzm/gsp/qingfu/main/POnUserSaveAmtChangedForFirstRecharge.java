/*    */ package mzm.gsp.qingfu.main;
/*    */ 
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class POnUserSaveAmtChangedForFirstRecharge extends LogicProcedure
/*    */ {
/*    */   private final String userId;
/*    */   
/*    */   public POnUserSaveAmtChangedForFirstRecharge(String userId)
/*    */   {
/* 11 */     this.userId = userId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 17 */     return FirstRechargeManager.onSaveAmtChanged(this.userId);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\qingfu\main\POnUserSaveAmtChangedForFirstRecharge.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */