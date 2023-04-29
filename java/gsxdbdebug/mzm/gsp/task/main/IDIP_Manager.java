/*     */ package mzm.gsp.task.main;
/*     */ 
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.GraphBean;
/*     */ import xbean.NodeBean;
/*     */ import xbean.TaskBean;
/*     */ import xbean.TaskDataBean;
/*     */ import xdb.Lockeys;
/*     */ import xtable.User;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class IDIP_Manager
/*     */ {
/*     */   static IDIP_ActivieGraphRes activeGraph(long roleId, int graphId)
/*     */   {
/*  24 */     IDIP_ActivieGraphRes res = new IDIP_ActivieGraphRes();
/*     */     
/*  26 */     Graph graph = GraphManager.getGraphById(graphId);
/*  27 */     if (graph == null)
/*     */     {
/*  29 */       String str = String.format("[task]IDIP_Manager.activeGraph@ graph cfg is null!|roleId=%d|graphId=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(graphId) });
/*     */       
/*  31 */       GameServer.logger().error(str);
/*  32 */       res.addTip(str);
/*  33 */       res.fillErrRes(IDIP_ActivieGraphRes.ActiveGraphErrReason.GRAPH_NULL);
/*  34 */       return res;
/*     */     }
/*     */     
/*  37 */     if (graph.isTeamGraph())
/*     */     {
/*  39 */       String str = String.format("[task]IDIP_Manager.activeGraph@ only single task!|roleId=%d|graphId=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(graphId) });
/*     */       
/*  41 */       GameServer.logger().error(str);
/*  42 */       res.addTip(str);
/*  43 */       res.fillErrRes(IDIP_ActivieGraphRes.ActiveGraphErrReason.GRAPH_NOT_SINGLE);
/*  44 */       return res;
/*     */     }
/*  46 */     if (!RoleInterface.isRoleExist(roleId, false))
/*     */     {
/*  48 */       String str = String.format("[task]IDIP_Manager.activeGraph@ role not exist!|roleId=%d|graphId=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(graphId) });
/*  49 */       GameServer.logger().error(str);
/*  50 */       res.addTip(str);
/*  51 */       res.fillErrRes(IDIP_ActivieGraphRes.ActiveGraphErrReason.ROLE_NOT_EXIST);
/*  52 */       return res;
/*     */     }
/*     */     
/*  55 */     String userId = RoleInterface.getUserId(roleId);
/*  56 */     Lockeys.lock(Lockeys.get(User.getTable(), userId));
/*     */     
/*  58 */     RoleTask roleTask = RoleTaskManager.getRoleTask(roleId, true);
/*  59 */     if (roleTask.getTaskDataBean() == null)
/*     */     {
/*  61 */       String str = String.format("[task]IDIP_Manager.activeGraph@ role's task DB data is null!|roleId=%d|graphId=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(graphId) });
/*     */       
/*  63 */       GameServer.logger().error(str);
/*  64 */       res.addTip(str);
/*  65 */       res.fillErrRes(IDIP_ActivieGraphRes.ActiveGraphErrReason.ROLE_TASK_DB_NULL);
/*  66 */       return res;
/*     */     }
/*  68 */     GraphBean xGraphBean = (GraphBean)roleTask.getTaskDataBean().getGraphbeans().get(Integer.valueOf(graphId));
/*  69 */     if (xGraphBean != null)
/*     */     {
/*  71 */       Map<Integer, TaskBean> xTaskBeans = xGraphBean.getNodebean().getTaskbeans();
/*  72 */       if ((xTaskBeans != null) && (xTaskBeans.size() > 0))
/*     */       {
/*  74 */         for (Map.Entry<Integer, TaskBean> entry : xTaskBeans.entrySet())
/*     */         {
/*  76 */           int taskId = ((Integer)entry.getKey()).intValue();
/*  77 */           int taskState = ((TaskBean)entry.getValue()).getTaskstate();
/*  78 */           switch (taskState)
/*     */           {
/*     */           case 1: 
/*  81 */             String str_0 = String.format("[task]IDIP_Manager.activeGraph@ task is can accept state!|roleId=%d|graphId=%d|taskId=%d|state=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(graphId), Integer.valueOf(taskId), Integer.valueOf(taskState) });
/*     */             
/*     */ 
/*  84 */             GameServer.logger().info(str_0);
/*  85 */             res.addTip(str_0);
/*  86 */             new AccpetTaskProcedure(roleId, graphId, taskId).execute();
/*  87 */             break;
/*     */           
/*     */           default: 
/*  90 */             String str_1 = String.format("[task]IDIP_Manager.activeGraph@ task's state is normal!|roleId=%d|graphId=%d|taskId=%d|state=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(graphId), Integer.valueOf(taskId), Integer.valueOf(taskState) });
/*     */             
/*     */ 
/*  93 */             GameServer.logger().info(str_1);
/*  94 */             res.addTip(str_1);
/*     */           }
/*     */           
/*     */         }
/*  98 */         res.fillSucRes();
/*  99 */         return res;
/*     */       }
/*     */       
/*     */ 
/* 103 */       if (graph.isRingTypeGraph())
/*     */       {
/*     */ 
/* 106 */         TaskInterface.goNextTask(roleId, graphId);
/* 107 */         res.fillSucRes();
/* 108 */         return res;
/*     */       }
/* 110 */       String str = String.format("[task]IDIP_Manager.activeGraph@ no task data in graph!|roleId=%d|graphId=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(graphId) });
/*     */       
/* 112 */       GameServer.logger().info(str);
/* 113 */       res.addTip(str);
/* 114 */       roleTask.getTaskDataBean().getGraphbeans().remove(Integer.valueOf(graphId));
/*     */     }
/*     */     
/*     */ 
/* 118 */     RoleTaskManager.activeGraph(graphId, roleId, roleTask, graph);
/* 119 */     String str = String.format("[task]IDIP_Manager.activeGraph@ no graph DB date, active new one!|roleId=%d|graphId=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(graphId) });
/*     */     
/* 121 */     GameServer.logger().info(str);
/* 122 */     res.addTip(str);
/* 123 */     res.fillSucRes();
/* 124 */     return res;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\task\main\IDIP_Manager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */