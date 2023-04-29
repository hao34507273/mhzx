/*     */ package mzm.gsp.role.main;
/*     */ 
/*     */ import java.util.Collection;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.occupation.confbean.RoleCommonConstants;
/*     */ import mzm.gsp.occupation.confbean.SOccupationPropTable;
/*     */ import mzm.gsp.occupation.confbean.SPropertyTransform;
/*     */ import mzm.gsp.occupation.confbean.SRoleLevelUpExp;
/*     */ 
/*     */ 
/*     */ public class OccupationManager
/*     */ {
/*  18 */   private static OccupationManager instance = new OccupationManager();
/*     */   
/*     */ 
/*     */ 
/*  22 */   private Map<Integer, Map<Integer, Occupation>> occupationMap = new HashMap();
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  27 */   private Map<Integer, Set<Integer>> type2occIds = new HashMap();
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static OccupationManager getInstance()
/*     */   {
/*  35 */     return instance;
/*     */   }
/*     */   
/*     */   void init(Map<String, String> envs) throws Exception
/*     */   {
/*  40 */     RoleExpConfig roleExpConfig = new RoleExpConfig();
/*  41 */     Map<Integer, SRoleLevelUpExp> expMap = SRoleLevelUpExp.getAll();
/*     */     
/*  43 */     Iterator<SRoleLevelUpExp> expIt = expMap.values().iterator();
/*  44 */     while (expIt.hasNext())
/*     */     {
/*  46 */       SRoleLevelUpExp exp = (SRoleLevelUpExp)expIt.next();
/*  47 */       roleExpConfig.addMap(Integer.valueOf(exp.upToLevel), Integer.valueOf(exp.needExp));
/*     */     }
/*  49 */     Map<Integer, SPropertyTransform> transformMap = SPropertyTransform.getAll();
/*  50 */     parseTransformMap(transformMap);
/*  51 */     Map<Integer, SOccupationPropTable> occupationDataMap = SOccupationPropTable.getAll();
/*  52 */     for (SOccupationPropTable ocp : occupationDataMap.values())
/*     */     {
/*  54 */       Occupation occupationType = createOccupationPrototype(ocp, roleExpConfig);
/*  55 */       Map<Integer, Occupation> genderMap = (Map)this.occupationMap.get(Integer.valueOf(ocp.occupationId));
/*  56 */       if (genderMap == null)
/*     */       {
/*  58 */         genderMap = new HashMap();
/*  59 */         this.occupationMap.put(Integer.valueOf(ocp.occupationId), genderMap);
/*     */       }
/*  61 */       genderMap.put(Integer.valueOf(ocp.gender), occupationType);
/*     */       
/*  63 */       Set<Integer> xTypeOccIds = (Set)this.type2occIds.get(Integer.valueOf(ocp.occupationType));
/*  64 */       if (xTypeOccIds == null)
/*     */       {
/*  66 */         xTypeOccIds = new HashSet();
/*  67 */         this.type2occIds.put(Integer.valueOf(ocp.occupationType), xTypeOccIds);
/*     */       }
/*  69 */       xTypeOccIds.add(Integer.valueOf(ocp.occupationId));
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
/*     */ 
/*     */ 
/*     */ 
/*     */   void postInit()
/*     */   {
/*  87 */     for (Map.Entry<Integer, Map<Integer, Occupation>> entry : this.occupationMap.entrySet())
/*     */     {
/*  89 */       for (Occupation ocp : ((Map)entry.getValue()).values())
/*     */       {
/*  91 */         ocp.initBornEquip();
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getOpenResetFuncLevel()
/*     */   {
/* 103 */     return RoleCommonConstants.getInstance().ADD_POTEN_FUNC_LEVEL;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getSecondSysOpenLevel()
/*     */   {
/* 113 */     return RoleCommonConstants.getInstance().OPEN_POINT_SYS_2_LEVEL;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getThirdSysOpenLevel()
/*     */   {
/* 123 */     return RoleCommonConstants.getInstance().OPEN_POINT_SYS_3_LEVEL;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean isExistOccupation(int id)
/*     */   {
/* 134 */     return instance.occupationMap.containsKey(Integer.valueOf(id));
/*     */   }
/*     */   
/*     */   static Occupation getOccupationById(int id, int gender)
/*     */   {
/* 139 */     Map<Integer, Occupation> gender2OccupMap = (Map)instance.occupationMap.get(Integer.valueOf(id));
/* 140 */     if (gender2OccupMap == null)
/*     */     {
/* 142 */       return null;
/*     */     }
/* 144 */     return (Occupation)gender2OccupMap.get(Integer.valueOf(gender));
/*     */   }
/*     */   
/*     */   public static boolean isOccupationOpen(int occupationid, int gender)
/*     */   {
/* 149 */     Occupation occupation = getOccupationById(occupationid, gender);
/* 150 */     if (occupation == null)
/*     */     {
/* 152 */       return false;
/*     */     }
/* 154 */     return occupation.isRoleOpen();
/*     */   }
/*     */   
/*     */   private void parseTransformMap(Map<Integer, SPropertyTransform> transformMap)
/*     */   {
/* 159 */     for (SPropertyTransform ptransform : transformMap.values())
/*     */     {
/* 161 */       Occupation.add(ptransform.baseProp, ptransform.fightProp, (float)ptransform.transformValue);
/*     */     }
/*     */   }
/*     */   
/*     */   private Occupation createOccupationPrototype(SOccupationPropTable ocpData, RoleExpConfig expConfig)
/*     */   {
/* 167 */     Occupation ocp = new Occupation(ocpData.id, ocpData.occupationName);
/* 168 */     ocp.setExpConfig(expConfig);
/*     */     
/*     */ 
/* 171 */     double[] prop = { ocpData.HP, 0.0D, ocpData.MP, 0.0D, 0.0D, 0.0D, ocpData.PHY_ATK, ocpData.PHY_DEF, ocpData.MAG_ATK, ocpData.MAG_DEF, ocpData.PHY_CRT_RATE, ocpData.MAG_CRT_RATE, 0.0D, ocpData.PHY_CRT, ocpData.MAG_CRT, ocpData.SEAL_HIT_LEVEL, ocpData.SEAL_RES_LEVEL, ocpData.PHY_HIT_LEVEL, ocpData.PHY_DODAGE_LEVEL, ocpData.MAG_HIT_LEVEL, ocpData.MAG_DODAGE_LEVEL, 0.0D, 0.0D, ocpData.SPEED, ocpData.STR, ocpData.DEX, ocpData.SPR, ocpData.CON, ocpData.STA };
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 177 */     double[] addPropPerLevel = { ocpData.HP_PER_LEVEL, 0.0D, ocpData.MP_PER_LEVEL, 0.0D, 0.0D, 0.0D, ocpData.PHY_ATK_PER_LEVEL, ocpData.PHY_DEF_PER_LEVEL, ocpData.MAG_ATK_PER_LEVEL, ocpData.MAG_DEF_PER_LEVEL, ocpData.PHY_CRT_RATE_PER_LEVEL, ocpData.MAG_CRT_RATE_PER_LEVEL, 0.0D, ocpData.PHY_CRT_PER_LEVEL, ocpData.MAG_CRT_PER_LEVEL, ocpData.SEAL_HIT_LEVEL_PER_LEVEL, ocpData.SEAL_RES_LEVEL_PER_LEVEL, ocpData.PHY_HIT_LEVEL_PER_LEVEL, ocpData.PHY_DODAGE_LEVEL_PER_LEVEL, ocpData.MAG_HIT_LEVEL_PER_LEVEL, ocpData.MAG_DODAGE_LEVEL_PER_LEVEL, 0.0D, 0.0D, ocpData.SPEED_PER_LEVEL, ocpData.STR_PER_LEVEL, ocpData.DEX_PER_LEVEL, ocpData.SPR_PER_LEVEL, ocpData.CON_PER_LEVEL, ocpData.STA_PER_LEVEL };
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 184 */     int[] potenExprId = { ocpData.STR_PER_LEVEL_EXPREE_ID, ocpData.DEX_PER_LEVEL_EXPREE_ID, ocpData.SPR_PER_LEVEL_EXPREE_ID, ocpData.CON_PER_LEVEL_EXPREE_ID, ocpData.STA_PER_LEVEL_EXPREE_ID };
/*     */     
/* 186 */     ocp.init(prop, addPropPerLevel, potenExprId);
/* 187 */     return ocp;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getRenameItem()
/*     */   {
/* 197 */     return RoleCommonConstants.getInstance().RENAME_ITEM_TYPE_ID;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getResetPointItem()
/*     */   {
/* 207 */     return RoleCommonConstants.getInstance().RESET_POINT_ITEM_TYPE_ID;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean isAssistOccupation(int occupationId, int gender)
/*     */   {
/* 219 */     Map<Integer, Occupation> m = (Map)this.occupationMap.get(Integer.valueOf(occupationId));
/* 220 */     if ((m == null) || (m.size() == 0))
/*     */     {
/* 222 */       return false;
/*     */     }
/* 224 */     Occupation c = (Occupation)m.get(Integer.valueOf(gender));
/* 225 */     if (c == null)
/*     */     {
/* 227 */       return false;
/*     */     }
/* 229 */     return c.isAssist();
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
/*     */   public int getOccupationType(int occupationId, int gender)
/*     */   {
/* 245 */     Map<Integer, Occupation> m = (Map)this.occupationMap.get(Integer.valueOf(occupationId));
/* 246 */     if ((m == null) || (m.size() == 0))
/*     */     {
/* 248 */       return -1;
/*     */     }
/* 250 */     Occupation c = (Occupation)m.get(Integer.valueOf(gender));
/* 251 */     if (c == null)
/*     */     {
/* 253 */       return -1;
/*     */     }
/* 255 */     return c.getOccupationType();
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
/*     */   public int getOccupationDefaultAvatarId(int occupationId, int gender)
/*     */   {
/* 271 */     Map<Integer, Occupation> m = (Map)this.occupationMap.get(Integer.valueOf(occupationId));
/* 272 */     if ((m == null) || (m.size() == 0))
/*     */     {
/* 274 */       return -1;
/*     */     }
/* 276 */     Occupation c = (Occupation)m.get(Integer.valueOf(gender));
/* 277 */     if (c == null)
/*     */     {
/* 279 */       return -1;
/*     */     }
/* 281 */     return c.getDefaultAvatarId();
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
/*     */   boolean isOccupationSwitchOpen(int occupationId)
/*     */   {
/* 294 */     return isOccupationSwitchOpen(occupationId, 1);
/*     */   }
/*     */   
/*     */   boolean isOccupationSwitchOpen(int occupationId, int gender)
/*     */   {
/* 299 */     Map<Integer, Occupation> m = (Map)this.occupationMap.get(Integer.valueOf(occupationId));
/* 300 */     if ((m == null) || (m.size() == 0))
/*     */     {
/* 302 */       return false;
/*     */     }
/* 304 */     Occupation c = (Occupation)m.get(Integer.valueOf(gender));
/* 305 */     if (c == null)
/*     */     {
/* 307 */       return false;
/*     */     }
/* 309 */     return c.isOccupationSwitchOpened();
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
/*     */   public Set<Integer> getXTypeOccupationIds(int type)
/*     */   {
/* 322 */     Set<Integer> occIds = (Set)this.type2occIds.get(Integer.valueOf(type));
/* 323 */     return occIds == null ? new HashSet() : occIds;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\main\OccupationManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */