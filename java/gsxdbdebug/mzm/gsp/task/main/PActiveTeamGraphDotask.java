/*     */ package mzm.gsp.task.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.team.main.TeamInterface;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import xbean.GraphBean;
/*     */ import xbean.NodeBean;
/*     */ import xbean.TaskBean;
/*     */ import xdb.Procedure;
/*     */ import xtable.Basic;
/*     */ 
/*     */ public class PActiveTeamGraphDotask extends LogicProcedure
/*     */ {
/*     */   private int graphId;
/*     */   private int taskId;
/*     */   private long teamLeaderId;
/*     */   
/*     */   public PActiveTeamGraphDotask(int graphId, int taskId, long teamLeaderId)
/*     */   {
/*  23 */     this.graphId = graphId;
/*  24 */     this.taskId = taskId;
/*  25 */     this.teamLeaderId = teamLeaderId;
/*     */   }
/*     */   
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  32 */     Graph graph = GraphManager.getGraphById(this.graphId);
/*  33 */     if (!graph.isTeamGraph())
/*     */     {
/*  35 */       return false;
/*     */     }
/*     */     
/*  38 */     List<Integer> nodeInfo = graph.getNodeInfoByTaskId(this.taskId);
/*  39 */     if ((nodeInfo == null) || (nodeInfo.size() == 0))
/*     */     {
/*  41 */       return false;
/*     */     }
/*  43 */     int nodeId = ((Integer)nodeInfo.get(0)).intValue();
/*     */     
/*  45 */     Long teamId = TeamInterface.getTeamidByRoleid(this.teamLeaderId, false);
/*  46 */     if (teamId == null)
/*     */     {
/*  48 */       return false;
/*     */     }
/*     */     
/*  51 */     List<Long> normalMemberList = TeamInterface.getNormalRoleList(this.teamLeaderId);
/*  52 */     if (normalMemberList.size() == 0)
/*     */     {
/*  54 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  58 */     if (((Long)normalMemberList.get(0)).longValue() != this.teamLeaderId)
/*     */     {
/*  60 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  64 */     lock(Basic.getTable(), normalMemberList);
/*     */     
/*     */ 
/*  67 */     for (Iterator i$ = normalMemberList.iterator(); i$.hasNext();) { long memberId = ((Long)i$.next()).longValue();
/*     */       
/*     */ 
/*  70 */       RoleTask roleTask = RoleTaskManager.getRoleTask(memberId, true);
/*  71 */       GraphBean graphBean = roleTask.getGraphBean(this.graphId);
/*  72 */       if (graphBean == null)
/*     */       {
/*  74 */         graphBean = RoleTaskManager.activeGraph(this.graphId, memberId);
/*  75 */         if (graphBean == null) {}
/*     */ 
/*     */       }
/*     */       else
/*     */       {
/*     */ 
/*  81 */         graphBean.getNodebean().setNodeid(nodeId);
/*     */       }
/*     */     }
/*  84 */     RoleTask roleTask = RoleTaskManager.getRoleTask(this.teamLeaderId, true);
/*  85 */     GraphBean graphBean = roleTask.getGraphBean(this.graphId);
/*     */     
/*  87 */     Task task = TaskManager.getTaskById(this.taskId);
/*  88 */     if (task == null)
/*     */     {
/*  90 */       return false;
/*     */     }
/*  92 */     AcceptTaskCheckResult ret = task.iscanTake(this.teamLeaderId, new HashMap(), new HashMap(), this.graphId);
/*     */     
/*  94 */     if (ret.isCanTake())
/*     */     {
/*     */ 
/*     */ 
/*  98 */       TaskBean taskBean = RoleTaskManager.createTaskBean(this.teamLeaderId, graphBean.getGraphid(), this.taskId, 1);
/*     */       
/*     */ 
/* 101 */       RoleTaskManager.sendUpdateTaskState(this.teamLeaderId, graphBean.getGraphid(), taskBean.getTaskid(), taskBean.getTaskstate());
/*     */       
/*     */ 
/* 104 */       graphBean.getNodebean().getTaskbeans().put(Integer.valueOf(taskBean.getTaskid()), taskBean);
/* 105 */       Procedure.execute(new AccpetTaskProcedure(this.teamLeaderId, graphBean.getGraphid(), this.taskId));
/* 106 */       return true;
/*     */     }
/* 108 */     return false;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\task\main\PActiveTeamGraphDotask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */