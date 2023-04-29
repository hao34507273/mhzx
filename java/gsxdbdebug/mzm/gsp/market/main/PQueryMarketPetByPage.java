/*     */ package mzm.gsp.market.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import mzm.gsp.market.PagePetInfo;
/*     */ import mzm.gsp.market.SQueryMarketPetRes;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.AuctionPetInfo;
/*     */ 
/*     */ public class PQueryMarketPetByPage extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final int subid;
/*     */   private final int pricesort;
/*     */   private int pageIndex;
/*     */   
/*     */   public PQueryMarketPetByPage(long roleId, int subid, int pricesort, int pageIndex)
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
/*  37 */       String logStr = String.format("[market]PQueryMarketPetByPage.processImp@role state can not operate market|roleid=%d", new Object[] { Long.valueOf(this.roleId) });
/*     */       
/*  39 */       MarketManager.logger.info(logStr);
/*  40 */       return false;
/*     */     }
/*  42 */     if (!MarketManager.isMarketSwitchOpenForRole(this.roleId))
/*     */     {
/*  44 */       return false;
/*     */     }
/*  46 */     if (!MarketManager.isPetSubtype(this.subid))
/*     */     {
/*  48 */       return false;
/*     */     }
/*  50 */     if (!MarketManager.isMarketOpen(this.roleId))
/*     */     {
/*  52 */       return false;
/*     */     }
/*  54 */     if (!MarketManager.isRoleLevelRight(RoleInterface.getLevel(this.roleId), this.subid))
/*     */     {
/*  56 */       return false;
/*     */     }
/*     */     
/*  59 */     int size = PriceRankManager.getSellSize(this.subid);
/*  60 */     int pageSize = MarketManager.getPageSize();
/*  61 */     int totalPage = (size - 1) / pageSize + 1;
/*  62 */     if (this.pageIndex > totalPage)
/*     */     {
/*  64 */       this.pageIndex = totalPage;
/*     */     }
/*  66 */     SQueryMarketPetRes res = new SQueryMarketPetRes();
/*  67 */     res.pageresult.totalpagenum = totalPage;
/*  68 */     res.pageresult.pageindex = this.pageIndex;
/*  69 */     res.pageresult.subid = this.subid;
/*  70 */     res.pricesort = this.pricesort;
/*  71 */     List<MarketPriceChart> list = PriceRankManager.getByPage(this.subid, this.pageIndex, false, this.pricesort == 0);
/*     */     
/*  73 */     String logs = String.format("[market]PQueryMarketPetByPage.processImp@query pet by page req|roleid=%d|subId=%d|pricesort=%d|pageIndex=%d|totalpage=%d|pageSize=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.subid), Integer.valueOf(this.pricesort), Integer.valueOf(this.pageIndex), Integer.valueOf(totalPage), Integer.valueOf(list.size()) });
/*     */     
/*     */ 
/*  76 */     MarketManager.logger.info(logs);
/*     */     
/*  78 */     for (MarketPriceChart m : list)
/*     */     {
/*  80 */       xbean.MarketPet xMarketPet = xtable.Marketpet.select(Long.valueOf(m.getMarketId()));
/*  81 */       AuctionPetInfo xAuctionPetInfo = xtable.Marketpetid2auction.select(Long.valueOf(m.getMarketId()));
/*  82 */       if (xMarketPet == null)
/*     */       {
/*  84 */         logs = String.format("[market]PQueryMarketPetByPage.processImp@xMarketPet null|roleid=%d|subId=%d|pricesort=%d|pageIndex=%d|marketId=%d|price=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.subid), Integer.valueOf(this.pricesort), Integer.valueOf(this.pageIndex), Long.valueOf(m.getMarketId()), Integer.valueOf(m.getPrice()) });
/*     */         
/*     */ 
/*  87 */         MarketManager.logger.warn(logs);
/*     */ 
/*     */       }
/*     */       else
/*     */       {
/*  92 */         mzm.gsp.market.MarketPet marketPet = new mzm.gsp.market.MarketPet();
/*  93 */         MarketManager.fillProtocolMarketPet(marketPet, m.getMarketId(), xMarketPet, xAuctionPetInfo);
/*     */         
/*  95 */         res.pageresult.marketpetlist.add(marketPet);
/*     */       }
/*     */     }
/*  98 */     logs = String.format("[market]PQueryMarketPetByPage.processImp@send query pet by page res|roleid=%d|subId=%d|pricesort=%d|pageIndex=%d|totalpage=%d|pageSize=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.subid), Integer.valueOf(this.pricesort), Integer.valueOf(this.pageIndex), Integer.valueOf(totalPage), Integer.valueOf(res.pageresult.marketpetlist.size()) });
/*     */     
/*     */ 
/* 101 */     MarketManager.logger.info(logs);
/*     */     
/* 103 */     OnlineManager.getInstance().send(this.roleId, res);
/* 104 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\market\main\PQueryMarketPetByPage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */