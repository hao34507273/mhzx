/*     */ package mzm.gsp.superequipment.main;
/*     */ 
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.item.main.BasicItem;
/*     */ import mzm.gsp.item.main.EquipmentItem;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.item.main.ItemOperateResult;
/*     */ import mzm.gsp.qingfu.main.CostResult;
/*     */ import mzm.gsp.qingfu.main.CostType;
/*     */ import mzm.gsp.qingfu.main.QingfuInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.superequipment.confbean.SSuperEquipmentStageCfg;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import xtable.User;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PImproveSuperEquipmentStage
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final int bagId;
/*     */   private final int grid;
/*     */   private final boolean useYuanbao;
/*     */   private final int requiredYuanbao;
/*     */   private final int currency;
/*     */   
/*     */   public PImproveSuperEquipmentStage(long roleId, int bagId, int grid, boolean useYuanbao, long requiredYuanbao, long currency)
/*     */   {
/*  36 */     this.roleId = roleId;
/*  37 */     this.bagId = bagId;
/*  38 */     this.grid = grid;
/*  39 */     this.useYuanbao = useYuanbao;
/*  40 */     this.requiredYuanbao = ((int)requiredYuanbao);
/*  41 */     this.currency = ((int)currency);
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  47 */     if (!SuperEquipmentManager.checkBasicConditions(this.roleId)) {
/*  48 */       return false;
/*     */     }
/*     */     
/*  51 */     String userId = RoleInterface.getUserId(this.roleId);
/*  52 */     if (userId == null)
/*  53 */       return false;
/*  54 */     lock(User.getTable(), Collections.singleton(userId));
/*     */     
/*     */ 
/*  57 */     BasicItem basicItem = ItemInterface.getItem(this.roleId, this.bagId, this.grid);
/*  58 */     if (basicItem == null)
/*  59 */       return false;
/*  60 */     if (!(basicItem instanceof EquipmentItem)) {
/*  61 */       return false;
/*     */     }
/*  63 */     EquipmentItem item = (EquipmentItem)basicItem;
/*  64 */     if (!SuperEquipmentManager.canImproveStage(this.roleId, item)) {
/*  65 */       return false;
/*     */     }
/*  67 */     if (!validateRoleCurrency(item)) {
/*  68 */       return false;
/*     */     }
/*  70 */     if (this.useYuanbao)
/*     */     {
/*     */ 
/*  73 */       return false;
/*     */     }
/*  75 */     return processWithoutYuanbao(item);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean processWithYuanbao(EquipmentItem item)
/*     */   {
/*  83 */     if (!chargeCurrency(item, false)) {
/*  84 */       return false;
/*     */     }
/*  86 */     RemoveResult removeResult = removeImprovingItems(item, true);
/*  87 */     if (((removeResult == RemoveResult.NONE) || (removeResult == RemoveResult.PARTIAL)) && 
/*  88 */       (!chargeYuanbao(item))) {
/*  89 */       return false;
/*     */     }
/*  91 */     finishImproveStage(item, true);
/*  92 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean processWithoutYuanbao(EquipmentItem item)
/*     */   {
/* 102 */     RemoveResult removeResult = removeImprovingItems(item, false);
/* 103 */     if (removeResult == RemoveResult.ALREADY_ALL)
/*     */     {
/* 105 */       if (chargeCurrency(item, false))
/*     */       {
/* 107 */         finishImproveStage(item, true);
/* 108 */         return true;
/*     */       }
/*     */       
/*     */ 
/* 112 */       return false;
/*     */     }
/*     */     
/* 115 */     if (removeResult == RemoveResult.ALL)
/*     */     {
/* 117 */       if (chargeCurrency(item, true))
/*     */       {
/* 119 */         finishImproveStage(item, true);
/* 120 */         return true;
/*     */       }
/*     */       
/*     */ 
/* 124 */       finishImproveStage(item, false);
/* 125 */       return true;
/*     */     }
/*     */     
/* 128 */     if (removeResult == RemoveResult.PARTIAL)
/*     */     {
/* 130 */       finishImproveStage(item, false);
/* 131 */       return true;
/*     */     }
/*     */     
/* 134 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean validateRoleCurrency(EquipmentItem item)
/*     */   {
/* 142 */     SSuperEquipmentStageCfg nextStageCfg = SuperEquipmentManager.getNextStageCfg(item);
/* 143 */     if (nextStageCfg == null) {
/* 144 */       return false;
/*     */     }
/* 146 */     boolean result = SuperEquipmentManager.getRoleCurrencyForImproving(this.roleId, nextStageCfg.requiredCurrencyType) == this.currency;
/*     */     
/* 148 */     if (!result) {
/* 149 */       SuperEquipmentManager.sendImproveStageFailAtOnce(this.roleId, 5);
/*     */     }
/* 151 */     return result;
/*     */   }
/*     */   
/*     */ 
/*     */   private static enum RemoveResult
/*     */   {
/* 157 */     NONE,  PARTIAL,  ALL,  ALREADY_ALL;
/*     */     
/*     */ 
/*     */     private RemoveResult() {}
/*     */   }
/*     */   
/*     */ 
/*     */   private RemoveResult removeImprovingItems(EquipmentItem item, boolean allowFail)
/*     */   {
/* 166 */     Map<Integer, Integer> lackedItems = SuperEquipmentManager.getLackedItemsForImprovingStage(item);
/* 167 */     if (lackedItems == null)
/* 168 */       return RemoveResult.NONE;
/* 169 */     if (lackedItems.isEmpty()) {
/* 170 */       return RemoveResult.ALREADY_ALL;
/*     */     }
/* 172 */     Map<Integer, Integer> removedItems = new HashMap();
/* 173 */     for (Map.Entry<Integer, Integer> e : lackedItems.entrySet())
/*     */     {
/* 175 */       int itemNumInBag = ItemInterface.getItemNumberById(this.roleId, ((Integer)e.getKey()).intValue());
/* 176 */       if (itemNumInBag != 0)
/*     */       {
/* 178 */         removedItems.put(e.getKey(), Integer.valueOf(Math.min(((Integer)e.getValue()).intValue(), itemNumInBag)));
/*     */       }
/*     */     }
/* 181 */     if (removedItems.isEmpty())
/*     */     {
/* 183 */       if (!allowFail)
/*     */       {
/* 185 */         SuperEquipmentManager.sendImproveStageFailAtOnce(this.roleId, 1);
/* 186 */         SuperEquipmentManager.error("PImproveSuperEquipmentStage.removeImprovingItems()@fail: no material|roleid=%d|item_uuid=%d|stage=%d", new Object[] { Long.valueOf(this.roleId), item.getFirstUuid(), Integer.valueOf(item.getSuperEquipmentStage()) });
/*     */       }
/*     */       
/*     */ 
/* 190 */       return RemoveResult.NONE;
/*     */     }
/*     */     
/* 193 */     TLogArg tLogArg = new TLogArg(LogReason.SUPER_EQUIPMENT_IMPROVE_STAGE);
/* 194 */     if (!ItemInterface.removeItemById(this.roleId, removedItems, tLogArg).success())
/*     */     {
/* 196 */       if (!allowFail)
/*     */       {
/* 198 */         SuperEquipmentManager.sendImproveStageFailAtOnce(this.roleId, 1);
/* 199 */         SuperEquipmentManager.error("PImproveSuperEquipmentStage.removeImprovingItems()@fail: removing items|roleid=%d|item_uuid=%d|stage=%d", new Object[] { Long.valueOf(this.roleId), item.getFirstUuid(), Integer.valueOf(item.getSuperEquipmentStage()) });
/*     */       }
/*     */       
/*     */ 
/* 203 */       return RemoveResult.NONE;
/*     */     }
/*     */     
/* 206 */     Map<Integer, Integer> stageCostMap = item.getSuperEquipmentImproveStageCostMap();
/* 207 */     for (Map.Entry<Integer, Integer> e : removedItems.entrySet())
/*     */     {
/* 209 */       Integer costNum = (Integer)stageCostMap.get(e.getKey());
/* 210 */       if (costNum == null)
/* 211 */         costNum = Integer.valueOf(0);
/* 212 */       stageCostMap.put(e.getKey(), Integer.valueOf(((Integer)e.getValue()).intValue() + costNum.intValue()));
/*     */     }
/*     */     
/* 215 */     lackedItems = SuperEquipmentManager.getLackedItemsForImprovingStage(item);
/* 216 */     if (lackedItems == null)
/* 217 */       return RemoveResult.NONE;
/* 218 */     return lackedItems.isEmpty() ? RemoveResult.ALL : RemoveResult.PARTIAL;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean chargeCurrency(EquipmentItem item, boolean allowFail)
/*     */   {
/* 228 */     SSuperEquipmentStageCfg nextStageCfg = SuperEquipmentManager.getNextStageCfg(item);
/* 229 */     if (nextStageCfg == null) {
/* 230 */       return false;
/*     */     }
/* 232 */     TLogArg tLogArg = new TLogArg(LogReason.SUPER_EQUIPMENT_IMPROVE_STAGE);
/* 233 */     boolean chargeResult = SuperEquipmentManager.chargeCurrencyForImproving(this.roleId, this.currency, CostType.COST_BIND_FIRST_IMPROVE_SUPER_EQUIPMENT_STAGE, tLogArg, nextStageCfg.requiredCurrencyType, nextStageCfg.requiredCurrencyNum);
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 238 */     if (!chargeResult)
/*     */     {
/* 240 */       if (!allowFail)
/*     */       {
/* 242 */         SuperEquipmentManager.sendImproveStageFailAtOnce(this.roleId, 3);
/* 243 */         SuperEquipmentManager.error("PImproveSuperEquipmentStage.processWithYuanbao()@fail: charging currency|roleid=%d|item_uuid=%d|stage=%d", new Object[] { Long.valueOf(this.roleId), item.getFirstUuid(), Integer.valueOf(item.getSuperEquipmentStage()) });
/*     */       }
/*     */       
/*     */ 
/* 247 */       return false;
/*     */     }
/*     */     
/* 250 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean chargeYuanbao(EquipmentItem item)
/*     */   {
/* 260 */     int realRequiredYuanbao = SuperEquipmentManager.getYuanbaoForImprovingStage(item);
/* 261 */     if (realRequiredYuanbao == -1) {
/* 262 */       return false;
/*     */     }
/* 264 */     if (realRequiredYuanbao != this.requiredYuanbao)
/*     */     {
/* 266 */       SuperEquipmentManager.sendImproveStageFailAtOnce(this.roleId, 4);
/* 267 */       SuperEquipmentManager.error("PImproveSuperEquipmentStage.processWithYuanbao()@required yuanbao mismatch|roleid=%d|item_uuid=%d|stage=%d|server_yuanbao=%d|client_yuanbao=%d", new Object[] { Long.valueOf(this.roleId), item.getFirstUuid(), Integer.valueOf(item.getSuperEquipmentStage()), Integer.valueOf(realRequiredYuanbao), Integer.valueOf(this.requiredYuanbao) });
/*     */       
/*     */ 
/* 270 */       return false;
/*     */     }
/*     */     
/* 273 */     String userId = RoleInterface.getUserId(this.roleId);
/* 274 */     if (userId == null)
/* 275 */       return false;
/* 276 */     TLogArg tLogArg = new TLogArg(LogReason.SUPER_EQUIPMENT_IMPROVE_STAGE);
/* 277 */     CostResult costResult = QingfuInterface.costYuanbao(userId, this.roleId, realRequiredYuanbao, CostType.COST_BIND_FIRST_IMPROVE_SUPER_EQUIPMENT_STAGE, tLogArg);
/*     */     
/* 279 */     if (costResult != CostResult.Success)
/*     */     {
/* 281 */       SuperEquipmentManager.sendImproveStageFailAtOnce(this.roleId, 2);
/* 282 */       SuperEquipmentManager.error("PImproveSuperEquipmentStage.chargeYuanbao()@fail: charging yuanbao|roleid=%d|item_uuid=%d|stage=%d|required_yuanbao=%d", new Object[] { Long.valueOf(this.roleId), item.getFirstUuid(), Integer.valueOf(item.getSuperEquipmentStage()), Integer.valueOf(realRequiredYuanbao) });
/*     */       
/*     */ 
/* 285 */       return false;
/*     */     }
/*     */     
/* 288 */     return true;
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
/*     */   private void finishImproveStage(EquipmentItem item, boolean improved)
/*     */   {
/* 301 */     if (improved)
/*     */     {
/* 303 */       item.setSuperEquipmentStage(item.getSuperEquipmentStage() + 1);
/* 304 */       item.getSuperEquipmentImproveStageCostMap().clear();
/* 305 */       SuperEquipmentManager.triggerStageImproved(this.roleId, item, this.bagId == 340600001);
/*     */     }
/* 307 */     SuperEquipmentManager.sendImproveStageSuccess(this.roleId, improved, item);
/* 308 */     SuperEquipmentManager.tlogImproveStage(this.roleId, item);
/* 309 */     SuperEquipmentManager.info("PImproveSuperEquipmentStage.finishImproveStage()@success|roleid=%d|item_uuid=%d|stage=%d|improved=%d", new Object[] { Long.valueOf(this.roleId), item.getFirstUuid(), Integer.valueOf(item.getSuperEquipmentStage()), Integer.valueOf(improved ? 1 : 0) });
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\superequipment\main\PImproveSuperEquipmentStage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */