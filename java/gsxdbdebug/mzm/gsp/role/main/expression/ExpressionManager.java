/*    */ package mzm.gsp.role.main.expression;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Iterator;
/*    */ import java.util.Map;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.occupation.confbean.SExpressionParam;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ExpressionManager
/*    */ {
/* 13 */   private static ExpressionManager instance = new ExpressionManager();
/*    */   
/* 15 */   private Map<Integer, IExpression> expressionMap = new HashMap();
/*    */   
/*    */ 
/*    */   public static ExpressionManager getInstance()
/*    */   {
/* 20 */     return instance;
/*    */   }
/*    */   
/*    */   public int init() throws Exception {
/* 24 */     Map<Integer, SExpressionParam> expresMap = SExpressionParam.getAll();
/* 25 */     Iterator<Integer> it = expresMap.keySet().iterator();
/* 26 */     while (it.hasNext()) {
/* 27 */       int id = ((Integer)it.next()).intValue();
/* 28 */       SExpressionParam expr = (SExpressionParam)expresMap.get(Integer.valueOf(id));
/* 29 */       IExpression exprAction = ExpressionFactory.createExpression(expr.className, expr.params);
/* 30 */       this.expressionMap.put(Integer.valueOf(id), exprAction);
/*    */     }
/* 32 */     return 0;
/*    */   }
/*    */   
/*    */   public IExpression getExpression(int id) {
/* 36 */     return (IExpression)this.expressionMap.get(Integer.valueOf(id));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\main\expression\ExpressionManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */