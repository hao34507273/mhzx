/*    */ package mzm.gsp.crossserver.main;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import com.goldhuman.Common.Octets;
/*    */ import hub.DataTransferReq;
/*    */ import hub.DataTransferReqXidWrapper;
/*    */ import hub.DataTransferRsp;
/*    */ import hub.DataTransferRspXidWrapper;
/*    */ import hub.GHubHelper;
/*    */ import hub.SingleCrossFieldRoamMatchContextReq;
/*    */ import hub.SingleCrossFieldRoamMatchContextRsp;
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
/*    */ public class DTH_SingleCrossFieldRoamMatchContext
/*    */   extends DataTransferHandler<SingleCrossFieldRoamMatchContextReq, SingleCrossFieldRoamMatchContextRsp>
/*    */ {
/*    */   protected SingleCrossFieldRoamMatchContextReq makeReqDataBean()
/*    */   {
/* 27 */     return new SingleCrossFieldRoamMatchContextReq();
/*    */   }
/*    */   
/*    */ 
/*    */   protected SingleCrossFieldRoamMatchContextRsp makeRspDataBean()
/*    */   {
/* 33 */     return new SingleCrossFieldRoamMatchContextRsp();
/*    */   }
/*    */   
/*    */ 
/*    */   protected void onDataTransferReq(DataTransferReq req, SingleCrossFieldRoamMatchContextReq reqData)
/*    */   {
/* 39 */     DataTransferRsp rsp = new DataTransferRsp();
/* 40 */     rsp.direction = req.direction;
/* 41 */     rsp.xid = req.xid;
/* 42 */     rsp.src_id = req.dst_id;
/* 43 */     rsp.dst_id = req.src_id;
/* 44 */     rsp.data_type = req.data_type;
/*    */     
/* 46 */     long roamedRoomInstanceid = SingleCrossFieldRoamedContextManager.getInstance().getRoamedRoomInstanceid();
/* 47 */     if (new PCreateSingleCrossFieldRoamedContext(roamedRoomInstanceid, reqData.activity_cfg_id, reqData.field_role_infos).call())
/*    */     {
/* 49 */       SingleCrossFieldRoamedContext context = SingleCrossFieldRoamedContextManager.getInstance().getContext(roamedRoomInstanceid);
/*    */       
/* 51 */       if (!context.startSingleBattle())
/*    */       {
/* 53 */         new PRemoveSingleCrossFieldRoamedContext(roamedRoomInstanceid, reqData.field_role_infos).call();
/* 54 */         rsp.retcode = 2;
/*    */       }
/*    */       else
/*    */       {
/* 58 */         rsp.retcode = 0;
/*    */       }
/*    */     }
/*    */     else
/*    */     {
/* 63 */       rsp.retcode = 2;
/*    */     }
/* 65 */     SingleCrossFieldRoamMatchContextRsp rspData = new SingleCrossFieldRoamMatchContextRsp();
/* 66 */     rspData.roam_zoneid = GameServerInfoManager.getZoneId();
/* 67 */     rspData.roam_room_instanceid = roamedRoomInstanceid;
/* 68 */     OctetsStream os = new OctetsStream();
/* 69 */     os.marshal(rspData);
/* 70 */     rsp.data.replace(os);
/*    */     
/* 72 */     GameServer.logger().info(String.format("[crossserver]DTH_SingleCrossFieldRoamMatchContext.onDataTransferReq@handle single cross field roam match context req|req=%s|req_data=%s|rsp=%s|rsp_data=%s", new Object[] { req, reqData, rsp, rspData }));
/*    */     
/*    */ 
/*    */ 
/* 76 */     GHubHelper.sendDataTransferRsp(rsp);
/*    */   }
/*    */   
/*    */   protected void onDataTransferRsp(DataTransferReqXidWrapper reqXidWrapper, SingleCrossFieldRoamMatchContextReq reqData, DataTransferRspXidWrapper rspXidWrapper, SingleCrossFieldRoamMatchContextRsp rspData) {}
/*    */   
/*    */   protected void onDataTransferTimeout(DataTransferReqXidWrapper reqXidWrapper, SingleCrossFieldRoamMatchContextReq reqData, int code) {}
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\main\DTH_SingleCrossFieldRoamMatchContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */