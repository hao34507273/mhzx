/*    */ package mzm.gsp.feisheng.zhuxianjianzhen;
/*    */ 
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.status.main.RoleStatusInterface;
/*    */ import mzm.gsp.team.main.JoinTeamCheckHandler;
/*    */ import mzm.gsp.team.main.JoinTeamResult;
/*    */ import mzm.gsp.team.main.JoinTeamResult.Receiver;
/*    */ import mzm.gsp.team.main.JoinTeamResult.Result;
/*    */ import mzm.gsp.team.main.JoinTeamType;
/*    */ import mzm.gsp.team.main.ReturnTeamResult;
/*    */ import mzm.gsp.team.main.ReturnTeamResult.Result;
/*    */ import mzm.gsp.team.main.TeamInfo;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ZhuXianJianZhenJoinTeamCheckHandler
/*    */   implements JoinTeamCheckHandler
/*    */ {
/*    */   public JoinTeamResult canJoinTeam(TeamInfo teamInfo, long roleId, long leaderWorldId, long roleWorldId, boolean tf2LeaderAftJoin, JoinTeamType joinTeamType)
/*    */   {
/* 26 */     JoinTeamResult joinTeamResult = new JoinTeamResult();
/* 27 */     joinTeamResult.setSucceed(true);
/* 28 */     long leaderid = teamInfo.getLeaderId();
/* 29 */     if (RoleStatusInterface.containsStatus(leaderid, 959))
/*    */     {
/* 31 */       joinTeamResult.setSucceed(false);
/*    */       
/* 33 */       if (joinTeamType == JoinTeamType.JOIN_TEAM__APPLY)
/*    */       {
/*    */ 
/* 36 */         JoinTeamResult.Result result = new JoinTeamResult.Result(7000, new String[0]);
/*    */         
/* 38 */         joinTeamResult.addResult(JoinTeamResult.Receiver.Leader, result);
/*    */ 
/*    */       }
/* 41 */       else if (joinTeamType == JoinTeamType.JOIN_TEAM__INVITE)
/*    */       {
/*    */ 
/* 44 */         JoinTeamResult.Result result = new JoinTeamResult.Result(7001, new String[] { RoleInterface.getName(leaderid) });
/*    */         
/*    */ 
/* 47 */         joinTeamResult.addResult(JoinTeamResult.Receiver.Member, result);
/*    */       }
/*    */     }
/* 50 */     if (RoleStatusInterface.containsStatus(roleId, 959))
/*    */     {
/* 52 */       joinTeamResult.setSucceed(false);
/*    */       
/* 54 */       if (joinTeamType == JoinTeamType.JOIN_TEAM__APPLY)
/*    */       {
/*    */ 
/* 57 */         JoinTeamResult.Result result = new JoinTeamResult.Result(7001, new String[] { RoleInterface.getName(roleId) });
/*    */         
/*    */ 
/* 60 */         joinTeamResult.addResult(JoinTeamResult.Receiver.Leader, result);
/*    */ 
/*    */       }
/* 63 */       else if (joinTeamType == JoinTeamType.JOIN_TEAM__INVITE)
/*    */       {
/*    */ 
/* 66 */         JoinTeamResult.Result result = new JoinTeamResult.Result(7000, new String[0]);
/*    */         
/* 68 */         joinTeamResult.addResult(JoinTeamResult.Receiver.Member, result);
/*    */       }
/*    */     }
/* 71 */     return joinTeamResult;
/*    */   }
/*    */   
/*    */ 
/*    */   public ReturnTeamResult canReturnTeam(TeamInfo teamInfo, long roleId, long leaderWorldId, long roleWorldId)
/*    */   {
/* 77 */     ReturnTeamResult returnTeamResult = new ReturnTeamResult();
/* 78 */     returnTeamResult.setSucceed(true);
/* 79 */     long leaderid = teamInfo.getLeaderId();
/* 80 */     if (RoleStatusInterface.containsStatus(leaderid, 959))
/*    */     {
/* 82 */       returnTeamResult.setSucceed(false);
/*    */       
/* 84 */       ReturnTeamResult.Result result = new ReturnTeamResult.Result(7001, new String[] { RoleInterface.getName(leaderid) });
/*    */       
/*    */ 
/* 87 */       returnTeamResult.setResult(result);
/*    */     }
/* 89 */     if (RoleStatusInterface.containsStatus(roleId, 959))
/*    */     {
/* 91 */       returnTeamResult.setSucceed(false);
/*    */       
/*    */ 
/* 94 */       ReturnTeamResult.Result result = new ReturnTeamResult.Result(7000, new String[0]);
/*    */       
/* 96 */       returnTeamResult.setResult(result);
/*    */     }
/* 98 */     return returnTeamResult;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\feisheng\zhuxianjianzhen\ZhuXianJianZhenJoinTeamCheckHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */