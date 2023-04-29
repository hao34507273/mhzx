/*     */ package mzm.gsp.pet.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.LinkedList;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Random;
/*     */ import java.util.Set;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.bulletin.SBulletinInfo;
/*     */ import mzm.gsp.bulletin.main.BulletinInterface;
/*     */ import mzm.gsp.fight.main.FightInterface;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.item.main.ItemOperateResult;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.pet.SPetNormalResult;
/*     */ import mzm.gsp.pet.SSyncPetStateChange;
/*     */ import mzm.gsp.pet.STriggerMinimumGuarantee;
/*     */ import mzm.gsp.pet.confbean.MinmumGuaranteeBean;
/*     */ import mzm.gsp.pet.confbean.PetConstants;
/*     */ import mzm.gsp.pet.confbean.SPetHuaShengCostConf;
/*     */ import mzm.gsp.pet.confbean.SPetHuaShengSkillConf;
/*     */ import mzm.gsp.pet.event.PetEventArg;
/*     */ import mzm.gsp.pet.event.PetHuaSheng;
/*     */ import mzm.gsp.pet.event.PetSkillChange;
/*     */ import mzm.gsp.pet.event.PlayerDeletePet;
/*     */ import mzm.gsp.pet.event.PlayerShowPetChange;
/*     */ import mzm.gsp.qingfu.main.CostResult;
/*     */ import mzm.gsp.qingfu.main.CostType;
/*     */ import mzm.gsp.qingfu.main.QingfuInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.Pet;
/*     */ import xbean.PetBag;
/*     */ import xbean.PetSkill;
/*     */ import xdb.Xdb;
/*     */ import xtable.Role2petbag;
/*     */ 
/*     */ public class PHuaShengReq extends LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final long mainPetId;
/*     */   private final long fuPetId;
/*     */   private final long clientYuanBao;
/*     */   private final int costType;
/*     */   private final int minimumGuaranteeType;
/*     */   private final int needYuanBao;
/*     */   
/*     */   public PHuaShengReq(long roleId, long mainPetId, long fuPetId, long yuanbaonum, int costType, int minimumGuaranteeType, int needYuanBao)
/*     */   {
/*  64 */     this.roleId = roleId;
/*  65 */     this.mainPetId = mainPetId;
/*  66 */     this.fuPetId = fuPetId;
/*  67 */     this.clientYuanBao = yuanbaonum;
/*  68 */     this.costType = costType;
/*  69 */     this.minimumGuaranteeType = minimumGuaranteeType;
/*  70 */     this.needYuanBao = needYuanBao;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  78 */     if ((this.minimumGuaranteeType != 0) && (this.minimumGuaranteeType != 2) && (this.minimumGuaranteeType != 1)) {
/*  79 */       return false;
/*     */     }
/*  81 */     if (((this.costType != 0) && (this.costType != 1)) || (!PetManager.isPetSwitchOpenForRole(this.roleId))) {
/*  82 */       return false;
/*     */     }
/*  84 */     if (RoleInterface.getLevel(this.roleId) < PetConstants.getInstance().PET_HUASHENG_OPEN_LEVEL) {
/*  85 */       onHuaShengReqFail(100);
/*  86 */       return false; }
/*  87 */     if ((this.fuPetId == -1L) && (!OpenInterface.getOpenStatus(498))) {
/*  88 */       return false;
/*     */     }
/*  90 */     if (PetFightInterface.isPetInDefenseTeam(this.roleId, this.fuPetId, false)) {
/*  91 */       SPetNormalResult sPetNormalResult = new SPetNormalResult();
/*  92 */       sPetNormalResult.result = 300;
/*  93 */       OnlineManager.getInstance().sendAtOnce(this.roleId, sPetNormalResult);
/*  94 */       PetManager.logDebug("PHuaShengReq.processImp()@last pet in defense team|roleid=%d|petid=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.fuPetId) });
/*  95 */       return false;
/*     */     }
/*  97 */     String userId = RoleInterface.getUserId(this.roleId);
/*  98 */     long currentYuanBao = QingfuInterface.getBalance(userId, true);
/*  99 */     if (this.clientYuanBao != currentYuanBao) {
/* 100 */       Map<String, Object> extraMap = new HashMap();
/* 101 */       extraMap.put("server_yuan_bao", Long.valueOf(currentYuanBao));
/* 102 */       onHuaShengReqFail(202, extraMap);
/* 103 */       return false; }
/* 104 */     if (!RoleStatusInterface.checkCanSetStatus(this.roleId, 196, true, true))
/* 105 */       return false;
/*     */     PetBag xPetBag;
/* 107 */     if (((this.fuPetId == -1L) && (!RoleStatusInterface.checkCanSetStatus(this.roleId, 1801, true))) || ((xPetBag = Role2petbag.get(Long.valueOf(this.roleId))) == null))
/* 108 */       return false;
/*     */     PetBag xPetBag;
/* 110 */     if ((xPetBag.getFightpet() == this.mainPetId) && (FightInterface.getFightIdByRoleid(this.roleId, true) != null)) {
/* 111 */       onHuaShengReqFail(200);
/* 112 */       return false; }
/* 113 */     if ((this.fuPetId != -1L) && (xPetBag.getFightpet() == this.fuPetId)) {
/* 114 */       return false;
/*     */     }
/* 116 */     Pet xMainPet = (Pet)xPetBag.getPetmap().get(Long.valueOf(this.mainPetId));
/* 117 */     Pet xFuPet = (Pet)xPetBag.getPetmap().get(Long.valueOf(this.fuPetId));
/* 118 */     if (xMainPet == null) {
/* 119 */       return false;
/*     */     }
/* 121 */     if ((this.fuPetId != -1L) && (xFuPet == null)) {
/* 122 */       return false;
/*     */     }
/* 124 */     int xFuPetTemplateId = -1;
/* 125 */     int xFuPetLevel = xMainPet.getLevel();
/* 126 */     if (xFuPet != null) {
/* 127 */       xFuPetTemplateId = xFuPet.getTemplateid();
/* 128 */       xFuPetLevel = xFuPet.getLevel();
/*     */     }
/* 130 */     VicePetMakeUpPriceInfo vicePetMakeUpPriceInfo = null;
/* 131 */     List<Integer> fuPetSkillCfgIdList; if (xFuPet == null) {
/* 132 */       VicePetMakeUpInfo vicePetMakeUpInfo = PetHuaShengYuanBaoMakeUpViceManager.getVicePetMakeUpInfo(xMainPet);
/* 133 */       List<Integer> fuPetSkillCfgIdList = vicePetMakeUpInfo.vicePetSkillList;
/* 134 */       vicePetMakeUpPriceInfo = vicePetMakeUpInfo.vicePetMakeUpPriceInfo;
/* 135 */       if (vicePetMakeUpPriceInfo == null) {
/* 136 */         return false;
/*     */       }
/*     */     } else {
/* 139 */       fuPetSkillCfgIdList = new ArrayList();
/* 140 */       for (PetSkill petSkill : xFuPet.getSkilllist()) {
/* 141 */         fuPetSkillCfgIdList.add(Integer.valueOf(petSkill.getSkillid()));
/*     */       }
/*     */     }
/* 144 */     if ((fuPetSkillCfgIdList == null) || (fuPetSkillCfgIdList.size() <= 0)) {
/* 145 */       return false;
/*     */     }
/* 147 */     int fuPetSKillNum = fuPetSkillCfgIdList.size();
/* 148 */     int mainPetSkillNum = xMainPet.getSkilllist().size();
/* 149 */     int totalSkillNum = mainPetSkillNum + fuPetSKillNum;
/* 150 */     if ((totalSkillNum < PetConstants.getInstance().PET_SHELF_SKILL_NUM_LIMIT * 2) || (this.minimumGuaranteeType != 2)) {
/* 151 */       int mainPetFightFlag = PetManager.getPetFightFlag(this.roleId, this.mainPetId);
/* 152 */       int fuPetFightFlag = PetManager.getPetFightFlag(this.roleId, this.fuPetId);
/* 153 */       if ((mainPetFightFlag == 1) || (fuPetFightFlag == 1)) {
/* 154 */         Map<String, Object> extraMap2 = new HashMap();
/* 155 */         extraMap2.put("main_pet_fight_flag", Integer.valueOf(mainPetFightFlag));
/* 156 */         extraMap2.put("fu_fight_pet_flag", Integer.valueOf(fuPetFightFlag));
/* 157 */         onHuaShengReqFail(200, extraMap2);
/* 158 */         return false; }
/* 159 */       if ((xFuPet == null) || (xFuPet.getRememberskillid() <= 0)) {
/* 160 */         if ((this.fuPetId != -1L) && (this.fuPetId == xPetBag.getShowpet())) {
/* 161 */           PetEventArg arg = new PetEventArg();
/* 162 */           arg.petId = this.fuPetId;
/* 163 */           arg.roleId = this.roleId;
/* 164 */           TriggerEventsManger.getInstance().triggerEvent(new PlayerShowPetChange(), arg);
/*     */         }
/* 166 */         PetCfg mainPetCfg = PetManager.getInstance().getPetCfg(xMainPet.getTemplateid());
/* 167 */         if (mainPetCfg == null) {
/* 168 */           new HashMap().put("main_pet_cfg_id", Integer.valueOf(xMainPet.getTemplateid()));
/* 169 */           onHuaShengReqFail(204);
/* 170 */           return false;
/*     */         }
/* 172 */         int fuPetCarrayLevel = mainPetCfg.getCarrayLevel();
/* 173 */         boolean fuPetIsCanBeFuPet = true;
/* 174 */         if (xFuPet != null) {
/* 175 */           PetCfg fuPetCfg = PetManager.getInstance().getPetCfg(xFuPetTemplateId);
/* 176 */           if (fuPetCfg == null) {
/* 177 */             new HashMap().put("fu_pet_cfg_id", Integer.valueOf(xFuPetTemplateId));
/* 178 */             onHuaShengReqFail(205);
/* 179 */             return false;
/*     */           }
/* 181 */           fuPetCarrayLevel = fuPetCfg.getCarrayLevel();
/* 182 */           fuPetIsCanBeFuPet = fuPetCfg.isCanBeFuPet();
/*     */         }
/* 184 */         if ((this.minimumGuaranteeType != 0) && (mainPetCfg.getCarrayLevel() > fuPetCarrayLevel)) {
/* 185 */           Map<String, Object> extraMap3 = new HashMap();
/* 186 */           extraMap3.put("fu_pet_carry_level", Integer.valueOf(fuPetCarrayLevel));
/* 187 */           extraMap3.put("main_pet_carry_level", Integer.valueOf(mainPetCfg.getCarrayLevel()));
/* 188 */           extraMap3.put("main_pet_cfg_id", Integer.valueOf(xMainPet.getTemplateid()));
/* 189 */           extraMap3.put("fu_pet_cfg_id", Integer.valueOf(xFuPetTemplateId));
/* 190 */           onHuaShengReqFail(201);
/* 191 */           return false; }
/* 192 */         if ((!mainPetCfg.isCanBeMainPet()) || (!fuPetIsCanBeFuPet)) {
/* 193 */           Map<String, Object> extraMap4 = new HashMap();
/* 194 */           extraMap4.put("fu_pet_can_be_fu_pet", Boolean.valueOf(fuPetIsCanBeFuPet));
/* 195 */           extraMap4.put("main_pet_can_be_main_pet", Boolean.valueOf(mainPetCfg.isCanBeMainPet()));
/* 196 */           extraMap4.put("main_pet_cfg_id", Integer.valueOf(xMainPet.getTemplateid()));
/* 197 */           extraMap4.put("fu_pet_cfg_id", Integer.valueOf(xFuPetTemplateId));
/* 198 */           onHuaShengReqFail(206);
/* 199 */           return false;
/*     */         }
/* 201 */         SPetHuaShengCostConf huaShengCostConf = null;
/* 202 */         Iterator<SPetHuaShengCostConf> i$ = SPetHuaShengCostConf.getAll().values().iterator();
/*     */         
/* 204 */         while (i$.hasNext())
/*     */         {
/*     */ 
/* 207 */           SPetHuaShengCostConf sPetHuaShengCostConf = (SPetHuaShengCostConf)i$.next();
/* 208 */           if ((sPetHuaShengCostConf.catchLevel == mainPetCfg.getCarrayLevel()) && (sPetHuaShengCostConf.mainPetType == mainPetCfg.getPetType())) {
/* 209 */             huaShengCostConf = sPetHuaShengCostConf;
/* 210 */             break;
/*     */           }
/*     */         }
/* 213 */         if (huaShengCostConf == null) {
/* 214 */           Map<String, Object> extraMap5 = new HashMap();
/* 215 */           extraMap5.put("fu_pet_carry_level", Integer.valueOf(fuPetCarrayLevel));
/* 216 */           extraMap5.put("main_pet_carry_level", Integer.valueOf(mainPetCfg.getCarrayLevel()));
/* 217 */           extraMap5.put("main_pet_cfg_id", Integer.valueOf(xMainPet.getTemplateid()));
/* 218 */           extraMap5.put("fu_pet_cfg_id", Integer.valueOf(xFuPetTemplateId));
/* 219 */           extraMap5.put("main_pet_type", Integer.valueOf(mainPetCfg.getPetType()));
/* 220 */           onHuaShengReqFail(207);
/* 221 */           return false;
/*     */         }
/* 223 */         int itemNum = huaShengCostConf.needItemNum;
/* 224 */         int itemId = PetConstants.getInstance().PET_HUASHENG_ITEM_ID;
/* 225 */         SPetHuaShengSkillConf skillConf = null;
/* 226 */         int levelDisparity = mainPetCfg.getCarrayLevel() - fuPetCarrayLevel;
/* 227 */         Iterator<SPetHuaShengSkillConf> i$2 = SPetHuaShengSkillConf.getAll().values().iterator();
/*     */         
/* 229 */         while (i$2.hasNext())
/*     */         {
/*     */ 
/* 232 */           SPetHuaShengSkillConf sPetHuaShengSkillConf = (SPetHuaShengSkillConf)i$2.next();
/* 233 */           if ((mainPetCfg.getPetType() == sPetHuaShengSkillConf.mainPetType) && (levelDisparity >= sPetHuaShengSkillConf.catchLevelLowerLimit) && (levelDisparity <= sPetHuaShengSkillConf.catchLevelUpLimit) && (sPetHuaShengSkillConf.mainAddSecondPetSkillNum == totalSkillNum)) {
/* 234 */             skillConf = sPetHuaShengSkillConf;
/* 235 */             break;
/*     */           }
/*     */         }
/* 238 */         if (skillConf == null) {
/* 239 */           return false;
/*     */         }
/* 241 */         int prop = Xdb.random().nextInt(10000);
/* 242 */         int addProp = mzm.gsp.skill.main.SkillInterface.getHuaShengAddRateWithSkills(mzm.gsp.fashiondress.main.FashionDressInterface.getFashionDressPassiveSkillMap(this.roleId, false));
/* 243 */         int prop2 = prop + addProp;
/* 244 */         if (prop2 > 10000) {
/* 245 */           prop2 = 10000;
/*     */         }
/* 247 */         int finalGenSkillNum = 0;
/* 248 */         int totalProp = 0;
/* 249 */         int genSkillNum = 0;
/*     */         
/* 251 */         while (genSkillNum < skillConf.genSkillNPropList.size())
/*     */         {
/*     */ 
/* 254 */           totalProp += ((Integer)skillConf.genSkillNPropList.get(genSkillNum)).intValue();
/* 255 */           if (totalProp >= prop2) {
/* 256 */             finalGenSkillNum = genSkillNum;
/* 257 */             break;
/*     */           }
/* 259 */           genSkillNum++;
/*     */         }
/* 261 */         Set<Integer> skillSet = new HashSet();
/* 262 */         for (PetSkill xPetSkill : xMainPet.getSkilllist()) {
/* 263 */           skillSet.add(Integer.valueOf(xPetSkill.getSkillid()));
/*     */         }
/* 265 */         for (Integer num : fuPetSkillCfgIdList) {
/* 266 */           int fuPetSkillId = num.intValue();
/* 267 */           if (PetManager.getInstance().isSkillCanHuaSheng(fuPetSkillId)) {
/* 268 */             skillSet.add(Integer.valueOf(fuPetSkillId));
/*     */           }
/*     */         }
/* 271 */         int guaranteeCalculateSkillSumNum = skillSet.size();
/* 272 */         int needGeneratorSkillNum = Math.min(finalGenSkillNum, skillSet.size());
/* 273 */         if (isHuaShengMinimumGuaranteeSwitchOpen(this.roleId)) {
/* 274 */           boolean result = handleHuaShengMinimumGuarantee(userId, huaShengCostConf, guaranteeCalculateSkillSumNum, vicePetMakeUpPriceInfo);
/* 275 */           if (!result) {
/* 276 */             return false;
/*     */           }
/* 278 */         } else if (this.costType == 1) {
/* 279 */           if (!PetManager.getInstance().removeItemAndYuanBao(userId, this.roleId, itemId, itemNum, CostType.COST_BIND_FIRST_PET_HUASHENG, new TLogArg(LogReason.PET_HUASHENG_REM))) {
/* 280 */             onHuaShengReqFail(214);
/* 281 */             return false; }
/* 282 */           CostResult costResult; if ((vicePetMakeUpPriceInfo != null) && ((costResult = QingfuInterface.costYuanbao(userId, this.roleId, vicePetMakeUpPriceInfo.vicePetMakeUpPrice, CostType.COST_BIND_FIRST_PET_HUASHENG, new TLogArg(LogReason.PET_HUASHENG_REM))) != CostResult.Success)) {
/* 283 */             Map<String, Object> extraMap6 = new HashMap();
/* 284 */             extraMap6.put("ret", Integer.valueOf(costResult.code));
/* 285 */             extraMap6.put("des", costResult.desc);
/* 286 */             onHuaShengReqFail(214, extraMap6);
/* 287 */             return false;
/*     */           }
/* 289 */         } else if (!ItemInterface.removeItemsByTypeId(this.roleId, PetConstants.getInstance().HUASHENG_ITEM_TYPE, huaShengCostConf.needItemNum, new TLogArg(LogReason.PET_HUASHENG_REM))) {
/* 290 */           onHuaShengReqFail(208);
/* 291 */           return false;
/*     */         }
/* 293 */         int leftGeneratorSkillNum = needGeneratorSkillNum;
/* 294 */         HashSet<Integer> hashSet = new HashSet();
/* 295 */         if (xMainPet.getRememberskillid() > 0) {
/* 296 */           leftGeneratorSkillNum--;
/* 297 */           hashSet.add(Integer.valueOf(xMainPet.getRememberskillid()));
/* 298 */           skillSet.remove(Integer.valueOf(xMainPet.getRememberskillid()));
/*     */         }
/* 300 */         int skremcount = RememberSkillManager.getRememberSkillCount(this.mainPetId);
/* 301 */         if (skremcount > 0) {
/* 302 */           leftGeneratorSkillNum -= skremcount;
/* 303 */           List<Integer> ids = RememberSkillManager.getRemberSkillIds(this.mainPetId);
/* 304 */           hashSet.addAll(ids);
/* 305 */           skillSet.removeAll(ids);
/*     */         }
/* 307 */         ArrayList<Integer> arrayList = new ArrayList(skillSet);
/* 308 */         int optionSkillListSize = arrayList.size();
/*     */         
/* 310 */         while (leftGeneratorSkillNum > 0)
/*     */         {
/* 312 */           if (leftGeneratorSkillNum == skillSet.size()) {
/* 313 */             hashSet.addAll(arrayList);
/* 314 */             arrayList.clear();
/* 315 */             break;
/*     */           }
/* 317 */           optionSkillListSize--;
/* 318 */           int idx = Xdb.random().nextInt(optionSkillListSize);
/* 319 */           hashSet.add(arrayList.get(idx));
/* 320 */           arrayList.remove(idx);
/* 321 */           leftGeneratorSkillNum--;
/*     */         }
/*     */         
/* 324 */         if ((isHuaShengMinimumGuaranteeSwitchOpen(this.roleId)) && (this.minimumGuaranteeType != 0)) {
/* 325 */           int guaranteeSkillNum = this.minimumGuaranteeType == 1 ? guaranteeCalculateSkillSumNum / 2 : guaranteeCalculateSkillSumNum / 2 + 1;
/* 326 */           int needGuaranteeAddSkillNum = guaranteeSkillNum - needGeneratorSkillNum;
/* 327 */           if (needGuaranteeAddSkillNum >= 0) {
/* 328 */             for (int index = needGuaranteeAddSkillNum; index > 0; index--) {
/* 329 */               int randomId = Xdb.random().nextInt(index);
/* 330 */               hashSet.add(arrayList.get(randomId));
/* 331 */               arrayList.remove(randomId);
/*     */             }
/* 333 */             STriggerMinimumGuarantee sTriggerMinimumGuarantee = new STriggerMinimumGuarantee();
/* 334 */             sTriggerMinimumGuarantee.guarantee_skill_num = guaranteeSkillNum;
/* 335 */             OnlineManager.getInstance().send(this.roleId, sTriggerMinimumGuarantee);
/*     */           }
/*     */         }
/* 338 */         xMainPet.getSkilllist().clear();
/* 339 */         for (Integer num2 : hashSet) {
/* 340 */           int skillId = num2.intValue();
/* 341 */           PetSkill xPetSkill2 = xbean.Pod.newPetSkill();
/* 342 */           xPetSkill2.setSkillid(skillId);
/* 343 */           xPetSkill2.setSkillfrom(0);
/* 344 */           xMainPet.getSkilllist().add(xPetSkill2);
/*     */         }
/* 346 */         if (this.fuPetId != -1L) {
/* 347 */           xPetBag.getPetmap().remove(Long.valueOf(this.fuPetId));
/* 348 */           SSyncPetStateChange sSyncPetStateChange = new SSyncPetStateChange();
/* 349 */           sSyncPetStateChange.petid = this.fuPetId;
/* 350 */           sSyncPetStateChange.state = 2;
/* 351 */           OnlineManager.getInstance().send(this.roleId, sSyncPetStateChange);
/* 352 */           PlayerDeletePet playerDeletePet = new PlayerDeletePet();
/* 353 */           PetEventArg deletePetArg = new PetEventArg();
/* 354 */           deletePetArg.roleId = this.roleId;
/* 355 */           deletePetArg.petId = this.fuPetId;
/* 356 */           deletePetArg.enventType = PetDeleteTLogEnum.HUASHENG.value;
/* 357 */           TriggerEventsManger.getInstance().triggerEvent(playerDeletePet, deletePetArg);
/*     */         }
/* 359 */         PetOutFightObj obj = new PetOutFightObj(this.roleId, xMainPet);
/* 360 */         obj.updatePassiveSkill();
/* 361 */         obj.syncPetInfo();
/* 362 */         PetSkillChange petSkillChange = new PetSkillChange();
/* 363 */         PetEventArg skillChangeArg = new PetEventArg();
/* 364 */         skillChangeArg.roleId = this.roleId;
/* 365 */         skillChangeArg.petId = this.mainPetId;
/* 366 */         skillChangeArg.enventType = PetSkillChangeLogEnum.HUASHENG.value;
/* 367 */         TriggerEventsManger.getInstance().triggerEvent(petSkillChange, skillChangeArg);
/* 368 */         SPetNormalResult sPetNormalResult2 = new SPetNormalResult();
/* 369 */         sPetNormalResult2.result = 12;
/* 370 */         OnlineManager.getInstance().send(this.roleId, sPetNormalResult2);
/* 371 */         PetEventArg eventArg = new PetEventArg();
/* 372 */         eventArg.petId = this.mainPetId;
/* 373 */         eventArg.roleId = this.roleId;
/* 374 */         TriggerEventsManger.getInstance().triggerEvent(new PetHuaSheng(), eventArg);
/* 375 */         if (hashSet.size() > PetConstants.getInstance().PET_HUASHENG_X_SKILL_BULLETIN) {
/* 376 */           SBulletinInfo bulletinInfo = new SBulletinInfo();
/* 377 */           bulletinInfo.bulletintype = 27;
/* 378 */           bulletinInfo.params.put(Integer.valueOf(1), RoleInterface.getName(this.roleId));
/* 379 */           bulletinInfo.params.put(Integer.valueOf(21), String.valueOf(mainPetCfg.getId()));
/* 380 */           bulletinInfo.params.put(Integer.valueOf(23), String.valueOf(hashSet.size()));
/* 381 */           BulletinInterface.sendBulletin(bulletinInfo);
/*     */         }
/* 383 */         String hostIp = GameServerInfoManager.getHostIP();
/* 384 */         TLogManager.getInstance().addLog(this.roleId, "PetHuaSheng", PetManager.createTLog(new Object[] { hostIp, userId, Long.valueOf(this.roleId), Long.valueOf(this.mainPetId), Integer.valueOf(mainPetCfg.getId()), Integer.valueOf(mainPetSkillNum), Integer.valueOf(xMainPet.getLevel()), Long.valueOf(this.fuPetId), Integer.valueOf(xFuPetTemplateId), Integer.valueOf(fuPetSKillNum), Integer.valueOf(xFuPetLevel), Integer.valueOf(xMainPet.getSkilllist().size()), Integer.valueOf(this.minimumGuaranteeType), Integer.valueOf(this.costType) }));
/* 385 */         if (this.fuPetId != -1L) {
/* 386 */           PetManager.addPetDeleteTlog(this.roleId, this.fuPetId, xFuPetTemplateId, PetDeleteTLogEnum.HUASHENG);
/*     */         }
/* 388 */         arrayList.clear();
/* 389 */         arrayList.addAll(hashSet);
/* 390 */         PetManager.addPetSkillChangeTlog(this.roleId, hostIp, userId, this.mainPetId, mainPetCfg.getId(), PetSkillChangeLogEnum.HUASHENG, arrayList);
/* 391 */         return true;
/*     */       }
/*     */       
/* 394 */       onHuaShengReqFail(203);
/* 395 */       return false;
/*     */     }
/*     */     
/* 398 */     Map<String, Object> extraMap7 = new HashMap();
/* 399 */     extraMap7.put("fu_pet_skill_num", Integer.valueOf(fuPetSKillNum));
/* 400 */     extraMap7.put("main_pet_skill_num", Integer.valueOf(mainPetSkillNum));
/* 401 */     extraMap7.put("max_pet_skill_num", Integer.valueOf(PetConstants.getInstance().PET_SHELF_SKILL_NUM_LIMIT));
/* 402 */     onHuaShengReqFail(215, extraMap7);
/* 403 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean handleHuaShengMinimumGuarantee(String userId, SPetHuaShengCostConf sPetHuaShengCostConf, int guaranteeCalculateSkillSumNum, VicePetMakeUpPriceInfo vicePetMakeUpPriceInfo)
/*     */   {
/* 411 */     int huaShengCostItemNum = sPetHuaShengCostConf.needItemNum;
/* 412 */     int addYuanBao1 = removeHuaShengDanItemAndCalNeedYuanBao(huaShengCostItemNum);
/* 413 */     if (addYuanBao1 < 0) {
/* 414 */       return false;
/*     */     }
/* 416 */     int needYuanBao = 0 + addYuanBao1;
/* 417 */     if (this.minimumGuaranteeType != 0) {
/* 418 */       int guaranteeSkillNum = this.minimumGuaranteeType == 1 ? guaranteeCalculateSkillSumNum / 2 : guaranteeCalculateSkillSumNum / 2 + 1;
/* 419 */       MinmumGuaranteeBean minmunGuaranteeBean = (MinmumGuaranteeBean)sPetHuaShengCostConf.minmum_guarantee_list.get(guaranteeSkillNum);
/* 420 */       if (minmunGuaranteeBean == null) {
/* 421 */         Map<String, Object> extraMap = new HashMap();
/* 422 */         extraMap.put("guarantee_skill_num", Integer.valueOf(guaranteeSkillNum));
/* 423 */         onHuaShengReqFail(216, extraMap);
/* 424 */         return false;
/*     */       }
/* 426 */       int minmumGuaranteeItemId = this.minimumGuaranteeType == 1 ? PetConstants.getInstance().hua_sheng_low_minimum_guarantee_item_id : PetConstants.getInstance().hua_sheng_hign_minimum_guarantee_item_id;
/* 427 */       int needMinmumGuaranteeItemNum = this.minimumGuaranteeType == 1 ? minmunGuaranteeBean.need_low_minimum_guarantee_item_num : minmunGuaranteeBean.need_high_minimum_guarantee_item_num;
/* 428 */       int itemType = this.minimumGuaranteeType == 1 ? 111 : 112;
/* 429 */       int addYuanBao2 = removeGuaranteeItemAndCalNeedYuanBao(needMinmumGuaranteeItemNum, minmumGuaranteeItemId, itemType);
/* 430 */       if (addYuanBao2 < 0) {
/* 431 */         return false;
/*     */       }
/* 433 */       needYuanBao += addYuanBao2;
/*     */     }
/* 435 */     if (vicePetMakeUpPriceInfo != null) {
/* 436 */       needYuanBao += vicePetMakeUpPriceInfo.vicePetMakeUpPrice;
/*     */     }
/* 438 */     if (this.costType == 1) {
/* 439 */       if (needYuanBao <= 0) {
/* 440 */         onHuaShengReqFail(212);
/* 441 */         return false; }
/* 442 */       if (needYuanBao != this.needYuanBao) {
/* 443 */         onHuaShengReqFail(218);
/* 444 */         return false;
/*     */       }
/* 446 */       CostResult costResult = QingfuInterface.costYuanbao(userId, this.roleId, needYuanBao, CostType.COST_BIND_FIRST_PET_HUASHENG, new TLogArg(LogReason.PET_HUASHENG_REM));
/* 447 */       if (costResult == CostResult.Success) {
/* 448 */         return true;
/*     */       }
/* 450 */       Map<String, Object> extraMap2 = new HashMap();
/* 451 */       extraMap2.put("ret", Integer.valueOf(costResult.code));
/* 452 */       extraMap2.put("des", costResult.desc);
/* 453 */       onHuaShengReqFail(214, extraMap2);
/* 454 */       return false;
/*     */     }
/* 456 */     if (needYuanBao <= 0) {
/* 457 */       return true;
/*     */     }
/* 459 */     onHuaShengReqFail(213);
/* 460 */     return false;
/*     */   }
/*     */   
/*     */   private int removeHuaShengDanItemAndCalNeedYuanBao(int needItemNum)
/*     */   {
/* 465 */     int needItemId = PetConstants.getInstance().PET_HUASHENG_ITEM_ID;
/* 466 */     int nowHasItemItem = ItemInterface.getItemNumberByType(this.roleId, 340600000, 19, true);
/* 467 */     if (needItemNum > nowHasItemItem) {
/* 468 */       if (nowHasItemItem > 0) {
/* 469 */         boolean result = ItemInterface.removeItemById(this.roleId, needItemId, nowHasItemItem, new TLogArg(LogReason.PET_HUASHENG_REM));
/* 470 */         if (!result) {
/* 471 */           Map<String, Object> extraMap = new HashMap();
/* 472 */           extraMap.put("need_item_num", Integer.valueOf(needItemNum));
/* 473 */           extraMap.put("need_item_id", Integer.valueOf(needItemId));
/* 474 */           extraMap.put("now_has_item_num", Integer.valueOf(nowHasItemItem));
/* 475 */           onHuaShengReqFail(208, extraMap);
/* 476 */           return -1;
/*     */         }
/*     */       }
/* 479 */       int itemPrice = ItemInterface.getItemYuanBaoPrice(needItemId);
/* 480 */       if (itemPrice <= 0) {
/* 481 */         Map<String, Object> extraMap2 = new HashMap();
/* 482 */         extraMap2.put("need_item_num", Integer.valueOf(needItemNum));
/* 483 */         extraMap2.put("need_item_id", Integer.valueOf(needItemId));
/* 484 */         extraMap2.put("now_has_item_num", Integer.valueOf(nowHasItemItem));
/* 485 */         extraMap2.put("price", Integer.valueOf(itemPrice));
/* 486 */         onHuaShengReqFail(209, extraMap2);
/* 487 */         return -1;
/*     */       }
/* 489 */       int needYuanBao = itemPrice * (needItemNum - nowHasItemItem);
/* 490 */       return needYuanBao;
/*     */     }
/* 492 */     boolean result2 = ItemInterface.removeItemsByType(this.roleId, 19, needItemNum, new TLogArg(LogReason.PET_HUASHENG_REM));
/* 493 */     if (result2) {
/* 494 */       return 0;
/*     */     }
/* 496 */     Map<String, Object> extraMap3 = new HashMap();
/* 497 */     extraMap3.put("need_item_num", Integer.valueOf(needItemNum));
/* 498 */     extraMap3.put("need_item_id", Integer.valueOf(needItemId));
/* 499 */     extraMap3.put("now_has_item_num", Integer.valueOf(nowHasItemItem));
/* 500 */     onHuaShengReqFail(208, extraMap3);
/* 501 */     return -1;
/*     */   }
/*     */   
/*     */   private int removeGuaranteeItemAndCalNeedYuanBao(int needItemNum, int needItemId, int itemType) {
/* 505 */     int nowHasItemItem = ItemInterface.getItemNumberByType(this.roleId, 340600000, itemType, true);
/* 506 */     if (needItemNum > nowHasItemItem) {
/* 507 */       if (nowHasItemItem > 0) {
/* 508 */         ItemOperateResult itemOperateResult = ItemInterface.removeItemsByItemType(this.roleId, itemType, nowHasItemItem, true, new TLogArg(LogReason.PET_HUASHENG_REM));
/* 509 */         if (!itemOperateResult.success()) {
/* 510 */           Map<String, Object> extraMap = new HashMap();
/* 511 */           extraMap.put("need_item_num", Integer.valueOf(needItemNum));
/* 512 */           extraMap.put("need_item_id", Integer.valueOf(needItemId));
/* 513 */           extraMap.put("now_has_item_num", Integer.valueOf(nowHasItemItem));
/* 514 */           extraMap.put("reason", itemOperateResult.getResultEnum());
/* 515 */           onHuaShengReqFail(210, extraMap);
/* 516 */           return -1;
/*     */         }
/*     */       }
/* 519 */       int itemPrice = ItemInterface.getItemYuanBaoPrice(needItemId);
/* 520 */       if (itemPrice <= 0) {
/* 521 */         Map<String, Object> extraMap2 = new HashMap();
/* 522 */         extraMap2.put("need_item_num", Integer.valueOf(needItemNum));
/* 523 */         extraMap2.put("need_item_id", Integer.valueOf(needItemId));
/* 524 */         extraMap2.put("now_has_item_num", Integer.valueOf(nowHasItemItem));
/* 525 */         extraMap2.put("item_price", Integer.valueOf(itemPrice));
/* 526 */         onHuaShengReqFail(211, extraMap2);
/* 527 */         return -1;
/*     */       }
/* 529 */       int needYuanBao = itemPrice * (needItemNum - nowHasItemItem);
/* 530 */       return needYuanBao;
/*     */     }
/* 532 */     ItemOperateResult itemOperateResult2 = ItemInterface.removeItemsByItemType(this.roleId, itemType, needItemNum, true, new TLogArg(LogReason.PET_HUASHENG_REM));
/* 533 */     if (itemOperateResult2.success()) {
/* 534 */       return 0;
/*     */     }
/* 536 */     Map<String, Object> extraMap3 = new HashMap();
/* 537 */     extraMap3.put("need_item_num", Integer.valueOf(needItemNum));
/* 538 */     extraMap3.put("need_item_id", Integer.valueOf(needItemId));
/* 539 */     extraMap3.put("now_has_item_num", Integer.valueOf(nowHasItemItem));
/* 540 */     extraMap3.put("reason", itemOperateResult2.getResultEnum());
/* 541 */     onHuaShengReqFail(210, extraMap3);
/* 542 */     return -1;
/*     */   }
/*     */   
/*     */   private void onHuaShengReqFail(int ret) {
/* 546 */     onHuaShengReqFail(ret, null);
/*     */   }
/*     */   
/*     */   private void onHuaShengReqFail(int ret, Map<String, ?> extraMap) {
/* 550 */     StringBuilder sbLog = new StringBuilder();
/* 551 */     sbLog.append("[sign]PHuaShengReq.processImp@hua sheng failed");
/* 552 */     sbLog.append("|ret=").append(ret);
/* 553 */     sbLog.append("|role_id=").append(this.roleId);
/* 554 */     sbLog.append("|main_pet_id=").append(this.mainPetId);
/* 555 */     sbLog.append("|fu_pet_id=").append(this.fuPetId);
/* 556 */     sbLog.append("|yuan_bao_num=").append(this.clientYuanBao);
/* 557 */     sbLog.append("|cost_type=").append(this.costType);
/* 558 */     sbLog.append("|minmum_guarantee_type").append(this.minimumGuaranteeType);
/* 559 */     sbLog.append("|need_yuan_bao").append(this.needYuanBao);
/* 560 */     if ((extraMap != null) && (!extraMap.isEmpty())) {
/* 561 */       for (Map.Entry<String, ?> entry : extraMap.entrySet()) {
/* 562 */         sbLog.append('|').append((String)entry.getKey()).append('=').append(entry.getValue());
/*     */       }
/*     */     }
/* 565 */     GameServer.logger().error(sbLog.toString());
/* 566 */     SPetNormalResult sPetNormalResult = new SPetNormalResult();
/* 567 */     sPetNormalResult.result = ret;
/* 568 */     OnlineManager.getInstance().sendAtOnce(this.roleId, sPetNormalResult);
/*     */   }
/*     */   
/*     */   private boolean isHuaShengMinimumGuaranteeSwitchOpen(long roleId) {
/* 572 */     if (!OpenInterface.getOpenStatus(275)) {
/* 573 */       GameServer.logger().info(String.format("[pet]PHuaShengReq.isHuaShengMinimumguaranteeSwitchOpen@sign precious system switch closed|role_id=%d", new Object[] { Long.valueOf(roleId) }));
/* 574 */       return false; }
/* 575 */     if (!OpenInterface.isBanPlay(roleId, 275)) {
/* 576 */       return true;
/*     */     }
/* 578 */     GameServer.logger().info(String.format("[pet]PHuaShengReq.isHuaShengMinimumguaranteeSwitchOpen@sign precious system is ban play|role_id=%d", new Object[] { Long.valueOf(roleId) }));
/* 579 */     OpenInterface.sendBanPlayMsg(roleId, 275);
/* 580 */     return false;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pet\main\PHuaShengReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */