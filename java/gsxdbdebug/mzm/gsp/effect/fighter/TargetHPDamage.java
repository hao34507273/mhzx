/*    */ package mzm.gsp.effect.fighter;
/*    */ 
/*    */ import mzm.gsp.effect.fighter.Interface.OpOnce;
/*    */ import mzm.gsp.effect.main.FighterEffect;
/*    */ import mzm.gsp.effect.main.FighterEffectGroup;
/*    */ import mzm.gsp.fight.handle.BeforeAttackHandle.InputObj;
/*    */ import mzm.gsp.fight.handle.BeforeAttackHandle.OutputObj;
/*    */ import mzm.gsp.fight.main.FightUtil;
/*    */ import mzm.gsp.fight.main.FightUtil.DamageInputObj;
/*    */ import mzm.gsp.fight.main.FightUtil.DamageOutputObj;
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ import mzm.gsp.skill.main.Skill;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class TargetHPDamage
/*    */   extends FighterEffect
/*    */   implements OpOnce
/*    */ {
/*    */   private final int targetLossHp;
/*    */   private final int damageRate;
/*    */   private final int exdamageRate;
/*    */   
/*    */   public TargetHPDamage(int targetLossHp, int damageRate, int exdamagerate)
/*    */   {
/* 31 */     this.targetLossHp = targetLossHp;
/* 32 */     this.damageRate = damageRate;
/* 33 */     this.exdamageRate = exdamagerate;
/*    */   }
/*    */   
/*    */   public boolean attach(Fighter fighter)
/*    */   {
/* 38 */     return true;
/*    */   }
/*    */   
/*    */   public boolean detach(Fighter fighter)
/*    */   {
/* 43 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public boolean perform(Skill skill, FighterEffectGroup effectGroup, Fighter releaser, Fighter target)
/*    */   {
/* 50 */     if (this.targetLossHp <= 0) {
/* 51 */       return true;
/*    */     }
/*    */     
/* 54 */     BeforeAttackHandle.OutputObj outputObj = releaser.handleBeforeAttack(new BeforeAttackHandle.InputObj(releaser, target, skill));
/*    */     
/* 56 */     BeforeAttackHandle.OutputObj tagertOutputObj = target.handleBeforeAttack(new BeforeAttackHandle.InputObj(releaser, target, skill));
/*    */     
/* 58 */     int targetLost = (int)(target.getMaxHp() - target.getHp());
/* 59 */     int count = targetLost / this.targetLossHp;
/* 60 */     if (count > 0) {
/* 61 */       outputObj.damageRate += count * this.damageRate;
/*    */     }
/* 63 */     outputObj.damageRate += this.exdamageRate;
/* 64 */     FightUtil.DamageInputObj damageInputObj = new FightUtil.DamageInputObj(outputObj, tagertOutputObj, releaser, target, skill, effectGroup);
/*    */     
/* 66 */     FightUtil.DamageOutputObj damageOutputObj = new FightUtil.DamageOutputObj();
/* 67 */     FightUtil.handleCommonDamage(damageInputObj, damageOutputObj);
/* 68 */     return damageOutputObj.isHit;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\TargetHPDamage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */