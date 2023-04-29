/*    */ package mzm.gsp.market.main;
/*    */ 
/*    */ import mzm.gsp.timer.main.Session;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.Item;
/*    */ import xbean.MarketItem;
/*    */ import xtable.Marketitem2sessionid;
/*    */ import xtable.Marketitemid2concernrole;
/*    */ 
/*    */ public class PublicItemSession extends Session
/*    */ {
/*    */   public PublicItemSession(long interval, long marketId)
/*    */   {
/* 14 */     super(interval, marketId);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   protected void onTimeOut()
/*    */   {
/* 21 */     new PublicItemSessionPro(getOwerId()).execute();
/*    */   }
/*    */   
/*    */   private static class PublicItemSessionPro
/*    */     extends mzm.gsp.util.LogicProcedure
/*    */   {
/*    */     private final long marketId;
/*    */     
/*    */     public PublicItemSessionPro(long marketId)
/*    */     {
/* 31 */       this.marketId = marketId;
/*    */     }
/*    */     
/*    */     protected boolean processImp()
/*    */       throws Exception
/*    */     {
/* 37 */       MarketItem xMarketItem = xtable.Marketitem.get(Long.valueOf(this.marketId));
/* 38 */       if (xMarketItem == null)
/*    */       {
/* 40 */         String logStr = String.format("[market]PublicItemSessionPro.processImp@ xbean.MarketItem get null|marketId=%d", new Object[] { Long.valueOf(this.marketId) });
/*    */         
/* 42 */         MarketManager.logger.error(logStr);
/* 43 */         return false;
/*    */       }
/* 45 */       if (xMarketItem.getState() != 1)
/*    */       {
/* 47 */         String logStr = String.format("[market]PublicItemSessionPro.processImp@ xbean.MarketItem state error|roleId=%d|marketId=%d|state=%d", new Object[] { Long.valueOf(xMarketItem.getRoleid()), Long.valueOf(this.marketId), Integer.valueOf(xMarketItem.getState()) });
/*    */         
/*    */ 
/* 50 */         MarketManager.logger.error(logStr);
/* 51 */         return false;
/*    */       }
/*    */       
/* 54 */       xMarketItem.setState(2);
/* 55 */       long now = mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis();
/* 56 */       xMarketItem.setOnshelf_time(now);
/* 57 */       int subid = MarketManager.getSubidByItemId(xMarketItem.getItem().getCfgid());
/* 58 */       if (subid != -1)
/*    */       {
/* 60 */         MarketManager.startOnSellItemPhaseSession(this.marketId, xMarketItem, MarketManager.getRecycleSeconds(xMarketItem.getItem().getCfgid()), MarketManager.getShangjiaLengthSeconds());
/*    */         
/*    */ 
/*    */ 
/* 64 */         if (MarketManager.isLevelSift(subid))
/*    */         {
/* 66 */           int level = mzm.gsp.item.main.ItemInterface.getUseLevel(xMarketItem.getItem().getCfgid());
/* 67 */           LevelSiftRankManager.deletePub(subid, this.marketId, level);
/* 68 */           LevelSiftRankManager.rankSell(subid, this.marketId, level, xMarketItem.getPrice());
/*    */         }
/*    */         else
/*    */         {
/* 72 */           PriceRankManager.deletePub(subid, this.marketId);
/* 73 */           PriceRankManager.rankSell(subid, this.marketId, xMarketItem.getPrice());
/*    */         }
/* 75 */         MarketItemPetPriceManager.addPrice(xMarketItem.getItem().getCfgid(), xMarketItem.getPrice());
/*    */         
/* 77 */         MarketInterface.triggerMarketItemOffShelfEvent(this.marketId, xMarketItem.getItem().getCfgid(), true, xMarketItem.toData());
/*    */         
/*    */ 
/* 80 */         MarketInterface.triggerMarketItemOnShelfEvent(this.marketId, xMarketItem.getItem().getCfgid(), false);
/* 81 */         String logStr = String.format("[market]PublicItemSessionPro.processImp@ market item from public to sell success|roleId=%d|marketId=%d|subid=%d|itemId=%d|price=%d", new Object[] { Long.valueOf(xMarketItem.getRoleid()), Long.valueOf(this.marketId), Integer.valueOf(subid), Integer.valueOf(xMarketItem.getItem().getCfgid()), Integer.valueOf(xMarketItem.getPrice()) });
/*    */         
/*    */ 
/* 84 */         MarketManager.logger.info(logStr);
/*    */       }
/*    */       else
/*    */       {
/* 88 */         Marketitem2sessionid.remove(Long.valueOf(this.marketId));
/*    */       }
/*    */       
/* 91 */       Marketitemid2concernrole.remove(Long.valueOf(this.marketId));
/* 92 */       return true;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\market\main\PublicItemSession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */