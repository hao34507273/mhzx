/*     */ package mzm.gsp.pet.confbean;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.dom4j.Element;
/*     */ import org.dom4j.io.SAXReader;
/*     */ 
/*     */ public class SPetCfg implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*  14 */   private static volatile Map<Integer, SPetCfg> oldAll = null;
/*     */   
/*  16 */   private static Map<Integer, SPetCfg> all = null;
/*     */   
/*     */   public int templateId;
/*     */   public String name;
/*     */   public int type;
/*     */   public int catchLevel;
/*     */   public int pet_open_idip_switch;
/*     */   public int buyPrice;
/*     */   public boolean isSpecial;
/*     */   public int bornMinLife;
/*     */   public int bornMaxLife;
/*     */   public int modelId;
/*     */   public int colorId;
/*     */   public double growMinLimit;
/*     */   public double growMaxLimit;
/*     */   public boolean isCanBeHuaShengMainPet;
/*     */   public boolean isCanBeHuaShengFuPet;
/*     */   public int bornStr;
/*     */   public int bornDex;
/*     */   public int bornSpr;
/*     */   public int bornCon;
/*     */   public int bornSta;
/*     */   public int minHPApt;
/*     */   public int minPhyAtkApt;
/*     */   public int minPhyDefApt;
/*     */   public int minMagAtkApt;
/*     */   public int minMagDefApt;
/*     */   public int minSpdApt;
/*     */   public int maxHPApt;
/*     */   public int maxPhyAtkApt;
/*     */   public int maxPhyDefApt;
/*     */   public int maxMagAtkApt;
/*     */   public int maxMagDefApt;
/*     */   public int maxSpdApt;
/*     */   public double bornMaxHP;
/*     */   public double bornMaxMp;
/*     */   public double bornPhyAtk;
/*     */   public double bornPhyDef;
/*     */   public double bornMagAtk;
/*     */   public double bornMagDef;
/*     */   public double bornSealHitLevel;
/*     */   public double bornSealResLevel;
/*     */   public double bornPhyHitLevel;
/*     */   public double bornPhyDodgeLevel;
/*     */   public double bornMagHitLevel;
/*     */   public double bornMagDodogeLevel;
/*     */   public double PHY_CRT_LEVEL;
/*     */   public double MAG_CRT_LEVEL;
/*     */   public double PHY_CRT_DEF_LEVEL;
/*     */   public double MAG_CRT_DEF_LEVEL;
/*     */   public int bornPhyCrtRate;
/*     */   public int bornMagCrtRate;
/*     */   public int bornPhyCrtValue;
/*     */   public int bornMagCrtValue;
/*     */   public double bornSpeed;
/*     */   public double PHY_CRT_LEVEL_PER_LEVEL;
/*     */   public double MAG_CRT_LEVEL_PER_LEVEL;
/*     */   public double PHY_CRT_LEVEL_DEF_PER_LEVEL;
/*     */   public double MAG_CRT_LEVEL_DEF_PER_LEVEL;
/*     */   public int level2propertyId;
/*     */   public int skillPropTabId;
/*     */   public int PetTypeIdRef;
/*     */   public int PetDecorateRef;
/*     */   public int defaultPetPointCfg;
/*     */   public int petAptLimitRate;
/*     */   public int petAptRate;
/*     */   public int petFanSHengConfId;
/*     */   public boolean isAutoSetPoint;
/*     */   public int aptStageRate;
/*     */   public int growStageRate;
/*     */   public int petScoreConfId;
/*     */   public int yaoliLevel;
/*     */   public int lianguItemLimit;
/*     */   public int growItemLimit;
/*     */   public double addStrPerLevel;
/*     */   public double addDexPerLevel;
/*     */   public double addSprPerLevel;
/*     */   public double addConPerLevel;
/*     */   public double addStaPerLevel;
/*     */   public int fanshengBianyiNum;
/*     */   public int huijuanItemId;
/*     */   public int change_model_card_class_type;
/*     */   public int change_model_card_level;
/*     */   
/*     */   public void loadFromXml(Element rootElement)
/*     */   {
/* 102 */     this.templateId = Integer.valueOf(rootElement.attributeValue("templateId")).intValue();
/* 103 */     this.name = rootElement.attributeValue("name");
/* 104 */     this.type = Integer.valueOf(rootElement.attributeValue("type")).intValue();
/* 105 */     this.catchLevel = Integer.valueOf(rootElement.attributeValue("catchLevel")).intValue();
/* 106 */     this.pet_open_idip_switch = Integer.valueOf(rootElement.attributeValue("pet_open_idip_switch")).intValue();
/* 107 */     this.buyPrice = Integer.valueOf(rootElement.attributeValue("buyPrice")).intValue();
/* 108 */     this.isSpecial = Boolean.valueOf(rootElement.attributeValue("isSpecial")).booleanValue();
/* 109 */     this.bornMinLife = Integer.valueOf(rootElement.attributeValue("bornMinLife")).intValue();
/* 110 */     this.bornMaxLife = Integer.valueOf(rootElement.attributeValue("bornMaxLife")).intValue();
/* 111 */     this.modelId = Integer.valueOf(rootElement.attributeValue("modelId")).intValue();
/* 112 */     this.colorId = Integer.valueOf(rootElement.attributeValue("colorId")).intValue();
/* 113 */     this.growMinLimit = Double.valueOf(rootElement.attributeValue("growMinLimit")).doubleValue();
/* 114 */     this.growMaxLimit = Double.valueOf(rootElement.attributeValue("growMaxLimit")).doubleValue();
/* 115 */     this.isCanBeHuaShengMainPet = Boolean.valueOf(rootElement.attributeValue("isCanBeHuaShengMainPet")).booleanValue();
/* 116 */     this.isCanBeHuaShengFuPet = Boolean.valueOf(rootElement.attributeValue("isCanBeHuaShengFuPet")).booleanValue();
/* 117 */     this.bornStr = Integer.valueOf(rootElement.attributeValue("bornStr")).intValue();
/* 118 */     this.bornDex = Integer.valueOf(rootElement.attributeValue("bornDex")).intValue();
/* 119 */     this.bornSpr = Integer.valueOf(rootElement.attributeValue("bornSpr")).intValue();
/* 120 */     this.bornCon = Integer.valueOf(rootElement.attributeValue("bornCon")).intValue();
/* 121 */     this.bornSta = Integer.valueOf(rootElement.attributeValue("bornSta")).intValue();
/* 122 */     this.minHPApt = Integer.valueOf(rootElement.attributeValue("minHPApt")).intValue();
/* 123 */     this.minPhyAtkApt = Integer.valueOf(rootElement.attributeValue("minPhyAtkApt")).intValue();
/* 124 */     this.minPhyDefApt = Integer.valueOf(rootElement.attributeValue("minPhyDefApt")).intValue();
/* 125 */     this.minMagAtkApt = Integer.valueOf(rootElement.attributeValue("minMagAtkApt")).intValue();
/* 126 */     this.minMagDefApt = Integer.valueOf(rootElement.attributeValue("minMagDefApt")).intValue();
/* 127 */     this.minSpdApt = Integer.valueOf(rootElement.attributeValue("minSpdApt")).intValue();
/* 128 */     this.maxHPApt = Integer.valueOf(rootElement.attributeValue("maxHPApt")).intValue();
/* 129 */     this.maxPhyAtkApt = Integer.valueOf(rootElement.attributeValue("maxPhyAtkApt")).intValue();
/* 130 */     this.maxPhyDefApt = Integer.valueOf(rootElement.attributeValue("maxPhyDefApt")).intValue();
/* 131 */     this.maxMagAtkApt = Integer.valueOf(rootElement.attributeValue("maxMagAtkApt")).intValue();
/* 132 */     this.maxMagDefApt = Integer.valueOf(rootElement.attributeValue("maxMagDefApt")).intValue();
/* 133 */     this.maxSpdApt = Integer.valueOf(rootElement.attributeValue("maxSpdApt")).intValue();
/* 134 */     this.bornMaxHP = Double.valueOf(rootElement.attributeValue("bornMaxHP")).doubleValue();
/* 135 */     this.bornMaxMp = Double.valueOf(rootElement.attributeValue("bornMaxMp")).doubleValue();
/* 136 */     this.bornPhyAtk = Double.valueOf(rootElement.attributeValue("bornPhyAtk")).doubleValue();
/* 137 */     this.bornPhyDef = Double.valueOf(rootElement.attributeValue("bornPhyDef")).doubleValue();
/* 138 */     this.bornMagAtk = Double.valueOf(rootElement.attributeValue("bornMagAtk")).doubleValue();
/* 139 */     this.bornMagDef = Double.valueOf(rootElement.attributeValue("bornMagDef")).doubleValue();
/* 140 */     this.bornSealHitLevel = Double.valueOf(rootElement.attributeValue("bornSealHitLevel")).doubleValue();
/* 141 */     this.bornSealResLevel = Double.valueOf(rootElement.attributeValue("bornSealResLevel")).doubleValue();
/* 142 */     this.bornPhyHitLevel = Double.valueOf(rootElement.attributeValue("bornPhyHitLevel")).doubleValue();
/* 143 */     this.bornPhyDodgeLevel = Double.valueOf(rootElement.attributeValue("bornPhyDodgeLevel")).doubleValue();
/* 144 */     this.bornMagHitLevel = Double.valueOf(rootElement.attributeValue("bornMagHitLevel")).doubleValue();
/* 145 */     this.bornMagDodogeLevel = Double.valueOf(rootElement.attributeValue("bornMagDodogeLevel")).doubleValue();
/* 146 */     this.PHY_CRT_LEVEL = Double.valueOf(rootElement.attributeValue("PHY_CRT_LEVEL")).doubleValue();
/* 147 */     this.MAG_CRT_LEVEL = Double.valueOf(rootElement.attributeValue("MAG_CRT_LEVEL")).doubleValue();
/* 148 */     this.PHY_CRT_DEF_LEVEL = Double.valueOf(rootElement.attributeValue("PHY_CRT_DEF_LEVEL")).doubleValue();
/* 149 */     this.MAG_CRT_DEF_LEVEL = Double.valueOf(rootElement.attributeValue("MAG_CRT_DEF_LEVEL")).doubleValue();
/* 150 */     this.bornPhyCrtRate = Integer.valueOf(rootElement.attributeValue("bornPhyCrtRate")).intValue();
/* 151 */     this.bornMagCrtRate = Integer.valueOf(rootElement.attributeValue("bornMagCrtRate")).intValue();
/* 152 */     this.bornPhyCrtValue = Integer.valueOf(rootElement.attributeValue("bornPhyCrtValue")).intValue();
/* 153 */     this.bornMagCrtValue = Integer.valueOf(rootElement.attributeValue("bornMagCrtValue")).intValue();
/* 154 */     this.bornSpeed = Double.valueOf(rootElement.attributeValue("bornSpeed")).doubleValue();
/* 155 */     this.PHY_CRT_LEVEL_PER_LEVEL = Double.valueOf(rootElement.attributeValue("PHY_CRT_LEVEL_PER_LEVEL")).doubleValue();
/* 156 */     this.MAG_CRT_LEVEL_PER_LEVEL = Double.valueOf(rootElement.attributeValue("MAG_CRT_LEVEL_PER_LEVEL")).doubleValue();
/* 157 */     this.PHY_CRT_LEVEL_DEF_PER_LEVEL = Double.valueOf(rootElement.attributeValue("PHY_CRT_LEVEL_DEF_PER_LEVEL")).doubleValue();
/* 158 */     this.MAG_CRT_LEVEL_DEF_PER_LEVEL = Double.valueOf(rootElement.attributeValue("MAG_CRT_LEVEL_DEF_PER_LEVEL")).doubleValue();
/* 159 */     this.level2propertyId = Integer.valueOf(rootElement.attributeValue("level2propertyId")).intValue();
/* 160 */     this.skillPropTabId = Integer.valueOf(rootElement.attributeValue("skillPropTabId")).intValue();
/* 161 */     this.PetTypeIdRef = Integer.valueOf(rootElement.attributeValue("PetTypeIdRef")).intValue();
/* 162 */     this.PetDecorateRef = Integer.valueOf(rootElement.attributeValue("PetDecorateRef")).intValue();
/* 163 */     this.defaultPetPointCfg = Integer.valueOf(rootElement.attributeValue("defaultPetPointCfg")).intValue();
/* 164 */     this.petAptLimitRate = Integer.valueOf(rootElement.attributeValue("petAptLimitRate")).intValue();
/* 165 */     this.petAptRate = Integer.valueOf(rootElement.attributeValue("petAptRate")).intValue();
/* 166 */     this.petFanSHengConfId = Integer.valueOf(rootElement.attributeValue("petFanSHengConfId")).intValue();
/* 167 */     this.isAutoSetPoint = Boolean.valueOf(rootElement.attributeValue("isAutoSetPoint")).booleanValue();
/* 168 */     this.aptStageRate = Integer.valueOf(rootElement.attributeValue("aptStageRate")).intValue();
/* 169 */     this.growStageRate = Integer.valueOf(rootElement.attributeValue("growStageRate")).intValue();
/* 170 */     this.petScoreConfId = Integer.valueOf(rootElement.attributeValue("petScoreConfId")).intValue();
/* 171 */     this.yaoliLevel = Integer.valueOf(rootElement.attributeValue("yaoliLevel")).intValue();
/* 172 */     this.lianguItemLimit = Integer.valueOf(rootElement.attributeValue("lianguItemLimit")).intValue();
/* 173 */     this.growItemLimit = Integer.valueOf(rootElement.attributeValue("growItemLimit")).intValue();
/* 174 */     this.addStrPerLevel = Double.valueOf(rootElement.attributeValue("addStrPerLevel")).doubleValue();
/* 175 */     this.addDexPerLevel = Double.valueOf(rootElement.attributeValue("addDexPerLevel")).doubleValue();
/* 176 */     this.addSprPerLevel = Double.valueOf(rootElement.attributeValue("addSprPerLevel")).doubleValue();
/* 177 */     this.addConPerLevel = Double.valueOf(rootElement.attributeValue("addConPerLevel")).doubleValue();
/* 178 */     this.addStaPerLevel = Double.valueOf(rootElement.attributeValue("addStaPerLevel")).doubleValue();
/* 179 */     this.fanshengBianyiNum = Integer.valueOf(rootElement.attributeValue("fanshengBianyiNum")).intValue();
/* 180 */     this.huijuanItemId = Integer.valueOf(rootElement.attributeValue("huijuanItemId")).intValue();
/* 181 */     this.change_model_card_class_type = Integer.valueOf(rootElement.attributeValue("change_model_card_class_type")).intValue();
/* 182 */     this.change_model_card_level = Integer.valueOf(rootElement.attributeValue("change_model_card_level")).intValue();
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_)
/*     */   {
/* 187 */     _os_.marshal(this.templateId);
/* 188 */     _os_.marshal(this.name, "UTF-8");
/* 189 */     _os_.marshal(this.type);
/* 190 */     _os_.marshal(this.catchLevel);
/* 191 */     _os_.marshal(this.pet_open_idip_switch);
/* 192 */     _os_.marshal(this.buyPrice);
/* 193 */     _os_.marshal(this.isSpecial);
/* 194 */     _os_.marshal(this.bornMinLife);
/* 195 */     _os_.marshal(this.bornMaxLife);
/* 196 */     _os_.marshal(this.modelId);
/* 197 */     _os_.marshal(this.colorId);
/* 198 */     _os_.marshal(this.growMinLimit);
/* 199 */     _os_.marshal(this.growMaxLimit);
/* 200 */     _os_.marshal(this.isCanBeHuaShengMainPet);
/* 201 */     _os_.marshal(this.isCanBeHuaShengFuPet);
/* 202 */     _os_.marshal(this.bornStr);
/* 203 */     _os_.marshal(this.bornDex);
/* 204 */     _os_.marshal(this.bornSpr);
/* 205 */     _os_.marshal(this.bornCon);
/* 206 */     _os_.marshal(this.bornSta);
/* 207 */     _os_.marshal(this.minHPApt);
/* 208 */     _os_.marshal(this.minPhyAtkApt);
/* 209 */     _os_.marshal(this.minPhyDefApt);
/* 210 */     _os_.marshal(this.minMagAtkApt);
/* 211 */     _os_.marshal(this.minMagDefApt);
/* 212 */     _os_.marshal(this.minSpdApt);
/* 213 */     _os_.marshal(this.maxHPApt);
/* 214 */     _os_.marshal(this.maxPhyAtkApt);
/* 215 */     _os_.marshal(this.maxPhyDefApt);
/* 216 */     _os_.marshal(this.maxMagAtkApt);
/* 217 */     _os_.marshal(this.maxMagDefApt);
/* 218 */     _os_.marshal(this.maxSpdApt);
/* 219 */     _os_.marshal(this.bornMaxHP);
/* 220 */     _os_.marshal(this.bornMaxMp);
/* 221 */     _os_.marshal(this.bornPhyAtk);
/* 222 */     _os_.marshal(this.bornPhyDef);
/* 223 */     _os_.marshal(this.bornMagAtk);
/* 224 */     _os_.marshal(this.bornMagDef);
/* 225 */     _os_.marshal(this.bornSealHitLevel);
/* 226 */     _os_.marshal(this.bornSealResLevel);
/* 227 */     _os_.marshal(this.bornPhyHitLevel);
/* 228 */     _os_.marshal(this.bornPhyDodgeLevel);
/* 229 */     _os_.marshal(this.bornMagHitLevel);
/* 230 */     _os_.marshal(this.bornMagDodogeLevel);
/* 231 */     _os_.marshal(this.PHY_CRT_LEVEL);
/* 232 */     _os_.marshal(this.MAG_CRT_LEVEL);
/* 233 */     _os_.marshal(this.PHY_CRT_DEF_LEVEL);
/* 234 */     _os_.marshal(this.MAG_CRT_DEF_LEVEL);
/* 235 */     _os_.marshal(this.bornPhyCrtRate);
/* 236 */     _os_.marshal(this.bornMagCrtRate);
/* 237 */     _os_.marshal(this.bornPhyCrtValue);
/* 238 */     _os_.marshal(this.bornMagCrtValue);
/* 239 */     _os_.marshal(this.bornSpeed);
/* 240 */     _os_.marshal(this.PHY_CRT_LEVEL_PER_LEVEL);
/* 241 */     _os_.marshal(this.MAG_CRT_LEVEL_PER_LEVEL);
/* 242 */     _os_.marshal(this.PHY_CRT_LEVEL_DEF_PER_LEVEL);
/* 243 */     _os_.marshal(this.MAG_CRT_LEVEL_DEF_PER_LEVEL);
/* 244 */     _os_.marshal(this.level2propertyId);
/* 245 */     _os_.marshal(this.skillPropTabId);
/* 246 */     _os_.marshal(this.PetTypeIdRef);
/* 247 */     _os_.marshal(this.PetDecorateRef);
/* 248 */     _os_.marshal(this.defaultPetPointCfg);
/* 249 */     _os_.marshal(this.petAptLimitRate);
/* 250 */     _os_.marshal(this.petAptRate);
/* 251 */     _os_.marshal(this.petFanSHengConfId);
/* 252 */     _os_.marshal(this.isAutoSetPoint);
/* 253 */     _os_.marshal(this.aptStageRate);
/* 254 */     _os_.marshal(this.growStageRate);
/* 255 */     _os_.marshal(this.petScoreConfId);
/* 256 */     _os_.marshal(this.yaoliLevel);
/* 257 */     _os_.marshal(this.lianguItemLimit);
/* 258 */     _os_.marshal(this.growItemLimit);
/* 259 */     _os_.marshal(this.addStrPerLevel);
/* 260 */     _os_.marshal(this.addDexPerLevel);
/* 261 */     _os_.marshal(this.addSprPerLevel);
/* 262 */     _os_.marshal(this.addConPerLevel);
/* 263 */     _os_.marshal(this.addStaPerLevel);
/* 264 */     _os_.marshal(this.fanshengBianyiNum);
/* 265 */     _os_.marshal(this.huijuanItemId);
/* 266 */     _os_.marshal(this.change_model_card_class_type);
/* 267 */     _os_.marshal(this.change_model_card_level);
/* 268 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/* 273 */     this.templateId = _os_.unmarshal_int();
/* 274 */     this.name = _os_.unmarshal_String("UTF-8");
/* 275 */     this.type = _os_.unmarshal_int();
/* 276 */     this.catchLevel = _os_.unmarshal_int();
/* 277 */     this.pet_open_idip_switch = _os_.unmarshal_int();
/* 278 */     this.buyPrice = _os_.unmarshal_int();
/* 279 */     this.isSpecial = _os_.unmarshal_boolean();
/* 280 */     this.bornMinLife = _os_.unmarshal_int();
/* 281 */     this.bornMaxLife = _os_.unmarshal_int();
/* 282 */     this.modelId = _os_.unmarshal_int();
/* 283 */     this.colorId = _os_.unmarshal_int();
/* 284 */     this.growMinLimit = _os_.unmarshal_float();
/* 285 */     this.growMaxLimit = _os_.unmarshal_float();
/* 286 */     this.isCanBeHuaShengMainPet = _os_.unmarshal_boolean();
/* 287 */     this.isCanBeHuaShengFuPet = _os_.unmarshal_boolean();
/* 288 */     this.bornStr = _os_.unmarshal_int();
/* 289 */     this.bornDex = _os_.unmarshal_int();
/* 290 */     this.bornSpr = _os_.unmarshal_int();
/* 291 */     this.bornCon = _os_.unmarshal_int();
/* 292 */     this.bornSta = _os_.unmarshal_int();
/* 293 */     this.minHPApt = _os_.unmarshal_int();
/* 294 */     this.minPhyAtkApt = _os_.unmarshal_int();
/* 295 */     this.minPhyDefApt = _os_.unmarshal_int();
/* 296 */     this.minMagAtkApt = _os_.unmarshal_int();
/* 297 */     this.minMagDefApt = _os_.unmarshal_int();
/* 298 */     this.minSpdApt = _os_.unmarshal_int();
/* 299 */     this.maxHPApt = _os_.unmarshal_int();
/* 300 */     this.maxPhyAtkApt = _os_.unmarshal_int();
/* 301 */     this.maxPhyDefApt = _os_.unmarshal_int();
/* 302 */     this.maxMagAtkApt = _os_.unmarshal_int();
/* 303 */     this.maxMagDefApt = _os_.unmarshal_int();
/* 304 */     this.maxSpdApt = _os_.unmarshal_int();
/* 305 */     this.bornMaxHP = _os_.unmarshal_float();
/* 306 */     this.bornMaxMp = _os_.unmarshal_float();
/* 307 */     this.bornPhyAtk = _os_.unmarshal_float();
/* 308 */     this.bornPhyDef = _os_.unmarshal_float();
/* 309 */     this.bornMagAtk = _os_.unmarshal_float();
/* 310 */     this.bornMagDef = _os_.unmarshal_float();
/* 311 */     this.bornSealHitLevel = _os_.unmarshal_float();
/* 312 */     this.bornSealResLevel = _os_.unmarshal_float();
/* 313 */     this.bornPhyHitLevel = _os_.unmarshal_float();
/* 314 */     this.bornPhyDodgeLevel = _os_.unmarshal_float();
/* 315 */     this.bornMagHitLevel = _os_.unmarshal_float();
/* 316 */     this.bornMagDodogeLevel = _os_.unmarshal_float();
/* 317 */     this.PHY_CRT_LEVEL = _os_.unmarshal_float();
/* 318 */     this.MAG_CRT_LEVEL = _os_.unmarshal_float();
/* 319 */     this.PHY_CRT_DEF_LEVEL = _os_.unmarshal_float();
/* 320 */     this.MAG_CRT_DEF_LEVEL = _os_.unmarshal_float();
/* 321 */     this.bornPhyCrtRate = _os_.unmarshal_int();
/* 322 */     this.bornMagCrtRate = _os_.unmarshal_int();
/* 323 */     this.bornPhyCrtValue = _os_.unmarshal_int();
/* 324 */     this.bornMagCrtValue = _os_.unmarshal_int();
/* 325 */     this.bornSpeed = _os_.unmarshal_float();
/* 326 */     this.PHY_CRT_LEVEL_PER_LEVEL = _os_.unmarshal_float();
/* 327 */     this.MAG_CRT_LEVEL_PER_LEVEL = _os_.unmarshal_float();
/* 328 */     this.PHY_CRT_LEVEL_DEF_PER_LEVEL = _os_.unmarshal_float();
/* 329 */     this.MAG_CRT_LEVEL_DEF_PER_LEVEL = _os_.unmarshal_float();
/* 330 */     this.level2propertyId = _os_.unmarshal_int();
/* 331 */     this.skillPropTabId = _os_.unmarshal_int();
/* 332 */     this.PetTypeIdRef = _os_.unmarshal_int();
/* 333 */     this.PetDecorateRef = _os_.unmarshal_int();
/* 334 */     this.defaultPetPointCfg = _os_.unmarshal_int();
/* 335 */     this.petAptLimitRate = _os_.unmarshal_int();
/* 336 */     this.petAptRate = _os_.unmarshal_int();
/* 337 */     this.petFanSHengConfId = _os_.unmarshal_int();
/* 338 */     this.isAutoSetPoint = _os_.unmarshal_boolean();
/* 339 */     this.aptStageRate = _os_.unmarshal_int();
/* 340 */     this.growStageRate = _os_.unmarshal_int();
/* 341 */     this.petScoreConfId = _os_.unmarshal_int();
/* 342 */     this.yaoliLevel = _os_.unmarshal_int();
/* 343 */     this.lianguItemLimit = _os_.unmarshal_int();
/* 344 */     this.growItemLimit = _os_.unmarshal_int();
/* 345 */     this.addStrPerLevel = _os_.unmarshal_float();
/* 346 */     this.addDexPerLevel = _os_.unmarshal_float();
/* 347 */     this.addSprPerLevel = _os_.unmarshal_float();
/* 348 */     this.addConPerLevel = _os_.unmarshal_float();
/* 349 */     this.addStaPerLevel = _os_.unmarshal_float();
/* 350 */     this.fanshengBianyiNum = _os_.unmarshal_int();
/* 351 */     this.huijuanItemId = _os_.unmarshal_int();
/* 352 */     this.change_model_card_class_type = _os_.unmarshal_int();
/* 353 */     this.change_model_card_level = _os_.unmarshal_int();
/* 354 */     return _os_;
/*     */   }
/*     */   
/*     */   public static void loadXml(String dir)
/*     */   {
/* 359 */     String path = dir + "mzm.gsp.pet.confbean.SPetCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 363 */       all = new java.util.HashMap();
/* 364 */       SAXReader reader = new SAXReader();
/* 365 */       org.dom4j.Document doc = reader.read(new File(path));
/* 366 */       Element root = doc.getRootElement();
/* 367 */       List<?> nodeList = root.elements();
/* 368 */       int len = nodeList.size();
/* 369 */       for (int i = 0; i < len; i++)
/*     */       {
/* 371 */         Element elem = (Element)nodeList.get(i);
/* 372 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.pet.confbean.SPetCfg"))
/*     */         {
/*     */ 
/* 375 */           SPetCfg obj = new SPetCfg();
/* 376 */           obj.loadFromXml(elem);
/* 377 */           if (all.put(Integer.valueOf(obj.templateId), obj) != null) {
/* 378 */             throw new RuntimeException("duplicate key : " + obj.templateId);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 383 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void reLoadXml(String dir, Map<Integer, SPetCfg> all)
/*     */   {
/* 389 */     String path = dir + "mzm.gsp.pet.confbean.SPetCfg.xml";
/*     */     
/*     */     try
/*     */     {
/* 393 */       SAXReader reader = new SAXReader();
/* 394 */       org.dom4j.Document doc = reader.read(new File(path));
/* 395 */       Element root = doc.getRootElement();
/* 396 */       List<?> nodeList = root.elements();
/* 397 */       int len = nodeList.size();
/* 398 */       for (int i = 0; i < len; i++)
/*     */       {
/* 400 */         Element elem = (Element)nodeList.get(i);
/* 401 */         if (elem.getName().equalsIgnoreCase("mzm.gsp.pet.confbean.SPetCfg"))
/*     */         {
/*     */ 
/* 404 */           SPetCfg obj = new SPetCfg();
/* 405 */           obj.loadFromXml(elem);
/* 406 */           if (all.put(Integer.valueOf(obj.templateId), obj) != null) {
/* 407 */             throw new RuntimeException("duplicate key : " + obj.templateId);
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Exception e) {
/* 412 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void loadBny(String dir)
/*     */   {
/* 418 */     all = new java.util.HashMap();
/*     */     
/* 420 */     String path = dir + "mzm.gsp.pet.confbean.SPetCfg.bny";
/*     */     try
/*     */     {
/* 423 */       File file = new File(path);
/* 424 */       if (file.exists())
/*     */       {
/* 426 */         byte[] bytes = new byte['Ѐ'];
/* 427 */         FileInputStream fis = new FileInputStream(file);
/* 428 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 429 */         int len = 0;
/* 430 */         while ((len = fis.read(bytes)) > 0)
/* 431 */           baos.write(bytes, 0, len);
/* 432 */         fis.close();
/* 433 */         bytes = baos.toByteArray();
/* 434 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 435 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 437 */           _os_.unmarshal_int();
/* 438 */           _os_.unmarshal_int();
/* 439 */           _os_.unmarshal_int();
/*     */         }
/* 441 */         _os_.unmarshal_int();
/* 442 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 445 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 447 */           SPetCfg _v_ = new SPetCfg();
/* 448 */           _v_.unmarshal(_os_);
/* 449 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 450 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 455 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 460 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void reLoadBny(String dir, Map<Integer, SPetCfg> all)
/*     */   {
/* 467 */     String path = dir + "mzm.gsp.pet.confbean.SPetCfg.bny";
/*     */     try
/*     */     {
/* 470 */       File file = new File(path);
/* 471 */       if (file.exists())
/*     */       {
/* 473 */         byte[] bytes = new byte['Ѐ'];
/* 474 */         FileInputStream fis = new FileInputStream(file);
/* 475 */         ByteArrayOutputStream baos = new ByteArrayOutputStream();
/* 476 */         int len = 0;
/* 477 */         while ((len = fis.read(bytes)) > 0)
/* 478 */           baos.write(bytes, 0, len);
/* 479 */         fis.close();
/* 480 */         bytes = baos.toByteArray();
/* 481 */         OctetsStream _os_ = OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(bytes));
/* 482 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/* 484 */           _os_.unmarshal_int();
/* 485 */           _os_.unmarshal_int();
/* 486 */           _os_.unmarshal_int();
/*     */         }
/* 488 */         _os_.unmarshal_int();
/* 489 */         for (int i = _os_.uncompact_uint32(); i > 0; i--)
/*     */         {
/*     */ 
/* 492 */           int _k_ = _os_.unmarshal_int();
/*     */           
/* 494 */           SPetCfg _v_ = new SPetCfg();
/* 495 */           _v_.unmarshal(_os_);
/* 496 */           if (all.put(Integer.valueOf(_k_), _v_) != null) {
/* 497 */             throw new RuntimeException("duplicate key : " + _k_);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 502 */         throw new RuntimeException("file not exist : " + path);
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 507 */       throw new RuntimeException("load " + path + " failed", e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static SPetCfg getOld(int key)
/*     */   {
/* 515 */     return (SPetCfg)oldAll.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static SPetCfg get(int key)
/*     */   {
/* 520 */     return (SPetCfg)all.get(Integer.valueOf(key));
/*     */   }
/*     */   
/*     */   public static Map<Integer, SPetCfg> getOldAll()
/*     */   {
/* 525 */     return oldAll;
/*     */   }
/*     */   
/*     */   public static Map<Integer, SPetCfg> getAll()
/*     */   {
/* 530 */     return all;
/*     */   }
/*     */   
/*     */   public static void setAll(Map<Integer, SPetCfg> newAll)
/*     */   {
/* 535 */     oldAll = all;
/* 536 */     all = newAll;
/*     */   }
/*     */   
/*     */   public static void resetOldAll()
/*     */   {
/* 541 */     oldAll = null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pet\confbean\SPetCfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */