/*    */ package mzm.gsp.crossserver.main;
/*    */ 
/*    */ import hub.DataBroadcast;
/*    */ import hub.NotifyModifyServerDate;
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ 
/*    */ public class DBH_NotifyModifyServerDate extends DataBroadcastHandler<NotifyModifyServerDate>
/*    */ {
/*    */   protected NotifyModifyServerDate makeDataBean()
/*    */   {
/* 11 */     return new NotifyModifyServerDate();
/*    */   }
/*    */   
/*    */ 
/*    */   protected void onDataBroadcast(DataBroadcast broadcast, NotifyModifyServerDate data)
/*    */   {
/* 17 */     String dateValue = data.date_args.getString("UTF-8");
/* 18 */     GameServerInfoManager.setDateForGM(dateValue, 0L);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\main\DBH_NotifyModifyServerDate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */