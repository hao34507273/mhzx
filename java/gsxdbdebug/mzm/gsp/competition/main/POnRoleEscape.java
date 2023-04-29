/*    */ package mzm.gsp.competition.main;
/*    */ 
/*    */ import mzm.gsp.buff.main.BuffInterface;
/*    */ import mzm.gsp.competition.confbean.SCompetitionConsts;
/*    */ import mzm.gsp.fight.event.RoleEscapeArg;
/*    */ import mzm.gsp.fight.event.RoleEscapeProcedure;
/*    */ import mzm.gsp.gang.main.Gang;
/*    */ import mzm.gsp.gang.main.GangInterface;
/*    */ import mzm.gsp.team.main.TeamInterface;
/*    */ import xbean.FactionCompetitionTmp;
/*    */ import xbean.RoleCompetition;
/*    */ import xdb.Lockeys;
/*    */ import xtable.Faction_competition_tmp;
/*    */ import xtable.Role_competition;
/*    */ import xtable.User;
/*    */ 
/*    */ public class POnRoleEscape extends RoleEscapeProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 21 */     if (!(((RoleEscapeArg)this.arg).fightContext instanceof CompetitionFightContext)) {
/* 22 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 26 */     String userid = mzm.gsp.role.main.RoleInterface.getUserId(((RoleEscapeArg)this.arg).roleid);
/* 27 */     lock(Lockeys.get(User.getTable(), userid));
/*    */     
/*    */ 
/* 30 */     RoleCompetition xRoleCompetition = Role_competition.get(Long.valueOf(((RoleEscapeArg)this.arg).roleid));
/* 31 */     if (xRoleCompetition == null) {
/* 32 */       return false;
/*    */     }
/*    */     
/* 35 */     CompetitionManager.deductActionPoint(((RoleEscapeArg)this.arg).roleid, xRoleCompetition, SCompetitionConsts.getInstance().DeductActionPointWhenLose, 4);
/*    */     
/* 37 */     if (xRoleCompetition.getAction_point() <= 0) {
/* 38 */       if (TeamInterface.isRoleInTeam(((RoleEscapeArg)this.arg).roleid, false)) {
/* 39 */         TeamInterface.leaveTeamNoneRealTime(((RoleEscapeArg)this.arg).roleid);
/*    */       }
/*    */       else
/*    */       {
/* 43 */         Gang faction = GangInterface.getGangByRoleId(((RoleEscapeArg)this.arg).roleid, true);
/* 44 */         FactionCompetitionTmp xTmp = Faction_competition_tmp.get(Long.valueOf(faction.getGangId()));
/* 45 */         CompetitionManager.leave(userid, ((RoleEscapeArg)this.arg).roleid, faction, xTmp);
/*    */       }
/*    */       
/*    */     }
/*    */     else {
/* 50 */       BuffInterface.installBuff(((RoleEscapeArg)this.arg).roleid, SCompetitionConsts.getInstance().ProtectedBuff);
/*    */     }
/*    */     
/*    */ 
/* 54 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\competition\main\POnRoleEscape.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */