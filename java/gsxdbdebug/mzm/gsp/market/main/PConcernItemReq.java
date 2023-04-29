/*     */ package mzm.gsp.market.main;
/*     */ 
/*     */ import java.util.List;
/*     */ import mzm.gsp.market.SConcernItemRes;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.ConcernRoleIdSet;
/*     */ import xbean.MarketItem;
/*     */ import xbean.RoleMarketInfo;
/*     */ 
/*     */ public class PConcernItemReq extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private long roleId;
/*     */   private long marketid;
/*     */   private int itemId;
/*     */   
/*     */   public PConcernItemReq(long roleId, long marketid, int itemId)
/*     */   {
/*  18 */     this.roleId = roleId;
/*  19 */     this.marketid = marketid;
/*  20 */     this.itemId = itemId;
/*     */   }
/*     */   
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  27 */     if (!MarketInterface.isRoleStateCanOperateMarket(this.roleId))
/*     */     {
/*  29 */       String logStr = String.format("[market]PConcernItemReq.processImp@role state can not operate market|roleid=%d", new Object[] { Long.valueOf(this.roleId) });
/*     */       
/*  31 */       MarketManager.logger.info(logStr);
/*  32 */       return false;
/*     */     }
/*  34 */     if (!MarketManager.isMarketSwitchOpenForRole(this.roleId))
/*     */     {
/*  36 */       return false;
/*     */     }
/*  38 */     if (!MarketManager.isMarketOpen(this.roleId))
/*     */     {
/*  40 */       return false;
/*     */     }
/*  42 */     RoleMarketInfo xRoleMarketInfo = xtable.Role2marketinfo.get(Long.valueOf(this.roleId));
/*     */     
/*  44 */     if (xRoleMarketInfo == null)
/*     */     {
/*  46 */       xRoleMarketInfo = xbean.Pod.newRoleMarketInfo();
/*  47 */       xtable.Role2marketinfo.insert(Long.valueOf(this.roleId), xRoleMarketInfo);
/*     */     }
/*     */     
/*  50 */     xbean.RoleAuctionInfo xRoleAuctionInfo = xtable.Role2auctioninfo.get(Long.valueOf(this.roleId));
/*  51 */     if ((xRoleAuctionInfo != null) && (xRoleAuctionInfo.getAuction_item_ids().contains(Long.valueOf(this.marketid))))
/*     */     {
/*  53 */       return false;
/*     */     }
/*     */     
/*  56 */     int alreadyConcernNum = xRoleMarketInfo.getConcern_item_ids().size() + xRoleMarketInfo.getConcern_pet_ids().size();
/*  57 */     if (alreadyConcernNum >= MarketManager.getRoleMaxConcernNum())
/*     */     {
/*     */ 
/*  60 */       MarketManager.removeRolecConcernIds(xRoleMarketInfo);
/*  61 */       alreadyConcernNum = xRoleMarketInfo.getConcern_item_ids().size() + xRoleMarketInfo.getConcern_pet_ids().size();
/*  62 */       if (alreadyConcernNum >= MarketManager.getRoleMaxConcernNum())
/*     */       {
/*     */ 
/*  65 */         String logStr = String.format("[market]PConcernItemReq.processImp@market concern num to max |roleid=%d|concernNum=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(alreadyConcernNum) });
/*     */         
/*     */ 
/*  68 */         MarketManager.logger.error(logStr);
/*  69 */         MarketManager.sendCommonError(this.roleId, 12);
/*  70 */         return false;
/*     */       }
/*     */     }
/*     */     
/*  74 */     if (xRoleMarketInfo.getConcern_item_ids().contains(Long.valueOf(this.marketid)))
/*     */     {
/*  76 */       return false;
/*     */     }
/*     */     
/*  79 */     MarketItem xMarketItem = xtable.Marketitem.get(Long.valueOf(this.marketid));
/*  80 */     if ((xMarketItem == null) || (xMarketItem.getRest_num() <= 0))
/*     */     {
/*  82 */       MarketManager.sendCommonError(this.roleId, 7);
/*  83 */       return false;
/*     */     }
/*     */     
/*  86 */     if (xMarketItem.getRoleid() == this.roleId)
/*     */     {
/*  88 */       MarketManager.sendCommonError(this.roleId, 16);
/*  89 */       return false;
/*     */     }
/*  91 */     if (xMarketItem.getItem().getCfgid() != this.itemId)
/*     */     {
/*  93 */       return false;
/*     */     }
/*  95 */     xRoleMarketInfo.getConcern_item_ids().add(Long.valueOf(this.marketid));
/*  96 */     xMarketItem.setConcern_role_num(xMarketItem.getConcern_role_num() + 1);
/*     */     
/*  98 */     SConcernItemRes concernItemRes = new SConcernItemRes();
/*  99 */     xbean.AuctionItemInfo xAuctionItemInfo = xtable.Marketitemid2auction.select(Long.valueOf(this.marketid));
/* 100 */     MarketManager.fillProtocolMarketItem(concernItemRes.concernmarketitem, this.marketid, xMarketItem, xAuctionItemInfo);
/*     */     
/* 102 */     if (MarketManager.hasState(xMarketItem.getState(), 1))
/*     */     {
/* 104 */       ConcernRoleIdSet xConcernRoleIdSet = xtable.Marketitemid2concernrole.get(Long.valueOf(this.marketid));
/* 105 */       if (xConcernRoleIdSet == null)
/*     */       {
/* 107 */         xConcernRoleIdSet = xbean.Pod.newConcernRoleIdSet();
/* 108 */         xtable.Marketitemid2concernrole.insert(Long.valueOf(this.marketid), xConcernRoleIdSet);
/*     */       }
/* 110 */       if (xConcernRoleIdSet.getRoleids().size() >= MarketManager.getConcernMax())
/*     */       {
/* 112 */         int r = xdb.Xdb.random().nextInt(MarketManager.getConcernMax());
/* 113 */         xConcernRoleIdSet.getRoleids().remove(r);
/* 114 */         xConcernRoleIdSet.getRoleids().add(Long.valueOf(this.roleId));
/*     */       }
/*     */       else
/*     */       {
/* 118 */         xConcernRoleIdSet.getRoleids().add(Long.valueOf(this.roleId));
/*     */       }
/*     */     }
/*     */     
/* 122 */     mzm.gsp.online.main.OnlineManager.getInstance().send(this.roleId, concernItemRes);
/* 123 */     String logStr = String.format("[market]PConcernItemReq.processImp@concern item success|roleid=%d|itemId=%d|marketId=%d|concernNum=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.itemId), Long.valueOf(this.marketid), Integer.valueOf(xMarketItem.getConcern_role_num()) });
/*     */     
/*     */ 
/* 126 */     MarketManager.logger.info(logStr);
/*     */     
/* 128 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\market\main\PConcernItemReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */