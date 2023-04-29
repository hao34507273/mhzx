/*    */ package mzm.gsp.effect.fighter;
/*    */ 
/*    */ import mzm.gsp.effect.main.FighterEffect;
/*    */ import mzm.gsp.effect.main.FighterEffectGroup;
/*    */ import mzm.gsp.fight.handle.BeforeAttackHandle.InputObj;
/*    */ import mzm.gsp.fight.handle.BeforeAttackHandle.OutputObj;
/*    */ import mzm.gsp.fight.main.FightArgs;
/*    */ import mzm.gsp.fight.main.FightUtil.DamageInputObj;
/*    */ import mzm.gsp.fight.main.FightUtil.DamageOutputObj;
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ import mzm.gsp.skill.main.Skill;
/*    */ 
/*    */ public class DamageBiggerOnce extends FighterEffect implements mzm.gsp.effect.fighter.Interface.OpOnce
/*    */ {
/*    */   private int targethprate;
/*    */   private int damagerate;
/*    */   private int exdamagerate;
/*    */   
/*    */   public DamageBiggerOnce(int targethprate, int damagerate, int exdamagerate)
/*    */   {
/* 21 */     this.targethprate = targethprate;
/* 22 */     this.damagerate = damagerate;
/* 23 */     if (targethprate <= 0) {
/* 24 */       throw new RuntimeException("DamageBiggerOnce目标每减少的血量万分比不能小于等于0");
/*    */     }
/* 26 */     this.exdamagerate = exdamagerate;
/*    */   }
/*    */   
/*    */   public boolean attach(Fighter fighter)
/*    */   {
/* 31 */     return true;
/*    */   }
/*    */   
/*    */   public boolean detach(Fighter fighter)
/*    */   {
/* 36 */     return true;
/*    */   }
/*    */   
/*    */   public boolean perform(Skill skill, FighterEffectGroup effectGroup, Fighter releaser, Fighter target)
/*    */   {
/* 41 */     int cutHpRate = (int)(FightArgs.getInstance().getDefaultRate() - target.getCurHpRateValue());
/* 42 */     int count = Math.max(0, cutHpRate / this.targethprate);
/*    */     
/* 44 */     BeforeAttackHandle.OutputObj outputObj = releaser.handleBeforeAttack(new BeforeAttackHandle.InputObj(releaser, target, skill));
/*    */     
/* 46 */     BeforeAttackHandle.OutputObj tagertOutputObj = target.handleBeforeAttack(new BeforeAttackHandle.InputObj(releaser, target, skill));
/*    */     
/* 48 */     outputObj.damageRate += this.exdamagerate;
/* 49 */     outputObj.biggerDamageCount += count;
/* 50 */     outputObj.biggerDamageRate += this.damagerate;
/*    */     
/* 52 */     FightUtil.DamageInputObj damageInputObj = new FightUtil.DamageInputObj(outputObj, tagertOutputObj, releaser, target, skill, effectGroup);
/*    */     
/*    */ 
/* 55 */     FightUtil.DamageOutputObj damageOutputObj = new FightUtil.DamageOutputObj();
/* 56 */     mzm.gsp.fight.main.FightUtil.handleCommonDamage(damageInputObj, damageOutputObj);
/*    */     
/* 58 */     return damageOutputObj.isHit;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\DamageBiggerOnce.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */