/*    */ package mzm.gsp.crossserver.main;
/*    */ 
/*    */ import hub.DataBroadcast;
/*    */ import hub.NotifyFightRecordStartInfo;
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.fight.main.FightInterface;
/*    */ 
/*    */ public class DBH_NotifyFightRecordStartInfo extends DataBroadcastHandler<NotifyFightRecordStartInfo>
/*    */ {
/*    */   protected NotifyFightRecordStartInfo makeDataBean()
/*    */   {
/* 12 */     return new NotifyFightRecordStartInfo();
/*    */   }
/*    */   
/*    */ 
/*    */   protected void onDataBroadcast(DataBroadcast broadcast, NotifyFightRecordStartInfo data)
/*    */   {
/* 18 */     if (GameServerInfoManager.isRoamServer())
/*    */     {
/* 20 */       return;
/*    */     }
/*    */     
/* 23 */     FightInterface.onRoamFightRecordStart(data.recordid, data.start_content);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\main\DBH_NotifyFightRecordStartInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */