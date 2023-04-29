/*    */ package mzm.gsp.crosscompete.roam;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import mzm.gsp.team.event.TeamDissolveArg;
/*    */ import mzm.gsp.team.event.TeamDissolveProcedure;
/*    */ import xdb.Procedure;
/*    */ 
/*    */ public class POnTeamDissolve extends TeamDissolveProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 12 */     for (Iterator i$ = ((TeamDissolveArg)this.arg).members.iterator(); i$.hasNext();) { long r = ((Long)i$.next()).longValue();
/* 13 */       Procedure.execute(new PCheckLeaveByLeaveTeam(r));
/*    */     }
/* 15 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crosscompete\roam\POnTeamDissolve.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */