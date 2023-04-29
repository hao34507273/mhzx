/*    */ package mzm.gsp.arena.main;
/*    */ 
/*    */ import mzm.gsp.arena.confbean.SArenaConsts;
/*    */ import mzm.gsp.timer.main.Observer;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.ArenaTmp;
/*    */ import xdb.Procedure;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class AwardObserver
/*    */   extends Observer
/*    */ {
/*    */   public AwardObserver()
/*    */   {
/* 17 */     super(SArenaConsts.getInstance().PrepareAwardMinutes * 60);
/*    */   }
/*    */   
/*    */   public boolean update()
/*    */   {
/* 22 */     Procedure.execute(new PAward(this));
/*    */     
/* 24 */     return true;
/*    */   }
/*    */   
/*    */   private static class PAward extends LogicProcedure
/*    */   {
/*    */     private AwardObserver observer;
/*    */     
/*    */     PAward(AwardObserver observer)
/*    */     {
/* 33 */       this.observer = observer;
/*    */     }
/*    */     
/*    */     protected boolean processImp()
/*    */       throws Exception
/*    */     {
/* 39 */       if (!ArenaManager.isPrepareStage()) {
/* 40 */         this.observer.stopTimer();
/* 41 */         return false;
/*    */       }
/*    */       
/* 44 */       ArenaTmp xArenaTmp = ArenaManager.getXArenaTmpIfNotExist();
/* 45 */       ArenaManager.awardAllParticipants(xArenaTmp);
/*    */       
/* 47 */       return true;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\arena\main\AwardObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */