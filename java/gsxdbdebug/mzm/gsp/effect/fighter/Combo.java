/*     */ package mzm.gsp.effect.fighter;
/*     */ 
/*     */ import java.util.HashSet;
/*     */ import java.util.List;
/*     */ import java.util.Random;
/*     */ import mzm.gsp.fight.AttackResult;
/*     */ import mzm.gsp.fight.AttackResultBean;
/*     */ import mzm.gsp.fight.FighterStatus;
/*     */ import mzm.gsp.fight.handle.AfterAttackHandle.InputObj;
/*     */ import mzm.gsp.fight.handle.AfterAttackHandle.OutPutObj;
/*     */ import mzm.gsp.fight.handle.BeDamageHandle.OutputObj;
/*     */ import mzm.gsp.fight.handle.BeforeAttackHandle.InputObj;
/*     */ import mzm.gsp.fight.handle.BeforeAttackHandle.OutputObj;
/*     */ import mzm.gsp.fight.handle.DamageHandle.OutputObj;
/*     */ import mzm.gsp.fight.handle.ReboundHandle.OutPutObj;
/*     */ import mzm.gsp.fight.main.FightArgs;
/*     */ import mzm.gsp.fight.main.FightFormulaHelp;
/*     */ import mzm.gsp.fight.main.Fighter;
/*     */ import mzm.gsp.fight.main.Fighter.ProtectResult;
/*     */ import mzm.gsp.skill.main.Skill;
/*     */ 
/*     */ public class Combo extends mzm.gsp.effect.main.FighterEffect implements mzm.gsp.fight.handle.AfterAttackHandle
/*     */ {
/*     */   private int times;
/*     */   private int comborate;
/*     */   private int exdamagerate;
/*     */   
/*     */   public Combo(int times, int comborate, int exdamagerate)
/*     */   {
/*  30 */     this.times = times;
/*  31 */     this.comborate = comborate;
/*  32 */     this.exdamagerate = exdamagerate;
/*     */   }
/*     */   
/*     */   public boolean attach(Fighter fighter)
/*     */   {
/*  37 */     fighter.addAfterAttackHandle(this);
/*  38 */     return true;
/*     */   }
/*     */   
/*     */   public boolean detach(Fighter fighter)
/*     */   {
/*  43 */     fighter.remAfterAttackHandle(this);
/*  44 */     return true;
/*     */   }
/*     */   
/*     */   public void afterAttack(AfterAttackHandle.InputObj inputObj, AfterAttackHandle.OutPutObj outPutObj)
/*     */   {
/*  49 */     if (!inputObj.canCombo) {
/*  50 */       return;
/*     */     }
/*  52 */     if ((inputObj.skill == null) || (inputObj.target == null) || (inputObj.releser == null)) {
/*  53 */       return;
/*     */     }
/*  55 */     Skill skill = inputObj.skill;
/*  56 */     Fighter releaser = inputObj.releser;
/*  57 */     Fighter target = inputObj.target;
/*     */     
/*  59 */     if ((skill.getType() == 1) && (mzm.gsp.fight.main.FightInterface.isNormalAttackSkill(skill.getID()))) {
/*  60 */       if ((target.isParry()) && (!releaser.isTech())) {
/*  61 */         return;
/*     */       }
/*  63 */       if ((releaser == null) || (target == null)) {
/*  64 */         return;
/*     */       }
/*  66 */       if ((target.isDead()) || (target.isFakeDead()) || (releaser.isDead()) || (releaser.isFakeDead())) {
/*  67 */         return;
/*     */       }
/*  69 */       int random = xdb.Xdb.random().nextInt(FightArgs.getInstance().getDefaultRate());
/*  70 */       if (this.comborate > random) {
/*  71 */         AttackResult attackResult = skill.getAttackResult(target.getid());
/*  72 */         for (int i = 0; i < this.times; i++) {
/*  73 */           if (target.isDead()) {
/*     */             break;
/*     */           }
/*  76 */           AttackResultBean attackResultBean = new AttackResultBean();
/*     */           
/*  78 */           BeforeAttackHandle.OutputObj outputObj = releaser.handleBeforeAttack(new BeforeAttackHandle.InputObj(releaser, target, skill));
/*     */           
/*     */ 
/*  81 */           BeforeAttackHandle.OutputObj targetOutputObj = target.handleBeforeAttack(new BeforeAttackHandle.InputObj(releaser, target, skill));
/*     */           
/*  83 */           attackResultBean.attackerstatus.triggerpassiveskills.addAll(outputObj.releasertriggerPassiveSkillids);
/*     */           
/*  85 */           boolean ishit = FightFormulaHelp.isPhyHit(releaser, target, 0);
/*  86 */           if (!ishit) {
/*  87 */             skill.addDodge(releaser, target);
/*  88 */             List<AttackResultBean> attackresultbeans = skill.getAttackResult(target.getid()).attackresultbeans;
/*  89 */             int size = attackresultbeans.size();
/*  90 */             if (size > 0) {
/*  91 */               ((AttackResultBean)attackresultbeans.get(size - 1)).targetstatus.status_set.add(Integer.valueOf(24));
/*     */             }
/*     */           }
/*     */           else
/*     */           {
/*  96 */             int damage = 0;
/*     */             
/*  98 */             outputObj.damageRate += this.exdamagerate * i;
/*     */             
/* 100 */             boolean isCrt = FightFormulaHelp.isPHyCrt(releaser, target, outputObj, targetOutputObj);
/*     */             
/* 102 */             damage = FightFormulaHelp.calPHYDamage(releaser, target, skill.getTargetSize(), isCrt, outputObj, targetOutputObj);
/*     */             
/*     */ 
/* 105 */             DamageHandle.OutputObj damageOutputObj = releaser.handleOnDamage(new mzm.gsp.fight.handle.DamageHandle.InputObj(releaser, target, skill, damage));
/*     */             
/*     */ 
/* 108 */             damage = damageOutputObj.damage;
/* 109 */             BeDamageHandle.OutputObj beDamageRet = target.handleBeDamage(new mzm.gsp.fight.handle.BeDamageHandle.InputObj(releaser, target, skill, damage, 1));
/*     */             
/* 111 */             ReboundHandle.OutPutObj reboundOutPutObj = target.handleOnRebound(1, damage);
/* 112 */             int reboundDamage = reboundOutPutObj.reboundDamage;
/* 113 */             boolean isAbsrobDamage = beDamageRet.absorb;
/* 114 */             int trueDamage = beDamageRet.damage2heal > 0 ? -beDamageRet.damage2heal : beDamageRet.nowDamage;
/*     */             
/*     */ 
/* 117 */             int vampireHp = (int)((beDamageRet.nowDamage + beDamageRet.shareDamage) * ((outputObj.phyVampirerate + damageOutputObj.vampirerate) * 1.0D / FightArgs.getInstance().getDefaultRate()));
/*     */             
/*     */ 
/* 120 */             releaser.addHp(vampireHp);
/*     */             
/*     */ 
/* 123 */             if (skill.canBeProtect()) {
/* 124 */               Fighter.ProtectResult protectResult = target.handleProtect(trueDamage);
/* 125 */               skill.handleProtectResult(releaser, target, protectResult);
/* 126 */               trueDamage = protectResult.getFinalDamage();
/*     */             }
/*     */             
/* 129 */             target.addHp(releaser, -trueDamage);
/* 130 */             releaser.addDamageToFighter(target, damage);
/*     */             
/* 132 */             attackResultBean.attackerstatus.hpchange += vampireHp;
/* 133 */             attackResultBean.targetstatus.hpchange -= trueDamage;
/* 134 */             attackResultBean.targetstatus.triggerpassiveskills.addAll(reboundOutPutObj.targetPassiveSkillids);
/* 135 */             attackResultBean.targetstatus.triggerpassiveskills.addAll(targetOutputObj.targetPassiveSkillids);
/* 136 */             attackResultBean.targetstatus.triggerpassiveskills.addAll(beDamageRet.targetPassiveSkillids);
/* 137 */             attackResultBean.targetstatus.status_set.add(Integer.valueOf(20));
/* 138 */             attackResultBean.targetstatus.status_set.add(Integer.valueOf(24));
/* 139 */             if (isCrt) {
/* 140 */               attackResultBean.targetstatus.status_set.add(Integer.valueOf(21));
/*     */             }
/* 142 */             if (isAbsrobDamage) {
/* 143 */               attackResultBean.targetstatus.status_set.add(Integer.valueOf(26));
/*     */             }
/* 145 */             if (target.isDefense()) {
/* 146 */               attackResultBean.targetstatus.status_set.add(Integer.valueOf(29));
/*     */             }
/* 148 */             releaser.fillFighterStatus(attackResultBean.attackerstatus);
/* 149 */             target.fillFighterStatus(attackResultBean.targetstatus);
/* 150 */             int passiveSkillid = getPassiveSkillid();
/* 151 */             if (passiveSkillid > 0) {
/* 152 */               attackResultBean.attackerstatus.triggerpassiveskills.add(Integer.valueOf(passiveSkillid));
/*     */             }
/* 154 */             attackResultBean.attackerstatus.triggerpassiveskills.addAll(damageOutputObj.releaserPassiveSkillids);
/*     */             
/* 156 */             attackResult.attackresultbeans.add(attackResultBean);
/*     */             
/* 158 */             skill.handleShareDamage(releaser, beDamageRet, attackResultBean);
/*     */             
/* 160 */             skill.afterTargetDamage(releaser, target, reboundDamage, attackResultBean, trueDamage);
/*     */             
/* 162 */             if ((releaser.isDead()) || (releaser.isFakeDead())) {
/*     */               break;
/*     */             }
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\Combo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */