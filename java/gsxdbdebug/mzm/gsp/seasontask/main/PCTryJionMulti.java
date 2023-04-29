/*     */ package mzm.gsp.seasontask.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityJoinResult;
/*     */ import mzm.gsp.map.main.MapInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.task.main.TaskInterface;
/*     */ import mzm.gsp.team.main.TeamInfo;
/*     */ import mzm.gsp.team.main.TeamInterface;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Role2task;
/*     */ import xtable.User;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PCTryJionMulti
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   
/*     */   public PCTryJionMulti(long roleId)
/*     */   {
/*  32 */     this.roleId = roleId;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  38 */     if (!SummerTaskManager.isMultiOpen(this.roleId))
/*     */     {
/*  40 */       return false;
/*     */     }
/*     */     
/*  43 */     TeamInfo teamInfo = TeamInterface.getTeamInfoByRoleId(this.roleId);
/*  44 */     if (teamInfo == null)
/*     */     {
/*  46 */       return false;
/*     */     }
/*  48 */     if (!teamInfo.isTeamExist())
/*     */     {
/*  50 */       return false;
/*     */     }
/*     */     
/*  53 */     List<Long> normalMembers = teamInfo.getTeamNormalList();
/*     */     
/*  55 */     Map<Long, String> roleidToUserid = new HashMap();
/*  56 */     for (Iterator i$ = normalMembers.iterator(); i$.hasNext();) { long tmpRoleId = ((Long)i$.next()).longValue();
/*     */       
/*  58 */       roleidToUserid.put(Long.valueOf(tmpRoleId), RoleInterface.getUserId(tmpRoleId));
/*     */     }
/*     */     
/*  61 */     Lockeys.lock(User.getTable(), roleidToUserid.values());
/*     */     
/*  63 */     Lockeys.lock(Role2task.getTable(), normalMembers);
/*     */     
/*  65 */     teamInfo = TeamInterface.getTeamInfo(teamInfo.getTeamId(), true);
/*     */     
/*  67 */     if (!checkAfterLock(teamInfo, normalMembers))
/*     */     {
/*  69 */       return false;
/*     */     }
/*     */     
/*  72 */     ActivityJoinResult res = ActivityInterface.canJoinAndCheckInitActivityData(roleidToUserid, normalMembers, SummerTaskManager.getMultiActivityId());
/*     */     
/*  74 */     if (!res.isCanJoin())
/*     */     {
/*  76 */       GameServer.logger().error(String.format("[seasonTask]PCTryJionMulti.processImp@ forbid join!|roleId=%d|activityId=%d|errcode=%d ", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(SummerTaskManager.getMultiActivityId()), Integer.valueOf(res.getReasonValue()) }));
/*     */       
/*     */ 
/*  79 */       return false;
/*     */     }
/*     */     
/*  82 */     if (!MapInterface.isNearByNPC(this.roleId, SummerTaskManager.getMultiNpcId()))
/*     */     {
/*     */ 
/*  85 */       SummerTaskManager.sendNormalResult(this.roleId, 5, new String[0]);
/*  86 */       return false;
/*     */     }
/*     */     
/*  89 */     if (TaskInterface.isHaveGraphId(this.roleId, SummerTaskManager.getMultiGraph()))
/*     */     {
/*  91 */       GameServer.logger().error(String.format("[seasonTask]PCTryJionMulti.processImp@ already has graph!|roleId=%d", new Object[] { Long.valueOf(this.roleId) }));
/*     */       
/*  93 */       return false;
/*     */     }
/*     */     
/*  96 */     int taskId = getOpenTaskId();
/*  97 */     if (taskId < 0)
/*     */     {
/*  99 */       GameServer.logger().error(String.format("[seasontask]PCTryJionMulti.processImp@ taskid illegal!|graphId=%d", new Object[] { Integer.valueOf(SummerTaskManager.getMultiGraph()) }));
/*     */       
/*     */ 
/* 102 */       return false;
/*     */     }
/*     */     
/* 105 */     TaskInterface.acceptGraphXTask(this.roleId, SummerTaskManager.getMultiGraph(), taskId);
/*     */     
/* 107 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean checkAfterLock(TeamInfo teamInfo, List<Long> normalMembers)
/*     */   {
/* 119 */     if (teamInfo == null)
/*     */     {
/* 121 */       return false;
/*     */     }
/* 123 */     if (!teamInfo.isTeamExist())
/*     */     {
/* 125 */       return false;
/*     */     }
/* 127 */     if (!teamInfo.isLeader(this.roleId))
/*     */     {
/*     */ 
/* 130 */       SummerTaskManager.sendNormalResult(this.roleId, 1, new String[0]);
/* 131 */       return false;
/*     */     }
/* 133 */     List<Long> tmpMembers = teamInfo.getTeamNormalList();
/* 134 */     if (normalMembers.size() != tmpMembers.size())
/*     */     {
/* 136 */       return false;
/*     */     }
/* 138 */     if (!normalMembers.containsAll(tmpMembers))
/*     */     {
/* 140 */       return false;
/*     */     }
/*     */     
/* 143 */     if (normalMembers.size() < getNeedNum())
/*     */     {
/*     */ 
/* 146 */       SummerTaskManager.sendNormalResult(this.roleId, 2, new String[] { String.valueOf(getNeedNum()) });
/*     */       
/* 148 */       return false;
/*     */     }
/*     */     
/* 151 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   int getNeedNum()
/*     */   {
/* 161 */     return ActivityInterface.getPersonCountMin(SummerTaskManager.getMultiActivityId());
/*     */   }
/*     */   
/*     */   private int getOpenTaskId()
/*     */   {
/* 166 */     return TaskInterface.getFristTaskId(SummerTaskManager.getMultiGraph());
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\seasontask\main\PCTryJionMulti.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */