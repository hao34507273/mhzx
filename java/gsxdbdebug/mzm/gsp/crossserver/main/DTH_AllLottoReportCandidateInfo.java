/*    */ package mzm.gsp.crossserver.main;
/*    */ 
/*    */ import hub.AllLottoReportCandidateInfoReq;
/*    */ import hub.AllLottoReportCandidateInfoRsp;
/*    */ import hub.DataTransferReq;
/*    */ import hub.DataTransferReqXidWrapper;
/*    */ import hub.DataTransferRsp;
/*    */ import hub.DataTransferRspXidWrapper;
/*    */ import mzm.gsp.GameServer;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class DTH_AllLottoReportCandidateInfo
/*    */   extends DataTransferHandler<AllLottoReportCandidateInfoReq, AllLottoReportCandidateInfoRsp>
/*    */ {
/*    */   protected AllLottoReportCandidateInfoReq makeReqDataBean()
/*    */   {
/* 22 */     return new AllLottoReportCandidateInfoReq();
/*    */   }
/*    */   
/*    */ 
/*    */   protected AllLottoReportCandidateInfoRsp makeRspDataBean()
/*    */   {
/* 28 */     return new AllLottoReportCandidateInfoRsp();
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   protected void onDataTransferReq(DataTransferReq req, AllLottoReportCandidateInfoReq reqData) {}
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   protected void onDataTransferRsp(DataTransferReqXidWrapper reqXidWrapper, AllLottoReportCandidateInfoReq reqData, DataTransferRspXidWrapper rspXidWrapper, AllLottoReportCandidateInfoRsp rspData)
/*    */   {
/* 41 */     GameServer.logger().info(String.format("[crossserver]DTH_AllLottoReportCandidateInfo.onDataTransferRsp@all lotto report candidate info rsp|req=%s|req_data=%s|rsp=%s|rsp_data=%s|success=%b", new Object[] { reqXidWrapper.getProtocol(), reqData, rspXidWrapper.getProtocol(), rspData, Boolean.valueOf(rspXidWrapper.getProtocol().retcode == 0 ? 1 : false) }));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   protected void onDataTransferTimeout(DataTransferReqXidWrapper reqXidWrapper, AllLottoReportCandidateInfoReq reqData, int code)
/*    */   {
/* 52 */     GameServer.logger().error(String.format("[crossserver]DTH_AllLottoReportCandidateInfo.onDataTransferTimeout@all lotto report candidate info timeout|req=%s|req_data=%s|code=%d", new Object[] { reqXidWrapper.getProtocol(), reqData, Integer.valueOf(code) }));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\main\DTH_AllLottoReportCandidateInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */