/*    */ package mzm.gsp.crossserver.main;
/*    */ 
/*    */ import hub.DataTransferReq;
/*    */ import hub.DataTransferReqXidWrapper;
/*    */ import hub.DataTransferRsp;
/*    */ import hub.DataTransferRspXidWrapper;
/*    */ import hub.GHubHelper;
/*    */ import hub.WaitNextRoundMatchReq;
/*    */ import hub.WaitNextRoundMatchRsp;
/*    */ import mzm.gsp.GameServer;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ public class DTH_WaitNextRoundMatch
/*    */   extends DataTransferHandler<WaitNextRoundMatchReq, WaitNextRoundMatchRsp>
/*    */ {
/*    */   protected WaitNextRoundMatchReq makeReqDataBean()
/*    */   {
/* 18 */     return new WaitNextRoundMatchReq();
/*    */   }
/*    */   
/*    */ 
/*    */   protected WaitNextRoundMatchRsp makeRspDataBean()
/*    */   {
/* 24 */     return new WaitNextRoundMatchRsp();
/*    */   }
/*    */   
/*    */ 
/*    */   protected void onDataTransferReq(DataTransferReq req, WaitNextRoundMatchReq reqData)
/*    */   {
/* 30 */     DataTransferRsp rsp = new DataTransferRsp();
/* 31 */     rsp.direction = req.direction;
/* 32 */     rsp.xid = req.xid;
/* 33 */     rsp.src_id = req.dst_id;
/* 34 */     rsp.dst_id = req.src_id;
/* 35 */     rsp.data_type = req.data_type;
/* 36 */     MatchContext context = MatchContextManager.getInstance().getContext(reqData.game_server_contextid);
/* 37 */     if ((context == null) || (context.activityContext.getMatchActivityContextType().typeid != reqData.activity_context_typeid) || (context.getMatcherServerContextid() != reqData.matcher_server_contextid))
/*    */     {
/*    */ 
/* 40 */       GameServer.logger().error(String.format("[crossserver]DTH_WaitNextRoundMatch.onDataTransferReq@match context not match|req=%s|req_data=%s|match_context=%s", new Object[] { req, reqData, context }));
/*    */       
/*    */ 
/*    */ 
/*    */ 
/* 45 */       rsp.retcode = 2;
/* 46 */       GHubHelper.sendDataTransferRsp(rsp);
/*    */       
/* 48 */       return;
/*    */     }
/*    */     
/* 51 */     context.setWaitNextRundMatch(true);
/*    */     
/* 53 */     rsp.retcode = 0;
/*    */     
/* 55 */     GameServer.logger().info(String.format("[crossserver]DTH_WaitNextRoundMatch.onDataTransferReq@handle wait next round match done|req=%s|req_data=%s|rsp=%s|match_context=%s", new Object[] { req, reqData, rsp, context }));
/*    */     
/*    */ 
/*    */ 
/*    */ 
/* 60 */     GHubHelper.sendDataTransferRsp(rsp);
/*    */   }
/*    */   
/*    */   protected void onDataTransferTimeout(DataTransferReqXidWrapper reqXidWrapper, WaitNextRoundMatchReq reqData, int code) {}
/*    */   
/*    */   protected void onDataTransferRsp(DataTransferReqXidWrapper reqXidWrapper, WaitNextRoundMatchReq reqData, DataTransferRspXidWrapper rspXidWrapper, WaitNextRoundMatchRsp rspData) {}
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\main\DTH_WaitNextRoundMatch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */