/*    */ package mzm.gsp.arena.main;
/*    */ 
/*    */ import mzm.gsp.status.main.RoleStatusInterface;
/*    */ import mzm.gsp.team.main.TeamInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.ArenaScore;
/*    */ import xbean.ArenaTmp;
/*    */ import xtable.Arenascore;
/*    */ 
/*    */ 
/*    */ class PCheckLeave
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   
/*    */   PCheckLeave(long roleid)
/*    */   {
/* 18 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 24 */     if (!RoleStatusInterface.containsStatus(this.roleid, 8)) {
/* 25 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 29 */     ArenaScore xScore = Arenascore.get(Long.valueOf(this.roleid));
/* 30 */     if (xScore == null) {
/* 31 */       return false;
/*    */     }
/*    */     
/* 34 */     if (xScore.getAction_point() <= 0) {
/* 35 */       if (TeamInterface.isRoleInTeam(this.roleid, true)) {
/* 36 */         TeamInterface.leaveTeamNoneRealTime(this.roleid);
/*    */       }
/*    */       else
/*    */       {
/* 40 */         ArenaTmp xTmp = ArenaManager.getXArenaTmpIfNotExist();
/* 41 */         if (ArenaManager.checkAndLeaveActivityWorld(this.roleid, xTmp)) {
/* 42 */           ArenaManager.sendNormalResult(this.roleid, 11, new String[0]);
/*    */         }
/*    */       }
/*    */     }
/*    */     
/* 47 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\arena\main\PCheckLeave.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */