/*    */ package mzm.gsp.crossserver.main;
/*    */ 
/*    */ import hub.DataTransferReq;
/*    */ import hub.DataTransferReqXidWrapper;
/*    */ import hub.DataTransferRsp;
/*    */ import hub.DataTransferRspXidWrapper;
/*    */ import hub.GHubHelper;
/*    */ import hub.NotifyPointRaceResultReq;
/*    */ import hub.NotifyPointRaceResultRsp;
/*    */ import mzm.event.TriggerEventsManger;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.crossbattle.point.PointRaceInfo;
/*    */ import mzm.gsp.crossserver.event.JoinPointRaceFail;
/*    */ import mzm.gsp.crossserver.event.JoinPointRaceFailArg;
/*    */ import mzm.gsp.crossserver.event.RoamPointRaceDataStart;
/*    */ import mzm.gsp.crossserver.event.RoamPointRaceDataStartArg;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ public class DTH_NotifyPointRaceResult extends DataTransferHandler<NotifyPointRaceResultReq, NotifyPointRaceResultRsp>
/*    */ {
/*    */   protected NotifyPointRaceResultReq makeReqDataBean()
/*    */   {
/* 23 */     return new NotifyPointRaceResultReq();
/*    */   }
/*    */   
/*    */ 
/*    */   protected NotifyPointRaceResultRsp makeRspDataBean()
/*    */   {
/* 29 */     return new NotifyPointRaceResultRsp();
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   protected void onDataTransferReq(DataTransferReq req, NotifyPointRaceResultReq reqData)
/*    */   {
/* 36 */     DataTransferRsp rsp = new DataTransferRsp();
/* 37 */     rsp.direction = req.direction;
/* 38 */     rsp.xid = req.xid;
/* 39 */     rsp.src_id = req.dst_id;
/* 40 */     rsp.dst_id = req.src_id;
/* 41 */     rsp.data_type = req.data_type;
/* 42 */     rsp.retcode = 2;
/*    */     
/* 44 */     PointRaceContext context = PointRaceContextManager.getInstance().getContext(reqData.game_server_contextid);
/* 45 */     if ((context == null) || (context.getMatcherServerContextid() != reqData.matcher_server_contextid))
/*    */     {
/* 47 */       GameServer.logger().error(String.format("[crossserver]DTH_NotifyPointRaceResult.onDataTransferReq@point race data not match|req=%s|req_data=%s|context=%s", new Object[] { req, reqData, context }));
/*    */       
/*    */ 
/*    */ 
/*    */ 
/* 52 */       GHubHelper.sendDataTransferRsp(rsp);
/* 53 */       return;
/*    */     }
/*    */     
/* 56 */     context.stopTimeoutWatchDog();
/* 57 */     boolean isSucceed = reqData.result == 0;
/* 58 */     if (isSucceed)
/*    */     {
/* 60 */       context.setRoamZoneid(reqData.roam_zoneid);
/* 61 */       context.setRoamRoomInstanceid(reqData.roam_room_instanceid);
/*    */     }
/*    */     
/* 64 */     rsp.retcode = 0;
/* 65 */     GameServer.logger().info(String.format("[crossserver]DTH_NotifyPointRaceResult.onDataTransferReq@handle notify result|req=%s|req_data=%s|rsp=%s|context=%s", new Object[] { req, reqData, rsp, context }));
/*    */     
/*    */ 
/*    */ 
/*    */ 
/* 70 */     if ((GHubHelper.sendDataTransferRsp(rsp)) && (isSucceed))
/*    */     {
/* 72 */       RoamPointRaceDataStart event = new RoamPointRaceDataStart();
/* 73 */       RoamPointRaceDataStartArg arg = new RoamPointRaceDataStartArg(context.contextid, context.corpsid, context.leaderid, context.rolePointRaceMarkingInfos, context.pointRaceInfo.getActivityCfgid(), context.pointRaceInfo.getTimePointCfgid());
/*    */       
/*    */ 
/*    */ 
/*    */ 
/* 78 */       TriggerEventsManger.getInstance().triggerEvent(event, arg);
/*    */     }
/*    */     else
/*    */     {
/* 82 */       JoinPointRaceFail event = new JoinPointRaceFail();
/* 83 */       JoinPointRaceFailArg arg = new JoinPointRaceFailArg(context.contextid, context.corpsid, context.leaderid, context.rolePointRaceMarkingInfos, context.pointRaceInfo.getActivityCfgid());
/*    */       
/*    */ 
/* 86 */       TriggerEventsManger.getInstance().triggerEvent(event, arg);
/*    */     }
/*    */   }
/*    */   
/*    */   protected void onDataTransferTimeout(DataTransferReqXidWrapper reqXidWrapper, NotifyPointRaceResultReq reqData, int code) {}
/*    */   
/*    */   protected void onDataTransferRsp(DataTransferReqXidWrapper reqXidWrapper, NotifyPointRaceResultReq reqData, DataTransferRspXidWrapper rspXidWrapper, NotifyPointRaceResultRsp rspData) {}
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\main\DTH_NotifyPointRaceResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */