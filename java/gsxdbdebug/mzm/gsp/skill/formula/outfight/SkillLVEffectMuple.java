/*    */ package mzm.gsp.skill.formula.outfight;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import mzm.gsp.common.IOutFightObject;
/*    */ import mzm.gsp.effect.confbean.SOutFightEffectFormula;
/*    */ import mzm.gsp.skill.main.OutFightSkill;
/*    */ 
/*    */ 
/*    */ public class SkillLVEffectMuple
/*    */   implements FormulaFunction
/*    */ {
/*    */   private double p1;
/*    */   private double p2;
/*    */   private double p3;
/*    */   
/*    */   public SkillLVEffectMuple(SOutFightEffectFormula formula)
/*    */   {
/* 18 */     if (formula.params.size() != 3) {
/* 19 */       throw new RuntimeException("param size not equal 3");
/*    */     }
/* 21 */     this.p1 = ((Double)formula.params.get(0)).doubleValue();
/* 22 */     this.p2 = ((Double)formula.params.get(1)).doubleValue();
/* 23 */     this.p3 = ((Double)formula.params.get(2)).doubleValue();
/*    */   }
/*    */   
/*    */   public int calc(IOutFightObject object, OutFightSkill skill)
/*    */   {
/* 28 */     return (int)(skill.getLevel() / this.p1 * this.p2 + this.p3);
/*    */   }
/*    */   
/*    */   public int calcWithParams(int baseLevel, int attachLevel)
/*    */   {
/* 33 */     return (int)(baseLevel * this.p1 + attachLevel * this.p2 + this.p3);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\skill\formula\outfight\SkillLVEffectMuple.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */