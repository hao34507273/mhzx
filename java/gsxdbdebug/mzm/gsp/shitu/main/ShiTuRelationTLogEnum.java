/*    */ package mzm.gsp.shitu.main;
/*    */ 
/*    */ public enum ShiTuRelationTLogEnum
/*    */ {
/*  5 */   SHOU_TU(0),  CHU_SHI(-1),  MASTER_FORCE_RELIEVE(-2),  APPRENTICE_FORCE_RELIECE(-3);
/*    */   
/*    */   private final int operator;
/*    */   
/*    */   private ShiTuRelationTLogEnum(int operator) {
/* 10 */     this.operator = operator;
/*    */   }
/*    */   
/*    */   public int getOperator()
/*    */   {
/* 15 */     return this.operator;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\shitu\main\ShiTuRelationTLogEnum.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */