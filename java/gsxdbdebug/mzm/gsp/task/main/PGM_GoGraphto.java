/*     */ package mzm.gsp.task.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.task.confbean.SGraph;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import xbean.GraphBean;
/*     */ import xbean.NodeBean;
/*     */ import xbean.TaskBean;
/*     */ import xdb.Lockeys;
/*     */ import xdb.Procedure;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PGM_GoGraphto extends LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final int graphId;
/*     */   private final int count;
/*     */   
/*     */   public PGM_GoGraphto(long roleId, int graphId, int count)
/*     */   {
/*  24 */     this.roleId = roleId;
/*  25 */     this.graphId = graphId;
/*  26 */     this.count = count;
/*     */   }
/*     */   
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  33 */     String userId = RoleInterface.getUserId(this.roleId);
/*  34 */     lock(Lockeys.get(User.getTable(), userId));
/*  35 */     RoleTask roleTask = RoleTaskManager.getRoleTask(this.roleId, true);
/*  36 */     GraphBean graphBean = roleTask.getGraphBean(this.graphId);
/*  37 */     Graph graph = GraphManager.getGraphById(this.graphId);
/*  38 */     if ((graphBean == null) || (graph == null))
/*     */     {
/*  40 */       return false;
/*     */     }
/*  42 */     int taskId = -1;
/*  43 */     int nodeId = -1;
/*  44 */     if (graph.getSgraph().isRingTypeGraph)
/*     */     {
/*     */ 
/*  47 */       if (graph.getAllTaskNum() < this.count)
/*     */       {
/*  49 */         return false;
/*     */       }
/*  51 */       List<Integer> nodeInfo = graph.getNodeInfoByTurn(this.count);
/*  52 */       nodeId = ((Integer)nodeInfo.get(0)).intValue();
/*  53 */       graphBean.getNodebean().setFinishcount(((Integer)nodeInfo.get(1)).intValue() - 1);
/*  54 */       int allFinishcount = this.count - 1;
/*  55 */       graphBean.setAllfinishcount(allFinishcount);
/*     */ 
/*     */     }
/*     */     else
/*     */     {
/*  60 */       List<Integer> nodeInfo = graph.getNodeInfoByTaskId(this.count);
/*  61 */       if ((nodeInfo == null) || (nodeInfo.size() == 0))
/*     */       {
/*  63 */         return false;
/*     */       }
/*  65 */       nodeId = ((Integer)nodeInfo.get(0)).intValue();
/*  66 */       graphBean.getNodebean().setFinishcount(0);
/*  67 */       graphBean.setAllfinishcount(((Integer)nodeInfo.get(1)).intValue());
/*  68 */       taskId = this.count;
/*     */     }
/*  70 */     if (nodeId < 0)
/*     */     {
/*  72 */       return false;
/*     */     }
/*  74 */     graphBean.getNodebean().setNodeid(nodeId);
/*  75 */     for (TaskBean taskBean : graphBean.getNodebean().getTaskbeans().values())
/*     */     {
/*  77 */       RoleTaskManager.sendUpdateTaskState(this.roleId, this.graphId, taskBean.getTaskid(), 4);
/*     */     }
/*  79 */     graphBean.getNodebean().getTaskbeans().clear();
/*     */     
/*     */ 
/*  82 */     if (taskId == -1)
/*     */     {
/*  84 */       RoleTaskManager.sendGraphCurRing(this.roleId, graphBean, 1, graph.getSgraph().isRingTypeGraph);
/*  85 */       return TaskInterface.goNextTask(this.roleId, this.graphId);
/*     */     }
/*     */     
/*     */ 
/*  89 */     Task task = TaskManager.getTaskById(taskId);
/*  90 */     if (task == null)
/*     */     {
/*  92 */       return false;
/*     */     }
/*  94 */     AcceptTaskCheckResult ret = task.iscanTake(this.roleId, new HashMap(), new HashMap(), this.graphId);
/*     */     
/*  96 */     if (ret.isCanTake())
/*     */     {
/*     */ 
/*  99 */       TaskBean taskBean = RoleTaskManager.createTaskBean(this.roleId, graphBean.getGraphid(), taskId, 1);
/*     */       
/*     */ 
/* 102 */       RoleTaskManager.sendUpdateTaskState(this.roleId, graphBean.getGraphid(), taskBean.getTaskid(), taskBean.getTaskstate());
/*     */       
/* 104 */       graphBean.getNodebean().getTaskbeans().put(Integer.valueOf(taskBean.getTaskid()), taskBean);
/* 105 */       Procedure.execute(new AccpetTaskProcedure(this.roleId, graphBean.getGraphid(), taskId));
/*     */     }
/* 107 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\task\main\PGM_GoGraphto.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */