/*     */ package mzm.gsp.multicommontask.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityJoinResult;
/*     */ import mzm.gsp.activity3.confbean.SMultiLineTaskCfg;
/*     */ import mzm.gsp.map.main.MapInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.task.main.TaskInterface;
/*     */ import mzm.gsp.team.main.TeamInfo;
/*     */ import mzm.gsp.team.main.TeamInterface;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Role2task;
/*     */ import xtable.User;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PCAcceptMultiLineTask
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final int activityId;
/*     */   
/*     */   public PCAcceptMultiLineTask(long roleId, int activityId)
/*     */   {
/*  31 */     this.roleId = roleId;
/*  32 */     this.activityId = activityId;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  38 */     SMultiLineTaskCfg cfg = SMultiLineTaskCfg.get(this.activityId);
/*  39 */     if (cfg == null)
/*     */     {
/*  41 */       return false;
/*     */     }
/*  43 */     if (!MultiTaskManager.isActivityValid(this.activityId, cfg.openId))
/*     */     {
/*  45 */       return false;
/*     */     }
/*     */     
/*  48 */     TeamInfo teamInfo = TeamInterface.getTeamInfoByRoleId(this.roleId);
/*  49 */     if (teamInfo == null)
/*     */     {
/*  51 */       return false;
/*     */     }
/*  53 */     if (!teamInfo.isTeamExist())
/*     */     {
/*  55 */       return false;
/*     */     }
/*  57 */     List<Long> normalMembers = teamInfo.getTeamNormalList();
/*     */     
/*  59 */     Map<Long, String> roleidToUserid = new HashMap();
/*  60 */     for (Iterator i$ = normalMembers.iterator(); i$.hasNext();) { long tmpRoleId = ((Long)i$.next()).longValue();
/*     */       
/*  62 */       roleidToUserid.put(Long.valueOf(tmpRoleId), RoleInterface.getUserId(tmpRoleId));
/*     */     }
/*     */     
/*  65 */     Lockeys.lock(User.getTable(), roleidToUserid.values());
/*     */     
/*  67 */     Lockeys.lock(Role2task.getTable(), normalMembers);
/*     */     
/*  69 */     teamInfo = TeamInterface.getTeamInfo(teamInfo.getTeamId(), true);
/*     */     
/*  71 */     if (!canActiveGraph(cfg, teamInfo, normalMembers, roleidToUserid))
/*     */     {
/*     */ 
/*  74 */       return false;
/*     */     }
/*  76 */     return activeGraph(cfg, getOpenTaskId(cfg.graphId));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean activeGraph(SMultiLineTaskCfg cfg, int taskId)
/*     */   {
/*  88 */     if (taskId < 0)
/*     */     {
/*  90 */       MultiTaskManager.loggerError("PCAcceptMultiLineTask.activeGraph@ taskid illegal!|roleId=%d|activityId=%d|graphId=%d ", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.activityId), Integer.valueOf(cfg.graphId) });
/*     */       
/*     */ 
/*  93 */       return false;
/*     */     }
/*     */     
/*  96 */     TaskInterface.acceptGraphXTask(this.roleId, cfg.graphId, taskId);
/*  97 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   private boolean canActiveGraph(SMultiLineTaskCfg cfg, TeamInfo teamInfo, List<Long> normalMembers, Map<Long, String> roleidToUserid)
/*     */   {
/* 103 */     if (!checkAfterLock(teamInfo, normalMembers))
/*     */     {
/*     */ 
/* 106 */       MultiTaskManager.loggerError("PCAcceptMultiLineTask.canActiveGraph@ recheck lock err!|roleId=%d|activityId=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.activityId) });
/*     */       
/* 108 */       return false;
/*     */     }
/*     */     
/* 111 */     ActivityJoinResult res = ActivityInterface.canJoinAndCheckInitActivityData(roleidToUserid, normalMembers, this.activityId);
/* 112 */     if (!res.isCanJoin())
/*     */     {
/*     */ 
/* 115 */       MultiTaskManager.loggerError("PCAcceptMultiLineTask.canActiveGraph@ forbid join!|roleId=%d|activityId=%d|errcode=%d ", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.activityId), Integer.valueOf(res.getReasonValue()) });
/*     */       
/*     */ 
/* 118 */       return false;
/*     */     }
/*     */     
/* 121 */     if (!MapInterface.isNearByNPC(this.roleId, cfg.npcid))
/*     */     {
/*     */ 
/* 124 */       MultiTaskManager.loggerError("PCAcceptMultiLineTask.canActiveGraph@ not near by npc!|roleId=%d|activityId=%d|npcId=%d ", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.activityId), Integer.valueOf(cfg.npcid) });
/*     */       
/*     */ 
/* 127 */       return false;
/*     */     }
/*     */     
/* 130 */     if (TaskInterface.isHaveGraphId(this.roleId, cfg.graphId))
/*     */     {
/*     */ 
/* 133 */       MultiTaskManager.loggerError("PCAcceptMultiLineTask.canActiveGraph@ already has graph!!|roleId=%d|activityId=%d|graphId=%d ", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.activityId), Integer.valueOf(cfg.graphId) });
/*     */       
/*     */ 
/* 136 */       return false;
/*     */     }
/* 138 */     return true;
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
/* 150 */     if (teamInfo == null)
/*     */     {
/* 152 */       return false;
/*     */     }
/* 154 */     if (!teamInfo.isTeamExist())
/*     */     {
/* 156 */       return false;
/*     */     }
/* 158 */     if (!teamInfo.isLeader(this.roleId))
/*     */     {
/* 160 */       return false;
/*     */     }
/* 162 */     List<Long> tmpMembers = teamInfo.getTeamNormalList();
/* 163 */     if (normalMembers.size() != tmpMembers.size())
/*     */     {
/* 165 */       return false;
/*     */     }
/* 167 */     if (!normalMembers.containsAll(tmpMembers))
/*     */     {
/* 169 */       return false;
/*     */     }
/* 171 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private int getOpenTaskId(int graphId)
/*     */   {
/* 182 */     return TaskInterface.getFristTaskId(graphId);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\multicommontask\main\PCAcceptMultiLineTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */