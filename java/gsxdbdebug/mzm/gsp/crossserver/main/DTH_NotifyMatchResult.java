/*    */ package mzm.gsp.crossserver.main;
/*    */ 
/*    */ import hub.DataTransferReq;
/*    */ import hub.DataTransferReqXidWrapper;
/*    */ import hub.DataTransferRsp;
/*    */ import hub.DataTransferRspXidWrapper;
/*    */ import hub.GHubHelper;
/*    */ import hub.NotifyMatchResultReq;
/*    */ import hub.NotifyMatchResultRsp;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import mzm.event.TriggerEventsManger;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.crossserver.event.MatchFail;
/*    */ import mzm.gsp.crossserver.event.MatchFailArg;
/*    */ import mzm.gsp.crossserver.event.MatchSucceed;
/*    */ import mzm.gsp.crossserver.event.MatchSucceedArg;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class DTH_NotifyMatchResult
/*    */   extends DataTransferHandler<NotifyMatchResultReq, NotifyMatchResultRsp>
/*    */ {
/*    */   protected NotifyMatchResultReq makeReqDataBean()
/*    */   {
/* 27 */     return new NotifyMatchResultReq();
/*    */   }
/*    */   
/*    */ 
/*    */   protected NotifyMatchResultRsp makeRspDataBean()
/*    */   {
/* 33 */     return new NotifyMatchResultRsp();
/*    */   }
/*    */   
/*    */ 
/*    */   protected void onDataTransferReq(DataTransferReq req, NotifyMatchResultReq reqData)
/*    */   {
/* 39 */     DataTransferRsp rsp = new DataTransferRsp();
/* 40 */     rsp.direction = req.direction;
/* 41 */     rsp.xid = req.xid;
/* 42 */     rsp.src_id = req.dst_id;
/* 43 */     rsp.dst_id = req.src_id;
/* 44 */     rsp.data_type = req.data_type;
/* 45 */     rsp.retcode = 2;
/* 46 */     MatchContext context = MatchContextManager.getInstance().getContext(reqData.game_server_contextid);
/* 47 */     if ((context == null) || (context.activityContext.getMatchActivityContextType().typeid != reqData.activity_context_typeid) || (context.getMatcherServerContextid() != reqData.matcher_server_contextid))
/*    */     {
/*    */ 
/* 50 */       GameServer.logger().error(String.format("[crossserver]DTH_NotifyMatchResult.onDataTransferReq@match data not match|req=%s|req_data=%s|context=%s", new Object[] { req, reqData, context }));
/*    */       
/*    */ 
/*    */ 
/*    */ 
/* 55 */       GHubHelper.sendDataTransferRsp(rsp);
/*    */       
/* 57 */       return;
/*    */     }
/*    */     
/* 60 */     context.stopTimeoutWatchDog();
/* 61 */     context.setRoamZoneid(reqData.roam_zoneid);
/* 62 */     context.setRoamRoomInstanceid(reqData.roam_room_instanceid);
/* 63 */     List<RoleMatchMarkingInfo> opponentRoleMatchMarkingInfos = new ArrayList();
/* 64 */     for (hub.RoleMatchMarkingInfo roleMMInfo : reqData.opponent_role_infos)
/*    */     {
/* 66 */       RoleMatchMarkingInfo roleMatchMarkingInfo = new RoleMatchMarkingInfo(roleMMInfo);
/* 67 */       opponentRoleMatchMarkingInfos.add(roleMatchMarkingInfo);
/*    */     }
/* 69 */     if ((opponentRoleMatchMarkingInfos.size() > 0) && (context.setOpponentRoleMatchMarkingInfos(opponentRoleMatchMarkingInfos)))
/*    */     {
/* 71 */       context.setOpponentLeaderid(((RoleMatchMarkingInfo)opponentRoleMatchMarkingInfos.get(0)).getRoleid());
/*    */       
/* 73 */       rsp.retcode = 0;
/*    */     }
/*    */     
/* 76 */     GameServer.logger().info(String.format("[crossserver]DTH_NotifyMatchResult.onDataTransferReq@handle notify match result|req=%s|req_data=%s|rsp=%s|context=%s", new Object[] { req, reqData, rsp, context }));
/*    */     
/*    */ 
/*    */ 
/*    */ 
/* 81 */     if ((GHubHelper.sendDataTransferRsp(rsp)) && (rsp.retcode == 0))
/*    */     {
/* 83 */       MatchSucceed event = new MatchSucceed();
/* 84 */       MatchSucceedArg arg = new MatchSucceedArg(context.contextid, context.leaderid, context.roleMatchMarkingInfos, context.getOpponentLeaderid(), context.getOpponentRoleMatchMarkingInfos(), context.activityContext, context.getRoamZoneid(), context.getRoamRoomInstanceid(), context.getCreateTime());
/*    */       
/*    */ 
/*    */ 
/*    */ 
/* 89 */       TriggerEventsManger.getInstance().triggerEvent(event, arg);
/*    */     }
/*    */     else
/*    */     {
/* 93 */       MatchFail event = new MatchFail();
/* 94 */       MatchFailArg arg = new MatchFailArg(context.contextid, context.leaderid, context.roleMatchMarkingInfos, context.activityContext, context.getCreateTime());
/*    */       
/* 96 */       TriggerEventsManger.getInstance().triggerEvent(event, arg);
/*    */     }
/*    */   }
/*    */   
/*    */   protected void onDataTransferTimeout(DataTransferReqXidWrapper reqXidWrapper, NotifyMatchResultReq reqData, int code) {}
/*    */   
/*    */   protected void onDataTransferRsp(DataTransferReqXidWrapper reqXidWrapper, NotifyMatchResultReq reqData, DataTransferRspXidWrapper rspXidWrapper, NotifyMatchResultRsp rspData) {}
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\main\DTH_NotifyMatchResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */