/*    */ package mzm.gsp.online.main;
/*    */ 
/*    */ public class OnlineInfo {
/*    */   private int onlineStatus;
/*  5 */   private long offlineProtectSessionid = -1L;
/*  6 */   private boolean useOfflineItem = false;
/*    */   private long time;
/*    */   
/*    */   public boolean isUseOfflineItem() {
/* 10 */     return this.useOfflineItem;
/*    */   }
/*    */   
/*    */   public void setUseOfflineItem(boolean useOfflineItem) {
/* 14 */     this.useOfflineItem = useOfflineItem;
/*    */   }
/*    */   
/*    */   public void setTime(long time) {
/* 18 */     this.time = time;
/*    */   }
/*    */   
/*    */   public long getTime() {
/* 22 */     return this.time;
/*    */   }
/*    */   
/*    */   public OnlineInfo(int onlineStatus) {
/* 26 */     this.onlineStatus = onlineStatus;
/* 27 */     this.useOfflineItem = false;
/*    */   }
/*    */   
/*    */   public int getOnlineStatus() {
/* 31 */     return this.onlineStatus;
/*    */   }
/*    */   
/*    */   public void setOnlineStatus(int onlineStatus) {
/* 35 */     this.onlineStatus = onlineStatus;
/*    */   }
/*    */   
/*    */   public long getOfflineProtectSessionid() {
/* 39 */     return this.offlineProtectSessionid;
/*    */   }
/*    */   
/*    */   public void setOfflineProtectSessionid(long offlineProtectSessionid) {
/* 43 */     this.offlineProtectSessionid = offlineProtectSessionid;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\online\main\OnlineInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */