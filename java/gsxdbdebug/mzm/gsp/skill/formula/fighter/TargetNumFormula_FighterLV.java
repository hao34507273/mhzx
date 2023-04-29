/*    */ package mzm.gsp.skill.formula.fighter;
/*    */ 
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ 
/*    */ public class TargetNumFormula_FighterLV implements SkillFormula
/*    */ {
/*    */   private double param1;
/*    */   private double param2;
/*    */   private double param3;
/*    */   private double param4;
/*    */   
/*    */   public TargetNumFormula_FighterLV(double param1, double param2, double param3, double param4) {
/* 13 */     this.param1 = param1;
/* 14 */     this.param2 = param2;
/* 15 */     this.param3 = param3;
/* 16 */     this.param4 = param4;
/*    */   }
/*    */   
/*    */   public int calc(mzm.gsp.skill.main.Skill skill, Fighter fighter)
/*    */   {
/* 21 */     int fighterLv = fighter.getLevel();
/* 22 */     int ret = (int)(fighterLv * fighterLv * this.param1 + fighterLv * this.param2 + this.param3);
/* 23 */     return (int)Math.min(ret, this.param4);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\skill\formula\fighter\TargetNumFormula_FighterLV.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */