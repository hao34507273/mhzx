/*     */ package mzm.gsp.task.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.fight.event.PVEFightEndArg;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.task.confbean.SGraph;
/*     */ import mzm.gsp.task.confbean.STask;
/*     */ import mzm.gsp.team.main.TeamInfo;
/*     */ import mzm.gsp.team.main.TeamInterface;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.GraphBean;
/*     */ import xbean.NodeBean;
/*     */ import xbean.TaskBean;
/*     */ import xdb.Lockeys;
/*     */ import xdb.Procedure;
/*     */ import xtable.Role2task;
/*     */ import xtable.Team;
/*     */ import xtable.User;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class TeamGraphManager
/*     */ {
/*  37 */   private static final Logger logger = Logger.getLogger(TeamGraphManager.class);
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean finishTeamGraphTask(List<Long> roleIds, Task task, Graph graph, Map<Integer, Object> operParamMap, PVEFightEndArg arg)
/*     */   {
/*  53 */     long teamLeaderId = ((Long)roleIds.get(0)).longValue();
/*  54 */     Long teamId = TeamInterface.getTeamidByRoleid(teamLeaderId, false);
/*  55 */     if (teamId == null)
/*     */     {
/*  57 */       return false;
/*     */     }
/*  59 */     long teamLeaderCheck = TeamInterface.getTeamLeaderByTeamid(teamId.longValue(), false);
/*     */     
/*  61 */     if (teamLeaderId != teamLeaderCheck)
/*     */     {
/*  63 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  67 */     RoleTask roleTask = RoleTaskManager.getRoleTask(teamLeaderId, true);
/*  68 */     GraphBean graphBean = roleTask.getGraphBean(graph.getSgraph().id);
/*  69 */     TaskBean taskBean = roleTask.getTaskBean(graph.getSgraph().id, task.getStask().id);
/*  70 */     List<Integer> teamTypeList = new ArrayList();
/*     */     
/*  72 */     teamTypeList.add(Integer.valueOf(3));
/*     */     
/*  74 */     if (!RoleTaskManager.innerFinishTask(teamLeaderId, taskBean, graphBean, teamTypeList, operParamMap, true))
/*     */     {
/*  76 */       return false;
/*     */     }
/*     */     
/*  79 */     afterFinishTeamTask(teamLeaderId, taskBean, graphBean, arg);
/*  80 */     boolean closed = false;
/*  81 */     graphBean = roleTask.getGraphBean(graph.getSgraph().id);
/*  82 */     if (graphBean == null)
/*     */     {
/*  84 */       closed = true;
/*     */     }
/*  86 */     return teamMemberFinishTask(task, graph, teamLeaderId, roleIds, closed, arg);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void copyTeamGraphTaskToRole(long roleId, GraphBean copyGraphBean)
/*     */   {
/*  97 */     RoleTask roleTask = RoleTaskManager.getRoleTask(roleId, true);
/*     */     
/*     */ 
/* 100 */     GraphBean graphBean = roleTask.getGraphBean(copyGraphBean.getGraphid());
/* 101 */     if (graphBean == null)
/*     */     {
/* 103 */       graphBean = RoleTaskManager.activeGraph(copyGraphBean.getGraphid(), roleId);
/*     */     }
/*     */     
/*     */ 
/* 107 */     graphBean.setAllfinishcount(copyGraphBean.getAllfinishcount());
/* 108 */     graphBean.getNodebean().setFinishcount(copyGraphBean.getNodebean().getFinishcount());
/* 109 */     graphBean.getNodebean().setNodeid(copyGraphBean.getNodebean().getNodeid());
/*     */     
/* 111 */     for (Map.Entry<Integer, TaskBean> entry : copyGraphBean.getNodebean().getTaskbeans().entrySet())
/*     */     {
/* 113 */       teamTaskCopyProc(roleId, copyGraphBean, graphBean, entry);
/*     */     }
/* 115 */     if (GraphManager.getGraphById(graphBean.getGraphid()).isRingTypeGraph())
/*     */     {
/* 117 */       RoleTaskManager.sendGraphCurRing(roleId, graphBean, 3, GraphManager.getGraphById(graphBean.getGraphid()).isRingTypeGraph());
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static void teamTaskCopyAll(long roleId, GraphBean copyGraphBean, GraphBean graphBean, Map.Entry<Integer, TaskBean> entry)
/*     */   {
/* 134 */     Task task = TaskManager.getTaskById(((TaskBean)entry.getValue()).getTaskid());
/* 135 */     TaskBean taskBean = RoleTaskManager.createTaskBean(roleId, graphBean.getGraphid(), task.getStask().id, ((TaskBean)entry.getValue()).getTaskstate());
/*     */     
/* 137 */     graphBean.getNodebean().getTaskbeans().put(Integer.valueOf(task.getStask().id), taskBean);
/* 138 */     RoleTaskManager.sendUpdateTaskState(roleId, copyGraphBean.getGraphid(), taskBean.getTaskid(), taskBean.getTaskstate());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static void teamTaskCopyProc(long roleId, GraphBean copyGraphBean, GraphBean graphBean, Map.Entry<Integer, TaskBean> entry)
/*     */   {
/* 152 */     Task task = TaskManager.getTaskById(((TaskBean)entry.getValue()).getTaskid());
/* 153 */     if (((TaskBean)entry.getValue()).getTaskstate() == 2)
/*     */     {
/*     */ 
/* 156 */       if (graphBean.getNodebean().getTaskbeans().containsKey(Integer.valueOf(task.getStask().id)))
/*     */       {
/* 158 */         TaskBean taskBean = (TaskBean)graphBean.getNodebean().getTaskbeans().get(Integer.valueOf(task.getStask().id));
/* 159 */         if (taskBean.getTaskstate() == 2)
/*     */         {
/* 161 */           return;
/*     */         }
/*     */       }
/* 164 */       AcceptTaskCheckResult acRet = task.iscanTake(roleId, new HashMap(), new HashMap(), copyGraphBean.getGraphid());
/*     */       
/* 166 */       if (acRet.isCanTake())
/*     */       {
/* 168 */         teamTaskCanTakeProc(roleId, copyGraphBean, graphBean, task);
/*     */       }
/*     */     }
/* 171 */     if (((TaskBean)entry.getValue()).getTaskstate() == 3)
/*     */     {
/* 173 */       if (graphBean.getNodebean().getTaskbeans().containsKey(Integer.valueOf(task.getStask().id)))
/*     */       {
/* 175 */         TaskBean taskBean = (TaskBean)graphBean.getNodebean().getTaskbeans().get(Integer.valueOf(task.getStask().id));
/* 176 */         if (taskBean.getTaskstate() == 3)
/*     */         {
/* 178 */           return;
/*     */         }
/*     */       }
/* 181 */       if (task.isCanFinish(roleId, new HashMap(), new HashMap(), copyGraphBean.getGraphid()))
/*     */       {
/*     */ 
/* 184 */         teamTaskCanFinishProc(roleId, copyGraphBean, graphBean, task);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static void teamTaskCanFinishProc(long roleId, GraphBean copyGraphBean, GraphBean graphBean, Task task)
/*     */   {
/* 199 */     TaskBean taskBean = RoleTaskManager.createTaskBean(roleId, graphBean.getGraphid(), task.getStask().id, 3);
/*     */     
/* 201 */     graphBean.getNodebean().getTaskbeans().put(Integer.valueOf(task.getStask().id), taskBean);
/* 202 */     RoleTaskManager.sendUpdateTaskState(roleId, copyGraphBean.getGraphid(), taskBean.getTaskid(), taskBean.getTaskstate());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static void teamTaskCanTakeProc(long roleId, GraphBean copyGraphBean, GraphBean graphBean, Task task)
/*     */   {
/* 215 */     TaskBean taskBean = RoleTaskManager.createTaskBean(roleId, graphBean.getGraphid(), task.getStask().id, 2);
/*     */     
/* 217 */     graphBean.getNodebean().getTaskbeans().put(Integer.valueOf(task.getStask().id), taskBean);
/* 218 */     RoleTaskManager.sendUpdateTaskState(roleId, copyGraphBean.getGraphid(), taskBean.getTaskid(), taskBean.getTaskstate());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean teamMemberFinishTask(Task task, Graph graph, long teamLeaderId, List<Long> teamMemberList, boolean closed, PVEFightEndArg arg)
/*     */   {
/* 234 */     for (Iterator i$ = teamMemberList.iterator(); i$.hasNext();) { long memberRoleId = ((Long)i$.next()).longValue();
/*     */       
/* 236 */       if ((memberRoleId != teamLeaderId) && 
/*     */       
/*     */ 
/*     */ 
/* 240 */         (TeamInterface.getTeamMemberStatus(memberRoleId) == 0))
/*     */       {
/*     */ 
/*     */ 
/* 244 */         RoleTask roleMemTask = RoleTaskManager.getRoleTask(memberRoleId, true);
/* 245 */         GraphBean graphMemBean = roleMemTask.getGraphBean(graph.getSgraph().id);
/* 246 */         TaskBean taskMemBean = roleMemTask.getTaskBean(graph.getSgraph().id, task.getStask().id);
/*     */         
/* 248 */         if (graphMemBean == null)
/*     */         {
/* 250 */           if (logger.isDebugEnabled())
/*     */           {
/* 252 */             logger.debug("[" + RoleInterface.getName(memberRoleId) + "]没有此图[" + graph.getSgraph().id + "]");
/*     */           }
/*     */           
/*     */         }
/* 256 */         else if (taskMemBean == null)
/*     */         {
/* 258 */           if (logger.isDebugEnabled())
/*     */           {
/* 260 */             logger.debug("[" + RoleInterface.getName(memberRoleId) + "]没有此任务[" + task.getStask().id + "]");
/*     */           }
/*     */         }
/*     */         else
/*     */         {
/* 265 */           List<Integer> teamTypeList2 = new ArrayList();
/* 266 */           teamTypeList2.add(Integer.valueOf(3));
/*     */           
/* 268 */           if (!RoleTaskManager.innerFinishTask(memberRoleId, taskMemBean, graphMemBean, teamTypeList2, new HashMap(), true))
/*     */           {
/*     */ 
/* 271 */             if (logger.isDebugEnabled())
/*     */             {
/* 273 */               logger.debug("队员没有完成任务:任务id:" + task.getStask().id + " 图id:" + graph.id());
/*     */             }
/*     */             
/*     */           }
/*     */           else
/* 278 */             afterTeamerFinishTeamGraphTask(memberRoleId, taskMemBean, graphMemBean, graph, closed, arg);
/*     */         }
/*     */       } }
/* 281 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void updateTeamTaskCon(List<Long> roleList, Map<Integer, Object> params, GraphBean graphBean, TaskBean taskBean, PVEFightEndArg arg)
/*     */   {
/* 295 */     Task task = TaskManager.getTaskById(taskBean.getTaskid());
/* 296 */     int originalState = taskBean.getTaskstate();
/* 297 */     Set<Integer> types = params.keySet();
/* 298 */     long leaderId = ((Long)roleList.get(0)).longValue();
/* 299 */     Iterator i$; Iterator i$; if ((taskBean.getTaskstate() == 6) || (taskBean.getTaskstate() == 7))
/*     */     {
/*     */ 
/* 302 */       for (i$ = types.iterator(); i$.hasNext();) { int type = ((Integer)i$.next()).intValue();
/*     */         
/* 304 */         if (task.containsCondition(type, 1))
/*     */         {
/*     */ 
/*     */ 
/* 308 */           AcceptTaskCheckResult acRet = task.iscanTake(leaderId, new HashMap(), new HashMap(), graphBean.getGraphid());
/*     */           
/* 310 */           if (acRet.isCanTake())
/*     */           {
/* 312 */             RoleTaskManager.changeTaskState(leaderId, 1, graphBean.getGraphid(), taskBean, 0);
/*     */             
/* 314 */             Graph graph = GraphManager.getGraphById(graphBean.getGraphid());
/* 315 */             if (graph.isAutoAcceptTask(graphBean))
/*     */             {
/* 317 */               Procedure.execute(new AccpetTaskProcedure(leaderId, graph.id(), taskBean.getTaskid())); }
/*     */           }
/*     */         }
/*     */       }
/*     */     } else {
/*     */       Iterator i$;
/* 323 */       if (taskBean.getTaskstate() == 2)
/*     */       {
/* 325 */         for (i$ = types.iterator(); i$.hasNext();) { int type = ((Integer)i$.next()).intValue();
/*     */           
/*     */ 
/* 328 */           if (task.containsCondition(type, 2))
/*     */           {
/*     */ 
/*     */ 
/* 332 */             if (task.isCanFinish(leaderId, taskBean.getConmap(), params, graphBean.getGraphid()))
/*     */             {
/* 334 */               RoleTaskManager.changeTaskState(leaderId, 3, graphBean.getGraphid(), taskBean, 0);
/*     */             }
/*     */           }
/*     */         }
/* 338 */       } else if (taskBean.getTaskstate() == 3)
/*     */       {
/* 340 */         for (i$ = types.iterator(); i$.hasNext();) { int type = ((Integer)i$.next()).intValue();
/*     */           
/*     */ 
/* 343 */           if (task.containsCondition(type, 2))
/*     */           {
/*     */ 
/*     */ 
/* 347 */             if (!task.isCanFinish(leaderId, taskBean.getConmap(), params, graphBean.getGraphid()))
/*     */             {
/* 349 */               RoleTaskManager.changeTaskState(leaderId, 2, graphBean.getGraphid(), taskBean, 0); }
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/* 354 */     if (originalState != taskBean.getTaskstate())
/*     */     {
/* 356 */       if (!teamerTaskStatePro(roleList, graphBean, taskBean, leaderId))
/*     */       {
/* 358 */         return;
/*     */       }
/*     */     }
/* 361 */     if (taskBean.getTaskstate() == 3)
/*     */     {
/* 363 */       if (task.getStask().autoFinish)
/*     */       {
/*     */ 
/* 366 */         finishTeamGraphTask(roleList, task, GraphManager.getGraphById(graphBean.getGraphid()), new HashMap(), arg);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static boolean teamerTaskStatePro(List<Long> roleList, GraphBean graphBean, TaskBean taskBean, long leaderId)
/*     */   {
/* 382 */     for (Iterator i$ = roleList.iterator(); i$.hasNext();) { roleId = ((Long)i$.next()).longValue();
/*     */       
/* 384 */       RoleTask roleTask = RoleTaskManager.getRoleTask(roleId, true);
/* 385 */       GraphBean graphBean_member = roleTask.getGraphBean(graphBean.getGraphid());
/* 386 */       if (graphBean_member == null)
/*     */       {
/* 388 */         if (logger.isDebugEnabled())
/*     */         {
/* 390 */           logger.debug("[" + RoleInterface.getName(roleId) + "]没有图[" + graphBean.getGraphid() + "]");
/*     */         }
/*     */       }
/*     */       else {
/* 394 */         taskStateLeader = taskBean.getTaskstate();
/* 395 */         for (TaskBean taskBean_member : graphBean_member.getNodebean().getTaskbeans().values())
/*     */         {
/* 397 */           if (taskBean_member.getTaskid() == taskBean.getTaskid())
/*     */           {
/*     */ 
/*     */ 
/* 401 */             if (roleId != leaderId)
/*     */             {
/* 403 */               int memeberState = taskBean_member.getTaskstate();
/* 404 */               if ((memeberState != 7) && (memeberState != 6))
/*     */               {
/*     */ 
/*     */ 
/* 408 */                 RoleTaskManager.changeTaskState(roleId, taskStateLeader, graphBean.getGraphid(), taskBean_member, 0); }
/*     */             } else {
/* 410 */               RoleTaskManager.sendUpdateTaskState(roleId, graphBean.getGraphid(), taskBean.getTaskid(), taskBean.getTaskstate());
/*     */             } } } } }
/*     */     long roleId;
/*     */     int taskStateLeader;
/* 414 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean teamerTryAcceptTask(long memberRoleId, GraphBean teamLeaderGraphBean, int taskId)
/*     */   {
/* 426 */     int graphId = teamLeaderGraphBean.getGraphid();
/* 427 */     RoleTask roleMemTask = RoleTaskManager.getRoleTask(memberRoleId, true);
/*     */     
/* 429 */     Graph graph = GraphManager.getGraphById(graphId);
/* 430 */     if (!graph.getSgraph().teamTaskGraph)
/*     */     {
/* 432 */       return false;
/*     */     }
/*     */     
/* 435 */     Task task = TaskManager.getTaskById(taskId);
/* 436 */     GraphBean graphMemBean = roleMemTask.getGraphBean(graphId);
/* 437 */     if (graphMemBean == null)
/*     */     {
/* 439 */       return true;
/*     */     }
/*     */     
/*     */ 
/* 443 */     for (TaskBean taskBean : graphMemBean.getNodebean().getTaskbeans().values())
/*     */     {
/* 445 */       RoleTaskManager.sendUpdateTaskState(memberRoleId, graphId, taskBean.getTaskid(), 4);
/*     */     }
/* 447 */     graphMemBean.getNodebean().getTaskbeans().clear();
/*     */     
/* 449 */     List<Integer> operTeamerList = new ArrayList();
/* 450 */     operTeamerList.add(Integer.valueOf(3));
/*     */     
/*     */ 
/*     */ 
/* 454 */     checkIsGraphScheduleSame(memberRoleId, teamLeaderGraphBean, graphMemBean);
/*     */     
/* 456 */     AcceptTaskCheckResult acRet = task.iscanTake(memberRoleId, new HashMap(), new HashMap(), graphId);
/*     */     
/* 458 */     if (acRet.isCanTake())
/*     */     {
/* 460 */       TaskBean newTaskMemBean = RoleTaskManager.createTaskBean(memberRoleId, graphMemBean.getGraphid(), taskId, 1);
/*     */       
/* 462 */       graphMemBean.getNodebean().getTaskbeans().put(Integer.valueOf(newTaskMemBean.getTaskid()), newTaskMemBean);
/*     */       
/* 464 */       if (graph.getSgraph().isRingTypeGraph)
/*     */       {
/* 466 */         if ((graphMemBean.getNodebean().getTaskbeans().size() == 1) && (graphMemBean.getAllfinishcount() == 0))
/*     */         {
/* 468 */           RoleTaskManager.sendGraphCurRing(memberRoleId, graphMemBean, 4, true);
/*     */         }
/*     */       }
/* 471 */       if (!RoleTaskManager.innerAcceptTask(memberRoleId, graphMemBean, newTaskMemBean, operTeamerList))
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/* 476 */         return false;
/*     */       }
/*     */     }
/*     */     
/* 480 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static void checkIsGraphScheduleSame(long memberRoleId, GraphBean teamLeaderGraphBean, GraphBean graphMemBean)
/*     */   {
/* 492 */     graphMemBean.getNodebean().setFinishcount(teamLeaderGraphBean.getNodebean().getFinishcount());
/* 493 */     graphMemBean.getNodebean().setNodeid(teamLeaderGraphBean.getNodebean().getNodeid());
/* 494 */     if (graphMemBean.getAllfinishcount() != teamLeaderGraphBean.getAllfinishcount())
/*     */     {
/* 496 */       graphMemBean.setAllfinishcount(teamLeaderGraphBean.getAllfinishcount());
/*     */       
/* 498 */       if (GraphManager.getGraphById(graphMemBean.getGraphid()).isRingTypeGraph())
/*     */       {
/* 500 */         RoleTaskManager.sendGraphCurRing(memberRoleId, graphMemBean, 3, GraphManager.getGraphById(graphMemBean.getGraphid()).isRingTypeGraph());
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean acceptTeamGraphTask(long roleId, Task task, Graph graph, int tryCount)
/*     */   {
/* 516 */     int graphId = graph.id();
/* 517 */     int taskId = task.getStask().id;
/*     */     
/* 519 */     Long teamId = TeamInterface.getTeamidByRoleid(roleId, false);
/* 520 */     if (teamId == null)
/*     */     {
/* 522 */       GameServer.logger().info(String.format("[Task]TeamGraphManager.acceptTeamGraphTask@can not get team graph if role is not in team！|roleId=%d|graphId=%d|taskId=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(graphId), Integer.valueOf(taskId) }));
/*     */       
/*     */ 
/*     */ 
/* 526 */       return false;
/*     */     }
/* 528 */     long teamLeaderId = TeamInterface.getTeamLeaderByTeamid(teamId.longValue(), false);
/* 529 */     if (teamLeaderId != roleId)
/*     */     {
/* 531 */       GameServer.logger().info(String.format("[Task]TeamGraphManager.acceptTeamGraphTask@can not get team graph if role is not leader！|roleId=%d|graphId=%d|taskId=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(graphId), Integer.valueOf(taskId) }));
/*     */       
/*     */ 
/*     */ 
/* 535 */       return false;
/*     */     }
/*     */     
/* 538 */     List<Long> teamMemberList = TeamInterface.getTeamMemberList(teamId.longValue(), false);
/* 539 */     List<String> userList = new ArrayList();
/* 540 */     for (Iterator i$ = teamMemberList.iterator(); i$.hasNext();) { long tmpRoleId = ((Long)i$.next()).longValue();
/*     */       
/* 542 */       userList.add(RoleInterface.getUserId(tmpRoleId));
/*     */     }
/*     */     
/* 545 */     Lockeys.lock(User.getTable(), userList);
/* 546 */     Lockeys.lock(Role2task.getTable(), teamMemberList);
/*     */     
/* 548 */     Lockeys.lock(Team.getTable(), Arrays.asList(new Long[] { teamId }));
/* 549 */     if (!reCheckLockWhenAcceptTeamGraph(roleId, graphId, taskId, teamId, teamMemberList))
/*     */     {
/* 551 */       if (tryCount > 2)
/*     */       {
/* 553 */         GameServer.logger().error(String.format("[task]TaskManager.acceptTeamGraphTask@ try 3 time, but steal fail to lock!|roleId=%d|graphId=%d|taskId=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(graphId), Integer.valueOf(taskId) }));
/*     */         
/*     */ 
/*     */ 
/* 557 */         return false;
/*     */       }
/* 559 */       new TryAccepteTeamGraphTask(teamId.longValue(), graphId, taskId, tryCount);
/* 560 */       return false;
/*     */     }
/* 562 */     RoleTask roleTask = RoleTaskManager.getRoleTask(roleId, true);
/* 563 */     GraphBean graphBean = roleTask.getGraphBean(graph.getSgraph().id);
/* 564 */     TaskBean taskBean = roleTask.getTaskBean(graph.getSgraph().id, task.getStask().id);
/*     */     
/*     */ 
/* 567 */     if ((graphBean == null) || (taskBean == null))
/*     */     {
/* 569 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 573 */     if (graph.getSgraph().isRingTypeGraph)
/*     */     {
/* 575 */       if ((graphBean.getNodebean().getTaskbeans().size() == 1) && (graphBean.getAllfinishcount() == 0))
/*     */       {
/* 577 */         RoleTaskManager.sendGraphCurRing(roleId, graphBean, 4, true);
/*     */       }
/*     */     }
/*     */     
/* 581 */     List<Integer> operTeamTypeList = new ArrayList();
/* 582 */     operTeamTypeList.add(Integer.valueOf(3));
/*     */     
/* 584 */     if (!RoleTaskManager.innerAcceptTask(roleId, graphBean, taskBean, operTeamTypeList))
/*     */     {
/* 586 */       GameServer.logger().error(String.format("[Task]TeamGraphManager.acceptTeamGraphTask@leader accept task failed！|roleId=%d|graphId=%d|taskId=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(graphId), Integer.valueOf(taskId) }));
/*     */       
/*     */ 
/*     */ 
/* 590 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 594 */     for (Iterator i$ = teamMemberList.iterator(); i$.hasNext();) { long memberRoleId = ((Long)i$.next()).longValue();
/*     */       
/* 596 */       if (memberRoleId != teamLeaderId)
/*     */       {
/*     */ 
/*     */ 
/* 600 */         if (TeamInterface.getTeamMemberStatus(memberRoleId) == 0)
/*     */         {
/* 602 */           if (!teamerTryAcceptTask(memberRoleId, graphBean, task.getStask().id))
/*     */           {
/* 604 */             GameServer.logger().error(String.format("[Task]TeamGraphManager.acceptTeamGraphTask@member accept task failed！|roleId=%d|graphId=%d|taskId=%d", new Object[] { Long.valueOf(memberRoleId), Integer.valueOf(graphId), Integer.valueOf(taskId) }));
/*     */             
/*     */ 
/*     */ 
/* 608 */             return false;
/*     */           } } }
/*     */     }
/* 611 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static boolean reCheckLockWhenAcceptTeamGraph(long roleId, int graphId, int taskId, Long teamId, List<Long> teamMemberList)
/*     */   {
/* 627 */     TeamInfo teamInfo = TeamInterface.getTeamInfo(teamId.longValue(), true);
/* 628 */     if (teamInfo == null)
/*     */     {
/* 630 */       GameServer.logger().info(String.format("[Task]TeamGraphManager.reCheckLock@can not get team graph if role is not in team！|roleId=%d|graphId=%d|taskId=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(graphId), Integer.valueOf(taskId) }));
/*     */       
/*     */ 
/*     */ 
/* 634 */       return false;
/*     */     }
/* 636 */     if (teamInfo.getLeaderId() != roleId)
/*     */     {
/* 638 */       GameServer.logger().info(String.format("[Task]TeamGraphManager.reCheckLock@can not get team graph if role is not leader！|roleId=%d|graphId=%d|taskId=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(graphId), Integer.valueOf(taskId) }));
/*     */       
/*     */ 
/*     */ 
/* 642 */       return false;
/*     */     }
/* 644 */     List<Long> nowMembers = teamInfo.getTeamMemberList();
/* 645 */     if ((nowMembers.size() != teamMemberList.size()) || (!nowMembers.containsAll(teamMemberList)))
/*     */     {
/* 647 */       GameServer.logger().info(String.format("[Task]TeamGraphManager.reCheckLock@team members changed！|roleId=%d|graphId=%d|taskId=%d|nowMembers=%s|teamMemberList=%s", new Object[] { Long.valueOf(roleId), Integer.valueOf(graphId), Integer.valueOf(taskId), nowMembers.toString(), teamMemberList.toString() }));
/*     */       
/*     */ 
/*     */ 
/* 651 */       return false;
/*     */     }
/* 653 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void afterFinishTeamTask(long roleId, TaskBean taskBean, GraphBean graphBean, PVEFightEndArg arg)
/*     */   {
/* 668 */     Graph graph = GraphManager.getGraphById(graphBean.getGraphid());
/* 669 */     int finishCount = graphBean.getNodebean().getFinishcount() + 1;
/* 670 */     int graphTaskFinishCount = graphBean.getAllfinishcount() + 1;
/* 671 */     RoleTaskManager.changeTaskState(roleId, 8, graphBean.getGraphid(), taskBean, 0, arg);
/*     */     
/* 673 */     graphBean.getNodebean().getTaskbeans().remove(Integer.valueOf(taskBean.getTaskid()));
/*     */     
/* 675 */     RoleTaskManager.sendUpdateTaskState(roleId, graph.getSgraph().id, taskBean.getTaskid(), 8, arg);
/*     */     
/*     */ 
/* 678 */     graphBean.getNodebean().setFinishcount(finishCount);
/*     */     
/* 680 */     graphBean.setAllfinishcount(graphTaskFinishCount);
/*     */     
/* 682 */     RoleTaskManager.sendGraphCurRing(roleId, graphBean, 1, graph.getSgraph().isRingTypeGraph);
/*     */     
/* 684 */     graph.afterFinishTask(roleId, taskBean, graphBean);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void afterTeamerFinishTeamGraphTask(long roleId, TaskBean taskBean, GraphBean graphBean, Graph graph, boolean isTeamGraphClosed, PVEFightEndArg arg)
/*     */   {
/* 700 */     RoleTaskManager.changeTaskState(roleId, 8, graphBean.getGraphid(), taskBean, 0, arg);
/* 701 */     graphBean.getNodebean().getTaskbeans().remove(Integer.valueOf(taskBean.getTaskid()));
/* 702 */     RoleTaskManager.sendUpdateTaskState(roleId, graphBean.getGraphid(), taskBean.getTaskid(), 8, arg);
/*     */     
/*     */ 
/* 705 */     if (isTeamGraphClosed)
/*     */     {
/* 707 */       RoleTaskManager.closeGraphWithoutEvent(graphBean.getGraphid(), roleId, false);
/* 708 */       return;
/*     */     }
/*     */     
/* 711 */     graphBean.getNodebean().setFinishcount(graphBean.getNodebean().getFinishcount() + 1);
/* 712 */     graphBean.setAllfinishcount(graphBean.getAllfinishcount() + 1);
/*     */     
/* 714 */     RoleTaskManager.sendGraphCurRing(roleId, graphBean, 1, graph.getSgraph().isRingTypeGraph);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\task\main\TeamGraphManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */