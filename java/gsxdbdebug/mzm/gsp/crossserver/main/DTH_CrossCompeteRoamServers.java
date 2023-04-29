/*    */ package mzm.gsp.crossserver.main;
/*    */ 
/*    */ import hub.CrossCompeteRoamServersReq;
/*    */ import hub.CrossCompeteRoamServersRsp;
/*    */ import hub.DataTransferReq;
/*    */ import hub.DataTransferReqXidWrapper;
/*    */ import hub.DataTransferRspXidWrapper;
/*    */ import mzm.event.TriggerEventsManger;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.crossserver.event.CrossCompeteRoamServersDone;
/*    */ import mzm.gsp.crossserver.event.CrossCompeteRoamServersDoneArg;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class DTH_CrossCompeteRoamServers
/*    */   extends DataTransferHandler<CrossCompeteRoamServersReq, CrossCompeteRoamServersRsp>
/*    */ {
/*    */   protected CrossCompeteRoamServersReq makeReqDataBean()
/*    */   {
/* 23 */     return new CrossCompeteRoamServersReq();
/*    */   }
/*    */   
/*    */   protected CrossCompeteRoamServersRsp makeRspDataBean()
/*    */   {
/* 28 */     return new CrossCompeteRoamServersRsp();
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   protected void onDataTransferReq(DataTransferReq req, CrossCompeteRoamServersReq reqData) {}
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   protected void onDataTransferRsp(DataTransferReqXidWrapper reqXidWrapper, CrossCompeteRoamServersReq reqData, DataTransferRspXidWrapper rspXidWrapper, CrossCompeteRoamServersRsp rspData)
/*    */   {
/* 43 */     CrossCompeteRoamServersDoneArg arg = new CrossCompeteRoamServersDoneArg(rspData.start_millis, rspData.compete2zoneid);
/*    */     
/* 45 */     TriggerEventsManger.getInstance().triggerEvent(new CrossCompeteRoamServersDone(), arg);
/*    */     
/* 47 */     GameServer.logger().info(String.format("[crosscompete]DTH_CrossCompeteRoamServers.onDataTransferRsp@require roam servers done|req=%s|req_data=%s|rsp_data=%s", new Object[] { reqXidWrapper.getProtocol(), reqData, rspData }));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   protected void onDataTransferTimeout(DataTransferReqXidWrapper reqXidWrapper, CrossCompeteRoamServersReq reqData, int code)
/*    */   {
/* 57 */     GameServer.logger().error(String.format("[crosscompete]DTH_CrossCompeteRoamServers.onDataTransferTimeout@require roam servers timeout|req=%s|req_data=%s|code=%d", new Object[] { reqXidWrapper.getProtocol(), reqData, Integer.valueOf(code) }));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\main\DTH_CrossCompeteRoamServers.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */