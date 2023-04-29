/*    */ package mzm.gsp.awardpool.main;
/*    */ 
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*    */ import xbean.IdCounter;
/*    */ import xtable.Itemsubid2count;
/*    */ 
/*    */ public class Itemsubid2countDBSaver
/*    */ {
/*    */   public static void writeRecdor(int itemSubId, int unHitCount, int dropCount, int historyDropCount)
/*    */   {
/* 13 */     NoneRealTimeTaskManager.getInstance().addTask(new WriteItemSubIdCountPro(itemSubId, unHitCount, dropCount, historyDropCount));
/*    */   }
/*    */   
/*    */ 
/*    */   private static class WriteItemSubIdCountPro
/*    */     extends LogicProcedure
/*    */   {
/*    */     private final int itemSubId;
/*    */     
/*    */     private final int unHitCount;
/*    */     private final int dropCount;
/*    */     private final int historyDropCount;
/*    */     
/*    */     public WriteItemSubIdCountPro(int itemSubId, int unHitCount, int dropCount, int historyDropCount)
/*    */     {
/* 28 */       this.itemSubId = itemSubId;
/*    */       
/* 30 */       this.unHitCount = unHitCount;
/* 31 */       this.dropCount = dropCount;
/* 32 */       this.historyDropCount = historyDropCount;
/*    */     }
/*    */     
/*    */     protected boolean processImp()
/*    */       throws Exception
/*    */     {
/* 38 */       long key = GameServerInfoManager.toGlobalId(this.itemSubId);
/*    */       
/* 40 */       IdCounter xCounter = Itemsubid2count.get(Long.valueOf(key));
/* 41 */       if (xCounter == null)
/*    */       {
/* 43 */         xCounter = xbean.Pod.newIdCounter();
/* 44 */         Itemsubid2count.insert(Long.valueOf(key), xCounter);
/*    */       }
/*    */       
/* 47 */       xCounter.setDropcount(this.dropCount);
/* 48 */       xCounter.setHistorydropcount(this.historyDropCount);
/* 49 */       xCounter.setUnhitcount(this.unHitCount);
/* 50 */       xCounter.setModifytime(mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis());
/* 51 */       return true;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\awardpool\main\Itemsubid2countDBSaver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */