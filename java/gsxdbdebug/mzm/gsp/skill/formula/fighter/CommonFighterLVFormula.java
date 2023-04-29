/*    */ package mzm.gsp.skill.formula.fighter;
/*    */ 
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ 
/*    */ public class CommonFighterLVFormula implements SkillFormula
/*    */ {
/*    */   private double param1;
/*    */   private double param2;
/*    */   private double param3;
/*    */   
/*    */   public CommonFighterLVFormula(double param1, double param2, double param3) {
/* 12 */     this.param1 = param1;
/* 13 */     this.param2 = param2;
/* 14 */     this.param3 = param3;
/*    */   }
/*    */   
/*    */   public int calc(mzm.gsp.skill.main.Skill skill, Fighter fighter)
/*    */   {
/* 19 */     int fighterLv = fighter.getLevel();
/* 20 */     int ret = (int)(fighterLv * fighterLv * this.param1 + fighterLv * this.param2 + this.param3);
/* 21 */     return ret;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\skill\formula\fighter\CommonFighterLVFormula.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */