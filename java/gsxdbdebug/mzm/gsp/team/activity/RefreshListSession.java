/*    */ package mzm.gsp.team.activity;
/*    */ 
/*    */ import mzm.gsp.team.confbean.TeamConsts;
/*    */ import mzm.gsp.timer.main.Session;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*    */ import xbean.ActivityTeamBean;
/*    */ import xtable.Role2activityteam;
/*    */ 
/*    */ 
/*    */ class RefreshListSession
/*    */   extends Session
/*    */ {
/*    */   private long roleId;
/*    */   
/*    */   RefreshListSession(long roleId)
/*    */   {
/* 18 */     super(TeamConsts.getInstance().ACTIVITY_TEAM_REFRESH_INTERVAL, roleId);
/* 19 */     this.roleId = roleId;
/*    */   }
/*    */   
/*    */   protected void onTimeOut()
/*    */   {
/* 24 */     NoneRealTimeTaskManager.getInstance().addTask(new LogicProcedure()
/*    */     {
/*    */       protected boolean processImp() throws Exception
/*    */       {
/* 28 */         ActivityTeamBean xbean = Role2activityteam.get(Long.valueOf(RefreshListSession.this.roleId));
/* 29 */         if (xbean == null) {
/* 30 */           return false;
/*    */         }
/* 32 */         Role2activityteam.remove(Long.valueOf(RefreshListSession.this.roleId));
/* 33 */         return true;
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\team\activity\RefreshListSession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */