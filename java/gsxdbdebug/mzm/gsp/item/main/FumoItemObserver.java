/*    */ package mzm.gsp.item.main;
/*    */ 
/*    */ import mzm.gsp.timer.main.Session;
/*    */ 
/*    */ public class FumoItemObserver extends Session
/*    */ {
/*    */   private long uuid;
/*    */   private long roleId;
/*    */   private int propertyType;
/*    */   
/*    */   FumoItemObserver(long intervalSeconds, long roleId, long uuid, int propertyType) {
/* 12 */     super(intervalSeconds, roleId);
/* 13 */     this.roleId = roleId;
/* 14 */     this.uuid = uuid;
/* 15 */     this.propertyType = propertyType;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   protected void onTimeOut()
/*    */   {
/* 33 */     long currentTime = mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis() / 1000L;
/* 34 */     if (mzm.gsp.online.main.OnlineManager.getInstance().isOnline(this.roleId)) {
/* 35 */       new PClearFumoEffect(this.roleId, this.uuid, this.propertyType, currentTime).execute();
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\main\FumoItemObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */