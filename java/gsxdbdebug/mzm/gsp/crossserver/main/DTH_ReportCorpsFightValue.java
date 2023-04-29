/*    */ package mzm.gsp.crossserver.main;
/*    */ 
/*    */ import hub.DataTransferReq;
/*    */ import hub.DataTransferReqXidWrapper;
/*    */ import hub.DataTransferRspXidWrapper;
/*    */ import hub.ReportCorpsFightValueReq;
/*    */ import hub.ReportCorpsFightValueRsp;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.crossbattle.main.CrossBattleOneByOneManager;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ public class DTH_ReportCorpsFightValue extends DataTransferHandler<ReportCorpsFightValueReq, ReportCorpsFightValueRsp>
/*    */ {
/*    */   protected ReportCorpsFightValueReq makeReqDataBean()
/*    */   {
/* 16 */     return new ReportCorpsFightValueReq();
/*    */   }
/*    */   
/*    */ 
/*    */   protected ReportCorpsFightValueRsp makeRspDataBean()
/*    */   {
/* 22 */     return new ReportCorpsFightValueRsp();
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   protected void onDataTransferReq(DataTransferReq req, ReportCorpsFightValueReq reqData) {}
/*    */   
/*    */ 
/*    */ 
/*    */   protected void onDataTransferTimeout(DataTransferReqXidWrapper reqXidWrapper, ReportCorpsFightValueReq reqData, int code)
/*    */   {
/* 34 */     GameServer.logger().error(String.format("[crossserver]DTH_ReportCorpsFightValue.onDataTransferTimeout@report corps fight value timeout|req=%s|req_data=%s|code=%d", new Object[] { reqXidWrapper.getProtocol(), reqData, Integer.valueOf(code) }));
/*    */     
/*    */ 
/*    */ 
/*    */ 
/* 39 */     boolean force = reqData.force == 1;
/* 40 */     if (!CrossServerInterface.reportCorpsFightValue(reqData.activity_cfgid, reqData.zone_num, force, reqData.corps))
/*    */     {
/* 42 */       GameServer.logger().error("[crossserver]DTH_ReportCorpsFightValue.onDataTransferTimeout@report corps fight value again failed");
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   protected void onDataTransferRsp(DataTransferReqXidWrapper reqXidWrapper, ReportCorpsFightValueReq reqData, DataTransferRspXidWrapper rspXidWrapper, ReportCorpsFightValueRsp rspData)
/*    */   {
/* 51 */     if (rspXidWrapper.getProtocol().retcode != 0)
/*    */     {
/* 53 */       GameServer.logger().error(String.format("[crossserver]DTH_ReportCorpsFightValue.onDataTransferRsp@report corps fight value failed|req=%s|req_data=%s|rsp=%s|rsp_data=%s", new Object[] { reqXidWrapper.getProtocol(), reqData, rspXidWrapper.getProtocol(), rspData }));
/*    */ 
/*    */ 
/*    */     }
/*    */     else
/*    */     {
/*    */ 
/* 60 */       int activityCfgid = reqData.activity_cfgid;
/* 61 */       CrossBattleOneByOneManager.getInstance().addLogicProcedure(Integer.valueOf(activityCfgid), new mzm.gsp.crossbattle.point.PReportFightValueDone(reqData.activity_cfgid));
/*    */       
/* 63 */       GameServer.logger().info(String.format("[crossserver]DTH_ReportCorpsFightValue.onDataTransferRsp@report corps fight value done|req=%s|req_data=%s|rsp=%s|rsp_data=%s", new Object[] { reqXidWrapper.getProtocol(), reqData, rspXidWrapper.getProtocol(), rspData }));
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\main\DTH_ReportCorpsFightValue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */