/*    */ package mzm.gsp.flowerparade.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.HashMap;
/*    */ import java.util.List;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.activity4.confbean.FlowerParadeMapCfg;
/*    */ import mzm.gsp.activity4.confbean.FlowerParadePos;
/*    */ import mzm.gsp.activity4.confbean.SFlowerParadeCfg;
/*    */ import mzm.gsp.activity4.confbean.SFlowerParadeMapGroupCfg;
/*    */ import mzm.gsp.map.Location;
/*    */ import mzm.gsp.map.main.MapCallback;
/*    */ import mzm.gsp.map.main.MapInterface;
/*    */ import mzm.gsp.map.main.scene.object.MapEntityType;
/*    */ import mzm.gsp.map.main.scene.zone.ZoneForm;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.FlowerParade;
/*    */ 
/*    */ public class PFlowerParadeMove extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final int activityId;
/*    */   
/*    */   public PFlowerParadeMove(int activityId)
/*    */   {
/* 26 */     this.activityId = activityId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 32 */     long localid = GameServerInfoManager.getLocalId();
/* 33 */     FlowerParade xFlowerParade = xtable.Flowerparade.get(Long.valueOf(localid));
/* 34 */     if (xFlowerParade == null)
/*    */     {
/* 36 */       return false;
/*    */     }
/* 38 */     SFlowerParadeCfg cfg = SFlowerParadeCfg.get(this.activityId);
/* 39 */     SFlowerParadeMapGroupCfg mapGrpCfg = SFlowerParadeMapGroupCfg.get(cfg.mapGroupId);
/* 40 */     FlowerParadeMapCfg mCfg = (FlowerParadeMapCfg)mapGrpCfg.map2Pos.get(Integer.valueOf(xFlowerParade.getMapid()));
/* 41 */     int newPosIndex = xFlowerParade.getToposindex() + 1;
/* 42 */     FlowerParadePos newPos = FlowerParadeManager.getFlowerParadePos(mCfg.pathId, newPosIndex);
/* 43 */     xFlowerParade.setToposindex(newPosIndex);
/* 44 */     xFlowerParade.setState(1);
/*    */     
/*    */ 
/* 47 */     int radius = FlowerParadeConfig.REST_ZONE_WIDTH / 2;
/* 48 */     Location location = new Location(newPos.x, newPos.y);
/* 49 */     ZoneForm zoneForm = new FlowerParadeRestPosZoneForm(location.x, location.y, radius);
/* 50 */     int sceneId = xFlowerParade.getMapid();
/* 51 */     FlowerParadeRestPosZoneListener listener = new FlowerParadeRestPosZoneListener(sceneId, xFlowerParade.getFlowerinstanceid(), newPosIndex, this.activityId);
/*    */     
/*    */ 
/*    */ 
/* 55 */     MapCallback<Integer> callback = new FlowerParadeRestPosRegCallback(listener);
/* 56 */     MapInterface.registerZoneEvent(sceneId, zoneForm, listener, callback);
/*    */     
/* 58 */     GameServer.logger().info(String.format("[flowerparade]PFlowerParadeMove.processImp@start move|paradeinstance=%d|activityid=%d|newposindex=%d", new Object[] { Long.valueOf(xFlowerParade.getFlowerinstanceid()), Integer.valueOf(this.activityId), Integer.valueOf(newPosIndex) }));
/*    */     
/*    */ 
/*    */ 
/*    */ 
/* 63 */     List<Location> keyPathList = new ArrayList();
/* 64 */     keyPathList.add(location);
/* 65 */     int velocity = cfg.paradeVelocity;
/* 66 */     MapInterface.mapEntityMove(MapEntityType.MET_FLOAT_PARADE, xFlowerParade.getFlowerinstanceid(), keyPathList, velocity);
/* 67 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\flowerparade\main\PFlowerParadeMove.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */