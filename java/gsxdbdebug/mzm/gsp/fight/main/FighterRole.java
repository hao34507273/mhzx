/*      */ package mzm.gsp.fight.main;
/*      */ 
/*      */ import com.goldhuman.Common.Marshal.OctetsStream;
/*      */ import com.goldhuman.Common.Octets;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Arrays;
/*      */ import java.util.HashMap;
/*      */ import java.util.HashSet;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.Map.Entry;
/*      */ import java.util.Random;
/*      */ import java.util.Set;
/*      */ import mzm.event.TriggerEventsManger;
/*      */ import mzm.gsp.GameServer;
/*      */ import mzm.gsp.changemodelcard.main.ChangeModelCardInterface;
/*      */ import mzm.gsp.changemodelcard.main.ChangeModelCardInterface.ClassLevelEntry;
/*      */ import mzm.gsp.children.confbean.SChildrenConsts;
/*      */ import mzm.gsp.children.main.ChildrenInterface;
/*      */ import mzm.gsp.children.main.ChildrenOutFightObj;
/*      */ import mzm.gsp.common.IOutFightObject;
/*      */ import mzm.gsp.effect.main.FighterEffect;
/*      */ import mzm.gsp.fight.OpCapture;
/*      */ import mzm.gsp.fight.OpSummonChild;
/*      */ import mzm.gsp.fight.OpSummonPet;
/*      */ import mzm.gsp.fight.Play;
/*      */ import mzm.gsp.fight.PlaySummon;
/*      */ import mzm.gsp.fight.SRoundPlayBrd;
/*      */ import mzm.gsp.fight.SSelectOperateBrd;
/*      */ import mzm.gsp.fight.SSynRoleSkillInfo;
/*      */ import mzm.gsp.fight.confbean.SFightConsts;
/*      */ import mzm.gsp.fight.confbean.SFightTypeCfg;
/*      */ import mzm.gsp.fight.event.RoleEscape;
/*      */ import mzm.gsp.fight.event.RoleEscapeArg;
/*      */ import mzm.gsp.fight.handle.BeforeUseSkilHandle.OutputObj;
/*      */ import mzm.gsp.fight.handle.ChildEnterFightHandle;
/*      */ import mzm.gsp.fight.handle.PetEnterFightHandle;
/*      */ import mzm.gsp.item.main.ItemInterface;
/*      */ import mzm.gsp.monster.main.Monster;
/*      */ import mzm.gsp.monster.main.MonsterInterface;
/*      */ import mzm.gsp.mounts.main.MountsInterface;
/*      */ import mzm.gsp.mounts.main.MountsInterface.ChiefBattleMountsObj;
/*      */ import mzm.gsp.online.main.OnlineManager;
/*      */ import mzm.gsp.open.main.OpenInterface;
/*      */ import mzm.gsp.pet.event.PetCatchEvent;
/*      */ import mzm.gsp.pet.event.PetCatchEventArg;
/*      */ import mzm.gsp.pet.main.Pet;
/*      */ import mzm.gsp.pet.main.PetCfg;
/*      */ import mzm.gsp.pet.main.PetInterface;
/*      */ import mzm.gsp.role.main.RoleInterface;
/*      */ import mzm.gsp.role.main.RoleOneByOneManager;
/*      */ import mzm.gsp.role.main.RoleOutFightObj;
/*      */ import mzm.gsp.skill.confbean.SMountsSkillCfg;
/*      */ import mzm.gsp.skill.confbean.SOutFightEffectGroup;
/*      */ import mzm.gsp.skill.confbean.SSkillCfg;
/*      */ import mzm.gsp.skill.main.PassiveSkill;
/*      */ import mzm.gsp.skill.main.Skill;
/*      */ import mzm.gsp.skill.main.Skill.Attack;
/*      */ import mzm.gsp.skill.main.SkillInterface;
/*      */ import mzm.gsp.status.main.RoleStatusInterface;
/*      */ import mzm.gsp.teamplatform.match.TeamMatchInterface;
/*      */ import mzm.gsp.wanted.main.WantedInterface;
/*      */ import org.apache.log4j.Logger;
/*      */ import xbean.FightCache;
/*      */ import xbean.FightCmd;
/*      */ import xbean.FighterMounts;
/*      */ import xdb.Xdb;
/*      */ import xtable.Role2fight;
/*      */ 
/*      */ public class FighterRole extends Fighter
/*      */ {
/*      */   FighterRole(int fighterid, xbean.Fighter xFighter, FightGroup fightGroup)
/*      */   {
/*   74 */     super(fighterid, xFighter, fightGroup);
/*      */   }
/*      */   
/*      */   protected boolean canPlayerOperate()
/*      */   {
/*   79 */     return true;
/*      */   }
/*      */   
/*      */   public boolean isExisted()
/*      */   {
/*   84 */     return !isEscaped();
/*      */   }
/*      */   
/*      */ 
/*      */   protected void onEnterFight()
/*      */   {
/*   90 */     super.onEnterFight();
/*   91 */     int maxSpeed = Integer.MIN_VALUE;
/*   92 */     int minSpeed = Integer.MAX_VALUE;
/*   93 */     for (Fighter fighter : this.fightGroup.fightTeam.fight.getSelectedFighters(null)) {
/*   94 */       if (fighter.isRole()) {
/*   95 */         int tmpSpeed = fighter.getSpeed();
/*   96 */         if (tmpSpeed > maxSpeed) {
/*   97 */           maxSpeed = tmpSpeed;
/*      */         }
/*   99 */         if (tmpSpeed < minSpeed) {
/*  100 */           minSpeed = tmpSpeed;
/*      */         }
/*      */       }
/*      */     }
/*  104 */     if (maxSpeed > minSpeed) {
/*  105 */       int random = maxSpeed - minSpeed + 1;
/*  106 */       int captureSpeed = Xdb.random().nextInt(random) + minSpeed;
/*      */       
/*  108 */       setExtra(FighterExtra.CAPTURE_SPEED, captureSpeed);
/*      */     }
/*      */   }
/*      */   
/*      */   protected void init(RoleOutFightObj role, int pos, int maxTeamLevel)
/*      */   {
/*  114 */     setPos(pos);
/*      */     
/*  116 */     RoleOutFightObj roleOutFightObj = RoleInterface.getRoleOutFightObject(role.getId());
/*  117 */     if (OpenInterface.getOpenStatus(239)) {
/*  118 */       roleOutFightObj.fillFinalPropertyMap(getAttrsMap());
/*      */     }
/*      */     else {
/*  121 */       roleOutFightObj.fillSelfFixFightProperty(getAttrsMap());
/*      */       
/*  123 */       roleOutFightObj.fillOtherFightProperty(getExa_AttrsMap());
/*      */     }
/*  125 */     setHp(Math.min(roleOutFightObj.getHP(), roleOutFightObj.getFinalMaxHP()));
/*  126 */     setMp(Math.min(roleOutFightObj.getMP(), roleOutFightObj.getFinalMaxMP()));
/*      */     
/*  128 */     int anger = roleOutFightObj.getAnger();
/*  129 */     SFightTypeCfg fightTypeCfg = FightConfigManager.getInstance().getFightTypeCfg(this.fightGroup.getFight().getCfgType());
/*      */     
/*  131 */     int angerMax = fightTypeCfg.enterFightAngerMax;
/*  132 */     setAnger(Math.min(anger, angerMax));
/*  133 */     setGender(role);
/*  134 */     setOccupation(role.getOccupationId());
/*      */     
/*      */ 
/*      */ 
/*  138 */     List<Skill> skills = role.getActiveSkills();
/*      */     
/*  140 */     for (Skill skill : skills) {
/*  141 */       int skillid = skill.getID();
/*  142 */       int skillLv = skill.getLevel();
/*  143 */       addSkill(skillid, skillLv);
/*      */     }
/*      */     
/*      */ 
/*  147 */     SSynRoleSkillInfo synRoleSkillInfo = new SSynRoleSkillInfo();
/*  148 */     synRoleSkillInfo.fight_uuid = this.fightGroup.fightTeam.getFight().fightid;
/*  149 */     synRoleSkillInfo.skillmap.putAll(getActiveSkillMap());
/*  150 */     OnlineManager.getInstance().send(role.getId(), synRoleSkillInfo);
/*      */     
/*  152 */     FightCache xFightCache = getFightCache();
/*  153 */     if ((xFightCache == null) || (xFightCache.getRole_default_skill() <= 0)) {
/*  154 */       for (Skill skill : skills) {
/*  155 */         SSkillCfg skillCfg = SSkillCfg.get(skill.getID());
/*  156 */         if (skillCfg.canAuto)
/*      */         {
/*      */ 
/*  159 */           setLastCanAutoSkill(skill.getID());
/*      */         }
/*      */       }
/*      */     }
/*      */     
/*  164 */     List<PassiveSkill> passiveSkills = role.getPassiveSkills();
/*  165 */     installPassiveSkills(passiveSkills);
/*  166 */     int level = roleOutFightObj.getLevel();
/*  167 */     int subLevel = maxTeamLevel - level;
/*  168 */     if ((fightTypeCfg.hasNewer) && (subLevel >= TeamMatchInterface.getNewGuyLevelDiff())) {
/*  169 */       int effectid = FightConfigManager.getInstance().getNewerPassiveEffect(subLevel);
/*  170 */       if (effectid > 0) {
/*  171 */         SOutFightEffectGroup outFightEffectGroup = SOutFightEffectGroup.get(effectid);
/*  172 */         FighterEffect fighterEffect = getPassiveEffect(outFightEffectGroup.effectId, outFightEffectGroup.formulaList, subLevel);
/*      */         
/*  174 */         addPassiveEffect(fighterEffect);
/*      */       }
/*      */     }
/*      */     
/*      */ 
/*  179 */     MountsInterface.ChiefBattleMountsObj chiefBattleMountsObj = MountsInterface.getChiefBattlMounts(role.getId(), true);
/*  180 */     if (chiefBattleMountsObj != null) {
/*  181 */       this.xFighter.getFightermounts().setMountcfgid(chiefBattleMountsObj.getMountsCfgId());
/*  182 */       this.xFighter.getFightermounts().setMountuuid(chiefBattleMountsObj.getMountsId());
/*  183 */       this.xFighter.getFightermounts().getSkillmap().putAll(chiefBattleMountsObj.getMountsActiveSkillMap());
/*      */     }
/*      */     
/*      */ 
/*  187 */     boolean isRedName = WantedInterface.isHongMing(role.getId());
/*  188 */     if (isRedName) {
/*  189 */       setRedName();
/*      */     }
/*  191 */     initOutFightCommon(role);
/*      */   }
/*      */   
/*      */   public final long getRoleid() {
/*  195 */     return this.fightGroup.getRoleid();
/*      */   }
/*      */   
/*      */   protected final FightCache getFightCache() {
/*  199 */     if ((this.fightGroup instanceof FightGroupRole)) {
/*  200 */       return ((FightGroupRole)this.fightGroup).createXFightCacheIfNotExist();
/*      */     }
/*  202 */     return null;
/*      */   }
/*      */   
/*      */   protected IOutFightObject getOutFightObj()
/*      */   {
/*  207 */     return RoleInterface.getRoleOutFightObject(getRoleid());
/*      */   }
/*      */   
/*      */   protected boolean isAuto()
/*      */   {
/*  212 */     FightCache fightCache = getFightCache();
/*  213 */     if (fightCache != null) {
/*  214 */       return getFightCache().getIsauto();
/*      */     }
/*  216 */     return false;
/*      */   }
/*      */   
/*      */   protected void setAutoSkill(int skillid) {
/*  220 */     skillid = convertSkill(skillid).intValue();
/*  221 */     if (hasSkill(skillid)) {
/*  222 */       FightCache fightCache = getFightCache();
/*  223 */       if (fightCache == null) {
/*  224 */         return;
/*      */       }
/*  226 */       fightCache.setRole_default_skill(skillid);
/*      */       
/*  228 */       sendDefalutSkillChangeRes(getRoleid(), skillid, 0L, 1);
/*      */     } else {
/*  230 */       sendDefalutSkillChangeRes(getRoleid(), getAutoSkill(), 0L, 1);
/*      */     }
/*      */   }
/*      */   
/*      */   protected int getAutoSkill()
/*      */   {
/*  236 */     FightCache fightCache = getFightCache();
/*  237 */     if (fightCache == null) {
/*  238 */       return getCfgDefaultSkill();
/*      */     }
/*  240 */     int skill = fightCache.getRole_default_skill();
/*  241 */     skill = convertSkill(skill).intValue();
/*  242 */     if (!hasSkill(skill)) {
/*  243 */       skill = 0;
/*      */     }
/*  245 */     if (skill <= 0) {
/*  246 */       skill = getCfgDefaultSkill();
/*  247 */       fightCache.setRole_default_skill(skill);
/*      */     }
/*  249 */     return skill;
/*      */   }
/*      */   
/*      */   protected void setAuto()
/*      */   {
/*  254 */     if ((this.fightGroup instanceof FightGroupRole)) {
/*  255 */       ((FightGroupRole)this.fightGroup).setAuto(true);
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   void setLastCanAutoSkill(int skillid)
/*      */   {
/*  267 */     SSkillCfg skillCfg = SSkillCfg.get(skillid);
/*  268 */     if (skillCfg == null) {
/*  269 */       return;
/*      */     }
/*  271 */     if ((skillCfg.canAuto) && 
/*  272 */       (hasSkill(skillid))) {
/*  273 */       FightCache fightCache = getFightCache();
/*  274 */       if (fightCache == null) {
/*  275 */         return;
/*      */       }
/*  277 */       fightCache.setRole_default_skill(skillid);
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   protected void onDead()
/*      */   {
/*  300 */     setFakeDead();
/*  301 */     super.onFighterDead();
/*      */   }
/*      */   
/*      */   protected void setDead()
/*      */   {
/*  306 */     super.setFakeDead();
/*      */   }
/*      */   
/*      */ 
/*      */   protected void setDefautOper()
/*      */   {
/*  312 */     if (!this.fightGroup.getFight().hasFightCmd(this.fighterid))
/*      */     {
/*  314 */       if (!PetInterface.isPetBagFull(getRoleid()))
/*      */       {
/*  316 */         for (Fighter fighter : getEnermyLiveFighters()) {
/*  317 */           if ((fighter instanceof FighterMonster)) {
/*  318 */             FighterMonster fighterMonster = (FighterMonster)fighter;
/*  319 */             if (MonsterInterface.isMonsterCanAutoCatch(fighterMonster.getMonsterid(), getLevel()))
/*      */             {
/*  321 */               Monster monster = MonsterInterface.getMonster(fighterMonster.getMonsterid(), fighterMonster.getLevel());
/*      */               
/*  323 */               int petCfgId = monster.getCatchedId();
/*  324 */               PetCfg petCfg = PetInterface.getPetCfgByCfgId(petCfgId);
/*  325 */               if (petCfg != null)
/*      */               {
/*  327 */                 if (petCfg.getCarrayLevel() <= getLevel()) {
/*  328 */                   OpCapture opCapture = new OpCapture();
/*      */                   
/*  330 */                   opCapture.target = -1;
/*  331 */                   this.fightGroup.fightTeam.fight.addFightCmd(this.fighterid, 2, opCapture);
/*      */                   
/*  333 */                   break;
/*      */                 }
/*      */               }
/*      */             }
/*      */           }
/*      */         }
/*      */       }
/*      */     }
/*      */     
/*      */ 
/*  343 */     if (!this.fightGroup.getFight().hasFightCmd(this.fighterid))
/*      */     {
/*  345 */       super.setDefautOper();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   protected boolean excuteOpEscape(ExcuteCmdResult excuteCmdResult)
/*      */   {
/*  353 */     long roleid = getRoleid();
/*  354 */     boolean isEscaped = super.excuteOpEscape(excuteCmdResult);
/*  355 */     if (isEscaped) {
/*  356 */       List<Integer> partnerids = new ArrayList();
/*  357 */       List<Long> petids = new ArrayList();
/*  358 */       for (Fighter fighter : this.fightGroup.getExistedFighters()) {
/*  359 */         if (fighter.getid() != getid())
/*      */         {
/*      */ 
/*  362 */           if (fighter.isAlive()) {
/*  363 */             fighter.setEscape();
/*      */           }
/*  365 */           if (fighter.isFakeDead()) {
/*  366 */             fighter.setDead();
/*      */           }
/*  368 */           if (fighter.isPet()) {
/*  369 */             petids.add(Long.valueOf(fighter.getUuid()));
/*  370 */           } else if (fighter.isFellow()) {
/*  371 */             partnerids.add(Integer.valueOf((int)fighter.getUuid()));
/*      */           }
/*      */         }
/*      */       }
/*  375 */       for (Fighter fighter : this.fightGroup.getLeaveFightFighters()) {
/*  376 */         if (fighter.isPet()) {
/*  377 */           petids.add(Long.valueOf(fighter.getUuid()));
/*  378 */         } else if (fighter.isFellow()) {
/*  379 */           partnerids.add(Integer.valueOf((int)fighter.getUuid()));
/*      */         }
/*      */       }
/*      */       
/*      */ 
/*  384 */       for (FightGroupFellow fightGroupFellow : this.fightGroup.fightTeam.getGroupFellows()) {
/*  385 */         if (fightGroupFellow.getRoleid() == roleid) {
/*  386 */           for (Fighter fighter : fightGroupFellow.getExistedFighters()) {
/*  387 */             if (fighter.getid() != getid())
/*      */             {
/*      */ 
/*  390 */               if (fighter.isAlive()) {
/*  391 */                 fighter.setEscape();
/*      */               }
/*  393 */               if (fighter.isFakeDead())
/*  394 */                 fighter.setDead();
/*      */             }
/*      */           }
/*  397 */           fightGroupFellow.onFightEnd();
/*      */         }
/*      */       }
/*      */       
/*  401 */       this.fightGroup.onFightEnd();
/*  402 */       SRoundPlayBrd sRoundPlayBrd = new SRoundPlayBrd();
/*  403 */       sRoundPlayBrd.fight_uuid = this.fightGroup.getFight().fightid;
/*  404 */       boolean isActive = this.fightGroup.fightTeam.isActive;
/*  405 */       sRoundPlayBrd.playlist.addAll(this.fightGroup.getFight().getPlayList(isActive));
/*  406 */       sRoundPlayBrd.playlist.addAll(excuteCmdResult.getPlayList(isActive));
/*  407 */       OnlineManager.getInstance().send(getRoleid(), sRoundPlayBrd);
/*  408 */       RoleEscapeArg roleEscapeArg = new RoleEscapeArg(roleid, this.fightGroup.fightTeam.fight.getFightContext(), this.fightGroup.fightTeam.fight.getCfgType(), getFight().getFightReason(), partnerids, petids, getFight().getFightCfgid(), getFight().getFightStartTime(), getRound(), getFight().getActionMaxCurRound(), getFight().getActionTotalCount());
/*      */       
/*      */ 
/*      */ 
/*      */ 
/*  413 */       TriggerEventsManger.getInstance().triggerEvent(new RoleEscape(), roleEscapeArg);
/*      */     }
/*  415 */     return isEscaped;
/*      */   }
/*      */   
/*      */   protected void excuteOpSummonPet(OpSummonPet opSummonPet, ExcuteCmdResult excuteCmdResult)
/*      */   {
/*  420 */     if ((isSeal()) && 
/*  421 */       (isSealSummon())) {
/*  422 */       Play play = new Play();
/*  423 */       fillPlayTipResult(play, this.fighterid, 121000019, new String[0]);
/*  424 */       excuteCmdResult.addPlay(play, true);
/*  425 */       excuteCmdResult.addPlay(play, false);
/*  426 */       if (isRecordEnable()) {
/*  427 */         excuteCmdResult.addPlay(play);
/*      */       }
/*  429 */       return;
/*      */     }
/*      */     
/*  432 */     long petUUid = opSummonPet.pet_uuid;
/*  433 */     if (!PetInterface.isCanJoinFight(getRoleid(), petUUid, true)) {
/*  434 */       GameServer.logger().error("宠物不能召唤....!petuuid:" + petUUid);
/*  435 */       return;
/*      */     }
/*      */     
/*  438 */     if (this.fightGroup.hasSummonBackPet(petUUid))
/*      */     {
/*      */ 
/*      */ 
/*  442 */       GameServer.logger().info("已经召唤过该宠物了...");
/*  443 */       return;
/*      */     }
/*      */     
/*  446 */     Pet pet = PetInterface.getPetByPetId(getRoleid(), petUUid, true);
/*  447 */     if (pet == null) {
/*  448 */       GameServer.logger().error("玩家不存在这个宠物");
/*  449 */       return;
/*      */     }
/*      */     
/*      */ 
/*  453 */     Map<Long, FighterPet> petidToFighter = new HashMap();
/*  454 */     for (Fighter fighter : this.fightGroup.getFighters()) {
/*  455 */       if (fighter.isPet()) {
/*  456 */         FighterPet fighterPet = (FighterPet)fighter;
/*  457 */         petidToFighter.put(Long.valueOf(fighterPet.getUuid()), fighterPet);
/*      */       }
/*      */     }
/*  460 */     Fighter beSummonedFighter = null;
/*  461 */     PlaySummon playSummon = new PlaySummon();
/*  462 */     if (petidToFighter.containsKey(Long.valueOf(petUUid)))
/*      */     {
/*  464 */       FighterPet fighter = (FighterPet)petidToFighter.get(Long.valueOf(petUUid));
/*  465 */       if ((fighter.isDead()) || (fighter.isEscaped()))
/*      */       {
/*      */ 
/*      */ 
/*      */ 
/*  470 */         GameServer.logger().info("逃跑或者死亡的宠物不能被召唤!!!");
/*  471 */         return;
/*      */       }
/*  473 */       List<Fighter> fighters = new ArrayList();
/*  474 */       fighters.add(fighter);
/*  475 */       fillPlaySummonResult(playSummon, 0, this.fighterid, fighters);
/*  476 */       Skill.Attack attack0 = new Skill.Attack();
/*  477 */       attack0.addNormalCount(1);
/*  478 */       List<Skill.Attack> attacks = new ArrayList();
/*  479 */       attacks.add(attack0);
/*  480 */       int playTime = FightUtil.getPlayTime(getModelid(), SFightConsts.getInstance().SUMMON_SKILL_PLAYId, Arrays.asList(new Integer[] { Integer.valueOf(fighter.fighterid) }), attacks);
/*      */       
/*  482 */       excuteCmdResult.addPlayTime(playTime);
/*      */       
/*  484 */       fighter.onFightEnd();
/*      */ 
/*      */     }
/*      */     else
/*      */     {
/*  489 */       int summonTimes = this.fightGroup.getExtra(FightGroupExtra.Summon_pet_times);
/*  490 */       if (summonTimes >= SFightConsts.getInstance().SUMMON_TIMES)
/*      */       {
/*      */ 
/*      */ 
/*      */ 
/*  495 */         GameServer.logger().info("召唤次数不足,time:" + summonTimes);
/*  496 */         return;
/*      */       }
/*      */       
/*  499 */       for (Fighter fighter : this.fightGroup.getFighters()) {
/*  500 */         if ((fighter.isPetType()) || (fighter.isChildType())) {
/*  501 */           this.fightGroup.removeFighter(fighter.getid());
/*  502 */           fighter.onFightEnd();
/*      */         }
/*      */       }
/*      */       
/*      */ 
/*  507 */       int petPos = -1 * FightManager.getPosNumberPerRow() + getPos();
/*      */       
/*  509 */       FighterPet fighterPet = this.fightGroup.addPet(pet, petPos);
/*  510 */       List<Fighter> fighters = new ArrayList();
/*  511 */       fighters.add(fighterPet);
/*  512 */       fillPlaySummonResult(playSummon, 1, this.fighterid, fighters);
/*  513 */       Skill.Attack attack = new Skill.Attack();
/*  514 */       attack.addNormalCount(1);
/*  515 */       List<Skill.Attack> attacks = new ArrayList();
/*  516 */       attacks.add(attack);
/*  517 */       int playTime = FightUtil.getPlayTime(getModelid(), SFightConsts.getInstance().SUMMON_SKILL_PLAYId, Arrays.asList(new Integer[] { Integer.valueOf(fighterPet.fighterid) }), attacks);
/*      */       
/*  519 */       excuteCmdResult.addPlayTime(playTime);
/*      */       
/*      */ 
/*      */ 
/*  523 */       PetInterface.setPetInFightFlag(getRoleid(), petUUid);
/*  524 */       fighterPet.onEnterFight();
/*  525 */       beSummonedFighter = fighterPet;
/*  526 */       this.fightGroup.setExtra(FightGroupExtra.Summon_pet_times, ++summonTimes);
/*      */     }
/*      */     
/*  529 */     if (this.fightGroup.fightTeam.fight.canSeeOppsiteHpProp()) {
/*  530 */       Play play = new Play();
/*  531 */       play.play_type = 2;
/*  532 */       play.content = playSummon.marshal(new OctetsStream());
/*  533 */       excuteCmdResult.addPlay(play, true);
/*  534 */       excuteCmdResult.addPlay(play, false);
/*  535 */       if (isRecordEnable()) {
/*  536 */         excuteCmdResult.addPlay(play);
/*      */       }
/*      */     } else {
/*  539 */       Play oppisitePlay = new Play();
/*  540 */       PlaySummon oppisitePlaySummon = getOppisitePlaySummon(playSummon, true);
/*  541 */       oppisitePlay.play_type = 2;
/*  542 */       oppisitePlay.content = oppisitePlaySummon.marshal(new OctetsStream());
/*  543 */       excuteCmdResult.addPlay(oppisitePlay, true);
/*      */       
/*  545 */       Play oppisitePassivePlay = new Play();
/*  546 */       PlaySummon oppisitePassivePlaySummon = getOppisitePlaySummon(playSummon, false);
/*  547 */       oppisitePassivePlay.play_type = 2;
/*  548 */       oppisitePassivePlay.content = oppisitePassivePlaySummon.marshal(new OctetsStream());
/*  549 */       excuteCmdResult.addPlay(oppisitePassivePlay, false);
/*      */       
/*  551 */       if (isRecordEnable()) {
/*  552 */         Play play = new Play();
/*  553 */         play.play_type = 2;
/*  554 */         play.content = playSummon.marshal(new OctetsStream());
/*  555 */         excuteCmdResult.addPlay(play);
/*      */       }
/*      */     }
/*      */     
/*  559 */     addActionCount();
/*      */     
/*  561 */     if (beSummonedFighter != null) {
/*  562 */       beSummonedFighter.handleOnAftSummon(this, excuteCmdResult);
/*      */     }
/*      */   }
/*      */   
/*      */   protected void excuteOpSummonChild(OpSummonChild opSummonChild, ExcuteCmdResult excuteCmdResult)
/*      */   {
/*  568 */     if ((isSeal()) && 
/*  569 */       (isSealSummon())) {
/*  570 */       Play play = new Play();
/*  571 */       fillPlayTipResult(play, this.fighterid, 121000019, new String[0]);
/*  572 */       excuteCmdResult.addPlay(play, true);
/*  573 */       excuteCmdResult.addPlay(play, false);
/*  574 */       if (isRecordEnable()) {
/*  575 */         excuteCmdResult.addPlay(play);
/*      */       }
/*  577 */       return;
/*      */     }
/*      */     
/*  580 */     long childid = opSummonChild.child_uuid;
/*  581 */     long roleid = getRoleid();
/*  582 */     if (!ChildrenInterface.canJoinFight(roleid, childid, false)) {
/*  583 */       GameServer.logger().info(String.format("[Fight]FighterRole.excuteOpSummonChild@do not can summon child|roleid=%d|childid=%d", new Object[] { Long.valueOf(roleid), Long.valueOf(childid) }));
/*      */       
/*      */ 
/*      */ 
/*  587 */       Play play = new Play();
/*  588 */       fillPlayTipResult(play, this.fighterid, 121000035, new String[0]);
/*  589 */       excuteCmdResult.addPlay(play, true);
/*  590 */       excuteCmdResult.addPlay(play, false);
/*  591 */       if (isRecordEnable()) {
/*  592 */         excuteCmdResult.addPlay(play);
/*      */       }
/*      */       
/*  595 */       return;
/*      */     }
/*      */     
/*  598 */     if (this.fightGroup.hasSummonBackChild(childid)) {
/*  599 */       GameServer.logger().info(String.format("[Fight]FighterRole.excuteOpSummonChild@has summoned child|roleid=%d|childid=%d", new Object[] { Long.valueOf(roleid), Long.valueOf(childid) }));
/*      */       
/*      */ 
/*  602 */       return;
/*      */     }
/*      */     
/*  605 */     ChildrenOutFightObj childrenOutFightObj = ChildrenInterface.getChildrenOutFightObj(roleid, childid, false);
/*  606 */     if (childrenOutFightObj == null) {
/*  607 */       GameServer.logger().error(String.format("[Fight]FighterRole.excuteOpSummonChild@do not exist childOutfight object|roleid=%d|childid=%d", new Object[] { Long.valueOf(roleid), Long.valueOf(childid) }));
/*      */       
/*      */ 
/*      */ 
/*      */ 
/*  612 */       return;
/*      */     }
/*      */     
/*      */ 
/*  616 */     Map<Long, FighterChild> childToFighter = new HashMap();
/*  617 */     for (Fighter fighter : this.fightGroup.getFighters()) {
/*  618 */       if ((fighter.isChild()) && ((fighter instanceof FighterChild))) {
/*  619 */         FighterChild fighterChild = (FighterChild)fighter;
/*  620 */         childToFighter.put(Long.valueOf(fighterChild.getUuid()), fighterChild);
/*      */       }
/*      */     }
/*  623 */     Fighter beSummonedFighter = null;
/*  624 */     PlaySummon playSummon = new PlaySummon();
/*  625 */     if (childToFighter.containsKey(Long.valueOf(childid)))
/*      */     {
/*  627 */       FighterChild fighter = (FighterChild)childToFighter.get(Long.valueOf(childid));
/*  628 */       if ((fighter.isDead()) || (fighter.isEscaped())) {
/*  629 */         GameServer.logger().info(String.format("[Fight]FighterRole.excuteOpSummonChild@dead or escape can not callback|roleid=%d|childid=%d", new Object[] { Long.valueOf(roleid), Long.valueOf(childid) }));
/*      */         
/*      */ 
/*      */ 
/*      */ 
/*  634 */         return;
/*      */       }
/*  636 */       List<Fighter> fighters = new ArrayList();
/*  637 */       fighters.add(fighter);
/*  638 */       fillPlaySummonResult(playSummon, 0, this.fighterid, fighters);
/*  639 */       Skill.Attack attack0 = new Skill.Attack();
/*  640 */       attack0.addNormalCount(1);
/*  641 */       List<Skill.Attack> attacks = new ArrayList();
/*  642 */       attacks.add(attack0);
/*  643 */       int playTime = FightUtil.getPlayTime(getModelid(), SFightConsts.getInstance().SUMMON_SKILL_PLAYId, Arrays.asList(new Integer[] { Integer.valueOf(fighter.fighterid) }), attacks);
/*      */       
/*  645 */       excuteCmdResult.addPlayTime(playTime);
/*      */       
/*  647 */       fighter.onFightEnd();
/*      */     }
/*      */     else {
/*  650 */       int summonChildTimes = this.fightGroup.getExtra(FightGroupExtra.Summon_child_times);
/*  651 */       if (summonChildTimes >= SChildrenConsts.getInstance().child_summon_max) {
/*  652 */         GameServer.logger().info(String.format("[Fight]FighterRole.excuteOpSummonChild@summon child times is not enough|roleid=%d|childid=%d|times=%d", new Object[] { Long.valueOf(roleid), Long.valueOf(childid), Integer.valueOf(summonChildTimes) }));
/*      */         
/*      */ 
/*      */ 
/*      */ 
/*  657 */         return;
/*      */       }
/*      */       
/*  660 */       for (Fighter fighter : this.fightGroup.getFighters()) {
/*  661 */         if ((fighter.isPetType()) || (fighter.isChildType())) {
/*  662 */           this.fightGroup.removeFighter(fighter.getid());
/*  663 */           fighter.onFightEnd();
/*      */         }
/*      */       }
/*      */       
/*      */ 
/*  668 */       int petPos = -1 * FightManager.getPosNumberPerRow() + getPos();
/*      */       
/*  670 */       FighterChild fighterChild = this.fightGroup.addChild(childrenOutFightObj, petPos);
/*  671 */       List<Fighter> fighters = new ArrayList();
/*  672 */       fighters.add(fighterChild);
/*  673 */       fillPlaySummonResult(playSummon, 1, this.fighterid, fighters);
/*  674 */       Skill.Attack attack = new Skill.Attack();
/*  675 */       attack.addNormalCount(1);
/*  676 */       List<Skill.Attack> attacks = new ArrayList();
/*  677 */       attacks.add(attack);
/*  678 */       int playTime = FightUtil.getPlayTime(getModelid(), SFightConsts.getInstance().SUMMON_SKILL_PLAYId, Arrays.asList(new Integer[] { Integer.valueOf(fighterChild.fighterid) }), attacks);
/*      */       
/*  680 */       excuteCmdResult.addPlayTime(playTime);
/*      */       
/*      */ 
/*      */ 
/*  684 */       ChildrenTaskOneByOneManager.asyncChildInFight(roleid, childid);
/*  685 */       fighterChild.onEnterFight();
/*  686 */       beSummonedFighter = fighterChild;
/*  687 */       this.fightGroup.setExtra(FightGroupExtra.Summon_child_times, ++summonChildTimes);
/*      */     }
/*      */     
/*  690 */     if (this.fightGroup.fightTeam.fight.canSeeOppsiteHpProp()) {
/*  691 */       Play play = new Play();
/*  692 */       play.play_type = 2;
/*  693 */       play.content = playSummon.marshal(new OctetsStream());
/*  694 */       excuteCmdResult.addPlay(play, true);
/*  695 */       excuteCmdResult.addPlay(play, false);
/*  696 */       if (isRecordEnable()) {
/*  697 */         excuteCmdResult.addPlay(play);
/*      */       }
/*      */     } else {
/*  700 */       Play oppisitePlay = new Play();
/*  701 */       PlaySummon oppisitePlaySummon = getOppisitePlaySummon(playSummon, true);
/*  702 */       oppisitePlay.play_type = 2;
/*  703 */       oppisitePlay.content = oppisitePlaySummon.marshal(new OctetsStream());
/*  704 */       excuteCmdResult.addPlay(oppisitePlay, true);
/*      */       
/*  706 */       Play oppisitePassivePlay = new Play();
/*  707 */       PlaySummon oppisitePassivePlaySummon = getOppisitePlaySummon(playSummon, false);
/*  708 */       oppisitePassivePlay.play_type = 2;
/*  709 */       oppisitePassivePlay.content = oppisitePassivePlaySummon.marshal(new OctetsStream());
/*  710 */       excuteCmdResult.addPlay(oppisitePassivePlay, false);
/*      */       
/*  712 */       if (isRecordEnable()) {
/*  713 */         Play play = new Play();
/*  714 */         play.play_type = 2;
/*  715 */         play.content = playSummon.marshal(new OctetsStream());
/*  716 */         excuteCmdResult.addPlay(play);
/*      */       }
/*      */     }
/*      */     
/*  720 */     addActionCount();
/*      */     
/*  722 */     if (beSummonedFighter != null) {
/*  723 */       beSummonedFighter.handleOnAftSummon(this, excuteCmdResult);
/*      */     }
/*      */   }
/*      */   
/*      */   protected void excuteOpCapture(OpCapture opCapture, ExcuteCmdResult excuteCmdResult)
/*      */   {
/*  729 */     Fighter targetFighter = null;
/*  730 */     if (opCapture.target < 0) {
/*  731 */       for (Fighter fighter : getEnermyLiveFighters()) {
/*  732 */         if ((fighter instanceof FighterMonster)) {
/*  733 */           FighterMonster fighterMonster = (FighterMonster)fighter;
/*  734 */           int monsterid = fighterMonster.getMonsterid();
/*  735 */           if (MonsterInterface.isMonsterCanAutoCatch(monsterid, getLevel()))
/*      */           {
/*  737 */             targetFighter = fighter;
/*  738 */             opCapture.target = fighter.getid();
/*  739 */             break;
/*      */ 
/*      */           }
/*      */           
/*      */         }
/*      */         
/*      */       }
/*      */       
/*      */     }
/*      */     else
/*      */     {
/*  750 */       targetFighter = getFighter(opCapture.target);
/*      */     }
/*  752 */     if ((targetFighter == null) || (!targetFighter.isExisted()) || (!targetFighter.isAlive())) {
/*  753 */       Play play = new Play();
/*  754 */       fillPlayTipResult(play, getid(), 121000012, new String[0]);
/*  755 */       excuteCmdResult.addPlay(play, true);
/*  756 */       excuteCmdResult.addPlay(play, false);
/*  757 */       if (isRecordEnable()) {
/*  758 */         excuteCmdResult.addPlay(play);
/*      */       }
/*  760 */       return;
/*      */     }
/*      */     
/*  763 */     if (PetInterface.isPetBagFull(getRoleid()))
/*      */     {
/*  765 */       Play play = new Play();
/*  766 */       fillPlayTipResult(play, getid(), 121000013, new String[0]);
/*  767 */       excuteCmdResult.addPlay(play, true);
/*  768 */       excuteCmdResult.addPlay(play, false);
/*  769 */       if (isRecordEnable()) {
/*  770 */         excuteCmdResult.addPlay(play);
/*      */       }
/*  772 */       return;
/*      */     }
/*      */     
/*  775 */     if ((targetFighter instanceof FighterMonster))
/*      */     {
/*  777 */       FighterMonster fighterMonster = (FighterMonster)targetFighter;
/*  778 */       Monster monster = MonsterInterface.getMonster(fighterMonster.getMonsterid(), fighterMonster.getLevel());
/*  779 */       int petCfgId = monster.getCatchedId();
/*  780 */       PetCfg petCfg = PetInterface.getPetCfgByCfgId(petCfgId);
/*  781 */       if (petCfg != null)
/*      */       {
/*  783 */         if (petCfg.getCarrayLevel() > getLevel()) {
/*  784 */           Play play = new Play();
/*  785 */           fillPlayTipResult(play, getid(), 121000007, new String[0]);
/*  786 */           excuteCmdResult.addPlay(play, true);
/*  787 */           excuteCmdResult.addPlay(play, false);
/*  788 */           if (isRecordEnable()) {
/*  789 */             excuteCmdResult.addPlay(play);
/*      */           }
/*      */         }
/*      */       }
/*      */       else
/*      */       {
/*  795 */         Play play = new Play();
/*  796 */         fillPlayTipResult(play, getid(), 121000012, new String[0]);
/*  797 */         excuteCmdResult.addPlay(play, true);
/*  798 */         excuteCmdResult.addPlay(play, false);
/*  799 */         if (isRecordEnable()) {
/*  800 */           excuteCmdResult.addPlay(play);
/*      */         }
/*  802 */         return;
/*      */       }
/*      */       
/*  805 */       Play play = new Play();
/*  806 */       int captrueRate = getCatchPetRate(monster) + fighterMonster.getBeCapatureRate();
/*      */       
/*  808 */       if (FightFormulaHelp.isCaptrue(captrueRate)) {
/*  809 */         long petid = PetInterface.addCatchPet(getRoleid(), petCfgId, monster.getLevel());
/*  810 */         if (petid > 0L) {
/*  811 */           fighterMonster.setDead();
/*  812 */           fillPlayCaptureResult(play, opCapture.target, 0);
/*      */         } else {
/*  814 */           fillPlayCaptureResult(play, opCapture.target, 1);
/*      */         }
/*      */       }
/*      */       else {
/*  818 */         fillPlayCaptureResult(play, opCapture.target, 1);
/*  819 */         TriggerEventsManger.getInstance().triggerEvent(new PetCatchEvent(), new PetCatchEventArg(getRoleid(), petCfgId, monster.getLevel(), false), RoleOneByOneManager.getInstance().getTaskOneByOne(Long.valueOf(getRoleid())));
/*      */       }
/*      */       
/*      */ 
/*      */ 
/*  824 */       Skill.Attack attack = new Skill.Attack();
/*  825 */       attack.addNormalCount(1);
/*  826 */       List<Skill.Attack> attacks = new ArrayList();
/*  827 */       attacks.add(attack);
/*  828 */       int playTime = FightUtil.getPlayTime(getModelid(), SFightConsts.getInstance().CAPTURE_SKILL_PLAYId, Arrays.asList(new Integer[] { Integer.valueOf(opCapture.target) }), attacks);
/*      */       
/*  830 */       excuteCmdResult.addPlay(play, true);
/*  831 */       excuteCmdResult.addPlay(play, false);
/*  832 */       if (isRecordEnable()) {
/*  833 */         excuteCmdResult.addPlay(play);
/*      */       }
/*  835 */       excuteCmdResult.addPlayTime(playTime);
/*      */       
/*  837 */       addActionCount();
/*      */     } else {
/*  839 */       Play play = new Play();
/*  840 */       fillPlayTipResult(play, getid(), 121000012, new String[0]);
/*  841 */       excuteCmdResult.addPlay(play, true);
/*  842 */       excuteCmdResult.addPlay(play, false);
/*  843 */       if (isRecordEnable()) {
/*  844 */         excuteCmdResult.addPlay(play);
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   void broadCastSelectOperInTeam()
/*      */   {
/*  856 */     if (!OnlineManager.getInstance().isOnline(getRoleid()))
/*  857 */       return;
/*  858 */     SSelectOperateBrd operateBrd = new SSelectOperateBrd();
/*  859 */     operateBrd.fighterid = this.fighterid;
/*      */     
/*  861 */     operateBrd.auto = (isAuto() ? 1 : 0);
/*  862 */     FightCmd xCmd = getFight().getFightCmd(this.fighterid);
/*  863 */     operateBrd.op_type = xCmd.getOp_type();
/*  864 */     operateBrd.content.replace(xCmd.getContentCopy());
/*      */     
/*  866 */     this.fightGroup.fightTeam.broadcast(operateBrd);
/*      */   }
/*      */   
/*      */   protected void onFightEnd()
/*      */   {
/*  871 */     int cfgType = this.fightGroup.getFight().getCfgType();
/*  872 */     SFightTypeCfg fightTypeCfg = FightConfigManager.getInstance().getFightTypeCfg(cfgType);
/*  873 */     Set<Long> aliveRoleSet = new HashSet();
/*  874 */     Set<Long> deadRoleSet = new HashSet();
/*  875 */     long roleid = getRoleid();
/*  876 */     if ((isDead()) || (isFakeDead())) {
/*  877 */       deadRoleSet.add(Long.valueOf(roleid));
/*      */     } else {
/*  879 */       aliveRoleSet.add(Long.valueOf(roleid));
/*      */     }
/*      */     
/*  882 */     RoleOutFightObj outFightObj = null;
/*      */     try {
/*  884 */       outFightObj = RoleInterface.getRoleOutFightObject(roleid);
/*      */     } catch (Exception e) {
/*  886 */       GameServer.logger().error(String.format("FighterRole.onFightEnd@get role outfight object exception|roleid=%d", new Object[] { Long.valueOf(roleid) }));
/*      */     }
/*      */     
/*      */ 
/*  890 */     if (outFightObj != null)
/*      */     {
/*  892 */       if ((fightTypeCfg.synHpMpAnger) && (aliveRoleSet.contains(Long.valueOf(roleid))))
/*      */       {
/*  894 */         int hp = Math.max(1, getHp());
/*      */         try {
/*  896 */           hp = Math.min(hp, outFightObj.getFinalMaxHP());
/*  897 */           outFightObj.setHP(hp);
/*      */         } catch (Exception e) {
/*  899 */           GameServer.logger().error(String.format("FighterRole.onFightEnd@set role outfight object hp exception|roleid=%d|hp=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(hp) }));
/*      */         }
/*      */         
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  906 */         int mp = Math.max(0, getMp());
/*      */         try {
/*  908 */           mp = Math.min(mp, outFightObj.getFinalMaxHP());
/*  909 */           outFightObj.setMP(mp);
/*      */         } catch (Exception e) {
/*  911 */           GameServer.logger().error(String.format("FighterRole.onFightEnd@set role outfight object mp exception|roleid=%d|mp=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(mp) }));
/*      */         }
/*      */         
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  918 */         int anger = Math.max(0, getAnger());
/*      */         try {
/*  920 */           anger = Math.min(anger, outFightObj.getMaxAnger());
/*  921 */           outFightObj.setAnger(anger);
/*      */         } catch (Exception e) {
/*  923 */           GameServer.logger().error(String.format("FighterRole.onFightEnd@set role outfight object anger exception|roleid=%d|anger=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(anger) }));
/*      */         }
/*      */       }
/*      */       
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  943 */       if (fightTypeCfg.isUsePoint) {
/*      */         try {
/*  945 */           ItemInterface.decEquipUsePoint(deadRoleSet, aliveRoleSet);
/*      */         } catch (Exception e) {
/*  947 */           GameServer.logger().error(String.format("FighterRole.onFightEnd@cut role equip point exception|roleid=%d", new Object[] { Long.valueOf(roleid) }));
/*      */         }
/*      */       }
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*  954 */     this.fightGroup.addLeaveFightFighter(this);
/*  955 */     this.fightGroup.removeFighter(this.fighterid);
/*  956 */     Long fightIdLong = Role2fight.get(Long.valueOf(roleid));
/*  957 */     if ((fightIdLong != null) && (fightIdLong.longValue() != this.fightGroup.fightTeam.fight.fightid)) {
/*  958 */       GameServer.logger().error(String.format("[fight]remove_fihgt wrong|roleid=%d|fightid=%d", new Object[] { Long.valueOf(roleid), fightIdLong }));
/*      */     }
/*      */     
/*  961 */     Role2fight.remove(Long.valueOf(roleid));
/*  962 */     RoleStatusInterface.unsetStatus(roleid, 0);
/*      */   }
/*      */   
/*      */   public boolean isMyOwner(Fighter fighter)
/*      */   {
/*  967 */     return false;
/*      */   }
/*      */   
/*      */   public boolean carryPet()
/*      */   {
/*  972 */     Set<Fighter> fighters = this.fightGroup.getExistedFighters();
/*  973 */     for (Fighter fighter : fighters) {
/*  974 */       if (fighter.isPetType()) {
/*  975 */         return true;
/*      */       }
/*      */     }
/*  978 */     return false;
/*      */   }
/*      */   
/*      */   public boolean carryChild()
/*      */   {
/*  983 */     Set<Fighter> fighters = this.fightGroup.getExistedFighters();
/*  984 */     for (Fighter fighter : fighters) {
/*  985 */       if (fighter.isChildType()) {
/*  986 */         return true;
/*      */       }
/*      */     }
/*  989 */     return false;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   final void handleOnPetEnterFight(FighterPet fighterPet)
/*      */   {
/* 1004 */     Set<PetEnterFightHandle> copySet = copySetValue(this.xFighter.getHandleonpetenterfighthandle());
/* 1005 */     for (PetEnterFightHandle petEnterFightHandle : copySet) {
/* 1006 */       petEnterFightHandle.onPetEnterFight(this, fighterPet);
/*      */     }
/*      */   }
/*      */   
/*      */   final void handleOnChildEnterFight(FighterChild child) {
/* 1011 */     Set<ChildEnterFightHandle> copySet = copySetValue(this.xFighter.getHandleonchildenterfighthandle());
/*      */     
/* 1013 */     for (ChildEnterFightHandle petEnterFightHandle : copySet) {
/* 1014 */       petEnterFightHandle.onEnterFight(this, child);
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   protected void beforeExcuteSkill(Op_UseSkill opUseSkill, ExcuteCmdResult excuteCmdResult)
/*      */   {
/* 1021 */     if (opUseSkill.skill == SFightConsts.getInstance().DEFENCE_SKILL) {
/* 1022 */       return;
/*      */     }
/*      */     
/*      */ 
/* 1026 */     FighterMounts xFighterMounts = this.xFighter.getFightermounts();
/* 1027 */     if (xFighterMounts.getMountcfgid() == 0) {
/* 1028 */       return;
/*      */     }
/* 1030 */     SSkillCfg skillCfg = SSkillCfg.get(opUseSkill.skill);
/* 1031 */     if (skillCfg == null) {
/* 1032 */       GameServer.logger().error(String.format("[Fight]FighterRole.beforeExcuteOpSkill@skill not exist|skillid=%d|roleid=%d", new Object[] { Integer.valueOf(opUseSkill.skill), Long.valueOf(getRoleid()) }));
/*      */       
/*      */ 
/* 1035 */       return;
/*      */     }
/* 1037 */     if (skillCfg.mountsSkillClassid <= 0) {
/* 1038 */       return;
/*      */     }
/* 1040 */     SMountsSkillCfg mountsSkillCfg = SMountsSkillCfg.get(skillCfg.mountsSkillClassid);
/* 1041 */     if (mountsSkillCfg == null) {
/* 1042 */       if (!FightInterface.isNormalAttackSkill(opUseSkill.skill)) {
/* 1043 */         GameServer.logger().error(String.format("[Fight]FighterRole.beforeExcuteOpSkill@mounts skill classid not exist|roleid=%d|skillid=%d|classid=%d", new Object[] { Long.valueOf(getRoleid()), Integer.valueOf(opUseSkill.skill), Integer.valueOf(skillCfg.mountsSkillClassid) }));
/*      */       }
/*      */       
/*      */ 
/*      */ 
/*      */ 
/* 1049 */       return;
/*      */     }
/* 1051 */     int ret = Xdb.random().nextInt(FightArgs.getInstance().defaultRate);
/* 1052 */     List<Skill> triggerSkills = new ArrayList();
/* 1053 */     for (Map.Entry<Integer, Integer> skillid2Lv : xFighterMounts.getSkillmap().entrySet()) {
/* 1054 */       int skillid = ((Integer)skillid2Lv.getKey()).intValue();
/* 1055 */       Integer rate = (Integer)mountsSkillCfg.mountsSkillMap.get(Integer.valueOf(skillid));
/* 1056 */       if ((rate != null) && 
/*      */       
/*      */ 
/* 1059 */         (rate.intValue() > ret))
/*      */       {
/*      */ 
/* 1062 */         Skill skill = SkillInterface.getSkill(skillid, ((Integer)skillid2Lv.getValue()).intValue());
/* 1063 */         if (canNomalUseSkill(skill))
/* 1064 */           triggerSkills.add(skill);
/*      */       }
/*      */     }
/* 1067 */     int size = triggerSkills.size();
/* 1068 */     if (size <= 0) {
/* 1069 */       return;
/*      */     }
/* 1071 */     int index = Xdb.random().nextInt(size);
/* 1072 */     Skill skill = (Skill)triggerSkills.get(index);
/* 1073 */     List<Fighter> targets = skill.getTargets(this, opUseSkill.main_target, true);
/* 1074 */     if (!skill.canRun(this, opUseSkill.main_target, targets, true)) {
/* 1075 */       return;
/*      */     }
/* 1077 */     doUseSkill(opUseSkill, excuteCmdResult, targets, skill.getID(), skill, 0, new BeforeUseSkilHandle.OutputObj());
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   void initChangeModelCard()
/*      */   {
/* 1111 */     ChangeModelCardInterface.ClassLevelEntry entry = ChangeModelCardInterface.getRoleClassTypeAndLevel(getRoleid(), true);
/*      */     
/* 1113 */     initChangeModelCard(entry.classType, entry.level);
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\main\FighterRole.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */