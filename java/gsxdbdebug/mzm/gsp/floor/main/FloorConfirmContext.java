/*    */ package mzm.gsp.floor.main;
/*    */ 
/*    */ import mzm.gsp.confirm.main.TeamConfirmContext;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class FloorConfirmContext
/*    */   implements TeamConfirmContext
/*    */ {
/*    */   private final long roleId;
/*    */   private final int activityId;
/*    */   private final int floor;
/*    */   
/*    */   public FloorConfirmContext(long roleId, int activityId, int floor)
/*    */   {
/* 19 */     this.roleId = roleId;
/* 20 */     this.activityId = activityId;
/* 21 */     this.floor = floor;
/*    */   }
/*    */   
/*    */   public long getRoleId()
/*    */   {
/* 26 */     return this.roleId;
/*    */   }
/*    */   
/*    */   public int getActivityId()
/*    */   {
/* 31 */     return this.activityId;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getFloor()
/*    */   {
/* 41 */     return this.floor;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\floor\main\FloorConfirmContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */