/*    */ package mzm.gsp.crossserver.main;
/*    */ 
/*    */ import hub.DataTransferReq;
/*    */ import hub.DataTransferReqXidWrapper;
/*    */ import hub.DataTransferRsp;
/*    */ import hub.DataTransferRspXidWrapper;
/*    */ import hub.GHubHelper;
/*    */ import hub.NotifySelectionOrFinalByeReq;
/*    */ import hub.NotifySelectionOrFinalByeRsp;
/*    */ import mzm.event.TriggerEventsManger;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.crossserver.event.SelectionOrFinalMatchFailed;
/*    */ import mzm.gsp.crossserver.event.SelectionOrFinalMatchFailedArg;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class DTH_NotifyKnockOutBye
/*    */   extends DataTransferHandler<NotifySelectionOrFinalByeReq, NotifySelectionOrFinalByeRsp>
/*    */ {
/*    */   public NotifySelectionOrFinalByeReq makeReqDataBean()
/*    */   {
/* 25 */     return new NotifySelectionOrFinalByeReq();
/*    */   }
/*    */   
/*    */ 
/*    */   public NotifySelectionOrFinalByeRsp makeRspDataBean()
/*    */   {
/* 31 */     return new NotifySelectionOrFinalByeRsp();
/*    */   }
/*    */   
/*    */ 
/*    */   public void onDataTransferReq(DataTransferReq req, NotifySelectionOrFinalByeReq reqData)
/*    */   {
/* 37 */     DataTransferRsp rsp = new DataTransferRsp();
/* 38 */     rsp.direction = req.direction;
/* 39 */     rsp.xid = req.xid;
/* 40 */     rsp.src_id = req.dst_id;
/* 41 */     rsp.dst_id = req.src_id;
/* 42 */     rsp.data_type = req.data_type;
/* 43 */     rsp.retcode = 2;
/*    */     
/* 45 */     KnockOutContext context = KnockOutContextManager.getInstance().getContext(reqData.game_server_contextid);
/*    */     
/* 47 */     if ((context == null) || (context.fightType != reqData.fight_type) || (context.getMatcherServerContextid() != reqData.matcher_server_contextid))
/*    */     {
/*    */ 
/* 50 */       GameServer.logger().error(String.format("[crossserver]DTH_NotifySelectionOrFinalBye.onDataTransferReq@match data not match|req=%s|req_data=%s|context=%s", new Object[] { req, reqData, context }));
/*    */       
/*    */ 
/*    */ 
/*    */ 
/* 55 */       GHubHelper.sendDataTransferRsp(rsp);
/*    */       
/* 57 */       return;
/*    */     }
/*    */     
/* 60 */     rsp.retcode = 0;
/*    */     
/* 62 */     GameServer.logger().info(String.format("[crossserver]DTH_NotifySelectionOrFinalBye.onDataTransferReq@handle notify selection or final bye result|req=%s|req_data=%s|rsp=%s|context=%s", new Object[] { req, reqData, rsp, context }));
/*    */     
/*    */ 
/*    */ 
/*    */ 
/* 67 */     SelectionOrFinalMatchFailed event = new SelectionOrFinalMatchFailed();
/* 68 */     SelectionOrFinalMatchFailedArg arg = new SelectionOrFinalMatchFailedArg(context.gameServerContextId, context.leaderRoleId, context.getCrossBattleTeamInfo(), context.getCreateTime());
/*    */     
/*    */ 
/*    */ 
/* 72 */     TriggerEventsManger.getInstance().triggerEvent(event, arg);
/*    */     
/* 74 */     if (!GHubHelper.sendDataTransferRsp(rsp))
/*    */     {
/* 76 */       GameServer.logger().error(String.format("[crossserver]DTH_NotifySelectionOrFinalBye.onDataTransferReq@send  notify selection or final bye rsp failed|req=%s|req_data=%s|rsp=%s|context=%s", new Object[] { req, reqData, rsp, context }));
/*    */     }
/*    */     
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 83 */     new PNotifySelectionOrFinalBye(context).call();
/*    */   }
/*    */   
/*    */   public void onDataTransferTimeout(DataTransferReqXidWrapper reqXidWrapper, NotifySelectionOrFinalByeReq reqData, int code) {}
/*    */   
/*    */   public void onDataTransferRsp(DataTransferReqXidWrapper reqXidWrapper, NotifySelectionOrFinalByeReq reqData, DataTransferRspXidWrapper rspXidWrapper, NotifySelectionOrFinalByeRsp rspData) {}
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\main\DTH_NotifyKnockOutBye.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */