/*     */ package mzm.gsp.pet.main;
/*     */ 
/*     */ import java.util.Random;
/*     */ import mzm.gsp.pet.confbean.AptRandomRegion;
/*     */ import mzm.gsp.pet.confbean.SPetAptRandomCfg;
/*     */ import mzm.gsp.pet.confbean.SPetCfg;
/*     */ import mzm.gsp.pet.confbean.SPetExp2Level;
/*     */ import mzm.gsp.pet.confbean.SPetTypeCfg;
/*     */ import mzm.gsp.pet.confbean.STPet2Prop;
/*     */ import xdb.Xdb;
/*     */ 
/*     */ public class PetCfg
/*     */ {
/*     */   private final int sPetCfgId;
/*     */   
/*     */   public PetCfg(int sPetCfgId)
/*     */   {
/*  18 */     this.sPetCfgId = sPetCfgId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SPetCfg getsPetCfg()
/*     */   {
/*  27 */     SPetCfg sPetCfg = SPetCfg.get(this.sPetCfgId);
/*  28 */     if (sPetCfg == null) {
/*  29 */       PetManager.logDebug("PetCfg.getsPetCfg@petcfg not find in cfg!|petid=%d", new Object[] { Integer.valueOf(this.sPetCfgId) });
/*     */     }
/*  31 */     return sPetCfg;
/*     */   }
/*     */   
/*     */   public int getLife() {
/*  35 */     if (getsPetCfg().bornMaxLife == 0) {
/*  36 */       return -1;
/*     */     }
/*  38 */     if (getsPetCfg().bornMaxLife == getsPetCfg().bornMinLife) {
/*  39 */       return getsPetCfg().bornMaxLife;
/*     */     }
/*  41 */     return Xdb.random().nextInt(getsPetCfg().bornMaxLife - getsPetCfg().bornMinLife) + getsPetCfg().bornMinLife;
/*     */   }
/*     */   
/*     */   public int getBuyPrice() {
/*  45 */     return getsPetCfg().buyPrice;
/*     */   }
/*     */   
/*     */   public int getColorId() {
/*  49 */     return getsPetCfg().colorId;
/*     */   }
/*     */   
/*     */   public float getGrow() {
/*  53 */     float factor = 1000.0F;
/*  54 */     int max = (int)(getsPetCfg().growMaxLimit * factor);
/*  55 */     int min = (int)(getsPetCfg().growMinLimit * factor);
/*  56 */     if (max == min) {
/*  57 */       return (float)getsPetCfg().growMinLimit;
/*     */     }
/*  59 */     int random = Xdb.random().nextInt(max - min) + min;
/*  60 */     return random / factor;
/*     */   }
/*     */   
/*     */   public String getDefaultName()
/*     */   {
/*  65 */     return getsPetCfg().name;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getPetType()
/*     */   {
/*  74 */     return getsPetCfg().type;
/*     */   }
/*     */   
/*     */   public boolean isBaoBao() {
/*  78 */     return getsPetCfg().type == 1;
/*     */   }
/*     */   
/*     */   public boolean isWild() {
/*  82 */     return getsPetCfg().type == 0;
/*     */   }
/*     */   
/*     */   public boolean isBianYi() {
/*  86 */     return getsPetCfg().type == 2;
/*     */   }
/*     */   
/*     */   public boolean isShenShou() {
/*  90 */     return getsPetCfg().type == 3;
/*     */   }
/*     */   
/*     */   public boolean isMoShou() {
/*  94 */     return getsPetCfg().type == 4;
/*     */   }
/*     */   
/*     */   public float getBornProp(int propType) {
/*  98 */     STPet2Prop stPet2Prop = STPet2Prop.get(this.sPetCfgId);
/*  99 */     if (stPet2Prop == null) {
/* 100 */       return 0.0F;
/*     */     }
/* 102 */     Double propVal = (Double)stPet2Prop.bornPropMap.get(Integer.valueOf(propType));
/* 103 */     if (propVal == null) {
/* 104 */       return 0.0F;
/*     */     }
/* 106 */     return propVal.floatValue();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   void init() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public int getUptoLevelNeedExp(int level)
/*     */   {
/* 118 */     SPetExp2Level sExp2Level = SPetExp2Level.get(level);
/* 119 */     return sExp2Level.needExp;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getTotalExpWithLevel(int level)
/*     */   {
/* 128 */     int total = 0;
/* 129 */     for (int i = 1; i <= level; i++) {
/* 130 */       SPetExp2Level sExp2Level = SPetExp2Level.get(level);
/* 131 */       total += sExp2Level.needExp;
/*     */     }
/* 133 */     return total;
/*     */   }
/*     */   
/*     */   public String getName() {
/* 137 */     return getsPetCfg().name;
/*     */   }
/*     */   
/*     */   public int getId() {
/* 141 */     return getsPetCfg().templateId;
/*     */   }
/*     */   
/*     */   public Integer getMaxApt(int aptType) {
/* 145 */     STPet2Prop stPet2Prop = STPet2Prop.get(this.sPetCfgId);
/* 146 */     if (stPet2Prop == null) {
/* 147 */       return null;
/*     */     }
/* 149 */     return (Integer)stPet2Prop.maxZiZhiLimit.get(Integer.valueOf(aptType));
/*     */   }
/*     */   
/*     */   public Integer getMinApt(int aptType) {
/* 153 */     STPet2Prop stPet2Prop = STPet2Prop.get(this.sPetCfgId);
/* 154 */     if (stPet2Prop == null) {
/* 155 */       return null;
/*     */     }
/* 157 */     return (Integer)stPet2Prop.minZiZhiLimit.get(Integer.valueOf(aptType));
/*     */   }
/*     */   
/*     */   public int getModelId() {
/* 161 */     return getsPetCfg().modelId;
/*     */   }
/*     */   
/*     */   public int getRandomAptLimit(int aptType) {
/* 165 */     Integer maxApt = getMaxApt(aptType);
/* 166 */     Integer minApt = getMinApt(aptType);
/* 167 */     if ((maxApt == null) || (minApt == null)) {
/* 168 */       return 0;
/*     */     }
/* 170 */     if (maxApt == minApt) {
/* 171 */       return minApt.intValue();
/*     */     }
/* 173 */     long dis = maxApt.intValue() - minApt.intValue();
/*     */     
/* 175 */     int prop = Xdb.random().nextInt(10000);
/* 176 */     int baseProp = 0;
/* 177 */     AptRandomRegion randomRegion = null;
/* 178 */     SPetAptRandomCfg aptLimitRandomCfg = SPetAptRandomCfg.get(getsPetCfg().petAptLimitRate);
/* 179 */     for (AptRandomRegion arr : aptLimitRandomCfg.aptRandomList) {
/* 180 */       baseProp += arr.AptProb;
/* 181 */       if (prop <= baseProp) {
/* 182 */         randomRegion = arr;
/* 183 */         break;
/*     */       }
/*     */     }
/* 186 */     if (randomRegion == null) {
/* 187 */       return 0;
/*     */     }
/* 189 */     int randomRate = randomRegion.AptLowLimit;
/* 190 */     if (randomRegion.AptLowLimit < randomRegion.AptHighLimit) {
/* 191 */       randomRate += Xdb.random().nextInt(randomRegion.AptHighLimit - randomRegion.AptLowLimit);
/*     */     }
/* 193 */     return (int)(minApt.intValue() + dis * randomRate / 10000L);
/*     */   }
/*     */   
/*     */   public int getRandomApt(int aptType, int maxApt) {
/* 197 */     int minApt = getMinApt(aptType).intValue();
/* 198 */     if (maxApt == minApt) {
/* 199 */       return minApt;
/*     */     }
/*     */     
/* 202 */     long dis = maxApt - minApt;
/* 203 */     int prop = Xdb.random().nextInt(10000);
/* 204 */     int baseProp = 0;
/* 205 */     AptRandomRegion randomRegion = null;
/* 206 */     SPetAptRandomCfg aptRealRandomCfg = SPetAptRandomCfg.get(getsPetCfg().petAptRate);
/* 207 */     for (AptRandomRegion arr : aptRealRandomCfg.aptRandomList) {
/* 208 */       baseProp += arr.AptProb;
/* 209 */       if (prop <= baseProp) {
/* 210 */         randomRegion = arr;
/* 211 */         break;
/*     */       }
/*     */     }
/* 214 */     if (randomRegion == null) {
/* 215 */       return 0;
/*     */     }
/* 217 */     int randomRate = randomRegion.AptLowLimit;
/* 218 */     if (randomRegion.AptLowLimit < randomRegion.AptHighLimit) {
/* 219 */       randomRate += Xdb.random().nextInt(randomRegion.AptHighLimit - randomRegion.AptLowLimit);
/*     */     }
/* 221 */     return (int)(minApt + dis * randomRate / 10000L);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getCarrayLevel()
/*     */   {
/* 229 */     return getsPetCfg().catchLevel;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getPetDecorateId()
/*     */   {
/* 237 */     return getsPetCfg().PetDecorateRef;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public java.util.List<Integer> getBornSkillList()
/*     */   {
/* 245 */     return mzm.gsp.skill.main.SkillInterface.getMonsterRandomSkill(getsPetCfg().skillPropTabId);
/*     */   }
/*     */   
/*     */   public int getMonsterSkillId() {
/* 249 */     return getsPetCfg().skillPropTabId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean isSpecial()
/*     */   {
/* 257 */     return getsPetCfg().isSpecial;
/*     */   }
/*     */   
/*     */   public boolean isCanBeMainPet() {
/* 261 */     return getsPetCfg().isCanBeHuaShengMainPet;
/*     */   }
/*     */   
/*     */   public boolean isCanBeFuPet() {
/* 265 */     return getsPetCfg().isCanBeHuaShengFuPet;
/*     */   }
/*     */   
/*     */   public float getMaxGrow() {
/* 269 */     return (float)getsPetCfg().growMaxLimit;
/*     */   }
/*     */   
/*     */   public int getFanShengBaoBaoId() {
/* 273 */     SPetTypeCfg petTypeCfg = SPetTypeCfg.get(getsPetCfg().PetTypeIdRef);
/* 274 */     return petTypeCfg.baobaoId;
/*     */   }
/*     */   
/*     */   public int getFanShengBianYiId() {
/* 278 */     SPetTypeCfg petTypeCfg = SPetTypeCfg.get(getsPetCfg().PetTypeIdRef);
/* 279 */     return petTypeCfg.bianYiId;
/*     */   }
/*     */   
/*     */   public int getPetFanSHengConfId() {
/* 283 */     return getsPetCfg().petFanSHengConfId;
/*     */   }
/*     */   
/*     */   public boolean getIsAutoSetPoint() {
/* 287 */     return getsPetCfg().isAutoSetPoint;
/*     */   }
/*     */   
/*     */   public int getAptStageRate() {
/* 291 */     return getsPetCfg().aptStageRate;
/*     */   }
/*     */   
/*     */   public int getGrowStageRate() {
/* 295 */     return getsPetCfg().growStageRate;
/*     */   }
/*     */   
/*     */   public int getPetScoreConfId() {
/* 299 */     return getsPetCfg().petScoreConfId;
/*     */   }
/*     */   
/*     */   public int getYaoliLevel() {
/* 303 */     return getsPetCfg().yaoliLevel;
/*     */   }
/*     */   
/*     */   public int getGrowItemLimit() {
/* 307 */     return getsPetCfg().growItemLimit;
/*     */   }
/*     */   
/*     */ 
/* 311 */   public int getLianguItemLimit() { return getsPetCfg().lianguItemLimit; }
/*     */   
/*     */   public mzm.gsp.occupation.confbean.SDefaultAddPointCase getdefaultPetPointCfg() {
/* 314 */     if (getsPetCfg().defaultPetPointCfg == 0) {
/* 315 */       return null;
/*     */     }
/* 317 */     mzm.gsp.occupation.confbean.SDefaultAddPointCase sDefaultAddPointCase = mzm.gsp.occupation.confbean.SDefaultAddPointCase.get(getsPetCfg().defaultPetPointCfg);
/* 318 */     return sDefaultAddPointCase;
/*     */   }
/*     */   
/*     */   public int getFanshengBianyiNum() {
/* 322 */     return getsPetCfg().fanshengBianyiNum;
/*     */   }
/*     */   
/*     */   public int getHuiJuanItemId() {
/* 326 */     return getsPetCfg().huijuanItemId;
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
/*     */   float getProperty(int type, int level)
/*     */   {
/* 347 */     if (type == 25)
/* 348 */       return (float)(getBornProp(type) + level * getsPetCfg().addStrPerLevel);
/* 349 */     if (type == 27)
/* 350 */       return (float)(getBornProp(type) + level * getsPetCfg().addSprPerLevel);
/* 351 */     if (type == 28)
/* 352 */       return (float)(getBornProp(type) + level * getsPetCfg().addConPerLevel);
/* 353 */     if (type == 29)
/* 354 */       return (float)(getBornProp(type) + level * getsPetCfg().addStaPerLevel);
/* 355 */     if (type == 26) {
/* 356 */       return (float)(getBornProp(type) + level * getsPetCfg().addDexPerLevel);
/*     */     }
/*     */     
/* 359 */     mzm.gsp.pet.confbean.STPetLevel2value stPetLevel2value = mzm.gsp.pet.confbean.STPetLevel2value.get(level);
/* 360 */     if (stPetLevel2value == null)
/*     */     {
/* 362 */       mzm.gsp.GameServer.logger().error(String.format("[pet]stPetLevel2value.getProperty@ no this level data!|level=%d", new Object[] { Integer.valueOf(level) }));
/* 363 */       return 0.0F;
/*     */     }
/* 365 */     java.util.Map<Integer, Double> propMap = stPetLevel2value.valueMap;
/* 366 */     if (propMap == null)
/*     */     {
/* 368 */       return 0.0F;
/*     */     }
/* 370 */     Double propValue = (Double)propMap.get(Integer.valueOf(type));
/* 371 */     if (propValue == null)
/*     */     {
/* 373 */       return 0.0F;
/*     */     }
/* 375 */     if ((type == 1) || (type == 3) || (type == 7) || (type == 8) || (type == 9) || (type == 10) || (type == 24)) {
/* 376 */       return propValue.floatValue();
/*     */     }
/*     */     
/* 379 */     if ((type == 14) || (type == 15)) {
/* 380 */       return propValue.floatValue();
/*     */     }
/*     */     
/* 383 */     return getBornProp(type) + propValue.floatValue();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   int calculateType(int level, int propertyType)
/*     */   {
/* 394 */     float propValue = 0.0F;
/* 395 */     propValue += getProperty(propertyType, level);
/* 396 */     mzm.gsp.pet.confbean.STPetTransformProp stTransformProp = mzm.gsp.pet.confbean.STPetTransformProp.get(propertyType);
/* 397 */     if (stTransformProp != null)
/*     */     {
/* 399 */       java.util.Map<Integer, Double> baseTransform = stTransformProp.basePro2value;
/* 400 */       java.util.Iterator<java.util.Map.Entry<Integer, Double>> it = baseTransform.entrySet().iterator();
/* 401 */       while (it.hasNext())
/*     */       {
/* 403 */         java.util.Map.Entry<Integer, Double> entry = (java.util.Map.Entry)it.next();
/* 404 */         propValue += getProperty(((Integer)entry.getKey()).intValue(), level) * ((Double)entry.getValue()).floatValue();
/*     */       }
/*     */     }
/* 407 */     return Math.round(propValue * 100.0F) / 100;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pet\main\PetCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */