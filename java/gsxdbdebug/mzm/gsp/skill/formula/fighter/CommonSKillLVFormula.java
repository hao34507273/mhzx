/*    */ package mzm.gsp.skill.formula.fighter;
/*    */ 
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ import mzm.gsp.skill.main.Skill;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CommonSKillLVFormula
/*    */   implements SkillFormula
/*    */ {
/*    */   private double param1;
/*    */   private double param2;
/*    */   private double param3;
/*    */   
/*    */   public CommonSKillLVFormula(double param1, double param2, double param3)
/*    */   {
/* 19 */     this.param1 = param1;
/* 20 */     this.param2 = param2;
/* 21 */     this.param3 = param3;
/*    */   }
/*    */   
/*    */   public int calc(Skill skill, Fighter fighter)
/*    */   {
/* 26 */     int skillLv = skill.getLevel();
/* 27 */     int ret = (int)(skillLv * skillLv * this.param1 + skillLv * this.param2 + this.param3);
/* 28 */     return ret;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\skill\formula\fighter\CommonSKillLVFormula.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */