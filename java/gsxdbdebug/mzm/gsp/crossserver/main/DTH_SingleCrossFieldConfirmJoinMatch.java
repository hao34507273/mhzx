/*    */ package mzm.gsp.crossserver.main;
/*    */ 
/*    */ import hub.DataTransferReq;
/*    */ import hub.DataTransferReqXidWrapper;
/*    */ import hub.DataTransferRsp;
/*    */ import hub.DataTransferRspXidWrapper;
/*    */ import hub.SingleCrossFieldConfirmJoinMatchReq;
/*    */ import hub.SingleCrossFieldConfirmJoinMatchRsp;
/*    */ import mzm.event.TriggerEventsManger;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.crossserver.event.SingleCrossFieldMatchFail;
/*    */ import mzm.gsp.crossserver.event.SingleCrossFieldMatchFailArg;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class DTH_SingleCrossFieldConfirmJoinMatch
/*    */   extends DataTransferHandler<SingleCrossFieldConfirmJoinMatchReq, SingleCrossFieldConfirmJoinMatchRsp>
/*    */ {
/*    */   protected SingleCrossFieldConfirmJoinMatchReq makeReqDataBean()
/*    */   {
/* 26 */     return new SingleCrossFieldConfirmJoinMatchReq();
/*    */   }
/*    */   
/*    */ 
/*    */   protected SingleCrossFieldConfirmJoinMatchRsp makeRspDataBean()
/*    */   {
/* 32 */     return new SingleCrossFieldConfirmJoinMatchRsp();
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   protected void onDataTransferReq(DataTransferReq req, SingleCrossFieldConfirmJoinMatchReq reqData) {}
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   protected void onDataTransferRsp(DataTransferReqXidWrapper reqXidWrapper, SingleCrossFieldConfirmJoinMatchReq reqData, DataTransferRspXidWrapper rspXidWrapper, SingleCrossFieldConfirmJoinMatchRsp rspData)
/*    */   {
/* 45 */     SingleCrossFieldComfirmJoinMatchReqXidWrapper xidWrapper = (SingleCrossFieldComfirmJoinMatchReqXidWrapper)reqXidWrapper;
/* 46 */     SingleCrossFieldContext context = xidWrapper.getContext();
/* 47 */     DataTransferRsp rsp = rspXidWrapper.getProtocol();
/* 48 */     if (rsp.retcode != 0)
/*    */     {
/* 50 */       TriggerEventsManger.getInstance().triggerEvent(new SingleCrossFieldMatchFail(), new SingleCrossFieldMatchFailArg(context));
/*    */     }
/*    */     
/* 53 */     GameServer.logger().info(String.format("[crossserver]DTH_SingleCrossFieldConfirmJoinMatch.onDataTransferRsp@single cross field confirm join match rsp|req=%s|req_data=%s|rsp=%s|rsp_data=%s|context=%s", new Object[] { reqXidWrapper.getProtocol(), reqData, rspXidWrapper.getProtocol(), rspData, context }));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   protected void onDataTransferTimeout(DataTransferReqXidWrapper reqXidWrapper, SingleCrossFieldConfirmJoinMatchReq reqData, int code)
/*    */   {
/* 63 */     SingleCrossFieldComfirmJoinMatchReqXidWrapper xidWrapper = (SingleCrossFieldComfirmJoinMatchReqXidWrapper)reqXidWrapper;
/* 64 */     SingleCrossFieldContext context = xidWrapper.getContext();
/* 65 */     TriggerEventsManger.getInstance().triggerEvent(new SingleCrossFieldMatchFail(), new SingleCrossFieldMatchFailArg(context));
/*    */     
/* 67 */     GameServer.logger().error(String.format("[crossserver]DTH_SingleCrossFieldConfirmJoinMatch.onDataTransferTimeout@single cross field confirm join match timeout|req=%s|req_data=%s|code=%d|context=%s", new Object[] { reqXidWrapper.getProtocol(), reqData, Integer.valueOf(code), context }));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\main\DTH_SingleCrossFieldConfirmJoinMatch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */