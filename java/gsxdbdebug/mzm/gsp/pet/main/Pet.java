/*     */ package mzm.gsp.pet.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Random;
/*     */ import java.util.Set;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.bulletin.SBulletinInfo;
/*     */ import mzm.gsp.bulletin.main.BulletinInterface;
/*     */ import mzm.gsp.item.confbean.SItemPetChangeItemCfg;
/*     */ import mzm.gsp.map.MapModelInfo;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.pet.SPetNormalResult;
/*     */ import mzm.gsp.pet.SSyncAddSkill;
/*     */ import mzm.gsp.pet.SSyncPetExpChange;
/*     */ import mzm.gsp.pet.confbean.PetConstants;
/*     */ import mzm.gsp.pet.confbean.SPetSkillColorCfg;
/*     */ import mzm.gsp.pet.event.PetEventArg;
/*     */ import mzm.gsp.pet.event.PetSkillChange;
/*     */ import mzm.gsp.pet.event.PlayerPetLevelUp;
/*     */ import mzm.gsp.petmark.main.PetMarkInterface;
/*     */ import mzm.gsp.pubdata.ModelInfo;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.skill.main.SkillInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.Pair;
/*     */ import xbean.Item;
/*     */ import xbean.PetEquipBag;
/*     */ import xbean.PetSkill;
/*     */ import xbean.Pod;
/*     */ import xdb.Xdb;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Pet
/*     */ {
/*     */   protected final long roleId;
/*     */   protected final xbean.Pet xPet;
/*     */   
/*     */   Pet(long roleId, xbean.Pet xPet)
/*     */   {
/*  50 */     this.roleId = roleId;
/*  51 */     this.xPet = xPet;
/*     */   }
/*     */   
/*     */   public long getId() {
/*  55 */     return this.xPet.getId();
/*     */   }
/*     */   
/*     */   public int getCfgId() {
/*  59 */     return this.xPet.getTemplateid();
/*     */   }
/*     */   
/*     */   public int getMaxLevel() {
/*  63 */     return Math.min(PetManager.getInstance().getMaxLevel(), RoleInterface.getLevel(this.roleId) + PetConstants.getInstance().PET_LEVEL_MORE_THAN_OWNER_LIMIT);
/*     */   }
/*     */   
/*     */   public boolean isBianYi() {
/*  67 */     PetCfg cfg = PetManager.getInstance().getPetCfg(getCfgId());
/*  68 */     if (cfg == null) {
/*  69 */       return false;
/*     */     }
/*  71 */     return cfg.isBianYi();
/*     */   }
/*     */   
/*     */   public boolean isBaoBao() {
/*  75 */     PetCfg cfg = PetManager.getInstance().getPetCfg(getCfgId());
/*  76 */     if (cfg == null) {
/*  77 */       return false;
/*     */     }
/*  79 */     return cfg.isBaoBao();
/*     */   }
/*     */   
/*     */   public boolean isShenShou() {
/*  83 */     PetCfg cfg = PetManager.getInstance().getPetCfg(getCfgId());
/*  84 */     if (cfg == null) {
/*  85 */       return false;
/*     */     }
/*  87 */     return cfg.isShenShou();
/*     */   }
/*     */   
/*     */   public int getPetType() {
/*  91 */     PetCfg cfg = PetManager.getInstance().getPetCfg(getCfgId());
/*  92 */     if (cfg == null) {
/*  93 */       return -1;
/*     */     }
/*  95 */     return cfg.getPetType();
/*     */   }
/*     */   
/*     */   public boolean isYeSheng() {
/*  99 */     PetCfg cfg = PetManager.getInstance().getPetCfg(getCfgId());
/* 100 */     if (cfg == null) {
/* 101 */       return false;
/*     */     }
/* 103 */     return cfg.isWild();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int addExp(int exp)
/*     */   {
/* 112 */     if (exp <= 0) {
/* 113 */       return 0;
/*     */     }
/* 115 */     int curLevel = this.xPet.getLevel();
/* 116 */     int curExp = this.xPet.getExp();
/* 117 */     int newExp = exp + curExp;
/* 118 */     int tmpExp = newExp;
/* 119 */     int newLevel = curLevel;
/* 120 */     int tmpLevel = newLevel;
/* 121 */     int maxLevel = getMaxLevel();
/* 122 */     if (curLevel >= maxLevel) {
/* 123 */       SPetNormalResult normalResult = new SPetNormalResult();
/* 124 */       normalResult.result = 8;
/*     */       
/* 126 */       OnlineManager.getInstance().sendAtOnce(this.roleId, normalResult);
/* 127 */       return 0;
/*     */     }
/*     */     do {
/* 130 */       newExp = tmpExp;
/* 131 */       newLevel = tmpLevel;
/*     */       
/* 133 */       if (tmpLevel >= maxLevel) {
/* 134 */         newExp = 0;
/* 135 */         break;
/*     */       }
/* 137 */       PetCfg petCfg = PetManager.getInstance().getPetCfg(this.xPet.getTemplateid());
/* 138 */       if (petCfg == null) {
/* 139 */         return 0;
/*     */       }
/* 141 */       int needExp = petCfg.getUptoLevelNeedExp(tmpLevel + 1);
/* 142 */       tmpExp -= needExp;
/* 143 */       tmpLevel++;
/* 144 */     } while (tmpExp >= 0);
/* 145 */     SSyncPetExpChange petExpChange = new SSyncPetExpChange();
/* 146 */     petExpChange.addexp = exp;
/* 147 */     petExpChange.petid = getId();
/* 148 */     OnlineManager.getInstance().send(this.roleId, petExpChange);
/* 149 */     setLevel(newLevel, true);
/* 150 */     this.xPet.setExp(newExp);
/* 151 */     return exp;
/*     */   }
/*     */   
/*     */   public boolean setLevel(int newLevel, boolean send) {
/* 155 */     int curLevel = this.xPet.getLevel();
/* 156 */     if (newLevel <= curLevel) {
/* 157 */       return false;
/*     */     }
/* 159 */     int totalPotentialPoint = (newLevel - curLevel) * PetManager.getPortentialPointPerLevel() + this.xPet.getPotentialpoint();
/* 160 */     this.xPet.setPotentialpoint(totalPotentialPoint);
/* 161 */     this.xPet.setLevel(newLevel);
/* 162 */     autoSpecialPoint();
/* 163 */     onLevelUp(curLevel, newLevel, send);
/* 164 */     return true;
/*     */   }
/*     */   
/*     */   private void onLevelUp(int oldLevel, int newLevel, boolean send) {
/* 168 */     studySkillOnLevelUp(oldLevel, newLevel, send);
/* 169 */     PetOutFightObj outFightObj = new PetOutFightObj(this.roleId, this.xPet);
/* 170 */     setHP(outFightObj.getFinalMaxHP());
/* 171 */     setMP(outFightObj.getFinalMaxMP());
/* 172 */     if (!send) return;
/* 173 */     PetEventArg arg = new PetEventArg();
/* 174 */     arg.petId = getId();
/* 175 */     arg.roleId = this.roleId;
/* 176 */     outFightObj.updateOutFightProperty();
/* 177 */     PlayerPetLevelUp playerPetLevelUp = new PlayerPetLevelUp();
/* 178 */     TriggerEventsManger.getInstance().triggerEvent(playerPetLevelUp, arg);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   void studySkillOnLevelUp(int oldLevel, int newLevel, boolean send)
/*     */   {
/* 189 */     if (isYeSheng()) {
/* 190 */       return;
/*     */     }
/*     */     
/* 193 */     Set<Integer> skillList = new HashSet();
/* 194 */     List<PetSkill> xPetSkillList = this.xPet.getSkilllist();
/* 195 */     for (int i = oldLevel; i < newLevel; i++) {
/* 196 */       Set<Integer> removeSkillList = new HashSet();
/* 197 */       Set<Integer> levelUpSkillList = new HashSet();
/* 198 */       for (PetSkill xPetSkill : xPetSkillList) {
/* 199 */         int skillId = xPetSkill.getSkillid();
/* 200 */         if ((SkillInterface.isPassiveSkill(skillId)) && (send)) {
/* 201 */           List<Integer> highList = SkillInterface.getHigherSkillId(skillId);
/* 202 */           if (!highList.isEmpty()) {
/* 203 */             SPetSkillColorCfg sPetSkillScoreCfg = SPetSkillColorCfg.get(PetManager.getInstance().getSkillStagebySkillId(skillId).intValue());
/* 204 */             if (sPetSkillScoreCfg.skillLevelUpRate > 0) {
/* 205 */               int prop = Xdb.random().nextInt(1000000);
/* 206 */               if (sPetSkillScoreCfg.skillLevelUpRate >= prop)
/*     */               {
/* 208 */                 int newSkillId = ((Integer)highList.get(0)).intValue();
/* 209 */                 SBulletinInfo bulletinInfo = new SBulletinInfo();
/* 210 */                 bulletinInfo.bulletintype = 30;
/* 211 */                 bulletinInfo.params.put(Integer.valueOf(1), RoleInterface.getName(this.roleId));
/* 212 */                 bulletinInfo.params.put(Integer.valueOf(21), getCfgId() + "");
/* 213 */                 bulletinInfo.params.put(Integer.valueOf(25), skillId + "");
/* 214 */                 bulletinInfo.params.put(Integer.valueOf(26), newSkillId + "");
/* 215 */                 BulletinInterface.sendBulletin(bulletinInfo);
/* 216 */                 skillList.remove(Integer.valueOf(skillId));
/* 217 */                 removeSkillList.add(Integer.valueOf(skillId));
/* 218 */                 int oldSkillId = skillId;
/* 219 */                 skillId = newSkillId;
/* 220 */                 levelUpSkillList.add(Integer.valueOf(newSkillId));
/* 221 */                 PetManager.sendTitleMail(this.roleId, this.xPet.getTemplateid(), PetConstants.getInstance().PET_SKILL_LEVELUP_MAIL, new TLogArg(LogReason.PET_PASSIVE_SKILL_LEVELUP_REM), new int[] { oldSkillId, newSkillId });
/*     */                 
/* 223 */                 PetEventArg arg = new PetEventArg();
/* 224 */                 arg.roleId = this.roleId;
/* 225 */                 arg.petId = this.xPet.getId();
/* 226 */                 arg.enventType = PetSkillChangeLogEnum.AUTOLEVELUP.value;
/* 227 */                 TriggerEventsManger.getInstance().triggerEvent(new PetSkillChange(), arg);
/*     */               }
/*     */             }
/*     */           }
/*     */         }
/* 232 */         skillList.add(Integer.valueOf(skillId));
/*     */       }
/* 234 */       if (removeSkillList.size() > 0) {
/* 235 */         Iterator<PetSkill> skillIterable = xPetSkillList.iterator();
/* 236 */         while (skillIterable.hasNext()) {
/* 237 */           PetSkill xPetSkill = (PetSkill)skillIterable.next();
/* 238 */           if (removeSkillList.contains(Integer.valueOf(xPetSkill.getSkillid()))) {
/* 239 */             skillIterable.remove();
/*     */           }
/*     */         }
/*     */       }
/* 243 */       if (levelUpSkillList.size() > 0) {
/* 244 */         for (Integer skillId : levelUpSkillList) {
/* 245 */           PetSkill xPetSkill = Pod.newPetSkill();
/* 246 */           xPetSkill.setSkillid(skillId.intValue());
/* 247 */           xPetSkill.setSkillfrom(0);
/* 248 */           xPetSkillList.add(xPetSkill);
/*     */         }
/* 250 */         PetOutFightObj obj = new PetOutFightObj(this.roleId, this.xPet);
/* 251 */         obj.updatePassiveSkill();
/* 252 */         if (!send) {
/* 253 */           return;
/*     */         }
/* 255 */         obj.syncPetInfo();
/*     */         
/* 257 */         List<Integer> newSkillList = new ArrayList();
/* 258 */         for (PetSkill xPetSkill : this.xPet.getSkilllist()) {
/* 259 */           newSkillList.add(Integer.valueOf(xPetSkill.getSkillid()));
/*     */         }
/* 261 */         String hostIp = GameServerInfoManager.getHostIP();
/* 262 */         String userId = RoleInterface.getUserId(this.roleId);
/* 263 */         PetManager.addPetSkillChangeTlog(this.roleId, hostIp, userId, this.xPet.getId(), this.xPet.getTemplateid(), PetSkillChangeLogEnum.AUTOLEVELUP, newSkillList);
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 268 */     if (oldLevel >= PetConstants.getInstance().PET_STUDY_SKILL_MAX_LEVEL) {
/* 269 */       return;
/*     */     }
/*     */     
/* 272 */     int studyProp = 0;
/* 273 */     for (int i = oldLevel; i < newLevel; i++) {
/* 274 */       if (i >= PetConstants.getInstance().PET_STUDY_SKILL_MAX_LEVEL) {
/* 275 */         return;
/*     */       }
/* 277 */       if (skillList.size() >= PetConstants.getInstance().PET_STUDY_SKILL_NUM_LIMIT) {
/* 278 */         return;
/*     */       }
/* 280 */       if (skillList.size() >= PetConstants.getInstance().PET_SHELF_SKILL_NUM_LIMIT) {
/* 281 */         return;
/*     */       }
/* 283 */       switch (skillList.size())
/*     */       {
/*     */       case 0: 
/* 286 */         studyProp = PetConstants.getInstance().PET_HAVE_0_SKILL_STUDY_PROP;
/* 287 */         break;
/*     */       case 1: 
/* 289 */         studyProp = PetConstants.getInstance().PET_HAVE_1_SKILL_STUDY_PROP;
/* 290 */         break;
/*     */       case 2: 
/* 292 */         studyProp = PetConstants.getInstance().PET_HAVE_2_SKILL_STUDY_PROP;
/* 293 */         break;
/*     */       case 3: 
/* 295 */         studyProp = PetConstants.getInstance().PET_HAVE_3_SKILL_STUDY_PROP;
/*     */       }
/*     */       
/* 298 */       int prop = Xdb.random().nextInt(10000);
/* 299 */       if (studyProp > prop) {
/* 300 */         PetCfg petCfg = PetManager.getInstance().getPetCfg(this.xPet.getTemplateid());
/* 301 */         if (petCfg == null) {
/* 302 */           return;
/*     */         }
/* 304 */         Set<Integer> studySkills = SkillInterface.getMonsterRandomSkill(petCfg.getMonsterSkillId(), skillList, 1);
/* 305 */         if (studySkills.isEmpty()) {
/* 306 */           return;
/*     */         }
/* 308 */         studySkills.removeAll(skillList);
/* 309 */         if (studySkills.isEmpty()) {
/* 310 */           return;
/*     */         }
/* 312 */         int studySkill = ((Integer)studySkills.iterator().next()).intValue();
/*     */         
/* 314 */         if (!skillList.contains(Integer.valueOf(studySkill)))
/*     */         {
/*     */ 
/*     */ 
/* 318 */           List<Integer> studyhighList = SkillInterface.getHigherSkillId(studySkill);
/* 319 */           boolean hasHighSkill = false;
/* 320 */           for (Iterator i$ = studyhighList.iterator(); i$.hasNext();) { int highSkill = ((Integer)i$.next()).intValue();
/* 321 */             if (skillList.contains(Integer.valueOf(highSkill))) {
/* 322 */               hasHighSkill = true;
/*     */             }
/*     */           }
/* 325 */           if (!hasHighSkill)
/*     */           {
/*     */ 
/*     */ 
/* 329 */             if (!SkillInterface.isSameSKill(studySkill, skillList))
/*     */             {
/*     */ 
/* 332 */               skillList.add(Integer.valueOf(studySkill));
/* 333 */               PetSkill xPetSkill = Pod.newPetSkill();
/* 334 */               xPetSkill.setSkillid(studySkill);
/* 335 */               xPetSkill.setSkillfrom(0);
/* 336 */               xPetSkillList.add(xPetSkill);
/* 337 */               if (send) {
/* 338 */                 SSyncAddSkill sSyncAddSkill = new SSyncAddSkill();
/* 339 */                 sSyncAddSkill.skillid = studySkill;
/* 340 */                 sSyncAddSkill.petid = getId();
/* 341 */                 sSyncAddSkill.reason = 1;
/* 342 */                 OnlineManager.getInstance().sendAtOnce(this.roleId, sSyncAddSkill);
/*     */                 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 350 */                 PetManager.sendTitleMail(this.roleId, this.xPet.getTemplateid(), PetConstants.getInstance().PET_NEW_SKILL_MAIL, new TLogArg(LogReason.PET_LEARN_NEW_SKILL_REM), new int[] { studySkill });
/*     */                 
/* 352 */                 List<Integer> newSkillList = new ArrayList();
/* 353 */                 for (PetSkill xpetSkill : this.xPet.getSkilllist()) {
/* 354 */                   newSkillList.add(Integer.valueOf(xpetSkill.getSkillid()));
/*     */                 }
/* 356 */                 String hostIp = GameServerInfoManager.getHostIP();
/* 357 */                 String userId = RoleInterface.getUserId(this.roleId);
/* 358 */                 PetManager.addPetSkillChangeTlog(this.roleId, hostIp, userId, this.xPet.getId(), this.xPet.getTemplateid(), PetSkillChangeLogEnum.AUTOLEARN, newSkillList);
/*     */                 
/* 360 */                 PetEventArg arg = new PetEventArg();
/* 361 */                 arg.roleId = this.roleId;
/* 362 */                 arg.petId = this.xPet.getId();
/* 363 */                 arg.enventType = PetSkillChangeLogEnum.AUTOLEARN.value;
/* 364 */                 TriggerEventsManger.getInstance().triggerEvent(new PetSkillChange(), arg);
/*     */               }
/*     */             } }
/*     */         } } }
/* 368 */     PetOutFightObj obj = new PetOutFightObj(this.roleId, this.xPet);
/* 369 */     obj.updatePassiveSkill();
/* 370 */     if (!send) {
/* 371 */       return;
/*     */     }
/* 373 */     obj.syncPetInfo();
/*     */   }
/*     */   
/*     */   void autoSpecialPoint() {
/* 377 */     if (this.xPet.getIsautospecialpoint()) {
/* 378 */       int totalPotentialPoint = this.xPet.getPotentialpoint();
/* 379 */       Map<Integer, Integer> autoSpecialMap = this.xPet.getAutospecialpointcase();
/* 380 */       Map<Integer, Integer> propMap = this.xPet.getBasicproperty();
/* 381 */       int totalPref = 0;
/* 382 */       boolean isDevideBy2 = true;
/* 383 */       Map<Integer, Integer> specialPrefMap = autoSpecialMap;
/* 384 */       for (Map.Entry<Integer, Integer> autoEntry : autoSpecialMap.entrySet()) {
/* 385 */         int propType = ((Integer)autoEntry.getKey()).intValue();
/* 386 */         int propPref = ((Integer)autoEntry.getValue()).intValue();
/* 387 */         if (!PetManager.addPointTypeCheck(propType)) {
/* 388 */           return;
/*     */         }
/* 390 */         if ((propPref < 0) || (propPref > PetManager.autoAssignPointLimit)) {
/* 391 */           return;
/*     */         }
/* 393 */         totalPref += propPref;
/* 394 */         if (propPref % 2 != 0) {
/* 395 */           isDevideBy2 = false;
/*     */         }
/*     */       }
/*     */       
/* 399 */       if ((totalPref <= 0) || (totalPref > PetManager.autoAssignPointLimit)) {
/* 400 */         return;
/*     */       }
/*     */       
/* 403 */       if (isDevideBy2) {
/* 404 */         totalPref /= 2;
/* 405 */         specialPrefMap = new HashMap();
/* 406 */         Iterator<Integer> typeIt = autoSpecialMap.keySet().iterator();
/* 407 */         while (typeIt.hasNext()) {
/* 408 */           int propType = ((Integer)typeIt.next()).intValue();
/* 409 */           int propValue = ((Integer)autoSpecialMap.get(Integer.valueOf(propType))).intValue();
/* 410 */           specialPrefMap.put(Integer.valueOf(propType), Integer.valueOf(propValue / 2));
/*     */         }
/*     */       }
/*     */       
/* 414 */       while (totalPotentialPoint >= totalPref) {
/* 415 */         for (Iterator i$ = specialPrefMap.keySet().iterator(); i$.hasNext();) { int propType = ((Integer)i$.next()).intValue();
/* 416 */           Integer oldValue = (Integer)propMap.get(Integer.valueOf(propType));
/* 417 */           if (oldValue == null) {
/* 418 */             oldValue = Integer.valueOf(0);
/*     */           }
/* 420 */           propMap.put(Integer.valueOf(propType), Integer.valueOf(oldValue.intValue() + ((Integer)specialPrefMap.get(Integer.valueOf(propType))).intValue()));
/*     */         }
/* 422 */         totalPotentialPoint -= totalPref;
/*     */       }
/* 424 */       this.xPet.setPotentialpoint(totalPotentialPoint);
/*     */       
/*     */ 
/* 427 */       String hostIp = GameServerInfoManager.getHostIP();
/* 428 */       String userId = RoleInterface.getUserId(this.roleId);
/* 429 */       PetManager.addPetPointChangeTlog(this.roleId, hostIp, userId, this.xPet.getId(), this.xPet.getLevel(), PetPointChangeLogEnum.AUTOADD_TYPE, this.xPet.getBasicproperty(), this.xPet.getPotentialpoint());
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getName()
/*     */   {
/* 438 */     return this.xPet.getPetname();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void getModel(ModelInfo modelInfo)
/*     */   {
/* 445 */     PetCfg petCfg = PetManager.getInstance().getPetCfg(this.xPet.getTemplateid());
/* 446 */     if (petCfg == null) {
/* 447 */       return;
/*     */     }
/* 449 */     modelInfo.modelid = petCfg.getModelId();
/* 450 */     if (petCfg.getColorId() > 0) {
/* 451 */       modelInfo.extramap.put(Integer.valueOf(12), Integer.valueOf(petCfg.getColorId()));
/*     */     }
/*     */     
/* 454 */     Item xItem = (Item)this.xPet.getEquipbag().getEquip2item().get(Integer.valueOf(3));
/* 455 */     if (xItem != null) {
/* 456 */       modelInfo.extramap.put(Integer.valueOf(9), Integer.valueOf(1));
/*     */     }
/*     */     
/*     */ 
/* 460 */     modelInfo.extramap.put(Integer.valueOf(17), Integer.valueOf(this.xPet.getStagelevel()));
/*     */     
/* 462 */     if (this.xPet.getExtramodelcfgid() > 0) {
/* 463 */       SItemPetChangeItemCfg sItemPetChangeItemCfg = SItemPetChangeItemCfg.get(this.xPet.getExtramodelcfgid());
/* 464 */       if (sItemPetChangeItemCfg != null) {
/* 465 */         modelInfo.extramap.put(Integer.valueOf(22), Integer.valueOf(sItemPetChangeItemCfg.modelId));
/* 466 */         modelInfo.extramap.put(Integer.valueOf(23), Integer.valueOf(sItemPetChangeItemCfg.colorId));
/* 467 */         modelInfo.extramap.put(Integer.valueOf(11), Integer.valueOf(sItemPetChangeItemCfg.modelFigureCfgId));
/*     */       }
/*     */     }
/*     */     
/* 471 */     Pair<Integer, Integer> petMarkInfo = PetMarkInterface.getPetMarkCfgIdAndLevel(this.roleId, getId(), false);
/* 472 */     if (((Integer)petMarkInfo.first).intValue() > 0) {
/* 473 */       modelInfo.extramap.put(Integer.valueOf(39), petMarkInfo.first);
/*     */     }
/*     */   }
/*     */   
/*     */   public void getMapModel(MapModelInfo info) {
/* 478 */     getModel(info.model);
/* 479 */     info.id = getId();
/* 480 */     info.string_props.put(Integer.valueOf(0), getName());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getLevel()
/*     */   {
/* 491 */     return this.xPet.getLevel();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getHP()
/*     */   {
/* 499 */     return this.xPet.getHp();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getMP()
/*     */   {
/* 507 */     return this.xPet.getMp();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setHP(int hp)
/*     */   {
/* 515 */     this.xPet.setHp(hp);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setMP(int mp)
/*     */   {
/* 523 */     this.xPet.setMp(mp);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getModelId()
/*     */   {
/* 531 */     PetCfg petCfg = PetManager.getInstance().getPetCfg(this.xPet.getTemplateid());
/* 532 */     if (petCfg == null) {
/* 533 */       return 0;
/*     */     }
/* 535 */     return petCfg.getModelId();
/*     */   }
/*     */   
/*     */   public int getColorId() {
/* 539 */     PetCfg petCfg = PetManager.getInstance().getPetCfg(this.xPet.getTemplateid());
/* 540 */     if (petCfg == null) {
/* 541 */       return 0;
/*     */     }
/* 543 */     return petCfg.getColorId();
/*     */   }
/*     */   
/*     */   public void setName(String name) {
/* 547 */     this.xPet.setPetname(name);
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
/*     */   public boolean addLife(int life)
/*     */   {
/* 560 */     int oldLife = this.xPet.getLife();
/*     */     
/* 562 */     if (oldLife == -1) {
/* 563 */       return false;
/*     */     }
/* 565 */     if (oldLife >= PetConstants.getInstance().PET_MAX_LIFE) {
/* 566 */       return false;
/*     */     }
/* 568 */     int newLife = oldLife + life;
/* 569 */     if (newLife > PetConstants.getInstance().PET_MAX_LIFE) {
/* 570 */       newLife = PetConstants.getInstance().PET_MAX_LIFE;
/*     */     } else {
/* 572 */       newLife = Math.max(1, newLife);
/*     */     }
/* 574 */     this.xPet.setLife(newLife);
/* 575 */     return true;
/*     */   }
/*     */   
/* 578 */   public xbean.Pet getXPet() { return this.xPet; }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean getXPetIsBinded()
/*     */   {
/* 586 */     if (this.xPet.getIsbinded() == 1) {
/* 587 */       return true;
/*     */     }
/* 589 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getMarketBuytime()
/*     */   {
/* 596 */     return this.xPet.getMarketbuytime();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getPetYaoli()
/*     */   {
/* 604 */     PetOutFightObj outFightObj = new PetOutFightObj(this.roleId, this.xPet);
/* 605 */     return outFightObj.getYaoLi();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getCarrayLevel()
/*     */   {
/* 613 */     PetCfg cfg = PetManager.getInstance().getPetCfg(getCfgId());
/* 614 */     if (cfg == null) {
/* 615 */       return 0;
/*     */     }
/* 617 */     return cfg.getCarrayLevel();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pet\main\Pet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */