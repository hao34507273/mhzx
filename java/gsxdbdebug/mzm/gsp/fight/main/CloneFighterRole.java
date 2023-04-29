/*     */ package mzm.gsp.fight.main;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collection;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Random;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.changemodelcard.main.ChangeModelCardInterface.ClassLevelEntry;
/*     */ import mzm.gsp.children.confbean.SChildrenConsts;
/*     */ import mzm.gsp.children.main.ChildrenInterface;
/*     */ import mzm.gsp.children.main.ChildrenOutFightObj;
/*     */ import mzm.gsp.fight.OpSummonChild;
/*     */ import mzm.gsp.fight.OpSummonPet;
/*     */ import mzm.gsp.fight.Play;
/*     */ import mzm.gsp.fight.PlaySummon;
/*     */ import mzm.gsp.fight.confbean.SFightConsts;
/*     */ import mzm.gsp.fight.confbean.SFightTypeCfg;
/*     */ import mzm.gsp.fight.handle.BeforeUseSkilHandle.OutputObj;
/*     */ import mzm.gsp.monster.main.Monster;
/*     */ import mzm.gsp.monster.main.MonsterInterface;
/*     */ import mzm.gsp.mounts.main.MountsInterface.ChiefBattleMountsObj;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.pet.main.Pet;
/*     */ import mzm.gsp.pet.main.PetInterface;
/*     */ import mzm.gsp.pet.main.PetOutFightObj;
/*     */ import mzm.gsp.pvc.confbean.PVCRobotCfg;
/*     */ import mzm.gsp.pvc.confbean.SPVCCfg;
/*     */ import mzm.gsp.role.main.RoleOutFightObj;
/*     */ import mzm.gsp.skill.confbean.SMountsSkillCfg;
/*     */ import mzm.gsp.skill.confbean.SSkillCfg;
/*     */ import mzm.gsp.skill.main.Skill;
/*     */ import mzm.gsp.skill.main.Skill.Attack;
/*     */ import mzm.gsp.skill.main.SkillInterface;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.FighterMounts;
/*     */ import xdb.Xdb;
/*     */ 
/*     */ class CloneFighterRole extends Fighter implements CloneFighter
/*     */ {
/*     */   CloneFighterRole(int fighterid, xbean.Fighter xFighter, FightGroup fightGroup)
/*     */   {
/*  50 */     super(fighterid, xFighter, fightGroup);
/*  51 */     setExtra(FighterExtra.CLONE_MINI_TYPE, 1);
/*     */   }
/*     */   
/*     */   protected void init(RoleOutFightObj role, int pos, Map<Integer, Integer> attrsMap, Map<Integer, Integer> exaAttrsMap)
/*     */   {
/*  56 */     setPos(pos);
/*     */     
/*     */ 
/*  59 */     getAttrsMap().putAll(attrsMap);
/*     */     
/*  61 */     getExa_AttrsMap().putAll(exaAttrsMap);
/*     */     
/*  63 */     setHp((int)getMaxHp());
/*  64 */     setMp((int)getMaxMp());
/*  65 */     setGender(role);
/*  66 */     setOccupation(role.getOccupationId());
/*     */     
/*  68 */     int anger = getMaxAnger();
/*  69 */     SFightTypeCfg fightTypeCfg = FightConfigManager.getInstance().getFightTypeCfg(this.fightGroup.getFight().getCfgType());
/*     */     
/*  71 */     int angerMax = fightTypeCfg.enterFightAngerMax;
/*  72 */     setAnger(Math.min(anger, angerMax));
/*  73 */     String aiName = FightConfigManager.getInstance().getPVCAIString(role.getOccupationId());
/*  74 */     if (this.fightGroup.getGroupAI() == null) {
/*  75 */       setAi(new AI(aiName).getAi());
/*     */     }
/*     */     
/*     */ 
/*  79 */     List<Skill> skills = role.getActiveSkills();
/*     */     
/*  81 */     for (Skill skill : skills) {
/*  82 */       addSkill(skill.getID(), skill.getLevel());
/*     */     }
/*  84 */     List<mzm.gsp.skill.main.PassiveSkill> passiveSkills = role.getPassiveSkills();
/*  85 */     installPassiveSkills(passiveSkills);
/*     */     
/*     */ 
/*  88 */     MountsInterface.ChiefBattleMountsObj chiefBattleMountsObj = mzm.gsp.mounts.main.MountsInterface.getChiefBattlMounts(role.getId(), true);
/*  89 */     if (chiefBattleMountsObj != null) {
/*  90 */       this.xFighter.getFightermounts().setMountcfgid(chiefBattleMountsObj.getMountsCfgId());
/*  91 */       this.xFighter.getFightermounts().setMountuuid(chiefBattleMountsObj.getMountsId());
/*  92 */       this.xFighter.getFightermounts().getSkillmap().putAll(chiefBattleMountsObj.getMountsActiveSkillMap());
/*     */     }
/*  94 */     initOutFightCommon(role);
/*     */   }
/*     */   
/*     */   protected long getRoleid() {
/*  98 */     return this.fightGroup.getRoleid();
/*     */   }
/*     */   
/*     */   protected boolean canPlayerOperate()
/*     */   {
/* 103 */     return false;
/*     */   }
/*     */   
/*     */   protected boolean isAuto()
/*     */   {
/* 108 */     return true;
/*     */   }
/*     */   
/*     */   protected int getAutoSkill()
/*     */   {
/* 113 */     for (Iterator i$ = getActiveSkills().iterator(); i$.hasNext();) { int skillid = ((Integer)i$.next()).intValue();
/* 114 */       int skillLV = getSkillLevel(skillid);
/* 115 */       Skill skill = SkillInterface.getSkill(skillid, skillLV);
/* 116 */       if (canChoiceSkill(skill)) {
/* 117 */         return skillid;
/*     */       }
/*     */     }
/* 120 */     return getNormalSkill();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   protected void setAuto() {}
/*     */   
/*     */ 
/*     */   void onDead()
/*     */   {
/* 130 */     setFakeDead();
/* 131 */     super.onFighterDead();
/*     */   }
/*     */   
/*     */   protected void setDead()
/*     */   {
/* 136 */     super.setFakeDead();
/*     */   }
/*     */   
/*     */   protected void onFightEnd()
/*     */   {
/* 141 */     this.fightGroup.addLeaveFightFighter(this);
/* 142 */     this.fightGroup.removeFighter(this.fighterid);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected mzm.gsp.common.IOutFightObject getOutFightObj()
/*     */   {
/* 152 */     return mzm.gsp.role.main.RoleInterface.getRoleOutFightObject(this.fightGroup.getRoleid());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   void broadCastSelectOperInTeam() {}
/*     */   
/*     */ 
/*     */   public boolean isMyOwner(Fighter fighter)
/*     */   {
/* 162 */     return false;
/*     */   }
/*     */   
/*     */   public boolean carryPet()
/*     */   {
/* 167 */     Set<Fighter> fighters = this.fightGroup.getExistedFighters();
/* 168 */     for (Fighter fighter : fighters) {
/* 169 */       if (fighter.isPetType()) {
/* 170 */         return true;
/*     */       }
/*     */     }
/* 173 */     return false;
/*     */   }
/*     */   
/*     */   public boolean carryChild()
/*     */   {
/* 178 */     Set<Fighter> fighters = this.fightGroup.getExistedFighters();
/* 179 */     for (Fighter fighter : fighters) {
/* 180 */       if (fighter.isChildType()) {
/* 181 */         return true;
/*     */       }
/*     */     }
/* 184 */     return false;
/*     */   }
/*     */   
/*     */   protected void excuteOpSummonPet(OpSummonPet opSummonPet, ExcuteCmdResult excuteCmdResult)
/*     */   {
/* 189 */     if ((isSeal()) && 
/* 190 */       (isSealSummon())) {
/* 191 */       return;
/*     */     }
/*     */     
/* 194 */     long petUUid = opSummonPet.pet_uuid;
/* 195 */     if (!PetInterface.isCanJoinFight(getRoleid(), petUUid, true)) {
/* 196 */       return;
/*     */     }
/*     */     
/* 199 */     if (this.fightGroup.hasSummonBackPet(petUUid)) {
/* 200 */       return;
/*     */     }
/*     */     
/* 203 */     int summonTimes = this.fightGroup.getExtra(FightGroupExtra.Summon_pet_times);
/* 204 */     if (summonTimes >= SFightConsts.getInstance().SUMMON_TIMES) {
/* 205 */       return;
/*     */     }
/*     */     
/* 208 */     Pet pet = PetInterface.getPetByPetId(getRoleid(), petUUid, true);
/* 209 */     if (pet == null) {
/* 210 */       return;
/*     */     }
/*     */     
/*     */ 
/* 214 */     Map<Long, CloneFighterPet> petidToFighter = new HashMap();
/* 215 */     for (Fighter fighter : this.fightGroup.getFighters()) {
/* 216 */       if (fighter.isClonePet()) {
/* 217 */         CloneFighterPet cloneFighterPet = (CloneFighterPet)fighter;
/* 218 */         petidToFighter.put(Long.valueOf(cloneFighterPet.getUuid()), cloneFighterPet);
/*     */       }
/*     */     }
/* 221 */     PlaySummon playSummon = new PlaySummon();
/* 222 */     if (petidToFighter.containsKey(Long.valueOf(petUUid)))
/*     */     {
/* 224 */       CloneFighterPet fighter = (CloneFighterPet)petidToFighter.get(Long.valueOf(petUUid));
/* 225 */       if ((fighter.isDead()) || (fighter.isEscaped()))
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/* 230 */         return;
/*     */       }
/* 232 */       List<Fighter> fighters = new ArrayList();
/* 233 */       fighters.add(fighter);
/* 234 */       fillPlaySummonResult(playSummon, 0, this.fighterid, fighters);
/* 235 */       Skill.Attack attack0 = new Skill.Attack();
/* 236 */       attack0.addNormalCount(1);
/* 237 */       List<Skill.Attack> attacks = new ArrayList();
/* 238 */       attacks.add(attack0);
/* 239 */       int playTime = FightUtil.getPlayTime(getModelid(), SFightConsts.getInstance().SUMMON_SKILL_PLAYId, Arrays.asList(new Integer[] { Integer.valueOf(fighter.fighterid) }), attacks);
/*     */       
/* 241 */       excuteCmdResult.addPlayTime(playTime);
/*     */       
/* 243 */       fighter.onFightEnd();
/*     */     }
/*     */     else
/*     */     {
/* 247 */       for (Map.Entry<Long, CloneFighterPet> entry : petidToFighter.entrySet()) {
/* 248 */         CloneFighterPet fighter = (CloneFighterPet)entry.getValue();
/* 249 */         if (fighter.isAlive()) {
/* 250 */           this.fightGroup.removeFighter(fighter.getid());
/*     */           
/* 252 */           fighter.onFightEnd();
/*     */         }
/*     */       }
/*     */       
/*     */ 
/* 257 */       int petPos = -1 * FightManager.getPosNumberPerRow() + getPos();
/*     */       
/* 259 */       CloneFighterPet cloneFighterPet = this.fightGroup.generateCloneFighterPet();
/*     */       
/* 261 */       Map<Integer, Integer> attrsMap = new HashMap();
/* 262 */       Map<Integer, Integer> exaAttrsMap = new HashMap();
/* 263 */       PetOutFightObj petOutFightObj = PetInterface.getPetOutFightObjById(getRoleid(), petUUid);
/* 264 */       if (OpenInterface.getOpenStatus(239)) {
/* 265 */         petOutFightObj.fillFinalPropertyMap(attrsMap);
/*     */       } else {
/* 267 */         petOutFightObj.fillSelfFixFightProperty(attrsMap);
/* 268 */         petOutFightObj.fillOtherFightProperty(exaAttrsMap);
/*     */       }
/*     */       
/* 271 */       int pvcid = this.fightGroup.getExtra(FightGroupExtra.PVC_Cfg_Id);
/* 272 */       SPVCCfg spvcCfg = SPVCCfg.get(pvcid);
/* 273 */       if (spvcCfg != null) {
/* 274 */         for (Map.Entry<Integer, Integer> entry : spvcCfg.proRateMap.entrySet()) {
/* 275 */           int key = ((Integer)entry.getKey()).intValue();
/* 276 */           Integer value = (Integer)attrsMap.get(Integer.valueOf(key));
/* 277 */           if (value != null) {
/* 278 */             int ret = (int)(((Integer)entry.getValue()).intValue() * 1.0D / FightArgs.getInstance().defaultRate * value.intValue());
/* 279 */             attrsMap.put(Integer.valueOf(key), Integer.valueOf(ret));
/*     */           }
/*     */         }
/*     */       } else {
/* 283 */         int classid = this.fightGroup.getExtra(FightGroupExtra.PVC_Cfg_Robot_Classid);
/* 284 */         int level = this.fightGroup.getExtra(FightGroupExtra.PVC_Cfg_Robot_Level);
/* 285 */         PVCRobotCfg spvcRobotCfg = FightConfigManager.getInstance().getPVCRobotCfg(classid, level);
/* 286 */         if (spvcRobotCfg != null) {
/* 287 */           int petMonsterid = FightConfigManager.getInstance().getPetid(spvcRobotCfg);
/* 288 */           if (petMonsterid >= 0) {
/* 289 */             Monster petMonster = MonsterInterface.getMonster(petMonsterid, level);
/* 290 */             attrsMap.clear();
/* 291 */             petMonster.fillSelfFixFightProperty(attrsMap);
/* 292 */             exaAttrsMap.clear();
/* 293 */             petMonster.fillOtherFightProperty(exaAttrsMap);
/*     */           }
/*     */         }
/*     */       }
/* 297 */       cloneFighterPet.init(pet, petPos, attrsMap, exaAttrsMap);
/* 298 */       List<Fighter> fighters = new ArrayList();
/* 299 */       fighters.add(cloneFighterPet);
/* 300 */       fillPlaySummonResult(playSummon, 1, this.fighterid, fighters);
/* 301 */       Skill.Attack attack = new Skill.Attack();
/* 302 */       attack.addNormalCount(1);
/* 303 */       List<Skill.Attack> attacks = new ArrayList();
/* 304 */       attacks.add(attack);
/* 305 */       int playTime = FightUtil.getPlayTime(getModelid(), SFightConsts.getInstance().SUMMON_SKILL_PLAYId, Arrays.asList(new Integer[] { Integer.valueOf(cloneFighterPet.fighterid) }), attacks);
/*     */       
/* 307 */       excuteCmdResult.addPlayTime(playTime);
/*     */       
/*     */ 
/*     */ 
/* 311 */       cloneFighterPet.onEnterFight();
/*     */     }
/* 313 */     this.fightGroup.setExtra(FightGroupExtra.Summon_pet_times, ++summonTimes);
/*     */     
/* 315 */     if (this.fightGroup.fightTeam.fight.canSeeOppsiteHpProp()) {
/* 316 */       Play play = new Play();
/* 317 */       play.play_type = 2;
/* 318 */       play.content = playSummon.marshal(new OctetsStream());
/* 319 */       excuteCmdResult.addPlay(play, true);
/* 320 */       excuteCmdResult.addPlay(play, false);
/* 321 */       if (isRecordEnable()) {
/* 322 */         excuteCmdResult.addPlay(play);
/*     */       }
/*     */     } else {
/* 325 */       Play oppisitePlay = new Play();
/* 326 */       PlaySummon oppisitePlaySummon = getOppisitePlaySummon(playSummon, true);
/* 327 */       oppisitePlay.play_type = 2;
/* 328 */       oppisitePlay.content = oppisitePlaySummon.marshal(new OctetsStream());
/* 329 */       excuteCmdResult.addPlay(oppisitePlay, true);
/*     */       
/* 331 */       Play oppisitePassivePlay = new Play();
/* 332 */       PlaySummon oppisitePassivePlaySummon = getOppisitePlaySummon(playSummon, false);
/* 333 */       oppisitePassivePlay.play_type = 2;
/* 334 */       oppisitePassivePlay.content = oppisitePassivePlaySummon.marshal(new OctetsStream());
/* 335 */       excuteCmdResult.addPlay(oppisitePassivePlay, false);
/*     */       
/* 337 */       if (isRecordEnable()) {
/* 338 */         Play play = new Play();
/* 339 */         play.play_type = 2;
/* 340 */         play.content = playSummon.marshal(new OctetsStream());
/* 341 */         excuteCmdResult.addPlay(play);
/*     */       }
/*     */     }
/*     */     
/* 345 */     addActionCount();
/*     */   }
/*     */   
/*     */   protected void excuteOpSummonChild(OpSummonChild opSummonChild, ExcuteCmdResult excuteCmdResult)
/*     */   {
/* 350 */     if ((isSeal()) && 
/* 351 */       (isSealSummon())) {
/* 352 */       return;
/*     */     }
/*     */     
/*     */ 
/* 356 */     long childid = opSummonChild.child_uuid;
/* 357 */     long roleid = getRoleid();
/* 358 */     if (!ChildrenInterface.canJoinFight(roleid, childid, false)) {
/* 359 */       GameServer.logger().info(String.format("[Fight]CloneFighterRole.excuteOpSummonChild@do not can summon child|roleid=%d|childid=%d", new Object[] { Long.valueOf(roleid), Long.valueOf(childid) }));
/*     */       
/*     */ 
/*     */ 
/* 363 */       return;
/*     */     }
/*     */     
/* 366 */     if (this.fightGroup.hasSummonBackChild(childid)) {
/* 367 */       GameServer.logger().info(String.format("[Fight]CloneFighterRole.excuteOpSummonChild@has summoned child|roleid=%d|childid=%d", new Object[] { Long.valueOf(roleid), Long.valueOf(childid) }));
/*     */       
/*     */ 
/*     */ 
/* 371 */       return;
/*     */     }
/*     */     
/* 374 */     ChildrenOutFightObj childrenOutFightObj = ChildrenInterface.getChildrenOutFightObj(roleid, childid, false);
/*     */     
/* 376 */     if (childrenOutFightObj == null) {
/* 377 */       GameServer.logger().error(String.format("[Fight]CloneFighterRole.excuteOpSummonChild@do not exist childOutfight object|roleid=%d|childid=%d", new Object[] { Long.valueOf(roleid), Long.valueOf(childid) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 382 */       return;
/*     */     }
/*     */     
/*     */ 
/* 386 */     Map<Long, CloneFighterChild> childToFighter = new HashMap();
/* 387 */     for (Fighter fighter : this.fightGroup.getFighters()) {
/* 388 */       if (fighter.isCloneChild()) {
/* 389 */         CloneFighterChild fighterChild = (CloneFighterChild)fighter;
/* 390 */         childToFighter.put(Long.valueOf(fighterChild.getUuid()), fighterChild);
/*     */       }
/*     */     }
/* 393 */     Fighter beSummonedFighter = null;
/* 394 */     PlaySummon playSummon = new PlaySummon();
/* 395 */     if (childToFighter.containsKey(Long.valueOf(childid)))
/*     */     {
/* 397 */       CloneFighterChild fighter = (CloneFighterChild)childToFighter.get(Long.valueOf(childid));
/* 398 */       if ((fighter.isDead()) || (fighter.isEscaped())) {
/* 399 */         GameServer.logger().info(String.format("[Fight]CloneFighterRole.excuteOpSummonChild@dead or escape can not callback|roleid=%d|childid=%d", new Object[] { Long.valueOf(roleid), Long.valueOf(childid) }));
/*     */         
/*     */ 
/*     */ 
/*     */ 
/* 404 */         return;
/*     */       }
/*     */       
/* 407 */       List<Fighter> fighters = new ArrayList();
/* 408 */       fighters.add(fighter);
/* 409 */       fillPlaySummonResult(playSummon, 0, this.fighterid, fighters);
/* 410 */       Skill.Attack attack0 = new Skill.Attack();
/* 411 */       attack0.addNormalCount(1);
/* 412 */       List<Skill.Attack> attacks = new ArrayList();
/* 413 */       attacks.add(attack0);
/* 414 */       int playTime = FightUtil.getPlayTime(getModelid(), SFightConsts.getInstance().SUMMON_SKILL_PLAYId, Arrays.asList(new Integer[] { Integer.valueOf(fighter.fighterid) }), attacks);
/*     */       
/* 416 */       excuteCmdResult.addPlayTime(playTime);
/*     */       
/* 418 */       fighter.onFightEnd();
/*     */     } else {
/* 420 */       int summonChildTimes = this.fightGroup.getExtra(FightGroupExtra.Summon_child_times);
/* 421 */       if (summonChildTimes >= SChildrenConsts.getInstance().child_summon_max) {
/* 422 */         GameServer.logger().info(String.format("[Fight]CloneFighterRole.excuteOpSummonChild@summon child times is not enough|roleid=%d|childid=%d|times=%d", new Object[] { Long.valueOf(roleid), Long.valueOf(childid), Integer.valueOf(summonChildTimes) }));
/*     */         
/*     */ 
/*     */ 
/*     */ 
/* 427 */         return;
/*     */       }
/*     */       
/* 430 */       for (Fighter fighter : this.fightGroup.getFighters()) {
/* 431 */         if ((fighter.isPetType()) || (fighter.isChildType())) {
/* 432 */           this.fightGroup.removeFighter(fighter.getid());
/* 433 */           fighter.onFightEnd();
/*     */         }
/*     */       }
/*     */       
/*     */ 
/* 438 */       int petPos = -1 * FightManager.getPosNumberPerRow() + getPos();
/*     */       
/* 440 */       CloneFighterChild cloneFighterChild = this.fightGroup.generateCloneFighterChild();
/*     */       
/* 442 */       Map<Integer, Integer> attrsMap = new HashMap();
/* 443 */       Map<Integer, Integer> exaAttrsMap = new HashMap();
/* 444 */       if (OpenInterface.getOpenStatus(239)) {
/* 445 */         childrenOutFightObj.fillFinalPropertyMap(attrsMap);
/*     */       } else {
/* 447 */         childrenOutFightObj.fillSelfFixFightProperty(attrsMap);
/* 448 */         childrenOutFightObj.fillOtherFightProperty(exaAttrsMap);
/*     */       }
/*     */       
/* 451 */       int pvcid = this.fightGroup.getExtra(FightGroupExtra.PVC_Cfg_Id);
/* 452 */       SPVCCfg spvcCfg = SPVCCfg.get(pvcid);
/* 453 */       if (spvcCfg != null) {
/* 454 */         for (Map.Entry<Integer, Integer> entry : spvcCfg.proRateMap.entrySet()) {
/* 455 */           int key = ((Integer)entry.getKey()).intValue();
/* 456 */           Integer value = (Integer)attrsMap.get(Integer.valueOf(key));
/* 457 */           if (value != null) {
/* 458 */             int ret = (int)(((Integer)entry.getValue()).intValue() * 1.0D / FightArgs.getInstance().defaultRate * value.intValue());
/* 459 */             attrsMap.put(Integer.valueOf(key), Integer.valueOf(ret));
/*     */           }
/*     */         }
/*     */       } else {
/* 463 */         int classid = this.fightGroup.getExtra(FightGroupExtra.PVC_Cfg_Robot_Classid);
/* 464 */         int level = this.fightGroup.getExtra(FightGroupExtra.PVC_Cfg_Robot_Level);
/* 465 */         PVCRobotCfg spvcRobotCfg = FightConfigManager.getInstance().getPVCRobotCfg(classid, level);
/* 466 */         if (spvcRobotCfg != null) {
/* 467 */           int petMonsterid = FightConfigManager.getInstance().getPetid(spvcRobotCfg);
/* 468 */           if (petMonsterid >= 0) {
/* 469 */             Monster petMonster = MonsterInterface.getMonster(petMonsterid, level);
/* 470 */             attrsMap.clear();
/* 471 */             petMonster.fillSelfFixFightProperty(attrsMap);
/* 472 */             exaAttrsMap.clear();
/* 473 */             petMonster.fillOtherFightProperty(exaAttrsMap);
/*     */           }
/*     */         }
/*     */       }
/* 477 */       cloneFighterChild.init(childrenOutFightObj, petPos, attrsMap, exaAttrsMap);
/*     */       
/* 479 */       List<Fighter> fighters = new ArrayList();
/* 480 */       fighters.add(cloneFighterChild);
/* 481 */       fillPlaySummonResult(playSummon, 1, this.fighterid, fighters);
/* 482 */       Skill.Attack attack = new Skill.Attack();
/* 483 */       attack.addNormalCount(1);
/* 484 */       List<Skill.Attack> attacks = new ArrayList();
/* 485 */       attacks.add(attack);
/* 486 */       int playTime = FightUtil.getPlayTime(getModelid(), SFightConsts.getInstance().SUMMON_SKILL_PLAYId, Arrays.asList(new Integer[] { Integer.valueOf(cloneFighterChild.fighterid) }), attacks);
/*     */       
/* 488 */       excuteCmdResult.addPlayTime(playTime);
/*     */       
/* 490 */       cloneFighterChild.onEnterFight();
/* 491 */       beSummonedFighter = cloneFighterChild;
/* 492 */       this.fightGroup.setExtra(FightGroupExtra.Summon_child_times, ++summonChildTimes);
/*     */     }
/*     */     
/* 495 */     if (this.fightGroup.fightTeam.fight.canSeeOppsiteHpProp()) {
/* 496 */       Play play = new Play();
/* 497 */       play.play_type = 2;
/* 498 */       play.content = playSummon.marshal(new OctetsStream());
/* 499 */       excuteCmdResult.addPlay(play, true);
/* 500 */       excuteCmdResult.addPlay(play, false);
/* 501 */       if (isRecordEnable()) {
/* 502 */         excuteCmdResult.addPlay(play);
/*     */       }
/*     */     } else {
/* 505 */       Play oppisitePlay = new Play();
/* 506 */       PlaySummon oppisitePlaySummon = getOppisitePlaySummon(playSummon, true);
/* 507 */       oppisitePlay.play_type = 2;
/* 508 */       oppisitePlay.content = oppisitePlaySummon.marshal(new OctetsStream());
/* 509 */       excuteCmdResult.addPlay(oppisitePlay, true);
/*     */       
/* 511 */       Play oppisitePassivePlay = new Play();
/* 512 */       PlaySummon oppisitePassivePlaySummon = getOppisitePlaySummon(playSummon, false);
/* 513 */       oppisitePassivePlay.play_type = 2;
/* 514 */       oppisitePassivePlay.content = oppisitePassivePlaySummon.marshal(new OctetsStream());
/* 515 */       excuteCmdResult.addPlay(oppisitePassivePlay, false);
/*     */       
/* 517 */       if (isRecordEnable()) {
/* 518 */         Play play = new Play();
/* 519 */         play.play_type = 2;
/* 520 */         play.content = playSummon.marshal(new OctetsStream());
/* 521 */         excuteCmdResult.addPlay(play);
/*     */       }
/*     */     }
/*     */     
/* 525 */     addActionCount();
/*     */     
/* 527 */     if (beSummonedFighter != null) {
/* 528 */       beSummonedFighter.handleOnAftSummon(this, excuteCmdResult);
/*     */     }
/*     */   }
/*     */   
/*     */   public Set<Long> getCanSummonPets() {
/* 533 */     Set<Long> petUUidsInFight = new HashSet();
/* 534 */     for (Fighter fighter : this.fightGroup.getLeaveFightFighters()) {
/* 535 */       if (fighter.isPetType()) {
/* 536 */         petUUidsInFight.add(Long.valueOf(fighter.getUuid()));
/*     */       }
/*     */     }
/* 539 */     for (Fighter fighter : this.fightGroup.getFighters()) {
/* 540 */       if (fighter.isPetType()) {
/* 541 */         petUUidsInFight.add(Long.valueOf(fighter.getUuid()));
/*     */       }
/*     */     }
/* 544 */     Set<Long> ret = new HashSet();
/* 545 */     Set<Long> petids = PetInterface.getPetList(getRoleid(), true);
/* 546 */     Iterator i$; if (petids != null) {
/* 547 */       for (i$ = petids.iterator(); i$.hasNext();) { long petid = ((Long)i$.next()).longValue();
/* 548 */         if ((!petUUidsInFight.contains(Long.valueOf(petid))) && 
/*     */         
/*     */ 
/* 551 */           (PetInterface.isCanJoinFight(getRoleid(), petid, true)))
/*     */         {
/*     */ 
/* 554 */           ret.add(Long.valueOf(petid)); }
/*     */       }
/*     */     }
/* 557 */     return ret;
/*     */   }
/*     */   
/*     */   public Set<Long> getCanSummonChildren() {
/* 561 */     Set<Long> childrenUUidsInFight = new HashSet();
/* 562 */     for (Fighter fighter : this.fightGroup.getLeaveFightFighters()) {
/* 563 */       if (fighter.isChildType()) {
/* 564 */         childrenUUidsInFight.add(Long.valueOf(fighter.getUuid()));
/*     */       }
/*     */     }
/* 567 */     for (Fighter fighter : this.fightGroup.getFighters()) {
/* 568 */       if (fighter.isChildType()) {
/* 569 */         childrenUUidsInFight.add(Long.valueOf(fighter.getUuid()));
/*     */       }
/*     */     }
/* 572 */     Set<Long> ret = new HashSet();
/* 573 */     Collection<Long> childrenids = ChildrenInterface.getRoleBagChilds(getRoleid(), true);
/* 574 */     Iterator i$; if (childrenids != null) {
/* 575 */       for (i$ = childrenids.iterator(); i$.hasNext();) { long childid = ((Long)i$.next()).longValue();
/* 576 */         if ((!childrenUUidsInFight.contains(Long.valueOf(childid))) && 
/*     */         
/*     */ 
/* 579 */           (ChildrenInterface.canJoinFight(getRoleid(), childid, false)))
/*     */         {
/*     */ 
/* 582 */           ret.add(Long.valueOf(childid)); }
/*     */       }
/*     */     }
/* 585 */     return ret;
/*     */   }
/*     */   
/*     */   public int getPetLevel(long petid) {
/* 589 */     Pet pet = PetInterface.getPetById(getRoleid(), petid);
/* 590 */     if (pet != null) {
/* 591 */       return pet.getLevel();
/*     */     }
/* 593 */     return -1;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   protected void beforeExcuteSkill(Op_UseSkill opUseSkill, ExcuteCmdResult excuteCmdResult)
/*     */   {
/* 600 */     if (opUseSkill.skill == SFightConsts.getInstance().DEFENCE_SKILL) {
/* 601 */       return;
/*     */     }
/*     */     
/*     */ 
/* 605 */     FighterMounts xFighterMounts = this.xFighter.getFightermounts();
/* 606 */     if (xFighterMounts.getMountcfgid() == 0) {
/* 607 */       return;
/*     */     }
/* 609 */     SSkillCfg skillCfg = SSkillCfg.get(opUseSkill.skill);
/* 610 */     if (skillCfg == null) {
/* 611 */       GameServer.logger().error(String.format("[Fight]FighterRole.beforeExcuteOpSkill@skill not exist|skillid=%d|roleid=%d", new Object[] { Integer.valueOf(opUseSkill.skill), Long.valueOf(getRoleid()) }));
/*     */       
/*     */ 
/* 614 */       return;
/*     */     }
/* 616 */     SMountsSkillCfg mountsSkillCfg = SMountsSkillCfg.get(skillCfg.mountsSkillClassid);
/* 617 */     if (mountsSkillCfg == null) {
/* 618 */       GameServer.logger().error(String.format("[Fight]FighterRole.beforeExcuteOpSkill@mounts skill classid not exist|roleid=%d|skillid=%d|classid=%d", new Object[] { Long.valueOf(getRoleid()), Integer.valueOf(opUseSkill.skill), Integer.valueOf(skillCfg.mountsSkillClassid) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 623 */       return;
/*     */     }
/* 625 */     int ret = Xdb.random().nextInt(FightArgs.getInstance().defaultRate);
/* 626 */     List<Skill> triggerSkills = new ArrayList();
/* 627 */     for (Map.Entry<Integer, Integer> skillid2Lv : xFighterMounts.getSkillmap().entrySet()) {
/* 628 */       int skillid = ((Integer)skillid2Lv.getKey()).intValue();
/* 629 */       Integer rate = (Integer)mountsSkillCfg.mountsSkillMap.get(Integer.valueOf(skillid));
/* 630 */       if ((rate != null) && 
/*     */       
/*     */ 
/* 633 */         (rate.intValue() > ret))
/*     */       {
/*     */ 
/* 636 */         Skill skill = SkillInterface.getSkill(skillid, ((Integer)skillid2Lv.getValue()).intValue());
/* 637 */         if (canNomalUseSkill(skill))
/* 638 */           triggerSkills.add(skill);
/*     */       }
/*     */     }
/* 641 */     int size = triggerSkills.size();
/* 642 */     if (size <= 0) {
/* 643 */       return;
/*     */     }
/* 645 */     int index = Xdb.random().nextInt(size);
/* 646 */     Skill skill = (Skill)triggerSkills.get(index);
/* 647 */     List<Fighter> targets = skill.getTargets(this, opUseSkill.main_target, true);
/* 648 */     if (!skill.canRun(this, opUseSkill.main_target, targets, true)) {
/* 649 */       return;
/*     */     }
/* 651 */     doUseSkill(opUseSkill, excuteCmdResult, targets, skill.getID(), skill, 0, new BeforeUseSkilHandle.OutputObj());
/*     */   }
/*     */   
/*     */   void initChangeModelCard()
/*     */   {
/* 656 */     ChangeModelCardInterface.ClassLevelEntry entry = mzm.gsp.changemodelcard.main.ChangeModelCardInterface.getRoleClassTypeAndLevel(getRoleid(), true);
/*     */     
/* 658 */     initChangeModelCard(entry.classType, entry.level);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\main\CloneFighterRole.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */