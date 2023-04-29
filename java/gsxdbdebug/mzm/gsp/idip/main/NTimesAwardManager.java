/*     */ package mzm.gsp.idip.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import java.util.concurrent.locks.Lock;
/*     */ import java.util.concurrent.locks.ReadWriteLock;
/*     */ import java.util.concurrent.locks.ReentrantReadWriteLock;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.buff.main.BuffInterface;
/*     */ import mzm.gsp.crossbattle.knockout.CrossBattleKnockoutInterface;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.confbean.SIDIPNTimesAwardBuffCfg;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.IdipConfigInfo;
/*     */ import xbean.IdipNTimesAwardInfo;
/*     */ import xbean.Role2NTimesAwardInfo;
/*     */ import xtable.Idipconfig;
/*     */ import xtable.Role2ntimesaward;
/*     */ 
/*     */ public class NTimesAwardManager
/*     */ {
/*     */   public static final int HU_SONG_SILVER_BUFF = 701210108;
/*  29 */   private static final ReadWriteLock globalNTimesAwardLock = new ReentrantReadWriteLock();
/*  30 */   private static final Lock globalNTimesWriteLock = globalNTimesAwardLock.writeLock();
/*  31 */   private static final Lock globalNTimesReadLock = globalNTimesAwardLock.readLock();
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  36 */   private static final Map<Integer, NTimesAwardGlobalMillObserver> globalStartObserverCacheMap = new HashMap();
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  41 */   private static final Map<Integer, NTimesAwardGlobalMillObserver> globalEndObserverCacheMap = new HashMap();
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  46 */   private static final Map<Integer, NTimesAwardInfo> currentGlobalNTimesCacheMap = new HashMap();
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  51 */   private static final ReadWriteLock roleNTimesAwardLock = new ReentrantReadWriteLock();
/*  52 */   private static final Lock roleNTimesWriteLock = roleNTimesAwardLock.writeLock();
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  57 */   private static final Map<Long, Map<Integer, NTimesAwardRoleMillObserver>> roleStartObserverCacheMap = new HashMap();
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  62 */   private static final Map<Long, Map<Integer, NTimesAwardRoleMillObserver>> roleEndObserverCacheMap = new HashMap();
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static void init()
/*     */   {
/*  69 */     globalNTimesWriteLock.lock();
/*     */     try
/*     */     {
/*  72 */       globalStartObserverCacheMap.clear();
/*  73 */       globalEndObserverCacheMap.clear();
/*  74 */       currentGlobalNTimesCacheMap.clear();
/*     */     }
/*     */     finally
/*     */     {
/*  78 */       globalNTimesWriteLock.unlock();
/*     */     }
/*     */     
/*  81 */     roleNTimesWriteLock.lock();
/*     */     try
/*     */     {
/*  84 */       roleStartObserverCacheMap.clear();
/*  85 */       roleEndObserverCacheMap.clear();
/*     */     }
/*     */     finally
/*     */     {
/*  89 */       roleNTimesWriteLock.unlock();
/*     */     }
/*     */     
/*  92 */     new PIDIPNTimesAwardInit(null).call();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void removeCurrentGlobalNTimesAwardInfo(int buffId)
/*     */   {
/* 104 */     globalNTimesWriteLock.lock();
/*     */     try
/*     */     {
/* 107 */       NTimesAwardInfo nTimesAwardInfo = (NTimesAwardInfo)currentGlobalNTimesCacheMap.get(Integer.valueOf(buffId));
/* 108 */       if (nTimesAwardInfo != null)
/*     */       {
/* 110 */         nTimesAwardInfo.setExpireTime(DateTimeUtils.getCurrTimeInMillis());
/*     */       }
/* 112 */       NTimesAwardGlobalMillObserver globalEndObserver = (NTimesAwardGlobalMillObserver)globalEndObserverCacheMap.remove(Integer.valueOf(buffId));
/* 113 */       if (globalEndObserver != null)
/*     */       {
/* 115 */         globalEndObserver.stopTimer();
/*     */       }
/*     */       
/* 118 */       NTimesAwardGlobalMillObserver globalStartObserver = (NTimesAwardGlobalMillObserver)globalStartObserverCacheMap.remove(Integer.valueOf(buffId));
/* 119 */       if (globalStartObserver != null)
/*     */       {
/* 121 */         globalStartObserver.stopTimer();
/*     */       }
/*     */     }
/*     */     finally
/*     */     {
/* 126 */       globalNTimesWriteLock.unlock();
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
/*     */   static void removeRoleNTimesAwardMapInfo(long roleId, int buffId)
/*     */   {
/* 140 */     roleNTimesWriteLock.lock();
/*     */     try
/*     */     {
/* 143 */       Map<Integer, NTimesAwardRoleMillObserver> roleStartObserverMap = (Map)roleStartObserverCacheMap.get(Long.valueOf(roleId));
/*     */       
/* 145 */       if (roleStartObserverMap == null)
/*     */       {
/* 147 */         roleStartObserverMap = new HashMap();
/* 148 */         roleStartObserverCacheMap.put(Long.valueOf(roleId), roleStartObserverMap);
/*     */       }
/*     */       
/* 151 */       NTimesAwardRoleMillObserver roleStartObserver = (NTimesAwardRoleMillObserver)roleStartObserverMap.remove(Integer.valueOf(buffId));
/* 152 */       if (roleStartObserver != null)
/*     */       {
/* 154 */         roleStartObserver.stopTimer();
/*     */       }
/*     */       
/* 157 */       Map<Integer, NTimesAwardRoleMillObserver> roleEndObserverMap = (Map)roleEndObserverCacheMap.get(Long.valueOf(roleId));
/* 158 */       if (roleEndObserverMap == null)
/*     */       {
/* 160 */         roleEndObserverMap = new HashMap();
/* 161 */         roleEndObserverCacheMap.put(Long.valueOf(roleId), roleEndObserverMap);
/*     */       }
/*     */       
/* 164 */       NTimesAwardRoleMillObserver roleEndObserver = (NTimesAwardRoleMillObserver)roleEndObserverMap.remove(Integer.valueOf(buffId));
/* 165 */       if (roleEndObserver != null)
/*     */       {
/* 167 */         roleEndObserver.stopTimer();
/*     */       }
/*     */       
/* 170 */       BuffInterface.uninstallBufAsyc(roleId, buffId);
/*     */     }
/*     */     finally
/*     */     {
/* 174 */       roleNTimesWriteLock.unlock();
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
/*     */   static void addCurrentGlobalNTimesAwardInfo(int buffId, NTimesAwardInfo nTimesAwardInfo)
/*     */   {
/* 188 */     globalNTimesWriteLock.lock();
/*     */     try
/*     */     {
/* 191 */       currentGlobalNTimesCacheMap.put(Integer.valueOf(buffId), nTimesAwardInfo);
/*     */     }
/*     */     finally
/*     */     {
/* 195 */       globalNTimesWriteLock.unlock();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void globalNTimesAwardInstallLogin(long roleId)
/*     */   {
/* 207 */     globalNTimesReadLock.lock();
/*     */     try
/*     */     {
/* 210 */       for (Map.Entry<Integer, NTimesAwardInfo> entry : currentGlobalNTimesCacheMap.entrySet())
/*     */       {
/* 212 */         NTimesAwardInfo nTimesAwardInfo = (NTimesAwardInfo)entry.getValue();
/*     */         
/* 214 */         long currTimeInMillis = DateTimeUtils.getCurrTimeInMillis();
/* 215 */         if (nTimesAwardInfo.getExpireTime() > currTimeInMillis)
/*     */         {
/*     */ 
/*     */ 
/*     */ 
/* 220 */           if (CrossBattleKnockoutInterface.isFinalServerAwardBuff(((Integer)entry.getKey()).intValue()))
/*     */           {
/* 222 */             int roleZoneId = GameServerInfoManager.getZoneidFromRoleid(roleId);
/* 223 */             if ((!nTimesAwardInfo.getValidedZoneIdSet().contains(Integer.valueOf(roleZoneId))) || 
/*     */             
/*     */ 
/*     */ 
/*     */ 
/* 228 */               (!CrossBattleKnockoutInterface.isCrossBattleServerBuffSwitchOpen(roleId))) {}
/*     */ 
/*     */           }
/*     */           else
/*     */           {
/*     */ 
/* 234 */             BuffInterface.installIDIPBuffAsyc(roleId, ((Integer)entry.getKey()).intValue(), nTimesAwardInfo.getNTimes(), nTimesAwardInfo.getExpireTime());
/*     */             
/*     */ 
/* 237 */             GameServer.logger().info(String.format("[ntimesaward]IDIPNTimesAwardManager.globalNTimesAwardInstallLogin@login install global n_times buff success|role_id=%d|buff_id=%d|n_times=%d|start_time=%d|end_time=%d", new Object[] { Long.valueOf(roleId), entry.getKey(), Integer.valueOf(nTimesAwardInfo.getNTimes()), Long.valueOf(nTimesAwardInfo.getStartTime()), Long.valueOf(nTimesAwardInfo.getExpireTime()) }));
/*     */           }
/*     */           
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     finally
/*     */     {
/* 246 */       globalNTimesReadLock.unlock();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void globalNTimesFinalServerAwardInstall(long roleId)
/*     */   {
/* 258 */     globalNTimesReadLock.lock();
/*     */     try
/*     */     {
/* 261 */       for (Map.Entry<Integer, NTimesAwardInfo> entry : currentGlobalNTimesCacheMap.entrySet())
/*     */       {
/* 263 */         NTimesAwardInfo nTimesAwardInfo = (NTimesAwardInfo)entry.getValue();
/*     */         
/* 265 */         long currTimeInMillis = DateTimeUtils.getCurrTimeInMillis();
/* 266 */         if ((nTimesAwardInfo.getExpireTime() > currTimeInMillis) && 
/*     */         
/*     */ 
/*     */ 
/*     */ 
/* 271 */           (CrossBattleKnockoutInterface.isFinalServerAwardBuff(((Integer)entry.getKey()).intValue())))
/*     */         {
/*     */ 
/*     */ 
/*     */ 
/* 276 */           int roleZoneId = GameServerInfoManager.getZoneidFromRoleid(roleId);
/* 277 */           if (nTimesAwardInfo.getValidedZoneIdSet().contains(Integer.valueOf(roleZoneId)))
/*     */           {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 283 */             BuffInterface.installIDIPBuffAsyc(roleId, ((Integer)entry.getKey()).intValue(), nTimesAwardInfo.getNTimes(), nTimesAwardInfo.getExpireTime());
/*     */             
/*     */ 
/* 286 */             GameServer.logger().info(String.format("[ntimesaward]IDIPNTimesAwardManager.globalNTimesFinalServerAwardInstall@login install global n_times buff success|role_id=%d|buff_id=%d|n_times=%d|start_time=%d|end_time=%d", new Object[] { Long.valueOf(roleId), entry.getKey(), Integer.valueOf(nTimesAwardInfo.getNTimes()), Long.valueOf(nTimesAwardInfo.getStartTime()), Long.valueOf(nTimesAwardInfo.getExpireTime()) }));
/*     */           }
/*     */           
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     finally
/*     */     {
/* 295 */       globalNTimesReadLock.unlock();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void globalNTimesAwardUnInstallLogoff(long roleId)
/*     */   {
/* 306 */     globalNTimesReadLock.lock();
/*     */     try
/*     */     {
/* 309 */       for (Map.Entry<Integer, NTimesAwardInfo> entry : currentGlobalNTimesCacheMap.entrySet())
/*     */       {
/* 311 */         int buffId = ((Integer)entry.getKey()).intValue();
/* 312 */         NTimesAwardInfo nTimesAwardInfo = (NTimesAwardInfo)entry.getValue();
/*     */         
/* 314 */         BuffInterface.uninstallBufAsyc(roleId, buffId);
/*     */         
/* 316 */         GameServer.logger().info(String.format("[ntimesaward]IDIPNTimesAwardManager.globalNTimesAwardInstallLogin@logoff global unistall n_times buff success|role_id=%d|buff_id=%d|n_times=%d|start_time=%d|end_time=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(buffId), Integer.valueOf(nTimesAwardInfo.getNTimes()), Long.valueOf(nTimesAwardInfo.getStartTime()), Long.valueOf(nTimesAwardInfo.getExpireTime()) }));
/*     */ 
/*     */       }
/*     */       
/*     */ 
/*     */     }
/*     */     finally
/*     */     {
/*     */ 
/* 325 */       globalNTimesReadLock.unlock();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void globalNTimesFinalServerAwardUnInstall(long roleId)
/*     */   {
/* 336 */     globalNTimesReadLock.lock();
/*     */     try
/*     */     {
/* 339 */       for (Map.Entry<Integer, NTimesAwardInfo> entry : currentGlobalNTimesCacheMap.entrySet())
/*     */       {
/* 341 */         int buffId = ((Integer)entry.getKey()).intValue();
/* 342 */         NTimesAwardInfo nTimesAwardInfo = (NTimesAwardInfo)entry.getValue();
/*     */         
/* 344 */         if (CrossBattleKnockoutInterface.isFinalServerAwardBuff(buffId))
/*     */         {
/*     */ 
/*     */ 
/*     */ 
/* 349 */           BuffInterface.uninstallBufAsyc(roleId, buffId);
/*     */           
/* 351 */           GameServer.logger().info(String.format("[ntimesaward]IDIPNTimesAwardManager.globalNTimesFinalServerAwardUnInstall@logoff global unistall n_times buff success|role_id=%d|buff_id=%d|n_times=%d|start_time=%d|end_time=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(buffId), Integer.valueOf(nTimesAwardInfo.getNTimes()), Long.valueOf(nTimesAwardInfo.getStartTime()), Long.valueOf(nTimesAwardInfo.getExpireTime()) }));
/*     */         }
/*     */         
/*     */       }
/*     */       
/*     */ 
/*     */     }
/*     */     finally
/*     */     {
/* 360 */       globalNTimesReadLock.unlock();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private static class PIDIPNTimesAwardInit
/*     */     extends mzm.gsp.util.LogicProcedure
/*     */   {
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/* 372 */       IdipConfigInfo xIdipConfigInfo = Idipconfig.get(Long.valueOf(GameServerInfoManager.getLocalId()));
/* 373 */       if (xIdipConfigInfo == null)
/*     */       {
/* 375 */         xIdipConfigInfo = xbean.Pod.newIdipConfigInfo();
/* 376 */         Idipconfig.add(Long.valueOf(GameServerInfoManager.getLocalId()), xIdipConfigInfo);
/*     */       }
/*     */       
/* 379 */       NTimesAwardManager.globalNTimesWriteLock.lock();
/*     */       try
/*     */       {
/* 382 */         Map<Integer, IdipNTimesAwardInfo> xGlobalNTimesAwardMap = xIdipConfigInfo.getN_times_award();
/*     */         
/* 384 */         Iterator<Map.Entry<Integer, IdipNTimesAwardInfo>> iterator = xGlobalNTimesAwardMap.entrySet().iterator();
/* 385 */         while (iterator.hasNext())
/*     */         {
/* 387 */           Map.Entry<Integer, IdipNTimesAwardInfo> entry = (Map.Entry)iterator.next();
/* 388 */           IdipNTimesAwardInfo xIdipNTimesAwardInfo = (IdipNTimesAwardInfo)entry.getValue();
/*     */           
/* 390 */           int buffId = ((Integer)entry.getKey()).intValue();
/* 391 */           long currentTimeMillis = DateTimeUtils.getCurrTimeInMillis();
/* 392 */           int nTimes = xIdipNTimesAwardInfo.getN_times();
/* 393 */           long startTime = xIdipNTimesAwardInfo.getStart_time();
/* 394 */           long endTime = xIdipNTimesAwardInfo.getExpire_time();
/*     */           
/*     */ 
/* 397 */           if (endTime <= currentTimeMillis)
/*     */           {
/* 399 */             iterator.remove();
/* 400 */             GameServer.logger().info(String.format("[ntimesaward]IDIPNTimesAwardManager.PIDIPNTimesAwardInit.processImp@global buff remove from xdb,time expired|buff_id=%d|start_time=%d|end_time=%d|n_times=%d", new Object[] { Integer.valueOf(buffId), Long.valueOf(startTime), Long.valueOf(endTime), Integer.valueOf(nTimes) }));
/*     */ 
/*     */           }
/*     */           else
/*     */           {
/*     */ 
/* 406 */             long startInterval = startTime - currentTimeMillis;
/*     */             
/* 408 */             Set<Integer> validedZoneId = new java.util.HashSet(xIdipNTimesAwardInfo.getValid_zone_id_set());
/*     */             
/*     */ 
/* 411 */             NTimesAwardManager.globalStartObserverCacheMap.put(Integer.valueOf(buffId), new NTimesAwardGlobalMillObserver(startInterval < 0L ? 0L : startInterval, buffId, new NTimesAwardInfo(nTimes, startTime, endTime, validedZoneId), 1));
/*     */             
/*     */ 
/*     */ 
/*     */ 
/* 416 */             NTimesAwardManager.globalEndObserverCacheMap.put(Integer.valueOf(buffId), new NTimesAwardGlobalMillObserver(endTime - currentTimeMillis, buffId, new NTimesAwardInfo(nTimes, startTime, endTime, validedZoneId), 0));
/*     */ 
/*     */           }
/*     */           
/*     */         }
/*     */         
/*     */ 
/*     */       }
/*     */       finally
/*     */       {
/*     */ 
/* 427 */         NTimesAwardManager.globalNTimesWriteLock.unlock();
/*     */       }
/*     */       
/* 430 */       return true;
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
/*     */   public static void addGlobalObserver(int buffId, NTimesAwardGlobalMillObserver globalStartObserver, NTimesAwardGlobalMillObserver globalEndObserver)
/*     */   {
/* 444 */     globalNTimesWriteLock.lock();
/*     */     try
/*     */     {
/* 447 */       NTimesAwardGlobalMillObserver oldStartObserver = (NTimesAwardGlobalMillObserver)globalStartObserverCacheMap.put(Integer.valueOf(buffId), globalStartObserver);
/* 448 */       if (oldStartObserver != null)
/*     */       {
/* 450 */         oldStartObserver.stopTimer();
/*     */       }
/*     */       
/* 453 */       NTimesAwardGlobalMillObserver oldEndObserver = (NTimesAwardGlobalMillObserver)globalEndObserverCacheMap.put(Integer.valueOf(buffId), globalEndObserver);
/* 454 */       if (oldEndObserver != null)
/*     */       {
/* 456 */         oldEndObserver.stopTimer();
/*     */       }
/*     */     }
/*     */     finally
/*     */     {
/* 461 */       globalNTimesWriteLock.unlock();
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
/*     */   public static void addRoleObserver(long roleId, int buffId, NTimesAwardRoleMillObserver roleStartObserver, NTimesAwardRoleMillObserver roleEndObserver)
/*     */   {
/* 475 */     roleNTimesWriteLock.lock();
/*     */     try
/*     */     {
/* 478 */       Map<Integer, NTimesAwardRoleMillObserver> startObserverMap = (Map)roleStartObserverCacheMap.get(Long.valueOf(roleId));
/* 479 */       if (startObserverMap == null)
/*     */       {
/* 481 */         startObserverMap = new HashMap();
/* 482 */         roleStartObserverCacheMap.put(Long.valueOf(roleId), startObserverMap);
/*     */       }
/* 484 */       NTimesAwardRoleMillObserver oldStartObserver = (NTimesAwardRoleMillObserver)startObserverMap.put(Integer.valueOf(buffId), roleStartObserver);
/* 485 */       if (oldStartObserver != null)
/*     */       {
/* 487 */         oldStartObserver.stopTimer();
/*     */       }
/*     */       
/* 490 */       Map<Integer, NTimesAwardRoleMillObserver> endObserverMap = (Map)roleEndObserverCacheMap.get(Long.valueOf(roleId));
/* 491 */       if (endObserverMap == null)
/*     */       {
/* 493 */         endObserverMap = new HashMap();
/* 494 */         roleEndObserverCacheMap.put(Long.valueOf(roleId), endObserverMap);
/*     */       }
/* 496 */       NTimesAwardRoleMillObserver oldEndObserver = (NTimesAwardRoleMillObserver)endObserverMap.put(Integer.valueOf(buffId), roleEndObserver);
/* 497 */       if (oldEndObserver != null)
/*     */       {
/* 499 */         oldEndObserver.stopTimer();
/*     */       }
/*     */     }
/*     */     finally
/*     */     {
/* 504 */       roleNTimesWriteLock.unlock();
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
/*     */   public static int getBuffIdByIdipId(int idipId)
/*     */   {
/* 517 */     SIDIPNTimesAwardBuffCfg sIdipNTimesAwardBuffCfg = SIDIPNTimesAwardBuffCfg.get(idipId);
/* 518 */     if (sIdipNTimesAwardBuffCfg == null)
/*     */     {
/* 520 */       return 0;
/*     */     }
/* 522 */     return sIdipNTimesAwardBuffCfg.buffId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public static List<Integer> getAllBuffIdList()
/*     */   {
/* 530 */     List<Integer> buffList = new ArrayList();
/* 531 */     for (SIDIPNTimesAwardBuffCfg sIdipnTimesAwardBuffCfg : SIDIPNTimesAwardBuffCfg.getAll().values())
/*     */     {
/* 533 */       buffList.add(Integer.valueOf(sIdipnTimesAwardBuffCfg.buffId));
/*     */     }
/* 535 */     return buffList;
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
/*     */   public static int isBuffNTimes(long roleId, int buffId)
/*     */   {
/* 549 */     int nTimes = 0;
/*     */     
/* 551 */     Role2NTimesAwardInfo xRole2nTimesAwardInfo = Role2ntimesaward.get(Long.valueOf(roleId));
/* 552 */     long currentTimeMillis = DateTimeUtils.getCurrTimeInMillis();
/* 553 */     if (xRole2nTimesAwardInfo != null)
/*     */     {
/* 555 */       Map<Integer, IdipNTimesAwardInfo> xIdipNTimesAwardInfoMap = xRole2nTimesAwardInfo.getN_times_award_role_map();
/* 556 */       IdipNTimesAwardInfo xIdipNTimesAwardInfo = (IdipNTimesAwardInfo)xIdipNTimesAwardInfoMap.get(Integer.valueOf(buffId));
/* 557 */       nTimes += ((xIdipNTimesAwardInfo != null) && (xIdipNTimesAwardInfo.getExpire_time() > currentTimeMillis) && (xIdipNTimesAwardInfo.getStart_time() <= currentTimeMillis) ? xIdipNTimesAwardInfo.getN_times() : 0);
/*     */     }
/*     */     
/* 560 */     globalNTimesReadLock.lock();
/*     */     try
/*     */     {
/* 563 */       NTimesAwardInfo nTimesAwardInfo = (NTimesAwardInfo)currentGlobalNTimesCacheMap.get(Integer.valueOf(buffId));
/* 564 */       if ((nTimesAwardInfo != null) && (nTimesAwardInfo.getExpireTime() > currentTimeMillis) && (nTimesAwardInfo.getStartTime() <= currentTimeMillis))
/*     */       {
/*     */ 
/* 567 */         nTimes += nTimesAwardInfo.getNTimes();
/*     */       }
/*     */     }
/*     */     finally
/*     */     {
/* 572 */       globalNTimesReadLock.unlock();
/*     */     }
/*     */     
/* 575 */     return nTimes + 1;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\idip\main\NTimesAwardManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */