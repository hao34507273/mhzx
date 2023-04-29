/*     */ package mzm.gsp.fabaolingqi.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.fabaolingqi.confbean.ArtifactProperty;
/*     */ import mzm.gsp.fabaolingqi.confbean.SFabaoArtifactPropertyTable;
/*     */ import mzm.gsp.item.confbean.IdTypeValueBean;
/*     */ import mzm.gsp.item.confbean.SItemSiftCfg;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.qingfu.main.CostResult;
/*     */ import mzm.gsp.qingfu.main.CostType;
/*     */ import mzm.gsp.qingfu.main.QingfuInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import xbean.FabaoArtifactRecord;
/*     */ import xbean.FabaoArtifactRecords;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PImproveArtifactUseAll
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final int artifactClassId;
/*     */   private final int propertyType;
/*     */   private final boolean useYuanbao;
/*     */   private final long clientYuanbao;
/*     */   
/*     */   public PImproveArtifactUseAll(long roleId, int artifactClassId, int propertyType, boolean useYuanbao, long clientYuanbao)
/*     */   {
/*  36 */     this.roleId = roleId;
/*  37 */     this.artifactClassId = artifactClassId;
/*  38 */     this.propertyType = propertyType;
/*  39 */     this.useYuanbao = useYuanbao;
/*  40 */     this.clientYuanbao = clientYuanbao;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  46 */     if (!FabaoArtifactManager.isEnable())
/*     */     {
/*  48 */       return false;
/*     */     }
/*  50 */     if (GameServerInfoManager.isRoamServer())
/*     */     {
/*  52 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  56 */     String userId = RoleInterface.getUserId(this.roleId);
/*  57 */     if (userId == null)
/*     */     {
/*  59 */       return false;
/*     */     }
/*  61 */     if ((QingfuInterface.getBalance(userId, true) != this.clientYuanbao) && (this.useYuanbao))
/*     */     {
/*  63 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  67 */     FabaoArtifactRecords xRecords = FabaoArtifactManager.getRecords(this.roleId, true);
/*  68 */     if (xRecords == null)
/*     */     {
/*  70 */       return false;
/*     */     }
/*  72 */     FabaoArtifactRecord xRecord = (FabaoArtifactRecord)xRecords.getRecords().get(Integer.valueOf(this.artifactClassId));
/*  73 */     if (xRecord == null)
/*     */     {
/*  75 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  79 */     int artifactLevel = xRecord.getLevel();
/*  80 */     SFabaoArtifactPropertyTable propertyTable = FabaoArtifactManager.getPropertyTable(this.artifactClassId, artifactLevel);
/*  81 */     if (propertyTable == null)
/*     */     {
/*  83 */       return false;
/*     */     }
/*  85 */     ArtifactProperty artifactProperty = (ArtifactProperty)propertyTable.propertyMap.get(Integer.valueOf(this.propertyType));
/*  86 */     if (artifactProperty == null)
/*     */     {
/*  88 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  92 */     if ((artifactProperty.improvedValue == 0) || (artifactProperty.itemFilterId == 0) || (artifactProperty.itemNum == 0))
/*     */     {
/*  94 */       FabaoArtifactProtocols.notifyImproveArtifactFail(this.roleId, 1, this.artifactClassId, this.propertyType);
/*     */       
/*  96 */       FabaoArtifactManager.error("PImproveArtifactUseAll.processImp()@not improvable|roleid=%d|artifact_classid=%d|property_type=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.artifactClassId), Integer.valueOf(this.propertyType) });
/*     */       
/*     */ 
/*  99 */       return false;
/*     */     }
/* 101 */     Integer currentValue = (Integer)xRecord.getProperties().get(Integer.valueOf(this.propertyType));
/* 102 */     if (currentValue == null)
/*     */     {
/* 104 */       return false;
/*     */     }
/* 106 */     int valueDiff = artifactProperty.finalValue - currentValue.intValue();
/* 107 */     if (valueDiff <= 0)
/*     */     {
/* 109 */       FabaoArtifactProtocols.notifyImproveArtifactFail(this.roleId, 2, this.artifactClassId, this.propertyType);
/*     */       
/* 111 */       FabaoArtifactManager.error("PImproveArtifactUseAll.processImp()@reach final value|roleid=%d|artifact_classid=%d|property_type=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.artifactClassId), Integer.valueOf(this.propertyType) });
/*     */       
/*     */ 
/* 114 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 118 */     SItemSiftCfg itemSiftCfg = SItemSiftCfg.get(artifactProperty.itemFilterId);
/* 119 */     if (itemSiftCfg == null)
/*     */     {
/* 121 */       return false;
/*     */     }
/* 123 */     List<Integer> itemIds = new ArrayList();
/* 124 */     List<Integer> itemNums = new ArrayList();
/* 125 */     int totalItemNum = 0;
/* 126 */     for (IdTypeValueBean idTypeValueBean : itemSiftCfg.idTypeValueBeans)
/*     */     {
/* 128 */       itemIds.add(Integer.valueOf(idTypeValueBean.idvalue));
/*     */     }
/* 130 */     for (Integer itemId : itemIds)
/*     */     {
/* 132 */       int itemNum = ItemInterface.getItemNumberById(this.roleId, itemId.intValue());
/* 133 */       totalItemNum += itemNum;
/* 134 */       itemNums.add(Integer.valueOf(itemNum));
/*     */     }
/*     */     
/* 137 */     int maxImprovableValue = valueDiff / artifactProperty.improvedValue * artifactProperty.improvedValue;
/* 138 */     int maxConsumedItemNum = valueDiff / artifactProperty.improvedValue * artifactProperty.itemNum;
/*     */     
/* 140 */     TLogArg tLogArg = new TLogArg(LogReason.IMPROVE_FABAO_ARTIFACT);
/* 141 */     if ((totalItemNum >= maxConsumedItemNum) || (!this.useYuanbao))
/*     */     {
/*     */ 
/*     */ 
/* 145 */       int consumedItemNum = totalItemNum > maxConsumedItemNum ? maxConsumedItemNum : totalItemNum / artifactProperty.itemNum * artifactProperty.itemNum;
/*     */       
/* 147 */       if (consumedItemNum == 0)
/*     */       {
/* 149 */         FabaoArtifactProtocols.notifyImproveArtifactFail(this.roleId, 4, this.artifactClassId, this.propertyType);
/*     */         
/* 151 */         FabaoArtifactManager.error("PImproveArtifactUseAll.processImp()@insufficient item|roleid=%d|item_num=%d|minimum_item_num=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(totalItemNum), Integer.valueOf(artifactProperty.itemNum) });
/*     */         
/*     */ 
/* 154 */         return false;
/*     */       }
/* 156 */       int improvedValue = consumedItemNum / artifactProperty.itemNum * artifactProperty.improvedValue;
/*     */       
/* 158 */       int itemNumToConsume = improvedValue;
/* 159 */       for (int i = 0; (i < itemIds.size()) && (itemNumToConsume > 0); i++)
/*     */       {
/* 161 */         int itemId = ((Integer)itemIds.get(i)).intValue();
/* 162 */         int itemNum = Math.min(itemNumToConsume, ((Integer)itemNums.get(i)).intValue());
/* 163 */         if (itemNum > 0)
/*     */         {
/* 165 */           if (!ItemInterface.removeItemById(this.roleId, itemId, itemNum, tLogArg))
/*     */           {
/* 167 */             FabaoArtifactProtocols.notifyImproveArtifactFail(this.roleId, 3, this.artifactClassId, this.propertyType);
/*     */             
/* 169 */             FabaoArtifactManager.error("PImproveArtifactUseAll.processImp()@consume item failed|roleid=%d|itemid=%d|item_num=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(itemId), Integer.valueOf(itemNum) });
/*     */             
/* 171 */             return false;
/*     */           }
/* 173 */           itemNumToConsume -= itemNum;
/*     */         }
/*     */       }
/*     */       
/* 177 */       int newValue = currentValue.intValue() + improvedValue;
/* 178 */       xRecord.getProperties().put(Integer.valueOf(this.propertyType), Integer.valueOf(newValue));
/* 179 */       FabaoArtifactProtocols.notifyImproveArtifactUseAllSuccess(this.roleId, this.artifactClassId, this.propertyType, newValue, consumedItemNum, 0);
/*     */       
/* 181 */       FabaoArtifactEvents.triggerImproveArtifactEvent(this.roleId, this.artifactClassId, this.propertyType, currentValue.intValue(), newValue);
/* 182 */       FabaoArtifactManager.tlogImprove(this.roleId, this.artifactClassId, this.propertyType, newValue);
/* 183 */       FabaoArtifactManager.info("PImproveArtifactUseAll.processImp()@success|roleid=%d|artifact_classid=%d|property_type=%d|improved_value=%d|consumed_item_num=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.artifactClassId), Integer.valueOf(this.propertyType), Integer.valueOf(improvedValue), Integer.valueOf(consumedItemNum) });
/*     */ 
/*     */ 
/*     */     }
/*     */     else
/*     */     {
/*     */ 
/* 190 */       int lackedItemNum = maxConsumedItemNum;
/* 191 */       for (int i = 0; i < itemIds.size(); i++)
/*     */       {
/* 193 */         int itemId = ((Integer)itemIds.get(i)).intValue();
/* 194 */         int itemNum = ((Integer)itemNums.get(i)).intValue();
/* 195 */         if (itemNum != 0)
/*     */         {
/* 197 */           if (!ItemInterface.removeItemById(this.roleId, itemId, itemNum, tLogArg))
/*     */           {
/* 199 */             FabaoArtifactProtocols.notifyImproveArtifactFail(this.roleId, 3, this.artifactClassId, this.propertyType);
/*     */             
/* 201 */             FabaoArtifactManager.error("PImproveArtifactUseAll.processImp()@consume item failed|roleid=%d|itemid=%d|item_num=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(itemId), Integer.valueOf(itemNum) });
/*     */             
/* 203 */             return false;
/*     */           }
/* 205 */           lackedItemNum -= itemNum;
/*     */         }
/*     */       }
/*     */       
/* 209 */       int requiredYuanbao = ItemInterface.getItemYuanBaoPrice(((Integer)itemIds.get(0)).intValue()) * lackedItemNum;
/* 210 */       CostResult costResult = QingfuInterface.costYuanbao(userId, this.roleId, requiredYuanbao, CostType.COST_BIND_FIRST_IMPROVE_FABAO_ARTIFACT, tLogArg);
/*     */       
/* 212 */       if (costResult != CostResult.Success)
/*     */       {
/* 214 */         FabaoArtifactProtocols.notifyImproveArtifactFail(this.roleId, 5, this.artifactClassId, this.propertyType);
/*     */         
/* 216 */         FabaoArtifactManager.error("PImproveArtifactUseAll.processImp()@insufficient yuanbao|roleid=%d|required_yuanbao=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(requiredYuanbao) });
/*     */         
/* 218 */         return false;
/*     */       }
/*     */       
/* 221 */       int newValue = currentValue.intValue() + maxImprovableValue;
/* 222 */       xRecord.getProperties().put(Integer.valueOf(this.propertyType), Integer.valueOf(newValue));
/* 223 */       FabaoArtifactProtocols.notifyImproveArtifactUseAllSuccess(this.roleId, this.artifactClassId, this.propertyType, newValue, totalItemNum, requiredYuanbao);
/*     */       
/* 225 */       FabaoArtifactEvents.triggerImproveArtifactEvent(this.roleId, this.artifactClassId, this.propertyType, currentValue.intValue(), newValue);
/* 226 */       FabaoArtifactManager.tlogImprove(this.roleId, this.artifactClassId, this.propertyType, newValue);
/* 227 */       FabaoArtifactManager.info("PImproveArtifactUseAll.processImp()@success|roleid=%d|artifact_classid=%d|property_type=%d|improved_value=%d|consumed_item_num=%d|consumed_yuanbao=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.artifactClassId), Integer.valueOf(this.propertyType), Integer.valueOf(maxImprovableValue), Integer.valueOf(totalItemNum), Integer.valueOf(requiredYuanbao) });
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 232 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fabaolingqi\main\PImproveArtifactUseAll.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */