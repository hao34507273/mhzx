/*    */ package mzm.gsp.market.main;
/*    */ 
/*    */ import mzm.gsp.timer.main.Session;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.MarketPet;
/*    */ import xbean.Pet;
/*    */ import xtable.Marketpetid2concernrole;
/*    */ 
/*    */ public class PublicPetSession extends Session
/*    */ {
/*    */   public PublicPetSession(long interval, long marketId)
/*    */   {
/* 13 */     super(interval, marketId);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   protected void onTimeOut()
/*    */   {
/* 20 */     new PublicPetSessionPro(getOwerId()).execute();
/*    */   }
/*    */   
/*    */   private static class PublicPetSessionPro
/*    */     extends mzm.gsp.util.LogicProcedure
/*    */   {
/*    */     private final long marketId;
/*    */     
/*    */     public PublicPetSessionPro(long marketId)
/*    */     {
/* 30 */       this.marketId = marketId;
/*    */     }
/*    */     
/*    */     protected boolean processImp()
/*    */       throws Exception
/*    */     {
/* 36 */       MarketPet xMarketPet = xtable.Marketpet.get(Long.valueOf(this.marketId));
/* 37 */       if (xMarketPet == null)
/*    */       {
/* 39 */         String logStr = String.format("[market]PublicPetSessionPro.processImp@ xbean.MarketItem get null|marketId=%d", new Object[] { Long.valueOf(this.marketId) });
/*    */         
/* 41 */         MarketManager.logger.error(logStr);
/* 42 */         return false;
/*    */       }
/* 44 */       if (xMarketPet.getState() != 1)
/*    */       {
/* 46 */         String logStr = String.format("[market]PublicPetSessionPro.processImp@ xbean.MarketPet state error|roleId=%d|marketId=%d|state=%d", new Object[] { Long.valueOf(xMarketPet.getRoleid()), Long.valueOf(this.marketId), Integer.valueOf(xMarketPet.getState()) });
/*    */         
/*    */ 
/* 49 */         MarketManager.logger.error(logStr);
/* 50 */         return false;
/*    */       }
/* 52 */       xMarketPet.setState(2);
/* 53 */       long now = mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis();
/* 54 */       xMarketPet.setOnshelf_time(now);
/*    */       
/* 56 */       int subid = MarketManager.getSubidByPetId(xMarketPet.getPet().getTemplateid());
/* 57 */       if (subid != -1)
/*    */       {
/* 59 */         MarketManager.startOnSellPetPhaseSession(this.marketId, xMarketPet, MarketManager.getRecycleSeconds(xMarketPet.getPet().getTemplateid()), MarketManager.getShangjiaLengthSeconds());
/*    */         
/*    */ 
/* 62 */         if (MarketManager.isLevelSift(subid))
/*    */         {
/* 64 */           LevelSiftRankManager.deletePub(subid, this.marketId, xMarketPet.getPet().getLevel());
/* 65 */           LevelSiftRankManager.rankSell(subid, this.marketId, xMarketPet.getPet().getLevel(), xMarketPet.getPrice());
/*    */         }
/*    */         else
/*    */         {
/* 69 */           PriceRankManager.deletePub(subid, this.marketId);
/* 70 */           PriceRankManager.rankSell(subid, this.marketId, xMarketPet.getPrice());
/*    */         }
/* 72 */         MarketItemPetPriceManager.addPrice(xMarketPet.getPet().getTemplateid(), xMarketPet.getPrice());
/*    */         
/* 74 */         MarketInterface.triggerMarketPetOffShelfEvent(this.marketId, xMarketPet.getPet().getTemplateid(), true, xMarketPet.toData());
/*    */         
/* 76 */         MarketInterface.triggerMarketPetOnShelfEvent(this.marketId, xMarketPet.getPet().getTemplateid(), false);
/*    */         
/* 78 */         String logStr = String.format("[market]PublicPetSessionPro.processImp@ market pet from public to sell success|roleId=%d|marketId=%d|subid=%d|petCfgId=%d|price=%d", new Object[] { Long.valueOf(xMarketPet.getRoleid()), Long.valueOf(this.marketId), Integer.valueOf(subid), Integer.valueOf(xMarketPet.getPet().getTemplateid()), Integer.valueOf(xMarketPet.getPrice()) });
/*    */         
/*    */ 
/* 81 */         MarketManager.logger.info(logStr);
/*    */       }
/*    */       else
/*    */       {
/* 85 */         xtable.Marketpet2sessionid.remove(Long.valueOf(this.marketId));
/*    */       }
/*    */       
/* 88 */       Marketpetid2concernrole.remove(Long.valueOf(this.marketId));
/* 89 */       return true;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\market\main\PublicPetSession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */