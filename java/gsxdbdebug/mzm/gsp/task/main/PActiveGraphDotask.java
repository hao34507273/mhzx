/*     */ package mzm.gsp.task.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.task.confbean.SGraph;
/*     */ import mzm.gsp.team.main.TeamInterface;
/*     */ import xbean.GraphBean;
/*     */ import xbean.NodeBean;
/*     */ import xbean.TaskBean;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Basic;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PActiveGraphDotask extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private int graphId;
/*     */   private int taskId;
/*     */   private long teamLeaderId;
/*     */   
/*     */   public PActiveGraphDotask(int graphId, int taskId, long teamLeaderId)
/*     */   {
/*  26 */     this.graphId = graphId;
/*  27 */     this.taskId = taskId;
/*  28 */     this.teamLeaderId = teamLeaderId;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  34 */     Graph graph = GraphManager.getGraphById(this.graphId);
/*  35 */     boolean isRingTypeGraph = graph.getSgraph().isRingTypeGraph;
/*  36 */     if (isRingTypeGraph)
/*     */     {
/*  38 */       PGM_AcceptTask p = new PGM_AcceptTask(this.teamLeaderId, this.graphId, this.taskId);
/*  39 */       return p.call();
/*     */     }
/*  41 */     List<Integer> nodeInfo = graph.getNodeInfoByTaskId(this.taskId);
/*  42 */     if ((nodeInfo == null) || (nodeInfo.size() == 0))
/*     */     {
/*  44 */       return false;
/*     */     }
/*  46 */     int nodeId = ((Integer)nodeInfo.get(0)).intValue();
/*     */     Iterator i$;
/*  48 */     if (graph.isTeamGraph())
/*     */     {
/*  50 */       Long teamId = TeamInterface.getTeamidByRoleid(this.teamLeaderId, false);
/*  51 */       if (teamId == null)
/*     */       {
/*  53 */         return false;
/*     */       }
/*     */       
/*  56 */       List<Long> normalMemberList = TeamInterface.getNormalRoleList(this.teamLeaderId);
/*  57 */       if (normalMemberList.size() == 0)
/*     */       {
/*  59 */         return false;
/*     */       }
/*     */       
/*     */ 
/*  63 */       if (((Long)normalMemberList.get(0)).longValue() != this.teamLeaderId)
/*     */       {
/*  65 */         return false;
/*     */       }
/*     */       
/*  68 */       List<String> userIds = new ArrayList();
/*  69 */       for (Iterator i$ = normalMemberList.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*     */         
/*  71 */         userIds.add(RoleInterface.getUserId(roleId));
/*     */       }
/*     */       
/*  74 */       Lockeys.lock(User.getTable(), userIds);
/*     */       
/*  76 */       lock(Basic.getTable(), normalMemberList);
/*     */       
/*     */ 
/*  79 */       for (i$ = normalMemberList.iterator(); i$.hasNext();) { long memberId = ((Long)i$.next()).longValue();
/*     */         
/*  81 */         activeGraph(nodeId, memberId);
/*     */       }
/*     */       
/*     */     }
/*     */     else
/*     */     {
/*  87 */       String leaderUserId = RoleInterface.getUserId(this.teamLeaderId);
/*  88 */       lock(Lockeys.get(User.getTable(), leaderUserId));
/*     */       
/*  90 */       lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.teamLeaderId) }));
/*  91 */       if (!activeGraph(nodeId, this.teamLeaderId))
/*     */       {
/*  93 */         return false;
/*     */       }
/*     */     }
/*     */     
/*  97 */     RoleTask roleTask = RoleTaskManager.getRoleTask(this.teamLeaderId, true);
/*  98 */     GraphBean graphBean = roleTask.getGraphBean(this.graphId);
/*     */     
/* 100 */     Task task = TaskManager.getTaskById(this.taskId);
/* 101 */     if (task == null)
/*     */     {
/* 103 */       return false;
/*     */     }
/* 105 */     AcceptTaskCheckResult ret = task.iscanTake(this.teamLeaderId, new HashMap(), new HashMap(), this.graphId);
/*     */     
/* 107 */     if (ret.isCanTake())
/*     */     {
/*     */ 
/*     */ 
/* 111 */       TaskBean taskBean = RoleTaskManager.createTaskBean(this.teamLeaderId, graphBean.getGraphid(), this.taskId, 1);
/*     */       
/*     */ 
/* 114 */       RoleTaskManager.sendUpdateTaskState(this.teamLeaderId, graphBean.getGraphid(), taskBean.getTaskid(), taskBean.getTaskstate());
/*     */       
/*     */ 
/* 117 */       graphBean.getNodebean().getTaskbeans().put(Integer.valueOf(taskBean.getTaskid()), taskBean);
/* 118 */       xdb.Procedure.execute(new AccpetTaskProcedure(this.teamLeaderId, graphBean.getGraphid(), this.taskId));
/* 119 */       return true;
/*     */     }
/* 121 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   boolean activeGraph(int nodeId, long roleId)
/*     */   {
/* 133 */     RoleTask roleTask = RoleTaskManager.getRoleTask(roleId, true);
/* 134 */     GraphBean graphBean = roleTask.getGraphBean(this.graphId);
/* 135 */     if (graphBean == null)
/*     */     {
/* 137 */       graphBean = RoleTaskManager.activeGraph(this.graphId, roleId);
/*     */     }
/* 139 */     if (graphBean == null)
/*     */     {
/* 141 */       return false;
/*     */     }
/* 143 */     graphBean.getNodebean().setNodeid(nodeId);
/* 144 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\task\main\PActiveGraphDotask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */