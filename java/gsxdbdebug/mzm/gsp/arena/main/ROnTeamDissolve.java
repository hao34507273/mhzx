/*    */ package mzm.gsp.arena.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import mzm.gsp.team.event.TeamDissolveArg;
/*    */ import mzm.gsp.team.event.TeamDissolveRunnable;
/*    */ 
/*    */ public class ROnTeamDissolve extends TeamDissolveRunnable
/*    */ {
/*    */   public void process() throws Exception
/*    */   {
/* 12 */     for (Iterator i$ = ((TeamDissolveArg)this.arg).members.iterator(); i$.hasNext();) { long r = ((Long)i$.next()).longValue();
/* 13 */       new PCheckLeave(r).call();
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\arena\main\ROnTeamDissolve.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */