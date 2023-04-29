/*     */ package mzm.gsp.item.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.award.main.AwardInterface;
/*     */ import mzm.gsp.award.main.AwardModel;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.common.TimeCommonUtil;
/*     */ import mzm.gsp.gang.main.GangInterface;
/*     */ import mzm.gsp.item.SUseGiftBagItemRes;
/*     */ import mzm.gsp.item.confbean.SChainedGiftBagCfg;
/*     */ import mzm.gsp.item.confbean.SChainedGiftBagChainCfg;
/*     */ import mzm.gsp.item.confbean.SGiftbagItem;
/*     */ import mzm.gsp.item.confbean.SUseAllItemCfg;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.qingfu.main.CostResult;
/*     */ import mzm.gsp.qingfu.main.CostType;
/*     */ import mzm.gsp.qingfu.main.QingfuInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.Item;
/*     */ import xdb.Lockeys;
/*     */ import xtable.User;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PUseGiftBagItem
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final long uuid;
/*     */   private final boolean isUseAll;
/*     */   
/*     */   public PUseGiftBagItem(long roleid, long uuid, boolean isUseAll)
/*     */   {
/*  45 */     this.roleid = roleid;
/*  46 */     this.uuid = uuid;
/*  47 */     this.isUseAll = isUseAll;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  53 */     if (!ItemModuleSwitchInterface.isUseGiftBagItemSwitchOpenForRole(this.roleid))
/*     */     {
/*  55 */       return false;
/*     */     }
/*  57 */     if (!ItemManager.isRoleStateCanOperateItem(this.roleid))
/*     */     {
/*  59 */       String logStr = String.format("[item]PUseGiftBagItem.processImp@role state can not operate item|roleid=%d", new Object[] { Long.valueOf(this.roleid) });
/*  60 */       ItemManager.logger.info(logStr);
/*  61 */       return false;
/*     */     }
/*     */     
/*  64 */     String userid = RoleInterface.getUserId(this.roleid);
/*  65 */     lock(Lockeys.get(User.getTable(), userid));
/*     */     
/*  67 */     BasicItem item = ItemInterface.getItemByUuid(this.roleid, this.uuid);
/*  68 */     if (item == null)
/*     */     {
/*  70 */       ItemManager.sendWrongInfo(this.roleid, 102, new String[0]);
/*  71 */       return false;
/*     */     }
/*  73 */     SGiftbagItem giftbagItem = SGiftbagItem.get(item.getCfgId());
/*  74 */     if (!checkGiftItemType(giftbagItem))
/*     */     {
/*  76 */       ItemManager.sendWrongInfo(this.roleid, 101, new String[0]);
/*  77 */       return false;
/*     */     }
/*  79 */     if (!checkSpecialGiftBagSwitch(giftbagItem))
/*  80 */       return false;
/*  81 */     int level = RoleInterface.getLevel(this.roleid);
/*  82 */     if ((giftbagItem.useLevel > level) || (level > giftbagItem.maxUseLevel))
/*     */     {
/*  84 */       ItemManager.sendWrongInfo(this.roleid, 770, new String[0]);
/*  85 */       return false;
/*     */     }
/*  87 */     if (this.isUseAll)
/*     */     {
/*  89 */       return useAllItem(userid, giftbagItem, item);
/*     */     }
/*     */     
/*     */ 
/*  93 */     return useSingleItem(userid, giftbagItem, item);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private boolean useAllItem(String userid, SGiftbagItem giftbagItem, BasicItem item)
/*     */   {
/* 100 */     if (SUseAllItemCfg.get(giftbagItem.id) == null)
/*     */     {
/* 102 */       String logStr = String.format("[item]PUseGiftBagItem.useAllItem@item can not use all,SUseAllItemCfg is null|roleid=%d|uuid=%d|itemid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.uuid), Integer.valueOf(giftbagItem.id) });
/*     */       
/*     */ 
/* 105 */       ItemManager.logger.error(logStr);
/* 106 */       return false;
/*     */     }
/* 108 */     if (giftbagItem.endDate != 0)
/*     */     {
/* 110 */       String logStr = String.format("[item]PUseGiftBagItem.useAllItem@item can not use all,has end date|roleid=%d|uuid=%d|itemid=%d|end_date=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.uuid), Integer.valueOf(giftbagItem.id), Integer.valueOf(giftbagItem.endDate) });
/*     */       
/*     */ 
/* 113 */       ItemManager.logger.error(logStr);
/* 114 */       return false;
/*     */     }
/* 116 */     if (giftbagItem.moneyNum > 0)
/*     */     {
/* 118 */       String logStr = String.format("[item]PUseGiftBagItem.useAllItem@item can not use all,need money not zero|roleid=%d|uuid=%d|itemid=%d|need_money=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.uuid), Integer.valueOf(giftbagItem.id), Integer.valueOf(giftbagItem.moneyNum) });
/*     */       
/*     */ 
/* 121 */       ItemManager.logger.error(logStr);
/* 122 */       return false;
/*     */     }
/* 124 */     TLogArg logArg = new TLogArg(LogReason.ITEM_USE_LIBAO, item.getCfgId());
/* 125 */     AwardReason awardReason = new AwardReason(logArg.getLogReason(), item.getCfgId());
/* 126 */     AwardModel awardModel = AwardInterface.getRoleFixAwardModel(giftbagItem.awardId, this.roleid, awardReason);
/* 127 */     if (awardModel == null)
/*     */     {
/* 129 */       String logStr = String.format("[item]PUseGiftBagItem.useAllItem@awardModel null|roleid=%d|uuid=%d|itemid=%d|awardid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.uuid), Integer.valueOf(giftbagItem.id), Integer.valueOf(giftbagItem.awardId) });
/*     */       
/*     */ 
/* 132 */       ItemManager.logger.error(logStr);
/* 133 */       return false;
/*     */     }
/* 135 */     int uuidHasNum = item.getNumber();
/* 136 */     int totalNum = ItemInterface.getItemNumberById(this.roleid, giftbagItem.id);
/* 137 */     if (totalNum < uuidHasNum)
/*     */     {
/* 139 */       String logStr = String.format("[item]PUseGiftBagItem.useAllItem@item num error|roleid=%d|uuid=%d|itemid=%d|awardid=%d|total_num=%d|grid_has_num=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.uuid), Integer.valueOf(giftbagItem.id), Integer.valueOf(giftbagItem.awardId), Integer.valueOf(totalNum), Integer.valueOf(uuidHasNum) });
/*     */       
/*     */ 
/* 142 */       ItemManager.logger.error(logStr);
/* 143 */       return false;
/*     */     }
/* 145 */     int realCanUseNum = 0;
/* 146 */     for (int i = 0; i < totalNum; i++)
/*     */     {
/* 148 */       int restgrid = ItemInterface.getAvailableGridNum(this.roleid, 340600000, true);
/* 149 */       if (ItemInterface.needGrid(awardModel.getItemMap()) > restgrid)
/*     */       {
/* 151 */         ItemInterface.sendSpecificBagGridNotEnough(this.roleid, 340600000);
/* 152 */         break;
/*     */       }
/* 154 */       boolean ret = AwardInterface.awardToRoleByAwardModel(userid, this.roleid, awardModel, true, false, awardReason);
/* 155 */       if (!ret)
/*     */       {
/* 157 */         ItemManager.sendWrongInfo(this.roleid, 1178, new String[0]);
/* 158 */         break;
/*     */       }
/* 160 */       realCanUseNum++;
/*     */     }
/* 162 */     if (realCanUseNum <= 0)
/*     */     {
/* 164 */       String logStr = String.format("[item]PUseGiftBagItem.useAllItem@item can use num error|roleid=%d|uuid=%d|itemid=%d|awardid=%d|total_num=%d|grid_has_num=%d|real_can_use_num=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.uuid), Integer.valueOf(giftbagItem.id), Integer.valueOf(giftbagItem.awardId), Integer.valueOf(totalNum), Integer.valueOf(uuidHasNum), Integer.valueOf(realCanUseNum) });
/*     */       
/*     */ 
/* 167 */       ItemManager.logger.error(logStr);
/* 168 */       return false;
/*     */     }
/* 170 */     boolean ret = false;
/* 171 */     if (realCanUseNum <= uuidHasNum)
/*     */     {
/* 173 */       ret = ItemInterface.removeItemByUuid(this.roleid, this.uuid, realCanUseNum, logArg);
/*     */     }
/*     */     else
/*     */     {
/* 177 */       ret = ItemInterface.removeItemByUuid(this.roleid, this.uuid, uuidHasNum, logArg);
/* 178 */       if (ret)
/*     */       {
/* 180 */         ret = ItemInterface.removeItemById(this.roleid, giftbagItem.id, realCanUseNum - uuidHasNum, logArg);
/*     */       }
/*     */     }
/* 183 */     if (!ret)
/*     */     {
/* 185 */       String logStr = String.format("[item]PUseGiftBagItem.useAllItem@cut item error|roleid=%d|uuid=%d|itemid=%d|awardid=%d|total_num=%d|grid_has_num=%d|real_can_use_num=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.uuid), Integer.valueOf(giftbagItem.id), Integer.valueOf(giftbagItem.awardId), Integer.valueOf(totalNum), Integer.valueOf(uuidHasNum), Integer.valueOf(realCanUseNum) });
/*     */       
/*     */ 
/* 188 */       ItemManager.logger.error(logStr);
/* 189 */       return false;
/*     */     }
/* 191 */     sendResult(item.getCfgId(), realCanUseNum, awardModel);
/* 192 */     return true;
/*     */   }
/*     */   
/*     */   private boolean useSingleItem(String userid, SGiftbagItem giftbagItem, BasicItem item)
/*     */   {
/* 197 */     if (!checkChainedGiftBagUseTime(giftbagItem, item))
/*     */     {
/* 199 */       ItemManager.sendWrongInfo(this.roleid, 1194, new String[0]);
/* 200 */       ItemManager.logger.error(String.format("[item]PUseGiftBagItem.useSingleItem()@chained gift bag still in counting down|roleid=%d|itemid=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(giftbagItem.id) }));
/*     */       
/* 202 */       return false;
/*     */     }
/*     */     
/* 205 */     TLogArg logArg = new TLogArg(LogReason.ITEM_USE_LIBAO, item.getCfgId());
/* 206 */     if (giftbagItem.endDate != 0)
/*     */     {
/* 208 */       long endtime = TimeCommonUtil.getLimitTimeEnd(giftbagItem.endDate);
/* 209 */       if (DateTimeUtils.getCurrTimeInMillis() > endtime)
/*     */       {
/* 211 */         ItemInterface.removeItemByUuid(this.roleid, this.uuid, 1, logArg);
/* 212 */         ItemManager.sendWrongInfo(this.roleid, 771, new String[0]);
/* 213 */         String logStr = String.format("[item]PUseGiftBagItem.useSingleItem@giftbag out of date|roleid=%d|itemid=%d|rewardid=%d|endtime=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(giftbagItem.id), Integer.valueOf(giftbagItem.awardId), Long.valueOf(endtime) });
/*     */         
/*     */ 
/* 216 */         ItemManager.logger.info(logStr);
/* 217 */         return true;
/*     */       }
/*     */     }
/*     */     
/* 221 */     if (giftbagItem.moneyType == 1)
/*     */     {
/* 223 */       if (giftbagItem.moneyNum > 0)
/*     */       {
/* 225 */         boolean r = QingfuInterface.costYuanbao(userid, this.roleid, giftbagItem.moneyNum, CostType.COST_BIND_FIRST_USE_GIFT_BAG_ITEM, logArg) == CostResult.Success;
/*     */         
/* 227 */         if (!r)
/*     */         {
/* 229 */           ItemManager.sendWrongInfo(this.roleid, 772, new String[0]);
/* 230 */           return false;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/* 235 */     else if (giftbagItem.moneyType == 2)
/*     */     {
/* 237 */       if (giftbagItem.moneyNum > 0)
/*     */       {
/* 239 */         boolean r = RoleInterface.cutGold(this.roleid, giftbagItem.moneyNum, logArg);
/* 240 */         if (!r)
/*     */         {
/* 242 */           ItemManager.sendWrongInfo(this.roleid, 772, new String[0]);
/* 243 */           return false;
/*     */         }
/*     */       }
/*     */     }
/* 247 */     else if (giftbagItem.moneyType == 3)
/*     */     {
/* 249 */       if (giftbagItem.moneyNum > 0)
/*     */       {
/* 251 */         boolean r = RoleInterface.cutSilver(this.roleid, giftbagItem.moneyNum, logArg);
/* 252 */         if (!r)
/*     */         {
/* 254 */           ItemManager.sendWrongInfo(this.roleid, 772, new String[0]);
/* 255 */           return false;
/*     */         }
/*     */       }
/*     */     }
/* 259 */     else if (giftbagItem.moneyType == 4)
/*     */     {
/* 261 */       if (giftbagItem.moneyNum > 0)
/*     */       {
/* 263 */         boolean r = GangInterface.cutBangGong(this.roleid, giftbagItem.moneyNum, logArg);
/*     */         
/* 265 */         if (!r)
/*     */         {
/* 267 */           ItemManager.sendWrongInfo(this.roleid, 772, new String[0]);
/* 268 */           return false;
/*     */         }
/*     */       }
/*     */     }
/* 272 */     boolean ret = ItemInterface.removeItemByUuid(this.roleid, this.uuid, 1, logArg);
/* 273 */     if (!ret)
/*     */     {
/* 275 */       ItemManager.sendWrongInfo(this.roleid, 102, new String[0]);
/* 276 */       return false;
/*     */     }
/*     */     
/* 279 */     if (!addNextChainedGiftBag(giftbagItem, logArg))
/*     */     {
/* 281 */       ItemManager.sendWrongInfo(this.roleid, 100, new String[0]);
/* 282 */       ItemManager.logger.error(String.format("PUseGiftBagItem.useSingleItem()@error when adding next chained gift bag|roleid=%d|itemid=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(giftbagItem.awardId) }));
/*     */       
/* 284 */       return false;
/*     */     }
/*     */     
/* 287 */     int restgrid = ItemInterface.getAvailableGridNum(this.roleid, 340600000, true);
/* 288 */     AwardReason awardReason = new AwardReason(logArg.getLogReason(), item.getCfgId());
/*     */     
/* 290 */     AwardModel awardModel = AwardInterface.getRoleFixAwardModel(giftbagItem.awardId, this.roleid, awardReason);
/* 291 */     if (awardModel == null)
/*     */     {
/* 293 */       String logStr = String.format("[item]PUseGiftBagItem.useSingleItem@awardModel null|roleid=%d|uuid=%d|itemid=%d|awardid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.uuid), Integer.valueOf(giftbagItem.id), Integer.valueOf(giftbagItem.awardId) });
/*     */       
/*     */ 
/* 296 */       ItemManager.logger.error(logStr);
/* 297 */       return false;
/*     */     }
/* 299 */     if (ItemInterface.needGrid(awardModel.getItemMap()) > restgrid)
/*     */     {
/* 301 */       ItemInterface.sendSpecificBagGridNotEnough(this.roleid, 340600000);
/* 302 */       return false;
/*     */     }
/* 304 */     ret = AwardInterface.awardToRoleByAwardModel(userid, this.roleid, awardModel, true, false, awardReason);
/* 305 */     if (!ret)
/*     */     {
/* 307 */       String logStr = String.format("[item]PUseGiftBagItem.useSingleItem@award to role error|roleid=%d|uuid=%d|itemid=%d|rewardid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.uuid), Integer.valueOf(giftbagItem.id), Integer.valueOf(giftbagItem.awardId) });
/*     */       
/*     */ 
/* 310 */       ItemManager.logger.error(logStr);
/*     */       
/* 312 */       return false;
/*     */     }
/*     */     
/* 315 */     sendResult(item.getCfgId(), 1, awardModel);
/* 316 */     return true;
/*     */   }
/*     */   
/*     */   private void sendResult(int usedItemid, int usedNum, AwardModel awardModel)
/*     */   {
/* 321 */     SUseGiftBagItemRes res = new SUseGiftBagItemRes();
/* 322 */     res.itemid = usedItemid;
/* 323 */     res.usednum = usedNum;
/* 324 */     AwardInterface.fillAwardBean(res.awardbean, awardModel);
/* 325 */     OnlineManager.getInstance().send(this.roleid, res);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean checkGiftItemType(SGiftbagItem item)
/*     */   {
/* 333 */     if (item == null)
/* 334 */       return false;
/* 335 */     if (item.type == 9)
/* 336 */       return true;
/* 337 */     if (item.type == 141)
/* 338 */       return true;
/* 339 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean checkSpecialGiftBagSwitch(SGiftbagItem item)
/*     */   {
/* 348 */     if (item.type == 141)
/* 349 */       return OpenInterface.getOpenStatus(455);
/* 350 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean checkChainedGiftBagUseTime(SGiftbagItem giftBagItem, BasicItem item)
/*     */   {
/* 358 */     if (giftBagItem.type == 141)
/*     */     {
/* 360 */       Integer useTime = item.getExtra(ItemStoreEnum.CHAINED_GIFT_BAG_USE_TIME);
/* 361 */       if ((useTime != null) && ((int)(DateTimeUtils.getCurrTimeInMillis() / 1000L) < useTime.intValue()))
/* 362 */         return false;
/*     */     }
/* 364 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean addNextChainedGiftBag(SGiftbagItem giftBagItem, TLogArg tLogArg)
/*     */   {
/* 372 */     if (giftBagItem.type == 141)
/*     */     {
/* 374 */       SChainedGiftBagCfg chainedGiftBagCfg = SChainedGiftBagCfg.get(giftBagItem.id);
/* 375 */       if (chainedGiftBagCfg == null)
/* 376 */         return false;
/* 377 */       SChainedGiftBagChainCfg chainCfg = SChainedGiftBagChainCfg.get(chainedGiftBagCfg.chain);
/* 378 */       if (chainCfg == null)
/* 379 */         return false;
/* 380 */       Integer nextChainedGiftBagId = (Integer)chainCfg.sn2id.get(Integer.valueOf(chainedGiftBagCfg.sn + 1));
/* 381 */       if (nextChainedGiftBagId == null)
/* 382 */         return true;
/* 383 */       SChainedGiftBagCfg nextChainedGiftBagCfg = SChainedGiftBagCfg.get(nextChainedGiftBagId.intValue());
/* 384 */       if (nextChainedGiftBagCfg == null) {
/* 385 */         return false;
/*     */       }
/*     */       List<Item> xItemList;
/*     */       List<Item> xItemList;
/* 389 */       if (nextChainedGiftBagCfg.countDown <= 0) {
/* 390 */         xItemList = ItemManager.createXItem(nextChainedGiftBagId.intValue(), 1, null, true);
/*     */       }
/*     */       else {
/* 393 */         int useTime = (int)(DateTimeUtils.getCurrTimeInMillis() / 1000L) + nextChainedGiftBagCfg.countDown * 60;
/* 394 */         Map<Integer, Integer> extraMap = new HashMap();
/* 395 */         extraMap.put(Integer.valueOf(261), Integer.valueOf(useTime));
/* 396 */         xItemList = ItemManager.createXItem(nextChainedGiftBagId.intValue(), 1, extraMap, true);
/*     */       }
/* 398 */       ItemOperateResult r = ItemInterface.addItem(this.roleid, xItemList, tLogArg);
/* 399 */       if (!r.success())
/* 400 */         return false;
/*     */     }
/* 402 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\main\PUseGiftBagItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */