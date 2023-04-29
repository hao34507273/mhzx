/*     */ package mzm.gsp.fabaolingqi.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.fabaolingqi.confbean.ArtifactProperty;
/*     */ import mzm.gsp.fabaolingqi.confbean.SFabaoArtifactPropertyTable;
/*     */ import mzm.gsp.item.confbean.IdTypeValueBean;
/*     */ import mzm.gsp.item.confbean.SItemSiftCfg;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.item.main.ItemOperateResult;
/*     */ import mzm.gsp.qingfu.main.CostResult;
/*     */ import mzm.gsp.qingfu.main.CostType;
/*     */ import mzm.gsp.qingfu.main.QingfuInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import xbean.FabaoArtifactRecord;
/*     */ import xbean.FabaoArtifactRecords;
/*     */ import xtable.User;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PImproveArtifact
/*     */   extends LogicProcedure
/*     */ {
/*     */   private long roleId;
/*     */   private int artifactClassId;
/*     */   private int propertyType;
/*     */   private boolean useYuanbao;
/*     */   private long clientYuanbao;
/*     */   
/*     */   public PImproveArtifact(long roleId, int artifactClassId, int propertyType, boolean useYuanbao, long clientYuanbao)
/*     */   {
/*  40 */     this.roleId = roleId;
/*  41 */     this.artifactClassId = artifactClassId;
/*  42 */     this.propertyType = propertyType;
/*  43 */     this.useYuanbao = useYuanbao;
/*  44 */     this.clientYuanbao = clientYuanbao;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  50 */     if (!FabaoArtifactManager.isEnable())
/*  51 */       return false;
/*  52 */     if (GameServerInfoManager.isRoamServer()) {
/*  53 */       return false;
/*     */     }
/*     */     
/*  56 */     String userId = RoleInterface.getUserId(this.roleId);
/*  57 */     lock(User.getTable(), Collections.singleton(userId));
/*  58 */     if ((this.useYuanbao) && (QingfuInterface.getBalance(userId, true) != this.clientYuanbao)) {
/*  59 */       return false;
/*     */     }
/*     */     
/*  62 */     FabaoArtifactRecords xRecords = FabaoArtifactManager.getRecords(this.roleId, true);
/*  63 */     if (xRecords == null)
/*  64 */       return false;
/*  65 */     FabaoArtifactRecord xRecord = (FabaoArtifactRecord)xRecords.getRecords().get(Integer.valueOf(this.artifactClassId));
/*  66 */     if (xRecord == null) {
/*  67 */       return false;
/*     */     }
/*     */     
/*  70 */     int artifactLevel = xRecord.getLevel();
/*  71 */     SFabaoArtifactPropertyTable propertyTable = FabaoArtifactManager.getPropertyTable(this.artifactClassId, artifactLevel);
/*  72 */     if (propertyTable == null)
/*     */     {
/*  74 */       FabaoArtifactManager.error("PImproveArtifact.processImp()@property table not found|artifact_classid=%d|artifact_level=%d", new Object[] { Integer.valueOf(this.artifactClassId), Integer.valueOf(artifactLevel) });
/*     */       
/*     */ 
/*  77 */       return false;
/*     */     }
/*  79 */     ArtifactProperty artifactProperty = (ArtifactProperty)propertyTable.propertyMap.get(Integer.valueOf(this.propertyType));
/*  80 */     if (artifactProperty == null)
/*     */     {
/*  82 */       FabaoArtifactManager.error("PImproveArtifact.processImp()@property type not found|artifact_classid=%d|artifact_level=%d|property_type=%d", new Object[] { Integer.valueOf(this.artifactClassId), Integer.valueOf(artifactLevel), Integer.valueOf(this.propertyType) });
/*     */       
/*     */ 
/*  85 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  89 */     if ((artifactProperty.improvedValue == 0) || (artifactProperty.itemNum == 0) || (artifactProperty.itemFilterId == 0))
/*     */     {
/*  91 */       FabaoArtifactProtocols.notifyImproveArtifactFail(this.roleId, 1, this.artifactClassId, this.propertyType);
/*  92 */       FabaoArtifactManager.info("PImproveArtifact.processImp()@property not improvable|artifact_classid=%d|artifact_level=%d|property_type=%d", new Object[] { Integer.valueOf(this.artifactClassId), Integer.valueOf(artifactLevel), Integer.valueOf(this.propertyType) });
/*     */       
/*     */ 
/*  95 */       return false;
/*     */     }
/*  97 */     int oldValue = ((Integer)xRecord.getProperties().get(Integer.valueOf(this.propertyType))).intValue();
/*  98 */     if (oldValue >= artifactProperty.finalValue)
/*     */     {
/* 100 */       FabaoArtifactProtocols.notifyImproveArtifactFail(this.roleId, 2, this.artifactClassId, this.propertyType);
/* 101 */       FabaoArtifactManager.info("PImproveArtifact.processImp()@reach maximum|roleid=%d|artifact_classid=%d|artifact_level=%d|property_type=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.artifactClassId), Integer.valueOf(artifactLevel), Integer.valueOf(this.propertyType) });
/*     */       
/*     */ 
/* 104 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 108 */     SItemSiftCfg itemSiftCfg = SItemSiftCfg.get(artifactProperty.itemFilterId);
/* 109 */     if ((itemSiftCfg == null) || (itemSiftCfg.idTypeValueBeans.size() == 0))
/*     */     {
/* 111 */       FabaoArtifactManager.error("PImproveArtifact.processImp()@invalid filter id|artifact_classid=%d|artifact_level=%d|property_type=%d|item_filter_cfgid=%d", new Object[] { Integer.valueOf(this.artifactClassId), Integer.valueOf(artifactLevel), Integer.valueOf(this.propertyType), Integer.valueOf(artifactProperty.itemFilterId) });
/*     */       
/*     */ 
/* 114 */       return false;
/*     */     }
/* 116 */     List<Integer> improveItemIds = new ArrayList();
/* 117 */     for (IdTypeValueBean bean : itemSiftCfg.idTypeValueBeans)
/* 118 */       improveItemIds.add(Integer.valueOf(bean.idvalue));
/* 119 */     ArrayList<Integer> improveItemNums = new ArrayList();
/* 120 */     for (Iterator i$ = improveItemIds.iterator(); i$.hasNext();) { int itemId = ((Integer)i$.next()).intValue();
/* 121 */       improveItemNums.add(Integer.valueOf(ItemInterface.getItemNumberById(this.roleId, itemId)));
/*     */     }
/*     */     
/* 124 */     int lackedItemNum = artifactProperty.itemNum;
/* 125 */     HashMap<Integer, Integer> itemCostMap = new HashMap();
/* 126 */     for (int i = 0; (i < improveItemIds.size()) && (lackedItemNum > 0); i++)
/*     */     {
/* 128 */       int itemId = ((Integer)improveItemIds.get(i)).intValue();
/* 129 */       int itemNum = ((Integer)improveItemNums.get(i)).intValue();
/*     */       
/* 131 */       if (itemNum != 0)
/*     */       {
/*     */ 
/* 134 */         int costNum = Math.min(itemNum, lackedItemNum);
/* 135 */         itemCostMap.put(Integer.valueOf(itemId), Integer.valueOf(costNum));
/* 136 */         lackedItemNum -= costNum;
/*     */       }
/*     */     }
/* 139 */     int improveItemYuanbaoPrice = ItemInterface.getItemYuanBaoPrice(((Integer)improveItemIds.get(0)).intValue());
/* 140 */     if (lackedItemNum == artifactProperty.itemNum)
/*     */     {
/* 142 */       if (this.useYuanbao)
/*     */       {
/* 144 */         if (!chargeYuanbao(userId, improveItemYuanbaoPrice * lackedItemNum))
/*     */         {
/* 146 */           return false;
/*     */         }
/*     */       }
/*     */       else
/*     */       {
/* 151 */         FabaoArtifactProtocols.notifyImproveArtifactFail(this.roleId, 3, this.artifactClassId, this.propertyType);
/* 152 */         FabaoArtifactManager.info("PImproveArtifact.processImp()@no item|roleid=%d|artifact_classid=%d|artifact_level=%d|property_type=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.artifactClassId), Integer.valueOf(artifactLevel), Integer.valueOf(this.propertyType) });
/*     */         
/*     */ 
/* 155 */         return false;
/*     */       }
/*     */     }
/* 158 */     else if (lackedItemNum > 0)
/*     */     {
/* 160 */       if (this.useYuanbao)
/*     */       {
/* 162 */         if (!chargeYuanbao(userId, improveItemYuanbaoPrice * lackedItemNum))
/*     */         {
/* 164 */           return false;
/*     */         }
/*     */       }
/*     */       else
/*     */       {
/* 169 */         FabaoArtifactProtocols.notifyImproveArtifactFail(this.roleId, 4, this.artifactClassId, this.propertyType);
/* 170 */         FabaoArtifactManager.info("PImproveArtifact.processImp()@item not enough|roleid=%d|artifact_classid=%d|artifact_level=%d|property_type=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.artifactClassId), Integer.valueOf(artifactLevel), Integer.valueOf(this.propertyType) });
/*     */         
/*     */ 
/* 173 */         return false;
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 178 */     int newValue = Math.min(oldValue + artifactProperty.improvedValue, artifactProperty.finalValue);
/* 179 */     xRecord.getProperties().put(Integer.valueOf(this.propertyType), Integer.valueOf(newValue));
/* 180 */     TLogArg tLogArg = new TLogArg(LogReason.IMPROVE_FABAO_ARTIFACT);
/* 181 */     if (lackedItemNum != artifactProperty.itemNum)
/*     */     {
/* 183 */       if (!ItemInterface.removeItemById(this.roleId, itemCostMap, tLogArg).success())
/*     */       {
/* 185 */         FabaoArtifactProtocols.notifyImproveArtifactFail(this.roleId, 4, this.artifactClassId, this.propertyType);
/* 186 */         FabaoArtifactManager.error("PImproveArtifact.processImp()@removing items failed|roleid=%d|artifact_classid=%d|artifact_level=%d|property_type=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.artifactClassId), Integer.valueOf(artifactLevel), Integer.valueOf(this.propertyType) });
/*     */         
/*     */ 
/* 189 */         return false;
/*     */       }
/*     */     }
/* 192 */     FabaoArtifactProtocols.notifyImproveArtifactSuccess(this.roleId, this.artifactClassId, this.propertyType, newValue);
/* 193 */     FabaoArtifactManager.tlogImprove(this.roleId, this.artifactClassId, this.propertyType, newValue);
/* 194 */     FabaoArtifactEvents.triggerImproveArtifactEvent(this.roleId, this.artifactClassId, this.propertyType, oldValue, newValue);
/* 195 */     FabaoArtifactManager.info("PImproveArtifact.processImp()@done|roleid=%d|artifact_classid=%d|artifact_level=%d|property_type=%d|property_value=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.artifactClassId), Integer.valueOf(artifactLevel), Integer.valueOf(this.propertyType), Integer.valueOf(newValue) });
/*     */     
/*     */ 
/* 198 */     return true;
/*     */   }
/*     */   
/*     */   private boolean chargeYuanbao(String userId, int num)
/*     */   {
/* 203 */     TLogArg tLogArg = new TLogArg(LogReason.IMPROVE_FABAO_ARTIFACT);
/* 204 */     CostResult costResult = QingfuInterface.costYuanbao(userId, this.roleId, num, CostType.COST_BIND_FIRST_IMPROVE_FABAO_ARTIFACT, tLogArg);
/*     */     
/* 206 */     if (costResult != CostResult.Success)
/*     */     {
/* 208 */       FabaoArtifactProtocols.notifyImproveArtifactFail(this.roleId, 5, this.artifactClassId, this.propertyType);
/*     */       
/* 210 */       FabaoArtifactManager.info("PImproveArtifact.chargeYuanbao()@insufficient yuanbao|roleid=%d|artifact_classid=%d|property_type=%d|user_yuanbao=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.artifactClassId), Integer.valueOf(this.propertyType), Long.valueOf(QingfuInterface.getBalance(userId, true)) });
/*     */       
/*     */ 
/* 213 */       return false;
/*     */     }
/* 215 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fabaolingqi\main\PImproveArtifact.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */