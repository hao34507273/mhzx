/*    */ package mzm.gsp.market.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import mzm.gsp.market.SSynRoleConcernInfo;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import xbean.AuctionItemInfo;
/*    */ import xbean.AuctionPetInfo;
/*    */ import xbean.RoleMarketInfo;
/*    */ import xtable.Marketitem;
/*    */ import xtable.Marketitemid2auction;
/*    */ 
/*    */ public class PQueryAllConcernReq extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   
/*    */   public PQueryAllConcernReq(long roleid)
/*    */   {
/* 20 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 26 */     if (!MarketInterface.isRoleStateCanOperateMarket(this.roleid))
/*    */     {
/* 28 */       String logStr = String.format("[market]PQueryAllConcernReq.processImp@role state can not operate market|roleid=%d", new Object[] { Long.valueOf(this.roleid) });
/*    */       
/* 30 */       MarketManager.logger.info(logStr);
/* 31 */       return false;
/*    */     }
/* 33 */     if (!MarketManager.isMarketSwitchOpenForRole(this.roleid))
/*    */     {
/* 35 */       return false;
/*    */     }
/* 37 */     if (!MarketManager.isMarketOpen(this.roleid))
/*    */     {
/* 39 */       return false;
/*    */     }
/* 41 */     RoleMarketInfo xRoleMarketInfo = xtable.Role2marketinfo.get(Long.valueOf(this.roleid));
/* 42 */     if (xRoleMarketInfo == null)
/*    */     {
/* 44 */       return false;
/*    */     }
/*    */     
/* 47 */     SSynRoleConcernInfo res = new SSynRoleConcernInfo();
/*    */     
/* 49 */     List<Long> toRemoveItemList = new ArrayList();
/* 50 */     for (Iterator i$ = xRoleMarketInfo.getConcern_item_ids().iterator(); i$.hasNext();) { long marketId = ((Long)i$.next()).longValue();
/*    */       
/* 52 */       xbean.MarketItem xMarketItem = Marketitem.select(Long.valueOf(marketId));
/* 53 */       AuctionItemInfo xAuctionItemInfo = Marketitemid2auction.select(Long.valueOf(marketId));
/* 54 */       if ((xMarketItem == null) || (xMarketItem.getRest_num() == 0) || (xMarketItem.getState() == 4) || (MarketManager.hasState(xMarketItem.getState(), 8)))
/*    */       {
/*    */ 
/* 57 */         toRemoveItemList.add(Long.valueOf(marketId));
/*    */       }
/*    */       else
/*    */       {
/* 61 */         mzm.gsp.market.MarketItem marketItem = new mzm.gsp.market.MarketItem();
/* 62 */         MarketManager.fillProtocolMarketItem(marketItem, marketId, xMarketItem, xAuctionItemInfo);
/* 63 */         res.marketitemlist.add(marketItem);
/*    */       } }
/* 65 */     xRoleMarketInfo.getConcern_item_ids().removeAll(toRemoveItemList);
/*    */     
/* 67 */     List<Long> toRemovePetList = new ArrayList();
/* 68 */     for (Iterator i$ = xRoleMarketInfo.getConcern_pet_ids().iterator(); i$.hasNext();) { long marketId = ((Long)i$.next()).longValue();
/*    */       
/* 70 */       xbean.MarketPet xMarketPet = xtable.Marketpet.select(Long.valueOf(marketId));
/* 71 */       AuctionPetInfo xAuctionPetInfo = xtable.Marketpetid2auction.select(Long.valueOf(marketId));
/* 72 */       if ((xMarketPet == null) || (xMarketPet.getState() == 4) || (xMarketPet.getState() == 8))
/*    */       {
/*    */ 
/* 75 */         toRemovePetList.add(Long.valueOf(marketId));
/*    */       }
/*    */       else {
/* 78 */         mzm.gsp.market.MarketPet marketPet = new mzm.gsp.market.MarketPet();
/* 79 */         MarketManager.fillProtocolMarketPet(marketPet, marketId, xMarketPet, xAuctionPetInfo);
/* 80 */         res.marketpetlist.add(marketPet);
/*    */       } }
/* 82 */     xRoleMarketInfo.getConcern_pet_ids().removeAll(toRemovePetList);
/* 83 */     OnlineManager.getInstance().send(this.roleid, res);
/*    */     
/* 85 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\market\main\PQueryAllConcernReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */