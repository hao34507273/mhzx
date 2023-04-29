/*    */ package mzm.gsp.menpaipvp.main;
/*    */ 
/*    */ import mzm.gsp.timer.main.Observer;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.MenpaiPVP;
/*    */ import xdb.Procedure;
/*    */ 
/*    */ 
/*    */ class AwardObserver
/*    */   extends Observer
/*    */ {
/*    */   public AwardObserver()
/*    */   {
/* 14 */     super(MenpaiPVPConfigManager.getInstance().getPrepareAwardIntervalSeconds());
/*    */   }
/*    */   
/*    */   public boolean update()
/*    */   {
/* 19 */     Procedure.execute(new PAward(this));
/* 20 */     return true;
/*    */   }
/*    */   
/*    */   private static class PAward extends LogicProcedure
/*    */   {
/*    */     private AwardObserver observer;
/*    */     
/*    */     PAward(AwardObserver observer)
/*    */     {
/* 29 */       this.observer = observer;
/*    */     }
/*    */     
/*    */     protected boolean processImp()
/*    */       throws Exception
/*    */     {
/* 35 */       if (!MenpaiPVPManager.isPrepareStage()) {
/* 36 */         this.observer.stopTimer();
/* 37 */         return false;
/*    */       }
/*    */       
/* 40 */       MenpaiPVP xMenpaiPVP = MenpaiPVPManager.getXMenpaiPVPIfNotExist();
/* 41 */       MenpaiPVPManager.awardAllParticipants(xMenpaiPVP);
/*    */       
/* 43 */       return true;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\menpaipvp\main\AwardObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */