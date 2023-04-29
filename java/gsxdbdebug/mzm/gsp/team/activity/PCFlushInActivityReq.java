/*    */ package mzm.gsp.team.activity;
/*    */ 
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.map.main.MapInterface;
/*    */ import mzm.gsp.team.main.ActivityTeamHandler;
/*    */ import mzm.gsp.team.main.TeamManager;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.ActivityTeamBean;
/*    */ import xbean.Pod;
/*    */ import xdb.Procedure;
/*    */ import xtable.Role2activityteam;
/*    */ 
/*    */ 
/*    */ public class PCFlushInActivityReq
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final int flushType;
/*    */   
/*    */   public PCFlushInActivityReq(long roleId, int flushType)
/*    */   {
/* 23 */     this.roleId = roleId;
/* 24 */     this.flushType = flushType;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 30 */     if (!checkCanRefresh()) {
/* 31 */       return false;
/*    */     }
/*    */     
/* 34 */     long roleWorldId = MapInterface.getRoleWorldInstanceId(this.roleId);
/* 35 */     if (roleWorldId < 0L) {
/* 36 */       return false;
/*    */     }
/* 38 */     ActivityTeamHandler handler = (ActivityTeamHandler)TeamManager.getActiveTeamHandlers().get(Long.valueOf(roleWorldId));
/* 39 */     if (handler == null) {
/* 40 */       return false;
/*    */     }
/*    */     
/* 43 */     switch (this.flushType) {
/*    */     case 1: 
/* 45 */       List<Long> teams = handler.findTeams(this.roleId, roleWorldId);
/* 46 */       new PSynTeamsInfo(this.roleId, teams).execute();
/* 47 */       break;
/*    */     
/*    */     case 2: 
/* 50 */       List<Long> roles = handler.findMembers(this.roleId, roleWorldId);
/* 51 */       new PSSynMembersInfo(this.roleId, roles).execute();
/* 52 */       break;
/*    */     
/*    */     default: 
/* 55 */       return false;
/*    */     }
/* 57 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   boolean checkCanRefresh()
/*    */   {
/* 65 */     ActivityTeamBean xActivityTeamBean = Role2activityteam.select(Long.valueOf(this.roleId));
/* 66 */     if (xActivityTeamBean != null)
/*    */     {
/* 68 */       return false;
/*    */     }
/*    */     
/* 71 */     Procedure.execute(new LogicProcedure()
/*    */     {
/*    */       protected boolean processImp() throws Exception
/*    */       {
/* 75 */         ActivityTeamBean xActivityTeamBean = Role2activityteam.get(Long.valueOf(PCFlushInActivityReq.this.roleId));
/* 76 */         RefreshListSession session = new RefreshListSession(PCFlushInActivityReq.this.roleId);
/* 77 */         xActivityTeamBean = Pod.newActivityTeamBean();
/* 78 */         xActivityTeamBean.setSessionid(session.getSessionId());
/*    */         
/* 80 */         Role2activityteam.insert(Long.valueOf(PCFlushInActivityReq.this.roleId), xActivityTeamBean);
/* 81 */         return true;
/*    */       }
/*    */       
/* 84 */     });
/* 85 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\team\activity\PCFlushInActivityReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */