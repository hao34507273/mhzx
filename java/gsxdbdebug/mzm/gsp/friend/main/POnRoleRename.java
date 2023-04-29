/*    */ package mzm.gsp.friend.main;
/*    */ 
/*    */ import mzm.gsp.role.event.RoleRenameProcedure;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ 
/*    */ public class POnRoleRename extends RoleRenameProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 10 */     String roleName = RoleInterface.getName(((Long)this.arg).longValue());
/*    */     
/* 12 */     RoleFriend roleFriend = RoleFriendManager.getRoleFriend(((Long)this.arg).longValue(), false);
/* 13 */     RoleFriendManager.sendFriendNameChangeMsg(roleName, roleFriend);
/* 14 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\friend\main\POnRoleRename.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */