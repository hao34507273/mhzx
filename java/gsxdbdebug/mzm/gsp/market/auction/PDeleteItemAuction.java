/*    */ package mzm.gsp.market.auction;
/*    */ 
/*    */ import mzm.gsp.market.main.MarketInterface;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.AuctionItemInfo;
/*    */ import xbean.RoleAuctionInfo;
/*    */ 
/*    */ public class PDeleteItemAuction extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final long marketId;
/*    */   
/*    */   public PDeleteItemAuction(long roleId, long marketId)
/*    */   {
/* 15 */     this.roleId = roleId;
/* 16 */     this.marketId = marketId;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 24 */     String log = String.format("[marketauction]PDeleteItemAuction.processImp@receive delete auction item req|roleid=%d|marketId=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.marketId) });
/*    */     
/*    */ 
/* 27 */     MarketInterface.getLogger().info(log);
/*    */     
/* 29 */     if (!MarketInterface.isRoleStateCanOperateMarket(this.roleId))
/*    */     {
/* 31 */       String logStr = String.format("[marketauction]PDeleteItemAuction.processImp@role state can not operate market|roleid=%d", new Object[] { Long.valueOf(this.roleId) });
/*    */       
/* 33 */       MarketInterface.getLogger().info(logStr);
/* 34 */       return false;
/*    */     }
/*    */     
/* 37 */     RoleAuctionInfo xRoleAuctionInfo = xtable.Role2auctioninfo.get(Long.valueOf(this.roleId));
/* 38 */     if (xRoleAuctionInfo == null)
/*    */     {
/* 40 */       return false;
/*    */     }
/*    */     
/* 43 */     if (!xRoleAuctionInfo.getAuction_item_ids().contains(Long.valueOf(this.marketId)))
/*    */     {
/* 45 */       return false;
/*    */     }
/* 47 */     AuctionItemInfo xAuctionItemInfo = xtable.Marketitemid2auction.get(Long.valueOf(this.marketId));
/* 48 */     if ((xAuctionItemInfo != null) && (xAuctionItemInfo.getAuctionroleid() == this.roleId))
/*    */     {
/* 50 */       log = String.format("[marketauction]PDeleteItemAuction.processImp@max price roleid，can not delete|roleid=%d|marketId=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.marketId) });
/*    */       
/*    */ 
/* 53 */       MarketInterface.getLogger().info(log);
/* 54 */       return false;
/*    */     }
/* 56 */     xAuctionItemInfo.getAuctionroleset().remove(Long.valueOf(this.roleId));
/* 57 */     xRoleAuctionInfo.getAuction_item_ids().remove(Long.valueOf(this.marketId));
/*    */     
/* 59 */     mzm.gsp.market.SDeleteItemAuctionRes res = new mzm.gsp.market.SDeleteItemAuctionRes();
/* 60 */     res.marketid = this.marketId;
/*    */     
/* 62 */     mzm.gsp.online.main.OnlineManager.getInstance().send(this.roleId, res);
/* 63 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\market\auction\PDeleteItemAuction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */