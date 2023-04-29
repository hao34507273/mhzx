/*    */ package mzm.gsp.achievement.main;
/*    */ 
/*    */ import mzm.gsp.role.event.RoleRenameProcedure;
/*    */ 
/*    */ 
/*    */ public class POnRoleRename
/*    */   extends RoleRenameProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */   {
/* 11 */     AchievementManager.updateGoalTypeState(((Long)this.arg).longValue(), 3301, Integer.valueOf(1), "POnRoleRename.processImp@handle ROLE_RENAME success");
/*    */     
/*    */ 
/* 14 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\POnRoleRename.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */