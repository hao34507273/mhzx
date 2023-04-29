/*    */ package mzm.gsp.instance.main;
/*    */ 
/*    */ import java.util.List;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.confirm.main.TeamConfirmContext;
/*    */ import mzm.gsp.confirm.main.TeamConfirmHandler;
/*    */ import mzm.gsp.instance.SSynLeaderInstanceInfo;
/*    */ import mzm.gsp.map.main.MapInterface;
/*    */ import mzm.gsp.team.main.TeamInterface;
/*    */ import xio.Protocol;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class TeamInstanceConfirmHandler
/*    */   implements TeamConfirmHandler
/*    */ {
/*    */   public boolean afterAllAccepted(long teamId, int conformType, TeamConfirmContext context)
/*    */   {
/* 19 */     if (!(context instanceof TeamInstanceConfirmContext))
/*    */     {
/* 21 */       return false;
/*    */     }
/* 23 */     TeamInstanceConfirmContext teamInstanceConfirmContext = (TeamInstanceConfirmContext)context;
/* 24 */     List<Long> roleids = TeamInterface.getTeamMemberList(teamId, false);
/* 25 */     if (!TeamInstance.allAgreeRoleCheck(teamInstanceConfirmContext.getRoleids(), roleids, false))
/*    */     {
/* 27 */       return false;
/*    */     }
/* 29 */     Set<Integer> mapSet = InstanceCfgManager.getMapsByInstanceid(teamInstanceConfirmContext.getInstanceCfgid());
/* 30 */     MapInterface.createWorld(mapSet, new EnterInstanceCallBack(teamInstanceConfirmContext.getRoleids(), teamInstanceConfirmContext.getInstanceCfgid(), teamId));
/*    */     
/* 32 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */   public Protocol getConfirmProtocol(long teamId, int conformType, TeamConfirmContext context)
/*    */   {
/* 38 */     if (!(context instanceof TeamInstanceConfirmContext))
/*    */     {
/* 40 */       return null;
/*    */     }
/* 42 */     TeamInstanceConfirmContext teamInstanceConfirmContext = (TeamInstanceConfirmContext)context;
/* 43 */     SSynLeaderInstanceInfo protocol = new SSynLeaderInstanceInfo();
/* 44 */     protocol.teaminfo.instancecfgid = teamInstanceConfirmContext.getInstanceCfgid();
/* 45 */     protocol.teaminfo.toprocess = teamInstanceConfirmContext.getLeaderProcess();
/* 46 */     return protocol;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\instance\main\TeamInstanceConfirmHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */