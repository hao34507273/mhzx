/*     */ package mzm.gsp.effect.fighter;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.LinkedList;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.effect.main.FighterEffectGroup;
/*     */ import mzm.gsp.fight.AttackOtherBean;
/*     */ import mzm.gsp.fight.AttackResult;
/*     */ import mzm.gsp.fight.AttackResultBean;
/*     */ import mzm.gsp.fight.FighterStatus;
/*     */ import mzm.gsp.fight.InfluenceOther;
/*     */ import mzm.gsp.fight.handle.AfterAttackHandle.InputObj;
/*     */ import mzm.gsp.fight.handle.AfterAttackHandle.OutPutObj;
/*     */ import mzm.gsp.fight.handle.BeDamageHandle.OutputObj;
/*     */ import mzm.gsp.fight.handle.BeKilledHandle.InputObj;
/*     */ import mzm.gsp.fight.handle.BeKilledHandle.OutPutObj;
/*     */ import mzm.gsp.fight.handle.BeforeAttackHandle.InputObj;
/*     */ import mzm.gsp.fight.handle.BeforeAttackHandle.OutputObj;
/*     */ import mzm.gsp.fight.handle.DamageHandle.InputObj;
/*     */ import mzm.gsp.fight.handle.DamageHandle.OutputObj;
/*     */ import mzm.gsp.fight.handle.KillOtherHandle.InputObj;
/*     */ import mzm.gsp.fight.handle.KillOtherHandle.OutputObj;
/*     */ import mzm.gsp.fight.handle.ReboundHandle.OutPutObj;
/*     */ import mzm.gsp.fight.main.FightArgs;
/*     */ import mzm.gsp.fight.main.FightFormulaHelp;
/*     */ import mzm.gsp.fight.main.Fighter;
/*     */ import mzm.gsp.fight.main.Fighter.ProtectResult;
/*     */ import mzm.gsp.skill.main.Skill;
/*     */ 
/*     */ public class MultiDamageResetTarget extends mzm.gsp.effect.main.FighterEffect implements mzm.gsp.effect.fighter.Interface.OpOnce
/*     */ {
/*     */   private int skillDamageRate;
/*     */   private int times;
/*     */   private int exdamagerate;
/*     */   private int minskillDamageRate;
/*     */   
/*     */   public MultiDamageResetTarget(int skillDamageRate, int times, int exdamagerate, int minskillDamageRate)
/*     */   {
/*  41 */     this.skillDamageRate = skillDamageRate;
/*  42 */     this.times = Math.min(20, times);
/*  43 */     this.exdamagerate = exdamagerate;
/*  44 */     this.minskillDamageRate = minskillDamageRate;
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean perform(Skill skill, FighterEffectGroup effectGroup, Fighter releaser, Fighter t)
/*     */   {
/*  50 */     Fighter tempFighter = null;
/*  51 */     Map<Integer, Integer> fighter2Count = new HashMap();
/*  52 */     AttackResult attackResult = skill.getAttackResult(t.getid());
/*  53 */     AttackResultBean attackResultBean = new AttackResultBean();
/*  54 */     attackResult.attackresultbeans.add(attackResultBean);
/*  55 */     int targetSize = Math.max(skill.getTargetSize(), 1);
/*  56 */     for (int i = 0; i < this.times; i++) {
/*  57 */       if (((releaser.isDead()) || (releaser.isFakeDead())) && (i > 0))
/*  58 */         return true;
/*     */       int index;
/*  60 */       if (i <= 0) {
/*  61 */         tempFighter = t;
/*     */       } else {
/*  63 */         List<Fighter> targets = skill.getTargets(releaser, -1, false);
/*  64 */         int size = targets.size();
/*  65 */         if (size <= 0) {
/*  66 */           return true;
/*     */         }
/*  68 */         index = xdb.Xdb.random().nextInt(size);
/*  69 */         tempFighter = (Fighter)targets.get(index);
/*     */       }
/*  71 */       int targetid = tempFighter.getid();
/*  72 */       Integer count = (Integer)fighter2Count.get(Integer.valueOf(targetid));
/*  73 */       if (count == null) {
/*  74 */         count = Integer.valueOf(1);
/*     */       } else {
/*  76 */         index = count;Integer localInteger1 = count = Integer.valueOf(count.intValue() + 1);
/*     */       }
/*  78 */       fighter2Count.put(Integer.valueOf(targetid), count);
/*     */       
/*  80 */       boolean isCrt = false;
/*  81 */       int damage = 0;
/*  82 */       int trueDamage = 0;
/*  83 */       int vampireHp = 0;
/*  84 */       boolean absorbDamage = false;
/*  85 */       int reboundDamage = 0;
/*  86 */       BeforeAttackHandle.OutputObj outputObj = releaser.handleBeforeAttack(new BeforeAttackHandle.InputObj(releaser, tempFighter, skill));
/*     */       
/*  88 */       BeforeAttackHandle.OutputObj tagertOutputObj = tempFighter.handleBeforeAttack(new BeforeAttackHandle.InputObj(releaser, tempFighter, skill));
/*     */       
/*     */ 
/*  91 */       int extraDamageRate = this.exdamagerate * (count.intValue() - 1) + this.skillDamageRate;
/*  92 */       extraDamageRate = Math.max(extraDamageRate, this.minskillDamageRate);
/*  93 */       outputObj.damageRate += extraDamageRate;
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*  98 */       AttackOtherBean attackOtherBean = null;
/*     */       
/* 100 */       if (effectGroup.getDamageType() == 2)
/*     */       {
/* 102 */         boolean ishit = FightFormulaHelp.isMagHit(releaser, tempFighter, 0);
/* 103 */         if (!ishit) {
/* 104 */           if (i == 0) {
/* 105 */             skill.addDodge(releaser, tempFighter, attackResultBean); continue;
/*     */           }
/* 107 */           attackOtherBean = new AttackOtherBean();
/* 108 */           skill.addDodge(releaser, tempFighter, attackOtherBean.attackinnerbean);
/* 109 */           attackOtherBean.targetid = tempFighter.getid();
/* 110 */           attackResultBean.attackothers.add(attackOtherBean);
/*     */           
/* 112 */           continue;
/*     */         }
/* 114 */         isCrt = FightFormulaHelp.isMagCrt(releaser, tempFighter, outputObj, tagertOutputObj);
/*     */         
/* 116 */         damage = FightFormulaHelp.calMAGDamage(releaser, tempFighter, targetSize, isCrt, outputObj, tagertOutputObj);
/*     */         
/* 118 */         DamageHandle.OutputObj damageOutputObj = releaser.handleOnDamage(new DamageHandle.InputObj(releaser, tempFighter, skill, damage));
/*     */         
/*     */ 
/* 121 */         damage = damageOutputObj.damage;
/* 122 */         BeDamageHandle.OutputObj beDamageRet = tempFighter.handleBeDamage(new mzm.gsp.fight.handle.BeDamageHandle.InputObj(releaser, tempFighter, skill, damage, effectGroup.getDamageType()));
/*     */         
/* 124 */         ReboundHandle.OutPutObj rebondOutPutObj = tempFighter.handleOnRebound(2, damage);
/* 125 */         reboundDamage = rebondOutPutObj.reboundDamage;
/* 126 */         trueDamage = beDamageRet.damage2heal > 0 ? -beDamageRet.damage2heal : beDamageRet.nowDamage;
/* 127 */         absorbDamage = beDamageRet.absorb;
/*     */         
/*     */ 
/* 130 */         vampireHp = (int)((beDamageRet.nowDamage + beDamageRet.shareDamage) * ((outputObj.magVampirerate + damageOutputObj.vampirerate) * 1.0D / FightArgs.getInstance().getDefaultRate()));
/*     */         
/* 132 */         releaser.addHp(vampireHp);
/*     */       }
/* 134 */       else if (effectGroup.getDamageType() == 1) {
/* 135 */         boolean ishit = FightFormulaHelp.isPhyHit(releaser, tempFighter, 0);
/* 136 */         if (!ishit)
/*     */         {
/* 138 */           if (i == 0) {
/* 139 */             skill.addDodge(releaser, tempFighter, attackResultBean); continue;
/*     */           }
/* 141 */           attackOtherBean = new AttackOtherBean();
/* 142 */           skill.addDodge(releaser, tempFighter, attackOtherBean.attackinnerbean);
/* 143 */           attackResultBean.attackothers.add(attackOtherBean);
/* 144 */           attackOtherBean.targetid = tempFighter.getid();
/*     */           
/* 146 */           continue;
/*     */         }
/* 148 */         isCrt = FightFormulaHelp.isPHyCrt(releaser, tempFighter, outputObj, tagertOutputObj);
/*     */         
/* 150 */         damage = FightFormulaHelp.calPHYDamage(releaser, tempFighter, targetSize, isCrt, outputObj, tagertOutputObj);
/*     */         
/*     */ 
/* 153 */         DamageHandle.OutputObj damageOutputObj = releaser.handleOnDamage(new DamageHandle.InputObj(releaser, tempFighter, skill, damage));
/*     */         
/*     */ 
/* 156 */         damage = damageOutputObj.damage;
/* 157 */         BeDamageHandle.OutputObj beDamageRet = tempFighter.handleBeDamage(new mzm.gsp.fight.handle.BeDamageHandle.InputObj(releaser, tempFighter, skill, damage, effectGroup.getDamageType()));
/*     */         
/* 159 */         ReboundHandle.OutPutObj rebondOutPutObj = tempFighter.handleOnRebound(1, damage);
/* 160 */         reboundDamage = rebondOutPutObj.reboundDamage;
/* 161 */         trueDamage = beDamageRet.damage2heal > 0 ? -beDamageRet.damage2heal : beDamageRet.nowDamage;
/* 162 */         absorbDamage = beDamageRet.absorb;
/*     */         
/*     */ 
/* 165 */         vampireHp = (int)((beDamageRet.nowDamage + beDamageRet.shareDamage) * ((outputObj.phyVampirerate + damageOutputObj.vampirerate) * 1.0D / FightArgs.getInstance().getDefaultRate()));
/*     */         
/* 167 */         releaser.addHp(vampireHp);
/*     */         
/*     */ 
/* 170 */         if (skill.canBeProtect()) {
/* 171 */           Fighter.ProtectResult protectResult = tempFighter.handleProtect(trueDamage);
/* 172 */           if (i == 0) {
/* 173 */             skill.handleProtectResult(releaser, tempFighter, protectResult);
/* 174 */             trueDamage = protectResult.getFinalDamage();
/*     */           } else {
/* 176 */             if (attackOtherBean == null) {
/* 177 */               attackOtherBean = new AttackOtherBean();
/* 178 */               attackOtherBean.targetid = tempFighter.getid();
/* 179 */               attackResultBean.attackothers.add(attackOtherBean);
/*     */             }
/* 181 */             skill.handleProtectResult(releaser, tempFighter, protectResult, attackOtherBean.protect);
/* 182 */             trueDamage = protectResult.getFinalDamage();
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 187 */         mzm.gsp.GameServer.logger().error(String.format("MultiDamageCombo.perform@效果组不是伤害类型，但是确配置了伤害类型的效果|efffectgroupid=%d", new Object[] { Integer.valueOf(effectGroup.getEffectGroupCfg().id) }));
/*     */         
/*     */ 
/* 190 */         return false; }
/*     */       DamageHandle.OutputObj damageOutputObj;
/*     */       ReboundHandle.OutPutObj rebondOutPutObj;
/* 193 */       BeDamageHandle.OutputObj beDamageRet; tempFighter.addHp(releaser, -trueDamage);
/* 194 */       releaser.addDamageToFighter(tempFighter, damage);
/* 195 */       AttackResultBean tempAttackResultBean = null;
/* 196 */       if (i == 0) {
/* 197 */         tempAttackResultBean = skill.addDamageRet(trueDamage, vampireHp, isCrt, absorbDamage, releaser, tempFighter, attackResultBean);
/*     */       }
/*     */       else {
/* 200 */         if (attackOtherBean == null) {
/* 201 */           attackOtherBean = new AttackOtherBean();
/* 202 */           attackOtherBean.targetid = tempFighter.getid();
/* 203 */           attackResultBean.attackothers.add(attackOtherBean);
/*     */         }
/* 205 */         tempAttackResultBean = new AttackResultBean();
/* 206 */         skill.addDamageRet(trueDamage, vampireHp, isCrt, absorbDamage, releaser, tempFighter, tempAttackResultBean);
/*     */       }
/*     */       
/*     */ 
/* 210 */       tempAttackResultBean.attackerstatus.triggerpassiveskills.addAll(outputObj.releasertriggerPassiveSkillids);
/* 211 */       tempAttackResultBean.attackerstatus.triggerpassiveskills.addAll(damageOutputObj.releaserPassiveSkillids);
/* 212 */       tempAttackResultBean.targetstatus.triggerpassiveskills.addAll(rebondOutPutObj.targetPassiveSkillids);
/* 213 */       tempAttackResultBean.targetstatus.triggerpassiveskills.addAll(tagertOutputObj.targetPassiveSkillids);
/* 214 */       tempAttackResultBean.targetstatus.triggerpassiveskills.addAll(beDamageRet.targetPassiveSkillids);
/* 215 */       skill.handleShareDamage(releaser, beDamageRet, tempAttackResultBean);
/* 216 */       if ((tempFighter.isDead()) || (tempFighter.isFakeDead())) {
/* 217 */         KillOtherHandle.InputObj tempInputObj = new KillOtherHandle.InputObj(releaser, tempFighter, tempFighter, skill);
/* 218 */         tempInputObj.hitAagin = false;
/* 219 */         KillOtherHandle.OutputObj tempOutputObj = new KillOtherHandle.OutputObj();
/* 220 */         releaser.handleKillOther(tempInputObj, tempOutputObj);
/* 221 */         tempAttackResultBean.attackerstatus.hpchange += tempOutputObj.addHp;
/* 222 */         tempAttackResultBean.attackerstatus.mpchange += tempOutputObj.addMp;
/* 223 */         BeKilledHandle.OutPutObj outPutObj = tempFighter.handleBeKilled(new BeKilledHandle.InputObj(releaser, tempFighter, skill, trueDamage));
/*     */         
/*     */ 
/* 226 */         if (attackOtherBean != null) {
/* 227 */           attackOtherBean.influenceothers.othermap.putAll(tempFighter.getInfluenceMap());
/*     */         } else {
/* 229 */           skill.addTargetInfluenceMap(tempFighter, tempFighter.getInfluenceMap());
/*     */         }
/* 231 */         tempFighter.clearInfluenceTarget();
/* 232 */         tempAttackResultBean.targetstatus.triggerpassiveskills.addAll(outPutObj.targetPassiveSkillids);
/* 233 */         if (tempFighter.isAlive()) {
/* 234 */           tempAttackResultBean.targetstatus.status_set.remove(Integer.valueOf(1));
/* 235 */           tempAttackResultBean.targetstatus.status_set.add(Integer.valueOf(3));
/* 236 */           FighterStatus fighterStatus = new FighterStatus();
/* 237 */           fighterStatus.status_set.add(Integer.valueOf(23));
/* 238 */           fighterStatus.hpchange += tempFighter.getHp();
/* 239 */           tempFighter.fillFighterStatus(fighterStatus);
/* 240 */           tempAttackResultBean.statusmap.put(Integer.valueOf(1), fighterStatus);
/*     */         }
/*     */       } else {
/* 243 */         if ((reboundDamage > 0) && (releaser.isAlive())) {
/* 244 */           releaser.addHp(tempFighter, -reboundDamage);
/* 245 */           tempFighter.addDamageToFighter(releaser, reboundDamage);
/* 246 */           FighterStatus fighterStatus = new FighterStatus();
/* 247 */           fighterStatus.status_set.add(Integer.valueOf(20));
/* 248 */           releaser.fillFighterStatus(fighterStatus);
/* 249 */           fighterStatus.hpchange -= reboundDamage;
/* 250 */           tempAttackResultBean.statusmap.put(Integer.valueOf(0), fighterStatus);
/* 251 */           if ((releaser.isDead()) || (releaser.isFakeDead())) {
/* 252 */             BeKilledHandle.OutPutObj outPutObj = releaser.handleBeKilled(new BeKilledHandle.InputObj(tempFighter, releaser, skill, reboundDamage));
/*     */             
/*     */ 
/* 255 */             if (attackOtherBean != null) {
/* 256 */               attackOtherBean.influenceothers.othermap.putAll(releaser.getInfluenceMap());
/*     */             } else {
/* 258 */               skill.addTargetInfluenceMap(tempFighter, releaser.getInfluenceMap());
/*     */             }
/* 260 */             releaser.clearInfluenceTarget();
/* 261 */             FighterStatus status = (FighterStatus)tempAttackResultBean.statusmap.get(Integer.valueOf(0));
/* 262 */             status.triggerpassiveskills.addAll(outPutObj.targetPassiveSkillids);
/* 263 */             if (releaser.isAlive()) {
/* 264 */               status.status_set.remove(Integer.valueOf(1));
/* 265 */               status.status_set.add(Integer.valueOf(3));
/*     */               
/* 267 */               FighterStatus releaserReliveStatus = new FighterStatus();
/* 268 */               releaserReliveStatus.hpchange += releaser.getHp();
/* 269 */               releaserReliveStatus.status_set.add(Integer.valueOf(23));
/* 270 */               releaser.fillFighterStatus(releaserReliveStatus);
/* 271 */               tempAttackResultBean.statusmap.put(Integer.valueOf(2), releaserReliveStatus);
/*     */             }
/*     */           }
/*     */         }
/*     */         
/*     */ 
/* 277 */         skill.addCounterAttack(releaser, tempFighter, tempAttackResultBean);
/*     */       }
/* 279 */       if ((tempFighter.isDefense()) && (effectGroup.getDamageType() == 1)) {
/* 280 */         tempAttackResultBean.targetstatus.status_set.add(Integer.valueOf(29));
/*     */       }
/*     */       
/* 283 */       AfterAttackHandle.InputObj inputObj = new AfterAttackHandle.InputObj(skill, releaser, tempFighter);
/* 284 */       inputObj.canCombo = false;
/* 285 */       AfterAttackHandle.OutPutObj afterAttackOutPutObj = releaser.handleAfterAttack(inputObj);
/* 286 */       tempAttackResultBean.attackerstatus.triggerpassiveskills.addAll(afterAttackOutPutObj.releaserPassiveSkills);
/* 287 */       if ((i != 0) && (attackOtherBean != null)) {
/* 288 */         Skill.fillInAttackOtherBeanResult(tempAttackResultBean, attackOtherBean.attackinnerbean);
/*     */       }
/*     */     }
/* 291 */     return true;
/*     */   }
/*     */   
/*     */   public boolean attach(Fighter fighter)
/*     */   {
/* 296 */     return true;
/*     */   }
/*     */   
/*     */   public boolean detach(Fighter fighter)
/*     */   {
/* 301 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\MultiDamageResetTarget.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */