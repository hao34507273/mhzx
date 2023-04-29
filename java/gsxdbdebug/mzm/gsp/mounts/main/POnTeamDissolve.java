/*    */ package mzm.gsp.mounts.main;
/*    */ 
/*    */ import mzm.gsp.team.event.TeamDissolveArg;
/*    */ 
/*    */ public class POnTeamDissolve extends mzm.gsp.team.event.TeamDissolveProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */   {
/*  9 */     xtable.Team2multirolemounts.remove(Long.valueOf(((TeamDissolveArg)this.arg).teamid));
/*    */     
/* 11 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mounts\main\POnTeamDissolve.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */