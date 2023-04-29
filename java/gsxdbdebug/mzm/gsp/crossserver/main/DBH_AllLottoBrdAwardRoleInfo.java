/*    */ package mzm.gsp.crossserver.main;
/*    */ 
/*    */ import hub.AllLottoBrdAwardRoleInfo;
/*    */ import hub.DataBroadcast;
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
/*    */ public class DBH_AllLottoBrdAwardRoleInfo
/*    */   extends DataBroadcastHandler<AllLottoBrdAwardRoleInfo>
/*    */ {
/*    */   protected AllLottoBrdAwardRoleInfo makeDataBean()
/*    */   {
/* 21 */     return new AllLottoBrdAwardRoleInfo();
/*    */   }
/*    */   
/*    */ 
/*    */   protected void onDataBroadcast(DataBroadcast broadcast, AllLottoBrdAwardRoleInfo data)
/*    */   {
/* 27 */     if (GameServerInfoManager.isRoamServer())
/*    */     {
/* 29 */       return;
/*    */     }
/* 31 */     if (broadcast.src_id != CrossServerManager.allLottoMatcherid)
/*    */     {
/* 33 */       return;
/*    */     }
/* 35 */     TriggerEventsManger.getInstance().triggerEvent(new ReceiveAllLottoAwardRoleInfo(), new ReceiveAllLottoAwardRoleInfoArg(data.activity_cfg_id, data.turn, data.award_role_infos), AllLottoOneByOneManager.getInstance().getTaskOneByOne(Integer.valueOf(data.activity_cfg_id)));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\main\DBH_AllLottoBrdAwardRoleInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */