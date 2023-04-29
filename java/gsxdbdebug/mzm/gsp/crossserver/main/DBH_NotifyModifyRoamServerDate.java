/*    */ package mzm.gsp.crossserver.main;
/*    */ 
/*    */ import hub.DataBroadcast;
/*    */ import hub.NotifyModifyRoamServerDate;
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ 
/*    */ public class DBH_NotifyModifyRoamServerDate extends DataBroadcastHandler<NotifyModifyRoamServerDate>
/*    */ {
/*    */   protected NotifyModifyRoamServerDate makeDataBean()
/*    */   {
/* 11 */     return new NotifyModifyRoamServerDate();
/*    */   }
/*    */   
/*    */ 
/*    */   protected void onDataBroadcast(DataBroadcast broadcast, NotifyModifyRoamServerDate data)
/*    */   {
/* 17 */     if (!GameServerInfoManager.isRoamServer())
/*    */     {
/* 19 */       return;
/*    */     }
/*    */     
/* 22 */     String dateValue = data.date_args.getString("UTF-8");
/* 23 */     GameServerInfoManager.setDateForGM(dateValue, 0L);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\main\DBH_NotifyModifyRoamServerDate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */