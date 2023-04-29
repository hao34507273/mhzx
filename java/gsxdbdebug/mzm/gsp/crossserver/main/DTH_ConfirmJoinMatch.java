/*    */ package mzm.gsp.crossserver.main;
/*    */ 
/*    */ import hub.ConfirmJoinMatchReq;
/*    */ import hub.ConfirmJoinMatchRsp;
/*    */ import hub.DataTransferReq;
/*    */ import hub.DataTransferReqXidWrapper;
/*    */ import hub.DataTransferRspXidWrapper;
/*    */ import mzm.gsp.GameServer;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ public class DTH_ConfirmJoinMatch extends DataTransferHandler<ConfirmJoinMatchReq, ConfirmJoinMatchRsp>
/*    */ {
/*    */   protected ConfirmJoinMatchReq makeReqDataBean()
/*    */   {
/* 15 */     return new ConfirmJoinMatchReq();
/*    */   }
/*    */   
/*    */ 
/*    */   protected ConfirmJoinMatchRsp makeRspDataBean()
/*    */   {
/* 21 */     return new ConfirmJoinMatchRsp();
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   protected void onDataTransferReq(DataTransferReq req, ConfirmJoinMatchReq reqData) {}
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   protected void onDataTransferTimeout(DataTransferReqXidWrapper reqXidWrapper, ConfirmJoinMatchReq reqData, int code)
/*    */   {
/* 34 */     GameServer.logger().error(String.format("[crossserver]DTH_ConfirmJoinMatch.onDataTransferTimeout@confirm join match timeout|req=%s|req_data=%s|code=%d", new Object[] { reqXidWrapper.getProtocol(), reqData, Integer.valueOf(code) }));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   protected void onDataTransferRsp(DataTransferReqXidWrapper reqXidWrapper, ConfirmJoinMatchReq reqData, DataTransferRspXidWrapper rspXidWrapper, ConfirmJoinMatchRsp rspData)
/*    */   {
/* 44 */     GameServer.logger().info(String.format("[crossserver]DTH_ConfirmJoinMatch.onDataTransferRsp@confirm join match done|req=%s|req_data=%s|rsp=%s|rsp_data=%s", new Object[] { reqXidWrapper.getProtocol(), reqData, rspXidWrapper.getProtocol(), rspData }));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\main\DTH_ConfirmJoinMatch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */