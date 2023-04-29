/*    */ package mzm.gsp.floor.main;
/*    */ 
/*    */ import java.util.Collections;
/*    */ import java.util.Map;
/*    */ import java.util.Set;
/*    */ import xbean.RoleFloorActivityInfo;
/*    */ import xbean.RoleFloorInfo;
/*    */ import xtable.Role2flooractivity;
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
/*    */ public class FloorInterface
/*    */ {
/*    */   public static Set<Integer> getRolePassFloors(long roleId, int activityId, boolean remainRoleLock)
/*    */   {
/* 23 */     RoleFloorActivityInfo xRoleActivityInfo = null;
/* 24 */     if (remainRoleLock)
/*    */     {
/* 26 */       xRoleActivityInfo = Role2flooractivity.get(Long.valueOf(roleId));
/*    */     }
/*    */     else
/*    */     {
/* 30 */       xRoleActivityInfo = Role2flooractivity.select(Long.valueOf(roleId));
/*    */     }
/* 32 */     if (xRoleActivityInfo == null)
/*    */     {
/* 34 */       return Collections.emptySet();
/*    */     }
/* 36 */     RoleFloorInfo xRoleFloorInfo = (RoleFloorInfo)xRoleActivityInfo.getActivityinfo().get(Integer.valueOf(activityId));
/* 37 */     if (xRoleFloorInfo == null)
/*    */     {
/* 39 */       return Collections.emptySet();
/*    */     }
/* 41 */     return xRoleFloorInfo.getFloor2info().keySet();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\floor\main\FloorInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */