/*    */ package mzm.gsp.market.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.market.confbean.SMarketSupplyItemCfg;
/*    */ import mzm.gsp.timer.main.Session;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.MarketChannelIds;
/*    */ 
/*    */ class MarketSupplySession extends Session
/*    */ {
/*    */   public MarketSupplySession(long interval, long itemIdOrPetCfgId)
/*    */   {
/* 14 */     super(interval, itemIdOrPetCfgId);
/*    */   }
/*    */   
/*    */ 
/*    */   protected void onTimeOut()
/*    */   {
/* 20 */     new POnMarketSupplySessionTimeOutPro((int)getOwerId()).execute();
/*    */   }
/*    */   
/*    */   private static class POnMarketSupplySessionTimeOutPro
/*    */     extends mzm.gsp.util.LogicProcedure
/*    */   {
/*    */     private final int itemIdOrPetCfgId;
/*    */     
/*    */     public POnMarketSupplySessionTimeOutPro(int itemIdOrPetCfgId)
/*    */     {
/* 30 */       this.itemIdOrPetCfgId = itemIdOrPetCfgId;
/*    */     }
/*    */     
/*    */     protected boolean processImp()
/*    */       throws Exception
/*    */     {
/* 36 */       MarketSupplySessionIdManager.getInstance().removeSession(this.itemIdOrPetCfgId);
/* 37 */       SMarketSupplyItemCfg sMarketSupplyItemCfg = SMarketSupplyItemCfg.get(this.itemIdOrPetCfgId);
/* 38 */       if (sMarketSupplyItemCfg != null)
/*    */       {
/* 40 */         MarketChannelIds xChannelIds = MarketManager.getMarketItemChannelIdsOnAdd(this.itemIdOrPetCfgId);
/* 41 */         if (xChannelIds.getSupply_num() >= sMarketSupplyItemCfg.daySupplyNum)
/*    */         {
/* 43 */           String logStr = String.format("[market]POnMarketSupplySessionTimeOutPro.processImp@market supply num to day max|itemid=%d|supply_num=%d", new Object[] { Integer.valueOf(this.itemIdOrPetCfgId), Integer.valueOf(xChannelIds.getSupply_num()) });
/*    */           
/*    */ 
/* 46 */           MarketManager.logger.info(logStr);
/* 47 */           return false;
/*    */         }
/*    */         
/* 50 */         int supplyNum = MarketManager.randomSupplyItemNum(sMarketSupplyItemCfg, xChannelIds);
/*    */         
/* 52 */         Map<Integer, Integer> index2GridNums = MarketManager.randomSupplyItemGridsNum(this.itemIdOrPetCfgId, supplyNum);
/* 53 */         if ((index2GridNums == null) || (index2GridNums.isEmpty()))
/*    */         {
/* 55 */           String logStr = String.format("[market]POnMarketSupplySessionTimeOutPro.processImp@random grid num error|itemid=%d|supplyNum=%d", new Object[] { Integer.valueOf(this.itemIdOrPetCfgId), Integer.valueOf(supplyNum) });
/*    */           
/*    */ 
/* 58 */           MarketManager.logger.error(logStr);
/* 59 */           return false;
/*    */         }
/* 61 */         for (Iterator i$ = index2GridNums.values().iterator(); i$.hasNext();) { int num = ((Integer)i$.next()).intValue();
/*    */           
/* 63 */           new SupplyItemPro(this.itemIdOrPetCfgId, num).execute();
/*    */           
/* 65 */           String logStr = String.format("[market]POnMarketSupplySessionTimeOutPro.processImp@try to supply item|itemid=%d|supply_num=%d", new Object[] { Integer.valueOf(this.itemIdOrPetCfgId), Integer.valueOf(num) });
/*    */           
/*    */ 
/* 68 */           MarketManager.logger.info(logStr);
/*    */         }
/*    */         
/* 71 */         return true;
/*    */       }
/*    */       
/*    */ 
/*    */ 
/*    */ 
/* 77 */       return true;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\market\main\MarketSupplySession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */