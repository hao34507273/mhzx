/*    */ package mzm.gsp.crossserver.main;
/*    */ 
/*    */ import hub.DataTransferReq;
/*    */ import hub.DataTransferReqXidWrapper;
/*    */ import hub.DataTransferRsp;
/*    */ import hub.DataTransferRspXidWrapper;
/*    */ import hub.JoinMatchReq;
/*    */ import hub.JoinMatchRsp;
/*    */ import mzm.event.TriggerEventsManger;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.crossserver.event.MatchFail;
/*    */ import mzm.gsp.crossserver.event.MatchFailArg;
/*    */ import mzm.gsp.crossserver.event.MatchStart;
/*    */ import mzm.gsp.crossserver.event.MatchStartArg;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ public class DTH_JoinMatch
/*    */   extends DataTransferHandler<JoinMatchReq, JoinMatchRsp>
/*    */ {
/*    */   protected JoinMatchReq makeReqDataBean()
/*    */   {
/* 22 */     return new JoinMatchReq();
/*    */   }
/*    */   
/*    */ 
/*    */   protected JoinMatchRsp makeRspDataBean()
/*    */   {
/* 28 */     return new JoinMatchRsp();
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   protected void onDataTransferReq(DataTransferReq req, JoinMatchReq reqData) {}
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   protected void onDataTransferTimeout(DataTransferReqXidWrapper reqXidWrapper, JoinMatchReq reqData, int code)
/*    */   {
/* 41 */     JoinMatchTransferReqXidWrapper xidWrapper = (JoinMatchTransferReqXidWrapper)reqXidWrapper;
/* 42 */     MatchContext context = xidWrapper.getContext();
/*    */     
/* 44 */     GameServer.logger().error(String.format("[crossserver]DTH_JoinMatch.onDataTransferTimeout@join match timeout|req=%s|req_data=%s|code=%d|match_context=%s", new Object[] { reqXidWrapper.getProtocol(), reqData, Integer.valueOf(code), context }));
/*    */     
/*    */ 
/*    */ 
/*    */ 
/* 49 */     MatchFail event = new MatchFail();
/* 50 */     MatchFailArg arg = new MatchFailArg(context.contextid, context.leaderid, context.roleMatchMarkingInfos, context.activityContext, context.getCreateTime());
/*    */     
/* 52 */     TriggerEventsManger.getInstance().triggerEvent(event, arg);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   protected void onDataTransferRsp(DataTransferReqXidWrapper reqXidWrapper, JoinMatchReq reqData, DataTransferRspXidWrapper rspXidWrapper, JoinMatchRsp rspData)
/*    */   {
/* 59 */     JoinMatchTransferReqXidWrapper xidWrapper = (JoinMatchTransferReqXidWrapper)reqXidWrapper;
/* 60 */     MatchContext context = xidWrapper.getContext();
/*    */     
/* 62 */     GameServer.logger().info(String.format("[crossserver]DTH_JoinMatch.onDataTransferRsp@join match rsp|req=%s|req_data=%s|rsp=%s|rsp_data=%s|match_context=%s", new Object[] { reqXidWrapper.getProtocol(), reqData, rspXidWrapper.getProtocol(), rspData, context }));
/*    */     
/*    */ 
/*    */ 
/*    */ 
/* 67 */     DataTransferRsp rsp = rspXidWrapper.getProtocol();
/* 68 */     if (rsp.retcode != 0)
/*    */     {
/* 70 */       MatchFail event = new MatchFail();
/* 71 */       MatchFailArg arg = new MatchFailArg(context.contextid, context.leaderid, context.roleMatchMarkingInfos, context.activityContext, context.getCreateTime());
/*    */       
/* 73 */       TriggerEventsManger.getInstance().triggerEvent(event, arg);
/*    */ 
/*    */     }
/*    */     else
/*    */     {
/* 78 */       context.setMatcherServerContextid(rspData.matcher_server_contextid);
/*    */       
/* 80 */       MatchStart event = new MatchStart();
/* 81 */       MatchStartArg arg = new MatchStartArg(context.contextid, context.leaderid, context.roleMatchMarkingInfos, context.activityContext, context.getCreateTime());
/*    */       
/* 83 */       TriggerEventsManger.getInstance().triggerEvent(event, arg);
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\main\DTH_JoinMatch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */