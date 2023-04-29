/*    */ package mzm.gsp.crossserver.main;
/*    */ 
/*    */ import hub.ConfirmJoinSelectionOrFinalMatchReq;
/*    */ import hub.ConfirmJoinSelectionOrFinalMatchRsp;
/*    */ import hub.DataTransferReq;
/*    */ import hub.DataTransferReqXidWrapper;
/*    */ import hub.DataTransferRspXidWrapper;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.crossbattle.knockout.CrossBattleKnockoutInterface;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ public class DTH_ConfirmJoinKnockOutMatch
/*    */   extends DataTransferHandler<ConfirmJoinSelectionOrFinalMatchReq, ConfirmJoinSelectionOrFinalMatchRsp>
/*    */ {
/*    */   public ConfirmJoinSelectionOrFinalMatchReq makeReqDataBean()
/*    */   {
/* 17 */     return new ConfirmJoinSelectionOrFinalMatchReq();
/*    */   }
/*    */   
/*    */ 
/*    */   public ConfirmJoinSelectionOrFinalMatchRsp makeRspDataBean()
/*    */   {
/* 23 */     return new ConfirmJoinSelectionOrFinalMatchRsp();
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public void onDataTransferReq(DataTransferReq req, ConfirmJoinSelectionOrFinalMatchReq reqData) {}
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public void onDataTransferTimeout(DataTransferReqXidWrapper reqXidWrapper, ConfirmJoinSelectionOrFinalMatchReq reqData, int code)
/*    */   {
/* 36 */     GameServer.logger().error(String.format("[crossbattle_knockout]DTH_ConfirmJoinSelectionOrFinalMatch.onDataTransferTimeout@confirm join match timeout|req=%s|req_data=%s|code=%d", new Object[] { reqXidWrapper.getProtocol(), reqData, Integer.valueOf(code) }));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public void onDataTransferRsp(DataTransferReqXidWrapper reqXidWrapper, ConfirmJoinSelectionOrFinalMatchReq reqData, DataTransferRspXidWrapper rspXidWrapper, ConfirmJoinSelectionOrFinalMatchRsp rspData)
/*    */   {
/* 48 */     KnockOutConfirmJoinMatchTransferReqXidWrapper confirmJoinMatchTransferReq = (KnockOutConfirmJoinMatchTransferReqXidWrapper)reqXidWrapper;
/* 49 */     KnockOutContext context = confirmJoinMatchTransferReq.getContext();
/* 50 */     long corpsId = context.crossBattleTeamInfo.getCorpsId();
/*    */     
/*    */ 
/* 53 */     CrossBattleKnockoutInterface.stopAbstainObserver(corpsId);
/*    */     
/* 55 */     GameServer.logger().info(String.format("[crossbattle_knockout]DTH_ConfirmJoinSelectionOrFinalMatch.onDataTransferRsp@confirm join match done|req=%s|req_data=%s|rsp=%s|rsp_data=%s", new Object[] { reqXidWrapper.getProtocol(), reqData, rspXidWrapper.getProtocol(), rspData }));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\main\DTH_ConfirmJoinKnockOutMatch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */