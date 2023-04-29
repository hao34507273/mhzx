/*    */ package mzm.gsp.crossserver.main;
/*    */ 
/*    */ import hub.DataBroadcast;
/*    */ import hub.NotifyIndianaAwardRoleInfo;
/*    */ import mzm.event.TriggerEventsManger;
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.crossserver.event.ReceiveIndianaAwardRoleInfo;
/*    */ import mzm.gsp.crossserver.event.ReceiveIndianaAwardRoleInfoArg;
/*    */ import mzm.gsp.indiana.main.IndianaOneByOneManager;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class DBH_NotifyIndianaAwardRoleInfo
/*    */   extends DataBroadcastHandler<NotifyIndianaAwardRoleInfo>
/*    */ {
/*    */   protected NotifyIndianaAwardRoleInfo makeDataBean()
/*    */   {
/* 19 */     return new NotifyIndianaAwardRoleInfo();
/*    */   }
/*    */   
/*    */ 
/*    */   protected void onDataBroadcast(DataBroadcast broadcast, NotifyIndianaAwardRoleInfo data)
/*    */   {
/* 25 */     if (GameServerInfoManager.isRoamServer())
/*    */     {
/* 27 */       return;
/*    */     }
/* 29 */     TriggerEventsManger.getInstance().triggerEvent(new ReceiveIndianaAwardRoleInfo(), new ReceiveIndianaAwardRoleInfoArg(broadcast.src_id, data.activity_cfg_id, data.turn, data.sortid, data.award_role_infos), IndianaOneByOneManager.getInstance().getTaskOneByOne(Integer.valueOf(data.activity_cfg_id)));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\main\DBH_NotifyIndianaAwardRoleInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */