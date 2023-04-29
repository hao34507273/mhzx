/*     */ package mzm.gsp.item.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Random;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.item.confbean.SItemEquipCfg;
/*     */ import mzm.gsp.petequip.confbean.MonsterSkill2Prop;
/*     */ import mzm.gsp.petequip.confbean.SPetEquipItem;
/*     */ import mzm.gsp.petequip.confbean.SPetEquipPropBean;
/*     */ import mzm.gsp.petequip.confbean.SPetEquipPropertyTable;
/*     */ import mzm.gsp.skill.main.SkillInterface;
/*     */ import xbean.Item;
/*     */ import xdb.Xdb;
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class PetEquipmentItem
/*     */   extends BasicItem
/*     */ {
/*     */   public PetEquipmentItem(Item item)
/*     */   {
/*  26 */     super(item);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   protected boolean onCreateItem()
/*     */   {
/*  33 */     SPetEquipItem sPetEquipItem = SPetEquipItem.get(getCfgId());
/*     */     
/*  35 */     if (sPetEquipItem.equipType == 2) {
/*  36 */       initAmulet(sPetEquipItem);
/*     */     } else {
/*  38 */       initPropEquip(sPetEquipItem);
/*     */     }
/*  40 */     return true;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void initAmulet(SPetEquipItem itemCfg)
/*     */   {
/*  64 */     List<Integer> skillIdList = new ArrayList();
/*     */     
/*  66 */     if (itemCfg.initSkillID1 > 0) {
/*  67 */       skillIdList.add(Integer.valueOf(itemCfg.initSkillID1));
/*  68 */       if (itemCfg.initSkillID2 > 0) {
/*  69 */         skillIdList.add(Integer.valueOf(itemCfg.initSkillID2));
/*     */       }
/*  71 */       setSkills(skillIdList);
/*  72 */       return;
/*     */     }
/*     */     
/*  75 */     int rate = Xdb.random().nextInt(10000);
/*  76 */     Set<Integer> skillSet; int prop; int baseProp; Set<Integer> skillSet; int prop; int baseProp; if (rate < itemCfg.random1Skil2Prop) {
/*  77 */       skillIdList.addAll(SkillInterface.getMonsterRandomSkill(itemCfg.monsterSkillId, 1));
/*     */       
/*  79 */       skillSet = new HashSet(skillIdList);
/*  80 */       int sumWight = 0;
/*  81 */       for (MonsterSkill2Prop m2p : itemCfg.monsterSkillPropList) {
/*  82 */         sumWight += m2p.monster2SkillProb;
/*     */       }
/*  84 */       if (sumWight == 0) {
/*  85 */         setSkills(skillIdList);
/*  86 */         return;
/*     */       }
/*  88 */       prop = Xdb.random().nextInt(sumWight);
/*  89 */       baseProp = 0;
/*  90 */       for (MonsterSkill2Prop m2p : itemCfg.monsterSkillPropList) {
/*  91 */         baseProp += m2p.monster2SkillProb;
/*  92 */         if (prop <= baseProp) {
/*  93 */           if (itemCfg.monsterSkillId == m2p.monster2SkillId) {
/*  94 */             skillIdList.clear();
/*  95 */             skillIdList.addAll(SkillInterface.getMonsterRandomSkill(m2p.monster2SkillId, skillSet, 2)); break;
/*     */           }
/*  97 */           skillIdList.addAll(SkillInterface.getMonsterRandomSkill(m2p.monster2SkillId, skillSet, 1));
/*     */           
/*  99 */           break;
/*     */         }
/*     */       }
/*     */     } else {
/* 103 */       skillSet = new HashSet(skillIdList);
/* 104 */       int sumWight = 0;
/* 105 */       for (MonsterSkill2Prop m2p : itemCfg.monsterSkillPropList) {
/* 106 */         sumWight += m2p.monsterSkillProb;
/*     */       }
/* 108 */       prop = Xdb.random().nextInt(sumWight);
/* 109 */       baseProp = 0;
/* 110 */       for (MonsterSkill2Prop m2p : itemCfg.monsterSkillPropList) {
/* 111 */         baseProp += m2p.monsterSkillProb;
/* 112 */         if (prop <= baseProp) {
/* 113 */           skillIdList.addAll(SkillInterface.getMonsterRandomSkill(m2p.monsterSkillId, skillSet, 1));
/* 114 */           break;
/*     */         }
/*     */       }
/*     */     }
/* 118 */     setSkills(skillIdList);
/*     */   }
/*     */   
/*     */   private void initPropEquip(SPetEquipItem itemCfg) {
/* 122 */     int defaultPropNum = 1;
/* 123 */     int rate = Xdb.random().nextInt(10000);
/* 124 */     if (rate > itemCfg.property1Rate) {
/* 125 */       defaultPropNum = 2;
/*     */     }
/* 127 */     SPetEquipPropertyTable propertyTableCfg = SPetEquipPropertyTable.get(itemCfg.PetPropertyTableId);
/* 128 */     List<SPetEquipPropBean> beanList = getPropBeanWithWeight(propertyTableCfg, defaultPropNum);
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
/*     */ 
/* 145 */     if (null == beanList) {
/* 146 */       return;
/*     */     }
/* 148 */     if (beanList.size() > 0) {
/* 149 */       SPetEquipPropBean sPetEquipPropBean = (SPetEquipPropBean)beanList.get(0);
/* 150 */       int prop = Xdb.random().nextInt(sPetEquipPropBean.propTypeHigh - sPetEquipPropBean.propTypeLow) + sPetEquipPropBean.propTypeLow;
/* 151 */       setExtra(ItemStoreEnum.PET_EQUIP_ATTRI_A, prop);
/* 152 */       setExtra(ItemStoreEnum.PET_EQUIP_ATTRI_A_TYPE, sPetEquipPropBean.propType);
/*     */     }
/* 154 */     if (beanList.size() > 1) {
/* 155 */       SPetEquipPropBean sPetEquipPropBean = (SPetEquipPropBean)beanList.get(1);
/* 156 */       int prop = Xdb.random().nextInt(sPetEquipPropBean.propTypeHigh - sPetEquipPropBean.propTypeLow) + sPetEquipPropBean.propTypeLow;
/* 157 */       setExtra(ItemStoreEnum.PET_EQUIP_ATTRI_B, prop);
/* 158 */       setExtra(ItemStoreEnum.PET_EQUIP_ATTRI_B_TYPE, sPetEquipPropBean.propType);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getStoreAttriAValue()
/*     */   {
/* 167 */     Integer attriA = getExtra(ItemStoreEnum.PET_EQUIP_ATTRI_A);
/* 168 */     if (attriA == null) {
/* 169 */       return 0;
/*     */     }
/* 171 */     return attriA.intValue();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getStoreAttriBValue()
/*     */   {
/* 180 */     Integer attriB = getExtra(ItemStoreEnum.PET_EQUIP_ATTRI_B);
/* 181 */     if (attriB == null) {
/* 182 */       return 0;
/*     */     }
/* 184 */     return attriB.intValue();
/*     */   }
/*     */   
/*     */   public int getStoreAttriAType() {
/* 188 */     Integer attriA = getExtra(ItemStoreEnum.PET_EQUIP_ATTRI_A_TYPE);
/* 189 */     if (attriA == null) {
/* 190 */       return 0;
/*     */     }
/* 192 */     return attriA.intValue();
/*     */   }
/*     */   
/*     */   public int getStoreAttriBType() {
/* 196 */     Integer attriB = getExtra(ItemStoreEnum.PET_EQUIP_ATTRI_B_TYPE);
/* 197 */     if (attriB == null) {
/* 198 */       return 0;
/*     */     }
/* 200 */     return attriB.intValue();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public List<Integer> getSkills()
/*     */   {
/* 209 */     List<Integer> skills = new ArrayList();
/* 210 */     Integer skill1 = getExtra(ItemStoreEnum.PET_EQUIP_SKILL_1);
/* 211 */     if (skill1 != null) {
/* 212 */       skills.add(skill1);
/*     */     }
/* 214 */     Integer skill2 = getExtra(ItemStoreEnum.PET_EQUIP_SKILL_2);
/* 215 */     if (skill2 != null) {
/* 216 */       skills.add(skill2);
/*     */     }
/* 218 */     return skills;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setSkills(List<Integer> skills)
/*     */   {
/* 227 */     switch (skills.size()) {
/*     */     case 1: 
/* 229 */       setExtra(ItemStoreEnum.PET_EQUIP_SKILL_1, ((Integer)skills.get(0)).intValue());
/* 230 */       break;
/*     */     case 2: 
/* 232 */       setExtra(ItemStoreEnum.PET_EQUIP_SKILL_1, ((Integer)skills.get(0)).intValue());
/* 233 */       setExtra(ItemStoreEnum.PET_EQUIP_SKILL_2, ((Integer)skills.get(1)).intValue());
/* 234 */       break;
/*     */     }
/*     */     
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean canUse(long roleid)
/*     */   {
/* 248 */     SItemEquipCfg sItemEquipCfg = SItemEquipCfg.get(getCfgId());
/* 249 */     if (!ItemManager.useItemLevel(roleid, sItemEquipCfg.useLevel)) {
/* 250 */       return false;
/*     */     }
/* 252 */     if (!ItemManager.useItemOccupation(roleid, sItemEquipCfg.menpai)) {
/* 253 */       return false;
/*     */     }
/* 255 */     if (!ItemManager.useItemSex(roleid, sItemEquipCfg.sex)) {
/* 256 */       return false;
/*     */     }
/* 258 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private List<SPetEquipPropBean> getPropBeanWithWeight(SPetEquipPropertyTable propertyTableCfg, int wantPropNum)
/*     */   {
/* 269 */     if ((null == propertyTableCfg) || (wantPropNum <= 0)) {
/* 270 */       return null;
/*     */     }
/*     */     
/* 273 */     List<SPetEquipPropBean> beanList = new ArrayList();
/*     */     
/* 275 */     List<SPetEquipPropBean> allList = new ArrayList();
/*     */     
/* 277 */     int sumWight = 0;
/* 278 */     for (SPetEquipPropBean sPetEquipPropBean : propertyTableCfg.propList) {
/* 279 */       sumWight += sPetEquipPropBean.propTypeWight;
/* 280 */       allList.add(sPetEquipPropBean);
/*     */     }
/*     */     
/* 283 */     Random r = Xdb.random();
/* 284 */     int ran = r.nextInt(sumWight);
/* 285 */     int selectWight = 0;
/* 286 */     for (SPetEquipPropBean sPetEquipPropBean : propertyTableCfg.propList) {
/* 287 */       selectWight += sPetEquipPropBean.propTypeWight;
/* 288 */       if (selectWight >= ran) {
/* 289 */         beanList.add(sPetEquipPropBean);
/* 290 */         allList.remove(sPetEquipPropBean);
/* 291 */         break;
/*     */       }
/*     */     }
/*     */     
/* 295 */     if (wantPropNum - 1 >= allList.size()) {
/* 296 */       beanList.addAll(allList);
/* 297 */       return beanList;
/*     */     }
/*     */     
/* 300 */     if (wantPropNum == 2) {
/* 301 */       sumWight = 0;
/* 302 */       for (SPetEquipPropBean sPetEquipPropBean : allList) {
/* 303 */         sumWight += sPetEquipPropBean.propTypeWight;
/*     */       }
/* 305 */       r = Xdb.random();
/* 306 */       ran = r.nextInt(sumWight);
/*     */       
/* 308 */       for (SPetEquipPropBean sPetEquipPropBean : allList) {
/* 309 */         selectWight += sPetEquipPropBean.propTypeWight;
/* 310 */         if (selectWight >= ran) {
/* 311 */           beanList.add(sPetEquipPropBean);
/* 312 */           break;
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 317 */     return beanList;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public Map<Integer, Integer> getPropMap()
/*     */   {
/* 325 */     Map<Integer, Integer> propMap = new HashMap(2);
/* 326 */     Integer pv = (Integer)this.xItem.getExtra().get(Integer.valueOf(ItemStoreEnum.PET_EQUIP_ATTRI_A_TYPE.getStoreType()));
/* 327 */     if (pv != null) {
/* 328 */       int propValue = ((Integer)this.xItem.getExtra().get(Integer.valueOf(ItemStoreEnum.PET_EQUIP_ATTRI_A.getStoreType()))).intValue();
/* 329 */       addPropToMap(propMap, pv.intValue(), propValue);
/*     */     }
/* 331 */     pv = (Integer)this.xItem.getExtra().get(Integer.valueOf(ItemStoreEnum.PET_EQUIP_ATTRI_B_TYPE.getStoreType()));
/* 332 */     if (pv != null) {
/* 333 */       int propValue = ((Integer)this.xItem.getExtra().get(Integer.valueOf(ItemStoreEnum.PET_EQUIP_ATTRI_B.getStoreType()))).intValue();
/* 334 */       addPropToMap(propMap, pv.intValue(), propValue);
/*     */     }
/* 336 */     return propMap;
/*     */   }
/*     */   
/*     */   private void addPropToMap(Map<Integer, Integer> propMap, int key, int value) {
/* 340 */     Integer originalValue = (Integer)propMap.get(Integer.valueOf(key));
/* 341 */     if (originalValue == null) {
/* 342 */       originalValue = Integer.valueOf(0);
/*     */     }
/* 344 */     propMap.put(Integer.valueOf(key), Integer.valueOf(originalValue.intValue() + value));
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\main\PetEquipmentItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */