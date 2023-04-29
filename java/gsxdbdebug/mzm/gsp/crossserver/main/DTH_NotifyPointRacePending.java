/*    */ package mzm.gsp.crossserver.main;
/*    */ 
/*    */ import hub.DataTransferReq;
/*    */ import hub.DataTransferReqXidWrapper;
/*    */ import hub.DataTransferRsp;
/*    */ import hub.DataTransferRspXidWrapper;
/*    */ import hub.GHubHelper;
/*    */ import hub.NotifyPointRacePendingReq;
/*    */ import hub.NotifyPointRacePendingRsp;
/*    */ import mzm.event.TriggerEventsManger;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.crossbattle.point.PointRaceInfo;
/*    */ import mzm.gsp.crossserver.event.JoinPointRacePending;
/*    */ import mzm.gsp.crossserver.event.JoinPointRacePendingArg;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ public class DTH_NotifyPointRacePending extends DataTransferHandler<NotifyPointRacePendingReq, NotifyPointRacePendingRsp>
/*    */ {
/*    */   protected NotifyPointRacePendingReq makeReqDataBean()
/*    */   {
/* 21 */     return new NotifyPointRacePendingReq();
/*    */   }
/*    */   
/*    */ 
/*    */   protected NotifyPointRacePendingRsp makeRspDataBean()
/*    */   {
/* 27 */     return new NotifyPointRacePendingRsp();
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   protected void onDataTransferReq(DataTransferReq req, NotifyPointRacePendingReq reqData)
/*    */   {
/* 34 */     DataTransferRsp rsp = new DataTransferRsp();
/* 35 */     rsp.direction = req.direction;
/* 36 */     rsp.xid = req.xid;
/* 37 */     rsp.src_id = req.dst_id;
/* 38 */     rsp.dst_id = req.src_id;
/* 39 */     rsp.data_type = req.data_type;
/* 40 */     rsp.retcode = 2;
/*    */     
/* 42 */     PointRaceContext context = PointRaceContextManager.getInstance().getContext(reqData.game_server_contextid);
/* 43 */     if ((context == null) || (context.getMatcherServerContextid() != reqData.matcher_server_contextid))
/*    */     {
/* 45 */       GameServer.logger().error(String.format("[crossserver]DTH_NotifyPointRacePending.onDataTransferReq@point race data not match|req=%s|req_data=%s|context=%s", new Object[] { req, reqData, context }));
/*    */       
/*    */ 
/*    */ 
/*    */ 
/* 50 */       GHubHelper.sendDataTransferRsp(rsp);
/* 51 */       return;
/*    */     }
/*    */     
/* 54 */     rsp.retcode = 0;
/* 55 */     GameServer.logger().info(String.format("[crossserver]DTH_NotifyPointRacePending.onDataTransferReq@handle notify pending|req=%s|req_data=%s|rsp=%s|context=%s", new Object[] { req, reqData, rsp, context }));
/*    */     
/*    */ 
/*    */ 
/*    */ 
/* 60 */     if (GHubHelper.sendDataTransferRsp(rsp))
/*    */     {
/* 62 */       JoinPointRacePending event = new JoinPointRacePending();
/* 63 */       JoinPointRacePendingArg arg = new JoinPointRacePendingArg(context.contextid, context.corpsid, context.leaderid, context.rolePointRaceMarkingInfos, context.pointRaceInfo.getActivityCfgid());
/*    */       
/*    */ 
/*    */ 
/* 67 */       TriggerEventsManger.getInstance().triggerEvent(event, arg);
/*    */     }
/*    */   }
/*    */   
/*    */   protected void onDataTransferTimeout(DataTransferReqXidWrapper reqXidWrapper, NotifyPointRacePendingReq reqData, int code) {}
/*    */   
/*    */   protected void onDataTransferRsp(DataTransferReqXidWrapper reqXidWrapper, NotifyPointRacePendingReq reqData, DataTransferRspXidWrapper rspXidWrapper, NotifyPointRacePendingRsp rspData) {}
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\main\DTH_NotifyPointRacePending.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */