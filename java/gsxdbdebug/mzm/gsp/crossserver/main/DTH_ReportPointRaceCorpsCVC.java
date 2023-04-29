/*    */ package mzm.gsp.crossserver.main;
/*    */ 
/*    */ import hub.DataTransferReqXidWrapper;
/*    */ import hub.DataTransferRspXidWrapper;
/*    */ import hub.ReportPointRaceCorpsCVCReq;
/*    */ import hub.ReportPointRaceCorpsCVCRsp;
/*    */ import mzm.gsp.GameServer;
/*    */ 
/*    */ public class DTH_ReportPointRaceCorpsCVC extends DataTransferHandler<ReportPointRaceCorpsCVCReq, ReportPointRaceCorpsCVCRsp>
/*    */ {
/*    */   protected ReportPointRaceCorpsCVCReq makeReqDataBean()
/*    */   {
/* 13 */     return new ReportPointRaceCorpsCVCReq();
/*    */   }
/*    */   
/*    */ 
/*    */   protected ReportPointRaceCorpsCVCRsp makeRspDataBean()
/*    */   {
/* 19 */     return new ReportPointRaceCorpsCVCRsp();
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   protected void onDataTransferReq(hub.DataTransferReq req, ReportPointRaceCorpsCVCReq reqData) {}
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   protected void onDataTransferTimeout(DataTransferReqXidWrapper reqXidWrapper, ReportPointRaceCorpsCVCReq reqData, int code)
/*    */   {
/* 33 */     GameServer.logger().error(String.format("[crossserver]DTH_ReportPointRaceCorpsCVC.onDataTransferTimeout@report point race corps cvc timeout|req=%s|req_data=%s|code=%d", new Object[] { reqXidWrapper.getProtocol(), reqData, Integer.valueOf(code) }));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   protected void onDataTransferRsp(DataTransferReqXidWrapper reqXidWrapper, ReportPointRaceCorpsCVCReq reqData, DataTransferRspXidWrapper rspXidWrapper, ReportPointRaceCorpsCVCRsp rspData)
/*    */   {
/* 44 */     GameServer.logger().info(String.format("[crossserver]DTH_ReportPointRaceCorpsCVC.onDataTransferRsp@report point race corps cvc done|req=%s|req_data=%s|rsp=%s|rsp_data=%s", new Object[] { reqXidWrapper.getProtocol(), reqData, rspXidWrapper.getProtocol(), rspData }));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\main\DTH_ReportPointRaceCorpsCVC.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */