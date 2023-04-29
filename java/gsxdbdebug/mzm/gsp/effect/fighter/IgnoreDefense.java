/*    */ package mzm.gsp.effect.fighter;
/*    */ 
/*    */ import mzm.gsp.fight.handle.BeforeAttackHandle.InputObj;
/*    */ import mzm.gsp.fight.handle.BeforeAttackHandle.OutputObj;
/*    */ import mzm.gsp.fight.main.FightUtil.DamageInputObj;
/*    */ import mzm.gsp.fight.main.FightUtil.DamageOutputObj;
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ import mzm.gsp.skill.main.Skill;
/*    */ 
/*    */ public class IgnoreDefense extends mzm.gsp.effect.main.FighterEffect implements mzm.gsp.effect.fighter.Interface.OpOnce
/*    */ {
/*    */   private int exatk;
/*    */   private int exdamagerate;
/*    */   private int ignoredefense;
/*    */   
/*    */   public IgnoreDefense(int exatk, int exdamagerate, int ignoredefense)
/*    */   {
/* 18 */     this.exatk = exatk;
/* 19 */     this.exdamagerate = exdamagerate;
/* 20 */     this.ignoredefense = ignoredefense;
/*    */   }
/*    */   
/*    */   public boolean perform(Skill skill, mzm.gsp.effect.main.FighterEffectGroup effectGroup, Fighter releaser, Fighter target)
/*    */   {
/* 25 */     BeforeAttackHandle.OutputObj outputObj = releaser.handleBeforeAttack(new BeforeAttackHandle.InputObj(releaser, target, skill));
/*    */     
/* 27 */     BeforeAttackHandle.OutputObj tagertOutputObj = target.handleBeforeAttack(new BeforeAttackHandle.InputObj(releaser, target, skill));
/*    */     
/* 29 */     outputObj.damageRate += this.exdamagerate;
/* 30 */     outputObj.exaAtk += this.exatk;
/* 31 */     outputObj.phyPenetration += this.ignoredefense;
/* 32 */     outputObj.mgcPenetration += this.ignoredefense;
/*    */     
/* 34 */     FightUtil.DamageInputObj damageInputObj = new FightUtil.DamageInputObj(outputObj, tagertOutputObj, releaser, target, skill, effectGroup);
/*    */     
/*    */ 
/* 37 */     FightUtil.DamageOutputObj damageOutputObj = new FightUtil.DamageOutputObj();
/* 38 */     mzm.gsp.fight.main.FightUtil.handleCommonDamage(damageInputObj, damageOutputObj);
/*    */     
/* 40 */     return damageOutputObj.isHit;
/*    */   }
/*    */   
/*    */   public boolean attach(Fighter fighter)
/*    */   {
/* 45 */     return true;
/*    */   }
/*    */   
/*    */   public boolean detach(Fighter fighter)
/*    */   {
/* 50 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\IgnoreDefense.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */