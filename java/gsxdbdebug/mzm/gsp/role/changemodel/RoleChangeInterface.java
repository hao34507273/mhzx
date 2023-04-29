/*    */ package mzm.gsp.role.changemodel;
/*    */ 
/*    */ import mzm.gsp.util.NoneRealTimeTaskManager;
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
/*    */ public class RoleChangeInterface
/*    */ {
/*    */   public static int getRoleNowChangeId(long roleId, boolean remainRoleLock)
/*    */   {
/* 21 */     RoleChangeInfo roleChangeInfo = new RoleChangeInfo(roleId, remainRoleLock);
/* 22 */     return roleChangeInfo.getNeedShowChangeId();
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
/*    */   public static boolean addRoleChangePlan(long roleId, int changeId)
/*    */   {
/* 38 */     return new PAddNewChangePlan(roleId, changeId).call();
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
/*    */   public static void addNewChangePlanNoneRealtime(long roleId, int changeId)
/*    */   {
/* 53 */     NoneRealTimeTaskManager.getInstance().addTask(new PAddNewChangePlan(roleId, changeId));
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
/*    */   public static boolean rmRoleChangePlan(long roleId, int rmChangeId)
/*    */   {
/* 69 */     return new PRmChangePlan(roleId, rmChangeId).call();
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
/*    */   public static void rmRoleChangePlanNoneRealtime(long roleId, int rmChangeId)
/*    */   {
/* 84 */     NoneRealTimeTaskManager.getInstance().addTask(new PRmChangePlan(roleId, rmChangeId));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\changemodel\RoleChangeInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */