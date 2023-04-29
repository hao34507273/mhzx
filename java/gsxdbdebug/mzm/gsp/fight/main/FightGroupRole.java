/*     */ package mzm.gsp.fight.main;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.effect.main.EffectInterface;
/*     */ import mzm.gsp.effect.main.FighterEffectGroup;
/*     */ import mzm.gsp.fight.AttackResult;
/*     */ import mzm.gsp.fight.AttackResultBean;
/*     */ import mzm.gsp.fight.FighterStatus;
/*     */ import mzm.gsp.fight.OpItem;
/*     */ import mzm.gsp.fight.Play;
/*     */ import mzm.gsp.fight.PlayUseItem;
/*     */ import mzm.gsp.fight.confbean.SFightConsts;
/*     */ import mzm.gsp.fight.confbean.SFightTypeCfg;
/*     */ import mzm.gsp.fight.confbean.SItemTypeInFightCfg;
/*     */ import mzm.gsp.fight.handle.DrugHandle.InputObj;
/*     */ import mzm.gsp.fight.handle.DrugHandle.OutputObj;
/*     */ import mzm.gsp.item.confbean.SDrugItem;
/*     */ import mzm.gsp.item.confbean.SItemCfg;
/*     */ import mzm.gsp.item.confbean.SItemDrugInFightCfg;
/*     */ import mzm.gsp.item.main.BasicItem;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.monster.main.Monster;
/*     */ import mzm.gsp.monster.main.MonsterInterface;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.partner.main.PartnerOutFightObj;
/*     */ import mzm.gsp.pet.main.Pet;
/*     */ import mzm.gsp.pet.main.PetInterface;
/*     */ import mzm.gsp.pet.main.PetOutFightObj;
/*     */ import mzm.gsp.pvc.confbean.PVCRobotCfg;
/*     */ import mzm.gsp.pvc.confbean.SPVCCfg;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.role.main.RoleOutFightObj;
/*     */ import mzm.gsp.skill.main.Skill;
/*     */ import mzm.gsp.skill.main.Skill.Attack;
/*     */ import mzm.gsp.skill.main.SkillInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.Pair;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.FightCache;
/*     */ import xbean.Pod;
/*     */ import xtable.Rolefightcache;
/*     */ 
/*     */ 
/*     */ class FightGroupRole
/*     */   extends FightGroup
/*     */ {
/*     */   FightGroupRole(int groupid, xbean.FightGroup xGroup, FightTeam fightTeam)
/*     */   {
/*  60 */     super(groupid, xGroup, fightTeam);
/*     */   }
/*     */   
/*     */   void init(long roleid, int pos, int teamMaxLevel)
/*     */   {
/*  65 */     setRoleid(roleid);
/*     */     
/*  67 */     int posNumPerRow = FightManager.getPosNumberPerRow();
/*     */     
/*  69 */     int rolePos = 1 * posNumPerRow + pos;
/*  70 */     FighterRole fr = generateFighterRole();
/*  71 */     fr.init(RoleInterface.getRoleOutFightObject(getRoleid()), rolePos, teamMaxLevel);
/*     */     
/*     */ 
/*  74 */     Pet pet = PetInterface.getFightPet(roleid, true);
/*  75 */     if (pet != null) {
/*  76 */       int petPos = 0 * posNumPerRow + pos;
/*  77 */       FighterPet fp = generateFighterPet();
/*  78 */       fp.init(pet, petPos);
/*     */     }
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
/*     */   CloneFighterPet initClonePet(long roleId, long petId, int fightPos, Map<Integer, Integer> extraAttr)
/*     */   {
/*  93 */     setRoleid(roleId);
/*  94 */     setCloneGroup();
/*     */     
/*  96 */     Pet pet = PetInterface.getPetById(roleId, petId);
/*  97 */     if (pet == null) {
/*  98 */       return null;
/*     */     }
/* 100 */     Map<Integer, Integer> petAttrsMap = new HashMap();
/* 101 */     Map<Integer, Integer> petExaAttrsMap = new HashMap();
/* 102 */     if (extraAttr != null) {
/* 103 */       petExaAttrsMap.putAll(extraAttr);
/*     */     }
/* 105 */     int petPos = fightPos;
/* 106 */     PetOutFightObj petOutFightObj = PetInterface.getPetOutFightObjById(roleId, pet.getId());
/* 107 */     if (OpenInterface.getOpenStatus(239)) {
/* 108 */       petOutFightObj.fillFinalPropertyMap(petAttrsMap);
/*     */     } else {
/* 110 */       petOutFightObj.fillSelfFixFightProperty(petAttrsMap);
/* 111 */       petOutFightObj.fillOtherFightProperty(petExaAttrsMap);
/*     */     }
/*     */     
/* 114 */     CloneFighterPet fp = generateCloneFighterPet();
/* 115 */     fp.init(pet, petPos, petAttrsMap, petExaAttrsMap);
/* 116 */     return fp;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   void initFellow(Map<Integer, PartnerOutFightObj> posToPartnerMap)
/*     */   {
/* 125 */     for (Map.Entry<Integer, PartnerOutFightObj> entry : posToPartnerMap.entrySet()) {
/* 126 */       int pos = ((Integer)entry.getKey()).intValue();
/* 127 */       PartnerOutFightObj p = (PartnerOutFightObj)entry.getValue();
/* 128 */       FighterFellow ff = generateFighterFellow();
/* 129 */       ff.init(p, pos);
/*     */     }
/*     */   }
/*     */   
/*     */   void initClone(long roleid, int pos, SPVCCfg pvCfg, int level) {
/* 134 */     setRoleid(roleid);
/* 135 */     setCloneGroup();
/* 136 */     int posNumPerRow = FightManager.getPosNumberPerRow();
/*     */     
/* 138 */     int rolePos = 1 * posNumPerRow + pos;
/* 139 */     CloneFighterRole cloneRoleFighter = generateCloneFighterRole();
/* 140 */     RoleOutFightObj outFightObj = RoleInterface.getRoleOutFightObject(roleid);
/* 141 */     Map<Integer, Integer> attrsMap = new HashMap();
/* 142 */     Map<Integer, Integer> exaAttrsMap = new HashMap();
/* 143 */     if (OpenInterface.getOpenStatus(239)) {
/* 144 */       outFightObj.fillFinalPropertyMap(attrsMap);
/*     */     } else {
/* 146 */       outFightObj.fillSelfFixFightProperty(attrsMap);
/* 147 */       outFightObj.fillOtherFightProperty(exaAttrsMap);
/*     */     }
/* 149 */     for (Map.Entry<Integer, Integer> entry : pvCfg.proRateMap.entrySet()) {
/* 150 */       int key = ((Integer)entry.getKey()).intValue();
/* 151 */       if (attrsMap.containsKey(Integer.valueOf(key))) {
/* 152 */         int value = (int)(((Integer)entry.getValue()).intValue() * 1.0D / FightArgs.getInstance().defaultRate * ((Integer)attrsMap.get(Integer.valueOf(key))).intValue());
/* 153 */         attrsMap.put(Integer.valueOf(key), Integer.valueOf(value));
/*     */       }
/*     */     }
/*     */     
/* 157 */     cloneRoleFighter.init(outFightObj, rolePos, attrsMap, exaAttrsMap);
/*     */     
/*     */ 
/* 160 */     Pet pet = PetInterface.getFightPet(roleid, true);
/* 161 */     if (pet != null) {
/* 162 */       Map<Integer, Integer> petAttrsMap = new HashMap();
/* 163 */       Map<Integer, Integer> petExaAttrsMap = new HashMap();
/* 164 */       int petPos = 0 * posNumPerRow + pos;
/* 165 */       PetOutFightObj petOutFightObj = PetInterface.getPetOutFightObjById(roleid, pet.getId());
/* 166 */       if (OpenInterface.getOpenStatus(239)) {
/* 167 */         petOutFightObj.fillFinalPropertyMap(petAttrsMap);
/*     */       } else {
/* 169 */         petOutFightObj.fillSelfFixFightProperty(petAttrsMap);
/* 170 */         petOutFightObj.fillOtherFightProperty(petExaAttrsMap);
/*     */       }
/* 172 */       for (Map.Entry<Integer, Integer> entry : pvCfg.proRateMap.entrySet()) {
/* 173 */         int key = ((Integer)entry.getKey()).intValue();
/* 174 */         if (petAttrsMap.containsKey(Integer.valueOf(key))) {
/* 175 */           int value = (int)(((Integer)entry.getValue()).intValue() * 1.0D / FightArgs.getInstance().defaultRate * ((Integer)petAttrsMap.get(Integer.valueOf(key))).intValue());
/*     */           
/* 177 */           petAttrsMap.put(Integer.valueOf(key), Integer.valueOf(value));
/*     */         }
/*     */       }
/* 180 */       if (petAttrsMap.size() > 0) {
/* 181 */         CloneFighterPet fp = generateCloneFighterPet();
/* 182 */         fp.init(pet, petPos, petAttrsMap, petExaAttrsMap);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   void initClone(long roleid, int pos, PVCRobotCfg spvcRobotCfg, int level)
/*     */   {
/* 189 */     setRoleid(roleid);
/* 190 */     setCloneGroup();
/* 191 */     int posNumPerRow = FightManager.getPosNumberPerRow();
/*     */     
/* 193 */     int rolePos = 1 * posNumPerRow + pos;
/* 194 */     CloneFighterRole cloneRoleFighter = generateCloneFighterRole();
/* 195 */     RoleOutFightObj outFightObj = RoleInterface.getRoleOutFightObject(roleid);
/* 196 */     Map<Integer, Integer> attrsMap = new HashMap();
/* 197 */     Map<Integer, Integer> exaAttrsMap = new HashMap();
/*     */     
/* 199 */     Monster roleMonster = MonsterInterface.getMonster(spvcRobotCfg.roleRobotid, level);
/* 200 */     roleMonster.fillSelfFixFightProperty(attrsMap);
/* 201 */     roleMonster.fillOtherFightProperty(exaAttrsMap);
/* 202 */     cloneRoleFighter.init(outFightObj, rolePos, attrsMap, exaAttrsMap);
/*     */     
/*     */ 
/* 205 */     Pet pet = PetInterface.getFightPet(roleid, true);
/* 206 */     if (pet != null) {
/* 207 */       Map<Integer, Integer> petAttrsMap = new HashMap();
/* 208 */       Map<Integer, Integer> petExaAttrsMap = new HashMap();
/* 209 */       int petPos = 0 * posNumPerRow + pos;
/* 210 */       int petMonsterid = FightConfigManager.getInstance().getPetid(spvcRobotCfg);
/*     */       
/* 212 */       if (petMonsterid >= 0) {
/* 213 */         Monster petMonster = MonsterInterface.getMonster(petMonsterid, level);
/* 214 */         petMonster.fillSelfFixFightProperty(petAttrsMap);
/* 215 */         petMonster.fillOtherFightProperty(petExaAttrsMap);
/*     */       }
/* 217 */       if (petAttrsMap.size() > 0) {
/* 218 */         CloneFighterPet fp = generateCloneFighterPet();
/* 219 */         fp.init(pet, petPos, petAttrsMap, petExaAttrsMap);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   void initCloneFellow(Map<Integer, PartnerOutFightObj> partnerMap, SPVCCfg pvCfg, int level)
/*     */   {
/* 227 */     for (Map.Entry<Integer, PartnerOutFightObj> entry : partnerMap.entrySet()) {
/* 228 */       int pos = ((Integer)entry.getKey()).intValue();
/* 229 */       PartnerOutFightObj p = (PartnerOutFightObj)entry.getValue();
/* 230 */       Map<Integer, Integer> attrsMap = new HashMap();
/* 231 */       Map<Integer, Integer> exaAttrsMap = new HashMap();
/* 232 */       if (OpenInterface.getOpenStatus(239)) {
/* 233 */         p.fillFinalPropertyMap(attrsMap);
/*     */       } else {
/* 235 */         p.fillSelfFixFightProperty(attrsMap);
/* 236 */         p.fillOtherFightProperty(exaAttrsMap);
/*     */       }
/* 238 */       for (Map.Entry<Integer, Integer> proRateEntry : pvCfg.proRateMap.entrySet()) {
/* 239 */         int key = ((Integer)proRateEntry.getKey()).intValue();
/* 240 */         if (attrsMap.containsKey(Integer.valueOf(key))) {
/* 241 */           int value = (int)(((Integer)proRateEntry.getValue()).intValue() * 1.0D / FightArgs.getInstance().defaultRate * ((Integer)attrsMap.get(Integer.valueOf(key))).intValue());
/*     */           
/* 243 */           attrsMap.put(Integer.valueOf(key), Integer.valueOf(value));
/*     */         }
/*     */       }
/*     */       
/* 247 */       if (attrsMap.size() > 0) {
/* 248 */         CloneFighterFellow ff = generateCloneFighterFellow();
/* 249 */         ff.init(p, pos, attrsMap, exaAttrsMap);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   void initCloneFellow(Map<Integer, PartnerOutFightObj> partnerMap, PVCRobotCfg spvcRobotCfg, int level)
/*     */   {
/* 256 */     List<Integer> partnerMonsters = FightConfigManager.getInstance().getPartnerids(spvcRobotCfg);
/* 257 */     int index = 0;
/* 258 */     for (Map.Entry<Integer, PartnerOutFightObj> entry : partnerMap.entrySet()) {
/* 259 */       int pos = ((Integer)entry.getKey()).intValue();
/* 260 */       PartnerOutFightObj p = (PartnerOutFightObj)entry.getValue();
/* 261 */       Map<Integer, Integer> attrsMap = new HashMap();
/* 262 */       Map<Integer, Integer> exaAttrsMap = new HashMap();
/* 263 */       if (index < partnerMonsters.size()) {
/* 264 */         Monster monster = MonsterInterface.getMonster(((Integer)partnerMonsters.get(index++)).intValue(), level);
/* 265 */         monster.fillSelfFixFightProperty(attrsMap);
/* 266 */         monster.fillOtherFightProperty(exaAttrsMap);
/*     */       }
/* 268 */       if (attrsMap.size() > 0) {
/* 269 */         CloneFighterFellow ff = generateCloneFighterFellow();
/* 270 */         ff.init(p, pos, attrsMap, exaAttrsMap);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected FighterRole getFighterRole()
/*     */   {
/* 282 */     for (Fighter fighter : getExistedFighters()) {
/* 283 */       if ((fighter instanceof FighterRole)) {
/* 284 */         return (FighterRole)fighter;
/*     */       }
/*     */     }
/* 287 */     return null;
/*     */   }
/*     */   
/*     */   protected boolean isRoleEscape() {
/* 291 */     for (Fighter fighter : getFighters()) {
/* 292 */       if (((fighter instanceof FighterRole)) && 
/* 293 */         (fighter.isEscaped())) {
/* 294 */         return true;
/*     */       }
/*     */     }
/*     */     
/* 298 */     for (Fighter fighter : getLeaveFightFighters()) {
/* 299 */       if (((fighter instanceof FighterRole)) && 
/* 300 */         (fighter.isEscaped())) {
/* 301 */         return true;
/*     */       }
/*     */     }
/*     */     
/* 305 */     return false;
/*     */   }
/*     */   
/*     */   protected int getRoleFighterId(long roleid) {
/* 309 */     for (Fighter fighter : getFighters()) {
/* 310 */       if ((fighter instanceof FighterRole))
/* 311 */         return ((FighterRole)fighter).fighterid;
/*     */     }
/* 313 */     return -1;
/*     */   }
/*     */   
/*     */   protected void fillFightGroupBean(mzm.gsp.fight.FightGroup fightGroupBean)
/*     */   {
/* 318 */     super.fillFightGroupBean(fightGroupBean);
/* 319 */     if ((!isCloneGroup()) || (this.fightTeam.isActive)) {
/* 320 */       fightGroupBean.roleid = getRoleid();
/*     */     }
/*     */     
/* 323 */     fightGroupBean.summonpettimes = getExtra(FightGroupExtra.Summon_pet_times);
/* 324 */     fightGroupBean.summonchldtimes = getExtra(FightGroupExtra.Summon_child_times);
/* 325 */     fightGroupBean.useitemtimes = getExtra(FightGroupExtra.Use_Drag_times);
/* 326 */     for (Fighter fighter : this.xGroup.getLeavefighters()) {
/* 327 */       if (fighter.isPetType()) {
/* 328 */         fightGroupBean.fightedpets.add(Long.valueOf(fighter.getUuid()));
/* 329 */       } else if (fighter.isChildType()) {
/* 330 */         fightGroupBean.fightedchilds.add(Long.valueOf(fighter.getUuid()));
/*     */       }
/*     */     }
/* 333 */     for (Fighter fighter : getFighters()) {
/* 334 */       if (fighter.isPetType()) {
/* 335 */         fightGroupBean.fightedpets.add(Long.valueOf(fighter.getUuid()));
/* 336 */       } else if (fighter.isChildType()) {
/* 337 */         fightGroupBean.fightedchilds.add(Long.valueOf(fighter.getUuid()));
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   protected final void setAuto(boolean bAuto) {
/* 343 */     FightCache xCache = createXFightCacheIfNotExist();
/* 344 */     if (xCache.getIsauto() == bAuto) {
/* 345 */       return;
/*     */     }
/* 347 */     xCache.setIsauto(bAuto);
/* 348 */     if (bAuto) {
/* 349 */       checkAndSetAutoSkill(xCache);
/*     */     }
/*     */     
/* 352 */     FightInterface.syncAutoState(getRoleid());
/*     */   }
/*     */   
/*     */   protected final void refreshAuto() {
/* 356 */     FightCache xCache = createXFightCacheIfNotExist();
/* 357 */     checkAndSetAutoSkill(xCache);
/* 358 */     FightInterface.syncAutoState(getRoleid());
/*     */   }
/*     */   
/*     */   protected boolean isAuto() {
/* 362 */     FightCache xCache = createXFightCacheIfNotExist();
/* 363 */     return xCache.getIsauto();
/*     */   }
/*     */   
/*     */   private void checkAndSetAutoSkill(FightCache xCache) {
/* 367 */     for (Fighter fighter : getFighters()) {
/* 368 */       if ((fighter.isRole()) && ((fighter instanceof FighterRole))) {
/* 369 */         FighterRole fr = (FighterRole)fighter;
/* 370 */         if (getRoleid() == fr.getRoleid()) {
/* 371 */           int autoSKill = xCache.getRole_default_skill();
/* 372 */           if ((!fr.hasSkill(autoSKill)) || (!fr.isSkillAvailableWithFightState(autoSKill))) {
/* 373 */             xCache.setRole_default_skill(fr.getCfgDefaultSkill());
/*     */           }
/*     */         }
/*     */       }
/* 377 */       if ((fighter.isPet()) && ((fighter instanceof FighterPet))) {
/* 378 */         FighterPet fPet = (FighterPet)fighter;
/* 379 */         if (fPet.getOwnerid() == getRoleid()) {
/* 380 */           Integer autoSkillInteger = (Integer)xCache.getPet_default_skills().get(Long.valueOf(fPet.getUuid()));
/* 381 */           if ((autoSkillInteger == null) || (!fPet.hasSkill(autoSkillInteger.intValue())) || (!fPet.isSkillAvailableWithFightState(autoSkillInteger.intValue())))
/*     */           {
/* 383 */             xCache.getPet_default_skills().put(Long.valueOf(fPet.getUuid()), Integer.valueOf(fPet.getCfgDefaultSkill()));
/*     */           }
/*     */         }
/*     */       }
/*     */       
/* 388 */       if ((fighter.isChild()) && ((fighter instanceof FighterChild))) {
/* 389 */         FighterChild fighterChild = (FighterChild)fighter;
/* 390 */         if (fighterChild.getOwnerid() == getRoleid()) {
/* 391 */           Integer autoSkillInteger = (Integer)xCache.getChild_default_skills().get(Long.valueOf(fighterChild.getUuid()));
/* 392 */           if ((autoSkillInteger == null) || (!fighterChild.hasSkill(autoSkillInteger.intValue())) || (!fighterChild.isSkillAvailableWithFightState(autoSkillInteger.intValue())))
/*     */           {
/* 394 */             xCache.getChild_default_skills().put(Long.valueOf(fighterChild.getUuid()), Integer.valueOf(fighterChild.getCfgDefaultSkill()));
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   protected final FightCache createXFightCacheIfNotExist() {
/* 402 */     long roleid = getRoleid();
/* 403 */     FightCache xCache = Rolefightcache.get(Long.valueOf(roleid));
/* 404 */     if (xCache == null) {
/* 405 */       xCache = Pod.newFightCache();
/* 406 */       Rolefightcache.insert(Long.valueOf(roleid), xCache);
/*     */     }
/* 408 */     return xCache;
/*     */   }
/*     */   
/*     */   protected void excuteOpItem(Fighter fighter, OpItem opItem, ExcuteCmdResult excuteCmdResult)
/*     */   {
/* 413 */     if ((fighter.isSeal()) && 
/* 414 */       (fighter.isSealUseDrag())) {
/* 415 */       Play play = new Play();
/* 416 */       fighter.fillPlayTipResult(play, fighter.getid(), 121000019, new String[0]);
/* 417 */       excuteCmdResult.addPlay(play, true);
/* 418 */       excuteCmdResult.addPlay(play, false);
/* 419 */       if (isRecordEnable()) {
/* 420 */         excuteCmdResult.addPlay(play);
/*     */       }
/* 422 */       return;
/*     */     }
/*     */     
/* 425 */     if (fighter.isFellowType()) {
/* 426 */       return;
/*     */     }
/* 428 */     int itemCfgid = opItem.item_cfgid;
/* 429 */     BasicItem basicItem = ItemInterface.getItemByCfgId(getRoleid(), itemCfgid);
/* 430 */     if (basicItem == null) {
/* 431 */       Play play = new Play();
/* 432 */       fighter.fillPlayTipResult(play, fighter.getid(), 121000034, new String[0]);
/* 433 */       excuteCmdResult.addPlay(play, true);
/* 434 */       excuteCmdResult.addPlay(play, false);
/* 435 */       if (isRecordEnable()) {
/* 436 */         excuteCmdResult.addPlay(play);
/*     */       }
/* 438 */       return;
/*     */     }
/* 440 */     SItemCfg itemCfg = SItemCfg.get(basicItem.getCfgId());
/* 441 */     if (itemCfg == null) {
/* 442 */       Play play = new Play();
/* 443 */       fighter.fillPlayTipResult(play, fighter.getid(), 121000034, new String[0]);
/* 444 */       excuteCmdResult.addPlay(play, true);
/* 445 */       excuteCmdResult.addPlay(play, false);
/* 446 */       if (isRecordEnable()) {
/* 447 */         excuteCmdResult.addPlay(play);
/*     */       }
/* 449 */       return;
/*     */     }
/* 451 */     if (itemCfg.useLevel > fighter.getLevel())
/*     */     {
/* 453 */       GameServer.logger().error("玩家等级不足，不能使用这个药品");
/* 454 */       return;
/*     */     }
/* 456 */     if ((itemCfg.type != 5) && (itemCfg.type != 6) && (SItemTypeInFightCfg.get(itemCfg.type) == null))
/*     */     {
/* 458 */       GameServer.logger().error("使用的药品类型不是战斗内可用的,itemtype:" + itemCfg.type);
/* 459 */       return;
/*     */     }
/*     */     
/* 462 */     List<Integer> effeceGroupIds = new ArrayList();
/* 463 */     int pro = 1;
/* 464 */     int type1 = 0;
/* 465 */     int type2 = 0;
/* 466 */     int type3 = 0;
/* 467 */     int type4 = 0;
/*     */     
/* 469 */     if ((itemCfg.type == 5) || (SItemTypeInFightCfg.get(itemCfg.type) != null)) {
/* 470 */       SItemDrugInFightCfg itemDrugInFightCfg = SItemDrugInFightCfg.get(basicItem.getCfgId());
/* 471 */       if (itemDrugInFightCfg == null) {
/* 472 */         GameServer.logger().error("背包中物品对应的药品配置不存在:cfgid:" + basicItem.getCfgId());
/* 473 */         return;
/*     */       }
/* 475 */       effeceGroupIds.addAll(itemDrugInFightCfg.skillEffectGroupIds);
/* 476 */       pro = itemDrugInFightCfg.drugPro;
/* 477 */       type1 = itemDrugInFightCfg.targettype1;
/* 478 */       type2 = itemDrugInFightCfg.targettype2;
/* 479 */       type3 = itemDrugInFightCfg.targettype3;
/* 480 */       type4 = itemDrugInFightCfg.targettype4;
/* 481 */     } else if (itemCfg.type == 6) {
/* 482 */       SDrugItem drugItem = SDrugItem.get(basicItem.getCfgId());
/* 483 */       if (drugItem == null) {
/* 484 */         GameServer.logger().error("背包中物品对应的药品配置不存在:cfgid:" + basicItem.getCfgId());
/* 485 */         return;
/*     */       }
/* 487 */       effeceGroupIds.add(Integer.valueOf(drugItem.skillEffectGroupId));
/* 488 */       type1 = drugItem.targettype1;
/* 489 */       type2 = drugItem.targettype2;
/* 490 */       type3 = drugItem.targettype3;
/* 491 */       type4 = drugItem.targettype4;
/*     */     } else {
/* 493 */       GameServer.logger().error("使用的药品类型不是战斗内可用的,itemtype:" + itemCfg.type);
/* 494 */       return;
/*     */     }
/*     */     
/*     */ 
/* 498 */     int useDragTimes = getExtra(FightGroupExtra.Use_Drag_times);
/* 499 */     if (useDragTimes >= SFightConsts.getInstance().DRAG_USE_TIMES)
/*     */     {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 505 */       GameServer.logger().info("玩家使用药品次数已经达到上限了!time:" + useDragTimes);
/* 506 */       return;
/*     */     }
/*     */     
/* 509 */     Set<Fighter> targets = FightUtil.getTargets(fighter, type1, type2, type3, type4);
/* 510 */     Fighter maintaFighter = this.fightTeam.fight.getFighter(opItem.main_target);
/*     */     
/*     */ 
/* 513 */     if (!targets.contains(maintaFighter)) {
/* 514 */       Play play = new Play();
/* 515 */       fighter.fillPlayTipResult(play, fighter.getid(), 121000012, new String[0]);
/* 516 */       excuteCmdResult.addPlay(play, true);
/* 517 */       excuteCmdResult.addPlay(play, false);
/* 518 */       if (isRecordEnable()) {
/* 519 */         excuteCmdResult.addPlay(play);
/*     */       }
/* 521 */       return;
/*     */     }
/* 523 */     Skill skill = SkillInterface.getSkill(SFightConsts.getInstance().ATTACK_SKILL, pro);
/* 524 */     if (skill == null) {
/* 525 */       return;
/*     */     }
/* 527 */     List<FighterEffectGroup> fighterEffectGroups = new ArrayList();
/*     */     
/* 529 */     for (Iterator i$ = effeceGroupIds.iterator(); i$.hasNext();) { int effeceGroupId = ((Integer)i$.next()).intValue();
/* 530 */       FighterEffectGroup fighterEffectGroup = EffectInterface.getEffectGroup(effeceGroupId);
/* 531 */       if (fighterEffectGroup == null) {
/* 532 */         GameServer.logger().error("没有找到效果组的配置!effectGroupid:" + effeceGroupId);
/* 533 */         return;
/*     */       }
/*     */       
/* 536 */       fighterEffectGroups.add(fighterEffectGroup);
/*     */     }
/*     */     
/* 539 */     for (FighterEffectGroup fighterEffectGroup : fighterEffectGroups) {
/* 540 */       fighterEffectGroup.setFromDrag();
/* 541 */       fighterEffectGroup.run(skill, fighter, maintaFighter, maintaFighter.getid());
/*     */     }
/*     */     
/* 544 */     int targetid = maintaFighter.getid();
/* 545 */     ItemInterface.removeItemById(getRoleid(), itemCfgid, 1, new TLogArg(LogReason.FIGHTER_USE_DRAG_REM, getFight().getFightCfgid()));
/*     */     
/* 547 */     setExtra(FightGroupExtra.Use_Drag_times, ++useDragTimes);
/*     */     
/* 549 */     Skill.Attack attack = new Skill.Attack();
/* 550 */     attack.addNormalCount(1);
/* 551 */     List<Skill.Attack> attacks = new ArrayList();
/* 552 */     attacks.add(attack);
/* 553 */     int playTime = FightUtil.getPlayTime(fighter.getModelid(), SFightConsts.getInstance().DRAG_USE_SKILL_PLAYId, Arrays.asList(new Integer[] { Integer.valueOf(maintaFighter.getid()) }), attacks);
/*     */     
/*     */ 
/* 556 */     AttackResult taAttackResult = skill.getAttackResult(targetid);
/* 557 */     FighterStatus targetStatus = new FighterStatus();
/* 558 */     maintaFighter.fillFighterStatus(targetStatus);
/*     */     
/* 560 */     for (AttackResultBean attackResultBean : taAttackResult.attackresultbeans) {
/* 561 */       targetStatus.angerchange += attackResultBean.targetstatus.angerchange;
/* 562 */       targetStatus.hpchange += attackResultBean.targetstatus.hpchange;
/* 563 */       targetStatus.mpchange += attackResultBean.targetstatus.mpchange;
/* 564 */       targetStatus.status_set.addAll(attackResultBean.targetstatus.status_set);
/*     */     }
/* 566 */     HashMap<Integer, FighterStatus> targetstatusMap = new HashMap();
/* 567 */     targetstatusMap.put(Integer.valueOf(targetid), targetStatus);
/*     */     
/* 569 */     DrugHandle.OutputObj outputObj = fighter.handleOnAfterDrug(new DrugHandle.InputObj(fighter, maintaFighter, targetStatus.hpchange));
/*     */     
/* 571 */     FighterStatus releaserStatus = new FighterStatus();
/* 572 */     releaserStatus.triggerpassiveskills.addAll(outputObj.passiveSkills);
/* 573 */     if (outputObj.drugSelfValue > 0) {
/* 574 */       fighter.addHp(outputObj.drugSelfValue);
/* 575 */       releaserStatus.hpchange += outputObj.drugSelfValue;
/*     */     }
/* 577 */     fighter.fillFighterStatus(releaserStatus);
/*     */     
/* 579 */     PlayUseItem playUseItem = new PlayUseItem();
/* 580 */     fighter.fillPlayUseItemResult(playUseItem, fighter.getid(), releaserStatus, itemCfg.id, targetstatusMap);
/*     */     
/* 582 */     boolean recordEnable = isRecordEnable();
/* 583 */     if (this.fightTeam.fight.canSeeOppsiteHpProp()) {
/* 584 */       Play play = new Play();
/* 585 */       play.play_type = 6;
/* 586 */       play.content = playUseItem.marshal(new OctetsStream());
/* 587 */       excuteCmdResult.addPlay(play, true);
/* 588 */       excuteCmdResult.addPlay(play, false);
/* 589 */       if (recordEnable) {
/* 590 */         excuteCmdResult.addPlay(play);
/*     */       }
/*     */     } else {
/* 593 */       Play activePlay = new Play();
/* 594 */       activePlay.play_type = 6;
/* 595 */       Pair<PlayUseItem, Boolean> activePlayUseItemPair = fighter.getOppisiteUseItemResult(playUseItem, true);
/*     */       
/* 597 */       PlayUseItem activePlayUseItem = (PlayUseItem)activePlayUseItemPair.first;
/* 598 */       activePlay.content = activePlayUseItem.marshal(new OctetsStream());
/* 599 */       excuteCmdResult.addPlay(activePlay, true);
/* 600 */       if ((!((Boolean)activePlayUseItemPair.second).booleanValue()) && 
/* 601 */         (recordEnable)) {
/* 602 */         excuteCmdResult.addPlay(activePlay);
/*     */       }
/*     */       
/*     */ 
/* 606 */       Play passivePlay = new Play();
/* 607 */       passivePlay.play_type = 6;
/* 608 */       Pair<PlayUseItem, Boolean> passivePlayUseItemPair = fighter.getOppisiteUseItemResult(playUseItem, false);
/*     */       
/* 610 */       PlayUseItem passivePlayUseItem = (PlayUseItem)passivePlayUseItemPair.first;
/* 611 */       passivePlay.content = passivePlayUseItem.marshal(new OctetsStream());
/* 612 */       excuteCmdResult.addPlay(passivePlay, false);
/* 613 */       if ((!((Boolean)passivePlayUseItemPair.second).booleanValue()) && 
/* 614 */         (recordEnable)) {
/* 615 */         excuteCmdResult.addPlay(passivePlay);
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 620 */     excuteCmdResult.addPlayTime(playTime);
/*     */     
/* 622 */     fighter.addActionCount();
/*     */     
/* 624 */     fighter.addUseItemCount();
/*     */   }
/*     */   
/*     */   protected void onFightEnd()
/*     */   {
/*     */     try {
/* 630 */       super.onFightEnd();
/*     */       
/* 632 */       Set<FighterPet> fighterPets = new HashSet();
/* 633 */       FighterRole fighterRole = null;
/*     */       
/* 635 */       for (Fighter fighter : getFighters())
/*     */       {
/* 637 */         if ((fighter.isPet()) && ((fighter instanceof FighterPet))) {
/* 638 */           FighterPet fighterPet = (FighterPet)fighter;
/* 639 */           fighterPets.add(fighterPet);
/* 640 */         } else if ((fighter.isRole()) && ((fighter instanceof FighterRole))) {
/* 641 */           fighterRole = (FighterRole)fighter;
/*     */         }
/*     */       }
/*     */       
/*     */ 
/* 646 */       for (Fighter fighter : getLeaveFightFighters()) {
/* 647 */         if ((fighter.isPet()) && ((fighter instanceof FighterPet))) {
/* 648 */           FighterPet fighterPet = (FighterPet)fighter;
/* 649 */           fighterPets.add(fighterPet);
/* 650 */         } else if ((fighter.isRole()) && ((fighter instanceof FighterRole))) {
/* 651 */           fighterRole = (FighterRole)fighter;
/*     */         }
/*     */       }
/* 654 */       if (fighterRole == null) {
/* 655 */         return;
/*     */       }
/* 657 */       int cfgType = getFight().getCfgType();
/* 658 */       SFightTypeCfg fightTypeCfg = FightConfigManager.getInstance().getFightTypeCfg(cfgType);
/* 659 */       if (fightTypeCfg.synHpMpAnger) {
/* 660 */         roleid = getRoleid();
/* 661 */         boolean ret = false;
/*     */         try {
/* 663 */           ret = RoleInterface.costBaoShiDu(roleid, RoleInterface.getCoastBaoShiDu());
/*     */         } catch (Exception e) {
/* 665 */           GameServer.logger().error(String.format("[Fight]FightGroupRole.onFightEnd@cost bao shi du error|roleid=%d", new Object[] { Long.valueOf(roleid) }));
/*     */         }
/*     */         
/*     */ 
/*     */ 
/* 670 */         if ((ret) || (fighterRole.isDead()) || (fighterRole.isFakeDead()))
/*     */         {
/*     */           try {
/* 673 */             RoleInterface.setHpAndMpFull(roleid);
/*     */           } catch (Exception e) {
/* 675 */             GameServer.logger().error(String.format("[Fight]FightGroupRole.onFightEnd@set hp and mp error|roleid=%d", new Object[] { Long.valueOf(roleid) }), e);
/*     */           }
/*     */           
/*     */ 
/*     */ 
/*     */ 
/* 681 */           for (FighterPet fighterPet : fighterPets) {
/* 682 */             long petid = 0L;
/*     */             try {
/* 684 */               petid = fighterPet.getUuid();
/* 685 */               PetInterface.recoveryHPAndMP(roleid, petid);
/*     */             } catch (Exception e) {
/* 687 */               GameServer.logger().error(String.format("[Fight]FightGroupRole.onFightEnd@set pet hp and mp error|roleid=%d|petid=%d", new Object[] { Long.valueOf(roleid), Long.valueOf(petid) }), e);
/*     */             }
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*     */       long roleid;
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 700 */       GameServer.logger().error("战斗结束时设置玩家属性等发生异常", e);
/* 701 */       return;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\main\FightGroupRole.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */