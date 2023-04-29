/*    */ package mzm.gsp.friend.main;
/*    */ 
/*    */ import mzm.gsp.role.event.RoleLevelUpArg;
/*    */ 
/*    */ public class POnRoleLevelUp extends mzm.gsp.role.event.RoleLevelUpProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/*  9 */     mzm.gsp.friend.SSynFriendLevel synFriendLevel = new mzm.gsp.friend.SSynFriendLevel();
/* 10 */     synFriendLevel.friendid = ((RoleLevelUpArg)this.arg).roleId;
/* 11 */     synFriendLevel.level = ((RoleLevelUpArg)this.arg).newLevel;
/* 12 */     RoleFriend roleFriend = RoleFriendManager.getRoleFriend(((RoleLevelUpArg)this.arg).roleId, false);
/* 13 */     RoleFriendManager.broadCastMsgToFriend(synFriendLevel, roleFriend);
/* 14 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\friend\main\POnRoleLevelUp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */