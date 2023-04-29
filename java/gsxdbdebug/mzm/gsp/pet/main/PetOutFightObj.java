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
/*     */ import java.util.Set;
/*     */ import mzm.gsp.common.IOutFightObject.FighterState;
/*     */ import mzm.gsp.common.PropertyFormula;
/*     */ import mzm.gsp.effect.main.OutFightEffect;
/*     */ import mzm.gsp.fight.main.FightArgs;
/*     */ import mzm.gsp.item.ItemInfo;
/*     */ import mzm.gsp.item.confbean.SPetDecorateItemCfg;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.item.main.ItemStoreEnum;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.pet.PetAptInfo;
/*     */ import mzm.gsp.pet.PetInfo;
/*     */ import mzm.gsp.pet.PetSoulInfo;
/*     */ import mzm.gsp.pet.SSyncPetInfoChange;
/*     */ import mzm.gsp.pet.confbean.PetConstants;
/*     */ import mzm.gsp.pet.confbean.STPetTransformProp;
/*     */ import mzm.gsp.petmark.main.PetMarkInterface;
/*     */ import mzm.gsp.petsoul.confbean.SPetPropBean;
/*     */ import mzm.gsp.petsoul.confbean.SPetSoulCfg;
/*     */ import mzm.gsp.petsoul.confbean.SPetSoulCfgPos2Level;
/*     */ import mzm.gsp.pubdata.ModelInfo;
/*     */ import mzm.gsp.role.main.PropertyManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.skill.confbean.SOutFightEffectGroup;
/*     */ import mzm.gsp.skill.confbean.SXiuLianSkillCfg;
/*     */ import mzm.gsp.skill.main.PassiveSkill;
/*     */ import mzm.gsp.skill.main.SkillInterface;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.Pair;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.Aptitude;
/*     */ import xbean.Item;
/*     */ import xbean.PetEquipBag;
/*     */ import xbean.PetOutFightBean;
/*     */ import xbean.PetSkill;
/*     */ import xbean.PetSoul;
/*     */ import xbean.PetSoulBag;
/*     */ import xbean.Pod;
/*     */ import xbean.Role2PetBean;
/*     */ import xbean.RoleXiuLian;
/*     */ import xbean.XiuLianSkill;
/*     */ import xtable.Role2petoutfightbean;
/*     */ import xtable.Role2xiulianskill;
/*     */ 
/*     */ public class PetOutFightObj extends Pet implements mzm.gsp.common.IOutFightObject
/*     */ {
/*     */   private PetOutFightBean xOutFightBean;
/*  59 */   private static final Logger logger = Logger.getLogger(PetOutFightObj.class);
/*     */   
/*     */   PetOutFightObj(long roleId, xbean.Pet xPet) {
/*  62 */     super(roleId, xPet);
/*  63 */     Role2PetBean xRole2Pet = Role2petoutfightbean.get(Long.valueOf(roleId));
/*  64 */     if (xRole2Pet == null) {
/*  65 */       xRole2Pet = Pod.newRole2PetBean();
/*  66 */       Role2petoutfightbean.add(Long.valueOf(roleId), xRole2Pet);
/*     */     }
/*  68 */     this.xOutFightBean = ((PetOutFightBean)xRole2Pet.getBeanmap().get(Long.valueOf(xPet.getId())));
/*  69 */     if (this.xOutFightBean == null) {
/*  70 */       this.xOutFightBean = Pod.newPetOutFightBean();
/*  71 */       xRole2Pet.getBeanmap().put(Long.valueOf(xPet.getId()), this.xOutFightBean);
/*  72 */       updateOutFightProperty();
/*     */     }
/*     */   }
/*     */   
/*     */   public void updateOutFightProperty() {
/*  77 */     updateEquipment();
/*  78 */     updatePassiveSkill();
/*  79 */     updateSoul();
/*  80 */     updatePetMark();
/*     */   }
/*     */   
/*     */   private int getAptValue(int aptType) {
/*  84 */     Integer aptValue = (Integer)this.xPet.getAptitude().getAptmap().get(Integer.valueOf(aptType));
/*  85 */     if (aptValue == null)
/*  86 */       return 0;
/*  87 */     return aptValue.intValue();
/*     */   }
/*     */   
/*     */   private double getAptValueByProp(int propertyType) {
/*  91 */     double aptValue = 0.0D;
/*  92 */     switch (propertyType) {
/*     */     case 1: 
/*  94 */       aptValue = getAptValue(0);
/*  95 */       return aptValue;
/*     */     case 7: 
/*  97 */       aptValue = getAptValue(1);
/*  98 */       return aptValue;
/*     */     case 8: 
/* 100 */       aptValue = getAptValue(2);
/* 101 */       return aptValue;
/*     */     case 9: 
/* 103 */       aptValue = getAptValue(3);
/* 104 */       return aptValue;
/*     */     case 10: 
/* 106 */       aptValue = getAptValue(4);
/* 107 */       return aptValue;
/*     */     case 24: 
/* 109 */       aptValue = getAptValue(5);
/* 110 */       return aptValue;
/*     */     }
/* 112 */     aptValue = 0.0D;
/* 113 */     return aptValue;
/*     */   }
/*     */   
/*     */   private int calculateType(int propertyType) {
/* 117 */     double propValue = 0.0D;
/* 118 */     int level = this.xPet.getLevel();
/* 119 */     PetCfg petCfg = PetManager.getInstance().getPetCfg(this.xPet.getTemplateid());
/* 120 */     if (petCfg == null)
/* 121 */       return 0;
/* 122 */     float addPerLv = petCfg.getProperty(propertyType, level);
/* 123 */     propValue = petCfg.getBornProp(propertyType);
/* 124 */     Integer bpv = (Integer)this.xPet.getBasicproperty().get(Integer.valueOf(propertyType));
/* 125 */     if (bpv != null)
/* 126 */       propValue += bpv.intValue();
/* 127 */     double aptValue = 0.0D;
/* 128 */     switch (propertyType) {
/*     */     case 1: 
/* 130 */       aptValue = (getAptValue(0) + PetConstants.getInstance().PET_APT_BASE_VALUE) * addPerLv / PetConstants.getInstance().PET_APT_BASE_RATE;
/* 131 */       break;
/*     */     case 7: 
/* 133 */       aptValue = (getAptValue(1) + PetConstants.getInstance().PET_APT_BASE_VALUE) * addPerLv / PetConstants.getInstance().PET_APT_BASE_RATE;
/* 134 */       break;
/*     */     case 8: 
/* 136 */       aptValue = (getAptValue(2) + PetConstants.getInstance().PET_APT_BASE_VALUE) * addPerLv / PetConstants.getInstance().PET_APT_BASE_RATE;
/* 137 */       break;
/*     */     case 9: 
/* 139 */       aptValue = (getAptValue(3) + PetConstants.getInstance().PET_APT_BASE_VALUE) * addPerLv / PetConstants.getInstance().PET_APT_BASE_RATE;
/* 140 */       break;
/*     */     case 10: 
/* 142 */       aptValue = (getAptValue(4) + PetConstants.getInstance().PET_APT_BASE_VALUE) * addPerLv / PetConstants.getInstance().PET_APT_BASE_RATE;
/* 143 */       break;
/*     */     case 24: 
/* 145 */       aptValue = (getAptValue(5) + PetConstants.getInstance().PET_APT_BASE_VALUE) * addPerLv / PetConstants.getInstance().PET_APT_BASE_RATE;
/* 146 */       break;
/*     */     default: 
/* 148 */       aptValue = addPerLv;
/*     */     }
/*     */     
/* 151 */     propValue += aptValue;
/* 152 */     STPetTransformProp stTransformProp = STPetTransformProp.get(propertyType);
/* 153 */     if (stTransformProp != null) {
/* 154 */       Map<Integer, Double> baseTransform = stTransformProp.basePro2value;
/* 155 */       if (baseTransform != null)
/* 156 */         for (Map.Entry<Integer, Double> entry : baseTransform.entrySet())
/* 157 */           propValue += getBaseValue(((Integer)entry.getKey()).intValue()) * ((Double)entry.getValue()).doubleValue() * this.xPet.getGrow();
/*     */     }
/* 159 */     return (int)(Math.round(propValue * 100.0D) / 100L);
/*     */   }
/*     */   
/*     */   private void addEquipmentProp(int propType, int propValue) {
/* 163 */     Integer propVal = (Integer)this.xOutFightBean.getEquipstaticaddpropmap().get(Integer.valueOf(propType));
/* 164 */     if (propVal == null)
/* 165 */       propVal = Integer.valueOf(0);
/* 166 */     this.xOutFightBean.getEquipstaticaddpropmap().put(Integer.valueOf(propType), Integer.valueOf(propVal.intValue() + propValue));
/*     */   }
/*     */   
/*     */   private void addSoulProp(int propType, int propValue) {
/* 170 */     Integer propVal = (Integer)this.xOutFightBean.getSouladdpropmap().get(Integer.valueOf(propType));
/* 171 */     if (propVal == null)
/* 172 */       propVal = Integer.valueOf(0);
/* 173 */     this.xOutFightBean.getSouladdpropmap().put(Integer.valueOf(propType), Integer.valueOf(propVal.intValue() + propValue));
/*     */   }
/*     */   
/*     */   private void addPetMarkProp(int propType, int propValue) {
/* 177 */     Integer propVal = (Integer)this.xOutFightBean.getPetmarkaddpropmap().get(Integer.valueOf(propType));
/* 178 */     if (propVal == null)
/* 179 */       propVal = Integer.valueOf(0);
/* 180 */     this.xOutFightBean.getPetmarkaddpropmap().put(Integer.valueOf(propType), Integer.valueOf(propVal.intValue() + propValue));
/*     */   }
/*     */   
/*     */   public void updatePetMark() {
/* 184 */     int beforeFinalhp = getFinalMaxHP();
/* 185 */     int beforeFinalmp = getFinalMaxMP();
/* 186 */     this.xOutFightBean.getPetmarkaddpropmap().clear();
/* 187 */     Map<Integer, Integer> petMarkPropsMap = PetMarkInterface.getPetMarkProps(this.roleId, getId(), false);
/* 188 */     for (Map.Entry<Integer, Integer> entry : petMarkPropsMap.entrySet())
/* 189 */       addPetMarkProp(((Integer)entry.getKey()).intValue(), ((Integer)entry.getValue()).intValue());
/* 190 */     int changeHP = getFinalMaxHP() - beforeFinalhp;
/* 191 */     int changeMP = getFinalMaxMP() - beforeFinalmp;
/* 192 */     setHP(getHP() + changeHP);
/* 193 */     setMP(getMP() + changeMP);
/* 194 */     onPropertyChange();
/*     */   }
/*     */   
/*     */   public void updateSoul() {
/* 198 */     int beforeFinalhp = getFinalMaxHP();
/* 199 */     int beforeFinalmp = getFinalMaxMP();
/* 200 */     this.xOutFightBean.getSouladdpropmap().clear();
/* 201 */     Set<Map.Entry<Integer, PetSoul>> xSet = this.xPet.getSoulbag().getSoulmap().entrySet();
/* 202 */     for (Map.Entry<Integer, PetSoul> entry : xSet) {
/* 203 */       PetSoul xPetSoul = (PetSoul)entry.getValue();
/* 204 */       SPetSoulCfgPos2Level petSoulCfgPos2Level = SPetSoulCfgPos2Level.get(xPetSoul.getPos());
/* 205 */       Integer petSoulCfgId = (Integer)petSoulCfgPos2Level.level2id.get(Integer.valueOf(xPetSoul.getLevel()));
/* 206 */       SPetSoulCfg soulCfg = SPetSoulCfg.get(petSoulCfgId.intValue());
/* 207 */       SPetPropBean propBeanCfg = (SPetPropBean)soulCfg.propList.get(xPetSoul.getPropindex() - 1);
/* 208 */       addSoulProp(propBeanCfg.propType, propBeanCfg.propValue);
/*     */     }
/* 210 */     int changeHP = getFinalMaxHP() - beforeFinalhp;
/* 211 */     int changeMP = getFinalMaxMP() - beforeFinalmp;
/* 212 */     setHP(getHP() + changeHP);
/* 213 */     setMP(getMP() + changeMP);
/* 214 */     onPropertyChange();
/*     */   }
/*     */   
/*     */   public void updateEquipment() {
/* 218 */     int beforeFinalhp = getFinalMaxHP();
/* 219 */     int beforeFinalmp = getFinalMaxMP();
/* 220 */     PetEquipBag xPetEquipBag = this.xPet.getEquipbag();
/* 221 */     Map<Integer, Item> xPetEquipMap = xPetEquipBag.getEquip2item();
/* 222 */     this.xOutFightBean.getEquipstaticaddpropmap().clear();
/* 223 */     for (Item xPetEquip : xPetEquipMap.values()) {
/* 224 */       Integer pv = (Integer)xPetEquip.getExtra().get(Integer.valueOf(ItemStoreEnum.PET_EQUIP_ATTRI_A_TYPE.getStoreType()));
/* 225 */       if (pv != null) {
/* 226 */         int propValue = ((Integer)xPetEquip.getExtra().get(Integer.valueOf(ItemStoreEnum.PET_EQUIP_ATTRI_A.getStoreType()))).intValue();
/* 227 */         addEquipmentProp(pv.intValue(), propValue);
/*     */       }
/* 229 */       pv = (Integer)xPetEquip.getExtra().get(Integer.valueOf(ItemStoreEnum.PET_EQUIP_ATTRI_B_TYPE.getStoreType()));
/* 230 */       if (pv != null) {
/* 231 */         int propValue = ((Integer)xPetEquip.getExtra().get(Integer.valueOf(ItemStoreEnum.PET_EQUIP_ATTRI_B.getStoreType()))).intValue();
/* 232 */         addEquipmentProp(pv.intValue(), propValue);
/*     */       }
/*     */     }
/* 235 */     int changeHP = getFinalMaxHP() - beforeFinalhp;
/* 236 */     int changeMP = getFinalMaxMP() - beforeFinalmp;
/* 237 */     setHP(getHP() + changeHP);
/* 238 */     setMP(getMP() + changeMP);
/* 239 */     onPropertyChange();
/*     */   }
/*     */   
/*     */   private int getOutFightBeanProperty(int propertyType) {
/* 243 */     int propValue = 0;
/* 244 */     Integer outfightPropValue = (Integer)this.xOutFightBean.getEquipstaticaddpropmap().get(Integer.valueOf(propertyType));
/* 245 */     if (outfightPropValue != null)
/* 246 */       propValue += outfightPropValue.intValue();
/* 247 */     Integer effectProp = (Integer)this.xOutFightBean.getEffectaddpropmap().get(Integer.valueOf(propertyType));
/* 248 */     if (effectProp != null)
/* 249 */       propValue += effectProp.intValue();
/* 250 */     Integer soulValue = (Integer)this.xOutFightBean.getSouladdpropmap().get(Integer.valueOf(propertyType));
/* 251 */     if (soulValue != null)
/* 252 */       propValue = (int)(propValue + Math.floor(calSoulPropValue(propertyType, soulValue.intValue())));
/* 253 */     Integer petMarkValue = (Integer)this.xOutFightBean.getPetmarkaddpropmap().get(Integer.valueOf(propertyType));
/* 254 */     if (petMarkValue != null)
/* 255 */       propValue = (int)(propValue + Math.floor(calPetMarkPropValue(propertyType, petMarkValue.intValue())));
/* 256 */     return propValue;
/*     */   }
/*     */   
/*     */   private double calSoulPropValue(int propertyType, int soulValue) {
/* 260 */     double apt = getAptValueByProp(propertyType);
/* 261 */     float grow = this.xPet.getGrow();
/* 262 */     float DEFAULT_RATE = FightArgs.getInstance().getDefaultRate();
/* 263 */     double result = soulValue * PetConstants.getInstance().RATIO_BISIC_PROP / DEFAULT_RATE + soulValue * Math.max(apt / 1000.0D - PetConstants.getInstance().CONST_APT / DEFAULT_RATE, 0.0D) * PetConstants.getInstance().RATIO_APT / DEFAULT_RATE + soulValue * Math.max(grow - PetConstants.getInstance().CONST_GROW / DEFAULT_RATE, 0.0F) * PetConstants.getInstance().RATIO_GROW / DEFAULT_RATE;
/* 264 */     return result;
/*     */   }
/*     */   
/*     */   private double calPetMarkPropValue(int propertyType, int petmarkValue) {
/* 268 */     double apt = getAptValueByProp(propertyType);
/* 269 */     if (apt == 0.0D)
/* 270 */       return petmarkValue;
/* 271 */     float grow = this.xPet.getGrow();
/* 272 */     float DEFAULT_RATE = FightArgs.getInstance().getDefaultRate();
/* 273 */     double result = petmarkValue * PetConstants.getInstance().RATIO_BISIC_PROP / DEFAULT_RATE + petmarkValue * Math.max(apt / 1000.0D - PetConstants.getInstance().CONST_APT / DEFAULT_RATE, 0.0D) * PetConstants.getInstance().RATIO_APT / DEFAULT_RATE + petmarkValue * Math.max(grow - PetConstants.getInstance().CONST_GROW / DEFAULT_RATE, 0.0F) * PetConstants.getInstance().RATIO_GROW / DEFAULT_RATE;
/* 274 */     return result;
/*     */   }
/*     */   
/*     */   int getOuterValue(int propertyType) {
/* 278 */     int propValue = 0;
/* 279 */     Integer outfightPropValue = Integer.valueOf(getOutFightBeanProperty(propertyType));
/* 280 */     if (outfightPropValue != null)
/* 281 */       propValue += outfightPropValue.intValue();
/* 282 */     return propValue;
/*     */   }
/*     */   
/*     */   int getBaseValue(int propertyType) {
/* 286 */     int level = this.xPet.getLevel();
/* 287 */     PetCfg petCfg = PetManager.getInstance().getPetCfg(this.xPet.getTemplateid());
/* 288 */     if (petCfg == null)
/* 289 */       return 0;
/* 290 */     float propLevelValue = petCfg.getProperty(propertyType, level);
/* 291 */     Integer bpv = (Integer)this.xPet.getBasicproperty().get(Integer.valueOf(propertyType));
/* 292 */     if (bpv == null)
/* 293 */       bpv = Integer.valueOf(0);
/* 294 */     Integer outfightp = Integer.valueOf(getOutFightBeanProperty(propertyType));
/* 295 */     float bornValue = petCfg.getProperty(propertyType, 0);
/* 296 */     int totalValue = (int)(bornValue + propLevelValue - bornValue + bpv.intValue()) + outfightp.intValue();
/* 297 */     return totalValue;
/*     */   }
/*     */   
/*     */   public int getYaoLi() {
/* 301 */     int yaoLi = getNewFightValue();
/* 302 */     return yaoLi;
/*     */   }
/*     */   
/*     */   public void fillPetInfo(PetInfo petInfo) {
/* 306 */     PetCfg petCfg = PetManager.getInstance().getPetCfg(this.xPet.getTemplateid());
/* 307 */     if (petCfg == null)
/* 308 */       return;
/* 309 */     petInfo.petid = this.xPet.getId();
/* 310 */     petInfo.typeid = this.xPet.getTemplateid();
/* 311 */     petInfo.exp = this.xPet.getExp();
/* 312 */     petInfo.grow = this.xPet.getGrow();
/* 313 */     petInfo.mp = this.xPet.getMp();
/* 314 */     petInfo.hp = this.xPet.getHp();
/* 315 */     petInfo.petlevel = this.xPet.getLevel();
/* 316 */     petInfo.petname = this.xPet.getPetname();
/* 317 */     petInfo.life = this.xPet.getLife();
/* 318 */     petInfo.stagelevel = this.xPet.getStagelevel();
/* 319 */     petInfo.magatk = getFinalMAGATK();
/* 320 */     petInfo.magdef = getFinalMAGDEF();
/* 321 */     petInfo.maxhp = getFinalMaxHP();
/* 322 */     petInfo.maxmp = getFinalMaxMP();
/* 323 */     petInfo.phyatk = getFinalPHYATK();
/* 324 */     petInfo.phydef = getFinalPHYDEF();
/* 325 */     petInfo.speed = getFinalSpeed();
/* 326 */     Aptitude xApt = this.xPet.getAptitude();
/* 327 */     for (Map.Entry<Integer, Integer> entry : xApt.getAptmap().entrySet())
/* 328 */       petInfo.petapt.aptmap.put(entry.getKey(), entry.getValue());
/* 329 */     Item decorateItem = (Item)this.xPet.getEquipbag().getEquip2item().get(Integer.valueOf(3));
/* 330 */     int addApt = 0;
/* 331 */     if (decorateItem != null) {
/* 332 */       SPetDecorateItemCfg cfg = SPetDecorateItemCfg.get(decorateItem.getCfgid());
/* 333 */       addApt = cfg.addRealAptMaxLimit;
/* 334 */       petInfo.isdecorated = 1;
/*     */     }
/* 336 */     for (Map.Entry<Integer, Integer> entry : xApt.getAptlimitmap().entrySet())
/* 337 */       petInfo.petapt.aptlimitmap.put(entry.getKey(), Integer.valueOf(((Integer)entry.getValue()).intValue() + addApt));
/* 338 */     if (petCfg.isBaoBao()) {
/* 339 */       petInfo.pettype = 1;
/* 340 */     } else if (petCfg.isBianYi()) {
/* 341 */       petInfo.pettype = 2;
/* 342 */     } else if (petCfg.isShenShou()) {
/* 343 */       petInfo.pettype = 3;
/* 344 */     } else if (petCfg.isMoShou()) {
/* 345 */       petInfo.pettype = 4;
/*     */     }
/* 347 */     List<PetSkill> xPetSkillList = this.xPet.getSkilllist();
/* 348 */     for (PetSkill xPetSkill : xPetSkillList)
/* 349 */       petInfo.skillidlist.add(Integer.valueOf(xPetSkill.getSkillid()));
/* 350 */     petInfo.rememberskillid = this.xPet.getRememberskillid();
/* 351 */     getModel(petInfo.model);
/* 352 */     petInfo.yaoli = getYaoLi();
/* 353 */     petInfo.bindedstate = this.xPet.getIsbinded();
/* 354 */     petInfo.potentialpoint = this.xPet.getPotentialpoint();
/* 355 */     petInfo.extramodelcfgid = this.xPet.getExtramodelcfgid();
/* 356 */     petInfo.own_extra_model_cfg_ids.addAll(this.xPet.getOwnextramodelcfgids());
/* 357 */     Map<Integer, Integer> xPropPref = this.xPet.getAutospecialpointcase();
/* 358 */     for (int propType = 25; propType <= 29; propType++) {
/* 359 */       petInfo.basepropmap.put(Integer.valueOf(propType), Integer.valueOf(getBaseValue(propType)));
/* 360 */       Integer autoAddValue = (Integer)xPropPref.get(Integer.valueOf(propType));
/* 361 */       if (autoAddValue == null)
/* 362 */         autoAddValue = Integer.valueOf(0);
/* 363 */       petInfo.autoaddproppref.put(Integer.valueOf(propType), autoAddValue);
/*     */     }
/* 365 */     petInfo.isautoaddflagopen = (this.xPet.getIsautospecialpoint() ? 1 : 0);
/* 366 */     petInfo.marketbuytime = this.xPet.getMarketbuytime();
/* 367 */     PetEquipBag xPetEquipBag = this.xPet.getEquipbag();
/* 368 */     Map<Integer, Item> xPetEquipMap = xPetEquipBag.getEquip2item();
/* 369 */     Item xEquip = (Item)xPetEquipMap.get(Integer.valueOf(2));
/* 370 */     if (xEquip != null) {
/* 371 */       ItemInfo itemInfo = new ItemInfo();
/* 372 */       ItemInterface.fillInItemInfoBean(itemInfo, xEquip);
/* 373 */       petInfo.equipmap.put(Integer.valueOf(2), itemInfo);
/*     */     }
/* 375 */     xEquip = (Item)xPetEquipMap.get(Integer.valueOf(0));
/* 376 */     if (xEquip != null) {
/* 377 */       ItemInfo itemInfo = new ItemInfo();
/* 378 */       ItemInterface.fillInItemInfoBean(itemInfo, xEquip);
/* 379 */       petInfo.equipmap.put(Integer.valueOf(0), itemInfo);
/*     */     }
/* 381 */     xEquip = (Item)xPetEquipMap.get(Integer.valueOf(1));
/* 382 */     if (xEquip != null) {
/* 383 */       ItemInfo itemInfo = new ItemInfo();
/* 384 */       ItemInterface.fillInItemInfoBean(itemInfo, xEquip);
/* 385 */       petInfo.equipmap.put(Integer.valueOf(1), itemInfo);
/*     */     }
/* 387 */     for (Iterator<Integer> i$ = this.xPet.getBasicproperty().values().iterator(); i$.hasNext();) {
/* 388 */       int value = ((Integer)i$.next()).intValue();
/* 389 */       if (value > 0) {
/* 390 */         petInfo.iscanresetprop = 1;
/* 391 */         break;
/*     */       }
/*     */     }
/* 394 */     Collection<PetSoul> xpetSouls = this.xPet.getSoulbag().getSoulmap().values();
/* 395 */     for (PetSoul xPetSoul : xpetSouls) {
/* 396 */       PetSoulInfo soulInfo = new PetSoulInfo(xPetSoul.getPos(), xPetSoul.getLevel(), xPetSoul.getExp(), xPetSoul.getPropindex());
/* 397 */       petInfo.soulmap.put(Integer.valueOf(xPetSoul.getPos()), soulInfo);
/*     */     }
/* 399 */     Pair<Integer, Integer> petMarkCfgIdAndLevel = PetMarkInterface.getPetMarkCfgIdAndLevel(this.roleId, getId(), false);
/* 400 */     petInfo.petmarkcfgid = ((Integer)petMarkCfgIdAndLevel.first).intValue();
/* 401 */     petInfo.petmarklevel = ((Integer)petMarkCfgIdAndLevel.second).intValue();
/* 402 */     petInfo.extraremember = RememberSkillManager.getRemberSkillIds(this.xPet.getId());
/*     */   }
/*     */   
/*     */   public void syncPetInfo() {
/* 406 */     SSyncPetInfoChange infoChange = new SSyncPetInfoChange();
/* 407 */     fillPetInfo(infoChange.petinfo);
/* 408 */     OnlineManager.getInstance().send(this.roleId, infoChange);
/*     */   }
/*     */   
/*     */   public void updatePassiveSkill() {
/* 412 */     int beforeFinalhp = getFinalMaxHP();
/* 413 */     int beforeFinalmp = getFinalMaxMP();
/* 414 */     Set<Integer> allSkill = getPassiveSkillIds();
/* 415 */     Set<OutFightEffect> effectSet = this.xOutFightBean.getSkilleffectset();
/* 416 */     for (OutFightEffect effect : effectSet)
/* 417 */       effect.detach(this);
/* 418 */     this.xOutFightBean.getSkilleffectset().clear();
/* 419 */     for (Integer skillId : allSkill) {
/* 420 */       PassiveSkill passiveSkill = SkillInterface.getPassiveSkillById2Lv(skillId.intValue(), 1);
/* 421 */       if (passiveSkill != null) {
/* 422 */         List<OutFightEffect> outFightEffects = passiveSkill.getEffectList(this);
/* 423 */         for (OutFightEffect effect : outFightEffects) {
/* 424 */           effect.attach(this);
/* 425 */           this.xOutFightBean.getSkilleffectset().add(effect);
/*     */         }
/*     */       }
/*     */     }
/* 429 */     RoleXiuLian xRoleXiuLian = Role2xiulianskill.get(Long.valueOf(this.roleId));
/* 430 */     if (xRoleXiuLian != null)
/* 431 */       for (Map.Entry<Integer, XiuLianSkill> xXiuLianSkillEntry : xRoleXiuLian.getSkillmap().entrySet()) {
/* 432 */         XiuLianSkill xXiuLianSkill = (XiuLianSkill)xXiuLianSkillEntry.getValue();
/* 433 */         if (xXiuLianSkill.getLevel() != 0) {
/* 434 */           SXiuLianSkillCfg sXiuLianSkillCfg = SXiuLianSkillCfg.get(((Integer)xXiuLianSkillEntry.getKey()).intValue());
/* 435 */           if ((sXiuLianSkillCfg.target & 0x2) != 0) {
/* 436 */             PassiveSkill skill = SkillInterface.getPassiveSkillById2Lv(sXiuLianSkillCfg.skillId, xXiuLianSkill.getLevel());
/* 437 */             List<OutFightEffect> outFightEffects = skill.getEffectList(this);
/* 438 */             for (OutFightEffect effect : outFightEffects) {
/* 439 */               this.xOutFightBean.getSkilleffectset().add(effect);
/* 440 */               effect.attach(this);
/*     */             }
/*     */           }
/*     */         }
/*     */       }
/* 445 */     int changeHP = getFinalMaxHP() - beforeFinalhp;
/* 446 */     int changeMP = getFinalMaxMP() - beforeFinalmp;
/* 447 */     setHP(getHP() + changeHP);
/* 448 */     setMP(getMP() + changeMP);
/* 449 */     onPropertyChange();
/*     */   }
/*     */   
/*     */   private void onPropertyChange() {
/* 453 */     int hp = getHP();
/* 454 */     int mp = getMP();
/* 455 */     int maxHp = getFinalMaxHP();
/* 456 */     int maxMp = getFinalMaxMP();
/* 457 */     if (hp > maxHp)
/* 458 */       setHP(maxHp);
/* 459 */     if (mp > maxMp)
/* 460 */       setMP(maxMp);
/* 461 */     int yaoli = getNewFightValue();
/* 462 */     if (yaoli != this.xPet.getYaoli()) {
/* 463 */       this.xPet.setYaoli(getNewFightValue());
/* 464 */       this.xPet.setChangeyaolitime(DateTimeUtils.getCurrTimeInMillis());
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean addLife(int life) {
/* 469 */     boolean ret = super.addLife(life);
/* 470 */     syncPetInfo();
/* 471 */     return ret;
/*     */   }
/*     */   
/*     */   public int getSex() {
/* 475 */     return 1;
/*     */   }
/*     */   
/*     */   public void fillSelfFixFightProperty(Map<Integer, Integer> propMap) {
/* 479 */     for (Integer prop : PropertyFormula.PROP_LIST)
/* 480 */       fillDefaultInnverProperty(prop.intValue(), propMap);
/*     */   }
/*     */   
/*     */   public Map<Integer, Integer> getSelfFixFightProperty() {
/* 484 */     Map<Integer, Integer> propMap = new HashMap();
/* 485 */     fillSelfFixFightProperty(propMap);
/* 486 */     return propMap;
/*     */   }
/*     */   
/*     */   public void fillOtherFightProperty(Map<Integer, Integer> propMap) {
/* 490 */     for (Integer prop : PropertyFormula.PROP_LIST)
/* 491 */       fillDefaultOutProperty(prop.intValue(), propMap);
/*     */   }
/*     */   
/*     */   public Map<Integer, Integer> getOtherFightProperty() {
/* 495 */     Map<Integer, Integer> propMap = new HashMap();
/* 496 */     fillOtherFightProperty(propMap);
/* 497 */     return propMap;
/*     */   }
/*     */   
/*     */   public Map<Integer, Integer> getFinalPropertyMap() {
/* 501 */     Map<Integer, Integer> propMap = new HashMap();
/* 502 */     fillFinalPropertyMap(propMap);
/* 503 */     return propMap;
/*     */   }
/*     */   
/*     */   public void fillFinalPropertyMap(Map<Integer, Integer> propMap) {
/* 507 */     Map<Integer, Integer> pro2Ret = PropertyManager.getPro2Ret();
/* 508 */     Iterator<Map.Entry<Integer, Integer>> it = pro2Ret.entrySet().iterator();
/* 509 */     while (it.hasNext()) {
/* 510 */       Map.Entry<Integer, Integer> entry = (Map.Entry)it.next();
/* 511 */       int propType = ((Integer)entry.getKey()).intValue();
/* 512 */       int finalValue = getFinalProperty(propType, ((Integer)entry.getValue()).intValue());
/* 513 */       propMap.put(Integer.valueOf(propType), Integer.valueOf(finalValue));
/*     */     }
/* 515 */     propMap.put(Integer.valueOf(2), Integer.valueOf(getHP()));
/* 516 */     propMap.put(Integer.valueOf(4), Integer.valueOf(getMP()));
/*     */   }
/*     */   
/*     */   private void fillDefaultOutProperty(int propertyType, Map<Integer, Integer> propMap) {
/* 520 */     Integer propValue = Integer.valueOf(getOuterValue(propertyType));
/* 521 */     if (propValue == null)
/* 522 */       propValue = Integer.valueOf(0);
/* 523 */     propMap.put(Integer.valueOf(propertyType), propValue);
/*     */   }
/*     */   
/*     */   private void fillDefaultInnverProperty(int propertyType, Map<Integer, Integer> propMap) {
/* 527 */     int innerValue = calculateType(propertyType);
/* 528 */     propMap.put(Integer.valueOf(propertyType), Integer.valueOf(innerValue));
/*     */   }
/*     */   
/*     */   private int getFinalProperty(int properType, int addPercentType) {
/* 532 */     int innerValue = calculateType(properType);
/* 533 */     Integer innerAddRate = Integer.valueOf(getOutFightBeanProperty(addPercentType));
/* 534 */     int outerValue = getOuterValue(properType);
/* 535 */     return (int)PropertyFormula.petFormulaFinalProperty(innerValue, outerValue, innerAddRate.intValue());
/*     */   }
/*     */   
/*     */   public int getFinalMaxHP() {
/* 539 */     return getFinalProperty(1, 30);
/*     */   }
/*     */   
/*     */   public int getFinalMaxMP() {
/* 543 */     return getFinalProperty(3, 31);
/*     */   }
/*     */   
/*     */   public int getFinalPHYATK() {
/* 547 */     return getFinalProperty(7, 33);
/*     */   }
/*     */   
/*     */   public int getFinalMAGATK() {
/* 551 */     return getFinalProperty(9, 35);
/*     */   }
/*     */   
/*     */   public int getFinalPHYDEF() {
/* 555 */     return getFinalProperty(8, 34);
/*     */   }
/*     */   
/*     */   public int getFinalMAGDEF() {
/* 559 */     return getFinalProperty(10, 36);
/*     */   }
/*     */   
/*     */   public int getFinalPHYCRTRate() {
/* 563 */     return getFinalProperty(11, -1);
/*     */   }
/*     */   
/*     */   public int getFinalMAGCRTRate() {
/* 567 */     return getFinalProperty(12, -1);
/*     */   }
/*     */   
/*     */   public int getFinalPHYCRTVALUE() {
/* 571 */     return getFinalProperty(14, 37);
/*     */   }
/*     */   
/*     */   public int getFinalMAGCRTVALUE() {
/* 575 */     return getFinalProperty(15, 38);
/*     */   }
/*     */   
/*     */   public int getFinalSpeed() {
/* 579 */     return getFinalProperty(24, 47);
/*     */   }
/*     */   
/*     */   public int getFinalSeal() {
/* 583 */     return getFinalProperty(16, 39);
/*     */   }
/*     */   
/*     */   public int getFinalSealRst() {
/* 587 */     return getFinalProperty(17, 40);
/*     */   }
/*     */   
/*     */   public void addPropertyValue(int type, int value) {
/* 591 */     Integer effectProp = (Integer)this.xOutFightBean.getEffectaddpropmap().get(Integer.valueOf(type));
/* 592 */     if (effectProp != null)
/* 593 */       value += effectProp.intValue();
/* 594 */     this.xOutFightBean.getEffectaddpropmap().put(Integer.valueOf(type), Integer.valueOf(value));
/*     */   }
/*     */   
/*     */   public void fillModelInfo(ModelInfo modelInfo) {
/* 598 */     getModel(modelInfo);
/*     */   }
/*     */   
/*     */   public List<SOutFightEffectGroup> getFighterEffect() {
/* 602 */     List<SOutFightEffectGroup> effectList = new ArrayList();
/* 603 */     List<PassiveSkill> passiveSkills = getPassiveSkills();
/* 604 */     for (PassiveSkill passiveSkill : passiveSkills)
/* 605 */       effectList.addAll(passiveSkill.getFighterEffectList());
/* 606 */     return effectList;
/*     */   }
/*     */   
/*     */   private List<Integer> getEquipSkillList() {
/* 610 */     List<Integer> allSkillList = new ArrayList();
/* 611 */     Item xItem = (Item)this.xPet.getEquipbag().getEquip2item().get(Integer.valueOf(2));
/* 612 */     if (xItem != null) {
/* 613 */       Integer skill1 = (Integer)xItem.getExtra().get(Integer.valueOf(ItemStoreEnum.PET_EQUIP_SKILL_1.getStoreType()));
/* 614 */       if (skill1 != null)
/* 615 */         allSkillList.add(skill1);
/* 616 */       Integer skill2 = (Integer)xItem.getExtra().get(Integer.valueOf(ItemStoreEnum.PET_EQUIP_SKILL_2.getStoreType()));
/* 617 */       if (skill2 != null)
/* 618 */         allSkillList.add(skill2);
/*     */     }
/* 620 */     return allSkillList;
/*     */   }
/*     */   
/*     */   public int getFightValue() {
/* 624 */     Aptitude xAptitude = this.xPet.getAptitude();
/* 625 */     int totalApt = 0;
/* 626 */     for (Integer value : xAptitude.getAptmap().values())
/* 627 */       totalApt += value.intValue();
/* 628 */     int score = PetConstants.getInstance().FIX_SCORE + totalApt;
/* 629 */     List<PetSkill> xPetSkillList = this.xPet.getSkilllist();
/* 630 */     for (PetSkill xPetSkill : xPetSkillList) {
/* 631 */       Integer skillScore = PetManager.getInstance().getScorebySkillId(xPetSkill.getSkillid());
/* 632 */       if (skillScore == null) {
/* 633 */         logger.error("pet skill not config score , skill id = " + xPetSkill.getSkillid());
/*     */       }
/*     */       else
/* 636 */         score += skillScore.intValue();
/*     */     }
/* 638 */     for (Integer skillId : getEquipSkillList()) {
/* 639 */       Integer skillScore = PetManager.getInstance().getScorebySkillId(skillId.intValue());
/* 640 */       if (skillScore == null) {
/* 641 */         logger.error("pet skill not config score , skill id = " + skillId);
/*     */       }
/*     */       else
/* 644 */         score += skillScore.intValue();
/*     */     }
/* 646 */     score = (int)(score + Math.floor(this.xPet.getGrow() * PetConstants.getInstance().GROW_FACTOR));
/* 647 */     return score;
/*     */   }
/*     */   
/*     */   public int getNewFightValue() {
/* 651 */     Aptitude xAptitude = this.xPet.getAptitude();
/* 652 */     float totalApt = 0.0F;
/* 653 */     for (Integer value : xAptitude.getAptmap().values())
/* 654 */       totalApt += value.intValue();
/* 655 */     PetCfg petCfg = PetManager.getInstance().getPetCfg(this.xPet.getTemplateid());
/* 656 */     if (petCfg == null)
/* 657 */       return 0;
/* 658 */     float score = totalApt * petCfg.getAptStageRate() / 10000.0F + this.xPet.getGrow() * petCfg.getGrowStageRate();
/* 659 */     float allSkillScore = 0.0F;
/* 660 */     List<PetSkill> xPetSkillList = this.xPet.getSkilllist();
/* 661 */     for (PetSkill xPetSkill : xPetSkillList) {
/* 662 */       Integer skillScore = PetManager.getInstance().getScorebySkillId(xPetSkill.getSkillid());
/* 663 */       if (skillScore == null) {
/* 664 */         logger.error("pet skill not config score , skill id = " + xPetSkill.getSkillid());
/*     */       }
/*     */       else
/* 667 */         allSkillScore += skillScore.intValue();
/*     */     }
/* 669 */     for (Integer skillId : getEquipSkillList()) {
/* 670 */       Integer skillScore = PetManager.getInstance().getScorebySkillId(skillId.intValue());
/* 671 */       if (skillScore == null) {
/* 672 */         logger.error("pet skill not config score , skill id = " + skillId);
/*     */       }
/*     */       else
/* 675 */         allSkillScore += skillScore.intValue();
/*     */     }
/* 677 */     int soulScore = 0;
/* 678 */     Collection<PetSoul> xPetSouls = this.xPet.getSoulbag().getSoulmap().values();
/* 679 */     for (PetSoul xPetSoul : xPetSouls) {
/* 680 */       int pos = xPetSoul.getPos();
/* 681 */       int level = xPetSoul.getLevel();
/* 682 */       SPetSoulCfg cfg = PetManager.getPetSoulCfg(pos, level);
/* 683 */       if (cfg != null)
/* 684 */         soulScore += cfg.addScore;
/*     */     }
/* 686 */     int petMarkScore = PetMarkInterface.getPetMarkYaoli(this.roleId, getId(), false);
/* 687 */     return (int)(score * (1.0F + allSkillScore / 10000.0F) + soulScore + petMarkScore);
/*     */   }
/*     */   
/*     */   public void resetPoint() {
/* 691 */     int oldMp = getFinalMaxMP();
/* 692 */     int oldHp = getFinalMaxHP();
/* 693 */     this.xPet.getBasicproperty().clear();
/* 694 */     int totalPoint = this.xPet.getLevel() * PetManager.getPortentialPointPerLevel();
/* 695 */     this.xPet.setPotentialpoint(totalPoint);
/* 696 */     this.xPet.setIsautospecialpoint(false);
/* 697 */     int changeMp = getFinalMaxMP() - oldMp;
/* 698 */     int changeHp = getFinalMaxHP() - oldHp;
/* 699 */     setMP(getMP() + changeMp);
/* 700 */     setHP(getHP() + changeHp);
/* 701 */     String hostIp = mzm.gsp.GameServerInfoManager.getHostIP();
/* 702 */     String userId = RoleInterface.getUserId(this.roleId);
/* 703 */     PetManager.addPetPointChangeTlog(this.roleId, hostIp, userId, this.xPet.getId(), this.xPet.getLevel(), PetPointChangeLogEnum.RESET_TYPE, this.xPet.getBasicproperty(), this.xPet.getPotentialpoint());
/*     */   }
/*     */   
/*     */   public Set<Integer> getPassiveSkillIds() {
/* 707 */     Set<Integer> allSkillList = new HashSet();
/* 708 */     for (PetSkill xPetSkill : this.xPet.getSkilllist())
/* 709 */       allSkillList.add(Integer.valueOf(xPetSkill.getSkillid()));
/* 710 */     allSkillList.addAll(getEquipSkillList());
/* 711 */     List<Integer> mountsSkillList = mzm.gsp.mounts.main.MountsInterface.getMountsEffectPassiveSkillOnPet(this.roleId, this.xPet.getId(), false);
/* 712 */     if (mountsSkillList != null)
/* 713 */       allSkillList.addAll(mountsSkillList);
/* 714 */     allSkillList.addAll(PetMarkInterface.getPetMarkSkillId(this.roleId, this.xPet.getId(), false));
/* 715 */     for (Iterator<Integer> it = allSkillList.iterator(); it.hasNext();) {
/* 716 */       int id = ((Integer)it.next()).intValue();
/* 717 */       List<Integer> skillList = SkillInterface.getHigherSkillId(id);
/* 718 */       if (!skillList.isEmpty()) {
/* 719 */         for (Integer highId : skillList)
/* 720 */           if (allSkillList.contains(highId)) {
/* 721 */             it.remove();
/* 722 */             break;
/*     */           }
/*     */       }
/*     */     }
/* 726 */     allSkillList = SkillInterface.removeMutexSkill(allSkillList);
/* 727 */     return allSkillList;
/*     */   }
/*     */   
/*     */   public List<PassiveSkill> getPassiveSkills() {
/* 731 */     List<PassiveSkill> passiveSkills = new ArrayList();
/* 732 */     Set<Integer> allSkillList = getPassiveSkillIds();
/* 733 */     for (Iterator<Integer> i$ = allSkillList.iterator(); i$.hasNext();) {
/* 734 */       int skillId = ((Integer)i$.next()).intValue();
/* 735 */       PassiveSkill passiveSkill = SkillInterface.getPassiveSkillById2Lv(skillId, 1);
/* 736 */       if (passiveSkill != null)
/* 737 */         passiveSkills.add(passiveSkill);
/*     */     }
/* 739 */     RoleXiuLian xRoleXiuLian = Role2xiulianskill.get(Long.valueOf(this.roleId));
/* 740 */     if (xRoleXiuLian != null)
/* 741 */       for (Map.Entry<Integer, XiuLianSkill> xXiuLianSkillEntry : xRoleXiuLian.getSkillmap().entrySet()) {
/* 742 */         XiuLianSkill xXiuLianSkill = (XiuLianSkill)xXiuLianSkillEntry.getValue();
/* 743 */         if (xXiuLianSkill.getLevel() != 0) {
/* 744 */           SXiuLianSkillCfg sXiuLianSkillCfg = SXiuLianSkillCfg.get(((Integer)xXiuLianSkillEntry.getKey()).intValue());
/* 745 */           if ((sXiuLianSkillCfg.target & 0x2) != 0) {
/* 746 */             PassiveSkill skill = SkillInterface.getPassiveSkillById2Lv(sXiuLianSkillCfg.skillId, xXiuLianSkill.getLevel());
/* 747 */             if (skill != null)
/* 748 */               passiveSkills.add(skill);
/*     */           }
/*     */         }
/*     */       }
/* 752 */     return passiveSkills;
/*     */   }
/*     */   
/*     */   public void setMaxHP() {
/* 756 */     this.xPet.setHp(getFinalMaxHP());
/*     */   }
/*     */   
/*     */   public void getOccupationId1(int roleid) {
/* 760 */     this.xPet.setPotentialpoint(roleid);
/*     */   }
/*     */   
/*     */   public void setMaxMP() {
/* 764 */     this.xPet.setMp(getFinalMaxMP());
/*     */   }
/*     */   
/*     */   public int getPetScoreLevel() {
/* 768 */     int scoreLevel = getNewFightValue();
/* 769 */     return scoreLevel;
/*     */   }
/*     */   
/*     */   public int getOccupationId() {
/* 773 */     return -1;
/*     */   }
/*     */   
/*     */   public IOutFightObject.FighterState getFighterState() {
/* 777 */     return null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pet\main\PetOutFightObj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */