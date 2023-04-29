/*    */ package mzm.gsp.crossserver.main;
/*    */ 
/*    */ import hub.DataTransferReq;
/*    */ import hub.DataTransferReqXidWrapper;
/*    */ import hub.DataTransferRsp;
/*    */ import hub.DataTransferRspXidWrapper;
/*    */ import hub.SingleCrossFieldCancelMatchReq;
/*    */ import hub.SingleCrossFieldCancelMatchRsp;
/*    */ import mzm.event.TriggerEventsManger;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.crossserver.event.SingleCrossFieldCancelMatchFail;
/*    */ import mzm.gsp.crossserver.event.SingleCrossFieldCancelMatchFailArg;
/*    */ import mzm.gsp.crossserver.event.SingleCrossFieldCancelMatchSuccess;
/*    */ import mzm.gsp.crossserver.event.SingleCrossFieldCancelMatchSuccessArg;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class DTH_SingleCrossFieldCancelMatch
/*    */   extends DataTransferHandler<SingleCrossFieldCancelMatchReq, SingleCrossFieldCancelMatchRsp>
/*    */ {
/*    */   protected SingleCrossFieldCancelMatchReq makeReqDataBean()
/*    */   {
/* 28 */     return new SingleCrossFieldCancelMatchReq();
/*    */   }
/*    */   
/*    */ 
/*    */   protected SingleCrossFieldCancelMatchRsp makeRspDataBean()
/*    */   {
/* 34 */     return new SingleCrossFieldCancelMatchRsp();
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   protected void onDataTransferReq(DataTransferReq req, SingleCrossFieldCancelMatchReq reqData) {}
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   protected void onDataTransferRsp(DataTransferReqXidWrapper reqXidWrapper, SingleCrossFieldCancelMatchReq reqData, DataTransferRspXidWrapper rspXidWrapper, SingleCrossFieldCancelMatchRsp rspData)
/*    */   {
/* 47 */     SingleCrossFieldCancelMatchReqXidWrapper xidWrapper = (SingleCrossFieldCancelMatchReqXidWrapper)reqXidWrapper;
/* 48 */     SingleCrossFieldContext context = xidWrapper.getContext();
/* 49 */     DataTransferRsp rsp = rspXidWrapper.getProtocol();
/* 50 */     if (rsp.retcode != 0)
/*    */     {
/* 52 */       TriggerEventsManger.getInstance().triggerEvent(new SingleCrossFieldCancelMatchFail(), new SingleCrossFieldCancelMatchFailArg(context));
/*    */ 
/*    */     }
/*    */     else
/*    */     {
/* 57 */       TriggerEventsManger.getInstance().triggerEvent(new SingleCrossFieldCancelMatchSuccess(), new SingleCrossFieldCancelMatchSuccessArg(context));
/*    */     }
/*    */     
/* 60 */     GameServer.logger().info(String.format("[crossserver]DTH_SingleCrossFieldCancelMatch.onDataTransferTimeout@single cross field cancel match rsp|req=%s|req_data=%s|rsp=%s|rsp_data=%s", new Object[] { reqXidWrapper.getProtocol(), reqData, rspXidWrapper.getProtocol(), rspData }));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   protected void onDataTransferTimeout(DataTransferReqXidWrapper reqXidWrapper, SingleCrossFieldCancelMatchReq reqData, int code)
/*    */   {
/* 70 */     SingleCrossFieldCancelMatchReqXidWrapper xidWrapper = (SingleCrossFieldCancelMatchReqXidWrapper)reqXidWrapper;
/* 71 */     SingleCrossFieldContext context = xidWrapper.getContext();
/* 72 */     TriggerEventsManger.getInstance().triggerEvent(new SingleCrossFieldCancelMatchFail(), new SingleCrossFieldCancelMatchFailArg(context));
/*    */     
/* 74 */     GameServer.logger().error(String.format("[crossserver]DTH_SingleCrossFieldCancelMatch.onDataTransferTimeout@single cross field cancel match timeout|req=%s|req_data=%s|code=%d", new Object[] { reqXidWrapper.getProtocol(), reqData, Integer.valueOf(code) }));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\main\DTH_SingleCrossFieldCancelMatch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */