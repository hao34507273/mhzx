/*    */ package mzm.gsp.gratefuldelivery.main;
/*    */ 
/*    */ import mzm.gsp.gratefuldelivery.event.ArgForAutoDeliverySession;
/*    */ import mzm.gsp.gratefuldelivery.event.StartAutoDeliverySessionEventRunnable;
/*    */ 
/*    */ public class ROnStartAutoDeliverySessionEvent extends StartAutoDeliverySessionEventRunnable
/*    */ {
/*    */   public void process() throws Exception
/*    */   {
/* 10 */     int now = (int)(mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis() / 1000L);
/* 11 */     new AutoDeliverySession(((ArgForAutoDeliverySession)this.arg).autoRedeliveryTime - now, ((ArgForAutoDeliverySession)this.arg).activityId, ((ArgForAutoDeliverySession)this.arg).roleId);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gratefuldelivery\main\ROnStartAutoDeliverySessionEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */