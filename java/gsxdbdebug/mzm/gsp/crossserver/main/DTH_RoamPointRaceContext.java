/*    */ package mzm.gsp.crossserver.main;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import hub.DataTransferReq;
/*    */ import hub.DataTransferReqXidWrapper;
/*    */ import hub.DataTransferRsp;
/*    */ import hub.DataTransferRspXidWrapper;
/*    */ import hub.GHubHelper;
/*    */ import hub.RoamPointRaceContextReq;
/*    */ import hub.RoamPointRaceContextRsp;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.crossbattle.point.PStartPointRace;
/*    */ import mzm.gsp.crossbattle.point.PointRaceInfo;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ 
/*    */ public class DTH_RoamPointRaceContext
/*    */   extends DataTransferHandler<RoamPointRaceContextReq, RoamPointRaceContextRsp>
/*    */ {
/*    */   protected RoamPointRaceContextReq makeReqDataBean()
/*    */   {
/* 23 */     return new RoamPointRaceContextReq();
/*    */   }
/*    */   
/*    */ 
/*    */   protected RoamPointRaceContextRsp makeRspDataBean()
/*    */   {
/* 29 */     return new RoamPointRaceContextRsp();
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   protected void onDataTransferReq(DataTransferReq req, RoamPointRaceContextReq reqData)
/*    */   {
/* 36 */     DataTransferRsp rsp = new DataTransferRsp();
/* 37 */     rsp.direction = req.direction;
/* 38 */     rsp.xid = req.xid;
/* 39 */     rsp.src_id = req.dst_id;
/* 40 */     rsp.dst_id = req.src_id;
/* 41 */     rsp.data_type = req.data_type;
/*    */     
/* 43 */     PointRaceInfo pointRaceInfo = new PointRaceInfo(reqData.point_race_info);
/* 44 */     PStartPointRace pStartPointRace = new PStartPointRace(pointRaceInfo, reqData.corps_base_infos);
/* 45 */     pStartPointRace.call();
/* 46 */     long roomInstanceid = pStartPointRace.getRoomInstanceid().longValue();
/* 47 */     if (roomInstanceid > 0L)
/*    */     {
/* 49 */       rsp.retcode = 0;
/*    */     }
/*    */     else
/*    */     {
/* 53 */       rsp.retcode = 2;
/*    */     }
/*    */     
/* 56 */     RoamPointRaceContextRsp rspData = new RoamPointRaceContextRsp();
/* 57 */     rspData.roam_zoneid = GameServerInfoManager.getZoneId();
/* 58 */     rspData.roam_room_instanceid = roomInstanceid;
/*    */     
/* 60 */     OctetsStream os = new OctetsStream();
/* 61 */     os.marshal(rspData);
/* 62 */     rsp.data = os;
/*    */     
/*    */ 
/* 65 */     GHubHelper.sendDataTransferRsp(rsp);
/*    */     
/* 67 */     GameServer.logger().info(String.format("[crossserver]DTH_RoamPointRaceContext.onDataTransferReq@handle roam point race context request|req=%s|req_data=%s|rsp=%s|rsp_data=%s", new Object[] { req, reqData, rsp, rspData }));
/*    */   }
/*    */   
/*    */   protected void onDataTransferTimeout(DataTransferReqXidWrapper reqXidWrapper, RoamPointRaceContextReq reqData, int code) {}
/*    */   
/*    */   protected void onDataTransferRsp(DataTransferReqXidWrapper reqXidWrapper, RoamPointRaceContextReq reqData, DataTransferRspXidWrapper rspXidWrapper, RoamPointRaceContextRsp rspData) {}
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\main\DTH_RoamPointRaceContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */