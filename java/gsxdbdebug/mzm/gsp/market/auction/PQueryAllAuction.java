/*     */ package mzm.gsp.market.auction;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import mzm.gsp.market.AuctionItem;
/*     */ import mzm.gsp.market.SSynRoleAuctionInfo;
/*     */ import mzm.gsp.market.main.MarketInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.AuctionItemInfo;
/*     */ import xbean.AuctionPetInfo;
/*     */ import xbean.RoleAuctionInfo;
/*     */ 
/*     */ public class PQueryAllAuction extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   
/*     */   public PQueryAllAuction(long roleId)
/*     */   {
/*  23 */     this.roleId = roleId;
/*     */   }
/*     */   
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  30 */     if (!MarketInterface.isMarketSwitchOpenForRole(this.roleId))
/*     */     {
/*  32 */       return false;
/*     */     }
/*  34 */     if (!MarketInterface.isRoleStateCanOperateMarket(this.roleId))
/*     */     {
/*  36 */       String logStr = String.format("[marketauction]PQueryAllAuction.processImp@role state can not operate market|roleid=%d", new Object[] { Long.valueOf(this.roleId) });
/*     */       
/*  38 */       MarketInterface.getLogger().info(logStr);
/*  39 */       return false;
/*     */     }
/*  41 */     if (!MarketInterface.isMarketOpen(this.roleId))
/*     */     {
/*  43 */       return false;
/*     */     }
/*  45 */     SSynRoleAuctionInfo res = new SSynRoleAuctionInfo();
/*     */     
/*  47 */     RoleAuctionInfo xRoleAuctionInfo = xtable.Role2auctioninfo.get(Long.valueOf(this.roleId));
/*  48 */     if (xRoleAuctionInfo == null)
/*     */     {
/*  50 */       OnlineManager.getInstance().send(this.roleId, res);
/*  51 */       return true;
/*     */     }
/*  53 */     Set<Long> toremove = new java.util.HashSet();
/*  54 */     for (Iterator i$ = xRoleAuctionInfo.getAuction_item_ids().iterator(); i$.hasNext();) { long marketId = ((Long)i$.next()).longValue();
/*     */       
/*  56 */       AuctionItemInfo xAuctionInfo = xtable.Marketitemid2auction.select(Long.valueOf(marketId));
/*  57 */       if (xAuctionInfo == null)
/*     */       {
/*  59 */         String logStr = String.format("[marketauction]PQueryAllAuction.processImp@ xbean.AuctionItemInfo error ,null|roleid=%d|marketId=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(marketId) });
/*     */         
/*     */ 
/*  62 */         MarketInterface.getLogger().info(logStr);
/*  63 */         toremove.add(Long.valueOf(marketId));
/*     */       }
/*     */       else
/*     */       {
/*  67 */         mzm.gsp.market.MarketItem marketItem = new mzm.gsp.market.MarketItem();
/*  68 */         marketItem.itemid = xAuctionInfo.getItemid();
/*  69 */         marketItem.marketid = marketId;
/*  70 */         marketItem.concernrolenum = xAuctionInfo.getAuctioncount();
/*  71 */         marketItem.state = (xRoleAuctionInfo.getMarketid2auctionitem().containsKey(Long.valueOf(marketId)) ? 4 : 17);
/*     */         
/*  73 */         marketItem.price = xAuctionInfo.getAuctionprice();
/*  74 */         marketItem.publicendtime = TimeUnit.MILLISECONDS.toSeconds(xAuctionInfo.getEndtime());
/*  75 */         marketItem.restnum = xAuctionInfo.getItemnum();
/*  76 */         marketItem.sellnum = 0;
/*  77 */         AuctionItem auctionItem = new AuctionItem(marketItem, xAuctionInfo.getAuctionroleid() == this.roleId ? 1 : 0);
/*  78 */         res.marketitemlist.add(auctionItem);
/*     */       } }
/*  80 */     xRoleAuctionInfo.getAuction_item_ids().removeAll(toremove);
/*     */     
/*  82 */     toremove.clear();
/*  83 */     for (Iterator i$ = xRoleAuctionInfo.getAuction_pet_ids().iterator(); i$.hasNext();) { long marketId = ((Long)i$.next()).longValue();
/*     */       
/*  85 */       AuctionPetInfo xAuctionInfo = xtable.Marketpetid2auction.select(Long.valueOf(marketId));
/*     */       
/*  87 */       if (xAuctionInfo == null)
/*     */       {
/*  89 */         String logStr = String.format("[marketauction]PQueryAllAuction.processImp@xbean.AuctionPetInfo error ,null|roleid=%d|marketId=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(marketId) });
/*     */         
/*     */ 
/*  92 */         MarketInterface.getLogger().error(logStr);
/*  93 */         toremove.add(Long.valueOf(marketId));
/*     */       }
/*     */       else
/*     */       {
/*  97 */         mzm.gsp.market.MarketPet marketPet = new mzm.gsp.market.MarketPet();
/*  98 */         marketPet.petcfgid = xAuctionInfo.getPetcfgid();
/*  99 */         marketPet.marketid = marketId;
/* 100 */         marketPet.concernrolenum = xAuctionInfo.getAuctioncount();
/* 101 */         marketPet.state = (xRoleAuctionInfo.getMarketid2auctionpet().containsKey(Long.valueOf(marketId)) ? 4 : 17);
/*     */         
/* 103 */         marketPet.price = xAuctionInfo.getAuctionprice();
/* 104 */         marketPet.publicendtime = TimeUnit.MILLISECONDS.toSeconds(xAuctionInfo.getEndtime());
/* 105 */         marketPet.petlevel = 0;
/* 106 */         mzm.gsp.market.AuctionPet auctionPet = new mzm.gsp.market.AuctionPet(marketPet, xAuctionInfo.getAuctionroleid() == this.roleId ? 1 : 0);
/* 107 */         res.marketpetlist.add(auctionPet);
/*     */       } }
/* 109 */     xRoleAuctionInfo.getAuction_pet_ids().removeAll(toremove);
/* 110 */     OnlineManager.getInstance().send(this.roleId, res);
/* 111 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\market\auction\PQueryAllAuction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */