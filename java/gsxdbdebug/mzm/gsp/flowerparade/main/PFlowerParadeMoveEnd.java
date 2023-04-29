/*    */ package mzm.gsp.flowerparade.main;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.List;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.activity4.confbean.FlowerParadeMapCfg;
/*    */ import mzm.gsp.activity4.confbean.SFlowerParadeCfg;
/*    */ import mzm.gsp.activity4.confbean.SFlowerParadeMapGroupCfg;
/*    */ import mzm.gsp.timer.main.MilliSession;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.FlowerParade;
/*    */ import xdb.Procedure;
/*    */ 
/*    */ public class PFlowerParadeMoveEnd extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final int activityId;
/*    */   private final int posIndex;
/*    */   
/*    */   public PFlowerParadeMoveEnd(int activityId, int posIndex)
/*    */   {
/* 22 */     this.activityId = activityId;
/* 23 */     this.posIndex = posIndex;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 29 */     long localid = GameServerInfoManager.getLocalId();
/* 30 */     FlowerParade xFlowerParade = xtable.Flowerparade.get(Long.valueOf(localid));
/* 31 */     if (xFlowerParade == null)
/*    */     {
/* 33 */       return false;
/*    */     }
/* 35 */     xFlowerParade.setState(0);
/*    */     
/* 37 */     SFlowerParadeCfg cfg = SFlowerParadeCfg.get(this.activityId);
/* 38 */     SFlowerParadeMapGroupCfg mapGroupCfg = SFlowerParadeMapGroupCfg.get(cfg.mapGroupId);
/* 39 */     FlowerParadeMapCfg mapCfg = (FlowerParadeMapCfg)mapGroupCfg.map2Pos.get(Integer.valueOf(xFlowerParade.getMapid()));
/* 40 */     List<mzm.gsp.activity4.confbean.FlowerParadePos> posList = FlowerParadeManager.getAllPos(mapCfg.pathId);
/* 41 */     int posSize = posList.size();
/* 42 */     int currentSize = xFlowerParade.getToposindex();
/* 43 */     if (posSize == currentSize)
/*    */     {
/*    */ 
/* 46 */       GameServer.logger().info(String.format("[flowerparade]PFlowerParadeMoveEnd.processImp@move end at final pos|paradeinstance=%d|activityid=%d|posindex=%d", new Object[] { Long.valueOf(xFlowerParade.getFlowerinstanceid()), Integer.valueOf(this.activityId), Integer.valueOf(this.posIndex) }));
/*    */       
/*    */ 
/*    */ 
/* 50 */       int stopDuration = cfg.endRestTime;
/*    */       
/*    */ 
/* 53 */       MilliSession session = new FlowerParadeSessionStopCountdown(stopDuration * 1000, this.activityId);
/* 54 */       xFlowerParade.setSessionidstopcountdown(session.getSessionId());
/*    */     }
/*    */     else
/*    */     {
/* 58 */       boolean isRestPos = FlowerParadeManager.isRestPos(cfg.mapGroupId, xFlowerParade.getMapid(), xFlowerParade.getToposindex());
/*    */       
/* 60 */       if (isRestPos)
/*    */       {
/*    */ 
/* 63 */         GameServer.logger().info(String.format("[flowerparade]PFlowerParadeMoveEnd.processImp@move end at a rest pos and start to rest|paradeinstance=%d|activityid=%d|posindex=%d", new Object[] { Long.valueOf(xFlowerParade.getFlowerinstanceid()), Integer.valueOf(this.activityId), Integer.valueOf(this.posIndex) }));
/*    */         
/*    */ 
/*    */ 
/* 67 */         Procedure.execute(new PFlowerParadeRest(this.posIndex, this.activityId));
/*    */       }
/*    */       else
/*    */       {
/* 71 */         GameServer.logger().info(String.format("[flowerparade]PFlowerParadeMoveEnd.processImp@move end at a key point and will continue to move|paradeinstance=%d|activityid=%d|posindex=%d", new Object[] { Long.valueOf(xFlowerParade.getFlowerinstanceid()), Integer.valueOf(this.activityId), Integer.valueOf(this.posIndex) }));
/*    */         
/*    */ 
/*    */ 
/* 75 */         Procedure.execute(new PFlowerParadeMove(this.activityId));
/*    */       }
/*    */     }
/*    */     
/* 79 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\flowerparade\main\PFlowerParadeMoveEnd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */