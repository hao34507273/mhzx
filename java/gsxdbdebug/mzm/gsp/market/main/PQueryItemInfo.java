/*    */ package mzm.gsp.market.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.gsp.item.main.ItemInterface;
/*    */ import mzm.gsp.market.SQueryItemInfoRes;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import xbean.AuctionItemInfo;
/*    */ import xbean.MarketItem;
/*    */ import xbean.RoleMarketInfo;
/*    */ import xtable.Marketitemid2auction;
/*    */ import xtable.Role2marketinfo;
/*    */ 
/*    */ public class PQueryItemInfo extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private long roleId;
/*    */   private long marketId;
/*    */   private int itemId;
/*    */   
/*    */   public PQueryItemInfo(long roleId, long marketId, int itemId, int price)
/*    */   {
/* 21 */     this.roleId = roleId;
/* 22 */     this.marketId = marketId;
/* 23 */     this.itemId = itemId;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 30 */     if (!MarketInterface.isRoleStateCanOperateMarket(this.roleId))
/*    */     {
/* 32 */       String logStr = String.format("[market]PQueryItemInfo.processImp@role state can not operate market|roleid=%d", new Object[] { Long.valueOf(this.roleId) });
/*    */       
/* 34 */       MarketManager.logger.info(logStr);
/* 35 */       return false;
/*    */     }
/*    */     
/* 38 */     xdb.Lockeys.lock(Role2marketinfo.getTable(), java.util.Arrays.asList(new Long[] { Long.valueOf(this.roleId) }));
/* 39 */     if (this.itemId <= 0)
/*    */     {
/* 41 */       return false;
/*    */     }
/* 43 */     if (!MarketManager.isMarketSwitchOpenForRole(this.roleId))
/*    */     {
/*    */ 
/* 46 */       return false;
/*    */     }
/* 48 */     if (!MarketManager.isMarketOpen(this.roleId))
/*    */     {
/* 50 */       return false;
/*    */     }
/* 52 */     SQueryItemInfoRes res = new SQueryItemInfoRes();
/* 53 */     res.itemid = this.itemId;
/* 54 */     res.marketid = this.marketId;
/*    */     
/* 56 */     MarketItem xMarketItem = xtable.Marketitem.select(Long.valueOf(this.marketId));
/* 57 */     AuctionItemInfo xAuctionItemInfo = Marketitemid2auction.select(Long.valueOf(this.marketId));
/* 58 */     if (xMarketItem == null)
/*    */     {
/* 60 */       RoleMarketInfo xRoleMarketInfo = Role2marketinfo.get(Long.valueOf(this.roleId));
/* 61 */       if (xRoleMarketInfo == null)
/*    */       {
/* 63 */         MarketManager.sendCommonError(this.roleId, 7);
/* 64 */         return false;
/*    */       }
/* 66 */       xMarketItem = (MarketItem)xRoleMarketInfo.getMarketid2timeoutorselleditem().get(Long.valueOf(this.marketId));
/* 67 */       if (xMarketItem == null)
/*    */       {
/* 69 */         MarketManager.sendCommonError(this.roleId, 7);
/* 70 */         return false;
/*    */       }
/* 72 */       res.price = xMarketItem.getPrice();
/* 73 */       res.sellerroleid = xMarketItem.getRoleid();
/* 74 */       MarketManager.fillProtocolMarketItem(res.marketitem, this.marketId, xMarketItem, xAuctionItemInfo);
/* 75 */       ItemInterface.fillInItemInfoBean(res.iteminfo, xMarketItem.getItem());
/* 76 */       OnlineManager.getInstance().send(this.roleId, res);
/*    */     }
/*    */     else
/*    */     {
/* 80 */       if (xMarketItem.getItem().getCfgid() != this.itemId)
/*    */       {
/* 82 */         MarketManager.sendCommonError(this.roleId, 7);
/* 83 */         return false;
/*    */       }
/* 85 */       res.price = xMarketItem.getPrice();
/* 86 */       res.sellerroleid = xMarketItem.getRoleid();
/* 87 */       MarketManager.fillProtocolMarketItem(res.marketitem, this.marketId, xMarketItem, xAuctionItemInfo);
/* 88 */       ItemInterface.fillInItemInfoBean(res.iteminfo, xMarketItem.getItem());
/* 89 */       OnlineManager.getInstance().send(this.roleId, res);
/*    */     }
/*    */     
/* 92 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\market\main\PQueryItemInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */