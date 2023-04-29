/*    */ package mzm.gsp.homeland.main;
/*    */ 
/*    */ import java.util.List;
/*    */ import mzm.gsp.map.Location;
/*    */ import mzm.gsp.map.main.MapInterface;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.HomeInfo;
/*    */ import xbean.MaidInfo;
/*    */ 
/*    */ public class PTransferMaidToReq extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final List<Location> locations;
/*    */   
/*    */   public PTransferMaidToReq(long roleId, List<Location> locations)
/*    */   {
/* 17 */     this.roleId = roleId;
/* 18 */     this.locations = locations;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 24 */     if (this.locations.isEmpty())
/*    */     {
/* 26 */       return false;
/*    */     }
/* 28 */     int targetX = ((Location)this.locations.get(this.locations.size() - 1)).x;
/* 29 */     int targetY = ((Location)this.locations.get(this.locations.size() - 1)).y;
/*    */     
/* 31 */     if (!HomelandManager.isHomeSwitchOpenForRole(this.roleId))
/*    */     {
/* 33 */       return false;
/*    */     }
/* 35 */     if (!HomelandManager.isRoleStateCanOperateHome(this.roleId))
/*    */     {
/* 37 */       String logStr = String.format("[home]PTransferMaidToReq.processImp@role state can not operate home|roleid=%d", new Object[] { Long.valueOf(this.roleId) });
/*    */       
/* 39 */       HomelandManager.logger.info(logStr);
/* 40 */       return false;
/*    */     }
/*    */     
/* 43 */     HomeInfoWrapper homeInfoWrapper = HomelandManager.getHomeInfoWrapper(this.roleId);
/* 44 */     if (homeInfoWrapper == null)
/*    */     {
/* 46 */       String logString = String.format("[home]PTransferMaidToReq.processImp@xHomeInfo is null|roleId=%d", new Object[] { Long.valueOf(this.roleId) });
/* 47 */       HomelandManager.logger.warn(logString);
/* 48 */       return false;
/*    */     }
/* 50 */     long homeWorleId = homeInfoWrapper.getHomeWorldId();
/* 51 */     if (!HomelandManager.isAtHome(this.roleId, homeWorleId))
/*    */     {
/* 53 */       String logString = String.format("[home]PTransferMaidToReq.processImp@role is not at home|roleId=%d|homeWorleId=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(homeWorleId) });
/*    */       
/* 55 */       HomelandManager.logger.info(logString);
/* 56 */       return false;
/*    */     }
/* 58 */     HomeInfo xHomeInfo = homeInfoWrapper.getxHomeInfo();
/* 59 */     MaidInfo xMaidInfo = (MaidInfo)xHomeInfo.getUuid2maidinfo().get(Long.valueOf(xHomeInfo.getCurrentmaiduuid()));
/* 60 */     if (xMaidInfo == null)
/*    */     {
/* 62 */       return false;
/*    */     }
/* 64 */     int mapid = MapInterface.getRoleMapId(this.roleId);
/* 65 */     if (mapid != HomelandManager.getHomelandRoomMapId(homeInfoWrapper.getxHomeInfo().getHomelevel()))
/*    */     {
/* 67 */       String logString = String.format("[home]PTransferMaidToReq.processImp@role is not in room map|roleId=%d|homeWorleId=%d|mapid=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(homeWorleId), Integer.valueOf(mapid) });
/*    */       
/*    */ 
/* 70 */       HomelandManager.logger.info(logString);
/* 71 */       return false;
/*    */     }
/* 73 */     if (!MapInterface.isReachable(mapid, targetX, targetY))
/*    */     {
/* 75 */       String logString = String.format("[home]PTransferMaidToReq.processImp@target is not reachable|roleId=%d|homeWorleId=%d|mapid=%d|x=%d|y=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(homeWorleId), Integer.valueOf(mapid), Integer.valueOf(targetX), Integer.valueOf(targetY) });
/*    */       
/*    */ 
/* 78 */       HomelandManager.logger.info(logString);
/* 79 */       return false;
/*    */     }
/* 81 */     long currentMaidUuid = homeInfoWrapper.getxHomeInfo().getCurrentmaiduuid();
/* 82 */     MapInterface.mapEntityMove(mzm.gsp.map.main.scene.object.MapEntityType.MGT_SERVANT, currentMaidUuid, this.locations);
/* 83 */     xMaidInfo.setX(targetX);
/* 84 */     xMaidInfo.setY(targetY);
/* 85 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\homeland\main\PTransferMaidToReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */