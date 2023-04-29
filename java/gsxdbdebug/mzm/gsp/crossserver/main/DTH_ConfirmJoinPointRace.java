/*    */ package mzm.gsp.crossserver.main;
/*    */ 
/*    */ import hub.ConfirmJoinPointRaceReq;
/*    */ import hub.ConfirmJoinPointRaceRsp;
/*    */ import hub.DataTransferReq;
/*    */ import hub.DataTransferReqXidWrapper;
/*    */ import hub.DataTransferRspXidWrapper;
/*    */ import mzm.gsp.GameServer;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ public class DTH_ConfirmJoinPointRace extends DataTransferHandler<ConfirmJoinPointRaceReq, ConfirmJoinPointRaceRsp>
/*    */ {
/*    */   protected ConfirmJoinPointRaceReq makeReqDataBean()
/*    */   {
/* 15 */     return new ConfirmJoinPointRaceReq();
/*    */   }
/*    */   
/*    */ 
/*    */   protected ConfirmJoinPointRaceRsp makeRspDataBean()
/*    */   {
/* 21 */     return new ConfirmJoinPointRaceRsp();
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   protected void onDataTransferReq(DataTransferReq req, ConfirmJoinPointRaceReq reqData) {}
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   protected void onDataTransferTimeout(DataTransferReqXidWrapper reqXidWrapper, ConfirmJoinPointRaceReq reqData, int code)
/*    */   {
/* 34 */     GameServer.logger().error(String.format("[crossserver]DTH_ConfirmJoinPointRace.onDataTransferTimeout@confirm join point race timeout|req=%s|req_data=%s|code=%d", new Object[] { reqXidWrapper.getProtocol(), reqData, Integer.valueOf(code) }));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   protected void onDataTransferRsp(DataTransferReqXidWrapper reqXidWrapper, ConfirmJoinPointRaceReq reqData, DataTransferRspXidWrapper rspXidWrapper, ConfirmJoinPointRaceRsp rspData)
/*    */   {
/* 45 */     GameServer.logger().info(String.format("[crossserver]DTH_ConfirmJoinPointRace.onDataTransferRsp@confirm join point race done|req=%s|req_data=%s|rsp=%s|rsp_data=%s", new Object[] { reqXidWrapper.getProtocol(), reqData, rspXidWrapper.getProtocol(), rspData }));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\main\DTH_ConfirmJoinPointRace.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */