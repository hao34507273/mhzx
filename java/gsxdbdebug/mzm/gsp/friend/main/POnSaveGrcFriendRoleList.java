/*    */ package mzm.gsp.friend.main;
/*    */ 
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.UserGrcFriendInfo;
/*    */ import xtable.User2grc_friend;
/*    */ 
/*    */ public class POnSaveGrcFriendRoleList
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   
/*    */   public POnSaveGrcFriendRoleList(long roleId)
/*    */   {
/* 15 */     this.roleId = roleId;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 22 */     String userId = RoleInterface.getUserId(this.roleId);
/* 23 */     if (userId == null)
/* 24 */       return false;
/* 25 */     UserGrcFriendInfo xUserGrcFriendInfo = User2grc_friend.get(userId);
/* 26 */     RoleFriend roleFriend = RoleFriendManager.getRoleFriend(this.roleId, true);
/* 27 */     RoleFriendManager.notifyGrcFriendRecommend(this.roleId, xUserGrcFriendInfo, roleFriend);
/* 28 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\friend\main\POnSaveGrcFriendRoleList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */