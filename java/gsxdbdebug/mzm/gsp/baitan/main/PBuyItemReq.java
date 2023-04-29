/*     */ package mzm.gsp.baitan.main;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.baitan.SBuyItemRes;
/*     */ import mzm.gsp.item.main.EquipmentItem;
/*     */ import mzm.gsp.item.main.ItemBanTrade;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.item.main.ItemOperateResult;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.yuanbao.main.CurrencyType;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.Channels;
/*     */ import xbean.DisplayItem;
/*     */ import xbean.DisplayItemList;
/*     */ import xbean.Item;
/*     */ import xbean.ShoppingIds;
/*     */ import xbean.ShoppingInfo;
/*     */ import xbean.Subtype2ItemList;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Channel2shoppingid;
/*     */ import xtable.Roleshoppinginfo;
/*     */ 
/*     */ public class PBuyItemReq extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private int itemid;
/*     */   private int price;
/*     */   private int index;
/*     */   
/*     */   public PBuyItemReq(long roleId, int itemid, int price, int index)
/*     */   {
/*  39 */     this.roleId = roleId;
/*  40 */     this.itemid = itemid;
/*  41 */     this.price = price;
/*  42 */     this.index = index;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  48 */     if (ItemBanTrade.getInstance().isBanTrade(mzm.gsp.item.main.ItemBanTrade.TradeTypeEnum.BAITAN.value, this.itemid))
/*     */     {
/*  50 */       ItemBanTrade.getInstance().sendTipToTole(this.roleId, ItemInterface.getItemName(this.itemid));
/*  51 */       return false;
/*     */     }
/*  53 */     String log = String.format("[baitan]PBuyItemReq.processImp@ receive buy item req|roleid=%d|itemid=%d|price=%d|index=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.itemid), Integer.valueOf(this.price), Integer.valueOf(this.index) });
/*     */     
/*     */ 
/*  56 */     BaiTanManager.logger.info(log);
/*     */     
/*  58 */     if ((this.index < 0) || (this.price <= 0) || (this.itemid <= 0))
/*     */     {
/*  60 */       return false;
/*     */     }
/*     */     
/*  63 */     if (!BaiTanManager.isBaiTanSwitchOpenForRole(this.roleId))
/*     */     {
/*  65 */       return false;
/*     */     }
/*  67 */     int level = RoleInterface.getLevel(this.roleId);
/*  68 */     if (!BaiTanManager.isOpenForLevel(level))
/*     */     {
/*  70 */       String logStr = String.format("[baitan]PBuyItemReq.processImp@ role level not open for baitan|roleid=%d|level=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(level) });
/*     */       
/*  72 */       BaiTanManager.logger.warn(logStr);
/*  73 */       return false;
/*     */     }
/*     */     
/*  76 */     if (!BaiTanManager.isRoleStateCanBaiTanBuyOrSell(this.roleId))
/*     */     {
/*  78 */       String logStr = String.format("[baitan]PBuyItemReq.processImp@role state can not baitan sell or buy|roleid=%d", new Object[] { Long.valueOf(this.roleId) });
/*     */       
/*  80 */       BaiTanManager.logger.info(logStr);
/*  81 */       return false;
/*     */     }
/*  83 */     int subtype = BaiTanManager.getSubtypeidByItemid(this.itemid);
/*  84 */     if (subtype == -1)
/*     */     {
/*  86 */       String logStr = String.format("[baitan]PBuyItemReq.processImp@subtype error|roleid=%d|itemid=%d|price=%d|index=%d|subtype=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.itemid), Integer.valueOf(this.price), Integer.valueOf(this.index), Integer.valueOf(subtype) });
/*     */       
/*     */ 
/*  89 */       BaiTanManager.logger.error(logStr);
/*     */       
/*  91 */       return false;
/*     */     }
/*  93 */     Subtype2ItemList id2Price = xtable.Role2baitanshoppinglist.get(Long.valueOf(this.roleId));
/*  94 */     if ((id2Price == null) || (id2Price.getSub2itemlist().isEmpty()))
/*     */     {
/*  96 */       String logStr = String.format("[baitan]PBuyItemReq.processImp@Subtype2ItemList null|roleid=%d|itemid=%d|price=%d|index=%d|rolelevel=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.itemid), Integer.valueOf(this.price), Integer.valueOf(this.index), Integer.valueOf(level) });
/*     */       
/*     */ 
/*  99 */       BaiTanManager.logger.error(logStr);
/* 100 */       return false;
/*     */     }
/* 102 */     long key = mzm.gsp.GameServerInfoManager.toGlobalId(this.itemid);
/* 103 */     Lockeys.lock(xtable.Item2prices.getTable(), Arrays.asList(new Long[] { Long.valueOf(key) }));
/*     */     
/* 105 */     DisplayItemList displayItemList = (DisplayItemList)id2Price.getSub2itemlist().get(Integer.valueOf(subtype));
/* 106 */     if ((displayItemList == null) || (displayItemList.getDisplayitemlist().isEmpty()) || (this.index >= displayItemList.getDisplayitemlist().size()))
/*     */     {
/*     */ 
/*     */ 
/* 110 */       String logStr = String.format("[baitan]PBuyItemReq.processImp@item not exist|roleid=%d|itemid=%d|index=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.itemid), Integer.valueOf(this.index) });
/*     */       
/* 112 */       BaiTanManager.logger.error(logStr);
/* 113 */       return false;
/*     */     }
/* 115 */     DisplayItem displayItem = (DisplayItem)displayItemList.getDisplayitemlist().get(this.index);
/*     */     
/* 117 */     if ((displayItem.getItemid() != this.itemid) || (displayItem.getPrice() != this.price))
/*     */     {
/* 119 */       String logStr = String.format("[baitan]PBuyItemReq.processImp@itemid or price error|roleid=%d|itemid=%d|price=%d|sitemid=%d|sprice=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.itemid), Integer.valueOf(this.price), Integer.valueOf(displayItem.getItemid()), Integer.valueOf(displayItem.getPrice()) });
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 124 */       BaiTanManager.logger.error(logStr);
/* 125 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 129 */     TLogArg arg = new TLogArg(LogReason.BAITAN_BUY_ADD, this.itemid);
/* 130 */     if (!RoleInterface.cutSilver(this.roleId, this.price, arg))
/*     */     {
/* 132 */       String logStr = String.format("[baitan]PBuyItemReq.processImp@cut silver error|roleid=%d|cutnum=%d|hassivler=%d|itemid=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.price), Long.valueOf(RoleInterface.getSilver(this.roleId)), Integer.valueOf(this.itemid) });
/*     */       
/*     */ 
/* 135 */       BaiTanManager.logger.error(logStr);
/* 136 */       BaiTanManager.sendCommonError(this.roleId, 7);
/* 137 */       return false;
/*     */     }
/*     */     
/* 140 */     long now = mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis();
/* 141 */     if (displayItem.getShoppingid() == 0L)
/*     */     {
/* 143 */       int num = (int)displayItem.getChannelidornum();
/*     */       
/* 145 */       if (num <= 0)
/*     */       {
/* 147 */         String logStr = String.format("[baitan]PBuyItemReq.processImp@can not buy item,num error|roleid=%d|num=%d|itemid=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(num), Integer.valueOf(this.itemid) });
/*     */         
/*     */ 
/* 150 */         BaiTanManager.logger.error(logStr);
/*     */         
/* 152 */         sendBuyRes(1, 0, 0);
/* 153 */         return false;
/*     */       }
/*     */       
/* 156 */       displayItem.setChannelidornum(num - 1);
/* 157 */       Channelshopping cs = findOneShoppingid(now);
/* 158 */       if ((cs.getChannelid() == -1L) || (cs.getShoppingid() == -1L))
/*     */       {
/* 160 */         boolean ret = buyItemFromSys(this.itemid, subtype);
/* 161 */         if (ret)
/*     */         {
/* 163 */           sendBuyRes(0, num - 1, this.price);
/*     */           
/* 165 */           BaiTanManager.addItemSellMoney(this.itemid, this.price, 1);
/*     */         }
/*     */         
/* 168 */         return ret;
/*     */       }
/*     */       
/*     */ 
/* 172 */       Lockeys.lock(Channel2shoppingid.getTable(), Arrays.asList(new Long[] { Long.valueOf(cs.getChannelid()) }));
/* 173 */       ShoppingInfo shoppingInfo = Roleshoppinginfo.get(Long.valueOf(cs.getShoppingid()));
/* 174 */       if ((shoppingInfo == null) || (shoppingInfo.getRoleid() == this.roleId) || (shoppingInfo.getExpire() < now) || (shoppingInfo.getItem().getNumber() <= 0))
/*     */       {
/*     */ 
/* 177 */         boolean ret = buyItemFromSys(this.itemid, subtype);
/* 178 */         if (ret)
/*     */         {
/* 180 */           sendBuyRes(0, num - 1, this.price);
/*     */           
/* 182 */           BaiTanManager.addItemSellMoney(this.itemid, this.price, 1);
/*     */         }
/*     */         
/* 185 */         return ret;
/*     */       }
/*     */       
/*     */ 
/*     */ 
/* 190 */       boolean ret = buyItemFromRole(shoppingInfo, cs.getChannelid(), cs.getShoppingid());
/*     */       
/* 192 */       if (ret)
/*     */       {
/* 194 */         sendBuyRes(0, num - 1, this.price);
/*     */         
/* 196 */         BaiTanManager.addItemSellMoney(this.itemid, this.price, 1);
/*     */       }
/*     */       
/*     */ 
/* 200 */       return ret;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 209 */     Lockeys.lock(Channel2shoppingid.getTable(), Arrays.asList(new Long[] { Long.valueOf(displayItem.getChannelidornum()) }));
/* 210 */     ShoppingInfo shoppingInfo = Roleshoppinginfo.get(Long.valueOf(displayItem.getShoppingid()));
/*     */     
/* 212 */     if (shoppingInfo == null)
/*     */     {
/* 214 */       String logStr = String.format("[baitan]PBuyItemReq.processImp@buy item from shoppingid error,ShoppingInfo null|roleid=%d|itemid=%d|shoppingid=%d|channelid=%d|price=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.itemid), Long.valueOf(displayItem.getShoppingid()), Long.valueOf(displayItem.getChannelidornum()), Integer.valueOf(this.price) });
/*     */       
/*     */ 
/* 217 */       BaiTanManager.logger.info(logStr);
/*     */       
/* 219 */       sendBuyRes(3, 0, 0);
/* 220 */       return false;
/*     */     }
/* 222 */     if ((this.roleId == shoppingInfo.getRoleid()) || (shoppingInfo.getExpire() < now) || (shoppingInfo.getItem().getNumber() <= 0) || (shoppingInfo.getPrice() != this.price))
/*     */     {
/*     */ 
/* 225 */       String logStr = String.format("[baitan]PBuyItemReq.processImp@buy item from shoppingid error|roleid=%d|itemid=%d|shoppingid=%d|channelid=%d|price=%d|newprice=%d|now=%d|expiretime=%d|restnum=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.itemid), Long.valueOf(displayItem.getShoppingid()), Long.valueOf(displayItem.getChannelidornum()), Integer.valueOf(this.price), Integer.valueOf(shoppingInfo.getPrice()), Long.valueOf(now), Long.valueOf(shoppingInfo.getExpire()), Integer.valueOf(shoppingInfo.getItem().getNumber()) });
/*     */       
/*     */ 
/*     */ 
/* 229 */       BaiTanManager.logger.info(logStr);
/*     */       
/* 231 */       sendBuyRes(3, 0, 0);
/* 232 */       return false;
/*     */     }
/*     */     
/* 235 */     int num = shoppingInfo.getItem().getNumber();
/* 236 */     boolean ret = buyItemFromRole(shoppingInfo, displayItem.getChannelidornum(), displayItem.getShoppingid());
/* 237 */     if (ret)
/*     */     {
/* 239 */       sendBuyRes(0, num - 1, this.price);
/*     */       
/* 241 */       BaiTanManager.addItemSellMoney(this.itemid, this.price, 1);
/*     */     }
/* 243 */     return ret;
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
/*     */   private Channelshopping findOneShoppingid(long now)
/*     */   {
/* 258 */     Channelshopping cs = new Channelshopping(-1L, -1L);
/*     */     
/* 260 */     Channels channels = BaiTanManager.getChannels(this.itemid, this.price, false);
/* 261 */     if ((channels == null) || (channels.getChannels().isEmpty()))
/*     */     {
/*     */ 
/* 264 */       return cs;
/*     */     }
/*     */     
/* 267 */     for (Iterator i$ = channels.getChannels().iterator(); i$.hasNext();) { channelid = ((Long)i$.next()).longValue();
/*     */       
/* 269 */       ShoppingIds xShoppingIds = Channel2shoppingid.select(Long.valueOf(channelid));
/* 270 */       if ((xShoppingIds != null) && (!xShoppingIds.getShoppingids().isEmpty()))
/*     */       {
/*     */ 
/*     */ 
/* 274 */         for (i$ = xShoppingIds.getShoppingids().iterator(); i$.hasNext();) { long shoppingid = ((Long)i$.next()).longValue();
/*     */           
/* 276 */           ShoppingInfo shoppingInfo = Roleshoppinginfo.select(Long.valueOf(shoppingid));
/* 277 */           if ((shoppingInfo != null) && (shoppingInfo.getRoleid() != this.roleId) && (shoppingInfo.getExpire() >= now) && (shoppingInfo.getItem().getNumber() > 0))
/*     */           {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 285 */             cs.setChannelid(channelid);
/* 286 */             cs.setShoppingid(shoppingid);
/* 287 */             return cs;
/*     */           }
/*     */         } }
/*     */     }
/*     */     long channelid;
/*     */     Iterator i$;
/* 293 */     return cs;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean buyItemFromRole(ShoppingInfo gridInfo, long channelid, long shoppingid)
/*     */   {
/* 304 */     Item xItem = gridInfo.getItem();
/* 305 */     ItemOperateResult ret = addItemAndCutItem(xItem);
/* 306 */     if (!ret.success())
/*     */     {
/* 308 */       String logStr = String.format("[baitan]PBuyItemReq.buyItemFromRole@addItemAndCutItem error|roleid=%d|itemid=%d|channelid=%d|shoppingid=%d|price=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.itemid), Long.valueOf(channelid), Long.valueOf(shoppingid), Integer.valueOf(this.price) });
/*     */       
/*     */ 
/* 311 */       BaiTanManager.logger.error(logStr);
/*     */       
/* 313 */       return false;
/*     */     }
/*     */     
/* 316 */     if (xItem.getNumber() <= 0)
/*     */     {
/* 318 */       BaiTanManager.removeSCPI(xItem.getCfgid(), this.price, channelid, shoppingid);
/*     */       
/* 320 */       BaiTanManager.decItemGridnum(xItem.getCfgid());
/*     */       
/* 322 */       BaiTanManager.stopObserver(gridInfo.getRoleid(), shoppingid);
/*     */     }
/* 324 */     sendSellItemSuccessRes(gridInfo.getRoleid(), xItem.getNumber(), gridInfo.getTotalnum() - xItem.getNumber(), shoppingid);
/*     */     
/*     */ 
/* 327 */     String logStr = String.format("[baitan]PBuyItemReq.buyItemFromRole@buy item from role success|roleid=%d|sellerroleid=%d|itemid=%d|channelid=%d|shoppingid=%d|price=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(gridInfo.getRoleid()), Integer.valueOf(this.itemid), Long.valueOf(channelid), Long.valueOf(shoppingid), Integer.valueOf(this.price) });
/*     */     
/*     */ 
/* 330 */     BaiTanManager.logger.info(logStr);
/* 331 */     BaiTanManager.tlogBaitanBuy(this.roleId, this.itemid, 1, this.price, gridInfo.getRoleid());
/* 332 */     BaiTanManager.tlogBaitanBuyForIdip(this.roleId, gridInfo.getRoleid(), this.itemid, 1, this.price, (Set)ret.getChangedItemId2Uuids().get(Integer.valueOf(this.itemid)), shoppingid);
/*     */     
/* 334 */     return true;
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
/*     */   private boolean buyItemFromSys(int itemid, int subtype)
/*     */   {
/* 347 */     int syssellnum = BaiTanManager.getSysSellItemNum(itemid, false);
/* 348 */     int maxsellnum = BaiTanManager.getMaxSysSellNum(itemid);
/* 349 */     if (syssellnum >= maxsellnum)
/*     */     {
/* 351 */       String logStr = String.format("[baitan]PBuyItemReq.buyItemFromSys@buy item faild from sys|roleid=%d|itemid=%d|syssellnum=%d|sysmaxsellnum=%d|price=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(itemid), Integer.valueOf(syssellnum), Integer.valueOf(maxsellnum), Integer.valueOf(this.price) });
/*     */       
/*     */ 
/* 354 */       BaiTanManager.logger.info(logStr);
/*     */       
/* 356 */       sendBuyRes(1, 0, 0);
/* 357 */       return false;
/*     */     }
/* 359 */     BaiTanManager.addSysSellItemNum(itemid, this.price, 1);
/*     */     
/* 361 */     TLogArg arg = new TLogArg(LogReason.BAITAN_BUY_ADD, itemid);
/* 362 */     arg.addCurrencytype2num(CurrencyType.CURRENCY_SILVE, Integer.valueOf(-this.price));
/*     */     
/* 364 */     List<Item> newItems = new java.util.ArrayList();
/* 365 */     if (BaiTanManager.isEquipSubtype(subtype))
/*     */     {
/* 367 */       EquipmentItem equipmentItem = BaiTanManager.createFixEquipItem(itemid, true, true);
/* 368 */       if (equipmentItem == null)
/*     */       {
/* 370 */         return false;
/*     */       }
/* 372 */       newItems.add(equipmentItem.getItem());
/*     */     }
/*     */     else
/*     */     {
/* 376 */       newItems = ItemInterface.createXItem(itemid, 1, null, true);
/*     */     }
/*     */     
/* 379 */     ItemOperateResult result = ItemInterface.addItem(this.roleId, newItems, true, arg);
/* 380 */     if (!result.success())
/*     */     {
/* 382 */       BaiTanManager.sendCommonError(this.roleId, 2);
/*     */       
/* 384 */       String logStr = String.format("[baitan]PBuyItemReq.buyItemFromSys@buy item faild from sys bag full|roleid=%d|itemid=%d|syssellnum=%d|sysmaxsellnum=%d|price=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(itemid), Integer.valueOf(syssellnum), Integer.valueOf(maxsellnum), Integer.valueOf(this.price) });
/*     */       
/*     */ 
/* 387 */       BaiTanManager.logger.info(logStr);
/*     */       
/* 389 */       return false;
/*     */     }
/*     */     
/* 392 */     String logStr = String.format("[baitan]PBuyItemReq.buyItemFromSys@buy item success from sys|roleid=%d|itemid=%d|syssellnum=%d|sysmaxsellnum=%d|price=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(itemid), Integer.valueOf(syssellnum), Integer.valueOf(maxsellnum), Integer.valueOf(this.price) });
/*     */     
/*     */ 
/* 395 */     BaiTanManager.logger.info(logStr);
/*     */     
/* 397 */     BaiTanManager.tlogBaitanBuy(this.roleId, itemid, 1, this.price, 0L);
/* 398 */     BaiTanManager.tlogBaitanBuyForIdip(this.roleId, 0L, itemid, 1, this.price, (Set)result.getChangedItemId2Uuids().get(Integer.valueOf(itemid)), 0L);
/* 399 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private ItemOperateResult addItemAndCutItem(Item item)
/*     */   {
/* 406 */     Item newItem = BaiTanManager.separateItem(item, 1);
/*     */     
/* 408 */     newItem.setFlags(1);
/* 409 */     TLogArg addItemArg = new TLogArg(LogReason.BAITAN_BUY_ADD, newItem.getCfgid());
/* 410 */     addItemArg.addCurrencytype2num(CurrencyType.CURRENCY_SILVE, Integer.valueOf(-this.price));
/* 411 */     ItemOperateResult result = ItemInterface.addItem(this.roleId, Arrays.asList(new Item[] { newItem }), true, addItemArg);
/* 412 */     if (!result.success())
/*     */     {
/* 414 */       BaiTanManager.sendCommonError(this.roleId, 2);
/*     */     }
/*     */     
/* 417 */     return result;
/*     */   }
/*     */   
/*     */   private void sendBuyRes(int resCode, int restnum, int usemoney)
/*     */   {
/* 422 */     SBuyItemRes res = new SBuyItemRes();
/* 423 */     res.buy_res = resCode;
/* 424 */     res.index = this.index;
/* 425 */     res.num = restnum;
/* 426 */     res.itemid = this.itemid;
/* 427 */     res.price = this.price;
/* 428 */     res.usemoney = usemoney;
/* 429 */     OnlineManager.getInstance().sendAtOnce(this.roleId, res);
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
/*     */   private void sendSellItemSuccessRes(long sellerroleid, int restnum, int sellnum, long shoppingid)
/*     */   {
/* 443 */     mzm.gsp.baitan.SSyncSellItemNotify sSyncSellItemNotify = new mzm.gsp.baitan.SSyncSellItemNotify();
/* 444 */     sSyncSellItemNotify.shoppingid = shoppingid;
/* 445 */     sSyncSellItemNotify.num = restnum;
/* 446 */     sSyncSellItemNotify.sellnum = sellnum;
/* 447 */     OnlineManager.getInstance().send(sellerroleid, sSyncSellItemNotify);
/*     */   }
/*     */   
/*     */   private static class Channelshopping
/*     */   {
/*     */     private long channelid;
/*     */     private long shoppingid;
/*     */     
/*     */     public Channelshopping(long channelid, long shoppingid)
/*     */     {
/* 457 */       this.channelid = shoppingid;
/* 458 */       this.shoppingid = shoppingid;
/*     */     }
/*     */     
/*     */     public long getChannelid()
/*     */     {
/* 463 */       return this.channelid;
/*     */     }
/*     */     
/*     */     public void setChannelid(long channelid)
/*     */     {
/* 468 */       this.channelid = channelid;
/*     */     }
/*     */     
/*     */     public long getShoppingid()
/*     */     {
/* 473 */       return this.shoppingid;
/*     */     }
/*     */     
/*     */     public void setShoppingid(long shoppingid)
/*     */     {
/* 478 */       this.shoppingid = shoppingid;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\baitan\main\PBuyItemReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */