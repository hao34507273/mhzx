/*    */ package mzm.gsp.crosscompete.roam;
/*    */ 
/*    */ import mzm.gsp.buff.main.BuffInterface;
/*    */ import mzm.gsp.competition.confbean.SCompetitionConsts;
/*    */ import mzm.gsp.crosscompete.confbean.SCrossCompeteConsts;
/*    */ import mzm.gsp.fight.event.RoleEscapeArg;
/*    */ import mzm.gsp.fight.event.RoleEscapeProcedure;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.team.main.TeamInterface;
/*    */ import xbean.RoamCrossCompeteRole;
/*    */ import xdb.Lockeys;
/*    */ import xtable.Roam_crosscompete_role;
/*    */ import xtable.User;
/*    */ 
/*    */ public class POnRoleEscape
/*    */   extends RoleEscapeProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 21 */     if (!(((RoleEscapeArg)this.arg).fightContext instanceof PVPFightContext)) {
/* 22 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 26 */     String userid = RoleInterface.getUserId(((RoleEscapeArg)this.arg).roleid);
/* 27 */     lock(Lockeys.get(User.getTable(), userid));
/*    */     
/*    */ 
/* 30 */     RoamCrossCompeteRole xRoamRole = Roam_crosscompete_role.get(Long.valueOf(((RoleEscapeArg)this.arg).roleid));
/* 31 */     if (xRoamRole == null) {
/* 32 */       return false;
/*    */     }
/*    */     
/* 35 */     CrossCompeteRoamManager.deductActionPoint(((RoleEscapeArg)this.arg).roleid, xRoamRole, SCrossCompeteConsts.getInstance().DeductActionPointWhenLose, 4);
/*    */     
/*    */ 
/*    */ 
/* 39 */     CrossCompeteRoamManager.addRoleEscapeTimes(((RoleEscapeArg)this.arg).roleid, xRoamRole);
/*    */     
/* 41 */     if (xRoamRole.getAction_point() <= 0) {
/* 42 */       if (TeamInterface.isRoleInTeam(((RoleEscapeArg)this.arg).roleid, false)) {
/* 43 */         TeamInterface.leaveTeamNoneRealTime(((RoleEscapeArg)this.arg).roleid);
/*    */       }
/*    */       else {
/* 46 */         CrossCompeteRoamManager.leave(userid, ((RoleEscapeArg)this.arg).roleid, xRoamRole, 1);
/*    */       }
/*    */       
/*    */ 
/*    */     }
/*    */     else {
/* 52 */       BuffInterface.installBuff(((RoleEscapeArg)this.arg).roleid, SCompetitionConsts.getInstance().ProtectedBuff);
/*    */     }
/*    */     
/*    */ 
/* 56 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crosscompete\roam\POnRoleEscape.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */