/*    */ package mzm.gsp.homeland.main;
/*    */ 
/*    */ import mzm.gsp.homeland.confbean.SHomelandCfg;
/*    */ import mzm.gsp.map.main.MapInterface;
/*    */ import mzm.gsp.map.main.TransferZoneProxyHandler;
/*    */ import mzm.gsp.map.main.scene.Position;
/*    */ import xbean.HomeInfo;
/*    */ 
/*    */ public class RoomTransferZoneProxyHandler
/*    */   implements TransferZoneProxyHandler
/*    */ {
/*    */   public Position getProxyTargetMapCfgid(long roleid, long worldid, int targetMapCfgid)
/*    */   {
/* 14 */     long creatorRoleId = HomelandInterface.getRoleByHomeWorldId(worldid, false);
/* 15 */     if (creatorRoleId == -1L)
/*    */     {
/* 17 */       return null;
/*    */     }
/* 19 */     HomeInfoWrapper homeInfoWrapper = HomelandManager.getHomeInfoWrapper(creatorRoleId);
/*    */     
/* 21 */     if (homeInfoWrapper == null)
/*    */     {
/* 23 */       return null;
/*    */     }
/* 25 */     SHomelandCfg sHomelandCfg = SHomelandCfg.get(homeInfoWrapper.getxHomeInfo().getHomelevel());
/* 26 */     if (sHomelandCfg == null)
/*    */     {
/* 28 */       return null;
/*    */     }
/*    */     
/* 31 */     int targetMapId = sHomelandCfg.mapId;
/* 32 */     int courtYardMapId = HomelandManager.getHomelandCourtyardMapId(homeInfoWrapper.getxHomeInfo().getCourtyardlevel());
/* 33 */     if (MapInterface.getSceneInstanceId(worldid, targetMapId, false) == 0)
/*    */     {
/* 35 */       HomelandManager.addAllMapEntityIntoRoom(homeInfoWrapper, courtYardMapId, targetMapId, sHomelandCfg.maidX, sHomelandCfg.maidY, worldid, targetMapId);
/*    */       
/* 37 */       HomelandManager.setHomeSceneProperty(worldid, targetMapId);
/*    */     }
/*    */     
/* 40 */     return new Position(-1, -1, -1, targetMapId);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\homeland\main\RoomTransferZoneProxyHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */