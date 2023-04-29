/*    */ package mzm.gsp.team.main;
/*    */ 
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xdb.Procedure;
/*    */ import xtable.Role2team;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PEmptyApplicationList
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   
/*    */   public PEmptyApplicationList(long roleid)
/*    */   {
/* 18 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 26 */     Long teamid = Role2team.select(Long.valueOf(this.roleid));
/* 27 */     if (teamid == null)
/*    */     {
/* 29 */       return false;
/*    */     }
/* 31 */     xbean.Team xTeam = xtable.Team.get(teamid);
/* 32 */     if (xTeam == null)
/*    */     {
/* 34 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 38 */     if (!TeamManager.isLeader(this.roleid, xTeam))
/*    */     {
/* 40 */       return false;
/*    */     }
/*    */     
/* 43 */     TeamManager.emptyApplicationList(teamid.longValue(), xTeam);
/* 44 */     Procedure.execute(new PSyncApplicantsToAll(teamid.longValue()));
/*    */     
/* 46 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\team\main\PEmptyApplicationList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */