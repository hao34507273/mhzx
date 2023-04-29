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
/*    */ class AwardObserver extends Observer
/*    */ {
/*    */   public AwardObserver()
/*    */   {
/* 17 */     super(SMassWeddingConsts.getInstance().rainAwardSec);
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
/* 29 */           AwardObserver.this.stopTimer();
/* 30 */           return false;
/*    */         }
/*    */         
/* 33 */         if (!OpenInterface.getOpenStatus(164)) {
/* 34 */           GameServer.logger().info("[MassWedding]AwardObserver.update@TYPE_MASSWEDDING is closed");
/* 35 */           return false;
/*    */         }
/* 37 */         MassWedding xMassWedding = MassWeddingManager.getMassWedding(true);
/* 38 */         if (xMassWedding == null) {
/* 39 */           GameServer.logger().info(String.format("[MassWedding]AwardObserver.processImp@xMassWedding is null", new Object[0]));
/*    */           
/* 41 */           AwardObserver.this.stopTimer();
/* 42 */           return false;
/*    */         }
/* 44 */         MassWeddingManager.commonAward(xMassWedding);
/*    */         
/* 46 */         return true;
/*    */       }
/*    */       
/* 49 */     });
/* 50 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\masswedding\main\AwardObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */