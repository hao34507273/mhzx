/*    */ package mzm.gsp.roledye.main;
/*    */ 
/*    */ public enum RoleDyeTlogEnum
/*    */ {
/*  5 */   ADD(1),  USE(2),  DELETE(3);
/*    */   
/*    */   private final int operator;
/*    */   
/*    */   private RoleDyeTlogEnum(int operator) {
/* 10 */     this.operator = operator;
/*    */   }
/*    */   
/*    */   public int getOperator()
/*    */   {
/* 15 */     return this.operator;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\roledye\main\RoleDyeTlogEnum.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */