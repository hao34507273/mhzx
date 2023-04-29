/*    */ package mzm.gsp.masswedding.main;
/*    */ 
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.masswedding.confbean.SMassWeddingConsts;
/*    */ import mzm.gsp.open.main.OpenInterface;
/*    */ import mzm.gsp.timer.main.Observer;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.MassWedding;
/*    */ import xdb.Procedure;
/*    */ 
/*    */ class RedGiftObserver extends Observer
/*    */ {
/*    */   public RedGiftObserver()
/*    */   {
/* 17 */     super(SMassWeddingConsts.getInstance().redGiftIntervalSec);
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean update()
/*    */   {
/* 23 */     Procedure.execute(new LogicProcedure()
/*    */     {
/*    */       protected boolean processImp()
/*    */         throws Exception
/*    */       {
/* 28 */         if (!ActivityInterface.isActivityOpen(SMassWeddingConsts.getInstance().activityid)) {
/* 29 */           RedGiftObserver.this.stopTimer();
/* 30 */           return false;
/*    */         }
/* 32 */         if (!OpenInterface.getOpenStatus(164)) {
/* 33 */           GameServer.logger().info("[MassWedding]AwardObserver.update@TYPE_MASSWEDDING is closed");
/* 34 */           return false;
/*    */         }
/* 36 */         MassWedding xMassWedding = MassWeddingManager.getMassWedding(true);
/* 37 */         if (xMassWedding == null) {
/* 38 */           GameServer.logger().info(String.format("[MassWedding]AwardObserver.processImp@xMassWedding is null", new Object[0]));
/*    */           
/* 40 */           RedGiftObserver.this.stopTimer();
/* 41 */           return false;
/*    */         }
/* 43 */         MassWeddingManager.redGigtAward(xMassWedding);
/*    */         
/* 45 */         return true;
/*    */       }
/*    */       
/* 48 */     });
/* 49 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\masswedding\main\RedGiftObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */