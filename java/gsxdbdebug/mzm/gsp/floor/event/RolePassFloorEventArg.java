/*    */ package mzm.gsp.floor.event;
/*    */ 
/*    */ import java.util.HashSet;
/*    */ import java.util.Set;
/*    */ 
/*    */ public class RolePassFloorEventArg
/*    */ {
/*    */   private final Set<Long> roleIds;
/*    */   private final int activityId;
/*    */   private final int floor;
/*    */   private final Set<Long> helpRoleIds;
/*    */   
/*    */   public RolePassFloorEventArg(Set<Long> roleIds, int activityId, int floor, Set<Long> helpRoleIds)
/*    */   {
/* 15 */     this.roleIds = roleIds;
/* 16 */     this.activityId = activityId;
/* 17 */     this.floor = floor;
/* 18 */     this.helpRoleIds = helpRoleIds;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public Set<Long> getRoleIds()
/*    */   {
/* 28 */     return new HashSet(this.roleIds);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public Set<Long> getHelpRoleIds()
/*    */   {
/* 38 */     return new HashSet(this.helpRoleIds);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public Set<Long> getFristPassRoleIds()
/*    */   {
/* 48 */     Set<Long> allRoleIds = getRoleIds();
/* 49 */     allRoleIds.removeAll(getHelpRoleIds());
/* 50 */     return allRoleIds;
/*    */   }
/*    */   
/*    */   public int getActivityId()
/*    */   {
/* 55 */     return this.activityId;
/*    */   }
/*    */   
/*    */   public int getFloor()
/*    */   {
/* 60 */     return this.floor;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\floor\event\RolePassFloorEventArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */