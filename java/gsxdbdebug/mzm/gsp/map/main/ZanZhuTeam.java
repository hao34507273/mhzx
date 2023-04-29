/*    */ package mzm.gsp.map.main;
/*    */ 
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.team.main.JoinTeamCheckHandler;
/*    */ import mzm.gsp.team.main.JoinTeamResult;
/*    */ import mzm.gsp.team.main.JoinTeamResult.Receiver;
/*    */ import mzm.gsp.team.main.JoinTeamResult.Result;
/*    */ import mzm.gsp.team.main.JoinTeamType;
/*    */ import mzm.gsp.team.main.ReturnTeamResult;
/*    */ import mzm.gsp.team.main.ReturnTeamResult.Result;
/*    */ import mzm.gsp.team.main.TeamInfo;
/*    */ 
/*    */ public class ZanZhuTeam
/*    */   implements JoinTeamCheckHandler
/*    */ {
/*    */   public JoinTeamResult canJoinTeam(TeamInfo teamInfo, long roleId, long leaderWorldId, long roleWorldId, boolean tf2LeaderAftJoin, JoinTeamType joinTeamType)
/*    */   {
/* 18 */     JoinTeamResult result = new JoinTeamResult();
/* 19 */     result.setSucceed(true);
/* 20 */     long leaderId = teamInfo.getLeaderId();
/* 21 */     long leaderMapId = MapInterface.getRoleMapId(leaderId);
/* 22 */     int roleMapId = MapInterface.getRoleMapId(roleId);
/* 23 */     String leaderName = RoleInterface.getName(leaderId);
/* 24 */     String roleName = RoleInterface.getName(roleId);
/* 25 */     if (leaderWorldId != roleWorldId) {
/* 26 */       result.setSucceed(false);
/* 27 */       result.addResult(JoinTeamResult.Receiver.Leader, new JoinTeamResult.Result(8250, new String[] { roleName }));
/* 28 */       result.addResult(JoinTeamResult.Receiver.Member, new JoinTeamResult.Result(8251, new String[] { leaderName }));
/*    */     }
/* 30 */     if (!result.isSucceed()) {
/* 31 */       return result;
/*    */     }
/* 33 */     if (roleMapId != leaderMapId) {
/* 34 */       result.setSucceed(false);
/* 35 */       result.addResult(JoinTeamResult.Receiver.Leader, new JoinTeamResult.Result(8251, new String[] { roleName }));
/* 36 */       result.addResult(JoinTeamResult.Receiver.Member, new JoinTeamResult.Result(8250, new String[] { leaderName }));
/*    */     }
/*    */     
/* 39 */     if (!result.isSucceed()) {
/* 40 */       return result;
/*    */     }
/* 42 */     return !result.isSucceed() ? result : result;
/*    */   }
/*    */   
/*    */ 
/*    */   public ReturnTeamResult canReturnTeam(TeamInfo teamInfo, long roleId, long leaderWorldId, long roleWorldId)
/*    */   {
/* 48 */     ReturnTeamResult result = new ReturnTeamResult();
/* 49 */     result.setSucceed(false);
/* 50 */     long leaderId = teamInfo.getLeaderId();
/* 51 */     long leaderMapId = MapInterface.getRoleMapId(leaderId);
/* 52 */     int roleMapId = MapInterface.getRoleMapId(roleId);
/* 53 */     String leaderName = RoleInterface.getName(leaderId);
/* 54 */     String roleName = RoleInterface.getName(roleId);
/* 55 */     if (roleMapId != leaderMapId) {
/* 56 */       result.setResult(new ReturnTeamResult.Result(8250, new String[] { leaderName }));
/* 57 */       return result; }
/* 58 */     if (roleWorldId != leaderWorldId) {
/* 59 */       result.setResult(new ReturnTeamResult.Result(8251, new String[] { roleName }));
/* 60 */       return result;
/*    */     }
/* 62 */     result.setSucceed(true);
/* 63 */     return result;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\ZanZhuTeam.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */