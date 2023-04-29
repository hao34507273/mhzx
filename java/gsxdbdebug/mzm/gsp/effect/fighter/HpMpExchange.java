/*    */ package mzm.gsp.effect.fighter;
/*    */ 
/*    */ import java.util.HashSet;
/*    */ import mzm.gsp.effect.fighter.Interface.OpOnce;
/*    */ import mzm.gsp.effect.main.FighterEffect;
/*    */ import mzm.gsp.effect.main.FighterEffectGroup;
/*    */ import mzm.gsp.fight.AttackResultBean;
/*    */ import mzm.gsp.fight.FighterStatus;
/*    */ import mzm.gsp.fight.handle.AfterAttackHandle.OutPutObj;
/*    */ import mzm.gsp.fight.handle.BeDamageHandle.InputObj;
/*    */ import mzm.gsp.fight.handle.BeDamageHandle.OutputObj;
/*    */ import mzm.gsp.fight.handle.ReboundHandle.OutPutObj;
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ import mzm.gsp.skill.main.Skill;
/*    */ 
/*    */ public class HpMpExchange
/*    */   extends FighterEffect implements OpOnce
/*    */ {
/*    */   public boolean attach(Fighter paramFighter)
/*    */   {
/* 21 */     return true;
/*    */   }
/*    */   
/*    */   public boolean detach(Fighter paramFighter)
/*    */   {
/* 26 */     return true;
/*    */   }
/*    */   
/*    */   public boolean perform(Skill paramSkill, FighterEffectGroup paramFighterEffectGroup, Fighter paramFighter1, Fighter paramFighter2)
/*    */   {
/* 31 */     double d1 = getHpRate(paramFighter2);
/* 32 */     double d2 = getMpRate(paramFighter2);
/*    */     
/* 34 */     int i = (int)paramFighter2.getMaxHp();
/* 35 */     int j = paramFighter2.getHp();
/* 36 */     int k = (int)(i * d2) - j;
/* 37 */     if (k >= 0) {
/* 38 */       paramFighter2.addHp(k);
/* 39 */       paramSkill.addHealHpRet(paramFighter1, paramFighter2, k, false);
/*    */     } else {
/* 41 */       BeDamageHandle.OutputObj localOutputObj = paramFighter2.handleBeDamage(new BeDamageHandle.InputObj(paramFighter1, paramFighter2, paramSkill, -k, paramFighterEffectGroup.getDamageType()));
/* 42 */       ReboundHandle.OutPutObj localOutPutObj = paramFighter2.handleOnRebound(paramFighterEffectGroup.getDamageType(), -k);
/* 43 */       i1 = localOutPutObj.reboundDamage;
/* 44 */       int i2 = localOutputObj.damage2heal > 0 ? -localOutputObj.damage2heal : localOutputObj.nowDamage;
/* 45 */       boolean bool = localOutputObj.absorb;
/* 46 */       paramFighter2.addHp(paramFighter1, -i2);
/* 47 */       paramFighter1.addDamageToFighter(paramFighter2, -k);
/* 48 */       AttackResultBean localAttackResultBean = paramSkill.addDamageRet(i2, 0, false, bool, paramFighter1, paramFighter2);
/* 49 */       localAttackResultBean.targetstatus.triggerpassiveskills.addAll(localOutPutObj.targetPassiveSkillids);
/* 50 */       localAttackResultBean.targetstatus.triggerpassiveskills.addAll(localOutputObj.targetPassiveSkillids);
/* 51 */       paramSkill.handleShareDamage(paramFighter1, localOutputObj, localAttackResultBean);
/* 52 */       paramSkill.afterTargetDamage(paramFighter1, paramFighter2, i1, localAttackResultBean, -k);
/* 53 */       if ((paramFighter2.isDefense()) && (paramFighterEffectGroup.getDamageType() == 1))
/* 54 */         localAttackResultBean.targetstatus.status_set.add(Integer.valueOf(29));
/* 55 */       AfterAttackHandle.OutPutObj localOutPutObj1 = paramFighter1.handleAfterAttack(paramSkill, paramFighter1, paramFighter2);
/* 56 */       localAttackResultBean.attackerstatus.triggerpassiveskills.addAll(localOutPutObj1.releaserPassiveSkills);
/*    */     }
/*    */     
/* 59 */     int m = (int)paramFighter2.getMaxMp();
/* 60 */     int n = paramFighter2.getMp();
/* 61 */     int i1 = (int)(m * d1) - n;
/* 62 */     paramFighter2.addMp(i1);
/* 63 */     paramSkill.addHealMpRet(paramFighter1, paramFighter2, i1, false);
/*    */     
/* 65 */     return true;
/*    */   }
/*    */   
/*    */   public double getHpRate(Fighter paramFighter)
/*    */   {
/* 70 */     double d1 = paramFighter.getMaxHp();
/* 71 */     int i = paramFighter.getHp();
/* 72 */     double d2 = i / d1;
/*    */     
/* 74 */     return d2;
/*    */   }
/*    */   
/*    */   public double getMpRate(Fighter paramFighter)
/*    */   {
/* 79 */     double d1 = paramFighter.getMaxMp();
/* 80 */     int i = paramFighter.getMp();
/* 81 */     double d2 = i / d1;
/*    */     
/* 83 */     return d2;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\HpMpExchange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */