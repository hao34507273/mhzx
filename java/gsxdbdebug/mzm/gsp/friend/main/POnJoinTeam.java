/*    */ package mzm.gsp.friend.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import mzm.gsp.friend.SSynFriendTeamMem;
/*    */ import mzm.gsp.team.event.JoinTeamArg;
/*    */ 
/*    */ public class POnJoinTeam extends mzm.gsp.team.event.JoinTeamProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 12 */     long teamId = ((JoinTeamArg)this.arg).teamid;
/* 13 */     List<Long> members = mzm.gsp.team.main.TeamInterface.getTeamMemberList(teamId, false);
/*    */     
/* 15 */     for (Iterator i$ = members.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/* 16 */       SSynFriendTeamMem syFriendTeamMem = new SSynFriendTeamMem();
/* 17 */       syFriendTeamMem.friendid = roleid;
/* 18 */       syFriendTeamMem.teammemcount = members.size();
/* 19 */       RoleFriend roleFriend = RoleFriendManager.getRoleFriend(roleid, false);
/* 20 */       RoleFriendManager.broadCastMsgToFriend(syFriendTeamMem, roleFriend);
/*    */     }
/* 22 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\friend\main\POnJoinTeam.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */