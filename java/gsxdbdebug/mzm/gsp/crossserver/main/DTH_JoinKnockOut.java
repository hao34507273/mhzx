/*    */ package mzm.gsp.crossserver.main;
/*    */ 
/*    */ import hub.DataTransferReq;
/*    */ import hub.DataTransferReqXidWrapper;
/*    */ import hub.DataTransferRsp;
/*    */ import hub.DataTransferRspXidWrapper;
/*    */ import hub.JoinCrossBattleSelectionOrFinalReq;
/*    */ import hub.JoinCrossBattleSelectionOrFinalRsp;
/*    */ import mzm.event.TriggerEventsManger;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.crossserver.event.SelectionOrFinalJoinSucceed;
/*    */ import mzm.gsp.crossserver.event.SelectionOrFinalJoinSucceedArg;
/*    */ import mzm.gsp.crossserver.event.SelectionOrFinalMatchFailed;
/*    */ import mzm.gsp.crossserver.event.SelectionOrFinalMatchFailedArg;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class DTH_JoinKnockOut
/*    */   extends DataTransferHandler<JoinCrossBattleSelectionOrFinalReq, JoinCrossBattleSelectionOrFinalRsp>
/*    */ {
/*    */   public JoinCrossBattleSelectionOrFinalReq makeReqDataBean()
/*    */   {
/* 26 */     return new JoinCrossBattleSelectionOrFinalReq();
/*    */   }
/*    */   
/*    */ 
/*    */   public JoinCrossBattleSelectionOrFinalRsp makeRspDataBean()
/*    */   {
/* 32 */     return new JoinCrossBattleSelectionOrFinalRsp();
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public void onDataTransferReq(DataTransferReq req, JoinCrossBattleSelectionOrFinalReq reqData) {}
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public void onDataTransferTimeout(DataTransferReqXidWrapper reqXidWrapper, JoinCrossBattleSelectionOrFinalReq reqData, int code)
/*    */   {
/* 45 */     KnockOutJoinReqXidWrapper xidWrapper = (KnockOutJoinReqXidWrapper)reqXidWrapper;
/* 46 */     KnockOutContext context = xidWrapper.getContext();
/*    */     
/* 48 */     GameServer.logger().error(String.format("[crossserver]DTH_JoinMatch.onDataTransferTimeout@join match timeout|req=%s|req_data=%s|code=%d|match_context=%s", new Object[] { reqXidWrapper.getProtocol(), reqData, Integer.valueOf(code), context }));
/*    */     
/*    */ 
/*    */ 
/*    */ 
/* 53 */     SelectionOrFinalMatchFailed event = new SelectionOrFinalMatchFailed();
/* 54 */     SelectionOrFinalMatchFailedArg arg = new SelectionOrFinalMatchFailedArg(context.gameServerContextId, context.leaderRoleId, context.getCrossBattleTeamInfo(), context.getCreateTime());
/*    */     
/*    */ 
/* 57 */     TriggerEventsManger.getInstance().triggerEvent(event, arg);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public void onDataTransferRsp(DataTransferReqXidWrapper reqXidWrapper, JoinCrossBattleSelectionOrFinalReq reqData, DataTransferRspXidWrapper rspXidWrapper, JoinCrossBattleSelectionOrFinalRsp rspData)
/*    */   {
/* 65 */     KnockOutJoinReqXidWrapper xidWrapper = (KnockOutJoinReqXidWrapper)reqXidWrapper;
/* 66 */     KnockOutContext context = xidWrapper.getContext();
/*    */     
/* 68 */     GameServer.logger().info(String.format("[crossserver]DTH_JoinMatch.onDataTransferRsp@join match rsp|req=%s|req_data=%s|rsp=%s|rsp_data=%s|match_context=%s", new Object[] { reqXidWrapper.getProtocol(), reqData, rspXidWrapper.getProtocol(), rspData, context }));
/*    */     
/*    */ 
/*    */ 
/*    */ 
/* 73 */     DataTransferRsp rsp = rspXidWrapper.getProtocol();
/* 74 */     if (rsp.retcode != 0)
/*    */     {
/* 76 */       SelectionOrFinalMatchFailed event = new SelectionOrFinalMatchFailed();
/* 77 */       SelectionOrFinalMatchFailedArg arg = new SelectionOrFinalMatchFailedArg(context.gameServerContextId, context.leaderRoleId, context.getCrossBattleTeamInfo(), context.getCreateTime());
/*    */       
/*    */ 
/* 80 */       TriggerEventsManger.getInstance().triggerEvent(event, arg);
/*    */ 
/*    */     }
/*    */     else
/*    */     {
/* 85 */       context.setMatcherServerContextid(rspData.matcher_server_contextid);
/*    */       
/* 87 */       SelectionOrFinalJoinSucceed event = new SelectionOrFinalJoinSucceed();
/* 88 */       SelectionOrFinalJoinSucceedArg arg = new SelectionOrFinalJoinSucceedArg(context.gameServerContextId, context.leaderRoleId, context.getCrossBattleTeamInfo(), context.getCreateTime());
/*    */       
/*    */ 
/* 91 */       TriggerEventsManger.getInstance().triggerEvent(event, arg);
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\main\DTH_JoinKnockOut.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */