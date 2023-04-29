/*    */ package mzm.gsp.awardpool.main;
/*    */ 
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.awardpool.confbean.SPreciousDropCfg;
/*    */ import xbean.IdCounter;
/*    */ import xtable.Itemsubid2count;
/*    */ 
/*    */ class InitServerAwardPoolPrecious extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final int itemSubId;
/*    */   private final int clearType;
/*    */   
/*    */   public InitServerAwardPoolPrecious(int itemSubId, int clearType)
/*    */   {
/* 15 */     this.itemSubId = itemSubId;
/* 16 */     this.clearType = clearType;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 23 */     int preciousCfgId = AwardPoolManager.getPreciousCfgId(this.itemSubId);
/*    */     
/* 25 */     SPreciousDropCfg peCfg = SPreciousDropCfg.get(preciousCfgId);
/* 26 */     if (peCfg == null)
/*    */     {
/* 28 */       return false;
/*    */     }
/* 30 */     if (peCfg.serverClearTypeEnum2 == this.clearType)
/*    */     {
/* 32 */       long key = GameServerInfoManager.toGlobalId(this.itemSubId);
/*    */       
/* 34 */       IdCounter xIdCounter = Itemsubid2count.get(Long.valueOf(key));
/* 35 */       if (xIdCounter == null)
/*    */       {
/* 37 */         xIdCounter = xbean.Pod.newIdCounter();
/* 38 */         Itemsubid2count.insert(Long.valueOf(key), xIdCounter);
/*    */       }
/* 40 */       if (xIdCounter.getHistorydropcount() >= peCfg.serverMaxDropCount1)
/*    */       {
/* 42 */         xIdCounter.setDropcount(0);
/* 43 */         xIdCounter.setUnhitcount(0);
/* 44 */         xIdCounter.setModifytime(mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis());
/*    */         
/* 46 */         ItemSubidObject itemSubidObject = ItemSubIdDropcCounter.getInstance().getItemSubidObject(this.itemSubId);
/* 47 */         itemSubidObject.resetItemSubIdObject();
/*    */         
/* 49 */         String logstr = String.format("[awardpool]InitServerAwardPoolPrecious.processImp@init server itemSubid count|itemSubId=%d|clearType=%d", new Object[] { Integer.valueOf(this.itemSubId), Integer.valueOf(this.clearType) });
/*    */         
/*    */ 
/* 52 */         AwardPoolManager.logger.info(logstr);
/*    */       }
/*    */     }
/*    */     
/*    */ 
/* 57 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\awardpool\main\InitServerAwardPoolPrecious.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */