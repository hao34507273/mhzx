/*    */ package mzm.gsp.flowerparade.main;
/*    */ 
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.flowerparade.SFlowerParadeEnd;
/*    */ import mzm.gsp.map.main.MapInterface;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.timer.main.MilliSession;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.FlowerParade;
/*    */ import xtable.Flowerparade;
/*    */ 
/*    */ public class PFlowerParadeStop extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   final int activityId;
/*    */   
/*    */   public PFlowerParadeStop(int activityId)
/*    */   {
/* 19 */     this.activityId = activityId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 25 */     long localid = GameServerInfoManager.getLocalId();
/* 26 */     FlowerParade xFlowerParade = Flowerparade.get(Long.valueOf(localid));
/* 27 */     if (xFlowerParade == null)
/*    */     {
/* 29 */       return false;
/*    */     }
/* 31 */     GameServer.logger().info(String.format("[flowerparade]PFlowerParadeStop.processImp@flowerparade end|paradeinstance=%d|activityid=%d", new Object[] { Long.valueOf(xFlowerParade.getFlowerinstanceid()), Integer.valueOf(this.activityId) }));
/*    */     
/*    */ 
/*    */ 
/* 35 */     if (xFlowerParade.getSessionidcountdown() != 0L)
/*    */     {
/* 37 */       MilliSession.removeSession(xFlowerParade.getSessionidcountdown());
/* 38 */       xFlowerParade.setSessionidcountdown(0L);
/*    */     }
/*    */     
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 48 */     FlowerParadeManager.stopUpdateFollowerObserver();
/*    */     
/*    */ 
/* 51 */     long restSessionId = xFlowerParade.getSessionidrest();
/* 52 */     if (restSessionId != 0L)
/*    */     {
/* 54 */       MilliSession.removeSession(restSessionId);
/* 55 */       xFlowerParade.setSessionidrest(0L);
/*    */     }
/*    */     
/*    */ 
/* 59 */     long stopSessionId = xFlowerParade.getSessionidstopcountdown();
/* 60 */     if (stopSessionId != 0L)
/*    */     {
/* 62 */       MilliSession.removeSession(stopSessionId);
/* 63 */       xFlowerParade.setSessionidstopcountdown(0L);
/*    */     }
/*    */     
/* 66 */     Flowerparade.remove(Long.valueOf(localid));
/*    */     
/* 68 */     MapInterface.removeMapEntity(mzm.gsp.map.main.scene.object.MapEntityType.MET_FLOAT_PARADE, xFlowerParade.getFlowerinstanceid(), null);
/*    */     
/*    */ 
/* 71 */     FlowerParadeManager.recycleRedbag(this.activityId);
/*    */     
/*    */ 
/* 74 */     SFlowerParadeEnd protocol = new SFlowerParadeEnd(this.activityId);
/* 75 */     OnlineManager.getInstance().sendAll(protocol);
/*    */     
/* 77 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\flowerparade\main\PFlowerParadeStop.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */