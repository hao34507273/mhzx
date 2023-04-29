/*     */ package mzm.gsp.crossserver.main;
/*     */ 
/*     */ import hub.DataTransferReq;
/*     */ import hub.DataTransferReqXidWrapper;
/*     */ import hub.DataTransferRsp;
/*     */ import hub.DataTransferRspXidWrapper;
/*     */ import hub.GHubHelper;
/*     */ import hub.NotifySelectionOrFinalMatchReq;
/*     */ import hub.NotifySelectionOrFinalMatchRsp;
/*     */ import java.util.List;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.crossserver.event.SelectionOrFinalMatchFailed;
/*     */ import mzm.gsp.crossserver.event.SelectionOrFinalMatchFailedArg;
/*     */ import mzm.gsp.crossserver.event.SelectionOrFinalMatchSucceed;
/*     */ import mzm.gsp.crossserver.event.SelectionOrFinalMatchSucceedArg;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DTH_NotifyKnockOutMatchResult
/*     */   extends DataTransferHandler<NotifySelectionOrFinalMatchReq, NotifySelectionOrFinalMatchRsp>
/*     */ {
/*     */   public NotifySelectionOrFinalMatchReq makeReqDataBean()
/*     */   {
/*  27 */     return new NotifySelectionOrFinalMatchReq();
/*     */   }
/*     */   
/*     */ 
/*     */   public NotifySelectionOrFinalMatchRsp makeRspDataBean()
/*     */   {
/*  33 */     return new NotifySelectionOrFinalMatchRsp();
/*     */   }
/*     */   
/*     */ 
/*     */   public void onDataTransferReq(DataTransferReq req, NotifySelectionOrFinalMatchReq reqData)
/*     */   {
/*  39 */     DataTransferRsp rsp = new DataTransferRsp();
/*  40 */     rsp.direction = req.direction;
/*  41 */     rsp.xid = req.xid;
/*  42 */     rsp.src_id = req.dst_id;
/*  43 */     rsp.dst_id = req.src_id;
/*  44 */     rsp.data_type = req.data_type;
/*  45 */     rsp.retcode = 2;
/*     */     
/*  47 */     KnockOutContext context = KnockOutContextManager.getInstance().getContext(reqData.game_server_contextid);
/*     */     
/*  49 */     if ((context == null) || (context.fightStage != reqData.fight_stage) || (context.getMatcherServerContextid() != reqData.matcher_server_contextid))
/*     */     {
/*     */ 
/*  52 */       GameServer.logger().error(String.format("[crossserver]DTH_NotifyMatchResult.onDataTransferReq@match data not match|req=%s|req_data=%s|context=%s", new Object[] { req, reqData, context }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*  57 */       GHubHelper.sendDataTransferRsp(rsp);
/*     */       
/*  59 */       return;
/*     */     }
/*     */     
/*  62 */     context.stopTimeoutWatchDog();
/*  63 */     context.setRoamZoneid(reqData.roam_zoneid);
/*  64 */     context.setRoamRoomInstanceid(reqData.roam_room_instanceid);
/*     */     
/*  66 */     KnockOutTeamInfo crossBattleTeamInfo = new KnockOutTeamInfo(reqData.opponent_team_info);
/*     */     
/*  68 */     if ((crossBattleTeamInfo.getCrossBattleRoleInfoList().size() > 0) && (context.setOpponentCrossBattleTeamInfo(crossBattleTeamInfo)))
/*     */     {
/*     */ 
/*  71 */       context.setOpponentLeaderid(((KnockOutRoleInfo)crossBattleTeamInfo.getCrossBattleRoleInfoList().get(0)).getRoleid());
/*     */       
/*  73 */       rsp.retcode = 0;
/*     */     }
/*     */     
/*  76 */     GameServer.logger().info(String.format("[crossserver]DTH_NotifyMatchResult.onDataTransferReq@handle notify match result|req=%s|req_data=%s|rsp=%s|context=%s", new Object[] { req, reqData, rsp, context }));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*  81 */     if ((GHubHelper.sendDataTransferRsp(rsp)) && (rsp.retcode == 0))
/*     */     {
/*  83 */       SelectionOrFinalMatchSucceed event = new SelectionOrFinalMatchSucceed();
/*  84 */       SelectionOrFinalMatchSucceedArg arg = new SelectionOrFinalMatchSucceedArg(context.gameServerContextId, context.leaderRoleId, context.crossBattleTeamInfo, context.getOpponentLeaderid(), context.getOpponentCrossBattleTeamInfo(), context.getRoamZoneid(), context.getRoamRoomInstanceid(), context.getCreateTime(), context.fightStage, context.fightType, context.getSelectionFinalPhaseContext());
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  96 */       TriggerEventsManger.getInstance().triggerEvent(event, arg);
/*     */     }
/*     */     else
/*     */     {
/* 100 */       SelectionOrFinalMatchFailed event = new SelectionOrFinalMatchFailed();
/* 101 */       SelectionOrFinalMatchFailedArg arg = new SelectionOrFinalMatchFailedArg(context.gameServerContextId, context.leaderRoleId, context.crossBattleTeamInfo, context.getCreateTime());
/*     */       
/*     */ 
/*     */ 
/* 105 */       TriggerEventsManger.getInstance().triggerEvent(event, arg);
/*     */     }
/*     */   }
/*     */   
/*     */   public void onDataTransferTimeout(DataTransferReqXidWrapper reqXidWrapper, NotifySelectionOrFinalMatchReq reqData, int code) {}
/*     */   
/*     */   public void onDataTransferRsp(DataTransferReqXidWrapper reqXidWrapper, NotifySelectionOrFinalMatchReq reqData, DataTransferRspXidWrapper rspXidWrapper, NotifySelectionOrFinalMatchRsp rspData) {}
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\main\DTH_NotifyKnockOutMatchResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */