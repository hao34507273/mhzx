/*    */ package mzm.gsp.redgift.main;
/*    */ 
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class POnRedgiftEnd
/*    */   extends LogicProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 14 */     if (RedGiftManager.isRedGiftFunOpen()) {
/* 15 */       return false;
/*    */     }
/* 17 */     RedGiftManager.onRedgiftEnd();
/* 18 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\redgift\main\POnRedgiftEnd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */