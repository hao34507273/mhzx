/*    */ package mzm.gsp.crossserver.main;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import hub.DataTransferReq;
/*    */ import hub.DataTransferReqXidWrapper;
/*    */ import hub.DataTransferRsp;
/*    */ import hub.DataTransferRspXidWrapper;
/*    */ import hub.GHubHelper;
/*    */ import hub.NotifyCrossCompeteResultReq;
/*    */ import hub.NotifyCrossCompeteResultRsp;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.crosscompete.main.PSaveResult;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class DTH_NotifyCrossCompeteResult
/*    */   extends DataTransferHandler<NotifyCrossCompeteResultReq, NotifyCrossCompeteResultRsp>
/*    */ {
/*    */   protected NotifyCrossCompeteResultReq makeReqDataBean()
/*    */   {
/* 26 */     return new NotifyCrossCompeteResultReq();
/*    */   }
/*    */   
/*    */   protected NotifyCrossCompeteResultRsp makeRspDataBean()
/*    */   {
/* 31 */     return new NotifyCrossCompeteResultRsp();
/*    */   }
/*    */   
/*    */ 
/*    */   protected void onDataTransferReq(DataTransferReq req, NotifyCrossCompeteResultReq reqData)
/*    */   {
/* 37 */     DataTransferRsp rsp = new DataTransferRsp();
/* 38 */     rsp.direction = req.direction;
/* 39 */     rsp.xid = req.xid;
/* 40 */     rsp.src_id = req.dst_id;
/* 41 */     rsp.dst_id = req.src_id;
/* 42 */     rsp.data_type = req.data_type;
/*    */     
/* 44 */     rsp.retcode = 0;
/*    */     
/*    */ 
/* 47 */     if (!new PSaveResult(reqData.win_factionid, reqData.lose_factionid).call()) {
/* 48 */       GameServer.logger().error(String.format("[crosscompete]DTH_NotifyCrossCompeteResult.onDataTransferRsp@save result failed|win_factionid=%d|lose_factionid=%d", new Object[] { Long.valueOf(reqData.win_factionid), Long.valueOf(reqData.lose_factionid) }));
/*    */ 
/*    */ 
/*    */     }
/*    */     else
/*    */     {
/*    */ 
/* 55 */       GameServer.logger().info(String.format("[crosscompete]DTH_NotifyCrossCompeteResult.onDataTransferRsp@save result succeed|win_factionid=%d|lose_factionid=%d", new Object[] { Long.valueOf(reqData.win_factionid), Long.valueOf(reqData.lose_factionid) }));
/*    */     }
/*    */     
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 62 */     NotifyCrossCompeteResultRsp rspData = new NotifyCrossCompeteResultRsp();
/* 63 */     OctetsStream os = new OctetsStream();
/* 64 */     os.marshal(rspData);
/* 65 */     rsp.data = os;
/*    */     
/* 67 */     GHubHelper.sendDataTransferRsp(rsp);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   protected void onDataTransferRsp(DataTransferReqXidWrapper reqXidWrapper, NotifyCrossCompeteResultReq reqData, DataTransferRspXidWrapper rspXidWrapper, NotifyCrossCompeteResultRsp rspData)
/*    */   {
/* 76 */     GameServer.logger().info(String.format("[crosscompete]DTH_NotifyCrossCompeteResult.onDataTransferRsp@notify result succeed|win_factionid=%d|lose_factionid=%d", new Object[] { Long.valueOf(reqData.win_factionid), Long.valueOf(reqData.lose_factionid) }));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   protected void onDataTransferTimeout(DataTransferReqXidWrapper reqXidWrapper, NotifyCrossCompeteResultReq reqData, int code)
/*    */   {
/* 87 */     GameServer.logger().error(String.format("[crosscompete]DTH_NotifyCrossCompeteResult.onDataTransferTimeout@notify result timeout|win_factionid=%d|lose_factionid=%d|code=%d", new Object[] { Long.valueOf(reqData.win_factionid), Long.valueOf(reqData.lose_factionid), Integer.valueOf(code) }));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\main\DTH_NotifyCrossCompeteResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */