/*    */ package mzm.gsp.friend.main;
/*    */ 
/*    */ import mzm.gsp.online.event.PlayerLoginProtectProcedure;
/*    */ 
/*    */ public class POnRoleLoginProtect extends PlayerLoginProtectProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception {
/*  8 */     RoleFriend roleFriend = RoleFriendManager.getRoleFriend(((Long)this.arg).longValue(), true);
/*  9 */     RoleApply roleApply = RoleFriendManager.getRoleApply(((Long)this.arg).longValue(), true);
/* 10 */     RoleFriendManager.onRolelogin(roleApply, roleFriend);
/* 11 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\friend\main\POnRoleLoginProtect.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */