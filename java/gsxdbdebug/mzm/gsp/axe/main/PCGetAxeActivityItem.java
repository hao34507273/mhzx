/*    */ package mzm.gsp.axe.main;
/*    */ 
/*    */ import mzm.gsp.item.main.POfferLotteryResult;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PCGetAxeActivityItem
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   
/*    */   public PCGetAxeActivityItem(long roleid)
/*    */   {
/* 17 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 23 */     return new POfferLotteryResult(this.roleid, 10).call();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\axe\main\PCGetAxeActivityItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */