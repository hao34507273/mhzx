/*     */ package mzm.gsp.fabaolingqi.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.fabaolingqi.confbean.ArtifactProperty;
/*     */ import mzm.gsp.fabaolingqi.confbean.SFabaoArtifactCfg;
/*     */ import mzm.gsp.fabaolingqi.confbean.SFabaoArtifactConsts;
/*     */ import mzm.gsp.fabaolingqi.confbean.SFabaoArtifactPropertyTable;
/*     */ import mzm.gsp.item.confbean.SFabaoArtifactItemCfg;
/*     */ import mzm.gsp.item.main.BasicItem;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import xbean.FabaoArtifactRecord;
/*     */ import xbean.FabaoArtifactRecords;
/*     */ import xbean.FabaoArtifactSessionInfo;
/*     */ import xbean.Pod;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PUseArtifactItem
/*     */   extends LogicProcedure
/*     */ {
/*     */   private long roleId;
/*     */   private int itemKey;
/*     */   private boolean useAllItems;
/*     */   
/*     */   public PUseArtifactItem(long roleId, int itemKey, boolean useAllItems)
/*     */   {
/*  39 */     this.roleId = roleId;
/*  40 */     this.itemKey = itemKey;
/*  41 */     this.useAllItems = useAllItems;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  47 */     if (!FabaoArtifactManager.isEnable())
/*  48 */       return false;
/*  49 */     if (GameServerInfoManager.isRoamServer()) {
/*  50 */       return false;
/*     */     }
/*  52 */     if (RoleInterface.getLevel(this.roleId) < SFabaoArtifactConsts.getInstance().OPEN_LEVEL) {
/*  53 */       return false;
/*     */     }
/*     */     
/*  56 */     BasicItem item = ItemInterface.getItem(this.roleId, this.itemKey);
/*  57 */     if (item == null)
/*     */     {
/*  59 */       FabaoArtifactProtocols.notifyUseArtifactItemFail(this.roleId, 1, this.itemKey);
/*  60 */       FabaoArtifactManager.info("PUseArtifactItem.checkItemKey()@no item|roleid=%d|item_key=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.itemKey) });
/*  61 */       return false;
/*     */     }
/*  63 */     SFabaoArtifactItemCfg itemCfg = SFabaoArtifactItemCfg.get(item.getCfgId());
/*  64 */     if (itemCfg == null)
/*     */     {
/*  66 */       FabaoArtifactProtocols.notifyUseArtifactItemFail(this.roleId, 2, this.itemKey);
/*  67 */       FabaoArtifactManager.info("PUseArtifactItem.processImp()@invalid item|roleid=%d|item_key=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.itemKey) });
/*  68 */       return false;
/*     */     }
/*  70 */     SFabaoArtifactCfg artifactCfg = SFabaoArtifactCfg.get(itemCfg.artifactCfgId);
/*  71 */     if (artifactCfg == null)
/*     */     {
/*  73 */       FabaoArtifactManager.error("PUseArtifactItem.processImp()@conf not found|artifact_cfgid=%d", new Object[] { Integer.valueOf(itemCfg.artifactCfgId) });
/*  74 */       return false;
/*     */     }
/*     */     
/*  77 */     FabaoArtifactRecords xRecords = FabaoArtifactManager.getOrCreateRecords(this.roleId);
/*  78 */     if (FabaoArtifactManager.hasArtifact(xRecords, artifactCfg.classId))
/*     */     {
/*  80 */       FabaoArtifactRecord xRecord = (FabaoArtifactRecord)xRecords.getRecords().get(Integer.valueOf(artifactCfg.classId));
/*  81 */       if (artifactCfg.hasDuration)
/*     */       {
/*     */ 
/*  84 */         int expireTime = xRecord.getExpire_time() + itemCfg.validDuration * 3600;
/*  85 */         xRecord.setExpire_time(expireTime);
/*  86 */         TLogArg tLogArg = new TLogArg(LogReason.EXTEND_FABAO_ARTIFACT);
/*  87 */         if (!ItemInterface.removeItemByGrid(this.roleId, 340600000, this.itemKey, 1, tLogArg))
/*     */         {
/*  89 */           FabaoArtifactProtocols.notifyUseArtifactItemFail(this.roleId, 1, this.itemKey);
/*  90 */           FabaoArtifactManager.info("PUseArtifactItem.processImp()@removing item failed|roleid=%d|item_key=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.itemKey) });
/*     */           
/*  92 */           return false;
/*     */         }
/*  94 */         FabaoArtifactProtocols.notifyExtendArtifactSuccess(this.roleId, artifactCfg.classId, expireTime);
/*  95 */         FabaoArtifactManager.tlogExtend(this.roleId, artifactCfg.classId, itemCfg.validDuration, expireTime);
/*  96 */         FabaoArtifactSessionInfo xFabaoArtifactSessionInfo = FabaoArtifactManager.getOrCreateSessionInfo(this.roleId);
/*     */         
/*  98 */         FabaoArtifactExpireSession.restartSession(this.roleId, xFabaoArtifactSessionInfo, artifactCfg.classId, expireTime);
/*  99 */         FabaoArtifactManager.info("PUseArtifactItem.processImp()@extend artifact|roleid=%d|artifact_classid=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(artifactCfg.classId) });
/*     */         
/* 101 */         return true;
/*     */       }
/*     */       
/*     */ 
/*     */ 
/* 106 */       if (artifactCfg.upgradeExp == 0)
/*     */       {
/* 108 */         FabaoArtifactProtocols.notifyUpgradeArtifactFail(this.roleId, 2, artifactCfg.classId);
/* 109 */         FabaoArtifactManager.info("PUseArtifactItem.processImp()@upgrade reach maximum|roleid=%d|artifact_classid=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(artifactCfg.classId) });
/*     */         
/*     */ 
/* 112 */         return false;
/*     */       }
/* 114 */       int topLevelExp = FabaoArtifactManager.getTopLevelUpgradeExp(artifactCfg.classId);
/* 115 */       int oldExp = xRecord.getUpgrade_exp();
/* 116 */       int oldLevel = xRecord.getLevel();
/* 117 */       int newExp = oldExp + artifactCfg.providedExp;
/* 118 */       int numberOfItem = 1;
/* 119 */       if (this.useAllItems)
/*     */       {
/* 121 */         while ((newExp < topLevelExp) && (numberOfItem < item.getNumber()))
/*     */         {
/* 123 */           newExp += artifactCfg.providedExp;
/* 124 */           numberOfItem++;
/*     */         }
/*     */       }
/* 127 */       int newLevel = FabaoArtifactManager.getLevelAfterUpgraded(artifactCfg.classId, newExp);
/* 128 */       if (newLevel == 0) {
/* 129 */         return false;
/*     */       }
/* 131 */       xRecord.setUpgrade_exp(newExp);
/* 132 */       if (newLevel > oldLevel)
/*     */       {
/*     */ 
/* 135 */         SFabaoArtifactPropertyTable propertyTable = FabaoArtifactManager.getPropertyTable(artifactCfg.classId, newLevel);
/*     */         
/* 137 */         if (propertyTable != null)
/*     */         {
/* 139 */           for (Map.Entry<Integer, ArtifactProperty> e : propertyTable.propertyMap.entrySet())
/* 140 */             if (!xRecord.getProperties().containsKey(e.getKey()))
/* 141 */               xRecord.getProperties().put(e.getKey(), Integer.valueOf(((ArtifactProperty)e.getValue()).initValue));
/*     */         }
/* 143 */         xRecord.setLevel(newLevel);
/* 144 */         FabaoArtifactEvents.triggerUpgradeArtifactEvent(this.roleId, artifactCfg.classId, oldLevel, newLevel);
/*     */       }
/* 146 */       TLogArg tLogArg = new TLogArg(LogReason.UPGRADE_FABAO_ARTIFACT);
/* 147 */       if (!ItemInterface.removeItemByGrid(this.roleId, 340600000, this.itemKey, numberOfItem, tLogArg))
/*     */       {
/* 149 */         FabaoArtifactProtocols.notifyUseArtifactItemFail(this.roleId, 1, this.itemKey);
/* 150 */         FabaoArtifactManager.info("PUseArtifactItem.processImp()@removing item failed|roleid=%d|item_key=%d|item_number=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.itemKey), Integer.valueOf(numberOfItem) });
/*     */         
/*     */ 
/* 153 */         return false;
/*     */       }
/* 155 */       FabaoArtifactProtocols.notifyUpgradeArtifactSuccess(this.roleId, artifactCfg.classId, newLevel, newExp);
/* 156 */       FabaoArtifactManager.tlogUpgrade(this.roleId, artifactCfg.classId, newLevel, newExp);
/* 157 */       FabaoArtifactManager.info("PUseArtifactItem.processImp()@upgrade artifact|roleid=%d|artifact_classid=%d|old_level=%d|new_level=%d|old_exp=%d|new_exp=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(artifactCfg.classId), Integer.valueOf(oldLevel), Integer.valueOf(newLevel), Integer.valueOf(oldExp), Integer.valueOf(newExp) });
/*     */       
/*     */ 
/* 160 */       return false;
/*     */     }
/*     */     
/*     */     int expireTime;
/*     */     
/*     */     int expireTime;
/*     */     
/* 167 */     if (artifactCfg.hasDuration) {
/* 168 */       expireTime = (int)(DateTimeUtils.getCurrTimeInMillis() / 1000L) + itemCfg.validDuration * 3600;
/*     */     }
/*     */     else
/* 171 */       expireTime = 0;
/* 172 */     int totalExp = FabaoArtifactManager.getTotalUpgradeExp(artifactCfg.classId, artifactCfg.level);
/* 173 */     if (totalExp == -1)
/*     */     {
/* 175 */       FabaoArtifactManager.error("PUseArtifactItem.processImp()@upgrade exp not found|artifact_classid=%d|level=%d", new Object[] { Integer.valueOf(artifactCfg.classId), Integer.valueOf(artifactCfg.level) });
/*     */       
/* 177 */       return false;
/*     */     }
/* 179 */     SFabaoArtifactPropertyTable artifactPropertyTable = SFabaoArtifactPropertyTable.get(artifactCfg.id);
/* 180 */     Map<Integer, Integer> propertyType2value = new HashMap();
/* 181 */     if (artifactPropertyTable != null)
/*     */     {
/* 183 */       for (Map.Entry<Integer, ArtifactProperty> e : artifactPropertyTable.propertyMap.entrySet()) {
/* 184 */         propertyType2value.put(e.getKey(), Integer.valueOf(((ArtifactProperty)e.getValue()).initValue));
/*     */       }
/*     */     }
/*     */     
/* 188 */     FabaoArtifactRecord xRecord = Pod.newFabaoArtifactRecord();
/* 189 */     xRecord.setLevel(artifactCfg.level);
/* 190 */     xRecord.setExpire_time(expireTime);
/* 191 */     xRecord.setUpgrade_exp(totalExp);
/* 192 */     xRecord.getProperties().putAll(propertyType2value);
/* 193 */     xRecords.getRecords().put(Integer.valueOf(artifactCfg.classId), xRecord);
/* 194 */     TLogArg tLogArg = new TLogArg(LogReason.UNLOCK_FABAO_ARTIFACT);
/* 195 */     if (!ItemInterface.removeItemByGrid(this.roleId, 340600000, this.itemKey, 1, tLogArg))
/*     */     {
/* 197 */       FabaoArtifactProtocols.notifyUseArtifactItemFail(this.roleId, 1, this.itemKey);
/* 198 */       FabaoArtifactManager.info("PUseArtifactItem.processImp()@removing item failed|roleid=%d|item_key=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.itemKey) });
/*     */       
/* 200 */       return false;
/*     */     }
/* 202 */     FabaoArtifactProtocols.notifyUnlockArtifactSuccess(this.roleId, artifactCfg.classId, artifactCfg.level, expireTime);
/* 203 */     FabaoArtifactManager.tlogUnlock(this.roleId, artifactCfg.classId, artifactCfg.level);
/* 204 */     FabaoArtifactEvents.triggerUnlockArtifactEvent(this.roleId, artifactCfg.classId);
/* 205 */     if (expireTime != 0)
/*     */     {
/* 207 */       FabaoArtifactSessionInfo xSessionInfo = FabaoArtifactManager.getOrCreateSessionInfo(this.roleId);
/* 208 */       FabaoArtifactExpireSession.startSession(this.roleId, xSessionInfo, artifactCfg.classId, expireTime);
/*     */     }
/* 210 */     FabaoArtifactManager.info("PUseArtifactItem.processImp()@unlock artifact|roleid=%d|artifact_classid=%d|expire_time=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(artifactCfg.classId), Integer.valueOf(expireTime) });
/*     */     
/*     */ 
/* 213 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fabaolingqi\main\PUseArtifactItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */