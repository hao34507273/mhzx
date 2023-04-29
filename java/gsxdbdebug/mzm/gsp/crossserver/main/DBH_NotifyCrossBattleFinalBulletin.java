/*    */ package mzm.gsp.crossserver.main;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import hub.DataBroadcast;
/*    */ import hub.NotifyCrossBattleFinalBulletion;
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.bulletin.SBulletinInfo;
/*    */ import mzm.gsp.crossbattle.knockout.CrossBattleKnockoutInterface;
/*    */ 
/*    */ public class DBH_NotifyCrossBattleFinalBulletin
/*    */   extends DataBroadcastHandler<NotifyCrossBattleFinalBulletion>
/*    */ {
/*    */   protected NotifyCrossBattleFinalBulletion makeDataBean()
/*    */   {
/* 16 */     return new NotifyCrossBattleFinalBulletion();
/*    */   }
/*    */   
/*    */ 
/*    */   protected void onDataBroadcast(DataBroadcast broadcast, NotifyCrossBattleFinalBulletion data)
/*    */   {
/* 22 */     if (GameServerInfoManager.isRoamServer())
/*    */     {
/* 24 */       return;
/*    */     }
/*    */     
/* 27 */     SBulletinInfo sBulletinInfo = new SBulletinInfo();
/*    */     try
/*    */     {
/* 30 */       sBulletinInfo.unmarshal(new OctetsStream(data.bulletin_content));
/*    */     }
/*    */     catch (MarshalException e)
/*    */     {
/* 34 */       e.printStackTrace();
/*    */     }
/*    */     
/* 37 */     CrossBattleKnockoutInterface.onNotifyCrossBattleFinalBulletin(data.zone_id, sBulletinInfo);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\main\DBH_NotifyCrossBattleFinalBulletin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */