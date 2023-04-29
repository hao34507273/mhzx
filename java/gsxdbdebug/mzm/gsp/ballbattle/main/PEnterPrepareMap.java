/*     */ package mzm.gsp.ballbattle.main;
/*     */ 
/*     */ import java.util.Collections;
/*     */ import java.util.List;
/*     */ import mzm.gsp.ballbattle.SEnterPrepareMapFail;
/*     */ import mzm.gsp.ballbattle.SEnterPrepareMapSuccess;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.team.main.TeamInfo;
/*     */ import mzm.gsp.team.main.TeamInterface;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import xtable.Basic;
/*     */ 
/*     */ 
/*     */ public class PEnterPrepareMap
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   
/*     */   private PEnterPrepareMap(long roleId)
/*     */   {
/*  21 */     this.roleId = roleId;
/*     */   }
/*     */   
/*     */   public static void schedule(long roleId)
/*     */   {
/*  26 */     BallBattleActivityManager.addTask(new PEnterPrepareMap(roleId));
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  32 */     if (!BallBattleActivityManager.isOpen())
/*     */     {
/*  34 */       return false;
/*     */     }
/*  36 */     if (BallBattleActivityManager.getActivityId() == 0)
/*     */     {
/*  38 */       onFail(1);
/*  39 */       BallBattleLogger.error(String.format("PEnterPrepareMap.processImp()@activity not initialized|roleid=%d", new Object[] { Long.valueOf(this.roleId) }));
/*  40 */       return false;
/*     */     }
/*     */     
/*  43 */     TeamInfo teamInfo = TeamInterface.getTeamInfoByRoleId(this.roleId);
/*  44 */     if (teamInfo == null)
/*     */     {
/*  46 */       return handleSinglePlayer();
/*     */     }
/*  48 */     if (teamInfo.getLeaderId() == this.roleId)
/*     */     {
/*  50 */       return handleTeamLeader(teamInfo);
/*     */     }
/*  52 */     if (!teamInfo.getTeamNormalList().contains(Long.valueOf(this.roleId)))
/*     */     {
/*  54 */       return handleTmpLeaveTeamMember();
/*     */     }
/*  56 */     onFail(3);
/*  57 */     BallBattleLogger.error(String.format("PEnterPrepareMap.processImp()@in team and not leader|roleid=%d", new Object[] { Long.valueOf(this.roleId) }));
/*  58 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean handleSinglePlayer()
/*     */   {
/*  67 */     Long teamId = TeamInterface.getTeamidByRoleid(this.roleId, true);
/*  68 */     if (teamId != null)
/*     */     {
/*  70 */       return false;
/*     */     }
/*  72 */     return handleEnterPrepareMapResult(BallBattleActivityManager.enterPrepareMap(this.roleId));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean handleTeamLeader(TeamInfo oldTeamInfo)
/*     */   {
/*  81 */     lock(Basic.getTable(), oldTeamInfo.getTeamNormalList());
/*  82 */     TeamInfo teamInfo = TeamInterface.getTeamInfoByRoleId(this.roleId);
/*  83 */     if (teamInfo == null)
/*     */     {
/*  85 */       return false;
/*     */     }
/*  87 */     if (teamInfo.getLeaderId() != this.roleId)
/*     */     {
/*  89 */       return false;
/*     */     }
/*  91 */     if (!teamInfo.getTeamNormalList().equals(oldTeamInfo.getTeamNormalList()))
/*     */     {
/*  93 */       return false;
/*     */     }
/*  95 */     return handleEnterPrepareMapResult(BallBattleActivityManager.enterPrepareMap(teamInfo.getTeamId(), teamInfo.getTeamNormalList()));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean handleTmpLeaveTeamMember()
/*     */   {
/* 105 */     lock(Basic.getTable(), Collections.singleton(Long.valueOf(this.roleId)));
/* 106 */     TeamInfo teamInfo = TeamInterface.getTeamInfoByRoleId(this.roleId);
/* 107 */     if (teamInfo == null)
/*     */     {
/* 109 */       return false;
/*     */     }
/* 111 */     if (teamInfo.getTeamNormalList().contains(Long.valueOf(this.roleId)))
/*     */     {
/* 113 */       return false;
/*     */     }
/* 115 */     return handleEnterPrepareMapResult(BallBattleActivityManager.enterPrepareMap(teamInfo.getTeamId(), Collections.singletonList(Long.valueOf(this.roleId))));
/*     */   }
/*     */   
/*     */ 
/*     */   private boolean handleEnterPrepareMapResult(BallBattleActivityManager.EnterPrepareMapResult result)
/*     */   {
/* 121 */     switch (result)
/*     */     {
/*     */ 
/*     */     case SUCCESS: 
/* 125 */       onSuccess();
/* 126 */       BallBattleLogger.info(String.format("PEnterPrepareMap.handleEnterPrepareMapResult()@success|roleid=%d", new Object[] { Long.valueOf(this.roleId) }));
/*     */       
/* 128 */       return true;
/*     */     
/*     */ 
/*     */     case ACTIVITY_IN_LAST_ROUND: 
/* 132 */       onFail(2);
/* 133 */       BallBattleLogger.error(String.format("PEnterPrepareMap.handleEnterPrepareMapResult()@activity about to end|roleid=%d", new Object[] { Long.valueOf(this.roleId) }));
/*     */       
/* 135 */       return false;
/*     */     
/*     */ 
/*     */     case CANNOT_PARTICIPATE: 
/* 139 */       BallBattleLogger.error(String.format("PEnterPrepareMap.handleEnterPrepareMapResult()@cannot participate|roleid=%d", new Object[] { Long.valueOf(this.roleId) }));
/*     */       
/* 141 */       return false;
/*     */     
/*     */ 
/*     */     case ROLE_STATUS_CONFLICT: 
/* 145 */       BallBattleLogger.error(String.format("PEnterPrepareMap.handleEnterPrepareMapResult()@status conflict|roleid=%d", new Object[] { Long.valueOf(this.roleId) }));
/*     */       
/* 147 */       return false;
/*     */     
/*     */ 
/*     */     case ALREADY_IN_PREPARE_MAP: 
/* 151 */       BallBattleLogger.error(String.format("PEnterPrepareMap.handleEnterPrepareMapResult()@already in prepare map|roleid=%d", new Object[] { Long.valueOf(this.roleId) }));
/*     */       
/* 153 */       return false;
/*     */     }
/*     */     
/*     */     
/* 157 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private void onSuccess()
/*     */   {
/* 164 */     SEnterPrepareMapSuccess success = new SEnterPrepareMapSuccess();
/* 165 */     OnlineManager.getInstance().send(this.roleId, success);
/*     */   }
/*     */   
/*     */   private void onFail(int reason)
/*     */   {
/* 170 */     SEnterPrepareMapFail fail = new SEnterPrepareMapFail();
/* 171 */     fail.reason = reason;
/* 172 */     OnlineManager.getInstance().sendAtOnce(this.roleId, fail);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\ballbattle\main\PEnterPrepareMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */