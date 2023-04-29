/*     */ package mzm.gsp.task.main;
/*     */ 
/*     */ import java.util.Map;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.task.condition.ConditionEnum;
/*     */ import mzm.gsp.task.confbean.STaskContimeLimit;
/*     */ import mzm.gsp.team.main.TeamInterface;
/*     */ import mzm.gsp.timer.main.Session;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.ConBean;
/*     */ import xbean.TaskBean;
/*     */ import xdb.Lockeys;
/*     */ import xdb.Procedure;
/*     */ import xtable.User;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class TaskTimeLimitSession
/*     */   extends Session
/*     */ {
/*     */   private final int graphId;
/*     */   private final int taskId;
/*     */   private final STaskContimeLimit sTaskContimeLimit;
/*     */   
/*     */   public TaskTimeLimitSession(long interval, long roleId, int graphId, int taskId, STaskContimeLimit sTaskContimeLimit)
/*     */   {
/*  32 */     super(interval, roleId);
/*  33 */     this.graphId = graphId;
/*  34 */     this.taskId = taskId;
/*  35 */     this.sTaskContimeLimit = sTaskContimeLimit;
/*     */   }
/*     */   
/*     */ 
/*     */   protected void onTimeOut()
/*     */   {
/*  41 */     Procedure.execute(new updateTimeLimitTask(getOwerId()));
/*     */   }
/*     */   
/*     */   class updateTimeLimitTask extends LogicProcedure
/*     */   {
/*     */     private final long roleId;
/*     */     
/*     */     updateTimeLimitTask(long roleId)
/*     */     {
/*  50 */       this.roleId = roleId;
/*     */     }
/*     */     
/*     */ 
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/*  57 */       Lockeys.lock(Lockeys.get(User.getTable(), RoleInterface.getUserId(this.roleId)));
/*     */       
/*  59 */       RoleTask roleTask = RoleTaskManager.getRoleTask(this.roleId, true);
/*  60 */       TaskBean xTaskBean = roleTask.getTaskBean(TaskTimeLimitSession.this.graphId, TaskTimeLimitSession.this.taskId);
/*  61 */       if (xTaskBean == null)
/*     */       {
/*  63 */         GameServer.logger().error(String.format("[task]updateTimeLimitTask.processImp@ not have this task!|roleId=%d|graphId=%d|taskId=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(TaskTimeLimitSession.this.graphId), Integer.valueOf(TaskTimeLimitSession.this.taskId) }));
/*     */         
/*     */ 
/*     */ 
/*  67 */         return false;
/*     */       }
/*  69 */       if (xTaskBean.getTaskstate() != 2)
/*     */       {
/*  71 */         GameServer.logger().error(String.format("[task]updateTimeLimitTask.processImp@ not already accepted task!|roleId=%d|graphId=%d|taskId=%d|state=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(TaskTimeLimitSession.this.graphId), Integer.valueOf(TaskTimeLimitSession.this.taskId), Integer.valueOf(xTaskBean.getTaskstate()) }));
/*     */         
/*     */ 
/*     */ 
/*  75 */         return false;
/*     */       }
/*  77 */       ConBean xConBean = (ConBean)xTaskBean.getConmap().get(Integer.valueOf(TaskTimeLimitSession.this.sTaskContimeLimit.id));
/*  78 */       if (xConBean == null)
/*     */       {
/*  80 */         GameServer.logger().error(String.format("[task]updateTimeLimitTask.processImp@ not have this conBean!|roleId=%d|graphId=%d|taskId=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(TaskTimeLimitSession.this.graphId), Integer.valueOf(TaskTimeLimitSession.this.taskId) }));
/*     */         
/*     */ 
/*     */ 
/*  84 */         return false;
/*     */       }
/*     */       
/*  87 */       xConBean.getParammap().put(Integer.valueOf(ConditionEnum.CON_TIME_LIMIT_LEFT_TIME.getParamType()), Long.valueOf(0L));
/*  88 */       xConBean.getParammap().put(Integer.valueOf(ConditionEnum.CON_TIME_LIMIT_END_SESSIONID.getParamType()), Long.valueOf(0L));
/*  89 */       xConBean.getParammap().put(Integer.valueOf(ConditionEnum.CON_TIME_LIMIT_START_TIME.getParamType()), Long.valueOf(0L));
/*     */       
/*  91 */       if (TaskTimeLimitSession.this.sTaskContimeLimit.timeOutHandleTask == 2)
/*     */       {
/*  93 */         timeEndFailPro();
/*     */       }
/*  95 */       else if (TaskTimeLimitSession.this.sTaskContimeLimit.timeOutHandleTask == 1)
/*     */       {
/*  97 */         timeEndSucPro();
/*     */       }
/*  99 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     private void timeEndSucPro()
/*     */     {
/* 105 */       TaskInterface.updateTaskCondition(this.roleId, TaskTimeLimitSession.this.taskId, 12, new Object());
/*     */     }
/*     */     
/*     */     private void timeEndFailPro()
/*     */     {
/* 110 */       Graph graph = GraphManager.getGraphById(TaskTimeLimitSession.this.graphId);
/* 111 */       Task task = TaskManager.getTaskById(TaskTimeLimitSession.this.taskId);
/* 112 */       if (!graph.isTeamGraph())
/*     */       {
/* 114 */         RoleTaskManager.failNomalTask(this.roleId, graph, task, false);
/*     */       }
/* 116 */       if (TeamInterface.isRoleInTeam(this.roleId, false))
/*     */       {
/* 118 */         long teamLeaderId = TeamInterface.getTeamLeaderByRoleid(this.roleId, false, false);
/* 119 */         if (teamLeaderId == this.roleId)
/*     */         {
/* 121 */           RoleTaskManager.teamLeaderFailTask(this.roleId, graph, task, false);
/*     */         }
/*     */         else
/*     */         {
/* 125 */           RoleTaskManager.teamerFailTask(this.roleId, graph, task, false);
/*     */         }
/*     */         
/*     */       }
/*     */       else
/*     */       {
/* 131 */         RoleTaskManager.failNomalTask(this.roleId, graph, task, false);
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\task\main\TaskTimeLimitSession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */