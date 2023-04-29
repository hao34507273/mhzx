/*    */ package mzm.gsp.friend.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ 
/*    */ public class POnTeamDissolve extends mzm.gsp.team.event.TeamDissolveProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/*  9 */     for (Iterator i$ = ((mzm.gsp.team.event.TeamDissolveArg)this.arg).members.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/* 10 */       mzm.gsp.friend.SSynFriendTeamMem sSynFriendTeamMem = new mzm.gsp.friend.SSynFriendTeamMem();
/* 11 */       sSynFriendTeamMem.friendid = roleid;
/* 12 */       sSynFriendTeamMem.teammemcount = 0;
/*    */       
/* 14 */       RoleFriend roleFriend = RoleFriendManager.getRoleFriend(roleid, false);
/* 15 */       RoleFriendManager.broadCastMsgToFriend(sSynFriendTeamMem, roleFriend);
/*    */     }
/* 17 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\friend\main\POnTeamDissolve.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */