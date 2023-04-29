/*    */ package mzm.gsp.crossserver.main;
/*    */ 
/*    */ import hub.DataTransferReq;
/*    */ import hub.DataTransferReqXidWrapper;
/*    */ import hub.DataTransferRsp;
/*    */ import hub.DataTransferRspXidWrapper;
/*    */ import hub.JoinPointRaceReq;
/*    */ import hub.JoinPointRaceRsp;
/*    */ import mzm.event.TriggerEventsManger;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.crossbattle.point.PointRaceInfo;
/*    */ import mzm.gsp.crossserver.event.JoinPointRaceFail;
/*    */ import mzm.gsp.crossserver.event.JoinPointRaceFailArg;
/*    */ import mzm.gsp.crossserver.event.JoinPointRaceStart;
/*    */ import mzm.gsp.crossserver.event.JoinPointRaceStartArg;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ public class DTH_JoinPointRace extends DataTransferHandler<JoinPointRaceReq, JoinPointRaceRsp>
/*    */ {
/*    */   protected JoinPointRaceReq makeReqDataBean()
/*    */   {
/* 22 */     return new JoinPointRaceReq();
/*    */   }
/*    */   
/*    */ 
/*    */   protected JoinPointRaceRsp makeRspDataBean()
/*    */   {
/* 28 */     return new JoinPointRaceRsp();
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   protected void onDataTransferReq(DataTransferReq req, JoinPointRaceReq reqData) {}
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   protected void onDataTransferTimeout(DataTransferReqXidWrapper reqXidWrapper, JoinPointRaceReq reqData, int code)
/*    */   {
/* 42 */     JoinPointRaceTransferReqXidWrapper xidWrapper = (JoinPointRaceTransferReqXidWrapper)reqXidWrapper;
/* 43 */     PointRaceContext context = xidWrapper.getContext();
/*    */     
/* 45 */     GameServer.logger().error(String.format("[crossserver]DTH_JoinPointRace.onDataTransferTimeout@join point race timeout|req=%s|req_data=%s|code=%d|match_context=%s", new Object[] { reqXidWrapper.getProtocol(), reqData, Integer.valueOf(code), context }));
/*    */     
/*    */ 
/*    */ 
/*    */ 
/* 50 */     JoinPointRaceFail event = new JoinPointRaceFail();
/* 51 */     JoinPointRaceFailArg arg = new JoinPointRaceFailArg(context.contextid, context.corpsid, context.leaderid, context.rolePointRaceMarkingInfos, context.pointRaceInfo.getActivityCfgid());
/*    */     
/*    */ 
/* 54 */     TriggerEventsManger.getInstance().triggerEvent(event, arg);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   protected void onDataTransferRsp(DataTransferReqXidWrapper reqXidWrapper, JoinPointRaceReq reqData, DataTransferRspXidWrapper rspXidWrapper, JoinPointRaceRsp rspData)
/*    */   {
/* 62 */     JoinPointRaceTransferReqXidWrapper xidWrapper = (JoinPointRaceTransferReqXidWrapper)reqXidWrapper;
/* 63 */     PointRaceContext context = xidWrapper.getContext();
/*    */     
/* 65 */     GameServer.logger().info(String.format("[crossserver]DTH_JoinPointRace.onDataTransferRsp@join match rsp|req=%s|req_data=%s|rsp=%s|rsp_data=%s|match_context=%s", new Object[] { reqXidWrapper.getProtocol(), reqData, rspXidWrapper.getProtocol(), rspData, context }));
/*    */     
/*    */ 
/*    */ 
/*    */ 
/* 70 */     DataTransferRsp rsp = rspXidWrapper.getProtocol();
/* 71 */     if (rsp.retcode != 0)
/*    */     {
/* 73 */       JoinPointRaceFail event = new JoinPointRaceFail();
/* 74 */       JoinPointRaceFailArg arg = new JoinPointRaceFailArg(context.contextid, context.corpsid, context.leaderid, context.rolePointRaceMarkingInfos, context.pointRaceInfo.getActivityCfgid());
/*    */       
/*    */ 
/* 77 */       TriggerEventsManger.getInstance().triggerEvent(event, arg);
/*    */ 
/*    */     }
/*    */     else
/*    */     {
/* 82 */       context.setMatcherServerContextid(rspData.matcher_server_contextid);
/*    */       
/* 84 */       JoinPointRaceStart event = new JoinPointRaceStart();
/* 85 */       JoinPointRaceStartArg arg = new JoinPointRaceStartArg(context.contextid, context.corpsid, context.leaderid, context.rolePointRaceMarkingInfos, context.getCreateTime());
/*    */       
/*    */ 
/* 88 */       TriggerEventsManger.getInstance().triggerEvent(event, arg);
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\main\DTH_JoinPointRace.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */