/*     */ package mzm.gsp.crossbattle.point;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import java.util.concurrent.locks.Lock;
/*     */ import java.util.concurrent.locks.ReadWriteLock;
/*     */ import java.util.concurrent.locks.ReentrantReadWriteLock;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PointRaceCorpsManager
/*     */ {
/*  20 */   private final ReadWriteLock rwLock = new ReentrantReadWriteLock();
/*     */   
/*  22 */   private final Map<Long, List<Long>> corps2Roleids = new HashMap();
/*  23 */   private final Map<Long, Long> role2Corps = new HashMap();
/*     */   
/*     */ 
/*  26 */   private final Map<Long, PointRaceCorpsCurInfo> corps2CurInfo = new HashMap();
/*  27 */   private final Map<Long, PointRaceCorpsFightInfo> corps2FightInfo = new HashMap();
/*  28 */   private final Map<Long, PointRaceCorpsPreInfo> corps2PreInfo = new HashMap();
/*  29 */   private final Map<Long, Integer> corps2Pvp = new HashMap();
/*     */   
/*     */   boolean put(long corpsid, int zoneid, PointRaceCorpsPreInfo preInfo)
/*     */   {
/*  33 */     this.rwLock.writeLock().lock();
/*     */     try
/*     */     {
/*  36 */       if (!this.corps2PreInfo.containsKey(Long.valueOf(corpsid)))
/*     */       {
/*  38 */         this.corps2PreInfo.put(Long.valueOf(corpsid), preInfo);
/*     */       }
/*  40 */       if (!this.corps2FightInfo.containsKey(Long.valueOf(corpsid)))
/*     */       {
/*  42 */         this.corps2FightInfo.put(Long.valueOf(corpsid), new PointRaceCorpsFightInfo());
/*     */       }
/*  44 */       return true;
/*     */     }
/*     */     finally
/*     */     {
/*  48 */       this.rwLock.writeLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   boolean put(long corpsid, List<Long> roleids, PointRaceCorpsCurInfo curInfo)
/*     */   {
/*  54 */     this.rwLock.writeLock().lock();
/*     */     try
/*     */     {
/*  57 */       if (!this.corps2PreInfo.containsKey(Long.valueOf(corpsid)))
/*     */       {
/*  59 */         return false;
/*     */       }
/*     */       
/*  62 */       if (!this.corps2CurInfo.containsKey(Long.valueOf(corpsid)))
/*     */       {
/*  64 */         this.corps2CurInfo.put(Long.valueOf(corpsid), curInfo);
/*     */       }
/*     */       
/*  67 */       Object roles = new ArrayList(roleids);
/*  68 */       this.corps2Roleids.put(Long.valueOf(corpsid), roles);
/*  69 */       for (Iterator i$ = ((List)roles).iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*     */         
/*  71 */         this.role2Corps.put(Long.valueOf(roleid), Long.valueOf(corpsid));
/*     */       }
/*  73 */       return 1;
/*     */     }
/*     */     finally
/*     */     {
/*  77 */       this.rwLock.writeLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getCorpsid(long roleid)
/*     */   {
/*  83 */     this.rwLock.readLock().lock();
/*     */     try
/*     */     {
/*  86 */       return (Long)this.role2Corps.get(Long.valueOf(roleid));
/*     */     }
/*     */     finally
/*     */     {
/*  90 */       this.rwLock.readLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   public List<MatchObj> getMatchObjs(Set<Long> exclusiveCorpsids)
/*     */   {
/*  96 */     this.rwLock.readLock().lock();
/*     */     try
/*     */     {
/*  99 */       Set<Long> allCorpsids = new HashSet(this.corps2CurInfo.keySet());
/* 100 */       if (exclusiveCorpsids != null)
/*     */       {
/* 102 */         allCorpsids.removeAll(exclusiveCorpsids);
/*     */       }
/*     */       
/* 105 */       if (allCorpsids.isEmpty())
/*     */       {
/* 107 */         return Collections.emptyList();
/*     */       }
/*     */       
/* 110 */       Object result = new ArrayList();
/* 111 */       for (Long corpsid : allCorpsids)
/*     */       {
/* 113 */         List<Long> corpRoleids = (List)this.corps2Roleids.get(corpsid);
/* 114 */         if (corpRoleids != null)
/*     */         {
/*     */ 
/*     */ 
/* 118 */           PointRaceCorpsCurInfo curInfo = (PointRaceCorpsCurInfo)this.corps2CurInfo.get(corpsid);
/* 119 */           if (curInfo != null)
/*     */           {
/*     */ 
/*     */ 
/* 123 */             PointRaceCorpsPreInfo preInfo = (PointRaceCorpsPreInfo)this.corps2PreInfo.get(corpsid);
/* 124 */             if (preInfo != null)
/*     */             {
/*     */ 
/*     */ 
/* 128 */               PointRaceCorpsFightInfo fightInfo = (PointRaceCorpsFightInfo)this.corps2FightInfo.get(corpsid);
/* 129 */               if (fightInfo != null)
/*     */               {
/*     */ 
/*     */ 
/*     */ 
/* 134 */                 int fight = preInfo.win + preInfo.lose;
/* 135 */                 fight += curInfo.lose + curInfo.win;
/* 136 */                 MatchObj matchObj = new MatchObj(corpsid.longValue(), corpRoleids, fight);
/*     */                 
/* 138 */                 for (Map.Entry<Long, CorpsCVCInfo> entry : preInfo.corpsFights.entrySet())
/*     */                 {
/* 140 */                   Long key = (Long)entry.getKey();
/* 141 */                   CorpsCVCInfo cvcInfo = (CorpsCVCInfo)entry.getValue();
/* 142 */                   int num = cvcInfo.lose + cvcInfo.win;
/* 143 */                   matchObj.corpsFightInfos.put(key, Integer.valueOf(num));
/*     */                 }
/* 145 */                 for (Map.Entry<Long, CorpsCVCInfo> entry : fightInfo.corpsFights.entrySet())
/*     */                 {
/* 147 */                   Long key = (Long)entry.getKey();
/* 148 */                   CorpsCVCInfo cvcInfo = (CorpsCVCInfo)entry.getValue();
/* 149 */                   int num = cvcInfo.lose + cvcInfo.win;
/*     */                   
/* 151 */                   Integer preNum = (Integer)matchObj.corpsFightInfos.get(key);
/* 152 */                   if (preNum == null)
/*     */                   {
/* 154 */                     matchObj.corpsFightInfos.put(key, Integer.valueOf(num));
/*     */                   }
/*     */                   else
/*     */                   {
/* 158 */                     matchObj.corpsFightInfos.put(key, Integer.valueOf(preNum.intValue() + num));
/*     */                   }
/*     */                 }
/*     */                 
/* 162 */                 ((List)result).add(matchObj);
/*     */               } } } } }
/* 164 */       return (Iterator)result;
/*     */     }
/*     */     finally
/*     */     {
/* 168 */       this.rwLock.readLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean update(long winCorpsid, long loseCorpsid, int winPoint, int losePoint, long updateTime)
/*     */   {
/* 175 */     this.rwLock.writeLock().lock();
/*     */     try
/*     */     {
/* 178 */       PointRaceCorpsCurInfo winCorpsCurInfo = (PointRaceCorpsCurInfo)this.corps2CurInfo.get(Long.valueOf(winCorpsid));
/* 179 */       if (winCorpsCurInfo == null)
/*     */       {
/* 181 */         return false;
/*     */       }
/* 183 */       PointRaceCorpsFightInfo winCorpsFightInfo = (PointRaceCorpsFightInfo)this.corps2FightInfo.get(Long.valueOf(winCorpsid));
/* 184 */       if (winCorpsFightInfo == null)
/*     */       {
/* 186 */         return false;
/*     */       }
/* 188 */       PointRaceCorpsCurInfo loseCorpsCurInfo = (PointRaceCorpsCurInfo)this.corps2CurInfo.get(Long.valueOf(loseCorpsid));
/* 189 */       if (loseCorpsCurInfo == null)
/*     */       {
/* 191 */         return false;
/*     */       }
/* 193 */       PointRaceCorpsFightInfo loseCorpsFightInfo = (PointRaceCorpsFightInfo)this.corps2FightInfo.get(Long.valueOf(loseCorpsid));
/* 194 */       if (loseCorpsFightInfo == null)
/*     */       {
/* 196 */         return false;
/*     */       }
/*     */       
/*     */ 
/* 200 */       int zoneid = winCorpsCurInfo.zoneid;
/* 201 */       int win = winCorpsCurInfo.win + 1;
/* 202 */       int lose = winCorpsCurInfo.lose;
/* 203 */       int point = winCorpsCurInfo.point + winPoint;
/* 204 */       PointRaceCorpsCurInfo newCorpsCurInfo = new PointRaceCorpsCurInfo(zoneid, win, lose, point, updateTime);
/* 205 */       this.corps2CurInfo.put(Long.valueOf(winCorpsid), newCorpsCurInfo);
/*     */       
/* 207 */       int wins = winCorpsFightInfo.wins + 1;
/* 208 */       Map<Long, CorpsCVCInfo> tmp = new HashMap(winCorpsFightInfo.corpsFights);
/* 209 */       CorpsCVCInfo fightInfo = (CorpsCVCInfo)tmp.get(Long.valueOf(loseCorpsid));
/* 210 */       if (fightInfo == null)
/*     */       {
/* 212 */         CorpsCVCInfo info = new CorpsCVCInfo(1, 0);
/* 213 */         tmp.put(Long.valueOf(loseCorpsid), info);
/*     */       }
/*     */       else
/*     */       {
/* 217 */         CorpsCVCInfo info = new CorpsCVCInfo(fightInfo.win + 1, fightInfo.lose);
/* 218 */         tmp.put(Long.valueOf(loseCorpsid), info);
/*     */       }
/*     */       
/* 221 */       PointRaceCorpsFightInfo newCorpsFightInfo = new PointRaceCorpsFightInfo(wins, tmp);
/* 222 */       this.corps2FightInfo.put(Long.valueOf(winCorpsid), newCorpsFightInfo);
/*     */       
/*     */ 
/* 225 */       Integer pvps = (Integer)this.corps2Pvp.get(Long.valueOf(winCorpsid));
/* 226 */       if (pvps == null)
/*     */       {
/* 228 */         this.corps2Pvp.put(Long.valueOf(winCorpsid), Integer.valueOf(1));
/*     */       }
/*     */       else
/*     */       {
/* 232 */         this.corps2Pvp.put(Long.valueOf(winCorpsid), Integer.valueOf(pvps.intValue() + 1));
/*     */       }
/*     */       
/*     */ 
/*     */ 
/* 237 */       int zoneid = loseCorpsCurInfo.zoneid;
/* 238 */       int win = loseCorpsCurInfo.win;
/* 239 */       int lose = loseCorpsCurInfo.lose + 1;
/* 240 */       int point = loseCorpsCurInfo.point + losePoint;
/* 241 */       PointRaceCorpsCurInfo newCorpsCurInfo = new PointRaceCorpsCurInfo(zoneid, win, lose, point, loseCorpsCurInfo.updateTime + 1L);
/*     */       
/* 243 */       this.corps2CurInfo.put(Long.valueOf(loseCorpsid), newCorpsCurInfo);
/*     */       
/* 245 */       int wins = 0;
/* 246 */       Map<Long, CorpsCVCInfo> tmp = new HashMap(loseCorpsFightInfo.corpsFights);
/* 247 */       CorpsCVCInfo fightInfo = (CorpsCVCInfo)tmp.get(Long.valueOf(winCorpsid));
/* 248 */       if (fightInfo == null)
/*     */       {
/* 250 */         CorpsCVCInfo info = new CorpsCVCInfo(0, 1);
/* 251 */         tmp.put(Long.valueOf(winCorpsid), info);
/*     */       }
/*     */       else
/*     */       {
/* 255 */         CorpsCVCInfo info = new CorpsCVCInfo(fightInfo.win, fightInfo.lose + 1);
/* 256 */         tmp.put(Long.valueOf(winCorpsid), info);
/*     */       }
/* 258 */       PointRaceCorpsFightInfo newCorpsFightInfo = new PointRaceCorpsFightInfo(0, tmp);
/* 259 */       this.corps2FightInfo.put(Long.valueOf(loseCorpsid), newCorpsFightInfo);
/*     */       
/*     */ 
/* 262 */       Integer pvps = (Integer)this.corps2Pvp.get(Long.valueOf(loseCorpsid));
/* 263 */       if (pvps == null)
/*     */       {
/* 265 */         this.corps2Pvp.put(Long.valueOf(loseCorpsid), Integer.valueOf(1));
/*     */       }
/*     */       else
/*     */       {
/* 269 */         this.corps2Pvp.put(Long.valueOf(loseCorpsid), Integer.valueOf(pvps.intValue() + 1));
/*     */       }
/*     */       
/* 272 */       return 1;
/*     */     }
/*     */     finally
/*     */     {
/* 276 */       this.rwLock.writeLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   public PointRaceCorpsCurInfo getCorpsCurInfo(long corpsid)
/*     */   {
/* 282 */     this.rwLock.readLock().lock();
/*     */     try
/*     */     {
/* 285 */       return (PointRaceCorpsCurInfo)this.corps2CurInfo.get(Long.valueOf(corpsid));
/*     */     }
/*     */     finally
/*     */     {
/* 289 */       this.rwLock.readLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   public PointRaceCorpsFightInfo getCorpsFightInfo(long corpsid)
/*     */   {
/* 295 */     this.rwLock.readLock().lock();
/*     */     try
/*     */     {
/* 298 */       return (PointRaceCorpsFightInfo)this.corps2FightInfo.get(Long.valueOf(corpsid));
/*     */     }
/*     */     finally
/*     */     {
/* 302 */       this.rwLock.readLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   public PointRaceCorpsPreInfo getCorpsPreInfo(long corpsid)
/*     */   {
/* 308 */     this.rwLock.readLock().lock();
/*     */     try
/*     */     {
/* 311 */       return (PointRaceCorpsPreInfo)this.corps2PreInfo.get(Long.valueOf(corpsid));
/*     */     }
/*     */     finally
/*     */     {
/* 315 */       this.rwLock.readLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   public Map<Long, PointRaceCorpsFightInfo> getCorpsFightInfos(long startTime, long endTime)
/*     */   {
/* 321 */     this.rwLock.readLock().lock();
/*     */     try
/*     */     {
/* 324 */       if (this.corps2FightInfo.isEmpty())
/*     */       {
/* 326 */         return Collections.emptyMap();
/*     */       }
/*     */       
/* 329 */       Object result = new HashMap();
/* 330 */       for (Map.Entry<Long, PointRaceCorpsFightInfo> entry : this.corps2FightInfo.entrySet())
/*     */       {
/* 332 */         PointRaceCorpsFightInfo fightInfo = (PointRaceCorpsFightInfo)entry.getValue();
/* 333 */         long updateTime = fightInfo.updateTime;
/* 334 */         if ((updateTime > startTime) && (updateTime <= endTime))
/*     */         {
/* 336 */           ((Map)result).put(entry.getKey(), fightInfo);
/*     */         }
/*     */       }
/* 339 */       return (Iterator)result;
/*     */     }
/*     */     finally
/*     */     {
/* 343 */       this.rwLock.readLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   public List<Long> getRoleids(long corpsid)
/*     */   {
/* 349 */     this.rwLock.readLock().lock();
/*     */     try
/*     */     {
/* 352 */       List<Long> roleids = (List)this.corps2Roleids.get(Long.valueOf(corpsid));
/* 353 */       Object localObject1; if (roleids == null)
/*     */       {
/* 355 */         return null;
/*     */       }
/* 357 */       return new ArrayList(roleids);
/*     */     }
/*     */     finally
/*     */     {
/* 361 */       this.rwLock.readLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   public void fillAllCorpsid(Set<Long> corpsids)
/*     */   {
/* 367 */     this.rwLock.readLock().lock();
/*     */     try
/*     */     {
/* 370 */       corpsids.addAll(this.corps2CurInfo.keySet());
/*     */     }
/*     */     finally
/*     */     {
/* 374 */       this.rwLock.readLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   public void fillCorpsids(Set<Long> result, Set<Long> roleids)
/*     */   {
/* 380 */     if (result == null)
/*     */     {
/* 382 */       return;
/*     */     }
/* 384 */     this.rwLock.readLock().lock();
/*     */     try
/*     */     {
/* 387 */       for (Long roleid : roleids)
/*     */       {
/* 389 */         Long corpsid = (Long)this.role2Corps.get(roleid);
/* 390 */         if (corpsid != null)
/*     */         {
/*     */ 
/*     */ 
/* 394 */           result.add(corpsid);
/*     */         }
/*     */       }
/*     */     }
/*     */     finally {
/* 399 */       this.rwLock.readLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public int getPvpFight(long corpsid)
/*     */   {
/* 406 */     this.rwLock.readLock().lock();
/*     */     try
/*     */     {
/* 409 */       Integer num = (Integer)this.corps2Pvp.get(Long.valueOf(corpsid));
/* 410 */       int i; if (num == null)
/*     */       {
/* 412 */         return 0;
/*     */       }
/* 414 */       return num.intValue();
/*     */     }
/*     */     finally
/*     */     {
/* 418 */       this.rwLock.readLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean remove(long corpsid)
/*     */   {
/* 424 */     this.rwLock.writeLock().lock();
/*     */     try
/*     */     {
/* 427 */       List<Long> roleids = (List)this.corps2Roleids.remove(Long.valueOf(corpsid));
/* 428 */       Iterator i$; if (roleids != null)
/*     */       {
/* 430 */         for (i$ = roleids.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*     */           
/* 432 */           this.role2Corps.remove(Long.valueOf(roleid));
/*     */         }
/*     */       }
/* 435 */       this.corps2CurInfo.remove(Long.valueOf(corpsid));
/* 436 */       this.corps2Pvp.remove(Long.valueOf(corpsid));
/* 437 */       return 1;
/*     */     }
/*     */     finally
/*     */     {
/* 441 */       this.rwLock.writeLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   public int getCorpsNum()
/*     */   {
/* 447 */     this.rwLock.readLock().lock();
/*     */     try
/*     */     {
/* 450 */       return this.corps2PreInfo.size();
/*     */     }
/*     */     finally
/*     */     {
/* 454 */       this.rwLock.readLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   public int getOnlineCorpsNum()
/*     */   {
/* 460 */     this.rwLock.readLock().lock();
/*     */     try
/*     */     {
/* 463 */       return this.corps2CurInfo.size();
/*     */     }
/*     */     finally
/*     */     {
/* 467 */       this.rwLock.readLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   public void clear()
/*     */   {
/* 473 */     this.rwLock.writeLock().lock();
/*     */     try
/*     */     {
/* 476 */       this.corps2Roleids.clear();
/* 477 */       this.role2Corps.clear();
/*     */       
/* 479 */       this.corps2CurInfo.clear();
/* 480 */       this.corps2FightInfo.clear();
/* 481 */       this.corps2PreInfo.clear();
/*     */     }
/*     */     finally
/*     */     {
/* 485 */       this.rwLock.writeLock().unlock();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\point\PointRaceCorpsManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */