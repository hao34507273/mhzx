/*    */ package mzm.gsp.friend.main;
/*    */ 
/*    */ import mzm.gsp.team.event.TeamCreateArg;
/*    */ import mzm.gsp.team.event.TeamMember;
/*    */ 
/*    */ public class POnTeamCreate extends mzm.gsp.team.event.TeamCreateProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 10 */     int number = ((TeamCreateArg)this.arg).members.size();
/* 11 */     for (TeamMember member : ((TeamCreateArg)this.arg).members) {
/* 12 */       mzm.gsp.friend.SSynFriendTeamMem friendTeamMem = new mzm.gsp.friend.SSynFriendTeamMem();
/* 13 */       friendTeamMem.friendid = member.roleid;
/* 14 */       friendTeamMem.teammemcount = number;
/*    */       
/* 16 */       RoleFriend rolememFriend = RoleFriendManager.getRoleFriend(member.roleid, false);
/* 17 */       RoleFriendManager.broadCastMsgToFriend(friendTeamMem, rolememFriend);
/*    */     }
/* 19 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\friend\main\POnTeamCreate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */