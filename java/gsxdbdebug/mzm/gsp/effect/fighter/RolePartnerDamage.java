/*    */ package mzm.gsp.effect.fighter;
/*    */ 
/*    */ import mzm.gsp.effect.fighter.Interface.OpOnce;
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
/*    */ public class RolePartnerDamage extends FighterEffect implements OpOnce
/*    */ {
/*    */   private int exatk;
/*    */   private int exatkrate;
/*    */   private int skillDamageRate;
/*    */   private int skillDamageRateMax;
/*    */   private int fixDamage;
/*    */   private int damagerate;
/*    */   
/*    */   public RolePartnerDamage(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
/*    */   {
/* 25 */     this.exatk = paramInt1;
/* 26 */     this.exatkrate = paramInt2;
/* 27 */     this.skillDamageRate = paramInt3;
/* 28 */     this.skillDamageRateMax = paramInt4;
/* 29 */     this.fixDamage = paramInt5;
/* 30 */     if (this.skillDamageRate >= this.skillDamageRateMax) {
/* 31 */       this.skillDamageRate = this.skillDamageRateMax;
/*    */     }
/* 33 */     this.damagerate = paramInt6;
/*    */   }
/*    */   
/*    */   public boolean perform(Skill paramSkill, FighterEffectGroup paramFighterEffectGroup, Fighter paramFighter1, Fighter paramFighter2)
/*    */   {
/* 38 */     BeforeAttackHandle.OutputObj localOutputObj1 = paramFighter1.handleBeforeAttack(new BeforeAttackHandle.InputObj(paramFighter1, paramFighter2, paramSkill));
/*    */     
/* 40 */     BeforeAttackHandle.OutputObj localOutputObj2 = paramFighter2.handleBeforeAttack(new BeforeAttackHandle.InputObj(paramFighter1, paramFighter2, paramSkill));
/*    */     
/* 42 */     localOutputObj1.skillDamageRate += this.skillDamageRate;
/* 43 */     localOutputObj1.exaAtk += this.exatk;
/* 44 */     localOutputObj1.exaAtkRate += this.exatkrate;
/* 45 */     localOutputObj1.fixDamage += this.fixDamage;
/*    */     
/*    */ 
/* 48 */     if ((paramFighter2.isRoleType()) || (paramFighter2.isFellowType())) {
/* 49 */       BeforeAttackHandle.OutputObj tmp109_107 = localOutputObj1;tmp109_107.fixDamage = ((int)(tmp109_107.fixDamage + paramFighter2.getMaxHp() * (this.damagerate * 1.0D / FightArgs.getInstance().getDefaultRate())));
/*    */     }
/*    */     
/* 52 */     FightUtil.DamageInputObj localDamageInputObj = new FightUtil.DamageInputObj(localOutputObj1, localOutputObj2, paramFighter1, paramFighter2, paramSkill, paramFighterEffectGroup);
/*    */     
/* 54 */     FightUtil.DamageOutputObj localDamageOutputObj = new FightUtil.DamageOutputObj();
/* 55 */     mzm.gsp.fight.main.FightUtil.handleCommonDamage(localDamageInputObj, localDamageOutputObj);
/*    */     
/* 57 */     return localDamageOutputObj.isHit;
/*    */   }
/*    */   
/*    */   public boolean attach(Fighter paramFighter)
/*    */   {
/* 62 */     return true;
/*    */   }
/*    */   
/*    */   public boolean detach(Fighter paramFighter)
/*    */   {
/* 67 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\RolePartnerDamage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */