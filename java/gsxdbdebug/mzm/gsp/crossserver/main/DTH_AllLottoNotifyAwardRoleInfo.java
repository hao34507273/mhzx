/*    */ package mzm.gsp.crossserver.main;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import com.goldhuman.Common.Octets;
/*    */ import hub.AllLottoNotifyAwardRoleInfoReq;
/*    */ import hub.AllLottoNotifyAwardRoleInfoRsp;
/*    */ import hub.DataTransferReq;
/*    */ import hub.DataTransferReqXidWrapper;
/*    */ import hub.DataTransferRsp;
/*    */ import hub.DataTransferRspXidWrapper;
/*    */ import hub.GHubHelper;
/*    */ import mzm.event.TriggerEventsManger;
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.alllotto.main.AllLottoOneByOneManager;
/*    */ import mzm.gsp.crossserver.event.ReceiveAllLottoAwardRoleInfo;
/*    */ import mzm.gsp.crossserver.event.ReceiveAllLottoAwardRoleInfoArg;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class DTH_AllLottoNotifyAwardRoleInfo
/*    */   extends DataTransferHandler<AllLottoNotifyAwardRoleInfoReq, AllLottoNotifyAwardRoleInfoRsp>
/*    */ {
/*    */   protected AllLottoNotifyAwardRoleInfoReq makeReqDataBean()
/*    */   {
/* 30 */     return new AllLottoNotifyAwardRoleInfoReq();
/*    */   }
/*    */   
/*    */ 
/*    */   protected AllLottoNotifyAwardRoleInfoRsp makeRspDataBean()
/*    */   {
/* 36 */     return new AllLottoNotifyAwardRoleInfoRsp();
/*    */   }
/*    */   
/*    */ 
/*    */   protected void onDataTransferReq(DataTransferReq req, AllLottoNotifyAwardRoleInfoReq reqData)
/*    */   {
/* 42 */     DataTransferRsp rsp = new DataTransferRsp();
/* 43 */     rsp.direction = req.direction;
/* 44 */     rsp.xid = req.xid;
/* 45 */     rsp.src_id = req.dst_id;
/* 46 */     rsp.dst_id = req.src_id;
/* 47 */     rsp.data_type = req.data_type;
/*    */     
/* 49 */     AllLottoNotifyAwardRoleInfoRsp rspData = new AllLottoNotifyAwardRoleInfoRsp();
/* 50 */     OctetsStream os = new OctetsStream();
/* 51 */     os.marshal(rspData);
/* 52 */     rsp.data.replace(os);
/* 53 */     rsp.retcode = 0;
/* 54 */     GHubHelper.sendDataTransferRsp(rsp);
/*    */     
/* 56 */     if (GameServerInfoManager.isRoamServer())
/*    */     {
/* 58 */       return;
/*    */     }
/* 60 */     TriggerEventsManger.getInstance().triggerEvent(new ReceiveAllLottoAwardRoleInfo(), new ReceiveAllLottoAwardRoleInfoArg(reqData.activity_cfg_id, reqData.turn, reqData.award_role_infos), AllLottoOneByOneManager.getInstance().getTaskOneByOne(Integer.valueOf(reqData.activity_cfg_id)));
/*    */   }
/*    */   
/*    */   protected void onDataTransferRsp(DataTransferReqXidWrapper reqXidWrapper, AllLottoNotifyAwardRoleInfoReq reqData, DataTransferRspXidWrapper rspXidWrapper, AllLottoNotifyAwardRoleInfoRsp rspData) {}
/*    */   
/*    */   protected void onDataTransferTimeout(DataTransferReqXidWrapper reqXidWrapper, AllLottoNotifyAwardRoleInfoReq reqData, int code) {}
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\main\DTH_AllLottoNotifyAwardRoleInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */