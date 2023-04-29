/*    */ package mzm.gsp.crossserver.main;
/*    */ 
/*    */ import hub.DataBroadcast;
/*    */ import hub.NotifyFightRecordRoundInfo;
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.fight.main.FightInterface;
/*    */ 
/*    */ public class DBH_NotifyFightRecordRoundInfo extends DataBroadcastHandler<NotifyFightRecordRoundInfo>
/*    */ {
/*    */   protected NotifyFightRecordRoundInfo makeDataBean()
/*    */   {
/* 12 */     return new NotifyFightRecordRoundInfo();
/*    */   }
/*    */   
/*    */ 
/*    */   protected void onDataBroadcast(DataBroadcast broadcast, NotifyFightRecordRoundInfo data)
/*    */   {
/* 18 */     if (GameServerInfoManager.isRoamServer())
/*    */     {
/* 20 */       return;
/*    */     }
/* 22 */     FightInterface.onRoamFightRecordRound(data.recordid, data.round, data.round_content);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\main\DBH_NotifyFightRecordRoundInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */