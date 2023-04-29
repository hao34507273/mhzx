/*    */ package mzm.gsp.effect.fighter;
/*    */ 
/*    */ import mzm.gsp.effect.main.FighterEffect;
/*    */ import mzm.gsp.fight.handle.BeforeHealHandle;
/*    */ import mzm.gsp.fight.handle.BeforeHealHandle.InputObj;
/*    */ import mzm.gsp.fight.handle.BeforeHealHandle.OutputObj;
/*    */ import mzm.gsp.fight.main.FightArgs;
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ import mzm.gsp.skill.main.Skill;
/*    */ import mzm.gsp.skill.main.SkillInterface;
/*    */ 
/*    */ public class Mercy extends FighterEffect implements BeforeHealHandle
/*    */ {
/*    */   private int hprate;
/*    */   private int exhealrate;
/*    */   
/*    */   public Mercy(int hprate, int exhealrate)
/*    */   {
/* 19 */     this.hprate = hprate;
/* 20 */     this.exhealrate = exhealrate;
/*    */   }
/*    */   
/*    */   public boolean attach(Fighter fighter)
/*    */   {
/* 25 */     fighter.addBeforeHealHandle(this);
/* 26 */     return true;
/*    */   }
/*    */   
/*    */   public boolean detach(Fighter fighter)
/*    */   {
/* 31 */     fighter.remBeforeHealHandle(this);
/* 32 */     return true;
/*    */   }
/*    */   
/*    */   public void handleBeforeHeal(BeforeHealHandle.InputObj inputObj, BeforeHealHandle.OutputObj outputObj)
/*    */   {
/* 37 */     Skill skill = inputObj.getSkill();
/* 38 */     if (skill == null) {
/* 39 */       return;
/*    */     }
/* 41 */     boolean isHealSkill = SkillInterface.isSkillEffectType(skill.getID(), 7);
/* 42 */     if (!isHealSkill) {
/* 43 */       return;
/*    */     }
/* 45 */     Fighter targetFighter = inputObj.getTarget();
/* 46 */     if (targetFighter == null) {
/* 47 */       return;
/*    */     }
/* 49 */     double curHpRate = targetFighter.getCurHpRateValue();
/* 50 */     double lostHpRate = FightArgs.getInstance().getDefaultRate() - curHpRate;
/* 51 */     if (this.hprate <= lostHpRate) {
/* 52 */       outputObj.healeffectrate += this.exhealrate;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\Mercy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */