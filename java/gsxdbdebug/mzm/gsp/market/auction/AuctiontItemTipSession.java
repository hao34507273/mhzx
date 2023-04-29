/*     */ package mzm.gsp.market.auction;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.List;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.market.main.MarketInterface;
/*     */ import mzm.gsp.timer.main.Session;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.AuctionItemInfo;
/*     */ import xbean.Item;
/*     */ import xbean.MarketItem;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Marketitem;
/*     */ import xtable.Marketitem2sessionid;
/*     */ import xtable.Marketitemid2auction;
/*     */ import xtable.Marketitemid2concernrole;
/*     */ import xtable.Role2auctioninfo;
/*     */ 
/*     */ public class AuctiontItemTipSession extends Session
/*     */ {
/*     */   public AuctiontItemTipSession(long interval, long marketId)
/*     */   {
/*  26 */     super(interval, marketId);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   protected void onTimeOut()
/*     */   {
/*  34 */     new AuctiontItemTipPro(getOwerId()).execute();
/*     */   }
/*     */   
/*     */ 
/*     */   private static class AuctiontItemTipPro
/*     */     extends LogicProcedure
/*     */   {
/*     */     private final long marketId;
/*     */     
/*     */     public AuctiontItemTipPro(long marketId)
/*     */     {
/*  45 */       this.marketId = marketId;
/*     */     }
/*     */     
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/*  51 */       Long maxPriceRoleId = Marketitemid2auction.selectAuctionroleid(Long.valueOf(this.marketId));
/*  52 */       if (maxPriceRoleId == null)
/*     */       {
/*  54 */         String logStr = String.format("[marketauction]AuctiontItemTipPro.processImp@ maxPriceRoleId get null|marketId=%d", new Object[] { Long.valueOf(this.marketId) });
/*     */         
/*  56 */         MarketInterface.getLogger().error(logStr);
/*  57 */         return false;
/*     */       }
/*     */       
/*  60 */       Lockeys.lock(Role2auctioninfo.getTable(), Arrays.asList(new Long[] { maxPriceRoleId }));
/*     */       
/*  62 */       MarketItem xMarketItem = Marketitem.get(Long.valueOf(this.marketId));
/*  63 */       if (xMarketItem == null)
/*     */       {
/*  65 */         String logStr = String.format("[marketauction]AuctiontItemTipPro.processImp@ xbean.MarketItem get null|marketId=%d", new Object[] { Long.valueOf(this.marketId) });
/*     */         
/*  67 */         MarketInterface.getLogger().error(logStr);
/*  68 */         return false;
/*     */       }
/*  70 */       if (!MarketInterface.hasState(xMarketItem.getState(), 16))
/*     */       {
/*  72 */         String logStr = String.format("[marketauction]AuctiontItemTipPro.processImp@ xbean.MarketItem state error|roleId=%d|marketId=%d|state=%d|auctionRoleId=%d", new Object[] { Long.valueOf(xMarketItem.getRoleid()), Long.valueOf(this.marketId), Integer.valueOf(xMarketItem.getState()), maxPriceRoleId });
/*     */         
/*     */ 
/*  75 */         MarketInterface.getLogger().error(logStr);
/*  76 */         return false;
/*     */       }
/*     */       
/*  79 */       AuctionItemInfo xAuctionInfo = Marketitemid2auction.get(Long.valueOf(this.marketId));
/*  80 */       if (xAuctionInfo == null)
/*     */       {
/*  82 */         String logStr = String.format("[marketauction]AuctiontItemTipPro.processImp@ xbean.AuctionItemInfo state error,null|roleId=%d|marketId=%d|state=%d|auctionRoleId=%d", new Object[] { Long.valueOf(xMarketItem.getRoleid()), Long.valueOf(this.marketId), Integer.valueOf(xMarketItem.getState()), maxPriceRoleId });
/*     */         
/*     */ 
/*  85 */         MarketInterface.getLogger().error(logStr);
/*  86 */         return false;
/*     */       }
/*  88 */       xAuctionInfo.setIssendtip(true);
/*  89 */       if (maxPriceRoleId.longValue() != xAuctionInfo.getAuctionroleid())
/*     */       {
/*  91 */         String logStr = String.format("[marketauction]AuctiontItemTipPro.processImp@ auction roleId not same or price error|roleId=%d|marketId=%d|state=%d|auctionRoleId=%d|newAuctionRoleId=%d", new Object[] { Long.valueOf(xMarketItem.getRoleid()), Long.valueOf(this.marketId), Integer.valueOf(xMarketItem.getState()), maxPriceRoleId, Long.valueOf(xAuctionInfo.getAuctionroleid()) });
/*     */         
/*     */ 
/*     */ 
/*  95 */         MarketInterface.getLogger().error(logStr);
/*  96 */         return false;
/*     */       }
/*     */       
/*  99 */       List<Long> concernRoleSet = Marketitemid2concernrole.selectRoleids(Long.valueOf(this.marketId));
/* 100 */       MarketAuctionManager.sendAuctionPublicEndTipMail(xMarketItem.getRoleid(), maxPriceRoleId.longValue(), concernRoleSet, this.marketId, xMarketItem.getItem().getCfgid(), ItemInterface.getItemName(xMarketItem.getItem().getCfgid()), xAuctionInfo.getAuctioncount(), xAuctionInfo.getAuctionprice());
/*     */       
/*     */ 
/*     */ 
/* 104 */       long interval = TimeUnit.MILLISECONDS.toSeconds(xAuctionInfo.getEndtime() - DateTimeUtils.getCurrTimeInMillis());
/* 105 */       if (interval <= 0L)
/*     */       {
/* 107 */         interval = 1L;
/*     */       }
/* 109 */       Session session = new AuctionItemEndSession(interval, this.marketId);
/* 110 */       Marketitem2sessionid.remove(Long.valueOf(this.marketId));
/* 111 */       Marketitem2sessionid.insert(Long.valueOf(this.marketId), Long.valueOf(session.getSessionId()));
/*     */       
/* 113 */       return true;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\market\auction\AuctiontItemTipSession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */