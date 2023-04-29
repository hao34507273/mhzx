/*    */ package mzm.gsp.market.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.item.confbean.SItemEquipCfg;
/*    */ import mzm.gsp.item.main.ItemInterface;
/*    */ import mzm.gsp.market.search.EquipConditionManager;
/*    */ import mzm.gsp.market.search.EquipQueryCache;
/*    */ import mzm.gsp.market.search.PetEquipConditionManager;
/*    */ import mzm.gsp.market.search.PetEquipQueryCache;
/*    */ import mzm.gsp.petequip.confbean.SPetEquipItem;
/*    */ import xbean.MarketChannelIds;
/*    */ import xbean.MarketIds;
/*    */ import xbean.MarketItem;
/*    */ import xdb.Lockeys;
/*    */ import xtable.Channel2marketids;
/*    */ import xtable.Item2marketchannelids;
/*    */ import xtable.Marketitem;
/*    */ 
/*    */ public class PDealItemBanTrade extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private int itemId;
/*    */   private int subid;
/*    */   
/*    */   public PDealItemBanTrade(int itemId, int subid)
/*    */   {
/* 28 */     this.itemId = itemId;
/* 29 */     this.subid = subid;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 35 */     long key = GameServerInfoManager.toGlobalId(this.itemId);
/*    */     
/* 37 */     MarketChannelIds xMarketChannelIds = Item2marketchannelids.get(Long.valueOf(key));
/* 38 */     if (xMarketChannelIds == null)
/*    */     {
/* 40 */       return false;
/*    */     }
/* 42 */     Lockeys.lock(Channel2marketids.getTable(), xMarketChannelIds.getChannel_ids());
/* 43 */     for (Iterator i$ = xMarketChannelIds.getChannel_ids().iterator(); i$.hasNext();) { long channelId = ((Long)i$.next()).longValue();
/*    */       
/* 45 */       MarketIds xMarketIds = Channel2marketids.get(Long.valueOf(channelId));
/* 46 */       if ((xMarketIds != null) && (!xMarketIds.getMarket_ids().isEmpty()))
/*    */       {
/*    */ 
/*    */ 
/* 50 */         for (i$ = xMarketIds.getMarket_ids().iterator(); i$.hasNext();) { long marketId = ((Long)i$.next()).longValue();
/*    */           
/* 52 */           if (MarketManager.isLevelSift(this.subid))
/*    */           {
/* 54 */             int level = ItemInterface.getUseLevel(this.itemId);
/* 55 */             LevelSiftRankManager.deletePub(this.subid, marketId, level);
/* 56 */             LevelSiftRankManager.deleteSell(this.subid, marketId, level);
/*    */           }
/*    */           else
/*    */           {
/* 60 */             PriceRankManager.deletePub(this.subid, marketId);
/* 61 */             PriceRankManager.deleteSell(this.subid, marketId);
/*    */           }
/* 63 */           if (MarketInterface.canSearch(this.subid))
/*    */           {
/* 65 */             MarketItem xMarketItem = Marketitem.select(Long.valueOf(marketId));
/* 66 */             if (SItemEquipCfg.get(this.itemId) != null)
/*    */             {
/* 68 */               EquipConditionManager.getInstance().removeItem(this.subid, marketId, xMarketItem, true);
/* 69 */               EquipConditionManager.getInstance().removeItem(this.subid, marketId, xMarketItem, false);
/*    */               
/* 71 */               EquipQueryCache.getInstance().clearCache(xMarketItem, this.subid, true);
/* 72 */               EquipQueryCache.getInstance().clearCache(xMarketItem, this.subid, false);
/*    */             }
/* 74 */             else if (SPetEquipItem.get(this.itemId) != null)
/*    */             {
/* 76 */               PetEquipConditionManager.getInstance().removeItem(this.subid, marketId, xMarketItem, true);
/* 77 */               PetEquipConditionManager.getInstance().removeItem(this.subid, marketId, xMarketItem, false);
/*    */               
/* 79 */               PetEquipQueryCache.getInstance().clearCache(xMarketItem, this.subid, true);
/* 80 */               PetEquipQueryCache.getInstance().clearCache(xMarketItem, this.subid, false);
/*    */             }
/*    */           }
/*    */         } } }
/*    */     Iterator i$;
/* 85 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\market\main\PDealItemBanTrade.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */