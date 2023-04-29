/*     */ package mzm.gsp.market.auction;
/*     */ 
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import mzm.gsp.item.main.ItemBanTrade;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.market.SItemAuctionRes;
/*     */ import mzm.gsp.market.main.MarketInterface;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.AuctionItemInfo;
/*     */ import xbean.Item;
/*     */ import xbean.MarketItem;
/*     */ import xbean.RoleAuctionInfo;
/*     */ import xbean.RoleMarketInfo;
/*     */ import xtable.Marketitemid2auction;
/*     */ 
/*     */ public class PItemAuction extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final long marketId;
/*     */   private final int itemId;
/*     */   private final int price;
/*     */   
/*     */   public PItemAuction(long roleId, long marketId, int itemId, int price)
/*     */   {
/*  28 */     this.roleId = roleId;
/*  29 */     this.marketId = marketId;
/*  30 */     this.itemId = itemId;
/*  31 */     this.price = price;
/*     */   }
/*     */   
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  38 */     if (!MarketInterface.isRoleStateCanOperateMarket(this.roleId))
/*     */     {
/*  40 */       String logStr = String.format("[marketauction]PItemAuction.processImp@role state can not operate market|roleid=%d", new Object[] { Long.valueOf(this.roleId) });
/*     */       
/*  42 */       MarketInterface.getLogger().info(logStr);
/*  43 */       return false;
/*     */     }
/*     */     
/*  46 */     if (ItemBanTrade.getInstance().isBanTrade(mzm.gsp.item.main.ItemBanTrade.TradeTypeEnum.MARKET_ITEM.value, this.itemId))
/*     */     {
/*  48 */       ItemBanTrade.getInstance().sendTipToTole(this.roleId, ItemInterface.getItemName(this.itemId));
/*  49 */       return false;
/*     */     }
/*  51 */     String log = String.format("[marketauction]PItemAuction.processImp@receive auction item req|roleid=%d|itemid=%d|marketId=%d|price=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.itemId), Long.valueOf(this.marketId), Integer.valueOf(this.price) });
/*     */     
/*     */ 
/*  54 */     MarketInterface.getLogger().info(log);
/*     */     
/*  56 */     if (this.price <= 0)
/*     */     {
/*  58 */       log = String.format("[marketauction]PItemAuction.processImp@price error|roleid=%d|itemid=%d|marketId=%d|price=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.itemId), Long.valueOf(this.marketId), Integer.valueOf(this.price) });
/*     */       
/*  60 */       MarketInterface.getLogger().warn(log);
/*     */       
/*  62 */       return false;
/*     */     }
/*  64 */     if (!MarketInterface.isMarketSwitchOpenForRole(this.roleId))
/*     */     {
/*  66 */       log = String.format("[marketauction]PItemAuction.processImp@market switch closed for role|roleid=%d|itemid=%d|marketId=%d|price=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.itemId), Long.valueOf(this.marketId), Integer.valueOf(this.price) });
/*     */       
/*     */ 
/*  69 */       MarketInterface.getLogger().warn(log);
/*     */       
/*  71 */       return false;
/*     */     }
/*  73 */     if (!MarketInterface.isMarketAuctionSwitchOpenForRole(this.roleId))
/*     */     {
/*  75 */       log = String.format("[marketauction]PItemAuction.processImp@market auction switch closed for role|roleid=%d|itemid=%d|marketId=%d|price=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.itemId), Long.valueOf(this.marketId), Integer.valueOf(this.price) });
/*     */       
/*     */ 
/*  78 */       MarketInterface.getLogger().warn(log);
/*     */       
/*  80 */       return false;
/*     */     }
/*  82 */     if (!MarketInterface.isMarketOpen(this.roleId))
/*     */     {
/*  84 */       log = String.format("[marketauction]PItemAuction.processImp@role level error|roleid=%d|itemid=%d|marketId=%d|price=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.itemId), Long.valueOf(this.marketId), Integer.valueOf(this.price) });
/*     */       
/*     */ 
/*  87 */       MarketInterface.getLogger().warn(log);
/*     */       
/*  89 */       return false;
/*     */     }
/*  91 */     int subid = MarketInterface.getSubidByItemId(this.itemId);
/*  92 */     if (subid == -1)
/*     */     {
/*  94 */       MarketInterface.sendCommonError(this.roleId, 19);
/*  95 */       return false;
/*     */     }
/*     */     
/*  98 */     if (!MarketInterface.isRoleLevelRight(mzm.gsp.role.main.RoleInterface.getLevel(this.roleId), subid))
/*     */     {
/* 100 */       log = String.format("[marketauction]PItemAuction.processImp@role level can not see this item|roleid=%d|itemid=%d|marketId=%d|price=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.itemId), Long.valueOf(this.marketId), Integer.valueOf(this.price) });
/*     */       
/*     */ 
/* 103 */       MarketInterface.getLogger().warn(log);
/* 104 */       return false;
/*     */     }
/*     */     
/* 107 */     RoleAuctionInfo xRoleAuctionInfo = xtable.Role2auctioninfo.get(Long.valueOf(this.roleId));
/* 108 */     if (xRoleAuctionInfo == null)
/*     */     {
/* 110 */       xRoleAuctionInfo = xbean.Pod.newRoleAuctionInfo();
/* 111 */       xtable.Role2auctioninfo.insert(Long.valueOf(this.roleId), xRoleAuctionInfo);
/*     */     }
/*     */     
/* 114 */     MarketItem xMarketItem = xtable.Marketitem.get(Long.valueOf(this.marketId));
/* 115 */     if (xMarketItem == null)
/*     */     {
/* 117 */       MarketInterface.sendCommonError(this.roleId, 7);
/* 118 */       return false;
/*     */     }
/* 120 */     long sellerRoleid = xMarketItem.getRoleid();
/* 121 */     if (sellerRoleid == this.roleId)
/*     */     {
/* 123 */       log = String.format("[marketauction]PItemAuction.processImp@roleid error, self|roleid=%d|itemid=%d|marketId=%d|price=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.itemId), Long.valueOf(this.marketId), Integer.valueOf(this.price) });
/*     */       
/*     */ 
/* 126 */       MarketInterface.getLogger().warn(log);
/* 127 */       return false;
/*     */     }
/* 129 */     boolean isWithSkill = MarketInterface.isItemWithSkill(xMarketItem.getItem());
/* 130 */     int maxPrice = MarketInterface.getMaxItemPrice(this.itemId, isWithSkill);
/* 131 */     if (maxPrice <= 0)
/*     */     {
/* 133 */       log = String.format("[marketauction]PItemAuction.processImp@maxPrice is below zero|roleid=%d|itemId=%d|marketId=%d|price=%d|state=%d|maxprice=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.itemId), Long.valueOf(this.marketId), Integer.valueOf(this.price), Integer.valueOf(xMarketItem.getState()), Integer.valueOf(maxPrice) });
/*     */       
/*     */ 
/* 136 */       MarketInterface.getLogger().warn(log);
/* 137 */       return false;
/*     */     }
/* 139 */     if (xMarketItem.getPrice() >= maxPrice)
/*     */     {
/* 141 */       log = String.format("[marketauction]PItemAuction.processImp@item price is already to max price|roleid=%d|itemId=%d|marketId=%d|price=%d|state=%d|maxprice=%d|currentprice=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.itemId), Long.valueOf(this.marketId), Integer.valueOf(this.price), Integer.valueOf(xMarketItem.getState()), Integer.valueOf(maxPrice), Integer.valueOf(xMarketItem.getPrice()) });
/*     */       
/*     */ 
/* 144 */       MarketInterface.getLogger().warn(log);
/* 145 */       return false;
/*     */     }
/* 147 */     if (this.price > maxPrice)
/*     */     {
/* 149 */       log = String.format("[marketauction]PItemAuction.processImp@price is over than max price|roleid=%d|itemId=%d|marketId=%d|price=%d|state=%d|maxprice=%d|currentprice=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.itemId), Long.valueOf(this.marketId), Integer.valueOf(this.price), Integer.valueOf(xMarketItem.getState()), Integer.valueOf(maxPrice), Integer.valueOf(xMarketItem.getPrice()) });
/*     */       
/*     */ 
/* 152 */       MarketInterface.getLogger().warn(log);
/* 153 */       return false;
/*     */     }
/* 155 */     if (!MarketAuctionManager.canAuction(xMarketItem.getState()))
/*     */     {
/* 157 */       log = String.format("[marketauction]PItemAuction.processImp@item state can not auction|roleid=%d|itemid=%d|marketId=%d|price=%d|state=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.itemId), Long.valueOf(this.marketId), Integer.valueOf(this.price), Integer.valueOf(xMarketItem.getState()) });
/*     */       
/*     */ 
/* 160 */       MarketInterface.getLogger().warn(log);
/*     */       
/* 162 */       return false;
/*     */     }
/*     */     
/* 165 */     if (xMarketItem.getItem().getCfgid() != this.itemId)
/*     */     {
/* 167 */       log = String.format("[marketauction]PItemAuction.processImp@itemid error|roleid=%d|itemid=%d|serverItemId=%d|marketId=%d|price=%d|state=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.itemId), Integer.valueOf(xMarketItem.getItem().getCfgid()), Long.valueOf(this.marketId), Integer.valueOf(this.price), Integer.valueOf(xMarketItem.getState()) });
/*     */       
/*     */ 
/* 170 */       MarketInterface.getLogger().warn(log);
/* 171 */       return false;
/*     */     }
/* 173 */     if (!MarketAuctionManager.isItemAuctionPriceRight(this.price, xMarketItem.getPrice(), maxPrice))
/*     */     {
/* 175 */       log = String.format("[marketauction]PItemAuction.processImp@item auction price error|roleid=%d|itemid=%d|marketId=%d|price=%d|state=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.itemId), Long.valueOf(this.marketId), Integer.valueOf(this.price), Integer.valueOf(xMarketItem.getState()) });
/*     */       
/*     */ 
/* 178 */       MarketInterface.getLogger().warn(log);
/* 179 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 183 */     RoleMarketInfo xRoleMarketInfo = xtable.Role2marketinfo.get(Long.valueOf(this.roleId));
/* 184 */     if ((xRoleMarketInfo != null) && (xRoleMarketInfo.getConcern_item_ids().contains(Long.valueOf(this.marketId))))
/*     */     {
/* 186 */       xRoleMarketInfo.getConcern_item_ids().remove(Long.valueOf(this.marketId));
/*     */       
/* 188 */       xMarketItem.setConcern_role_num(Math.max(0, xMarketItem.getConcern_role_num() - 1));
/*     */       
/* 190 */       xbean.ConcernRoleIdSet xConcernRoleIdSet = xtable.Marketitemid2concernrole.get(Long.valueOf(this.marketId));
/* 191 */       if (xConcernRoleIdSet != null)
/*     */       {
/*     */ 
/* 194 */         xConcernRoleIdSet.getRoleids().remove(Long.valueOf(this.roleId));
/*     */       }
/*     */     }
/*     */     
/* 198 */     int oldPrice = xMarketItem.getPrice();
/*     */     
/* 200 */     xMarketItem.setPrice(this.price);
/* 201 */     xMarketItem.setState(xMarketItem.getState() | 0x10);
/*     */     
/* 203 */     AuctionItemInfo xAuctionInfo = Marketitemid2auction.get(Long.valueOf(this.marketId));
/* 204 */     if (xAuctionInfo == null)
/*     */     {
/* 206 */       xAuctionInfo = xbean.Pod.newAuctionItemInfo();
/* 207 */       Marketitemid2auction.insert(Long.valueOf(this.marketId), xAuctionInfo);
/*     */     }
/* 209 */     long oldRoleId = xAuctionInfo.getAuctionroleid();
/*     */     
/* 211 */     if (oldRoleId == this.roleId)
/*     */     {
/* 213 */       log = String.format("[marketauction]PItemAuction.processImp@auction role error,already the max price role|roleid=%d|itemid=%d|marketId=%d|price=%d|state=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.itemId), Long.valueOf(this.marketId), Integer.valueOf(this.price), Integer.valueOf(xMarketItem.getState()) });
/*     */       
/*     */ 
/* 216 */       MarketInterface.getLogger().warn(log);
/* 217 */       return false;
/*     */     }
/* 219 */     xAuctionInfo.setAuctionroleid(this.roleId);
/* 220 */     xAuctionInfo.setAuctioncount(xAuctionInfo.getAuctioncount() + 1);
/* 221 */     xAuctionInfo.setAuctionprice(this.price);
/* 222 */     xAuctionInfo.setItemid(xMarketItem.getItem().getCfgid());
/* 223 */     xAuctionInfo.getAuctionroleset().add(Long.valueOf(this.roleId));
/* 224 */     xAuctionInfo.setItemnum(xMarketItem.getRest_num());
/* 225 */     long now = mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis();
/* 226 */     if (xAuctionInfo.getAuctioncount() == 1)
/*     */     {
/* 228 */       xAuctionInfo.setEndtime(TimeUnit.SECONDS.toMillis(MarketInterface.computePublicEndtime(xMarketItem.getOnshelf_time())));
/*     */     }
/*     */     else
/*     */     {
/* 232 */       long endTime = MarketAuctionManager.computeNewAuctionEndTime(xAuctionInfo.getEndtime(), xMarketItem.getOnshelf_time(), now);
/*     */       
/* 234 */       xAuctionInfo.setEndtime(endTime);
/*     */     }
/* 236 */     if (!xRoleAuctionInfo.getAuction_item_ids().contains(Long.valueOf(this.marketId)))
/*     */     {
/* 238 */       xRoleAuctionInfo.getAuction_item_ids().add(Long.valueOf(this.marketId));
/*     */     }
/*     */     
/* 241 */     TLogArg logArg = new TLogArg(mzm.gsp.tlog.LogReason.MARKET_AUCTION, this.itemId);
/* 242 */     if (!mzm.gsp.role.main.RoleInterface.cutGoldIngot(this.roleId, this.price * xAuctionInfo.getItemnum(), logArg))
/*     */     {
/* 244 */       log = String.format("[marketauction]PItemAuction.processImp@cut ingot failed|roleid=%d|itemid=%d|marketId=%d|price=%d|state=%d|num=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.itemId), Long.valueOf(this.marketId), Integer.valueOf(this.price), Integer.valueOf(xMarketItem.getState()), Integer.valueOf(xAuctionInfo.getItemnum()) });
/*     */       
/*     */ 
/* 247 */       MarketInterface.getLogger().warn(log);
/* 248 */       return false;
/*     */     }
/*     */     
/* 251 */     MarketAuctionManager.startAuctionItemSession(this.marketId, xAuctionInfo, now);
/*     */     
/* 253 */     SItemAuctionRes res = new SItemAuctionRes();
/* 254 */     res.marketid = this.marketId;
/* 255 */     res.itemid = this.itemId;
/* 256 */     res.price = this.price;
/* 257 */     res.endtime = TimeUnit.MILLISECONDS.toSeconds(xAuctionInfo.getEndtime());
/*     */     
/* 259 */     mzm.gsp.online.main.OnlineManager.getInstance().send(this.roleId, res);
/*     */     
/* 261 */     log = String.format("[marketauction]PItemAuction.processImp@auction item success|roleid=%d|itemid=%d|marketId=%d|price=%d|endTime=%d|itemnum=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.itemId), Long.valueOf(this.marketId), Integer.valueOf(this.price), Long.valueOf(res.endtime), Integer.valueOf(xMarketItem.getRest_num()) });
/*     */     
/*     */ 
/* 264 */     MarketInterface.getLogger().info(log);
/*     */     
/* 266 */     if (oldRoleId != 0L)
/*     */     {
/* 268 */       MarketAuctionManager.sendAuctionPriceBePassedMail(oldRoleId, oldPrice, this.marketId, this.itemId, ItemInterface.getItemName(this.itemId), this.price, xMarketItem.getRest_num());
/*     */     }
/*     */     
/* 271 */     long uuid = 0L;
/* 272 */     if ((xMarketItem.getItem().getUuid() != null) && (!xMarketItem.getItem().getUuid().isEmpty()))
/*     */     {
/* 274 */       uuid = ((Long)xMarketItem.getItem().getUuid().iterator().next()).longValue();
/*     */     }
/*     */     
/* 277 */     if (MarketInterface.isLevelSift(subid))
/*     */     {
/* 279 */       int level = ItemInterface.getUseLevel(xMarketItem.getItem().getCfgid());
/* 280 */       MarketInterface.deleteFromPubLevelSiftRank(subid, this.marketId, level);
/* 281 */       MarketInterface.rankIntoPubLevelSiftRank(subid, this.marketId, level, this.price);
/*     */     }
/*     */     else
/*     */     {
/* 285 */       MarketInterface.deleteFromPubPriceRank(subid, this.marketId);
/* 286 */       MarketInterface.rankIntoPubPriceRank(subid, this.marketId, this.price);
/*     */     }
/* 288 */     if (!MarketInterface.isSysRoleid(sellerRoleid))
/*     */     {
/* 290 */       MarketAuctionManager.sendSSynItemPriceRes(sellerRoleid, this.marketId, xMarketItem, xAuctionInfo);
/*     */     }
/* 292 */     MarketAuctionManager.tlogMarketauction(this.roleId, subid, this.itemId, this.price, oldRoleId, oldPrice, this.marketId, uuid, sellerRoleid);
/* 293 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\market\auction\PItemAuction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */