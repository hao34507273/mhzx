/*     */ package mzm.gsp.task.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.team.main.TeamInfo;
/*     */ import mzm.gsp.team.main.TeamInterface;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.GraphBean;
/*     */ import xbean.NodeBean;
/*     */ import xbean.TaskBean;
/*     */ import xdb.Procedure;
/*     */ import xtable.Basic;
/*     */ import xtable.Team;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PGoXNextTask extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long leaderId;
/*     */   private final int graphId;
/*     */   private final Set<Integer> taskIdSet;
/*     */   private boolean autoAccept;
/*     */   
/*     */   public PGoXNextTask(long roleId, int graphId, Set<Integer> taskIdSet, boolean autoAccept)
/*     */   {
/*  32 */     this.leaderId = roleId;
/*  33 */     this.graphId = graphId;
/*  34 */     this.taskIdSet = taskIdSet;
/*  35 */     this.autoAccept = autoAccept;
/*     */   }
/*     */   
/*  38 */   private static final Logger logger = Logger.getLogger(PGoXNextTask.class);
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  43 */     Graph graph = GraphManager.getGraphById(this.graphId);
/*  44 */     if (graph == null)
/*     */     {
/*  46 */       return false;
/*     */     }
/*  48 */     if (!graph.isRingTypeGraph())
/*     */     {
/*  50 */       return new PGoNextLineTask(this.leaderId, this.graphId).call();
/*     */     }
/*     */     
/*     */ 
/*  54 */     Set<Long> lockRoles = new HashSet();
/*  55 */     Long teamId = TeamInterface.getTeamidByRoleid(this.leaderId, false);
/*  56 */     if (teamId == null)
/*     */     {
/*     */ 
/*  59 */       String leaderUserId = RoleInterface.getUserId(this.leaderId);
/*  60 */       lock(xdb.Lockeys.get(User.getTable(), leaderUserId));
/*  61 */       lockRoles.add(Long.valueOf(this.leaderId));
/*  62 */       lock(Basic.getTable(), lockRoles);
/*     */     }
/*     */     else
/*     */     {
/*  66 */       List<Long> teamMemberList = TeamInterface.getTeamMemberList(teamId.longValue(), false);
/*  67 */       lockRoles.addAll(teamMemberList);
/*  68 */       List<String> userIds = new ArrayList();
/*  69 */       for (Iterator i$ = teamMemberList.iterator(); i$.hasNext();) { long tmpRoleId = ((Long)i$.next()).longValue();
/*     */         
/*  71 */         userIds.add(RoleInterface.getUserId(tmpRoleId));
/*     */       }
/*     */       
/*  74 */       lock(User.getTable(), userIds);
/*     */       
/*  76 */       lock(Basic.getTable(), lockRoles);
/*  77 */       lock(Team.getTable(), Arrays.asList(new Long[] { Long.valueOf(teamId.longValue()) }));
/*     */       
/*  79 */       if (!recheckAfterLock(teamId))
/*     */       {
/*  81 */         GameServer.logger().error(String.format("[task]PGoXNextTask.processImp@ recheck fail!|teamId=%d|leaderId=%d", new Object[] { teamId, Long.valueOf(this.leaderId) }));
/*     */         
/*  83 */         return false;
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*  89 */     RoleTask roleTask = RoleTaskManager.getRoleTask(this.leaderId, true);
/*  90 */     GraphBean graphBean = roleTask.getGraphBean(this.graphId);
/*  91 */     if (graphBean == null)
/*     */     {
/*     */ 
/*  94 */       if (graph.isTeamGraph())
/*     */       {
/*  96 */         List<Long> memeberList = TeamInterface.getTeamMemberList(TeamInterface.getTeamidByRoleid(this.leaderId, false).longValue(), false);
/*     */         
/*  98 */         if (((Long)memeberList.get(0)).longValue() != this.leaderId)
/*     */         {
/* 100 */           logger.error("GoNextTask@激活组队图图失败：图Id[" + this.graphId + "]--不是队长");
/* 101 */           return false;
/*     */         }
/* 103 */         if (!RoleTaskManager.activeTeamGraph(this.graphId, memeberList))
/*     */         {
/* 105 */           logger.error("GoNextTask@激活组队图失败：图Id[" + this.graphId + "]");
/* 106 */           return false;
/*     */         }
/* 108 */         graphBean = roleTask.getGraphBean(this.graphId);
/*     */       }
/*     */       else
/*     */       {
/* 112 */         graphBean = RoleTaskManager.activeGraph(this.graphId, this.leaderId);
/* 113 */         if (graphBean == null)
/*     */         {
/* 115 */           logger.error("GoNextTask@激活图失败：图Id[" + this.graphId + "]");
/* 116 */           return false;
/*     */         }
/*     */       }
/*     */     }
/* 120 */     Map<Integer, TaskBean> taskBeanMap = graphBean.getNodebean().getTaskbeans();
/* 121 */     if (taskBeanMap.size() > 1)
/*     */     {
/* 123 */       for (TaskBean taskBean : taskBeanMap.values())
/*     */       {
/* 125 */         RoleTaskManager.sendUpdateTaskState(this.leaderId, this.graphId, taskBean.getTaskid(), 4);
/*     */       }
/* 127 */       graphBean.getNodebean().getTaskbeans().clear();
/* 128 */       taskBeanMap = graphBean.getNodebean().getTaskbeans();
/*     */     }
/* 130 */     if (taskBeanMap.size() == 1)
/*     */     {
/* 132 */       for (TaskBean taskBean : graphBean.getNodebean().getTaskbeans().values())
/*     */       {
/* 134 */         if (taskBean.getTaskstate() != 1)
/*     */         {
/* 136 */           return false;
/*     */         }
/* 138 */         if ((this.taskIdSet.size() > 0) || (this.taskIdSet.contains(Integer.valueOf(taskBean.getTaskid()))))
/*     */         {
/* 140 */           RoleTaskManager.sendUpdateTaskState(this.leaderId, this.graphId, taskBean.getTaskid(), 4);
/* 141 */           graphBean.getNodebean().getTaskbeans().clear();
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 146 */     if (taskBeanMap.size() == 0)
/*     */     {
/* 148 */       RoleTaskManager.flushNewTask(this.leaderId, graphBean, graph, -1, this.taskIdSet);
/*     */     }
/* 150 */     ArrayList<TaskBean> taskBeansList = new ArrayList();
/* 151 */     for (TaskBean taskBean : graphBean.getNodebean().getTaskbeans().values())
/*     */     {
/* 153 */       if (taskBean.getTaskstate() == 1)
/*     */       {
/* 155 */         taskBeansList.add(taskBean);
/*     */       }
/*     */     }
/* 158 */     if (taskBeansList.size() != 1)
/*     */     {
/* 160 */       return false;
/*     */     }
/* 162 */     if (this.autoAccept)
/*     */     {
/* 164 */       Procedure.execute(new AccpetTaskProcedure(this.leaderId, this.graphId, ((TaskBean)taskBeansList.get(0)).getTaskid()));
/*     */     }
/* 166 */     return true;
/*     */   }
/*     */   
/*     */   private boolean recheckAfterLock(Long teamId)
/*     */   {
/* 171 */     if (teamId == null)
/*     */     {
/* 173 */       return false;
/*     */     }
/* 175 */     TeamInfo teamInfo = TeamInterface.getTeamInfo(teamId.longValue(), true);
/* 176 */     if (teamInfo == null)
/*     */     {
/* 178 */       GameServer.logger().error(String.format("[task]PGoXNextTask.recheckAfterLock@ team is null!|teamId=%d", new Object[] { teamId }));
/* 179 */       return false;
/*     */     }
/* 181 */     if (!teamInfo.getTeamMemberList().contains(Long.valueOf(this.leaderId)))
/*     */     {
/* 183 */       GameServer.logger().error(String.format("[task]PGoXNextTask.recheckAfterLock@ not in team!|teamId=%d|leaderId=%d", new Object[] { teamId, Long.valueOf(this.leaderId) }));
/*     */       
/* 185 */       return false;
/*     */     }
/* 187 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\task\main\PGoXNextTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */