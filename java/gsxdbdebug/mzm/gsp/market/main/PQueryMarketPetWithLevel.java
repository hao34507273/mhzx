/*     */ package mzm.gsp.market.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import mzm.gsp.market.PagePetInfo;
/*     */ import mzm.gsp.market.SQueryMarketPetWithLevelRes;
/*     */ import mzm.gsp.market.confbean.SMarketSubTypeCfg;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.AuctionPetInfo;
/*     */ import xtable.Marketpetid2auction;
/*     */ 
/*     */ public class PQueryMarketPetWithLevel extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final int subid;
/*     */   private final int pricesort;
/*     */   private int level;
/*     */   private final int pubOrsell;
/*     */   private int pageIndex;
/*     */   
/*     */   public PQueryMarketPetWithLevel(long roleId, int subid, int pricesort, int level, int pubOrsell, int pageIndex)
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
/*  43 */       String logStr = String.format("[market]PQueryMarketPetWithLevel.processImp@role state can not operate market|roleid=%d", new Object[] { Long.valueOf(this.roleId) });
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
/*  62 */     if (!MarketManager.isPetSubtype(this.subid))
/*     */     {
/*  64 */       return false;
/*     */     }
/*  66 */     if (!MarketManager.isLevelSift(this.subid))
/*     */     {
/*  68 */       return false;
/*     */     }
/*     */     
/*  71 */     if (!MarketManager.isRoleLevelRight(RoleInterface.getLevel(this.roleId), this.subid))
/*     */     {
/*  73 */       return false;
/*     */     }
/*     */     
/*  76 */     this.level = (this.level / marketSubTypeCfg.levelDelta * marketSubTypeCfg.levelDelta);
/*     */     
/*  78 */     SQueryMarketPetWithLevelRes res = new SQueryMarketPetWithLevelRes();
/*     */     
/*  80 */     res.pageresult.subid = this.subid;
/*     */     
/*  82 */     res.level = this.level;
/*     */     
/*  84 */     SubtypeLevelRankManager subtypeLevelSiftRankManager = null;
/*  85 */     if (this.pubOrsell == 0)
/*     */     {
/*  87 */       res.puborsell = 0;
/*  88 */       subtypeLevelSiftRankManager = LevelSiftRankManager.getPubRankManager(this.subid);
/*     */     }
/*     */     else
/*     */     {
/*  92 */       res.puborsell = 1;
/*  93 */       subtypeLevelSiftRankManager = LevelSiftRankManager.getSellRankManager(this.subid);
/*     */     }
/*     */     
/*  96 */     int size = subtypeLevelSiftRankManager.getSize(this.level);
/*  97 */     int pageSize = MarketManager.getPageSize();
/*  98 */     int totalPage = (size - 1) / pageSize + 1;
/*     */     
/* 100 */     if (this.pageIndex > totalPage)
/*     */     {
/* 102 */       this.pageIndex = totalPage;
/*     */     }
/*     */     
/* 105 */     res.pageresult.pageindex = this.pageIndex;
/* 106 */     res.pageresult.totalpagenum = totalPage;
/* 107 */     res.pricesort = this.pricesort;
/*     */     
/* 109 */     List<MarketLevelPriceChart> list = subtypeLevelSiftRankManager.getByPage(this.level, this.pageIndex, this.pricesort == 0);
/*     */     
/* 111 */     String logs = String.format("[market]PQueryMarketPetWithLevel.processImp@query pet by page req|roleid=%d|subId=%d|pricesort=%d|pageIndex=%d|totalpage=%d|pageSize=%d|level=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.subid), Integer.valueOf(this.pricesort), Integer.valueOf(this.pageIndex), Integer.valueOf(totalPage), Integer.valueOf(list.size()), Integer.valueOf(this.level) });
/*     */     
/*     */ 
/* 114 */     MarketManager.logger.info(logs);
/*     */     
/* 116 */     for (MarketLevelPriceChart m : list)
/*     */     {
/* 118 */       xbean.MarketPet xMarketPet = xtable.Marketpet.select(Long.valueOf(m.getMarketId()));
/* 119 */       AuctionPetInfo xAuctionPetInfo = Marketpetid2auction.select(Long.valueOf(m.getMarketId()));
/* 120 */       if (xMarketPet == null)
/*     */       {
/* 122 */         logs = String.format("[market]PQueryMarketPetWithLevel.processImp@xMarketPet null|roleid=%d|subId=%d|pricesort=%d|pageIndex=%d|marketId=%d|price=%d|level=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.subid), Integer.valueOf(this.pricesort), Integer.valueOf(this.pageIndex), Long.valueOf(m.getMarketId()), Integer.valueOf(m.getPrice()), Integer.valueOf(m.getLevel()) });
/*     */         
/*     */ 
/* 125 */         MarketManager.logger.warn(logs);
/*     */       }
/*     */       else
/*     */       {
/* 129 */         mzm.gsp.market.MarketPet marketPet = new mzm.gsp.market.MarketPet();
/* 130 */         MarketManager.fillProtocolMarketPet(marketPet, m.getMarketId(), xMarketPet, xAuctionPetInfo);
/*     */         
/* 132 */         res.pageresult.marketpetlist.add(marketPet);
/*     */       }
/*     */     }
/* 135 */     logs = String.format("[market]PQueryMarketPetWithLevel.processImp@send query pet by page res|roleid=%d|subId=%d|pricesort=%d|pageIndex=%d|totalpage=%d|pageSize=%d|level=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.subid), Integer.valueOf(this.pricesort), Integer.valueOf(this.pageIndex), Integer.valueOf(totalPage), Integer.valueOf(res.pageresult.marketpetlist.size()), Integer.valueOf(this.level) });
/*     */     
/*     */ 
/* 138 */     MarketManager.logger.info(logs);
/*     */     
/* 140 */     OnlineManager.getInstance().send(this.roleId, res);
/* 141 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\market\main\PQueryMarketPetWithLevel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */