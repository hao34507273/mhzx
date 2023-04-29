/*    */ package mzm.gsp.effect.fighter;
/*    */ 
/*    */ import mzm.gsp.fight.handle.BeforeAttackHandle.InputObj;
/*    */ import mzm.gsp.fight.handle.BeforeAttackHandle.OutputObj;
/*    */ import mzm.gsp.fight.main.FightUtil.DamageInputObj;
/*    */ import mzm.gsp.fight.main.FightUtil.DamageOutputObj;
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ import mzm.gsp.skill.main.Skill;
/*    */ 
/*    */ public class Damage extends mzm.gsp.effect.main.FighterEffect implements mzm.gsp.effect.fighter.Interface.OpOnce
/*    */ {
/*    */   private int exatk;
/*    */   private int exatkrate;
/*    */   private int skillDamageRate;
/*    */   private int skillDamageRateMax;
/*    */   private int fixDamage;
/*    */   
/*    */   public Damage(int exatk, int exatkrate, int skillDamageRate, int skillDamageRateMax, int fixDamage)
/*    */   {
/* 20 */     this.exatk = exatk;
/* 21 */     this.exatkrate = exatkrate;
/* 22 */     this.skillDamageRate = skillDamageRate;
/* 23 */     this.skillDamageRateMax = skillDamageRateMax;
/* 24 */     this.fixDamage = fixDamage;
/*    */     
/* 26 */     if (this.skillDamageRate >= this.skillDamageRateMax) {
/* 27 */       this.skillDamageRate = this.skillDamageRateMax;
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean perform(Skill skill, mzm.gsp.effect.main.FighterEffectGroup effectGroup, Fighter releaser, Fighter target)
/*    */   {
/* 34 */     BeforeAttackHandle.OutputObj outputObj = releaser.handleBeforeAttack(new BeforeAttackHandle.InputObj(releaser, target, skill));
/*    */     
/* 36 */     BeforeAttackHandle.OutputObj tagertOutputObj = target.handleBeforeAttack(new BeforeAttackHandle.InputObj(releaser, target, skill));
/*    */     
/* 38 */     outputObj.skillDamageRate += this.skillDamageRate;
/* 39 */     outputObj.exaAtk += this.exatk;
/* 40 */     outputObj.exaAtkRate += this.exatkrate;
/* 41 */     outputObj.fixDamage += this.fixDamage;
/*    */     
/* 43 */     FightUtil.DamageInputObj damageInputObj = new FightUtil.DamageInputObj(outputObj, tagertOutputObj, releaser, target, skill, effectGroup);
/*    */     
/*    */ 
/* 46 */     FightUtil.DamageOutputObj damageOutputObj = new FightUtil.DamageOutputObj();
/* 47 */     mzm.gsp.fight.main.FightUtil.handleCommonDamage(damageInputObj, damageOutputObj);
/*    */     
/* 49 */     return damageOutputObj.isHit;
/*    */   }
/*    */   
/*    */   public boolean attach(Fighter fighter)
/*    */   {
/* 54 */     return true;
/*    */   }
/*    */   
/*    */   public boolean detach(Fighter fighter)
/*    */   {
/* 59 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\Damage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */