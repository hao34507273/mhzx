/*    */ package mzm.gsp.csprovider.main;
/*    */ 
/*    */ import csprovider.ActiveCardUseArg;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class POnUseActivateCardTimeout extends LogicProcedure
/*    */ {
/*    */   private final ActiveCardUseArg arg;
/*    */   
/*    */   public POnUseActivateCardTimeout(ActiveCardUseArg arg)
/*    */   {
/* 12 */     this.arg = arg;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 18 */     CSProviderManager.onUseActivateCardTimeout(this.arg);
/* 19 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\csprovider\main\POnUseActivateCardTimeout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */