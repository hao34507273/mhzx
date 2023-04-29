/*     */ package mzm.gsp.jingji.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.NavigableMap;
/*     */ import java.util.Random;
/*     */ import java.util.Set;
/*     */ import java.util.TreeMap;
/*     */ import java.util.concurrent.locks.Lock;
/*     */ import java.util.concurrent.locks.ReadWriteLock;
/*     */ import java.util.concurrent.locks.ReentrantReadWriteLock;
/*     */ import mzm.gsp.activity.confbean.JingjiActivityCfgConsts;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.timer.main.Observer;
/*     */ import xdb.Executor;
/*     */ import xdb.Xdb;
/*     */ 
/*     */ class FightMatchManager
/*     */ {
/*     */   private static final int PERCENT = 10000;
/*  26 */   private static final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
/*     */   
/*  28 */   private static final TreeMap<Integer, List<Long>> mulitFightToRoles = new TreeMap();
/*     */   
/*  30 */   private static Map<Long, MatchInfo> roleToMatchInfo = new HashMap();
/*     */   
/*     */ 
/*  33 */   private static Set<Long> rankings = new HashSet();
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static void init()
/*     */   {
/*  40 */     new UpdateRolesFightingCapacityObserver();
/*     */   }
/*     */   
/*     */   private static class RUpdateRolesFightingCapacity implements Runnable
/*     */   {
/*     */     public void run() {}
/*     */   }
/*     */   
/*     */   private static class UpdateRolesFightingCapacityObserver
/*     */     extends Observer
/*     */   {
/*     */     public UpdateRolesFightingCapacityObserver()
/*     */     {
/*  53 */       super();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean update()
/*     */     {
/*  59 */       Xdb.executor().execute(new FightMatchManager.RUpdateRolesFightingCapacity(null));
/*  60 */       return true;
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
/*     */ 
/*     */ 
/*     */ 
/*     */   private static void updateRolesFightingCapacity()
/*     */   {
/*  84 */     Set<Long> roleids = null;
/*  85 */     readWriteLock.readLock().lock();
/*     */     try
/*     */     {
/*  88 */       roleids = new HashSet(roleToMatchInfo.keySet());
/*  89 */       roleids.addAll(rankings);
/*     */     }
/*     */     finally
/*     */     {
/*  93 */       readWriteLock.readLock().unlock();
/*     */     }
/*     */     
/*  96 */     for (Long roleid : roleids)
/*     */     {
/*  98 */       int winPoint = JingjiManager.getWinpoint(roleid.longValue(), false);
/*  99 */       if (winPoint > 0)
/*     */       {
/*     */ 
/*     */ 
/* 103 */         int rank = RoleJingjiChartInterface.getRank(roleid.longValue());
/* 104 */         int mulitFight = RoleInterface.getRoleMFValue(roleid.longValue());
/* 105 */         int stage = JingjiManager.getPhaseByWingPoint(winPoint);
/* 106 */         MatchInfo matchInfo = new MatchInfo(mulitFight, stage);
/* 107 */         updateRoleMatchInfo(roleid.longValue(), rank, matchInfo);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static void updateRoleMatchInfo(long roleid, int rank, MatchInfo newMatchInfo)
/*     */   {
/* 118 */     int newMulitFight = newMatchInfo.mulitFight;
/* 119 */     readWriteLock.writeLock().lock();
/*     */     try
/*     */     {
/* 122 */       boolean isRemove = false;
/* 123 */       MatchInfo oldMatchInfo = null;
/* 124 */       if (rank >= 0)
/*     */       {
/* 126 */         rankings.add(Long.valueOf(roleid));
/*     */         
/* 128 */         oldMatchInfo = (MatchInfo)roleToMatchInfo.remove(Long.valueOf(roleid));
/* 129 */         if (oldMatchInfo != null)
/*     */         {
/* 131 */           isRemove = true;
/*     */         }
/*     */       }
/*     */       else
/*     */       {
/* 136 */         rankings.remove(Long.valueOf(roleid));
/*     */         
/* 138 */         oldMatchInfo = (MatchInfo)roleToMatchInfo.put(Long.valueOf(roleid), newMatchInfo);
/*     */         
/* 140 */         if ((oldMatchInfo == null) || (oldMatchInfo.mulitFight != newMulitFight))
/*     */         {
/* 142 */           List<Long> roles = (List)mulitFightToRoles.get(Integer.valueOf(newMulitFight));
/* 143 */           if (roles == null)
/*     */           {
/* 145 */             roles = new ArrayList();
/* 146 */             mulitFightToRoles.put(Integer.valueOf(newMulitFight), roles);
/*     */           }
/* 148 */           roles.add(Long.valueOf(roleid));
/* 149 */           if (oldMatchInfo != null)
/*     */           {
/* 151 */             isRemove = true;
/*     */           }
/*     */         }
/*     */       }
/*     */       
/* 156 */       if (isRemove)
/*     */       {
/*     */ 
/* 159 */         List<Long> oldRoles = (List)mulitFightToRoles.get(Integer.valueOf(oldMatchInfo.mulitFight));
/* 160 */         if (oldRoles != null)
/*     */         {
/* 162 */           oldRoles.remove(Long.valueOf(roleid));
/*     */         }
/*     */       }
/*     */     }
/*     */     finally
/*     */     {
/* 168 */       readWriteLock.writeLock().unlock();
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
/*     */   static List<Long> matchOpponents(long roleid, int mulitFight, int winPoint)
/*     */   {
/* 181 */     int realHigherNum = JingjiActivityCfgConsts.getInstance().HIGHER_NUM;
/* 182 */     int realLowerNum = JingjiActivityCfgConsts.getInstance().LOWER_NUM;
/* 183 */     int Multiple = JingjiActivityCfgConsts.getInstance().FIND_TIMES;
/* 184 */     int higherNum = realHigherNum * Multiple;
/* 185 */     int lowerNum = realLowerNum * Multiple;
/*     */     
/* 187 */     int stage = JingjiManager.getPhaseByWingPoint(winPoint);
/* 188 */     List<Long> higherFinds = new ArrayList();
/* 189 */     List<Long> lowerFinds = new ArrayList();
/* 190 */     readWriteLock.readLock().lock();
/*     */     
/*     */ 
/*     */     try
/*     */     {
/* 195 */       int lastKey = ((Integer)mulitFightToRoles.lastKey()).intValue();
/* 196 */       boolean isfind; if (mulitFight <= lastKey)
/*     */       {
/* 198 */         NavigableMap<Integer, List<Long>> subFightingCapacityToRoles = mulitFightToRoles.subMap(Integer.valueOf(mulitFight), true, Integer.valueOf(lastKey), true);
/*     */         
/* 200 */         isfind = false;
/* 201 */         for (Map.Entry<Integer, List<Long>> entry : subFightingCapacityToRoles.entrySet())
/*     */         {
/* 203 */           for (Long tempRoleid : (List)entry.getValue())
/*     */           {
/* 205 */             if (tempRoleid.longValue() != roleid)
/*     */             {
/*     */ 
/*     */ 
/* 209 */               MatchInfo matchInfo = (MatchInfo)roleToMatchInfo.get(tempRoleid);
/* 210 */               if (matchInfo.stage <= stage)
/*     */               {
/*     */ 
/*     */ 
/*     */ 
/* 215 */                 higherFinds.add(tempRoleid);
/* 216 */                 if (higherFinds.size() >= higherNum)
/*     */                 {
/* 218 */                   isfind = true;
/* 219 */                   break;
/*     */                 }
/*     */               } } }
/* 222 */           if (isfind) {
/*     */             break;
/*     */           }
/*     */         }
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 232 */       int toKey = mulitFight * (10000 - JingjiActivityCfgConsts.getInstance().FIGHT_DELTA) / 10000;
/* 233 */       if (toKey > 0)
/*     */       {
/* 235 */         NavigableMap<Integer, List<Long>> subFightingCapacityToRoles = mulitFightToRoles.subMap(Integer.valueOf(0), false, Integer.valueOf(toKey), true);
/*     */         
/* 237 */         isfind = false;
/* 238 */         for (Map.Entry<Integer, List<Long>> entry : subFightingCapacityToRoles.descendingMap().entrySet())
/*     */         {
/* 240 */           for (Long tempRoleid : (List)entry.getValue())
/*     */           {
/* 242 */             if (tempRoleid.longValue() != roleid)
/*     */             {
/*     */ 
/*     */ 
/* 246 */               MatchInfo matchInfo = (MatchInfo)roleToMatchInfo.get(tempRoleid);
/* 247 */               if (matchInfo.stage <= stage)
/*     */               {
/*     */ 
/*     */ 
/*     */ 
/* 252 */                 lowerFinds.add(tempRoleid);
/* 253 */                 if (lowerFinds.size() >= lowerNum)
/*     */                 {
/* 255 */                   isfind = true;
/* 256 */                   break;
/*     */                 }
/*     */               } } }
/* 259 */           if (isfind) {
/*     */             break;
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */     finally
/*     */     {
/*     */       boolean isfind;
/*     */       
/* 269 */       readWriteLock.readLock().unlock();
/*     */     }
/*     */     
/*     */ 
/* 273 */     List<Long> result = new ArrayList();
/*     */     
/*     */ 
/* 276 */     boolean upFull = true;
/* 277 */     if (higherFinds.size() > realHigherNum)
/*     */     {
/* 279 */       result.addAll(randomRoles(higherFinds, realHigherNum));
/*     */     }
/*     */     else
/*     */     {
/* 283 */       result.addAll(higherFinds);
/* 284 */       if (higherFinds.size() < realHigherNum)
/*     */       {
/* 286 */         upFull = false;
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 291 */     if (lowerFinds.size() > realLowerNum)
/*     */     {
/* 293 */       if (!upFull)
/*     */       {
/* 295 */         int count = realLowerNum + realHigherNum - result.size();
/* 296 */         if (count > lowerFinds.size())
/*     */         {
/* 298 */           count = lowerFinds.size();
/*     */         }
/*     */         
/* 301 */         result.addAll(randomRoles(lowerFinds, count));
/*     */       }
/*     */       else
/*     */       {
/* 305 */         result.addAll(randomRoles(lowerFinds, realLowerNum));
/*     */       }
/*     */       
/*     */     }
/*     */     else {
/* 310 */       result.addAll(lowerFinds);
/*     */     }
/*     */     
/* 313 */     return result;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static List<Long> randomRoles(List<Long> roles, int count)
/*     */   {
/* 325 */     int size = roles.size();
/* 326 */     if ((count > size) || (size == 0) || (count == 0))
/*     */     {
/* 328 */       return Collections.emptyList();
/*     */     }
/*     */     
/* 331 */     if (size == count)
/*     */     {
/* 333 */       return new ArrayList(roles);
/*     */     }
/*     */     
/* 336 */     Random random = Xdb.random();
/* 337 */     int i = size; for (int j = 0; j < count; j++)
/*     */     {
/* 339 */       Collections.swap(roles, i - 1, random.nextInt(i));i--;
/*     */     }
/*     */     
/* 342 */     return new ArrayList(roles.subList(size - count, size));
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
/*     */   static void addFightingCapacity(long roleId, int rank, int mulitFight, int winPoint)
/*     */   {
/* 355 */     MatchInfo matchInfo = new MatchInfo(mulitFight, JingjiManager.getPhaseByWingPoint(winPoint));
/* 356 */     updateRoleMatchInfo(roleId, rank, matchInfo);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void removeFightingCapacity(long roleid)
/*     */   {
/* 366 */     readWriteLock.writeLock().lock();
/*     */     try
/*     */     {
/* 369 */       MatchInfo oldMatchInfo = (MatchInfo)roleToMatchInfo.remove(Long.valueOf(roleid));
/* 370 */       if (oldMatchInfo != null)
/*     */       {
/* 372 */         List<Long> roles = (List)mulitFightToRoles.get(Integer.valueOf(oldMatchInfo.mulitFight));
/* 373 */         if (roles != null)
/*     */         {
/* 375 */           roles.remove(Long.valueOf(roleid));
/*     */         }
/*     */       }
/*     */       else
/*     */       {
/* 380 */         rankings.remove(Long.valueOf(roleid));
/*     */       }
/*     */     }
/*     */     finally
/*     */     {
/* 385 */       readWriteLock.writeLock().unlock();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\jingji\main\FightMatchManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */