/*     */ package mzm.gsp.seasontask.main;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.map.main.MapInterface;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.task.main.TaskInterface;
/*     */ import mzm.gsp.team.main.TeamInfo;
/*     */ import mzm.gsp.team.main.TeamInterface;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Basic;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCJoinMultiSeasonTaskReq extends LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   
/*     */   public PCJoinMultiSeasonTaskReq(long roleId)
/*     */   {
/*  26 */     this.roleId = roleId;
/*     */   }
/*     */   
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  31 */     if (!SummerTaskManager.isMultiOpen(this.roleId)) {
/*  32 */       return false;
/*     */     }
/*  34 */     TeamInfo teamInfo = TeamInterface.getTeamInfoByRoleId(this.roleId);
/*  35 */     int needNum = ActivityInterface.getPersonCountMin(SummerTaskManager.getMultiActivityId());
/*  36 */     if (teamInfo == null)
/*     */     {
/*  38 */       SummerTaskManager.sendNormalResult(this.roleId, 2, new String[] { String.valueOf(needNum) });
/*     */       
/*     */ 
/*  41 */       return false;
/*     */     }
/*     */     
/*  44 */     if (!teamInfo.isLeader(this.roleId))
/*     */     {
/*  46 */       SummerTaskManager.sendNormalResult(this.roleId, 1, new String[0]);
/*     */       
/*  48 */       return false;
/*     */     }
/*     */     
/*  51 */     List<Long> normaList = teamInfo.getTeamNormalList();
/*  52 */     if ((normaList == null) || (normaList.size() < needNum))
/*     */     {
/*  54 */       SummerTaskManager.sendNormalResult(this.roleId, 2, new String[] { String.valueOf(needNum) });
/*     */       
/*     */ 
/*  57 */       return false;
/*     */     }
/*     */     
/*  60 */     Map<Long, String> roleidToUserid = new HashMap();
/*  61 */     for (Iterator i$ = normaList.iterator(); i$.hasNext();) { long tmpRoleId = ((Long)i$.next()).longValue();
/*     */       
/*  63 */       roleidToUserid.put(Long.valueOf(tmpRoleId), RoleInterface.getUserId(tmpRoleId));
/*     */     }
/*     */     
/*  66 */     Lockeys.lock(User.getTable(), roleidToUserid.values());
/*     */     
/*  68 */     lock(Basic.getTable(), normaList);
/*  69 */     long teamId = teamInfo.getTeamId();
/*  70 */     teamInfo = TeamInterface.getTeamInfo(teamId, true);
/*  71 */     if (!checkTeamStable(teamInfo, normaList))
/*     */     {
/*  73 */       SummerTaskManager.sendNormalResult(this.roleId, 3, new String[0]);
/*     */       
/*  75 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  79 */     if (!canJoinMultiTask(this.roleId, normaList)) {
/*  80 */       return false;
/*     */     }
/*     */     
/*  83 */     if (!ActivityInterface.canJoinAndCheckInitActivityData(roleidToUserid, Arrays.asList(new Long[] { Long.valueOf(this.roleId) }), SummerTaskManager.getMultiActivityId()).isCanJoin()) {
/*  84 */       return false;
/*     */     }
/*     */     
/*  87 */     if (!MapInterface.isNearByNPC(this.roleId, SummerTaskManager.getMultiNpcId()))
/*     */     {
/*  89 */       SummerTaskManager.sendNormalResult(this.roleId, 5, new String[0]);
/*     */       
/*  91 */       return false;
/*     */     }
/*     */     
/*  94 */     if (TaskInterface.isHaveGraphId(this.roleId, SummerTaskManager.getMultiGraph())) {
/*  95 */       return false;
/*     */     }
/*     */     
/*  98 */     TaskInterface.acceptGraphXTask(this.roleId, SummerTaskManager.getMultiGraph(), getOpenTaskId());
/*     */     
/* 100 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   boolean canJoinMultiTask(long leaderId, List<Long> roleIds)
/*     */   {
/* 109 */     for (Iterator i$ = roleIds.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/* 110 */       if (!mzm.gsp.status.main.RoleStatusInterface.checkCanSetStatus(roleId, 227, true))
/*     */       {
/* 112 */         return false;
/*     */       }
/* 114 */       if (OpenInterface.isBanPlay(roleId, 20)) {
/* 115 */         OpenInterface.sendBanPlayMsg(leaderId, roleId, RoleInterface.getName(roleId), 20);
/* 116 */         return false;
/*     */       }
/*     */     }
/* 119 */     return true;
/*     */   }
/*     */   
/*     */   private boolean checkTeamStable(TeamInfo teamInfo, List<Long> normaList) {
/* 123 */     if (teamInfo == null) {
/* 124 */       return false;
/*     */     }
/* 126 */     if (!teamInfo.getTeamNormalList().containsAll(normaList)) {
/* 127 */       return false;
/*     */     }
/* 129 */     return true;
/*     */   }
/*     */   
/*     */   private int getOpenTaskId()
/*     */   {
/* 134 */     return 40000189;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\seasontask\main\PCJoinMultiSeasonTaskReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */