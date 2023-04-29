/*     */ package mzm.gsp.effect.fighter;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.LinkedList;
/*     */ import java.util.List;
/*     */ import java.util.Random;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.effect.fighter.Interface.OpOnce;
/*     */ import mzm.gsp.effect.main.FighterEffect;
/*     */ import mzm.gsp.effect.main.FighterEffectGroup;
/*     */ import mzm.gsp.fight.AttackOtherBean;
/*     */ import mzm.gsp.fight.AttackResult;
/*     */ import mzm.gsp.fight.AttackResultBean;
/*     */ import mzm.gsp.fight.FighterStatus;
/*     */ import mzm.gsp.fight.InfluenceOther;
/*     */ import mzm.gsp.fight.handle.AfterAttackHandle.InputObj;
/*     */ import mzm.gsp.fight.handle.AfterAttackHandle.OutPutObj;
/*     */ import mzm.gsp.fight.handle.BeDamageHandle.InputObj;
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
/*     */ import mzm.gsp.skill.confbean.SSkillEffectGroupCfg;
/*     */ import mzm.gsp.skill.main.Skill;
/*     */ import org.apache.log4j.Logger;
/*     */ import xdb.Xdb;
/*     */ 
/*     */ 
/*     */ public class DamageDeadTransfer
/*     */   extends FighterEffect
/*     */   implements OpOnce
/*     */ {
/*     */   private int times;
/*     */   private int damageRate;
/*     */   private int modifyDamage;
/*     */   
/*     */   public DamageDeadTransfer(int hitTimes, int damageRate, int modifyDamage)
/*     */   {
/*  50 */     this.times = hitTimes;
/*  51 */     this.damageRate = damageRate;
/*  52 */     this.modifyDamage = modifyDamage;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean perform(Skill skill, FighterEffectGroup effectGroup, Fighter releaser, Fighter t)
/*     */   {
/*  59 */     AttackResult attackResult = skill.getAttackResult(t.getid());
/*  60 */     AttackResultBean attackResultBean = new AttackResultBean();
/*  61 */     attackResult.attackresultbeans.add(attackResultBean);
/*  62 */     int targetSize = Math.max(skill.getTargetSize(), 1);
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  68 */     Fighter tempFighter = null;
/*  69 */     for (int i = 0; i < this.times; i++) {
/*  70 */       if (((releaser.isDead()) || (releaser.isFakeDead())) && (i > 0)) {
/*  71 */         return true;
/*     */       }
/*  73 */       if (i <= 0) {
/*  74 */         tempFighter = t;
/*  75 */       } else if ((tempFighter.isDead()) || (tempFighter.isFakeDead())) {
/*  76 */         List<Fighter> targets = skill.getTargets(releaser, -1, false);
/*  77 */         int size = targets.size();
/*  78 */         if (size <= 0) {
/*  79 */           return true;
/*     */         }
/*  81 */         int index = Xdb.random().nextInt(size);
/*  82 */         tempFighter = (Fighter)targets.get(index);
/*     */       }
/*     */       
/*  85 */       if (tempFighter == null) {
/*  86 */         return true;
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  97 */       boolean isCrt = false;
/*  98 */       int damage = 0;
/*  99 */       int trueDamage = 0;
/* 100 */       int vampireHp = 0;
/* 101 */       boolean absorbDamage = false;
/* 102 */       int reboundDamage = 0;
/* 103 */       BeforeAttackHandle.OutputObj outputObj = releaser.handleBeforeAttack(new BeforeAttackHandle.InputObj(releaser, tempFighter, skill));
/*     */       
/* 105 */       BeforeAttackHandle.OutputObj tagertOutputObj = tempFighter.handleBeforeAttack(new BeforeAttackHandle.InputObj(releaser, tempFighter, skill));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 111 */       AttackOtherBean attackOtherBean = null;
/*     */       
/* 113 */       if (effectGroup.getDamageType() == 2)
/*     */       {
/* 115 */         boolean ishit = FightFormulaHelp.isMagHit(releaser, tempFighter, 0);
/* 116 */         if (!ishit) {
/* 117 */           if (i == 0) {
/* 118 */             skill.addDodge(releaser, tempFighter, attackResultBean); continue;
/*     */           }
/* 120 */           attackOtherBean = new AttackOtherBean();
/* 121 */           skill.addDodge(releaser, tempFighter, attackOtherBean.attackinnerbean);
/* 122 */           attackOtherBean.targetid = tempFighter.getid();
/* 123 */           attackResultBean.attackothers.add(attackOtherBean);
/*     */           
/* 125 */           continue;
/*     */         }
/* 127 */         isCrt = FightFormulaHelp.isMagCrt(releaser, tempFighter, outputObj, tagertOutputObj);
/*     */         
/* 129 */         damage = FightFormulaHelp.calMAGDamage(releaser, tempFighter, targetSize, isCrt, outputObj, tagertOutputObj);
/*     */         
/*     */ 
/* 132 */         damage = (int)(damage * ((this.damageRate + this.modifyDamage * i) * 1.0D / FightArgs.getInstance().getDefaultRate()));
/* 133 */         if (damage < 1) {
/* 134 */           damage = 1;
/*     */         }
/* 136 */         DamageHandle.OutputObj damageOutputObj = releaser.handleOnDamage(new DamageHandle.InputObj(releaser, tempFighter, skill, damage));
/*     */         
/*     */ 
/* 139 */         damage = damageOutputObj.damage;
/* 140 */         BeDamageHandle.OutputObj beDamageRet = tempFighter.handleBeDamage(new BeDamageHandle.InputObj(releaser, tempFighter, skill, damage, effectGroup.getDamageType()));
/*     */         
/* 142 */         ReboundHandle.OutPutObj rebondOutPutObj = tempFighter.handleOnRebound(2, damage);
/* 143 */         reboundDamage = rebondOutPutObj.reboundDamage;
/* 144 */         trueDamage = beDamageRet.damage2heal > 0 ? -beDamageRet.damage2heal : beDamageRet.nowDamage;
/* 145 */         absorbDamage = beDamageRet.absorb;
/*     */         
/*     */ 
/* 148 */         vampireHp = (int)((beDamageRet.nowDamage + beDamageRet.shareDamage) * ((outputObj.magVampirerate + damageOutputObj.vampirerate) * 1.0D / FightArgs.getInstance().getDefaultRate()));
/*     */         
/* 150 */         releaser.addHp(vampireHp);
/*     */       }
/* 152 */       else if (effectGroup.getDamageType() == 1) {
/* 153 */         boolean ishit = FightFormulaHelp.isPhyHit(releaser, tempFighter, 0);
/* 154 */         if (!ishit)
/*     */         {
/* 156 */           if (i == 0) {
/* 157 */             skill.addDodge(releaser, tempFighter, attackResultBean); continue;
/*     */           }
/* 159 */           attackOtherBean = new AttackOtherBean();
/* 160 */           skill.addDodge(releaser, tempFighter, attackOtherBean.attackinnerbean);
/* 161 */           attackResultBean.attackothers.add(attackOtherBean);
/* 162 */           attackOtherBean.targetid = tempFighter.getid();
/*     */           
/* 164 */           continue;
/*     */         }
/* 166 */         isCrt = FightFormulaHelp.isPHyCrt(releaser, tempFighter, outputObj, tagertOutputObj);
/*     */         
/* 168 */         damage = FightFormulaHelp.calPHYDamage(releaser, tempFighter, targetSize, isCrt, outputObj, tagertOutputObj);
/*     */         
/* 170 */         damage = (int)(damage * ((this.damageRate + this.modifyDamage * i) * 1.0D / FightArgs.getInstance().getDefaultRate()));
/* 171 */         if (damage < 1) {
/* 172 */           damage = 1;
/*     */         }
/* 174 */         DamageHandle.OutputObj damageOutputObj = releaser.handleOnDamage(new DamageHandle.InputObj(releaser, tempFighter, skill, damage));
/*     */         
/*     */ 
/* 177 */         damage = damageOutputObj.damage;
/* 178 */         BeDamageHandle.OutputObj beDamageRet = tempFighter.handleBeDamage(new BeDamageHandle.InputObj(releaser, tempFighter, skill, damage, effectGroup.getDamageType()));
/*     */         
/* 180 */         ReboundHandle.OutPutObj rebondOutPutObj = tempFighter.handleOnRebound(1, damage);
/* 181 */         reboundDamage = rebondOutPutObj.reboundDamage;
/* 182 */         trueDamage = beDamageRet.damage2heal > 0 ? -beDamageRet.damage2heal : beDamageRet.nowDamage;
/* 183 */         absorbDamage = beDamageRet.absorb;
/*     */         
/*     */ 
/* 186 */         vampireHp = (int)((beDamageRet.nowDamage + beDamageRet.shareDamage) * ((outputObj.phyVampirerate + damageOutputObj.vampirerate) * 1.0D / FightArgs.getInstance().getDefaultRate()));
/*     */         
/* 188 */         releaser.addHp(vampireHp);
/*     */         
/*     */ 
/* 191 */         if (skill.canBeProtect()) {
/* 192 */           Fighter.ProtectResult protectResult = tempFighter.handleProtect(trueDamage);
/* 193 */           if (i == 0) {
/* 194 */             skill.handleProtectResult(releaser, tempFighter, protectResult);
/* 195 */             trueDamage = protectResult.getFinalDamage();
/*     */           } else {
/* 197 */             if (attackOtherBean == null) {
/* 198 */               attackOtherBean = new AttackOtherBean();
/* 199 */               attackOtherBean.targetid = tempFighter.getid();
/* 200 */               attackResultBean.attackothers.add(attackOtherBean);
/*     */             }
/* 202 */             skill.handleProtectResult(releaser, tempFighter, protectResult, attackOtherBean.protect);
/* 203 */             trueDamage = protectResult.getFinalDamage();
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 208 */         GameServer.logger().error(String.format("MultiDamageCombo.perform@效果组不是伤害类型，但是确配置了伤害类型的效果|efffectgroupid=%d", new Object[] { Integer.valueOf(effectGroup.getEffectGroupCfg().id) }));
/*     */         
/*     */ 
/* 211 */         return false; }
/*     */       DamageHandle.OutputObj damageOutputObj;
/*     */       ReboundHandle.OutPutObj rebondOutPutObj;
/* 214 */       BeDamageHandle.OutputObj beDamageRet; tempFighter.addHp(releaser, -trueDamage);
/* 215 */       releaser.addDamageToFighter(tempFighter, damage);
/* 216 */       AttackResultBean tempAttackResultBean = null;
/* 217 */       if (i == 0) {
/* 218 */         tempAttackResultBean = skill.addDamageRet(trueDamage, vampireHp, isCrt, absorbDamage, releaser, tempFighter, attackResultBean);
/*     */       }
/*     */       else {
/* 221 */         if (attackOtherBean == null) {
/* 222 */           attackOtherBean = new AttackOtherBean();
/* 223 */           attackOtherBean.targetid = tempFighter.getid();
/* 224 */           attackResultBean.attackothers.add(attackOtherBean);
/*     */         }
/* 226 */         tempAttackResultBean = new AttackResultBean();
/* 227 */         skill.addDamageRet(trueDamage, vampireHp, isCrt, absorbDamage, releaser, tempFighter, tempAttackResultBean);
/*     */       }
/*     */       
/*     */ 
/* 231 */       tempAttackResultBean.attackerstatus.triggerpassiveskills.addAll(outputObj.releasertriggerPassiveSkillids);
/* 232 */       tempAttackResultBean.attackerstatus.triggerpassiveskills.addAll(damageOutputObj.releaserPassiveSkillids);
/* 233 */       tempAttackResultBean.targetstatus.triggerpassiveskills.addAll(rebondOutPutObj.targetPassiveSkillids);
/* 234 */       tempAttackResultBean.targetstatus.triggerpassiveskills.addAll(tagertOutputObj.targetPassiveSkillids);
/* 235 */       tempAttackResultBean.targetstatus.triggerpassiveskills.addAll(beDamageRet.targetPassiveSkillids);
/* 236 */       skill.handleShareDamage(releaser, beDamageRet, tempAttackResultBean);
/* 237 */       if ((tempFighter.isDead()) || (tempFighter.isFakeDead())) {
/* 238 */         KillOtherHandle.InputObj tempInputObj = new KillOtherHandle.InputObj(releaser, tempFighter, tempFighter, skill);
/* 239 */         tempInputObj.hitAagin = false;
/* 240 */         KillOtherHandle.OutputObj tempOutputObj = new KillOtherHandle.OutputObj();
/* 241 */         releaser.handleKillOther(tempInputObj, tempOutputObj);
/* 242 */         tempAttackResultBean.attackerstatus.hpchange += tempOutputObj.addHp;
/* 243 */         tempAttackResultBean.attackerstatus.mpchange += tempOutputObj.addMp;
/* 244 */         BeKilledHandle.OutPutObj outPutObj = tempFighter.handleBeKilled(new BeKilledHandle.InputObj(releaser, tempFighter, skill, trueDamage));
/*     */         
/*     */ 
/* 247 */         if (attackOtherBean != null) {
/* 248 */           attackOtherBean.influenceothers.othermap.putAll(tempFighter.getInfluenceMap());
/*     */         } else {
/* 250 */           skill.addTargetInfluenceMap(tempFighter, tempFighter.getInfluenceMap());
/*     */         }
/* 252 */         tempFighter.clearInfluenceTarget();
/* 253 */         tempAttackResultBean.targetstatus.triggerpassiveskills.addAll(outPutObj.targetPassiveSkillids);
/* 254 */         if (tempFighter.isAlive()) {
/* 255 */           tempAttackResultBean.targetstatus.status_set.remove(Integer.valueOf(1));
/* 256 */           tempAttackResultBean.targetstatus.status_set.add(Integer.valueOf(3));
/* 257 */           FighterStatus fighterStatus = new FighterStatus();
/* 258 */           fighterStatus.status_set.add(Integer.valueOf(23));
/* 259 */           fighterStatus.hpchange += tempFighter.getHp();
/* 260 */           tempFighter.fillFighterStatus(fighterStatus);
/* 261 */           tempAttackResultBean.statusmap.put(Integer.valueOf(1), fighterStatus);
/*     */         }
/*     */       } else {
/* 264 */         if ((reboundDamage > 0) && (releaser.isAlive())) {
/* 265 */           releaser.addHp(tempFighter, -reboundDamage);
/* 266 */           tempFighter.addDamageToFighter(releaser, reboundDamage);
/* 267 */           FighterStatus fighterStatus = new FighterStatus();
/* 268 */           fighterStatus.status_set.add(Integer.valueOf(20));
/* 269 */           releaser.fillFighterStatus(fighterStatus);
/* 270 */           fighterStatus.hpchange -= reboundDamage;
/* 271 */           tempAttackResultBean.statusmap.put(Integer.valueOf(0), fighterStatus);
/* 272 */           if ((releaser.isDead()) || (releaser.isFakeDead())) {
/* 273 */             BeKilledHandle.OutPutObj outPutObj = releaser.handleBeKilled(new BeKilledHandle.InputObj(tempFighter, releaser, skill, reboundDamage));
/*     */             
/*     */ 
/* 276 */             if (attackOtherBean != null) {
/* 277 */               attackOtherBean.influenceothers.othermap.putAll(releaser.getInfluenceMap());
/*     */             } else {
/* 279 */               skill.addTargetInfluenceMap(tempFighter, releaser.getInfluenceMap());
/*     */             }
/* 281 */             releaser.clearInfluenceTarget();
/* 282 */             FighterStatus status = (FighterStatus)tempAttackResultBean.statusmap.get(Integer.valueOf(0));
/* 283 */             status.triggerpassiveskills.addAll(outPutObj.targetPassiveSkillids);
/* 284 */             if (releaser.isAlive()) {
/* 285 */               status.status_set.remove(Integer.valueOf(1));
/* 286 */               status.status_set.add(Integer.valueOf(3));
/*     */               
/* 288 */               FighterStatus releaserReliveStatus = new FighterStatus();
/* 289 */               releaserReliveStatus.hpchange += releaser.getHp();
/* 290 */               releaserReliveStatus.status_set.add(Integer.valueOf(23));
/* 291 */               releaser.fillFighterStatus(releaserReliveStatus);
/* 292 */               tempAttackResultBean.statusmap.put(Integer.valueOf(2), releaserReliveStatus);
/*     */             }
/*     */           }
/*     */         }
/*     */         
/*     */ 
/* 298 */         skill.addCounterAttack(releaser, tempFighter, tempAttackResultBean);
/*     */       }
/* 300 */       if ((tempFighter.isDefense()) && (effectGroup.getDamageType() == 1)) {
/* 301 */         tempAttackResultBean.targetstatus.status_set.add(Integer.valueOf(29));
/*     */       }
/*     */       
/* 304 */       AfterAttackHandle.InputObj inputObj = new AfterAttackHandle.InputObj(skill, releaser, tempFighter);
/* 305 */       inputObj.canCombo = false;
/* 306 */       AfterAttackHandle.OutPutObj afterAttackOutPutObj = releaser.handleAfterAttack(inputObj);
/* 307 */       tempAttackResultBean.attackerstatus.triggerpassiveskills.addAll(afterAttackOutPutObj.releaserPassiveSkills);
/* 308 */       if ((i != 0) && (attackOtherBean != null)) {
/* 309 */         Skill.fillInAttackOtherBeanResult(tempAttackResultBean, attackOtherBean.attackinnerbean);
/*     */       }
/*     */     }
/* 312 */     return true;
/*     */   }
/*     */   
/*     */   public boolean attach(Fighter fighter)
/*     */   {
/* 317 */     return true;
/*     */   }
/*     */   
/*     */   public boolean detach(Fighter fighter)
/*     */   {
/* 322 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\DamageDeadTransfer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */