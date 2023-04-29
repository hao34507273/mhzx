/*    */ package mzm.gsp.corps.event;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class LeaveCorpsEventArg
/*    */ {
/*    */   private final long roleId;
/*    */   
/*    */ 
/*    */   private final long corpsId;
/*    */   
/*    */   private final LeaveCorpsReason reason;
/*    */   
/*    */ 
/*    */   public LeaveCorpsEventArg(long roleId, long corpsId, LeaveCorpsReason reason)
/*    */   {
/* 17 */     this.roleId = roleId;
/* 18 */     this.corpsId = corpsId;
/* 19 */     this.reason = reason;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public long getRoleId()
/*    */   {
/* 29 */     return this.roleId;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public long getCorpsId()
/*    */   {
/* 39 */     return this.corpsId;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public LeaveCorpsReason getReason()
/*    */   {
/* 49 */     return this.reason;
/*    */   }
/*    */   
/*    */   public static enum LeaveCorpsReason
/*    */   {
/* 54 */     ACTIVE_LEAVE, 
/* 55 */     FIRED;
/*    */     
/*    */     private LeaveCorpsReason() {}
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\corps\event\LeaveCorpsEventArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */