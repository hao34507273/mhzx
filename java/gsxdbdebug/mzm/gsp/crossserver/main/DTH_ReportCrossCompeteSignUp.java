/*    */ package mzm.gsp.crossserver.main;
/*    */ 
/*    */ import hub.DataTransferReq;
/*    */ import hub.DataTransferReqXidWrapper;
/*    */ import hub.DataTransferRspXidWrapper;
/*    */ import hub.ReportCrossCompeteSignUpReq;
/*    */ import hub.ReportCrossCompeteSignUpRsp;
/*    */ import mzm.event.TriggerEventsManger;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.crossserver.event.ReportCrossCompeteSignUpDone;
/*    */ import mzm.gsp.crossserver.event.ReportCrossCompeteSignUpDoneArg;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class DTH_ReportCrossCompeteSignUp
/*    */   extends DataTransferHandler<ReportCrossCompeteSignUpReq, ReportCrossCompeteSignUpRsp>
/*    */ {
/*    */   protected ReportCrossCompeteSignUpReq makeReqDataBean()
/*    */   {
/* 23 */     return new ReportCrossCompeteSignUpReq();
/*    */   }
/*    */   
/*    */   protected ReportCrossCompeteSignUpRsp makeRspDataBean()
/*    */   {
/* 28 */     return new ReportCrossCompeteSignUpRsp();
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   protected void onDataTransferReq(DataTransferReq req, ReportCrossCompeteSignUpReq reqData) {}
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   protected void onDataTransferRsp(DataTransferReqXidWrapper reqXidWrapper, ReportCrossCompeteSignUpReq reqData, DataTransferRspXidWrapper rspXidWrapper, ReportCrossCompeteSignUpRsp rspData)
/*    */   {
/* 43 */     ReportCrossCompeteSignUpDoneArg arg = new ReportCrossCompeteSignUpDoneArg(rspData.result, rspData.start_mills, rspData.againsts, rspData.miss_turn_factions);
/*    */     
/* 45 */     TriggerEventsManger.getInstance().triggerEvent(new ReportCrossCompeteSignUpDone(), arg);
/*    */     
/* 47 */     GameServer.logger().info(String.format("[crosscompete]DTH_ReportCrossCompeteSignUp.onDataTransferRsp@report cross compete sign up done|req=%s|req_data=%s|rsp=%s|rsp_data=%s", new Object[] { reqXidWrapper.getProtocol(), reqData, rspXidWrapper.getProtocol(), rspData }));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   protected void onDataTransferTimeout(DataTransferReqXidWrapper reqXidWrapper, ReportCrossCompeteSignUpReq reqData, int code)
/*    */   {
/* 57 */     GameServer.logger().error(String.format("[crosscompete]DTH_ReportCrossCompeteSignUp.onDataTransferTimeout@report cross compete sign up timeout|req=%s|req_data=%s|code=%d", new Object[] { reqXidWrapper.getProtocol(), reqData, Integer.valueOf(code) }));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\main\DTH_ReportCrossCompeteSignUp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */