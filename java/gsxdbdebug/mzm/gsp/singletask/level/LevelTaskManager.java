/*     */ package mzm.gsp.singletask.level;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.function.confbean.SLevelActiveGraphCfg;
/*     */ import mzm.gsp.function.confbean.STLevel2eGraphs;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.task.main.AccpetTaskProcedure;
/*     */ import mzm.gsp.task.main.TaskData;
/*     */ import mzm.gsp.task.main.TaskInterface;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*     */ import mzm.gsp.util.Pair;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.LevelTaskInfo;
/*     */ import xbean.OwnTaskData;
/*     */ import xbean.Pod;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class LevelTaskManager
/*     */ {
/*     */   static Set<Integer> getCanTakeGraphIds(long roleId, int level, LevelTaskInfo xLvInfo)
/*     */   {
/*  37 */     Set<Integer> canTakeGraphIds = getCanTaskTaskIds(level);
/*  38 */     if ((canTakeGraphIds == null) || (canTakeGraphIds.size() == 0))
/*     */     {
/*  40 */       return new HashSet();
/*     */     }
/*     */     
/*  43 */     Set<Integer> doneGraphIds = getDoneGraphIds(xLvInfo);
/*  44 */     if (GameServer.logger().isDebugEnabled())
/*     */     {
/*  46 */       GameServer.logger().debug(String.format("[levelgraph]LevelTaskManager.getCanTakeGraphIds@ lv graph info!|roleId=%d|roleLv=%d|activedGraphIds=%s|canTakeGraphIds=%s", new Object[] { Long.valueOf(roleId), Integer.valueOf(level), doneGraphIds.toString(), canTakeGraphIds.toString() }));
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*  51 */     canTakeGraphIds.removeAll(doneGraphIds);
/*  52 */     return canTakeGraphIds;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static Set<Integer> getDoneGraphIds(LevelTaskInfo xLvInfo)
/*     */   {
/*  63 */     Map<Integer, Set<Integer>> doneGraphInfos = getDoneLvGraphIds(xLvInfo);
/*  64 */     if (doneGraphInfos.size() == 0)
/*     */     {
/*  66 */       return new HashSet();
/*     */     }
/*  68 */     Set<Integer> doneGraphIds = new HashSet();
/*  69 */     for (Set<Integer> graphIds : doneGraphInfos.values())
/*     */     {
/*  71 */       doneGraphIds.addAll(graphIds);
/*     */     }
/*  73 */     return doneGraphIds;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static Map<Integer, Set<Integer>> getDoneLvGraphIds(LevelTaskInfo xLvInfo)
/*     */   {
/*  84 */     Map<Integer, Set<Integer>> doneGraphIds = new HashMap();
/*  85 */     Map<Integer, OwnTaskData> xOwnInfo = xLvInfo.getLevel2graphids();
/*  86 */     Iterator<Map.Entry<Integer, OwnTaskData>> it = xOwnInfo.entrySet().iterator();
/*  87 */     while (it.hasNext())
/*     */     {
/*  89 */       Map.Entry<Integer, OwnTaskData> entry = (Map.Entry)it.next();
/*  90 */       int lv = ((Integer)entry.getKey()).intValue();
/*  91 */       OwnTaskData xData = (OwnTaskData)entry.getValue();
/*  92 */       Set<Integer> lvActivedGraphIds = xData.getGraphids();
/*  93 */       if (lvActivedGraphIds.size() != 0)
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/*  98 */         Set<Integer> graphIds = (Set)doneGraphIds.get(Integer.valueOf(lv));
/*  99 */         if (graphIds == null)
/*     */         {
/* 101 */           graphIds = new HashSet();
/* 102 */           doneGraphIds.put(Integer.valueOf(lv), graphIds);
/*     */         }
/* 104 */         graphIds.addAll(lvActivedGraphIds);
/*     */       } }
/* 106 */     return doneGraphIds;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static Set<Integer> getCanTaskTaskIds(int lv)
/*     */   {
/* 117 */     Set<Integer> canGetGraphIds = new HashSet();
/* 118 */     for (int i = 1; i <= lv; i++)
/*     */     {
/* 120 */       canGetGraphIds.addAll(getGraphIds(i));
/*     */     }
/* 122 */     return canGetGraphIds;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static Set<Integer> getGraphIds(int lv)
/*     */   {
/* 134 */     STLevel2eGraphs cfg = STLevel2eGraphs.get(lv);
/* 135 */     if (cfg == null)
/*     */     {
/* 137 */       return new HashSet();
/*     */     }
/* 139 */     return new HashSet(cfg.graphIds);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static int getGraphActivelv(int graphId)
/*     */   {
/* 150 */     SLevelActiveGraphCfg cfg = SLevelActiveGraphCfg.get(graphId);
/* 151 */     if (cfg == null)
/*     */     {
/* 153 */       return -1;
/*     */     }
/* 155 */     return cfg.activeLv;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static Set<Integer> getAllLevelGraphIds()
/*     */   {
/* 165 */     return SLevelActiveGraphCfg.getAll().keySet();
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
/*     */   static Set<Integer> checkAndActiveNewGraphs(LevelTaskInfo xLvInfo, long roleId, String userId, int roleLv)
/*     */   {
/* 181 */     Set<Integer> needTakeGraphIds = getCanTakeGraphIds(roleId, roleLv, xLvInfo);
/* 182 */     if ((needTakeGraphIds == null) || (needTakeGraphIds.size() == 0))
/*     */     {
/* 184 */       return null;
/*     */     }
/*     */     
/* 187 */     Set<Integer> addActivedGraphIds = new HashSet();
/* 188 */     for (Integer graphId : needTakeGraphIds)
/*     */     {
/* 190 */       TaskInterface.activeGraph(Long.valueOf(roleId), graphId.intValue());
/* 191 */       addActivedGraphIds.add(graphId);
/*     */     }
/*     */     
/* 194 */     if (addActivedGraphIds.size() == 0)
/*     */     {
/* 196 */       return null;
/*     */     }
/* 198 */     addActivedGraphId(xLvInfo, addActivedGraphIds, roleId, roleLv);
/* 199 */     return addActivedGraphIds;
/*     */   }
/*     */   
/*     */   static void checkCanActiveGraph(long roleId, String userid, LevelTaskInfo xLvInfo)
/*     */   {
/* 204 */     int level = RoleInterface.getLevel(roleId);
/* 205 */     Set<Integer> addActivedGraphIds = checkAndActiveNewGraphs(xLvInfo, roleId, userid, level);
/* 206 */     if ((addActivedGraphIds == null) || (addActivedGraphIds.size() == 0))
/*     */     {
/* 208 */       return;
/*     */     }
/*     */     
/* 211 */     GameServer.logger().info(String.format("[levelgraph]LevelTaskManager.checkCanActiveGraph@ active new graphIds!|roleId=%d|roleLv=%d|graphIds=%s", new Object[] { Long.valueOf(roleId), Integer.valueOf(level), addActivedGraphIds.toString() }));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void checkRoleGraphValid(LevelTaskInfo xLvInfo, long roleId, String userId)
/*     */   {
/* 220 */     checkGraph(roleId, getCanChange2AlreadyAcceptGraphIds(userId, roleId, getDoneGraphIds(xLvInfo)));
/*     */   }
/*     */   
/*     */   static void addActivedGraphId(LevelTaskInfo xLvInfo, Set<Integer> addActivedGraphIds, long roleId, int roleLv)
/*     */   {
/* 225 */     if ((addActivedGraphIds == null) || (addActivedGraphIds.size() == 0))
/*     */     {
/* 227 */       return;
/*     */     }
/* 229 */     for (Iterator i$ = addActivedGraphIds.iterator(); i$.hasNext();) { int graphId = ((Integer)i$.next()).intValue();
/*     */       
/* 231 */       int activeLv = getGraphActivelv(graphId);
/* 232 */       if (activeLv < 0)
/*     */       {
/* 234 */         GameServer.logger().error(String.format("[levelgraph]LevelTaskManager.addActivedGraphId@ activeLv illegal!|roleId=%d|graphId=%d|roleLv=%d|activeLv=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(graphId), Integer.valueOf(roleLv), Integer.valueOf(activeLv) }));
/*     */       }
/*     */       
/*     */ 
/*     */ 
/* 239 */       addActivedGraphId(xLvInfo, activeLv, graphId);
/*     */     }
/*     */   }
/*     */   
/*     */   static void addActivedGraphId(LevelTaskInfo xLvInfo, int level, int graphId)
/*     */   {
/* 245 */     OwnTaskData xOwnData = (OwnTaskData)xLvInfo.getLevel2graphids().get(Integer.valueOf(level));
/* 246 */     if (xOwnData == null)
/*     */     {
/* 248 */       xOwnData = Pod.newOwnTaskData();
/* 249 */       xLvInfo.getLevel2graphids().put(Integer.valueOf(level), xOwnData);
/*     */     }
/* 251 */     xOwnData.getGraphids().add(Integer.valueOf(graphId));
/*     */   }
/*     */   
/*     */   private static Set<Integer> getCanChange2AlreadyAcceptGraphIds(String userId, long roleId, Set<Integer> graphIds)
/*     */   {
/* 256 */     Set<Integer> needGraphIds = new HashSet();
/* 257 */     for (Iterator i$ = graphIds.iterator(); i$.hasNext();) { int graphId = ((Integer)i$.next()).intValue();
/*     */       
/* 259 */       SLevelActiveGraphCfg cfg = SLevelActiveGraphCfg.get(graphId);
/* 260 */       if (cfg == null)
/*     */       {
/* 262 */         GameServer.logger().error(String.format("[levelgraph]LevelTaskManager.getCanChange2AlreadyAcceptGraphIds@ graph 2 cfg not exist!|roleId=%d|graphId=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(graphId) }));
/*     */ 
/*     */       }
/*     */       else
/*     */       {
/*     */ 
/* 268 */         Pair<Boolean, Boolean> res = canUseFunction(userId, roleId, cfg.activityId, cfg.openId);
/* 269 */         if (((Boolean)res.first).booleanValue())
/*     */         {
/*     */ 
/*     */ 
/*     */ 
/* 274 */           needGraphIds.add(Integer.valueOf(graphId)); }
/*     */       } }
/* 276 */     return needGraphIds;
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
/*     */   private static Pair<Boolean, Boolean> canUseFunction(String userId, long roleId, int activityId, int openId)
/*     */   {
/* 290 */     Pair<Boolean, Boolean> res = new Pair(Boolean.valueOf(true), Boolean.valueOf(false));
/* 291 */     res.first = Boolean.valueOf(true);
/* 292 */     res.second = Boolean.valueOf((activityId == 0) && (openId == 0));
/* 293 */     if (activityId > 0)
/*     */     {
/* 295 */       long curTime = DateTimeUtils.getCurrTimeInMillis();
/* 296 */       long endTime = ActivityInterface.getActivityEndTime(activityId);
/* 297 */       if (GameServer.logger().isDebugEnabled())
/*     */       {
/* 299 */         GameServer.logger().debug(String.format("[leveltask]roleId=%d|activityId=%d|curtime=%s|endtime=%s", new Object[] { Long.valueOf(roleId), Integer.valueOf(activityId), DateTimeUtils.formatTimestamp(curTime), DateTimeUtils.formatTimestamp(endTime) }));
/*     */       }
/*     */       
/*     */ 
/* 303 */       if (DateTimeUtils.getCurrTimeInMillis() > ActivityInterface.getActivityEndTime(activityId))
/*     */       {
/* 305 */         GameServer.logger().error(String.format("[levelgraph]LevelTaskManager.canUseFunction@ activity not open yet!|roleId=%d|activityId=%d|openId=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(activityId), Integer.valueOf(openId) }));
/*     */         
/*     */ 
/*     */ 
/* 309 */         res.first = Boolean.valueOf(false);
/*     */       }
/*     */     }
/* 312 */     if (openId > 0)
/*     */     {
/* 314 */       if (!OpenInterface.getOpenStatus(openId))
/*     */       {
/* 316 */         GameServer.logger().error(String.format("[levelgraph]LevelTaskManager.canUseFunction@ function not open yet!|roleId=%d|activityId=%d|openId=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(activityId), Integer.valueOf(openId) }));
/*     */         
/*     */ 
/*     */ 
/* 320 */         res.first = Boolean.valueOf(false);
/*     */       }
/*     */     }
/* 323 */     return res;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static void checkGraph(long roleId, Set<Integer> graphIds)
/*     */   {
/* 334 */     if ((graphIds == null) || (graphIds.size() == 0))
/*     */     {
/* 336 */       return;
/*     */     }
/* 338 */     for (Iterator i$ = graphIds.iterator(); i$.hasNext();) { int graphId = ((Integer)i$.next()).intValue();
/*     */       
/* 340 */       TaskData taskData = TaskInterface.getRoleGraphTask(roleId, graphId);
/* 341 */       if (taskData == null)
/*     */       {
/* 343 */         if (GameServer.logger().isDebugEnabled())
/*     */         {
/* 345 */           GameServer.logger().debug(String.format("[leveltask]LevelTaskManager.checkTask@ not own this graphId|roleId=%d|graphId=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(graphId) }));
/*     */ 
/*     */         }
/*     */         
/*     */ 
/*     */       }
/* 351 */       else if (taskData.getState() != 1)
/*     */       {
/* 353 */         if (GameServer.logger().isDebugEnabled())
/*     */         {
/* 355 */           GameServer.logger().debug(String.format("[leveltask]LevelTaskManager.checkTask@ not can accept task!|roleId=%d|graphId=%d|taskId=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(graphId), Integer.valueOf(taskData.getTaskId()) }));
/*     */         }
/*     */         
/*     */ 
/*     */       }
/*     */       else
/*     */       {
/* 362 */         GameServer.logger().info(String.format("[leveltask]LevelTaskManager.checkTask@ change task from can accept state to already accept state!|roleId=%d|graphId=%d|taskId=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(graphId), Integer.valueOf(taskData.getTaskId()) }));
/*     */         
/*     */ 
/*     */ 
/* 366 */         NoneRealTimeTaskManager.getInstance().addTask(new AccpetTaskProcedure(roleId, graphId, taskData.getTaskId()));
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\singletask\level\LevelTaskManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */