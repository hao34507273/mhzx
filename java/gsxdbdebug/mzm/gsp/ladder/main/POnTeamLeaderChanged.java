/*    */ package mzm.gsp.ladder.main;
/*    */ 
/*    */ import java.util.List;
/*    */ import mzm.gsp.status.main.RoleStatusInterface;
/*    */ import mzm.gsp.team.TeamMember;
/*    */ import mzm.gsp.team.event.TeamLeaderChangedArg;
/*    */ import mzm.gsp.team.event.TeamLeaderChangedProcedure;
/*    */ 
/*    */ public class POnTeamLeaderChanged extends TeamLeaderChangedProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 13 */     if (RoleStatusInterface.containsStatus(((TeamLeaderChangedArg)this.arg).oldLeader, 43)) {
/* 14 */       List<Long> allRoles = new java.util.ArrayList();
/* 15 */       for (TeamMember teamMember : ((TeamLeaderChangedArg)this.arg).teamMembers) {
/* 16 */         allRoles.add(Long.valueOf(teamMember.roleid));
/*    */       }
/* 18 */       lock(xtable.Role2properties.getTable(), allRoles);
/* 19 */       LadderManager.doCancelReady(((TeamLeaderChangedArg)this.arg).oldLeader, allRoles);
/* 20 */       RoleStatusInterface.setStatus(((TeamLeaderChangedArg)this.arg).newLeader, 43, false);
/*    */     }
/* 22 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\ladder\main\POnTeamLeaderChanged.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */