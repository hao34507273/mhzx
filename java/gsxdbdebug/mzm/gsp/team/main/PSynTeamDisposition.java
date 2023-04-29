/*    */ package mzm.gsp.team.main;
/*    */ 
/*    */ import mzm.gsp.team.SDispositionChanged;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PSynTeamDisposition
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long teamId;
/*    */   
/*    */   public PSynTeamDisposition(long teamId)
/*    */   {
/* 19 */     this.teamId = teamId;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 26 */     xbean.Team xTeam = xtable.Team.select(Long.valueOf(this.teamId));
/* 27 */     if (xTeam == null)
/*    */     {
/* 29 */       return false;
/*    */     }
/* 31 */     SDispositionChanged brd = TeamManager.fillPositionChangePro(xTeam);
/* 32 */     TeamManager.broadcast(xTeam, brd);
/*    */     
/* 34 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\team\main\PSynTeamDisposition.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */