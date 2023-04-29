/*     */ package mzm.gsp.fight.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Random;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.effect.main.EffectInterface;
/*     */ import mzm.gsp.effect.main.FighterEffectGroup;
/*     */ import mzm.gsp.fight.AttackResultBean;
/*     */ import mzm.gsp.fight.FighterStatus;
/*     */ import mzm.gsp.fight.confbean.SFightConsts;
/*     */ import mzm.gsp.fight.durationCfg.DurationCfgManager;
/*     */ import mzm.gsp.fight.handle.AfterAttackHandle.OutPutObj;
/*     */ import mzm.gsp.fight.handle.BeDamageHandle.InputObj;
/*     */ import mzm.gsp.fight.handle.BeDamageHandle.OutputObj;
/*     */ import mzm.gsp.fight.handle.BeforeAttackHandle.OutputObj;
/*     */ import mzm.gsp.fight.handle.DamageHandle.InputObj;
/*     */ import mzm.gsp.fight.handle.DamageHandle.OutputObj;
/*     */ import mzm.gsp.fight.handle.ReboundHandle.OutPutObj;
/*     */ import mzm.gsp.skill.confbean.ActionData;
/*     */ import mzm.gsp.skill.confbean.EffectPlayData;
/*     */ import mzm.gsp.skill.confbean.Effectid2LateTime;
/*     */ import mzm.gsp.skill.confbean.SMoveAction;
/*     */ import mzm.gsp.skill.confbean.SSkillEffectGroupCfg;
/*     */ import mzm.gsp.skill.confbean.SSkillPlayCfg;
/*     */ import mzm.gsp.skill.confbean.SSkillPlayStageCfg;
/*     */ import mzm.gsp.skill.main.Skill;
/*     */ import mzm.gsp.skill.main.Skill.Attack;
/*     */ import org.apache.log4j.Logger;
/*     */ import xdb.Xdb;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class FightUtil
/*     */ {
/*     */   public static Set<Fighter> getTargets(Fighter fighter, int targetType1, int targetType2, int targetType3, int targetType4)
/*     */   {
/*  53 */     Set<Fighter> targets = new HashSet();
/*  54 */     if ((targetType1 & 0x4) > 0) {
/*  55 */       Set<Fighter> fighters = fighter.getEnermyFighters();
/*  56 */       targets.addAll(fighters);
/*     */     }
/*  58 */     if ((targetType1 & 0x1) > 0)
/*     */     {
/*  60 */       Set<Fighter> fighters = fighter.getFriendFighters();
/*  61 */       if (fighters.contains(fighter)) {
/*  62 */         fighters.remove(fighter);
/*     */       }
/*  64 */       targets.addAll(fighters);
/*     */     }
/*  66 */     if ((targetType1 & 0x2) > 0) {
/*  67 */       targets.add(fighter);
/*     */     }
/*     */     
/*     */ 
/*  71 */     if ((targetType1 & 0x8) > 0) {
/*  72 */       Set<Fighter> fighters = fighter.getFriendFighters();
/*  73 */       for (Fighter tmpFighter : fighters) {
/*  74 */         if ((fighter.isMyOwner(tmpFighter)) && (!targets.contains(tmpFighter))) {
/*  75 */           targets.add(tmpFighter);
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*  81 */     Iterator<Fighter> it = targets.iterator();
/*  82 */     while (it.hasNext()) {
/*  83 */       Fighter target = (Fighter)it.next();
/*  84 */       if (!isSuit(targetType2, targetType3, targetType4, target)) {
/*  85 */         it.remove();
/*     */       }
/*     */     }
/*  88 */     return targets;
/*     */   }
/*     */   
/*     */   private static boolean isSuit(int targetType2, int targetType3, int targetType4, Fighter target) {
/*  92 */     if (((targetType2 & 0x8) <= 0) && 
/*  93 */       (target.isMonster())) {
/*  94 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  98 */     if (((targetType2 & 0x2) <= 0) && 
/*  99 */       (target.isFellowType())) {
/* 100 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 104 */     if (((targetType2 & 0x4) <= 0) && 
/* 105 */       (target.isPetType())) {
/* 106 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 110 */     if (((targetType2 & 0x1) <= 0) && 
/* 111 */       (target.isRoleType())) {
/* 112 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 116 */     if (((targetType2 & 0x10) <= 0) && 
/* 117 */       (target.isChildType())) {
/* 118 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 123 */     if (((targetType3 & 0x2) <= 0) && 
/* 124 */       (target.isAlive())) {
/* 125 */       return false;
/*     */     }
/*     */     
/* 128 */     if (((targetType3 & 0x1) <= 0) && (
/* 129 */       (target.isFakeDead()) || (target.isDead()))) {
/* 130 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 135 */     if (((targetType4 & 0x2) <= 0) && 
/* 136 */       (target.isNegetive())) {
/* 137 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 141 */     if (((targetType4 & 0x10) <= 0) && 
/* 142 */       (target.isPoison())) {
/* 143 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 147 */     if (((targetType4 & 0x8) <= 0) && 
/* 148 */       (target.isSeal())) {
/* 149 */       return false;
/*     */     }
/*     */     
/* 152 */     if (((targetType4 & 0x4) <= 0) && 
/* 153 */       (target.isPositive())) {
/* 154 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 158 */     if (((targetType4 & 0x1) <= 0) && 
/* 159 */       (!target.isNegetive()) && (!target.isPoison()) && (!target.isSeal())) {
/* 160 */       return false;
/*     */     }
/*     */     
/* 163 */     if (((targetType4 & 0x20) <= 0) && 
/* 164 */       (target.isNotBeHealed())) {
/* 165 */       return false;
/*     */     }
/*     */     
/* 168 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static int getPlayTime(int modelid, int skillplayid, List<Integer> targets, List<Skill.Attack> attacks)
/*     */   {
/* 177 */     if ((targets.size() <= 0) || (attacks.size() <= 0)) {
/* 178 */       return 0;
/*     */     }
/* 180 */     if (targets.size() != attacks.size()) {
/* 181 */       GameServer.logger().error("目标的个数和受到攻击次数的个数不一致");
/* 182 */       return 0;
/*     */     }
/* 184 */     int playTime = 0;
/* 185 */     SSkillPlayCfg skillPlayCfg = SSkillPlayCfg.get(skillplayid);
/* 186 */     if (skillPlayCfg == null) {
/* 187 */       GameServer.logger().error("技能播放id不存在:skillplayid:" + skillplayid);
/* 188 */       playTime = SFightConsts.getInstance().DAMAGE_SKILL_PLAY_TIME;
/* 189 */       return playTime;
/*     */     }
/*     */     
/*     */ 
/* 193 */     SSkillPlayStageCfg prepareStageCfg = SSkillPlayStageCfg.get(skillPlayCfg.prepareStage);
/* 194 */     playTime += calPlayStateTime(modelid, prepareStageCfg);
/*     */     
/* 196 */     switch (skillPlayCfg.skillPlayType)
/*     */     {
/*     */     case 1: 
/* 199 */       Integer attackCount = Integer.valueOf(0);
/* 200 */       for (int i = 0; i < targets.size(); i++) {
/* 201 */         if (attacks.size() > i) {
/* 202 */           attackCount = Integer.valueOf(attackCount.intValue() + ((Skill.Attack)attacks.get(i)).getAttackNormalCount());
/*     */         }
/*     */       }
/* 205 */       if (attackCount.intValue() > 0)
/*     */       {
/*     */ 
/* 208 */         int[] ret = getPlayTimeOneTurn(skillPlayCfg, attacks, modelid, attackCount.intValue());
/* 209 */         playTime += ret[0];
/* 210 */         int leftAttackCount = ret[1];
/* 211 */         int nextTurn = leftAttackCount;
/* 212 */         for (int i = 0; i < nextTurn; i++) {
/* 213 */           int[] next = getPlayTimeOneTurn(skillPlayCfg, attacks, modelid, leftAttackCount);
/* 214 */           playTime += next[0];
/* 215 */           leftAttackCount = next[1];
/* 216 */           if (leftAttackCount <= 0) {
/*     */             break;
/*     */           }
/*     */         }
/*     */       }
/* 221 */       break;
/*     */     case 2: 
/* 223 */       Integer maxAttackCount = Integer.valueOf(0);
/* 224 */       for (Skill.Attack attack : attacks) {
/* 225 */         int count = attack.getAttackNormalCount();
/* 226 */         if (count > maxAttackCount.intValue()) {
/* 227 */           maxAttackCount = Integer.valueOf(count);
/*     */         }
/*     */       }
/*     */       
/* 231 */       if (maxAttackCount.intValue() > 0)
/*     */       {
/*     */ 
/* 234 */         int[] retMult = getPlayTimeOneTurn(skillPlayCfg, attacks, modelid, maxAttackCount.intValue());
/* 235 */         playTime += retMult[0];
/* 236 */         int leftCount = retMult[1];
/* 237 */         int leftTurn = leftCount;
/* 238 */         for (int i = 0; i < leftTurn; i++) {
/* 239 */           int[] next = getPlayTimeOneTurn(skillPlayCfg, attacks, modelid, leftCount);
/* 240 */           playTime += next[0];
/* 241 */           leftCount = next[1];
/* 242 */           if (leftCount <= 0)
/*     */             break;
/*     */         }
/*     */       }
/* 246 */       break;
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     default: 
/* 262 */       GameServer.logger().error("不存在的技能播放类型:skillplayid:" + skillplayid);
/* 263 */       playTime = SFightConsts.getInstance().DAMAGE_SKILL_PLAY_TIME;
/*     */     }
/*     */     
/*     */     
/*     */ 
/* 268 */     SSkillPlayStageCfg returnPlayStageCfg = SSkillPlayStageCfg.get(skillPlayCfg.returnStage);
/* 269 */     playTime += calPlayStateTime(modelid, returnPlayStageCfg);
/* 270 */     return playTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static int[] getPlayTimeOneTurn(SSkillPlayCfg skillPlayCfg, List<Skill.Attack> attacks, int modelid, int attackCount)
/*     */   {
/* 283 */     int[] ret = new int[2];
/* 284 */     if (attacks.size() <= 0) {
/* 285 */       return ret;
/*     */     }
/* 287 */     int max = Math.max(skillPlayCfg.effectStages.size(), skillPlayCfg.moveStages.size());
/* 288 */     int playTime = 0;
/*     */     
/* 290 */     for (int i = 0; i < max; i++) {
/* 291 */       boolean effect = false;
/*     */       
/* 293 */       if ((skillPlayCfg.effectStages.size() > i) && (attackCount > 0)) {
/* 294 */         SSkillPlayStageCfg skillPlayStageCfg = SSkillPlayStageCfg.get(((Integer)skillPlayCfg.effectStages.get(i)).intValue());
/* 295 */         int time = calPlayStateTime(modelid, skillPlayStageCfg);
/* 296 */         playTime += time;
/* 297 */         int count = getAttackCount(modelid, skillPlayStageCfg);
/* 298 */         attackCount -= count;
/* 299 */         if (skillPlayCfg.skillPlayType == 1) {
/* 300 */           if (attacks.size() > 0) {
/* 301 */             Skill.Attack attack = (Skill.Attack)attacks.get(0);
/* 302 */             if (attack.getAttackNormalCount() <= count) {
/* 303 */               attacks.remove(0);
/* 304 */               playTime += time * attack.getComBoCount();
/*     */             } else {
/* 306 */               attack.addNormalCount(-count);
/*     */             }
/*     */           }
/*     */         } else {
/* 310 */           Iterator<Skill.Attack> iterator = attacks.iterator();
/* 311 */           while (iterator.hasNext()) {
/* 312 */             Skill.Attack attack = (Skill.Attack)iterator.next();
/* 313 */             if (attack.getAttackNormalCount() <= count) {
/* 314 */               iterator.remove();
/* 315 */               playTime += time * attack.getComBoCount();
/*     */             } else {
/* 317 */               attack.addNormalCount(-count);
/*     */             }
/*     */           }
/*     */         }
/* 321 */         effect = true;
/*     */       }
/*     */       
/* 324 */       if ((skillPlayCfg.moveStages.size() > i) && (
/* 325 */         (effect) || (attackCount > 0) || (skillPlayCfg.effectStages.size() <= i) || (((Integer)skillPlayCfg.effectStages.get(i)).intValue() <= 0)))
/*     */       {
/* 327 */         SSkillPlayStageCfg moveSkillPlayStageCfg = SSkillPlayStageCfg.get(((Integer)skillPlayCfg.moveStages.get(i)).intValue());
/* 328 */         playTime += calPlayStateTime(modelid, moveSkillPlayStageCfg);
/* 329 */         attackCount -= getAttackCount(modelid, moveSkillPlayStageCfg);
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 334 */     ret[0] = playTime;
/* 335 */     ret[1] = attackCount;
/* 336 */     return ret;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static int calPlayStateTime(int modelid, SSkillPlayStageCfg skillPlayStageCfg)
/*     */   {
/* 347 */     if (skillPlayStageCfg == null) {
/* 348 */       return 0;
/*     */     }
/* 350 */     int needTime = 0;
/* 351 */     if (skillPlayStageCfg.actionid > 0) {
/* 352 */       if (SMoveAction.getAll().containsKey(Integer.valueOf(skillPlayStageCfg.actionid))) {
/* 353 */         SMoveAction sMoveAction = SMoveAction.get(skillPlayStageCfg.actionid);
/* 354 */         needTime = sMoveAction.duration;
/*     */       } else {
/* 356 */         needTime = DurationCfgManager.getActionDuration(modelid, skillPlayStageCfg.actionid);
/*     */       }
/*     */     }
/* 359 */     for (int i = 0; i < skillPlayStageCfg.effectlist.size(); i++) {
/* 360 */       Effectid2LateTime effectid2LateTime = (Effectid2LateTime)skillPlayStageCfg.effectlist.get(i);
/* 361 */       int effectTime = DurationCfgManager.getEffectDuration(modelid, effectid2LateTime.effectid);
/* 362 */       if (effectid2LateTime.lateTime >= 0) {
/* 363 */         effectTime += effectid2LateTime.lateTime;
/*     */       } else {
/* 365 */         List<Integer> lateTimes = DurationCfgManager.getEffectLateTimes(modelid, skillPlayStageCfg.actionid);
/* 366 */         if (lateTimes.size() > i) {
/* 367 */           effectTime += ((Integer)lateTimes.get(i)).intValue();
/*     */         }
/*     */       }
/* 370 */       if (effectTime > needTime) {
/* 371 */         needTime = effectTime;
/*     */       }
/*     */     }
/*     */     
/* 375 */     return needTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static int getAttackCount(int modelid, SSkillPlayStageCfg skillPlayStageCfg)
/*     */   {
/* 384 */     int attackCount = 0;
/* 385 */     if (skillPlayStageCfg == null) {
/* 386 */       return attackCount;
/*     */     }
/* 388 */     if ((skillPlayStageCfg.actionid > 0) && 
/* 389 */       (!SMoveAction.getAll().containsKey(Integer.valueOf(skillPlayStageCfg.actionid))))
/*     */     {
/* 391 */       ActionData action = DurationCfgManager.getAction(modelid, skillPlayStageCfg.actionid);
/* 392 */       if (action != null) {
/* 393 */         attackCount += action.beAttackedList.size();
/*     */       }
/*     */     }
/*     */     
/* 397 */     for (int i = 0; i < skillPlayStageCfg.effectlist.size(); i++) {
/* 398 */       Effectid2LateTime effectid2LateTime = (Effectid2LateTime)skillPlayStageCfg.effectlist.get(i);
/* 399 */       EffectPlayData effectPlayCfg = DurationCfgManager.getEffectPlayCfg(modelid, effectid2LateTime.effectid);
/* 400 */       if (effectPlayCfg != null) {
/* 401 */         attackCount += effectPlayCfg.beAttackedList.size();
/*     */       }
/*     */     }
/* 404 */     return attackCount;
/*     */   }
/*     */   
/*     */ 
/*     */   public static class DamageInputObj
/*     */   {
/*     */     public final BeforeAttackHandle.OutputObj outputObj;
/*     */     
/*     */     public final BeforeAttackHandle.OutputObj tagertOutputObj;
/*     */     
/*     */     public final Fighter releaser;
/*     */     
/*     */     public final Fighter target;
/*     */     
/*     */     public final Skill skill;
/*     */     
/*     */     public final FighterEffectGroup effectGroup;
/*     */     
/*     */     public int bedamagerateToSelf;
/*     */     
/*     */     public DamageInputObj(BeforeAttackHandle.OutputObj outputObj, BeforeAttackHandle.OutputObj tagertOutputObj, Fighter releaser, Fighter target, Skill skill, FighterEffectGroup effectGroup)
/*     */     {
/* 426 */       this.outputObj = outputObj;
/* 427 */       this.tagertOutputObj = tagertOutputObj;
/* 428 */       this.releaser = releaser;
/* 429 */       this.target = target;
/* 430 */       this.skill = skill;
/* 431 */       this.effectGroup = effectGroup;
/*     */     }
/*     */   }
/*     */   
/*     */   public static class DamageOutputObj {
/* 436 */     public boolean isHit = true;
/* 437 */     public int damage = 0;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void handleCommonDamage(DamageInputObj commonDamageInputObj, DamageOutputObj commonDamageOutputObj)
/*     */   {
/* 448 */     boolean isCrt = false;
/* 449 */     int damage = 0;
/* 450 */     int trueDamage = 0;
/* 451 */     int vampireHp = 0;
/* 452 */     boolean absorbDamage = false;
/* 453 */     int reboundDamage = 0;
/*     */     
/* 455 */     BeforeAttackHandle.OutputObj outputObj = commonDamageInputObj.outputObj;
/* 456 */     BeforeAttackHandle.OutputObj tagertOutputObj = commonDamageInputObj.tagertOutputObj;
/*     */     
/* 458 */     Fighter releaser = commonDamageInputObj.releaser;
/* 459 */     Fighter target = commonDamageInputObj.target;
/* 460 */     Skill skill = commonDamageInputObj.skill;
/*     */     
/* 462 */     BeDamageHandle.OutputObj beDamageRet = null;
/* 463 */     ReboundHandle.OutPutObj reboundDamageObj = null;
/* 464 */     DamageHandle.OutputObj damageOutputObj = null;
/*     */     
/* 466 */     if (commonDamageInputObj.effectGroup.getDamageType() == 2)
/*     */     {
/* 468 */       boolean ishit = FightFormulaHelp.isMagHit(releaser, target, 0);
/* 469 */       if (!ishit) {
/* 470 */         skill.addDodge(releaser, target);
/* 471 */         commonDamageOutputObj.isHit = false;
/* 472 */         return;
/*     */       }
/* 474 */       isCrt = FightFormulaHelp.isMagCrt(releaser, target, outputObj, tagertOutputObj);
/*     */       
/* 476 */       damage = FightFormulaHelp.calMAGDamage(releaser, target, skill.getTargetSize(), isCrt, outputObj, tagertOutputObj);
/*     */       
/*     */ 
/* 479 */       damageOutputObj = releaser.handleOnDamage(new DamageHandle.InputObj(releaser, target, skill, damage));
/*     */       
/* 481 */       damage = damageOutputObj.damage;
/* 482 */       if (outputObj.biggerDamageCount > 0) {
/* 483 */         damage = (int)(damage + outputObj.biggerDamageCount * damage * (outputObj.biggerDamageRate * 1.0D / FightArgs.getInstance().getDefaultRate()));
/*     */       }
/*     */       
/*     */ 
/* 487 */       beDamageRet = target.handleBeDamage(new BeDamageHandle.InputObj(releaser, target, skill, damage, commonDamageInputObj.effectGroup.getDamageType()));
/*     */       
/* 489 */       reboundDamageObj = target.handleOnRebound(2, damage);
/* 490 */       reboundDamage = reboundDamageObj.reboundDamage;
/* 491 */       trueDamage = beDamageRet.damage2heal > 0 ? -beDamageRet.damage2heal : beDamageRet.nowDamage;
/* 492 */       absorbDamage = beDamageRet.absorb;
/*     */       
/* 494 */       if (outputObj.vampire)
/*     */       {
/* 496 */         vampireHp = (int)((beDamageRet.nowDamage + beDamageRet.shareDamage) * ((outputObj.magVampirerate + damageOutputObj.vampirerate) * 1.0D / FightArgs.getInstance().getDefaultRate()));
/*     */         
/* 498 */         releaser.addHp(vampireHp);
/*     */       }
/*     */     }
/* 501 */     else if (commonDamageInputObj.effectGroup.getDamageType() == 1) {
/* 502 */       boolean ishit = FightFormulaHelp.isPhyHit(releaser, target, 0);
/* 503 */       if (!ishit) {
/* 504 */         skill.addDodge(releaser, target);
/* 505 */         commonDamageOutputObj.isHit = false;
/* 506 */         return;
/*     */       }
/* 508 */       isCrt = FightFormulaHelp.isPHyCrt(releaser, target, outputObj, tagertOutputObj);
/*     */       
/* 510 */       damage = FightFormulaHelp.calPHYDamage(releaser, target, skill.getTargetSize(), isCrt, outputObj, tagertOutputObj);
/*     */       
/*     */ 
/* 513 */       damageOutputObj = releaser.handleOnDamage(new DamageHandle.InputObj(releaser, target, skill, damage));
/*     */       
/* 515 */       damage = damageOutputObj.damage;
/* 516 */       if (outputObj.biggerDamageCount > 0) {
/* 517 */         damage = (int)(damage + outputObj.biggerDamageCount * damage * (outputObj.biggerDamageRate * 1.0D / FightArgs.getInstance().getDefaultRate()));
/*     */       }
/*     */       
/*     */ 
/* 521 */       beDamageRet = target.handleBeDamage(new BeDamageHandle.InputObj(releaser, target, skill, damage, commonDamageInputObj.effectGroup.getDamageType()));
/*     */       
/* 523 */       reboundDamageObj = target.handleOnRebound(1, damage);
/* 524 */       reboundDamage = reboundDamageObj.reboundDamage;
/* 525 */       trueDamage = beDamageRet.damage2heal > 0 ? -beDamageRet.damage2heal : beDamageRet.nowDamage;
/* 526 */       absorbDamage = beDamageRet.absorb;
/* 527 */       if (outputObj.vampire)
/*     */       {
/* 529 */         vampireHp = (int)((beDamageRet.nowDamage + beDamageRet.shareDamage) * ((outputObj.phyVampirerate + damageOutputObj.vampirerate) * 1.0D / FightArgs.getInstance().getDefaultRate()));
/*     */         
/* 531 */         releaser.addHp(vampireHp);
/*     */       }
/*     */       
/*     */ 
/* 535 */       if (skill.canBeProtect()) {
/* 536 */         Fighter.ProtectResult protectResult = target.handleProtect(trueDamage);
/* 537 */         skill.handleProtectResult(releaser, target, protectResult);
/* 538 */         trueDamage = protectResult.getFinalDamage();
/*     */       }
/*     */     } else {
/* 541 */       GameServer.logger().error(String.format("效果组不是伤害类型，但是确配置了伤害类型的效果|efffectgroupid=%d", new Object[] { Integer.valueOf(commonDamageInputObj.effectGroup.getEffectGroupCfg().id) }));
/*     */       
/*     */ 
/* 544 */       return;
/*     */     }
/*     */     
/* 547 */     target.addHp(releaser, -trueDamage);
/* 548 */     releaser.addDamageToFighter(target, damage);
/*     */     
/*     */ 
/* 551 */     if (outputObj.randomBuffRate > 0) {
/* 552 */       int rate = Xdb.random().nextInt(FightArgs.getInstance().getDefaultRate());
/* 553 */       if (rate < outputObj.randomBuffRate) {
/* 554 */         FighterEffectGroup addEffectGroup = EffectInterface.getEffectGroup(outputObj.randomBuffid);
/* 555 */         if (addEffectGroup != null) {
/* 556 */           addEffectGroup.run(skill.getLevel(), releaser, target, target.getid());
/*     */         } else {
/* 558 */           GameServer.logger().info("不存在的buffid:" + outputObj.randomBuffid);
/*     */         }
/*     */       }
/*     */     }
/* 562 */     if ((trueDamage > 0) && (outputObj.isStealHp)) {
/* 563 */       int stealHp = (int)(trueDamage * (outputObj.stealDamageRate * 1.0D / FightArgs.getInstance().getDefaultRate()));
/*     */       
/* 565 */       releaser.addHp(stealHp);
/* 566 */       vampireHp += stealHp;
/*     */     }
/*     */     
/* 569 */     AttackResultBean attackResultBean = skill.addDamageRet(trueDamage, vampireHp, isCrt, absorbDamage, releaser, target);
/*     */     
/* 571 */     attackResultBean.attackerstatus.triggerpassiveskills.addAll(outputObj.releasertriggerPassiveSkillids);
/* 572 */     attackResultBean.attackerstatus.triggerpassiveskills.addAll(damageOutputObj.releaserPassiveSkillids);
/* 573 */     attackResultBean.targetstatus.triggerpassiveskills.addAll(reboundDamageObj.targetPassiveSkillids);
/* 574 */     attackResultBean.targetstatus.triggerpassiveskills.addAll(tagertOutputObj.targetPassiveSkillids);
/* 575 */     attackResultBean.targetstatus.triggerpassiveskills.addAll(beDamageRet.targetPassiveSkillids);
/* 576 */     skill.handleShareDamage(releaser, beDamageRet, attackResultBean);
/*     */     
/* 578 */     skill.afterTargetDamage(releaser, target, reboundDamage, attackResultBean, trueDamage);
/* 579 */     if ((target.isDefense()) && (commonDamageInputObj.effectGroup.getDamageType() == 1)) {
/* 580 */       attackResultBean.targetstatus.status_set.add(Integer.valueOf(29));
/*     */     }
/*     */     
/* 583 */     AfterAttackHandle.OutPutObj afterAttackObj = releaser.handleAfterAttack(skill, releaser, target);
/* 584 */     attackResultBean.attackerstatus.triggerpassiveskills.addAll(afterAttackObj.releaserPassiveSkills);
/*     */     
/* 586 */     if (commonDamageInputObj.bedamagerateToSelf > 0) {
/* 587 */       FighterStatus afterFighterStatus = skill.getAfterSkillUseFighterStatus();
/* 588 */       int cutSelfHp = (int)(damage * (commonDamageInputObj.bedamagerateToSelf * 1.0D / FightArgs.getInstance().getDefaultRate()));
/*     */       
/* 590 */       afterFighterStatus.hpchange += -cutSelfHp;
/* 591 */       releaser.addHp(-cutSelfHp);
/*     */     }
/*     */     
/* 594 */     commonDamageOutputObj.damage = trueDamage;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\main\FightUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */