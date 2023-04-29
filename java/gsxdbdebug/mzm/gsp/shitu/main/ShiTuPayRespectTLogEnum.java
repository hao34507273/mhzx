/*    */ package mzm.gsp.shitu.main;
/*    */ 
/*    */ public enum ShiTuPayRespectTLogEnum
/*    */ {
/*  5 */   APPRENTICE_PAY_RESPECT(1),  MASTER_AGREE(2),  MASTER_REFUSE(3),  PAY_RESPECT_TIME_OUT(4);
/*    */   
/*    */   private final int operator;
/*    */   
/*    */   private ShiTuPayRespectTLogEnum(int operator) {
/* 10 */     this.operator = operator;
/*    */   }
/*    */   
/*    */   public int getOperator()
/*    */   {
/* 15 */     return this.operator;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\shitu\main\ShiTuPayRespectTLogEnum.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */