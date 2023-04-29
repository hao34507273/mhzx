/*     */ package mzm.gsp.flowerparade.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Random;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity4.confbean.FlowerParadeMapCfg;
/*     */ import mzm.gsp.activity4.confbean.FlowerParadePos;
/*     */ import mzm.gsp.activity4.confbean.FlowerParadeRestPos;
/*     */ import mzm.gsp.activity4.confbean.SFlowerParadeCfg;
/*     */ import mzm.gsp.activity4.confbean.SFlowerParadeMapGroupCfg;
/*     */ import mzm.gsp.activity4.confbean.SFlowerParadeRoadPathCfg;
/*     */ import mzm.gsp.map.main.ControllerInterface;
/*     */ import mzm.gsp.map.main.MapInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import xbean.FlowerParade;
/*     */ import xdb.Procedure;
/*     */ import xdb.Xdb;
/*     */ import xtable.Flowerparade;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class FlowerParadeManager
/*     */ {
/*     */   public static final int PARADE_MAP_NOT_SET = -1;
/*     */   public static final int PARADE_OCP_NOT_SET = -1;
/*     */   public static final int PARADE_GM_INDEX = -1;
/*     */   protected static final int PARADE_ROLE_RANDOM_SIZE = 20;
/*  40 */   private static List<FlowerParadeActivityStartDateObserver> paradeStartObservers = null;
/*     */   
/*     */ 
/*  43 */   private static FlowerParadeObserverUpdateFollower updateFollowerObserver = null;
/*     */   
/*     */   public static SFlowerParadeCfg getCfg(int activityId)
/*     */   {
/*  47 */     return SFlowerParadeCfg.get(activityId);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean isOpen(long roleId)
/*     */   {
/*  58 */     int switchId = 518;
/*  59 */     if (!OpenInterface.getOpenStatus(518))
/*     */     {
/*  61 */       return false;
/*     */     }
/*  63 */     if ((roleId > 0L) && (OpenInterface.isBanPlay(roleId, 518)))
/*     */     {
/*  65 */       OpenInterface.sendBanPlayMsg(roleId, 518);
/*  66 */       return false;
/*     */     }
/*  68 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected static int randomParadeOcp(List<Integer> excludeOcps, Collection<Integer> allOcpList)
/*     */   {
/*  80 */     List<Integer> canRandomOcpList = new ArrayList();
/*  81 */     for (Integer tmpOcp : allOcpList)
/*     */     {
/*  83 */       if ((excludeOcps == null) || (!excludeOcps.contains(tmpOcp)))
/*     */       {
/*  85 */         canRandomOcpList.add(tmpOcp);
/*     */       }
/*     */     }
/*  88 */     if (canRandomOcpList.size() == 0)
/*     */     {
/*  90 */       return 0;
/*     */     }
/*  92 */     int index = Xdb.random().nextInt(canRandomOcpList.size());
/*     */     
/*  94 */     return ((Integer)canRandomOcpList.get(index)).intValue();
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
/*     */   protected static Long randomParadeRole(int ocp, List<Long> excludeRoleIdList, int gender)
/*     */   {
/* 108 */     List<Long> roleList = RoleInterface.getTopNRoleIds(ocp, 20, gender);
/* 109 */     List<Long> randomList = new ArrayList();
/* 110 */     List<Long> onlineRandomList = new ArrayList();
/* 111 */     for (Long roleId : roleList)
/*     */     {
/* 113 */       if ((excludeRoleIdList == null) || (!excludeRoleIdList.contains(roleId)))
/*     */       {
/* 115 */         randomList.add(roleId);
/* 116 */         if (OnlineManager.getInstance().isOnline(roleId.longValue()))
/*     */         {
/* 118 */           onlineRandomList.add(roleId);
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 123 */     List<Long> list = onlineRandomList.size() > 0 ? onlineRandomList : randomList;
/* 124 */     int size = list.size();
/* 125 */     if (size > 0)
/*     */     {
/* 127 */       return (Long)list.get(Xdb.random().nextInt(size));
/*     */     }
/*     */     
/*     */ 
/* 131 */     int newSize = roleList.size();
/* 132 */     if (newSize > 0)
/*     */     {
/* 134 */       return (Long)roleList.get(Xdb.random().nextInt(newSize));
/*     */     }
/*     */     
/*     */ 
/* 138 */     return Long.valueOf(0L);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   protected static int randomParadeMap(List<Integer> excludeList, Collection<Integer> allList)
/*     */   {
/* 145 */     List<Integer> list = new ArrayList();
/* 146 */     for (Integer id : allList)
/*     */     {
/* 148 */       if (!excludeList.contains(id))
/*     */       {
/* 150 */         list.add(id);
/*     */       }
/*     */     }
/*     */     
/* 154 */     return ((Integer)list.get(Xdb.random().nextInt(list.size()))).intValue();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void init()
/*     */   {
/* 162 */     ActivityInterface.registerActivityByLogicType(130, new FlowerParadeActivityHandler(), false);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void initMapItem()
/*     */   {
/* 170 */     Set<Integer> handleTypes = new HashSet();
/*     */     
/* 172 */     Collection<SFlowerParadeCfg> values = SFlowerParadeCfg.getAll().values();
/* 173 */     for (SFlowerParadeCfg cfg : values)
/*     */     {
/* 175 */       handleTypes.add(Integer.valueOf(cfg.redbagHandleType));
/*     */     }
/* 177 */     for (Iterator i$ = handleTypes.iterator(); i$.hasNext();) { int handleType = ((Integer)i$.next()).intValue();
/*     */       
/* 179 */       if (!MapInterface.regisMapItemGatherHandler(handleType, FlowerParadeMapItemHandler.getInstance()))
/*     */       {
/* 181 */         throw new RuntimeException(String.format("[flowerparade]FlowerParadeManager.initMapItem@regisMapItemGatherHandler err!|checkType=%d", new Object[] { Integer.valueOf(handleType) }));
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
/*     */   protected static void onActivityStart(int activityId)
/*     */   {
/* 197 */     if (paradeStartObservers == null)
/*     */     {
/* 199 */       paradeStartObservers = new ArrayList();
/*     */ 
/*     */     }
/*     */     else
/*     */     {
/*     */ 
/* 205 */       for (int i = 0; i < paradeStartObservers.size(); i++)
/*     */       {
/* 207 */         ((FlowerParadeActivityStartDateObserver)paradeStartObservers.get(i)).stopTimer();
/*     */       }
/* 209 */       paradeStartObservers.clear();
/*     */     }
/*     */     
/*     */ 
/* 213 */     List<Integer> timeIds = SFlowerParadeCfg.get(activityId).startCommonTimeIds;
/* 214 */     for (int i = 0; i < timeIds.size(); i++)
/*     */     {
/* 216 */       int paradeIndex = i + 1;
/* 217 */       FlowerParadeActivityStartDateObserver observer = new FlowerParadeActivityStartDateObserver(((Integer)timeIds.get(i)).intValue(), activityId, paradeIndex);
/*     */       
/*     */ 
/* 220 */       paradeStartObservers.add(observer);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected static void onActivityEnd(int activityId)
/*     */   {
/* 231 */     if (paradeStartObservers == null)
/*     */     {
/* 233 */       return;
/*     */     }
/*     */     
/* 236 */     for (int i = 0; i < paradeStartObservers.size(); i++)
/*     */     {
/* 238 */       ((FlowerParadeActivityStartDateObserver)paradeStartObservers.get(i)).stopTimer();
/*     */     }
/* 240 */     paradeStartObservers.clear();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void startFlowerParade(int activityId, int paradeIndex)
/*     */   {
/* 251 */     startFlowerParade(activityId, paradeIndex, -1, -1);
/*     */   }
/*     */   
/*     */ 
/*     */   public static void startFlowerParade(int activityId, int paradeIndex, int mapId, int ocp)
/*     */   {
/* 257 */     Procedure.execute(new PFlowerParadeStart(activityId, paradeIndex, mapId, ocp));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void stopFlowerParade(int activityId)
/*     */   {
/* 267 */     Procedure.execute(new PFlowerParadeStop(activityId));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void stopFlowerParadeCall(int activityId)
/*     */   {
/* 277 */     new PFlowerParadeStop(activityId).call();
/*     */   }
/*     */   
/*     */   public static void tLogFollowAward(long roleId, long instanceId, int awardId)
/*     */   {
/* 282 */     String userid = RoleInterface.getUserId(roleId);
/* 283 */     Object[] columnns = { userid, Long.valueOf(roleId), Long.valueOf(instanceId), Integer.valueOf(awardId) };
/* 284 */     TLogManager.getInstance().addLog(roleId, "FlowerParadeFollowAward", columnns);
/*     */   }
/*     */   
/*     */   protected static void startUpdateFollowerObserver(long intervalSeconds, int activityId)
/*     */   {
/* 289 */     if (updateFollowerObserver != null)
/*     */     {
/* 291 */       stopUpdateFollowerObserver();
/*     */     }
/* 293 */     updateFollowerObserver = new FlowerParadeObserverUpdateFollower(intervalSeconds, activityId);
/*     */   }
/*     */   
/*     */   protected static void stopUpdateFollowerObserver()
/*     */   {
/* 298 */     if (updateFollowerObserver == null)
/*     */     {
/* 300 */       return;
/*     */     }
/* 302 */     updateFollowerObserver.stopTimer();
/* 303 */     updateFollowerObserver = null;
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
/*     */   protected static FlowerParadeRestPos getFlowerParadeRestPos(int mapGroupId, int mapId, int index)
/*     */   {
/* 316 */     SFlowerParadeMapGroupCfg grpCfg = SFlowerParadeMapGroupCfg.get(mapGroupId);
/* 317 */     if (grpCfg == null)
/*     */     {
/* 319 */       return null;
/*     */     }
/* 321 */     FlowerParadeMapCfg mapCfg = (FlowerParadeMapCfg)grpCfg.map2Pos.get(Integer.valueOf(mapId));
/* 322 */     if (mapCfg == null)
/*     */     {
/* 324 */       return null;
/*     */     }
/*     */     
/* 327 */     for (FlowerParadeRestPos pos : mapCfg.restPosList)
/*     */     {
/* 329 */       if (pos.restPosIndex == index)
/*     */       {
/* 331 */         return pos;
/*     */       }
/*     */     }
/* 334 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected static FlowerParadePos getFlowerParadePos(int pathId, int index)
/*     */   {
/* 346 */     SFlowerParadeRoadPathCfg cfg = SFlowerParadeRoadPathCfg.get(pathId);
/* 347 */     if (cfg == null)
/*     */     {
/* 349 */       return null;
/*     */     }
/* 351 */     for (FlowerParadePos pos : cfg.allPos)
/*     */     {
/* 353 */       if (pos.index == index)
/*     */       {
/* 355 */         return pos;
/*     */       }
/*     */     }
/* 358 */     return null;
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
/*     */   protected static boolean isRestPos(int mapGroupId, int mapId, int index)
/*     */   {
/* 371 */     SFlowerParadeMapGroupCfg grpCfg = SFlowerParadeMapGroupCfg.get(mapGroupId);
/* 372 */     if (grpCfg == null)
/*     */     {
/* 374 */       return false;
/*     */     }
/* 376 */     FlowerParadeMapCfg mapCfg = (FlowerParadeMapCfg)grpCfg.map2Pos.get(Integer.valueOf(mapId));
/* 377 */     if (mapCfg == null)
/*     */     {
/* 379 */       return false;
/*     */     }
/*     */     
/* 382 */     for (FlowerParadeRestPos pos : mapCfg.restPosList)
/*     */     {
/* 384 */       if (pos.restPosIndex == index)
/*     */       {
/* 386 */         return true;
/*     */       }
/*     */     }
/*     */     
/* 390 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected static List<FlowerParadePos> getAllPos(int pathId)
/*     */   {
/* 401 */     SFlowerParadeRoadPathCfg cfg = SFlowerParadeRoadPathCfg.get(pathId);
/* 402 */     if (cfg == null)
/*     */     {
/* 404 */       return null;
/*     */     }
/* 406 */     List<FlowerParadePos> list = new ArrayList();
/* 407 */     for (FlowerParadePos pos : cfg.allPos)
/*     */     {
/* 409 */       if ((pos.x != 0) && (pos.y != 0))
/*     */       {
/* 411 */         list.add(pos);
/*     */       }
/*     */     }
/* 414 */     return list;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static long getNextParadeStartTime()
/*     */   {
/* 423 */     if (paradeStartObservers.size() == 0)
/*     */     {
/* 425 */       return 0L;
/*     */     }
/* 427 */     long minTimeOut = ((FlowerParadeActivityStartDateObserver)paradeStartObservers.get(0)).getTimeoutTimestamp();
/* 428 */     for (int i = 0; i < paradeStartObservers.size(); i++)
/*     */     {
/* 430 */       FlowerParadeActivityStartDateObserver observer = (FlowerParadeActivityStartDateObserver)paradeStartObservers.get(i);
/* 431 */       if (observer.getTimeoutTimestamp() < minTimeOut)
/*     */       {
/* 433 */         minTimeOut = observer.getTimeoutTimestamp();
/*     */       }
/*     */     }
/*     */     
/* 437 */     return minTimeOut / 1000L;
/*     */   }
/*     */   
/*     */ 
/*     */   public static void recycleRedbag(int activityId)
/*     */   {
/* 443 */     long localid = GameServerInfoManager.getLocalId();
/* 444 */     FlowerParade xFlowerParade = Flowerparade.get(Long.valueOf(localid));
/* 445 */     if (xFlowerParade == null)
/*     */     {
/* 447 */       return;
/*     */     }
/*     */     
/* 450 */     SFlowerParadeCfg cfg = SFlowerParadeCfg.get(activityId);
/* 451 */     SFlowerParadeMapGroupCfg mapGroupCfg = SFlowerParadeMapGroupCfg.get(cfg.mapGroupId);
/* 452 */     ArrayList<FlowerParadeRestPos> posList = ((FlowerParadeMapCfg)mapGroupCfg.map2Pos.get(Integer.valueOf(xFlowerParade.getMapid()))).restPosList;
/* 453 */     for (FlowerParadeRestPos pos : posList)
/*     */     {
/* 455 */       int regbagControllerId = pos.redbagId;
/* 456 */       if (regbagControllerId > 0)
/*     */       {
/* 458 */         ControllerInterface.collectWorldController(MapInterface.getBigWorldid(), regbagControllerId);
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\flowerparade\main\FlowerParadeManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */