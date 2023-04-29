/*    */ package mzm.gsp.sworn.main;
/*    */ 
/*    */ import mzm.gsp.team.event.TeamDissolveArg;
/*    */ 
/*    */ public class POnTeamDissolve extends mzm.gsp.team.event.TeamDissolveProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/*  9 */     SwornManager.swornBuffForTeamDissolve(((TeamDissolveArg)this.arg).members);
/* 10 */     return SwornManager.swornBuilderTeamChange(((TeamDissolveArg)this.arg).teamid);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\sworn\main\POnTeamDissolve.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */