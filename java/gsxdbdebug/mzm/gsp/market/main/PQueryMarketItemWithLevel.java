/*     */ package mzm.gsp.market.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import mzm.gsp.market.PageItemInfo;
/*     */ import mzm.gsp.market.SQueryMarketItemWithLevelRes;
/*     */ import mzm.gsp.market.confbean.SMarketSubTypeCfg;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.AuctionItemInfo;
/*     */ import xtable.Marketitem;
/*     */ import xtable.Marketitemid2auction;
/*     */ 
/*     */ public class PQueryMarketItemWithLevel extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final int subid;
/*     */   private final int pricesort;
/*     */   private int level;
/*     */   private final int pubOrsell;
/*     */   private int pageIndex;
/*     */   
/*     */   public PQueryMarketItemWithLevel(long roleId, int subid, int pricesort, int level, int pubOrsell, int pageIndex)
/*     */   {
/*  25 */     this.roleId = roleId;
/*  26 */     this.subid = subid;
/*  27 */     this.pricesort = pricesort;
/*  28 */     this.level = level;
/*  29 */     this.pubOrsell = pubOrsell;
/*  30 */     this.pageIndex = pageIndex;
/*     */   }
/*     */   
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  37 */     if (this.pageIndex <= 0)
/*     */     {
/*  39 */       return false;
/*     */     }
/*  41 */     if (!MarketInterface.isRoleStateCanOperateMarket(this.roleId))
/*     */     {
/*  43 */       String logStr = String.format("[market]PQueryMarketItemWithLevel.processImp@role state can not operate market|roleid=%d", new Object[] { Long.valueOf(this.roleId) });
/*     */       
/*  45 */       MarketManager.logger.info(logStr);
/*  46 */       return false;
/*     */     }
/*  48 */     if (!MarketManager.isMarketSwitchOpenForRole(this.roleId))
/*     */     {
/*  50 */       return false;
/*     */     }
/*  52 */     SMarketSubTypeCfg marketSubTypeCfg = SMarketSubTypeCfg.get(this.subid);
/*  53 */     if (marketSubTypeCfg == null)
/*     */     {
/*  55 */       return false;
/*     */     }
/*     */     
/*  58 */     if (!MarketManager.isMarketOpen(this.roleId))
/*     */     {
/*  60 */       return false;
/*     */     }
/*  62 */     if (!MarketManager.isItemSubtype(this.subid))
/*     */     {
/*  64 */       return false;
/*     */     }
/*  66 */     if (!MarketManager.isLevelSift(this.subid))
/*     */     {
/*  68 */       return false;
/*     */     }
/*     */     
/*  71 */     if (!MarketManager.isRoleLevelRight(mzm.gsp.role.main.RoleInterface.getLevel(this.roleId), this.subid))
/*     */     {
/*  73 */       return false;
/*     */     }
/*  75 */     this.level = (this.level / marketSubTypeCfg.levelDelta * marketSubTypeCfg.levelDelta);
/*     */     
/*  77 */     SQueryMarketItemWithLevelRes res = new SQueryMarketItemWithLevelRes();
/*     */     
/*  79 */     res.pageresult.subid = this.subid;
/*     */     
/*  81 */     res.level = this.level;
/*     */     
/*  83 */     SubtypeLevelRankManager subtypeLevelSiftRankManager = null;
/*  84 */     if (this.pubOrsell == 0)
/*     */     {
/*  86 */       res.puborsell = 0;
/*  87 */       subtypeLevelSiftRankManager = LevelSiftRankManager.getPubRankManager(this.subid);
/*     */     }
/*     */     else
/*     */     {
/*  91 */       res.puborsell = 1;
/*  92 */       subtypeLevelSiftRankManager = LevelSiftRankManager.getSellRankManager(this.subid);
/*     */     }
/*     */     
/*  95 */     int size = subtypeLevelSiftRankManager.getSize(this.level);
/*  96 */     int pageSize = MarketManager.getPageSize();
/*  97 */     int totalPage = (size - 1) / pageSize + 1;
/*     */     
/*  99 */     if (this.pageIndex > totalPage)
/*     */     {
/* 101 */       this.pageIndex = totalPage;
/*     */     }
/*     */     
/* 104 */     res.pageresult.pageindex = this.pageIndex;
/* 105 */     res.pageresult.totalpagenum = totalPage;
/* 106 */     res.pricesort = this.pricesort;
/*     */     
/* 108 */     List<MarketLevelPriceChart> list = subtypeLevelSiftRankManager.getByPage(this.level, this.pageIndex, this.pricesort == 0);
/*     */     
/* 110 */     String logs = String.format("[market]PQueryMarketItemWithLevel.processImp@query item by page req|roleid=%d|subId=%d|pricesort=%d|pageIndex=%d|totalpage=%d|pageSize=%d|level=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.subid), Integer.valueOf(this.pricesort), Integer.valueOf(this.pageIndex), Integer.valueOf(totalPage), Integer.valueOf(list.size()), Integer.valueOf(this.level) });
/*     */     
/*     */ 
/* 113 */     MarketManager.logger.info(logs);
/*     */     
/* 115 */     for (MarketLevelPriceChart m : list)
/*     */     {
/* 117 */       xbean.MarketItem xMarketItem = Marketitem.select(Long.valueOf(m.getMarketId()));
/* 118 */       AuctionItemInfo xAuctionItemInfo = Marketitemid2auction.select(Long.valueOf(m.getMarketId()));
/* 119 */       if (xMarketItem == null)
/*     */       {
/* 121 */         logs = String.format("[market]PQueryMarketItemWithLevel.processImp@xMarketItem null|roleid=%d|subId=%d|pricesort=%d|pageIndex=%d|marketId=%d|price=%d|level=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.subid), Integer.valueOf(this.pricesort), Integer.valueOf(this.pageIndex), Long.valueOf(m.getMarketId()), Integer.valueOf(m.getPrice()), Integer.valueOf(m.getLevel()) });
/*     */         
/*     */ 
/* 124 */         MarketManager.logger.warn(logs);
/*     */       }
/*     */       else
/*     */       {
/* 128 */         mzm.gsp.market.MarketItem marketItem = new mzm.gsp.market.MarketItem();
/* 129 */         MarketManager.fillProtocolMarketItem(marketItem, m.getMarketId(), xMarketItem, xAuctionItemInfo);
/*     */         
/* 131 */         res.pageresult.marketitemlist.add(marketItem);
/*     */       }
/*     */     }
/* 134 */     logs = String.format("[market]PQueryMarketItemWithLevel.processImp@send query item by page res|roleid=%d|subId=%d|pricesort=%d|pageIndex=%d|totalpage=%d|pageSize=%d|level=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.subid), Integer.valueOf(this.pricesort), Integer.valueOf(this.pageIndex), Integer.valueOf(totalPage), Integer.valueOf(res.pageresult.marketitemlist.size()), Integer.valueOf(this.level) });
/*     */     
/*     */ 
/* 137 */     MarketManager.logger.info(logs);
/*     */     
/* 139 */     OnlineManager.getInstance().send(this.roleId, res);
/* 140 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\market\main\PQueryMarketItemWithLevel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */