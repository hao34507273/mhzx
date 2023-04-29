/*    */ package mzm.gsp.shanghui.main;
/*    */ 
/*    */ import mzm.gsp.open.main.OpenInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PBuyItemSelecter
/*    */   extends LogicProcedure
/*    */ {
/*    */   private long roleId;
/*    */   private int itemId;
/*    */   private int itemNum;
/*    */   private long curGold;
/*    */   
/*    */   public PBuyItemSelecter(long roleId, int itemId, int itemNum, long curGold)
/*    */   {
/* 24 */     this.roleId = roleId;
/* 25 */     this.itemNum = itemNum;
/* 26 */     this.itemId = itemId;
/* 27 */     this.curGold = curGold;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 33 */     if (!OpenInterface.getOpenStatus(500))
/*    */     {
/* 35 */       return new PBuyItemReq(this.roleId, this.itemId, this.itemNum, this.curGold).call();
/*    */     }
/* 37 */     return new PBuyItemReqMulti(this.roleId, this.itemId, this.itemNum, this.curGold).call();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\shanghui\main\PBuyItemSelecter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */