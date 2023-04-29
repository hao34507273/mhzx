/*    */ package mzm.gsp.crossserver.main;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import hub.DataTransferReq;
/*    */ import hub.DataTransferReqXidWrapper;
/*    */ import hub.DataTransferRsp;
/*    */ import hub.DataTransferRspXidWrapper;
/*    */ import hub.GHubHelper;
/*    */ import hub.UpdatePointRaceCorpsReq;
/*    */ import hub.UpdatePointRaceCorpsRsp;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.crossbattle.point.PUpdatePointRaceCorps;
/*    */ import mzm.gsp.crossbattle.point.PointRaceCorpsInfo;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ public class DTH_UpdatePointRaceCorps extends DataTransferHandler<UpdatePointRaceCorpsReq, UpdatePointRaceCorpsRsp>
/*    */ {
/*    */   protected UpdatePointRaceCorpsReq makeReqDataBean()
/*    */   {
/* 20 */     return new UpdatePointRaceCorpsReq();
/*    */   }
/*    */   
/*    */ 
/*    */   protected UpdatePointRaceCorpsRsp makeRspDataBean()
/*    */   {
/* 26 */     return new UpdatePointRaceCorpsRsp();
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   protected void onDataTransferReq(DataTransferReq req, UpdatePointRaceCorpsReq reqData)
/*    */   {
/* 33 */     int retcode = 0;
/* 34 */     PointRaceCorpsInfo corpsInfo = new PointRaceCorpsInfo(reqData.corps_info);
/* 35 */     boolean ret = new PUpdatePointRaceCorps(reqData.activity_cfgid, reqData.time_point_cfgid, corpsInfo).call();
/* 36 */     if (!ret)
/*    */     {
/* 38 */       retcode = 2;
/*    */     }
/*    */     
/* 41 */     DataTransferRsp rsp = new DataTransferRsp();
/* 42 */     rsp.direction = req.direction;
/* 43 */     rsp.xid = req.xid;
/* 44 */     rsp.src_id = req.dst_id;
/* 45 */     rsp.dst_id = req.src_id;
/* 46 */     rsp.data_type = req.data_type;
/* 47 */     rsp.retcode = retcode;
/* 48 */     UpdatePointRaceCorpsRsp updatePointRaceCorpsRsp = new UpdatePointRaceCorpsRsp();
/* 49 */     OctetsStream os = new OctetsStream();
/* 50 */     updatePointRaceCorpsRsp.marshal(os);
/* 51 */     rsp.data = os;
/* 52 */     GHubHelper.sendDataTransferRsp(rsp);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   protected void onDataTransferTimeout(DataTransferReqXidWrapper reqXidWrapper, UpdatePointRaceCorpsReq reqData, int code)
/*    */   {
/* 59 */     GameServer.logger().error(String.format("[crossserver]DTH_UpdatePointRaceCorps.onDataTransferTimeout@update point race corps timeout|req=%s|req_data=%s|code=%d", new Object[] { reqXidWrapper.getProtocol(), reqData, Integer.valueOf(code) }));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   protected void onDataTransferRsp(DataTransferReqXidWrapper reqXidWrapper, UpdatePointRaceCorpsReq reqData, DataTransferRspXidWrapper rspXidWrapper, UpdatePointRaceCorpsRsp rspData)
/*    */   {
/* 70 */     GameServer.logger().info(String.format("[crossserver]DTH_UpdatePointRaceCorps.onDataTransferRsp@report corps fight value done|req=%s|req_data=%s|rsp=%s|rsp_data=%s", new Object[] { reqXidWrapper.getProtocol(), reqData, rspXidWrapper.getProtocol(), rspData }));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\main\DTH_UpdatePointRaceCorps.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */