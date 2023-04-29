/*    */ package mzm.gsp.flowerparade.main;
/*    */ 
/*    */ import java.util.Random;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.activity4.confbean.FlowerParadeRestPos;
/*    */ import mzm.gsp.activity4.confbean.SFlowerParadeCfg;
/*    */ import mzm.gsp.activity4.confbean.SFlowerParadeDanceCfg;
/*    */ import mzm.gsp.flowerparade.SFlowerParadeDoDance;
/*    */ import mzm.gsp.map.main.MapInterface;
/*    */ import mzm.gsp.timer.main.MilliSession;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.FlowerParade;
/*    */ 
/*    */ public class PFlowerParadeRest extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final int posIndex;
/*    */   private final int activityId;
/*    */   
/*    */   public PFlowerParadeRest(int posIndex, int activityId)
/*    */   {
/* 22 */     this.posIndex = posIndex;
/* 23 */     this.activityId = activityId;
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
/* 35 */     xFlowerParade.setToposindex(this.posIndex);
/*    */     
/*    */ 
/* 38 */     SFlowerParadeCfg cfg = SFlowerParadeCfg.get(this.activityId);
/* 39 */     MilliSession restSession = new FlowerParadeSessionRest(cfg.restTime * 1000L, this.activityId);
/* 40 */     xFlowerParade.setSessionidrest(restSession.getSessionId());
/*    */     
/*    */ 
/* 43 */     SFlowerParadeDanceCfg danceCfg = SFlowerParadeDanceCfg.get(cfg.danceGroupId);
/* 44 */     int danceSize = danceCfg.danceList.size();
/* 45 */     int randeomDance = xdb.Xdb.random().nextInt(danceSize);
/* 46 */     xFlowerParade.setDanceindex(randeomDance);
/* 47 */     SFlowerParadeDoDance danceProtocol = new SFlowerParadeDoDance(randeomDance + 1, this.activityId);
/* 48 */     long worldid = MapInterface.getBigWorldid();
/* 49 */     MapInterface.brocadCastInWorldMap(worldid, xFlowerParade.getMapid(), danceProtocol, true);
/*    */     
/* 51 */     FlowerParadeRestPos restPos = FlowerParadeManager.getFlowerParadeRestPos(cfg.mapGroupId, xFlowerParade.getMapid(), this.posIndex);
/*    */     
/* 53 */     int regbagControllerId = restPos.redbagId;
/* 54 */     if (regbagControllerId > 0)
/*    */     {
/* 56 */       new FlowerParadeSessionMapRedbag(cfg.singDelayTime * 1000, this.activityId, regbagControllerId);
/*    */     }
/*    */     
/* 59 */     GameServer.logger().info(String.format("[flowerparade]PFlowerParadeRest.processImp@rest with dance and redbag|paradeinstance=%d|activityid=%d|posindex=%d|danceindex=%d|redbagctrl=%d", new Object[] { Long.valueOf(xFlowerParade.getFlowerinstanceid()), Integer.valueOf(this.activityId), Integer.valueOf(this.posIndex), Integer.valueOf(randeomDance), Integer.valueOf(regbagControllerId) }));
/*    */     
/*    */ 
/*    */ 
/* 63 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\flowerparade\main\PFlowerParadeRest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */