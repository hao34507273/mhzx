/*    */ package mzm.gsp.skill.formula.fighter;
/*    */ 
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ import mzm.gsp.skill.main.Skill;
/*    */ 
/*    */ public class RandomSKillLVFormula implements SkillFormula
/*    */ {
/*    */   private double param1;
/*    */   private double param2;
/*    */   private double param3;
/*    */   private double param4;
/*    */   
/*    */   public RandomSKillLVFormula(double param1, double param2, double param3, double param4)
/*    */   {
/* 15 */     this.param1 = param1;
/* 16 */     this.param2 = param2;
/* 17 */     this.param3 = param3;
/* 18 */     this.param4 = param4;
/*    */   }
/*    */   
/*    */   public int calc(Skill skill, Fighter fighter)
/*    */   {
/* 23 */     int skillLv = skill.getLevel();
/* 24 */     int ret1 = (int)(skillLv * this.param1 + this.param2);
/* 25 */     int ret2 = (int)(skillLv * this.param3 + this.param4);
/* 26 */     if (xdb.Xdb.random().nextBoolean()) {
/* 27 */       return ret1;
/*    */     }
/* 29 */     return ret2;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\skill\formula\fighter\RandomSKillLVFormula.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */