/*     */ package mzm.gsp.role.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.common.confbean.STPropertyScoreCfg;
/*     */ import mzm.gsp.item.confbean.SItemEquipCfg;
/*     */ import mzm.gsp.occupation.confbean.RoleCommonConstants;
/*     */ import mzm.gsp.occupation.confbean.SDefaultAddPointCase;
/*     */ import mzm.gsp.occupation.confbean.SOccupationPropTable;
/*     */ import mzm.gsp.occupation.confbean.SRoleBornEquipCfg;
/*     */ import mzm.gsp.occupation.confbean.SRoleCreateCfg;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.role.main.expression.ExpressionManager;
/*     */ import mzm.gsp.role.main.expression.IExpression;
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
/*     */ public class Occupation
/*     */ {
/*  37 */   private Map<Integer, Map<Integer, Integer>> propMap = new HashMap();
/*     */   
/*     */ 
/*     */ 
/*  41 */   private Map<Integer, Integer> leveltoFightValueMap = new HashMap();
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private int id;
/*     */   
/*     */ 
/*     */ 
/*  50 */   private static Map<Integer, Map<Integer, Float>> transformPropMap = new HashMap();
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private IExpression[] potentialExpression;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private RoleExpConfig roleExpConfig;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  65 */   private List<Integer> bornEquipList = new ArrayList();
/*     */   
/*     */   private int defaultAddPointCaseId;
/*     */   
/*     */   private int defaultRoleCreateRoleId;
/*     */   
/*     */   private int occupationType;
/*     */   
/*     */   private int switchId;
/*     */   
/*     */   private int defaultAvatarId;
/*     */   
/*     */   public Occupation(int id, String name)
/*     */   {
/*  79 */     this.id = id;
/*  80 */     SOccupationPropTable ocp = SOccupationPropTable.get(id);
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  87 */     this.defaultAddPointCaseId = ocp.addPointCaseId;
/*  88 */     this.occupationType = ocp.occupationType;
/*  89 */     this.switchId = ocp.switchId;
/*  90 */     this.defaultAvatarId = ocp.defaultAvatarId;
/*  91 */     for (SRoleCreateCfg cfg : SRoleCreateCfg.getAll().values())
/*     */     {
/*  93 */       if ((cfg.occupationId == ocp.occupationId) && (cfg.gender == ocp.gender))
/*     */       {
/*  95 */         this.defaultRoleCreateRoleId = cfg.id;
/*  96 */         break;
/*     */       }
/*     */     }
/*  99 */     if (this.defaultAddPointCaseId == 0)
/*     */     {
/* 101 */       throw new RuntimeException("角色职业找不到默认加点方案 occupationId " + id);
/*     */     }
/*     */   }
/*     */   
/*     */   void initBornEquip()
/*     */   {
/* 107 */     int gender = getGender();
/* 108 */     int ocpId = getId();
/* 109 */     for (SRoleBornEquipCfg cfg : SRoleBornEquipCfg.getAll().values())
/*     */     {
/* 111 */       if ((ocpId == cfg.occupationId) && (gender == cfg.gender))
/*     */       {
/* 113 */         checkEquip(cfg.weaponId, 0);
/* 114 */         checkEquip(cfg.clothId, 1);
/* 115 */         checkEquip(cfg.beltId, 3);
/* 116 */         checkEquip(cfg.hatId, 2);
/* 117 */         checkEquip(cfg.shoeId, 5);
/* 118 */         checkEquip(cfg.wristerId, 4);
/* 119 */         break;
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void checkEquip(int equipId, int pos)
/*     */   {
/* 132 */     if (equipId == 0)
/*     */     {
/* 134 */       return;
/*     */     }
/* 136 */     SItemEquipCfg equipCfg = (SItemEquipCfg)SItemEquipCfg.getAllSelf().get(Integer.valueOf(equipId));
/* 137 */     int ocpId = getId();
/* 138 */     int sex = getGender();
/* 139 */     if ((equipCfg.wearpos != 0) || (equipCfg.wearpos != pos))
/*     */     {
/* 141 */       if (((equipCfg.menpai != 0) && (equipCfg.menpai != ocpId)) || ((equipCfg.sex != 0) && (equipCfg.sex != sex)))
/*     */       {
/*     */ 
/* 144 */         throw new RuntimeException(String.format("init born equipment error, occupation name = %s , equipId = %d", new Object[] { getName(), Integer.valueOf(equipId) }));
/*     */       }
/*     */     }
/*     */     
/* 148 */     this.bornEquipList.add(Integer.valueOf(equipId));
/*     */   }
/*     */   
/*     */   public int getGender()
/*     */   {
/* 153 */     return SOccupationPropTable.get(this.id).gender;
/*     */   }
/*     */   
/*     */   public int getModelId()
/*     */   {
/* 158 */     return SOccupationPropTable.get(this.id).modelPath;
/*     */   }
/*     */   
/*     */   public void setExpConfig(RoleExpConfig expConfig)
/*     */   {
/* 163 */     this.roleExpConfig = expConfig;
/*     */   }
/*     */   
/*     */   public boolean isRoleOpen()
/*     */   {
/* 168 */     return SRoleCreateCfg.get(this.defaultRoleCreateRoleId).isOpen;
/*     */   }
/*     */   
/*     */   public int getHairColorId()
/*     */   {
/* 173 */     return SRoleCreateCfg.get(this.defaultRoleCreateRoleId).DEFAULT_HAIR_DRY_ID;
/*     */   }
/*     */   
/*     */   public int getClothColorId()
/*     */   {
/* 178 */     return SRoleCreateCfg.get(this.defaultRoleCreateRoleId).DEFAULT_CLOTH_DRY_ID;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean isAssist()
/*     */   {
/* 188 */     return this.occupationType == 3;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Map<Integer, Integer> getDefaultPointCase()
/*     */   {
/* 198 */     Map<Integer, Integer> propMap = new HashMap();
/* 199 */     SDefaultAddPointCase subConfig = SDefaultAddPointCase.get(this.defaultAddPointCaseId);
/* 200 */     propMap.put(Integer.valueOf(25), Integer.valueOf(subConfig.STR));
/* 201 */     propMap.put(Integer.valueOf(29), Integer.valueOf(subConfig.STA));
/* 202 */     propMap.put(Integer.valueOf(27), Integer.valueOf(subConfig.SPR));
/* 203 */     propMap.put(Integer.valueOf(28), Integer.valueOf(subConfig.CON));
/* 204 */     propMap.put(Integer.valueOf(26), Integer.valueOf(subConfig.DEX));
/* 205 */     return propMap;
/*     */   }
/*     */   
/*     */   public Map<Integer, Map<Integer, Integer>> getPropMap()
/*     */   {
/* 210 */     return this.propMap;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getToNextLevelNeedExp(int curLevel)
/*     */   {
/* 221 */     return this.roleExpConfig.getExpByLevel(curLevel + 1);
/*     */   }
/*     */   
/*     */   public int getId()
/*     */   {
/* 226 */     return SOccupationPropTable.get(this.id).occupationId;
/*     */   }
/*     */   
/*     */   public static Map<Integer, Map<Integer, Float>> getTransformPropMap()
/*     */   {
/* 231 */     return transformPropMap;
/*     */   }
/*     */   
/*     */   public String getName()
/*     */   {
/* 236 */     return SOccupationPropTable.get(this.id).occupationName;
/*     */   }
/*     */   
/*     */   static void add(int baseType, int fightType, float value)
/*     */   {
/* 241 */     Map<Integer, Float> baseProp = (Map)transformPropMap.get(Integer.valueOf(fightType));
/* 242 */     if (baseProp == null)
/*     */     {
/* 244 */       baseProp = new HashMap();
/* 245 */       transformPropMap.put(Integer.valueOf(fightType), baseProp);
/*     */     }
/* 247 */     baseProp.put(Integer.valueOf(baseType), Float.valueOf(value));
/*     */   }
/*     */   
/*     */   void init(double[] initProp, double[] addPropPerLevel, int[] portenExpId)
/*     */   {
/* 252 */     this.potentialExpression = new IExpression[portenExpId.length];
/* 253 */     for (int i = 0; i < portenExpId.length; i++)
/*     */     {
/* 255 */       this.potentialExpression[i] = ExpressionManager.getInstance().getExpression(portenExpId[i]);
/*     */     }
/* 257 */     for (int level = 1; level <= RoleCommonConstants.getInstance().MAX_LEVEL + RoleCfgArgs.getInstance().getExtroLevel(); level++)
/*     */     {
/* 259 */       buildPropertyForLevel(level, initProp, addPropPerLevel, this.propMap);
/*     */     }
/* 261 */     for (Map.Entry<Integer, Map<Integer, Integer>> entry : this.propMap.entrySet())
/*     */     {
/* 263 */       int level = ((Integer)entry.getKey()).intValue();
/* 264 */       Map<Integer, Integer> propertyMap = (Map)entry.getValue();
/* 265 */       int totalValue = getProScore(propertyMap);
/* 266 */       this.leveltoFightValueMap.put(Integer.valueOf(level), Integer.valueOf(totalValue));
/*     */     }
/*     */   }
/*     */   
/*     */   int getProScore(Map<Integer, Integer> propertyMap)
/*     */   {
/* 272 */     int totalValue = 0;
/* 273 */     for (STPropertyScoreCfg cfg : STPropertyScoreCfg.getAll().values())
/*     */     {
/* 275 */       Integer val = (Integer)propertyMap.get(Integer.valueOf(cfg.propertyType));
/* 276 */       if (val != null)
/*     */       {
/*     */ 
/*     */ 
/* 280 */         Double factor = (Double)cfg.occ2factor.get(Integer.valueOf(getId()));
/* 281 */         if ((factor != null) && (factor.doubleValue() >= 0.0D))
/*     */         {
/*     */ 
/*     */ 
/* 285 */           totalValue = (int)(totalValue + val.intValue() * factor.doubleValue()); }
/*     */       } }
/* 287 */     return totalValue;
/*     */   }
/*     */   
/*     */ 
/*     */   private void buildPropertyForLevel(int level, double[] initProp, double[] addPropPerLevel, Map<Integer, Map<Integer, Integer>> levelPropMap)
/*     */   {
/* 293 */     Map<Integer, Integer> propMap = (Map)levelPropMap.get(Integer.valueOf(level));
/* 294 */     if (propMap == null)
/*     */     {
/* 296 */       propMap = new HashMap();
/* 297 */       levelPropMap.put(Integer.valueOf(level), propMap);
/*     */     }
/* 299 */     for (int type = 0; type < addPropPerLevel.length; type++)
/*     */     {
/* 301 */       int propType = type + 1;
/* 302 */       propMap.put(Integer.valueOf(propType), Integer.valueOf((int)(initProp[type] + addPropPerLevel[type] * (level - 1))));
/*     */     }
/* 304 */     SOccupationPropTable sOccupationPropTable = SOccupationPropTable.get(this.id);
/*     */     
/* 306 */     propMap.put(Integer.valueOf(85), Integer.valueOf((int)(sOccupationPropTable.PHY_CRT_LEVEL + sOccupationPropTable.PHY_CRT_LEVEL_PER_LEVEL * (level - 1))));
/*     */     
/* 308 */     propMap.put(Integer.valueOf(87), Integer.valueOf((int)(sOccupationPropTable.PHY_CRT_DEF_LEVEL + sOccupationPropTable.PHY_CRT_LEVEL_DEF_PER_LEVEL * (level - 1))));
/*     */     
/* 310 */     propMap.put(Integer.valueOf(86), Integer.valueOf((int)(sOccupationPropTable.MAG_CRT_LEVEL + sOccupationPropTable.MAG_CRT_LEVEL_PER_LEVEL * (level - 1))));
/*     */     
/* 312 */     propMap.put(Integer.valueOf(88), Integer.valueOf((int)(sOccupationPropTable.MAG_CRT_DEF_LEVEL + sOccupationPropTable.MAG_CRT_LEVEL_DEF_PER_LEVEL * (level - 1))));
/*     */   }
/*     */   
/*     */ 
/*     */   public int getPortentialAddPoint(int propType, int level)
/*     */   {
/* 318 */     return this.potentialExpression[(propType - 25)].execute(new Object[] { Integer.valueOf(level) });
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getBasicFightValue(int level)
/*     */   {
/* 329 */     Integer fightValue = (Integer)this.leveltoFightValueMap.get(Integer.valueOf(level));
/* 330 */     if (fightValue == null)
/*     */     {
/* 332 */       return 0;
/*     */     }
/* 334 */     return fightValue.intValue();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   int getMaxLevel()
/*     */   {
/* 344 */     return RoleCommonConstants.getInstance().MAX_LEVEL;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   int getBornLevel()
/*     */   {
/* 354 */     return RoleCommonConstants.getInstance().BORN_LEVEL;
/*     */   }
/*     */   
/*     */   List<Integer> getBornEquipList()
/*     */   {
/* 359 */     return this.bornEquipList;
/*     */   }
/*     */   
/*     */   double getMoveSpeed()
/*     */   {
/* 364 */     return RoleCommonConstants.getInstance().BORN_MOVE_SPEED;
/*     */   }
/*     */   
/*     */   public int getBornMapId()
/*     */   {
/* 369 */     return RoleCommonConstants.getInstance().BORN_MAP_ID;
/*     */   }
/*     */   
/*     */   public int getBornMapX()
/*     */   {
/* 374 */     return RoleCommonConstants.getInstance().BORN_MAP_POS_X;
/*     */   }
/*     */   
/*     */   public int getBornMapY()
/*     */   {
/* 379 */     return RoleCommonConstants.getInstance().BORN_MAP_POS_Y;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getOccupationType()
/*     */   {
/* 389 */     return this.occupationType;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean isOccupationSwitchOpened()
/*     */   {
/* 399 */     int switchId = getSwitchId();
/* 400 */     if (switchId == 0)
/*     */     {
/* 402 */       return true;
/*     */     }
/* 404 */     return OpenInterface.getOpenStatus(switchId);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private int getSwitchId()
/*     */   {
/* 414 */     return this.switchId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getDefaultAvatarId()
/*     */   {
/* 424 */     return this.defaultAvatarId;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\main\Occupation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */