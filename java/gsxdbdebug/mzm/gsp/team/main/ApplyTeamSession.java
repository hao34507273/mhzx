/*    */ package mzm.gsp.team.main;
/*    */ 
/*    */ import mzm.gsp.team.confbean.TeamConsts;
/*    */ import mzm.gsp.timer.main.Session;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*    */ import xdb.Procedure;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class ApplyTeamSession
/*    */   extends Session
/*    */ {
/*    */   private final long teamid;
/*    */   
/*    */   ApplyTeamSession(long teamid, long applicant)
/*    */   {
/* 21 */     super(TeamConsts.getInstance().APPLY_SECONDS, applicant);
/* 22 */     this.teamid = teamid;
/*    */   }
/*    */   
/*    */ 
/*    */   protected void onTimeOut()
/*    */   {
/* 28 */     NoneRealTimeTaskManager.getInstance().addTask(new RemoveApplicant());
/*    */   }
/*    */   
/*    */   class RemoveApplicant extends LogicProcedure
/*    */   {
/*    */     RemoveApplicant() {}
/*    */     
/*    */     protected boolean processImp() throws Exception
/*    */     {
/* 37 */       xbean.Team xTeam = xtable.Team.get(Long.valueOf(ApplyTeamSession.this.teamid));
/* 38 */       if (xTeam == null)
/*    */       {
/* 40 */         return false;
/*    */       }
/*    */       
/* 43 */       if (TeamManager.removeApplicant(ApplyTeamSession.this.teamid, xTeam, ApplyTeamSession.this.getOwerId()))
/*    */       {
/*    */ 
/* 46 */         Procedure.execute(new PSyncApplicantsToAll(ApplyTeamSession.this.teamid));
/*    */       }
/*    */       
/* 49 */       return true;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\team\main\ApplyTeamSession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */