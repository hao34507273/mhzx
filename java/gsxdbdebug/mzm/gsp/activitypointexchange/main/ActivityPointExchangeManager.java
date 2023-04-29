/*     */ package mzm.gsp.activitypointexchange.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import java.util.concurrent.locks.Lock;
/*     */ import java.util.concurrent.locks.ReadWriteLock;
/*     */ import mzm.gsp.activitypointexchange.confbean.SActivityPointExchangeMallCfg;
/*     */ import mzm.gsp.activitypointexchange.confbean.SPointExchangeGoodsInfo;
/*     */ import mzm.gsp.activitypointexchange.confbean.STActivityPointExchangeGoodsCfg;
/*     */ import mzm.gsp.activitypointexchange.confbean.TActivityPointExchangeActivityCfg;
/*     */ import mzm.gsp.activitypointexchange.main.handler.ActivityPointExchangeHandler;
/*     */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*     */ import xbean.ActivityPointExchangeGoodsInfo;
/*     */ import xbean.ActivityPointExchangeInfo;
/*     */ import xbean.ActivityPointExchangeMallInfo;
/*     */ import xbean.Pod;
/*     */ import xtable.Activity2activitypointexchangeglobalinfo;
/*     */ import xtable.Role2activitypointexchangeinfo;
/*     */ 
/*     */ public class ActivityPointExchangeManager
/*     */ {
/*  26 */   public static final mzm.gsp.activitypointexchange.main.handler.DefaultActivityPointExchangeHandler DEFAULT_ACTIVITY_POINT_EXCHANGE_HANDLER = new mzm.gsp.activitypointexchange.main.handler.DefaultActivityPointExchangeHandler();
/*  27 */   public static final Map<Integer, ActivityPointExchangeHandler> ACTIVITY_POINT_EXCHANGE_HANDLER_MAP = new HashMap();
/*     */   
/*  29 */   private static final Map<Integer, BeanMapper.ActivityPointExchangeGlobalInfo> ACTIVITY_POINT_EXCHANGE_GLOBAL_INFO_HASH_MAP = new HashMap();
/*  30 */   private static final ReadWriteLock GLOBAL_INFO_LOCK = new java.util.concurrent.locks.ReentrantReadWriteLock();
/*     */   
/*     */   static void loadGlobalInfoMapFromDB()
/*     */   {
/*  34 */     NoneRealTimeTaskManager.getInstance().addTask(new mzm.gsp.util.LogicProcedure()
/*     */     {
/*     */       protected boolean processImp()
/*     */         throws Exception
/*     */       {
/*  39 */         Map<Long, Integer> globalKeyId2activityIdMap = new HashMap();
/*     */         
/*  41 */         for (Map.Entry<Integer, TActivityPointExchangeActivityCfg> entry : TActivityPointExchangeActivityCfg.getAll().entrySet())
/*     */         {
/*  43 */           int activityId = ((Integer)entry.getKey()).intValue();
/*  44 */           globalKeyId2activityIdMap.put(Long.valueOf(mzm.gsp.GameServerInfoManager.toGlobalId(activityId)), Integer.valueOf(activityId));
/*     */         }
/*  46 */         if (globalKeyId2activityIdMap.isEmpty())
/*     */         {
/*  48 */           return false;
/*     */         }
/*     */         
/*     */ 
/*  52 */         lock(Activity2activitypointexchangeglobalinfo.getTable(), globalKeyId2activityIdMap.keySet());
/*     */         
/*  54 */         ActivityPointExchangeManager.GLOBAL_INFO_LOCK.writeLock().lock();
/*     */         
/*     */ 
/*     */         try
/*     */         {
/*  59 */           for (Map.Entry<Long, Integer> entry : globalKeyId2activityIdMap.entrySet())
/*     */           {
/*  61 */             long globalTableKeyId = ((Long)entry.getKey()).longValue();
/*  62 */             int activityId = ((Integer)entry.getValue()).intValue();
/*  63 */             xbean.ActivityPointExchangeGlobalInfo xActivityPointExchangeGlobalInfo = Activity2activitypointexchangeglobalinfo.get(Long.valueOf(globalTableKeyId));
/*     */             
/*  65 */             if (xActivityPointExchangeGlobalInfo != null)
/*     */             {
/*     */ 
/*     */ 
/*  69 */               ActivityPointExchangeManager.ACTIVITY_POINT_EXCHANGE_GLOBAL_INFO_HASH_MAP.put(Integer.valueOf(activityId), BeanMapper.getActivityPointExchangeGlobalInfoFromXdb(xActivityPointExchangeGlobalInfo));
/*     */             }
/*     */           }
/*     */         }
/*     */         finally
/*     */         {
/*  75 */           ActivityPointExchangeManager.GLOBAL_INFO_LOCK.writeLock().unlock();
/*     */         }
/*  77 */         return true;
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   static void registerActivityPointExchangeHandler()
/*     */   {
/*  84 */     new mzm.gsp.activitypointexchange.main.handler.BackGameActivityPointExchangeHandler().registerActivityPointExchangeHandler();
/*     */   }
/*     */   
/*     */   static ActivityPointExchangeHandler getActivityPointExchangeHandler(int activityId)
/*     */   {
/*  89 */     ActivityPointExchangeHandler activityPointExchangeHandler = (ActivityPointExchangeHandler)ACTIVITY_POINT_EXCHANGE_HANDLER_MAP.get(Integer.valueOf(activityId));
/*  90 */     if (activityPointExchangeHandler == null)
/*     */     {
/*  92 */       return DEFAULT_ACTIVITY_POINT_EXCHANGE_HANDLER;
/*     */     }
/*  94 */     return activityPointExchangeHandler;
/*     */   }
/*     */   
/*     */   static int getOpenMallCfgId(long roleId, TActivityPointExchangeActivityCfg activityCfg)
/*     */   {
/*  99 */     if (activityCfg == null)
/*     */     {
/* 101 */       return -1;
/*     */     }
/* 103 */     for (Iterator i$ = activityCfg.mallCfgIds.iterator(); i$.hasNext();) { int mallCfgId = ((Integer)i$.next()).intValue();
/*     */       
/* 105 */       if (isMallOpen(roleId, activityCfg.activityId, mallCfgId))
/*     */       {
/* 107 */         return mallCfgId;
/*     */       }
/*     */     }
/* 110 */     return -1;
/*     */   }
/*     */   
/*     */   static boolean isMallOpen(long roleId, int activityId, int mallCfgId)
/*     */   {
/* 115 */     ActivityPointExchangeHandler activityPointExchangeHandler = getActivityPointExchangeHandler(activityId);
/* 116 */     return activityPointExchangeHandler.isMallOpenForRole(roleId, activityId, mallCfgId);
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
/*     */   static java.util.Collection<Integer> getSoldOutGoodsCfgIds(int activityId, int mallCfgId)
/*     */   {
/* 129 */     GLOBAL_INFO_LOCK.readLock().lock();
/*     */     try
/*     */     {
/* 132 */       BeanMapper.ActivityPointExchangeGlobalInfo activityPointExchangeGlobalInfo = (BeanMapper.ActivityPointExchangeGlobalInfo)ACTIVITY_POINT_EXCHANGE_GLOBAL_INFO_HASH_MAP.get(Integer.valueOf(activityId));
/* 133 */       if (activityPointExchangeGlobalInfo == null)
/*     */       {
/* 135 */         return null;
/*     */       }
/* 137 */       BeanMapper.ActivityPointExchangeMallGlobalInfo activityPointExchangeMallGlobalInfo = (BeanMapper.ActivityPointExchangeMallGlobalInfo)activityPointExchangeGlobalInfo.mallCfgId2mallInfo.get(Integer.valueOf(mallCfgId));
/*     */       Object localObject1;
/* 139 */       if (activityPointExchangeMallGlobalInfo == null)
/*     */       {
/* 141 */         return null;
/*     */       }
/* 143 */       return activityPointExchangeMallGlobalInfo.soldOutGoodsCfgIdSet;
/*     */     }
/*     */     finally
/*     */     {
/* 147 */       GLOBAL_INFO_LOCK.readLock().unlock();
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
/*     */   static boolean removeSoldOutGoodsCfgId(int activityId, int mallCfgId, int goodsCfgId)
/*     */   {
/* 161 */     if (!checkGoodsParams(activityId, mallCfgId, goodsCfgId))
/*     */     {
/* 163 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 167 */     GLOBAL_INFO_LOCK.writeLock().lock();
/*     */     boolean ret;
/*     */     try {
/* 170 */       BeanMapper.ActivityPointExchangeGlobalInfo activityPointExchangeGlobalInfo = (BeanMapper.ActivityPointExchangeGlobalInfo)ACTIVITY_POINT_EXCHANGE_GLOBAL_INFO_HASH_MAP.get(Integer.valueOf(activityId));
/*     */       
/* 172 */       if (activityPointExchangeGlobalInfo == null)
/*     */       {
/* 174 */         return true;
/*     */       }
/* 176 */       BeanMapper.ActivityPointExchangeMallGlobalInfo activityPointExchangeMallGlobalInfo = (BeanMapper.ActivityPointExchangeMallGlobalInfo)activityPointExchangeGlobalInfo.mallCfgId2mallInfo.get(Integer.valueOf(mallCfgId));
/*     */       
/* 178 */       if (activityPointExchangeMallGlobalInfo == null)
/*     */       {
/* 180 */         return true;
/*     */       }
/* 182 */       ret = activityPointExchangeMallGlobalInfo.soldOutGoodsCfgIdSet.remove(Integer.valueOf(goodsCfgId));
/*     */     }
/*     */     finally
/*     */     {
/* 186 */       GLOBAL_INFO_LOCK.writeLock().unlock();
/*     */     }
/* 188 */     if (ret)
/*     */     {
/* 190 */       NoneRealTimeTaskManager.getInstance().addTask(new PRemoveSoldOutGoodsCfgId(activityId, mallCfgId, goodsCfgId));
/*     */     }
/*     */     
/* 193 */     return true;
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
/*     */   static boolean addSoldOutGoodsCfgId(int activityId, int mallCfgId, int goodsCfgId)
/*     */   {
/* 206 */     if (!checkGoodsParams(activityId, mallCfgId, goodsCfgId))
/*     */     {
/* 208 */       return false;
/*     */     }
/*     */     
/* 211 */     GLOBAL_INFO_LOCK.writeLock().lock();
/*     */     boolean ret;
/*     */     try {
/* 214 */       BeanMapper.ActivityPointExchangeGlobalInfo activityPointExchangeGlobalInfo = (BeanMapper.ActivityPointExchangeGlobalInfo)ACTIVITY_POINT_EXCHANGE_GLOBAL_INFO_HASH_MAP.get(Integer.valueOf(activityId));
/*     */       
/* 216 */       if (activityPointExchangeGlobalInfo == null)
/*     */       {
/* 218 */         activityPointExchangeGlobalInfo = new BeanMapper.ActivityPointExchangeGlobalInfo();
/* 219 */         ACTIVITY_POINT_EXCHANGE_GLOBAL_INFO_HASH_MAP.put(Integer.valueOf(activityId), activityPointExchangeGlobalInfo);
/*     */       }
/* 221 */       BeanMapper.ActivityPointExchangeMallGlobalInfo activityPointExchangeMallGlobalInfo = (BeanMapper.ActivityPointExchangeMallGlobalInfo)activityPointExchangeGlobalInfo.mallCfgId2mallInfo.get(Integer.valueOf(mallCfgId));
/*     */       
/* 223 */       if (activityPointExchangeMallGlobalInfo == null)
/*     */       {
/* 225 */         activityPointExchangeMallGlobalInfo = new BeanMapper.ActivityPointExchangeMallGlobalInfo();
/* 226 */         activityPointExchangeGlobalInfo.mallCfgId2mallInfo.put(Integer.valueOf(mallCfgId), activityPointExchangeMallGlobalInfo);
/*     */       }
/* 228 */       ret = activityPointExchangeMallGlobalInfo.soldOutGoodsCfgIdSet.add(Integer.valueOf(goodsCfgId));
/*     */     }
/*     */     finally
/*     */     {
/* 232 */       GLOBAL_INFO_LOCK.writeLock().unlock();
/*     */     }
/* 234 */     if (ret)
/*     */     {
/* 236 */       NoneRealTimeTaskManager.getInstance().addTask(new PAddSoldOutGoodsCfgId(activityId, mallCfgId, goodsCfgId));
/*     */     }
/* 238 */     return true;
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
/*     */   static ActivityPointExchangeGoodsInfo getActivityPointExchangeGoodsInfo(long roleId, int activityId, int mallCfgId)
/*     */   {
/* 252 */     ActivityPointExchangeInfo xActivityPointExchangeInfo = Role2activitypointexchangeinfo.get(Long.valueOf(roleId));
/* 253 */     if (xActivityPointExchangeInfo == null)
/*     */     {
/* 255 */       return null;
/*     */     }
/* 257 */     ActivityPointExchangeMallInfo xActivityPointExchangeMallInfo = (ActivityPointExchangeMallInfo)xActivityPointExchangeInfo.getActivityid2mallinfo().get(Integer.valueOf(activityId));
/*     */     
/* 259 */     if (xActivityPointExchangeMallInfo == null)
/*     */     {
/* 261 */       return null;
/*     */     }
/* 263 */     return (ActivityPointExchangeGoodsInfo)xActivityPointExchangeMallInfo.getMallcfgid2goodsinfo().get(Integer.valueOf(mallCfgId));
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
/*     */   static ActivityPointExchangeGoodsInfo getActivityPointExchangeGoodsInfoCreateIfNotExist(long roleId, int activityId, int mallCfgId, ActivityPointExchangeHandler activityPointExchangeHandler)
/*     */   {
/* 277 */     ActivityPointExchangeInfo xActivityPointExchangeInfo = Role2activitypointexchangeinfo.get(Long.valueOf(roleId));
/* 278 */     if (xActivityPointExchangeInfo == null)
/*     */     {
/* 280 */       xActivityPointExchangeInfo = Pod.newActivityPointExchangeInfo();
/* 281 */       Role2activitypointexchangeinfo.insert(Long.valueOf(roleId), xActivityPointExchangeInfo);
/*     */     }
/* 283 */     ActivityPointExchangeMallInfo xActivityPointExchangeMallInfo = (ActivityPointExchangeMallInfo)xActivityPointExchangeInfo.getActivityid2mallinfo().get(Integer.valueOf(activityId));
/*     */     
/* 285 */     if (xActivityPointExchangeMallInfo == null)
/*     */     {
/* 287 */       xActivityPointExchangeMallInfo = Pod.newActivityPointExchangeMallInfo();
/* 288 */       xActivityPointExchangeInfo.getActivityid2mallinfo().put(Integer.valueOf(activityId), xActivityPointExchangeMallInfo);
/*     */     }
/* 290 */     ActivityPointExchangeGoodsInfo xActivityPointExchangeGoodsInfo = (ActivityPointExchangeGoodsInfo)xActivityPointExchangeMallInfo.getMallcfgid2goodsinfo().get(Integer.valueOf(mallCfgId));
/*     */     
/*     */ 
/* 293 */     if (xActivityPointExchangeGoodsInfo == null)
/*     */     {
/* 295 */       xActivityPointExchangeGoodsInfo = Pod.newActivityPointExchangeGoodsInfo();
/* 296 */       xActivityPointExchangeGoodsInfo.setExchangecountresettimestamp(activityPointExchangeHandler.getPointExchangeCountResetTime(activityId, mallCfgId, xActivityPointExchangeGoodsInfo));
/*     */       
/*     */ 
/* 299 */       xActivityPointExchangeGoodsInfo.setManualrefreshcountresettimestamp(activityPointExchangeHandler.getManualRefreshCountResetTime(activityId, mallCfgId, xActivityPointExchangeGoodsInfo));
/*     */       
/*     */ 
/* 302 */       xActivityPointExchangeMallInfo.getMallcfgid2goodsinfo().put(Integer.valueOf(mallCfgId), xActivityPointExchangeGoodsInfo);
/*     */     }
/* 304 */     return xActivityPointExchangeGoodsInfo;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static void checkResetManualRefreshCount(long roleId, int activityId, int mallCfgId, ActivityPointExchangeGoodsInfo xActivityPointExchangeGoodsInfo, long currentTimeStamp, ActivityPointExchangeHandler activityPointExchangeHandler)
/*     */   {
/* 312 */     long xManualRefreshCountResetTimeStamp = xActivityPointExchangeGoodsInfo.getManualrefreshcountresettimestamp();
/* 313 */     if ((xManualRefreshCountResetTimeStamp != 0L) && (xManualRefreshCountResetTimeStamp <= currentTimeStamp))
/*     */     {
/* 315 */       int beforeRefreshCount = xActivityPointExchangeGoodsInfo.getManualrefreshcount();
/* 316 */       xActivityPointExchangeGoodsInfo.setManualrefreshcount(0);
/*     */       
/* 318 */       long nextResetTimeStamp = activityPointExchangeHandler.getManualRefreshCountResetTime(activityId, mallCfgId, xActivityPointExchangeGoodsInfo);
/*     */       
/* 320 */       xActivityPointExchangeGoodsInfo.setManualrefreshcountresettimestamp(nextResetTimeStamp);
/*     */       
/*     */ 
/* 323 */       ActivityPointExchangeTLogManager.tLogActivityPointExchangeManualRefreshCountResetLog(roleId, activityId, mallCfgId, beforeRefreshCount, xManualRefreshCountResetTimeStamp, currentTimeStamp, nextResetTimeStamp);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void checkResetExchangeCount(long roleId, int activityId, int mallCfgId, ActivityPointExchangeGoodsInfo xActivityPointExchangeGoodsInfo, long currentTimeStamp, ActivityPointExchangeHandler activityPointExchangeHandler)
/*     */   {
/* 333 */     long xExchangeCountResetTimeStamp = xActivityPointExchangeGoodsInfo.getExchangecountresettimestamp();
/* 334 */     if ((xExchangeCountResetTimeStamp != 0L) && (xExchangeCountResetTimeStamp <= currentTimeStamp))
/*     */     {
/* 336 */       Map<Integer, Integer> beforeCfgId2count = new HashMap();
/* 337 */       beforeCfgId2count.putAll(xActivityPointExchangeGoodsInfo.getGoodscfgid2count());
/*     */       
/* 339 */       xActivityPointExchangeGoodsInfo.getGoodscfgid2count().clear();
/* 340 */       xActivityPointExchangeGoodsInfo.setIsneedrefresh(false);
/*     */       
/* 342 */       long nextResetTimeStamp = activityPointExchangeHandler.getPointExchangeCountResetTime(activityId, mallCfgId, xActivityPointExchangeGoodsInfo);
/*     */       
/* 344 */       xActivityPointExchangeGoodsInfo.setExchangecountresettimestamp(nextResetTimeStamp);
/*     */       
/*     */ 
/* 347 */       ActivityPointExchangeTLogManager.tLgoActivityPointExchangeCountResetLog(roleId, activityId, mallCfgId, beforeCfgId2count, xExchangeCountResetTimeStamp, currentTimeStamp, nextResetTimeStamp);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   static boolean checkGoodsParams(int activityId, int mallCfgId, int goodsCfgId)
/*     */   {
/* 354 */     TActivityPointExchangeActivityCfg activityCfg = TActivityPointExchangeActivityCfg.get(activityId);
/* 355 */     if (activityCfg == null)
/*     */     {
/* 357 */       return false;
/*     */     }
/*     */     
/* 360 */     if (!activityCfg.mallCfgIds.contains(Integer.valueOf(mallCfgId)))
/*     */     {
/* 362 */       return false;
/*     */     }
/*     */     
/* 365 */     SActivityPointExchangeMallCfg mallCfg = SActivityPointExchangeMallCfg.get(mallCfgId);
/* 366 */     if (mallCfg == null)
/*     */     {
/* 368 */       return false;
/*     */     }
/*     */     
/* 371 */     STActivityPointExchangeGoodsCfg activityPointExchangeGoodsCfg = STActivityPointExchangeGoodsCfg.get(mallCfg.goodsCfgTypeId);
/*     */     
/* 373 */     if (activityPointExchangeGoodsCfg == null)
/*     */     {
/* 375 */       return false;
/*     */     }
/* 377 */     SPointExchangeGoodsInfo pointExchangeGoodsInfo = (SPointExchangeGoodsInfo)activityPointExchangeGoodsCfg.id2pointExchangeGoodsInfo.get(Integer.valueOf(goodsCfgId));
/*     */     
/* 379 */     return pointExchangeGoodsInfo != null;
/*     */   }
/*     */   
/*     */   static void onError(long roleId, String strGsLog, xio.Protocol protocol)
/*     */   {
/* 384 */     mzm.gsp.GameServer.logger().error(strGsLog);
/* 385 */     mzm.gsp.online.main.OnlineManager.getInstance().sendAtOnce(roleId, protocol);
/*     */   }
/*     */   
/*     */ 
/*     */   static boolean getGoodsCfgId2available(ActivityPointExchangeGoodsInfo xActivityPointExchangeGoodsInfo, SActivityPointExchangeMallCfg mallCfg, Map<Integer, Integer> cfgId2available)
/*     */   {
/* 391 */     STActivityPointExchangeGoodsCfg activityPointExchangeGoodsCfg = STActivityPointExchangeGoodsCfg.get(mallCfg.goodsCfgTypeId);
/*     */     
/* 393 */     if (activityPointExchangeGoodsCfg == null)
/*     */     {
/* 395 */       return false;
/*     */     }
/*     */     
/* 398 */     for (Map.Entry<Integer, Integer> entry : xActivityPointExchangeGoodsInfo.getGoodscfgid2count().entrySet())
/*     */     {
/* 400 */       SPointExchangeGoodsInfo pointExchangeGoodsInfo = (SPointExchangeGoodsInfo)activityPointExchangeGoodsCfg.id2pointExchangeGoodsInfo.get(entry.getKey());
/* 401 */       if ((pointExchangeGoodsInfo != null) && (pointExchangeGoodsInfo.exchangeMaxCount != -1))
/*     */       {
/*     */ 
/*     */ 
/* 405 */         cfgId2available.put(entry.getKey(), Integer.valueOf(pointExchangeGoodsInfo.exchangeMaxCount - ((Integer)entry.getValue()).intValue())); }
/*     */     }
/* 407 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activitypointexchange\main\ActivityPointExchangeManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */