/*    */ package mzm.gsp.role.main.expression.impl;
/*    */ 
/*    */ import mzm.gsp.role.main.expression.IExpression;
/*    */ 
/*    */ public class RoleBasePropertyAddNoModifyValue implements IExpression
/*    */ {
/*    */   private int addValue;
/*    */   
/*    */   public RoleBasePropertyAddNoModifyValue(double addValue) {
/* 10 */     this.addValue = ((int)addValue);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public int execute(Object... param)
/*    */   {
/* 17 */     if (((Integer)param[0]).intValue() == 1) {
/* 18 */       return 0;
/*    */     }
/* 20 */     return this.addValue;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\main\expression\impl\RoleBasePropertyAddNoModifyValue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */