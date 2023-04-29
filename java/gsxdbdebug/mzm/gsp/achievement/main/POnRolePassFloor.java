/*    */ package mzm.gsp.achievement.main;
/*    */ 
/*    */ import java.util.Collection;
/*    */ import java.util.Iterator;
/*    */ import mzm.gsp.achievement.main.goaltype.FloorPass.Context;
/*    */ import mzm.gsp.floor.event.PassFloorEventProcedure;
/*    */ import mzm.gsp.floor.event.RolePassFloorEventArg;
/*    */ 
/*    */ public class POnRolePassFloor extends PassFloorEventProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 13 */     Collection<Long> roleIds = ((RolePassFloorEventArg)this.arg).getRoleIds();
/*    */     
/*    */ 
/* 16 */     AchievementManager.collectLocks(roleIds);
/*    */     
/*    */ 
/* 19 */     FloorPass.Context context = new FloorPass.Context(((RolePassFloorEventArg)this.arg).getActivityId(), ((RolePassFloorEventArg)this.arg).getFloor());
/* 20 */     for (Iterator i$ = roleIds.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*    */       
/* 22 */       AchievementManager.updateGoalTypeState(roleId, 5109, context, "POnRolePassFloor.processImp@handle FLOOR_PASS success");
/*    */     }
/*    */     
/*    */ 
/* 26 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\POnRolePassFloor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */