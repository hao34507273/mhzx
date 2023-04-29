/*    */ package mzm.gsp.csprovider.main;
/*    */ 
/*    */ import csprovider.GiftCardUseArg;
/*    */ import csprovider.GiftCardUseRes;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class POnUseGiftCardAck extends LogicProcedure
/*    */ {
/*    */   private final GiftCardUseArg arg;
/*    */   private final GiftCardUseRes res;
/*    */   
/*    */   public POnUseGiftCardAck(GiftCardUseArg arg, GiftCardUseRes res)
/*    */   {
/* 14 */     this.arg = arg;
/* 15 */     this.res = res;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 21 */     CSProviderManager.onUseGiftCardAck(this.arg, this.res);
/* 22 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\csprovider\main\POnUseGiftCardAck.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */