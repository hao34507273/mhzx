/*    */ package mzm.gsp.effect.fighter;
/*    */ 
/*    */ import mzm.gsp.effect.main.FighterEffect;
/*    */ import mzm.gsp.effect.main.FighterEffectGroup;
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ import mzm.gsp.skill.main.Skill;
/*    */ 
/*    */ public class AngerRateOnce extends FighterEffect implements mzm.gsp.effect.fighter.Interface.OpOnce
/*    */ {
/*    */   private int angerrate;
/*    */   private int angerratemax;
/*    */   
/*    */   public AngerRateOnce(int angerrate, int angerratemax)
/*    */   {
/* 15 */     this.angerrate = angerrate;
/* 16 */     this.angerratemax = angerratemax;
/*    */   }
/*    */   
/*    */   public boolean perform(Skill skill, FighterEffectGroup effectGroup, Fighter releaser, Fighter target)
/*    */   {
/* 21 */     int angermax = target.getMaxAnger();
/* 22 */     int changeValue = 0;
/* 23 */     if (this.angerrate > this.angerratemax) {
/* 24 */       changeValue = angermax * this.angerratemax;
/*    */     } else {
/* 26 */       changeValue = angermax * this.angerrate;
/*    */     }
/* 28 */     target.addAnger(changeValue);
/* 29 */     skill.addAngerRet(releaser, target, changeValue, false);
/* 30 */     return true;
/*    */   }
/*    */   
/*    */   public boolean attach(Fighter fighter)
/*    */   {
/* 35 */     return true;
/*    */   }
/*    */   
/*    */   public boolean detach(Fighter fighter)
/*    */   {
/* 40 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\AngerRateOnce.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */