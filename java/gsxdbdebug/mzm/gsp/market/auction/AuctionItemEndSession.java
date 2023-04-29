/*     */ package mzm.gsp.market.auction;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.market.main.MarketInterface;
/*     */ import mzm.gsp.timer.main.Session;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.AuctionItemInfo;
/*     */ import xbean.Item;
/*     */ import xbean.MarketItem;
/*     */ import xbean.RoleAuctionInfo;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Item2marketchannelids;
/*     */ import xtable.Marketitem;
/*     */ import xtable.Marketitem2sessionid;
/*     */ import xtable.Marketitemid2auction;
/*     */ import xtable.Marketitemid2concernrole;
/*     */ import xtable.Role2auctioninfo;
/*     */ 
/*     */ public class AuctionItemEndSession extends Session
/*     */ {
/*     */   public AuctionItemEndSession(long interval, long marketId)
/*     */   {
/*  28 */     super(interval, marketId);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   protected void onTimeOut()
/*     */   {
/*  36 */     new AuctionItemEndPro(getOwerId()).execute();
/*     */   }
/*     */   
/*     */ 
/*     */   private static class AuctionItemEndPro
/*     */     extends mzm.gsp.util.LogicProcedure
/*     */   {
/*     */     private final long marketId;
/*     */     
/*     */     public AuctionItemEndPro(long marketId)
/*     */     {
/*  47 */       this.marketId = marketId;
/*     */     }
/*     */     
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/*  53 */       Long maxPriceRoleId = Marketitemid2auction.selectAuctionroleid(Long.valueOf(this.marketId));
/*  54 */       if (maxPriceRoleId == null)
/*     */       {
/*  56 */         String logStr = String.format("[marketauction]AuctionItemEndPro.processImp@ maxPriceRoleId get null|marketId=%d", new Object[] { Long.valueOf(this.marketId) });
/*     */         
/*  58 */         MarketInterface.getLogger().error(logStr);
/*  59 */         return false;
/*     */       }
/*     */       
/*  62 */       MarketItem xMarketItem = Marketitem.select(Long.valueOf(this.marketId));
/*  63 */       if (xMarketItem == null)
/*     */       {
/*  65 */         String logStr = String.format("[marketauction]AuctionItemEndPro.processImp@ sellerRoleId get null|marketId=%d", new Object[] { Long.valueOf(this.marketId) });
/*     */         
/*  67 */         MarketInterface.getLogger().error(logStr);
/*  68 */         return false;
/*     */       }
/*     */       
/*  71 */       long sellerRoleId = xMarketItem.getRoleid();
/*  72 */       List<Long> roleList = new ArrayList();
/*  73 */       roleList.add(maxPriceRoleId);
/*  74 */       if (!MarketInterface.isSysRoleid(sellerRoleId))
/*     */       {
/*  76 */         roleList.add(Long.valueOf(sellerRoleId));
/*     */       }
/*     */       
/*  79 */       Lockeys.lock(Role2auctioninfo.getTable(), roleList);
/*     */       
/*  81 */       long itemLockKey = mzm.gsp.GameServerInfoManager.toGlobalId(xMarketItem.getItem().getCfgid());
/*  82 */       Lockeys.lock(Item2marketchannelids.getTable(), Arrays.asList(new Long[] { Long.valueOf(itemLockKey) }));
/*  83 */       Lockeys.lock(xtable.Channel2marketids.getTable(), Arrays.asList(new Long[] { Long.valueOf(xMarketItem.getChannel_id()) }));
/*     */       
/*  85 */       RoleAuctionInfo xRoleAuctionInfo = Role2auctioninfo.get(maxPriceRoleId);
/*  86 */       if (xRoleAuctionInfo == null)
/*     */       {
/*  88 */         String logStr = String.format("[marketauction]AuctionItemEndPro.processImp@ xRoleAuctionInfo get null|maxPriceRoleId=%d|marketId=%d", new Object[] { maxPriceRoleId, Long.valueOf(this.marketId) });
/*     */         
/*     */ 
/*  91 */         MarketInterface.getLogger().error(logStr);
/*  92 */         return false;
/*     */       }
/*  94 */       if (!xRoleAuctionInfo.getAuction_item_ids().contains(Long.valueOf(this.marketId)))
/*     */       {
/*  96 */         String logStr = String.format("[marketauction]AuctionItemEndPro.processImp@no auction item marketid|maxPriceRoleId=%d|marketId=%d", new Object[] { maxPriceRoleId, Long.valueOf(this.marketId) });
/*     */         
/*     */ 
/*  99 */         MarketInterface.getLogger().error(logStr);
/* 100 */         return false;
/*     */       }
/*     */       
/* 103 */       xMarketItem = Marketitem.get(Long.valueOf(this.marketId));
/*     */       
/* 105 */       if (xMarketItem == null)
/*     */       {
/* 107 */         String logStr = String.format("[marketauction]AuctionItemEndPro.processImp@ xbean.MarketItem get null|marketId=%d", new Object[] { Long.valueOf(this.marketId) });
/*     */         
/* 109 */         MarketInterface.getLogger().error(logStr);
/* 110 */         return false;
/*     */       }
/* 112 */       if (xMarketItem.getRoleid() != sellerRoleId)
/*     */       {
/* 114 */         String logStr = String.format("[marketauction]AuctionItemEndPro.processImp@ seller roleid error|sellerRoleid=%d|marketRoleId=%d", new Object[] { Long.valueOf(sellerRoleId), Long.valueOf(xMarketItem.getRoleid()) });
/*     */         
/*     */ 
/* 117 */         MarketInterface.getLogger().error(logStr);
/* 118 */         return false;
/*     */       }
/* 120 */       if (!MarketInterface.hasState(xMarketItem.getState(), 16))
/*     */       {
/* 122 */         String logStr = String.format("[marketauction]AuctionItemEndPro.processImp@ xbean.MarketItem state error|roleId=%d|marketId=%d|state=%d|auctionRoleId=%d", new Object[] { Long.valueOf(sellerRoleId), Long.valueOf(this.marketId), Integer.valueOf(xMarketItem.getState()), maxPriceRoleId });
/*     */         
/*     */ 
/* 125 */         MarketInterface.getLogger().error(logStr);
/* 126 */         return false;
/*     */       }
/*     */       
/* 129 */       xMarketItem.setState(4);
/* 130 */       xMarketItem.setRest_num(0);
/*     */       
/* 132 */       AuctionItemInfo xAuctionInfo = Marketitemid2auction.get(Long.valueOf(this.marketId));
/* 133 */       if (xAuctionInfo == null)
/*     */       {
/* 135 */         String logStr = String.format("[marketauction]AuctionItemEndPro.processImp@ xbean.AuctionItemInfo state error,null|roleId=%d|marketId=%d|state=%d|auctionRoleId=%d", new Object[] { Long.valueOf(sellerRoleId), Long.valueOf(this.marketId), Integer.valueOf(xMarketItem.getState()), maxPriceRoleId });
/*     */         
/*     */ 
/* 138 */         MarketInterface.getLogger().error(logStr);
/* 139 */         return false;
/*     */       }
/*     */       
/* 142 */       if (maxPriceRoleId.longValue() != xAuctionInfo.getAuctionroleid())
/*     */       {
/* 144 */         String logStr = String.format("[marketauction]AuctionItemEndPro.processImp@ auction roleId not same or price error|roleId=%d|marketId=%d|state=%d|auctionRoleId=%d|newAuctionRoleId=%d", new Object[] { Long.valueOf(sellerRoleId), Long.valueOf(this.marketId), Integer.valueOf(xMarketItem.getState()), maxPriceRoleId, Long.valueOf(xAuctionInfo.getAuctionroleid()) });
/*     */         
/*     */ 
/* 147 */         MarketInterface.getLogger().error(logStr);
/* 148 */         return false;
/*     */       }
/*     */       
/* 151 */       Item xItem = xbean.Pod.newItem();
/* 152 */       ItemInterface.fillXItem(xItem, xMarketItem.getItem());
/* 153 */       xItem.setMarketbuytime(TimeUnit.MILLISECONDS.toSeconds(xAuctionInfo.getEndtime()));
/* 154 */       xRoleAuctionInfo.getMarketid2auctionitem().put(Long.valueOf(this.marketId), xItem);
/*     */       
/* 156 */       if (!MarketInterface.isSysRoleid(sellerRoleId))
/*     */       {
/* 158 */         xbean.RoleMarketInfo xRoleMarketInfo = xtable.Role2marketinfo.get(Long.valueOf(sellerRoleId));
/* 159 */         if (xRoleMarketInfo == null)
/*     */         {
/* 161 */           String logStr = String.format("[marketauction]AuctionItemEndPro.processImp@ xRoleMarketInfo null|roleId=%d|marketId=%d|state=%d|auctionRoleId=%d", new Object[] { Long.valueOf(sellerRoleId), Long.valueOf(this.marketId), Integer.valueOf(xMarketItem.getState()), maxPriceRoleId });
/*     */           
/*     */ 
/* 164 */           MarketInterface.getLogger().error(logStr);
/* 165 */           return false;
/*     */         }
/* 167 */         MarketInterface.addMarketTimeOutOrSelledItem(xRoleMarketInfo, this.marketId, xMarketItem);
/* 168 */         MarketInterface.sendSSyncSellItemNotify(sellerRoleId, this.marketId, xMarketItem.getItem().getCfgid(), 0, xMarketItem.getItem().getNumber());
/*     */       }
/*     */       
/*     */ 
/* 172 */       MarketInterface.removeMarketIdFromItemChannel(itemLockKey, this.marketId, xMarketItem.getChannel_id());
/* 173 */       Marketitem.remove(Long.valueOf(this.marketId));
/*     */       
/* 175 */       Marketitemid2concernrole.remove(Long.valueOf(this.marketId));
/*     */       
/* 177 */       MarketInterface.logMarketBuyItem(maxPriceRoleId.longValue(), sellerRoleId, this.marketId, xMarketItem.getItem().getCfgid(), xMarketItem.getItem().getNumber(), xMarketItem.getPrice(), xMarketItem.getItem().getUuidAsData(), mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis());
/*     */       
/*     */ 
/*     */ 
/* 181 */       int subid = MarketInterface.getSubidByItemId(xMarketItem.getItem().getCfgid());
/* 182 */       if (subid != -1)
/*     */       {
/*     */ 
/* 185 */         Marketitem2sessionid.remove(Long.valueOf(this.marketId));
/*     */         
/* 187 */         if (MarketInterface.isLevelSift(subid))
/*     */         {
/* 189 */           int level = ItemInterface.getUseLevel(xMarketItem.getItem().getCfgid());
/* 190 */           MarketInterface.deleteFromPubLevelSiftRank(subid, this.marketId, level);
/*     */ 
/*     */         }
/*     */         else
/*     */         {
/* 195 */           MarketInterface.deleteFromPubPriceRank(subid, this.marketId);
/*     */         }
/*     */         
/* 198 */         MarketInterface.triggerMarketItemOffShelfEvent(this.marketId, xMarketItem.getItem().getCfgid(), true, xMarketItem.toData());
/*     */         
/*     */ 
/* 201 */         String logStr = String.format("[marketauction]AuctionItemEndPro.processImp@ market item auction success|roleId=%d|marketId=%d|subid=%d|itemId=%d|price=%d|auctionRoleId=%d|auctionPrice=%d", new Object[] { Long.valueOf(sellerRoleId), Long.valueOf(this.marketId), Integer.valueOf(subid), Integer.valueOf(xMarketItem.getItem().getCfgid()), Integer.valueOf(xMarketItem.getPrice()), maxPriceRoleId, Integer.valueOf(xAuctionInfo.getAuctionprice()) });
/*     */         
/*     */ 
/*     */ 
/* 205 */         MarketInterface.getLogger().info(logStr);
/*     */       }
/*     */       else
/*     */       {
/* 209 */         Marketitem2sessionid.remove(Long.valueOf(this.marketId));
/*     */       }
/* 211 */       long uuid = 0L;
/* 212 */       if ((xMarketItem.getItem().getUuid() != null) && (!xMarketItem.getItem().getUuid().isEmpty()))
/*     */       {
/* 214 */         uuid = ((Long)xMarketItem.getItem().getUuid().iterator().next()).longValue();
/*     */       }
/*     */       
/* 217 */       MarketAuctionManager.sendAuctionSuccessMail(maxPriceRoleId.longValue(), this.marketId, xMarketItem.getItem().getCfgid(), ItemInterface.getItemName(xMarketItem.getItem().getCfgid()), xAuctionInfo.getAuctionprice());
/*     */       
/* 219 */       MarketAuctionManager.tlogMarketAuctionSuccess(maxPriceRoleId.longValue(), subid, xMarketItem.getItem().getCfgid(), xMarketItem.getPrice(), this.marketId, uuid, sellerRoleId);
/*     */       
/* 221 */       MarketAuctionManager.removeMarketItemAuction(this.marketId, false, false, false);
/* 222 */       return true;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\market\auction\AuctionItemEndSession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */