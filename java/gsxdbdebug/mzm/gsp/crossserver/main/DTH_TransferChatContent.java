/*    */ package mzm.gsp.crossserver.main;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import com.goldhuman.Common.Octets;
/*    */ import hub.DataTransferReq;
/*    */ import hub.DataTransferReqXidWrapper;
/*    */ import hub.DataTransferRsp;
/*    */ import hub.DataTransferRspXidWrapper;
/*    */ import hub.GHubHelper;
/*    */ import hub.TransferChatContentReq;
/*    */ import hub.TransferChatContentRsp;
/*    */ import mzm.event.TriggerEventsManger;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.crossserver.event.ReceiveChatContent;
/*    */ import mzm.gsp.crossserver.event.ReceiveChatContentArg;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class DTH_TransferChatContent
/*    */   extends DataTransferHandler<TransferChatContentReq, TransferChatContentRsp>
/*    */ {
/*    */   protected TransferChatContentReq makeReqDataBean()
/*    */   {
/* 28 */     return new TransferChatContentReq();
/*    */   }
/*    */   
/*    */ 
/*    */   protected TransferChatContentRsp makeRspDataBean()
/*    */   {
/* 34 */     return new TransferChatContentRsp();
/*    */   }
/*    */   
/*    */ 
/*    */   protected void onDataTransferReq(DataTransferReq req, TransferChatContentReq reqData)
/*    */   {
/* 40 */     DataTransferRsp rsp = new DataTransferRsp();
/* 41 */     rsp.direction = req.direction;
/* 42 */     rsp.xid = req.xid;
/* 43 */     rsp.src_id = req.dst_id;
/* 44 */     rsp.dst_id = req.src_id;
/* 45 */     rsp.data_type = req.data_type;
/* 46 */     rsp.retcode = 0;
/* 47 */     TransferChatContentRsp rspData = new TransferChatContentRsp();
/* 48 */     OctetsStream os = new OctetsStream();
/* 49 */     os.marshal(rspData);
/* 50 */     rsp.data.replace(os);
/*    */     
/* 52 */     TriggerEventsManger.getInstance().triggerEvent(new ReceiveChatContent(), new ReceiveChatContentArg(reqData.roleid, reqData.channel, reqData.org_key, reqData.chat_content));
/*    */     
/*    */ 
/* 55 */     GameServer.logger().info(String.format("[crossserver]DTH_TransferChatContent.onDataTransferReq@handle transfer chat content|req=%s|req_data=%s|rsp=%s", new Object[] { req, reqData, rsp }));
/*    */     
/*    */ 
/*    */ 
/* 59 */     GHubHelper.sendDataTransferRsp(rsp);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   protected void onDataTransferRsp(DataTransferReqXidWrapper reqXidWrapper, TransferChatContentReq reqData, DataTransferRspXidWrapper rspXidWrapper, TransferChatContentRsp rspData)
/*    */   {
/* 66 */     DataTransferRsp rsp = rspXidWrapper.getProtocol();
/* 67 */     GameServer.logger().info(String.format("[crossserver]DTH_TransferChatContent.onDataTransferReq@transfer chat content rsp|errorcode=%d|req_data=%s", new Object[] { Integer.valueOf(rsp.retcode), reqData.toString() }));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   protected void onDataTransferTimeout(DataTransferReqXidWrapper reqXidWrapper, TransferChatContentReq reqData, int code)
/*    */   {
/* 76 */     GameServer.logger().error(String.format("[crossserver]DTH_TransferChatContent.onDataTransferReq@transfer chat content timeout|req_data=%s", new Object[] { reqData }));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\main\DTH_TransferChatContent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */