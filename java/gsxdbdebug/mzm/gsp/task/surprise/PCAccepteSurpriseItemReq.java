/*     */ package mzm.gsp.task.surprise;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.Collection;
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.activity3.confbean.NeedItemInfo;
/*     */ import mzm.gsp.activity3.confbean.SSurpriseItemTaskCfg;
/*     */ import mzm.gsp.activity3.confbean.STSurpriseItemConCfg;
/*     */ import mzm.gsp.item.main.BasicItem;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.item.main.ItemOperateResult;
/*     */ import mzm.gsp.item.main.ItemStoreEnum;
/*     */ import mzm.gsp.map.main.MapInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.task.confbean.TaskConsts;
/*     */ import mzm.gsp.task.main.TaskInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import xtable.Basic;
/*     */ import xtable.User;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PCAccepteSurpriseItemReq
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final int serverId;
/*     */   private final Set<Long> uuids;
/*     */   
/*     */   public PCAccepteSurpriseItemReq(long roleId, int serverId, Set<Long> uuids)
/*     */   {
/*  43 */     this.roleId = roleId;
/*  44 */     this.serverId = serverId;
/*  45 */     this.uuids = uuids;
/*     */   }
/*     */   
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  52 */     SSurpriseItemTaskCfg cfg = SSurpriseItemTaskCfg.get(this.serverId);
/*  53 */     if (!canActiveGraph(cfg))
/*     */     {
/*  55 */       return false;
/*     */     }
/*     */     
/*  58 */     lock(User.getTable(), Arrays.asList(new String[] { RoleInterface.getUserId(this.roleId) }));
/*     */     
/*  60 */     lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleId) }));
/*     */     
/*  62 */     if (!SurpriseTaskManager.neverAcceptGraph(this.roleId, cfg.graphId, cfg.finishCount))
/*     */     {
/*  64 */       SurpriseTaskManager.loggerError("PCAccepteSurpriseItemReq.processImp@ already finished graph!|roleId=%d|serverId=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.serverId) });
/*     */       
/*  66 */       return false;
/*     */     }
/*     */     
/*  69 */     if (!isItemConditionCompleted(this.roleId, cfg.itemConId, cfg.isTakeAway, this.uuids, cfg.itemType))
/*     */     {
/*  71 */       return false;
/*     */     }
/*     */     
/*  74 */     boolean isTakeAway = cfg.isTakeAway;
/*  75 */     if (!takeAwayItems(isTakeAway, cfg.itemConId, cfg.itemType, this.uuids))
/*     */     {
/*  77 */       SurpriseTaskManager.loggerError("PCAccepteSurpriseItemReq.processImp@ remove item error!|roleId=%d|serverId=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.serverId) });
/*     */       
/*  79 */       return false;
/*     */     }
/*     */     
/*  82 */     if (!TaskInterface.activeGraph(Long.valueOf(this.roleId), cfg.graphId))
/*     */     {
/*  84 */       SurpriseTaskManager.loggerError("PCAccepteSurpriseItemReq.processImp@ activeGraph error!|roleId=%d|serverId=%d|graphId=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.serverId), Integer.valueOf(cfg.graphId) });
/*     */       
/*     */ 
/*  87 */       return false;
/*     */     }
/*     */     
/*  90 */     SurpriseTaskManager.tlogSurprise(RoleInterface.getUserId(this.roleId), this.roleId, 1, this.serverId, cfg.graphId);
/*     */     
/*  92 */     return true;
/*     */   }
/*     */   
/*     */   private boolean takeAwayItems(boolean isTakeAway, int itemConId, int itemType, Set<Long> uuids)
/*     */   {
/*  97 */     if (!isTakeAway)
/*     */     {
/*  99 */       return true;
/*     */     }
/* 101 */     if (itemType == 1)
/*     */     {
/*     */ 
/* 104 */       ItemOperateResult itemOperateResult = ItemInterface.removeItemById(this.roleId, getItemXId2Num(itemConId), new TLogArg(LogReason.SURPRISE_COLLECT_AND_REMOVE_ITEM, this.serverId));
/*     */       
/* 106 */       if (!itemOperateResult.success())
/*     */       {
/* 108 */         SurpriseTaskManager.loggerError("PCAccepteSurpriseItemReq.takeAwayItems@ remove item error!|roleId=%d|serverId=%d|res=%s", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.serverId), itemOperateResult.getResultEnum() });
/*     */         
/*     */ 
/* 111 */         return false;
/*     */       }
/* 113 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 118 */     return removeHandupUuids(uuids);
/*     */   }
/*     */   
/*     */ 
/*     */   private Map<Integer, Integer> getItemXId2Num(int conId)
/*     */   {
/* 124 */     STSurpriseItemConCfg conCfg = STSurpriseItemConCfg.get(conId);
/* 125 */     if (conCfg == null)
/*     */     {
/* 127 */       return Collections.emptyMap();
/*     */     }
/* 129 */     Map<Integer, Integer> itemXId2Num = new HashMap();
/* 130 */     for (Map.Entry<Integer, NeedItemInfo> entry : conCfg.needItemDatas.entrySet())
/*     */     {
/* 132 */       itemXId2Num.put(entry.getKey(), Integer.valueOf(((NeedItemInfo)entry.getValue()).needNum));
/*     */     }
/* 134 */     return itemXId2Num;
/*     */   }
/*     */   
/*     */   private boolean removeHandupUuids(Set<Long> uuids)
/*     */   {
/* 139 */     Map<Long, Integer> uuid2num = new HashMap();
/* 140 */     for (Iterator i$ = uuids.iterator(); i$.hasNext();) { long uuid = ((Long)i$.next()).longValue();
/*     */       
/* 142 */       uuid2num.put(Long.valueOf(uuid), Integer.valueOf(1));
/*     */     }
/* 144 */     ItemOperateResult ret = ItemInterface.removeItemByUuid(this.roleId, uuid2num, new TLogArg(LogReason.SURPRISE_COLLECT_AND_REMOVE_ITEM, this.serverId));
/*     */     
/* 146 */     if (ret.success())
/*     */     {
/* 148 */       return true;
/*     */     }
/* 150 */     SurpriseTaskManager.loggerError("PCAccepteSurpriseItemReq.takeAwayItems@ remove item error!|roleId=%d|serverId=%d|graphId=%d|uuids=%s|res=%s", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.serverId), uuids, ret.getResultEnum() });
/*     */     
/*     */ 
/* 153 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean canActiveGraph(SSurpriseItemTaskCfg cfg)
/*     */   {
/* 164 */     if (cfg == null)
/*     */     {
/* 166 */       SurpriseTaskManager.loggerError("PCAccepteSurpriseItemReq.canActiveGraph@ serverId is invalid!|roleId=%d|serverId=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.serverId) });
/*     */       
/* 168 */       return false;
/*     */     }
/* 170 */     int level = RoleInterface.getLevel(this.roleId);
/* 171 */     if (level < cfg.joinLevel)
/*     */     {
/* 173 */       SurpriseTaskManager.loggerError("PCAccepteSurpriseItemReq.canActiveGraph@ role level is not enough!|roleId=%d|level=%d|cfgLevel=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(level), Integer.valueOf(cfg.joinLevel) });
/*     */       
/*     */ 
/* 176 */       return false;
/*     */     }
/* 178 */     if (!SurpriseTaskManager.isServerlevelValid(cfg.joinServerLevel, cfg.needServerLevelTime))
/*     */     {
/* 180 */       SurpriseTaskManager.loggerError("PCAccepteSurpriseItemReq.canActiveGraph@ server level is invalid!|roleId=%d|serverId=%d|activityId=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.serverId), Integer.valueOf(cfg.activityId) });
/*     */       
/*     */ 
/* 183 */       return false;
/*     */     }
/* 185 */     if (!SurpriseTaskManager.isActivityValid(cfg.activityId))
/*     */     {
/* 187 */       SurpriseTaskManager.loggerError("PCAccepteSurpriseItemReq.canActiveGraph@ activity is invalid!|roleId=%d|serverId=%d|activityId=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.serverId), Integer.valueOf(cfg.activityId) });
/*     */       
/*     */ 
/* 190 */       return false;
/*     */     }
/*     */     
/* 193 */     if (!MapInterface.isNearByNPC(this.roleId, cfg.npcId))
/*     */     {
/* 195 */       SurpriseTaskManager.loggerError("PCAccepteSurpriseItemReq.canActiveGraph@ not near by npc!|roleId=%d|serverId=%d|npcId=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.serverId), Integer.valueOf(cfg.npcId) });
/*     */       
/*     */ 
/* 198 */       return false;
/*     */     }
/*     */     
/* 201 */     if ((cfg.isTakeAway) && (cfg.itemType == 2))
/*     */     {
/* 203 */       if (this.uuids.size() <= 0)
/*     */       {
/* 205 */         SurpriseTaskManager.loggerError("PCAccepteSurpriseItemReq.canActiveGraph@ uuid is null!|roleId=%d|serverId=%d|npcId=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.serverId), Integer.valueOf(cfg.npcId) });
/*     */         
/*     */ 
/* 208 */         return false;
/*     */       }
/*     */     }
/* 211 */     return true;
/*     */   }
/*     */   
/*     */   boolean isItemConditionCompleted(long roleId, int conditionId, boolean isTakeAway, Set<Long> uuids, int itemType)
/*     */   {
/* 216 */     STSurpriseItemConCfg conCfg = STSurpriseItemConCfg.get(conditionId);
/* 217 */     if (conCfg == null)
/*     */     {
/* 219 */       return false;
/*     */     }
/*     */     
/* 222 */     if ((isTakeAway) && (itemType == 2))
/*     */     {
/* 224 */       return checkHandUpItemValid(roleId, uuids, conCfg, itemType);
/*     */     }
/*     */     
/* 227 */     for (Map.Entry<Integer, NeedItemInfo> entry : conCfg.needItemDatas.entrySet())
/*     */     {
/* 229 */       if (!isNeedItemEnough(roleId, ((Integer)entry.getKey()).intValue(), itemType, ((NeedItemInfo)entry.getValue()).needNum))
/*     */       {
/* 231 */         SurpriseTaskManager.loggerError("PCAccepteSurpriseItemReq.isItemConditionCompleted@ not enough!|roleId=%d|serverId=%d|itemXId=%d|itemType=%d|needNum=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(this.serverId), entry.getKey(), Integer.valueOf(itemType), Integer.valueOf(((NeedItemInfo)entry.getValue()).needNum) });
/*     */         
/*     */ 
/* 234 */         return false;
/*     */       }
/*     */     }
/* 237 */     return true;
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
/*     */   private boolean checkHandUpItemValid(long roleId, Set<Long> uuids, STSurpriseItemConCfg conCfg, int itemType)
/*     */   {
/* 250 */     Map<Integer, Integer> handupItemInfo = getHandUpItemInfo(roleId, uuids);
/* 251 */     if (handupItemInfo.isEmpty())
/*     */     {
/* 253 */       return false;
/*     */     }
/*     */     
/* 256 */     for (Map.Entry<Integer, NeedItemInfo> entry : conCfg.needItemDatas.entrySet())
/*     */     {
/* 258 */       if (!checkSingleXItemValid(roleId, handupItemInfo, ((Integer)entry.getKey()).intValue(), itemType, ((NeedItemInfo)entry.getValue()).needNum))
/*     */       {
/* 260 */         return false;
/*     */       }
/*     */     }
/* 263 */     if (handupItemInfo.size() == 0)
/*     */     {
/* 265 */       return true;
/*     */     }
/*     */     
/* 268 */     SurpriseTaskManager.loggerError("PCAccepteSurpriseItemReq.isItemConditionCompleted@ steal has hand up itemids!|roleId=%d|serverId=%d|handupItemInfo=%s", new Object[] { Long.valueOf(roleId), Integer.valueOf(this.serverId), handupItemInfo });
/*     */     
/*     */ 
/* 271 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private Map<Integer, Integer> getHandUpItemInfo(long roleId, Set<Long> uuids)
/*     */   {
/* 283 */     if (uuids.isEmpty())
/*     */     {
/* 285 */       return Collections.emptyMap();
/*     */     }
/* 287 */     Map<Integer, Integer> handupItemInfo = new HashMap();
/* 288 */     for (Iterator i$ = uuids.iterator(); i$.hasNext();) { long uuid = ((Long)i$.next()).longValue();
/*     */       
/* 290 */       BasicItem basicItem = ItemInterface.getItemByUuid(roleId, uuid);
/* 291 */       if (basicItem == null)
/*     */       {
/* 293 */         SurpriseTaskManager.loggerError("PCAccepteSurpriseItemReq.isItemConditionCompleted@ not own this uuid!|roleId=%d|serverId=%d|uuid=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(this.serverId), Long.valueOf(uuid) });
/*     */         
/*     */ 
/* 296 */         return Collections.emptyMap();
/*     */       }
/* 298 */       int itemId = basicItem.getCfgId();
/* 299 */       Integer orgNum = (Integer)handupItemInfo.get(Integer.valueOf(itemId));
/* 300 */       if (orgNum == null)
/*     */       {
/* 302 */         orgNum = Integer.valueOf(0);
/*     */       }
/* 304 */       handupItemInfo.put(Integer.valueOf(itemId), Integer.valueOf(orgNum.intValue() + 1));
/*     */     }
/* 306 */     return handupItemInfo;
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
/*     */ 
/*     */ 
/*     */   private boolean checkSingleXItemValid(long roleId, Map<Integer, Integer> handupItemInfo, int itemXId, int itemType, int itemNum)
/*     */   {
/* 322 */     if (itemType != 2)
/*     */     {
/*     */ 
/* 325 */       return false;
/*     */     }
/* 327 */     List<Integer> needItemIds = ItemInterface.getSamePriceItems(itemXId);
/* 328 */     if (checkHandUpItemsEnough(handupItemInfo, needItemIds, itemNum))
/*     */     {
/* 330 */       return true;
/*     */     }
/* 332 */     SurpriseTaskManager.loggerError("PCAccepteSurpriseItemReq.checkSingleXItemValid@ not enough!|roleId=%d|serverId=%d|needItemIds=%s|handupItemInfo=%s", new Object[] { Long.valueOf(roleId), Integer.valueOf(this.serverId), needItemIds, handupItemInfo });
/*     */     
/*     */ 
/* 335 */     return false;
/*     */   }
/*     */   
/*     */   boolean checkHandUpItemsEnough(Map<Integer, Integer> handupItemInfo, List<Integer> needItemIds, int needNum)
/*     */   {
/* 340 */     Iterator<Map.Entry<Integer, Integer>> it = handupItemInfo.entrySet().iterator();
/* 341 */     while (it.hasNext())
/*     */     {
/* 343 */       if (needNum == 0)
/*     */       {
/* 345 */         return true;
/*     */       }
/* 347 */       Map.Entry<Integer, Integer> entry = (Map.Entry)it.next();
/* 348 */       int itemId = ((Integer)entry.getKey()).intValue();
/* 349 */       int num = ((Integer)entry.getValue()).intValue();
/* 350 */       if ((num > 0) && (needItemIds.contains(Integer.valueOf(itemId))))
/*     */       {
/*     */ 
/*     */ 
/* 354 */         int leftNum = num;
/* 355 */         if (needNum <= num)
/*     */         {
/* 357 */           leftNum = num - needNum;
/* 358 */           needNum = 0;
/*     */         }
/*     */         else
/*     */         {
/* 362 */           needNum -= num;
/* 363 */           leftNum = 0;
/*     */         }
/* 365 */         if (leftNum == 0)
/*     */         {
/* 367 */           it.remove();
/*     */         }
/*     */         else
/*     */         {
/* 371 */           entry.setValue(Integer.valueOf(leftNum)); }
/*     */       }
/*     */     }
/* 374 */     return needNum == 0;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean isNeedItemEnough(long roleId, int itemXId, int itemType, int needNum)
/*     */   {
/* 384 */     switch (itemType)
/*     */     {
/*     */     case 1: 
/* 387 */       return checkNormalItem(roleId, itemXId, needNum);
/*     */     case 2: 
/* 389 */       return checkConditionItem(roleId, itemXId, needNum);
/*     */     }
/* 391 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */   private boolean checkConditionItem(long roleId, int itemXId, int needNum)
/*     */   {
/* 397 */     long count = getTaskConItemCount(roleId, ItemInterface.getSamePriceItems(itemXId));
/* 398 */     return count >= needNum;
/*     */   }
/*     */   
/*     */   private boolean checkNormalItem(long roleId, int itemXId, int needNum)
/*     */   {
/* 403 */     long count = getTaskConItemCount(roleId, Arrays.asList(new Integer[] { Integer.valueOf(itemXId) }));
/* 404 */     return count >= needNum;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   int getTaskConItemCount(long roleId, Collection<Integer> itemIds)
/*     */   {
/* 416 */     if ((itemIds == null) || (itemIds.size() == 0))
/*     */     {
/* 418 */       return 0;
/*     */     }
/* 420 */     int num = 0;
/* 421 */     for (Iterator i$ = itemIds.iterator(); i$.hasNext();) { int itemId = ((Integer)i$.next()).intValue();
/*     */       
/* 423 */       num += getNeedUuidsNum(roleId, itemId);
/*     */     }
/* 425 */     return num;
/*     */   }
/*     */   
/*     */   private int getNeedUuidsNum(long roleId, int itemId)
/*     */   {
/* 430 */     int qilingLvMax = TaskConsts.getInstance().HAND_UP_ITEM__QILING_LV_MAX;
/* 431 */     Map<Integer, BasicItem> basicItems = ItemInterface.getItemByItemId(roleId, itemId, true);
/* 432 */     if ((basicItems == null) || (basicItems.size() == 0))
/*     */     {
/* 434 */       return 0;
/*     */     }
/* 436 */     int totalNum = 0;
/* 437 */     for (BasicItem basicItem : basicItems.values())
/*     */     {
/* 439 */       Integer qilingLv = basicItem.getExtra(ItemStoreEnum.STRENGTH_LEVEL);
/* 440 */       if ((qilingLv == null) || (qilingLvMax >= qilingLv.intValue()))
/*     */       {
/* 442 */         totalNum += basicItem.getNumber();
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 449 */     return totalNum;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\task\surprise\PCAccepteSurpriseItemReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */