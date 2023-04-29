/*    */ package mzm.gsp.team.main;
/*    */ 
/*    */ import mzm.gsp.fight.event.RoleObserveEndProcedure;
/*    */ import xbean.TeamMember;
/*    */ import xtable.Role2team;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class POnRoleObserveEnd
/*    */   extends RoleObserveEndProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 17 */     Long teamid = Role2team.select((Long)this.arg);
/* 18 */     if (teamid == null)
/*    */     {
/* 20 */       return false;
/*    */     }
/* 22 */     boolean isLeader = TeamInterface.isTeamLeader(teamid.longValue(), ((Long)this.arg).longValue(), false);
/*    */     
/* 24 */     xbean.Team xTeam = xtable.Team.get(teamid);
/* 25 */     if (xTeam == null)
/*    */     {
/* 27 */       return false;
/*    */     }
/* 29 */     for (TeamMember xTeamMember : xTeam.getMembers())
/*    */     {
/* 31 */       if (isLeader)
/*    */       {
/* 33 */         if (xTeamMember.getTempstatus() == 6)
/*    */         {
/*    */ 
/*    */ 
/* 37 */           PReturnTeamReq returnTeam = new PReturnTeamReq(xTeamMember.getRoleid());
/* 38 */           returnTeam.execute();
/*    */         }
/*    */         
/*    */       }
/* 42 */       else if (xTeamMember.getRoleid() == ((Long)this.arg).longValue())
/*    */       {
/*    */ 
/*    */ 
/* 46 */         if (xTeamMember.getTempstatus() != 6)
/*    */         {
/* 48 */           return false;
/*    */         }
/* 50 */         xTeamMember.setTempstatus(0);
/*    */       }
/*    */     }
/*    */     
/* 54 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\team\main\POnRoleObserveEnd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */