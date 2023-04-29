/*    */ package mzm.gsp.crossserver.main;
/*    */ 
/*    */ import hub.DataTransferReqXidWrapper;
/*    */ import hub.DataTransferRspXidWrapper;
/*    */ import hub.PointRaceEndReq;
/*    */ import hub.PointRaceEndRsp;
/*    */ import mzm.gsp.GameServer;
/*    */ 
/*    */ public class DTH_PointRaceEnd extends DataTransferHandler<PointRaceEndReq, PointRaceEndRsp>
/*    */ {
/*    */   protected PointRaceEndReq makeReqDataBean()
/*    */   {
/* 13 */     return new PointRaceEndReq();
/*    */   }
/*    */   
/*    */ 
/*    */   protected PointRaceEndRsp makeRspDataBean()
/*    */   {
/* 19 */     return new PointRaceEndRsp();
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   protected void onDataTransferReq(hub.DataTransferReq req, PointRaceEndReq reqData) {}
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   protected void onDataTransferTimeout(DataTransferReqXidWrapper reqXidWrapper, PointRaceEndReq reqData, int code)
/*    */   {
/* 32 */     GameServer.logger().error(String.format("[crossserver]DTH_PointRaceEnd.onDataTransferTimeout@point race end timeout|req=%s|req_data=%s|code=%d", new Object[] { reqXidWrapper.getProtocol(), reqData, Integer.valueOf(code) }));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   protected void onDataTransferRsp(DataTransferReqXidWrapper reqXidWrapper, PointRaceEndReq reqData, DataTransferRspXidWrapper rspXidWrapper, PointRaceEndRsp rspData)
/*    */   {
/* 43 */     GameServer.logger().info(String.format("[crossserver]DTH_PointRaceEnd.onDataTransferRsp@point race end done|req=%s|req_data=%s|rsp=%s|rsp_data=%s", new Object[] { reqXidWrapper.getProtocol(), reqData, rspXidWrapper.getProtocol(), rspData }));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\main\DTH_PointRaceEnd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */