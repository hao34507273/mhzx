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
/*     */ import mzm.gsp.fight.handle.ReboundHandle.OutPutObj;
/*     */ import mzm.gsp.fight.main.FightArgs;
/*     */ import mzm.gsp.fight.main.FightFormulaHelp;
/*     */ import mzm.gsp.fight.main.Fighter;
/*     */ import mzm.gsp.fight.main.Fighter.ProtectResult;
/*     */ import mzm.gsp.skill.main.Skill;
/*     */ 
/*     */ public class CanBreakMultiDamage extends mzm.gsp.effect.main.FighterEffect implements mzm.gsp.effect.fighter.Interface.OpOnce
/*     */ {
/*     */   private int damagetimes;
/*     */   private int damagerate;
/*     */   private int modifyrate;
/*     */   
/*     */   public CanBreakMultiDamage(int damagetimes, int damagerate, int modifyrate)
/*     */   {
/*  28 */     this.damagetimes = damagetimes;
/*  29 */     this.damagerate = damagerate;
/*  30 */     this.modifyrate = modifyrate;
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean perform(Skill skill, FighterEffectGroup effectGroup, Fighter releaser, Fighter target)
/*     */   {
/*  36 */     boolean isCrt = false;
/*  37 */     int damage = 0;
/*  38 */     int reboundDamage = 0;
/*     */     
/*  40 */     if (effectGroup.getDamageType() == 2) {
/*  41 */       for (int i = 0; i < this.damagetimes; i++) {
/*  42 */         if ((target.isDead()) || (target.isFakeDead()) || (releaser.isDead()) || (releaser.isFakeDead())) {
/*     */           break;
/*     */         }
/*  45 */         boolean ishit = FightFormulaHelp.isMagHit(releaser, target, 0);
/*  46 */         if ((!ishit) && (target.isAlive())) {
/*  47 */           skill.addDodge(releaser, target);
/*     */         }
/*     */         else
/*     */         {
/*  51 */           BeforeAttackHandle.OutputObj attackOutputObj = releaser.handleBeforeAttack(new BeforeAttackHandle.InputObj(releaser, target, skill));
/*     */           
/*  53 */           BeforeAttackHandle.OutputObj targetOutputObj = target.handleBeforeAttack(new BeforeAttackHandle.InputObj(releaser, target, skill));
/*     */           
/*     */ 
/*  56 */           isCrt = FightFormulaHelp.isMagCrt(releaser, target, attackOutputObj, targetOutputObj);
/*     */           
/*  58 */           damage = FightFormulaHelp.calMAGDamage(releaser, target, skill.getTargetSize(), isCrt, attackOutputObj, targetOutputObj);
/*     */           
/*  60 */           damage = (int)(damage * ((this.damagerate + this.modifyrate * i) * 1.0D / FightArgs.getInstance().getDefaultRate()));
/*  61 */           if (damage < 1) {
/*  62 */             damage = 1;
/*     */           }
/*     */           
/*  65 */           DamageHandle.OutputObj damageOutputObj = releaser.handleOnDamage(new DamageHandle.InputObj(releaser, target, skill, damage));
/*     */           
/*     */ 
/*  68 */           damage = damageOutputObj.damage;
/*     */           
/*  70 */           BeDamageHandle.OutputObj beDamageRet = target.handleBeDamage(new mzm.gsp.fight.handle.BeDamageHandle.InputObj(releaser, target, skill, damage, effectGroup.getDamageType()));
/*     */           
/*  72 */           ReboundHandle.OutPutObj reboundDamageObj = target.handleOnRebound(2, damage);
/*  73 */           reboundDamage = reboundDamageObj.reboundDamage;
/*  74 */           int trueDamage = beDamageRet.damage2heal > 0 ? -beDamageRet.damage2heal : beDamageRet.nowDamage;
/*  75 */           boolean isAbsorbDamage = beDamageRet.absorb;
/*     */           
/*  77 */           int vampireHp = 0;
/*     */           
/*  79 */           if (attackOutputObj.vampire) {
/*  80 */             vampireHp = (int)((beDamageRet.nowDamage + beDamageRet.shareDamage) * ((attackOutputObj.magVampirerate + damageOutputObj.vampirerate) * 1.0D / FightArgs.getInstance().getDefaultRate()));
/*     */             
/*  82 */             releaser.addHp(vampireHp);
/*     */           }
/*  84 */           if ((trueDamage > 0) && (attackOutputObj.isStealHp)) {
/*  85 */             int stealHp = (int)(trueDamage * (attackOutputObj.stealDamageRate * 1.0D / FightArgs.getInstance().getDefaultRate()));
/*     */             
/*  87 */             releaser.addHp(stealHp);
/*  88 */             vampireHp += stealHp;
/*     */           }
/*     */           
/*  91 */           target.addHp(releaser, -trueDamage);
/*  92 */           releaser.addDamageToFighter(target, damage);
/*     */           
/*  94 */           AttackResultBean attackResultBean = skill.addDamageRet(trueDamage, vampireHp, isCrt, isAbsorbDamage, releaser, target);
/*     */           
/*  96 */           attackResultBean.attackerstatus.triggerpassiveskills.addAll(attackOutputObj.releasertriggerPassiveSkillids);
/*     */           
/*  98 */           attackResultBean.attackerstatus.triggerpassiveskills.addAll(damageOutputObj.releaserPassiveSkillids);
/*  99 */           attackResultBean.targetstatus.triggerpassiveskills.addAll(targetOutputObj.targetPassiveSkillids);
/* 100 */           attackResultBean.targetstatus.triggerpassiveskills.addAll(beDamageRet.targetPassiveSkillids);
/* 101 */           skill.handleShareDamage(releaser, beDamageRet, attackResultBean);
/* 102 */           skill.afterTargetDamage(releaser, target, reboundDamage, attackResultBean, trueDamage);
/*     */           
/* 104 */           AfterAttackHandle.OutPutObj afterAttackOutPutObj = releaser.handleAfterAttack(skill, releaser, target);
/* 105 */           attackResultBean.attackerstatus.triggerpassiveskills.addAll(afterAttackOutPutObj.releaserPassiveSkills);
/*     */         }
/*     */       }
/*     */     }
/* 109 */     else if (effectGroup.getDamageType() == 1) {
/* 110 */       for (int i = 0; i < this.damagetimes; i++) {
/* 111 */         if ((target.isDead()) || (target.isFakeDead()) || (releaser.isDead()) || (releaser.isFakeDead())) {
/*     */           break;
/*     */         }
/* 114 */         boolean ishit = FightFormulaHelp.isPhyHit(releaser, target, 0);
/* 115 */         if ((!ishit) && (target.isAlive())) {
/* 116 */           skill.addDodge(releaser, target);
/*     */         }
/*     */         else
/*     */         {
/* 120 */           BeforeAttackHandle.OutputObj attackOutputObj = releaser.handleBeforeAttack(new BeforeAttackHandle.InputObj(releaser, target, skill));
/*     */           
/* 122 */           BeforeAttackHandle.OutputObj targetOutputObj = target.handleBeforeAttack(new BeforeAttackHandle.InputObj(releaser, target, skill));
/*     */           
/*     */ 
/* 125 */           isCrt = FightFormulaHelp.isPHyCrt(releaser, target, attackOutputObj, targetOutputObj);
/*     */           
/* 127 */           damage = FightFormulaHelp.calPHYDamage(releaser, target, skill.getTargetSize(), isCrt, attackOutputObj, targetOutputObj);
/*     */           
/* 129 */           damage = (int)(damage * ((this.damagerate + this.modifyrate * i) * 1.0D / FightArgs.getInstance().getDefaultRate()));
/* 130 */           if (damage < 1) {
/* 131 */             damage = 1;
/*     */           }
/* 133 */           DamageHandle.OutputObj damageOutputObj = releaser.handleOnDamage(new DamageHandle.InputObj(releaser, target, skill, damage));
/*     */           
/*     */ 
/* 136 */           damage = damageOutputObj.damage;
/*     */           
/* 138 */           BeDamageHandle.OutputObj beDamageRet = target.handleBeDamage(new mzm.gsp.fight.handle.BeDamageHandle.InputObj(releaser, target, skill, damage, effectGroup.getDamageType()));
/*     */           
/*     */ 
/* 141 */           ReboundHandle.OutPutObj reboundDamageObj = target.handleOnRebound(1, damage);
/* 142 */           reboundDamage = reboundDamageObj.reboundDamage;
/* 143 */           int trueDamage = beDamageRet.damage2heal > 0 ? -beDamageRet.damage2heal : beDamageRet.nowDamage;
/* 144 */           boolean isAbsorbDamage = beDamageRet.absorb;
/*     */           
/* 146 */           int vampireHp = 0;
/*     */           
/* 148 */           if (attackOutputObj.vampire) {
/* 149 */             vampireHp = (int)((beDamageRet.nowDamage + beDamageRet.shareDamage) * ((attackOutputObj.phyVampirerate + damageOutputObj.vampirerate) * 1.0D / FightArgs.getInstance().getDefaultRate()));
/*     */             
/* 151 */             releaser.addHp(vampireHp);
/*     */           }
/* 153 */           if ((trueDamage > 0) && (attackOutputObj.isStealHp)) {
/* 154 */             int stealHp = (int)(trueDamage * (attackOutputObj.stealDamageRate * 1.0D / FightArgs.getInstance().getDefaultRate()));
/*     */             
/* 156 */             releaser.addHp(stealHp);
/* 157 */             vampireHp += stealHp;
/*     */           }
/*     */           
/*     */ 
/* 161 */           if (skill.canBeProtect()) {
/* 162 */             Fighter.ProtectResult protectResult = target.handleProtect(trueDamage);
/* 163 */             skill.handleProtectResult(releaser, target, protectResult);
/* 164 */             trueDamage = protectResult.getFinalDamage();
/*     */           }
/*     */           
/* 167 */           target.addHp(releaser, -trueDamage);
/* 168 */           releaser.addDamageToFighter(target, damage);
/*     */           
/* 170 */           AttackResultBean attackResultBean = skill.addDamageRet(trueDamage, vampireHp, isCrt, isAbsorbDamage, releaser, target);
/*     */           
/* 172 */           attackResultBean.attackerstatus.triggerpassiveskills.addAll(attackOutputObj.releasertriggerPassiveSkillids);
/*     */           
/* 174 */           attackResultBean.attackerstatus.triggerpassiveskills.addAll(damageOutputObj.releaserPassiveSkillids);
/* 175 */           attackResultBean.targetstatus.triggerpassiveskills.addAll(targetOutputObj.targetPassiveSkillids);
/* 176 */           attackResultBean.targetstatus.triggerpassiveskills.addAll(beDamageRet.targetPassiveSkillids);
/* 177 */           skill.handleShareDamage(releaser, beDamageRet, attackResultBean);
/* 178 */           if ((target.isDefense()) && (effectGroup.getDamageType() == 1)) {
/* 179 */             attackResultBean.targetstatus.status_set.add(Integer.valueOf(29));
/*     */           }
/*     */           
/* 182 */           skill.afterTargetDamage(releaser, target, reboundDamage, attackResultBean, trueDamage);
/*     */           
/* 184 */           AfterAttackHandle.OutPutObj afterAttackOutPutObj = releaser.handleAfterAttack(skill, releaser, target);
/* 185 */           attackResultBean.attackerstatus.triggerpassiveskills.addAll(afterAttackOutPutObj.releaserPassiveSkills);
/*     */         }
/*     */       }
/*     */     } else {
/* 189 */       mzm.gsp.GameServer.logger().error("效果组伤害类型不是法术和物理,但是效果组配置了伤害效果!!");
/* 190 */       return false;
/*     */     }
/*     */     
/* 193 */     return true;
/*     */   }
/*     */   
/*     */   public boolean attach(Fighter fighter)
/*     */   {
/* 198 */     return true;
/*     */   }
/*     */   
/*     */   public boolean detach(Fighter fighter)
/*     */   {
/* 203 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\CanBreakMultiDamage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */