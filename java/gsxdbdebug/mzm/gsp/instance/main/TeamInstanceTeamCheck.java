/*    */ package mzm.gsp.instance.main;
/*    */ 
/*    */ import mzm.gsp.instance.confbean.SInstanceCfg;
/*    */ import mzm.gsp.open.main.OpenInterface;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.team.main.JoinTeamCheckHandler;
/*    */ import mzm.gsp.team.main.JoinTeamResult;
/*    */ import mzm.gsp.team.main.JoinTeamResult.Receiver;
/*    */ import mzm.gsp.team.main.JoinTeamResult.Result;
/*    */ import mzm.gsp.team.main.JoinTeamType;
/*    */ import mzm.gsp.team.main.ReturnTeamResult;
/*    */ import mzm.gsp.team.main.TeamInfo;
/*    */ import xbean.InstanceCacheBean;
/*    */ import xtable.Instance;
/*    */ import xtable.Role2instanceuuid;
/*    */ 
/*    */ 
/*    */ public class TeamInstanceTeamCheck
/*    */   implements JoinTeamCheckHandler
/*    */ {
/*    */   private boolean isRoleInTeamInstance(long leaderid)
/*    */   {
/* 23 */     Long instanceUuid = Role2instanceuuid.select(Long.valueOf(leaderid));
/* 24 */     if (instanceUuid != null) {
/* 25 */       InstanceCacheBean xInstanceCacheBean = Instance.select(instanceUuid);
/* 26 */       SInstanceCfg instanceCfg = SInstanceCfg.get(xInstanceCacheBean.getInstancecfgid());
/* 27 */       if (instanceCfg.instanceType == 2) {
/* 28 */         return true;
/*    */       }
/*    */     }
/* 31 */     return false;
/*    */   }
/*    */   
/*    */ 
/*    */   public JoinTeamResult canJoinTeam(TeamInfo teamInfo, long roleId, long leaderWorldId, long roleWorldId, boolean tf2LeaderAftJoin, JoinTeamType joinTeamType)
/*    */   {
/* 37 */     JoinTeamResult joinTeamResult = new JoinTeamResult();
/* 38 */     joinTeamResult.setSucceed(true);
/* 39 */     long leaderid = teamInfo.getLeaderId();
/* 40 */     boolean isInTeamInstance = isRoleInTeamInstance(leaderid);
/* 41 */     boolean isInBan = (!OpenInterface.getOpenStatus(7)) || (OpenInterface.isBanPlay(leaderid, 7));
/*    */     
/* 43 */     if ((isInTeamInstance) || (isInBan)) {
/* 44 */       joinTeamResult.setSucceed(false);
/* 45 */       if (joinTeamType == JoinTeamType.JOIN_TEAM__APPLY)
/*    */       {
/* 47 */         JoinTeamResult.Result result = new JoinTeamResult.Result(104, new String[0]);
/*    */         
/* 49 */         joinTeamResult.addResult(JoinTeamResult.Receiver.Leader, result);
/* 50 */       } else if (joinTeamType == JoinTeamType.JOIN_TEAM__INVITE)
/*    */       {
/* 52 */         JoinTeamResult.Result result = new JoinTeamResult.Result(105, new String[0]);
/*    */         
/* 54 */         joinTeamResult.addResult(JoinTeamResult.Receiver.Member, result);
/*    */       }
/*    */     }
/* 57 */     boolean memInTeamInstance = isRoleInTeamInstance(roleId);
/* 58 */     boolean isMemInBan = (!OpenInterface.getOpenStatus(7)) || (OpenInterface.isBanPlay(roleId, 7));
/*    */     
/* 60 */     if ((memInTeamInstance) || (isMemInBan)) {
/* 61 */       joinTeamResult.setSucceed(false);
/*    */       
/* 63 */       if (joinTeamType == JoinTeamType.JOIN_TEAM__APPLY)
/*    */       {
/* 65 */         JoinTeamResult.Result result = new JoinTeamResult.Result(106, new String[] { RoleInterface.getName(roleId) });
/*    */         
/* 67 */         joinTeamResult.addResult(JoinTeamResult.Receiver.Leader, result);
/* 68 */       } else if (joinTeamType == JoinTeamType.JOIN_TEAM__INVITE)
/*    */       {
/* 70 */         JoinTeamResult.Result result = new JoinTeamResult.Result(104, new String[0]);
/*    */         
/* 72 */         joinTeamResult.addResult(JoinTeamResult.Receiver.Member, result);
/*    */       }
/*    */     }
/* 75 */     return joinTeamResult;
/*    */   }
/*    */   
/*    */   public ReturnTeamResult canReturnTeam(TeamInfo teamInfo, long roleId, long leaderWorldId, long roleWorldId)
/*    */   {
/* 80 */     ReturnTeamResult returnTeamResult = new ReturnTeamResult();
/* 81 */     returnTeamResult.setSucceed(true);
/* 82 */     return returnTeamResult;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\instance\main\TeamInstanceTeamCheck.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */