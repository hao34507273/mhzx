/*    */ package mzm.gsp.skill.formula.outfight;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Random;
/*    */ import mzm.gsp.common.IOutFightObject;
/*    */ import mzm.gsp.effect.confbean.SOutFightEffectFormula;
/*    */ import mzm.gsp.skill.main.OutFightSkill;
/*    */ import xdb.Xdb;
/*    */ 
/*    */ public class SkillLVEffectRandom implements FormulaFunction
/*    */ {
/*    */   private float p1;
/*    */   private float p2;
/*    */   private float p3;
/*    */   private float p4;
/*    */   
/*    */   public SkillLVEffectRandom(SOutFightEffectFormula cfg)
/*    */   {
/* 19 */     if (cfg.params.size() != 4) {
/* 20 */       throw new RuntimeException("skill param size error ! id  ");
/*    */     }
/* 22 */     this.p1 = ((Double)cfg.params.get(0)).floatValue();
/* 23 */     this.p2 = ((Double)cfg.params.get(1)).floatValue();
/* 24 */     this.p3 = ((Double)cfg.params.get(2)).floatValue();
/* 25 */     this.p4 = ((Double)cfg.params.get(3)).floatValue();
/*    */   }
/*    */   
/*    */   public int calc(IOutFightObject object, OutFightSkill skill)
/*    */   {
/* 30 */     int skillLv = skill.getLevel();
/* 31 */     int random = Xdb.random().nextInt(1);
/* 32 */     if (random == 1) {
/* 33 */       return (int)(skillLv * this.p1 + this.p2);
/*    */     }
/* 35 */     return (int)(skillLv * this.p3 + this.p4);
/*    */   }
/*    */   
/*    */   public int calcWithParams(int baseLevel, int attachLevel)
/*    */   {
/* 40 */     return (int)(baseLevel * this.p1 + attachLevel * this.p2 + this.p3);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\skill\formula\outfight\SkillLVEffectRandom.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */