/*    */ package mzm.gsp.skill.formula.outfight;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import mzm.gsp.common.IOutFightObject;
/*    */ import mzm.gsp.effect.confbean.SOutFightEffectFormula;
/*    */ import mzm.gsp.skill.main.OutFightSkill;
/*    */ 
/*    */ 
/*    */ public class ReleaserLVEffectFormula
/*    */   implements FormulaFunction
/*    */ {
/*    */   private float param1;
/*    */   private float param2;
/*    */   private float param3;
/*    */   
/*    */   public ReleaserLVEffectFormula(SOutFightEffectFormula cfg)
/*    */   {
/* 18 */     if (cfg.params.size() != 3) {
/* 19 */       throw new RuntimeException("outfight ReleaserLVEffectFormula params size must be 3");
/*    */     }
/* 21 */     this.param1 = ((Double)cfg.params.get(0)).floatValue();
/* 22 */     this.param2 = ((Double)cfg.params.get(1)).floatValue();
/* 23 */     this.param3 = ((Double)cfg.params.get(2)).floatValue();
/*    */   }
/*    */   
/*    */   public int calc(IOutFightObject object, OutFightSkill skill)
/*    */   {
/* 28 */     int lv = object.getLevel();
/* 29 */     return (int)(lv * lv * this.param1 + lv * this.param2 + this.param3);
/*    */   }
/*    */   
/*    */   public int calcWithParams(int baseLevel, int attachLevel)
/*    */   {
/* 34 */     return (int)(baseLevel * this.param1 + attachLevel * this.param2 + this.param3);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\skill\formula\outfight\ReleaserLVEffectFormula.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */