/*    */ package mzm.gsp.team.main;
/*    */ 
/*    */ import xbean.Team;
/*    */ import xtable.Role2team;
/*    */ 
/*    */ public class PClearAllApplicantsReq extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long leaderId;
/*    */   
/*    */   public PClearAllApplicantsReq(long leaderId)
/*    */   {
/* 12 */     this.leaderId = leaderId;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 19 */     Long teamId = Role2team.select(Long.valueOf(this.leaderId));
/* 20 */     if (teamId == null)
/*    */     {
/* 22 */       return false;
/*    */     }
/*    */     
/* 25 */     Team xTeam = TeamManager.getXTeamByRoleid(this.leaderId, true);
/* 26 */     if (xTeam == null)
/*    */     {
/* 28 */       return false;
/*    */     }
/*    */     
/* 31 */     if (!TeamManager.isLeader(this.leaderId, xTeam))
/*    */     {
/* 33 */       return false;
/*    */     }
/*    */     
/* 36 */     TeamManager.emptyApplicationList(teamId.longValue(), xTeam);
/* 37 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\team\main\PClearAllApplicantsReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */