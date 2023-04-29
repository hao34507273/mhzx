/*    */ package mzm.gsp.crossserver.main;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import com.goldhuman.Common.Octets;
/*    */ import hub.DataTransferReq;
/*    */ import hub.DataTransferReqXidWrapper;
/*    */ import hub.DataTransferRsp;
/*    */ import hub.DataTransferRspXidWrapper;
/*    */ import hub.GHubHelper;
/*    */ import hub.SingleCrossFieldNotifyMatchResultReq;
/*    */ import hub.SingleCrossFieldNotifyMatchResultRsp;
/*    */ import mzm.event.TriggerEventsManger;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.crossserver.event.SingleCrossFieldMatchFail;
/*    */ import mzm.gsp.crossserver.event.SingleCrossFieldMatchFailArg;
/*    */ import mzm.gsp.crossserver.event.SingleCrossFieldMatchSuccess;
/*    */ import mzm.gsp.crossserver.event.SingleCrossFieldMatchSuccessArg;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class DTH_SingleCrossFieldNotifyMatchResult
/*    */   extends DataTransferHandler<SingleCrossFieldNotifyMatchResultReq, SingleCrossFieldNotifyMatchResultRsp>
/*    */ {
/*    */   protected SingleCrossFieldNotifyMatchResultReq makeReqDataBean()
/*    */   {
/* 31 */     return new SingleCrossFieldNotifyMatchResultReq();
/*    */   }
/*    */   
/*    */ 
/*    */   protected SingleCrossFieldNotifyMatchResultRsp makeRspDataBean()
/*    */   {
/* 37 */     return new SingleCrossFieldNotifyMatchResultRsp();
/*    */   }
/*    */   
/*    */ 
/*    */   protected void onDataTransferReq(DataTransferReq req, SingleCrossFieldNotifyMatchResultReq reqData)
/*    */   {
/* 43 */     DataTransferRsp rsp = new DataTransferRsp();
/* 44 */     rsp.direction = req.direction;
/* 45 */     rsp.xid = req.xid;
/* 46 */     rsp.src_id = req.dst_id;
/* 47 */     rsp.dst_id = req.src_id;
/* 48 */     rsp.data_type = req.data_type;
/*    */     
/* 50 */     SingleCrossFieldNotifyMatchResultRsp rspData = new SingleCrossFieldNotifyMatchResultRsp();
/* 51 */     OctetsStream os = new OctetsStream();
/* 52 */     os.marshal(rspData);
/* 53 */     rsp.data.replace(os);
/*    */     
/* 55 */     SingleCrossFieldContext context = SingleCrossFieldContextManager.getInstance().getContext(reqData.game_server_contextid);
/*    */     
/* 57 */     if ((context == null) || (context.getMatcherServerContextid() != reqData.matcher_server_contextid))
/*    */     {
/* 59 */       rsp.retcode = 2;
/* 60 */       GameServer.logger().error(String.format("[crossserver]DTH_SingleCrossFieldNotifyMatchResult.onDataTransferReq@context do not match|req=%s|req_data=%s|context=%s", new Object[] { req, reqData, context }));
/*    */ 
/*    */ 
/*    */     }
/*    */     else
/*    */     {
/*    */ 
/* 67 */       context.stopWatchDog();
/* 68 */       if (reqData.result == 1)
/*    */       {
/* 70 */         TriggerEventsManger.getInstance().triggerEvent(new SingleCrossFieldMatchFail(), new SingleCrossFieldMatchFailArg(context));
/*    */ 
/*    */       }
/*    */       else
/*    */       {
/* 75 */         context.setRoamZoneid(reqData.roam_zoneid);
/* 76 */         context.setRoamRoomInstanceid(reqData.roam_room_instanceid);
/* 77 */         TriggerEventsManger.getInstance().triggerEvent(new SingleCrossFieldMatchSuccess(), new SingleCrossFieldMatchSuccessArg(context));
/*    */       }
/*    */       
/* 80 */       GameServer.logger().info(String.format("[crossserver]DTH_SingleCrossFieldNotifyMatchResult.onDataTransferReq@handle single cross field notify match result req|req=%s|req_data=%s|rsp=%s|context=%s", new Object[] { req, reqData, rsp, context }));
/*    */     }
/*    */     
/*    */ 
/*    */ 
/* 85 */     GHubHelper.sendDataTransferRsp(rsp);
/*    */   }
/*    */   
/*    */   protected void onDataTransferRsp(DataTransferReqXidWrapper reqXidWrapper, SingleCrossFieldNotifyMatchResultReq reqData, DataTransferRspXidWrapper rspXidWrapper, SingleCrossFieldNotifyMatchResultRsp rspData) {}
/*    */   
/*    */   protected void onDataTransferTimeout(DataTransferReqXidWrapper reqXidWrapper, SingleCrossFieldNotifyMatchResultReq reqData, int code) {}
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\main\DTH_SingleCrossFieldNotifyMatchResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */