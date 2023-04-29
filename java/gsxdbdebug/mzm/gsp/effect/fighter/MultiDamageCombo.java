/*     */ package mzm.gsp.effect.fighter;
/*     */ 
/*     */ import java.util.HashSet;
/*     */ import java.util.Random;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.effect.main.FighterEffect;
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
/*     */ import mzm.gsp.skill.confbean.SSkillEffectGroupCfg;
/*     */ import mzm.gsp.skill.main.Skill;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ public class MultiDamageCombo extends FighterEffect implements mzm.gsp.effect.fighter.Interface.OpOnce
/*     */ {
/*     */   private int times;
/*     */   private int combotrate;
/*     */   private int exdamagerate;
/*     */   private int maxtime;
/*     */   private int modifyrate;
/*     */   
/*     */   public MultiDamageCombo(int times, int combotrate, int exdamagerate, int maxtime, int modifyrate)
/*     */   {
/*  36 */     this.times = times;
/*  37 */     this.combotrate = combotrate;
/*  38 */     this.exdamagerate = exdamagerate;
/*  39 */     this.maxtime = maxtime;
/*  40 */     if (this.maxtime < times) {
/*  41 */       this.maxtime = times;
/*     */     }
/*  43 */     if (this.maxtime > 20) {
/*  44 */       this.maxtime = 20;
/*     */     }
/*  46 */     this.modifyrate = modifyrate;
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean perform(Skill skill, FighterEffectGroup effectGroup, Fighter releaser, Fighter target)
/*     */   {
/*  52 */     boolean isCrt = false;
/*  53 */     int damage = 0;
/*  54 */     int trueDamage = 0;
/*  55 */     int vampireHp = 0;
/*  56 */     boolean absorbDamage = false;
/*  57 */     int reboundDamage = 0;
/*  58 */     BeforeAttackHandle.OutputObj outputObj = releaser.handleBeforeAttack(new BeforeAttackHandle.InputObj(releaser, target, skill));
/*     */     
/*  60 */     BeforeAttackHandle.OutputObj tagertOutputObj = target.handleBeforeAttack(new BeforeAttackHandle.InputObj(releaser, target, skill));
/*     */     
/*  62 */     outputObj.damageRate += this.exdamagerate;
/*     */     
/*  64 */     for (int i = 0; i < this.maxtime; i++) {
/*  65 */       if ((target.isDead()) || (target.isFakeDead()) || (releaser.isDead()) || (releaser.isFakeDead())) {
/*     */         break;
/*     */       }
/*  68 */       if (i >= this.times) {
/*  69 */         int rate = xdb.Xdb.random().nextInt(FightArgs.getInstance().getDefaultRate());
/*  70 */         if (this.combotrate <= rate) {}
/*     */ 
/*     */       }
/*     */       else
/*     */       {
/*     */ 
/*  76 */         if (i > 0) {
/*  77 */           outputObj.damageRate += this.modifyrate;
/*     */         }
/*     */         
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  84 */         if (effectGroup.getDamageType() == 2)
/*     */         {
/*  86 */           boolean ishit = FightFormulaHelp.isMagHit(releaser, target, 0);
/*  87 */           if (!ishit) {
/*  88 */             skill.addDodge(releaser, target);
/*  89 */             continue;
/*     */           }
/*  91 */           isCrt = FightFormulaHelp.isMagCrt(releaser, target, outputObj, tagertOutputObj);
/*     */           
/*  93 */           damage = FightFormulaHelp.calMAGDamage(releaser, target, skill.getTargetSize(), isCrt, outputObj, tagertOutputObj);
/*     */           
/*  95 */           DamageHandle.OutputObj damageOutputObj = releaser.handleOnDamage(new DamageHandle.InputObj(releaser, target, skill, damage));
/*     */           
/*  97 */           damage = damageOutputObj.damage;
/*  98 */           BeDamageHandle.OutputObj beDamageRet = target.handleBeDamage(new BeDamageHandle.InputObj(releaser, target, skill, damage, effectGroup.getDamageType()));
/*     */           
/* 100 */           ReboundHandle.OutPutObj rebondOutPutObj = target.handleOnRebound(2, damage);
/* 101 */           reboundDamage = rebondOutPutObj.reboundDamage;
/* 102 */           trueDamage = beDamageRet.damage2heal > 0 ? -beDamageRet.damage2heal : beDamageRet.nowDamage;
/* 103 */           absorbDamage = beDamageRet.absorb;
/*     */           
/*     */ 
/* 106 */           vampireHp = (int)((beDamageRet.nowDamage + beDamageRet.shareDamage) * ((outputObj.magVampirerate + damageOutputObj.vampirerate) * 1.0D / FightArgs.getInstance().getDefaultRate()));
/*     */           
/* 108 */           releaser.addHp(vampireHp);
/*     */         }
/* 110 */         else if (effectGroup.getDamageType() == 1) {
/* 111 */           boolean ishit = FightFormulaHelp.isPhyHit(releaser, target, 0);
/* 112 */           if (!ishit) {
/* 113 */             skill.addDodge(releaser, target);
/* 114 */             continue;
/*     */           }
/* 116 */           isCrt = FightFormulaHelp.isPHyCrt(releaser, target, outputObj, tagertOutputObj);
/*     */           
/* 118 */           damage = FightFormulaHelp.calPHYDamage(releaser, target, skill.getTargetSize(), isCrt, outputObj, tagertOutputObj);
/*     */           
/*     */ 
/* 121 */           DamageHandle.OutputObj damageOutputObj = releaser.handleOnDamage(new DamageHandle.InputObj(releaser, target, skill, damage));
/*     */           
/* 123 */           damage = damageOutputObj.damage;
/* 124 */           BeDamageHandle.OutputObj beDamageRet = target.handleBeDamage(new BeDamageHandle.InputObj(releaser, target, skill, damage, effectGroup.getDamageType()));
/*     */           
/* 126 */           ReboundHandle.OutPutObj rebondOutPutObj = target.handleOnRebound(1, damage);
/* 127 */           reboundDamage = rebondOutPutObj.reboundDamage;
/* 128 */           trueDamage = beDamageRet.damage2heal > 0 ? -beDamageRet.damage2heal : beDamageRet.nowDamage;
/* 129 */           absorbDamage = beDamageRet.absorb;
/*     */           
/*     */ 
/* 132 */           vampireHp = (int)((beDamageRet.nowDamage + beDamageRet.shareDamage) * ((outputObj.phyVampirerate + damageOutputObj.vampirerate) * 1.0D / FightArgs.getInstance().getDefaultRate()));
/*     */           
/* 134 */           releaser.addHp(vampireHp);
/*     */           
/*     */ 
/* 137 */           if (skill.canBeProtect()) {
/* 138 */             Fighter.ProtectResult protectResult = target.handleProtect(trueDamage);
/* 139 */             skill.handleProtectResult(releaser, target, protectResult);
/* 140 */             trueDamage = protectResult.getFinalDamage();
/*     */           }
/*     */         } else {
/* 143 */           GameServer.logger().error(String.format("MultiDamageCombo.perform@效果组不是伤害类型，但是确配置了伤害类型的效果|efffectgroupid=%d", new Object[] { Integer.valueOf(effectGroup.getEffectGroupCfg().id) }));
/*     */           
/*     */ 
/* 146 */           return false; }
/*     */         DamageHandle.OutputObj damageOutputObj;
/*     */         ReboundHandle.OutPutObj rebondOutPutObj;
/* 149 */         BeDamageHandle.OutputObj beDamageRet; target.addHp(releaser, -trueDamage);
/* 150 */         releaser.addDamageToFighter(target, damage);
/*     */         
/* 152 */         AttackResultBean attackResultBean = skill.addDamageRet(trueDamage, vampireHp, isCrt, absorbDamage, releaser, target);
/*     */         
/* 154 */         if ((i <= 0) || 
/*     */         
/*     */ 
/* 157 */           (i == 0)) {
/* 158 */           attackResultBean.attackerstatus.triggerpassiveskills.addAll(outputObj.releasertriggerPassiveSkillids);
/*     */         }
/* 160 */         attackResultBean.attackerstatus.triggerpassiveskills.addAll(damageOutputObj.releaserPassiveSkillids);
/* 161 */         attackResultBean.targetstatus.triggerpassiveskills.addAll(rebondOutPutObj.targetPassiveSkillids);
/* 162 */         attackResultBean.targetstatus.triggerpassiveskills.addAll(tagertOutputObj.targetPassiveSkillids);
/* 163 */         attackResultBean.targetstatus.triggerpassiveskills.addAll(beDamageRet.targetPassiveSkillids);
/* 164 */         skill.handleShareDamage(releaser, beDamageRet, attackResultBean);
/*     */         
/* 166 */         skill.afterTargetDamage(releaser, target, reboundDamage, attackResultBean, trueDamage);
/* 167 */         if ((target.isDefense()) && (effectGroup.getDamageType() == 1)) {
/* 168 */           attackResultBean.targetstatus.status_set.add(Integer.valueOf(29));
/*     */         }
/*     */         
/* 171 */         AfterAttackHandle.OutPutObj afterAttackOutPutObj = releaser.handleAfterAttack(skill, releaser, target);
/* 172 */         attackResultBean.attackerstatus.triggerpassiveskills.addAll(afterAttackOutPutObj.releaserPassiveSkills);
/*     */       } }
/* 174 */     return true;
/*     */   }
/*     */   
/*     */   public boolean attach(Fighter fighter)
/*     */   {
/* 179 */     return true;
/*     */   }
/*     */   
/*     */   public boolean detach(Fighter fighter)
/*     */   {
/* 184 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\MultiDamageCombo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */