/*     */ package mzm.gsp.fabaolingqi.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.fabaolingqi.SEquipArtifactFail;
/*     */ import mzm.gsp.fabaolingqi.SEquipArtifactSuccess;
/*     */ import mzm.gsp.fabaolingqi.SExtendArtifactSuccess;
/*     */ import mzm.gsp.fabaolingqi.SImproveArtifactSuccess;
/*     */ import mzm.gsp.fabaolingqi.SImproveArtifactUseAllSuccess;
/*     */ import mzm.gsp.fabaolingqi.SSyncArtifactInformation;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import xbean.FabaoArtifactRecord;
/*     */ import xbean.FabaoArtifactRecords;
/*     */ 
/*     */ class FabaoArtifactProtocols
/*     */ {
/*     */   static void syncArtifactInformation(long roleId, FabaoArtifactRecords xRecords)
/*     */   {
/*  19 */     SSyncArtifactInformation protocol = new SSyncArtifactInformation();
/*  20 */     protocol.equipped_artifact_class = xRecords.getEquipped_artifact_class();
/*  21 */     for (Map.Entry<Integer, FabaoArtifactRecord> e : xRecords.getRecords().entrySet())
/*     */     {
/*  23 */       mzm.gsp.fabaolingqi.FabaoArtifactInfo artifactInfo = new mzm.gsp.fabaolingqi.FabaoArtifactInfo();
/*  24 */       artifactInfo.expire_time = ((FabaoArtifactRecord)e.getValue()).getExpire_time();
/*  25 */       artifactInfo.level = ((FabaoArtifactRecord)e.getValue()).getLevel();
/*  26 */       artifactInfo.upgrade_exp = ((FabaoArtifactRecord)e.getValue()).getUpgrade_exp();
/*  27 */       artifactInfo.properties = new HashMap(((FabaoArtifactRecord)e.getValue()).getProperties());
/*  28 */       protocol.artifact_map.put(e.getKey(), artifactInfo);
/*     */     }
/*  30 */     OnlineManager.getInstance().send(roleId, protocol);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static void notifyArtifactExpire(long roleId, int artifactClassId)
/*     */   {
/*  38 */     mzm.gsp.fabaolingqi.SNotifyArtifactExpire protocol = new mzm.gsp.fabaolingqi.SNotifyArtifactExpire();
/*  39 */     protocol.class_id = artifactClassId;
/*  40 */     OnlineManager.getInstance().send(roleId, protocol);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static void notifyUnlockArtifactSuccess(long roleId, int artifactClassId, int artifactLevel, int expireTime)
/*     */   {
/*  48 */     mzm.gsp.fabaolingqi.SUnlockArtifactSuccess protocol = new mzm.gsp.fabaolingqi.SUnlockArtifactSuccess();
/*  49 */     protocol.class_id = artifactClassId;
/*  50 */     protocol.level = artifactLevel;
/*  51 */     protocol.expire_time = expireTime;
/*  52 */     OnlineManager.getInstance().send(roleId, protocol);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static void notifyExtendArtifactSuccess(long roleId, int artifactClassId, int expireTime)
/*     */   {
/*  60 */     SExtendArtifactSuccess protocol = new SExtendArtifactSuccess();
/*  61 */     protocol.class_id = artifactClassId;
/*  62 */     protocol.expire_time = expireTime;
/*  63 */     OnlineManager.getInstance().send(roleId, protocol);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static void notifyUseArtifactItemFail(long roleId, int retcode, int itemKey)
/*     */   {
/*  71 */     mzm.gsp.fabaolingqi.SUseExchangeItemFail protocol = new mzm.gsp.fabaolingqi.SUseExchangeItemFail();
/*  72 */     protocol.retcode = retcode;
/*  73 */     protocol.item_key = itemKey;
/*  74 */     OnlineManager.getInstance().sendAtOnce(roleId, protocol);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static void notifyEquipArtifactSuccess(long roleId, int artifactClassId)
/*     */   {
/*  82 */     SEquipArtifactSuccess protocol = new SEquipArtifactSuccess();
/*  83 */     protocol.class_id = artifactClassId;
/*  84 */     OnlineManager.getInstance().send(roleId, protocol);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static void notifyEquipArtifactFail(long roleId, int retcode, int artifactClassId)
/*     */   {
/*  92 */     SEquipArtifactFail protocol = new SEquipArtifactFail();
/*  93 */     protocol.retcode = retcode;
/*  94 */     protocol.class_id = artifactClassId;
/*  95 */     OnlineManager.getInstance().sendAtOnce(roleId, protocol);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static void notifyUnequipArtifactSuccess(long roleId)
/*     */   {
/* 103 */     mzm.gsp.fabaolingqi.SUnequipArtifactSuccess protocol = new mzm.gsp.fabaolingqi.SUnequipArtifactSuccess();
/* 104 */     OnlineManager.getInstance().send(roleId, protocol);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static void notifyImproveArtifactSuccess(long roleId, int artifactClassId, int propertyType, int propertyValue)
/*     */   {
/* 112 */     SImproveArtifactSuccess protocol = new SImproveArtifactSuccess();
/* 113 */     protocol.class_id = artifactClassId;
/* 114 */     protocol.property_type = propertyType;
/* 115 */     protocol.property_value = propertyValue;
/* 116 */     OnlineManager.getInstance().send(roleId, protocol);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void notifyImproveArtifactUseAllSuccess(long roleId, int artifactClassId, int propertyType, int propertyValue, int consumedItemNum, int consumedYuanbao)
/*     */   {
/* 125 */     SImproveArtifactUseAllSuccess protocol = new SImproveArtifactUseAllSuccess();
/* 126 */     protocol.class_id = artifactClassId;
/* 127 */     protocol.property_type = propertyType;
/* 128 */     protocol.property_value = propertyValue;
/* 129 */     protocol.consumed_item_num = consumedItemNum;
/* 130 */     protocol.consumed_yuanbao = consumedYuanbao;
/* 131 */     OnlineManager.getInstance().send(roleId, protocol);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static void notifyImproveArtifactFail(long roleId, int retcode, int artifactClassId, int propertyType)
/*     */   {
/* 139 */     mzm.gsp.fabaolingqi.SImproveArtifactFail protocol = new mzm.gsp.fabaolingqi.SImproveArtifactFail();
/* 140 */     protocol.retcode = retcode;
/* 141 */     protocol.class_id = artifactClassId;
/* 142 */     protocol.property_type = propertyType;
/* 143 */     OnlineManager.getInstance().sendAtOnce(roleId, protocol);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static void notifyUpgradeArtifactSuccess(long roleId, int artifactClassId, int artifactLevel, int artifactExp)
/*     */   {
/* 151 */     mzm.gsp.fabaolingqi.SUpgradeArtifactSuccess protocol = new mzm.gsp.fabaolingqi.SUpgradeArtifactSuccess();
/* 152 */     protocol.class_id = artifactClassId;
/* 153 */     protocol.level = artifactLevel;
/* 154 */     protocol.upgrade_exp = artifactExp;
/* 155 */     OnlineManager.getInstance().send(roleId, protocol);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static void notifyUpgradeArtifactFail(long roleId, int retcode, int artifactClassId)
/*     */   {
/* 163 */     mzm.gsp.fabaolingqi.SUpgradeArtifactFail protocol = new mzm.gsp.fabaolingqi.SUpgradeArtifactFail();
/* 164 */     protocol.retcode = retcode;
/* 165 */     protocol.class_id = artifactClassId;
/* 166 */     OnlineManager.getInstance().sendAtOnce(roleId, protocol);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fabaolingqi\main\FabaoArtifactProtocols.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */