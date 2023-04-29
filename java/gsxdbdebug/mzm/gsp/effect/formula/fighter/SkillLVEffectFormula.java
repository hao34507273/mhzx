/*    */ package mzm.gsp.effect.formula.fighter;
/*    */ 
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ import mzm.gsp.skill.main.Skill;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SkillLVEffectFormula
/*    */   implements EffectFormula
/*    */ {
/*    */   private double param1;
/*    */   private double param2;
/*    */   private double param3;
/*    */   
/*    */   public SkillLVEffectFormula(double param1, double param2, double param3)
/*    */   {
/* 19 */     this.param1 = param1;
/* 20 */     this.param2 = param2;
/* 21 */     this.param3 = param3;
/*    */   }
/*    */   
/*    */   public int calc(Skill skill, Fighter realser, Fighter targert)
/*    */   {
/* 26 */     int skillLV = skill.getLevel();
/* 27 */     double ret = skillLV * skillLV * this.param1 + skillLV * this.param2 + this.param3;
/* 28 */     return (int)ret;
/*    */   }
/*    */   
/*    */   public int getParamConst()
/*    */   {
/* 33 */     return (int)this.param3;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\formula\fighter\SkillLVEffectFormula.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */