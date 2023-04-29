/*    */ package mzm.gsp.csprovider.main;
/*    */ 
/*    */ import csprovider.GiftCardUseArg;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class POnUseGiftCardTimeout extends LogicProcedure
/*    */ {
/*    */   private final GiftCardUseArg arg;
/*    */   
/*    */   public POnUseGiftCardTimeout(GiftCardUseArg arg)
/*    */   {
/* 12 */     this.arg = arg;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 18 */     CSProviderManager.onUseGiftCardTimeout(this.arg);
/* 19 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\csprovider\main\POnUseGiftCardTimeout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */