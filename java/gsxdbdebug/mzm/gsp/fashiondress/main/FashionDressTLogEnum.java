/*    */ package mzm.gsp.fashiondress.main;
/*    */ 
/*    */ public enum FashionDressTLogEnum
/*    */ {
/*  5 */   ITEM_UNLOCK(1),  LEVEL_UNLOCK(2),  PUT_ON(3),  TAKE_OFF(4),  EXTEND_TIME(5),  EXPIRED(6);
/*    */   
/*    */   private final int operator;
/*    */   
/*    */   private FashionDressTLogEnum(int operator) {
/* 10 */     this.operator = operator;
/*    */   }
/*    */   
/*    */   public int getOperator()
/*    */   {
/* 15 */     return this.operator;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fashiondress\main\FashionDressTLogEnum.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */