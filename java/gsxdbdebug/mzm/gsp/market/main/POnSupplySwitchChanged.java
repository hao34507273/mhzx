/*    */ package mzm.gsp.market.main;
/*    */ 
/*    */ import mzm.gsp.open.event.OpenChangeComplexArg;
/*    */ import mzm.gsp.open.event.OpenChangeProcedure;
/*    */ 
/*    */ public class POnSupplySwitchChanged
/*    */   extends OpenChangeProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 11 */     if (((OpenChangeComplexArg)this.arg).getType() != 318)
/*    */     {
/* 13 */       return false;
/*    */     }
/* 15 */     if (((OpenChangeComplexArg)this.arg).isOpen())
/*    */     {
/* 17 */       MarketManager.tryStartAllSupplyItemSession();
/*    */     }
/*    */     else
/*    */     {
/* 21 */       MarketManager.stopAllSupplyItemSession();
/*    */     }
/*    */     
/* 24 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\market\main\POnSupplySwitchChanged.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */