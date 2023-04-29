/*     */ package mzm.gsp.singletask.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Random;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.activity.SSingleTaskNormalRes;
/*     */ import mzm.gsp.activity.confbean.STGraph2ActivityId;
/*     */ import mzm.gsp.activity.confbean.STSingleTaskGraphLibCfg;
/*     */ import mzm.gsp.activity.confbean.STSingleTaskModCfg;
/*     */ import mzm.gsp.activity.confbean.SingleTaskCfg;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.task.main.TaskInterface;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.AllActivityInfo;
/*     */ import xbean.SingleActivityInfo;
/*     */ import xdb.Xdb;
/*     */ import xtable.Role2singleinfo;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SingleTaskManager
/*     */ {
/*     */   static int getActivityId(int graphId)
/*     */   {
/*  35 */     STGraph2ActivityId cfg = STGraph2ActivityId.get(graphId);
/*  36 */     if (cfg == null)
/*     */     {
/*  38 */       return -1;
/*     */     }
/*  40 */     return cfg.activityId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static int getModId(int activityId, int ringNum)
/*     */   {
/*  52 */     STSingleTaskModCfg cfg = STSingleTaskModCfg.get(activityId);
/*  53 */     if (cfg == null)
/*     */     {
/*  55 */       return -1;
/*     */     }
/*  57 */     Integer modId = (Integer)cfg.ring2modId.get(Integer.valueOf(ringNum));
/*     */     
/*  59 */     return modId == null ? -1 : modId.intValue();
/*     */   }
/*     */   
/*     */   static SingleTaskCfg getSingleTaskCfg(int activityId)
/*     */   {
/*  64 */     SingleTaskCfg cfg = SingleTaskCfg.get(activityId);
/*  65 */     if (cfg == null)
/*     */     {
/*  67 */       GameServer.logger().error(String.format("[singleTask]SingleTaskManager.getSingleTaskCfg@ cfg is null!|activityId=%d", new Object[] { Integer.valueOf(activityId) }));
/*     */     }
/*     */     
/*  70 */     return cfg;
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
/*     */   static void sendSingleNotice(long roleid, boolean afterSuc, int result, String... args)
/*     */   {
/*  83 */     SSingleTaskNormalRes pro = new SSingleTaskNormalRes();
/*  84 */     pro.result = result;
/*  85 */     for (String arg : args)
/*     */     {
/*  87 */       pro.args.add(arg);
/*     */     }
/*  89 */     if (afterSuc)
/*     */     {
/*  91 */       OnlineManager.getInstance().send(roleid, pro);
/*     */     }
/*     */     else
/*     */     {
/*  95 */       OnlineManager.getInstance().sendAtOnce(roleid, pro);
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
/*     */   static int getNewGraphId(SingleTaskCfg cfg, int oldGraphId)
/*     */   {
/* 108 */     if (cfg == null)
/*     */     {
/* 110 */       GameServer.logger().error(String.format("[singleTask]PSingleTaskActivityInit.initData@ cfg not exist!|oldGraphId=%d", new Object[] { Integer.valueOf(oldGraphId) }));
/*     */       
/* 112 */       return -1;
/*     */     }
/* 114 */     STSingleTaskGraphLibCfg libCfg = STSingleTaskGraphLibCfg.get(cfg.graphLibId);
/* 115 */     if (libCfg == null)
/*     */     {
/* 117 */       GameServer.logger().error(String.format("[singleTask]PSingleTaskActivityInit.initData@ libCfg not exist!|graphLibId=%d", new Object[] { Integer.valueOf(cfg.graphLibId) }));
/*     */       
/*     */ 
/* 120 */       return -1;
/*     */     }
/*     */     
/* 123 */     int newGraphId = getNewGraphId(oldGraphId, libCfg.graphId2weight, libCfg.weightSum, cfg.ranType);
/* 124 */     if (newGraphId <= 0)
/*     */     {
/* 126 */       return -1;
/*     */     }
/* 128 */     if (newGraphId != oldGraphId) {}
/*     */     
/*     */ 
/*     */ 
/* 132 */     return newGraphId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static Set<Integer> getGraphIds(int graphLibId)
/*     */   {
/* 143 */     STSingleTaskGraphLibCfg libCfg = STSingleTaskGraphLibCfg.get(graphLibId);
/* 144 */     if (libCfg == null)
/*     */     {
/* 146 */       return new HashSet();
/*     */     }
/* 148 */     return new HashSet(libCfg.graphId2weight.keySet());
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
/*     */   static int getNewGraphId(int oldGraphId, Map<Integer, Integer> cfgGraphIds, int allWeight, int ranType)
/*     */   {
/* 166 */     int newGraphId = -1;
/* 167 */     if ((cfgGraphIds == null) || (cfgGraphIds.size() == 0))
/*     */     {
/* 169 */       GameServer.logger().error(String.format("[singleTask]SingleTaskManager.getNewGraphId@ cfgGraphIds is null!|oldGraphId=%d", new Object[] { Integer.valueOf(oldGraphId) }));
/*     */       
/* 171 */       return -1;
/*     */     }
/* 173 */     if (cfgGraphIds.size() == 1)
/*     */     {
/* 175 */       if (GameServer.logger().isDebugEnabled())
/*     */       {
/* 177 */         GameServer.logger().error(String.format("[singleTask]SingleTaskManager.getNewGraphId@ cfgGraphIds is null!|oldGraphId=%d", new Object[] { Integer.valueOf(oldGraphId) }));
/*     */       }
/*     */       
/*     */ 
/* 181 */       for (Iterator i$ = cfgGraphIds.keySet().iterator(); i$.hasNext();) { int graphId = ((Integer)i$.next()).intValue();
/*     */         
/* 183 */         newGraphId = graphId;
/*     */       }
/* 185 */       return newGraphId;
/*     */     }
/* 187 */     Map<Integer, Integer> cfgGraphIdsCopy = new HashMap(cfgGraphIds);
/* 188 */     switch (ranType)
/*     */     {
/*     */     case 1: 
/*     */       break;
/*     */     case 2: 
/* 193 */       if (oldGraphId > 0)
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/* 198 */         Integer oldWeight = (Integer)cfgGraphIdsCopy.remove(Integer.valueOf(oldGraphId));
/* 199 */         if (oldWeight != null)
/*     */         {
/* 201 */           allWeight -= oldWeight.intValue();
/*     */         }
/*     */         else
/*     */         {
/* 205 */           GameServer.logger().info(String.format("[singleTask]SingleTaskManager.getNewGraphId@ not contains oldGraph!|oldGraphId=%d|cfgGraphIds=%s|ranType=%d|allWeight=%d", new Object[] { Integer.valueOf(oldGraphId), cfgGraphIds.toString(), Integer.valueOf(ranType), Integer.valueOf(allWeight) }));
/*     */         }
/*     */       }
/*     */       
/*     */ 
/* 210 */       break;
/*     */     
/*     */     default: 
/* 213 */       GameServer.logger().error(String.format("[singleTask]SingleTaskManager.getNewGraphId@ illegal ranType!|oldGraphId=%d|cfgGraphIds=%s|ranType=%d|allWeight=%d", new Object[] { Integer.valueOf(oldGraphId), cfgGraphIds.toString(), Integer.valueOf(ranType), Integer.valueOf(allWeight) }));
/*     */       
/*     */ 
/*     */ 
/* 217 */       return -1;
/*     */     }
/* 219 */     if (allWeight <= 0)
/*     */     {
/* 221 */       GameServer.logger().error(String.format("[singleTask]SingleTaskManager.getNewGraphId@ illegal allWeight!|oldGraphId=%d|cfgGraphIds=%s|ranType=%d|allWeight=%d", new Object[] { Integer.valueOf(oldGraphId), cfgGraphIds.toString(), Integer.valueOf(ranType), Integer.valueOf(allWeight) }));
/*     */       
/*     */ 
/*     */ 
/* 225 */       return -1;
/*     */     }
/* 227 */     return ranOneGraphId(allWeight, cfgGraphIdsCopy);
/*     */   }
/*     */   
/*     */   private static int ranOneGraphId(int allWeight, Map<Integer, Integer> cfgGraphs)
/*     */   {
/* 232 */     int newGraphId = -1;
/* 233 */     int ran = Xdb.random().nextInt(allWeight);
/* 234 */     int weightSum = 0;
/* 235 */     Iterator<Map.Entry<Integer, Integer>> it = cfgGraphs.entrySet().iterator();
/* 236 */     while (it.hasNext())
/*     */     {
/* 238 */       Map.Entry<Integer, Integer> entry = (Map.Entry)it.next();
/* 239 */       weightSum += ((Integer)entry.getValue()).intValue();
/* 240 */       if (weightSum > ran)
/*     */       {
/* 242 */         newGraphId = ((Integer)entry.getKey()).intValue();
/* 243 */         break;
/*     */       }
/*     */     }
/* 246 */     if (newGraphId <= 0)
/*     */     {
/* 248 */       GameServer.logger().error(String.format("[singleTask]SingleTaskManager.ranOneGraphId@ not get graphId!|allWeight=%d|cfgGraphs=%s", new Object[] { Integer.valueOf(allWeight), cfgGraphs.toString() }));
/*     */     }
/*     */     
/*     */ 
/* 252 */     return newGraphId;
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
/*     */   static int getNewGraphId(int oldGraphId, List<Integer> cfgGraphIds, int ranType)
/*     */   {
/* 265 */     int newGraphId = -1;
/* 266 */     if ((cfgGraphIds == null) || (cfgGraphIds.size() <= 1))
/*     */     {
/* 268 */       return -1;
/*     */     }
/* 270 */     List<Integer> ranGraphIds = randomGraphIds(getLastRanGraphIds(oldGraphId, cfgGraphIds, ranType), 1);
/* 271 */     if ((ranGraphIds != null) && (ranGraphIds.size() == 1))
/*     */     {
/* 273 */       newGraphId = ((Integer)ranGraphIds.get(0)).intValue();
/*     */     }
/* 275 */     if (newGraphId <= 0)
/*     */     {
/* 277 */       GameServer.logger().error(String.format("[singleTask]SingleTaskManager.getNewGraphId@ ran graphId err!|oldGraphId=%d|cfgGraphIds=%s|ranType=%d", new Object[] { Integer.valueOf(oldGraphId), cfgGraphIds.toString(), Integer.valueOf(ranType) }));
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 282 */     return newGraphId;
/*     */   }
/*     */   
/*     */   private static List<Integer> getLastRanGraphIds(int oldGraphId, List<Integer> cfgGraphIds, int ranType)
/*     */   {
/* 287 */     List<Integer> cfgGraphIdsCopy = new ArrayList();
/* 288 */     switch (ranType)
/*     */     {
/*     */     case 1: 
/* 291 */       cfgGraphIdsCopy.addAll(cfgGraphIds);
/* 292 */       break;
/*     */     case 2: 
/* 294 */       cfgGraphIds.remove(new Integer(oldGraphId));
/* 295 */       break;
/*     */     }
/*     */     
/*     */     
/*     */ 
/*     */ 
/* 301 */     return cfgGraphIdsCopy;
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
/*     */   private static List<Integer> randomGraphIds(List<Integer> graphIds, int count)
/*     */   {
/* 315 */     int size = graphIds.size();
/* 316 */     if ((count > size) || (size == 0) || (count == 0))
/*     */     {
/* 318 */       return Collections.emptyList();
/*     */     }
/*     */     
/* 321 */     if (size == count)
/*     */     {
/* 323 */       return new ArrayList(graphIds);
/*     */     }
/*     */     
/* 326 */     Random random = Xdb.random();
/* 327 */     int i = size; for (int j = 0; j < count; j++)
/*     */     {
/* 329 */       Collections.swap(graphIds, i - 1, random.nextInt(i));i--;
/*     */     }
/*     */     
/* 332 */     return new ArrayList(graphIds.subList(size - count, size));
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
/*     */   static int selectLastGraphId(long roleId, int activityId)
/*     */   {
/* 346 */     AllActivityInfo xActivityInfo = Role2singleinfo.select(Long.valueOf(roleId));
/* 347 */     if (xActivityInfo == null)
/*     */     {
/* 349 */       GameServer.logger().warn(String.format("[singleTask]SingleTaskManager.selectLastGraphId@ xActivityInfo is null!|roleId=%d|activityId=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(activityId) }));
/*     */       
/*     */ 
/*     */ 
/* 353 */       return -1;
/*     */     }
/* 355 */     SingleActivityInfo xSingleInfo = (SingleActivityInfo)xActivityInfo.getActivitydata().get(Integer.valueOf(activityId));
/* 356 */     if (xSingleInfo == null)
/*     */     {
/* 358 */       GameServer.logger().warn(String.format("[singleTask]SingleTaskManager.selectLastGraphId@ xSingleInfo is null!|roleId=%d|activityId=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(activityId) }));
/*     */       
/*     */ 
/*     */ 
/* 362 */       return -1;
/*     */     }
/* 364 */     return xSingleInfo.getLastgraphid();
/*     */   }
/*     */   
/*     */   static boolean containsGraphId(int graphLibId, long roleId)
/*     */   {
/* 369 */     List<Integer> ownGraphIds = TaskInterface.getRoleAllGraphIds(roleId, false);
/* 370 */     Set<Integer> libGraphIds = getGraphIds(graphLibId);
/* 371 */     for (Iterator i$ = libGraphIds.iterator(); i$.hasNext();) { int libGraphId = ((Integer)i$.next()).intValue();
/*     */       
/* 373 */       if (ownGraphIds.contains(Integer.valueOf(libGraphId)))
/*     */       {
/* 375 */         return true;
/*     */       }
/*     */     }
/* 378 */     return false;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\singletask\main\SingleTaskManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */