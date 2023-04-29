/*     */ package mzm.gsp.effect.fighter;
/*     */ 
/*     */ import java.util.HashSet;
/*     */ import mzm.gsp.effect.main.FighterEffectGroup;
/*     */ import mzm.gsp.fight.AttackResultBean;
/*     */ import mzm.gsp.fight.FighterStatus;
/*     */ import mzm.gsp.fight.handle.AfterAttackHandle.OutPutObj;
/*     */ import mzm.gsp.fight.handle.BeDamageHandle.InputObj;
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
/*     */ public class RandomDamageEffect extends mzm.gsp.effect.main.FighterEffect implements mzm.gsp.effect.fighter.Interface.OpOnce
/*     */ {
/*     */   private int rate;
/*     */   private int bedamagerate;
/*     */   private int healonce;
/*     */   
/*     */   public RandomDamageEffect(int rate, int bedamagerate, int healonce)
/*     */   {
/*  29 */     this.rate = rate;
/*  30 */     this.bedamagerate = bedamagerate;
/*  31 */     this.healonce = healonce;
/*     */   }
/*     */   
/*     */   public boolean perform(Skill skill, FighterEffectGroup effectGroup, Fighter releaser, Fighter target)
/*     */   {
/*  36 */     boolean isCrt = false;
/*  37 */     int damage = 0;
/*  38 */     int trueDamage = 0;
/*  39 */     int vampireHp = 0;
/*  40 */     boolean absorbDamage = false;
/*  41 */     int reboundDamage = 0;
/*     */     
/*  43 */     BeforeAttackHandle.OutputObj outputObj = releaser.handleBeforeAttack(new BeforeAttackHandle.InputObj(releaser, target, skill));
/*     */     
/*  45 */     BeforeAttackHandle.OutputObj tagertOutputObj = target.handleBeforeAttack(new BeforeAttackHandle.InputObj(releaser, target, skill));
/*     */     
/*     */ 
/*  48 */     boolean handleDamage = false;
/*  49 */     int random = xdb.Xdb.random().nextInt(FightArgs.getInstance().getDefaultRate());
/*  50 */     if (random < this.rate) {
/*  51 */       handleDamage = true;
/*     */     }
/*     */     
/*  54 */     BeDamageHandle.OutputObj beDamageRet = new BeDamageHandle.OutputObj();
/*  55 */     ReboundHandle.OutPutObj reboundOutPutObj = new ReboundHandle.OutPutObj();
/*  56 */     DamageHandle.OutputObj damageOutputObj = new DamageHandle.OutputObj();
/*     */     
/*  58 */     if (effectGroup.getDamageType() == 2)
/*     */     {
/*  60 */       boolean ishit = FightFormulaHelp.isMagHit(releaser, target, 0);
/*  61 */       if (!ishit) {
/*  62 */         skill.addDodge(releaser, target);
/*  63 */         return false;
/*     */       }
/*  65 */       if (handleDamage) {
/*  66 */         isCrt = FightFormulaHelp.isMagCrt(releaser, target, outputObj, tagertOutputObj);
/*     */         
/*  68 */         damage = FightFormulaHelp.calMAGDamage(releaser, target, skill.getTargetSize(), isCrt, outputObj, tagertOutputObj);
/*     */         
/*     */ 
/*     */ 
/*  72 */         outputObj.damageRate += this.bedamagerate;
/*  73 */         damage += FightFormulaHelp.calMAGDamage(releaser, target, skill.getTargetSize(), false, outputObj, tagertOutputObj);
/*     */         
/*     */ 
/*  76 */         damageOutputObj = releaser.handleOnDamage(new DamageHandle.InputObj(releaser, target, skill, damage));
/*     */         
/*  78 */         damage = damageOutputObj.damage;
/*  79 */         beDamageRet = target.handleBeDamage(new BeDamageHandle.InputObj(releaser, target, skill, damage, effectGroup.getDamageType()));
/*     */         
/*  81 */         reboundOutPutObj = target.handleOnRebound(2, damage);
/*  82 */         reboundDamage = reboundOutPutObj.reboundDamage;
/*  83 */         trueDamage = beDamageRet.damage2heal > 0 ? -beDamageRet.damage2heal : beDamageRet.nowDamage;
/*  84 */         absorbDamage = beDamageRet.absorb;
/*     */         
/*  86 */         vampireHp = (int)((beDamageRet.nowDamage + beDamageRet.shareDamage) * ((outputObj.magVampirerate + damageOutputObj.vampirerate) * 1.0D / FightArgs.getInstance().getDefaultRate()));
/*     */         
/*  88 */         releaser.addHp(vampireHp);
/*     */       }
/*     */     }
/*  91 */     else if (effectGroup.getDamageType() == 1) {
/*  92 */       boolean ishit = FightFormulaHelp.isPhyHit(releaser, target, 0);
/*  93 */       if (!ishit) {
/*  94 */         skill.addDodge(releaser, target);
/*  95 */         return false;
/*     */       }
/*  97 */       if (handleDamage) {
/*  98 */         isCrt = FightFormulaHelp.isPHyCrt(releaser, target, outputObj, tagertOutputObj);
/*     */         
/* 100 */         damage = FightFormulaHelp.calPHYDamage(releaser, target, skill.getTargetSize(), isCrt, outputObj, tagertOutputObj);
/*     */         
/*     */ 
/*     */ 
/* 104 */         outputObj.damageRate += this.bedamagerate;
/* 105 */         damage += FightFormulaHelp.calPHYDamage(releaser, target, skill.getTargetSize(), false, outputObj, tagertOutputObj);
/*     */         
/*     */ 
/* 108 */         damageOutputObj = releaser.handleOnDamage(new DamageHandle.InputObj(releaser, target, skill, damage));
/*     */         
/* 110 */         damage = damageOutputObj.damage;
/* 111 */         beDamageRet = target.handleBeDamage(new BeDamageHandle.InputObj(releaser, target, skill, damage, effectGroup.getDamageType()));
/*     */         
/* 113 */         reboundOutPutObj = target.handleOnRebound(2, damage);
/* 114 */         reboundDamage = reboundOutPutObj.reboundDamage;
/* 115 */         trueDamage = beDamageRet.damage2heal > 0 ? -beDamageRet.damage2heal : beDamageRet.nowDamage;
/* 116 */         absorbDamage = beDamageRet.absorb;
/*     */         
/*     */ 
/* 119 */         vampireHp = (int)((beDamageRet.nowDamage + beDamageRet.shareDamage) * ((outputObj.phyVampirerate + damageOutputObj.vampirerate) * 1.0D / FightArgs.getInstance().getDefaultRate()));
/*     */         
/* 121 */         releaser.addHp(vampireHp);
/*     */         
/*     */ 
/* 124 */         if (skill.canBeProtect()) {
/* 125 */           Fighter.ProtectResult protectResult = target.handleProtect(trueDamage);
/* 126 */           skill.handleProtectResult(releaser, target, protectResult);
/* 127 */           trueDamage = protectResult.getFinalDamage();
/*     */         }
/*     */       }
/*     */     } else {
/* 131 */       mzm.gsp.GameServer.logger().error(String.format("RandomDamageEffect.perform@效果组不是伤害类型，但是确配置了伤害类型的效果|efffectgroupid=%d", new Object[] { Integer.valueOf(effectGroup.getEffectGroupCfg().id) }));
/*     */       
/*     */ 
/* 134 */       return false;
/*     */     }
/*     */     
/* 137 */     if (handleDamage) {
/* 138 */       target.addHp(releaser, -trueDamage);
/* 139 */       releaser.addDamageToFighter(target, damage);
/*     */       
/* 141 */       AttackResultBean attackResultBean = skill.addDamageRet(trueDamage, vampireHp, isCrt, absorbDamage, releaser, target);
/*     */       
/* 143 */       attackResultBean.attackerstatus.triggerpassiveskills.addAll(outputObj.releasertriggerPassiveSkillids);
/* 144 */       attackResultBean.attackerstatus.triggerpassiveskills.addAll(damageOutputObj.releaserPassiveSkillids);
/* 145 */       attackResultBean.targetstatus.triggerpassiveskills.addAll(reboundOutPutObj.targetPassiveSkillids);
/* 146 */       attackResultBean.targetstatus.triggerpassiveskills.addAll(tagertOutputObj.targetPassiveSkillids);
/* 147 */       attackResultBean.targetstatus.triggerpassiveskills.addAll(beDamageRet.targetPassiveSkillids);
/* 148 */       skill.handleShareDamage(releaser, beDamageRet, attackResultBean);
/*     */       
/* 150 */       skill.afterTargetDamage(releaser, target, reboundDamage, attackResultBean, trueDamage);
/* 151 */       if ((target.isDefense()) && (effectGroup.getDamageType() == 1)) {
/* 152 */         attackResultBean.targetstatus.status_set.add(Integer.valueOf(29));
/*     */       }
/*     */       
/* 155 */       AfterAttackHandle.OutPutObj afterAttackOutPutObj = releaser.handleAfterAttack(skill, releaser, target);
/* 156 */       attackResultBean.attackerstatus.triggerpassiveskills.addAll(afterAttackOutPutObj.releaserPassiveSkills);
/*     */     } else {
/* 158 */       skill.addHealHpRet(releaser, target, this.healonce, false);
/*     */     }
/*     */     
/* 161 */     return true;
/*     */   }
/*     */   
/*     */   public boolean attach(Fighter fighter)
/*     */   {
/* 166 */     return true;
/*     */   }
/*     */   
/*     */   public boolean detach(Fighter fighter)
/*     */   {
/* 171 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\RandomDamageEffect.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */