/*      */ package mzm.gsp.task.main;
/*      */ 
/*      */ import java.util.ArrayList;
/*      */ import java.util.Arrays;
/*      */ import java.util.Collection;
/*      */ import java.util.Collections;
/*      */ import java.util.HashMap;
/*      */ import java.util.HashSet;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.Map.Entry;
/*      */ import java.util.Set;
/*      */ import java.util.concurrent.TimeUnit;
/*      */ import mzm.event.TriggerEventsManger;
/*      */ import mzm.gsp.GameServer;
/*      */ import mzm.gsp.chivalry.main.ChivalryInterface;
/*      */ import mzm.gsp.fight.event.PVEFightEndArg;
/*      */ import mzm.gsp.item.main.ItemInterface;
/*      */ import mzm.gsp.map.main.MapInterface;
/*      */ import mzm.gsp.online.main.OnlineManager;
/*      */ import mzm.gsp.role.main.RoleInterface;
/*      */ import mzm.gsp.task.ConData;
/*      */ import mzm.gsp.task.SRefreshTaskRes;
/*      */ import mzm.gsp.task.SSynTaskCurRing;
/*      */ import mzm.gsp.task.STaskInitData;
/*      */ import mzm.gsp.task.STaskNormalResult;
/*      */ import mzm.gsp.task.SUpdateTaskCon;
/*      */ import mzm.gsp.task.SUpdateTaskState;
/*      */ import mzm.gsp.task.TaskData;
/*      */ import mzm.gsp.task.TaskState;
/*      */ import mzm.gsp.task.ban.BanGraphInterface;
/*      */ import mzm.gsp.task.conParamObj.KillMonsterParamObj;
/*      */ import mzm.gsp.task.conParamObj.KillNpcParamObj;
/*      */ import mzm.gsp.task.conParamObj.WinCountParamObj;
/*      */ import mzm.gsp.task.condition.AbsCondition;
/*      */ import mzm.gsp.task.condition.ConParam;
/*      */ import mzm.gsp.task.condition.Con_Bag_9;
/*      */ import mzm.gsp.task.condition.Con_KillNpc_6;
/*      */ import mzm.gsp.task.condition.Con_ToPlace_4;
/*      */ import mzm.gsp.task.confbean.SGraph;
/*      */ import mzm.gsp.task.confbean.SNode;
/*      */ import mzm.gsp.task.confbean.SNodeProperty;
/*      */ import mzm.gsp.task.confbean.STTaskUsedNpcLibCfg;
/*      */ import mzm.gsp.task.confbean.STask;
/*      */ import mzm.gsp.task.confbean.STaskConBag;
/*      */ import mzm.gsp.task.confbean.STaskContoPlace;
/*      */ import mzm.gsp.task.confbean.STaskPvcCfg;
/*      */ import mzm.gsp.task.confbean.STaskToProperty;
/*      */ import mzm.gsp.task.event.GraphFinish;
/*      */ import mzm.gsp.task.event.GraphStart;
/*      */ import mzm.gsp.task.event.TaskStateChange;
/*      */ import mzm.gsp.task.pvc.RoleTaskPvcManager;
/*      */ import mzm.gsp.team.event.TeamLeaderChangedArg;
/*      */ import mzm.gsp.team.main.TeamInterface;
/*      */ import mzm.gsp.tlog.LogReason;
/*      */ import mzm.gsp.tlog.TLogArg;
/*      */ import mzm.gsp.util.DateTimeUtils;
/*      */ import mzm.gsp.util.LogicProcedure;
/*      */ import org.apache.log4j.Logger;
/*      */ import xbean.ConBean;
/*      */ import xbean.GraphBean;
/*      */ import xbean.GraphFinishBean;
/*      */ import xbean.NodeBean;
/*      */ import xbean.Pod;
/*      */ import xbean.TaskBean;
/*      */ import xbean.TaskDataBean;
/*      */ import xdb.Lockeys;
/*      */ import xdb.Procedure;
/*      */ import xtable.Basic;
/*      */ import xtable.Role2graphfinish;
/*      */ import xtable.Role2task;
/*      */ import xtable.Team;
/*      */ import xtable.User;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class RoleTaskManager
/*      */ {
/*   86 */   private static final Logger logger = Logger.getLogger(RoleTaskManager.class);
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean initRoleTaskData(long roleId)
/*      */   {
/*   97 */     if (!checkAndGetLock(Arrays.asList(new Long[] { Long.valueOf(roleId) })))
/*      */     {
/*   99 */       if (logger.isDebugEnabled())
/*      */       {
/*  101 */         logger.debug(String.format("[task]RoleTaskManager.initRoleTaskData@初始化任务取锁时发生数据不一致|roleId=%d", new Object[] { Long.valueOf(roleId) }));
/*      */       }
/*  103 */       return false;
/*      */     }
/*      */     
/*      */ 
/*  107 */     RoleTask roleTask = getRoleTask(roleId, true);
/*      */     
/*  109 */     if (roleTask.getTaskDataBean() == null)
/*      */     {
/*      */ 
/*  112 */       TaskDataBean taskDataBean = Pod.newTaskDataBean();
/*  113 */       for (Graph graph : GraphManager.getInstance().getAllGraph())
/*      */       {
/*  115 */         if (graph.isOwnGraph(roleId))
/*      */         {
/*      */ 
/*      */ 
/*  119 */           graphBean = graph.createGraphBean(roleId);
/*      */           
/*  121 */           if (graphBean != null) {
/*  122 */             taskDataBean.getGraphbeans().put(Integer.valueOf(graphBean.getGraphid()), graphBean);
/*      */           }
/*  124 */           for (TaskBean xtaskBean : graphBean.getNodebean().getTaskbeans().values())
/*      */           {
/*  126 */             sendUpdateTaskState(roleId, graphBean.getGraphid(), xtaskBean.getTaskid(), xtaskBean.getTaskstate()); }
/*      */         }
/*      */       }
/*      */       GraphBean graphBean;
/*  130 */       roleTask.setTaskDataBean(taskDataBean);
/*      */       
/*  132 */       if (taskDataBean.getGraphbeans().size() > 0)
/*      */       {
/*  134 */         Role2task.insert(Long.valueOf(roleId), taskDataBean);
/*      */       }
/*      */     }
/*      */     else
/*      */     {
/*  139 */       List<Integer> checkedGraphIds = new ArrayList();
/*  140 */       for (GraphBean graphBean : roleTask.getTaskDataBean().getGraphbeans().values())
/*      */       {
/*  142 */         int graphId = graphBean.getGraphid();
/*  143 */         Graph graph = GraphManager.getGraphById(graphId);
/*  144 */         if (graph == null)
/*      */         {
/*  146 */           logger.error("玩家身上有任务图而配置中没有了,graphId:" + graphId);
/*      */         }
/*      */         else {
/*  149 */           int nodeId = graphBean.getNodebean().getNodeid();
/*  150 */           SNode snode = graph.getNodebyNodeId(nodeId);
/*  151 */           if (snode == null)
/*      */           {
/*  153 */             logger.error("玩家身上有任务节点而配置中没有了,graphId:" + graphId + " nodeId:" + nodeId);
/*      */           }
/*      */           else {
/*  156 */             checkedGraphIds.add(Integer.valueOf(graphBean.getGraphid()));
/*      */           }
/*      */         }
/*      */       }
/*  160 */       int teamState = TeamInterface.getTeamMemberStatus(roleId);
/*  161 */       if (teamState != 0)
/*      */       {
/*  163 */         remTeamGraph(roleId);
/*      */       }
/*      */       
/*      */ 
/*  167 */       checkRoleLevel(roleId);
/*      */       
/*  169 */       checkGraphActiveCondition(roleId, roleTask);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*  174 */     checkAndUpdateTaskGraph(roleId, roleTask);
/*      */     
/*  176 */     new TimeLimitConProLogIn(roleId).handleTimeConTask();
/*  177 */     sendInitMsg(roleId);
/*  178 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private static void checkGraphActiveCondition(long roleId, RoleTask roleTask)
/*      */   {
/*  190 */     GraphFinishBean xGraphFinishBean = Role2graphfinish.get(Long.valueOf(roleId));
/*  191 */     if (xGraphFinishBean == null)
/*      */     {
/*  193 */       return;
/*      */     }
/*  195 */     for (Map.Entry<Integer, Graph> entry : GraphManager.getInstance().getAllGraphActiveGraphs().entrySet())
/*      */     {
/*  197 */       checkSingleGraph(roleId, roleTask, xGraphFinishBean.getGraphidtofinish(), ((Integer)entry.getKey()).intValue(), (Graph)entry.getValue());
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
/*      */   private static void checkSingleGraph(long roleId, RoleTask roleTask, Map<Integer, Integer> graphidtofinishCount, int conditionGraphId, Graph needActiveGraph)
/*      */   {
/*  213 */     if (needActiveGraph == null)
/*      */     {
/*  215 */       return;
/*      */     }
/*  217 */     if (!graphidtofinishCount.containsKey(Integer.valueOf(conditionGraphId)))
/*      */     {
/*      */ 
/*  220 */       return;
/*      */     }
/*  222 */     int needActiveGraphId = needActiveGraph.id();
/*  223 */     if (graphidtofinishCount.containsKey(Integer.valueOf(needActiveGraphId)))
/*      */     {
/*      */ 
/*  226 */       return;
/*      */     }
/*  228 */     if (roleTask.hasGraph(needActiveGraphId))
/*      */     {
/*      */ 
/*  231 */       return;
/*      */     }
/*  233 */     GameServer.logger().info(String.format("[task]RoleTaskMananger.checkSingleGraph@ need active graph!|roleId=%d|needActiveGraphId=%d|conditionGraphId=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(needActiveGraph.id()), Integer.valueOf(conditionGraphId) }));
/*      */     
/*      */ 
/*      */ 
/*  237 */     activeGraph(needActiveGraphId, roleId);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void checkRoleLevel(long roleId)
/*      */   {
/*  248 */     TaskInterface.updateTaskCondition(roleId, 1, new Object());
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
/*      */   public static GraphBean activeGraph(int graphId, long roleId)
/*      */   {
/*  262 */     RoleTask roleTask = getRoleTask(roleId, true);
/*  263 */     if (roleTask.getTaskDataBean() == null)
/*      */     {
/*  265 */       return null;
/*      */     }
/*  267 */     if (roleTask.getTaskDataBean().getGraphbeans().containsKey(Integer.valueOf(graphId)))
/*      */     {
/*  269 */       return null;
/*      */     }
/*  271 */     Graph graph = GraphManager.getGraphById(graphId);
/*  272 */     if (graph == null)
/*      */     {
/*  274 */       return null;
/*      */     }
/*  276 */     return activeGraph(graphId, roleId, roleTask, graph);
/*      */   }
/*      */   
/*      */   static GraphBean activeGraph(int graphId, long roleId, RoleTask roleTask, Graph graph)
/*      */   {
/*  281 */     GraphBean graphBean = graph.createGraphBean(roleId);
/*  282 */     roleTask.getTaskDataBean().getGraphbeans().put(Integer.valueOf(graphId), graphBean);
/*      */     
/*  284 */     for (TaskBean xtaskBean : graphBean.getNodebean().getTaskbeans().values())
/*      */     {
/*  286 */       sendUpdateTaskState(roleId, graphBean.getGraphid(), xtaskBean.getTaskid(), xtaskBean.getTaskstate());
/*      */     }
/*      */     
/*  289 */     TriggerEventsManger.getInstance().triggerEvent(new GraphStart(), new GraphStartArg(roleId, graphId));
/*      */     
/*  291 */     return graphBean;
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
/*      */   public static boolean activeTeamGraph(int graphId, List<Long> teamMemberIds)
/*      */   {
/*  308 */     Graph graph = GraphManager.getGraphById(graphId);
/*  309 */     if (!graph.isTeamGraph())
/*      */     {
/*  311 */       return false;
/*      */     }
/*      */     
/*  314 */     long teamLeader = TeamInterface.getTeamLeaderByRoleid(((Long)teamMemberIds.get(0)).longValue(), false, false);
/*  315 */     if (teamLeader != ((Long)teamMemberIds.get(0)).longValue())
/*      */     {
/*  317 */       return false;
/*      */     }
/*      */     
/*  320 */     if (!checkAndGetLock(Arrays.asList(new Long[] { Long.valueOf(teamLeader) })))
/*      */     {
/*  322 */       return false;
/*      */     }
/*      */     
/*  325 */     for (Iterator i$ = teamMemberIds.iterator(); i$.hasNext();) { long memberId = ((Long)i$.next()).longValue();
/*      */       
/*  327 */       if (activeGraph(graphId, memberId) == null) {}
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*  332 */     return true;
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
/*      */   static boolean closeGraph(int graphId, long roleId, boolean sendMsg)
/*      */   {
/*  346 */     if (!closeGraphWithoutEvent(graphId, roleId, sendMsg))
/*      */     {
/*  348 */       return false;
/*      */     }
/*      */     
/*      */ 
/*  352 */     TriggerEventsManger.getInstance().triggerEventAtOnce(new GraphFinish(), new GraphFinishArg(roleId, graphId));
/*  353 */     return true;
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
/*      */   static boolean closeGraphWithoutEvent(int graphId, long roleId, boolean sendMsg)
/*      */   {
/*  368 */     RoleTask roleTask = getRoleTask(roleId, true);
/*  369 */     GraphBean graphBean = roleTask.getGraphBean(graphId);
/*  370 */     if (graphBean == null)
/*      */     {
/*  372 */       return true;
/*      */     }
/*  374 */     if (sendMsg) {
/*  375 */       for (TaskBean taskBean : graphBean.getNodebean().getTaskbeans().values())
/*      */       {
/*  377 */         sendUpdateTaskState(roleId, graphId, taskBean.getTaskid(), 4); }
/*      */     }
/*  379 */     roleTask.remGraphBean(graphBean);
/*  380 */     return true;
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
/*      */   static boolean clearGraphImpl(int graphId, long roleId, boolean sendMsg)
/*      */   {
/*  395 */     RoleTask roleTask = getRoleTask(roleId, true);
/*  396 */     GraphBean graphBean = roleTask.getGraphBean(graphId);
/*  397 */     if (graphBean == null)
/*      */     {
/*  399 */       return false;
/*      */     }
/*  401 */     graphBean.setAllfinishcount(0);
/*  402 */     graphBean.getNodebean().setNodeid(GraphManager.getGraphById(graphId).getSgraph().rootNodeId);
/*  403 */     graphBean.getNodebean().setFinishcount(0);
/*  404 */     if (sendMsg) {
/*  405 */       for (TaskBean taskBean : graphBean.getNodebean().getTaskbeans().values())
/*      */       {
/*  407 */         sendUpdateTaskState(roleId, graphId, taskBean.getTaskid(), taskBean.getTaskstate());
/*      */       }
/*      */     }
/*  410 */     sendGraphCurRing(roleId, graphBean, 1, true);
/*  411 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static int getGraphFinishCount(long roleId, int graphId)
/*      */   {
/*  423 */     GraphFinishBean graphFinishBean = Role2graphfinish.select(Long.valueOf(roleId));
/*  424 */     if (graphFinishBean == null)
/*      */     {
/*  426 */       return 0;
/*      */     }
/*  428 */     Integer count = (Integer)graphFinishBean.getGraphidtofinish().get(Integer.valueOf(graphId));
/*  429 */     return count == null ? 0 : count.intValue();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static Map<Integer, Integer> getGraphFinishCount(long roleId, Set<Integer> checkGraphIds)
/*      */   {
/*  441 */     if ((checkGraphIds == null) || (checkGraphIds.size() == 0))
/*      */     {
/*  443 */       return Collections.emptyMap();
/*      */     }
/*  445 */     GraphFinishBean graphFinishBean = Role2graphfinish.select(Long.valueOf(roleId));
/*  446 */     if (graphFinishBean == null)
/*      */     {
/*  448 */       return Collections.emptyMap();
/*      */     }
/*  450 */     Map<Integer, Integer> graphId2finishCount = new HashMap();
/*  451 */     for (Iterator i$ = checkGraphIds.iterator(); i$.hasNext();) { int graphId = ((Integer)i$.next()).intValue();
/*      */       
/*  453 */       Integer count = (Integer)graphFinishBean.getGraphidtofinish().get(Integer.valueOf(graphId));
/*  454 */       if (count != null)
/*      */       {
/*      */ 
/*      */ 
/*  458 */         graphId2finishCount.put(Integer.valueOf(graphId), Integer.valueOf(count.intValue()));
/*      */       }
/*      */     }
/*  461 */     return graphId2finishCount;
/*      */   }
/*      */   
/*      */ 
/*      */   private static void checkAndInitSession(RoleTask roleTask)
/*      */   {
/*  467 */     if (roleTask.getTaskDataBean() == null)
/*      */     {
/*  469 */       return;
/*      */     }
/*  471 */     long timeNow = DateTimeUtils.getCurrTimeInMillis();
/*  472 */     for (GraphBean graphBean : roleTask.getTaskDataBean().getGraphbeans().values())
/*      */     {
/*  474 */       long refreshTime = graphBean.getNodebean().getRefreshtime();
/*  475 */       if ((refreshTime > 0L) && (timeNow >= refreshTime))
/*      */       {
/*  477 */         new RefreshTaskSetProcedure(roleTask.getRoleId(), graphBean.getGraphid(), refreshTime).execute();
/*      */ 
/*      */ 
/*      */       }
/*  481 */       else if (refreshTime > 0L)
/*      */       {
/*  483 */         long interval = Math.max(1L, (refreshTime - timeNow) / 1000L);
/*  484 */         RefreshTaskSetSession.addRefreshTaskSession(interval, roleTask.getRoleId(), graphBean.getGraphid(), refreshTime);
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private static void sendInitMsg(long roleId)
/*      */   {
/*  497 */     RoleTask roleTask = getRoleTask(roleId, false);
/*  498 */     STaskInitData staskInitData = new STaskInitData();
/*  499 */     if (roleTask.getTaskDataBean() != null)
/*      */     {
/*  501 */       for (Iterator i$ = roleTask.getTaskDataBean().getGraphbeans().values().iterator(); i$.hasNext();) { graphbean = (GraphBean)i$.next();
/*      */         
/*  503 */         graph = GraphManager.getGraphById(graphbean.getGraphid());
/*  504 */         if (graph == null)
/*      */         {
/*  506 */           GameServer.logger().error(String.format("[task]roleTaskManager.sendInitMsg@role own one no cfg graphId!|roleId=%d|graphId=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(graphbean.getGraphid()) }));
/*      */ 
/*      */         }
/*      */         else
/*      */         {
/*      */ 
/*  512 */           if ((graph != null) && (graph.getSgraph().isRingTypeGraph))
/*      */           {
/*  514 */             staskInitData.setgraphring.put(Integer.valueOf(graph.id()), Integer.valueOf(graphbean.getAllfinishcount()));
/*      */           }
/*  516 */           for (TaskBean taskBean : graphbean.getNodebean().getTaskbeans().values())
/*      */           {
/*  518 */             if (taskBean.getTaskstate() != 7)
/*      */             {
/*      */ 
/*      */ 
/*      */ 
/*  523 */               TaskData taskData = new TaskData();
/*  524 */               taskData.graphid = graphbean.getGraphid();
/*  525 */               taskData.taskid = taskBean.getTaskid();
/*  526 */               taskData.state = taskBean.getTaskstate();
/*  527 */               Task task = TaskManager.getTaskById(taskBean.getTaskid());
/*  528 */               if (task == null)
/*      */               {
/*  530 */                 logger.error(String.format("[task]RoleTaskManager.sendInitMsg@ not have task data!|roleId=%d|graphId=%d|taskId=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(graphbean.getGraphid()), Integer.valueOf(taskBean.getTaskid()) }));
/*      */ 
/*      */               }
/*      */               else
/*      */               {
/*  535 */                 for (Map.Entry<Integer, ConBean> entry : taskBean.getConmap().entrySet())
/*      */                 {
/*  537 */                   ConData conData = new ConData();
/*  538 */                   conData.conid = ((Integer)entry.getKey()).intValue();
/*  539 */                   AbsCondition condition = task.getCondition(conData.conid);
/*  540 */                   if (condition == null)
/*      */                   {
/*  542 */                     logger.error(String.format("[task]RoleTaskManager.sendInitMsg@ not have task con data!|roleId=%d|graphId=%d|taskId=%d|conId=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(graphbean.getGraphid()), Integer.valueOf(taskBean.getTaskid()), Integer.valueOf(conData.conid) }));
/*      */ 
/*      */                   }
/*      */                   else
/*      */                   {
/*  547 */                     ConParam p = condition.getSendParam((ConBean)entry.getValue());
/*  548 */                     conData.param = p.getParam();
/*  549 */                     conData.subparam = p.getSubParam();
/*  550 */                     taskData.condatas.add(conData);
/*  551 */                     condition.asynSendConParam(roleId, graphbean.getGraphid(), (ConBean)entry.getValue());
/*      */                   }
/*      */                 }
/*  554 */                 if ((taskBean.getTaskstate() == 6) && (!graph.isRingTypeGraph()))
/*      */                 {
/*  556 */                   AcceptTaskCheckResult ret = task.iscanTake(roleId, new HashMap(), new HashMap(), taskData.graphid);
/*      */                   
/*  558 */                   taskData.uncondatas.addAll(ret.getNoConId());
/*      */                 }
/*  560 */                 staskInitData.taskdatas.add(taskData);
/*      */               }
/*      */             } } } }
/*      */       GraphBean graphbean;
/*      */       Graph graph;
/*  565 */       OnlineManager.getInstance().send(roleId, staskInitData);
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
/*      */   public static RoleTask getRoleTask(long roleId, boolean isRetainLock)
/*      */   {
/*  581 */     RoleTask roleTask = new RoleTask(roleId, isRetainLock);
/*  582 */     return roleTask;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean updatePVEBattleWin(PVEFightEndArg pveArg)
/*      */   {
/*  592 */     if (!pveArg.isPlayerWin)
/*      */     {
/*  594 */       return false;
/*      */     }
/*      */     
/*  597 */     Set<Long> allRole = new HashSet();
/*  598 */     Set<Long> allNoEcapedRoles = new HashSet();
/*      */     
/*  600 */     allNoEcapedRoles.addAll(pveArg.alivedRoles);
/*  601 */     allNoEcapedRoles.addAll(pveArg.diedRoles);
/*  602 */     allNoEcapedRoles.removeAll(pveArg.escapedRoles);
/*  603 */     allRole.addAll(pveArg.escapedRoles);
/*  604 */     allRole.addAll(allNoEcapedRoles);
/*      */     
/*      */ 
/*  607 */     List<Long> noEscapedRoles = new ArrayList(allNoEcapedRoles);
/*  608 */     if (noEscapedRoles.size() <= 0)
/*      */     {
/*  610 */       GameServer.logger().error(String.format("[task]RoleTaskmanager.updatePVEBattleWin@战斗胜利，队员全都逃跑!|fightCfgId=%d|aliveRoles=%s|dieRoles=%s|escapedRoles=%s", new Object[] { Integer.valueOf(pveArg.fightCfgID), pveArg.alivedRoles, pveArg.diedRoles, pveArg.escapedRoles }));
/*      */       
/*      */ 
/*      */ 
/*  614 */       return false;
/*      */     }
/*  616 */     long leaderId = TeamInterface.getTeamLeaderByRoleid(((Long)noEscapedRoles.get(0)).longValue(), false, false);
/*  617 */     List<String> userIds = new ArrayList();
/*  618 */     for (Iterator i$ = allRole.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*      */       
/*  620 */       userIds.add(RoleInterface.getUserId(roleId));
/*      */     }
/*      */     
/*  623 */     Lockeys.lock(User.getTable(), userIds);
/*      */     
/*  625 */     Lockeys.lock(Role2task.getTable(), allRole);
/*      */     
/*  627 */     int mapId = 0;
/*  628 */     if ((pveArg.context instanceof MapFightContext))
/*      */     {
/*  630 */       MapFightContext context = (MapFightContext)pveArg.context;
/*  631 */       mapId = context.getMapId();
/*  632 */       mainTaskChivalryPro(allNoEcapedRoles, context);
/*      */     }
/*  634 */     else if ((pveArg.context instanceof mzm.gsp.map.main.MapFightContext))
/*      */     {
/*  636 */       mapId = ((mzm.gsp.map.main.MapFightContext)pveArg.context).mapId;
/*      */     }
/*      */     
/*  639 */     List<Long> noEcapedTeamList = new ArrayList();
/*  640 */     List<Long> tempList = new ArrayList();
/*  641 */     tempList.addAll(pveArg.roleList);
/*  642 */     tempList.removeAll(pveArg.escapedRoles);
/*  643 */     tempList.remove(Long.valueOf(leaderId));
/*  644 */     noEcapedTeamList.add(Long.valueOf(leaderId));
/*  645 */     noEcapedTeamList.addAll(tempList);
/*      */     
/*      */ 
/*  648 */     Map<Integer, Object> params = getFightParams(pveArg, mapId);
/*  649 */     for (Long roleId : allRole)
/*      */     {
/*      */ 
/*  652 */       RoleTask roleTask = getRoleTask(roleId.longValue(), true);
/*  653 */       if (roleTask.getTaskDataBean() != null)
/*      */       {
/*      */ 
/*      */ 
/*  657 */         List<GraphBean> graphBeans = new ArrayList(roleTask.getTaskDataBean().getGraphbeans().values());
/*  658 */         for (int i = 0; i < graphBeans.size(); i++)
/*      */         {
/*  660 */           GraphBean graphBean = (GraphBean)graphBeans.get(i);
/*  661 */           graphBeanProc(pveArg, leaderId, noEcapedTeamList, params, roleId, graphBean);
/*      */         }
/*      */       } }
/*  664 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void mainTaskChivalryPro(Set<Long> allNoEcapedRoles, MapFightContext context)
/*      */   {
/*  675 */     int graphId = context.getGraphId();
/*      */     
/*  677 */     if (!TaskImplManager.isMainGraphIdImp(graphId))
/*      */     {
/*  679 */       return;
/*      */     }
/*  681 */     for (Iterator i$ = allNoEcapedRoles.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*      */       
/*  683 */       if (!context.getRoleListHaveSameTask().contains(Long.valueOf(roleId)))
/*      */       {
/*      */ 
/*      */ 
/*  687 */         int needAddNum = ChivalryInterface.getMainCountPerTime();
/*  688 */         ChivalryInterface.addRoleChivalry(roleId, needAddNum, 3, new TLogArg(LogReason.TASK_OPER_ADD), true);
/*      */       }
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
/*      */   static void graphBeanProc(PVEFightEndArg pveArg, long leaderId, List<Long> noEcapedTeamList, Map<Integer, Object> params, Long roleId, GraphBean graphBean)
/*      */   {
/*  704 */     int graphId = graphBean.getGraphid();
/*  705 */     Graph graph = GraphManager.getGraphById(graphId);
/*  706 */     if (graph == null)
/*      */     {
/*  708 */       GameServer.logger().error(String.format("[task]RoleTaskManager.graphBeanProc@ no graph cfg!|roleId=%d|graphId=%d", new Object[] { roleId, Integer.valueOf(graphId) }));
/*      */       
/*  710 */       return;
/*      */     }
/*  712 */     boolean isTeamGraph = graph.isTeamGraph();
/*      */     
/*  714 */     if ((isTeamGraph) && (roleId.longValue() == leaderId))
/*      */     {
/*      */ 
/*  717 */       if (graphBean.getNodebean().getTaskbeans().size() == 0)
/*      */       {
/*  719 */         return;
/*      */       }
/*  721 */       for (TaskBean taskBean : graphBean.getNodebean().getTaskbeans().values())
/*      */       {
/*  723 */         TeamGraphManager.updateTeamTaskCon(noEcapedTeamList, params, graphBean, taskBean, pveArg);
/*      */       }
/*  725 */       return;
/*      */     }
/*  727 */     if (isTeamGraph)
/*      */     {
/*  729 */       return;
/*      */     }
/*  731 */     for (TaskBean taskBean : graphBean.getNodebean().getTaskbeans().values())
/*      */     {
/*  733 */       if (taskBean.getTaskstate() != 3)
/*      */       {
/*      */ 
/*      */ 
/*  737 */         Task task = TaskManager.getTaskById(taskBean.getTaskid());
/*  738 */         if (task == null)
/*      */         {
/*  740 */           logger.error("任务不存在了:" + taskBean.getTaskid());
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         }
/*      */         else
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  756 */           updateTaskCon(roleId.longValue(), params, graphBean, taskBean, pveArg);
/*      */         }
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private static Map<Integer, Object> getFightParams(PVEFightEndArg pveArg, int mapId)
/*      */   {
/*  769 */     Map<Integer, Object> params = new HashMap();
/*      */     
/*  771 */     KillMonsterParamObj killMonster = new KillMonsterParamObj();
/*  772 */     killMonster.setMapId(mapId);
/*      */     
/*  774 */     for (Integer monsterId : pveArg.diedMonsters)
/*      */     {
/*  776 */       killMonster.addMonsterCount(monsterId.intValue(), 1);
/*      */     }
/*  778 */     params.put(Integer.valueOf(8), killMonster);
/*      */     
/*  780 */     KillNpcParamObj killNpcParamObj = new KillNpcParamObj();
/*  781 */     killNpcParamObj.setBattleId(pveArg.fightCfgID);
/*  782 */     params.put(Integer.valueOf(6), killNpcParamObj);
/*      */     
/*  784 */     WinCountParamObj winCount = new WinCountParamObj();
/*  785 */     winCount.setMapId(mapId);
/*  786 */     winCount.setCount(1);
/*  787 */     winCount.setBattleId(pveArg.fightCfgID);
/*  788 */     params.put(Integer.valueOf(5), winCount);
/*  789 */     return params;
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
/*      */   static boolean updateCondition(long roleId, int taskId, int type, Object param)
/*      */   {
/*  804 */     return updateCondition(roleId, taskId, type, param, true);
/*      */   }
/*      */   
/*      */   static boolean updateCondition(long roleId, int taskId, int type, Object param, boolean lock)
/*      */   {
/*  809 */     if (lock)
/*      */     {
/*  811 */       if (!checkAndGetLock(Arrays.asList(new Long[] { Long.valueOf(roleId) })))
/*      */       {
/*  813 */         return false;
/*      */       }
/*      */     }
/*      */     
/*  817 */     RoleTask roleTask = getRoleTask(roleId, true);
/*  818 */     if (roleTask.getTaskDataBean() == null)
/*      */     {
/*  820 */       return true;
/*      */     }
/*  822 */     Map<Integer, Object> params = new HashMap();
/*  823 */     params.put(Integer.valueOf(type), param);
/*  824 */     for (Iterator i$ = roleTask.getTaskDataBean().getGraphbeans().values().iterator(); i$.hasNext();) { graphBean = (GraphBean)i$.next();
/*      */       
/*      */ 
/*  827 */       checkedTasks = new HashSet();
/*  828 */       if (taskId > 0)
/*      */       {
/*  830 */         TaskBean taskBean = (TaskBean)graphBean.getNodebean().getTaskbeans().get(Integer.valueOf(taskId));
/*  831 */         if (taskBean != null)
/*      */         {
/*      */ 
/*      */ 
/*  835 */           updateTaskCon(roleId, params, graphBean, taskBean);
/*  836 */           return true;
/*      */         }
/*  838 */       } else { for (TaskBean taskBean : graphBean.getNodebean().getTaskbeans().values())
/*      */         {
/*  840 */           if (taskBean != null)
/*      */           {
/*      */ 
/*      */ 
/*  844 */             updateTaskCon(roleId, params, graphBean, taskBean);
/*  845 */             checkedTasks.add(Integer.valueOf(taskBean.getTaskid()));
/*      */           }
/*      */         }
/*  848 */         graph = GraphManager.getGraphById(graphBean.getGraphid());
/*  849 */         if (graph == null)
/*      */         {
/*  851 */           GameServer.logger().error("玩家身上的任务图在配置中找不到：graphid：" + graphBean.getGraphid());
/*      */ 
/*      */         }
/*  854 */         else if ((graphBean.getNodebean().getTaskbeans().size() < 1) && 
/*      */         
/*      */ 
/*      */ 
/*  858 */           (!graph.isRingTypeGraph()))
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*  863 */           SNode snode = graph.getNodebyNodeId(graphBean.getNodebean().getNodeid());
/*  864 */           for (STaskToProperty sTaskToProperty : snode.taskIdToProperty)
/*      */           {
/*  866 */             if ((!checkedTasks.contains(Integer.valueOf(sTaskToProperty.taskId))) && ((taskId <= 0) || (sTaskToProperty.taskId == taskId)))
/*      */             {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  872 */               Task task = TaskManager.getTaskById(sTaskToProperty.taskId);
/*  873 */               if (task.containsCondition(type, 1))
/*      */               {
/*  875 */                 TaskBean newTaskBean = createTaskBean(roleId, graphBean.getGraphid(), task.getStask().id, 7);
/*      */                 
/*  877 */                 graphBean.getNodebean().getTaskbeans().put(Integer.valueOf(newTaskBean.getTaskid()), newTaskBean);
/*  878 */                 AcceptTaskCheckResult acRet = task.iscanTake(roleId, new HashMap(), new HashMap(), graph.id());
/*      */                 
/*  880 */                 if (acRet.isCanTake())
/*      */                 {
/*  882 */                   changeTaskState(roleId, 1, graphBean.getGraphid(), newTaskBean, 0);
/*      */                   
/*  884 */                   if (graph.isAutoAcceptTask(graphBean))
/*      */                   {
/*  886 */                     Procedure.execute(new AccpetTaskProcedure(roleId, graph.id(), sTaskToProperty.taskId));
/*      */                   }
/*      */                 }
/*      */                 
/*  890 */                 sendUpdateTaskState(roleId, graphBean.getGraphid(), task.getStask().id, newTaskBean.getTaskstate());
/*      */               }
/*      */             } } } } }
/*      */     GraphBean graphBean;
/*      */     Set<Integer> checkedTasks;
/*      */     Graph graph;
/*  896 */     return true;
/*      */   }
/*      */   
/*      */   private static void updateTaskCon(long roleId, Map<Integer, Object> params, GraphBean graphBean, TaskBean taskBean)
/*      */   {
/*  901 */     updateTaskCon(roleId, params, graphBean, taskBean, null);
/*      */   }
/*      */   
/*      */ 
/*      */   static void updateTaskCon(long roleId, Map<Integer, Object> params, GraphBean graphBean, TaskBean taskBean, PVEFightEndArg arg)
/*      */   {
/*  907 */     Task task = TaskManager.getTaskById(taskBean.getTaskid());
/*  908 */     if (task == null)
/*      */     {
/*  910 */       return;
/*      */     }
/*  912 */     int originalState = taskBean.getTaskstate();
/*  913 */     Set<Integer> types = params.keySet();
/*  914 */     Iterator i$; Iterator i$; if ((taskBean.getTaskstate() == 6) || (taskBean.getTaskstate() == 7))
/*      */     {
/*      */ 
/*  917 */       for (i$ = types.iterator(); i$.hasNext();) { int type = ((Integer)i$.next()).intValue();
/*  918 */         if (task.containsCondition(type, 1))
/*      */         {
/*  920 */           AcceptTaskCheckResult acRet = task.iscanTake(roleId, new HashMap(), new HashMap(), graphBean.getGraphid());
/*      */           
/*  922 */           if (acRet.isCanTake())
/*      */           {
/*  924 */             changeTaskState(roleId, 1, graphBean.getGraphid(), taskBean, 0, arg);
/*      */             
/*  926 */             Graph graph = GraphManager.getGraphById(graphBean.getGraphid());
/*  927 */             if (graph == null)
/*      */             {
/*  929 */               GameServer.logger().error(String.format("[task]roleTaskManager.updateTaskCon@role own one no cfg graphId!|roleId=%d|graphId=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(graphBean.getGraphid()) }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */             }
/*  935 */             else if (graph.isAutoAcceptTask(graphBean))
/*      */             {
/*  937 */               if (graph.isAutoAcceptTask(graphBean))
/*      */               {
/*  939 */                 Procedure.execute(new AccpetTaskProcedure(roleId, graph.id(), taskBean.getTaskid())); }
/*      */             }
/*      */           }
/*      */         }
/*      */       }
/*      */     } else {
/*      */       Iterator i$;
/*  946 */       if (taskBean.getTaskstate() == 2)
/*      */       {
/*  948 */         for (i$ = types.iterator(); i$.hasNext();) { int type = ((Integer)i$.next()).intValue();
/*      */           
/*  950 */           if (task.containsCondition(type, 2))
/*      */           {
/*  952 */             if (task.isCanFinish(roleId, taskBean.getConmap(), params, graphBean.getGraphid()))
/*      */             {
/*  954 */               changeTaskState(roleId, 3, graphBean.getGraphid(), taskBean, 0, arg);
/*      */             }
/*      */             
/*      */           }
/*      */         }
/*  959 */       } else if (taskBean.getTaskstate() == 3)
/*      */       {
/*  961 */         for (i$ = types.iterator(); i$.hasNext();) { int type = ((Integer)i$.next()).intValue();
/*      */           
/*  963 */           if (task.containsCondition(type, 2))
/*      */           {
/*  965 */             if (!task.isCanFinish(roleId, taskBean.getConmap(), params, graphBean.getGraphid()))
/*      */             {
/*  967 */               changeTaskState(roleId, 2, graphBean.getGraphid(), taskBean, 0, arg); }
/*      */           }
/*      */         }
/*      */       }
/*      */     }
/*  972 */     if (taskBean.getTaskstate() == 3)
/*      */     {
/*  974 */       if (task.getStask().autoFinish)
/*      */       {
/*  976 */         new FinishTaskProcedure(roleId, graphBean.getGraphid(), taskBean.getTaskid(), new ArrayList(), new ArrayList()).execute();
/*      */       }
/*      */     }
/*      */     
/*  980 */     if (originalState != taskBean.getTaskstate())
/*      */     {
/*  982 */       sendUpdateTaskState(roleId, graphBean.getGraphid(), taskBean.getTaskid(), taskBean.getTaskstate(), arg);
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
/*      */   static boolean changeTaskFinishImpl(long roleId, int graphId, int taskId)
/*      */   {
/*  999 */     Graph graph = GraphManager.getGraphById(graphId);
/* 1000 */     if (graph == null)
/*      */     {
/* 1002 */       return false;
/*      */     }
/* 1004 */     RoleTask roleTask = getRoleTask(roleId, true);
/* 1005 */     if (roleTask == null)
/*      */     {
/* 1007 */       return false;
/*      */     }
/*      */     
/* 1010 */     GraphBean graphBean = roleTask.getGraphBean(graphId);
/* 1011 */     if (graphBean == null)
/*      */     {
/* 1013 */       return false;
/*      */     }
/* 1015 */     Task task = TaskManager.getTaskById(taskId);
/* 1016 */     if (task == null)
/*      */     {
/* 1018 */       return false;
/*      */     }
/* 1020 */     TaskBean taskBean = roleTask.getTaskBean(graph.getSgraph().id, taskId);
/* 1021 */     changeTaskState(roleId, 3, graphBean.getGraphid(), taskBean, 0);
/* 1022 */     sendUpdateTaskState(roleId, graphBean.getGraphid(), taskBean.getTaskid(), taskBean.getTaskstate());
/* 1023 */     return true;
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
/*      */   static boolean checkAndGetLock(List<Long> roleIds)
/*      */   {
/* 1036 */     Long teamId = TeamInterface.getTeamidByRoleid(((Long)roleIds.get(0)).longValue(), false);
/* 1037 */     if (teamId == null)
/*      */     {
/* 1039 */       List<String> userIds = new ArrayList();
/* 1040 */       for (Iterator i$ = roleIds.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*      */         
/* 1042 */         userIds.add(RoleInterface.getUserId(roleId));
/*      */       }
/* 1044 */       Lockeys.lock(User.getTable(), userIds);
/* 1045 */       Lockeys.lock(Role2task.getTable(), roleIds);
/* 1046 */       if (TeamInterface.getTeamidByRoleid(((Long)roleIds.get(0)).longValue(), false) != null)
/*      */       {
/*      */ 
/* 1049 */         return false;
/*      */       }
/*      */     }
/*      */     else
/*      */     {
/* 1054 */       List<Long> teamMemberList = TeamInterface.getTeamMemberList(teamId.longValue(), false);
/* 1055 */       List<String> lockUserList = new ArrayList();
/* 1056 */       List<Long> lockRoleList = new ArrayList();
/* 1057 */       lockRoleList.addAll(teamMemberList);
/* 1058 */       for (Iterator i$ = roleIds.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*      */         
/* 1060 */         if (!lockRoleList.contains(Long.valueOf(roleId)))
/*      */         {
/*      */ 
/*      */ 
/* 1064 */           lockUserList.add(RoleInterface.getUserId(roleId));
/* 1065 */           lockRoleList.add(Long.valueOf(roleId));
/*      */         }
/*      */       }
/* 1068 */       Lockeys.lock(User.getTable(), lockUserList);
/* 1069 */       Lockeys.lock(Role2task.getTable(), lockRoleList);
/*      */       
/* 1071 */       Lockeys.lock(Lockeys.get(Team.getTable(), teamId));
/*      */       
/* 1073 */       List<Long> teamMemberAgainList = TeamInterface.getTeamMemberList(teamId.longValue(), false);
/*      */       
/* 1075 */       if (!teamMemberList.equals(teamMemberAgainList))
/*      */       {
/*      */ 
/* 1078 */         return false;
/*      */       }
/*      */     }
/*      */     
/* 1082 */     return true;
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
/*      */   static boolean acceptTask(long roleId, Task task, Graph graph)
/*      */   {
/* 1098 */     String userid = RoleInterface.getUserId(roleId);
/* 1099 */     Lockeys.lock(Lockeys.get(User.getTable(), userid));
/*      */     
/* 1101 */     RoleTask roleTask = getRoleTask(roleId, true);
/* 1102 */     if (roleTask.getTaskDataBean() == null)
/*      */     {
/* 1104 */       return false;
/*      */     }
/* 1106 */     GraphBean graphBean = roleTask.getGraphBean(graph.getSgraph().id);
/* 1107 */     TaskBean taskBean = roleTask.getTaskBean(graph.getSgraph().id, task.getStask().id);
/* 1108 */     List<Integer> operTeamTypeList = new ArrayList();
/* 1109 */     operTeamTypeList.add(Integer.valueOf(3));
/* 1110 */     if (!innerAcceptTask(roleId, graphBean, taskBean, operTeamTypeList))
/*      */     {
/* 1112 */       return false;
/*      */     }
/*      */     
/*      */ 
/* 1116 */     if (graph.getSgraph().isRingTypeGraph)
/*      */     {
/* 1118 */       if ((graphBean.getNodebean().getTaskbeans().size() == 1) && (graphBean.getAllfinishcount() == 0))
/*      */       {
/* 1120 */         sendGraphCurRing(roleId, graphBean, 4, true);
/*      */       }
/*      */     }
/*      */     
/* 1124 */     return true;
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
/*      */   static boolean innerAcceptTask(long roleId, GraphBean graphBean, TaskBean taskBean, List<Integer> operTeamTypeList)
/*      */   {
/* 1139 */     if ((graphBean == null) || (taskBean == null))
/*      */     {
/* 1141 */       return false;
/*      */     }
/* 1143 */     if (taskBean.getTaskstate() != 1)
/*      */     {
/* 1145 */       return false;
/*      */     }
/* 1147 */     Graph graph = GraphManager.getGraphById(graphBean.getGraphid());
/* 1148 */     Task task = TaskManager.getTaskById(taskBean.getTaskid());
/*      */     
/* 1150 */     for (Integer operTeamType : operTeamTypeList)
/*      */     {
/* 1152 */       if (!task.checkOperation(roleId, 1, operTeamType.intValue(), new HashMap(), true))
/*      */       {
/*      */ 
/* 1155 */         return false;
/*      */       }
/*      */     }
/* 1158 */     for (Integer operTeamType : operTeamTypeList)
/*      */     {
/* 1160 */       if (!task.excuteOperation(roleId, 1, operTeamType.intValue(), new HashMap(), graphBean.getGraphid(), true))
/*      */       {
/*      */ 
/* 1163 */         return false;
/*      */       }
/*      */     }
/*      */     
/* 1167 */     changeTaskState(roleId, 2, graphBean.getGraphid(), taskBean, 0);
/*      */     
/* 1169 */     checkAndUpdateTask(roleId, graphBean.getGraphid(), taskBean);
/*      */     
/*      */ 
/* 1172 */     if (task.isCanFinish(roleId, taskBean.getConmap(), new HashMap(), graph.getSgraph().id))
/*      */     {
/* 1174 */       changeTaskState(roleId, 3, graphBean.getGraphid(), taskBean, 0);
/* 1175 */       if (task.getStask().autoFinish)
/*      */       {
/* 1177 */         new FinishTaskProcedure(roleId, graphBean.getGraphid(), task.getStask().id, new ArrayList(), new ArrayList()).execute();
/*      */       }
/*      */     }
/*      */     
/*      */ 
/* 1182 */     sendUpdateTaskState(roleId, graphBean.getGraphid(), taskBean.getTaskid(), taskBean.getTaskstate());
/* 1183 */     return true;
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
/*      */   static boolean acceptTeamTask(long roleId, final Task task, Graph graph, int tryCount)
/*      */   {
/* 1203 */     if (graph.isTeamGraph())
/*      */     {
/* 1205 */       return TeamGraphManager.acceptTeamGraphTask(roleId, task, graph, tryCount);
/*      */     }
/* 1207 */     if (!checkAndGetLock(Arrays.asList(new Long[] { Long.valueOf(roleId) })))
/*      */     {
/* 1209 */       return false;
/*      */     }
/* 1211 */     RoleTask roleTask = getRoleTask(roleId, true);
/* 1212 */     GraphBean graphBean = roleTask.getGraphBean(graph.getSgraph().id);
/* 1213 */     TaskBean taskBean = roleTask.getTaskBean(graph.getSgraph().id, task.getStask().id);
/* 1214 */     List<Integer> operTeamTypeList = new ArrayList();
/* 1215 */     operTeamTypeList.add(Integer.valueOf(3));
/*      */     
/* 1217 */     if (!innerAcceptTask(roleId, graphBean, taskBean, operTeamTypeList))
/*      */     {
/* 1219 */       return false;
/*      */     }
/*      */     
/* 1222 */     Long teamId = TeamInterface.getTeamidByRoleid(roleId, false);
/* 1223 */     long teamLeaderId; List<Long> teamMemberList; Iterator i$; if (teamId != null)
/*      */     {
/* 1225 */       teamLeaderId = TeamInterface.getTeamLeaderByTeamid(teamId.longValue(), false);
/* 1226 */       if (teamLeaderId == roleId)
/*      */       {
/* 1228 */         teamMemberList = TeamInterface.getTeamMemberList(teamId.longValue(), false);
/*      */         
/* 1230 */         for (i$ = teamMemberList.iterator(); i$.hasNext();) { final long memberRoleId = ((Long)i$.next()).longValue();
/*      */           
/* 1232 */           if (memberRoleId != teamLeaderId)
/*      */           {
/*      */ 
/*      */ 
/* 1236 */             if (TeamInterface.getTeamMemberStatus(memberRoleId) == 0) {
/* 1237 */               new LogicProcedure()
/*      */               {
/*      */ 
/*      */                 protected boolean processImp()
/*      */                   throws Exception
/*      */                 {
/* 1243 */                   List<String> userList = new ArrayList();
/* 1244 */                   for (Iterator i$ = this.val$teamMemberList.iterator(); i$.hasNext();) { long tmpRoleId = ((Long)i$.next()).longValue();
/*      */                     
/* 1246 */                     userList.add(RoleInterface.getUserId(tmpRoleId));
/*      */                   }
/* 1248 */                   Lockeys.lock(User.getTable(), userList);
/* 1249 */                   Lockeys.lock(Role2task.getTable(), this.val$teamMemberList);
/* 1250 */                   return RoleTaskManager.teamerTryAcceptTask(memberRoleId, task, this.val$task.getStask().id);
/*      */                 }
/*      */               }.execute();
/*      */             }
/*      */           }
/*      */         }
/*      */       }
/*      */     }
/* 1258 */     return true;
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
/*      */   private static boolean teamerTryAcceptTask(long memberRoleId, GraphBean teamLeaderGraphBean, int taskId)
/*      */   {
/* 1338 */     RoleTask roleMemTask = getRoleTask(memberRoleId, true);
/* 1339 */     Graph graph = GraphManager.getGraphById(teamLeaderGraphBean.getGraphid());
/* 1340 */     Task task = TaskManager.getTaskById(taskId);
/* 1341 */     GraphBean graphMemBean = roleMemTask.getGraphBean(graph.getSgraph().id);
/* 1342 */     TaskBean taskMemBean = roleMemTask.getTaskBean(graph.getSgraph().id, task.getStask().id);
/*      */     
/*      */ 
/*      */ 
/*      */ 
/* 1347 */     List<Integer> operTeamerList = new ArrayList();
/* 1348 */     operTeamerList.add(Integer.valueOf(3));
/*      */     
/* 1350 */     if (graph.getSgraph().teamTaskGraph)
/*      */     {
/*      */ 
/* 1353 */       if (graphMemBean == null)
/*      */       {
/*      */ 
/* 1356 */         return false;
/*      */       }
/* 1358 */       for (TaskBean taskBean : graphMemBean.getNodebean().getTaskbeans().values())
/*      */       {
/* 1360 */         sendUpdateTaskState(memberRoleId, graph.getSgraph().id, taskBean.getTaskid(), 4);
/*      */       }
/*      */       
/* 1363 */       graphMemBean.getNodebean().getTaskbeans().clear();
/*      */       
/*      */ 
/* 1366 */       checkIsGraphScheduleSame(memberRoleId, teamLeaderGraphBean, graphMemBean);
/*      */       
/* 1368 */       AcceptTaskCheckResult acRet = task.iscanTake(memberRoleId, new HashMap(), new HashMap(), graph.id());
/*      */       
/* 1370 */       if (acRet.isCanTake())
/*      */       {
/* 1372 */         TaskBean newTaskMemBean = createTaskBean(memberRoleId, graphMemBean.getGraphid(), task.getStask().id, 1);
/*      */         
/* 1374 */         graphMemBean.getNodebean().getTaskbeans().put(Integer.valueOf(newTaskMemBean.getTaskid()), newTaskMemBean);
/*      */         
/* 1376 */         if (graph.getSgraph().isRingTypeGraph)
/*      */         {
/* 1378 */           if ((graphMemBean.getNodebean().getTaskbeans().size() == 1) && (graphMemBean.getAllfinishcount() == 0))
/*      */           {
/* 1380 */             sendGraphCurRing(memberRoleId, graphMemBean, 4, true);
/*      */           }
/*      */         }
/* 1383 */         if (!innerAcceptTask(memberRoleId, graphMemBean, newTaskMemBean, operTeamerList))
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/* 1388 */           return false;
/*      */         }
/*      */         
/*      */       }
/*      */       
/*      */ 
/*      */     }
/* 1395 */     else if ((taskMemBean != null) && (teamLeaderGraphBean.getNodebean().getNodeid() == graphMemBean.getNodebean().getNodeid()))
/*      */     {
/* 1397 */       if (!innerAcceptTask(memberRoleId, graphMemBean, taskMemBean, operTeamerList))
/*      */       {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 1404 */         return false;
/*      */       }
/*      */     }
/*      */     
/*      */ 
/* 1409 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private static void checkIsGraphScheduleSame(long memberRoleId, GraphBean teamLeaderGraphBean, GraphBean graphMemBean)
/*      */   {
/* 1421 */     graphMemBean.getNodebean().setFinishcount(teamLeaderGraphBean.getNodebean().getFinishcount());
/* 1422 */     graphMemBean.getNodebean().setNodeid(teamLeaderGraphBean.getNodebean().getNodeid());
/* 1423 */     if (graphMemBean.getAllfinishcount() != teamLeaderGraphBean.getAllfinishcount())
/*      */     {
/* 1425 */       graphMemBean.setAllfinishcount(teamLeaderGraphBean.getAllfinishcount());
/*      */       
/* 1427 */       if (GraphManager.getGraphById(graphMemBean.getGraphid()).isRingTypeGraph())
/*      */       {
/* 1429 */         sendGraphCurRing(memberRoleId, graphMemBean, 3, GraphManager.getGraphById(graphMemBean.getGraphid()).isRingTypeGraph());
/*      */       }
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
/*      */   static boolean finishTask(long roleId, Task task, Graph graph, Map<Integer, Object> operMap, boolean isHandUp)
/*      */   {
/* 1448 */     RoleTask roleTask = getRoleTask(roleId, true);
/* 1449 */     int graphId = graph.getSgraph().id;
/* 1450 */     int taskId = task.getStask().id;
/* 1451 */     TaskBean taskBean = roleTask.getTaskBean(graphId, taskId);
/* 1452 */     GraphBean graphBean = roleTask.getGraphBean(graphId);
/* 1453 */     return finishSingleTask(roleId, taskBean, graphBean, operMap, isHandUp);
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
/*      */   static boolean finishSingleTask(long roleId, TaskBean taskBean, GraphBean graphBean, Map<Integer, Object> operMap, boolean isHandUp)
/*      */   {
/* 1469 */     List<Integer> teamTypeList = new ArrayList();
/* 1470 */     teamTypeList.add(Integer.valueOf(3));
/* 1471 */     if (!innerFinishTask(roleId, taskBean, graphBean, teamTypeList, operMap, isHandUp))
/*      */     {
/* 1473 */       return false;
/*      */     }
/* 1475 */     afterFinishTask(roleId, taskBean, graphBean);
/* 1476 */     return true;
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
/*      */   static boolean innerFinishTask(long roleId, TaskBean taskBean, GraphBean graphBean, List<Integer> operTeamType, Map<Integer, Object> operParamMap, boolean isHandUp)
/*      */   {
/* 1492 */     if ((taskBean == null) || (graphBean == null))
/*      */     {
/* 1494 */       return false;
/*      */     }
/* 1496 */     if (taskBean.getTaskstate() != 3)
/*      */     {
/* 1498 */       return false;
/*      */     }
/* 1500 */     if (BanGraphInterface.isGraphBan(graphBean.getGraphid(), 2))
/*      */     {
/* 1502 */       GameServer.logger().info(String.format("[task]roleTaskManager.innerFinishTask@ graph is baned!|roleId=%d|graphId=%d|taskId=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(graphBean.getGraphid()), Integer.valueOf(taskBean.getTaskid()) }));
/*      */       
/*      */ 
/* 1505 */       return false;
/*      */     }
/* 1507 */     Task task = TaskManager.getTaskById(taskBean.getTaskid());
/* 1508 */     for (Integer teamType : operTeamType)
/*      */     {
/* 1510 */       if (!task.checkOperation(roleId, 2, teamType.intValue(), operParamMap, isHandUp))
/*      */       {
/* 1512 */         return false;
/*      */       }
/*      */     }
/* 1515 */     for (Integer teamType : operTeamType)
/*      */     {
/* 1517 */       if (!task.excuteOperation(roleId, 2, teamType.intValue(), operParamMap, graphBean.getGraphid(), isHandUp))
/*      */       {
/*      */ 
/* 1520 */         return false;
/*      */       }
/*      */     }
/* 1523 */     return true;
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
/*      */   static boolean finishTeamTask(long roleId, final Task task, Graph graph, Map<Integer, Object> operParamMap)
/*      */   {
/* 1543 */     if (graph.isTeamGraph())
/*      */     {
/* 1545 */       return finishTeamGraphTask(roleId, task, graph, operParamMap);
/*      */     }
/*      */     
/*      */ 
/* 1549 */     if (!checkAndGetLock(Arrays.asList(new Long[] { Long.valueOf(roleId) })))
/*      */     {
/* 1551 */       return false;
/*      */     }
/*      */     
/* 1554 */     RoleTask roleTask = getRoleTask(roleId, true);
/* 1555 */     GraphBean graphBean = roleTask.getGraphBean(graph.getSgraph().id);
/* 1556 */     TaskBean taskBean = roleTask.getTaskBean(graph.getSgraph().id, task.getStask().id);
/* 1557 */     List<Integer> teamTypeList = new ArrayList();
/*      */     
/* 1559 */     teamTypeList.add(Integer.valueOf(3));
/* 1560 */     if (!innerFinishTask(roleId, taskBean, graphBean, teamTypeList, operParamMap, true))
/*      */     {
/* 1562 */       return false;
/*      */     }
/*      */     
/* 1565 */     afterFinishTask(roleId, taskBean, graphBean);
/*      */     
/* 1567 */     Long teamId = TeamInterface.getTeamidByRoleid(roleId, false);
/* 1568 */     long teamLeaderId; List<Long> teamMemberList; Iterator i$; if (teamId != null)
/*      */     {
/* 1570 */       teamLeaderId = TeamInterface.getTeamLeaderByTeamid(teamId.longValue(), false);
/* 1571 */       if (teamLeaderId == roleId)
/*      */       {
/* 1573 */         teamMemberList = TeamInterface.getTeamMemberList(teamId.longValue(), false);
/* 1574 */         for (i$ = teamMemberList.iterator(); i$.hasNext();) { final long memberRoleId = ((Long)i$.next()).longValue();
/*      */           
/* 1576 */           if (memberRoleId != teamLeaderId)
/*      */           {
/*      */ 
/*      */ 
/* 1580 */             if (TeamInterface.getTeamMemberStatus(memberRoleId) == 0)
/*      */             {
/* 1582 */               new LogicProcedure()
/*      */               {
/*      */ 
/*      */                 protected boolean processImp()
/*      */                   throws Exception
/*      */                 {
/* 1588 */                   List<String> userList = new ArrayList();
/* 1589 */                   for (Iterator i$ = this.val$teamMemberList.iterator(); i$.hasNext();) { long tmpRoleId = ((Long)i$.next()).longValue();
/*      */                     
/* 1591 */                     userList.add(RoleInterface.getUserId(tmpRoleId));
/*      */                   }
/* 1593 */                   Lockeys.lock(User.getTable(), userList);
/* 1594 */                   Lockeys.lock(Role2task.getTable(), this.val$teamMemberList);
/* 1595 */                   RoleTask roleMemTask = RoleTaskManager.getRoleTask(memberRoleId, true);
/* 1596 */                   GraphBean graphMemBean = roleMemTask.getGraphBean(task.getSgraph().id);
/* 1597 */                   TaskBean taskMemBean = roleMemTask.getTaskBean(task.getSgraph().id, this.val$task.getStask().id);
/* 1598 */                   List<Integer> teamTypeList2 = new ArrayList();
/* 1599 */                   teamTypeList2.add(Integer.valueOf(3));
/*      */                   
/* 1601 */                   if (!RoleTaskManager.innerFinishTask(memberRoleId, taskMemBean, graphMemBean, teamTypeList2, new HashMap(), true))
/*      */                   {
/* 1603 */                     return false;
/*      */                   }
/* 1605 */                   RoleTaskManager.afterFinishTask(memberRoleId, taskMemBean, graphMemBean);
/* 1606 */                   return true;
/*      */                 }
/*      */               }.execute(); }
/*      */           }
/*      */         }
/*      */       }
/*      */     }
/* 1613 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   private static boolean finishTeamGraphTask(long roleId, Task task, Graph graph, Map<Integer, Object> operParamMap)
/*      */   {
/* 1619 */     Long teamId = TeamInterface.getTeamidByRoleid(roleId, false);
/* 1620 */     if (teamId == null)
/*      */     {
/* 1622 */       return false;
/*      */     }
/* 1624 */     long teamLeaderId = TeamInterface.getTeamLeaderByTeamid(teamId.longValue(), false);
/*      */     
/* 1626 */     if (teamLeaderId != roleId)
/*      */     {
/* 1628 */       return false;
/*      */     }
/*      */     
/*      */ 
/* 1632 */     if (!checkAndGetLock(Arrays.asList(new Long[] { Long.valueOf(roleId) })))
/*      */     {
/* 1634 */       return false;
/*      */     }
/*      */     
/* 1637 */     List<Long> teamMemberList = TeamInterface.getTeamMemberList(teamId.longValue(), false);
/*      */     
/*      */ 
/* 1640 */     RoleTask roleTask = getRoleTask(teamLeaderId, true);
/* 1641 */     GraphBean graphBean = roleTask.getGraphBean(graph.getSgraph().id);
/* 1642 */     TaskBean taskBean = roleTask.getTaskBean(graph.getSgraph().id, task.getStask().id);
/* 1643 */     List<Integer> teamTypeList = new ArrayList();
/*      */     
/* 1645 */     teamTypeList.add(Integer.valueOf(3));
/*      */     
/* 1647 */     if (!innerFinishTask(teamLeaderId, taskBean, graphBean, teamTypeList, operParamMap, true))
/*      */     {
/* 1649 */       return false;
/*      */     }
/*      */     
/* 1652 */     afterFinishTask(teamLeaderId, taskBean, graphBean);
/* 1653 */     boolean closed = false;
/* 1654 */     graphBean = roleTask.getGraphBean(graph.getSgraph().id);
/* 1655 */     if (graphBean == null)
/*      */     {
/* 1657 */       closed = true;
/*      */     }
/* 1659 */     return teamMemberFinishTask(task, graph, teamLeaderId, teamMemberList, closed);
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
/*      */   static boolean teamMemberFinishTask(Task task, Graph graph, long teamLeaderId, List<Long> teamMemberList, boolean closed)
/*      */   {
/* 1676 */     for (Iterator i$ = teamMemberList.iterator(); i$.hasNext();) { long memberRoleId = ((Long)i$.next()).longValue();
/*      */       
/* 1678 */       if (memberRoleId != teamLeaderId)
/*      */       {
/*      */ 
/*      */ 
/* 1682 */         if (TeamInterface.getTeamMemberStatus(memberRoleId) == 0)
/*      */         {
/* 1684 */           RoleTask roleMemTask = getRoleTask(memberRoleId, true);
/* 1685 */           GraphBean graphMemBean = roleMemTask.getGraphBean(graph.getSgraph().id);
/* 1686 */           TaskBean taskMemBean = roleMemTask.getTaskBean(graph.getSgraph().id, task.getStask().id);
/*      */           
/* 1688 */           if (graphMemBean == null)
/*      */           {
/* 1690 */             if (logger.isDebugEnabled())
/*      */             {
/* 1692 */               logger.debug("[" + RoleInterface.getName(memberRoleId) + "]没有此图[" + graph.getSgraph().id + "]");
/*      */             }
/*      */             
/*      */           }
/* 1696 */           else if (taskMemBean == null)
/*      */           {
/* 1698 */             if (logger.isDebugEnabled())
/*      */             {
/* 1700 */               logger.debug("[" + RoleInterface.getName(memberRoleId) + "]没有此任务[" + task.getStask().id + "]");
/*      */             }
/*      */           }
/*      */           else
/*      */           {
/* 1705 */             List<Integer> teamTypeList2 = new ArrayList();
/* 1706 */             teamTypeList2.add(Integer.valueOf(3));
/*      */             
/* 1708 */             if (!innerFinishTask(memberRoleId, taskMemBean, graphMemBean, teamTypeList2, new HashMap(), true))
/*      */             {
/*      */ 
/* 1711 */               if (logger.isDebugEnabled())
/*      */               {
/* 1713 */                 logger.debug("队员没有完成任务:任务id:" + task.getStask().id + " 图id:" + graph.id());
/*      */               }
/*      */               
/*      */             }
/*      */             else
/* 1718 */               graph.afterTeamerFinishTeamGraphTask(memberRoleId, taskMemBean, graphMemBean, graph, closed);
/*      */           }
/*      */         } } }
/* 1721 */     return true;
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
/*      */   static boolean giveUpTask(long roleId, Task task, Graph graph)
/*      */   {
/* 1736 */     RoleTask roleTask = getRoleTask(roleId, true);
/* 1737 */     if (roleTask.getTaskDataBean() == null)
/*      */     {
/* 1739 */       return false;
/*      */     }
/* 1741 */     GraphBean graphBean = roleTask.getGraphBean(graph.getSgraph().id);
/* 1742 */     TaskBean taskBean = roleTask.getTaskBean(graph.getSgraph().id, task.getStask().id);
/* 1743 */     if ((graphBean == null) || (taskBean == null))
/*      */     {
/* 1745 */       return false;
/*      */     }
/* 1747 */     List<Integer> operTeamList = new ArrayList();
/* 1748 */     operTeamList.add(Integer.valueOf(3));
/*      */     
/* 1750 */     long taskLastTime = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis()) - taskBean.getTaskstarttime();
/* 1751 */     TaskLogManager.addTaskLog(roleId, graphBean.getGraphid(), taskBean.getTaskid(), 9, 0, taskLastTime);
/*      */     
/* 1753 */     if (innerGiveUpTask(roleTask, graphBean, taskBean, operTeamList))
/*      */     {
/*      */ 
/* 1756 */       boolean isToEndTask = graphBean.getAllfinishcount() >= getGraphAllTaskNum(graph.id());
/* 1757 */       TriggerEventsManger.getInstance().triggerEvent(new TaskStateChange(), new TaskEventArg(roleId, graphBean.getGraphid(), taskBean.getTaskid(), 9, graphBean.getAllfinishcount(), isToEndTask));
/*      */       
/*      */ 
/*      */ 
/*      */ 
/* 1762 */       if (isToEndTask)
/*      */       {
/* 1764 */         TriggerEventsManger.getInstance().triggerEvent(new GraphFinish(), new GraphFinishArg(roleId, graphBean.getGraphid()));
/*      */       }
/*      */     }
/*      */     
/* 1768 */     return true;
/*      */   }
/*      */   
/*      */   private static boolean innerGiveUpTask(RoleTask roleTask, GraphBean graphBean, TaskBean taskBean, List<Integer> operTeamList)
/*      */   {
/* 1773 */     if ((graphBean == null) || (taskBean == null))
/*      */     {
/*      */ 
/* 1776 */       return false;
/*      */     }
/* 1778 */     Graph graph = GraphManager.getGraphById(graphBean.getGraphid());
/* 1779 */     Task task = TaskManager.getTaskById(taskBean.getTaskid());
/* 1780 */     if (graph.getSgraph().canGiveUpTask)
/*      */     {
/* 1782 */       for (Integer operTeam : operTeamList)
/*      */       {
/* 1784 */         if (!task.checkOperation(roleTask.getRoleId(), 4, operTeam.intValue(), new HashMap(), true))
/*      */         {
/*      */ 
/* 1787 */           return false;
/*      */         }
/*      */       }
/* 1790 */       for (Integer operTeam : operTeamList)
/*      */       {
/* 1792 */         if (!task.excuteOperation(roleTask.getRoleId(), 4, operTeam.intValue(), new HashMap(), graphBean.getGraphid(), true))
/*      */         {
/*      */ 
/* 1795 */           return false;
/*      */         }
/*      */       }
/*      */     }
/*      */     else
/*      */     {
/* 1801 */       return false;
/*      */     }
/*      */     
/* 1804 */     return graph.afterGiveUpTask(roleTask.getRoleId(), taskBean, graphBean);
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
/*      */   static boolean giveUpTeamTask(long roleId, final Task task, Graph graph)
/*      */   {
/* 1850 */     if (!checkAndGetLock(Arrays.asList(new Long[] { Long.valueOf(roleId) })))
/*      */     {
/* 1852 */       return false;
/*      */     }
/* 1854 */     if (!graph.isTeamGraph())
/*      */     {
/*      */ 
/* 1857 */       return giveUpTask(roleId, task, graph);
/*      */     }
/*      */     
/* 1860 */     Long teamId = TeamInterface.getTeamidByRoleid(roleId, false);
/* 1861 */     if (teamId == null)
/*      */     {
/* 1863 */       return false;
/*      */     }
/* 1865 */     long teamLeaderId = TeamInterface.getTeamLeaderByTeamid(teamId.longValue(), false);
/* 1866 */     if (teamLeaderId != roleId)
/*      */     {
/*      */ 
/* 1869 */       return false;
/*      */     }
/* 1871 */     List<Long> teamMemberList = TeamInterface.getTeamMemberList(teamId.longValue(), false);
/*      */     
/* 1873 */     RoleTask roleTask = getRoleTask(teamLeaderId, true);
/* 1874 */     GraphBean graphBean = roleTask.getGraphBean(graph.getSgraph().id);
/* 1875 */     TaskBean taskBean = roleTask.getTaskBean(graph.getSgraph().id, task.getStask().id);
/* 1876 */     List<Integer> operTeamLeader = new ArrayList();
/*      */     
/* 1878 */     operTeamLeader.add(Integer.valueOf(3));
/* 1879 */     if (!innerGiveUpTask(roleTask, graphBean, taskBean, operTeamLeader))
/*      */     {
/* 1881 */       return false;
/*      */     }
/*      */     
/*      */ 
/* 1885 */     final List<Integer> operTeamerList = new ArrayList();
/* 1886 */     operTeamerList.add(Integer.valueOf(3));
/* 1887 */     operTeamerList.add(Integer.valueOf(2));
/* 1888 */     for (Iterator i$ = teamMemberList.iterator(); i$.hasNext();) { final long memberRoleId = ((Long)i$.next()).longValue();
/*      */       
/* 1890 */       if (memberRoleId != teamLeaderId)
/*      */       {
/*      */ 
/*      */ 
/* 1894 */         new LogicProcedure()
/*      */         {
/*      */ 
/*      */           protected boolean processImp()
/*      */             throws Exception
/*      */           {
/* 1900 */             List<String> userList = new ArrayList();
/* 1901 */             for (Iterator i$ = this.val$teamMemberList.iterator(); i$.hasNext();) { long tmpRoleId = ((Long)i$.next()).longValue();
/*      */               
/* 1903 */               userList.add(RoleInterface.getUserId(tmpRoleId));
/*      */             }
/* 1905 */             Lockeys.lock(User.getTable(), userList);
/* 1906 */             Lockeys.lock(Role2task.getTable(), this.val$teamMemberList);
/* 1907 */             RoleTask roleMemTask = RoleTaskManager.getRoleTask(memberRoleId, true);
/* 1908 */             GraphBean graphMemBean = roleMemTask.getGraphBean(task.getSgraph().id);
/* 1909 */             TaskBean taskMemBean = roleMemTask.getTaskBean(task.getSgraph().id, operTeamerList.getStask().id);
/* 1910 */             return RoleTaskManager.innerGiveUpTask(roleMemTask, graphMemBean, taskMemBean, this.val$operTeamerList);
/*      */           }
/*      */         }.execute();
/*      */       }
/*      */     }
/*      */     
/* 1916 */     return true;
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
/*      */   public static void sendUpdateTaskState(long roleId, int graphId, int taskId, int taskState)
/*      */   {
/* 1929 */     sendUpdateTaskState(roleId, graphId, taskId, taskState, null);
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
/*      */   public static void sendUpdateTaskState(long roleId, int graphId, int taskId, int taskState, PVEFightEndArg arg)
/*      */   {
/* 1942 */     SUpdateTaskState updataTaskState = new SUpdateTaskState();
/* 1943 */     fillInTaskState(updataTaskState.taskstate, graphId, taskId, taskState);
/* 1944 */     OnlineManager.getInstance().send(roleId, updataTaskState);
/* 1945 */     if (taskState == 4)
/*      */     {
/* 1947 */       trigeerStateChangeEvent(roleId, graphId, taskId, taskState);
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void trigeerStateChangeEvent(long roleId, int graphId, int taskId, int taskState)
/*      */   {
/* 1959 */     trigeerStateChangeEvent(roleId, graphId, taskId, taskState, null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void trigeerStateChangeEvent(long roleId, int graphId, int taskId, int taskState, PVEFightEndArg arg)
/*      */   {
/* 1970 */     if (taskState == 7)
/*      */     {
/*      */ 
/* 1973 */       return;
/*      */     }
/* 1975 */     int taskNo = -1;
/*      */     
/* 1977 */     RoleTask roleTask = getRoleTask(roleId, true);
/* 1978 */     if (roleTask == null)
/*      */     {
/* 1980 */       return;
/*      */     }
/* 1982 */     GraphBean graphBean = roleTask.getGraphBean(graphId);
/* 1983 */     if (graphBean == null)
/*      */     {
/* 1985 */       return;
/*      */     }
/*      */     
/* 1988 */     taskNo = graphBean.getAllfinishcount() + 1;
/*      */     
/* 1990 */     boolean isToEndTask = taskNo >= getGraphAllTaskNum(graphId);
/* 1991 */     TaskEventArg taskArg = new TaskEventArg(roleId, graphId, taskId, taskState, taskNo, isToEndTask);
/* 1992 */     if (arg != null)
/*      */     {
/* 1994 */       fillFightTaskArg(roleId, arg, taskArg);
/*      */     }
/* 1996 */     TriggerEventsManger.getInstance().triggerEvent(new TaskStateChange(), taskArg);
/* 1997 */     if (GameServer.logger().isDebugEnabled())
/*      */     {
/* 1999 */       GameServer.logger().debug(String.format(String.format("[task]task state changed and triggered event!|roleId=%d|graphId|taskId=%d|taskState|name=%s", new Object[] { Long.valueOf(roleId), Integer.valueOf(graphId), Integer.valueOf(taskId), Integer.valueOf(taskState), RoleInterface.getName(roleId) }), new Object[0]));
/*      */     }
/*      */     
/*      */ 
/*      */ 
/* 2004 */     if ((isToEndTask) && (taskState == 8))
/*      */     {
/* 2006 */       TriggerEventsManger.getInstance().triggerEvent(new GraphFinish(), new GraphFinishArg(roleId, graphId));
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private static void fillFightTaskArg(long roleId, PVEFightEndArg arg, TaskEventArg taskArg)
/*      */   {
/* 2017 */     if (arg == null)
/*      */     {
/* 2019 */       return;
/*      */     }
/* 2021 */     if (arg.roleList.size() > 1)
/*      */     {
/* 2023 */       long leaderId = TeamInterface.getTeamLeaderByRoleid(roleId, false, false);
/* 2024 */       if (leaderId > 0L)
/*      */       {
/* 2026 */         taskArg.setLeaderId(leaderId);
/*      */       }
/*      */     }
/* 2029 */     taskArg.setPveArg(arg);
/*      */   }
/*      */   
/*      */   public static void sendConChangeMsg(long roleId, int graphId, int taskId, int conId, long param)
/*      */   {
/* 2034 */     sendConChangeMsg(roleId, graphId, taskId, conId, param, null);
/*      */   }
/*      */   
/*      */   public static void sendConChangeMsg(long roleId, int graphId, int taskId, int conId, long param, String subParam)
/*      */   {
/* 2039 */     SUpdateTaskCon sUpdateTaskCon = new SUpdateTaskCon();
/* 2040 */     sUpdateTaskCon.graphid = graphId;
/* 2041 */     sUpdateTaskCon.taskid = taskId;
/* 2042 */     sUpdateTaskCon.condata.conid = conId;
/* 2043 */     sUpdateTaskCon.condata.param = param;
/* 2044 */     if ((subParam != null) && (!subParam.equals("")))
/*      */     {
/* 2046 */       sUpdateTaskCon.condata.subparam = subParam;
/*      */     }
/* 2048 */     OnlineManager.getInstance().send(roleId, sUpdateTaskCon);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private static void checkAndUpdateTaskGraph(long roleId, RoleTask roleTask)
/*      */   {
/* 2058 */     for (Iterator i$ = roleTask.getTaskDataBean().getGraphbeans().values().iterator(); i$.hasNext();) { graphBean = (GraphBean)i$.next();
/*      */       
/* 2060 */       for (TaskBean taskBean : graphBean.getNodebean().getTaskbeans().values())
/*      */       {
/* 2062 */         int graphId = graphBean.getGraphid();
/* 2063 */         int taskId = taskBean.getTaskid();
/* 2064 */         checkAndUpdateTask(roleTask.getRoleId(), graphBean.getGraphid(), taskBean);
/* 2065 */         checkCanAccept(roleId, graphBean.getGraphid(), taskBean.getTaskid(), taskBean.getTaskstate());
/* 2066 */         checkTaskStateChange(roleId, taskBean, graphId, taskId);
/*      */       }
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */     GraphBean graphBean;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   private static void checkTaskStateChange(long roleId, TaskBean taskBean, int graphId, int taskId)
/*      */   {
/* 2081 */     Task task = TaskManager.getTaskById(taskId);
/* 2082 */     if (task == null)
/*      */     {
/* 2084 */       GameServer.logger().error(String.format("[task]RoleTaskManager.checkTaskStateChange@ task cfg is null!|roleId=%d|graphId=%d|taskId=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(graphId), Integer.valueOf(taskId) }));
/*      */       
/*      */ 
/*      */ 
/* 2088 */       return;
/*      */     }
/* 2090 */     if (taskBean.getTaskstate() == 2)
/*      */     {
/* 2092 */       if (!task.isCanFinish(roleId, taskBean.getConmap(), new HashMap(), graphId))
/*      */       {
/* 2094 */         return;
/*      */       }
/* 2096 */       changeTaskState(roleId, 3, graphId, taskBean, 0);
/* 2097 */       GameServer.logger().info(String.format("[task]RoleTaskManager.checkTaskStateChange@ task State change 2 finish!|roleId=%d|graphId=%d|taskId=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(graphId), Integer.valueOf(taskId) }));
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */ 
/* 2103 */     if ((taskBean.getTaskstate() == 3) && (task.getStask().autoFinish))
/*      */     {
/* 2105 */       new FinishTaskProcedure(roleId, graphId, taskId, new ArrayList(), new ArrayList()).execute();
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
/*      */   static void checkCanAccept(long roleId, int graphId, int taskId, int taskState)
/*      */   {
/* 2122 */     if (taskState != 1)
/*      */     {
/* 2124 */       return;
/*      */     }
/* 2126 */     if (RoleInterface.getLevel(roleId) <= 1)
/*      */     {
/* 2128 */       return;
/*      */     }
/* 2130 */     if (GraphManager.getInstance().getAllCondtionGraphIds().contains(Integer.valueOf(graphId)))
/*      */     {
/* 2132 */       GameServer.logger().error(String.format("[task]RoleTaskManager.checkMainCanAccept@ has accept task!|roleId=%d|graphId=%d|taskId=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(graphId), Integer.valueOf(taskId) }));
/*      */       
/*      */ 
/* 2135 */       Procedure.execute(new AccpetTaskProcedure(roleId, graphId, taskId));
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private static void checkAndUpdateTask(long roleId, int graphId, TaskBean taskBean)
/*      */   {
/* 2147 */     Task task = TaskManager.getTaskById(taskBean.getTaskid());
/* 2148 */     if (task == null)
/*      */     {
/* 2150 */       logger.error("图下的任务找不到,graphId:" + graphId + " taskId:" + taskBean.getTaskid());
/* 2151 */       return;
/*      */     }
/*      */     
/* 2154 */     if ((taskBean.getTaskstate() == 7) || (taskBean.getTaskstate() == 6))
/*      */     {
/*      */ 
/* 2157 */       List<AbsCondition> conditions = task.getCondition(4, 1);
/* 2158 */       for (AbsCondition condition : conditions)
/*      */       {
/* 2160 */         if (!condition.isComplete(roleId, taskBean.getConmap(), new HashMap(), graphId))
/*      */         {
/*      */ 
/*      */ 
/* 2164 */           STaskContoPlace sTaskContoPlace = ((Con_ToPlace_4)condition).getContoPlace();
/*      */           
/* 2166 */           RegisterPlaceManager.addListener(roleId, sTaskContoPlace);
/*      */         } }
/*      */     }
/* 2169 */     if (taskBean.getTaskstate() == 2)
/*      */     {
/* 2171 */       con2PlaceHandle(roleId, graphId, taskBean, task);
/* 2172 */       conPvcHandle(roleId, graphId, task);
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private static void con2PlaceHandle(long roleId, int graphId, TaskBean taskBean, Task task)
/*      */   {
/* 2182 */     List<AbsCondition> conditions = task.getCondition(4, 2);
/* 2183 */     for (AbsCondition condition : conditions)
/*      */     {
/* 2185 */       if (!condition.isComplete(roleId, taskBean.getConmap(), new HashMap(), graphId))
/*      */       {
/*      */ 
/*      */ 
/* 2189 */         STaskContoPlace sTaskContoPlace = ((Con_ToPlace_4)condition).getContoPlace();
/*      */         
/* 2191 */         RegisterPlaceManager.addListener(roleId, sTaskContoPlace);
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   private static void conPvcHandle(long roleId, int graphId, Task task)
/*      */   {
/* 2200 */     List<AbsCondition> conditions = task.getCondition(6, 2);
/* 2201 */     int taskId = task.getTaskId();
/* 2202 */     for (AbsCondition condition : conditions)
/*      */     {
/* 2204 */       Con_KillNpc_6 con = (Con_KillNpc_6)condition;
/* 2205 */       int taskUseId = con.getTaskPvcCfgId();
/* 2206 */       if (taskUseId > 0)
/*      */       {
/*      */ 
/*      */ 
/*      */ 
/* 2211 */         STaskPvcCfg sCfg = TaskManager.getInstance().getSTaskPvcCfg(taskUseId);
/* 2212 */         if (sCfg == null)
/*      */         {
/* 2214 */           return;
/*      */         }
/* 2216 */         RoleTaskPvcManager.onAcceptPvcTask(roleId, graphId, taskId, sCfg.id, con.getConId());
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   static TaskBean createTaskBean(long roleId, int graphId, int taskId, int taskState)
/*      */   {
/* 2223 */     TaskBean taskBean = Pod.newTaskBean();
/* 2224 */     taskBean.setTaskid(taskId);
/* 2225 */     changeTaskState(roleId, taskState, graphId, taskBean, 0);
/* 2226 */     return taskBean;
/*      */   }
/*      */   
/*      */ 
/*      */   static void sendGraphCurRing(long roleId, GraphBean graphBean, int reason, boolean isRingTypeGraph)
/*      */   {
/* 2232 */     if (!isRingTypeGraph)
/*      */     {
/* 2234 */       return;
/*      */     }
/* 2236 */     SSynTaskCurRing sSynTaskCurRing = new SSynTaskCurRing();
/* 2237 */     sSynTaskCurRing.graphid = graphBean.getGraphid();
/* 2238 */     sSynTaskCurRing.reason = reason;
/* 2239 */     if (graphBean.getAllfinishcount() >= getGraphAllTaskNum(graphBean.getGraphid()))
/*      */     {
/* 2241 */       sSynTaskCurRing.curring = 0;
/*      */     }
/*      */     else
/*      */     {
/* 2245 */       sSynTaskCurRing.curring = graphBean.getAllfinishcount();
/*      */     }
/* 2247 */     OnlineManager.getInstance().send(roleId, sSynTaskCurRing);
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
/*      */   static void afterFinishTask(long roleId, TaskBean taskBean, GraphBean graphBean)
/*      */   {
/* 2262 */     Graph graph = GraphManager.getGraphById(graphBean.getGraphid());
/* 2263 */     int finishCount = graphBean.getNodebean().getFinishcount() + 1;
/* 2264 */     int graphTaskFinishCount = graphBean.getAllfinishcount() + 1;
/*      */     
/* 2266 */     changeTaskState(roleId, 8, graphBean.getGraphid(), taskBean, 0);
/*      */     
/* 2268 */     graphBean.getNodebean().getTaskbeans().remove(Integer.valueOf(taskBean.getTaskid()));
/*      */     
/* 2270 */     sendUpdateTaskState(roleId, graph.getSgraph().id, taskBean.getTaskid(), 8);
/*      */     
/* 2272 */     graphBean.getNodebean().setFinishcount(finishCount);
/*      */     
/* 2274 */     graphBean.setAllfinishcount(graphTaskFinishCount);
/*      */     
/* 2276 */     sendGraphCurRing(roleId, graphBean, 1, graph.getSgraph().isRingTypeGraph);
/*      */     
/* 2278 */     graph.afterFinishTask(roleId, taskBean, graphBean);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void onCreateTeam(List<Long> roleIds)
/*      */   {
/* 2289 */     if (roleIds.size() <= 0)
/*      */     {
/* 2291 */       return;
/*      */     }
/* 2293 */     Long teamLeaderId = (Long)roleIds.get(0);
/* 2294 */     RoleTask roleTask = getRoleTask(teamLeaderId.longValue(), true);
/* 2295 */     if (roleTask.getTaskDataBean() == null)
/*      */     {
/* 2297 */       return;
/*      */     }
/* 2299 */     for (int i = 0; i < roleIds.size(); i++)
/*      */     {
/* 2301 */       updateCondition(((Long)roleIds.get(i)).longValue(), -1, 7, new Object());
/*      */     }
/*      */     
/* 2304 */     if (roleIds.size() <= 1)
/*      */     {
/* 2306 */       return;
/*      */     }
/*      */     
/* 2309 */     Map<Integer, GraphBean> graphBeanMap = roleTask.getAllTeamGraph();
/* 2310 */     Long teamerRoleId; for (int i = 1; i < roleIds.size(); i++)
/*      */     {
/* 2312 */       teamerRoleId = (Long)roleIds.get(i);
/* 2313 */       if (teamerRoleId != teamLeaderId)
/*      */       {
/*      */ 
/*      */ 
/* 2317 */         if (TeamInterface.getTeamMemberStatus(teamerRoleId.longValue()) == 0) {
/* 2318 */           for (GraphBean graphTeamLeaderBean : graphBeanMap.values())
/*      */           {
/*      */ 
/* 2321 */             activeGraph(graphTeamLeaderBean.getGraphid(), teamerRoleId.longValue());
/*      */           }
/*      */         }
/*      */       }
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
/*      */   static void copyRoleTeamTaskTo(long roleId, RoleTask fromTaskData)
/*      */   {
/* 2337 */     if (fromTaskData.getTaskDataBean() == null)
/*      */     {
/* 2339 */       return;
/*      */     }
/* 2341 */     Map<Integer, GraphBean> graphBeans = fromTaskData.getAllTeamGraph();
/* 2342 */     copyTeamGraphsTaskto(roleId, graphBeans);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void copyTeamGraphsTaskto(long roleId, Map<Integer, GraphBean> graphBeans)
/*      */   {
/* 2353 */     for (GraphBean graphBean : graphBeans.values())
/*      */     {
/* 2355 */       GraphBean teamerGraphBean = activeGraph(graphBean.getGraphid(), roleId);
/* 2356 */       if (teamerGraphBean != null)
/*      */       {
/*      */ 
/*      */ 
/* 2360 */         copyTeamGraphTaskToRole(roleId, graphBean);
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void copyTeamGraphTaskToRole(long roleId, GraphBean copyGraphBean)
/*      */   {
/* 2372 */     RoleTask roleTask = getRoleTask(roleId, true);
/* 2373 */     GraphBean graphBean = roleTask.getGraphBean(copyGraphBean.getGraphid());
/* 2374 */     if (graphBean == null)
/*      */     {
/* 2376 */       return;
/*      */     }
/*      */     
/* 2379 */     graphBean.setAllfinishcount(copyGraphBean.getAllfinishcount());
/* 2380 */     graphBean.getNodebean().setFinishcount(copyGraphBean.getNodebean().getFinishcount());
/* 2381 */     graphBean.getNodebean().setNodeid(copyGraphBean.getNodebean().getNodeid());
/* 2382 */     for (Map.Entry<Integer, TaskBean> entry : copyGraphBean.getNodebean().getTaskbeans().entrySet())
/*      */     {
/* 2384 */       Task task = TaskManager.getTaskById(((TaskBean)entry.getValue()).getTaskid());
/* 2385 */       if (((TaskBean)entry.getValue()).getTaskstate() == 2)
/*      */       {
/*      */ 
/* 2388 */         if (graphBean.getNodebean().getTaskbeans().containsKey(Integer.valueOf(task.getStask().id)))
/*      */         {
/* 2390 */           TaskBean taskBean = (TaskBean)graphBean.getNodebean().getTaskbeans().get(Integer.valueOf(task.getStask().id));
/* 2391 */           if (taskBean.getTaskstate() == 2) {
/*      */             continue;
/*      */           }
/*      */         }
/*      */         
/* 2396 */         AcceptTaskCheckResult acRet = task.iscanTake(roleId, new HashMap(), new HashMap(), copyGraphBean.getGraphid());
/*      */         
/* 2398 */         if (acRet.isCanTake())
/*      */         {
/* 2400 */           TaskBean taskBean = createTaskBean(roleId, copyGraphBean.getGraphid(), task.getStask().id, 2);
/*      */           
/* 2402 */           graphBean.getNodebean().getTaskbeans().put(Integer.valueOf(task.getStask().id), taskBean);
/* 2403 */           sendUpdateTaskState(roleId, copyGraphBean.getGraphid(), taskBean.getTaskid(), taskBean.getTaskstate());
/*      */         }
/*      */       }
/* 2406 */       if (((TaskBean)entry.getValue()).getTaskstate() == 3)
/*      */       {
/* 2408 */         if (graphBean.getNodebean().getTaskbeans().containsKey(Integer.valueOf(task.getStask().id)))
/*      */         {
/* 2410 */           TaskBean taskBean = (TaskBean)graphBean.getNodebean().getTaskbeans().get(Integer.valueOf(task.getStask().id));
/* 2411 */           if (taskBean.getTaskstate() == 3) {}
/*      */ 
/*      */ 
/*      */         }
/*      */         else
/*      */         {
/*      */ 
/* 2418 */           AcceptTaskCheckResult acRet = task.iscanTake(roleId, new HashMap(), new HashMap(), copyGraphBean.getGraphid());
/*      */           
/* 2420 */           if (acRet.isCanTake())
/*      */           {
/* 2422 */             if (task.isCanFinish(roleId, new HashMap(), new HashMap(), copyGraphBean.getGraphid()))
/*      */             {
/*      */ 
/* 2425 */               TaskBean taskBean = createTaskBean(roleId, copyGraphBean.getGraphid(), task.getStask().id, 3);
/*      */               
/* 2427 */               graphBean.getNodebean().getTaskbeans().put(Integer.valueOf(task.getStask().id), taskBean);
/* 2428 */               sendUpdateTaskState(roleId, copyGraphBean.getGraphid(), taskBean.getTaskid(), taskBean.getTaskstate());
/*      */             }
/*      */           }
/*      */         }
/*      */       }
/*      */     }
/* 2434 */     if (GraphManager.getGraphById(graphBean.getGraphid()).isRingTypeGraph())
/*      */     {
/* 2436 */       sendGraphCurRing(roleId, graphBean, 3, GraphManager.getGraphById(graphBean.getGraphid()).isRingTypeGraph());
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   static boolean isRingTypeGraph(GraphBean graphBean)
/*      */   {
/* 2443 */     return GraphManager.getGraphById(graphBean.getGraphid()).isRingTypeGraph();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void onJoinTeam(long teamerRoleId, boolean isReturnBeforeNormal)
/*      */   {
/* 2454 */     if (!checkAndGetLock(Arrays.asList(new Long[] { Long.valueOf(teamerRoleId) })))
/*      */     {
/* 2456 */       return;
/*      */     }
/*      */     
/* 2459 */     Long teamLeaderId = Long.valueOf(TeamInterface.getTeamLeaderByRoleid(teamerRoleId, false, false));
/* 2460 */     if ((teamLeaderId == null) || (teamLeaderId.longValue() < 0L))
/*      */     {
/* 2462 */       return;
/*      */     }
/* 2464 */     RoleTask roleTask = getRoleTask(teamLeaderId.longValue(), true);
/* 2465 */     if (roleTask.getTaskDataBean() == null)
/*      */     {
/* 2467 */       return;
/*      */     }
/*      */     
/* 2470 */     Long teamId = TeamInterface.getTeamidByRoleid(teamerRoleId, false);
/* 2471 */     List<Long> teamerList = TeamInterface.getTeamMemberList(teamId.longValue(), false);
/*      */     
/* 2473 */     for (Long roleId : teamerList)
/*      */     {
/* 2475 */       updateCondition(roleId.longValue(), -1, 7, new Object());
/*      */     }
/*      */     
/* 2478 */     if (teamerRoleId == teamLeaderId.longValue())
/*      */     {
/* 2480 */       return;
/*      */     }
/*      */     
/* 2483 */     if (TeamInterface.getTeamMemberStatus(teamerRoleId) != 0)
/*      */     {
/* 2485 */       return;
/*      */     }
/* 2487 */     Map<Integer, GraphBean> graphBeans = roleTask.getAllTeamGraph();
/* 2488 */     for (GraphBean graphBean : graphBeans.values())
/*      */     {
/* 2490 */       GraphBean teamerGraphBean = activeGraph(graphBean.getGraphid(), teamerRoleId);
/* 2491 */       if (teamerGraphBean != null)
/*      */       {
/*      */ 
/*      */ 
/*      */ 
/* 2496 */         copyTeamGraphTaskToRole(teamerRoleId, graphBean);
/*      */       }
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
/*      */   static boolean onLeaveTeam(long roleId, long teamId)
/*      */   {
/* 2510 */     RoleTask roleMemTask = getRoleTask(roleId, false);
/* 2511 */     if (roleMemTask.getTaskDataBean() == null)
/*      */     {
/* 2513 */       return true;
/*      */     }
/*      */     
/* 2516 */     Map<Integer, Set<Integer>> graphIdToOwnTaskIds = new HashMap();
/* 2517 */     final Map<Integer, Set<Integer>> graphIdToOtherTaskIds = new HashMap();
/* 2518 */     for (Iterator i$ = roleMemTask.getTaskDataBean().getGraphbeans().values().iterator(); i$.hasNext();) { graphBean = (GraphBean)i$.next();
/*      */       
/* 2520 */       for (TaskBean taskBean : graphBean.getNodebean().getTaskbeans().values())
/*      */       {
/* 2522 */         Task task = TaskManager.getTaskById(taskBean.getTaskid());
/* 2523 */         if ((task != null) && 
/*      */         
/*      */ 
/*      */ 
/* 2527 */           (task.getStask().teamType == 3))
/*      */         {
/*      */ 
/*      */ 
/* 2531 */           Graph graph = GraphManager.getGraphById(graphBean.getGraphid());
/* 2532 */           if (graph.isTeamGraph())
/*      */           {
/*      */ 
/*      */ 
/* 2536 */             if (task.getStask().leaveTaskSet == 2)
/*      */             {
/* 2538 */               if (graphIdToOwnTaskIds.containsKey(Integer.valueOf(graphBean.getGraphid())))
/*      */               {
/* 2540 */                 ((Set)graphIdToOwnTaskIds.get(Integer.valueOf(graphBean.getGraphid()))).add(Integer.valueOf(taskBean.getTaskid()));
/*      */               }
/*      */               else
/*      */               {
/* 2544 */                 HashSet<Integer> set = new HashSet();
/* 2545 */                 set.add(Integer.valueOf(taskBean.getTaskid()));
/* 2546 */                 graphIdToOwnTaskIds.put(Integer.valueOf(graphBean.getGraphid()), set);
/*      */               }
/*      */             }
/* 2549 */             else if (task.getStask().leaveTaskSet == 3)
/*      */             {
/* 2551 */               if (graphIdToOwnTaskIds.containsKey(Integer.valueOf(graphBean.getGraphid())))
/*      */               {
/* 2553 */                 ((Set)graphIdToOwnTaskIds.get(Integer.valueOf(graphBean.getGraphid()))).add(Integer.valueOf(taskBean.getTaskid()));
/*      */               }
/*      */               else
/*      */               {
/* 2557 */                 HashSet<Integer> set = new HashSet();
/* 2558 */                 set.add(Integer.valueOf(taskBean.getTaskid()));
/* 2559 */                 graphIdToOwnTaskIds.put(Integer.valueOf(graphBean.getGraphid()), set);
/*      */               }
/* 2561 */               if (graphIdToOtherTaskIds.containsKey(Integer.valueOf(graphBean.getGraphid())))
/*      */               {
/* 2563 */                 ((Set)graphIdToOtherTaskIds.get(Integer.valueOf(graphBean.getGraphid()))).add(Integer.valueOf(taskBean.getTaskid()));
/*      */               }
/*      */               else
/*      */               {
/* 2567 */                 HashSet<Integer> set = new HashSet();
/* 2568 */                 set.add(Integer.valueOf(taskBean.getTaskid()));
/* 2569 */                 graphIdToOtherTaskIds.put(Integer.valueOf(graphBean.getGraphid()), set);
/*      */               }
/*      */             } }
/*      */         }
/*      */       } }
/*      */     GraphBean graphBean;
/* 2575 */     final List<Long> allTeamer = TeamInterface.getTeamMemberList(teamId, false);
/* 2576 */     allTeamer.add(Long.valueOf(roleId));
/* 2577 */     List<String> userList = new ArrayList();
/* 2578 */     for (Iterator i$ = allTeamer.iterator(); i$.hasNext();) { long tmpRoleId = ((Long)i$.next()).longValue();
/*      */       
/* 2580 */       userList.add(RoleInterface.getUserId(tmpRoleId));
/*      */     }
/* 2582 */     Lockeys.lock(User.getTable(), userList);
/* 2583 */     Lockeys.lock(Role2task.getTable(), allTeamer);
/* 2584 */     final long teamLeaderId = ((Long)allTeamer.get(0)).longValue();
/* 2585 */     if (graphIdToOtherTaskIds.size() > 0)
/*      */     {
/* 2587 */       for (Long teamRoleId : allTeamer)
/*      */       {
/* 2589 */         if (teamRoleId.longValue() != roleId)
/*      */         {
/*      */ 
/*      */ 
/* 2593 */           new LogicProcedure()
/*      */           {
/*      */ 
/*      */             protected boolean processImp()
/*      */               throws Exception
/*      */             {
/* 2599 */               Lockeys.lock(User.getTable(), this.val$userList);
/* 2600 */               Lockeys.lock(Role2task.getTable(), allTeamer);
/* 2601 */               for (Map.Entry<Integer, Set<Integer>> entry : graphIdToOtherTaskIds.entrySet())
/*      */               {
/* 2603 */                 graph = GraphManager.getGraphById(((Integer)entry.getKey()).intValue());
/* 2604 */                 if (graph != null)
/*      */                 {
/*      */ 
/*      */ 
/* 2608 */                   for (i$ = ((Set)entry.getValue()).iterator(); i$.hasNext();) { int taskId = ((Integer)i$.next()).intValue();
/*      */                     
/* 2610 */                     Task task = TaskManager.getTaskById(taskId);
/* 2611 */                     if (task != null)
/*      */                     {
/*      */ 
/*      */ 
/* 2615 */                       if (teamLeaderId == this.val$teamRoleId.longValue())
/*      */                       {
/* 2617 */                         if (!RoleTaskManager.teamLeaderFailTask(this.val$teamRoleId.longValue(), graph, task, true))
/*      */                         {
/* 2619 */                           return false;
/*      */                         }
/*      */                         
/*      */ 
/*      */                       }
/* 2624 */                       else if (!RoleTaskManager.teamerFailTask(this.val$teamRoleId.longValue(), graph, task, true))
/*      */                       {
/* 2626 */                         return false; } }
/*      */                   } }
/*      */               }
/*      */               Graph graph;
/*      */               Iterator i$;
/* 2631 */               return true;
/*      */             }
/*      */           }.execute();
/*      */         }
/*      */       }
/*      */     }
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
/*      */ 
/*      */ 
/*      */ 
/* 2656 */     remTeamGraph(roleId);
/*      */     
/* 2658 */     for (Long teamerId : allTeamer)
/*      */     {
/* 2660 */       Procedure.execute(new PUpdateTeamCon(teamerId.longValue()));
/*      */     }
/*      */     
/* 2663 */     return true;
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
/*      */   static void remTeamGraph(long roleId)
/*      */   {
/* 2712 */     RoleTask roleTask = getRoleTask(roleId, true);
/* 2713 */     if (roleTask.getTaskDataBean() == null)
/*      */     {
/* 2715 */       return;
/*      */     }
/*      */     
/* 2718 */     Iterator<Map.Entry<Integer, GraphBean>> it = roleTask.getTaskDataBean().getGraphbeans().entrySet().iterator();
/* 2719 */     while (it.hasNext())
/*      */     {
/* 2721 */       Map.Entry<Integer, GraphBean> entry = (Map.Entry)it.next();
/* 2722 */       int graphId = ((Integer)entry.getKey()).intValue();
/* 2723 */       Graph graph = GraphManager.getGraphById(graphId);
/* 2724 */       if (graph != null)
/*      */       {
/*      */ 
/*      */ 
/* 2728 */         if (graph.getSgraph().teamTaskGraph)
/*      */         {
/* 2730 */           for (TaskBean taskBean : ((GraphBean)entry.getValue()).getNodebean().getTaskbeans().values())
/*      */           {
/* 2732 */             sendUpdateTaskState(roleId, graphId, taskBean.getTaskid(), 4);
/*      */           }
/* 2734 */           it.remove();
/*      */         }
/*      */       }
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
/*      */   static boolean failNomalTask(long roleId, Graph graph, Task task, boolean force)
/*      */   {
/* 2751 */     List<Integer> operList = new ArrayList();
/* 2752 */     operList.add(Integer.valueOf(3));
/* 2753 */     return innerFailTask(roleId, graph, task, operList, force);
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
/*      */   static boolean teamerFailTask(long roleId, Graph graph, Task task, boolean force)
/*      */   {
/* 2768 */     List<Integer> operList = new ArrayList();
/*      */     
/* 2770 */     operList.add(Integer.valueOf(3));
/* 2771 */     return innerFailTask(roleId, graph, task, operList, force);
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
/*      */   static boolean teamLeaderFailTask(long roleId, Graph graph, Task task, boolean force)
/*      */   {
/* 2784 */     List<Integer> operList = new ArrayList();
/*      */     
/* 2786 */     operList.add(Integer.valueOf(3));
/* 2787 */     return innerFailTask(roleId, graph, task, operList, force);
/*      */   }
/*      */   
/*      */   private static boolean innerFailTask(long roleId, Graph graph, Task task, List<Integer> operTypeList, boolean force)
/*      */   {
/* 2792 */     RoleTask roleTask = getRoleTask(roleId, true);
/* 2793 */     int graphId = graph.getSgraph().id;
/* 2794 */     int taskId = task.getStask().id;
/* 2795 */     GraphBean graphBean = roleTask.getGraphBean(graphId);
/* 2796 */     TaskBean taskBean = roleTask.getTaskBean(graphId, taskId);
/* 2797 */     if ((graphBean == null) || (taskBean == null))
/*      */     {
/* 2799 */       return false;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/* 2804 */     long taskLastTime = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis()) - taskBean.getTaskstarttime();
/* 2805 */     for (Integer operTeamType : operTypeList)
/*      */     {
/* 2807 */       if (!task.checkOperation(roleId, 3, operTeamType.intValue(), new HashMap(), true))
/*      */       {
/*      */ 
/* 2810 */         if (!force)
/*      */         {
/*      */ 
/*      */ 
/* 2814 */           return false; }
/*      */       }
/*      */     }
/* 2817 */     for (Integer operTeamType : operTypeList)
/*      */     {
/* 2819 */       if (!task.excuteOperation(roleId, 3, operTeamType.intValue(), new HashMap(), graphBean.getGraphid(), true))
/*      */       {
/* 2821 */         return false;
/*      */       }
/*      */     }
/* 2824 */     if (task.getStask().failToRev)
/*      */     {
/* 2826 */       changeTaskState(roleId, 4, graphBean.getGraphid(), taskBean, 0);
/* 2827 */       graphBean.getNodebean().getTaskbeans().remove(Integer.valueOf(taskBean.getTaskid()));
/*      */     }
/*      */     else
/*      */     {
/* 2831 */       changeTaskState(roleId, 5, graphBean.getGraphid(), taskBean, 0);
/*      */     }
/* 2833 */     graph.afterFailTask(roleId, taskBean, graphBean);
/* 2834 */     return true;
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
/*      */   static boolean onTeamLeaderChanged(TeamLeaderChangedArg arg)
/*      */   {
/* 2898 */     if (!checkAndGetLock(Arrays.asList(new Long[] { Long.valueOf(arg.newLeader), Long.valueOf(arg.oldLeader) })))
/*      */     {
/* 2900 */       return false;
/*      */     }
/* 2902 */     List<Long> allMembers = TeamInterface.getTeamMemberList(arg.teamid, false);
/* 2903 */     if (allMembers.size() <= 0)
/*      */     {
/*      */ 
/* 2906 */       return true;
/*      */     }
/*      */     
/* 2909 */     RoleTask oldRoleTask = getRoleTask(arg.oldLeader, true);
/* 2910 */     Map<Integer, GraphBean> oldAllGraphBeans = oldRoleTask.getAllTeamGraph();
/* 2911 */     RoleTask newRoleTask = getRoleTask(arg.newLeader, true);
/* 2912 */     Map<Integer, GraphBean> newAllGraphBeans = newRoleTask.getAllTeamGraph();
/*      */     
/* 2914 */     for (Iterator i$ = oldAllGraphBeans.values().iterator(); i$.hasNext();) { oldGraphBean = (GraphBean)i$.next();
/*      */       
/* 2916 */       if (!newAllGraphBeans.containsKey(Integer.valueOf(oldGraphBean.getGraphid())))
/*      */       {
/* 2918 */         for (TaskBean taskBean : oldGraphBean.getNodebean().getTaskbeans().values())
/*      */         {
/* 2920 */           sendUpdateTaskState(arg.oldLeader, oldGraphBean.getGraphid(), taskBean.getTaskid(), 4);
/*      */         }
/*      */       }
/*      */       
/* 2924 */       newGraphBean = (GraphBean)newAllGraphBeans.get(Integer.valueOf(oldGraphBean.getGraphid()));
/* 2925 */       if ((newGraphBean != null) && 
/*      */       
/*      */ 
/*      */ 
/* 2929 */         (newGraphBean.getNodebean().getTaskbeans() != null))
/*      */       {
/*      */ 
/*      */ 
/*      */ 
/* 2934 */         for (TaskBean taskBean : oldGraphBean.getNodebean().getTaskbeans().values())
/*      */         {
/* 2936 */           if (newGraphBean.getNodebean().getTaskbeans().containsKey(Integer.valueOf(taskBean.getTaskid()))) {
/*      */             break;
/*      */           }
/*      */           
/*      */ 
/*      */ 
/*      */ 
/* 2943 */           if (taskBean.getTaskstate() == 1)
/*      */           {
/* 2945 */             Task task = TaskManager.getTaskById(taskBean.getTaskid());
/* 2946 */             AcceptTaskCheckResult acRet = task.iscanTake(arg.newLeader, new HashMap(), new HashMap(), newGraphBean.getGraphid());
/*      */             
/* 2948 */             if (acRet.isCanTake())
/*      */             {
/*      */ 
/* 2951 */               TaskBean taskBean2 = createTaskBean(arg.newLeader, newGraphBean.getGraphid(), taskBean.getTaskid(), 1);
/*      */               
/* 2953 */               newGraphBean.getNodebean().getTaskbeans().put(Integer.valueOf(taskBean2.getTaskid()), taskBean2);
/* 2954 */               sendUpdateTaskState(arg.newLeader, newGraphBean.getGraphid(), taskBean2.getTaskid(), taskBean2.getTaskstate());
/*      */             }
/*      */             
/*      */           }
/*      */           else
/*      */           {
/* 2960 */             oldGraphBean.getNodebean().getTaskbeans().remove(Integer.valueOf(taskBean.getTaskid()));
/* 2961 */             sendUpdateTaskState(arg.oldLeader, oldGraphBean.getGraphid(), taskBean.getTaskid(), 4);
/*      */           }
/*      */         }
/*      */       }
/*      */     }
/*      */     GraphBean oldGraphBean;
/*      */     GraphBean newGraphBean;
/* 2968 */     checkNewLeaderTaskState(arg.newLeader);
/*      */     
/* 2970 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void checkNewLeaderTaskState(long newLeaderId)
/*      */   {
/* 2980 */     RoleTask newRoleTask = getRoleTask(newLeaderId, false);
/* 2981 */     Map<Integer, GraphBean> newAllGraphBeans = newRoleTask.getAllTeamGraph();
/*      */     
/* 2983 */     for (Iterator i$ = newAllGraphBeans.values().iterator(); i$.hasNext();) { graphBean = (GraphBean)i$.next();
/*      */       
/* 2985 */       graphId = graphBean.getGraphid();
/* 2986 */       for (TaskBean taskBean : graphBean.getNodebean().getTaskbeans().values())
/*      */       {
/* 2988 */         if (taskBean.getTaskstate() == 1)
/*      */         {
/*      */ 
/*      */ 
/* 2992 */           Graph graph = GraphManager.getGraphById(graphId);
/* 2993 */           if ((graph != null) && 
/*      */           
/*      */ 
/*      */ 
/* 2997 */             (graph.isAutoAcceptTask(graphBean)))
/*      */           {
/*      */ 
/*      */ 
/* 3001 */             Procedure.execute(new AccpetTaskProcedure(newLeaderId, graphBean.getGraphid(), taskBean.getTaskid()));
/*      */           }
/*      */         }
/*      */       }
/*      */     }
/*      */     
/*      */     GraphBean graphBean;
/*      */     
/*      */     int graphId;
/*      */   }
/*      */   
/*      */   static boolean reqRefreshTaskSet(long roleId, int npcId)
/*      */   {
/* 3014 */     Set<Integer> graphIds = GraphManager.getInstance().getAllGraphIds(npcId);
/* 3015 */     if (graphIds.size() == 0)
/*      */     {
/* 3017 */       SRefreshTaskRes sRefreshTaskRes = new SRefreshTaskRes();
/* 3018 */       sRefreshTaskRes.npcid = npcId;
/* 3019 */       OnlineManager.getInstance().sendAtOnce(roleId, sRefreshTaskRes);
/* 3020 */       return false;
/*      */     }
/* 3022 */     RoleTask roleTask = getRoleTask(roleId, true);
/* 3023 */     Map<Integer, List<TaskBean>> graphIdToTaskBeans = new HashMap();
/* 3024 */     for (Iterator i$ = graphIds.iterator(); i$.hasNext();) { int graphId = ((Integer)i$.next()).intValue();
/*      */       
/* 3026 */       GraphBean graphBean = roleTask.getGraphBean(graphId);
/* 3027 */       if (graphBean != null)
/*      */       {
/*      */ 
/*      */ 
/* 3031 */         Graph graph = GraphManager.getGraphById(graphId);
/* 3032 */         if (graph.isRingTypeGraph())
/*      */         {
/* 3034 */           List<TaskBean> taskBeans = graph.refreshTaskSetGraph(roleId, graphBean, false);
/* 3035 */           if (taskBeans.size() > 0)
/*      */           {
/* 3037 */             graphIdToTaskBeans.put(Integer.valueOf(graphId), taskBeans);
/*      */           }
/*      */         }
/*      */       }
/*      */     }
/* 3042 */     SRefreshTaskRes sRefreshTaskRes = new SRefreshTaskRes();
/* 3043 */     sRefreshTaskRes.npcid = npcId;
/* 3044 */     for (Iterator i$ = graphIdToTaskBeans.entrySet().iterator(); i$.hasNext();) { graphIdToBeansEntry = (Map.Entry)i$.next();
/*      */       
/* 3046 */       for (TaskBean taskBean : (List)graphIdToBeansEntry.getValue())
/*      */       {
/* 3048 */         TaskState taskState = new TaskState();
/* 3049 */         fillInTaskState(taskState, ((Integer)graphIdToBeansEntry.getKey()).intValue(), taskBean.getTaskid(), taskBean.getTaskstate());
/* 3050 */         sRefreshTaskRes.taskstates.add(taskState);
/*      */       } }
/*      */     Map.Entry<Integer, List<TaskBean>> graphIdToBeansEntry;
/* 3053 */     OnlineManager.getInstance().send(roleId, sRefreshTaskRes);
/* 3054 */     return true;
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
/*      */   static void fillInTaskState(TaskState taskState, int graphId, int taskId, int state)
/*      */   {
/* 3089 */     taskState.graphid = graphId;
/* 3090 */     taskState.taskid = taskId;
/* 3091 */     taskState.state = state;
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
/*      */   protected static int findTaskIdInGraph(long roleId, int graphId)
/*      */   {
/* 3105 */     List<Integer> taskIds = new ArrayList();
/* 3106 */     int taskId = 0;
/* 3107 */     Graph graph = GraphManager.getGraphById(graphId);
/* 3108 */     if (graph == null)
/*      */     {
/* 3110 */       return taskId;
/*      */     }
/*      */     
/* 3113 */     RoleTask roleTask = getRoleTask(roleId, false);
/* 3114 */     GraphBean graphBean = roleTask.getGraphBean(graphId);
/* 3115 */     if (graphBean == null)
/*      */     {
/* 3117 */       return taskId;
/*      */     }
/*      */     
/* 3120 */     for (TaskBean taskBean : graphBean.getNodebean().getTaskbeans().values())
/*      */     {
/* 3122 */       if (taskBean.getTaskstate() == 2)
/*      */       {
/* 3124 */         taskIds.add(Integer.valueOf(taskBean.getTaskid()));
/*      */       }
/*      */     }
/*      */     
/* 3128 */     if (taskIds.size() != 1)
/*      */     {
/* 3130 */       return taskId;
/*      */     }
/*      */     
/* 3133 */     return ((Integer)taskIds.get(0)).intValue();
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
/*      */   static boolean flushNewTask(long roleId, GraphBean graphBean, Graph graph, int oldTaskId, Set<Integer> taskIdSet)
/*      */   {
/* 3259 */     SNode snode = graph.getNodebyNodeId(graphBean.getNodebean().getNodeid());
/* 3260 */     if (graphBean.getNodebean().getFinishcount() >= ((STaskToProperty)snode.taskIdToProperty.get(0)).nodeProperty.turnNum)
/*      */     {
/* 3262 */       finishNodeProc(roleId, graph, graphBean);
/*      */       
/* 3264 */       for (STaskToProperty sTaskToProperty : snode.taskIdToProperty)
/*      */       {
/* 3266 */         if (sTaskToProperty.nodeProperty.nextNodeId > 0)
/*      */         {
/* 3268 */           newNodeProc(roleId, graph, graphBean, sTaskToProperty, oldTaskId, taskIdSet);
/*      */         }
/*      */         else
/*      */         {
/* 3272 */           finisGraph(roleId, graph, graphBean);
/*      */         }
/*      */         
/*      */       }
/*      */       
/*      */     }
/* 3278 */     else if (((STaskToProperty)snode.taskIdToProperty.get(0)).nodeProperty.taskSetType == 2)
/*      */     {
/* 3280 */       getCanAcceptTask(roleId, graphBean, snode, oldTaskId, taskIdSet);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 3287 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   private static void newNodeProc(long roleId, Graph graph, GraphBean graphBean, STaskToProperty sTaskToProperty, int oldTaskId, Set<Integer> taskIdSet)
/*      */   {
/* 3294 */     graphBean.getNodebean().setNodeid(sTaskToProperty.nodeProperty.nextNodeId);
/* 3295 */     graphBean.getNodebean().setFinishcount(0);
/* 3296 */     SNode node = graph.getNodebyNodeId(sTaskToProperty.nodeProperty.nextNodeId);
/* 3297 */     getCanAcceptTask(roleId, graphBean, node, oldTaskId, taskIdSet);
/*      */   }
/*      */   
/*      */   private static void finishNodeProc(long roleId, Graph graph, GraphBean graphBean)
/*      */   {
/* 3302 */     for (TaskBean taskBeanDel : graphBean.getNodebean().getTaskbeans().values())
/*      */     {
/*      */ 
/* 3305 */       sendUpdateTaskState(roleId, graphBean.getGraphid(), taskBeanDel.getTaskid(), 4);
/*      */     }
/*      */     
/*      */ 
/* 3309 */     graphBean.getNodebean().getTaskbeans().clear();
/* 3310 */     graphBean.getNodebean().setFinishcount(0);
/* 3311 */     graphBean.getNodebean().setNodeid(graph.getSgraph().rootNodeId);
/*      */   }
/*      */   
/*      */   private static void finisGraph(long roleId, Graph graph, GraphBean graphBean)
/*      */   {
/* 3316 */     graph.addGraphFinishCount(roleId, graphBean);
/* 3317 */     TaskInterface.updateTaskCondition(roleId, 13, new Object());
/*      */     
/* 3319 */     Graph graphBeAced = GraphManager.getInstance().getGraphByGraphId(graphBean.getGraphid());
/* 3320 */     if (graphBeAced != null)
/*      */     {
/* 3322 */       activeGraph(graphBeAced.id(), roleId);
/*      */     }
/* 3324 */     closeGraphWithoutEvent(graphBean.getGraphid(), roleId, true);
/*      */   }
/*      */   
/*      */ 
/*      */   private static void getCanAcceptTask(long roleId, GraphBean graphBean, SNode node, int oldTaskId, Set<Integer> taskIdSet)
/*      */   {
/* 3330 */     TaskSet taskSet = TaskSetManager.getTaskSetById(((STaskToProperty)node.taskIdToProperty.get(0)).taskId);
/* 3331 */     Set<Integer> taskIds = taskSet.randomCanTakeTaskId(roleId, taskIdSet, graphBean.getGraphid(), oldTaskId);
/* 3332 */     if (taskIds.size() != 1)
/*      */     {
/* 3334 */       return;
/*      */     }
/* 3336 */     for (Iterator i$ = taskIds.iterator(); i$.hasNext();) { int taskId = ((Integer)i$.next()).intValue();
/*      */       
/* 3338 */       TaskBean taskBean = createTaskBean(roleId, graphBean.getGraphid(), taskId, 1);
/* 3339 */       sendUpdateTaskState(roleId, graphBean.getGraphid(), taskId, taskBean.getTaskstate());
/*      */       
/* 3341 */       graphBean.getNodebean().getTaskbeans().put(Integer.valueOf(taskBean.getTaskid()), taskBean);
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
/*      */   static int getGraphAllTaskNum(int graphId)
/*      */   {
/* 3354 */     Graph graph = GraphManager.getGraphById(graphId);
/* 3355 */     if (graph == null)
/*      */     {
/* 3357 */       return 0;
/*      */     }
/* 3359 */     return graph.getAllTaskNum();
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
/*      */   static int getTaskNumInGraphImpl(long roleId, int graphId, int taskId)
/*      */   {
/* 3372 */     int taskNum = -1;
/* 3373 */     Graph graph = GraphManager.getGraphById(graphId);
/* 3374 */     if (graph == null)
/*      */     {
/* 3376 */       return taskNum;
/*      */     }
/*      */     
/* 3379 */     RoleTask roleTask = getRoleTask(roleId, false);
/* 3380 */     GraphBean graphBean = roleTask.getGraphBean(graphId);
/* 3381 */     if (graphBean == null)
/*      */     {
/* 3383 */       return taskNum;
/*      */     }
/* 3385 */     Map<Integer, TaskBean> taskBeans = graphBean.getNodebean().getTaskbeans();
/*      */     
/* 3387 */     if (taskBeans.values().size() > 1)
/*      */     {
/* 3389 */       return taskNum;
/*      */     }
/* 3391 */     if (taskBeans.values().size() == 1)
/*      */     {
/* 3393 */       if (taskId < 0)
/*      */       {
/* 3395 */         Iterator i$ = taskBeans.values().iterator(); if (i$.hasNext()) { TaskBean taskBean = (TaskBean)i$.next();
/*      */           
/* 3397 */           taskId = taskBean.getTaskid();
/*      */         }
/*      */       }
/*      */       
/* 3401 */       if (taskBeans.get(Integer.valueOf(taskId)) == null)
/*      */       {
/* 3403 */         return taskNum;
/*      */       }
/* 3405 */       if (((TaskBean)taskBeans.get(Integer.valueOf(taskId))).getTaskstate() == 8)
/*      */       {
/* 3407 */         taskNum = graphBean.getAllfinishcount();
/*      */       }
/*      */       else
/*      */       {
/* 3411 */         taskNum = graphBean.getAllfinishcount() + 1;
/*      */       }
/*      */     }
/* 3414 */     return taskNum;
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
/*      */   static List<Integer> getTaskNeedItemImpl(long roleId, int graphId, int taskId)
/*      */   {
/* 3431 */     List<Integer> itemList = new ArrayList();
/*      */     
/* 3433 */     Graph graph = GraphManager.getGraphById(graphId);
/* 3434 */     if (graph == null)
/*      */     {
/* 3436 */       return itemList;
/*      */     }
/* 3438 */     RoleTask roleTask = getRoleTask(roleId, true);
/* 3439 */     if (roleTask == null)
/*      */     {
/* 3441 */       return itemList;
/*      */     }
/*      */     
/* 3444 */     GraphBean graphBean = roleTask.getGraphBean(graphId);
/* 3445 */     if (graphBean == null)
/*      */     {
/* 3447 */       return itemList;
/*      */     }
/* 3449 */     TaskBean taskBean = roleTask.getTaskBean(graph.getSgraph().id, taskId);
/* 3450 */     if (taskBean == null)
/*      */     {
/* 3452 */       return itemList;
/*      */     }
/* 3454 */     Task task = TaskManager.getTaskById(taskId);
/* 3455 */     if (task == null)
/*      */     {
/* 3457 */       return itemList;
/*      */     }
/* 3459 */     List<AbsCondition> absConditions = task.getCondition(9, 2);
/* 3460 */     if (absConditions.size() <= 0)
/*      */     {
/* 3462 */       return itemList;
/*      */     }
/*      */     
/* 3465 */     for (AbsCondition condition : absConditions)
/*      */     {
/* 3467 */       if ((condition instanceof Con_Bag_9))
/*      */       {
/*      */ 
/*      */ 
/* 3471 */         Con_Bag_9 conditionBag = (Con_Bag_9)condition;
/* 3472 */         STaskConBag conBag = conditionBag.getConBag();
/* 3473 */         if (conBag.takeCfgId > 0)
/*      */         {
/*      */ 
/*      */ 
/* 3477 */           if (conBag.takeItemType == 1)
/*      */           {
/* 3479 */             itemList.add(Integer.valueOf(conBag.takeCfgId));
/*      */           }
/* 3481 */           else if (conBag.takeItemType == 2)
/*      */           {
/* 3483 */             itemList.addAll(ItemInterface.getSamePriceItems(conBag.takeCfgId)); } }
/*      */       }
/*      */     }
/* 3486 */     return itemList;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static Set<Integer> getRoleAlreadyGetTaskId(RoleTask roleTask)
/*      */   {
/* 3496 */     Set<Integer> taskIds = new HashSet();
/* 3497 */     Map<Integer, List<TaskStateInfo>> m = roleTask.getTaskStateInfo();
/* 3498 */     if ((m == null) || (m.size() == 0))
/*      */     {
/* 3500 */       return taskIds;
/*      */     }
/* 3502 */     for (Map.Entry<Integer, List<TaskStateInfo>> entry : m.entrySet())
/*      */     {
/* 3504 */       int taskId = ((Integer)entry.getKey()).intValue();
/* 3505 */       List<TaskStateInfo> taskStateInfos = (List)entry.getValue();
/* 3506 */       isAlreadyGetTask(taskIds, taskId, taskStateInfos);
/*      */     }
/* 3508 */     return taskIds;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private static boolean isAlreadyGetTask(Set<Integer> taskIds, int taskId, List<TaskStateInfo> taskStateInfos)
/*      */   {
/* 3518 */     for (TaskStateInfo t : taskStateInfos)
/*      */     {
/* 3520 */       if (t.getTaskState() == 2)
/*      */       {
/* 3522 */         taskIds.add(Integer.valueOf(taskId));
/* 3523 */         return true;
/*      */       }
/*      */     }
/* 3526 */     return false;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static int getAndFillTaskNeedItems(int taskId, Set<Integer> itemIds)
/*      */   {
/* 3538 */     Task task = TaskManager.getTaskById(taskId);
/* 3539 */     if (task == null)
/*      */     {
/* 3541 */       return -1;
/*      */     }
/* 3543 */     List<AbsCondition> absConditions = task.getCondition(9, 2);
/* 3544 */     if (absConditions.size() <= 0)
/*      */     {
/* 3546 */       return -1;
/*      */     }
/*      */     
/* 3549 */     for (AbsCondition condition : absConditions)
/*      */     {
/* 3551 */       if ((condition instanceof Con_Bag_9))
/*      */       {
/*      */ 
/*      */ 
/* 3555 */         Con_Bag_9 conditionBag = (Con_Bag_9)condition;
/* 3556 */         STaskConBag conBag = conditionBag.getConBag();
/* 3557 */         if (conBag.takeCfgId > 0)
/*      */         {
/*      */ 
/*      */ 
/* 3561 */           itemIds.add(Integer.valueOf(conBag.takeCfgId));
/* 3562 */           return conBag.takeItemType;
/*      */         } } }
/* 3564 */     return -1;
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
/*      */   static TaskNeedItemInfo getRoleTaskNeedItemInfos(long roleId)
/*      */   {
/* 3578 */     RoleTask roleTask = getRoleTask(roleId, true);
/* 3579 */     if (roleTask == null)
/*      */     {
/* 3581 */       return null;
/*      */     }
/* 3583 */     Set<Integer> alreadyGetTaskIds = getRoleAlreadyGetTaskId(roleTask);
/* 3584 */     if ((alreadyGetTaskIds == null) || (alreadyGetTaskIds.size() == 0))
/*      */     {
/* 3586 */       return null;
/*      */     }
/* 3588 */     TaskNeedItemInfo itemInfos = new TaskNeedItemInfo();
/* 3589 */     boolean getItems = getNeedItems(alreadyGetTaskIds, itemInfos);
/* 3590 */     return getItems ? itemInfos : null;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private static boolean getNeedItems(Set<Integer> alreadyGetTaskIds, TaskNeedItemInfo itemInfos)
/*      */   {
/* 3600 */     boolean getItems = false;
/* 3601 */     for (Iterator i$ = alreadyGetTaskIds.iterator(); i$.hasNext();) { int taskId = ((Integer)i$.next()).intValue();
/*      */       
/* 3603 */       Set<Integer> itemIds = new HashSet();
/* 3604 */       int type = getAndFillTaskNeedItems(taskId, itemIds);
/* 3605 */       if (type >= 0)
/*      */       {
/*      */ 
/*      */ 
/* 3609 */         if (itemIds.size() > 0)
/*      */         {
/* 3611 */           itemInfos.addItemInfoTo(taskId, type, itemIds);
/* 3612 */           getItems = true;
/*      */         } }
/*      */     }
/* 3615 */     return getItems;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean hasFlyTaskImpl(long roleId, boolean isRetainLock)
/*      */   {
/* 3627 */     List<Integer> ids = getAlreadyGetTask(roleId, isRetainLock);
/* 3628 */     if (ids.size() == 0)
/*      */     {
/* 3630 */       return false;
/*      */     }
/* 3632 */     for (Iterator i$ = ids.iterator(); i$.hasNext();) { int id = ((Integer)i$.next()).intValue();
/*      */       
/* 3634 */       if (TaskInterface.canFly(id))
/*      */       {
/* 3636 */         return true;
/*      */       }
/*      */     }
/* 3639 */     return false;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static List<Integer> getAlreadyGetTask(long roleId, boolean isRetainLock)
/*      */   {
/* 3651 */     List<Integer> aLTaskIds = new ArrayList();
/* 3652 */     RoleTask roleTask = new RoleTask(roleId, isRetainLock);
/* 3653 */     TaskDataBean taskDataBean = roleTask.getTaskDataBean();
/* 3654 */     if (taskDataBean == null)
/*      */     {
/* 3656 */       return new ArrayList();
/*      */     }
/* 3658 */     Map<Integer, GraphBean> graphbeans = taskDataBean.getGraphbeans();
/* 3659 */     for (GraphBean graphBean : graphbeans.values())
/*      */     {
/* 3661 */       NodeBean nodebean = graphBean.getNodebean();
/* 3662 */       if (nodebean != null)
/*      */       {
/*      */ 
/*      */ 
/* 3666 */         for (TaskBean taskBean : nodebean.getTaskbeans().values())
/*      */         {
/*      */ 
/* 3669 */           aLTaskIds.add(Integer.valueOf(taskBean.getTaskid()));
/*      */         }
/*      */       }
/*      */     }
/* 3673 */     return aLTaskIds;
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
/*      */   static void changeTaskState(long roleId, int taskState, int graphId, TaskBean taskBean, int taskType)
/*      */   {
/* 3692 */     changeTaskState(roleId, taskState, graphId, taskBean, taskType, null);
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
/*      */   static void changeTaskState(long roleId, int taskState, int graphId, TaskBean taskBean, int taskType, PVEFightEndArg arg)
/*      */   {
/* 3711 */     if (taskBean == null)
/*      */     {
/* 3713 */       return;
/*      */     }
/* 3715 */     if (taskState == taskBean.getTaskstate())
/*      */     {
/* 3717 */       return;
/*      */     }
/*      */     
/* 3720 */     taskBean.setTaskstate(taskState);
/*      */     
/*      */ 
/* 3723 */     TaskLogManager.addTaskLog(roleId, graphId, taskBean.getTaskid(), taskBean.getTaskstate(), taskType, getTaskPassTime(taskBean));
/*      */     
/*      */ 
/* 3726 */     trigeerStateChangeEvent(roleId, graphId, taskBean.getTaskid(), taskBean.getTaskstate(), arg);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static long getTaskPassTime(TaskBean taskBean)
/*      */   {
/* 3738 */     if ((taskBean.getTaskstate() == 1) || (taskBean.getTaskstate() == 7) || (taskBean.getTaskstate() == 6))
/*      */     {
/*      */ 
/*      */ 
/* 3742 */       return 0L;
/*      */     }
/* 3744 */     long taskStartTime = taskBean.getTaskstarttime();
/* 3745 */     long currentTime = TimeUnit.MILLISECONDS.toSeconds(DateTimeUtils.getCurrTimeInMillis());
/* 3746 */     if (taskStartTime <= 0L)
/*      */     {
/* 3748 */       taskBean.setTaskstarttime(currentTime);
/*      */     }
/* 3750 */     long taskLastTime = currentTime - taskBean.getTaskstarttime();
/* 3751 */     return taskLastTime;
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
/*      */   static boolean setGraphFinishNum(long roleId, int graphId, int num)
/*      */   {
/* 3769 */     RoleTask roleTask = getRoleTask(roleId, true);
/* 3770 */     GraphBean graphBean = roleTask.getGraphBean(graphId);
/* 3771 */     if (graphBean == null)
/*      */     {
/* 3773 */       GameServer.logger().error(String.format("[task]roletaskManager.setGraphFinishNum@ not own this graph!|roleId=%d|graphId=%d|", new Object[] { Long.valueOf(roleId), Integer.valueOf(graphId) }));
/*      */       
/*      */ 
/* 3776 */       return false;
/*      */     }
/* 3778 */     Graph graph = GraphManager.getGraphById(graphId);
/*      */     
/* 3780 */     if (!graph.getSgraph().isRingTypeGraph)
/*      */     {
/* 3782 */       GameServer.logger().error(String.format("[task]roletaskManager.setGraphFinishNum@ graph cfg not exist!|roleId=%d|graphId=%d|", new Object[] { Long.valueOf(roleId), Integer.valueOf(graphId) }));
/*      */       
/*      */ 
/* 3785 */       return false;
/*      */     }
/*      */     
/* 3788 */     if (graph.getAllTaskNum() < num)
/*      */     {
/* 3790 */       GameServer.logger().error(String.format("[task]roletaskManager.setGraphFinishNum@ num is over graphNum max!|roleId=%d|graphId=%d|num=%d|graphTaskNum=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(graphId), Integer.valueOf(num), Integer.valueOf(graph.getAllTaskNum()) }));
/*      */       
/*      */ 
/*      */ 
/* 3794 */       return false;
/*      */     }
/* 3796 */     List<Integer> nodeInfo = graph.getNodeInfoByTurn(num + 1);
/* 3797 */     graphBean.getNodebean().setNodeid(((Integer)nodeInfo.get(0)).intValue());
/* 3798 */     graphBean.getNodebean().setFinishcount(((Integer)nodeInfo.get(1)).intValue() - 1);
/* 3799 */     graphBean.setAllfinishcount(num);
/* 3800 */     if (GameServer.logger().isDebugEnabled())
/*      */     {
/* 3802 */       GameServer.logger().debug(String.format("[task]RoleTaskManager.setGraphFinishNum@info:|roleId=%d|graphId=%d|num=%d|nodeInfo=%s", new Object[] { Long.valueOf(roleId), Integer.valueOf(graphId), Integer.valueOf(num), nodeInfo.toString() }));
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */ 
/* 3808 */     sendGraphCurRing(roleId, graphBean, 1, true);
/* 3809 */     return true;
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
/*      */   public static void sendTaskNotice(Collection<Long> roleIds, boolean afterSuc, int result, String... args)
/*      */   {
/* 3822 */     STaskNormalResult pro = new STaskNormalResult();
/* 3823 */     pro.result = result;
/* 3824 */     for (String arg : args)
/*      */     {
/* 3826 */       pro.args.add(arg);
/*      */     }
/* 3828 */     if (afterSuc)
/*      */     {
/* 3830 */       OnlineManager.getInstance().sendMulti(pro, roleIds);
/*      */     }
/*      */     else
/*      */     {
/* 3834 */       OnlineManager.getInstance().sendMultiAtOnce(pro, roleIds);
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void updateTeamCon(List<Long> members)
/*      */   {
/* 3846 */     for (Iterator i$ = members.iterator(); i$.hasNext();) { long teamerId = ((Long)i$.next()).longValue();
/*      */       
/* 3848 */       Procedure.execute(new LogicProcedure()
/*      */       {
/*      */ 
/*      */         protected boolean processImp()
/*      */           throws Exception
/*      */         {
/* 3854 */           RoleTaskManager.updateCondition(this.val$teamerId, -1, 7, new Object());
/* 3855 */           return true;
/*      */         }
/*      */       });
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
/*      */   static boolean replaceGraphData(long roleId, int oldGraphId, int newGraphId)
/*      */   {
/* 3875 */     Lockeys.lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(roleId) }));
/*      */     
/* 3877 */     if (GraphManager.getGraphById(newGraphId) == null)
/*      */     {
/* 3879 */       GameServer.logger().error(String.format("[task]RoletaskManager.replaceGraphData@ new graph cfg!|roleId=%d|oldGraphId=%d|newGraphId=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(oldGraphId), Integer.valueOf(newGraphId) }));
/*      */       
/*      */ 
/*      */ 
/* 3883 */       return false;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */ 
/* 3889 */     TaskDataBean xTaskDataBean = Role2task.get(Long.valueOf(roleId));
/* 3890 */     if (xTaskDataBean == null)
/*      */     {
/* 3892 */       GameServer.logger().error(String.format("[task]RoletaskManager.replaceGraphData@ not have any task data!|roleId=%d|oldGraphId=%d|newGraphId=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(oldGraphId), Integer.valueOf(newGraphId) }));
/*      */       
/*      */ 
/*      */ 
/* 3896 */       return false;
/*      */     }
/*      */     
/* 3899 */     noticeDelOldGraphData(roleId, oldGraphId, newGraphId, xTaskDataBean);
/*      */     
/* 3901 */     GraphBean xGraphBean = (GraphBean)xTaskDataBean.getGraphbeans().remove(Integer.valueOf(oldGraphId));
/* 3902 */     if (xGraphBean == null)
/*      */     {
/* 3904 */       GameServer.logger().info(String.format("[task]RoletaskManager.replaceGraphData@ not have old graph!|roleId=%d|oldGraphId=%d|newGraphId=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(oldGraphId), Integer.valueOf(newGraphId) }));
/*      */       
/*      */ 
/*      */ 
/* 3908 */       return true;
/*      */     }
/*      */     
/* 3911 */     GraphBean xGraphBeanCopy = xGraphBean.copy();
/* 3912 */     xGraphBeanCopy.setGraphid(newGraphId);
/*      */     
/* 3914 */     xTaskDataBean.getGraphbeans().put(Integer.valueOf(newGraphId), xGraphBeanCopy);
/*      */     
/* 3916 */     sendInitMsg(roleId);
/* 3917 */     return true;
/*      */   }
/*      */   
/*      */   private static void noticeDelOldGraphData(long roleId, int oldGraphId, int newGraphId, TaskDataBean taskDataBean)
/*      */   {
/* 3922 */     GraphBean graphBean = (GraphBean)taskDataBean.getGraphbeans().get(Integer.valueOf(oldGraphId));
/* 3923 */     if (graphBean == null)
/*      */     {
/* 3925 */       GameServer.logger().info(String.format("[task]RoletaskManager.noticeDelOldGraphData@ role not own old graph!|roleId=%d|oldGraphId=%d|newGraphId=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(oldGraphId), Integer.valueOf(newGraphId) }));
/*      */       
/*      */ 
/*      */ 
/* 3929 */       return;
/*      */     }
/* 3931 */     for (TaskBean taskBean : graphBean.getNodebean().getTaskbeans().values())
/*      */     {
/* 3933 */       sendUpdateTaskState(roleId, oldGraphId, taskBean.getTaskid(), 4);
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
/*      */   static Set<Integer> getAllTaskNpcLibId()
/*      */   {
/* 3946 */     return STTaskUsedNpcLibCfg.getAll().keySet();
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
/*      */   static boolean containsNpcLibId(int npcLibId)
/*      */   {
/* 3960 */     return STTaskUsedNpcLibCfg.getAll().get(Integer.valueOf(npcLibId)) != null;
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
/*      */   static boolean isNearByNpc(long roleId, int npcXId)
/*      */   {
/* 3976 */     if (containsNpcLibId(npcXId))
/*      */     {
/* 3978 */       TaskNpcLibIdHandler handler = TaskNpcManager.getInstance().getTaskNpcLibIdHandler(npcXId);
/* 3979 */       if (handler == null)
/*      */       {
/* 3981 */         return false;
/*      */       }
/* 3983 */       return handler.isNearByNpc(roleId, npcXId);
/*      */     }
/*      */     
/* 3986 */     if (!MapInterface.isNpcExist(npcXId))
/*      */     {
/* 3988 */       return false;
/*      */     }
/* 3990 */     return MapInterface.isNearByNPC(roleId, npcXId);
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\task\main\RoleTaskManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */