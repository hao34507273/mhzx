/*    */ package mzm.gsp.market.auction;
/*    */ 
/*    */ import mzm.gsp.market.main.MarketInterface;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.AuctionPetInfo;
/*    */ import xbean.RoleAuctionInfo;
/*    */ 
/*    */ public class PDeletePetAuction extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final long marketId;
/*    */   
/*    */   public PDeletePetAuction(long roleId, long marketId)
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
/* 24 */     String log = String.format("[marketauction]PDeletePetAuction.processImp@receive delete auction pet req|roleid=%d|marketId=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.marketId) });
/*    */     
/*    */ 
/* 27 */     MarketInterface.getLogger().info(log);
/*    */     
/* 29 */     if (!MarketInterface.isRoleStateCanOperateMarket(this.roleId))
/*    */     {
/* 31 */       String logStr = String.format("[marketauction]PDeletePetAuction.processImp@role state can not operate market|roleid=%d", new Object[] { Long.valueOf(this.roleId) });
/*    */       
/* 33 */       MarketInterface.getLogger().info(logStr);
/* 34 */       return false;
/*    */     }
/* 36 */     RoleAuctionInfo xRoleAuctionInfo = xtable.Role2auctioninfo.get(Long.valueOf(this.roleId));
/* 37 */     if (xRoleAuctionInfo == null)
/*    */     {
/* 39 */       return false;
/*    */     }
/*    */     
/* 42 */     if (!xRoleAuctionInfo.getAuction_pet_ids().contains(Long.valueOf(this.marketId)))
/*    */     {
/* 44 */       return false;
/*    */     }
/* 46 */     AuctionPetInfo xAuctionPetInfo = xtable.Marketpetid2auction.get(Long.valueOf(this.marketId));
/* 47 */     if ((xAuctionPetInfo != null) && (xAuctionPetInfo.getAuctionroleid() == this.roleId))
/*    */     {
/* 49 */       log = String.format("[marketauction]PDeletePetAuction.processImp@max price roleid，can not delete|roleid=%d|marketId=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.marketId) });
/*    */       
/*    */ 
/* 52 */       MarketInterface.getLogger().info(log);
/*    */       
/* 54 */       return false;
/*    */     }
/* 56 */     xAuctionPetInfo.getAuctionroleset().remove(Long.valueOf(this.roleId));
/* 57 */     xRoleAuctionInfo.getAuction_pet_ids().remove(Long.valueOf(this.marketId));
/*    */     
/* 59 */     mzm.gsp.market.SDeletePetAuctionRes res = new mzm.gsp.market.SDeletePetAuctionRes();
/* 60 */     res.marketid = this.marketId;
/*    */     
/* 62 */     mzm.gsp.online.main.OnlineManager.getInstance().send(this.roleId, res);
/* 63 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\market\auction\PDeletePetAuction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */