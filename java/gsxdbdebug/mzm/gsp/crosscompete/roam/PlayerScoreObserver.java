/*    */ package mzm.gsp.crosscompete.roam;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.Map.Entry;
/*    */ import java.util.concurrent.TimeUnit;
/*    */ import mzm.gsp.crosscompete.main.CrossCompeteManager;
/*    */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*    */ import xbean.CrossCompete;
/*    */ import xbean.CrossCompeteAgainst;
/*    */ import xbean.CrossCompeteMatch;
/*    */ 
/*    */ public class PlayerScoreObserver extends mzm.gsp.timer.main.Observer
/*    */ {
/*    */   public PlayerScoreObserver()
/*    */   {
/* 16 */     super(TimeUnit.MINUTES.toSeconds(mzm.gsp.crosscompete.confbean.SCrossCompeteConsts.getInstance().PlayerScoreMinutes));
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean update()
/*    */   {
/* 22 */     NoneRealTimeTaskManager.getInstance().addTask(new RAddPlayerScore(this));
/* 23 */     return true;
/*    */   }
/*    */   
/*    */   static class RAddPlayerScore extends mzm.gsp.util.LogicRunnable
/*    */   {
/*    */     private final PlayerScoreObserver observer;
/*    */     
/*    */     RAddPlayerScore(PlayerScoreObserver observer)
/*    */     {
/* 32 */       this.observer = observer;
/*    */     }
/*    */     
/*    */     public void process()
/*    */       throws Exception
/*    */     {
/* 38 */       if (!CrossCompeteManager.isFightStage()) {
/* 39 */         stopTimer();
/* 40 */         return;
/*    */       }
/*    */       
/* 43 */       CrossCompete xCompete = CrossCompeteManager.getXCrossCompete(false);
/*    */       
/* 45 */       Iterator<Map.Entry<CrossCompeteMatch, CrossCompeteAgainst>> iter = xCompete.getAgainsts().entrySet().iterator();
/*    */       
/* 47 */       while (iter.hasNext()) {
/* 48 */         Map.Entry<CrossCompeteMatch, CrossCompeteAgainst> entry = (Map.Entry)iter.next();
/* 49 */         CrossCompeteMatch xMatch = (CrossCompeteMatch)entry.getKey();
/* 50 */         CrossCompeteAgainst xAgainst = (CrossCompeteAgainst)entry.getValue();
/* 51 */         if (xAgainst.getWinner() <= 0L)
/*    */         {
/*    */ 
/*    */ 
/* 55 */           new PAddPlayerScore(xMatch.getFront_factionid(), xMatch.getBehind_factionid()).call();
/*    */         }
/*    */       }
/*    */     }
/*    */     
/*    */     private void stopTimer() {
/* 61 */       if (this.observer != null) {
/* 62 */         this.observer.stopTimer();
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crosscompete\roam\PlayerScoreObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */