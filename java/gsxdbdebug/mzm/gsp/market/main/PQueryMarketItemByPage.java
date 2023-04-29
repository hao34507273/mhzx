/*     */ package mzm.gsp.market.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import mzm.gsp.market.PageItemInfo;
/*     */ import mzm.gsp.market.SQueryMarketItemRes;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.AuctionItemInfo;
/*     */ import xtable.Marketitemid2auction;
/*     */ 
/*     */ public class PQueryMarketItemByPage extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final int subid;
/*     */   private final int pricesort;
/*     */   private int pageIndex;
/*     */   
/*     */   public PQueryMarketItemByPage(long roleId, int subid, int pricesort, int pageIndex)
/*     */   {
/*  21 */     this.roleId = roleId;
/*  22 */     this.subid = subid;
/*  23 */     this.pricesort = pricesort;
/*  24 */     this.pageIndex = pageIndex;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  32 */     if (this.pageIndex <= 0)
/*     */     {
/*  34 */       return false;
/*     */     }
/*  36 */     if (!MarketInterface.isRoleStateCanOperateMarket(this.roleId))
/*     */     {
/*  38 */       String logStr = String.format("[market]PQueryMarketItemByPage.processImp@role state can not operate market|roleid=%d", new Object[] { Long.valueOf(this.roleId) });
/*     */       
/*  40 */       MarketManager.logger.info(logStr);
/*  41 */       return false;
/*     */     }
/*     */     
/*  44 */     if (!MarketManager.isMarketSwitchOpenForRole(this.roleId))
/*     */     {
/*     */ 
/*  47 */       return false;
/*     */     }
/*  49 */     if (!MarketManager.isMarketOpen(this.roleId))
/*     */     {
/*  51 */       return false;
/*     */     }
/*  53 */     if (!MarketManager.isItemSubtype(this.subid))
/*     */     {
/*  55 */       return false;
/*     */     }
/*     */     
/*  58 */     if (!MarketManager.isRoleLevelRight(mzm.gsp.role.main.RoleInterface.getLevel(this.roleId), this.subid))
/*     */     {
/*  60 */       return false;
/*     */     }
/*     */     
/*  63 */     int size = PriceRankManager.getSellSize(this.subid);
/*     */     
/*  65 */     int pageSize = MarketManager.getPageSize();
/*  66 */     int totalPage = (size - 1) / pageSize + 1;
/*  67 */     if (this.pageIndex > totalPage)
/*     */     {
/*  69 */       this.pageIndex = totalPage;
/*     */     }
/*  71 */     SQueryMarketItemRes res = new SQueryMarketItemRes();
/*  72 */     res.pageresult.totalpagenum = totalPage;
/*  73 */     res.pageresult.pageindex = this.pageIndex;
/*  74 */     res.pageresult.subid = this.subid;
/*  75 */     res.pricesort = this.pricesort;
/*     */     
/*  77 */     List<MarketPriceChart> list = PriceRankManager.getByPage(this.subid, this.pageIndex, false, this.pricesort == 0);
/*     */     
/*  79 */     String logs = String.format("[market]PQueryMarketItemByPage.processImp@query item by page req|roleid=%d|subId=%d|pricesort=%d|pageIndex=%d|totalpage=%d|pageSize=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.subid), Integer.valueOf(this.pricesort), Integer.valueOf(this.pageIndex), Integer.valueOf(totalPage), Integer.valueOf(list.size()) });
/*     */     
/*     */ 
/*  82 */     MarketManager.logger.info(logs);
/*     */     
/*  84 */     for (MarketPriceChart m : list)
/*     */     {
/*  86 */       xbean.MarketItem xMarketItem = xtable.Marketitem.select(Long.valueOf(m.getMarketId()));
/*  87 */       AuctionItemInfo xAuctionItemInfo = Marketitemid2auction.select(Long.valueOf(m.getMarketId()));
/*  88 */       if (xMarketItem == null)
/*     */       {
/*  90 */         logs = String.format("[market]PQueryMarketItemByPage.processImp@xMarketItem null|roleid=%d|subId=%d|pricesort=%d|pageIndex=%d|marketId=%d|price=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.subid), Integer.valueOf(this.pricesort), Integer.valueOf(this.pageIndex), Long.valueOf(m.getMarketId()), Integer.valueOf(m.getPrice()) });
/*     */         
/*     */ 
/*  93 */         MarketManager.logger.warn(logs);
/*     */       }
/*     */       else {
/*  96 */         mzm.gsp.market.MarketItem marketItem = new mzm.gsp.market.MarketItem();
/*  97 */         MarketManager.fillProtocolMarketItem(marketItem, m.getMarketId(), xMarketItem, xAuctionItemInfo);
/*     */         
/*  99 */         res.pageresult.marketitemlist.add(marketItem);
/*     */       }
/*     */     }
/* 102 */     logs = String.format("[market]PQueryMarketItemByPage.processImp@send query item by page res|roleid=%d|subId=%d|pricesort=%d|pageIndex=%d|totalpage=%d|pageSize=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.subid), Integer.valueOf(this.pricesort), Integer.valueOf(this.pageIndex), Integer.valueOf(totalPage), Integer.valueOf(res.pageresult.marketitemlist.size()) });
/*     */     
/*     */ 
/* 105 */     MarketManager.logger.info(logs);
/*     */     
/* 107 */     OnlineManager.getInstance().send(this.roleId, res);
/* 108 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\market\main\PQueryMarketItemByPage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */