/*     */ package mzm.gsp.market.main;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.item.main.ItemBanTrade;
/*     */ import mzm.gsp.item.main.ItemBanTrade.TradeTypeEnum;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.market.confbean.SMarketConsts;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.Item;
/*     */ import xbean.MarketIds;
/*     */ import xbean.MarketItem;
/*     */ import xbean.RoleMarketInfo;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Item2marketchannelids;
/*     */ import xtable.Marketitem2sessionid;
/*     */ import xtable.Role2marketinfo;
/*     */ 
/*     */ public class PReSellItemReq extends LogicProcedure
/*     */ {
/*     */   private long roleId;
/*     */   private long marketId;
/*     */   private int itemid;
/*     */   private int price;
/*     */   private int num;
/*     */   
/*     */   public PReSellItemReq(long roleId, long marketId, int itemid, int price, int num)
/*     */   {
/*  37 */     this.roleId = roleId;
/*  38 */     this.marketId = marketId;
/*  39 */     this.itemid = itemid;
/*  40 */     this.price = price;
/*  41 */     this.num = num;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  47 */     if (!MarketInterface.isRoleStateCanOperateMarket(this.roleId))
/*     */     {
/*  49 */       String logStr = String.format("[market]PReSellItemReq.processImp@role state can not operate market|roleid=%d", new Object[] { Long.valueOf(this.roleId) });
/*     */       
/*  51 */       MarketManager.logger.info(logStr);
/*  52 */       return false;
/*     */     }
/*  54 */     if (ItemBanTrade.getInstance().isBanTrade(ItemBanTrade.TradeTypeEnum.MARKET_ITEM.value, this.itemid))
/*     */     {
/*  56 */       ItemBanTrade.getInstance().sendTipToTole(this.roleId, ItemInterface.getItemName(this.itemid));
/*  57 */       return false;
/*     */     }
/*  59 */     String log = String.format("[market]PReSellItemReq.processImp@receive resell item req|roleid=%d|itemid=%d|marketId=%d|price=%d|num=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.itemid), Long.valueOf(this.marketId), Integer.valueOf(this.price), Integer.valueOf(this.num) });
/*     */     
/*     */ 
/*  62 */     MarketManager.logger.info(log);
/*     */     
/*  64 */     if ((this.price <= 0) || (this.num <= 0))
/*     */     {
/*  66 */       return false;
/*     */     }
/*  68 */     if (!MarketManager.isMarketSwitchOpenForRole(this.roleId))
/*     */     {
/*     */ 
/*  71 */       return false;
/*     */     }
/*  73 */     if (!MarketManager.isMarketOpen(this.roleId))
/*     */     {
/*  75 */       return false;
/*     */     }
/*     */     
/*  78 */     int subid = MarketManager.getSubidByItemId(this.itemid);
/*  79 */     if (subid == -1)
/*     */     {
/*  81 */       MarketManager.sendCommonError(this.roleId, 7);
/*  82 */       return false;
/*     */     }
/*     */     
/*  85 */     if (MarketManager.isMarketSellnumToMax(subid))
/*     */     {
/*  87 */       MarketManager.sendCommonError(this.roleId, 13);
/*  88 */       return false;
/*     */     }
/*  90 */     if (!MarketManager.canSellItem(this.itemid))
/*     */     {
/*     */ 
/*  93 */       String logStr = String.format("[market]PReSellItemReq.processImp@item can not sell|roleid=%d|itemId=%d|price=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.itemid), Integer.valueOf(this.price) });
/*     */       
/*  95 */       MarketManager.logger.error(logStr);
/*  96 */       return false;
/*     */     }
/*  98 */     RoleMarketInfo xRoleMarketInfo = Role2marketinfo.get(Long.valueOf(this.roleId));
/*  99 */     if (xRoleMarketInfo == null)
/*     */     {
/* 101 */       return false;
/*     */     }
/*     */     
/* 104 */     if (!xRoleMarketInfo.getOnshelf_item_ids().contains(Long.valueOf(this.marketId)))
/*     */     {
/* 106 */       return false;
/*     */     }
/* 108 */     long key = GameServerInfoManager.toGlobalId(this.itemid);
/* 109 */     Lockeys.lock(Item2marketchannelids.getTable(), Arrays.asList(new Long[] { Long.valueOf(key) }));
/*     */     
/* 111 */     MarketItem xMarketItem = (MarketItem)xRoleMarketInfo.getMarketid2timeoutorselleditem().get(Long.valueOf(this.marketId));
/* 112 */     if (xMarketItem == null)
/*     */     {
/* 114 */       return false;
/*     */     }
/*     */     
/* 117 */     if ((xMarketItem.getRest_num() <= 0) || (xMarketItem.getRest_num() != this.num) || (xMarketItem.getRoleid() != this.roleId) || (this.itemid != xMarketItem.getItem().getCfgid()))
/*     */     {
/*     */ 
/* 120 */       return false;
/*     */     }
/* 122 */     int oldPrice = xMarketItem.getPrice();
/* 123 */     if (MarketManager.hasState(xMarketItem.getState(), 4))
/*     */     {
/* 125 */       String logStr = String.format("[market]PReSellItemReq.processImp@market item should get money first|roleid=%d|marketId=%d|itemid=%d|price=%d|state=%d|sellnum=%d|reSellPrice=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.marketId), Integer.valueOf(this.itemid), Integer.valueOf(oldPrice), Integer.valueOf(xMarketItem.getState()), Integer.valueOf(xMarketItem.getItem().getNumber() - xMarketItem.getRest_num()), Integer.valueOf(this.price) });
/*     */       
/*     */ 
/*     */ 
/* 129 */       MarketManager.logger.error(logStr);
/*     */       
/* 131 */       return false;
/*     */     }
/* 133 */     if (!MarketManager.hasState(xMarketItem.getState(), 8))
/*     */     {
/* 135 */       String logStr = String.format("[market]PReSellItemReq.processImp@market item has no expire|roleid=%d|marketId=%d|itemid=%d|price=%d|state=%d|sellnum=%d|reSellPrice=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.marketId), Integer.valueOf(this.itemid), Integer.valueOf(oldPrice), Integer.valueOf(xMarketItem.getState()), Integer.valueOf(xMarketItem.getItem().getNumber() - xMarketItem.getRest_num()), Integer.valueOf(this.price) });
/*     */       
/*     */ 
/*     */ 
/* 139 */       MarketManager.logger.error(logStr);
/*     */       
/* 141 */       return false;
/*     */     }
/*     */     
/* 144 */     TLogArg logArg = new TLogArg(LogReason.MARKET_RE_SHANGJIA, this.itemid);
/* 145 */     boolean isWithSkill = MarketManager.isItemWithSkill(xMarketItem.getItem());
/* 146 */     if (!MarketManager.isItemPriceRight(this.itemid, this.price, isWithSkill))
/*     */     {
/* 148 */       String logStr = String.format("[market]PReSellItemReq.processImp@market sell item price error|roleid=%d|marketId=%d|itemid=%d|price=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.marketId), Integer.valueOf(this.itemid), Integer.valueOf(this.price) });
/*     */       
/*     */ 
/* 151 */       MarketManager.logger.error(logStr);
/* 152 */       return false;
/*     */     }
/*     */     
/* 155 */     long tax = MarketManager.computeSellNeedTaxGold(this.price, this.num);
/* 156 */     if (tax <= 0L)
/*     */     {
/* 158 */       String logStr = String.format("[market]PReSellItemReq.processImp@market sell item tax error|roleid=%d|marketId=%d|itemid=%d|tax=%d|num=%d|price=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.marketId), Integer.valueOf(this.itemid), Long.valueOf(tax), Integer.valueOf(this.num), Integer.valueOf(this.price) });
/*     */       
/*     */ 
/* 161 */       MarketManager.logger.error(logStr);
/* 162 */       return false;
/*     */     }
/* 164 */     if (!RoleInterface.cutGold(this.roleId, tax, logArg))
/*     */     {
/* 166 */       MarketManager.sendCommonError(this.roleId, 6);
/* 167 */       return false;
/*     */     }
/*     */     
/* 170 */     int channelSize = MarketManager.getChannelSizeByItemId(this.itemid);
/* 171 */     if (channelSize == -1)
/*     */     {
/*     */ 
/* 174 */       String logStr = String.format("[market]PReSellItemReq.processImp@market sell item channelSize error|roleid=%d|itemid=%d|channelSize=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.itemid), Integer.valueOf(channelSize) });
/*     */       
/*     */ 
/* 177 */       MarketManager.logger.error(logStr);
/* 178 */       return false;
/*     */     }
/*     */     
/* 181 */     xbean.MarketChannelIds xMarketChannelIds = MarketManager.getMarketItemChannelIdsOnAdd(this.itemid);
/*     */     
/* 183 */     ChannelIdXMarketIdsBean channelIdXMarketIdsBean = MarketManager.findChannelIdXMarketIdsBean(xMarketChannelIds, channelSize);
/*     */     
/* 185 */     if (channelIdXMarketIdsBean == null)
/*     */     {
/* 187 */       String logStr = String.format("[market]PReSellItemReq.processImp@market resell item error,not get an available channle|roleid=%d|itemid=%d|channelSize=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.itemid), Integer.valueOf(channelSize) });
/*     */       
/*     */ 
/* 190 */       MarketManager.logger.error(logStr);
/* 191 */       return false;
/*     */     }
/* 193 */     long channelid = channelIdXMarketIdsBean.channelid;
/* 194 */     MarketIds xMarketIds = channelIdXMarketIdsBean.xMarketIds;
/*     */     
/* 196 */     long now = DateTimeUtils.getCurrTimeInMillis();
/* 197 */     long endtime = 0L;
/* 198 */     long lengthTime = 0L;
/* 199 */     boolean isPub = false;
/* 200 */     long newMarketId = 0L;
/* 201 */     if (oldPrice != this.price)
/*     */     {
/*     */ 
/* 204 */       newMarketId = MarketManager.createMarketItemInfo(this.roleId, xMarketItem.getItem(), this.price, now, channelid, 1);
/*     */       
/*     */ 
/* 207 */       endtime = MarketManager.computePublicEndtime(now);
/*     */       
/* 209 */       if (MarketManager.isLevelSift(subid))
/*     */       {
/* 211 */         int level = ItemInterface.getUseLevel(xMarketItem.getItem().getCfgid());
/* 212 */         LevelSiftRankManager.rankPub(subid, newMarketId, level, this.price);
/*     */       }
/*     */       else
/*     */       {
/* 216 */         PriceRankManager.rankPub(subid, newMarketId, this.price);
/*     */       }
/*     */       
/* 219 */       long publicTipEndtime = MarketManager.computePublicTipEndTime(now);
/* 220 */       long length = publicTipEndtime - TimeUnit.MILLISECONDS.toSeconds(now);
/* 221 */       if (length <= 0L)
/*     */       {
/* 223 */         length = 1L;
/*     */       }
/* 225 */       PrePubItemSession prePubItemSession = new PrePubItemSession(length, newMarketId);
/* 226 */       Marketitem2sessionid.remove(Long.valueOf(newMarketId));
/* 227 */       Marketitem2sessionid.insert(Long.valueOf(newMarketId), Long.valueOf(prePubItemSession.getSessionId()));
/*     */       
/* 229 */       lengthTime = MarketManager.computePublicEndtime(now) - TimeUnit.MILLISECONDS.toSeconds(now) + TimeUnit.MINUTES.toSeconds(SMarketConsts.getInstance().AUCTION_TIME);
/*     */       
/* 231 */       isPub = true;
/* 232 */       MarketManager.sendSSellItemRes(this.roleId, newMarketId, this.itemid, this.price, endtime, xMarketItem.getRest_num(), 0, 1, this.marketId);
/*     */ 
/*     */     }
/*     */     else
/*     */     {
/* 237 */       newMarketId = MarketManager.createMarketItemInfo(this.roleId, xMarketItem.getItem(), this.price, now, channelid, 2);
/*     */       
/*     */ 
/* 240 */       endtime = MarketManager.computeShangjiaExpireTime(now);
/*     */       
/* 242 */       if (MarketManager.isLevelSift(subid))
/*     */       {
/* 244 */         int level = ItemInterface.getUseLevel(xMarketItem.getItem().getCfgid());
/* 245 */         LevelSiftRankManager.rankSell(subid, newMarketId, level, this.price);
/*     */       }
/*     */       else
/*     */       {
/* 249 */         PriceRankManager.rankSell(subid, newMarketId, this.price);
/*     */       }
/* 251 */       MarketItemPetPriceManager.addPrice(this.itemid, this.price);
/*     */       
/* 253 */       long interval = endtime - TimeUnit.MILLISECONDS.toSeconds(now);
/*     */       
/* 255 */       MarketManager.startOnSellItemPhaseSession(newMarketId, xMarketItem, MarketManager.getRecycleSeconds(this.itemid), interval);
/*     */       
/*     */ 
/* 258 */       lengthTime = interval;
/* 259 */       isPub = false;
/* 260 */       MarketManager.sendSSellItemRes(this.roleId, newMarketId, this.itemid, this.price, endtime, xMarketItem.getRest_num(), 0, 2, this.marketId);
/*     */     }
/*     */     
/* 263 */     boolean ret = xMarketIds.getMarket_ids().add(Long.valueOf(newMarketId));
/* 264 */     if (!ret)
/*     */     {
/* 266 */       String logStr = String.format("[market]PReSellItemReq.processImp@add new marketid error|roleid=%d|itemid=%d|num=%d|price=%d|oldprice=%d|marketId=%d|channel_id=%d|new_market_id=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.itemid), Integer.valueOf(this.num), Integer.valueOf(this.price), Integer.valueOf(oldPrice), Long.valueOf(this.marketId), Long.valueOf(xMarketItem.getChannel_id()), Long.valueOf(newMarketId) });
/*     */       
/*     */ 
/* 269 */       MarketManager.logger.error(logStr);
/* 270 */       return false;
/*     */     }
/* 272 */     xRoleMarketInfo.getMarketid2timeoutorselleditem().remove(Long.valueOf(this.marketId));
/* 273 */     xRoleMarketInfo.getOnshelf_item_ids().remove(Long.valueOf(this.marketId));
/* 274 */     xRoleMarketInfo.getOnshelf_item_ids().add(Long.valueOf(newMarketId));
/*     */     
/* 276 */     MarketManager.tlogMarket(this.roleId, this.itemid, this.num, this.price, tax, MarketOperateEnum.RESELL_ITEM);
/*     */     
/* 278 */     MarketManager.tlogMarketSellItemForIdip(this.roleId, this.itemid, this.num, this.price, xMarketItem.getItem().getUuidAsData(), newMarketId, lengthTime, MarketOperateEnum.RESELL_ITEM.value);
/*     */     
/*     */ 
/* 281 */     String logStr = String.format("[market]PReSellItemReq.processImp@market sell item success|roleid=%d|itemid=%d|num=%d|price=%d|oldprice=%d|marketId=%d|channel_id=%d|new_market_id=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.itemid), Integer.valueOf(this.num), Integer.valueOf(this.price), Integer.valueOf(oldPrice), Long.valueOf(this.marketId), Long.valueOf(xMarketItem.getChannel_id()), Long.valueOf(newMarketId) });
/*     */     
/*     */ 
/* 284 */     MarketManager.logger.info(logStr);
/*     */     
/* 286 */     MarketInterface.triggerMarketItemOnShelfEvent(newMarketId, this.itemid, isPub);
/* 287 */     MarketManager.sendBulletinForItem(RoleInterface.getName(this.roleId), newMarketId, this.itemid, this.price, isPub);
/* 288 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\market\main\PReSellItemReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */