/*    */ package mzm.gsp.friend.main;
/*    */ 
/*    */ import mzm.gsp.friend.SSynFriendDelStatus;
/*    */ 
/*    */ public class POnPlayerDelete extends mzm.gsp.online.event.PlayerDeleteProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/*  9 */     RoleFriend roleFriend = RoleFriendManager.getRoleFriend(((Long)this.arg).longValue(), false);
/* 10 */     if (roleFriend.friendSize() <= 0) {
/* 11 */       return false;
/*    */     }
/* 13 */     SSynFriendDelStatus synFriendDelStatus = new SSynFriendDelStatus();
/* 14 */     synFriendDelStatus.friendid = ((Long)this.arg).longValue();
/* 15 */     synFriendDelStatus.status = 0;
/* 16 */     RoleFriendManager.broadCastMsgToFriend(synFriendDelStatus, roleFriend);
/* 17 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\friend\main\POnPlayerDelete.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */