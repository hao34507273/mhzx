/*    */ package mzm.gsp.team.main;
/*    */ 
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xdb.Procedure;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PRmApplicant
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long applicantId;
/*    */   private final long teamId;
/*    */   
/*    */   public PRmApplicant(long applicantId, long teamId)
/*    */   {
/* 19 */     this.applicantId = applicantId;
/* 20 */     this.teamId = teamId;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 27 */     xbean.Team xTeam = xtable.Team.get(Long.valueOf(this.teamId));
/* 28 */     if (xTeam == null)
/*    */     {
/* 30 */       return false;
/*    */     }
/* 32 */     if (TeamManager.removeApplicant(this.teamId, xTeam, this.applicantId))
/*    */     {
/*    */ 
/* 35 */       Procedure.execute(new PSyncApplicantsToAll(this.teamId));
/*    */     }
/* 37 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\team\main\PRmApplicant.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */