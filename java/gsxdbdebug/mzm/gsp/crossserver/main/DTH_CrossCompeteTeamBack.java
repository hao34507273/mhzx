/*    */ package mzm.gsp.crossserver.main;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import hub.CrossCompeteTeamBackReq;
/*    */ import hub.CrossCompeteTeamBackRsp;
/*    */ import hub.CrossCompeteUserDataBack;
/*    */ import hub.DataTransferReq;
/*    */ import hub.DataTransferReqXidWrapper;
/*    */ import hub.DataTransferRsp;
/*    */ import hub.DataTransferRspXidWrapper;
/*    */ import hub.GHubHelper;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.crosscompete.main.PCreateTeamBackContext;
/*    */ import mzm.gsp.crosscompete.roam.PReturnOriginalServer;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class DTH_CrossCompeteTeamBack
/*    */   extends DataTransferHandler<CrossCompeteTeamBackReq, CrossCompeteTeamBackRsp>
/*    */ {
/*    */   protected CrossCompeteTeamBackReq makeReqDataBean()
/*    */   {
/* 27 */     return new CrossCompeteTeamBackReq();
/*    */   }
/*    */   
/*    */   protected CrossCompeteTeamBackRsp makeRspDataBean()
/*    */   {
/* 32 */     return new CrossCompeteTeamBackRsp();
/*    */   }
/*    */   
/*    */ 
/*    */   protected void onDataTransferReq(DataTransferReq req, CrossCompeteTeamBackReq reqData)
/*    */   {
/* 38 */     DataTransferRsp rsp = new DataTransferRsp();
/* 39 */     rsp.direction = req.direction;
/* 40 */     rsp.xid = req.xid;
/* 41 */     rsp.src_id = req.dst_id;
/* 42 */     rsp.dst_id = req.src_id;
/* 43 */     rsp.data_type = req.data_type;
/* 44 */     rsp.retcode = 0;
/*    */     
/*    */ 
/* 47 */     PCreateTeamBackContext pCreateContext = new PCreateTeamBackContext(reqData.users);
/* 48 */     pCreateContext.call();
/*    */     
/* 50 */     CrossCompeteTeamBackRsp rspData = new CrossCompeteTeamBackRsp();
/* 51 */     OctetsStream os = new OctetsStream();
/* 52 */     os.marshal(rspData);
/* 53 */     rsp.data = os;
/*    */     
/* 55 */     GHubHelper.sendDataTransferRsp(rsp);
/*    */     
/* 57 */     GameServer.logger().info(String.format("[crosscompete]DTH_CrossCompeteTeamBack.onDataTransferReq@team back|users=%s", new Object[] { reqData.users }));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   protected void onDataTransferRsp(DataTransferReqXidWrapper reqXidWrapper, CrossCompeteTeamBackReq reqData, DataTransferRspXidWrapper rspXidWrapper, CrossCompeteTeamBackRsp rspData)
/*    */   {
/* 68 */     for (CrossCompeteUserDataBack userData : reqData.users) {
/* 69 */       new PReturnOriginalServer(userData.roleid, userData.userid).call();
/*    */     }
/*    */     
/* 72 */     GameServer.logger().info(String.format("[crosscompete]DTH_CrossCompeteTeamBack.onDataTransferRsp@team back succeed|users=%s", new Object[] { reqData.users }));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   protected void onDataTransferTimeout(DataTransferReqXidWrapper reqXidWrapper, CrossCompeteTeamBackReq reqData, int code)
/*    */   {
/* 82 */     for (CrossCompeteUserDataBack userData : reqData.users) {
/* 83 */       new PReturnOriginalServer(userData.roleid, userData.userid).call();
/*    */     }
/*    */     
/* 86 */     GameServer.logger().error(String.format("[crosscompete]DTH_CrossCompeteTeamBack.onDataTransferRsp@team back timeout|users=%s|code=%d", new Object[] { reqData.users, Integer.valueOf(code) }));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\main\DTH_CrossCompeteTeamBack.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */