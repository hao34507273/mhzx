/*    */ package mzm.gsp.team.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import mzm.gsp.teamplatform.match.MJoinTeamOnNewGuy;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import mzm.gsp.util.LogicRunnable;
/*    */ import xdb.Executor;
/*    */ import xdb.Xdb;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PRoleTryJoinTeamByLeaders
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final List<Long> leaderIds;
/*    */   
/*    */   public PRoleTryJoinTeamByLeaders(long roleId, List<Long> leaderIds)
/*    */   {
/* 23 */     this.roleId = roleId;
/* 24 */     this.leaderIds = leaderIds;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 30 */     Xdb.executor().execute(new LogicRunnable()
/*    */     {
/*    */ 
/*    */       public void process()
/*    */         throws Exception
/*    */       {
/* 36 */         for (Iterator i$ = PRoleTryJoinTeamByLeaders.this.leaderIds.iterator(); i$.hasNext();) { long leaderId = ((Long)i$.next()).longValue();
/*    */           
/* 38 */           PJoinTeamByLeaderId joinTeam = new PJoinTeamByLeaderId(PRoleTryJoinTeamByLeaders.this.roleId, leaderId, MJoinTeamOnNewGuy.getInstance());
/* 39 */           boolean res = joinTeam.call();
/* 40 */           if (res)
/*    */           {
/* 42 */             return;
/*    */           }
/*    */           
/*    */ 
/* 46 */           switch (joinTeam.result)
/*    */           {
/*    */           case 0: 
/* 49 */             return;
/*    */           
/*    */ 
/*    */ 
/*    */ 
/*    */           }
/*    */           
/*    */         }
/*    */       }
/* 58 */     });
/* 59 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\team\main\PRoleTryJoinTeamByLeaders.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */