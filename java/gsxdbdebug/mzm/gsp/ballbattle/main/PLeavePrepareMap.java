/*     */ package mzm.gsp.ballbattle.main;
/*     */ 
/*     */ import java.util.Collections;
/*     */ import java.util.List;
/*     */ import mzm.gsp.ballbattle.SLeavePrepareMapFail;
/*     */ import mzm.gsp.ballbattle.SLeavePrepareMapSuccess;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.team.main.TeamInfo;
/*     */ import mzm.gsp.team.main.TeamInterface;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import xtable.Basic;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PLeavePrepareMap
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   
/*     */   private PLeavePrepareMap(long roleId)
/*     */   {
/*  23 */     this.roleId = roleId;
/*     */   }
/*     */   
/*     */   public static void schedule(long roleId)
/*     */   {
/*  28 */     BallBattleActivityManager.addTask(new PLeavePrepareMap(roleId));
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  34 */     if (!BallBattleActivityManager.isOpen())
/*     */     {
/*  36 */       return false;
/*     */     }
/*  38 */     if (BallBattleActivityManager.getActivityId() == 0)
/*     */     {
/*  40 */       return false;
/*     */     }
/*  42 */     if (!RoleStatusInterface.containsStatus(this.roleId, 2161))
/*     */     {
/*  44 */       onFail(1);
/*  45 */       BallBattleLogger.error(String.format("PLeavePrepareMap.processImp()@not in prepare map|roleid=%d", new Object[] { Long.valueOf(this.roleId) }));
/*  46 */       return false;
/*     */     }
/*     */     
/*  49 */     TeamInfo teamInfo = TeamInterface.getTeamInfoByRoleId(this.roleId);
/*  50 */     if (teamInfo == null)
/*     */     {
/*  52 */       return handleSinglePlayer();
/*     */     }
/*  54 */     if (teamInfo.getLeaderId() == this.roleId)
/*     */     {
/*  56 */       return handleTeamLeader(teamInfo);
/*     */     }
/*  58 */     if (!teamInfo.getTeamNormalList().contains(Long.valueOf(this.roleId)))
/*     */     {
/*  60 */       return handleTmpLeaveTeamMember();
/*     */     }
/*     */     
/*  63 */     onFail(2);
/*  64 */     BallBattleLogger.error(String.format("PLeavePrepareMap.processImp()@in team and not leader|roleid=%d", new Object[] { Long.valueOf(this.roleId) }));
/*  65 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean handleSinglePlayer()
/*     */   {
/*  74 */     Long teamId = TeamInterface.getTeamidByRoleid(this.roleId, true);
/*  75 */     if (teamId != null)
/*     */     {
/*  77 */       return false;
/*     */     }
/*  79 */     return handleLeavePrepareMapResult(BallBattleActivityManager.leavePrepareMap(this.roleId));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean handleTeamLeader(TeamInfo oldTeamInfo)
/*     */   {
/*  88 */     lock(Basic.getTable(), oldTeamInfo.getTeamNormalList());
/*  89 */     TeamInfo teamInfo = TeamInterface.getTeamInfoByRoleId(this.roleId);
/*  90 */     if (teamInfo == null)
/*     */     {
/*  92 */       return false;
/*     */     }
/*  94 */     if (teamInfo.getLeaderId() != this.roleId)
/*     */     {
/*  96 */       return false;
/*     */     }
/*  98 */     if (!teamInfo.getTeamNormalList().equals(oldTeamInfo.getTeamNormalList()))
/*     */     {
/* 100 */       return false;
/*     */     }
/* 102 */     return handleLeavePrepareMapResult(BallBattleActivityManager.leavePrepareMap(teamInfo.getTeamId(), teamInfo.getTeamNormalList()));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean handleTmpLeaveTeamMember()
/*     */   {
/* 112 */     lock(Basic.getTable(), Collections.singleton(Long.valueOf(this.roleId)));
/* 113 */     TeamInfo teamInfo = TeamInterface.getTeamInfoByRoleId(this.roleId);
/* 114 */     if (teamInfo == null)
/*     */     {
/* 116 */       return false;
/*     */     }
/* 118 */     if (teamInfo.getTeamNormalList().contains(Long.valueOf(this.roleId)))
/*     */     {
/* 120 */       return false;
/*     */     }
/* 122 */     return handleLeavePrepareMapResult(BallBattleActivityManager.leavePrepareMap(teamInfo.getTeamId(), Collections.singletonList(Long.valueOf(this.roleId))));
/*     */   }
/*     */   
/*     */ 
/*     */   private boolean handleLeavePrepareMapResult(BallBattleActivityManager.LeavePrepareMapResult result)
/*     */   {
/* 128 */     switch (result)
/*     */     {
/*     */ 
/*     */     case SUCCESS: 
/* 132 */       onSuccess();
/* 133 */       BallBattleLogger.info(String.format("PLeavePrepareMap.handleLeavePrepareMapResult()@success|roleid=%d", new Object[] { Long.valueOf(this.roleId) }));
/*     */       
/* 135 */       return true;
/*     */     
/*     */ 
/*     */     case NOT_IN_PREPARE_MAP: 
/* 139 */       onFail(1);
/* 140 */       BallBattleLogger.error(String.format("PLeavePrepareMap.handleLeavePrepareMapResult()@not in prepare map|roleid=%d", new Object[] { Long.valueOf(this.roleId) }));
/*     */       
/* 142 */       return false;
/*     */     }
/*     */     
/*     */     
/* 146 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private void onSuccess()
/*     */   {
/* 153 */     SLeavePrepareMapSuccess success = new SLeavePrepareMapSuccess();
/* 154 */     OnlineManager.getInstance().send(this.roleId, success);
/*     */   }
/*     */   
/*     */   private void onFail(int reason)
/*     */   {
/* 159 */     SLeavePrepareMapFail fail = new SLeavePrepareMapFail();
/* 160 */     fail.reason = reason;
/* 161 */     OnlineManager.getInstance().sendAtOnce(this.roleId, fail);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\ballbattle\main\PLeavePrepareMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */