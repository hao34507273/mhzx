/*    */ package mzm.gsp.market.main;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public enum MarketOperateEnum
/*    */ {
/* 12 */   SELL_ITEM(1), 
/* 13 */   RESELL_ITEM(2), 
/* 14 */   SELL_PET(3), 
/* 15 */   RESELL_PET(4), 
/* 16 */   SYS_SELL_ITEM(5), 
/* 17 */   SYS_SELL_PET(6);
/*    */   
/*    */   public final int value;
/*    */   
/*    */   private MarketOperateEnum(int value) {
/* 22 */     this.value = value;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\market\main\MarketOperateEnum.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */