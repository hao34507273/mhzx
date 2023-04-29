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
/*     */ import mzm.gsp.superequipment.confbean.SuperEquipmentLevelBean;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PImproveSuperEquipmentLevel
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final int bagId;
/*     */   private final int grid;
/*     */   private final boolean useYuanbao;
/*     */   private final int requiredYuanbao;
/*     */   private final int currency;
/*     */   
/*     */   public PImproveSuperEquipmentLevel(long roleId, int bagId, int grid, boolean useYuanbao, long requiredYuanbao, long currency)
/*     */   {
/*  33 */     this.roleId = roleId;
/*  34 */     this.bagId = bagId;
/*  35 */     this.grid = grid;
/*  36 */     this.useYuanbao = useYuanbao;
/*  37 */     this.requiredYuanbao = ((int)requiredYuanbao);
/*  38 */     this.currency = ((int)currency);
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  44 */     if (!SuperEquipmentManager.checkBasicConditions(this.roleId)) {
/*  45 */       return false;
/*     */     }
/*     */     
/*  48 */     String userId = RoleInterface.getUserId(this.roleId);
/*  49 */     if (userId == null)
/*  50 */       return false;
/*  51 */     lock(User.getTable(), Collections.singleton(userId));
/*     */     
/*     */ 
/*  54 */     BasicItem basicItem = ItemInterface.getItem(this.roleId, this.bagId, this.grid);
/*  55 */     if (basicItem == null)
/*  56 */       return false;
/*  57 */     if (!(basicItem instanceof EquipmentItem)) {
/*  58 */       return false;
/*     */     }
/*  60 */     EquipmentItem item = (EquipmentItem)basicItem;
/*  61 */     if (!SuperEquipmentManager.canImproveLevel(item)) {
/*  62 */       return false;
/*     */     }
/*  64 */     if (!validateRoleCurrency(item)) {
/*  65 */       return false;
/*     */     }
/*  67 */     if (this.useYuanbao)
/*     */     {
/*     */ 
/*  70 */       return false;
/*     */     }
/*  72 */     return processWithoutYuanbao(item);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean processWithYuanbao(EquipmentItem item)
/*     */   {
/*  80 */     if (!chargeCurrency(item, false)) {
/*  81 */       return false;
/*     */     }
/*  83 */     RemoveResult removeResult = removeImprovingItems(item, true);
/*  84 */     if (((removeResult == RemoveResult.NONE) || (removeResult == RemoveResult.PARTIAL)) && 
/*  85 */       (!chargeYuanbao(item))) {
/*  86 */       return false;
/*     */     }
/*  88 */     finishImproveLevel(item, true);
/*  89 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean processWithoutYuanbao(EquipmentItem item)
/*     */   {
/*  99 */     RemoveResult removeResult = removeImprovingItems(item, false);
/* 100 */     if (removeResult == RemoveResult.ALREADY_ALL)
/*     */     {
/* 102 */       if (chargeCurrency(item, false))
/*     */       {
/* 104 */         finishImproveLevel(item, true);
/* 105 */         return true;
/*     */       }
/*     */       
/*     */ 
/* 109 */       return false;
/*     */     }
/*     */     
/* 112 */     if (removeResult == RemoveResult.ALL)
/*     */     {
/* 114 */       if (chargeCurrency(item, true))
/*     */       {
/* 116 */         finishImproveLevel(item, true);
/* 117 */         return true;
/*     */       }
/*     */       
/*     */ 
/* 121 */       finishImproveLevel(item, false);
/* 122 */       return true;
/*     */     }
/*     */     
/* 125 */     if (removeResult == RemoveResult.PARTIAL)
/*     */     {
/* 127 */       finishImproveLevel(item, false);
/* 128 */       return true;
/*     */     }
/*     */     
/* 131 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean validateRoleCurrency(EquipmentItem item)
/*     */   {
/* 139 */     SuperEquipmentLevelBean nextLevelBean = SuperEquipmentManager.getNextLevelBean(item);
/* 140 */     if (nextLevelBean == null) {
/* 141 */       return false;
/*     */     }
/* 143 */     boolean result = SuperEquipmentManager.getRoleCurrencyForImproving(this.roleId, nextLevelBean.requiredCurrencyType) == this.currency;
/*     */     
/* 145 */     if (!result) {
/* 146 */       SuperEquipmentManager.sendImproveLevelFailAtOnce(this.roleId, 5);
/*     */     }
/* 148 */     return result;
/*     */   }
/*     */   
/*     */ 
/*     */   private static enum RemoveResult
/*     */   {
/* 154 */     NONE,  PARTIAL,  ALL,  ALREADY_ALL;
/*     */     
/*     */ 
/*     */     private RemoveResult() {}
/*     */   }
/*     */   
/*     */ 
/*     */   private RemoveResult removeImprovingItems(EquipmentItem item, boolean allowFail)
/*     */   {
/* 163 */     Map<Integer, Integer> lackedItems = SuperEquipmentManager.getLackedItemsForImprovingLevel(item);
/* 164 */     if (lackedItems == null)
/* 165 */       return RemoveResult.NONE;
/* 166 */     if (lackedItems.isEmpty()) {
/* 167 */       return RemoveResult.ALREADY_ALL;
/*     */     }
/* 169 */     Map<Integer, Integer> removedItems = new HashMap();
/* 170 */     for (Map.Entry<Integer, Integer> e : lackedItems.entrySet())
/*     */     {
/* 172 */       int itemNumInBag = ItemInterface.getItemNumberById(this.roleId, ((Integer)e.getKey()).intValue());
/* 173 */       if (itemNumInBag != 0)
/*     */       {
/* 175 */         removedItems.put(e.getKey(), Integer.valueOf(Math.min(((Integer)e.getValue()).intValue(), itemNumInBag)));
/*     */       }
/*     */     }
/* 178 */     if (removedItems.isEmpty())
/*     */     {
/* 180 */       if (!allowFail)
/*     */       {
/* 182 */         SuperEquipmentManager.sendImproveLevelFailAtOnce(this.roleId, 1);
/* 183 */         SuperEquipmentManager.error("PImproveSuperEquipmentLevel.removeImprovingItems()@fail: no material|roleid=%d|item_uuid=%d|level=%d", new Object[] { Long.valueOf(this.roleId), item.getFirstUuid(), Integer.valueOf(item.getSuperEquipmentLevel()) });
/*     */       }
/*     */       
/*     */ 
/* 187 */       return RemoveResult.NONE;
/*     */     }
/*     */     
/* 190 */     TLogArg tLogArg = new TLogArg(LogReason.SUPER_EQUIPMENT_IMPROVE_LEVEL);
/* 191 */     if (!ItemInterface.removeItemById(this.roleId, removedItems, tLogArg).success())
/*     */     {
/* 193 */       if (!allowFail)
/*     */       {
/* 195 */         SuperEquipmentManager.sendImproveLevelFailAtOnce(this.roleId, 1);
/* 196 */         SuperEquipmentManager.error("PImproveSuperEquipmentLevel.removeImprovingItems()@fail: removing items|roleid=%d|item_uuid=%d|level=%d", new Object[] { Long.valueOf(this.roleId), item.getFirstUuid(), Integer.valueOf(item.getSuperEquipmentLevel()) });
/*     */       }
/*     */       
/*     */ 
/* 200 */       return RemoveResult.NONE;
/*     */     }
/*     */     
/* 203 */     Map<Integer, Integer> levelCostMap = item.getSuperEquipmentImproveLevelCostMap();
/* 204 */     for (Map.Entry<Integer, Integer> e : removedItems.entrySet())
/*     */     {
/* 206 */       Integer costNum = (Integer)levelCostMap.get(e.getKey());
/* 207 */       if (costNum == null)
/* 208 */         costNum = Integer.valueOf(0);
/* 209 */       levelCostMap.put(e.getKey(), Integer.valueOf(((Integer)e.getValue()).intValue() + costNum.intValue()));
/*     */     }
/*     */     
/* 212 */     lackedItems = SuperEquipmentManager.getLackedItemsForImprovingLevel(item);
/* 213 */     if (lackedItems == null)
/* 214 */       return RemoveResult.NONE;
/* 215 */     return lackedItems.isEmpty() ? RemoveResult.ALL : RemoveResult.PARTIAL;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean chargeCurrency(EquipmentItem item, boolean allowFail)
/*     */   {
/* 225 */     SuperEquipmentLevelBean nextLevelBean = SuperEquipmentManager.getNextLevelBean(item);
/* 226 */     if (nextLevelBean == null) {
/* 227 */       return false;
/*     */     }
/* 229 */     TLogArg tLogArg = new TLogArg(LogReason.SUPER_EQUIPMENT_IMPROVE_LEVEL);
/* 230 */     boolean chargeResult = SuperEquipmentManager.chargeCurrencyForImproving(this.roleId, this.currency, CostType.COST_BIND_FIRST_IMPROVE_SUPER_EQUIPMENT_LEVEL, tLogArg, nextLevelBean.requiredCurrencyType, nextLevelBean.requiredCurrencyNum);
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 235 */     if (!chargeResult)
/*     */     {
/* 237 */       if (!allowFail)
/*     */       {
/* 239 */         SuperEquipmentManager.sendImproveLevelFailAtOnce(this.roleId, 3);
/* 240 */         SuperEquipmentManager.error("PImproveSuperEquipmentLevel.processWithYuanbao()@fail: charging currency|roleid=%d|item_uuid=%d|level=%d", new Object[] { Long.valueOf(this.roleId), item.getFirstUuid(), Integer.valueOf(item.getSuperEquipmentLevel()) });
/*     */       }
/*     */       
/*     */ 
/* 244 */       return false;
/*     */     }
/*     */     
/* 247 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean chargeYuanbao(EquipmentItem item)
/*     */   {
/* 257 */     int realRequiredYuanbao = SuperEquipmentManager.getYuanbaoForImprovingLevel(item);
/* 258 */     if (realRequiredYuanbao == -1) {
/* 259 */       return false;
/*     */     }
/* 261 */     if (realRequiredYuanbao != this.requiredYuanbao)
/*     */     {
/* 263 */       SuperEquipmentManager.sendImproveLevelFailAtOnce(this.roleId, 4);
/* 264 */       SuperEquipmentManager.error("PImproveSuperEquipmentLevel.chargeYuanbao()@required yuanbao mismatch|roleid=%d|item_uuid=%d|level=%d|server_yuanbao=%d|client_yuanbao=%d", new Object[] { Long.valueOf(this.roleId), item.getFirstUuid(), Integer.valueOf(item.getSuperEquipmentLevel()), Integer.valueOf(realRequiredYuanbao), Integer.valueOf(this.requiredYuanbao) });
/*     */       
/*     */ 
/* 267 */       return false;
/*     */     }
/*     */     
/* 270 */     String userId = RoleInterface.getUserId(this.roleId);
/* 271 */     if (userId == null)
/* 272 */       return false;
/* 273 */     TLogArg tLogArg = new TLogArg(LogReason.SUPER_EQUIPMENT_IMPROVE_LEVEL);
/* 274 */     CostResult costResult = QingfuInterface.costYuanbao(userId, this.roleId, realRequiredYuanbao, CostType.COST_BIND_FIRST_IMPROVE_SUPER_EQUIPMENT_LEVEL, tLogArg);
/*     */     
/* 276 */     if (costResult != CostResult.Success)
/*     */     {
/* 278 */       SuperEquipmentManager.sendImproveLevelFailAtOnce(this.roleId, 2);
/* 279 */       SuperEquipmentManager.error("PImproveSuperEquipmentLevel.chargeYuanbao()@fail: charging yuanbao|roleid=%d|item_uuid=%d|level=%d|required_yuanbao=%d", new Object[] { Long.valueOf(this.roleId), item.getFirstUuid(), Integer.valueOf(item.getSuperEquipmentLevel()), Integer.valueOf(realRequiredYuanbao) });
/*     */       
/*     */ 
/* 282 */       return false;
/*     */     }
/*     */     
/* 285 */     return true;
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
/*     */   private void finishImproveLevel(EquipmentItem item, boolean improved)
/*     */   {
/* 298 */     if (improved)
/*     */     {
/* 300 */       item.setSuperEquipmentLevel(item.getSuperEquipmentLevel() + 1);
/* 301 */       item.getSuperEquipmentImproveLevelCostMap().clear();
/* 302 */       SuperEquipmentManager.triggerLevelImproved(this.roleId, item, this.bagId == 340600001);
/*     */     }
/* 304 */     SuperEquipmentManager.sendImproveLevelSuccess(this.roleId, improved, item);
/* 305 */     SuperEquipmentManager.tlogImproveLevel(this.roleId, item);
/* 306 */     SuperEquipmentManager.info("PImproveSuperEquipmentLevel.finishImproveLevel()@success|roleid=%d|item_uuid=%d|level=%d|improved=%d", new Object[] { Long.valueOf(this.roleId), item.getFirstUuid(), Integer.valueOf(item.getSuperEquipmentLevel()), Integer.valueOf(improved ? 1 : 0) });
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\superequipment\main\PImproveSuperEquipmentLevel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */