/*     */ package mzm.gsp.task.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Random;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.task.SCannotAcceptTask;
/*     */ import mzm.gsp.task.confbean.SGraph;
/*     */ import mzm.gsp.task.confbean.SNode;
/*     */ import mzm.gsp.task.confbean.SNodeProperty;
/*     */ import mzm.gsp.task.confbean.STaskToProperty;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.GraphBean;
/*     */ import xbean.GraphFinishBean;
/*     */ import xbean.NodeBean;
/*     */ import xbean.Pod;
/*     */ import xbean.TaskBean;
/*     */ import xdb.Procedure;
/*     */ import xdb.Xdb;
/*     */ import xtable.Role2graphfinish;
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
/*     */ public class Graph
/*     */ {
/*  40 */   protected Map<Integer, SNode> nodeMap = new HashMap();
/*     */   
/*  42 */   private static final Logger logger = Logger.getLogger(Graph.class);
/*     */   
/*     */   private int graphId;
/*     */   
/*     */ 
/*     */   public SGraph getSgraph()
/*     */   {
/*  49 */     return SGraph.get(id());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Graph(int graphId)
/*     */   {
/*  59 */     this.graphId = graphId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setGraphId(int graphId)
/*     */   {
/*  66 */     this.graphId = graphId;
/*     */   }
/*     */   
/*     */   public int id()
/*     */   {
/*  71 */     return this.graphId;
/*     */   }
/*     */   
/*     */   boolean addSNode(SNode snode)
/*     */   {
/*  76 */     if (this.nodeMap.containsKey(Integer.valueOf(snode.nodeID)))
/*     */     {
/*  78 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  82 */     this.nodeMap.put(Integer.valueOf(snode.nodeID), snode);
/*  83 */     return true;
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
/*     */   SNode getNodebyNodeId(int nodeId)
/*     */   {
/*  96 */     return (SNode)getSgraph().nodeMap.get(Integer.valueOf(nodeId));
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
/*     */   public TaskBean createTaskBean(long roleId, int graphId, int taskId, int taskState)
/*     */   {
/* 109 */     TaskBean taskBean = Pod.newTaskBean();
/* 110 */     taskBean.setTaskid(taskId);
/* 111 */     RoleTaskManager.changeTaskState(roleId, taskState, graphId, taskBean, 0);
/* 112 */     return taskBean;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   int getAllTaskNum()
/*     */   {
/* 121 */     return getSgraph().taskNum;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean isOwnGraph(long roleid)
/*     */   {
/* 132 */     SGraph sgraph = getSgraph();
/* 133 */     if (sgraph.taskActiveType == 1)
/*     */     {
/* 135 */       int level = RoleInterface.getLevel(roleid);
/* 136 */       if (level == sgraph.activeLevel)
/*     */       {
/* 138 */         if (sgraph.activeMenPai == 0)
/*     */         {
/* 140 */           return true;
/*     */         }
/* 142 */         return sgraph.activeMenPai == RoleInterface.getOccupationId(roleid);
/*     */       }
/* 144 */       return false;
/*     */     }
/* 146 */     if (sgraph.taskActiveType == 2)
/*     */     {
/* 148 */       GraphFinishBean graphFinishBean = Role2graphfinish.select(Long.valueOf(roleid));
/* 149 */       if (graphFinishBean == null)
/*     */       {
/* 151 */         return false;
/*     */       }
/* 153 */       return graphFinishBean.getGraphidtofinish().containsKey(Integer.valueOf(sgraph.activeGraphId));
/*     */     }
/* 155 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean isTeamGraph()
/*     */   {
/* 165 */     return getSgraph().teamTaskGraph;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean isRingTypeGraph()
/*     */   {
/* 175 */     return getSgraph().isRingTypeGraph;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   int getFristTaskId()
/*     */   {
/* 184 */     if (isRingTypeGraph())
/*     */     {
/* 186 */       return -1;
/*     */     }
/* 188 */     SNode snode = getNodebyNodeId(getSgraph().rootNodeId);
/* 189 */     return ((STaskToProperty)snode.taskIdToProperty.get(0)).taskId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public GraphBean createGraphBean(long roleId)
/*     */   {
/* 200 */     SGraph sgraph = getSgraph();
/* 201 */     int rootNodeId = sgraph.rootNodeId;
/* 202 */     SNode snode = getNodebyNodeId(rootNodeId);
/*     */     
/* 204 */     GraphBean graphBean = Pod.newGraphBean();
/* 205 */     graphBean.setGraphid(sgraph.id);
/*     */     
/* 207 */     initNomalNode(roleId, graphBean, snode.nodeID);
/* 208 */     return graphBean;
/*     */   }
/*     */   
/*     */   void initNomalNode(long roleId, GraphBean graphBean, int nodeId)
/*     */   {
/* 213 */     graphBean.getNodebean().setNodeid(nodeId);
/* 214 */     graphBean.getNodebean().setFinishcount(0);
/* 215 */     SNode node = getNodebyNodeId(nodeId);
/* 216 */     addNomalNodeTaskBean(roleId, node, graphBean);
/*     */   }
/*     */   
/*     */   public void addNomalNodeTaskBean(long roleId, SNode snode, GraphBean graphBean)
/*     */   {
/* 221 */     SGraph sgraph = getSgraph();
/* 222 */     if (snode.nodeID == sgraph.rootNodeId)
/*     */     {
/* 224 */       if ((sgraph.isRingTypeGraph) && (!sgraph.isContinueTask) && (!sgraph.fristTaskAtuoAccept))
/*     */       {
/*     */ 
/* 227 */         return;
/*     */       }
/* 229 */       if (isTeamGraph())
/*     */       {
/*     */ 
/* 232 */         return;
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 237 */     for (STaskToProperty sTaskToProperty : snode.taskIdToProperty)
/*     */     {
/* 239 */       if (sTaskToProperty.nodeProperty.taskSetType == 2)
/*     */       {
/* 241 */         randomTaskSetNodeBean(roleId, graphBean, new HashSet(), -1);
/*     */ 
/*     */ 
/*     */ 
/*     */       }
/* 246 */       else if (!graphBean.getNodebean().getTaskbeans().containsKey(Integer.valueOf(sTaskToProperty.taskId)))
/*     */       {
/*     */ 
/*     */ 
/* 250 */         Task task = TaskManager.getTaskById(sTaskToProperty.taskId);
/* 251 */         AcceptTaskCheckResult ret = task.iscanTake(roleId, new HashMap(), new HashMap(), sgraph.id);
/*     */         
/* 253 */         if (ret.isCanTake())
/*     */         {
/*     */ 
/* 256 */           TaskBean taskBean = createTaskBean(roleId, graphBean.getGraphid(), sTaskToProperty.taskId, 1);
/*     */           
/*     */ 
/* 259 */           graphBean.getNodebean().getTaskbeans().put(Integer.valueOf(taskBean.getTaskid()), taskBean);
/*     */           
/*     */ 
/*     */ 
/* 263 */           afterGetNewTask(roleId, graphBean, sTaskToProperty.taskId);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         }
/*     */         else
/*     */         {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 275 */           TaskBean taskBean = createTaskBean(roleId, graphBean.getGraphid(), sTaskToProperty.taskId, 6);
/*     */           
/*     */ 
/* 278 */           graphBean.getNodebean().getTaskbeans().put(Integer.valueOf(taskBean.getTaskid()), taskBean);
/*     */           
/*     */ 
/* 281 */           SCannotAcceptTask sCannotAcceptTask = new SCannotAcceptTask();
/* 282 */           sCannotAcceptTask.graphid = graphBean.getGraphid();
/* 283 */           sCannotAcceptTask.taskid = taskBean.getTaskid();
/* 284 */           sCannotAcceptTask.conids.addAll(ret.getNoConId());
/*     */           
/* 286 */           OnlineManager.getInstance().send(roleId, sCannotAcceptTask);
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   protected void randomTaskSetNodeBean(long roleId, GraphBean graphBean, Set<Integer> hasTaskIds, int oldTaskId)
/*     */   {
/* 295 */     STaskToProperty sTaskToProperty = (STaskToProperty)getNodebyNodeId(graphBean.getNodebean().getNodeid()).taskIdToProperty.get(0);
/*     */     
/* 297 */     TaskSet taskSet = TaskSetManager.getTaskSetById(sTaskToProperty.taskId);
/*     */     
/* 299 */     Set<Integer> taskIds = taskSet.randomCanTakeTaskId(roleId, hasTaskIds, id(), oldTaskId);
/* 300 */     if (taskIds.size() != 1)
/*     */     {
/* 302 */       return;
/*     */     }
/* 304 */     for (Iterator i$ = taskIds.iterator(); i$.hasNext();) { int taskId = ((Integer)i$.next()).intValue();
/*     */       
/* 306 */       TaskBean taskBean = createTaskBean(roleId, graphBean.getGraphid(), taskId, 1);
/* 307 */       RoleTaskManager.sendUpdateTaskState(roleId, graphBean.getGraphid(), taskId, taskBean.getTaskstate());
/*     */       
/* 309 */       graphBean.getNodebean().getTaskbeans().put(Integer.valueOf(taskBean.getTaskid()), taskBean);
/* 310 */       afterGetNewTask(roleId, graphBean, taskId);
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
/*     */   int randomOneTaskInGraph(long roleId)
/*     */   {
/* 323 */     List<Integer> tasks = new ArrayList();
/* 324 */     ArrayList<SNode> nodes = getSgraph().nodes;
/* 325 */     for (SNode node : nodes)
/*     */     {
/* 327 */       STaskToProperty sTaskToProperty = (STaskToProperty)getNodebyNodeId(node.nodeID).taskIdToProperty.get(0);
/*     */       
/* 329 */       TaskSet taskSet = TaskSetManager.getTaskSetById(sTaskToProperty.taskId);
/*     */       
/* 331 */       Set<Integer> taskIds = taskSet.randomCanTakeTaskId(roleId, new HashSet(), id(), 0);
/* 332 */       if (taskIds.size() != 1)
/*     */       {
/* 334 */         return -1;
/*     */       }
/* 336 */       tasks.addAll(taskIds);
/*     */     }
/* 338 */     Random r = Xdb.random();
/* 339 */     int ran = r.nextInt(tasks.size());
/* 340 */     return ((Integer)tasks.get(ran)).intValue();
/*     */   }
/*     */   
/*     */   void afterGetNewTask(long roleId, GraphBean graphBean, int taskId)
/*     */   {
/* 345 */     SGraph sgraph = getSgraph();
/* 346 */     if ((graphBean.getNodebean().getNodeid() == sgraph.rootNodeId) && (graphBean.getAllfinishcount() == 0))
/*     */     {
/* 348 */       if (!sgraph.fristTaskAtuoAccept)
/*     */       {
/* 350 */         return;
/*     */       }
/* 352 */       Procedure.execute(new AccpetTaskProcedure(roleId, graphBean.getGraphid(), taskId));
/* 353 */       return;
/*     */     }
/* 355 */     if (isAutoAcceptTask(graphBean))
/*     */     {
/* 357 */       new AccpetTaskProcedure(roleId, graphBean.getGraphid(), taskId).execute();
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
/*     */   public void afterFinishTask(long roleId, TaskBean taskBean, GraphBean graphBean)
/*     */   {
/* 370 */     SNode snode = getNodebyNodeId(graphBean.getNodebean().getNodeid());
/* 371 */     if (graphBean.getNodebean().getFinishcount() >= ((STaskToProperty)snode.taskIdToProperty.get(0)).nodeProperty.turnNum)
/*     */     {
/* 373 */       lastNodeProc(roleId, taskBean, graphBean, snode);
/*     */ 
/*     */ 
/*     */     }
/* 377 */     else if (((STaskToProperty)snode.taskIdToProperty.get(0)).nodeProperty.taskSetType == 2)
/*     */     {
/* 379 */       TaskSet taskSet = getTaskSet(snode);
/* 380 */       randomGetTask(roleId, graphBean, taskSet, taskBean.getTaskid());
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void lastNodeProc(long roleId, TaskBean taskBean, GraphBean graphBean, SNode snode)
/*     */   {
/* 401 */     for (TaskBean taskBeanDel : graphBean.getNodebean().getTaskbeans().values())
/*     */     {
/*     */ 
/* 404 */       RoleTaskManager.sendUpdateTaskState(roleId, graphBean.getGraphid(), taskBeanDel.getTaskid(), 4);
/*     */     }
/*     */     
/*     */ 
/* 408 */     graphBean.getNodebean().getTaskbeans().clear();
/* 409 */     graphBean.getNodebean().setFinishcount(0);
/* 410 */     graphBean.getNodebean().setNodeid(getSgraph().rootNodeId);
/*     */     
/* 412 */     for (STaskToProperty sTaskToProperty : snode.taskIdToProperty)
/*     */     {
/* 414 */       nextNodeProc(roleId, graphBean, sTaskToProperty);
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
/*     */   private void nextNodeProc(long roleId, GraphBean graphBean, STaskToProperty sTaskToProperty)
/*     */   {
/* 429 */     if (sTaskToProperty.nodeProperty.nextNodeId > 0)
/*     */     {
/* 431 */       initNomalNode(roleId, graphBean, sTaskToProperty.nodeProperty.nextNodeId);
/* 432 */       RoleTask roleTask = RoleTaskManager.getRoleTask(roleId, true);
/* 433 */       graphBean = roleTask.getGraphBean(graphBean.getGraphid());
/* 434 */       for (TaskBean xtaskBean : graphBean.getNodebean().getTaskbeans().values())
/*     */       {
/* 436 */         RoleTaskManager.sendUpdateTaskState(roleId, graphBean.getGraphid(), xtaskBean.getTaskid(), xtaskBean.getTaskstate());
/*     */       }
/*     */       
/*     */     }
/*     */     else
/*     */     {
/* 442 */       addGraphFinishCount(roleId, graphBean);
/* 443 */       TaskInterface.updateTaskCondition(roleId, 13, new Object());
/*     */       
/* 445 */       Graph graph = GraphManager.getInstance().getGraphByGraphId(graphBean.getGraphid());
/* 446 */       if (graph != null)
/*     */       {
/* 448 */         RoleTaskManager.activeGraph(graph.id(), roleId);
/*     */       }
/*     */       
/* 451 */       TaskInterface.closeActivityGraphWithoutEvent(roleId, graphBean.getGraphid());
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
/*     */   void addGraphFinishCount(long roleId, GraphBean graphBean)
/*     */   {
/* 465 */     GraphFinishBean graphFinishBean = Role2graphfinish.get(Long.valueOf(roleId));
/* 466 */     if (graphFinishBean == null)
/*     */     {
/* 468 */       graphFinishBean = Pod.newGraphFinishBean();
/* 469 */       graphFinishBean.getGraphidtofinish().put(Integer.valueOf(graphBean.getGraphid()), Integer.valueOf(1));
/* 470 */       Role2graphfinish.insert(Long.valueOf(roleId), graphFinishBean);
/*     */ 
/*     */ 
/*     */     }
/* 474 */     else if (graphFinishBean.getGraphidtofinish().containsKey(Integer.valueOf(graphBean.getGraphid())))
/*     */     {
/* 476 */       int finishCount = ((Integer)graphFinishBean.getGraphidtofinish().get(Integer.valueOf(graphBean.getGraphid()))).intValue() + 1;
/* 477 */       graphFinishBean.getGraphidtofinish().put(Integer.valueOf(graphBean.getGraphid()), Integer.valueOf(finishCount));
/*     */     }
/*     */     else
/*     */     {
/* 481 */       graphFinishBean.getGraphidtofinish().put(Integer.valueOf(graphBean.getGraphid()), Integer.valueOf(1));
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
/*     */ 
/*     */   public void afterTeamerFinishTeamGraphTask(long roleId, TaskBean taskBean, GraphBean graphBean, Graph graph, boolean isTeamGraphClosed)
/*     */   {
/* 499 */     RoleTaskManager.changeTaskState(roleId, 8, graphBean.getGraphid(), taskBean, 0);
/* 500 */     graphBean.getNodebean().getTaskbeans().remove(Integer.valueOf(taskBean.getTaskid()));
/* 501 */     RoleTaskManager.sendUpdateTaskState(roleId, graphBean.getGraphid(), taskBean.getTaskid(), 8);
/*     */     
/* 503 */     if (isTeamGraphClosed)
/*     */     {
/* 505 */       RoleTaskManager.closeGraphWithoutEvent(graphBean.getGraphid(), roleId, false);
/* 506 */       return;
/*     */     }
/*     */     
/* 509 */     graphBean.getNodebean().setFinishcount(graphBean.getNodebean().getFinishcount() + 1);
/* 510 */     graphBean.setAllfinishcount(graphBean.getAllfinishcount() + 1);
/*     */     
/* 512 */     RoleTaskManager.sendGraphCurRing(roleId, graphBean, 1, getSgraph().isRingTypeGraph);
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
/*     */   public boolean afterGiveUpTask(long roleId, TaskBean taskBean, GraphBean graphBean)
/*     */   {
/* 525 */     SGraph sgraph = getSgraph();
/* 526 */     SNode snode = getNodebyNodeId(graphBean.getNodebean().getNodeid());
/*     */     
/* 528 */     if (((STaskToProperty)snode.taskIdToProperty.get(0)).nodeProperty.taskSetType == 1)
/*     */     {
/* 530 */       if (sgraph.giveUpOperRing == 1)
/*     */       {
/* 532 */         taskNumAddProc(roleId, taskBean, graphBean);
/* 533 */         if (graphBean.getNodebean().getFinishcount() >= ((STaskToProperty)snode.taskIdToProperty.get(0)).nodeProperty.turnNum)
/*     */         {
/* 535 */           lastNodeProc(roleId, taskBean, graphBean, snode);
/*     */ 
/*     */         }
/*     */         
/*     */ 
/*     */ 
/*     */       }
/* 542 */       else if (sgraph.giveUpOperRing == 2)
/*     */       {
/* 544 */         if (!isAutoAcceptTask(graphBean))
/*     */         {
/*     */ 
/*     */ 
/*     */ 
/* 549 */           RoleTaskManager.changeTaskState(roleId, 1, graphBean.getGraphid(), taskBean, 0);
/*     */         }
/*     */         
/* 552 */         taskBean.getConmap().clear();
/* 553 */         RoleTaskManager.sendUpdateTaskState(roleId, id(), taskBean.getTaskid(), taskBean.getTaskstate());
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 558 */     if (((STaskToProperty)snode.taskIdToProperty.get(0)).nodeProperty.taskSetType == 2)
/*     */     {
/* 560 */       if (sgraph.giveUpOperRing == 1)
/*     */       {
/* 562 */         addTaskCount(roleId, graphBean);
/*     */       }
/* 564 */       remCurTask(roleId, taskBean, graphBean);
/*     */     }
/*     */     
/*     */ 
/* 568 */     if (sgraph.giveUpOperRing == 3)
/*     */     {
/* 570 */       RoleTaskManager.closeGraphWithoutEvent(graphBean.getGraphid(), roleId, true);
/*     */     }
/*     */     
/* 573 */     return true;
/*     */   }
/*     */   
/*     */   public TaskSet getTaskSet(SNode snode)
/*     */   {
/* 578 */     STaskToProperty sTaskToProperty = (STaskToProperty)snode.taskIdToProperty.get(0);
/* 579 */     TaskSet taskSet = TaskSetManager.getTaskSetById(sTaskToProperty.taskId);
/* 580 */     if (taskSet == null)
/*     */     {
/* 582 */       logger.error("任务库被删掉了,graphId:" + id() + " taskSetId:" + sTaskToProperty.taskId);
/*     */     }
/* 584 */     return taskSet;
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
/*     */   private void taskNumAddProc(long roleId, TaskBean taskBean, GraphBean graphBean)
/*     */   {
/* 598 */     remCurTask(roleId, taskBean, graphBean);
/* 599 */     addTaskCount(roleId, graphBean);
/*     */   }
/*     */   
/*     */ 
/*     */   private void remCurTask(long roleId, TaskBean taskBean, GraphBean graphBean)
/*     */   {
/* 605 */     RoleTaskManager.changeTaskState(roleId, 4, graphBean.getGraphid(), taskBean, 0);
/* 606 */     graphBean.getNodebean().getTaskbeans().remove(Integer.valueOf(taskBean.getTaskid()));
/* 607 */     RoleTaskManager.sendUpdateTaskState(roleId, graphBean.getGraphid(), taskBean.getTaskid(), 4);
/*     */   }
/*     */   
/*     */ 
/*     */   private void addTaskCount(long roleId, GraphBean graphBean)
/*     */   {
/* 613 */     int finishCount = graphBean.getNodebean().getFinishcount() + 1;
/* 614 */     int graphTaskFinishCount = graphBean.getAllfinishcount() + 1;
/*     */     
/* 616 */     graphBean.getNodebean().setFinishcount(finishCount);
/*     */     
/* 618 */     graphBean.setAllfinishcount(graphTaskFinishCount);
/* 619 */     RoleTaskManager.sendGraphCurRing(roleId, graphBean, 2, getSgraph().isRingTypeGraph);
/*     */     
/* 621 */     if (graphTaskFinishCount >= RoleTaskManager.getGraphAllTaskNum(graphBean.getGraphid()))
/*     */     {
/* 623 */       RoleTaskManager.closeGraphWithoutEvent(graphBean.getGraphid(), roleId, true);
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
/*     */   void randomGetTask(long roleId, GraphBean graphBean, TaskSet taskSet, int oldTaskId)
/*     */   {
/* 639 */     Set<Integer> taskIds = taskSet.randomCanTakeTaskId(roleId, new HashSet(), id(), oldTaskId);
/* 640 */     for (Iterator i$ = taskIds.iterator(); i$.hasNext();) { int taskId = ((Integer)i$.next()).intValue();
/*     */       
/* 642 */       TaskBean taskBeanNew = createTaskBean(roleId, graphBean.getGraphid(), taskId, 1);
/* 643 */       RoleTaskManager.sendUpdateTaskState(roleId, graphBean.getGraphid(), taskId, taskBeanNew.getTaskstate());
/*     */       
/* 645 */       graphBean.getNodebean().getTaskbeans().put(Integer.valueOf(taskBeanNew.getTaskid()), taskBeanNew);
/* 646 */       if ((isAutoAcceptTask(graphBean)) && (taskIds.size() == 1))
/*     */       {
/* 648 */         new AccpetTaskProcedure(roleId, graphBean.getGraphid(), taskId).execute();
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
/*     */   public boolean afterFailTask(long roleId, TaskBean taskBean, GraphBean graphBean)
/*     */   {
/* 663 */     SNode snode = getNodebyNodeId(graphBean.getNodebean().getNodeid());
/*     */     
/* 665 */     if (((STaskToProperty)snode.taskIdToProperty.get(0)).nodeProperty.taskSetType == 1)
/*     */     {
/* 667 */       if (taskBean.getTaskstate() == 4)
/*     */       {
/* 669 */         addTaskCount(roleId, graphBean);
/* 670 */         if (graphBean.getNodebean().getFinishcount() >= ((STaskToProperty)snode.taskIdToProperty.get(0)).nodeProperty.turnNum)
/*     */         {
/* 672 */           lastNodeProc(roleId, taskBean, graphBean, snode);
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 681 */     if (((STaskToProperty)snode.taskIdToProperty.get(0)).nodeProperty.taskSetType == 2)
/*     */     {
/* 683 */       TaskSet taskSet = getTaskSet(snode);
/* 684 */       if (taskBean.getTaskstate() == 4)
/*     */       {
/* 686 */         addTaskCount(roleId, graphBean);
/* 687 */         if (graphBean.getNodebean().getFinishcount() >= ((STaskToProperty)snode.taskIdToProperty.get(0)).nodeProperty.turnNum)
/*     */         {
/* 689 */           lastNodeProc(roleId, taskBean, graphBean, snode);
/*     */         }
/*     */         else
/*     */         {
/* 693 */           randomGetTask(roleId, graphBean, taskSet, taskBean.getTaskid());
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 698 */     if (taskBean.getTaskstate() == 5)
/*     */     {
/* 700 */       taskBean.getConmap().clear();
/*     */     }
/* 702 */     RoleTaskManager.sendUpdateTaskState(roleId, graphBean.getGraphid(), taskBean.getTaskid(), taskBean.getTaskstate());
/* 703 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean isAutoAcceptTask(GraphBean graphBean)
/*     */   {
/* 714 */     return getSgraph().autoAcceptNextTask;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void refreshNewTask(long newLeader, GraphBean newGraphBean)
/*     */   {
/* 725 */     SNode snode = getNodebyNodeId(newGraphBean.getNodebean().getNodeid());
/* 726 */     if (snode != null) {
/* 727 */       addNomalNodeTaskBean(newLeader, snode, newGraphBean);
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
/*     */   public List<TaskBean> refreshTaskSetGraph(long roleId, GraphBean graphBean, boolean sendMsg)
/*     */   {
/* 740 */     List<TaskBean> taskBeans = new ArrayList();
/* 741 */     Set<Integer> hasTaskIds = new HashSet();
/* 742 */     hasTaskIds.addAll(graphBean.getNodebean().getTaskbeans().keySet());
/* 743 */     randomTaskSetNodeBean(roleId, graphBean, hasTaskIds, -1);
/* 744 */     for (TaskBean taskNewBean : graphBean.getNodebean().getTaskbeans().values())
/*     */     {
/* 746 */       if (!hasTaskIds.contains(Integer.valueOf(taskNewBean.getTaskid())))
/*     */       {
/* 748 */         taskBeans.add(taskNewBean);
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 754 */     return taskBeans;
/*     */   }
/*     */   
/*     */   List<SNode> getNodeInfo()
/*     */   {
/* 759 */     List<SNode> nodes = new ArrayList();
/* 760 */     int rootNodeId = getSgraph().rootNodeId;
/* 761 */     SNode rootNode = getNodebyNodeId(rootNodeId);
/* 762 */     nodes.add(rootNode);
/* 763 */     SNode node = rootNode;
/* 764 */     while (((STaskToProperty)node.taskIdToProperty.get(0)).nodeProperty.nextNodeId > 0)
/*     */     {
/* 766 */       int nextNodeId = ((STaskToProperty)node.taskIdToProperty.get(0)).nodeProperty.nextNodeId;
/* 767 */       node = getNodebyNodeId(nextNodeId);
/* 768 */       nodes.add(node);
/*     */     }
/* 770 */     return nodes;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   List<Integer> getNodeInfoByTurn(int turn)
/*     */   {
/* 781 */     List<Integer> nodeInfo = new ArrayList();
/* 782 */     List<SNode> nodes = getNodeInfo();
/* 783 */     int count = 0;
/* 784 */     for (SNode node : nodes)
/*     */     {
/* 786 */       int littleCount = turn - count;
/* 787 */       count += ((STaskToProperty)node.taskIdToProperty.get(0)).nodeProperty.turnNum;
/* 788 */       if (turn <= count)
/*     */       {
/* 790 */         nodeInfo.add(Integer.valueOf(node.nodeID));
/* 791 */         nodeInfo.add(Integer.valueOf(littleCount));
/* 792 */         return nodeInfo;
/*     */       }
/*     */     }
/* 795 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   List<Integer> getNodeInfoByTaskId(int taskId)
/*     */   {
/* 806 */     if (getSgraph().isRingTypeGraph)
/*     */     {
/* 808 */       return null;
/*     */     }
/* 810 */     List<Integer> nodeInfo = new ArrayList();
/* 811 */     List<SNode> nodes = getNodeInfo();
/* 812 */     int count = 0;
/* 813 */     for (SNode node : nodes)
/*     */     {
/* 815 */       if (taskId == ((STaskToProperty)node.taskIdToProperty.get(0)).taskId)
/*     */       {
/* 817 */         nodeInfo.add(Integer.valueOf(node.nodeID));
/* 818 */         nodeInfo.add(Integer.valueOf(count));
/* 819 */         return nodeInfo;
/*     */       }
/* 821 */       count++;
/*     */     }
/* 823 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   int getGraphType()
/*     */   {
/* 833 */     int type = getSgraph().taskType;
/* 834 */     if (type <= 0)
/*     */     {
/* 836 */       type = 100;
/*     */     }
/* 838 */     return type;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\task\main\Graph.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */