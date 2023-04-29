/*    */ package mzm.gsp.market.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import mzm.gsp.market.search.PetConditionManager;
/*    */ import mzm.gsp.market.search.PetQueryCache;
/*    */ import xbean.MarketChannelIds;
/*    */ import xbean.MarketIds;
/*    */ import xbean.MarketPet;
/*    */ 
/*    */ public class PDealPetBanTrade extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private int petCfgId;
/*    */   private int subid;
/*    */   
/*    */   public PDealPetBanTrade(int petCfgId, int subid)
/*    */   {
/* 17 */     this.petCfgId = petCfgId;
/* 18 */     this.subid = subid;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 24 */     long key = mzm.gsp.GameServerInfoManager.toGlobalId(this.petCfgId);
/*    */     
/* 26 */     MarketChannelIds xMarketChannelIds = xtable.Pet2marketchannelids.get(Long.valueOf(key));
/* 27 */     if (xMarketChannelIds == null)
/*    */     {
/* 29 */       return false;
/*    */     }
/*    */     
/* 32 */     xdb.Lockeys.lock(xtable.Channel2marketids.getTable(), xMarketChannelIds.getChannel_ids());
/* 33 */     for (Iterator i$ = xMarketChannelIds.getChannel_ids().iterator(); i$.hasNext();) { long channelId = ((Long)i$.next()).longValue();
/*    */       
/* 35 */       MarketIds xMarketIds = xtable.Channel2marketids.get(Long.valueOf(channelId));
/* 36 */       if ((xMarketIds != null) && (!xMarketIds.getMarket_ids().isEmpty()))
/*    */       {
/*    */ 
/*    */ 
/* 40 */         for (i$ = xMarketIds.getMarket_ids().iterator(); i$.hasNext();) { long marketId = ((Long)i$.next()).longValue();
/*    */           
/*    */ 
/* 43 */           PriceRankManager.deletePub(this.subid, marketId);
/* 44 */           PriceRankManager.deleteSell(this.subid, marketId);
/*    */           
/* 46 */           MarketPet xMarketPet = xtable.Marketpet.select(Long.valueOf(marketId));
/* 47 */           if ((xMarketPet != null) && (MarketManager.isLevelSift(this.subid)))
/*    */           {
/* 49 */             LevelSiftRankManager.deletePub(this.subid, marketId, xMarketPet.getPet().getLevel());
/* 50 */             LevelSiftRankManager.deleteSell(this.subid, marketId, xMarketPet.getPet().getLevel());
/*    */           }
/*    */           
/* 53 */           PetConditionManager.getInstance().removePet(this.subid, marketId, xMarketPet, true);
/* 54 */           PetConditionManager.getInstance().removePet(this.subid, marketId, xMarketPet, false);
/* 55 */           PetQueryCache.getInstance().clearCache(xMarketPet, this.subid, true);
/* 56 */           PetQueryCache.getInstance().clearCache(xMarketPet, this.subid, false);
/*    */         } }
/*    */     }
/*    */     Iterator i$;
/* 60 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\market\main\PDealPetBanTrade.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */