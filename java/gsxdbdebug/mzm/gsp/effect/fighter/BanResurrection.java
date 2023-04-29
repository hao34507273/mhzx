/*    */ package mzm.gsp.effect.fighter;
/*    */ 
/*    */ import mzm.gsp.fight.handle.BeforeAttackHandle.InputObj;
/*    */ import mzm.gsp.fight.handle.BeforeAttackHandle.OutputObj;
/*    */ import mzm.gsp.fight.main.FightUtil.DamageInputObj;
/*    */ import mzm.gsp.fight.main.FightUtil.DamageOutputObj;
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ import mzm.gsp.skill.main.Skill;
/*    */ 
/*    */ public class BanResurrection extends mzm.gsp.effect.main.FighterEffect implements mzm.gsp.effect.fighter.Interface.OpOnce
/*    */ {
/*    */   private int damagerate;
/*    */   private int bedamagerate;
/*    */   
/*    */   public BanResurrection(int damagerate, int bedamagerate)
/*    */   {
/* 17 */     this.damagerate = damagerate;
/* 18 */     this.bedamagerate = bedamagerate;
/*    */   }
/*    */   
/*    */   public boolean perform(Skill skill, mzm.gsp.effect.main.FighterEffectGroup effectGroup, Fighter releaser, Fighter target)
/*    */   {
/* 23 */     BeforeAttackHandle.OutputObj outputObj = releaser.handleBeforeAttack(new BeforeAttackHandle.InputObj(releaser, target, skill));
/*    */     
/* 25 */     BeforeAttackHandle.OutputObj tagertOutputObj = target.handleBeforeAttack(new BeforeAttackHandle.InputObj(releaser, target, skill));
/*    */     
/* 27 */     outputObj.damageRate += this.damagerate;
/*    */     
/* 29 */     FightUtil.DamageInputObj damageInputObj = new FightUtil.DamageInputObj(outputObj, tagertOutputObj, releaser, target, skill, effectGroup);
/*    */     
/* 31 */     damageInputObj.bedamagerateToSelf += this.bedamagerate;
/*    */     
/* 33 */     FightUtil.DamageOutputObj damageOutputObj = new FightUtil.DamageOutputObj();
/* 34 */     mzm.gsp.fight.main.FightUtil.handleCommonDamage(damageInputObj, damageOutputObj);
/*    */     
/* 36 */     return damageOutputObj.isHit;
/*    */   }
/*    */   
/*    */   public boolean attach(Fighter fighter)
/*    */   {
/* 41 */     return true;
/*    */   }
/*    */   
/*    */   public boolean detach(Fighter fighter)
/*    */   {
/* 46 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\BanResurrection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */