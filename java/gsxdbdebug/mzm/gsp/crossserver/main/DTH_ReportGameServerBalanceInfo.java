/*    */ package mzm.gsp.crossserver.main;
/*    */ 
/*    */ import hub.DataTransferReq;
/*    */ import hub.DataTransferReqXidWrapper;
/*    */ import hub.DataTransferRspXidWrapper;
/*    */ import hub.ReportGameServerBalanceInfoReq;
/*    */ import hub.ReportGameServerBalanceInfoRsp;
/*    */ import mzm.gsp.GameServer;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ public class DTH_ReportGameServerBalanceInfo
/*    */   extends DataTransferHandler<ReportGameServerBalanceInfoReq, ReportGameServerBalanceInfoRsp>
/*    */ {
/*    */   protected ReportGameServerBalanceInfoReq makeReqDataBean()
/*    */   {
/* 16 */     return new ReportGameServerBalanceInfoReq();
/*    */   }
/*    */   
/*    */ 
/*    */   protected ReportGameServerBalanceInfoRsp makeRspDataBean()
/*    */   {
/* 22 */     return new ReportGameServerBalanceInfoRsp();
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   protected void onDataTransferReq(DataTransferReq req, ReportGameServerBalanceInfoReq reqData) {}
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   protected void onDataTransferTimeout(DataTransferReqXidWrapper reqXidWrapper, ReportGameServerBalanceInfoReq reqData, int code)
/*    */   {
/* 35 */     GameServer.logger().error(String.format("[crossserver]DTH_ReportGameServerBalanceInfo.onDataTransferTimeout@report game server balance info timeout|req=%s|req_data=%s|code=%d", new Object[] { reqXidWrapper.getProtocol(), reqData, Integer.valueOf(code) }));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   protected void onDataTransferRsp(DataTransferReqXidWrapper reqXidWrapper, ReportGameServerBalanceInfoReq reqData, DataTransferRspXidWrapper rspXidWrapper, ReportGameServerBalanceInfoRsp rspData)
/*    */   {
/* 46 */     GameServer.logger().info(String.format("[crossserver]DTH_ReportGameServerBalanceInfo.onDataTransferRsp@report game server balance info done|req=%s|req_data=%s|rsp=%s|rsp_data=%s", new Object[] { reqXidWrapper.getProtocol(), reqData, rspXidWrapper.getProtocol(), rspData }));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\main\DTH_ReportGameServerBalanceInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */