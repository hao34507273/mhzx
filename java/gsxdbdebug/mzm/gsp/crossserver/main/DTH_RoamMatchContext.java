/*    */ package mzm.gsp.crossserver.main;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import hub.DataTransferReq;
/*    */ import hub.DataTransferReqXidWrapper;
/*    */ import hub.DataTransferRsp;
/*    */ import hub.DataTransferRspXidWrapper;
/*    */ import hub.GHubHelper;
/*    */ import hub.RoamMatchContextReq;
/*    */ import hub.RoamMatchContextRsp;
/*    */ import hub.RoleMatchMarkingInfo;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class DTH_RoamMatchContext
/*    */   extends DataTransferHandler<RoamMatchContextReq, RoamMatchContextRsp>
/*    */ {
/*    */   protected RoamMatchContextReq makeReqDataBean()
/*    */   {
/* 25 */     return new RoamMatchContextReq();
/*    */   }
/*    */   
/*    */ 
/*    */   protected RoamMatchContextRsp makeRspDataBean()
/*    */   {
/* 31 */     return new RoamMatchContextRsp();
/*    */   }
/*    */   
/*    */ 
/*    */   protected void onDataTransferReq(DataTransferReq req, RoamMatchContextReq reqData)
/*    */   {
/* 37 */     DataTransferRsp rsp = new DataTransferRsp();
/* 38 */     rsp.direction = req.direction;
/* 39 */     rsp.xid = req.xid;
/* 40 */     rsp.src_id = req.dst_id;
/* 41 */     rsp.dst_id = req.src_id;
/* 42 */     rsp.data_type = req.data_type;
/*    */     
/* 44 */     long roamedInstanceid = RoamedMatchContextManager.getInstance().getRoamedRoomInstanceid();
/*    */     
/* 46 */     RoamMatchContextRsp rspData = new RoamMatchContextRsp();
/* 47 */     rspData.roam_zoneid = GameServerInfoManager.getZoneId();
/* 48 */     rspData.roam_room_instanceid = roamedInstanceid;
/*    */     
/* 50 */     OctetsStream os = new OctetsStream();
/* 51 */     os.marshal(rspData);
/* 52 */     rsp.data = os;
/*    */     
/*    */ 
/* 55 */     int activityContextTypeid = reqData.activity_context_typeid;
/* 56 */     List<RoamedRoleMatchMarkingInfo> roleMatchMarkingInfos = new ArrayList();
/* 57 */     for (RoleMatchMarkingInfo roleMatchMarkingInfo : reqData.role_infos)
/*    */     {
/* 59 */       RoamedRoleMatchMarkingInfo roamedRoleMatchMarkingInfo = new RoamedRoleMatchMarkingInfo(roleMatchMarkingInfo);
/* 60 */       roleMatchMarkingInfos.add(roamedRoleMatchMarkingInfo);
/*    */     }
/* 62 */     List<RoamedRoleMatchMarkingInfo> opponentRoleMatchMarkingInfos = new ArrayList();
/* 63 */     for (RoleMatchMarkingInfo roleMatchMarkingInfo : reqData.opponent_role_infos)
/*    */     {
/* 65 */       RoamedRoleMatchMarkingInfo roamedRoleMatchMarkingInfo = new RoamedRoleMatchMarkingInfo(roleMatchMarkingInfo);
/* 66 */       opponentRoleMatchMarkingInfos.add(roamedRoleMatchMarkingInfo);
/*    */     }
/* 68 */     if (new PCollectRoamRoleContext(roamedInstanceid, activityContextTypeid, roleMatchMarkingInfos, opponentRoleMatchMarkingInfos).call())
/*    */     {
/*    */ 
/* 71 */       rsp.retcode = 0;
/*    */     }
/*    */     else
/*    */     {
/* 75 */       rsp.retcode = 2;
/*    */     }
/*    */     
/* 78 */     GameServer.logger().info(String.format("[crossserver]DTH_RoamMatchContext.onDataTransferReq@handle roam match context request|req=%s|req_data=%s|rsp=%s|rsp_data=%s", new Object[] { req, reqData, rsp, rspData }));
/*    */     
/*    */ 
/*    */ 
/*    */ 
/* 83 */     GHubHelper.sendDataTransferRsp(rsp);
/*    */   }
/*    */   
/*    */   protected void onDataTransferTimeout(DataTransferReqXidWrapper reqXidWrapper, RoamMatchContextReq reqData, int code) {}
/*    */   
/*    */   protected void onDataTransferRsp(DataTransferReqXidWrapper reqXidWrapper, RoamMatchContextReq reqData, DataTransferRspXidWrapper rspXidWrapper, RoamMatchContextRsp rspData) {}
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\main\DTH_RoamMatchContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */