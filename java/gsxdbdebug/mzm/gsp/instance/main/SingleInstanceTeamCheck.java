/*     */ package mzm.gsp.instance.main;
/*     */ 
/*     */ import mzm.gsp.instance.confbean.SInstanceCfg;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.team.main.JoinTeamCheckHandler;
/*     */ import mzm.gsp.team.main.JoinTeamResult;
/*     */ import mzm.gsp.team.main.JoinTeamResult.Receiver;
/*     */ import mzm.gsp.team.main.JoinTeamResult.Result;
/*     */ import mzm.gsp.team.main.JoinTeamType;
/*     */ import mzm.gsp.team.main.ReturnTeamResult;
/*     */ import mzm.gsp.team.main.ReturnTeamResult.Result;
/*     */ import mzm.gsp.team.main.TeamInfo;
/*     */ import xbean.InstanceCacheBean;
/*     */ import xtable.Instance;
/*     */ import xtable.Role2instanceuuid;
/*     */ 
/*     */ public class SingleInstanceTeamCheck
/*     */   implements JoinTeamCheckHandler
/*     */ {
/*     */   private boolean isRoleInSingleInstance(long leaderid)
/*     */   {
/*  22 */     Long instanceUuid = Role2instanceuuid.select(Long.valueOf(leaderid));
/*  23 */     if (instanceUuid != null) {
/*  24 */       InstanceCacheBean xInstanceCacheBean = Instance.select(instanceUuid);
/*  25 */       SInstanceCfg instanceCfg = SInstanceCfg.get(xInstanceCacheBean.getInstancecfgid());
/*  26 */       if (instanceCfg.instanceType == 1) {
/*  27 */         return true;
/*     */       }
/*     */     }
/*  30 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public JoinTeamResult canJoinTeam(TeamInfo teamInfo, long roleId, long leaderWorldId, long roleWorldId, boolean tf2LeaderAftJoin, JoinTeamType joinTeamType)
/*     */   {
/*  37 */     JoinTeamResult joinTeamResult = canJoinTeam(teamInfo, roleId, joinTeamType);
/*  38 */     return joinTeamResult;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private JoinTeamResult canJoinTeam(TeamInfo teamInfo, long roleId, JoinTeamType joinTeamType)
/*     */   {
/*  51 */     JoinTeamResult joinTeamResult = new JoinTeamResult();
/*  52 */     joinTeamResult.setSucceed(true);
/*  53 */     long leaderid = teamInfo.getLeaderId();
/*     */     
/*  55 */     boolean isInSingleInstance = isRoleInSingleInstance(leaderid);
/*  56 */     if (isInSingleInstance) {
/*  57 */       joinTeamResult.setSucceed(false);
/*     */       
/*  59 */       if (joinTeamType == JoinTeamType.JOIN_TEAM__APPLY)
/*     */       {
/*  61 */         JoinTeamResult.Result result = new JoinTeamResult.Result(101, new String[0]);
/*     */         
/*  63 */         joinTeamResult.addResult(JoinTeamResult.Receiver.Leader, result);
/*  64 */       } else if (joinTeamType == JoinTeamType.JOIN_TEAM__INVITE)
/*     */       {
/*  66 */         JoinTeamResult.Result result = new JoinTeamResult.Result(102, new String[0]);
/*     */         
/*  68 */         joinTeamResult.addResult(JoinTeamResult.Receiver.Member, result);
/*     */       }
/*     */     }
/*     */     
/*  72 */     boolean memberInSingleInstance = isRoleInSingleInstance(roleId);
/*  73 */     if (memberInSingleInstance) {
/*  74 */       joinTeamResult.setSucceed(false);
/*     */       
/*  76 */       if (joinTeamType == JoinTeamType.JOIN_TEAM__APPLY)
/*     */       {
/*  78 */         JoinTeamResult.Result result = new JoinTeamResult.Result(103, new String[] { RoleInterface.getName(roleId) });
/*     */         
/*  80 */         joinTeamResult.addResult(JoinTeamResult.Receiver.Leader, result);
/*  81 */       } else if (joinTeamType == JoinTeamType.JOIN_TEAM__INVITE)
/*     */       {
/*  83 */         JoinTeamResult.Result result = new JoinTeamResult.Result(101, new String[0]);
/*     */         
/*  85 */         joinTeamResult.addResult(JoinTeamResult.Receiver.Member, result);
/*     */       }
/*     */     }
/*     */     
/*  89 */     return joinTeamResult;
/*     */   }
/*     */   
/*     */   public ReturnTeamResult canReturnTeam(TeamInfo teamInfo, long roleId, long leaderWorldId, long roleWorldId)
/*     */   {
/*  94 */     ReturnTeamResult returnTeamResult = new ReturnTeamResult();
/*  95 */     returnTeamResult.setSucceed(true);
/*  96 */     if ((isRoleInSingleInstance(roleId)) || (isRoleInSingleInstance(teamInfo.getLeaderId()))) {
/*  97 */       returnTeamResult.setSucceed(false);
/*  98 */       returnTeamResult.setResult(new ReturnTeamResult.Result(107, new String[0]));
/*     */     }
/*     */     
/* 101 */     return returnTeamResult;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\instance\main\SingleInstanceTeamCheck.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */