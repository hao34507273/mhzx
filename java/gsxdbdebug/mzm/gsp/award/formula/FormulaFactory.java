/*    */ package mzm.gsp.award.formula;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class FormulaFactory
/*    */ {
/* 11 */   private static Map<String, Formula> nameToFormulaObjMap = new HashMap();
/*    */   
/*    */   public static double calc(long roleId, String formulaClassName, List<Integer> params) {
/* 14 */     Formula formula = (Formula)nameToFormulaObjMap.get(formulaClassName);
/* 15 */     if (formula == null) {
/* 16 */       return -1.0D;
/*    */     }
/* 18 */     return formula.calc(roleId, params);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\award\formula\FormulaFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */