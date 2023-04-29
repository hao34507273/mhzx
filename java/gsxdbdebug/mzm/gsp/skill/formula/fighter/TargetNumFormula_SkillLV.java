/*    */ package mzm.gsp.skill.formula.fighter;
/*    */ 
/*    */ import mzm.gsp.skill.main.Skill;
/*    */ 
/*    */ public class TargetNumFormula_SkillLV implements SkillFormula
/*    */ {
/*    */   private double param1;
/*    */   private double param2;
/*    */   private double param3;
/*    */   private double param4;
/*    */   
/*    */   public TargetNumFormula_SkillLV(double param1, double param2, double param3, double param4)
/*    */   {
/* 14 */     this.param1 = param1;
/* 15 */     this.param2 = param2;
/* 16 */     this.param3 = param3;
/* 17 */     this.param4 = param4;
/*    */   }
/*    */   
/*    */   public int calc(Skill skill, mzm.gsp.fight.main.Fighter fighter)
/*    */   {
/* 22 */     int skillLv = skill.getLevel();
/* 23 */     int ret = (int)(skillLv * skillLv * this.param1 + skillLv * this.param2 + this.param3);
/* 24 */     return (int)Math.min(ret, this.param4);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\skill\formula\fighter\TargetNumFormula_SkillLV.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */