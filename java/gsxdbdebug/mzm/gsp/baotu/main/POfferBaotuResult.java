/*    */ package mzm.gsp.baotu.main;
/*    */ 
/*    */ import mzm.gsp.item.main.POfferLotteryResult;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class POfferBaotuResult
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   
/*    */   public POfferBaotuResult(long roleId)
/*    */   {
/* 19 */     this.roleId = roleId;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 27 */     return new POfferLotteryResult(this.roleId, 0).call();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\baotu\main\POfferBaotuResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */