/*    */ package mzm.gsp.skill.formula.outfight;
/*    */ 
/*    */ import java.lang.reflect.Constructor;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.effect.confbean.SOutFightEffectFormula;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class FormulaFunctionFactory
/*    */ {
/*    */   private static final String pkg = "mzm.gsp.skill.formula.outfight.";
/* 18 */   private static Map<Integer, FormulaFunction> functionMap = new HashMap();
/*    */   
/*    */   public static void init() {
/* 21 */     for (SOutFightEffectFormula formula : SOutFightEffectFormula.getAll().values()) {
/*    */       try
/*    */       {
/* 24 */         Class cls = Class.forName("mzm.gsp.skill.formula.outfight." + formula.className);
/*    */         
/* 26 */         Constructor constructor = cls.getConstructors()[0];
/* 27 */         FormulaFunction formulaFunction = (FormulaFunction)constructor.newInstance(new Object[] { formula });
/* 28 */         functionMap.put(Integer.valueOf(formula.id), formulaFunction);
/*    */       } catch (Exception e) {
/* 30 */         throw new RuntimeException("create outfight formula exception!", e);
/*    */       }
/*    */     }
/* 33 */     SOutFightEffectFormula.getAll().clear();
/*    */   }
/*    */   
/*    */   public static FormulaFunction getFormula(int id)
/*    */   {
/* 38 */     return (FormulaFunction)functionMap.get(Integer.valueOf(id));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\skill\formula\outfight\FormulaFunctionFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */