/*    */ package mzm.gsp.crossserver.main;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import hub.CrossCompeteRoleDataBackReq;
/*    */ import hub.CrossCompeteRoleDataBackRsp;
/*    */ import hub.DataTransferReq;
/*    */ import hub.DataTransferReqXidWrapper;
/*    */ import hub.DataTransferRsp;
/*    */ import hub.DataTransferRspXidWrapper;
/*    */ import hub.ExchangeDataHandlerInfo;
/*    */ import hub.GHubHelper;
/*    */ import java.util.ArrayList;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.crosscompete.main.PRoleBack;
/*    */ import mzm.gsp.crosscompete.roam.PReturnOriginalServer;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class DTH_CrossCompeteRoleDataBack
/*    */   extends DataTransferHandler<CrossCompeteRoleDataBackReq, CrossCompeteRoleDataBackRsp>
/*    */ {
/*    */   protected CrossCompeteRoleDataBackReq makeReqDataBean()
/*    */   {
/* 27 */     return new CrossCompeteRoleDataBackReq();
/*    */   }
/*    */   
/*    */   protected CrossCompeteRoleDataBackRsp makeRspDataBean()
/*    */   {
/* 32 */     return new CrossCompeteRoleDataBackRsp();
/*    */   }
/*    */   
/*    */ 
/*    */   protected void onDataTransferReq(DataTransferReq req, CrossCompeteRoleDataBackReq reqData)
/*    */   {
/* 38 */     DataTransferRsp rsp = new DataTransferRsp();
/* 39 */     rsp.direction = req.direction;
/* 40 */     rsp.xid = req.xid;
/* 41 */     rsp.src_id = req.dst_id;
/* 42 */     rsp.dst_id = req.src_id;
/* 43 */     rsp.data_type = req.data_type;
/*    */     
/* 45 */     rsp.retcode = 0;
/*    */     
/* 47 */     PRoleBack pBack = new PRoleBack(reqData.roleid, reqData.userid, reqData.user_token, reqData.win_times, reqData.lose_times, reqData.escape_times, reqData.win_streak_award_times, reqData.treasure_award, reqData.reason, reqData.exchange_data_handler_info.isEmpty() ? null : (ExchangeDataHandlerInfo)reqData.exchange_data_handler_info.get(0));
/*    */     
/*    */ 
/*    */ 
/*    */ 
/* 52 */     if (!pBack.call()) {
/* 53 */       GameServer.logger().error(String.format("[crosscompete]DTH_CrossCompeteRoleDataBack.onDataTransferReq@role data back err|roleid=%d|reason=%d", new Object[] { Long.valueOf(reqData.roleid), Integer.valueOf(reqData.reason) }));
/*    */ 
/*    */     }
/*    */     else
/*    */     {
/*    */ 
/* 59 */       GameServer.logger().info(String.format("[crosscompete]DTH_CrossCompeteRoleDataBack.onDataTransferReq@role data back succeed|roleid=%d|reason=%d", new Object[] { Long.valueOf(reqData.roleid), Integer.valueOf(reqData.reason) }));
/*    */     }
/*    */     
/*    */ 
/*    */ 
/*    */ 
/* 65 */     CrossCompeteRoleDataBackRsp rspData = new CrossCompeteRoleDataBackRsp();
/* 66 */     OctetsStream os = new OctetsStream();
/* 67 */     os.marshal(rspData);
/* 68 */     rsp.data = os;
/*    */     
/* 70 */     GHubHelper.sendDataTransferRsp(rsp);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   protected void onDataTransferRsp(DataTransferReqXidWrapper reqXidWrapper, CrossCompeteRoleDataBackReq reqData, DataTransferRspXidWrapper rspXidWrapper, CrossCompeteRoleDataBackRsp rspData)
/*    */   {
/* 78 */     if (new PReturnOriginalServer(reqData.roleid, reqData.userid).call()) {
/* 79 */       GameServer.logger().info(String.format("[crossserver]DTH_CrossCompeteRoleDataBack.onDataTransferRsp@role data back done|roleid=%d", new Object[] { Long.valueOf(reqData.roleid) }));
/*    */ 
/*    */     }
/*    */     else
/*    */     {
/*    */ 
/* 85 */       GameServer.logger().error(String.format("[crossserver]DTH_CrossCompeteRoleDataBack.onDataTransferRsp@return original err|roleid=%d", new Object[] { Long.valueOf(reqData.roleid) }));
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   protected void onDataTransferTimeout(DataTransferReqXidWrapper reqXidWrapper, CrossCompeteRoleDataBackReq reqData, int code)
/*    */   {
/* 96 */     new PReturnOriginalServer(reqData.roleid, reqData.userid).call();
/*    */     
/* 98 */     GameServer.logger().error(String.format("[crossserver]DTH_CrossCompeteRoleDataBack.onDataTransferTimeout@role data back timeout|roleid=%d|req=%s|req_data=%s|code=%d", new Object[] { Long.valueOf(reqData.roleid), reqXidWrapper.getProtocol(), reqData, Integer.valueOf(code) }));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\main\DTH_CrossCompeteRoleDataBack.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */