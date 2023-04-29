/*    */ package mzm.gsp.friend.main;
/*    */ 
/*    */ import mzm.gsp.avatar.event.SetAvatarArg;
/*    */ import mzm.gsp.avatar.event.SetAvatarProcedure;
/*    */ import mzm.gsp.avatar.main.AvatarInterface;
/*    */ 
/*    */ public class POnRoleSetAvatar
/*    */   extends SetAvatarProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 13 */     int avatarId = AvatarInterface.getCurrentAvatar(((SetAvatarArg)this.arg).roleId, false);
/* 14 */     RoleFriend friends = RoleFriendManager.getRoleFriend(((SetAvatarArg)this.arg).roleId, false);
/* 15 */     RoleFriendManager.sendFriendAvatarChangeMsg(avatarId, friends);
/* 16 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\friend\main\POnRoleSetAvatar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */