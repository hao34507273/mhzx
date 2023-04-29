/*     */ package mzm.gsp.market.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import mzm.gsp.item.confbean.SItemEquipCfg;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.market.search.EquipConditionManager;
/*     */ import mzm.gsp.market.search.PetEquipConditionManager;
/*     */ import mzm.gsp.petequip.confbean.SPetEquipItem;
/*     */ import xbean.Item;
/*     */ import xbean.MarketChannelIds;
/*     */ import xbean.MarketIds;
/*     */ import xbean.MarketItem;
/*     */ import xtable.Channel2marketids;
/*     */ import xtable.Marketitem;
/*     */ import xtable.Marketitem2sessionid;
/*     */ 
/*     */ class GetMarketItemIdsPro extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final int itemId;
/*     */   private final int subid;
/*     */   
/*     */   public GetMarketItemIdsPro(int itemId, int subid)
/*     */   {
/*  27 */     this.itemId = itemId;
/*  28 */     this.subid = subid;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  34 */     MarketChannelIds xMarketChannelIds = MarketManager.getMarketItemChannelIdsOnAdd(this.itemId);
/*  35 */     if (xMarketChannelIds.getChannel_ids().isEmpty())
/*     */     {
/*  37 */       return false;
/*     */     }
/*  39 */     xdb.Lockeys.lock(Channel2marketids.getTable(), xMarketChannelIds.getChannel_ids());
/*     */     
/*  41 */     List<Long> marketIds = new ArrayList(1024);
/*  42 */     List<Long> toRemoveIds = new ArrayList();
/*  43 */     for (Iterator i$ = xMarketChannelIds.getChannel_ids().iterator(); i$.hasNext();) { long channelId = ((Long)i$.next()).longValue();
/*     */       
/*  45 */       MarketIds xMarketIds = Channel2marketids.get(Long.valueOf(channelId));
/*  46 */       if ((xMarketIds == null) || (xMarketIds.getMarket_ids().isEmpty()))
/*     */       {
/*  48 */         toRemoveIds.add(Long.valueOf(channelId));
/*  49 */         Channel2marketids.remove(Long.valueOf(channelId));
/*     */       }
/*     */       else {
/*  52 */         marketIds.addAll(xMarketIds.getMarket_ids());
/*     */       } }
/*  54 */     xMarketChannelIds.getChannel_ids().removeAll(toRemoveIds);
/*  55 */     toRemoveIds.clear();
/*     */     
/*  57 */     xdb.Lockeys.lock(Marketitem.getTable(), marketIds);
/*     */     
/*  59 */     for (Iterator i$ = xMarketChannelIds.getChannel_ids().iterator(); i$.hasNext();) { long channelId = ((Long)i$.next()).longValue();
/*     */       
/*  61 */       MarketIds xMarketIds = Channel2marketids.get(Long.valueOf(channelId));
/*  62 */       if (xMarketIds == null)
/*     */       {
/*  64 */         toRemoveIds.add(Long.valueOf(channelId));
/*  65 */         Channel2marketids.remove(Long.valueOf(channelId));
/*     */       }
/*     */       else {
/*  68 */         List<Long> marketList = new ArrayList(xMarketIds.getMarket_ids());
/*  69 */         for (Iterator i$ = marketList.iterator(); i$.hasNext();) { long marketId = ((Long)i$.next()).longValue();
/*     */           
/*  71 */           dealMarketItem(xMarketChannelIds, xMarketIds, marketId);
/*     */         }
/*  73 */         if (xMarketIds.getMarket_ids().isEmpty())
/*     */         {
/*  75 */           toRemoveIds.add(Long.valueOf(channelId));
/*  76 */           Channel2marketids.remove(Long.valueOf(channelId));
/*     */         }
/*     */       } }
/*  79 */     xMarketChannelIds.getChannel_ids().removeAll(toRemoveIds);
/*     */     
/*  81 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   private void buildPubInfo(long marketId, MarketItem xMarketItem)
/*     */   {
/*  87 */     if (MarketManager.isLevelSift(this.subid))
/*     */     {
/*  89 */       int level = ItemInterface.getUseLevel(xMarketItem.getItem().getCfgid());
/*  90 */       LevelSiftRankManager.rankPub(this.subid, marketId, level, xMarketItem.getPrice());
/*     */     }
/*     */     else
/*     */     {
/*  94 */       PriceRankManager.rankPub(this.subid, marketId, xMarketItem.getPrice());
/*     */     }
/*  96 */     if (MarketInterface.canSearch(this.subid))
/*     */     {
/*  98 */       if (SItemEquipCfg.get(xMarketItem.getItem().getCfgid()) != null)
/*     */       {
/* 100 */         EquipConditionManager.getInstance().addItem(this.subid, marketId, xMarketItem, true);
/*     */       }
/* 102 */       else if (SPetEquipItem.get(xMarketItem.getItem().getCfgid()) != null)
/*     */       {
/* 104 */         PetEquipConditionManager.getInstance().addItem(this.subid, marketId, xMarketItem, true);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private void buildSellInfo(long marketId, MarketItem xMarketItem)
/*     */   {
/* 113 */     if (MarketManager.isLevelSift(this.subid))
/*     */     {
/* 115 */       int level = ItemInterface.getUseLevel(xMarketItem.getItem().getCfgid());
/* 116 */       LevelSiftRankManager.rankSell(this.subid, marketId, level, xMarketItem.getPrice());
/*     */     }
/*     */     else
/*     */     {
/* 120 */       PriceRankManager.rankSell(this.subid, marketId, xMarketItem.getPrice());
/*     */     }
/* 122 */     MarketItemPetPriceManager.addPrice(xMarketItem.getItem().getCfgid(), xMarketItem.getPrice());
/*     */     
/* 124 */     if (MarketInterface.canSearch(this.subid))
/*     */     {
/* 126 */       if (SItemEquipCfg.get(xMarketItem.getItem().getCfgid()) != null)
/*     */       {
/* 128 */         EquipConditionManager.getInstance().addItem(this.subid, marketId, xMarketItem, false);
/*     */       }
/* 130 */       else if (SPetEquipItem.get(xMarketItem.getItem().getCfgid()) != null)
/*     */       {
/* 132 */         PetEquipConditionManager.getInstance().addItem(this.subid, marketId, xMarketItem, false);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private void removeSysItem(long marketId, MarketItem xMarketItem, MarketIds xMarketIds)
/*     */   {
/* 141 */     if (xMarketItem.getRoleid() == 0L)
/*     */     {
/* 143 */       Marketitem.remove(Long.valueOf(marketId));
/* 144 */       xtable.Marketitemid2concernrole.remove(Long.valueOf(marketId));
/* 145 */       xMarketIds.getMarket_ids().remove(Long.valueOf(marketId));
/*     */     }
/*     */   }
/*     */   
/*     */   private boolean dealMarketItem(MarketChannelIds xMarketChannelIds, MarketIds xMarketIds, long marketId)
/*     */     throws Exception
/*     */   {
/* 152 */     long now = mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis();
/* 153 */     long nowSecs = TimeUnit.MILLISECONDS.toSeconds(now);
/* 154 */     MarketItem xMarketItem = Marketitem.get(Long.valueOf(marketId));
/* 155 */     if (xMarketItem == null)
/*     */     {
/* 157 */       return false;
/*     */     }
/* 159 */     if (xMarketItem.getState() == 1)
/*     */     {
/* 161 */       long publicTipEndtime = MarketManager.computePublicTipEndTime(xMarketItem.getOnshelf_time());
/*     */       
/* 163 */       long length = publicTipEndtime - nowSecs;
/* 164 */       if (length <= 0L)
/*     */       {
/* 166 */         long publicEndtime = MarketManager.computePublicEndtime(xMarketItem.getOnshelf_time());
/* 167 */         length = publicEndtime - nowSecs;
/* 168 */         if (length <= 0L)
/*     */         {
/* 170 */           xMarketItem.setOnshelf_time(now);
/* 171 */           xMarketItem.setState(2);
/*     */           
/* 173 */           MarketManager.startOnSellItemPhaseSession(marketId, xMarketItem, MarketManager.getRecycleSeconds(xMarketItem.getItem().getCfgid()), MarketManager.getShangjiaLengthSeconds());
/*     */           
/*     */ 
/* 176 */           buildSellInfo(marketId, xMarketItem);
/*     */         }
/*     */         else
/*     */         {
/* 180 */           PublicItemSession publicItemSession = new PublicItemSession(length, marketId);
/*     */           
/* 182 */           Marketitem2sessionid.remove(Long.valueOf(marketId));
/* 183 */           Marketitem2sessionid.insert(Long.valueOf(marketId), Long.valueOf(publicItemSession.getSessionId()));
/*     */           
/* 185 */           buildPubInfo(marketId, xMarketItem);
/*     */ 
/*     */         }
/*     */         
/*     */ 
/*     */       }
/*     */       else
/*     */       {
/*     */ 
/* 194 */         PrePubItemSession prePubItemSession = new PrePubItemSession(length, marketId);
/*     */         
/* 196 */         Marketitem2sessionid.remove(Long.valueOf(marketId));
/* 197 */         Marketitem2sessionid.insert(Long.valueOf(marketId), Long.valueOf(prePubItemSession.getSessionId()));
/*     */         
/* 199 */         buildPubInfo(marketId, xMarketItem);
/*     */       }
/*     */       
/*     */ 
/*     */     }
/* 204 */     else if ((xMarketItem.getState() == 4) || (MarketManager.hasState(xMarketItem.getState(), 8)))
/*     */     {
/*     */ 
/* 207 */       removeSysItem(marketId, xMarketItem, xMarketIds);
/*     */     }
/* 209 */     else if (MarketManager.hasState(xMarketItem.getState(), 16))
/*     */     {
/* 211 */       xbean.AuctionItemInfo xAuctionInfo = xtable.Marketitemid2auction.get(Long.valueOf(marketId));
/*     */       
/* 213 */       if (xAuctionInfo != null)
/*     */       {
/* 215 */         mzm.gsp.market.auction.MarketAuctionManager.startAuctionItemSession(marketId, xAuctionInfo, now);
/*     */       }
/* 217 */       buildPubInfo(marketId, xMarketItem);
/*     */ 
/*     */ 
/*     */     }
/* 221 */     else if (xMarketItem.getRest_num() > 0)
/*     */     {
/* 223 */       long sellEndtime = MarketManager.computeShangjiaExpireTime(xMarketItem.getOnshelf_time());
/*     */       
/* 225 */       long length = sellEndtime - nowSecs;
/* 226 */       if (length <= 0L)
/*     */       {
/* 228 */         xMarketItem.setState(xMarketItem.getState() | 0x8);
/* 229 */         xMarketItem.setState(xMarketItem.getState() & 0xFFFFFFFD);
/* 230 */         removeSysItem(marketId, xMarketItem, xMarketIds);
/*     */       }
/*     */       else
/*     */       {
/* 234 */         long passedSellSec = TimeUnit.MILLISECONDS.toSeconds(now - xMarketItem.getOnshelf_time());
/* 235 */         long recycleSecs = MarketManager.getRecycleSeconds(xMarketItem.getItem().getCfgid());
/* 236 */         if (passedSellSec >= recycleSecs)
/*     */         {
/* 238 */           Marketitem2sessionid.remove(Long.valueOf(marketId));
/* 239 */           MarketItemSession marketItemSession = new MarketItemSession(length, marketId);
/* 240 */           Marketitem2sessionid.insert(Long.valueOf(marketId), Long.valueOf(marketItemSession.getSessionId()));
/*     */         }
/*     */         else
/*     */         {
/* 244 */           MarketManager.startOnSellItemPhaseSession(marketId, xMarketItem, recycleSecs - passedSellSec, length);
/*     */         }
/* 246 */         buildSellInfo(marketId, xMarketItem);
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 255 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\market\main\GetMarketItemIdsPro.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */