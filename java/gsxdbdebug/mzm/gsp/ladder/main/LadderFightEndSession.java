/*    */ package mzm.gsp.ladder.main;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Iterator;
/*    */ import java.util.Map;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.ladder.SLoginWaitTimeOut;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.team.main.TeamInterface;
/*    */ import mzm.gsp.timer.main.Session;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import mzm.gsp.util.LogicRunnable;
/*    */ import xdb.Executor;
/*    */ 
/*    */ public class LadderFightEndSession extends Session
/*    */ {
/* 17 */   public Map<Long, String> role2User = new HashMap();
/*    */   
/*    */   public LadderFightEndSession(long interval, long ownerid, Map<Long, String> role2User) {
/* 20 */     super(interval, ownerid);
/* 21 */     this.role2User.putAll(role2User);
/*    */   }
/*    */   
/*    */   protected void onTimeOut()
/*    */   {
/* 26 */     Executor.getInstance().execute(new LogicRunnable()
/*    */     {
/*    */       public void process()
/*    */         throws Exception
/*    */       {
/* 31 */         final LadderMatchEndContext ladderMatchEndContext = (LadderMatchEndContext)LadderMatchContextManager.getInstance().removeKeys(LadderFightEndSession.this.role2User.values());
/*    */         
/* 33 */         if (ladderMatchEndContext != null) {
/* 34 */           final long leaderid = ladderMatchEndContext.getLeaderid();
/* 35 */           if (OnlineManager.getInstance().isOnline(leaderid)) {
/* 36 */             final Long teamId = TeamInterface.getTeamidByRoleid(leaderid, false);
/* 37 */             if (teamId != null) {
/* 38 */               new LogicProcedure()
/*    */               {
/*    */                 protected boolean processImp() throws Exception
/*    */                 {
/* 42 */                   long teamLeader = TeamInterface.getTeamLeaderByTeamid(teamId.longValue(), false);
/* 43 */                   if (teamLeader != leaderid) {
/* 44 */                     TeamInterface.appointLeader(teamId.longValue(), leaderid);
/*    */                   }
/* 46 */                   return true;
/*    */                 }
/* 48 */               }.call();
/* 49 */               new LogicProcedure()
/*    */               {
/*    */                 protected boolean processImp() throws Exception
/*    */                 {
/* 53 */                   TeamInterface.designTeam(teamId.longValue(), ladderMatchEndContext.getAllRoleList());
/* 54 */                   return true;
/*    */                 }
/*    */               }.call();
/*    */             }
/*    */           }
/*    */         }
/*    */         
/*    */ 
/* 62 */         new LogicProcedure()
/*    */         {
/*    */           protected boolean processImp() throws Exception
/*    */           {
/* 66 */             lock(xtable.Role2properties.getTable(), LadderFightEndSession.this.role2User.keySet());
/* 67 */             for (Iterator i$ = LadderFightEndSession.this.role2User.keySet().iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/* 68 */               mzm.gsp.status.main.RoleStatusInterface.unsetStatus(roleid, 65);
/*    */             }
/* 70 */             return true;
/*    */           }
/* 72 */         }.call();
/* 73 */         SLoginWaitTimeOut loginWaitTimeOut = new SLoginWaitTimeOut();
/* 74 */         OnlineManager.getInstance().sendMultiAtOnce(loginWaitTimeOut, LadderFightEndSession.this.role2User.keySet());
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\ladder\main\LadderFightEndSession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */