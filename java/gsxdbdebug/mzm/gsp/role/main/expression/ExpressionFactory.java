/*    */ package mzm.gsp.role.main.expression;
/*    */ 
/*    */ import java.lang.reflect.Constructor;
/*    */ import java.util.List;
/*    */ 
/*    */ public class ExpressionFactory
/*    */ {
/*  8 */   private static String packageName = "mzm.gsp.role.main.expression.impl.";
/*    */   
/*    */   public static IExpression createExpression(String clsName, List<Double> params) throws Exception
/*    */   {
/* 12 */     Class cls = null;
/*    */     try {
/* 14 */       cls = Class.forName(packageName + clsName);
/*    */     } catch (Exception e) {
/* 16 */       cls = Class.forName(clsName);
/*    */     }
/* 18 */     if (!IExpression.class.isAssignableFrom(cls)) {
/* 19 */       throw new Exception("类型错误:" + clsName);
/*    */     }
/*    */     
/* 22 */     Constructor[] consts = cls.getConstructors();
/* 23 */     IExpression expr = null;
/* 24 */     Constructor[] arr$ = consts;int len$ = arr$.length;int i$ = 0; if (i$ < len$) { Constructor c = arr$[i$];
/*    */       
/* 26 */       Class[] paramsTypes = c.getParameterTypes();
/* 27 */       Object[] realParam = new Double[paramsTypes.length];
/* 28 */       for (int i = 0; i < realParam.length; i++) {
/* 29 */         realParam[i] = params.get(i);
/*    */       }
/* 31 */       expr = (IExpression)c.newInstance(realParam);
/*    */     }
/*    */     
/* 34 */     return expr;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\main\expression\ExpressionFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */