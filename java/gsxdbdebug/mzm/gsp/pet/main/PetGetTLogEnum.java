/*    */ package mzm.gsp.pet.main;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public enum PetGetTLogEnum
/*    */ {
/*  8 */   SHOP_BUY(1), 
/*  9 */   MARKET_BUY(2), 
/* 10 */   FIELD_CATCH(3), 
/* 11 */   SHENSHOU_NPC(4), 
/* 12 */   MOSHOU_NPC(5), 
/* 13 */   FANSHENG_GET(6), 
/* 14 */   PET_ITEM_BAG(7), 
/* 15 */   MARKET_BACK(8);
/*    */   
/*    */   public final int value;
/*    */   
/* 19 */   private PetGetTLogEnum(int value) { this.value = value; }
/*    */   
/*    */ 
/*    */   public String toString()
/*    */   {
/* 24 */     return this.value + "";
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pet\main\PetGetTLogEnum.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */