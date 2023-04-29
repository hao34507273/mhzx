/*    */ package mzm.gsp.flowerparade.main;
/*    */ 
/*    */ import java.util.Collection;
/*    */ import java.util.HashMap;
/*    */ import java.util.Random;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.activity4.confbean.SFlowerParadeCfg;
/*    */ import mzm.gsp.activity4.confbean.SFlowerParadeOcpCfg;
/*    */ import mzm.gsp.activity4.confbean.SFlowerParadeOcpGroupCfg;
/*    */ import mzm.gsp.activity4.confbean.SFlowerParadeRedbagCfg;
/*    */ import mzm.gsp.flowerparade.SFlowerParadeDoSing;
/*    */ import mzm.gsp.map.main.ControllerInterface;
/*    */ import mzm.gsp.map.main.MapInterface;
/*    */ import mzm.gsp.map.main.scene.object.MapEntityType;
/*    */ import mzm.gsp.timer.main.MilliSession;
/*    */ import xbean.FlowerParade;
/*    */ import xdb.Procedure;
/*    */ 
/*    */ public class FlowerParadeSessionMapRedbag extends MilliSession
/*    */ {
/*    */   private final int activityId;
/*    */   private final int regbagControllerId;
/*    */   
/*    */   public FlowerParadeSessionMapRedbag(long intervalMilliSeconds, int activityId, int regbagControllerId)
/*    */   {
/* 27 */     super(intervalMilliSeconds, activityId);
/* 28 */     this.activityId = activityId;
/* 29 */     this.regbagControllerId = regbagControllerId;
/*    */   }
/*    */   
/*    */ 
/*    */   protected void onTimeOut()
/*    */   {
/* 35 */     Procedure.execute(new mzm.gsp.util.LogicProcedure()
/*    */     {
/*    */ 
/*    */       protected boolean processImp()
/*    */         throws Exception
/*    */       {
/*    */ 
/* 42 */         if (!ActivityInterface.isActivityOpen(FlowerParadeSessionMapRedbag.this.activityId))
/*    */         {
/* 44 */           return false;
/*    */         }
/* 46 */         if (!FlowerParadeManager.isOpen(0L))
/*    */         {
/* 48 */           return false;
/*    */         }
/* 50 */         long localid = mzm.gsp.GameServerInfoManager.getLocalId();
/* 51 */         FlowerParade xFlowerParade = xtable.Flowerparade.get(Long.valueOf(localid));
/* 52 */         if (xFlowerParade == null)
/*    */         {
/* 54 */           return false;
/*    */         }
/* 56 */         SFlowerParadeCfg cfg = SFlowerParadeCfg.get(FlowerParadeSessionMapRedbag.this.activityId);
/* 57 */         SFlowerParadeRedbagCfg redbagCfg = SFlowerParadeRedbagCfg.get(cfg.redbagGroupId);
/* 58 */         long worldid = MapInterface.getBigWorldid();
/*    */         
/*    */ 
/* 61 */         SFlowerParadeOcpGroupCfg ocpCfg = SFlowerParadeOcpGroupCfg.get(cfg.ocpGroupId);
/* 62 */         int radius = ((SFlowerParadeOcpCfg)ocpCfg.ocpPradCfg.get(Integer.valueOf(xFlowerParade.getOcpid()))).radius;
/* 63 */         Collection<Long> currentRoleIdCollection = MapInterface.getRoleListNearbyMapEntity(MapEntityType.MET_FLOAT_PARADE, xFlowerParade.getFlowerinstanceid(), radius);
/*    */         
/* 65 */         int aroundRoleSize = currentRoleIdCollection == null ? 0 : currentRoleIdCollection.size();
/*    */         
/* 67 */         int redbagNum = aroundRoleSize * redbagCfg.countPercent / 10000;
/* 68 */         if ((redbagNum < redbagCfg.countMin) && (redbagCfg.countMin > 0))
/*    */         {
/* 70 */           redbagNum = redbagCfg.countMin;
/*    */         }
/* 72 */         if ((redbagNum > redbagCfg.countMax) && (redbagCfg.countMax > 0))
/*    */         {
/* 74 */           redbagNum = redbagCfg.countMax;
/*    */         }
/* 76 */         int actionIndex = xdb.Xdb.random().nextInt(redbagCfg.tipList.size());
/* 77 */         SFlowerParadeDoSing protocal = new SFlowerParadeDoSing(actionIndex + 1, FlowerParadeSessionMapRedbag.this.activityId);
/* 78 */         MapInterface.brocadCastInWorldMap(worldid, xFlowerParade.getMapid(), protocal, true);
/*    */         
/* 80 */         ControllerInterface.triggerWorldControllerWithMaxSpawnNum(worldid, FlowerParadeSessionMapRedbag.this.regbagControllerId, redbagNum);
/* 81 */         GameServer.logger().info(String.format("[flowerparade]FlowerParadeSessionMapRedbag.onTimeOut@redbag create info|activityid=%d|redbagctrl=%d|redbagnum=%d", new Object[] { Integer.valueOf(FlowerParadeSessionMapRedbag.this.activityId), Integer.valueOf(FlowerParadeSessionMapRedbag.this.regbagControllerId), Integer.valueOf(redbagNum) }));
/*    */         
/*    */ 
/*    */ 
/* 85 */         return true;
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\flowerparade\main\FlowerParadeSessionMapRedbag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */