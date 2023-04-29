/*    */ package mzm.gsp.arena.main;
/*    */ 
/*    */ import mzm.gsp.fight.event.RoleEscapeArg;
/*    */ import mzm.gsp.fight.event.RoleEscapeProcedure;
/*    */ import mzm.gsp.team.main.TeamInterface;
/*    */ import xbean.ArenaScore;
/*    */ import xbean.ArenaTmp;
/*    */ import xtable.Arenascore;
/*    */ 
/*    */ public class POnRoleEscape extends RoleEscapeProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 14 */     if (!(((RoleEscapeArg)this.arg).fightContext instanceof ArenaFightContext)) {
/* 15 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 19 */     ArenaScore xScore = Arenascore.get(Long.valueOf(((RoleEscapeArg)this.arg).roleid));
/* 20 */     if (xScore == null) {
/* 21 */       return false;
/*    */     }
/*    */     
/* 24 */     ArenaManager.deductActionPoint(xScore);
/*    */     
/* 26 */     if (xScore.getAction_point() <= 0) {
/* 27 */       if (TeamInterface.isRoleInTeam(((RoleEscapeArg)this.arg).roleid, false)) {
/* 28 */         TeamInterface.leaveTeamNoneRealTime(((RoleEscapeArg)this.arg).roleid);
/*    */       }
/*    */       else
/*    */       {
/* 32 */         ArenaTmp xArenaTmp = ArenaManager.getXArenaTmpIfNotExist();
/* 33 */         ArenaManager.checkAndLeaveActivityWorld(((RoleEscapeArg)this.arg).roleid, xArenaTmp);
/*    */       }
/*    */     }
/*    */     else {
/* 37 */       ArenaManager.syncRoleScore(((RoleEscapeArg)this.arg).roleid, xScore);
/*    */     }
/*    */     
/* 40 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\arena\main\POnRoleEscape.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */