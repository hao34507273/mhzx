/*    */ package mzm.gsp.effect.fighter;
/*    */ 
/*    */ import mzm.gsp.fight.handle.BeforeAttackHandle.InputObj;
/*    */ import mzm.gsp.fight.handle.BeforeAttackHandle.OutputObj;
/*    */ import mzm.gsp.fight.main.FightUtil.DamageInputObj;
/*    */ import mzm.gsp.fight.main.FightUtil.DamageOutputObj;
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ import mzm.gsp.skill.main.Skill;
/*    */ 
/*    */ public class CriticalStrikes extends mzm.gsp.effect.main.FighterEffect implements mzm.gsp.effect.fighter.Interface.OpOnce
/*    */ {
/*    */   private int exatk;
/*    */   private int exdamagerate;
/*    */   private int excriticalrate;
/*    */   
/*    */   public CriticalStrikes(int exatk, int exdamagerate, int exdcriticalrate)
/*    */   {
/* 18 */     this.exatk = exatk;
/* 19 */     this.exdamagerate = exdamagerate;
/* 20 */     this.excriticalrate = exdcriticalrate;
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
/* 31 */     outputObj.excriticalrate += this.excriticalrate;
/*    */     
/* 33 */     FightUtil.DamageInputObj damageInputObj = new FightUtil.DamageInputObj(outputObj, tagertOutputObj, releaser, target, skill, effectGroup);
/*    */     
/*    */ 
/* 36 */     FightUtil.DamageOutputObj damageOutputObj = new FightUtil.DamageOutputObj();
/* 37 */     mzm.gsp.fight.main.FightUtil.handleCommonDamage(damageInputObj, damageOutputObj);
/*    */     
/* 39 */     return damageOutputObj.isHit;
/*    */   }
/*    */   
/*    */   public boolean attach(Fighter fighter)
/*    */   {
/* 44 */     return true;
/*    */   }
/*    */   
/*    */   public boolean detach(Fighter fighter)
/*    */   {
/* 49 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\CriticalStrikes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */