/*    */ package mzm.gsp.crossserver.main;
/*    */ 
/*    */ import hub.DataTransferReq;
/*    */ import hub.DataTransferReqXidWrapper;
/*    */ import hub.DataTransferRsp;
/*    */ import hub.DataTransferRspXidWrapper;
/*    */ import hub.GHubHelper;
/*    */ import hub.SelectionOrFinalWaitNextRoundMatchReq;
/*    */ import hub.SelectionOrFinalWaitNextRoundMatchRsp;
/*    */ import mzm.gsp.GameServer;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ 
/*    */ public class DTH_KnockOutWaitNextRoundMatch
/*    */   extends DataTransferHandler<SelectionOrFinalWaitNextRoundMatchReq, SelectionOrFinalWaitNextRoundMatchRsp>
/*    */ {
/*    */   protected SelectionOrFinalWaitNextRoundMatchReq makeReqDataBean()
/*    */   {
/* 19 */     return new SelectionOrFinalWaitNextRoundMatchReq();
/*    */   }
/*    */   
/*    */ 
/*    */   protected SelectionOrFinalWaitNextRoundMatchRsp makeRspDataBean()
/*    */   {
/* 25 */     return new SelectionOrFinalWaitNextRoundMatchRsp();
/*    */   }
/*    */   
/*    */ 
/*    */   protected void onDataTransferReq(DataTransferReq req, SelectionOrFinalWaitNextRoundMatchReq reqData)
/*    */   {
/* 31 */     DataTransferRsp rsp = new DataTransferRsp();
/* 32 */     rsp.direction = req.direction;
/* 33 */     rsp.xid = req.xid;
/* 34 */     rsp.src_id = req.dst_id;
/* 35 */     rsp.dst_id = req.src_id;
/* 36 */     rsp.data_type = req.data_type;
/* 37 */     KnockOutContext context = KnockOutContextManager.getInstance().getContext(reqData.game_server_contextid);
/*    */     
/* 39 */     if ((context == null) || (reqData.fight_type != context.fightType) || (context.getMatcherServerContextid() != reqData.matcher_server_contextid))
/*    */     {
/*    */ 
/* 42 */       GameServer.logger().error(String.format("[crossserver]DTH_SelectionOrFinalWaitNextRoundMatch.onDataTransferReq@match context not match|req=%s|req_data=%s|match_context=%s", new Object[] { req, reqData, context }));
/*    */       
/*    */ 
/*    */ 
/*    */ 
/* 47 */       rsp.retcode = 2;
/* 48 */       GHubHelper.sendDataTransferRsp(rsp);
/*    */       
/* 50 */       return;
/*    */     }
/*    */     
/* 53 */     context.setWaitNextRundMatch(true);
/*    */     
/* 55 */     rsp.retcode = 0;
/*    */     
/* 57 */     GameServer.logger().info(String.format("[crossserver]DTH_WaitNextRoundMatch.onDataTransferReq@handle wait next round match done|req=%s|req_data=%s|rsp=%s|match_context=%s", new Object[] { req, reqData, rsp, context }));
/*    */     
/*    */ 
/*    */ 
/*    */ 
/* 62 */     GHubHelper.sendDataTransferRsp(rsp);
/*    */   }
/*    */   
/*    */   protected void onDataTransferTimeout(DataTransferReqXidWrapper reqXidWrapper, SelectionOrFinalWaitNextRoundMatchReq reqData, int code) {}
/*    */   
/*    */   protected void onDataTransferRsp(DataTransferReqXidWrapper reqXidWrapper, SelectionOrFinalWaitNextRoundMatchReq reqData, DataTransferRspXidWrapper rspXidWrapper, SelectionOrFinalWaitNextRoundMatchRsp rspData) {}
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\main\DTH_KnockOutWaitNextRoundMatch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */