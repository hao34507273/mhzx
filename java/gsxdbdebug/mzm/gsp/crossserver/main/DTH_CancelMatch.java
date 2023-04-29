/*    */ package mzm.gsp.crossserver.main;
/*    */ 
/*    */ import hub.CancelMatchReq;
/*    */ import hub.CancelMatchRsp;
/*    */ import hub.DataTransferReq;
/*    */ import hub.DataTransferReqXidWrapper;
/*    */ import hub.DataTransferRsp;
/*    */ import hub.DataTransferRspXidWrapper;
/*    */ import mzm.event.TriggerEventsManger;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.crossserver.event.MatchCancelFail;
/*    */ import mzm.gsp.crossserver.event.MatchCancelFailArg;
/*    */ import mzm.gsp.crossserver.event.MatchCancelSucceed;
/*    */ import mzm.gsp.crossserver.event.MatchCancelSucceedArg;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ public class DTH_CancelMatch
/*    */   extends DataTransferHandler<CancelMatchReq, CancelMatchRsp>
/*    */ {
/*    */   protected CancelMatchReq makeReqDataBean()
/*    */   {
/* 22 */     return new CancelMatchReq();
/*    */   }
/*    */   
/*    */ 
/*    */   protected CancelMatchRsp makeRspDataBean()
/*    */   {
/* 28 */     return null;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   protected void onDataTransferReq(DataTransferReq req, CancelMatchReq reqData) {}
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   protected void onDataTransferTimeout(DataTransferReqXidWrapper reqXidWrapper, CancelMatchReq reqData, int code)
/*    */   {
/* 41 */     CancelMatchTransferReqXidWrapper xidWrapper = (CancelMatchTransferReqXidWrapper)reqXidWrapper;
/* 42 */     MatchContext context = xidWrapper.getContext();
/*    */     
/* 44 */     GameServer.logger().error(String.format("[crossserver]DTH_CancelMatch.onDataTransferTimeout@cancel match timeout|req=%s|req_data=%s|code=%d", new Object[] { reqXidWrapper.getProtocol(), reqData, Integer.valueOf(code) }));
/*    */     
/*    */ 
/*    */ 
/*    */ 
/* 49 */     MatchCancelFail event = new MatchCancelFail();
/* 50 */     MatchCancelFailArg arg = new MatchCancelFailArg(context.contextid, context.leaderid, context.roleMatchMarkingInfos, context.activityContext, context.getCreateTime());
/*    */     
/*    */ 
/* 53 */     TriggerEventsManger.getInstance().triggerEvent(event, arg);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   protected void onDataTransferRsp(DataTransferReqXidWrapper reqXidWrapper, CancelMatchReq reqData, DataTransferRspXidWrapper rspXidWrapper, CancelMatchRsp rspData)
/*    */   {
/* 60 */     CancelMatchTransferReqXidWrapper xidWrapper = (CancelMatchTransferReqXidWrapper)reqXidWrapper;
/* 61 */     MatchContext context = xidWrapper.getContext();
/* 62 */     DataTransferRsp rsp = rspXidWrapper.getProtocol();
/*    */     
/* 64 */     GameServer.logger().info(String.format("[crossserver]DTH_CancelMatch.onDataTransferRsp@cancel match done|req=%s|req_data=%s|rsp=%s|rsp_data=%s", new Object[] { reqXidWrapper.getProtocol(), reqData, rspXidWrapper.getProtocol(), rspData }));
/*    */     
/*    */ 
/*    */ 
/*    */ 
/* 69 */     if (rsp.retcode != 0)
/*    */     {
/* 71 */       MatchCancelFail event = new MatchCancelFail();
/* 72 */       MatchCancelFailArg arg = new MatchCancelFailArg(context.contextid, context.leaderid, context.roleMatchMarkingInfos, context.activityContext, context.getCreateTime());
/*    */       
/*    */ 
/* 75 */       TriggerEventsManger.getInstance().triggerEvent(event, arg);
/*    */     }
/*    */     else
/*    */     {
/* 79 */       MatchCancelSucceed event = new MatchCancelSucceed();
/* 80 */       MatchCancelSucceedArg arg = new MatchCancelSucceedArg(context.contextid, context.leaderid, context.roleMatchMarkingInfos, context.activityContext, context.getCreateTime());
/*    */       
/*    */ 
/* 83 */       TriggerEventsManger.getInstance().triggerEvent(event, arg);
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\main\DTH_CancelMatch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */