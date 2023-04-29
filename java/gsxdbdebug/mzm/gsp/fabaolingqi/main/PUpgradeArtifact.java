/*     */ package mzm.gsp.fabaolingqi.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.fabaolingqi.confbean.ArtifactProperty;
/*     */ import mzm.gsp.fabaolingqi.confbean.SFabaoArtifactCfg;
/*     */ import mzm.gsp.fabaolingqi.confbean.SFabaoArtifactPropertyTable;
/*     */ import mzm.gsp.item.confbean.SFabaoArtifactItemCfg;
/*     */ import mzm.gsp.item.main.BasicItem;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.item.main.ItemOperateResult;
/*     */ import mzm.gsp.item.main.RoleItemBag;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import xbean.FabaoArtifactRecord;
/*     */ import xbean.FabaoArtifactRecords;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PUpgradeArtifact
/*     */   extends LogicProcedure
/*     */ {
/*     */   private long roleId;
/*     */   private int artifactClassId;
/*     */   
/*     */   public PUpgradeArtifact(long roleId, int artifactClassId)
/*     */   {
/*  38 */     this.roleId = roleId;
/*  39 */     this.artifactClassId = artifactClassId;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  45 */     if (!FabaoArtifactManager.isEnable())
/*  46 */       return false;
/*  47 */     if (GameServerInfoManager.isRoamServer()) {
/*  48 */       return false;
/*     */     }
/*     */     
/*  51 */     FabaoArtifactRecords xRecords = FabaoArtifactManager.getRecords(this.roleId, true);
/*  52 */     if (xRecords == null)
/*  53 */       return false;
/*  54 */     FabaoArtifactRecord xRecord = (FabaoArtifactRecord)xRecords.getRecords().get(Integer.valueOf(this.artifactClassId));
/*  55 */     if (xRecord == null)
/*  56 */       return false;
/*  57 */     int oldLevel = xRecord.getLevel();
/*  58 */     SFabaoArtifactCfg artifactCfg = FabaoArtifactManager.getArtifactCfg(this.artifactClassId, oldLevel);
/*  59 */     if (artifactCfg == null)
/*     */     {
/*  61 */       FabaoArtifactManager.error("PUpgradeArtifact.processImp()@artifact cfg not found|artifact_classid=%d", new Object[] { Integer.valueOf(this.artifactClassId) });
/*     */       
/*  63 */       return false;
/*     */     }
/*  65 */     if (artifactCfg.hasDuration)
/*     */     {
/*  67 */       FabaoArtifactProtocols.notifyUpgradeArtifactFail(this.roleId, 1, this.artifactClassId);
/*  68 */       FabaoArtifactManager.info("PUpgradeArtifact.processImp()@not upgradable|roleid=%d|artifact_classid=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.artifactClassId) });
/*     */       
/*  70 */       return false;
/*     */     }
/*  72 */     Map<Integer, Integer> level2exp = FabaoArtifactManager.getLevel2upgradeExpMap(this.artifactClassId);
/*  73 */     if (level2exp == null)
/*     */     {
/*  75 */       FabaoArtifactManager.error("PUpgradeArtifact.processImp()@level2exp not found|artifact_classid=%d", new Object[] { Integer.valueOf(this.artifactClassId) });
/*     */       
/*  77 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  87 */     Integer nextLevelTotalExp = (Integer)level2exp.get(Integer.valueOf(oldLevel + 1));
/*  88 */     if (nextLevelTotalExp == null)
/*     */     {
/*  90 */       FabaoArtifactProtocols.notifyUpgradeArtifactFail(this.roleId, 2, this.artifactClassId);
/*  91 */       FabaoArtifactManager.info("PUpgradeArtifact.processImp()@max level reached|roleid=%d|artifact_classid=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.artifactClassId) });
/*     */       
/*  93 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  97 */     RoleItemBag roleItemBag = ItemInterface.getRoleItemBag(this.roleId);
/*  98 */     if (roleItemBag == null)
/*  99 */       return false;
/* 100 */     List<UpgradeItem> upgradeItemList = new ArrayList();
/* 101 */     for (BasicItem item : roleItemBag.getItemByType(125).values())
/*     */     {
/* 103 */       SFabaoArtifactItemCfg artifactItemCfg = SFabaoArtifactItemCfg.get(item.getCfgId());
/* 104 */       if (artifactItemCfg != null)
/*     */       {
/* 106 */         SFabaoArtifactCfg _artifactCfg = SFabaoArtifactCfg.get(artifactItemCfg.artifactCfgId);
/* 107 */         if ((_artifactCfg != null) && 
/*     */         
/* 109 */           (_artifactCfg.classId == this.artifactClassId))
/*     */         {
/*     */ 
/* 112 */           UpgradeItem upgradeItem = new UpgradeItem(null);
/* 113 */           upgradeItem.itemCfgId = item.getCfgId();
/* 114 */           upgradeItem.providedExp = _artifactCfg.providedExp;
/* 115 */           upgradeItem.number = item.getNumber();
/* 116 */           upgradeItemList.add(upgradeItem);
/*     */         } } }
/* 118 */     Collections.sort(upgradeItemList);
/* 119 */     if (upgradeItemList.size() == 0)
/*     */     {
/* 121 */       FabaoArtifactProtocols.notifyUpgradeArtifactFail(this.roleId, 3, this.artifactClassId);
/* 122 */       FabaoArtifactManager.info("PUpgradeArtifact.processImp()@no item|roleid=%d|artifact_classid=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.artifactClassId) });
/*     */       
/* 124 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 128 */     int oldTotalExp = xRecord.getUpgrade_exp();
/* 129 */     int requiredExp = nextLevelTotalExp.intValue() - oldTotalExp;
/* 130 */     int providedExp = 0;
/* 131 */     HashMap<Integer, Integer> itemCostMap = new HashMap();
/* 132 */     for (UpgradeItem upgradeItem : upgradeItemList)
/*     */     {
/* 134 */       boolean breakOuter = false;
/* 135 */       for (int i = 0; i < upgradeItem.number; i++)
/*     */       {
/* 137 */         Integer itemCostNum = (Integer)itemCostMap.get(Integer.valueOf(upgradeItem.itemCfgId));
/* 138 */         itemCostNum = Integer.valueOf(itemCostNum == null ? 1 : itemCostNum.intValue() + 1);
/* 139 */         itemCostMap.put(Integer.valueOf(upgradeItem.itemCfgId), itemCostNum);
/*     */         
/* 141 */         providedExp += upgradeItem.providedExp;
/* 142 */         if (providedExp >= requiredExp)
/*     */         {
/* 144 */           breakOuter = true;
/* 145 */           break;
/*     */         }
/*     */       }
/* 148 */       if (breakOuter)
/*     */         break;
/*     */     }
/* 151 */     TLogArg tLogArg = new TLogArg(LogReason.UPGRADE_FABAO_ARTIFACT);
/* 152 */     ItemOperateResult itemOperateResult = ItemInterface.removeItemById(this.roleId, itemCostMap, tLogArg);
/* 153 */     if (!itemOperateResult.success())
/*     */     {
/* 155 */       FabaoArtifactProtocols.notifyUpgradeArtifactFail(this.roleId, 3, this.artifactClassId);
/* 156 */       FabaoArtifactManager.error("PUpgradeArtifact.processImp()@removing items failed|roleid=%d|artifact_classid=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.artifactClassId) });
/*     */       
/* 158 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 162 */     int newUpgradeExp = oldTotalExp + providedExp;
/* 163 */     int newLevel = FabaoArtifactManager.getLevelAfterUpgraded(this.artifactClassId, newUpgradeExp);
/* 164 */     if (newLevel == 0) {
/* 165 */       return false;
/*     */     }
/*     */     
/* 168 */     if (newLevel > oldLevel)
/*     */     {
/*     */ 
/* 171 */       SFabaoArtifactPropertyTable propertyTable = FabaoArtifactManager.getPropertyTable(this.artifactClassId, newLevel);
/* 172 */       if (propertyTable != null)
/*     */       {
/* 174 */         for (Map.Entry<Integer, ArtifactProperty> e : propertyTable.propertyMap.entrySet())
/* 175 */           if (!xRecord.getProperties().containsKey(e.getKey()))
/* 176 */             xRecord.getProperties().put(e.getKey(), Integer.valueOf(((ArtifactProperty)e.getValue()).initValue));
/*     */       }
/* 178 */       xRecord.setLevel(newLevel);
/* 179 */       FabaoArtifactEvents.triggerUpgradeArtifactEvent(this.roleId, this.artifactClassId, oldLevel, newLevel);
/*     */     }
/* 181 */     xRecord.setUpgrade_exp(newUpgradeExp);
/* 182 */     FabaoArtifactProtocols.notifyUpgradeArtifactSuccess(this.roleId, this.artifactClassId, newLevel, newUpgradeExp);
/* 183 */     FabaoArtifactManager.tlogUpgrade(this.roleId, this.artifactClassId, newLevel, newUpgradeExp);
/* 184 */     FabaoArtifactManager.info("PUpgradeArtifact.processImp()@done|roleid=%d|artifact_classid=%d|old_level=%d|new_level=%d|old_exp=%d|new_exp=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.artifactClassId), Integer.valueOf(oldLevel), Integer.valueOf(newLevel), Integer.valueOf(oldTotalExp), Integer.valueOf(newUpgradeExp) });
/*     */     
/*     */ 
/* 187 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   private class UpgradeItem
/*     */     implements Comparable<UpgradeItem>
/*     */   {
/*     */     int itemCfgId;
/*     */     int providedExp;
/*     */     int number;
/*     */     
/*     */     private UpgradeItem() {}
/*     */     
/*     */     public int compareTo(UpgradeItem other)
/*     */     {
/* 202 */       int expDiff = this.providedExp - other.providedExp;
/* 203 */       if (expDiff != 0)
/* 204 */         return expDiff;
/* 205 */       return this.itemCfgId - other.itemCfgId;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fabaolingqi\main\PUpgradeArtifact.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */