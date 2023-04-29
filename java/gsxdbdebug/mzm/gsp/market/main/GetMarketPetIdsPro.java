/*     */ package mzm.gsp.market.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import mzm.gsp.market.search.PetConditionManager;
/*     */ import xbean.MarketChannelIds;
/*     */ import xbean.MarketIds;
/*     */ import xbean.MarketPet;
/*     */ import xbean.Pet;
/*     */ import xtable.Channel2marketids;
/*     */ import xtable.Marketpet;
/*     */ import xtable.Marketpet2sessionid;
/*     */ 
/*     */ class GetMarketPetIdsPro extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final int petId;
/*     */   private final int subid;
/*     */   
/*     */   public GetMarketPetIdsPro(int petId, int subid)
/*     */   {
/*  23 */     this.petId = petId;
/*  24 */     this.subid = subid;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  30 */     MarketChannelIds xMarketChannelIds = MarketManager.getMarketPetChannelIdsOnAdd(this.petId);
/*  31 */     if (xMarketChannelIds.getChannel_ids().isEmpty())
/*     */     {
/*  33 */       return false;
/*     */     }
/*     */     
/*  36 */     xdb.Lockeys.lock(Channel2marketids.getTable(), xMarketChannelIds.getChannel_ids());
/*  37 */     List<Long> marketIds = new ArrayList(1024);
/*  38 */     List<Long> toRemoveIds = new ArrayList();
/*  39 */     for (Iterator i$ = xMarketChannelIds.getChannel_ids().iterator(); i$.hasNext();) { long channelId = ((Long)i$.next()).longValue();
/*     */       
/*  41 */       MarketIds xMarketIds = Channel2marketids.get(Long.valueOf(channelId));
/*  42 */       if ((xMarketIds == null) || (xMarketIds.getMarket_ids().isEmpty()))
/*     */       {
/*  44 */         toRemoveIds.add(Long.valueOf(channelId));
/*  45 */         Channel2marketids.remove(Long.valueOf(channelId));
/*     */       }
/*     */       else {
/*  48 */         marketIds.addAll(xMarketIds.getMarket_ids());
/*     */       }
/*     */     }
/*  51 */     xMarketChannelIds.getChannel_ids().removeAll(toRemoveIds);
/*  52 */     toRemoveIds.clear();
/*     */     
/*  54 */     xdb.Lockeys.lock(Marketpet.getTable(), marketIds);
/*     */     
/*  56 */     for (Iterator i$ = xMarketChannelIds.getChannel_ids().iterator(); i$.hasNext();) { long channelId = ((Long)i$.next()).longValue();
/*     */       
/*  58 */       MarketIds xMarketIds = Channel2marketids.get(Long.valueOf(channelId));
/*  59 */       if (xMarketIds == null)
/*     */       {
/*  61 */         toRemoveIds.add(Long.valueOf(channelId));
/*  62 */         Channel2marketids.remove(Long.valueOf(channelId));
/*     */       }
/*     */       else {
/*  65 */         List<Long> marketList = new ArrayList(xMarketIds.getMarket_ids());
/*  66 */         for (Iterator i$ = marketList.iterator(); i$.hasNext();) { long marketId = ((Long)i$.next()).longValue();
/*     */           
/*  68 */           dealMarketPet(xMarketChannelIds, xMarketIds, marketId);
/*     */         }
/*  70 */         if (xMarketIds.getMarket_ids().isEmpty())
/*     */         {
/*  72 */           toRemoveIds.add(Long.valueOf(channelId));
/*  73 */           Channel2marketids.remove(Long.valueOf(channelId));
/*     */         }
/*     */       } }
/*  76 */     xMarketChannelIds.getChannel_ids().removeAll(toRemoveIds);
/*     */     
/*  78 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   private void buildPubInfo(long marketId, MarketPet xMarketPet)
/*     */   {
/*  84 */     if (MarketManager.isLevelSift(this.subid))
/*     */     {
/*  86 */       LevelSiftRankManager.rankPub(this.subid, marketId, xMarketPet.getPet().getLevel(), xMarketPet.getPrice());
/*     */     }
/*     */     else
/*     */     {
/*  90 */       PriceRankManager.rankPub(this.subid, marketId, xMarketPet.getPrice());
/*     */     }
/*  92 */     if (MarketInterface.canSearch(this.subid))
/*     */     {
/*     */ 
/*  95 */       PetConditionManager.getInstance().addPet(this.subid, marketId, xMarketPet, true);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private void buildSellInfo(long marketId, MarketPet xMarketPet)
/*     */   {
/* 103 */     if (MarketManager.isLevelSift(this.subid))
/*     */     {
/* 105 */       LevelSiftRankManager.rankSell(this.subid, marketId, xMarketPet.getPet().getLevel(), xMarketPet.getPrice());
/*     */     }
/*     */     else
/*     */     {
/* 109 */       PriceRankManager.rankSell(this.subid, marketId, xMarketPet.getPrice());
/*     */     }
/* 111 */     MarketItemPetPriceManager.addPrice(xMarketPet.getPet().getTemplateid(), xMarketPet.getPrice());
/*     */     
/* 113 */     if (MarketInterface.canSearch(this.subid))
/*     */     {
/*     */ 
/* 116 */       PetConditionManager.getInstance().addPet(this.subid, marketId, xMarketPet, false);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private void removeSysPet(long marketId, MarketPet xMarketPet, MarketIds xMarketIds)
/*     */   {
/* 124 */     if (xMarketPet.getRoleid() == 0L)
/*     */     {
/* 126 */       Marketpet.remove(Long.valueOf(marketId));
/* 127 */       xtable.Marketpetid2concernrole.remove(Long.valueOf(marketId));
/* 128 */       xMarketIds.getMarket_ids().remove(Long.valueOf(marketId));
/*     */     }
/*     */   }
/*     */   
/*     */   private boolean dealMarketPet(MarketChannelIds xMarketChannelIds, MarketIds xMarketIds, long marketId)
/*     */     throws Exception
/*     */   {
/* 135 */     long now = mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis();
/* 136 */     long nowSec = TimeUnit.MILLISECONDS.toSeconds(now);
/* 137 */     MarketPet xMarketPet = Marketpet.get(Long.valueOf(marketId));
/* 138 */     if (xMarketPet == null)
/*     */     {
/* 140 */       return false;
/*     */     }
/*     */     
/* 143 */     if (xMarketPet.getState() == 1)
/*     */     {
/*     */ 
/* 146 */       long publicTipEndtime = MarketManager.computePublicTipEndTime(xMarketPet.getOnshelf_time());
/*     */       
/* 148 */       long length = publicTipEndtime - nowSec;
/* 149 */       if (length <= 0L)
/*     */       {
/* 151 */         long publicEndtime = MarketManager.computePublicEndtime(xMarketPet.getOnshelf_time());
/* 152 */         length = publicEndtime - nowSec;
/* 153 */         if (length <= 0L)
/*     */         {
/* 155 */           xMarketPet.setOnshelf_time(now);
/* 156 */           xMarketPet.setState(2);
/*     */           
/* 158 */           MarketManager.startOnSellPetPhaseSession(marketId, xMarketPet, MarketManager.getRecycleSeconds(xMarketPet.getPet().getTemplateid()), MarketManager.getShangjiaLengthSeconds());
/*     */           
/*     */ 
/*     */ 
/* 162 */           buildSellInfo(marketId, xMarketPet);
/*     */ 
/*     */         }
/*     */         else
/*     */         {
/*     */ 
/* 168 */           PublicPetSession publicPetSession = new PublicPetSession(length, marketId);
/* 169 */           Marketpet2sessionid.remove(Long.valueOf(marketId));
/* 170 */           Marketpet2sessionid.insert(Long.valueOf(marketId), Long.valueOf(publicPetSession.getSessionId()));
/* 171 */           buildPubInfo(marketId, xMarketPet);
/*     */         }
/*     */         
/*     */ 
/*     */       }
/*     */       else
/*     */       {
/*     */ 
/* 179 */         PrePubPetSession prePubPetSession = new PrePubPetSession(length, marketId);
/*     */         
/* 181 */         Marketpet2sessionid.remove(Long.valueOf(marketId));
/* 182 */         Marketpet2sessionid.insert(Long.valueOf(marketId), Long.valueOf(prePubPetSession.getSessionId()));
/*     */         
/* 184 */         buildPubInfo(marketId, xMarketPet);
/*     */       }
/*     */       
/*     */ 
/*     */     }
/* 189 */     else if ((xMarketPet.getState() == 4) || (xMarketPet.getState() == 8))
/*     */     {
/* 191 */       removeSysPet(marketId, xMarketPet, xMarketIds);
/*     */     }
/* 193 */     else if (MarketManager.hasState(xMarketPet.getState(), 16))
/*     */     {
/* 195 */       xbean.AuctionPetInfo xAuctionInfo = xtable.Marketpetid2auction.get(Long.valueOf(marketId));
/* 196 */       if (xAuctionInfo != null)
/*     */       {
/* 198 */         mzm.gsp.market.auction.MarketAuctionManager.startAuctionPetSession(marketId, xAuctionInfo, now);
/*     */       }
/*     */       
/* 201 */       buildPubInfo(marketId, xMarketPet);
/*     */ 
/*     */     }
/* 204 */     else if (xMarketPet.getState() == 2)
/*     */     {
/* 206 */       long sellEndtime = MarketManager.computeShangjiaExpireTime(xMarketPet.getOnshelf_time());
/*     */       
/* 208 */       long length = sellEndtime - TimeUnit.MILLISECONDS.toSeconds(now);
/* 209 */       if (length <= 0L)
/*     */       {
/* 211 */         xMarketPet.setState(8);
/* 212 */         removeSysPet(marketId, xMarketPet, xMarketIds);
/*     */       }
/*     */       else
/*     */       {
/* 216 */         long passedSellSec = TimeUnit.MILLISECONDS.toSeconds(now - xMarketPet.getOnshelf_time());
/* 217 */         long preRecycleSecs = MarketManager.getRecycleSeconds(xMarketPet.getPet().getTemplateid());
/* 218 */         if (passedSellSec >= preRecycleSecs)
/*     */         {
/* 220 */           Marketpet2sessionid.remove(Long.valueOf(marketId));
/* 221 */           MarketPetSession marPetSession = new MarketPetSession(length, marketId);
/* 222 */           Marketpet2sessionid.insert(Long.valueOf(marketId), Long.valueOf(marPetSession.getSessionId()));
/*     */         }
/*     */         else
/*     */         {
/* 226 */           MarketManager.startOnSellPetPhaseSession(marketId, xMarketPet, preRecycleSecs - passedSellSec, length);
/*     */         }
/* 228 */         buildSellInfo(marketId, xMarketPet);
/*     */       }
/*     */     }
/*     */     
/* 232 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\market\main\GetMarketPetIdsPro.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */