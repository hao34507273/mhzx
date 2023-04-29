/*    */ package mzm.gsp.friendscircle.main;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import mzm.gsp.friend.event.FriendDeleteArg;
/*    */ import mzm.gsp.friend.event.FriendDeleteEventProcedure;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import xtable.Role2properties;
/*    */ 
/*    */ public class POnFriendDelete
/*    */   extends FriendDeleteEventProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 14 */     long roleId = ((FriendDeleteArg)this.arg).roleid;
/* 15 */     long roleId1 = ((FriendDeleteArg)this.arg).deleteFriendRoleId;
/*    */     
/* 17 */     lock(Role2properties.getTable(), Arrays.asList(new Long[] { Long.valueOf(roleId), Long.valueOf(roleId1) }));
/* 18 */     String userId = RoleInterface.getUserId(roleId);
/* 19 */     if (userId == null)
/*    */     {
/* 21 */       return false;
/*    */     }
/*    */     
/* 24 */     String userId1 = RoleInterface.getUserId(roleId1);
/* 25 */     if (userId1 == null)
/*    */     {
/* 27 */       return false;
/*    */     }
/*    */     
/* 30 */     if (!FriendsCircleManager.isRoleLevelFriendsCircleOpen(roleId))
/*    */     {
/* 32 */       return false;
/*    */     }
/*    */     
/* 35 */     if (!FriendsCircleManager.isFriendsCircleSwitchOpen(roleId, 451, false))
/*    */     {
/* 37 */       return false;
/*    */     }
/*    */     
/* 40 */     FriendsCircleManager.reportRoleFriendsChange(roleId, userId, roleId1, 2);
/*    */     
/* 42 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\friendscircle\main\POnFriendDelete.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */