/*     */ package mzm.gsp.task.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.fight.main.FightInterface;
/*     */ import mzm.gsp.fight.main.FightReason;
/*     */ import mzm.gsp.task.condition.AbsCondition;
/*     */ import mzm.gsp.task.condition.Con_Bag_9;
/*     */ import mzm.gsp.task.confbean.SGraph;
/*     */ import mzm.gsp.task.confbean.STaskConBag;
/*     */ import mzm.gsp.team.main.TeamInfo;
/*     */ import mzm.gsp.team.main.TeamInterface;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.GraphBean;
/*     */ import xbean.NodeBean;
/*     */ import xbean.TaskBean;
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
/*     */ public class TaskImplManager
/*     */ {
/*     */   public static TaskFinishNeedItem getFinishTaskItemImpl(int taskId)
/*     */   {
/*  39 */     TaskFinishNeedItem itemInfo = new TaskFinishNeedItem();
/*  40 */     Task task = TaskManager.getTaskById(taskId);
/*  41 */     if (task == null)
/*     */     {
/*  43 */       return itemInfo;
/*     */     }
/*  45 */     List<AbsCondition> conList = task.getCondition(9, 2);
/*  46 */     for (AbsCondition absCondition : conList)
/*     */     {
/*  48 */       if ((absCondition != null) && ((absCondition instanceof Con_Bag_9)) && 
/*     */       
/*     */ 
/*     */ 
/*  52 */         (absCondition.getConType() == 2))
/*     */       {
/*     */ 
/*     */ 
/*  56 */         Con_Bag_9 con_Bag_9 = (Con_Bag_9)absCondition;
/*  57 */         STaskConBag conBag = con_Bag_9.getConBag();
/*  58 */         switch (conBag.takeItemType)
/*     */         {
/*     */         case 1: 
/*  61 */           addItemMap(itemInfo.getItemMap(), conBag);
/*  62 */           break;
/*     */         case 2: 
/*  64 */           addItemMap(itemInfo.getItemConMap(), conBag);
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     
/*  70 */     return itemInfo;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void addItemMap(Map<Integer, Integer> itemMap, STaskConBag conBag)
/*     */   {
/*  81 */     Integer num = (Integer)itemMap.get(Integer.valueOf(conBag.takeCfgId));
/*  82 */     if (num == null)
/*     */     {
/*  84 */       itemMap.put(Integer.valueOf(conBag.takeCfgId), Integer.valueOf(conBag.takeCfgCount));
/*     */     }
/*     */     else
/*     */     {
/*  88 */       num = Integer.valueOf(num.intValue() + conBag.takeCfgCount);
/*  89 */       itemMap.put(Integer.valueOf(conBag.takeCfgId), num);
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
/*     */   public static int getTaskStateImpl(long roleId, int graphId, int taskId)
/*     */   {
/* 106 */     RoleTask roleTask = RoleTaskManager.getRoleTask(roleId, false);
/* 107 */     GraphBean graphBean = roleTask.getGraphBean(graphId);
/* 108 */     if (graphBean == null)
/*     */     {
/* 110 */       return -1;
/*     */     }
/*     */     
/* 113 */     if (graphBean.getNodebean() == null)
/*     */     {
/* 115 */       return -1;
/*     */     }
/* 117 */     if (graphBean.getNodebean().getTaskbeans() == null)
/*     */     {
/* 119 */       return -1;
/*     */     }
/* 121 */     TaskBean xTaskBean = (TaskBean)graphBean.getNodebean().getTaskbeans().get(Integer.valueOf(taskId));
/* 122 */     if (xTaskBean == null)
/*     */     {
/* 124 */       return -1;
/*     */     }
/* 126 */     return xTaskBean.getTaskstate();
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
/*     */   public static int randomOneTaskInGraphImpl(long roleId, int graphId)
/*     */   {
/* 140 */     Graph graph = GraphManager.getGraphById(graphId);
/* 141 */     if (graph == null)
/*     */     {
/* 143 */       GameServer.logger().error(String.format("[task]TaskImplManager.randomOneTaskInGraphImpl@ graph cfg is null!|roleId=%d|graphId=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(graphId) }));
/*     */       
/*     */ 
/* 146 */       return -1;
/*     */     }
/* 148 */     return graph.randomOneTaskInGraph(roleId);
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
/*     */   public static void giveUpTaskImpl(long roleId, int graphId, int taskId)
/*     */   {
/* 164 */     new GiveupTaskProcedure(roleId, graphId, taskId).execute();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean isTeamGraphImpl(int graphId)
/*     */   {
/* 175 */     Graph graph = GraphManager.getGraphById(graphId);
/* 176 */     if (graph == null)
/*     */     {
/* 178 */       return false;
/*     */     }
/* 180 */     return graph.isTeamGraph();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean isMainGraphIdImp(int graphId)
/*     */   {
/* 192 */     Graph graph = GraphManager.getGraphById(graphId);
/* 193 */     if (graph == null)
/*     */     {
/* 195 */       return false;
/*     */     }
/* 197 */     if (graph.getSgraph().taskType == 1)
/*     */     {
/* 199 */       return true;
/*     */     }
/* 201 */     return false;
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
/*     */   public static Map<Integer, List<TaskStateInfo>> getRoleTaskStateImpl(long roleId)
/*     */   {
/* 214 */     RoleTask roleTask = RoleTaskManager.getRoleTask(roleId, false);
/* 215 */     if (roleTask == null)
/*     */     {
/* 217 */       return null;
/*     */     }
/* 219 */     return roleTask.getTaskStateInfo();
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
/*     */   public static void startTaskFight(int taskId, long roleId, int battleId, int mapCfgid, int graphId)
/*     */   {
/* 235 */     MapFightContext mapFightContext = new MapFightContext();
/* 236 */     mapFightContext.setGraphId(graphId);
/* 237 */     mapFightContext.setMapId(mapCfgid);
/* 238 */     mapFightContext.setTaskId(taskId);
/* 239 */     mapFightContext.setTaskState(2);
/*     */     
/* 241 */     if (!isCanStartPVEFight(graphId, taskId, roleId, mapFightContext))
/*     */     {
/* 243 */       return;
/*     */     }
/* 245 */     Integer fightType = GraphManager.getGraphFightType(graphId);
/* 246 */     if (fightType == null)
/*     */     {
/* 248 */       FightInterface.startPVEFight(roleId, battleId, mapFightContext, FightReason.Task_CON_PVE_FIGHT);
/*     */     }
/*     */     else
/*     */     {
/* 252 */       FightInterface.startPVEFight(roleId, battleId, mapFightContext, fightType.intValue(), FightReason.Task_CON_PVE_FIGHT);
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
/*     */   private static boolean isCanStartPVEFight(int graphId, int taskId, long roleId, MapFightContext mapFightContext)
/*     */   {
/* 270 */     Task task = TaskManager.getTaskById(taskId);
/* 271 */     if (task == null)
/*     */     {
/* 273 */       return false;
/*     */     }
/* 275 */     List<Long> fightMembers = getCanEnterFightMembers(roleId);
/* 276 */     if (fightMembers.size() == 0)
/*     */     {
/* 278 */       return false;
/*     */     }
/* 280 */     if (!task.canEnterFight(fightMembers))
/*     */     {
/* 282 */       return false;
/*     */     }
/*     */     
/* 285 */     List<Long> sameTaskMembers = getSameTaskMembers(graphId, taskId, fightMembers);
/* 286 */     if (sameTaskMembers.size() == 0)
/*     */     {
/* 288 */       return false;
/*     */     }
/* 290 */     mapFightContext.setRoleListHaveSameTask(sameTaskMembers);
/* 291 */     mapFightContext.setRoleList(fightMembers);
/* 292 */     return true;
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
/*     */   private static List<Long> getSameTaskMembers(int graphId, int taskId, List<Long> fightMembers)
/*     */   {
/* 305 */     List<Long> haveSameTaskRoles = new ArrayList();
/* 306 */     for (Iterator i$ = fightMembers.iterator(); i$.hasNext();) { long memberId = ((Long)i$.next()).longValue();
/*     */       
/* 308 */       if (TaskInterface.getTaskState(memberId, graphId, taskId) == 2)
/*     */       {
/* 310 */         haveSameTaskRoles.add(Long.valueOf(memberId));
/*     */       }
/*     */     }
/* 313 */     return haveSameTaskRoles;
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
/*     */   public static boolean canEnterFight(long roleId, int graphId, int taskId)
/*     */   {
/* 331 */     Task task = TaskManager.getTaskById(taskId);
/* 332 */     if (task == null)
/*     */     {
/* 334 */       return false;
/*     */     }
/* 336 */     List<Long> fightMembers = getCanEnterFightMembers(roleId);
/* 337 */     if (fightMembers.size() == 0)
/*     */     {
/* 339 */       return false;
/*     */     }
/* 341 */     return task.canEnterFight(fightMembers);
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
/*     */   static List<Long> getCanEnterFightMembers(long roleId)
/*     */   {
/* 354 */     List<Long> members = new ArrayList();
/* 355 */     TeamInfo teamInfo = TeamInterface.getTeamInfoByRoleId(roleId);
/* 356 */     if (teamInfo == null)
/*     */     {
/* 358 */       members.add(Long.valueOf(roleId));
/* 359 */       return members;
/*     */     }
/* 361 */     if (teamInfo.isLeader(roleId))
/*     */     {
/* 363 */       members.addAll(teamInfo.getTeamNormalList());
/*     */ 
/*     */ 
/*     */     }
/* 367 */     else if (teamInfo.getMemberStatus(roleId) == 1)
/*     */     {
/* 369 */       members.add(Long.valueOf(roleId));
/*     */     }
/*     */     
/* 372 */     return members;
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
/*     */   static TaskData getOwnTaskData(long roleId, int graphId)
/*     */   {
/* 387 */     TaskData taskData = new TaskData();
/*     */     
/* 389 */     RoleTask roleTask = RoleTaskManager.getRoleTask(roleId, false);
/* 390 */     if (roleTask == null)
/*     */     {
/* 392 */       return null;
/*     */     }
/*     */     
/* 395 */     GraphBean graphBean = roleTask.getGraphBean(graphId);
/* 396 */     if (graphBean == null)
/*     */     {
/* 398 */       return null;
/*     */     }
/* 400 */     TaskBean taskBean = null;
/* 401 */     Map<Integer, TaskBean> taskBeans = graphBean.getNodebean().getTaskbeans();
/* 402 */     if (taskBeans.size() != 1)
/*     */     {
/* 404 */       return null;
/*     */     }
/* 406 */     Iterator i$ = taskBeans.values().iterator(); if (i$.hasNext()) { TaskBean xTaskBean = (TaskBean)i$.next();
/*     */       
/* 408 */       taskBean = xTaskBean;
/*     */     }
/*     */     
/* 411 */     if (taskBean == null)
/*     */     {
/* 413 */       return null;
/*     */     }
/* 415 */     taskData.setGraphId(graphId);
/* 416 */     taskData.setTaskId(taskBean.getTaskid());
/* 417 */     taskData.setState(taskBean.getTaskstate());
/* 418 */     return taskData;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\task\main\TaskImplManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */