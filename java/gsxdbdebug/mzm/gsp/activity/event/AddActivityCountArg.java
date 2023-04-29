/*    */ package mzm.gsp.activity.event;
/*    */ 
/*    */ public class AddActivityCountArg
/*    */ {
/*    */   public final long roleId;
/*    */   public final int activityId;
/*    */   public final int currentActivityCount;
/*    */   public final int addedActivityCount;
/*    */   
/*    */   public AddActivityCountArg(long roleId, int activityId, int currentActivityCount, int addedActivityCount)
/*    */   {
/* 12 */     this.roleId = roleId;
/* 13 */     this.activityId = activityId;
/* 14 */     this.currentActivityCount = currentActivityCount;
/* 15 */     this.addedActivityCount = addedActivityCount;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activity\event\AddActivityCountArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */