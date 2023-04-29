/*    */ package mzm.gsp.crossserver.main;
/*    */ 
/*    */ import hub.DataTransferReq;
/*    */ import hub.DataTransferReqXidWrapper;
/*    */ import hub.DataTransferRsp;
/*    */ import hub.DataTransferRspXidWrapper;
/*    */ import hub.SingleCrossFieldJoinMatchReq;
/*    */ import hub.SingleCrossFieldJoinMatchRsp;
/*    */ import mzm.event.TriggerEventsManger;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.crossserver.event.SingleCrossFieldMatchFail;
/*    */ import mzm.gsp.crossserver.event.SingleCrossFieldMatchFailArg;
/*    */ import mzm.gsp.crossserver.event.SingleCrossFieldMatchStart;
/*    */ import mzm.gsp.crossserver.event.SingleCrossFieldMatchStartArg;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class DTH_SingleCrossFieldJoinMatch
/*    */   extends DataTransferHandler<SingleCrossFieldJoinMatchReq, SingleCrossFieldJoinMatchRsp>
/*    */ {
/*    */   protected SingleCrossFieldJoinMatchReq makeReqDataBean()
/*    */   {
/* 28 */     return new SingleCrossFieldJoinMatchReq();
/*    */   }
/*    */   
/*    */ 
/*    */   protected SingleCrossFieldJoinMatchRsp makeRspDataBean()
/*    */   {
/* 34 */     return new SingleCrossFieldJoinMatchRsp();
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   protected void onDataTransferReq(DataTransferReq req, SingleCrossFieldJoinMatchReq reqData) {}
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   protected void onDataTransferRsp(DataTransferReqXidWrapper reqXidWrapper, SingleCrossFieldJoinMatchReq reqData, DataTransferRspXidWrapper rspXidWrapper, SingleCrossFieldJoinMatchRsp rspData)
/*    */   {
/* 47 */     SingleCrossFieldJoinMatchReqXidWrapper xidWrapper = (SingleCrossFieldJoinMatchReqXidWrapper)reqXidWrapper;
/* 48 */     SingleCrossFieldContext context = xidWrapper.getContext();
/* 49 */     DataTransferRsp rsp = rspXidWrapper.getProtocol();
/* 50 */     if (rsp.retcode != 0)
/*    */     {
/* 52 */       TriggerEventsManger.getInstance().triggerEvent(new SingleCrossFieldMatchFail(), new SingleCrossFieldMatchFailArg(context));
/*    */ 
/*    */     }
/*    */     else
/*    */     {
/* 57 */       context.setMatcherServerContextid(rspData.matcher_server_contextid);
/* 58 */       TriggerEventsManger.getInstance().triggerEvent(new SingleCrossFieldMatchStart(), new SingleCrossFieldMatchStartArg(context));
/*    */     }
/*    */     
/* 61 */     GameServer.logger().info(String.format("[crossserver]DTH_SingleCrossFieldJoinMatch.onDataTransferRsp@single cross field join match rsp|req=%s|req_data=%s|rsp=%s|rsp_data=%s|context=%s", new Object[] { reqXidWrapper.getProtocol(), reqData, rspXidWrapper.getProtocol(), rspData, context }));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   protected void onDataTransferTimeout(DataTransferReqXidWrapper reqXidWrapper, SingleCrossFieldJoinMatchReq reqData, int code)
/*    */   {
/* 70 */     SingleCrossFieldJoinMatchReqXidWrapper xidWrapper = (SingleCrossFieldJoinMatchReqXidWrapper)reqXidWrapper;
/* 71 */     SingleCrossFieldContext context = xidWrapper.getContext();
/* 72 */     TriggerEventsManger.getInstance().triggerEvent(new SingleCrossFieldMatchFail(), new SingleCrossFieldMatchFailArg(context));
/*    */     
/* 74 */     GameServer.logger().error(String.format("[crossserver]DTH_SingleCrossFieldJoinMatch.onDataTransferTimeout@single cross field join match timeout|req=%s|req_data=%s|code=%d|context=%s", new Object[] { reqXidWrapper.getProtocol(), reqData, Integer.valueOf(code), context }));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\main\DTH_SingleCrossFieldJoinMatch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */