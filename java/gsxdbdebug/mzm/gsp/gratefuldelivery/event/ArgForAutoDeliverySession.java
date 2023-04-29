/*    */ package mzm.gsp.gratefuldelivery.event;
/*    */ 
/*    */ public class ArgForAutoDeliverySession
/*    */ {
/*    */   public final int activityId;
/*    */   public final long roleId;
/*    */   public final int autoRedeliveryTime;
/*    */   
/*    */   public ArgForAutoDeliverySession(int activityId, long roleId, int autoRedeliveryTime)
/*    */   {
/* 11 */     this.activityId = activityId;
/* 12 */     this.roleId = roleId;
/* 13 */     this.autoRedeliveryTime = autoRedeliveryTime;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gratefuldelivery\event\ArgForAutoDeliverySession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */