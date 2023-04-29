/*    */ package mzm.gsp.crossserver.main;
/*    */ 
/*    */ import com.goldhuman.Common.Octets;
/*    */ import hub.DataTransferReq;
/*    */ import hub.DataTransferReqXidWrapper;
/*    */ import hub.DataTransferRsp;
/*    */ import hub.DataTransferRspXidWrapper;
/*    */ import hub.GHubHelper;
/*    */ import hub.ModifyRoamServerDateReq;
/*    */ import hub.ModifyRoamServerDateRsp;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ public class DTH_ModifyRoamServerDate extends DataTransferHandler<ModifyRoamServerDateReq, ModifyRoamServerDateRsp>
/*    */ {
/*    */   protected ModifyRoamServerDateReq makeReqDataBean()
/*    */   {
/* 19 */     return new ModifyRoamServerDateReq();
/*    */   }
/*    */   
/*    */ 
/*    */   protected ModifyRoamServerDateRsp makeRspDataBean()
/*    */   {
/* 25 */     return null;
/*    */   }
/*    */   
/*    */ 
/*    */   protected void onDataTransferReq(DataTransferReq req, ModifyRoamServerDateReq reqData)
/*    */   {
/* 31 */     DataTransferRsp rsp = new DataTransferRsp();
/* 32 */     rsp.direction = req.direction;
/* 33 */     rsp.xid = req.xid;
/* 34 */     rsp.src_id = req.dst_id;
/* 35 */     rsp.dst_id = req.src_id;
/* 36 */     rsp.data_type = req.data_type;
/* 37 */     String dateValue = reqData.date_args.getString("UTF-8");
/* 38 */     rsp.retcode = (GameServerInfoManager.setDateForGM(dateValue, 0L) ? 0 : 2);
/*    */     
/* 40 */     GameServer.logger().info(String.format("[crossserver]DTH_ModifyRoamServerDate.onDataTransferReq@handle modify roam server date request|req=%s|req_data=%s|rsp=%s", new Object[] { req, reqData, rsp }));
/*    */     
/*    */ 
/*    */ 
/*    */ 
/* 45 */     GHubHelper.sendDataTransferRsp(rsp);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   protected void onDataTransferTimeout(DataTransferReqXidWrapper reqXidWrapper, ModifyRoamServerDateReq reqData, int code)
/*    */   {
/* 52 */     GameServer.logger().error(String.format("[crossserver]DTH_ModifyRoamServerDate.onDataTransferTimeout@modify roam server date timeout|req=%s|req_data=%s|code=%d", new Object[] { reqXidWrapper.getProtocol(), reqData, Integer.valueOf(code) }));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   protected void onDataTransferRsp(DataTransferReqXidWrapper reqXidWrapper, ModifyRoamServerDateReq reqData, DataTransferRspXidWrapper rspXidWrapper, ModifyRoamServerDateRsp rspData)
/*    */   {
/* 62 */     GameServer.logger().info(String.format("[crossserver]DTH_ModifyRoamServerDate.onDataTransferRsp@modify roam server date done|req=%s|req_data=%s|rsp=%s|rsp_data=%s", new Object[] { reqXidWrapper.getProtocol(), reqData, rspXidWrapper.getProtocol(), rspData }));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\main\DTH_ModifyRoamServerDate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */