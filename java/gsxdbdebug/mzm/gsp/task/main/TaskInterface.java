/*      */ package mzm.gsp.task.main;
/*      */ 
/*      */ import java.util.ArrayList;
/*      */ import java.util.HashMap;
/*      */ import java.util.HashSet;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.Set;
/*      */ import mzm.gsp.GameServer;
/*      */ import mzm.gsp.npc.main.NpcInterface;
/*      */ import mzm.gsp.online.main.OnlineManager;
/*      */ import mzm.gsp.task.STaskNormalResult;
/*      */ import mzm.gsp.task.condition.AbsCondition;
/*      */ import mzm.gsp.task.condition.Con_KillNpc_6;
/*      */ import mzm.gsp.task.confbean.SNpc2Task;
/*      */ import mzm.gsp.task.confbean.STask;
/*      */ import mzm.gsp.task.confbean.STaskConkillNpc;
/*      */ import mzm.gsp.team.main.TeamInterface;
/*      */ import org.apache.log4j.Logger;
/*      */ import xbean.TaskBean;
/*      */ import xbean.TaskDataBean;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class TaskInterface
/*      */ {
/*      */   public static int getFinishGraphNeedTaskNum(int graphId)
/*      */   {
/*   36 */     return RoleTaskManager.getGraphAllTaskNum(graphId);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static Map<Integer, TaskState> getAllRoleTaskBean(long roleId, boolean retainRoleLock)
/*      */   {
/*   51 */     RoleTask roleTask = RoleTaskManager.getRoleTask(roleId, retainRoleLock);
/*   52 */     Map<Integer, TaskState> map = new HashMap();
/*   53 */     for (TaskBean taskBean : roleTask.getAllTaskBean())
/*      */     {
/*   55 */       if (map.containsKey(Integer.valueOf(taskBean.getTaskid())))
/*      */       {
/*   57 */         ((TaskState)map.get(Integer.valueOf(taskBean.getTaskid()))).addState(taskBean.getTaskstate());
/*      */       }
/*      */       else
/*      */       {
/*   61 */         TaskState taskState = new TaskState(taskBean.getTaskid());
/*   62 */         taskState.addState(taskBean.getTaskstate());
/*   63 */         map.put(Integer.valueOf(taskState.getTaskId()), taskState);
/*      */       }
/*      */     }
/*   66 */     return map;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static Map<Integer, List<TaskStateInfo>> getRoleTaskState(long roleId)
/*      */   {
/*   79 */     return TaskImplManager.getRoleTaskStateImpl(roleId);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static int getTaskState(long roleId, int graphId, int taskId)
/*      */   {
/*   96 */     return TaskImplManager.getTaskStateImpl(roleId, graphId, taskId);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static int randomOneTaskInGraph(long roleId, int graphId)
/*      */   {
/*  111 */     return TaskImplManager.randomOneTaskInGraphImpl(roleId, graphId);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void updateTaskCondition(long roleId, int type, Object param)
/*      */   {
/*  123 */     updateTaskCondition(roleId, 0, type, param);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void updateTaskCondition(long roleId, int taskId, int type, Object param)
/*      */   {
/*  135 */     new UpdateTaskConProcedure(roleId, taskId, type, param).execute();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void setFightType(int graphId, int fightType)
/*      */   {
/*  148 */     GraphManager.setGraphFightType(graphId, fightType);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean activeGraph(Long roleId, int graphId)
/*      */   {
/*  164 */     return RoleTaskManager.activeGraph(graphId, roleId.longValue()) != null;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean isTaskExit(int taskId)
/*      */   {
/*  176 */     return TaskManager.isHasTask(taskId);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean isTeamGraph(int graphId)
/*      */   {
/*  189 */     return TaskImplManager.isTeamGraphImpl(graphId);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean activeTeamGraph(int graphId, List<Long> teamMemberIds)
/*      */   {
/*  205 */     return RoleTaskManager.activeTeamGraph(graphId, teamMemberIds);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean finishSingleTask(long roleId, int graphId, int taskId)
/*      */   {
/*  223 */     return new PActiveFinishTask(roleId, graphId, taskId).call();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean closeActivityGraph(long roleId, int graphId)
/*      */   {
/*  236 */     Graph graph = GraphManager.getGraphById(graphId);
/*  237 */     if (graph == null)
/*      */     {
/*  239 */       return false;
/*      */     }
/*  241 */     return RoleTaskManager.closeGraph(graphId, roleId, true);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean closeActivityGraphWithoutEvent(long roleId, int graphId)
/*      */   {
/*  254 */     Graph graph = GraphManager.getGraphById(graphId);
/*  255 */     if (graph == null)
/*      */     {
/*  257 */       return false;
/*      */     }
/*  259 */     return RoleTaskManager.closeGraphWithoutEvent(graphId, roleId, true);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean validateTaskNPCBattle(long roleId, int taskId, int npcId)
/*      */   {
/*  279 */     Task task = TaskManager.getTaskById(taskId);
/*  280 */     RoleTask roleTask = RoleTaskManager.getRoleTask(roleId, false);
/*  281 */     List<TaskBean> beans = roleTask.getTaskBeans(taskId);
/*  282 */     for (TaskBean taskBean : beans)
/*      */     {
/*  284 */       if (taskBean.getTaskstate() == 2)
/*      */       {
/*      */ 
/*  287 */         List<AbsCondition> conditions = task.getCondition(6, 2);
/*      */         
/*  289 */         int needPersonCount = 1;
/*  290 */         boolean allHaveTaskFight = false;
/*  291 */         for (AbsCondition condition : conditions)
/*      */         {
/*  293 */           Con_KillNpc_6 killNpcCondition = (Con_KillNpc_6)condition;
/*  294 */           if (killNpcCondition.getSConkillNpc().fixNPCId == npcId)
/*      */           {
/*  296 */             needPersonCount = killNpcCondition.getSConkillNpc().needPersonCount;
/*  297 */             allHaveTaskFight = killNpcCondition.getSConkillNpc().allHaveTaskFight;
/*  298 */             break;
/*      */           }
/*      */         }
/*  301 */         if (allHaveTaskFight)
/*      */         {
/*  303 */           if (!isAllHaveTask(roleId, taskId))
/*      */           {
/*  305 */             STaskNormalResult staskNormalResult = new STaskNormalResult();
/*  306 */             staskNormalResult.result = 3;
/*  307 */             OnlineManager.getInstance().sendAtOnce(roleId, staskNormalResult);
/*  308 */             return false;
/*      */           }
/*      */         }
/*  311 */         int personCount = 0;
/*  312 */         if (needPersonCount > 1)
/*      */         {
/*  314 */           Long teamId = TeamInterface.getTeamidByRoleid(roleId, false);
/*  315 */           Iterator i$; if (teamId != null)
/*      */           {
/*  317 */             List<Long> teamMemberList = TeamInterface.getTeamMemberList(teamId.longValue(), false);
/*  318 */             for (i$ = teamMemberList.iterator(); i$.hasNext();) { long memberRoleId = ((Long)i$.next()).longValue();
/*      */               
/*  320 */               if (TeamInterface.getTeamMemberStatus(memberRoleId) == 0)
/*      */               {
/*      */ 
/*      */ 
/*  324 */                 personCount++; }
/*      */             }
/*      */           }
/*  327 */           if (personCount < needPersonCount)
/*      */           {
/*  329 */             STaskNormalResult staskNormalResult = new STaskNormalResult();
/*  330 */             staskNormalResult.result = 2;
/*  331 */             staskNormalResult.args.add(needPersonCount + "");
/*  332 */             OnlineManager.getInstance().sendAtOnce(roleId, staskNormalResult);
/*  333 */             return false;
/*      */           }
/*      */         }
/*      */         
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  349 */         return true;
/*      */       }
/*      */     }
/*      */     
/*  353 */     return false;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean unVisiableMonsterTaskBattle(long roleId, int taskId)
/*      */   {
/*  365 */     RoleTask roleTask = RoleTaskManager.getRoleTask(roleId, false);
/*  366 */     List<TaskBean> beans = roleTask.getTaskBeans(taskId);
/*  367 */     for (TaskBean taskBean : beans)
/*      */     {
/*  369 */       if (taskBean.getTaskstate() == 2)
/*      */       {
/*  371 */         return true;
/*      */       }
/*      */     }
/*  374 */     return false;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static long getNpcJingXiangRoleId(int npcId, long roleId)
/*      */   {
/*  384 */     SNpc2Task sNpc2Task = NpcInterface.getSNpc2Task(npcId);
/*  385 */     if (sNpc2Task == null)
/*      */     {
/*  387 */       return -1L;
/*      */     }
/*  389 */     RoleTask roleTask = RoleTaskManager.getRoleTask(roleId, false);
/*  390 */     for (Iterator i$ = roleTask.getAllTaskBean().iterator(); i$.hasNext();) { taskBean = (TaskBean)i$.next();
/*      */       
/*  392 */       if (taskBean.getTaskstate() == 2)
/*      */       {
/*      */ 
/*  395 */         Task task = TaskManager.getTaskById(taskBean.getTaskid());
/*  396 */         if (task != null)
/*      */         {
/*      */ 
/*      */ 
/*  400 */           List<AbsCondition> conditions = task.getCondition(6, 2);
/*      */           
/*  402 */           for (AbsCondition condition : conditions)
/*      */           {
/*  404 */             Con_KillNpc_6 killNpcCondition = (Con_KillNpc_6)condition;
/*  405 */             long jingxiangRoleId = killNpcCondition.getJingXiangRoleId(taskBean);
/*  406 */             if (jingxiangRoleId > 0L)
/*      */             {
/*  408 */               return jingxiangRoleId; }
/*      */           }
/*      */         }
/*      */       } }
/*      */     TaskBean taskBean;
/*  413 */     return -1L;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private static boolean isAllHaveTask(long roleId, int taskId)
/*      */   {
/*  427 */     Long teamId = TeamInterface.getTeamidByRoleid(roleId, false);
/*  428 */     if (teamId == null)
/*      */     {
/*  430 */       return false;
/*      */     }
/*  432 */     List<Long> teamMemberList = TeamInterface.getTeamMemberList(teamId.longValue(), false);
/*  433 */     for (Iterator i$ = teamMemberList.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*      */       
/*  435 */       if (TeamInterface.getTeamMemberStatus(roleid) == 0)
/*      */       {
/*      */ 
/*      */ 
/*  439 */         RoleTask roleTask = RoleTaskManager.getRoleTask(roleid, false);
/*  440 */         List<TaskBean> beans = roleTask.getTaskBeans(taskId);
/*  441 */         boolean isHas = false;
/*  442 */         for (TaskBean taskBean : beans)
/*      */         {
/*  444 */           if (taskBean.getTaskstate() == 2)
/*      */           {
/*  446 */             isHas = true;
/*  447 */             break;
/*      */           }
/*      */         }
/*  450 */         if (!isHas)
/*  451 */           return false;
/*      */       } }
/*  453 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean hasGraphId(int graphId)
/*      */   {
/*  464 */     return GraphManager.getGraphById(graphId) != null;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean isMainGraphIdImp(int graphId)
/*      */   {
/*  476 */     return TaskImplManager.isMainGraphIdImp(graphId);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean goNextTask(long roleId, int graphId, Set<Integer> taskIdSet)
/*      */   {
/*  494 */     long xRoleId = roleId;
/*  495 */     int xGraphId = graphId;
/*  496 */     Set<Integer> xTaskIdSet = taskIdSet;
/*  497 */     new PGoXNextTask(xRoleId, xGraphId, xTaskIdSet, true).execute();
/*  498 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean goNextTask(long roleId, int graphId)
/*      */   {
/*  514 */     long xRoleId = roleId;
/*  515 */     int xGraphId = graphId;
/*  516 */     new PGoXNextTask(xRoleId, xGraphId, new HashSet(), true).execute();
/*  517 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean synGoNextTask(long roleId, int graphId)
/*      */   {
/*  533 */     return new PGoXNextTask(roleId, graphId, new HashSet(), true).call();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean ranOneCanAcceptTask(long roleId, int graphId)
/*      */   {
/*  549 */     long xRoleId = roleId;
/*  550 */     int xGraphId = graphId;
/*  551 */     new PGoXNextTask(xRoleId, xGraphId, new HashSet(), false).execute();
/*  552 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean synRanOneCanAcceptTask(long roleId, int graphId)
/*      */   {
/*  568 */     return new PGoXNextTask(roleId, graphId, new HashSet(), false).call();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static int findTaskInGraph(long roleId, int graphId)
/*      */   {
/*  584 */     return RoleTaskManager.findTaskIdInGraph(roleId, graphId);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean replaceGraphData(long roleId, int oldGraphId, int newGraphId)
/*      */   {
/*  602 */     return RoleTaskManager.replaceGraphData(roleId, oldGraphId, newGraphId);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static int getTaskNumInGraph(long roleId, int graphId, int taskId)
/*      */   {
/*  619 */     return RoleTaskManager.getTaskNumInGraphImpl(roleId, graphId, taskId);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static List<Integer> getRoleAllGraphIds(long roleId, boolean retainRoleLock)
/*      */   {
/*  634 */     RoleTask roleTask = RoleTaskManager.getRoleTask(roleId, retainRoleLock);
/*  635 */     if (roleTask == null)
/*      */     {
/*  637 */       return new ArrayList();
/*      */     }
/*  639 */     if (roleTask.getTaskDataBean() == null)
/*      */     {
/*  641 */       return new ArrayList();
/*      */     }
/*  643 */     if (roleTask.getTaskDataBean().getGraphbeans().keySet().size() == 0)
/*      */     {
/*  645 */       return new ArrayList();
/*      */     }
/*  647 */     List<Integer> graphIds = new ArrayList(roleTask.getTaskDataBean().getGraphbeans().keySet());
/*  648 */     return graphIds;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean isHaveGraphId(long roleId, int grapId)
/*      */   {
/*  663 */     return getRoleAllGraphIds(roleId, false).contains(Integer.valueOf(grapId));
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean isHaveGraphId(int graphId)
/*      */   {
/*  676 */     return GraphManager.getGraphById(graphId) != null;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static List<Integer> getTaskNeedItem(long roleId, int graphId, int taskId)
/*      */   {
/*  693 */     return RoleTaskManager.getTaskNeedItemImpl(roleId, graphId, taskId);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static TaskNeedItemInfo getRoleTaskNeedItemInfos(long roleId)
/*      */   {
/*  706 */     return RoleTaskManager.getRoleTaskNeedItemInfos(roleId);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean clearGraph(int graphId, long roleId)
/*      */   {
/*  722 */     return RoleTaskManager.clearGraphImpl(graphId, roleId, false);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean setGraphFinishNum(long roleId, int graphId, int num)
/*      */   {
/*  740 */     return RoleTaskManager.setGraphFinishNum(roleId, graphId, num);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void acceptGraphXTask(long roleId, int graphId, int taskId)
/*      */   {
/*  757 */     new PActiveGraphDotask(graphId, taskId, roleId).execute();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void giveUpTaskImpl(long roleId, int graphId, int taskId)
/*      */   {
/*  773 */     TaskImplManager.giveUpTaskImpl(roleId, graphId, taskId);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void regisBanGraph(Set<Integer> graphIds)
/*      */   {
/*  786 */     BanGraphManager.regisBanGraph(graphIds);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void unRegisBanGraph(Set<Integer> graphIds)
/*      */   {
/*  799 */     BanGraphManager.unRegisBanGraph(graphIds);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean isGraphValidate(int graphId)
/*      */   {
/*  815 */     return BanGraphManager.isValidate(graphId);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static int getAllTaskNumInGraph(int graphId)
/*      */   {
/*  827 */     return RoleTaskManager.getGraphAllTaskNum(graphId);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean canFly(int taskId)
/*      */   {
/*  839 */     if (!TaskManager.isHasTask(taskId))
/*      */     {
/*  841 */       return false;
/*      */     }
/*  843 */     return TaskManager.getTaskById(taskId).getStask().useFlySword;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean hasFlyTask(long roleId, boolean isRetainLock)
/*      */   {
/*  855 */     return RoleTaskManager.hasFlyTaskImpl(roleId, isRetainLock);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static int getFristTaskId(int graphId)
/*      */   {
/*  867 */     Graph graph = GraphManager.getGraphById(graphId);
/*  868 */     if (graph == null)
/*      */     {
/*  870 */       GameServer.logger().error(String.format("[task]taskInterface.getFristTaskId@ graph data is null!|graphId=%d", new Object[] { Integer.valueOf(graphId) }));
/*      */       
/*  872 */       return -1;
/*      */     }
/*  874 */     return graph.getFristTaskId();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static TaskFinishNeedItem getFinishTaskItem(int taskId)
/*      */   {
/*  887 */     return TaskImplManager.getFinishTaskItemImpl(taskId);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static TaskData getRoleGraphTask(long roleId, int graphId)
/*      */   {
/*  902 */     return TaskImplManager.getOwnTaskData(roleId, graphId);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static int getRoleGraphFinishCount(long roleId, int graphId)
/*      */   {
/*  916 */     return RoleTaskManager.getGraphFinishCount(roleId, graphId);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static Map<Integer, Integer> getGraphFinishCount(long roleId, Set<Integer> checkGraphIds)
/*      */   {
/*  931 */     return RoleTaskManager.getGraphFinishCount(roleId, checkGraphIds);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void registerTaskNpcLibHandler(int npcLibId, TaskNpcLibIdHandler handler)
/*      */   {
/*  947 */     if (!TaskNpcManager.getInstance().registerTaskNpcLibHandler(npcLibId, handler))
/*      */     {
/*  949 */       throw new RuntimeException("注册NPC类id处理类出错，详情参考ErrerLog!");
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static IDIP_ActivieGraphRes idipActiveGraph(long roleId, int graphId)
/*      */   {
/*  967 */     return IDIP_Manager.activeGraph(roleId, graphId);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean changeTaskFinish(long roleId, int graphId, int taskId)
/*      */   {
/*  985 */     return RoleTaskManager.changeTaskFinishImpl(roleId, graphId, taskId);
/*      */   }
/*      */   
/*      */   public static class TaskState
/*      */   {
/*      */     private int taskId;
/*  991 */     private HashSet<Integer> stateSet = new HashSet();
/*      */     
/*      */     public TaskState(int taskId)
/*      */     {
/*  995 */       this.taskId = taskId;
/*      */     }
/*      */     
/*      */     public void addState(int state)
/*      */     {
/* 1000 */       this.stateSet.add(Integer.valueOf(state));
/*      */     }
/*      */     
/*      */     public HashSet<Integer> getStateSet()
/*      */     {
/* 1005 */       return this.stateSet;
/*      */     }
/*      */     
/*      */     public int getTaskId()
/*      */     {
/* 1010 */       return this.taskId;
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\task\main\TaskInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */