/*    */ package mzm.gsp.crossserver.main;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import hub.DataTransferReq;
/*    */ import hub.DataTransferReqXidWrapper;
/*    */ import hub.DataTransferRsp;
/*    */ import hub.DataTransferRspXidWrapper;
/*    */ import hub.GHubHelper;
/*    */ import hub.RoamSelectionOrFinalContextReq;
/*    */ import hub.RoamSelectionOrFinalContextRsp;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class DTH_KnockOutRoamContext
/*    */   extends DataTransferHandler<RoamSelectionOrFinalContextReq, RoamSelectionOrFinalContextRsp>
/*    */ {
/*    */   protected RoamSelectionOrFinalContextReq makeReqDataBean()
/*    */   {
/* 26 */     return new RoamSelectionOrFinalContextReq();
/*    */   }
/*    */   
/*    */ 
/*    */   protected RoamSelectionOrFinalContextRsp makeRspDataBean()
/*    */   {
/* 32 */     return new RoamSelectionOrFinalContextRsp();
/*    */   }
/*    */   
/*    */ 
/*    */   protected void onDataTransferReq(DataTransferReq req, RoamSelectionOrFinalContextReq reqData)
/*    */   {
/* 38 */     DataTransferRsp rsp = new DataTransferRsp();
/* 39 */     rsp.direction = req.direction;
/* 40 */     rsp.xid = req.xid;
/* 41 */     rsp.src_id = req.dst_id;
/* 42 */     rsp.dst_id = req.src_id;
/* 43 */     rsp.data_type = req.data_type;
/*    */     
/* 45 */     long roamedInstanceid = RoamedKnockOutContextManager.getInstance().getRoamedRoomInstanceid();
/*    */     
/* 47 */     RoamSelectionOrFinalContextRsp rspData = new RoamSelectionOrFinalContextRsp();
/* 48 */     rspData.roam_zoneid = GameServerInfoManager.getZoneId();
/* 49 */     rspData.roam_room_instanceid = roamedInstanceid;
/*    */     
/* 51 */     OctetsStream os = new OctetsStream();
/* 52 */     os.marshal(rspData);
/* 53 */     rsp.data = os;
/*    */     
/*    */ 
/*    */ 
/* 57 */     RoamedKnockOutTeamInfo roamedTeamInfo = new RoamedKnockOutTeamInfo(reqData.selection_final_team_info);
/* 58 */     RoamedKnockOutTeamInfo opponentTeamInfo = new RoamedKnockOutTeamInfo(reqData.opponent_cross_battle_team_info);
/*    */     
/*    */ 
/* 61 */     if (new PCollectRoamSelectionFinalRoleContext(roamedInstanceid, roamedTeamInfo, opponentTeamInfo, reqData.fight_type, reqData.fight_stage, reqData.fight_index_id).call())
/*    */     {
/*    */ 
/* 64 */       rsp.retcode = 0;
/*    */     }
/*    */     else
/*    */     {
/* 68 */       rsp.retcode = 2;
/*    */     }
/*    */     
/* 71 */     GameServer.logger().info(String.format("[crossserver]DTH_RoamCrossBattleContext.onDataTransferReq@handle roam cross battle context request|req=%s|req_data=%s|rsp=%s|rsp_data=%s", new Object[] { req, reqData, rsp, rspData }));
/*    */     
/*    */ 
/*    */ 
/*    */ 
/* 76 */     GHubHelper.sendDataTransferRsp(rsp);
/*    */   }
/*    */   
/*    */   protected void onDataTransferTimeout(DataTransferReqXidWrapper reqXidWrapper, RoamSelectionOrFinalContextReq reqData, int code) {}
/*    */   
/*    */   protected void onDataTransferRsp(DataTransferReqXidWrapper reqXidWrapper, RoamSelectionOrFinalContextReq reqData, DataTransferRspXidWrapper rspXidWrapper, RoamSelectionOrFinalContextRsp rspData) {}
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\main\DTH_KnockOutRoamContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */