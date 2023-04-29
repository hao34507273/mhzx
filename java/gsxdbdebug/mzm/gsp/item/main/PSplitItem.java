/*     */ package mzm.gsp.item.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Random;
/*     */ import mzm.gsp.function.confbean.SItemSplitCfg;
/*     */ import mzm.gsp.function.confbean.SItemSplitResult;
/*     */ import mzm.gsp.function.confbean.SItemSplitResultCfg;
/*     */ import mzm.gsp.item.SSplitItemRes;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import org.apache.log4j.Logger;
/*     */ import xdb.Xdb;
/*     */ 
/*     */ public class PSplitItem extends mzm.gsp.util.LogicProcedure
/*     */ {
/*  22 */   private final int MAX_PROBABILITY = 10000;
/*     */   
/*     */   private final long roleId;
/*     */   private final long itemUUID;
/*     */   private final boolean splitAll;
/*     */   
/*     */   public PSplitItem(long roleId, long itemUUID, boolean splitAll)
/*     */   {
/*  30 */     this.roleId = roleId;
/*  31 */     this.itemUUID = itemUUID;
/*  32 */     this.splitAll = splitAll;
/*     */   }
/*     */   
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  39 */     if (!ItemModuleSwitchInterface.isItemSplitSwitchOpenForRole(this.roleId))
/*  40 */       return false;
/*  41 */     if (!ItemManager.isRoleStateCanOperateItem(this.roleId)) {
/*  42 */       return false;
/*     */     }
/*     */     
/*  45 */     BasicItem item = ItemInterface.getItemByUuid(this.roleId, this.itemUUID);
/*  46 */     if (item == null)
/*  47 */       return false;
/*  48 */     SItemSplitCfg splitCfg = SItemSplitCfg.get(item.getCfgId());
/*  49 */     if (splitCfg == null)
/*     */     {
/*  51 */       logError("PSplitItem.processImp()@item cannot be split|roleid=%d|item_cfgid=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(item.getCfgId()) });
/*  52 */       ItemManager.sendWrongInfo(this.roleId, 1195, new String[0]);
/*  53 */       return false;
/*     */     }
/*  55 */     if ((item.isBind()) && (!splitCfg.canSplitBind))
/*     */     {
/*  57 */       logError("PSplitItem.processImp()@bind item cannot be split|roleid=%d|item_cfgid=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(item.getCfgId()) });
/*  58 */       ItemManager.sendWrongInfo(this.roleId, 1197, new String[0]);
/*  59 */       return false;
/*     */     }
/*  61 */     if ((this.splitAll) && (!splitCfg.canSplitAll))
/*     */     {
/*  63 */       logError("PSplitItem.processImp()@items cannot be split all|roleid=%d|item_cfgid=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(item.getCfgId()) });
/*  64 */       ItemManager.sendWrongInfo(this.roleId, 1196, new String[0]);
/*  65 */       return false;
/*     */     }
/*     */     
/*     */     int splitNum;
/*     */     int splitNum;
/*  70 */     if (!this.splitAll)
/*     */     {
/*  72 */       splitNum = 1;
/*     */     } else { int splitNum;
/*  74 */       if (!splitCfg.canSplitBind)
/*     */       {
/*     */ 
/*  77 */         splitNum = getAllNonBindItemNumber(item.getCfgId());
/*     */       }
/*     */       else
/*     */       {
/*  81 */         splitNum = ItemInterface.getItemNumberById(this.roleId, item.getCfgId()); }
/*     */     }
/*  83 */     if (splitNum == 0) {
/*  84 */       return false;
/*     */     }
/*     */     
/*  87 */     TLogArg tLogArg = new TLogArg(LogReason.ITEM_SPLIT);
/*  88 */     if (splitCfg.requiredSilver > 0)
/*     */     {
/*  90 */       boolean r = RoleInterface.cutSilver(this.roleId, splitCfg.requiredSilver * splitNum, tLogArg);
/*  91 */       if (!r)
/*     */       {
/*  93 */         ItemManager.sendWrongInfo(this.roleId, 1198, new String[0]);
/*  94 */         logError("PSplitItem.processImp()@insufficient silver|roleid=%d|item_cfgid=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(item.getCfgId()) });
/*  95 */         return false;
/*     */       }
/*     */     }
/*  98 */     if (splitCfg.requiredGold > 0)
/*     */     {
/* 100 */       boolean r = RoleInterface.cutGold(this.roleId, splitCfg.requiredGold * splitNum, tLogArg);
/* 101 */       if (!r)
/*     */       {
/* 103 */         ItemManager.sendWrongInfo(this.roleId, 1199, new String[0]);
/* 104 */         logError("PSplitItem.processImp()@insufficient gold|roleid=%d|item_cfgid=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(item.getCfgId()) });
/* 105 */         return false;
/*     */       }
/*     */     }
/* 108 */     if (splitCfg.requiredVigor > 0)
/*     */     {
/* 110 */       boolean r = RoleInterface.cutVigor(this.roleId, splitCfg.requiredVigor * splitNum, tLogArg);
/* 111 */       if (!r)
/*     */       {
/* 113 */         ItemManager.sendWrongInfo(this.roleId, 1200, new String[0]);
/* 114 */         logError("PSplitItem.processImp()@insufficient vigor|roleid=%d|item_cfgid=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(item.getCfgId()) });
/* 115 */         return false;
/*     */       }
/*     */     }
/* 118 */     ItemOperateResult removeResult = ItemInterface.removeItemsWithBindFirst(this.roleId, item.getCfgId(), splitNum, tLogArg);
/*     */     
/* 120 */     if (!removeResult.success())
/*     */     {
/* 122 */       ItemManager.sendWrongInfo(this.roleId, 40, new String[0]);
/* 123 */       logError("PSplitItem.processImp()@failed on removing item|roleid=%d|item_cfgid=%d|split_num=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(item.getCfgId()), Integer.valueOf(splitNum) });
/*     */       
/* 125 */       return false;
/*     */     }
/*     */     
/* 128 */     Boolean resultIsRandom = checkResultRandom(splitCfg);
/* 129 */     if (resultIsRandom == null) {
/* 130 */       return false;
/*     */     }
/* 132 */     return resultIsRandom.booleanValue() ? addRandomItems(splitCfg, splitNum, tLogArg) : addFixedItems(splitCfg, splitNum, tLogArg);
/*     */   }
/*     */   
/*     */ 
/*     */   private void logError(String str, Object... args)
/*     */   {
/* 138 */     ItemManager.logger.error("[item]" + String.format(str, args));
/*     */   }
/*     */   
/*     */   private void notifySuccess(int splitNum, Map<Integer, Integer> acquiredItems)
/*     */   {
/* 143 */     SSplitItemRes res = new SSplitItemRes();
/* 144 */     res.item_uuid = this.itemUUID;
/* 145 */     res.split_num = splitNum;
/* 146 */     res.acquired_items.putAll(acquiredItems);
/* 147 */     OnlineManager.getInstance().send(this.roleId, res);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private int getAllNonBindItemNumber(int itemId)
/*     */   {
/* 155 */     RoleItemBag itemBag = ItemManager.getBagByItemId(this.roleId, 340600000, itemId, true);
/* 156 */     if (itemBag == null)
/* 157 */       return 0;
/* 158 */     int count = 0;
/* 159 */     for (BasicItem item : itemBag.getItemBycfgId(itemId).values())
/*     */     {
/* 161 */       if (!item.isBind())
/*     */       {
/* 163 */         count += item.getNumber();
/*     */       }
/*     */     }
/* 166 */     return count;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private Boolean checkResultRandom(SItemSplitCfg splitCfg)
/*     */   {
/* 174 */     for (SItemSplitResult result : splitCfg.results)
/*     */     {
/*     */ 
/* 177 */       if (result.resultProbability < 10000)
/* 178 */         return Boolean.valueOf(true);
/* 179 */       SItemSplitResultCfg resultCfg = SItemSplitResultCfg.get(result.resultId);
/* 180 */       if (resultCfg == null) {
/* 181 */         return null;
/*     */       }
/* 183 */       if (resultCfg.itemIds.size() > 1)
/* 184 */         return Boolean.valueOf(true);
/*     */     }
/* 186 */     return Boolean.valueOf(false);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean addFixedItems(SItemSplitCfg splitCfg, int splitNum, TLogArg tLogArg)
/*     */   {
/* 195 */     Map<Integer, Integer> bindItems = new HashMap();
/* 196 */     Map<Integer, Integer> nonBindItems = new HashMap();
/* 197 */     for (SItemSplitResult result : splitCfg.results)
/*     */     {
/* 199 */       SItemSplitResultCfg resultCfg = SItemSplitResultCfg.get(result.resultId);
/*     */       
/* 201 */       if (resultCfg == null)
/* 202 */         return false;
/* 203 */       if ((resultCfg.itemIds.isEmpty()) || (resultCfg.bindItems.isEmpty()) || (resultCfg.itemNums.isEmpty()))
/* 204 */         return false;
/* 205 */       Map<Integer, Integer> items = ((Boolean)resultCfg.bindItems.get(0)).booleanValue() ? bindItems : nonBindItems;
/* 206 */       int itemId = ((Integer)resultCfg.itemIds.get(0)).intValue();
/* 207 */       Integer itemNum = (Integer)items.get(Integer.valueOf(itemId));
/* 208 */       if (itemNum == null) {
/* 209 */         items.put(Integer.valueOf(itemId), Integer.valueOf(((Integer)resultCfg.itemNums.get(0)).intValue() * splitNum));
/*     */       } else {
/* 211 */         items.put(Integer.valueOf(itemId), Integer.valueOf(((Integer)resultCfg.itemNums.get(0)).intValue() * splitNum + itemNum.intValue()));
/*     */       }
/*     */     }
/*     */     
/* 215 */     if (!bindItems.isEmpty())
/*     */     {
/* 217 */       ItemOperateResult rBind = ItemInterface.addItem(this.roleId, bindItems, true, tLogArg);
/* 218 */       if (!rBind.success())
/*     */       {
/* 220 */         ItemInterface.sendSpecificBagGridNotEnough(this.roleId, rBind.getFullBagId());
/* 221 */         logError("PSplitItem.addFixedItems()@failed on adding bind items|roleid=%d|item_cfgid=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(splitCfg.itemId) });
/*     */         
/* 223 */         return false;
/*     */       }
/*     */     }
/* 226 */     if (!nonBindItems.isEmpty())
/*     */     {
/* 228 */       ItemOperateResult rNonBind = ItemInterface.addItem(this.roleId, nonBindItems, false, tLogArg);
/* 229 */       if (!rNonBind.success())
/*     */       {
/* 231 */         ItemInterface.sendSpecificBagGridNotEnough(this.roleId, rNonBind.getFullBagId());
/* 232 */         logError("PSplitItem.addFixedItems()@failed on adding non-bind items|roleid=%d|item_cfgid=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(splitCfg.itemId) });
/*     */         
/* 234 */         return false;
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 239 */     onSuccess(splitCfg.itemId, splitNum, bindItems, nonBindItems);
/* 240 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean addRandomItems(SItemSplitCfg splitCfg, int splitNum, TLogArg tLogArg)
/*     */   {
/* 249 */     int requiredGridNum = 0;
/* 250 */     for (SItemSplitResult result : splitCfg.results)
/*     */     {
/* 252 */       SItemSplitResultCfg resultCfg = SItemSplitResultCfg.get(result.resultId);
/* 253 */       if (resultCfg == null)
/* 254 */         return false;
/* 255 */       int maxGridNumForThisCfg = 0;
/* 256 */       for (int i = 0; i < resultCfg.itemIds.size(); i++)
/*     */       {
/* 258 */         int gridNum = ItemInterface.needGrid(Collections.singletonMap(resultCfg.itemIds.get(i), resultCfg.itemNums.get(i)));
/*     */         
/* 260 */         if (gridNum > maxGridNumForThisCfg)
/* 261 */           maxGridNumForThisCfg = gridNum;
/*     */       }
/* 263 */       requiredGridNum += maxGridNumForThisCfg;
/*     */     }
/*     */     
/* 266 */     if (ItemInterface.getAvailableGridNum(this.roleId, 340600000, true) < requiredGridNum)
/*     */     {
/* 268 */       ItemInterface.sendSpecificBagGridNotEnough(this.roleId, 340600000);
/* 269 */       logError("PSplitItem.addRandomItems()@grid not enough|roleid=%d|item_cfgid=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(splitCfg.itemId) });
/* 270 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 274 */     Map<Integer, Integer> bindItems = new HashMap();
/* 275 */     Map<Integer, Integer> nonBindItems = new HashMap();
/*     */     
/* 277 */     for (int i = 0; i < splitNum; i++)
/*     */     {
/* 279 */       for (SItemSplitResult result : splitCfg.results)
/*     */       {
/*     */ 
/* 282 */         if (result.resultProbability < 10000)
/*     */         {
/* 284 */           int random = Xdb.random().nextInt(10000);
/* 285 */           if (random >= result.resultProbability) {}
/*     */ 
/*     */         }
/*     */         else
/*     */         {
/* 290 */           SItemSplitResultCfg resultCfg = SItemSplitResultCfg.get(result.resultId);
/* 291 */           if (resultCfg == null)
/* 292 */             return false;
/* 293 */           int maxWeight = ((Integer)resultCfg.accumulatedWeights.get(resultCfg.accumulatedWeights.size() - 1)).intValue();
/* 294 */           int random = Xdb.random().nextInt(maxWeight);
/* 295 */           for (int j = 0; j < resultCfg.accumulatedWeights.size(); j++)
/*     */           {
/* 297 */             if (random < ((Integer)resultCfg.accumulatedWeights.get(j)).intValue())
/*     */             {
/* 299 */               Map<Integer, Integer> items = ((Boolean)resultCfg.bindItems.get(j)).booleanValue() ? bindItems : nonBindItems;
/* 300 */               Integer itemNum = (Integer)items.get(resultCfg.itemIds.get(j));
/* 301 */               if (itemNum == null) {
/* 302 */                 items.put(resultCfg.itemIds.get(j), resultCfg.itemNums.get(j)); break;
/*     */               }
/* 304 */               items.put(resultCfg.itemIds.get(j), Integer.valueOf(((Integer)resultCfg.itemNums.get(j)).intValue() + itemNum.intValue()));
/* 305 */               break;
/*     */             }
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 312 */     if (!bindItems.isEmpty())
/*     */     {
/* 314 */       ItemOperateResult rBind = ItemInterface.addItem(this.roleId, bindItems, true, tLogArg);
/* 315 */       if (!rBind.success())
/*     */       {
/* 317 */         logError("PSplitItem.addRandomItems()@failed on adding bind items|roleid=%d|item_cfgid=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(splitCfg.itemId) });
/*     */         
/* 319 */         return false;
/*     */       }
/*     */     }
/* 322 */     if (!nonBindItems.isEmpty())
/*     */     {
/* 324 */       ItemOperateResult rNonBind = ItemInterface.addItem(this.roleId, nonBindItems, false, tLogArg);
/* 325 */       if (!rNonBind.success())
/*     */       {
/* 327 */         logError("PSplitItem.addRandomItems()@failed on adding non-bind items|roleid=%d|item_cfgid=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(splitCfg.itemId) });
/*     */         
/* 329 */         return false;
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 334 */     onSuccess(splitCfg.itemId, splitNum, bindItems, nonBindItems);
/* 335 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void onSuccess(int splitItemId, int splitNum, Map<Integer, Integer> items1, Map<Integer, Integer> items2)
/*     */   {
/* 344 */     Map<Integer, Integer> results = new HashMap();
/* 345 */     results.putAll(items1);
/* 346 */     for (Map.Entry<Integer, Integer> entry : items2.entrySet())
/*     */     {
/* 348 */       Integer itemNum = (Integer)results.get(entry.getKey());
/* 349 */       if (itemNum == null) {
/* 350 */         results.put(entry.getKey(), entry.getValue());
/*     */       } else
/* 352 */         results.put(entry.getKey(), Integer.valueOf(((Integer)entry.getValue()).intValue() + itemNum.intValue()));
/*     */     }
/* 354 */     notifySuccess(splitNum, results);
/* 355 */     ItemManager.logger.info(String.format("PSplitItem.onSuccess()@success|roleid=%d|item_cfgid=%d|split_num=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(splitItemId), Integer.valueOf(splitNum) }));
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\main\PSplitItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */