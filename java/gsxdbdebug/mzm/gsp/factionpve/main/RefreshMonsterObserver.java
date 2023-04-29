/*    */ package mzm.gsp.factionpve.main;
/*    */ 
/*    */ import mzm.gsp.factionpve.confbean.SFactionPVEConsts;
/*    */ import mzm.gsp.map.main.ControllerInterface;
/*    */ import mzm.gsp.timer.main.Observer;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*    */ import xbean.FactionPVETmp;
/*    */ 
/*    */ 
/*    */ 
/*    */ class RefreshMonsterObserver
/*    */   extends Observer
/*    */ {
/*    */   private final long factionid;
/*    */   
/*    */   RefreshMonsterObserver(long factionid, int seconds)
/*    */   {
/* 19 */     super(seconds);
/* 20 */     this.factionid = factionid;
/*    */   }
/*    */   
/*    */   public boolean update()
/*    */   {
/* 25 */     NoneRealTimeTaskManager.getInstance().addTask(new PRefreshMonster(this.factionid, this));
/*    */     
/* 27 */     return true;
/*    */   }
/*    */   
/*    */   static class PRefreshMonster extends LogicProcedure
/*    */   {
/*    */     private final long factionid;
/*    */     private final RefreshMonsterObserver monsterObserver;
/*    */     
/*    */     PRefreshMonster(long factionid, RefreshMonsterObserver monsterObserver)
/*    */     {
/* 37 */       this.factionid = factionid;
/* 38 */       this.monsterObserver = monsterObserver;
/*    */     }
/*    */     
/*    */     protected boolean processImp() throws Exception
/*    */     {
/* 43 */       FactionPVETmp xFactionPVETmp = FactionPVEManager.getXFactionPVETmpIfNotExist(this.factionid);
/*    */       
/* 45 */       if (!FactionPVEManager.isStageCanEnter(xFactionPVETmp.getStage())) {
/* 46 */         this.monsterObserver.stopTimer();
/* 47 */         return false;
/*    */       }
/*    */       
/* 50 */       if (xFactionPVETmp.getWorld() > 0L) {
/* 51 */         ControllerInterface.triggerOrReSpawn(xFactionPVETmp.getWorld(), SFactionPVEConsts.getInstance().MonsterController);
/*    */       }
/*    */       
/*    */ 
/* 55 */       return true;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\factionpve\main\RefreshMonsterObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */