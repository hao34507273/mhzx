/*    */ package mzm.gsp.crossserver.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import mzm.gsp.crossbattle.knockout.KnockOutEndContext;
/*    */ import mzm.gsp.crossbattle.knockout.KnockOutEndContextManager;
/*    */ import mzm.gsp.ladder.SLoginWaitTimeOut;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.status.main.RoleStatusInterface;
/*    */ import mzm.gsp.team.main.TeamInterface;
/*    */ import mzm.gsp.timer.main.Session;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import mzm.gsp.util.LogicRunnable;
/*    */ import xdb.Executor;
/*    */ import xtable.Role2properties;
/*    */ 
/*    */ public class KnockOutFightEndSession extends Session
/*    */ {
/* 20 */   public List<Long> roleIdList = new ArrayList();
/* 21 */   public List<String> userIdList = new ArrayList();
/*    */   
/*    */   public KnockOutFightEndSession(long interval, long ownerid, List<Long> roleIdList, List<String> userIdList)
/*    */   {
/* 25 */     super(interval, ownerid);
/* 26 */     this.roleIdList.addAll(roleIdList);
/* 27 */     this.userIdList.addAll(userIdList);
/*    */   }
/*    */   
/*    */ 
/*    */   protected void onTimeOut()
/*    */   {
/* 33 */     Executor.getInstance().execute(new LogicRunnable()
/*    */     {
/*    */ 
/*    */       public void process()
/*    */         throws Exception
/*    */       {
/* 39 */         final KnockOutEndContext crossBattleEndContext = (KnockOutEndContext)KnockOutEndContextManager.getInstance().removeKeys(KnockOutFightEndSession.this.userIdList);
/* 40 */         if (crossBattleEndContext != null)
/*    */         {
/* 42 */           final long leaderid = crossBattleEndContext.getLeaderid();
/* 43 */           if (OnlineManager.getInstance().isOnline(leaderid))
/*    */           {
/* 45 */             final Long teamId = TeamInterface.getTeamidByRoleid(leaderid, false);
/* 46 */             if (teamId != null)
/*    */             {
/* 48 */               new LogicProcedure()
/*    */               {
/*    */ 
/*    */                 protected boolean processImp()
/*    */                   throws Exception
/*    */                 {
/* 54 */                   long teamLeader = TeamInterface.getTeamLeaderByTeamid(teamId.longValue(), false);
/* 55 */                   if (teamLeader != leaderid)
/*    */                   {
/* 57 */                     TeamInterface.appointLeader(teamId.longValue(), leaderid);
/*    */                   }
/* 59 */                   return true;
/*    */                 }
/*    */                 
/*    */ 
/* 63 */               }.call();
/* 64 */               new LogicProcedure()
/*    */               {
/*    */ 
/*    */                 protected boolean processImp()
/*    */                   throws Exception
/*    */                 {
/* 70 */                   TeamInterface.designTeam(teamId.longValue(), crossBattleEndContext.allRoleIdList);
/* 71 */                   return true;
/*    */                 }
/*    */               }.call();
/*    */             }
/*    */           }
/*    */         }
/*    */         
/*    */ 
/* 79 */         new LogicProcedure()
/*    */         {
/*    */ 
/*    */           protected boolean processImp()
/*    */             throws Exception
/*    */           {
/* 85 */             lock(Role2properties.getTable(), KnockOutFightEndSession.this.roleIdList);
/* 86 */             for (Iterator i$ = KnockOutFightEndSession.this.roleIdList.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*    */               
/* 88 */               RoleStatusInterface.unsetStatus(roleid, 65);
/* 89 */               RoleStatusInterface.unsetStatus(roleid, 1551);
/*    */             }
/* 91 */             return true;
/*    */           }
/* 93 */         }.call();
/* 94 */         SLoginWaitTimeOut loginWaitTimeOut = new SLoginWaitTimeOut();
/* 95 */         OnlineManager.getInstance().sendMultiAtOnce(loginWaitTimeOut, KnockOutFightEndSession.this.roleIdList);
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\main\KnockOutFightEndSession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */