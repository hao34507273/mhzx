/*    */ package mzm.gsp.skill.formula.fighter;
/*    */ 
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ import mzm.gsp.skill.main.Skill;
/*    */ 
/*    */ public class RandomRangeSKillLVFormula implements SkillFormula
/*    */ {
/*    */   private double param1;
/*    */   private double param2;
/*    */   private double param3;
/*    */   private double param4;
/*    */   
/*    */   public RandomRangeSKillLVFormula(double param1, double param2, double param3, double param4)
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
/* 24 */     int from = (int)(skillLv * this.param1 + this.param2);
/* 25 */     int end = (int)(skillLv * this.param3 + this.param4);
/* 26 */     if ((from <= 0) || (end <= 0)) {
/* 27 */       return 1;
/*    */     }
/*    */     
/* 30 */     if (from == end) {
/* 31 */       return from;
/*    */     }
/*    */     
/* 34 */     if (from > end) {
/* 35 */       int tmp = from;
/* 36 */       from = end;
/* 37 */       end = tmp;
/*    */     }
/*    */     
/* 40 */     return from + xdb.Xdb.random().nextInt(end - from + 1);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\skill\formula\fighter\RandomRangeSKillLVFormula.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */