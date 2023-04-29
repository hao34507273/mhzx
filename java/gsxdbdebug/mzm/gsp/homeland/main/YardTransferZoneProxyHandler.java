/*    */ package mzm.gsp.homeland.main;
/*    */ 
/*    */ import mzm.gsp.map.main.MapInterface;
/*    */ import mzm.gsp.map.main.TransferZoneProxyHandler;
/*    */ import mzm.gsp.map.main.scene.Position;
/*    */ import xbean.HomeInfo;
/*    */ 
/*    */ public class YardTransferZoneProxyHandler
/*    */   implements TransferZoneProxyHandler
/*    */ {
/*    */   public Position getProxyTargetMapCfgid(long roleid, long worldid, int targetMapCfgid)
/*    */   {
/* 13 */     long creatorRoleId = HomelandInterface.getRoleByHomeWorldId(worldid, false);
/* 14 */     if (creatorRoleId == -1L)
/*    */     {
/* 16 */       return null;
/*    */     }
/* 18 */     HomeInfoWrapper homeInfoWrapper = HomelandManager.getHomeInfoWrapper(creatorRoleId);
/*    */     
/* 20 */     if (homeInfoWrapper == null)
/*    */     {
/* 22 */       return null;
/*    */     }
/* 24 */     int courtYardMapId = HomelandManager.getHomelandCourtyardMapId(homeInfoWrapper.getxHomeInfo().getCourtyardlevel());
/*    */     
/* 26 */     if (courtYardMapId == -1)
/*    */     {
/* 28 */       return null;
/*    */     }
/* 30 */     int targetMapId = courtYardMapId;
/* 31 */     int roomMapId = HomelandManager.getHomelandRoomMapId(homeInfoWrapper.getxHomeInfo().getHomelevel());
/*    */     
/*    */ 
/* 34 */     if (MapInterface.getSceneInstanceId(worldid, targetMapId, false) == 0)
/*    */     {
/* 36 */       HomelandManager.addAllMapEntityIntoCourtyard(homeInfoWrapper, courtYardMapId, roomMapId, worldid, courtYardMapId);
/* 37 */       HomelandManager.setHomeSceneProperty(worldid, targetMapId);
/*    */     }
/*    */     
/* 40 */     return new Position(-1, -1, -1, targetMapId);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\homeland\main\YardTransferZoneProxyHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */