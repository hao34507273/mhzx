/*     */ package mzm.gsp.qmhw.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.map.main.MapInterface;
/*     */ import mzm.gsp.qmhw.confbean.SQMHWCfgConsts;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.team.main.ActivityTeamHandler;
/*     */ import mzm.gsp.team.main.JoinTeamCheckHandler;
/*     */ import mzm.gsp.team.main.JoinTeamResult;
/*     */ import mzm.gsp.team.main.JoinTeamResult.Receiver;
/*     */ import mzm.gsp.team.main.JoinTeamResult.Result;
/*     */ import mzm.gsp.team.main.JoinTeamType;
/*     */ import mzm.gsp.team.main.ReturnTeamResult;
/*     */ import mzm.gsp.team.main.ReturnTeamResult.Result;
/*     */ import mzm.gsp.team.main.TeamInfo;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import xbean.QMHWActivity;
/*     */ import xdb.Procedure;
/*     */ import xtable.Qmhw;
/*     */ import xtable.Role2qmhw;
/*     */ import xtable.User;
/*     */ 
/*     */ class QMHWTeamHandler implements JoinTeamCheckHandler, ActivityTeamHandler
/*     */ {
/*     */   public JoinTeamResult canJoinTeam(TeamInfo teamInfo, final long roleId, long leaderWorldId, long roleWorldId, boolean tf2LeaderAftJoin, JoinTeamType joinTeamType)
/*     */   {
/*  34 */     JoinTeamResult joinTeamResult = new JoinTeamResult();
/*  35 */     joinTeamResult.setSucceed(true);
/*  36 */     QMHWActivity xQmhwActivity = Qmhw.select(Long.valueOf(GameServerInfoManager.getLocalId()));
/*  37 */     if (xQmhwActivity == null) {
/*  38 */       return joinTeamResult;
/*     */     }
/*  40 */     if (leaderWorldId != xQmhwActivity.getWorldid()) {
/*  41 */       return joinTeamResult;
/*     */     }
/*     */     
/*  44 */     if (ActivityInterface.isInActivityLevelByLevel(SQMHWCfgConsts.getInstance().ACTIVITY_ID, RoleInterface.getLevel(roleId)))
/*     */     {
/*  46 */       if (tf2LeaderAftJoin) {
/*  47 */         boolean ret = RoleStatusInterface.setStatus(roleId, 31, false);
/*  48 */         if (!ret) {
/*  49 */           joinTeamResult.setSucceed(false);
/*  50 */           if (joinTeamType == JoinTeamType.JOIN_TEAM__APPLY)
/*     */           {
/*  52 */             JoinTeamResult.Result result = new JoinTeamResult.Result(143, new String[0]);
/*     */             
/*  54 */             joinTeamResult.addResult(JoinTeamResult.Receiver.Leader, result);
/*  55 */           } else if (joinTeamType == JoinTeamType.JOIN_TEAM__INVITE)
/*     */           {
/*  57 */             JoinTeamResult.Result result = new JoinTeamResult.Result(144, new String[0]);
/*     */             
/*  59 */             joinTeamResult.addResult(JoinTeamResult.Receiver.Member, result);
/*     */           }
/*     */         }
/*     */         else {
/*  63 */           Procedure.execute(new LogicProcedure()
/*     */           {
/*     */             protected boolean processImp() throws Exception
/*     */             {
/*  67 */               Map<Long, String> role2user = new HashMap();
/*  68 */               role2user.put(Long.valueOf(roleId), RoleInterface.getUserId(roleId));
/*  69 */               lock(User.getTable(), role2user.values());
/*  70 */               lock(Role2qmhw.getTable(), role2user.keySet());
/*  71 */               ActivityInterface.canJoinAndCheckInitActivityData(role2user, Arrays.asList(new Long[] { Long.valueOf(roleId) }), SQMHWCfgConsts.getInstance().ACTIVITY_ID);
/*     */               
/*  73 */               return true;
/*     */             }
/*     */           });
/*     */         }
/*     */       }
/*     */       
/*  79 */       return joinTeamResult;
/*     */     }
/*  81 */     joinTeamResult.setSucceed(false);
/*  82 */     String levelMin = String.valueOf(ActivityInterface.getActivityLevelMin(SQMHWCfgConsts.getInstance().ACTIVITY_ID));
/*     */     
/*  84 */     if (joinTeamType == JoinTeamType.JOIN_TEAM__APPLY)
/*     */     {
/*  86 */       JoinTeamResult.Result result = new JoinTeamResult.Result(141, new String[] { levelMin });
/*     */       
/*  88 */       joinTeamResult.addResult(JoinTeamResult.Receiver.Leader, result);
/*  89 */     } else if (joinTeamType == JoinTeamType.JOIN_TEAM__INVITE)
/*     */     {
/*  91 */       JoinTeamResult.Result result = new JoinTeamResult.Result(142, new String[] { levelMin });
/*     */       
/*  93 */       joinTeamResult.addResult(JoinTeamResult.Receiver.Member, result);
/*     */     }
/*     */     
/*  96 */     return joinTeamResult;
/*     */   }
/*     */   
/*     */ 
/*     */   public ReturnTeamResult canReturnTeam(TeamInfo teamInfo, final long roleId, long leaderWorldId, long roleWorldId)
/*     */   {
/* 102 */     ReturnTeamResult returnTeamResult = new ReturnTeamResult();
/* 103 */     returnTeamResult.setSucceed(true);
/* 104 */     boolean isLeaderInQMHW = RoleStatusInterface.containsStatus(teamInfo.getLeaderId(), 31);
/* 105 */     if (isLeaderInQMHW) {
/* 106 */       if (!ActivityInterface.isInActivityLevelByLevel(SQMHWCfgConsts.getInstance().ACTIVITY_ID, RoleInterface.getLevel(roleId)))
/*     */       {
/* 108 */         returnTeamResult.setSucceed(false);
/* 109 */         String levelMin = String.valueOf(ActivityInterface.getActivityLevelMin(SQMHWCfgConsts.getInstance().ACTIVITY_ID));
/*     */         
/* 111 */         returnTeamResult.setResult(new ReturnTeamResult.Result(145, new String[] { levelMin }));
/*     */       }
/*     */       else {
/* 114 */         boolean ret = RoleStatusInterface.setStatus(roleId, 31, false);
/* 115 */         if (!ret) {
/* 116 */           returnTeamResult.setSucceed(false);
/* 117 */           returnTeamResult.setResult(new ReturnTeamResult.Result(142, new String[0]));
/*     */         }
/*     */         else
/*     */         {
/* 121 */           Procedure.execute(new LogicProcedure()
/*     */           {
/*     */             protected boolean processImp() throws Exception
/*     */             {
/* 125 */               Map<Long, String> role2user = new HashMap();
/* 126 */               role2user.put(Long.valueOf(roleId), RoleInterface.getUserId(roleId));
/* 127 */               lock(User.getTable(), role2user.values());
/* 128 */               lock(Role2qmhw.getTable(), role2user.keySet());
/* 129 */               ActivityInterface.canJoinAndCheckInitActivityData(role2user, Arrays.asList(new Long[] { Long.valueOf(roleId) }), SQMHWCfgConsts.getInstance().ACTIVITY_ID);
/*     */               
/* 131 */               return true;
/*     */             }
/*     */           });
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 138 */     return returnTeamResult;
/*     */   }
/*     */   
/*     */   public List<Long> findTeams(long roleId, long worldId)
/*     */   {
/* 143 */     QMHWActivity qmhwActivity = QMHWManager.getQmhwActivity(false);
/* 144 */     if (qmhwActivity == null) {
/* 145 */       return new ArrayList();
/*     */     }
/* 147 */     long worldid = qmhwActivity.getWorldid();
/* 148 */     if (worldId != worldid) {
/* 149 */       return new ArrayList();
/*     */     }
/* 151 */     return MapInterface.getAllTeamInWorld(worldId);
/*     */   }
/*     */   
/*     */   public List<Long> findMembers(long roleId, long worldId)
/*     */   {
/* 156 */     QMHWActivity qmhwActivity = QMHWManager.getQmhwActivity(false);
/* 157 */     if (qmhwActivity == null) {
/* 158 */       return new ArrayList();
/*     */     }
/* 160 */     long worldid = qmhwActivity.getWorldid();
/* 161 */     if (worldId != worldid) {
/* 162 */       return new ArrayList();
/*     */     }
/* 164 */     return MapInterface.getAllSingleRoleInWorld(worldid);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\qmhw\main\QMHWTeamHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */