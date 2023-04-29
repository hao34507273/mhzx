/*    */ package mzm.gsp.qingyuan.main;
/*    */ 
/*    */ public enum QingYuanRelationTLogEnum
/*    */ {
/*  5 */   MAKE_QING_YUANI(1), 
/*  6 */   RELIEVE_QING_YUAN(2), 
/*  7 */   QING_YUAN_PROMOTION(3);
/*    */   
/*    */   private final int operator;
/*    */   
/*    */   private QingYuanRelationTLogEnum(int operator) {
/* 12 */     this.operator = operator;
/*    */   }
/*    */   
/*    */   public int getOperator()
/*    */   {
/* 17 */     return this.operator;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\qingyuan\main\QingYuanRelationTLogEnum.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */