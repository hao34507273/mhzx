/*     */ package mzm.gsp.fight.main;
/*     */ 
/*     */ import com.goldhuman.Common.Octets;
/*     */ import java.util.Collection;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.common.IOutFightObject;
/*     */ import mzm.gsp.fight.SSelectOperateBrd;
/*     */ import mzm.gsp.fight.SSynRolePetSkillInfo;
/*     */ import mzm.gsp.fight.confbean.SFightConsts;
/*     */ import mzm.gsp.fight.confbean.SFightTypeCfg;
/*     */ import mzm.gsp.monster.main.MonsterInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.pet.confbean.PetConstants;
/*     */ import mzm.gsp.pet.confbean.SPetCfg;
/*     */ import mzm.gsp.pet.main.Pet;
/*     */ import mzm.gsp.pet.main.PetInterface;
/*     */ import mzm.gsp.pet.main.PetOutFightObj;
/*     */ import mzm.gsp.skill.confbean.SSkillCfg;
/*     */ import mzm.gsp.skill.main.PassiveSkill;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.FightCache;
/*     */ import xbean.FightCmd;
/*     */ 
/*     */ final class FighterPet
/*     */   extends Fighter
/*     */ {
/*     */   FighterPet(int fighterid, xbean.Fighter xFighter, FightGroup fightGroup)
/*     */   {
/*  34 */     super(fighterid, xFighter, fightGroup);
/*     */   }
/*     */   
/*     */   protected boolean canPlayerOperate()
/*     */   {
/*  39 */     return true;
/*     */   }
/*     */   
/*     */   protected void init(Pet pet, int pos)
/*     */   {
/*  44 */     setPos(pos);
/*     */     
/*  46 */     long petid = pet.getId();
/*     */     
/*  48 */     setUuid(petid);
/*     */     
/*  50 */     setExtra(FighterExtra.PET_CFG_ID, pet.getCfgId());
/*     */     
/*     */ 
/*  53 */     PetOutFightObj outFightObj = PetInterface.getPetOutFightObjById(getOwnerid(), pet.getId());
/*  54 */     setHp(Math.min(outFightObj.getHP(), outFightObj.getFinalMaxHP()));
/*  55 */     setMp(Math.min(outFightObj.getMP(), outFightObj.getFinalMaxMP()));
/*  56 */     setAnger(0.0D);
/*  57 */     setGender(outFightObj);
/*  58 */     setOccupation(outFightObj.getOccupationId());
/*     */     
/*  60 */     if (OpenInterface.getOpenStatus(239)) {
/*  61 */       outFightObj.fillFinalPropertyMap(getAttrsMap());
/*     */     }
/*     */     else {
/*  64 */       outFightObj.fillSelfFixFightProperty(getAttrsMap());
/*     */       
/*  66 */       outFightObj.fillOtherFightProperty(getExa_AttrsMap());
/*     */     }
/*     */     
/*     */ 
/*  70 */     List<Integer> skillsList = PetInterface.getPetSkillList(getOwnerid(), pet.getId());
/*     */     
/*     */ 
/*  73 */     for (Iterator i$ = skillsList.iterator(); i$.hasNext();) { int skillid = ((Integer)i$.next()).intValue();
/*  74 */       addSkill(skillid, outFightObj.getLevel());
/*     */     }
/*     */     
/*     */ 
/*  78 */     PetInterface.setPetInFightFlag(getOwnerid(), petid);
/*     */     
/*     */ 
/*  81 */     SSynRolePetSkillInfo synRolePetSkillInfo = new SSynRolePetSkillInfo();
/*  82 */     synRolePetSkillInfo.fight_uuid = this.fightGroup.fightTeam.getFight().fightid;
/*  83 */     synRolePetSkillInfo.petuuid = pet.getId();
/*  84 */     synRolePetSkillInfo.skillmap.putAll(getActiveSkillMap());
/*  85 */     OnlineManager.getInstance().send(getOwnerid(), synRolePetSkillInfo);
/*     */     
/*     */ 
/*  88 */     FightCache xFightCache = getFightCache();
/*  89 */     validateAutoSkill(petid, xFightCache, skillsList);
/*  90 */     boolean needSetAutoSkill = (xFightCache == null) || (!xFightCache.getPet_default_skills().containsKey(Long.valueOf(pet.getId())));
/*     */     Iterator i$;
/*  92 */     if (needSetAutoSkill) {
/*  93 */       for (i$ = skillsList.iterator(); i$.hasNext();) { int skillid = ((Integer)i$.next()).intValue();
/*  94 */         SSkillCfg skillCfg = SSkillCfg.get(skillid);
/*  95 */         if (skillCfg.canAuto)
/*     */         {
/*     */ 
/*  98 */           setLastCanAutoSkill(skillid);
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 104 */     if (!xFightCache.getPet_default_skills().containsKey(Long.valueOf(pet.getId()))) {
/* 105 */       setLastCanAutoSkill(PetConstants.getInstance().NORMAL_ATTACK_SKILLID);
/*     */     }
/* 107 */     if ((needSetAutoSkill) && (xFightCache != null) && 
/* 108 */       (xFightCache.getIsauto())) {
/* 109 */       FightInterface.syncAutoState(getOwnerid(), xFightCache);
/*     */     }
/*     */     
/*     */ 
/* 113 */     List<PassiveSkill> passiveSkills = outFightObj.getPassiveSkills();
/* 114 */     installPassiveSkills(passiveSkills);
/* 115 */     initOutFightCommon(outFightObj);
/*     */   }
/*     */   
/*     */   private void validateAutoSkill(long petid, FightCache xFightCache, Collection<Integer> skillids) {
/* 119 */     if (xFightCache != null)
/*     */     {
/* 121 */       Integer autoSkill = (Integer)xFightCache.getPet_default_skills().get(Long.valueOf(petid));
/* 122 */       if (autoSkill != null) {
/* 123 */         if (FightManager.isCommonSkill(autoSkill.intValue(), getOccupation())) {
/* 124 */           return;
/*     */         }
/* 126 */         if (!skillids.contains(autoSkill)) {
/* 127 */           xFightCache.getPet_default_skills().remove(Long.valueOf(petid));
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected final long getOwnerid()
/*     */   {
/* 139 */     return this.fightGroup.getRoleid();
/*     */   }
/*     */   
/*     */   protected IOutFightObject getOutFightObj()
/*     */   {
/* 144 */     return PetInterface.getPetOutFightObjById(getOwnerid(), getUuid());
/*     */   }
/*     */   
/*     */   protected boolean isAuto()
/*     */   {
/* 149 */     FightCache fightCache = getFightCache();
/* 150 */     if (fightCache != null) {
/* 151 */       return fightCache.getIsauto();
/*     */     }
/* 153 */     return false;
/*     */   }
/*     */   
/*     */   protected int getAutoSkill()
/*     */   {
/* 158 */     FightCache fightCache = getFightCache();
/* 159 */     if (fightCache == null) {
/* 160 */       return getCfgDefaultSkill();
/*     */     }
/* 162 */     if (fightCache.getPet_default_skills().containsKey(Long.valueOf(getUuid()))) {
/* 163 */       return ((Integer)fightCache.getPet_default_skills().get(Long.valueOf(getUuid()))).intValue();
/*     */     }
/* 165 */     int skill = getCfgDefaultSkill();
/* 166 */     fightCache.getPet_default_skills().put(Long.valueOf(getUuid()), Integer.valueOf(skill));
/*     */     
/* 168 */     FightInterface.syncAutoState(getOwnerid());
/* 169 */     return skill;
/*     */   }
/*     */   
/*     */   protected void setAutoSkill(int skillid)
/*     */   {
/* 174 */     if (hasSkill(skillid)) {
/* 175 */       FightCache fightCache = getFightCache();
/* 176 */       if (fightCache == null) {
/* 177 */         return;
/*     */       }
/* 179 */       fightCache.getPet_default_skills().put(Long.valueOf(getUuid()), Integer.valueOf(skillid));
/*     */       
/* 181 */       sendDefalutSkillChangeRes(getOwnerid(), skillid, getUuid(), 4);
/*     */     } else {
/* 183 */       sendDefalutSkillChangeRes(getOwnerid(), getAutoSkill(), getUuid(), 4);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   void setLastCanAutoSkill(int skillid)
/*     */   {
/* 195 */     SSkillCfg skillCfg = SSkillCfg.get(skillid);
/* 196 */     if (skillCfg == null) {
/* 197 */       return;
/*     */     }
/* 199 */     if ((skillCfg.canAuto) && 
/* 200 */       (hasSkill(skillid))) {
/* 201 */       FightCache fightCache = getFightCache();
/* 202 */       if (fightCache == null) {
/* 203 */         return;
/*     */       }
/* 205 */       fightCache.getPet_default_skills().put(Long.valueOf(getUuid()), Integer.valueOf(skillid));
/*     */     }
/*     */   }
/*     */   
/*     */   private FightCache getFightCache()
/*     */   {
/* 211 */     if ((this.fightGroup instanceof FightGroupRole)) {
/* 212 */       return ((FightGroupRole)this.fightGroup).createXFightCacheIfNotExist();
/*     */     }
/* 214 */     return null;
/*     */   }
/*     */   
/*     */   protected void setAuto()
/*     */   {
/* 219 */     if ((this.fightGroup instanceof FightGroupRole)) {
/* 220 */       ((FightGroupRole)this.fightGroup).setAuto(true);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected void setDefautOper()
/*     */   {
/* 231 */     if (!isExisted()) {
/* 232 */       return;
/*     */     }
/* 234 */     AI ai = getAI();
/* 235 */     if (ai != null) {
/* 236 */       ai.onRoundBegin(this.fightGroup.getFight(), this);
/*     */     }
/* 238 */     if (!this.fightGroup.getFight().hasFightCmd(this.fighterid))
/*     */     {
/* 240 */       long roleid = this.fightGroup.getRoleid();
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
/* 252 */       if (!PetInterface.isPetBagFull(roleid)) {
/* 253 */         for (Fighter fighter : getEnermyLiveFighters()) {
/* 254 */           if ((fighter instanceof FighterMonster)) {
/* 255 */             FighterMonster fighterMonster = (FighterMonster)fighter;
/* 256 */             if (MonsterInterface.isMonsterCanAutoCatch(fighterMonster.getMonsterid(), getOwnerLevel()))
/*     */             {
/* 258 */               Op_UseSkill opUseSkill = new Op_UseSkill();
/* 259 */               opUseSkill.main_target = this.fighterid;
/* 260 */               opUseSkill.skill = SFightConsts.getInstance().DEFENCE_SKILL;
/* 261 */               if (hasSkill(opUseSkill.skill)) {
/* 262 */                 opUseSkill.skillLv = fighter.getSkillLevel(opUseSkill.skill);
/*     */               }
/* 264 */               this.fightGroup.getFight().addFightCmd(this.fighterid, 0, opUseSkill);
/*     */               
/* 266 */               break;
/*     */             }
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 274 */     if (!this.fightGroup.getFight().hasFightCmd(this.fighterid))
/*     */     {
/* 276 */       super.setDefautOper();
/*     */     }
/*     */   }
/*     */   
/*     */   private int getOwnerLevel()
/*     */   {
/* 282 */     for (Fighter fighter : this.fightGroup.getFighters()) {
/* 283 */       if (fighter.isRoleType()) {
/* 284 */         return fighter.getLevel();
/*     */       }
/*     */     }
/* 287 */     return getLevel();
/*     */   }
/*     */   
/*     */   protected void onFightEnd()
/*     */   {
/* 292 */     SFightTypeCfg fightTypeCfg = FightConfigManager.getInstance().getFightTypeCfg(this.fightGroup.getFight().getCfgType());
/*     */     
/* 294 */     PetOutFightObj petOutFightObj = null;
/* 295 */     long roleid = getOwnerid();
/* 296 */     long petuuid = getUuid();
/* 297 */     FightCache xFightCache = getFightCache();
/*     */     try {
/* 299 */       PetInterface.setPetOutFightFlag(roleid, petuuid);
/* 300 */       petOutFightObj = PetInterface.getPetOutFightObjById(roleid, petuuid);
/* 301 */       List<Integer> skillids = PetInterface.getPetSkillList(roleid, petuuid);
/* 302 */       validateAutoSkill(petuuid, xFightCache, skillids);
/*     */     } catch (Exception e) {
/* 304 */       GameServer.logger().error(String.format("FighterPet.onFightEnd@get pet outfight object exception|roleid=%d|petuuid=%d", new Object[] { Long.valueOf(roleid), Long.valueOf(petuuid) }));
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 309 */     if (petOutFightObj != null) {
/* 310 */       int cutLifeValue = fightTypeCfg.petAliveLostHealth;
/* 311 */       if ((isDead()) || (isFakeDead())) {
/* 312 */         cutLifeValue = fightTypeCfg.petDeadLostHealth;
/*     */       }
/*     */       try
/*     */       {
/* 316 */         petOutFightObj.addLife(-cutLifeValue);
/*     */       } catch (Exception e) {
/* 318 */         GameServer.logger().error(String.format("FighterPet.onFightEnd@cut pet outfight object life exception|roleid=%d|petuuid=%d|cut_value=%d", new Object[] { Long.valueOf(roleid), Long.valueOf(petuuid), Integer.valueOf(cutLifeValue) }));
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 325 */       if (fightTypeCfg.synHpMpAnger)
/*     */       {
/* 327 */         int hp = Math.max(1, getHp());
/*     */         try {
/* 329 */           hp = Math.min(hp, petOutFightObj.getFinalMaxHP());
/* 330 */           petOutFightObj.setHP(hp);
/*     */         } catch (Exception e) {
/* 332 */           GameServer.logger().error(String.format("FighterPet.onFightEnd@set pet hp exception|roleid=%d|petuuid=%d|set_value=%d", new Object[] { Long.valueOf(roleid), Long.valueOf(petuuid), Integer.valueOf(hp) }));
/*     */         }
/*     */         
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 339 */         int mp = Math.max(0, getMp());
/*     */         try {
/* 341 */           mp = Math.min(mp, petOutFightObj.getFinalMaxMP());
/* 342 */           petOutFightObj.setMP(mp);
/*     */         } catch (Exception e) {
/* 344 */           GameServer.logger().error(String.format("FighterPet.onFightEnd@set pet mp exception|roleid=%d|petuuid=%d|set_value=%d", new Object[] { Long.valueOf(roleid), Long.valueOf(petuuid), Integer.valueOf(mp) }));
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 353 */     this.fightGroup.addLeaveFightFighter(this);
/* 354 */     this.fightGroup.removeFighter(this.fighterid);
/*     */   }
/*     */   
/*     */   void broadCastSelectOperInTeam()
/*     */   {
/* 359 */     if (!OnlineManager.getInstance().isOnline(getOwnerid()))
/* 360 */       return;
/* 361 */     SSelectOperateBrd operateBrd = new SSelectOperateBrd();
/* 362 */     operateBrd.fighterid = this.fighterid;
/* 363 */     operateBrd.auto = (isAuto() ? 1 : 0);
/* 364 */     FightCmd xCmd = getFight().getFightCmd(this.fighterid);
/* 365 */     operateBrd.op_type = xCmd.getOp_type();
/* 366 */     operateBrd.content.replace(xCmd.getContentCopy());
/* 367 */     this.fightGroup.fightTeam.broadcast(operateBrd);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   void onDead()
/*     */   {
/* 386 */     if (isNotLeave()) {
/* 387 */       setFakeDead();
/*     */     } else {
/* 389 */       setDead();
/*     */     }
/* 391 */     super.onFighterDead();
/*     */   }
/*     */   
/*     */   public boolean isMyOwner(Fighter fighter)
/*     */   {
/* 396 */     if (this.fightGroup.groupid != fighter.fightGroup.groupid) {
/* 397 */       return false;
/*     */     }
/* 399 */     if ((fighter instanceof FighterRole)) {
/* 400 */       FighterRole fighterRole = (FighterRole)fighter;
/* 401 */       return fighterRole.getRoleid() == getOwnerid();
/*     */     }
/* 403 */     return false;
/*     */   }
/*     */   
/*     */   protected void onEnterFight()
/*     */   {
/* 408 */     super.onEnterFight();
/* 409 */     FightGroup fightGroup = this.fightGroup;
/* 410 */     if ((fightGroup instanceof FightGroupRole)) {
/* 411 */       FightGroupRole fightGroupRole = (FightGroupRole)fightGroup;
/* 412 */       FighterRole fighterRole = fightGroupRole.getFighterRole();
/* 413 */       if (fighterRole != null) {
/* 414 */         fighterRole.handleOnPetEnterFight(this);
/*     */       }
/*     */     } else {
/* 417 */       GameServer.logger().error(String.format("pet is not in fightGruopRole", new Object[0]));
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   void initChangeModelCard()
/*     */   {
/* 424 */     SPetCfg cfg = SPetCfg.get(getExtra(FighterExtra.PET_CFG_ID));
/* 425 */     int cardClassType = cfg.change_model_card_class_type;
/* 426 */     int cardLevel = cfg.change_model_card_level;
/* 427 */     initChangeModelCard(cardClassType, cardLevel);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\main\FighterPet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */