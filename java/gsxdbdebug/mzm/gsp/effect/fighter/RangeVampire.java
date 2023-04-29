/*    */ package mzm.gsp.effect.fighter;
/*    */ 
/*    */ import java.util.Random;
/*    */ import mzm.gsp.effect.fighter.Interface.OpOnce;
/*    */ import mzm.gsp.effect.main.FighterEffect;
/*    */ import mzm.gsp.effect.main.FighterEffectGroup;
/*    */ import mzm.gsp.fight.handle.BeforeAttackHandle.InputObj;
/*    */ import mzm.gsp.fight.handle.BeforeAttackHandle.OutputObj;
/*    */ import mzm.gsp.fight.main.FightUtil.DamageInputObj;
/*    */ import mzm.gsp.fight.main.FightUtil.DamageOutputObj;
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ import mzm.gsp.skill.main.Skill;
/*    */ import xdb.Xdb;
/*    */ 
/*    */ public class RangeVampire extends FighterEffect implements OpOnce
/*    */ {
/*    */   private int minrate;
/*    */   private int maxrate;
/*    */   private int mask;
/*    */   
/*    */   public RangeVampire(int paramInt1, int paramInt2, int paramInt3)
/*    */   {
/* 23 */     this.minrate = paramInt1;
/* 24 */     this.maxrate = paramInt2;
/* 25 */     this.mask = paramInt3;
/*    */   }
/*    */   
/*    */   public boolean perform(Skill paramSkill, FighterEffectGroup paramFighterEffectGroup, Fighter paramFighter1, Fighter paramFighter2)
/*    */   {
/* 30 */     BeforeAttackHandle.OutputObj localOutputObj1 = paramFighter1.handleBeforeAttack(new BeforeAttackHandle.InputObj(paramFighter1, paramFighter2, paramSkill));
/* 31 */     BeforeAttackHandle.OutputObj localOutputObj2 = paramFighter2.handleBeforeAttack(new BeforeAttackHandle.InputObj(paramFighter1, paramFighter2, paramSkill));
/*    */     
/* 33 */     int i = Xdb.random().nextInt(this.maxrate - this.minrate + 1) + this.minrate;
/* 34 */     localOutputObj1.damageRate = (i * 10000);
/*    */     
/* 36 */     if ((this.mask & 0x1) > 0)
/* 37 */       localOutputObj1.phyVampirerate += 10000;
/* 38 */     if ((this.mask & 0x2) > 0) {
/* 39 */       localOutputObj1.magVampirerate += 10000;
/*    */     }
/* 41 */     FightUtil.DamageInputObj localDamageInputObj = new FightUtil.DamageInputObj(localOutputObj1, localOutputObj2, paramFighter1, paramFighter2, paramSkill, paramFighterEffectGroup);
/*    */     
/* 43 */     FightUtil.DamageOutputObj localDamageOutputObj = new FightUtil.DamageOutputObj();
/* 44 */     mzm.gsp.fight.main.FightUtil.handleCommonDamage(localDamageInputObj, localDamageOutputObj);
/*    */     
/* 46 */     return localDamageOutputObj.isHit;
/*    */   }
/*    */   
/*    */   public boolean attach(Fighter paramFighter)
/*    */   {
/* 51 */     return true;
/*    */   }
/*    */   
/*    */   public boolean detach(Fighter paramFighter)
/*    */   {
/* 56 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\RangeVampire.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */