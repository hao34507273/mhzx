/*    */ package mzm.gsp.friend.main;
/*    */ 
/*    */ import mzm.gsp.avatar.event.AvatarFrameChangedArg;
/*    */ 
/*    */ public class POnAvatarFrameChanged extends mzm.gsp.avatar.event.AvatarFrameChangedProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception {
/*  8 */     RoleFriend friend = RoleFriendManager.getRoleFriend(((AvatarFrameChangedArg)this.arg).roleId, false);
/*  9 */     RoleFriendManager.sendFriendAvatarFrameChangeMsg(friend, ((AvatarFrameChangedArg)this.arg).avatarFrameId);
/* 10 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\friend\main\POnAvatarFrameChanged.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */