/*    */ package mzm.gsp.effect.fighter;
/*    */ 
/*    */ import mzm.gsp.effect.main.EffectInterface;
/*    */ import mzm.gsp.effect.main.FighterEffectGroup;
/*    */ import mzm.gsp.fight.handle.BeforeAttackHandle.InputObj;
/*    */ import mzm.gsp.fight.handle.BeforeAttackHandle.OutputObj;
/*    */ import mzm.gsp.fight.main.FightUtil.DamageInputObj;
/*    */ import mzm.gsp.fight.main.FightUtil.DamageOutputObj;
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ import mzm.gsp.skill.main.Skill;
/*    */ 
/*    */ public class DamageRandomBuff extends mzm.gsp.effect.main.FighterEffect implements mzm.gsp.effect.fighter.Interface.OpOnce, mzm.gsp.effect.fighter.Interface.Validate
/*    */ {
/*    */   private int modifyDamageRate;
/*    */   private int addbuffrate;
/*    */   private int addbuffid;
/*    */   
/*    */   public DamageRandomBuff(int modifyDamageRate, int addbuffrate, int addbuffid)
/*    */   {
/* 20 */     this.modifyDamageRate = modifyDamageRate;
/* 21 */     this.addbuffrate = addbuffrate;
/* 22 */     this.addbuffid = addbuffid;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean perform(Skill skill, FighterEffectGroup effectGroup, Fighter releaser, Fighter target)
/*    */   {
/* 28 */     BeforeAttackHandle.OutputObj outputObj = releaser.handleBeforeAttack(new BeforeAttackHandle.InputObj(releaser, target, skill));
/*    */     
/* 30 */     BeforeAttackHandle.OutputObj tagertOutputObj = target.handleBeforeAttack(new BeforeAttackHandle.InputObj(releaser, target, skill));
/*    */     
/* 32 */     outputObj.damageRate += this.modifyDamageRate;
/* 33 */     outputObj.randomBuffRate += this.addbuffrate;
/* 34 */     outputObj.randomBuffid = this.addbuffid;
/*    */     
/* 36 */     FightUtil.DamageInputObj damageInputObj = new FightUtil.DamageInputObj(outputObj, tagertOutputObj, releaser, target, skill, effectGroup);
/*    */     
/*    */ 
/* 39 */     FightUtil.DamageOutputObj damageOutputObj = new FightUtil.DamageOutputObj();
/* 40 */     mzm.gsp.fight.main.FightUtil.handleCommonDamage(damageInputObj, damageOutputObj);
/*    */     
/* 42 */     return damageOutputObj.isHit;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean attach(Fighter fighter)
/*    */   {
/* 48 */     return true;
/*    */   }
/*    */   
/*    */   public boolean detach(Fighter fighter)
/*    */   {
/* 53 */     return true;
/*    */   }
/*    */   
/*    */   public boolean validate()
/*    */   {
/* 58 */     FighterEffectGroup effectGroup = EffectInterface.getEffectGroup(this.addbuffid);
/* 59 */     if (effectGroup == null) {
/* 60 */       throw new RuntimeException("DamageRandomBuff中配置的效果组id不存在:效果组id" + this.addbuffid);
/*    */     }
/* 62 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\DamageRandomBuff.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */