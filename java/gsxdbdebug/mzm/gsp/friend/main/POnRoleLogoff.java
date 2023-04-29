/*    */ package mzm.gsp.friend.main;
/*    */ 
/*    */ import mzm.gsp.friend.SSynFriendStatus;
/*    */ import mzm.gsp.online.event.PlayerOfflineProcedure;
/*    */ import mzm.gsp.status.main.RoleStatusInterface;
/*    */ 
/*    */ public class POnRoleLogoff
/*    */   extends PlayerOfflineProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 12 */     SSynFriendStatus synFriendStatus = new SSynFriendStatus();
/* 13 */     synFriendStatus.friendid = ((Long)this.arg).longValue();
/* 14 */     synFriendStatus.status = 2;
/* 15 */     if (RoleStatusInterface.containsStatus(((Long)this.arg).longValue(), 411)) {
/* 16 */       synFriendStatus.reason = 2;
/*    */     } else {
/* 18 */       synFriendStatus.reason = 1;
/*    */     }
/*    */     
/* 21 */     RoleFriend roleFriend = RoleFriendManager.getRoleFriend(((Long)this.arg).longValue(), true);
/* 22 */     RoleFriendManager.broadCastMsgToFriend(synFriendStatus, roleFriend);
/*    */     
/* 24 */     RemApplyInfoSession.remApplyInfoSession(((Long)this.arg).longValue());
/* 25 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\friend\main\POnRoleLogoff.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */