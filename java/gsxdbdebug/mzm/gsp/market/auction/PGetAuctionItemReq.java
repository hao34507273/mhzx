/*     */ package mzm.gsp.market.auction;
/*     */ 
/*     */ import java.util.Map;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import mzm.gsp.item.main.ItemOperateResult;
/*     */ import mzm.gsp.market.main.MarketInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.AuctionItemInfo;
/*     */ import xbean.Item;
/*     */ import xbean.RoleAuctionInfo;
/*     */ 
/*     */ public class PGetAuctionItemReq extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final long marketId;
/*     */   private final int itemId;
/*     */   
/*     */   public PGetAuctionItemReq(long roleId, long marketId, int itemId)
/*     */   {
/*  21 */     this.roleId = roleId;
/*  22 */     this.marketId = marketId;
/*  23 */     this.itemId = itemId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  31 */     String log = String.format("[marketauction]PGetAuctionItemReq.processImp@receive get auction item req|roleid=%d|itemId=%d|marketId=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.itemId), Long.valueOf(this.marketId) });
/*     */     
/*     */ 
/*  34 */     MarketInterface.getLogger().info(log);
/*     */     
/*  36 */     if (!MarketInterface.isRoleStateCanOperateMarket(this.roleId))
/*     */     {
/*  38 */       String logStr = String.format("[marketauction]PGetAuctionItemReq.processImp@role state can not operate market|roleid=%d", new Object[] { Long.valueOf(this.roleId) });
/*     */       
/*  40 */       MarketInterface.getLogger().info(logStr);
/*  41 */       return false;
/*     */     }
/*     */     
/*  44 */     if (!MarketInterface.isMarketAuctionSwitchOpenForRole(this.roleId))
/*     */     {
/*  46 */       String logStr = String.format("[marketauction]PGetAuctionItemReq.processImp@get auction item failed ,role is auction ban play|roleid=%d|itemId=%d|marketId=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.itemId), Long.valueOf(this.marketId) });
/*     */       
/*     */ 
/*  49 */       MarketInterface.getLogger().error(logStr);
/*     */       
/*  51 */       return false;
/*     */     }
/*  53 */     if (!MarketInterface.isMarketOpen(this.roleId))
/*     */     {
/*  55 */       String logStr = String.format("[marketauction]PGetAuctionItemReq.processImp@get auction item failed ,role level wrong|roleid=%d|itemId=%d|marketId=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.itemId), Long.valueOf(this.marketId) });
/*     */       
/*     */ 
/*  58 */       MarketInterface.getLogger().error(logStr);
/*  59 */       return false;
/*     */     }
/*     */     
/*  62 */     RoleAuctionInfo xRoleAuctionInfo = xtable.Role2auctioninfo.get(Long.valueOf(this.roleId));
/*  63 */     if (xRoleAuctionInfo == null)
/*     */     {
/*  65 */       String logStr = String.format("[marketauction]PGetAuctionItemReq.processImp@get auction item failed ,xRoleAuctionInfo null|roleid=%d|itemId=%d|marketId=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.itemId), Long.valueOf(this.marketId) });
/*     */       
/*     */ 
/*  68 */       MarketInterface.getLogger().error(logStr);
/*  69 */       return false;
/*     */     }
/*     */     
/*  72 */     if (!xRoleAuctionInfo.getAuction_item_ids().contains(Long.valueOf(this.marketId)))
/*     */     {
/*  74 */       String logStr = String.format("[marketauction]PGetAuctionItemReq.processImp@get auction item failed ,marketId wrong|roleid=%d|itemId=%d|marketId=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.itemId), Long.valueOf(this.marketId) });
/*     */       
/*     */ 
/*  77 */       MarketInterface.getLogger().error(logStr);
/*     */       
/*  79 */       return false;
/*     */     }
/*     */     
/*  82 */     long now = mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis();
/*  83 */     AuctionItemInfo xAuctionInfo = xtable.Marketitemid2auction.get(Long.valueOf(this.marketId));
/*  84 */     if (xAuctionInfo == null)
/*     */     {
/*  86 */       String logStr = String.format("[marketauction]PGetAuctionItemReq.processImp@get auction item failed ,xAuctionInfo null|roleid=%d|itemId=%d|marketId=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.itemId), Long.valueOf(this.marketId) });
/*     */       
/*     */ 
/*  89 */       MarketInterface.getLogger().error(logStr);
/*     */       
/*  91 */       return false;
/*     */     }
/*     */     
/*  94 */     if (xAuctionInfo.getEndtime() > now)
/*     */     {
/*  96 */       String logStr = String.format("[marketauction]PGetAuctionItemReq.processImp@get auction item error ,time error|roleid=%d|itemId=%d|marketId=%d|endtime=%d|now=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.itemId), Long.valueOf(this.marketId), Long.valueOf(xAuctionInfo.getEndtime()), Long.valueOf(now) });
/*     */       
/*     */ 
/*  99 */       MarketInterface.getLogger().info(logStr);
/*     */       
/* 101 */       return false;
/*     */     }
/* 103 */     if (xAuctionInfo.getAuctionroleid() != this.roleId)
/*     */     {
/* 105 */       String logStr = String.format("[marketauction]PGetAuctionItemReq.processImp@get auction item error ,roleid error|roleid=%d|itemId=%d|marketId=%d|maxPriceRoleid=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.itemId), Long.valueOf(this.marketId), Long.valueOf(xAuctionInfo.getAuctionroleid()) });
/*     */       
/*     */ 
/* 108 */       MarketInterface.getLogger().info(logStr);
/* 109 */       return false;
/*     */     }
/*     */     
/* 112 */     Item xItem = (Item)xRoleAuctionInfo.getMarketid2auctionitem().get(Long.valueOf(this.marketId));
/* 113 */     if (xItem == null)
/*     */     {
/* 115 */       String logStr = String.format("[marketauction]PGetAuctionItemReq.processImp@get auction item failed, xItem null|roleid=%d|itemId=%d|marketId=%d|price=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.itemId), Long.valueOf(this.marketId), Integer.valueOf(xAuctionInfo.getAuctionprice()) });
/*     */       
/*     */ 
/* 118 */       MarketInterface.getLogger().info(logStr);
/*     */       
/* 120 */       return false;
/*     */     }
/* 122 */     if (xItem.getCfgid() != this.itemId)
/*     */     {
/* 124 */       String logStr = String.format("[marketauction]PGetAuctionItemReq.processImp@get auction item failed, itemId error|roleid=%d|itemId=%d|marketId=%d|price=%d|serverItemId=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.itemId), Long.valueOf(this.marketId), Integer.valueOf(xAuctionInfo.getAuctionprice()), Integer.valueOf(xItem.getCfgid()) });
/*     */       
/*     */ 
/* 127 */       MarketInterface.getLogger().info(logStr);
/*     */       
/* 129 */       return false;
/*     */     }
/*     */     
/* 132 */     int price = xAuctionInfo.getAuctionprice();
/*     */     
/* 134 */     xRoleAuctionInfo.getAuction_item_ids().remove(Long.valueOf(this.marketId));
/* 135 */     xRoleAuctionInfo.getMarketid2auctionitem().remove(Long.valueOf(this.marketId));
/*     */     
/* 137 */     ItemOperateResult ret = MarketInterface.addItemToRole(this.roleId, xItem, xItem.getNumber(), mzm.gsp.tlog.LogReason.MARKET_AUCTION, TimeUnit.MILLISECONDS.toSeconds(xAuctionInfo.getEndtime()));
/*     */     
/*     */ 
/* 140 */     if (!ret.success())
/*     */     {
/*     */ 
/* 143 */       String logStr = String.format("[marketauction]PGetAuctionItemReq.processImp@get auction item failed bag full|roleid=%d|itemId=%d|marketId=%d|price=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.itemId), Long.valueOf(this.marketId), Integer.valueOf(price) });
/*     */       
/*     */ 
/* 146 */       MarketInterface.getLogger().info(logStr);
/*     */       
/* 148 */       return false;
/*     */     }
/* 150 */     MarketAuctionManager.removeMarketItemAuction(this.marketId, false, false, true);
/*     */     
/* 152 */     String logStr = String.format("[marketauction]PGetAuctionItemReq.processImp@get auction item success|roleid=%d|itemId=%d|marketId=%d|price=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.itemId), Long.valueOf(this.marketId), Integer.valueOf(price) });
/*     */     
/*     */ 
/* 155 */     MarketInterface.getLogger().info(logStr);
/*     */     
/* 157 */     mzm.gsp.market.SGetAuctionItemRes res = new mzm.gsp.market.SGetAuctionItemRes();
/* 158 */     res.marketid = this.marketId;
/* 159 */     res.itemid = this.itemId;
/*     */     
/* 161 */     OnlineManager.getInstance().send(this.roleId, res);
/* 162 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\market\auction\PGetAuctionItemReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */