/*    */ package mzm.gsp.masswedding.main;
/*    */ 
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.map.main.ControllerInterface;
/*    */ import mzm.gsp.map.main.MapInterface;
/*    */ import mzm.gsp.masswedding.SSynMassWeddingNotifyMapRedGift;
/*    */ import mzm.gsp.masswedding.confbean.SMassWeddingConsts;
/*    */ import mzm.gsp.open.main.OpenInterface;
/*    */ import mzm.gsp.timer.main.Observer;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.MassWedding;
/*    */ import xdb.Procedure;
/*    */ 
/*    */ class MapRedGiftObserver
/*    */   extends Observer
/*    */ {
/*    */   public MapRedGiftObserver()
/*    */   {
/* 21 */     super(SMassWeddingConsts.getInstance().mapRedGiftIntervalSec);
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean update()
/*    */   {
/* 27 */     Procedure.execute(new LogicProcedure()
/*    */     {
/*    */       protected boolean processImp()
/*    */         throws Exception
/*    */       {
/* 32 */         if (!ActivityInterface.isActivityOpen(SMassWeddingConsts.getInstance().activityid)) {
/* 33 */           MapRedGiftObserver.this.stopTimer();
/* 34 */           return false;
/*    */         }
/* 36 */         if (!OpenInterface.getOpenStatus(164)) {
/* 37 */           GameServer.logger().info("[MassWedding]AwardObserver.update@TYPE_MASSWEDDING is closed");
/* 38 */           return false;
/*    */         }
/* 40 */         MassWedding xMassWedding = MassWeddingManager.getMassWedding(true);
/* 41 */         if (xMassWedding == null) {
/* 42 */           GameServer.logger().info(String.format("[MassWedding]AwardObserver.processImp@xMassWedding is null", new Object[0]));
/*    */           
/* 44 */           MapRedGiftObserver.this.stopTimer();
/* 45 */           return false;
/*    */         }
/* 47 */         if (xMassWedding.getStage() != 0) {
/* 48 */           MapRedGiftObserver.this.stopTimer();
/* 49 */           return false;
/*    */         }
/* 51 */         long worldid = xMassWedding.getWorldid();
/* 52 */         if (SMassWeddingConsts.getInstance().mapRedGiftControlid > 0) {
/* 53 */           ControllerInterface.triggerWorldControllerWithMaxSpawnNum(worldid, SMassWeddingConsts.getInstance().mapRedGiftControlid, SMassWeddingConsts.getInstance().mapRedGiftControlNum);
/*    */         }
/*    */         
/*    */ 
/*    */ 
/* 58 */         SSynMassWeddingNotifyMapRedGift synMassWeddingNotifyMapRedGift = new SSynMassWeddingNotifyMapRedGift();
/* 59 */         MapInterface.brocadCastInWorld(worldid, synMassWeddingNotifyMapRedGift, true);
/* 60 */         return true;
/*    */       }
/*    */       
/* 63 */     });
/* 64 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\masswedding\main\MapRedGiftObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */