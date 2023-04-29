/*    */ package mzm.gsp.singlebattle.main;
/*    */ 
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.timer.main.Observer;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class SynBattleInfoObserver
/*    */   extends Observer
/*    */ {
/*    */   private final long _battleId;
/*    */   
/*    */   public SynBattleInfoObserver(long battleId, int second)
/*    */   {
/* 22 */     super(second);
/* 23 */     this._battleId = battleId;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean update()
/*    */   {
/* 29 */     BattleTaskOneByOne.getInstance().addLogicProcedure(Long.valueOf(this._battleId), new PSynBattleSource(this));
/* 30 */     return true;
/*    */   }
/*    */   
/*    */   private class PSynBattleSource extends LogicProcedure
/*    */   {
/*    */     private SynBattleInfoObserver observer;
/*    */     
/*    */     PSynBattleSource(SynBattleInfoObserver observer)
/*    */     {
/* 39 */       this.observer = observer;
/*    */     }
/*    */     
/*    */ 
/*    */     protected boolean processImp()
/*    */       throws Exception
/*    */     {
/* 46 */       SingleBattleGlobalInfo globalInfo = SingleBattleManager.getBattleGlobalInfo(SynBattleInfoObserver.this._battleId, true);
/* 47 */       if (globalInfo == null)
/*    */       {
/* 49 */         this.observer.stopTimer();
/* 50 */         GameServer.logger().error(String.format("[singlebattle]PSynBattleSource.processImp@ no xGlobalInfo! |battleId=%d", new Object[] { Long.valueOf(SynBattleInfoObserver.this._battleId) }));
/*    */         
/* 52 */         return false;
/*    */       }
/* 54 */       if ((globalInfo.getStage() == 3) || (globalInfo.getStage() == 4))
/*    */       {
/*    */ 
/* 57 */         this.observer.stopTimer();
/* 58 */         GameServer.logger().info(String.format("[singlebattle]PSynBattleSource.processImp@ clean stage, stop timer! |battleId=%d", new Object[] { Long.valueOf(SynBattleInfoObserver.this._battleId) }));
/*    */         
/*    */ 
/* 61 */         return false;
/*    */       }
/* 63 */       globalInfo.battleSourceInfoBro();
/* 64 */       return true;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\singlebattle\main\SynBattleInfoObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */