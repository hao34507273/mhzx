/*    */ package mzm.gsp.crossserver.main;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import com.goldhuman.Common.Octets;
/*    */ import hub.DataTransferReq;
/*    */ import hub.DataTransferReqXidWrapper;
/*    */ import hub.DataTransferRsp;
/*    */ import hub.DataTransferRspXidWrapper;
/*    */ import hub.GHubHelper;
/*    */ import hub.SingleCrossFieldWaitNextRoundMatchReq;
/*    */ import hub.SingleCrossFieldWaitNextRoundMatchRsp;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.crossfield.main.CrossFieldInterface;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class DTH_SingleCrossFieldWaitNextRoundMatch
/*    */   extends DataTransferHandler<SingleCrossFieldWaitNextRoundMatchReq, SingleCrossFieldWaitNextRoundMatchRsp>
/*    */ {
/*    */   protected SingleCrossFieldWaitNextRoundMatchReq makeReqDataBean()
/*    */   {
/* 27 */     return new SingleCrossFieldWaitNextRoundMatchReq();
/*    */   }
/*    */   
/*    */ 
/*    */   protected SingleCrossFieldWaitNextRoundMatchRsp makeRspDataBean()
/*    */   {
/* 33 */     return new SingleCrossFieldWaitNextRoundMatchRsp();
/*    */   }
/*    */   
/*    */ 
/*    */   protected void onDataTransferReq(DataTransferReq req, SingleCrossFieldWaitNextRoundMatchReq reqData)
/*    */   {
/* 39 */     DataTransferRsp rsp = new DataTransferRsp();
/* 40 */     rsp.direction = req.direction;
/* 41 */     rsp.xid = req.xid;
/* 42 */     rsp.src_id = req.dst_id;
/* 43 */     rsp.dst_id = req.src_id;
/* 44 */     rsp.data_type = req.data_type;
/* 45 */     SingleCrossFieldContext context = SingleCrossFieldContextManager.getInstance().getContext(reqData.game_server_contextid);
/*    */     
/* 47 */     if ((context == null) || (context.getMatcherServerContextid() != reqData.matcher_server_contextid))
/*    */     {
/* 49 */       rsp.retcode = 2;
/* 50 */       GameServer.logger().error(String.format("[crossserver]DTH_SingleCrossFieldWaitNextRoundMatch.onDataTransferReq@match context not match|req=%s|req_data=%s|context=%s", new Object[] { req, reqData, context }));
/*    */ 
/*    */ 
/*    */     }
/*    */     else
/*    */     {
/*    */ 
/* 57 */       context.setWaitNextRoundMatch(true);
/* 58 */       CrossFieldInterface.onWaitNextRoundMatch(context.getRoleid(), reqData.reason);
/* 59 */       rsp.retcode = 0;
/* 60 */       GameServer.logger().info(String.format("[crossserver]DTH_SingleCrossFieldWaitNextRoundMatch.onDataTransferReq@handle wait next round match done|req=%s|req_data=%s|rsp=%s|context=%s", new Object[] { req, reqData, rsp, context }));
/*    */     }
/*    */     
/*    */ 
/*    */ 
/*    */ 
/* 66 */     SingleCrossFieldWaitNextRoundMatchRsp rspData = new SingleCrossFieldWaitNextRoundMatchRsp();
/* 67 */     OctetsStream os = new OctetsStream();
/* 68 */     os.marshal(rspData);
/* 69 */     rsp.data.replace(os);
/*    */     
/* 71 */     GHubHelper.sendDataTransferRsp(rsp);
/*    */   }
/*    */   
/*    */   protected void onDataTransferRsp(DataTransferReqXidWrapper reqXidWrapper, SingleCrossFieldWaitNextRoundMatchReq reqData, DataTransferRspXidWrapper rspXidWrapper, SingleCrossFieldWaitNextRoundMatchRsp rspData) {}
/*    */   
/*    */   protected void onDataTransferTimeout(DataTransferReqXidWrapper reqXidWrapper, SingleCrossFieldWaitNextRoundMatchReq reqData, int code) {}
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\main\DTH_SingleCrossFieldWaitNextRoundMatch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */