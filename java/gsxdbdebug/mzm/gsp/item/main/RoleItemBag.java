/*      */ package mzm.gsp.item.main;
/*      */ 
/*      */ import java.util.ArrayList;
/*      */ import java.util.Collections;
/*      */ import java.util.Comparator;
/*      */ import java.util.HashMap;
/*      */ import java.util.HashSet;
/*      */ import java.util.Iterator;
/*      */ import java.util.LinkedList;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.Map.Entry;
/*      */ import java.util.Random;
/*      */ import java.util.Set;
/*      */ import java.util.TreeSet;
/*      */ import mzm.gsp.item.DouobleItemBean;
/*      */ import mzm.gsp.item.SDoubleItemGetNotify;
/*      */ import mzm.gsp.item.SExpBottleGetExpNotify;
/*      */ import mzm.gsp.item.confbean.SDoubleItemCfg;
/*      */ import mzm.gsp.item.confbean.SDoubleItemCfgConsts;
/*      */ import mzm.gsp.item.confbean.SExpBottleItemCfg;
/*      */ import mzm.gsp.item.confbean.SExpBottleItemCfgConsts;
/*      */ import mzm.gsp.item.confbean.SForbidDoubleItemCfg;
/*      */ import mzm.gsp.item.confbean.SItemCfg;
/*      */ import mzm.gsp.item.confbean.STimeEffectItemCfg;
/*      */ import mzm.gsp.item.main.expbottle.ExpBottleItem;
/*      */ import mzm.gsp.market.main.MarketInterface;
/*      */ import mzm.gsp.role.main.RoleInterface;
/*      */ import mzm.gsp.tlog.LogReason;
/*      */ import mzm.gsp.tlog.TLogArg;
/*      */ import mzm.gsp.util.CommonUtils;
/*      */ import mzm.gsp.util.DateTimeUtils;
/*      */ import mzm.gsp.util.Pair;
/*      */ import xbean.Bag;
/*      */ import xbean.Item;
/*      */ import xbean.Pod;
/*      */ import xbean.Role2DoubleItemInfo;
/*      */ import xdb.Xdb;
/*      */ import xio.Protocol;
/*      */ import xtable.Role2doubleitem;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class RoleItemBag
/*      */   extends AbstractItemBag
/*      */ {
/*      */   protected final Bag xBag;
/*   53 */   protected long roleId = -1L;
/*      */   
/*      */ 
/*      */   RoleItemBag(Bag bag)
/*      */   {
/*   58 */     this.xBag = bag;
/*      */   }
/*      */   
/*      */ 
/*      */   public RoleItemBag(Bag xBag, long roleId)
/*      */   {
/*   64 */     this.xBag = xBag;
/*   65 */     this.roleId = roleId;
/*      */   }
/*      */   
/*      */ 
/*      */   public boolean add(int grid, BasicItem basicItem)
/*      */   {
/*   71 */     if ((grid < 0) || (grid >= getCapacity()))
/*      */     {
/*   73 */       throw new IndexOutOfBoundsException("格子号越界");
/*      */     }
/*   75 */     if (!isGridEmpty(grid))
/*      */     {
/*   77 */       return false;
/*      */     }
/*      */     
/*   80 */     handleItemWhenAddItem(basicItem);
/*      */     
/*   82 */     this.xBag.getItems().put(Integer.valueOf(grid), basicItem.getItem().toBean());
/*   83 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private void handleItemWhenAddItem(BasicItem basicItem)
/*      */   {
/*   95 */     handleExpBottleItemWhenAddItem(basicItem);
/*      */     
/*   97 */     handleDoubleItemWhenAddItem(basicItem);
/*      */     
/*   99 */     handleTimeGetEffectItemWhenAddItem(basicItem);
/*      */   }
/*      */   
/*      */ 
/*      */   public BasicItem removeByGrid(int grid)
/*      */   {
/*  105 */     if (isGridEmpty(grid))
/*      */     {
/*  107 */       return null;
/*      */     }
/*      */     
/*  110 */     Item xItem = (Item)this.xBag.getItems().remove(Integer.valueOf(grid));
/*  111 */     if (xItem == null)
/*      */     {
/*  113 */       return null;
/*      */     }
/*      */     
/*      */ 
/*  117 */     if (!ItemManager.checkTimeIsValid(xItem))
/*      */     {
/*  119 */       return null;
/*      */     }
/*      */     
/*  122 */     return ItemManager.getBasicItem(xItem);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public Map<Integer, BasicItem> getAllItems(boolean isContainTimeExpiredItem)
/*      */   {
/*  132 */     Map<Integer, BasicItem> ret = new HashMap();
/*  133 */     for (Map.Entry<Integer, Item> entry : this.xBag.getItems().entrySet())
/*      */     {
/*  135 */       if ((isContainTimeExpiredItem) || (ItemManager.checkTimeIsValid((Item)entry.getValue())))
/*      */       {
/*      */ 
/*      */ 
/*      */ 
/*  140 */         BasicItem basicItem = ItemManager.getBasicItem((Item)entry.getValue());
/*  141 */         if (basicItem != null)
/*      */         {
/*      */ 
/*      */ 
/*  145 */           ret.put(entry.getKey(), basicItem); }
/*      */       } }
/*  147 */     return ret;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public int getGridByUuid(long uuid)
/*      */   {
/*  158 */     for (Map.Entry<Integer, Item> entry : this.xBag.getItems().entrySet())
/*      */     {
/*  160 */       if (((Item)entry.getValue()).getUuid().contains(Long.valueOf(uuid)))
/*      */       {
/*  162 */         return ((Integer)entry.getKey()).intValue();
/*      */       }
/*      */     }
/*  165 */     return -1;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public BasicItem get(int grid)
/*      */   {
/*  172 */     Item item = (Item)this.xBag.getItems().get(Integer.valueOf(grid));
/*  173 */     if (item == null)
/*      */     {
/*  175 */       return null;
/*      */     }
/*  177 */     return ItemManager.getBasicItem(item);
/*      */   }
/*      */   
/*      */ 
/*      */   public int getCapacity()
/*      */   {
/*  183 */     return this.xBag.getCapacity();
/*      */   }
/*      */   
/*      */ 
/*      */   public boolean expandCapacity(int expandNum)
/*      */   {
/*  189 */     if (expandNum <= 0)
/*      */     {
/*  191 */       throw new IllegalArgumentException("扩充包裹容量参数错误");
/*      */     }
/*  193 */     long cap = getCapacity();
/*  194 */     cap += expandNum;
/*  195 */     if (cap >= 2147483647L)
/*      */     {
/*  197 */       this.xBag.setCapacity(Integer.MAX_VALUE);
/*      */     }
/*      */     else
/*      */     {
/*  201 */       this.xBag.setCapacity(getCapacity() + expandNum);
/*      */     }
/*      */     
/*  204 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public int size()
/*      */   {
/*  210 */     return this.xBag.getItems().size();
/*      */   }
/*      */   
/*      */ 
/*      */   public ItemOperateResult addItem(BasicItem basicItem, boolean isMerge)
/*      */   {
/*  216 */     if (basicItem == null)
/*      */     {
/*  218 */       return new ItemOperateResult(ItemOperateResult.ItemResultEnum.WRONG_NUMBER);
/*      */     }
/*  220 */     if (basicItem.getNumber() > ItemConfigManager.getPileMaxCount(basicItem.getCfgId()))
/*      */     {
/*  222 */       return new ItemOperateResult(ItemOperateResult.ItemResultEnum.WRONG_NUMBER);
/*      */     }
/*  224 */     List<ItemOperateResult.ChangeItemInfo> addedItemInfos = new ArrayList();
/*      */     
/*      */ 
/*  227 */     if ((!isMerge) || (!ItemConfigManager.isCanPile(basicItem.getCfgId())))
/*      */     {
/*  229 */       int grid = getNextAvailableGrid();
/*  230 */       if (grid < 0)
/*      */       {
/*  232 */         ItemOperateResult res = new ItemOperateResult(ItemOperateResult.ItemResultEnum.BAG_FULL);
/*  233 */         res.setFullBagId(ItemManager.getBagIdByItemId(basicItem.getCfgId()));
/*  234 */         return res;
/*      */       }
/*  236 */       boolean r = add(grid, basicItem);
/*  237 */       if (r)
/*      */       {
/*  239 */         ItemOperateResult.ChangeItemInfo c = new ItemOperateResult.ChangeItemInfo(grid, basicItem.getCopyItem(), true);
/*  240 */         addedItemInfos.add(c);
/*      */         
/*  242 */         return new ItemOperateResult(ItemOperateResult.ItemResultEnum.SUCCESS, addedItemInfos);
/*      */       }
/*      */       
/*      */ 
/*  246 */       return new ItemOperateResult(ItemOperateResult.ItemResultEnum.BAG_ERROR);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*  252 */     for (Map.Entry<Integer, BasicItem> e : getAllItems(true).entrySet())
/*      */     {
/*  254 */       if ((((BasicItem)e.getValue()).getCfgId() == basicItem.getCfgId()) && 
/*      */       
/*      */ 
/*      */ 
/*  258 */         (((BasicItem)e.getValue()).getNumber() != ItemConfigManager.getPileMaxCount(((BasicItem)e.getValue()).getCfgId())))
/*      */       {
/*      */ 
/*      */ 
/*  262 */         Set<Long> moveUuids = mergerItem(((BasicItem)e.getValue()).getItem(), basicItem.getItem());
/*  263 */         if (moveUuids.size() > 0)
/*      */         {
/*      */ 
/*      */ 
/*  267 */           BasicItem b = new BasicItem(((BasicItem)e.getValue()).getCopyItem());
/*  268 */           b.setNumber(moveUuids.size());
/*  269 */           b.getUuid().clear();
/*  270 */           b.getUuid().addAll(moveUuids);
/*  271 */           ItemOperateResult.ChangeItemInfo c = new ItemOperateResult.ChangeItemInfo(((Integer)e.getKey()).intValue(), b, false);
/*      */           
/*  273 */           addedItemInfos.add(c);
/*      */         }
/*  275 */         if (basicItem.getNumber() == 0) {
/*      */           break;
/*      */         }
/*      */       }
/*      */     }
/*      */     
/*  281 */     if (basicItem.getNumber() == 0)
/*      */     {
/*  283 */       return new ItemOperateResult(ItemOperateResult.ItemResultEnum.SUCCESS, addedItemInfos);
/*      */     }
/*      */     
/*      */ 
/*  287 */     int grid = getNextAvailableGrid();
/*  288 */     if (grid < 0)
/*      */     {
/*  290 */       ItemOperateResult res = new ItemOperateResult(ItemOperateResult.ItemResultEnum.BAG_FULL, addedItemInfos);
/*  291 */       res.setFullBagId(ItemManager.getBagIdByItemId(basicItem.getCfgId()));
/*  292 */       return res;
/*      */     }
/*      */     
/*  295 */     handleItemWhenAddItem(basicItem);
/*      */     
/*  297 */     this.xBag.getItems().put(Integer.valueOf(grid), basicItem.getItem());
/*  298 */     ItemOperateResult.ChangeItemInfo c = new ItemOperateResult.ChangeItemInfo(grid, basicItem.getCopyItem(), true);
/*  299 */     addedItemInfos.add(c);
/*  300 */     return new ItemOperateResult(ItemOperateResult.ItemResultEnum.SUCCESS, addedItemInfos);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private void handleExpBottleItemWhenAddItem(BasicItem basicItem)
/*      */   {
/*  310 */     if (this.roleId < 0L)
/*      */     {
/*  312 */       return;
/*      */     }
/*  314 */     Map<Integer, Integer> xItemExtraMap = basicItem.xItem.getExtra();
/*  315 */     if (xItemExtraMap.get(Integer.valueOf(211)) != null)
/*      */     {
/*  317 */       return;
/*      */     }
/*      */     
/*  320 */     SItemCfg sItemCfg = SItemCfg.get(basicItem.getCfgId());
/*  321 */     if (sItemCfg == null)
/*      */     {
/*  323 */       return;
/*      */     }
/*      */     
/*  326 */     if (sItemCfg.type != 113)
/*      */     {
/*  328 */       return;
/*      */     }
/*      */     
/*  331 */     if (!(sItemCfg instanceof SExpBottleItemCfg))
/*      */     {
/*  333 */       return;
/*      */     }
/*      */     
/*  336 */     SExpBottleItemCfg sExpBottleItemCfg = (SExpBottleItemCfg)sItemCfg;
/*      */     
/*  338 */     ExpBottleItem expBottleItem = (ExpBottleItem)ItemManager.expBotleItemMap.get(Integer.valueOf(sExpBottleItemCfg.exp_bottle_award_type));
/*  339 */     if (expBottleItem == null)
/*      */     {
/*  341 */       return;
/*      */     }
/*      */     
/*  344 */     int totalExp = (int)(expBottleItem.getExpBottleItemExp(this.roleId, sExpBottleItemCfg) * (sExpBottleItemCfg.get_total_exp_rate * 1.0D / CommonUtils.WAN_PERCENT));
/*  345 */     if (totalExp < 0)
/*      */     {
/*  347 */       return;
/*      */     }
/*      */     
/*  350 */     totalExp = totalExp > SExpBottleItemCfgConsts.getInstance().exp_max ? SExpBottleItemCfgConsts.getInstance().exp_max : totalExp;
/*      */     
/*  352 */     totalExp = totalExp < SExpBottleItemCfgConsts.getInstance().exp_min ? SExpBottleItemCfgConsts.getInstance().exp_min : totalExp;
/*      */     
/*      */ 
/*  355 */     xItemExtraMap.put(Integer.valueOf(211), Integer.valueOf(totalExp));
/*  356 */     xItemExtraMap.put(Integer.valueOf(212), Integer.valueOf(totalExp));
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private void handleDoubleItemWhenAddItem(BasicItem basicItem)
/*      */   {
/*  366 */     if (this.roleId < 0L)
/*      */     {
/*  368 */       return;
/*      */     }
/*  370 */     Map<Integer, Integer> xItemExtraMap = basicItem.xItem.getExtra();
/*  371 */     if (xItemExtraMap.get(Integer.valueOf(221)) != null)
/*      */     {
/*  373 */       return;
/*      */     }
/*      */     
/*  376 */     SItemCfg sItemCfg = SItemCfg.get(basicItem.getCfgId());
/*  377 */     if (sItemCfg == null)
/*      */     {
/*  379 */       return;
/*      */     }
/*      */     
/*  382 */     if (sItemCfg.type != 114)
/*      */     {
/*  384 */       return;
/*      */     }
/*      */     
/*  387 */     if (!(sItemCfg instanceof SDoubleItemCfg))
/*      */     {
/*  389 */       return;
/*      */     }
/*      */     
/*  392 */     SDoubleItemCfg sDoubleItemCfg = (SDoubleItemCfg)sItemCfg;
/*      */     
/*  394 */     xItemExtraMap.put(Integer.valueOf(221), Integer.valueOf(sDoubleItemCfg.total_times));
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private void handleTimeGetEffectItemWhenAddItem(BasicItem basicItem)
/*      */   {
/*  404 */     if (this.roleId < 0L)
/*      */     {
/*  406 */       return;
/*      */     }
/*      */     
/*  409 */     Map<Integer, Integer> xItemExtraMap = basicItem.xItem.getExtra();
/*  410 */     if (xItemExtraMap.get(Integer.valueOf(231)) != null)
/*      */     {
/*  412 */       return;
/*      */     }
/*      */     
/*  415 */     int itemCfgId = basicItem.getCfgId();
/*  416 */     STimeEffectItemCfg sTimeEffectItemCfg = STimeEffectItemCfg.get(itemCfgId);
/*  417 */     if (sTimeEffectItemCfg == null)
/*      */     {
/*  419 */       return;
/*      */     }
/*      */     
/*  422 */     if (sTimeEffectItemCfg.item_time_type != 2)
/*      */     {
/*  424 */       return;
/*      */     }
/*      */     
/*  427 */     int itemEndTime = (int)(DateTimeUtils.getCurrTimeInMillis() / 1000L + sTimeEffectItemCfg.effect_time_seconds);
/*  428 */     xItemExtraMap.put(Integer.valueOf(231), Integer.valueOf(itemEndTime));
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   Protocol handleExpBottleItemAfterAwardExp(int awardRoleExp)
/*      */   {
/*  441 */     if (!ItemManager.isExpBottleSwitchOpen(this.roleId))
/*      */     {
/*  443 */       return null;
/*      */     }
/*  445 */     int needBottleExp = (int)(awardRoleExp * (SExpBottleItemCfgConsts.getInstance().every_award_get_exp_rate * 1.0D / CommonUtils.WAN_PERCENT));
/*  446 */     int canAddBottleExp = 0;
/*  447 */     for (int gridNum = 0; gridNum < this.xBag.getCapacity(); gridNum++)
/*      */     {
/*  449 */       if (canAddBottleExp >= needBottleExp) {
/*      */         break;
/*      */       }
/*      */       
/*      */ 
/*  454 */       Item xItem = (Item)this.xBag.getItems().get(Integer.valueOf(gridNum));
/*  455 */       if (xItem != null)
/*      */       {
/*      */ 
/*      */ 
/*      */ 
/*  460 */         int itemCfgId = xItem.getCfgid();
/*  461 */         SItemCfg sItemCfg = SItemCfg.get(itemCfgId);
/*  462 */         if (sItemCfg != null)
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*  467 */           if (sItemCfg.type == 113)
/*      */           {
/*      */ 
/*      */ 
/*  471 */             if (sItemCfg.useLevel <= RoleInterface.getLevel(this.roleId))
/*      */             {
/*      */ 
/*      */ 
/*      */ 
/*  476 */               if (ItemManager.checkTimeIsValid(xItem))
/*      */               {
/*      */ 
/*      */ 
/*      */ 
/*  481 */                 Map<Integer, Integer> xExtraItemMap = xItem.getExtra();
/*      */                 
/*  483 */                 Integer leftExpValue = (Integer)xExtraItemMap.get(Integer.valueOf(212));
/*  484 */                 if ((leftExpValue != null) && (leftExpValue.intValue() > 0))
/*      */                 {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  490 */                   int leftNeedBottleExp = needBottleExp - canAddBottleExp;
/*  491 */                   if (leftExpValue.intValue() >= leftNeedBottleExp)
/*      */                   {
/*  493 */                     xExtraItemMap.put(Integer.valueOf(212), Integer.valueOf(leftExpValue.intValue() - leftNeedBottleExp));
/*  494 */                     canAddBottleExp = needBottleExp;
/*      */                   }
/*      */                   else
/*      */                   {
/*  498 */                     xExtraItemMap.put(Integer.valueOf(212), Integer.valueOf(0));
/*  499 */                     canAddBottleExp += leftExpValue.intValue();
/*      */                   }
/*      */                 }
/*      */               } } } } } }
/*  503 */     if (canAddBottleExp <= 0)
/*      */     {
/*  505 */       return null;
/*      */     }
/*      */     
/*  508 */     String userid = RoleInterface.getUserId(this.roleId);
/*  509 */     RoleInterface.addExp(userid, this.roleId, canAddBottleExp, new TLogArg(LogReason.EXP_BOTTLE_AWARD_EXP));
/*      */     
/*  511 */     SExpBottleGetExpNotify sExpBottleGetExpNotify = new SExpBottleGetExpNotify();
/*  512 */     sExpBottleGetExpNotify.get_exp = canAddBottleExp;
/*      */     
/*  514 */     return sExpBottleGetExpNotify;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   Pair<Boolean, Protocol> handleDoubleItemAfterAwardItem(Map<Integer, Integer> triggerItemMap)
/*      */   {
/*  527 */     if (!ItemManager.isDoubleItemSwitchOpen(this.roleId))
/*      */     {
/*  529 */       return new Pair(Boolean.valueOf(true), null);
/*      */     }
/*      */     
/*  532 */     Iterator<Integer> itemIdIter = triggerItemMap.keySet().iterator();
/*  533 */     while (itemIdIter.hasNext())
/*      */     {
/*  535 */       int itemId = ((Integer)itemIdIter.next()).intValue();
/*  536 */       if (SForbidDoubleItemCfg.get(itemId) != null)
/*      */       {
/*  538 */         itemIdIter.remove();
/*      */       }
/*      */     }
/*      */     
/*  542 */     int todayTriggerTimes = 0;
/*  543 */     LinkedList<DouobleItemBean> doubleItemList = null;
/*  544 */     for (int gridNum = 0; gridNum < this.xBag.getCapacity(); gridNum++)
/*      */     {
/*  546 */       if (triggerItemMap.isEmpty()) {
/*      */         break;
/*      */       }
/*      */       
/*      */ 
/*  551 */       Item xItem = checkIsValidDoubleItem(gridNum);
/*  552 */       if (xItem != null)
/*      */       {
/*      */ 
/*      */ 
/*      */ 
/*  557 */         Map<Integer, Integer> xExtraItemMap = xItem.getExtra();
/*  558 */         Integer leftDoubleItemTimes = (Integer)xExtraItemMap.get(Integer.valueOf(221));
/*  559 */         if ((leftDoubleItemTimes != null) && (leftDoubleItemTimes.intValue() > 0))
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*  564 */           Role2DoubleItemInfo xRole2DoubleItemInfo = Role2doubleitem.get(Long.valueOf(this.roleId));
/*  565 */           if (xRole2DoubleItemInfo == null)
/*      */           {
/*  567 */             xRole2DoubleItemInfo = Pod.newRole2DoubleItemInfo();
/*  568 */             Role2doubleitem.add(Long.valueOf(this.roleId), xRole2DoubleItemInfo);
/*      */           }
/*      */           
/*  571 */           long currentTimeMillis = DateTimeUtils.getCurrTimeInMillis();
/*      */           
/*      */ 
/*  574 */           todayTriggerTimes = getRefreshTriggerTimes(xRole2DoubleItemInfo, currentTimeMillis);
/*      */           
/*  576 */           if (todayTriggerTimes >= SDoubleItemCfgConsts.getInstance().max_double_item_times_every_day) {
/*      */             break;
/*      */           }
/*      */           
/*      */ 
/*  581 */           Iterator<Map.Entry<Integer, Integer>> iterator = triggerItemMap.entrySet().iterator();
/*  582 */           while (iterator.hasNext())
/*      */           {
/*  584 */             if (todayTriggerTimes >= SDoubleItemCfgConsts.getInstance().max_double_item_times_every_day) {
/*      */               break;
/*      */             }
/*      */             
/*      */ 
/*  589 */             if (leftDoubleItemTimes.intValue() <= 0) {
/*      */               break;
/*      */             }
/*      */             
/*      */ 
/*  594 */             Map.Entry<Integer, Integer> doubleItemEntry = (Map.Entry)iterator.next();
/*  595 */             iterator.remove();
/*      */             
/*  597 */             int random = Xdb.random().nextInt(CommonUtils.WAN_PERCENT);
/*  598 */             if (random >= SDoubleItemCfgConsts.getInstance().trigger_rate)
/*      */             {
/*  600 */               int todayGuaranteeTimes = getRefreshMinimumGuaranteeTimes(xRole2DoubleItemInfo, currentTimeMillis);
/*  601 */               if (todayGuaranteeTimes < SDoubleItemCfgConsts.getInstance().max_minimum_guarantee_times_every_day)
/*      */               {
/*      */ 
/*      */ 
/*  605 */                 xRole2DoubleItemInfo.setGuarantee_not_trigger_times(xRole2DoubleItemInfo.getGuarantee_not_trigger_times() + 1);
/*  606 */                 if (xRole2DoubleItemInfo.getGuarantee_not_trigger_times() >= SDoubleItemCfgConsts.getInstance().trigger_minimum_guarantee_need_times)
/*      */                 {
/*  608 */                   xRole2DoubleItemInfo.setGuarantee_not_trigger_times(0);
/*      */                   
/*  610 */                   xRole2DoubleItemInfo.setToday_guarantee_times(todayGuaranteeTimes + 1);
/*  611 */                   xRole2DoubleItemInfo.setToday_guarantee_refresh_time(currentTimeMillis);
/*      */                 }
/*      */                 
/*      */               }
/*      */               
/*      */             }
/*      */             else
/*      */             {
/*  619 */               xRole2DoubleItemInfo.setGuarantee_not_trigger_times(0);
/*  620 */               xRole2DoubleItemInfo.setToday_trigger_times(++todayTriggerTimes);
/*  621 */               xRole2DoubleItemInfo.setToday_trigger_refresh_time(currentTimeMillis);
/*      */               
/*  623 */               if (doubleItemList == null)
/*      */               {
/*  625 */                 doubleItemList = new LinkedList();
/*      */               }
/*  627 */               int doubleItemId = ((Integer)doubleItemEntry.getKey()).intValue();
/*  628 */               int doubleItemNum = ((Integer)doubleItemEntry.getValue()).intValue();
/*      */               
/*  630 */               doubleItemList.add(new DouobleItemBean(xItem.getCfgid(), doubleItemId, doubleItemNum));
/*  631 */               xExtraItemMap.put(Integer.valueOf(221), leftDoubleItemTimes = Integer.valueOf(leftDoubleItemTimes.intValue() - 1));
/*      */               
/*  633 */               ItemOperateResult result = ItemInterface.addItem(this.roleId, doubleItemId, doubleItemNum, new TLogArg(LogReason.DOUBLE_ITEM_AWARD));
/*      */               
/*      */ 
/*  636 */               boolean ret = (result.success()) || (result.isBagFull());
/*  637 */               if (!ret)
/*      */               {
/*  639 */                 return new Pair(Boolean.valueOf(false), null); }
/*      */             }
/*      */           }
/*      */         }
/*      */       } }
/*  644 */     if (doubleItemList != null)
/*      */     {
/*  646 */       SDoubleItemGetNotify sDoubleItemGetNotify = new SDoubleItemGetNotify(doubleItemList, todayTriggerTimes);
/*  647 */       return new Pair(Boolean.valueOf(true), sDoubleItemGetNotify);
/*      */     }
/*      */     
/*      */ 
/*  651 */     return new Pair(Boolean.valueOf(true), null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private Item checkIsValidDoubleItem(int gridNum)
/*      */   {
/*  663 */     Item xItem = (Item)this.xBag.getItems().get(Integer.valueOf(gridNum));
/*  664 */     if (xItem == null)
/*      */     {
/*  666 */       return null;
/*      */     }
/*      */     
/*  669 */     int itemCfgId = xItem.getCfgid();
/*  670 */     SItemCfg sItemCfg = SItemCfg.get(itemCfgId);
/*  671 */     if (sItemCfg == null)
/*      */     {
/*  673 */       return null;
/*      */     }
/*      */     
/*  676 */     if (sItemCfg.type != 114)
/*      */     {
/*  678 */       return null;
/*      */     }
/*      */     
/*  681 */     if (sItemCfg.useLevel > RoleInterface.getLevel(this.roleId))
/*      */     {
/*  683 */       return null;
/*      */     }
/*      */     
/*  686 */     if (!ItemManager.checkTimeIsValid(xItem))
/*      */     {
/*  688 */       return null;
/*      */     }
/*  690 */     return xItem;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private int getRefreshTriggerTimes(Role2DoubleItemInfo xRole2DoubleItemInfo, long currentTimeMills)
/*      */   {
/*  702 */     if (!DateTimeUtils.isInSameDay(xRole2DoubleItemInfo.getToday_trigger_refresh_time(), currentTimeMills))
/*      */     {
/*  704 */       xRole2DoubleItemInfo.setToday_trigger_times(0);
/*  705 */       xRole2DoubleItemInfo.setToday_trigger_refresh_time(currentTimeMills);
/*      */     }
/*  707 */     return xRole2DoubleItemInfo.getToday_trigger_times();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private int getRefreshMinimumGuaranteeTimes(Role2DoubleItemInfo xRole2DoubleItemInfo, long currentTimeMills)
/*      */   {
/*  720 */     if (!DateTimeUtils.isInSameDay(xRole2DoubleItemInfo.getToday_guarantee_refresh_time(), currentTimeMills))
/*      */     {
/*  722 */       xRole2DoubleItemInfo.setToday_guarantee_times(0);
/*  723 */       xRole2DoubleItemInfo.setToday_guarantee_refresh_time(currentTimeMills);
/*      */     }
/*  725 */     return xRole2DoubleItemInfo.getToday_guarantee_times();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public ItemOperateResult addItem(Item xItem, boolean isMerge, boolean isRollbackWhenFull)
/*      */   {
/*  740 */     if ((xItem == null) || (xItem.getNumber() == 0))
/*      */     {
/*  742 */       return new ItemOperateResult(ItemOperateResult.ItemResultEnum.WRONG_NUMBER);
/*      */     }
/*  744 */     List<Item> xItems = new ArrayList();
/*  745 */     xItems.add(xItem);
/*  746 */     return addItem(xItems, isMerge, isRollbackWhenFull);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public ItemOperateResult addItem(List<Item> xItems, boolean isMerge, boolean isRollbackWhenFull)
/*      */   {
/*  762 */     if ((xItems == null) || (xItems.size() == 0))
/*      */     {
/*  764 */       return new ItemOperateResult(ItemOperateResult.ItemResultEnum.WRONG_NUMBER);
/*      */     }
/*  766 */     for (int i = 0; i < xItems.size(); i++)
/*      */     {
/*  768 */       if (((Item)xItems.get(i)).getNumber() > ItemConfigManager.getPileMaxCount(((Item)xItems.get(i)).getCfgid()))
/*      */       {
/*  770 */         return new ItemOperateResult(ItemOperateResult.ItemResultEnum.WRONG_NUMBER);
/*      */       }
/*      */     }
/*  773 */     List<ItemOperateResult.ChangeItemInfo> addedItemInfos = new ArrayList();
/*  774 */     for (int i = 0; i < xItems.size(); i++)
/*      */     {
/*  776 */       BasicItem itemInfo = ItemManager.getBasicItem((Item)xItems.get(i));
/*  777 */       ItemOperateResult r = addItem(itemInfo, isMerge);
/*  778 */       if ((!r.success()) && (!r.isBagFull()))
/*      */       {
/*  780 */         rollbackRemoveItem(addedItemInfos);
/*  781 */         return r;
/*      */       }
/*  783 */       if (r.isBagFull())
/*      */       {
/*  785 */         if (isRollbackWhenFull)
/*      */         {
/*  787 */           rollbackRemoveItem(addedItemInfos);
/*  788 */           ItemOperateResult res = new ItemOperateResult(ItemOperateResult.ItemResultEnum.BAG_FULL);
/*  789 */           res.setFullBagId(r.getFullBagId());
/*  790 */           return res;
/*      */         }
/*      */         
/*      */ 
/*  794 */         ItemOperateResult res = new ItemOperateResult(ItemOperateResult.ItemResultEnum.BAG_FULL, addedItemInfos);
/*  795 */         res.setFullBagId(r.getFullBagId());
/*  796 */         return res;
/*      */       }
/*      */       
/*      */ 
/*  800 */       addedItemInfos.addAll(r.getChangeItemInfoList());
/*      */     }
/*  802 */     return new ItemOperateResult(ItemOperateResult.ItemResultEnum.SUCCESS, addedItemInfos);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public ItemOperateResult removeItemsByItemId(int itemId, int num)
/*      */   {
/*  809 */     int count = getItemNumberBycfgId(itemId);
/*  810 */     if ((num <= 0) || (count < num))
/*      */     {
/*  812 */       return new ItemOperateResult(ItemOperateResult.ItemResultEnum.WRONG_NUMBER);
/*      */     }
/*      */     
/*  815 */     return delItemFromItemMap(getItemById(itemId), num);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private Map<Integer, Item> getItemById(int itemId)
/*      */   {
/*  828 */     Map<Integer, Item> resultMap = new HashMap();
/*  829 */     for (Map.Entry<Integer, Item> e : this.xBag.getItems().entrySet())
/*      */     {
/*  831 */       Item v = (Item)e.getValue();
/*  832 */       if (v.getCfgid() == itemId)
/*      */       {
/*  834 */         if (ItemManager.checkTimeIsValid(v))
/*      */         {
/*      */ 
/*      */ 
/*  838 */           resultMap.put(e.getKey(), v); }
/*      */       }
/*      */     }
/*  841 */     return resultMap;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private void rollbackAddItem(List<ItemOperateResult.ChangeItemInfo> changeItemInfos)
/*      */   {
/*  851 */     if (changeItemInfos == null)
/*      */     {
/*  853 */       return;
/*      */     }
/*  855 */     for (ItemOperateResult.ChangeItemInfo c : changeItemInfos)
/*      */     {
/*  857 */       if (c.isNewGrifOrRemove)
/*      */       {
/*  859 */         this.xBag.getItems().put(Integer.valueOf(c.grid), c.basicItem.getItem());
/*      */       }
/*      */       else
/*      */       {
/*  863 */         Item item = (Item)this.xBag.getItems().get(Integer.valueOf(c.grid));
/*  864 */         item.getUuid().addAll(c.basicItem.getUuid());
/*  865 */         item.setNumber(item.getNumber() + c.basicItem.getNumber());
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private void rollbackRemoveItem(List<ItemOperateResult.ChangeItemInfo> changeItemInfos)
/*      */   {
/*  877 */     if (changeItemInfos == null)
/*      */     {
/*  879 */       return;
/*      */     }
/*  881 */     for (ItemOperateResult.ChangeItemInfo c : changeItemInfos)
/*      */     {
/*  883 */       if (c.isNewGrifOrRemove)
/*      */       {
/*  885 */         this.xBag.getItems().remove(Integer.valueOf(c.grid));
/*      */ 
/*      */       }
/*      */       else
/*      */       {
/*      */ 
/*  891 */         Item item = (Item)this.xBag.getItems().get(Integer.valueOf(c.grid));
/*  892 */         if (item != null)
/*      */         {
/*  894 */           item.getUuid().removeAll(c.basicItem.getUuid());
/*  895 */           item.setNumber(item.getNumber() - c.basicItem.getNumber());
/*      */         }
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   public int getNextAvailableGrid()
/*      */   {
/*  906 */     for (int i = 0; i < this.xBag.getCapacity(); i++)
/*      */     {
/*  908 */       if (isGridEmpty(i))
/*      */       {
/*  910 */         return i;
/*      */       }
/*      */     }
/*  913 */     return -1;
/*      */   }
/*      */   
/*      */   private Set<Long> mergerItem(Item destItem, Item srcItem)
/*      */   {
/*  918 */     Integer desItemSource = (Integer)destItem.getExtra().get(Integer.valueOf(ItemStoreEnum.ITEM_SOURCE.getStoreType()));
/*  919 */     Integer srcItemSource = (Integer)srcItem.getExtra().get(Integer.valueOf(ItemStoreEnum.ITEM_SOURCE.getStoreType()));
/*      */     
/*  921 */     if (((desItemSource == null) && (srcItemSource != null)) || ((desItemSource != null) && (srcItemSource == null)))
/*      */     {
/*  923 */       return new HashSet();
/*      */     }
/*  925 */     if ((desItemSource != null) && (srcItemSource != null))
/*      */     {
/*  927 */       if (desItemSource.intValue() != srcItemSource.intValue())
/*      */       {
/*  929 */         return new HashSet();
/*      */       }
/*      */     }
/*      */     
/*  933 */     if ((destItem.getFlags() != srcItem.getFlags()) || (destItem.getCfgid() != srcItem.getCfgid()) || (srcItem.getNumber() == 0) || (destItem.getNumber() == ItemConfigManager.getPileMaxCount(destItem.getCfgid())))
/*      */     {
/*      */ 
/*  936 */       return new HashSet();
/*      */     }
/*      */     
/*  939 */     if (MarketInterface.isItemInFrozenState(destItem.getCfgid(), destItem.getMarketbuytime()))
/*      */     {
/*      */ 
/*  942 */       if (MarketInterface.isItemInFrozenState(srcItem.getCfgid(), srcItem.getMarketbuytime()))
/*      */       {
/*  944 */         destItem.setMarketbuytime(Math.max(destItem.getMarketbuytime(), srcItem.getMarketbuytime()));
/*      */       }
/*      */       else
/*      */       {
/*  948 */         return new HashSet();
/*      */       }
/*      */       
/*      */     }
/*      */     else
/*      */     {
/*  954 */       if (MarketInterface.isItemInFrozenState(srcItem.getCfgid(), srcItem.getMarketbuytime()))
/*      */       {
/*  956 */         return new HashSet();
/*      */       }
/*      */       
/*      */ 
/*  960 */       destItem.setMarketbuytime(0L);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*  965 */     int num = Math.min(ItemConfigManager.getPileMaxCount(destItem.getCfgid()) - destItem.getNumber(), srcItem.getNumber());
/*      */     
/*  967 */     Integer desItemPrice = (Integer)destItem.getExtra().get(Integer.valueOf(ItemStoreEnum.SHANGHUI_PRICE.getStoreType()));
/*  968 */     Integer srcItemPrice = (Integer)srcItem.getExtra().get(Integer.valueOf(ItemStoreEnum.SHANGHUI_PRICE.getStoreType()));
/*  969 */     if ((desItemPrice != null) && (srcItemPrice != null))
/*      */     {
/*  971 */       int avgprice = (destItem.getNumber() * desItemPrice.intValue() + num * srcItemPrice.intValue()) / (destItem.getNumber() + num);
/*  972 */       destItem.getExtra().put(Integer.valueOf(ItemStoreEnum.SHANGHUI_PRICE.getStoreType()), Integer.valueOf(avgprice));
/*      */     }
/*  974 */     return moveUUID(destItem, srcItem, num);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private Set<Long> moveUUID(Item dstItem, Item srcItem, int number)
/*      */   {
/*  987 */     if ((number <= 0) || (srcItem.getNumber() < number) || (ItemConfigManager.getPileMaxCount(dstItem.getCfgid()) - dstItem.getNumber() < number))
/*      */     {
/*      */ 
/*  990 */       return new HashSet();
/*      */     }
/*  992 */     Set<Long> uuidLongs = new HashSet();
/*      */     
/*  994 */     for (Long uuidLong : srcItem.getUuid())
/*      */     {
/*  996 */       uuidLongs.add(uuidLong);
/*  997 */       if (uuidLongs.size() == number)
/*      */         break;
/*      */     }
/* 1000 */     if (uuidLongs.size() != number)
/* 1001 */       return new HashSet();
/* 1002 */     srcItem.getUuid().removeAll(uuidLongs);
/* 1003 */     dstItem.getUuid().addAll(uuidLongs);
/* 1004 */     dstItem.setNumber(dstItem.getNumber() + number);
/* 1005 */     srcItem.setNumber(srcItem.getNumber() - number);
/* 1006 */     return uuidLongs;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private ItemOperateResult delItemFromItemMap(Map<Integer, Item> itemMap, int num)
/*      */   {
/* 1019 */     return delItemFromItemMap(itemMap, num, false);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private ItemOperateResult delItemFromItemMap(Map<Integer, Item> itemMap, int num, boolean isBindFirst)
/*      */   {
/* 1032 */     Set<Integer> removekey = new HashSet();
/* 1033 */     List<ItemOperateResult.ChangeItemInfo> delItemInfos = new ArrayList();
/*      */     
/*      */ 
/* 1036 */     List<Integer> grids = new ArrayList(itemMap.keySet());
/* 1037 */     Collections.sort(grids);
/* 1038 */     if (isBindFirst)
/*      */     {
/* 1040 */       List<Integer> bindGrids = new ArrayList(grids.size());
/* 1041 */       for (Integer grid : grids)
/*      */       {
/* 1043 */         Item item = (Item)itemMap.get(grid);
/* 1044 */         if ((item.getFlags() & 0x1) == 1)
/*      */         {
/* 1046 */           bindGrids.add(grid);
/*      */         }
/*      */       }
/* 1049 */       if (!bindGrids.isEmpty())
/*      */       {
/* 1051 */         grids.removeAll(bindGrids);
/* 1052 */         for (Integer grid : grids)
/*      */         {
/* 1054 */           bindGrids.add(grid);
/*      */         }
/* 1056 */         grids = bindGrids;
/*      */       }
/*      */     }
/*      */     
/* 1060 */     for (Integer grid : grids)
/*      */     {
/* 1062 */       Item xItem = (Item)itemMap.get(grid);
/*      */       
/* 1064 */       if (xItem.getNumber() > num)
/*      */       {
/* 1066 */         Set<Long> removeUuidSet = removeUUID(xItem, num);
/*      */         
/*      */ 
/* 1069 */         BasicItem b = new BasicItem(xItem.copy());
/* 1070 */         b.setNumber(num);
/* 1071 */         b.getUuid().clear();
/* 1072 */         b.getUuid().addAll(removeUuidSet);
/*      */         
/* 1074 */         ItemOperateResult.ChangeItemInfo c = new ItemOperateResult.ChangeItemInfo(grid.intValue(), b, false);
/* 1075 */         delItemInfos.add(c);
/* 1076 */         num = 0;
/*      */ 
/*      */       }
/*      */       else
/*      */       {
/* 1081 */         removekey.add(grid);
/* 1082 */         num -= xItem.getNumber();
/* 1083 */         if (num == 0) {
/*      */           break;
/*      */         }
/*      */       }
/*      */     }
/*      */     
/* 1089 */     if (num != 0)
/*      */     {
/* 1091 */       rollbackAddItem(delItemInfos);
/* 1092 */       return new ItemOperateResult(ItemOperateResult.ItemResultEnum.WRONG_NUMBER);
/*      */     }
/*      */     
/* 1095 */     for (Iterator i$ = removekey.iterator(); i$.hasNext();) { int key = ((Integer)i$.next()).intValue();
/*      */       
/* 1097 */       Item item = (Item)this.xBag.getItems().remove(Integer.valueOf(key));
/* 1098 */       BasicItem b = new BasicItem(item);
/* 1099 */       ItemOperateResult.ChangeItemInfo c = new ItemOperateResult.ChangeItemInfo(key, b.getCopyItem(), true);
/* 1100 */       delItemInfos.add(c);
/*      */     }
/*      */     
/* 1103 */     return new ItemOperateResult(ItemOperateResult.ItemResultEnum.SUCCESS, delItemInfos);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public ItemOperateResult removeItemsWithBindFirst(int itemid, int number)
/*      */   {
/* 1116 */     if (number <= 0) {
/* 1117 */       return new ItemOperateResult(ItemOperateResult.ItemResultEnum.WRONG_NUMBER, ItemOperateResult.RemoveModelEnum.BIND_FIRST);
/*      */     }
/* 1119 */     int bindNum = getBindedItemNum(itemid);
/*      */     
/* 1121 */     int putongNum = getUnbindItemNum(itemid);
/*      */     
/* 1123 */     if (bindNum + putongNum < number)
/*      */     {
/* 1125 */       return new ItemOperateResult(ItemOperateResult.ItemResultEnum.WRONG_NUMBER, ItemOperateResult.RemoveModelEnum.BIND_FIRST);
/*      */     }
/* 1127 */     if (bindNum >= number)
/*      */     {
/* 1129 */       return removeBindedItem(itemid, number);
/*      */     }
/*      */     
/*      */ 
/* 1133 */     ItemOperateResult ret1 = removeBindedItem(itemid, bindNum);
/* 1134 */     if (!ret1.success())
/*      */     {
/* 1136 */       return ret1;
/*      */     }
/* 1138 */     ItemOperateResult ret2 = removeUnbindItem(itemid, number - bindNum, ItemOperateResult.RemoveModelEnum.BIND_FIRST);
/* 1139 */     if (!ret2.success())
/*      */     {
/* 1141 */       rollbackAddItem(ret1.getChangeItemInfoList());
/* 1142 */       return ret2;
/*      */     }
/* 1144 */     List<ItemOperateResult.ChangeItemInfo> delItemInfos = new ArrayList();
/* 1145 */     delItemInfos.addAll(ret1.getChangeItemInfoList());
/* 1146 */     delItemInfos.addAll(ret2.getChangeItemInfoList());
/* 1147 */     return new ItemOperateResult(ItemOperateResult.ItemResultEnum.SUCCESS, delItemInfos, ItemOperateResult.RemoveModelEnum.BIND_FIRST);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public ItemOperateResult removeItemsWithUnbindFirst(int itemid, int number)
/*      */   {
/* 1162 */     if (number <= 0) {
/* 1163 */       return new ItemOperateResult(ItemOperateResult.ItemResultEnum.WRONG_NUMBER, ItemOperateResult.RemoveModelEnum.UNBIND_FIRST);
/*      */     }
/* 1165 */     int bindNum = getBindedItemNum(itemid);
/*      */     
/* 1167 */     int unbindNum = getUnbindItemNum(itemid);
/*      */     
/* 1169 */     if (bindNum + unbindNum < number)
/*      */     {
/* 1171 */       return new ItemOperateResult(ItemOperateResult.ItemResultEnum.WRONG_NUMBER, ItemOperateResult.RemoveModelEnum.UNBIND_FIRST);
/*      */     }
/* 1173 */     if (unbindNum >= number)
/*      */     {
/* 1175 */       return removeUnbindItem(itemid, number, ItemOperateResult.RemoveModelEnum.UNBIND_FIRST);
/*      */     }
/*      */     
/*      */ 
/* 1179 */     ItemOperateResult ret1 = removeUnbindItem(itemid, unbindNum, ItemOperateResult.RemoveModelEnum.UNBIND_FIRST);
/* 1180 */     if (!ret1.success())
/*      */     {
/* 1182 */       return ret1;
/*      */     }
/* 1184 */     ItemOperateResult ret2 = removeBindedItem(itemid, number - unbindNum);
/* 1185 */     if (!ret2.success())
/*      */     {
/* 1187 */       rollbackAddItem(ret1.getChangeItemInfoList());
/* 1188 */       return ret2;
/*      */     }
/* 1190 */     List<ItemOperateResult.ChangeItemInfo> delItemInfos = new ArrayList();
/* 1191 */     delItemInfos.addAll(ret1.getChangeItemInfoList());
/* 1192 */     delItemInfos.addAll(ret2.getChangeItemInfoList());
/* 1193 */     return new ItemOperateResult(ItemOperateResult.ItemResultEnum.SUCCESS, delItemInfos, ItemOperateResult.RemoveModelEnum.UNBIND_FIRST);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public boolean arrange()
/*      */   {
/* 1207 */     Set<Integer> toRemove = new TreeSet();
/* 1208 */     for (Map.Entry<Integer, Item> entry : this.xBag.getItems().entrySet())
/*      */     {
/* 1210 */       if (((Item)entry.getValue()).getNumber() == 0)
/*      */       {
/* 1212 */         toRemove.add(entry.getKey());
/*      */       }
/*      */     }
/*      */     
/* 1216 */     for (Iterator i$ = toRemove.iterator(); i$.hasNext();) { int key = ((Integer)i$.next()).intValue();
/*      */       
/* 1218 */       this.xBag.getItems().remove(Integer.valueOf(key));
/*      */     }
/*      */     
/* 1221 */     List<Item> itemToMaxList = new ArrayList();
/* 1222 */     List<Item> itemNotToMaxList = new ArrayList();
/* 1223 */     for (Item item : this.xBag.getItems().values())
/*      */     {
/* 1225 */       if (item.getNumber() >= ItemConfigManager.getPileMaxCount(item.getCfgid()))
/*      */       {
/* 1227 */         itemToMaxList.add(item.copy());
/*      */       }
/*      */       else
/*      */       {
/* 1231 */         itemNotToMaxList.add(item.copy());
/*      */       }
/*      */     }
/*      */     
/* 1235 */     for (int i = 0; i < itemNotToMaxList.size(); i++)
/*      */     {
/* 1237 */       Item item_i = (Item)itemNotToMaxList.get(i);
/* 1238 */       for (int j = i + 1; j < itemNotToMaxList.size(); j++)
/*      */       {
/* 1240 */         Item item_j = (Item)itemNotToMaxList.get(j);
/* 1241 */         mergerItem(item_i, item_j);
/*      */       }
/*      */     }
/*      */     
/* 1245 */     for (int i = 0; i < itemNotToMaxList.size(); i++)
/*      */     {
/* 1247 */       Item item_i = (Item)itemNotToMaxList.get(i);
/* 1248 */       if (item_i.getNumber() > 0)
/*      */       {
/* 1250 */         itemToMaxList.add(item_i);
/*      */       }
/*      */     }
/*      */     
/*      */ 
/*      */ 
/* 1256 */     Collections.sort(itemToMaxList, new ItemComparator(null));
/*      */     
/*      */ 
/*      */ 
/* 1260 */     int pos = 0;
/* 1261 */     for (Item item : itemToMaxList)
/*      */     {
/* 1263 */       Item srcItem = (Item)this.xBag.getItems().get(Integer.valueOf(pos));
/* 1264 */       if (!item.equals(srcItem))
/*      */       {
/*      */ 
/* 1267 */         this.xBag.getItems().put(Integer.valueOf(pos), item);
/*      */       }
/*      */       
/* 1270 */       pos++;
/*      */     }
/* 1272 */     for (int i = itemToMaxList.size(); i < this.xBag.getCapacity(); i++)
/*      */     {
/* 1274 */       this.xBag.getItems().remove(Integer.valueOf(i));
/*      */     }
/*      */     
/* 1277 */     return true;
/*      */   }
/*      */   
/*      */   private static class ItemComparator
/*      */     implements Comparator<Item>
/*      */   {
/*      */     public int compare(Item o1, Item o2)
/*      */     {
/* 1285 */       int o1CfgId = o1.getCfgid();
/* 1286 */       int o2CfgId = o2.getCfgid();
/* 1287 */       SItemCfg o1ItemCfg = SItemCfg.get(o1CfgId);
/* 1288 */       SItemCfg o2ItemCfg = SItemCfg.get(o2CfgId);
/* 1289 */       int bagsort1 = ItemConfigManager.getBagSort(o1ItemCfg.type);
/* 1290 */       int bagsort2 = ItemConfigManager.getBagSort(o2ItemCfg.type);
/* 1291 */       if (bagsort1 < bagsort2)
/*      */       {
/* 1293 */         return -1;
/*      */       }
/* 1295 */       if (bagsort1 > bagsort2)
/*      */       {
/* 1297 */         return 1;
/*      */       }
/* 1299 */       if (o1ItemCfg.sort < o2ItemCfg.sort)
/* 1300 */         return -1;
/* 1301 */       if (o1ItemCfg.sort > o2ItemCfg.sort)
/* 1302 */         return 1;
/* 1303 */       if (o1CfgId < o2CfgId)
/* 1304 */         return -1;
/* 1305 */       if (o1CfgId > o2CfgId)
/* 1306 */         return 1;
/* 1307 */       boolean o1Bind = (o1.getFlags() & 0x1) == 1;
/* 1308 */       boolean o2Bind = (o2.getFlags() & 0x1) == 1;
/* 1309 */       if ((!o1Bind) && (o2Bind))
/* 1310 */         return -1;
/* 1311 */       if ((o1Bind) && (!o2Bind))
/* 1312 */         return 1;
/* 1313 */       if (o1.getNumber() > o2.getNumber())
/* 1314 */         return -1;
/* 1315 */       if (o1.getNumber() < o2.getNumber()) {
/* 1316 */         return 1;
/*      */       }
/*      */       
/*      */ 
/*      */ 
/* 1321 */       long uuid1 = ((Long)o1.getUuid().iterator().next()).longValue();
/* 1322 */       long uuid2 = ((Long)o2.getUuid().iterator().next()).longValue();
/* 1323 */       if (uuid1 > uuid2) {
/* 1324 */         return -1;
/*      */       }
/*      */       
/* 1327 */       return 1;
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public ItemOperateResult removeBindedItem(int itemId, int num)
/*      */   {
/* 1343 */     int count = getBindedItemNum(itemId);
/* 1344 */     if ((num < 0) || (count < num))
/*      */     {
/* 1346 */       return new ItemOperateResult(ItemOperateResult.ItemResultEnum.WRONG_NUMBER);
/*      */     }
/*      */     
/* 1349 */     return delItemFromItemMap(getBindedItem(itemId), num);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private Map<Integer, Item> getBindedItem(int itemId)
/*      */   {
/* 1362 */     Map<Integer, Item> resultMap = new HashMap();
/* 1363 */     for (Map.Entry<Integer, Item> e : this.xBag.getItems().entrySet())
/*      */     {
/* 1365 */       Item v = (Item)e.getValue();
/* 1366 */       if ((v.getCfgid() == itemId) && ((v.getFlags() & 0x1) != 0))
/*      */       {
/*      */ 
/* 1369 */         if (ItemManager.checkTimeIsValid(v))
/*      */         {
/*      */ 
/*      */ 
/* 1373 */           resultMap.put(e.getKey(), v);
/*      */         }
/*      */       }
/*      */     }
/* 1377 */     return resultMap;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private int getBindedItemNum(int itemId)
/*      */   {
/* 1390 */     Map<Integer, Item> resultMap = getBindedItem(itemId);
/* 1391 */     int count = 0;
/* 1392 */     for (Item i : resultMap.values())
/*      */     {
/* 1394 */       count += i.getNumber();
/*      */     }
/* 1396 */     return count;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private Map<Integer, Item> getUnbindItem(int itemId)
/*      */   {
/* 1408 */     Map<Integer, Item> resultMap = new HashMap();
/* 1409 */     for (Map.Entry<Integer, Item> e : this.xBag.getItems().entrySet())
/*      */     {
/* 1411 */       Item v = (Item)e.getValue();
/*      */       
/* 1413 */       if ((v.getCfgid() == itemId) && ((v.getFlags() & 0x1) == 0))
/*      */       {
/* 1415 */         if (ItemManager.checkTimeIsValid(v))
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/* 1420 */           resultMap.put(e.getKey(), v);
/*      */         }
/*      */       }
/*      */     }
/* 1424 */     return resultMap;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private int getUnbindItemNum(int itemId)
/*      */   {
/* 1435 */     Map<Integer, Item> resultMap = getUnbindItem(itemId);
/* 1436 */     int count = 0;
/* 1437 */     for (Item i : resultMap.values())
/*      */     {
/* 1439 */       count += i.getNumber();
/*      */     }
/* 1441 */     return count;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private ItemOperateResult removeUnbindItem(int itemId, int num, ItemOperateResult.RemoveModelEnum removeModelEnum)
/*      */   {
/* 1454 */     int count = getUnbindItemNum(itemId);
/* 1455 */     if ((num < 0) || (count < num))
/*      */     {
/* 1457 */       return new ItemOperateResult(ItemOperateResult.ItemResultEnum.WRONG_NUMBER, removeModelEnum);
/*      */     }
/*      */     
/* 1460 */     return delItemFromItemMap(getUnbindItem(itemId), num);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public BasicItem getAndRemoveItem(int grid, int number, boolean isContainTimeNotValidItem)
/*      */   {
/* 1475 */     BasicItem item = get(grid);
/*      */     
/* 1477 */     if ((item == null) || (item.getNumber() < number))
/*      */     {
/* 1479 */       return null;
/*      */     }
/*      */     
/* 1482 */     if ((!isContainTimeNotValidItem) && (!ItemManager.checkTimeIsValid(item.xItem)))
/*      */     {
/* 1484 */       return null;
/*      */     }
/*      */     
/* 1487 */     Item desItem = item.getCopyItem();
/* 1488 */     desItem.setNumber(0);
/* 1489 */     desItem.getUuid().clear();
/* 1490 */     moveUUID(desItem, item.getItem(), number);
/*      */     
/* 1492 */     if (item.getNumber() == 0)
/*      */     {
/* 1494 */       this.xBag.getItems().remove(Integer.valueOf(grid));
/*      */     }
/* 1496 */     return ItemManager.getBasicItem(desItem);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public BasicItem getAndRemoveItem(int grid, int number)
/*      */   {
/* 1508 */     return getAndRemoveItem(grid, number, false);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public ItemOperateResult removeItemByType(int type, int number)
/*      */   {
/* 1520 */     return removeItemByType(type, number, false);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public ItemOperateResult removeItemByType(int type, int number, boolean isBindFirst)
/*      */   {
/* 1534 */     Map<Integer, Item> ret = new HashMap();
/* 1535 */     int count = getItemNumberByType(type, ret);
/*      */     
/* 1537 */     if ((number < 0) || (count < number))
/*      */     {
/* 1539 */       return new ItemOperateResult(ItemOperateResult.ItemResultEnum.WRONG_NUMBER);
/*      */     }
/*      */     
/* 1542 */     return delItemFromItemMap(ret, number, isBindFirst);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private int getItemNumberByType(int type, Map<Integer, Item> ret)
/*      */   {
/* 1557 */     int count = 0;
/* 1558 */     Map<Integer, Item> itemMap = this.xBag.getItems();
/* 1559 */     for (Map.Entry<Integer, Item> i : itemMap.entrySet())
/*      */     {
/* 1561 */       Item xItem = (Item)i.getValue();
/* 1562 */       if (SItemCfg.get(xItem.getCfgid()).type == type)
/*      */       {
/* 1564 */         if (ItemManager.checkTimeIsValid(xItem))
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/* 1569 */           ret.put(i.getKey(), xItem);
/* 1570 */           count += xItem.getNumber();
/*      */         } }
/*      */     }
/* 1573 */     return count;
/*      */   }
/*      */   
/*      */   public int getItemNumberByType(int type)
/*      */   {
/* 1578 */     int count = 0;
/* 1579 */     Map<Integer, Item> itemMap = this.xBag.getItems();
/* 1580 */     for (Map.Entry<Integer, Item> entry : itemMap.entrySet())
/*      */     {
/* 1582 */       Item xItem = (Item)entry.getValue();
/* 1583 */       if (SItemCfg.get(xItem.getCfgid()).type == type)
/*      */       {
/* 1585 */         if (ItemManager.checkTimeIsValid(xItem))
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/* 1590 */           count += xItem.getNumber(); }
/*      */       }
/*      */     }
/* 1593 */     return count;
/*      */   }
/*      */   
/*      */ 
/*      */   public void clear()
/*      */   {
/* 1599 */     this.xBag.getItems().clear();
/*      */   }
/*      */   
/*      */   Map<Integer, Item> getItems()
/*      */   {
/* 1604 */     return this.xBag.getItems();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public Map<Integer, BasicItem> getItemByType(int type)
/*      */   {
/* 1615 */     Map<Integer, BasicItem> ret = new HashMap();
/* 1616 */     Map<Integer, Item> itemMap = this.xBag.getItems();
/* 1617 */     for (Map.Entry<Integer, Item> i : itemMap.entrySet())
/*      */     {
/* 1619 */       Item xItem = (Item)i.getValue();
/*      */       
/* 1621 */       SItemCfg sItemCfg = SItemCfg.get(xItem.getCfgid());
/* 1622 */       if (sItemCfg != null)
/*      */       {
/*      */ 
/*      */ 
/*      */ 
/* 1627 */         if (sItemCfg.type == type)
/*      */         {
/* 1629 */           BasicItem basicItem = ItemManager.getBasicItem(xItem);
/* 1630 */           if ((basicItem != null) && 
/*      */           
/*      */ 
/*      */ 
/*      */ 
/* 1635 */             (ItemManager.checkTimeIsValid(xItem)))
/*      */           {
/*      */ 
/*      */ 
/*      */ 
/* 1640 */             ret.put(i.getKey(), basicItem); }
/*      */         } }
/*      */     }
/* 1643 */     return ret;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public ItemOperateResult removeItemByUuid(long uuid, int number)
/*      */   {
/* 1656 */     return removeItemByUuid(uuid, number, false);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   ItemOperateResult removeItemByUuid(long uuid, int number, boolean isContainExpiredItem)
/*      */   {
/* 1672 */     if (number <= 0)
/*      */     {
/* 1674 */       return new ItemOperateResult(ItemOperateResult.ItemResultEnum.UN_KNOWN_ERROR);
/*      */     }
/* 1676 */     List<ItemOperateResult.ChangeItemInfo> removeItemInfos = new ArrayList();
/* 1677 */     int grid = getGridByUuid(uuid);
/* 1678 */     BasicItem basicItem = get(grid);
/* 1679 */     if (basicItem == null)
/*      */     {
/* 1681 */       return new ItemOperateResult(ItemOperateResult.ItemResultEnum.UN_KNOWN_ERROR);
/*      */     }
/* 1683 */     if (basicItem.getNumber() < number)
/*      */     {
/* 1685 */       return new ItemOperateResult(ItemOperateResult.ItemResultEnum.WRONG_NUMBER);
/*      */     }
/*      */     
/* 1688 */     if ((!isContainExpiredItem) && (!ItemManager.checkTimeIsValid(basicItem.xItem)))
/*      */     {
/* 1690 */       return new ItemOperateResult(ItemOperateResult.ItemResultEnum.ITEM_TIME_NOT_VALID);
/*      */     }
/*      */     
/* 1693 */     Item copyItem = basicItem.getCopyItem();
/* 1694 */     copyItem.getUuid().clear();
/*      */     
/*      */ 
/* 1697 */     List<Long> uuidsList = new ArrayList();
/* 1698 */     uuidsList.addAll(basicItem.getUuid());
/* 1699 */     Collections.sort(uuidsList);
/* 1700 */     List<Long> toremoveuuids = new ArrayList(number);
/* 1701 */     for (int i = uuidsList.size() - 1; i >= 0; i--)
/*      */     {
/* 1703 */       toremoveuuids.add(uuidsList.get(i));
/* 1704 */       if (toremoveuuids.size() == number) {
/*      */         break;
/*      */       }
/*      */     }
/*      */     
/*      */ 
/* 1710 */     basicItem.getUuid().removeAll(toremoveuuids);
/*      */     
/* 1712 */     basicItem.setNumber(basicItem.getNumber() - number);
/* 1713 */     if (basicItem.getNumber() <= 0)
/*      */     {
/* 1715 */       this.xBag.getItems().remove(Integer.valueOf(grid));
/*      */     }
/* 1717 */     copyItem.setNumber(number);
/* 1718 */     copyItem.getUuid().addAll(toremoveuuids);
/*      */     
/* 1720 */     ItemOperateResult.ChangeItemInfo changeItemInfo = new ItemOperateResult.ChangeItemInfo(grid, copyItem, basicItem.getNumber() <= 0);
/* 1721 */     removeItemInfos.add(changeItemInfo);
/* 1722 */     return new ItemOperateResult(ItemOperateResult.ItemResultEnum.SUCCESS, removeItemInfos);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public ItemOperateResult removeItemByUuid(Map<Long, Integer> uuid2Num)
/*      */   {
/* 1734 */     if ((uuid2Num == null) || (uuid2Num.size() == 0))
/*      */     {
/* 1736 */       return new ItemOperateResult(ItemOperateResult.ItemResultEnum.WRONG_NUMBER);
/*      */     }
/*      */     
/* 1739 */     List<ItemOperateResult.ChangeItemInfo> removeItemInfos = new ArrayList();
/* 1740 */     for (Iterator i$ = uuid2Num.keySet().iterator(); i$.hasNext();) { long uuid = ((Long)i$.next()).longValue();
/*      */       
/* 1742 */       ItemOperateResult ret = removeItemByUuid(uuid, ((Integer)uuid2Num.get(Long.valueOf(uuid))).intValue());
/* 1743 */       removeItemInfos.addAll(ret.getChangeItemInfoList());
/* 1744 */       if (!ret.success())
/*      */       {
/* 1746 */         rollbackAddItem(removeItemInfos);
/* 1747 */         return ret;
/*      */       }
/*      */     }
/*      */     
/* 1751 */     return new ItemOperateResult(ItemOperateResult.ItemResultEnum.SUCCESS, removeItemInfos);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public ItemOperateResult removeItemsByItemId(Map<Integer, Integer> itemId2num)
/*      */   {
/* 1762 */     Map<Integer, Integer> toRemoveItemMap = new HashMap(itemId2num);
/*      */     
/*      */ 
/* 1765 */     List<Integer> toRemoveGrid = new ArrayList();
/*      */     
/* 1767 */     Map<Integer, Integer> grid2num = new HashMap();
/*      */     
/* 1769 */     for (Map.Entry<Integer, Item> itemEntry : this.xBag.getItems().entrySet())
/*      */     {
/* 1771 */       Item xItem = (Item)itemEntry.getValue();
/*      */       
/* 1773 */       if (ItemManager.checkTimeIsValid(xItem))
/*      */       {
/*      */ 
/*      */ 
/*      */ 
/* 1778 */         int itemid = xItem.getCfgid();
/* 1779 */         if (toRemoveItemMap.containsKey(Integer.valueOf(itemid)))
/*      */         {
/* 1781 */           if (xItem.getNumber() <= ((Integer)toRemoveItemMap.get(Integer.valueOf(itemid))).intValue())
/*      */           {
/* 1783 */             toRemoveGrid.add(itemEntry.getKey());
/* 1784 */             toRemoveItemMap.put(Integer.valueOf(itemid), Integer.valueOf(((Integer)toRemoveItemMap.get(Integer.valueOf(itemid))).intValue() - xItem.getNumber()));
/* 1785 */             if (((Integer)toRemoveItemMap.get(Integer.valueOf(itemid))).intValue() == 0)
/*      */             {
/* 1787 */               toRemoveItemMap.remove(Integer.valueOf(itemid));
/*      */             }
/* 1789 */             grid2num.put(itemEntry.getKey(), Integer.valueOf(xItem.getNumber()));
/*      */           }
/*      */           else
/*      */           {
/* 1793 */             grid2num.put(itemEntry.getKey(), toRemoveItemMap.get(Integer.valueOf(itemid)));
/* 1794 */             toRemoveItemMap.remove(Integer.valueOf(itemid));
/*      */           }
/*      */         }
/*      */         
/* 1798 */         if (toRemoveItemMap.isEmpty()) {
/*      */           break;
/*      */         }
/*      */       }
/*      */     }
/*      */     
/* 1804 */     if (!toRemoveItemMap.isEmpty())
/*      */     {
/* 1806 */       return new ItemOperateResult(ItemOperateResult.ItemResultEnum.WRONG_NUMBER);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/* 1811 */     List<ItemOperateResult.ChangeItemInfo> delItemInfos = new ArrayList();
/* 1812 */     for (Iterator i$ = toRemoveGrid.iterator(); i$.hasNext();) { int grid = ((Integer)i$.next()).intValue();
/*      */       
/* 1814 */       Item item = (Item)this.xBag.getItems().remove(Integer.valueOf(grid));
/*      */       
/* 1816 */       BasicItem b = new BasicItem(item.copy());
/* 1817 */       b.setNumber(((Integer)grid2num.get(Integer.valueOf(grid))).intValue());
/* 1818 */       grid2num.remove(Integer.valueOf(grid));
/* 1819 */       ItemOperateResult.ChangeItemInfo c = new ItemOperateResult.ChangeItemInfo(grid, b, true);
/* 1820 */       delItemInfos.add(c);
/*      */     }
/*      */     
/*      */ 
/* 1824 */     for (Iterator i$ = grid2num.keySet().iterator(); i$.hasNext();) { int grid = ((Integer)i$.next()).intValue();
/*      */       
/* 1826 */       Item item = (Item)this.xBag.getItems().get(Integer.valueOf(grid));
/*      */       
/* 1828 */       Set<Long> uuidSet = removeUUID(item, ((Integer)grid2num.get(Integer.valueOf(grid))).intValue());
/*      */       
/*      */ 
/* 1831 */       BasicItem b = new BasicItem(item.copy());
/* 1832 */       b.setNumber(((Integer)grid2num.get(Integer.valueOf(grid))).intValue());
/* 1833 */       b.getUuid().clear();
/* 1834 */       b.getUuid().addAll(uuidSet);
/* 1835 */       ItemOperateResult.ChangeItemInfo c = new ItemOperateResult.ChangeItemInfo(grid, b, false);
/*      */       
/* 1837 */       delItemInfos.add(c);
/*      */     }
/* 1839 */     return new ItemOperateResult(ItemOperateResult.ItemResultEnum.SUCCESS, delItemInfos);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public void computeToRemoveGridAndDelta(Map<Integer, Integer> itemId2num, List<Integer> toRemoveGridList, Map<Integer, Integer> grid2num)
/*      */   {
/* 1858 */     for (Map.Entry<Integer, Item> itemEntry : this.xBag.getItems().entrySet())
/*      */     {
/* 1860 */       if (ItemManager.checkTimeIsValid((Item)itemEntry.getValue()))
/*      */       {
/*      */ 
/*      */ 
/*      */ 
/* 1865 */         int itemid = ((Item)itemEntry.getValue()).getCfgid();
/* 1866 */         if (itemId2num.containsKey(Integer.valueOf(itemid)))
/*      */         {
/* 1868 */           if (((Item)itemEntry.getValue()).getNumber() <= ((Integer)itemId2num.get(Integer.valueOf(itemid))).intValue())
/*      */           {
/* 1870 */             toRemoveGridList.add(itemEntry.getKey());
/* 1871 */             itemId2num.put(Integer.valueOf(itemid), Integer.valueOf(((Integer)itemId2num.get(Integer.valueOf(itemid))).intValue() - ((Item)itemEntry.getValue()).getNumber()));
/* 1872 */             if (((Integer)itemId2num.get(Integer.valueOf(itemid))).intValue() == 0)
/*      */             {
/* 1874 */               itemId2num.remove(Integer.valueOf(itemid));
/*      */             }
/*      */           }
/*      */           else
/*      */           {
/* 1879 */             grid2num.put(itemEntry.getKey(), itemId2num.get(Integer.valueOf(itemid)));
/* 1880 */             itemId2num.remove(Integer.valueOf(itemid));
/*      */           }
/*      */         }
/*      */         
/* 1884 */         if (itemId2num.isEmpty()) {
/*      */           break;
/*      */         }
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public String getBagName()
/*      */   {
/* 1899 */     return this.xBag.getBagname();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public boolean setBagName(String name)
/*      */   {
/* 1909 */     this.xBag.setBagname(name);
/* 1910 */     return true;
/*      */   }
/*      */   
/*      */   public Bag getXBag()
/*      */   {
/* 1915 */     return this.xBag;
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\main\RoleItemBag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */