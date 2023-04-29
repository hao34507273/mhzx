/*    */ package mzm.gsp.team.main;
/*    */ 
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.TeamMember;
/*    */ import xtable.Role2team;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PToReturnTeamCancel
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   
/*    */   public PToReturnTeamCancel(long roleid)
/*    */   {
/* 18 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 25 */     Long teamid = Role2team.select(Long.valueOf(this.roleid));
/* 26 */     if (teamid == null)
/*    */     {
/* 28 */       return false;
/*    */     }
/* 30 */     xbean.Team xTeam = xtable.Team.get(teamid);
/* 31 */     if (xTeam == null)
/*    */     {
/* 33 */       return false;
/*    */     }
/*    */     
/* 36 */     TeamMember xMember = TeamManager.getXMember(xTeam, this.roleid);
/* 37 */     if (xMember.getTempstatus() != 6)
/*    */     {
/* 39 */       return false;
/*    */     }
/*    */     
/* 42 */     xMember.setTempstatus(0);
/*    */     
/* 44 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\team\main\PToReturnTeamCancel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */