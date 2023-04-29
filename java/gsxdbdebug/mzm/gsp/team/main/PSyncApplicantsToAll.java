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
/*    */ public class PSyncApplicantsToAll
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long teamid;
/*    */   
/*    */   PSyncApplicantsToAll(long teamid)
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
/* 30 */     TeamManager.syncTeamApplicantsToAllMembers(xTeam);
/*    */     
/* 32 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\team\main\PSyncApplicantsToAll.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */