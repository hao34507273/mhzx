/*    */ package mzm.gsp.chart.main;
/*    */ 
/*    */ import mzm.gsp.timer.main.Observer;
/*    */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*    */ 
/*    */ class RankDBObserver extends Observer
/*    */ {
/*    */   RankDBObserver(int intervalSeconds)
/*    */   {
/* 10 */     super(intervalSeconds);
/*    */   }
/*    */   
/*    */   public boolean update()
/*    */   {
/* 15 */     NoneRealTimeTaskManager.getInstance().addTask(new mzm.gsp.util.LogicRunnable()
/*    */     {
/*    */       public void process()
/*    */       {
/* 19 */         RankDBManager.getInstance().onRankDBObserverUpdate();
/*    */       }
/* 21 */     });
/* 22 */     int originalSeconds = RankDBManager.getInstance().getSaveDbIntervalSec();
/* 23 */     if (originalSeconds != getIntervalSeconds()) {
/* 24 */       new RankDBObserver(originalSeconds);
/* 25 */       return false;
/*    */     }
/* 27 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chart\main\RankDBObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */