/*     */ package mzm.gsp.effect.fighter;
/*     */ 
/*     */ import java.util.HashSet;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.effect.main.EffectInterface;
/*     */ import mzm.gsp.effect.main.FighterEffect;
/*     */ import mzm.gsp.effect.main.FighterEffectGroup;
/*     */ import mzm.gsp.fight.AttackResultBean;
/*     */ import mzm.gsp.fight.FighterStatus;
/*     */ import mzm.gsp.fight.handle.AfterAttackHandle.OutPutObj;
/*     */ import mzm.gsp.fight.handle.BeDamageHandle.OutputObj;
/*     */ import mzm.gsp.fight.handle.BeforeAttackHandle.InputObj;
/*     */ import mzm.gsp.fight.handle.BeforeAttackHandle.OutputObj;
/*     */ import mzm.gsp.fight.handle.DamageHandle.OutputObj;
/*     */ import mzm.gsp.fight.handle.ReboundHandle.OutPutObj;
/*     */ import mzm.gsp.fight.main.FightArgs;
/*     */ import mzm.gsp.fight.main.FightFormulaHelp;
/*     */ import mzm.gsp.fight.main.Fighter;
/*     */ import mzm.gsp.skill.main.Skill;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ public class KillEnermyEffect extends FighterEffect implements mzm.gsp.effect.fighter.Interface.OpOnce, mzm.gsp.effect.fighter.Interface.Validate
/*     */ {
/*     */   private int damagetimes;
/*     */   private int damagerate;
/*     */   private int modifyrate;
/*     */   private int effectid;
/*     */   
/*     */   public KillEnermyEffect(int damagetimes, int damagerate, int modifyrate, int effectid)
/*     */   {
/*  31 */     this.damagetimes = damagetimes;
/*  32 */     this.damagerate = damagerate;
/*  33 */     this.modifyrate = modifyrate;
/*  34 */     this.effectid = effectid;
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean perform(Skill skill, FighterEffectGroup effectGroup, Fighter releaser, Fighter target)
/*     */   {
/*  40 */     boolean isCrt = false;
/*  41 */     int damage = 0;
/*  42 */     int reboundDamage = 0;
/*     */     
/*     */ 
/*     */ 
/*  46 */     if (effectGroup.getDamageType() == 2) {
/*  47 */       for (int i = 0; i < this.damagetimes; i++) {
/*  48 */         boolean ishit = FightFormulaHelp.isMagHit(releaser, target, 0);
/*  49 */         if ((!ishit) && (target.isAlive())) {
/*  50 */           skill.addDodge(releaser, target);
/*     */         }
/*     */         else {
/*  53 */           ReboundHandle.OutPutObj reboundDamageObj = null;
/*     */           
/*  55 */           BeforeAttackHandle.OutputObj attackOutputObj = releaser.handleBeforeAttack(new BeforeAttackHandle.InputObj(releaser, target, skill));
/*     */           
/*  57 */           BeforeAttackHandle.OutputObj targetOutputObj = target.handleBeforeAttack(new BeforeAttackHandle.InputObj(releaser, target, skill));
/*     */           
/*     */ 
/*  60 */           isCrt = FightFormulaHelp.isMagCrt(releaser, target, attackOutputObj, targetOutputObj);
/*     */           
/*  62 */           damage = FightFormulaHelp.calMAGDamage(releaser, target, skill.getTargetSize(), isCrt, attackOutputObj, targetOutputObj);
/*     */           
/*  64 */           damage = (int)(damage * ((this.damagerate + this.modifyrate * i) * 1.0D / FightArgs.getInstance().getDefaultRate()));
/*  65 */           if (damage < 1) {
/*  66 */             damage = 1;
/*     */           }
/*     */           
/*  69 */           DamageHandle.OutputObj damageOutputObj = releaser.handleOnDamage(new mzm.gsp.fight.handle.DamageHandle.InputObj(releaser, target, skill, damage));
/*     */           
/*     */ 
/*  72 */           damage = damageOutputObj.damage;
/*     */           
/*  74 */           BeDamageHandle.OutputObj beDamageRet = target.handleBeDamage(new mzm.gsp.fight.handle.BeDamageHandle.InputObj(releaser, target, skill, damage, effectGroup.getDamageType()));
/*     */           
/*  76 */           reboundDamageObj = target.handleOnRebound(2, damage);
/*  77 */           reboundDamage = reboundDamageObj.reboundDamage;
/*  78 */           int trueDamage = beDamageRet.damage2heal > 0 ? -beDamageRet.damage2heal : beDamageRet.nowDamage;
/*  79 */           boolean isAbsorbDamage = beDamageRet.absorb;
/*     */           
/*     */ 
/*  82 */           int vampireHp = (int)((beDamageRet.nowDamage + beDamageRet.shareDamage) * ((attackOutputObj.magVampirerate + damageOutputObj.vampirerate) * 1.0D / FightArgs.getInstance().getDefaultRate()));
/*     */           
/*  84 */           releaser.addHp(vampireHp);
/*     */           
/*  86 */           target.addHp(releaser, -trueDamage);
/*     */           
/*  88 */           releaser.addDamageToFighter(target, damage);
/*     */           
/*  90 */           AttackResultBean attackResultBean = skill.addDamageRet(trueDamage, vampireHp, isCrt, isAbsorbDamage, releaser, target);
/*     */           
/*  92 */           attackResultBean.attackerstatus.triggerpassiveskills.addAll(attackOutputObj.releasertriggerPassiveSkillids);
/*     */           
/*  94 */           attackResultBean.attackerstatus.triggerpassiveskills.addAll(damageOutputObj.releaserPassiveSkillids);
/*  95 */           attackResultBean.targetstatus.triggerpassiveskills.addAll(targetOutputObj.targetPassiveSkillids);
/*  96 */           attackResultBean.targetstatus.triggerpassiveskills.addAll(beDamageRet.targetPassiveSkillids);
/*  97 */           skill.handleShareDamage(releaser, beDamageRet, attackResultBean);
/*  98 */           if (i == this.damagetimes - 1) {
/*  99 */             skill.afterTargetDamage(releaser, target, reboundDamage, attackResultBean, trueDamage);
/*     */             
/* 101 */             AfterAttackHandle.OutPutObj afterAttackOutPutObj = releaser.handleAfterAttack(skill, releaser, target);
/*     */             
/* 103 */             attackResultBean.attackerstatus.triggerpassiveskills.addAll(afterAttackOutPutObj.releaserPassiveSkills);
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */     }
/* 109 */     else if (effectGroup.getDamageType() == 1) {
/* 110 */       for (int i = 0; i < this.damagetimes; i++) {
/* 111 */         boolean ishit = FightFormulaHelp.isPhyHit(releaser, target, 0);
/* 112 */         if ((!ishit) && (target.isAlive())) {
/* 113 */           skill.addDodge(releaser, target);
/*     */         }
/*     */         else {
/* 116 */           ReboundHandle.OutPutObj reboundDamageObj = null;
/*     */           
/* 118 */           BeforeAttackHandle.OutputObj attackOutputObj = releaser.handleBeforeAttack(new BeforeAttackHandle.InputObj(releaser, target, skill));
/*     */           
/* 120 */           BeforeAttackHandle.OutputObj targetOutputObj = target.handleBeforeAttack(new BeforeAttackHandle.InputObj(releaser, target, skill));
/*     */           
/*     */ 
/* 123 */           isCrt = FightFormulaHelp.isPHyCrt(releaser, target, attackOutputObj, targetOutputObj);
/*     */           
/* 125 */           damage = FightFormulaHelp.calPHYDamage(releaser, target, skill.getTargetSize(), isCrt, attackOutputObj, targetOutputObj);
/*     */           
/* 127 */           damage = (int)(damage * ((this.damagerate + this.modifyrate * i) * 1.0D / FightArgs.getInstance().getDefaultRate()));
/*     */           
/* 129 */           DamageHandle.OutputObj damageOutputObj = releaser.handleOnDamage(new mzm.gsp.fight.handle.DamageHandle.InputObj(releaser, target, skill, damage));
/*     */           
/*     */ 
/* 132 */           damage = damageOutputObj.damage;
/*     */           
/* 134 */           BeDamageHandle.OutputObj beDamageRet = target.handleBeDamage(new mzm.gsp.fight.handle.BeDamageHandle.InputObj(releaser, target, skill, damage, effectGroup.getDamageType()));
/*     */           
/*     */ 
/* 137 */           reboundDamageObj = target.handleOnRebound(1, damage);
/* 138 */           reboundDamage = reboundDamageObj.reboundDamage;
/*     */           
/* 140 */           int trueDamage = beDamageRet.damage2heal > 0 ? -beDamageRet.damage2heal : beDamageRet.nowDamage;
/* 141 */           boolean isAbsorbDamage = beDamageRet.absorb;
/*     */           
/*     */ 
/* 144 */           int vampireHp = (int)((beDamageRet.nowDamage + beDamageRet.shareDamage) * ((attackOutputObj.phyVampirerate + damageOutputObj.vampirerate) * 1.0D / FightArgs.getInstance().getDefaultRate()));
/*     */           
/* 146 */           releaser.addHp(vampireHp);
/*     */           
/*     */ 
/* 149 */           if ((i == 0) && (skill.canBeProtect())) {
/* 150 */             mzm.gsp.fight.main.Fighter.ProtectResult protectResult = target.handleProtect(trueDamage);
/* 151 */             skill.handleProtectResult(releaser, target, protectResult);
/* 152 */             trueDamage = protectResult.getFinalDamage();
/*     */           }
/*     */           
/* 155 */           target.addHp(releaser, -trueDamage);
/* 156 */           releaser.addDamageToFighter(target, damage);
/*     */           
/* 158 */           AttackResultBean attackResultBean = skill.addDamageRet(trueDamage, vampireHp, isCrt, isAbsorbDamage, releaser, target);
/*     */           
/* 160 */           attackResultBean.attackerstatus.triggerpassiveskills.addAll(attackOutputObj.releasertriggerPassiveSkillids);
/*     */           
/* 162 */           attackResultBean.attackerstatus.triggerpassiveskills.addAll(damageOutputObj.releaserPassiveSkillids);
/* 163 */           attackResultBean.targetstatus.triggerpassiveskills.addAll(targetOutputObj.targetPassiveSkillids);
/* 164 */           attackResultBean.targetstatus.triggerpassiveskills.addAll(beDamageRet.targetPassiveSkillids);
/* 165 */           if ((target.isDefense()) && (effectGroup.getDamageType() == 1)) {
/* 166 */             attackResultBean.targetstatus.status_set.add(Integer.valueOf(29));
/*     */           }
/* 168 */           skill.handleShareDamage(releaser, beDamageRet, attackResultBean);
/*     */           
/* 170 */           if (i == this.damagetimes - 1)
/*     */           {
/* 172 */             skill.afterTargetDamage(releaser, target, reboundDamage, attackResultBean, trueDamage);
/*     */             
/* 174 */             AfterAttackHandle.OutPutObj afterAttackOutPutObj = releaser.handleAfterAttack(skill, releaser, target);
/*     */             
/* 176 */             attackResultBean.attackerstatus.triggerpassiveskills.addAll(afterAttackOutPutObj.releaserPassiveSkills);
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */     else {
/* 182 */       GameServer.logger().error("效果组伤害类型不是法术和物理,但是效果组配置了伤害效果!!");
/* 183 */       return false;
/*     */     }
/* 185 */     if ((target.isDead()) || (target.isFakeDead())) {
/* 186 */       FighterEffectGroup addGroup = EffectInterface.getEffectGroup(this.effectid);
/* 187 */       if (addGroup != null) {
/* 188 */         int level = super.getSkillLevel();
/* 189 */         addGroup.run(level, releaser, target, target.getid());
/*     */       } else {
/* 191 */         GameServer.logger().error("不存在的效果组id" + this.effectid);
/*     */       }
/*     */     }
/* 194 */     return true;
/*     */   }
/*     */   
/*     */   public boolean attach(Fighter fighter)
/*     */   {
/* 199 */     return true;
/*     */   }
/*     */   
/*     */   public boolean detach(Fighter fighter)
/*     */   {
/* 204 */     return true;
/*     */   }
/*     */   
/*     */   public boolean validate()
/*     */   {
/* 209 */     FighterEffectGroup effectGroup = EffectInterface.getEffectGroup(this.effectid);
/* 210 */     if (effectGroup == null) {
/* 211 */       throw new RuntimeException("BuffAdd中配置的效果组id不存在:效果组id" + this.effectid);
/*     */     }
/* 213 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\KillEnermyEffect.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */