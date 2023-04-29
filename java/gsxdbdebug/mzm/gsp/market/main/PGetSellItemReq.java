/*     */ package mzm.gsp.market.main;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.item.main.ItemOperateResult;
/*     */ import mzm.gsp.market.SGetSellItemRes;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.AuctionItemInfo;
/*     */ import xbean.Item;
/*     */ import xbean.MarketItem;
/*     */ import xbean.RoleMarketInfo;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Item2marketchannelids;
/*     */ import xtable.Marketitem;
/*     */ import xtable.Marketitem2sessionid;
/*     */ import xtable.Marketitemid2concernrole;
/*     */ 
/*     */ public class PGetSellItemReq extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final long marketId;
/*     */   public final int itemId;
/*     */   
/*     */   public PGetSellItemReq(long roleId, long marketId, int itemId)
/*     */   {
/*  31 */     this.roleId = roleId;
/*  32 */     this.marketId = marketId;
/*  33 */     this.itemId = itemId;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  39 */     String logStr = String.format("[market]PGetSellItemReq.processImp@receive get sell item req|roleid=%d|itemId=%d|marketId=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.itemId), Long.valueOf(this.marketId) });
/*     */     
/*     */ 
/*  42 */     MarketManager.logger.info(logStr);
/*     */     
/*  44 */     if (!MarketInterface.isRoleStateCanOperateMarket(this.roleId))
/*     */     {
/*  46 */       logStr = String.format("[market]PGetSellItemReq.processImp@role state can not operate market|roleid=%d", new Object[] { Long.valueOf(this.roleId) });
/*  47 */       MarketManager.logger.info(logStr);
/*  48 */       return false;
/*     */     }
/*     */     
/*  51 */     RoleMarketInfo xRoleMarketInfo = xtable.Role2marketinfo.get(Long.valueOf(this.roleId));
/*  52 */     if (xRoleMarketInfo == null)
/*     */     {
/*  54 */       return false;
/*     */     }
/*  56 */     if (!xRoleMarketInfo.getOnshelf_item_ids().contains(Long.valueOf(this.marketId)))
/*     */     {
/*  58 */       return false;
/*     */     }
/*  60 */     if (xRoleMarketInfo.getMarketid2timeoutorselleditem().containsKey(Long.valueOf(this.marketId)))
/*     */     {
/*  62 */       MarketItem xMarketItem = (MarketItem)xRoleMarketInfo.getMarketid2timeoutorselleditem().get(Long.valueOf(this.marketId));
/*  63 */       if (xMarketItem.getRest_num() <= 0)
/*     */       {
/*  65 */         return false;
/*     */       }
/*  67 */       if (MarketManager.hasState(xMarketItem.getState(), 4))
/*     */       {
/*  69 */         MarketManager.sendCommonError(this.roleId, 4);
/*  70 */         return false;
/*     */       }
/*  72 */       TLogArg logArg = new TLogArg(LogReason.MARKET_XIAJIA, this.itemId);
/*  73 */       Item xItem = MarketManager.separateItem(xMarketItem.getItem(), xMarketItem.getRest_num());
/*  74 */       List<Item> xItemList = new java.util.ArrayList();
/*  75 */       xItemList.add(xItem);
/*     */       
/*  77 */       ItemOperateResult result = ItemInterface.addItemActive(this.roleId, xItemList, true, true, logArg);
/*  78 */       if (!result.success())
/*     */       {
/*  80 */         return false;
/*     */       }
/*  82 */       xRoleMarketInfo.getOnshelf_item_ids().remove(Long.valueOf(this.marketId));
/*  83 */       xRoleMarketInfo.getMarketid2timeoutorselleditem().remove(Long.valueOf(this.marketId));
/*     */       
/*  85 */       sendSGetSellItemRes(0);
/*     */       
/*  87 */       String log = String.format("[market]PGetSellItemReq.processImp@get item from role shelf sucess|roleid=%d|itemid=%d|marketId=%d|price=%d|num=%d|total_num=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.itemId), Long.valueOf(this.marketId), Integer.valueOf(xMarketItem.getPrice()), Integer.valueOf(xMarketItem.getRest_num()), Integer.valueOf(xMarketItem.getItem().getNumber()) });
/*     */       
/*     */ 
/*     */ 
/*  91 */       MarketManager.logger.info(log);
/*     */       
/*  93 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*  98 */     Long channel_id = Marketitem.selectChannel_id(Long.valueOf(this.marketId));
/*  99 */     if (channel_id == null)
/*     */     {
/* 101 */       return false;
/*     */     }
/*     */     
/* 104 */     long itemLockKey = mzm.gsp.GameServerInfoManager.toGlobalId(this.itemId);
/* 105 */     Lockeys.lock(Item2marketchannelids.getTable(), Arrays.asList(new Long[] { Long.valueOf(itemLockKey) }));
/* 106 */     Lockeys.lock(xtable.Channel2marketids.getTable(), Arrays.asList(new Long[] { channel_id }));
/*     */     
/* 108 */     MarketItem xMarketItem = Marketitem.get(Long.valueOf(this.marketId));
/* 109 */     if (xMarketItem == null)
/*     */     {
/* 111 */       return false;
/*     */     }
/* 113 */     if (xMarketItem.getChannel_id() != channel_id.longValue())
/*     */     {
/* 115 */       return false;
/*     */     }
/* 117 */     if (xMarketItem.getRest_num() <= 0)
/*     */     {
/* 119 */       MarketManager.sendCommonError(this.roleId, 9);
/* 120 */       return false;
/*     */     }
/* 122 */     if (xMarketItem.getState() == 4)
/*     */     {
/* 124 */       MarketManager.sendCommonError(this.roleId, 1);
/* 125 */       return false;
/*     */     }
/*     */     
/* 128 */     if (xMarketItem.getItem().getCfgid() != this.itemId)
/*     */     {
/* 130 */       return false;
/*     */     }
/* 132 */     int needGold = 0;
/* 133 */     AuctionItemInfo xAuctionItemInfo = xtable.Marketitemid2auction.get(Long.valueOf(this.marketId));
/* 134 */     if ((MarketManager.isCutGoldSwitchOpen()) && (MarketManager.hasState(xMarketItem.getState(), 16)) && (xAuctionItemInfo != null))
/*     */     {
/*     */ 
/*     */ 
/* 138 */       needGold = MarketManager.computeOffSheldNeedGold(xMarketItem.getPrice()) * xMarketItem.getRest_num();
/* 139 */       TLogArg logArg = new TLogArg(LogReason.MARKET_AUCTION_GOODS_OFFSHELF, this.itemId);
/*     */       
/* 141 */       boolean ret = mzm.gsp.role.main.RoleInterface.cutGold(this.roleId, needGold, logArg);
/* 142 */       if (!ret)
/*     */       {
/* 144 */         String log = String.format("[market]PGetSellItemReq.processImp@item is auctioned,cut gold error|roleid=%d|itemid=%d|marketId=%d|price=%d|num=%d|need_total_gold=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.itemId), Long.valueOf(this.marketId), Integer.valueOf(xMarketItem.getPrice()), Integer.valueOf(xMarketItem.getRest_num()), Integer.valueOf(needGold) });
/*     */         
/*     */ 
/* 147 */         MarketManager.logger.info(log);
/*     */         
/* 149 */         MarketManager.sendCommonError(this.roleId, 25);
/* 150 */         return false;
/*     */       }
/*     */     }
/*     */     else
/*     */     {
/* 155 */       String log = String.format("[market]PGetSellItemReq.processImp@item is not auctioned|roleid=%d|itemid=%d|marketId=%d|price=%d|num=%d|state=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.itemId), Long.valueOf(this.marketId), Integer.valueOf(xMarketItem.getPrice()), Integer.valueOf(xMarketItem.getRest_num()), Integer.valueOf(xMarketItem.getState()) });
/*     */       
/*     */ 
/* 158 */       MarketManager.logger.info(log);
/*     */     }
/*     */     
/* 161 */     ItemOperateResult result = MarketInterface.addItemToRole(this.roleId, xMarketItem.getItem(), xMarketItem.getRest_num(), LogReason.MARKET_XIAJIA, 0L);
/*     */     
/*     */ 
/* 164 */     if (!result.success())
/*     */     {
/* 166 */       return false;
/*     */     }
/*     */     
/* 169 */     Marketitem.remove(Long.valueOf(this.marketId));
/* 170 */     Marketitemid2concernrole.remove(Long.valueOf(this.marketId));
/* 171 */     MarketManager.removeMarketIdFromItemChannel(itemLockKey, this.marketId, channel_id.longValue());
/*     */     
/* 173 */     xRoleMarketInfo.getOnshelf_item_ids().remove(Long.valueOf(this.marketId));
/*     */     
/* 175 */     Long sessionId = Marketitem2sessionid.get(Long.valueOf(this.marketId));
/* 176 */     if (sessionId != null)
/*     */     {
/* 178 */       mzm.gsp.timer.main.Session.removeSession(sessionId.longValue());
/* 179 */       Marketitem2sessionid.remove(Long.valueOf(this.marketId));
/*     */     }
/*     */     
/* 182 */     int subid = MarketManager.getSubidByItemId(this.itemId);
/* 183 */     if (MarketManager.isLevelSift(subid))
/*     */     {
/* 185 */       int level = ItemInterface.getUseLevel(xMarketItem.getItem().getCfgid());
/* 186 */       LevelSiftRankManager.deletePub(subid, this.marketId, level);
/* 187 */       LevelSiftRankManager.deleteSell(subid, this.marketId, level);
/*     */     }
/*     */     else
/*     */     {
/* 191 */       PriceRankManager.deletePub(subid, this.marketId);
/* 192 */       PriceRankManager.deleteSell(subid, this.marketId);
/*     */     }
/*     */     
/* 195 */     sendSGetSellItemRes(needGold);
/*     */     
/* 197 */     if (MarketManager.hasState(xMarketItem.getState(), 1))
/*     */     {
/* 199 */       MarketInterface.triggerMarketItemOffShelfEvent(this.marketId, this.itemId, true, xMarketItem.toData());
/*     */     }
/* 201 */     else if (MarketManager.hasState(xMarketItem.getState(), 2))
/*     */     {
/* 203 */       MarketInterface.triggerMarketItemOffShelfEvent(this.marketId, this.itemId, false, xMarketItem.toData());
/* 204 */       MarketItemPetPriceManager.removePrice(xMarketItem.getItem().getCfgid(), xMarketItem.getPrice());
/*     */     }
/*     */     
/* 207 */     mzm.gsp.market.auction.MarketAuctionManager.removeMarketItemAuction(this.marketId, true, true, true);
/*     */     
/* 209 */     String log = String.format("[market]PGetSellItemReq.processImp@get item from market shelf sucess|roleid=%d|itemid=%d|marketId=%d|price=%d|num=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.itemId), Long.valueOf(this.marketId), Integer.valueOf(xMarketItem.getPrice()), Integer.valueOf(xMarketItem.getRest_num()) });
/*     */     
/*     */ 
/* 212 */     MarketManager.logger.info(log);
/*     */     
/* 214 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private void sendSGetSellItemRes(int cutGold)
/*     */   {
/* 221 */     SGetSellItemRes res = new SGetSellItemRes();
/* 222 */     res.marketid = this.marketId;
/* 223 */     res.cutgold = cutGold;
/* 224 */     OnlineManager.getInstance().send(this.roleId, res);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\market\main\PGetSellItemReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */