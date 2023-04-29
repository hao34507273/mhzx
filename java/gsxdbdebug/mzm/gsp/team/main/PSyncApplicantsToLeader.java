/*    */ package mzm.gsp.team.main;
/*    */ 
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class PSyncApplicantsToLeader
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long teamid;
/*    */   
/*    */   PSyncApplicantsToLeader(long teamid)
/*    */   {
/* 18 */     this.teamid = teamid;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 24 */     xbean.Team xTeam = xtable.Team.select(Long.valueOf(this.teamid));
/* 25 */     if (xTeam == null)
/*    */     {
/* 27 */       return false;
/*    */     }
/*    */     
/* 30 */     TeamManager.syncTeamApplicantsToLeader(xTeam);
/*    */     
/* 32 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\team\main\PSyncApplicantsToLeader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */