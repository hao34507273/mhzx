/*    */ package mzm.gsp.market.auction;
/*    */ 
/*    */ import mzm.gsp.market.SQueryAuctionConcernNumRes;
/*    */ import mzm.gsp.market.main.MarketInterface;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import xtable.Marketitemid2auction;
/*    */ 
/*    */ public class PQueryAuctionConcernNumReq extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final long marketId;
/*    */   private final int itemOrPet;
/*    */   
/*    */   public PQueryAuctionConcernNumReq(long roleId, long marketId, int itemOrPet)
/*    */   {
/* 16 */     this.roleId = roleId;
/* 17 */     this.marketId = marketId;
/* 18 */     this.itemOrPet = itemOrPet;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 25 */     if (!MarketInterface.isRoleStateCanOperateMarket(this.roleId))
/*    */     {
/* 27 */       String logStr = String.format("[marketauction]PQueryAuctionConcernNumReq.processImp@role state can not operate market|roleid=%d", new Object[] { Long.valueOf(this.roleId) });
/*    */       
/* 29 */       MarketInterface.getLogger().info(logStr);
/* 30 */       return false;
/*    */     }
/*    */     
/* 33 */     if (!MarketInterface.isMarketSwitchOpenForRole(this.roleId))
/*    */     {
/* 35 */       return false;
/*    */     }
/* 37 */     if (!MarketInterface.isMarketOpen(this.roleId))
/*    */     {
/* 39 */       return false;
/*    */     }
/* 41 */     SQueryAuctionConcernNumRes res = new SQueryAuctionConcernNumRes();
/*    */     
/* 43 */     res.itemorpet = this.itemOrPet;
/* 44 */     res.marketid = this.marketId;
/* 45 */     if (this.itemOrPet == 0)
/*    */     {
/* 47 */       Integer concernNum = xtable.Marketitem.selectConcern_role_num(Long.valueOf(this.marketId));
/* 48 */       Integer auctionNum = Marketitemid2auction.selectAuctioncount(Long.valueOf(this.marketId));
/*    */       
/* 50 */       if (concernNum != null)
/*    */       {
/* 52 */         res.concernnum = concernNum.intValue();
/*    */       }
/*    */       
/* 55 */       if (auctionNum != null)
/*    */       {
/* 57 */         res.auctionnum = auctionNum.intValue();
/*    */       }
/*    */       
/*    */     }
/*    */     else
/*    */     {
/* 63 */       Integer concernNum = xtable.Marketpet.selectConcern_role_num(Long.valueOf(this.marketId));
/* 64 */       Integer auctionNum = xtable.Marketpetid2auction.selectAuctioncount(Long.valueOf(this.marketId));
/*    */       
/* 66 */       if (concernNum != null)
/*    */       {
/* 68 */         res.concernnum = concernNum.intValue();
/*    */       }
/*    */       
/* 71 */       if (auctionNum != null)
/*    */       {
/* 73 */         res.auctionnum = auctionNum.intValue();
/*    */       }
/*    */     }
/*    */     
/*    */ 
/*    */ 
/* 79 */     OnlineManager.getInstance().send(this.roleId, res);
/*    */     
/* 81 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\market\auction\PQueryAuctionConcernNumReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */