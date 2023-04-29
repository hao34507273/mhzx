/*     */ package mzm.gsp.effect.fighter;
/*     */ 
/*     */ import java.util.HashSet;
/*     */ import mzm.gsp.effect.main.FighterEffectGroup;
/*     */ import mzm.gsp.fight.AttackResultBean;
/*     */ import mzm.gsp.fight.FighterStatus;
/*     */ import mzm.gsp.fight.handle.AfterAttackHandle.OutPutObj;
/*     */ import mzm.gsp.fight.handle.BeDamageHandle.OutputObj;
/*     */ import mzm.gsp.fight.handle.BeforeAttackHandle.InputObj;
/*     */ import mzm.gsp.fight.handle.BeforeAttackHandle.OutputObj;
/*     */ import mzm.gsp.fight.handle.DamageHandle.InputObj;
/*     */ import mzm.gsp.fight.handle.DamageHandle.OutputObj;
/*     */ import mzm.gsp.fight.main.FightArgs;
/*     */ import mzm.gsp.fight.main.FightFormulaHelp;
/*     */ import mzm.gsp.fight.main.Fighter;
/*     */ import mzm.gsp.fight.main.Fighter.ProtectResult;
/*     */ import mzm.gsp.skill.main.Skill;
/*     */ 
/*     */ public class MultiDamage extends mzm.gsp.effect.main.FighterEffect implements mzm.gsp.effect.fighter.Interface.OpOnce
/*     */ {
/*     */   private int damagetimes;
/*     */   private int damagerate;
/*     */   private int modifyrate;
/*     */   
/*     */   public MultiDamage(int damagetimes, int damagerate, int modifyrate)
/*     */   {
/*  27 */     this.damagetimes = damagetimes;
/*  28 */     this.damagerate = damagerate;
/*  29 */     this.modifyrate = modifyrate;
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean perform(Skill skill, FighterEffectGroup effectGroup, Fighter releaser, Fighter target)
/*     */   {
/*  35 */     boolean isCrt = false;
/*  36 */     int damage = 0;
/*  37 */     int reboundDamage = 0;
/*     */     
/*  39 */     if (effectGroup.getDamageType() == 2) {
/*  40 */       for (int i = 0; i < this.damagetimes; i++) {
/*  41 */         boolean ishit = FightFormulaHelp.isMagHit(releaser, target, 0);
/*  42 */         if ((!ishit) && (target.isAlive())) {
/*  43 */           skill.addDodge(releaser, target);
/*     */         }
/*     */         else
/*     */         {
/*  47 */           BeforeAttackHandle.OutputObj attackOutputObj = releaser.handleBeforeAttack(new BeforeAttackHandle.InputObj(releaser, target, skill));
/*     */           
/*  49 */           BeforeAttackHandle.OutputObj targetOutputObj = target.handleBeforeAttack(new BeforeAttackHandle.InputObj(releaser, target, skill));
/*     */           
/*     */ 
/*  52 */           isCrt = FightFormulaHelp.isMagCrt(releaser, target, attackOutputObj, targetOutputObj);
/*     */           
/*  54 */           damage = FightFormulaHelp.calMAGDamage(releaser, target, skill.getTargetSize(), isCrt, attackOutputObj, targetOutputObj);
/*     */           
/*  56 */           damage = (int)(damage * ((this.damagerate + this.modifyrate * i) * 1.0D / FightArgs.getInstance().getDefaultRate()));
/*  57 */           if (damage < 1) {
/*  58 */             damage = 1;
/*     */           }
/*     */           
/*  61 */           DamageHandle.OutputObj damageOutputObj = releaser.handleOnDamage(new DamageHandle.InputObj(releaser, target, skill, damage));
/*     */           
/*     */ 
/*  64 */           damage = damageOutputObj.damage;
/*     */           
/*  66 */           BeDamageHandle.OutputObj beDamageRet = target.handleBeDamage(new mzm.gsp.fight.handle.BeDamageHandle.InputObj(releaser, target, skill, damage, effectGroup.getDamageType()));
/*     */           
/*     */ 
/*  69 */           int trueDamage = beDamageRet.damage2heal > 0 ? -beDamageRet.damage2heal : beDamageRet.nowDamage;
/*  70 */           boolean isAbsorbDamage = beDamageRet.absorb;
/*     */           
/*     */ 
/*  73 */           int vampireHp = (int)((beDamageRet.nowDamage + beDamageRet.shareDamage) * ((attackOutputObj.magVampirerate + damageOutputObj.vampirerate) * 1.0D / FightArgs.getInstance().getDefaultRate()));
/*     */           
/*  75 */           releaser.addHp(vampireHp);
/*     */           
/*  77 */           target.addHp(releaser, -trueDamage);
/*  78 */           releaser.addDamageToFighter(target, damage);
/*     */           
/*  80 */           AttackResultBean attackResultBean = skill.addDamageRet(trueDamage, vampireHp, isCrt, isAbsorbDamage, releaser, target);
/*     */           
/*  82 */           if (i == 0) {
/*  83 */             attackResultBean.attackerstatus.triggerpassiveskills.addAll(attackOutputObj.releasertriggerPassiveSkillids);
/*     */           }
/*     */           
/*  86 */           attackResultBean.attackerstatus.triggerpassiveskills.addAll(damageOutputObj.releaserPassiveSkillids);
/*  87 */           attackResultBean.targetstatus.triggerpassiveskills.addAll(targetOutputObj.targetPassiveSkillids);
/*  88 */           attackResultBean.targetstatus.triggerpassiveskills.addAll(beDamageRet.targetPassiveSkillids);
/*  89 */           skill.handleShareDamage(releaser, beDamageRet, attackResultBean);
/*  90 */           if (i == this.damagetimes - 1) {
/*  91 */             skill.afterTargetDamage(releaser, target, reboundDamage, attackResultBean, trueDamage);
/*     */             
/*  93 */             AfterAttackHandle.OutPutObj afterAttackOutPutObj = releaser.handleAfterAttack(skill, releaser, target);
/*     */             
/*  95 */             attackResultBean.attackerstatus.triggerpassiveskills.addAll(afterAttackOutPutObj.releaserPassiveSkills);
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */     }
/* 101 */     else if (effectGroup.getDamageType() == 1) {
/* 102 */       for (int i = 0; i < this.damagetimes; i++) {
/* 103 */         boolean ishit = FightFormulaHelp.isPhyHit(releaser, target, 0);
/* 104 */         if ((!ishit) && (target.isAlive())) {
/* 105 */           skill.addDodge(releaser, target);
/*     */         }
/*     */         else
/*     */         {
/* 109 */           BeforeAttackHandle.OutputObj attackOutputObj = releaser.handleBeforeAttack(new BeforeAttackHandle.InputObj(releaser, target, skill));
/*     */           
/* 111 */           BeforeAttackHandle.OutputObj targetOutputObj = target.handleBeforeAttack(new BeforeAttackHandle.InputObj(releaser, target, skill));
/*     */           
/*     */ 
/* 114 */           isCrt = FightFormulaHelp.isPHyCrt(releaser, target, attackOutputObj, targetOutputObj);
/*     */           
/* 116 */           damage = FightFormulaHelp.calPHYDamage(releaser, target, skill.getTargetSize(), isCrt, attackOutputObj, targetOutputObj);
/*     */           
/* 118 */           damage = (int)(damage * ((this.damagerate + this.modifyrate * i) * 1.0D / FightArgs.getInstance().getDefaultRate()));
/* 119 */           if (damage < 1) {
/* 120 */             damage = 1;
/*     */           }
/* 122 */           DamageHandle.OutputObj damageOutputObj = releaser.handleOnDamage(new DamageHandle.InputObj(releaser, target, skill, damage));
/*     */           
/*     */ 
/* 125 */           damage = damageOutputObj.damage;
/*     */           
/* 127 */           BeDamageHandle.OutputObj beDamageRet = target.handleBeDamage(new mzm.gsp.fight.handle.BeDamageHandle.InputObj(releaser, target, skill, damage, effectGroup.getDamageType()));
/*     */           
/*     */ 
/* 130 */           int trueDamage = beDamageRet.damage2heal > 0 ? -beDamageRet.damage2heal : beDamageRet.nowDamage;
/* 131 */           boolean isAbsorbDamage = beDamageRet.absorb;
/*     */           
/*     */ 
/* 134 */           int vampireHp = (int)((beDamageRet.nowDamage + beDamageRet.shareDamage) * ((attackOutputObj.phyVampirerate + damageOutputObj.vampirerate) * 1.0D / FightArgs.getInstance().getDefaultRate()));
/*     */           
/* 136 */           releaser.addHp(vampireHp);
/*     */           
/*     */ 
/* 139 */           if ((i == 0) && (skill.canBeProtect())) {
/* 140 */             Fighter.ProtectResult protectResult = target.handleProtect(trueDamage);
/* 141 */             skill.handleProtectResult(releaser, target, protectResult);
/* 142 */             trueDamage = protectResult.getFinalDamage();
/*     */           }
/*     */           
/* 145 */           target.addHp(releaser, -trueDamage);
/* 146 */           releaser.addDamageToFighter(target, damage);
/*     */           
/* 148 */           AttackResultBean attackResultBean = skill.addDamageRet(trueDamage, vampireHp, isCrt, isAbsorbDamage, releaser, target);
/*     */           
/* 150 */           if (i == 0) {
/* 151 */             attackResultBean.attackerstatus.triggerpassiveskills.addAll(attackOutputObj.releasertriggerPassiveSkillids);
/*     */           }
/*     */           
/* 154 */           attackResultBean.attackerstatus.triggerpassiveskills.addAll(damageOutputObj.releaserPassiveSkillids);
/* 155 */           attackResultBean.targetstatus.triggerpassiveskills.addAll(targetOutputObj.targetPassiveSkillids);
/* 156 */           attackResultBean.targetstatus.triggerpassiveskills.addAll(beDamageRet.targetPassiveSkillids);
/* 157 */           skill.handleShareDamage(releaser, beDamageRet, attackResultBean);
/* 158 */           if ((target.isDefense()) && (effectGroup.getDamageType() == 1)) {
/* 159 */             attackResultBean.targetstatus.status_set.add(Integer.valueOf(29));
/*     */           }
/*     */           
/* 162 */           if (i == this.damagetimes - 1) {
/* 163 */             skill.afterTargetDamage(releaser, target, reboundDamage, attackResultBean, trueDamage);
/*     */             
/* 165 */             AfterAttackHandle.OutPutObj afterAttackOutPutObj = releaser.handleAfterAttack(skill, releaser, target);
/*     */             
/* 167 */             attackResultBean.attackerstatus.triggerpassiveskills.addAll(afterAttackOutPutObj.releaserPassiveSkills);
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */     else {
/* 173 */       mzm.gsp.GameServer.logger().error("效果组伤害类型不是法术和物理,但是效果组配置了伤害效果!!");
/* 174 */       return false;
/*     */     }
/*     */     
/* 177 */     return true;
/*     */   }
/*     */   
/*     */   public boolean attach(Fighter fighter)
/*     */   {
/* 182 */     return true;
/*     */   }
/*     */   
/*     */   public boolean detach(Fighter fighter)
/*     */   {
/* 187 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\MultiDamage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */