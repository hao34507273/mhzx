/*    */ package mzm.gsp.csprovider.main;
/*    */ 
/*    */ import csprovider.ActiveCardUseArg;
/*    */ import csprovider.ActiveCardUseRes;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class POnUseActivateCardAck extends LogicProcedure
/*    */ {
/*    */   private final ActiveCardUseArg arg;
/*    */   private final ActiveCardUseRes res;
/*    */   
/*    */   public POnUseActivateCardAck(ActiveCardUseArg arg, ActiveCardUseRes res)
/*    */   {
/* 14 */     this.arg = arg;
/* 15 */     this.res = res;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 21 */     CSProviderManager.onUseActivateCardAck(this.arg, this.res);
/* 22 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\csprovider\main\POnUseActivateCardAck.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */