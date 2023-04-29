/*    */ package mzm.gsp.crossserver.main;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import hub.DataTransferReq;
/*    */ import hub.DataTransferReqXidWrapper;
/*    */ import hub.DataTransferRsp;
/*    */ import hub.DataTransferRspXidWrapper;
/*    */ import hub.GHubHelper;
/*    */ import hub.PointRaceQueryReq;
/*    */ import hub.PointRaceQueryRsp;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.crossbattle.point.PointRaceManager;
/*    */ import mzm.gsp.crossbattle.point.PointRaceZoneManager;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ 
/*    */ public class DTH_PointRaceQuery
/*    */   extends DataTransferHandler<PointRaceQueryReq, PointRaceQueryRsp>
/*    */ {
/*    */   protected PointRaceQueryReq makeReqDataBean()
/*    */   {
/* 22 */     return new PointRaceQueryReq();
/*    */   }
/*    */   
/*    */ 
/*    */   protected PointRaceQueryRsp makeRspDataBean()
/*    */   {
/* 28 */     return new PointRaceQueryRsp();
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   protected void onDataTransferReq(DataTransferReq req, PointRaceQueryReq reqData)
/*    */   {
/* 35 */     DataTransferRsp rsp = new DataTransferRsp();
/* 36 */     rsp.direction = req.direction;
/* 37 */     rsp.xid = req.xid;
/* 38 */     rsp.src_id = req.dst_id;
/* 39 */     rsp.dst_id = req.src_id;
/* 40 */     rsp.data_type = req.data_type;
/*    */     
/* 42 */     long worldid = reqData.worldid;
/* 43 */     PointRaceZoneManager zoneManager = PointRaceManager.getInstance().getZoneManager(worldid);
/* 44 */     boolean exist = zoneManager != null;
/*    */     
/* 46 */     rsp.retcode = 0;
/*    */     
/* 48 */     PointRaceQueryRsp rspData = new PointRaceQueryRsp();
/* 49 */     rspData.exist = ((byte)(exist ? 1 : 0));
/*    */     
/* 51 */     OctetsStream os = new OctetsStream();
/* 52 */     os.marshal(rspData);
/* 53 */     rsp.data = os;
/*    */     
/*    */ 
/* 56 */     if (!GHubHelper.sendDataTransferRsp(rsp))
/*    */     {
/* 58 */       GameServer.logger().error(String.format("[crossserver]DTH_PointRaceQuery.onDataTransferReq@send rsp failed|req=%s|req_data=%s|rsp=%s|rsp_data=%s", new Object[] { req, reqData, rsp, rspData }));
/*    */       
/*    */ 
/*    */ 
/* 62 */       return;
/*    */     }
/*    */     
/* 65 */     GameServer.logger().info(String.format("[crossserver]DTH_PointRaceQuery.onDataTransferReq@handle point race query done|req=%s|req_data=%s|rsp=%s|rsp_data=%s", new Object[] { req, reqData, rsp, rspData }));
/*    */   }
/*    */   
/*    */   protected void onDataTransferTimeout(DataTransferReqXidWrapper reqXidWrapper, PointRaceQueryReq reqData, int code) {}
/*    */   
/*    */   protected void onDataTransferRsp(DataTransferReqXidWrapper reqXidWrapper, PointRaceQueryReq reqData, DataTransferRspXidWrapper rspXidWrapper, PointRaceQueryRsp rspData) {}
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\main\DTH_PointRaceQuery.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */