/*    */ package mzm.gsp.team.changeleader;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import mzm.gsp.team.event.TeamDissolveArg;
/*    */ import mzm.gsp.team.event.TeamDissolveProcedure;
/*    */ import mzm.gsp.timer.main.Session;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.LeaderChangeBean;
/*    */ import xtable.Role2leaderchange;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class POnTeamDissolve
/*    */   extends TeamDissolveProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 20 */     List<Long> roleList = ((TeamDissolveArg)this.arg).members;
/* 21 */     if ((roleList == null) || (roleList.size() == 0)) {
/* 22 */       return false;
/*    */     }
/*    */     
/* 25 */     for (Iterator i$ = roleList.iterator(); i$.hasNext();) { final long roleId = ((Long)i$.next()).longValue();
/* 26 */       new LogicProcedure()
/*    */       {
/*    */         protected boolean processImp() throws Exception
/*    */         {
/* 30 */           LeaderChangeBean xLeaderChangeBean = Role2leaderchange.get(Long.valueOf(roleId));
/* 31 */           if (xLeaderChangeBean == null) {
/* 32 */             return false;
/*    */           }
/* 34 */           Session.removeSession(xLeaderChangeBean.getSessionid());
/* 35 */           Role2leaderchange.remove(Long.valueOf(roleId));
/* 36 */           return true;
/*    */         }
/*    */       }.execute();
/*    */     }
/*    */     
/* 41 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\team\changeleader\POnTeamDissolve.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */