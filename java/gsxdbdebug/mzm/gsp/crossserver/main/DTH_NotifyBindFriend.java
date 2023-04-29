/*    */ package mzm.gsp.crossserver.main;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import hub.DataTransferReq;
/*    */ import hub.DataTransferReqXidWrapper;
/*    */ import hub.DataTransferRsp;
/*    */ import hub.DataTransferRspXidWrapper;
/*    */ import hub.GHubHelper;
/*    */ import hub.RecallNotifyBindFriendReq;
/*    */ import hub.RecallNotifyBindFriendRsp;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.grc.main.PNotifyBindFriendRemote;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ 
/*    */ public class DTH_NotifyBindFriend
/*    */   extends DataTransferHandler<RecallNotifyBindFriendReq, RecallNotifyBindFriendRsp>
/*    */ {
/*    */   protected RecallNotifyBindFriendReq makeReqDataBean()
/*    */   {
/* 21 */     return new RecallNotifyBindFriendReq();
/*    */   }
/*    */   
/*    */ 
/*    */   protected RecallNotifyBindFriendRsp makeRspDataBean()
/*    */   {
/* 27 */     return new RecallNotifyBindFriendRsp();
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   protected void onDataTransferReq(DataTransferReq req, RecallNotifyBindFriendReq reqData)
/*    */   {
/* 34 */     PNotifyBindFriendRemote pTask = new PNotifyBindFriendRemote(reqData);
/* 35 */     pTask.call();
/*    */     
/*    */ 
/* 38 */     DataTransferRsp rsp = new DataTransferRsp();
/* 39 */     rsp.direction = req.direction;
/* 40 */     rsp.xid = req.xid;
/* 41 */     rsp.src_id = req.dst_id;
/* 42 */     rsp.dst_id = req.src_id;
/* 43 */     rsp.data_type = req.data_type;
/* 44 */     rsp.retcode = 0;
/*    */     
/* 46 */     RecallNotifyBindFriendRsp notifyBindFriendRsp = new RecallNotifyBindFriendRsp();
/* 47 */     notifyBindFriendRsp.retcode = pTask.getRetcode();
/* 48 */     OctetsStream os = new OctetsStream();
/* 49 */     notifyBindFriendRsp.marshal(os);
/* 50 */     rsp.data = os;
/* 51 */     GHubHelper.sendDataTransferRsp(rsp);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   protected void onDataTransferTimeout(DataTransferReqXidWrapper reqXidWrapper, RecallNotifyBindFriendReq reqData, int code)
/*    */   {
/* 59 */     NotifyBindFriendTransferReqXidWrapper xidWrapper = (NotifyBindFriendTransferReqXidWrapper)reqXidWrapper;
/*    */     
/* 61 */     GameServer.logger().error(String.format("[crossserver]DTH_NotifyBindFriend.onDataTransferTimeout@timeout|req=%s|req_data=%s|code=%d|userid=%s|roleid=%d", new Object[] { reqXidWrapper.getProtocol(), reqData, Integer.valueOf(code), xidWrapper.userid, Long.valueOf(xidWrapper.roleid) }));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   protected void onDataTransferRsp(DataTransferReqXidWrapper reqXidWrapper, RecallNotifyBindFriendReq reqData, DataTransferRspXidWrapper rspXidWrapper, RecallNotifyBindFriendRsp rspData)
/*    */   {
/* 72 */     NotifyBindFriendTransferReqXidWrapper xidWrapper = (NotifyBindFriendTransferReqXidWrapper)reqXidWrapper;
/* 73 */     DataTransferRsp rsp = rspXidWrapper.getProtocol();
/*    */     
/* 75 */     GameServer.logger().info(String.format("[crossserver]DTH_NotifyBindFriend.onDataTransferRsp@handle rsp|req=%s|req_data=%s|rsp=%s|rsp_data=%s|userid=%s|roleid=%d|retcode=%d", new Object[] { reqXidWrapper.getProtocol(), reqData, rsp, rspData, xidWrapper.userid, Long.valueOf(xidWrapper.roleid), Integer.valueOf(rspData.retcode) }));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\main\DTH_NotifyBindFriend.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */