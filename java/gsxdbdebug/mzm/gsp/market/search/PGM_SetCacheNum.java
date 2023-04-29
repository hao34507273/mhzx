/*    */ package mzm.gsp.market.search;
/*    */ 
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class PGM_SetCacheNum extends LogicProcedure
/*    */ {
/*    */   private final int itemCacheNum;
/*    */   private final int petCacheNum;
/*    */   
/*    */   public PGM_SetCacheNum(int itemCacheNum, int petCacheNum)
/*    */   {
/* 12 */     this.itemCacheNum = itemCacheNum;
/* 13 */     this.petCacheNum = petCacheNum;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 18 */     if (this.itemCacheNum > 0)
/*    */     {
/* 20 */       MarketSearcherManager.setItemSubIdCacheNum(Math.max(16, this.itemCacheNum));
/*    */     }
/* 22 */     if (this.petCacheNum > 0)
/*    */     {
/* 24 */       MarketSearcherManager.setPetSubIdCacheNum(Math.max(16, this.petCacheNum));
/*    */     }
/* 26 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\market\search\PGM_SetCacheNum.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */