/*     */ package mzm.gsp.fabaolingqi.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.fabaolingqi.confbean.SFabaoArtifactCfg;
/*     */ import mzm.gsp.item.confbean.SFabaoArtifactItemCfg;
/*     */ import xbean.FabaoArtifactRecord;
/*     */ import xbean.FabaoArtifactRecords;
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
/*     */ public class FabaoArtifactInterface
/*     */ {
/*     */   public static Set<Integer> getArtifactSkills(long roleId, boolean holdRolelock)
/*     */   {
/*  30 */     Set<Integer> skillIds = new HashSet();
/*  31 */     if (!FabaoArtifactManager.isEnable()) {
/*  32 */       return skillIds;
/*     */     }
/*  34 */     FabaoArtifactRecords xRecords = FabaoArtifactManager.getRecords(roleId, holdRolelock);
/*  35 */     if (xRecords == null) {
/*  36 */       return skillIds;
/*     */     }
/*  38 */     for (Map.Entry<Integer, FabaoArtifactRecord> e : xRecords.getRecords().entrySet())
/*     */     {
/*  40 */       SFabaoArtifactCfg artifactCfg = FabaoArtifactManager.getArtifactCfg(((Integer)e.getKey()).intValue(), ((FabaoArtifactRecord)e.getValue()).getLevel());
/*  41 */       if ((artifactCfg != null) && (artifactCfg.skillId != 0))
/*  42 */         skillIds.add(Integer.valueOf(artifactCfg.skillId));
/*     */     }
/*  44 */     return skillIds;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static Map<Integer, Integer> getArtifactProperties(long roleId, boolean holdRolelock)
/*     */   {
/*  55 */     Map<Integer, Integer> properties = new HashMap();
/*  56 */     if (!FabaoArtifactManager.isEnable()) {
/*  57 */       return properties;
/*     */     }
/*  59 */     FabaoArtifactRecords xRecords = FabaoArtifactManager.getRecords(roleId, holdRolelock);
/*  60 */     if (xRecords == null) {
/*  61 */       return properties;
/*     */     }
/*  63 */     for (FabaoArtifactRecord xRecord : xRecords.getRecords().values())
/*     */     {
/*  65 */       for (Map.Entry<Integer, Integer> e : xRecord.getProperties().entrySet())
/*     */       {
/*  67 */         Integer value = (Integer)properties.get(e.getKey());
/*  68 */         if (value != null) {
/*  69 */           properties.put(e.getKey(), Integer.valueOf(value.intValue() + ((Integer)e.getValue()).intValue()));
/*     */         } else
/*  71 */           properties.put(e.getKey(), e.getValue());
/*     */       }
/*     */     }
/*  74 */     return properties;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static int getEquippedArtifactCfgId(long roleId, boolean holdRolelock)
/*     */   {
/*  85 */     if (!FabaoArtifactManager.isEnable()) {
/*  86 */       return 0;
/*     */     }
/*  88 */     FabaoArtifactRecords xRecords = FabaoArtifactManager.getRecords(roleId, holdRolelock);
/*  89 */     if (xRecords == null) {
/*  90 */       return 0;
/*     */     }
/*  92 */     int artifactClassId = xRecords.getEquipped_artifact_class();
/*  93 */     if (artifactClassId == 0) {
/*  94 */       return 0;
/*     */     }
/*  96 */     FabaoArtifactRecord xRecord = (FabaoArtifactRecord)xRecords.getRecords().get(Integer.valueOf(artifactClassId));
/*  97 */     if (xRecord == null)
/*  98 */       return 0;
/*  99 */     int level = xRecord.getLevel();
/*     */     
/* 101 */     Map<Integer, Integer> level2cfgId = FabaoArtifactManager.getLevel2cfgIdMap(artifactClassId);
/* 102 */     if (level2cfgId == null) {
/* 103 */       return 0;
/*     */     }
/* 105 */     Integer artifactCfgId = (Integer)level2cfgId.get(Integer.valueOf(level));
/* 106 */     return artifactCfgId == null ? 0 : artifactCfgId.intValue();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static int getArtifactCountByLevel(long roleId, int level, boolean holdRolelock)
/*     */   {
/* 118 */     if (!FabaoArtifactManager.isEnable())
/* 119 */       return 0;
/* 120 */     FabaoArtifactRecords xRecords = FabaoArtifactManager.getRecords(roleId, holdRolelock);
/* 121 */     if (xRecords == null) {
/* 122 */       return 0;
/*     */     }
/* 124 */     int count = 0;
/* 125 */     for (FabaoArtifactRecord xRecord : xRecords.getRecords().values())
/*     */     {
/* 127 */       if (xRecord.getLevel() >= level)
/*     */       {
/* 129 */         count++;
/*     */       }
/*     */     }
/* 132 */     return count;
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
/*     */   public static int getArtifactCountByLevelAndClass(long roleId, int level, int classId, boolean holdRolelock)
/*     */   {
/* 145 */     if (!FabaoArtifactManager.isEnable())
/* 146 */       return 0;
/* 147 */     FabaoArtifactRecords xRecords = FabaoArtifactManager.getRecords(roleId, holdRolelock);
/* 148 */     if (xRecords == null) {
/* 149 */       return 0;
/*     */     }
/* 151 */     int count = 0;
/* 152 */     for (Map.Entry<Integer, FabaoArtifactRecord> entry : xRecords.getRecords().entrySet())
/*     */     {
/* 154 */       if ((((Integer)entry.getKey()).intValue() == classId) && (((FabaoArtifactRecord)entry.getValue()).getLevel() >= level))
/*     */       {
/* 156 */         count++;
/*     */       }
/*     */     }
/* 159 */     return count;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean hasArtifacts(long roleId, Set<Integer> artifactClassIds, boolean holdRolelock)
/*     */   {
/* 171 */     if (!FabaoArtifactManager.isEnable())
/* 172 */       return false;
/* 173 */     FabaoArtifactRecords xRecords = FabaoArtifactManager.getRecords(roleId, holdRolelock);
/* 174 */     if (xRecords == null) {
/* 175 */       return false;
/*     */     }
/* 177 */     for (Integer artifactClassId : artifactClassIds)
/*     */     {
/* 179 */       if (!xRecords.getRecords().containsKey(artifactClassId))
/*     */       {
/* 181 */         return false;
/*     */       }
/*     */     }
/* 184 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @Deprecated
/*     */   public static int removeArtifactByItem(long roleId, int artifactItemId)
/*     */   {
/* 195 */     return FabaoArtifactManager.removeArtifactByItem(roleId, artifactItemId);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public static FabaoArtifactRemoveResult removeArtifactWithItem(long roleId, int artifactItemId)
/*     */   {
/* 203 */     return removeArtifactWithItem(roleId, artifactItemId, 1);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static FabaoArtifactRemoveResult removeArtifactWithItem(long roleId, int artifactItemId, int number)
/*     */   {
/* 213 */     SFabaoArtifactItemCfg itemCfg = SFabaoArtifactItemCfg.get(artifactItemId);
/* 214 */     if (itemCfg == null)
/*     */     {
/* 216 */       return FabaoArtifactRemoveResult.INVALID_ARTIFACT_ITEM;
/*     */     }
/* 218 */     SFabaoArtifactCfg artifactCfg = SFabaoArtifactCfg.get(itemCfg.artifactCfgId);
/* 219 */     if (artifactCfg == null)
/*     */     {
/* 221 */       return FabaoArtifactRemoveResult.INVALID_ARTIFACT_ITEM;
/*     */     }
/* 223 */     return artifactCfg.hasDuration ? FabaoArtifactManager.removeArtifactDuration(roleId, artifactCfg.classId, itemCfg.validDuration * number) : FabaoArtifactManager.removeArtifactUpgradeExp(roleId, artifactCfg.classId, artifactCfg.providedExp * number);
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
/*     */   public static Map<Integer, Integer> getArtifactTypeId2level(long roleId, boolean isHoldRoleLock)
/*     */   {
/* 237 */     Map<Integer, Integer> result = new HashMap();
/* 238 */     FabaoArtifactRecords xRecords = FabaoArtifactManager.getRecords(roleId, isHoldRoleLock);
/* 239 */     if (xRecords == null)
/*     */     {
/* 241 */       return result;
/*     */     }
/* 243 */     for (Map.Entry<Integer, FabaoArtifactRecord> entry : xRecords.getRecords().entrySet())
/*     */     {
/* 245 */       result.put(entry.getKey(), Integer.valueOf(((FabaoArtifactRecord)entry.getValue()).getLevel()));
/*     */     }
/* 247 */     return result;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fabaolingqi\main\FabaoArtifactInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */