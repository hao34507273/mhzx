/*    */ package mzm.gsp.role.main.expression.impl;
/*    */ 
/*    */ import mzm.gsp.role.main.expression.IExpression;
/*    */ 
/*    */ public class RoleBasePropertyAddPerLevelExprImpl implements IExpression
/*    */ {
/*    */   private Integer a;
/*    */   private Integer b;
/*    */   private Integer c;
/*    */   
/*    */   public RoleBasePropertyAddPerLevelExprImpl(double a, double b, double c) {
/* 12 */     this.a = Integer.valueOf((int)a);
/* 13 */     this.b = Integer.valueOf((int)b);
/* 14 */     this.c = Integer.valueOf((int)c);
/*    */   }
/*    */   
/*    */   public int execute(Object... param)
/*    */   {
/* 19 */     Integer level = (Integer)param[0];
/*    */     
/* 21 */     if (level.intValue() == 1) {
/* 22 */       return 0;
/*    */     }
/* 24 */     return (level.intValue() % this.a.intValue() == 0 ? this.b : this.c).intValue();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\main\expression\impl\RoleBasePropertyAddPerLevelExprImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */