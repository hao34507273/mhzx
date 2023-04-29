/*     */ package mzm.gsp.task.main;
/*     */ 
/*     */ import java.util.Collection;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.task.confbean.SGraph;
/*     */ import mzm.gsp.task.confbean.STask;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import xbean.GraphBean;
/*     */ import xbean.NodeBean;
/*     */ import xbean.TaskBean;
/*     */ import xdb.Lockeys;
/*     */ import xtable.User;
/*     */ 
/*     */ 
/*     */ public class PActiveFinishTask
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final int graphId;
/*     */   private final int taskId;
/*     */   
/*     */   public PActiveFinishTask(long roleId, int graphId, int taskId)
/*     */   {
/*  27 */     this.roleId = roleId;
/*  28 */     this.graphId = graphId;
/*  29 */     this.taskId = taskId;
/*     */   }
/*     */   
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  36 */     String userId = RoleInterface.getUserId(this.roleId);
/*  37 */     lock(Lockeys.get(User.getTable(), userId));
/*     */     
/*     */ 
/*  40 */     RoleTask roleTask = RoleTaskManager.getRoleTask(this.roleId, true);
/*  41 */     if (roleTask == null)
/*     */     {
/*  43 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  47 */     GraphBean graphBean = roleTask.getGraphBean(this.graphId);
/*  48 */     if (graphBean == null)
/*     */     {
/*  50 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  54 */     Graph graph = GraphManager.getGraphById(this.graphId);
/*  55 */     if (graph == null)
/*     */     {
/*  57 */       return false;
/*     */     }
/*     */     
/*  60 */     TaskBean taskBean = null;
/*  61 */     Task task = null;
/*     */     
/*  63 */     if (this.taskId < 0)
/*     */     {
/*  65 */       Map<Integer, TaskBean> taskBeans = graphBean.getNodebean().getTaskbeans();
/*  66 */       if (taskBeans.size() != 1)
/*     */       {
/*  68 */         return false;
/*     */       }
/*  70 */       Iterator i$ = taskBeans.values().iterator(); if (i$.hasNext()) { TaskBean xTaskBean = (TaskBean)i$.next();
/*     */         
/*  72 */         taskBean = xTaskBean;
/*     */       }
/*     */       
/*  75 */       task = TaskManager.getTaskById(taskBean.getTaskid());
/*     */     }
/*     */     else
/*     */     {
/*  79 */       task = TaskManager.getTaskById(this.taskId);
/*  80 */       if (task == null)
/*     */       {
/*  82 */         return false;
/*     */       }
/*  84 */       taskBean = roleTask.getTaskBean(graph.getSgraph().id, this.taskId);
/*     */     }
/*  86 */     if (taskBean == null)
/*     */     {
/*  88 */       return false;
/*     */     }
/*  90 */     if (task == null)
/*     */     {
/*  92 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 103 */     if (taskBean.getTaskstate() != 3)
/*     */     {
/*     */ 
/* 106 */       RoleTaskManager.changeTaskState(this.roleId, 3, graphBean.getGraphid(), taskBean, 0);
/* 107 */       RoleTaskManager.sendUpdateTaskState(this.roleId, this.graphId, task.getStask().id, 3);
/*     */     }
/* 109 */     if (task.getStask().teamType == 3)
/*     */     {
/*     */ 
/* 112 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 116 */     return RoleTaskManager.finishSingleTask(this.roleId, taskBean, graphBean, new HashMap(), false);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\task\main\PActiveFinishTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */