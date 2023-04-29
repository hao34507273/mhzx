/*     */ package mzm.gsp.market.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import mzm.gsp.market.PageItemInfo;
/*     */ import mzm.gsp.market.SQueryMarketPublicItemRes;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.AuctionItemInfo;
/*     */ import xtable.Marketitemid2auction;
/*     */ 
/*     */ public class PQueryMarketPubItemByPage extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final int subid;
/*     */   private final int pricesort;
/*     */   private int pageIndex;
/*     */   
/*     */   public PQueryMarketPubItemByPage(long roleId, int subid, int pricesort, int pageIndex)
/*     */   {
/*  21 */     this.roleId = roleId;
/*  22 */     this.subid = subid;
/*  23 */     this.pricesort = pricesort;
/*  24 */     this.pageIndex = pageIndex;
/*     */   }
/*     */   
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  31 */     if (this.pageIndex <= 0)
/*     */     {
/*  33 */       return false;
/*     */     }
/*  35 */     if (!MarketInterface.isRoleStateCanOperateMarket(this.roleId))
/*     */     {
/*  37 */       String logStr = String.format("[market]PQueryMarketPubItemByPage.processImp@role state can not operate market|roleid=%d", new Object[] { Long.valueOf(this.roleId) });
/*     */       
/*  39 */       MarketManager.logger.info(logStr);
/*  40 */       return false;
/*     */     }
/*  42 */     if (!MarketManager.isMarketSwitchOpenForRole(this.roleId))
/*     */     {
/*  44 */       return false;
/*     */     }
/*  46 */     if (!MarketManager.isMarketOpen(this.roleId))
/*     */     {
/*  48 */       return false;
/*     */     }
/*  50 */     if (!MarketManager.isItemSubtype(this.subid))
/*     */     {
/*  52 */       return false;
/*     */     }
/*     */     
/*  55 */     if (!MarketManager.isRoleLevelRight(mzm.gsp.role.main.RoleInterface.getLevel(this.roleId), this.subid))
/*     */     {
/*  57 */       return false;
/*     */     }
/*     */     
/*  60 */     int size = PriceRankManager.getPubSize(this.subid);
/*  61 */     int pageSize = MarketManager.getPageSize();
/*  62 */     int totalPage = (size - 1) / pageSize + 1;
/*  63 */     if (this.pageIndex > totalPage)
/*     */     {
/*  65 */       this.pageIndex = totalPage;
/*     */     }
/*  67 */     SQueryMarketPublicItemRes res = new SQueryMarketPublicItemRes();
/*  68 */     res.pageresult.totalpagenum = totalPage;
/*  69 */     res.pageresult.pageindex = this.pageIndex;
/*  70 */     res.pageresult.subid = this.subid;
/*  71 */     res.pricesort = this.pricesort;
/*     */     
/*  73 */     List<MarketPriceChart> list = PriceRankManager.getByPage(this.subid, this.pageIndex, true, this.pricesort == 0);
/*  74 */     String logs = String.format("[market]PQueryMarketPubItemByPage.processImp@query item by page req|roleid=%d|subId=%d|pricesort=%d|pageIndex=%d|totalpage=%d|pageSize=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.subid), Integer.valueOf(this.pricesort), Integer.valueOf(this.pageIndex), Integer.valueOf(totalPage), Integer.valueOf(list.size()) });
/*     */     
/*     */ 
/*  77 */     MarketManager.logger.info(logs);
/*  78 */     for (MarketPriceChart m : list)
/*     */     {
/*  80 */       xbean.MarketItem xMarketItem = xtable.Marketitem.select(Long.valueOf(m.getMarketId()));
/*  81 */       AuctionItemInfo xAuctionItemInfo = Marketitemid2auction.select(Long.valueOf(m.getMarketId()));
/*  82 */       if (xMarketItem == null)
/*     */       {
/*  84 */         logs = String.format("[market]PQueryMarketPubItemByPage.processImp@xMarketItem null|roleid=%d|subId=%d|pricesort=%d|pageIndex=%d|marketId=%d|price=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.subid), Integer.valueOf(this.pricesort), Integer.valueOf(this.pageIndex), Long.valueOf(m.getMarketId()), Integer.valueOf(m.getPrice()) });
/*     */         
/*     */ 
/*  87 */         MarketManager.logger.warn(logs);
/*     */       }
/*     */       else
/*     */       {
/*  91 */         mzm.gsp.market.MarketItem marketItem = new mzm.gsp.market.MarketItem();
/*  92 */         MarketManager.fillProtocolMarketItem(marketItem, m.getMarketId(), xMarketItem, xAuctionItemInfo);
/*     */         
/*  94 */         res.pageresult.marketitemlist.add(marketItem);
/*     */       }
/*     */     }
/*  97 */     logs = String.format("[market]PQueryMarketPubItemByPage.processImp@send query item by page res|roleid=%d|subId=%d|pricesort=%d|pageIndex=%d|totalpage=%d|pageSize=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.subid), Integer.valueOf(this.pricesort), Integer.valueOf(this.pageIndex), Integer.valueOf(totalPage), Integer.valueOf(res.pageresult.marketitemlist.size()) });
/*     */     
/*     */ 
/* 100 */     MarketManager.logger.info(logs);
/*     */     
/* 102 */     OnlineManager.getInstance().send(this.roleId, res);
/* 103 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\market\main\PQueryMarketPubItemByPage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */