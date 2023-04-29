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
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ import mzm.gsp.fight.main.Fighter.ProtectResult;
/*    */ import mzm.gsp.skill.main.Skill;
/*    */ 
/*    */ public class HpOnce extends FighterEffect implements mzm.gsp.effect.fighter.Interface.OpOnce
/*    */ {
/*    */   private int modifyHp;
/*    */   
/*    */   public HpOnce(int modifyHp)
/*    */   {
/* 21 */     this.modifyHp = modifyHp;
/*    */   }
/*    */   
/*    */   public boolean perform(Skill skill, FighterEffectGroup effectGroup, Fighter releaser, Fighter target)
/*    */   {
/* 26 */     if (this.modifyHp >= 0) {
/* 27 */       target.addHp(this.modifyHp);
/* 28 */       skill.addHealHpRet(releaser, target, this.modifyHp, false);
/*    */     } else {
/* 30 */       BeDamageHandle.OutputObj beDamageRet = target.handleBeDamage(new mzm.gsp.fight.handle.BeDamageHandle.InputObj(releaser, target, skill, -this.modifyHp, effectGroup.getDamageType()));
/*    */       
/* 32 */       ReboundHandle.OutPutObj rebondOutPutObj = target.handleOnRebound(effectGroup.getDamageType(), -this.modifyHp);
/* 33 */       int reboundDamage = rebondOutPutObj.reboundDamage;
/* 34 */       int trueDamage = beDamageRet.damage2heal > 0 ? -beDamageRet.damage2heal : beDamageRet.nowDamage;
/* 35 */       boolean isAbsorbDamage = beDamageRet.absorb;
/* 36 */       if (effectGroup.getDamageType() == 1)
/*    */       {
/* 38 */         if (skill.canBeProtect()) {
/* 39 */           Fighter.ProtectResult protectResult = target.handleProtect(trueDamage);
/* 40 */           skill.handleProtectResult(releaser, target, protectResult);
/* 41 */           trueDamage = protectResult.getFinalDamage();
/*    */         }
/*    */       }
/*    */       
/* 45 */       target.addHp(releaser, -trueDamage);
/* 46 */       releaser.addDamageToFighter(target, -this.modifyHp);
/* 47 */       AttackResultBean attackResultBean = skill.addDamageRet(trueDamage, 0, false, isAbsorbDamage, releaser, target);
/*    */       
/* 49 */       attackResultBean.targetstatus.triggerpassiveskills.addAll(rebondOutPutObj.targetPassiveSkillids);
/* 50 */       attackResultBean.targetstatus.triggerpassiveskills.addAll(beDamageRet.targetPassiveSkillids);
/* 51 */       skill.handleShareDamage(releaser, beDamageRet, attackResultBean);
/*    */       
/* 53 */       skill.afterTargetDamage(releaser, target, reboundDamage, attackResultBean, -this.modifyHp);
/* 54 */       if ((target.isDefense()) && (effectGroup.getDamageType() == 1)) {
/* 55 */         attackResultBean.targetstatus.status_set.add(Integer.valueOf(29));
/*    */       }
/*    */       
/* 58 */       AfterAttackHandle.OutPutObj afterAttackOutPutObj = releaser.handleAfterAttack(skill, releaser, target);
/* 59 */       attackResultBean.attackerstatus.triggerpassiveskills.addAll(afterAttackOutPutObj.releaserPassiveSkills);
/*    */     }
/*    */     
/* 62 */     return true;
/*    */   }
/*    */   
/*    */   public boolean attach(Fighter fighter)
/*    */   {
/* 67 */     return true;
/*    */   }
/*    */   
/*    */   public boolean detach(Fighter fighter)
/*    */   {
/* 72 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\HpOnce.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */