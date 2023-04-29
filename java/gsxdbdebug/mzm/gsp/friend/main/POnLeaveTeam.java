/*    */ package mzm.gsp.friend.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import mzm.gsp.friend.SSynFriendTeamMem;
/*    */ import mzm.gsp.team.event.LeaveTeamArg;
/*    */ 
/*    */ public class POnLeaveTeam extends mzm.gsp.team.event.LeaveTeamProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 12 */     long teamid = ((LeaveTeamArg)this.arg).teamid;
/* 13 */     long leaveRoleid = ((LeaveTeamArg)this.arg).roleid;
/*    */     
/* 15 */     SSynFriendTeamMem synFriendTeamMem = new SSynFriendTeamMem();
/* 16 */     synFriendTeamMem.friendid = leaveRoleid;
/* 17 */     synFriendTeamMem.teammemcount = 0;
/* 18 */     RoleFriend leaveRoleFriend = RoleFriendManager.getRoleFriend(leaveRoleid, false);
/* 19 */     RoleFriendManager.broadCastMsgToFriend(synFriendTeamMem, leaveRoleFriend);
/*    */     
/*    */ 
/* 22 */     List<Long> members = mzm.gsp.team.main.TeamInterface.getTeamMemberList(teamid, false);
/* 23 */     for (Iterator i$ = members.iterator(); i$.hasNext();) { long member = ((Long)i$.next()).longValue();
/* 24 */       SSynFriendTeamMem sSynFriendTeamMem = new SSynFriendTeamMem();
/* 25 */       sSynFriendTeamMem.friendid = member;
/* 26 */       sSynFriendTeamMem.teammemcount = members.size();
/* 27 */       RoleFriend memberFriend = RoleFriendManager.getRoleFriend(member, false);
/* 28 */       RoleFriendManager.broadCastMsgToFriend(sSynFriendTeamMem, memberFriend);
/*    */     }
/* 30 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\friend\main\POnLeaveTeam.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */