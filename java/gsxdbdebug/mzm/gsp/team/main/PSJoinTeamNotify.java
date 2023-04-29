/*    */ package mzm.gsp.team.main;
/*    */ 
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.team.SJoinTeamNotify;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xtable.Role2team;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PSJoinTeamNotify
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   
/*    */   public PSJoinTeamNotify(long roleId)
/*    */   {
/* 20 */     this.roleId = roleId;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 28 */     Long teamid = Role2team.select(Long.valueOf(this.roleId));
/* 29 */     if (teamid == null)
/*    */     {
/* 31 */       return false;
/*    */     }
/* 33 */     xbean.Team xTeam = xtable.Team.select(teamid);
/* 34 */     if (xTeam == null)
/*    */     {
/* 36 */       return false;
/*    */     }
/*    */     
/* 39 */     SJoinTeamNotify notify = new SJoinTeamNotify();
/* 40 */     TeamManager.fillTeamBean(teamid.longValue(), xTeam, notify.team);
/* 41 */     OnlineManager.getInstance().send(this.roleId, notify);
/* 42 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\team\main\PSJoinTeamNotify.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */