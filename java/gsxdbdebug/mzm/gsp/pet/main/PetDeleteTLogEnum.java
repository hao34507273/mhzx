/*    */ package mzm.gsp.pet.main;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public enum PetDeleteTLogEnum
/*    */ {
/*  9 */   SHOP_SELL(1),  MARKET_SELL(2),  RELEASE(3),  FANSHENG(4),  HUASHENG(5),  TASK_COST(6),  GET_MODEL(7),  IDIP_DELETE(8);
/*    */   
/*    */   public final int value;
/*    */   
/*    */   private PetDeleteTLogEnum(int value) {
/* 14 */     this.value = value;
/*    */   }
/*    */   
/*    */ 
/*    */   public String toString()
/*    */   {
/* 20 */     return this.value + "";
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pet\main\PetDeleteTLogEnum.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */