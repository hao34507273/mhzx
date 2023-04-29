/*    */ package mzm.gsp.buff.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import mzm.gsp.team.event.TeamDissolveArg;
/*    */ 
/*    */ public class POnTeamDissolve extends mzm.gsp.team.event.TeamDissolveProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 10 */     for (Iterator i$ = ((TeamDissolveArg)this.arg).members.iterator(); i$.hasNext();) { long memberId = ((Long)i$.next()).longValue();
/* 11 */       BuffInterface.uninstallBufWithTypeAsyc(memberId, 4);
/*    */     }
/*    */     
/* 14 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\buff\main\POnTeamDissolve.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */