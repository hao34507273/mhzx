/*    */ package mzm.gsp.redgift.main;
/*    */ 
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class POnStartRedgift
/*    */   extends LogicProcedure
/*    */ {
/*    */   private int redgiftTimeCfgId;
/*    */   
/*    */   POnStartRedgift(int redgiftTimeCfgId)
/*    */   {
/* 15 */     this.redgiftTimeCfgId = redgiftTimeCfgId;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception {
/* 19 */     if (!RedGiftManager.isRedGiftFunOpen()) {
/* 20 */       return false;
/*    */     }
/* 22 */     RedGiftManager.onRedgiftStart(this.redgiftTimeCfgId);
/* 23 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\redgift\main\POnStartRedgift.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */