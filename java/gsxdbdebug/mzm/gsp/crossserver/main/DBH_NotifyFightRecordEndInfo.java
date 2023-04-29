/*    */ package mzm.gsp.crossserver.main;
/*    */ 
/*    */ import hub.DataBroadcast;
/*    */ import hub.NotifyFightRecordEndInfo;
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.fight.main.FightInterface;
/*    */ 
/*    */ public class DBH_NotifyFightRecordEndInfo extends DataBroadcastHandler<NotifyFightRecordEndInfo>
/*    */ {
/*    */   protected NotifyFightRecordEndInfo makeDataBean()
/*    */   {
/* 12 */     return new NotifyFightRecordEndInfo();
/*    */   }
/*    */   
/*    */ 
/*    */   protected void onDataBroadcast(DataBroadcast broadcast, NotifyFightRecordEndInfo data)
/*    */   {
/* 18 */     if (GameServerInfoManager.isRoamServer())
/*    */     {
/* 20 */       return;
/*    */     }
/* 22 */     FightInterface.onRoamFightRecordEnd(data.recordid, data.max_round, data.end_content);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\main\DBH_NotifyFightRecordEndInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */