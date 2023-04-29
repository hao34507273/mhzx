/*    */ package mzm.gsp.effect.fighter;
/*    */ 
/*    */ import java.util.HashSet;
/*    */ import mzm.gsp.effect.main.FighterEffect;
/*    */ import mzm.gsp.effect.main.FighterEffectGroup;
/*    */ import mzm.gsp.fight.AttackResultBean;
/*    */ import mzm.gsp.fight.FighterStatus;
/*    */ import mzm.gsp.fight.handle.AfterAttackHandle.OutPutObj;
/*    */ import mzm.gsp.fight.handle.BeDamageHandle.OutputObj;
/*    */ import mzm.gsp.fight.handle.ReboundHandle.OutPutObj;
/*    */ import mzm.gsp.fight.main.FightArgs;
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ import mzm.gsp.fight.main.Fighter.ProtectResult;
/*    */ import mzm.gsp.skill.main.Skill;
/*    */ 
/*    */ public class HpRateOnce extends FighterEffect implements mzm.gsp.effect.fighter.Interface.OpOnce
/*    */ {
/*    */   private int modifyHpRate;
/*    */   
/*    */   public HpRateOnce(int modifyHpRate)
/*    */   {
/* 22 */     this.modifyHpRate = modifyHpRate;
/*    */   }
/*    */   
/*    */   public boolean perform(Skill skill, FighterEffectGroup effectGroup, Fighter releaser, Fighter target)
/*    */   {
/* 27 */     double maxHp = target.getMaxHp();
/* 28 */     int changeValue = (int)(maxHp * (this.modifyHpRate * 1.0D / FightArgs.getInstance().getDefaultRate()));
/* 29 */     if (changeValue >= 0) {
/* 30 */       target.addHp(changeValue);
/* 31 */       skill.addHealHpRet(releaser, target, changeValue, false);
/*    */     } else {
/* 33 */       BeDamageHandle.OutputObj beDamageRet = target.handleBeDamage(new mzm.gsp.fight.handle.BeDamageHandle.InputObj(releaser, target, skill, -changeValue, effectGroup.getDamageType()));
/*    */       
/* 35 */       ReboundHandle.OutPutObj reboundOutPutObj = target.handleOnRebound(effectGroup.getDamageType(), -changeValue);
/*    */       
/* 37 */       int reboundDamage = reboundOutPutObj.reboundDamage;
/* 38 */       int trueDamage = beDamageRet.damage2heal > 0 ? -beDamageRet.damage2heal : beDamageRet.nowDamage;
/* 39 */       boolean isAbsorbDamage = beDamageRet.absorb;
/* 40 */       if (effectGroup.getDamageType() == 1)
/*    */       {
/* 42 */         if (skill.canBeProtect()) {
/* 43 */           Fighter.ProtectResult protectResult = target.handleProtect(trueDamage);
/* 44 */           skill.handleProtectResult(releaser, target, protectResult);
/* 45 */           trueDamage = protectResult.getFinalDamage();
/*    */         }
/*    */       }
/* 48 */       target.addHp(releaser, -trueDamage);
/* 49 */       releaser.addDamageToFighter(target, -changeValue);
/* 50 */       AttackResultBean attackResultBean = skill.addDamageRet(trueDamage, 0, false, isAbsorbDamage, releaser, target);
/*    */       
/* 52 */       attackResultBean.targetstatus.triggerpassiveskills.addAll(reboundOutPutObj.targetPassiveSkillids);
/* 53 */       attackResultBean.targetstatus.triggerpassiveskills.addAll(beDamageRet.targetPassiveSkillids);
/* 54 */       skill.handleShareDamage(releaser, beDamageRet, attackResultBean);
/*    */       
/* 56 */       skill.afterTargetDamage(releaser, target, reboundDamage, attackResultBean, -changeValue);
/* 57 */       if ((target.isDefense()) && (effectGroup.getDamageType() == 1)) {
/* 58 */         attackResultBean.targetstatus.status_set.add(Integer.valueOf(29));
/*    */       }
/*    */       
/* 61 */       AfterAttackHandle.OutPutObj afterAttackOutPutObj = releaser.handleAfterAttack(skill, releaser, target);
/* 62 */       attackResultBean.attackerstatus.triggerpassiveskills.addAll(afterAttackOutPutObj.releaserPassiveSkills);
/*    */     }
/* 64 */     return true;
/*    */   }
/*    */   
/*    */   public boolean attach(Fighter fighter)
/*    */   {
/* 69 */     return true;
/*    */   }
/*    */   
/*    */   public boolean detach(Fighter fighter)
/*    */   {
/* 74 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\HpRateOnce.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */