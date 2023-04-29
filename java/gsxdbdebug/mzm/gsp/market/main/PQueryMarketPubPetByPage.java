/*     */ package mzm.gsp.market.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import mzm.gsp.market.PagePetInfo;
/*     */ import mzm.gsp.market.SQueryMarketPublicPetRes;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.AuctionPetInfo;
/*     */ 
/*     */ public class PQueryMarketPubPetByPage extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final int subid;
/*     */   private int pageIndex;
/*     */   private int pricesort;
/*     */   
/*     */   public PQueryMarketPubPetByPage(long roleId, int subid, int pricesort, int pageIndex)
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
/*  37 */       String logStr = String.format("[market]PQueryMarketPubPetByPage.processImp@role state can not operate market|roleid=%d", new Object[] { Long.valueOf(this.roleId) });
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
/*  50 */     if (!MarketManager.isPetSubtype(this.subid))
/*     */     {
/*  52 */       return false;
/*     */     }
/*     */     
/*  55 */     if (!MarketManager.isRoleLevelRight(RoleInterface.getLevel(this.roleId), this.subid))
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
/*  67 */     SQueryMarketPublicPetRes res = new SQueryMarketPublicPetRes();
/*  68 */     res.pageresult.totalpagenum = totalPage;
/*  69 */     res.pageresult.pageindex = this.pageIndex;
/*  70 */     res.pageresult.subid = this.subid;
/*  71 */     res.pricesort = this.pricesort;
/*     */     
/*  73 */     List<MarketPriceChart> list = PriceRankManager.getByPage(this.subid, this.pageIndex, true, this.pricesort == 0);
/*     */     
/*  75 */     String logs = String.format("[market]PQueryMarketPubPetByPage.processImp@query pet by page req|roleid=%d|subId=%d|pricesort=%d|pageIndex=%d|totalpage=%d|pageSize=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.subid), Integer.valueOf(this.pricesort), Integer.valueOf(this.pageIndex), Integer.valueOf(totalPage), Integer.valueOf(list.size()) });
/*     */     
/*     */ 
/*  78 */     MarketManager.logger.info(logs);
/*     */     
/*  80 */     for (MarketPriceChart m : list)
/*     */     {
/*  82 */       xbean.MarketPet xMarketPet = xtable.Marketpet.select(Long.valueOf(m.getMarketId()));
/*  83 */       AuctionPetInfo xAuctionPetInfo = xtable.Marketpetid2auction.select(Long.valueOf(m.getMarketId()));
/*  84 */       if (xMarketPet == null)
/*     */       {
/*  86 */         logs = String.format("[market]PQueryMarketPubPetByPage.processImp@xMarketPet null|roleid=%d|subId=%d|pricesort=%d|pageIndex=%d|marketId=%d|price=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.subid), Integer.valueOf(this.pricesort), Integer.valueOf(this.pageIndex), Long.valueOf(m.getMarketId()), Integer.valueOf(m.getPrice()) });
/*     */         
/*     */ 
/*  89 */         MarketManager.logger.warn(logs);
/*     */       }
/*     */       else
/*     */       {
/*  93 */         mzm.gsp.market.MarketPet marketPet = new mzm.gsp.market.MarketPet();
/*  94 */         MarketManager.fillProtocolMarketPet(marketPet, m.getMarketId(), xMarketPet, xAuctionPetInfo);
/*     */         
/*  96 */         res.pageresult.marketpetlist.add(marketPet);
/*     */       }
/*     */     }
/*  99 */     logs = String.format("[market]PQueryMarketPubPetByPage.processImp@send query pet by page res|roleid=%d|subId=%d|pricesort=%d|pageIndex=%d|totalpage=%d|pageSize=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.subid), Integer.valueOf(this.pricesort), Integer.valueOf(this.pageIndex), Integer.valueOf(totalPage), Integer.valueOf(res.pageresult.marketpetlist.size()) });
/*     */     
/*     */ 
/* 102 */     MarketManager.logger.info(logs);
/*     */     
/* 104 */     OnlineManager.getInstance().send(this.roleId, res);
/* 105 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\market\main\PQueryMarketPubPetByPage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */