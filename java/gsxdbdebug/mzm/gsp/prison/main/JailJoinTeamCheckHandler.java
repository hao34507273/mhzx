/*     */ package mzm.gsp.prison.main;
/*     */ 
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.team.main.JoinTeamCheckHandler;
/*     */ import mzm.gsp.team.main.JoinTeamResult;
/*     */ import mzm.gsp.team.main.JoinTeamResult.Receiver;
/*     */ import mzm.gsp.team.main.JoinTeamResult.Result;
/*     */ import mzm.gsp.team.main.JoinTeamType;
/*     */ import mzm.gsp.team.main.ReturnTeamResult;
/*     */ import mzm.gsp.team.main.ReturnTeamResult.Result;
/*     */ import mzm.gsp.team.main.TeamInfo;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class JailJoinTeamCheckHandler
/*     */   implements JoinTeamCheckHandler
/*     */ {
/*     */   public JoinTeamResult canJoinTeam(TeamInfo teamInfo, long roleId, long leaderWorldId, long roleWorldId, boolean tf2LeaderAftJoin, JoinTeamType joinTeamType)
/*     */   {
/*  20 */     JoinTeamResult result = new JoinTeamResult();
/*  21 */     result.setSucceed(true);
/*     */     
/*  23 */     long jailWorldId = JailWorldManager.getInstance().getWorldId();
/*  24 */     long leaderId = teamInfo.getLeaderId();
/*  25 */     String leaderName = RoleInterface.getName(leaderId);
/*  26 */     String roleName = RoleInterface.getName(roleId);
/*  27 */     boolean isRoleInJail = PrisonInterface.isRoleInJail(roleId);
/*  28 */     boolean isLeaderInJail = PrisonInterface.isRoleInJail(leaderId);
/*     */     
/*  30 */     if (leaderWorldId != jailWorldId)
/*     */     {
/*  32 */       result.setSucceed(false);
/*     */       
/*  34 */       result.addResult(JoinTeamResult.Receiver.Leader, new JoinTeamResult.Result(8300, new String[0]));
/*     */       
/*     */ 
/*     */ 
/*  38 */       result.addResult(JoinTeamResult.Receiver.Member, new JoinTeamResult.Result(8301, new String[] { leaderName }));
/*     */     }
/*     */     
/*  41 */     if (!result.isSucceed())
/*     */     {
/*  43 */       return result;
/*     */     }
/*     */     
/*  46 */     if (roleWorldId != jailWorldId)
/*     */     {
/*  48 */       result.setSucceed(false);
/*     */       
/*     */ 
/*  51 */       result.addResult(JoinTeamResult.Receiver.Leader, new JoinTeamResult.Result(8301, new String[] { roleName }));
/*     */       
/*     */ 
/*     */ 
/*  55 */       result.addResult(JoinTeamResult.Receiver.Member, new JoinTeamResult.Result(8300, new String[0]));
/*     */     }
/*     */     
/*  58 */     if (!result.isSucceed())
/*     */     {
/*  60 */       return result;
/*     */     }
/*     */     
/*  63 */     if (isLeaderInJail != isRoleInJail)
/*     */     {
/*  65 */       result.setSucceed(false);
/*     */       
/*     */ 
/*  68 */       result.addResult(JoinTeamResult.Receiver.Leader, new JoinTeamResult.Result(8303, new String[] { roleName }));
/*     */       
/*     */ 
/*     */ 
/*  72 */       result.addResult(JoinTeamResult.Receiver.Member, new JoinTeamResult.Result(8303, new String[] { leaderName }));
/*     */     }
/*     */     
/*  75 */     if (!result.isSucceed())
/*     */     {
/*  77 */       return result;
/*     */     }
/*  79 */     return result;
/*     */   }
/*     */   
/*     */ 
/*     */   public ReturnTeamResult canReturnTeam(TeamInfo teamInfo, long roleId, long leaderWorldId, long roleWorldId)
/*     */   {
/*  85 */     ReturnTeamResult result = new ReturnTeamResult();
/*  86 */     result.setSucceed(false);
/*     */     
/*  88 */     long jailWorldId = JailWorldManager.getInstance().getWorldId();
/*  89 */     long leaderId = teamInfo.getLeaderId();
/*  90 */     String leaderName = RoleInterface.getName(leaderId);
/*     */     
/*  92 */     if (leaderWorldId != jailWorldId)
/*     */     {
/*  94 */       result.setResult(new ReturnTeamResult.Result(8301, new String[] { leaderName }));
/*     */       
/*  96 */       return result;
/*     */     }
/*     */     
/*  99 */     if (roleWorldId != jailWorldId)
/*     */     {
/* 101 */       result.setResult(new ReturnTeamResult.Result(8300, new String[0]));
/* 102 */       return result;
/*     */     }
/*     */     
/* 105 */     boolean isRoleInJail = PrisonInterface.isRoleInJail(roleId);
/* 106 */     boolean isLeaderInJail = PrisonInterface.isRoleInJail(teamInfo.getLeaderId());
/* 107 */     if (isLeaderInJail != isRoleInJail)
/*     */     {
/* 109 */       result.setResult(new ReturnTeamResult.Result(8302, new String[0]));
/* 110 */       return result;
/*     */     }
/* 112 */     result.setSucceed(true);
/* 113 */     return result;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\prison\main\JailJoinTeamCheckHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */