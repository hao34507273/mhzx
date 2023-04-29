/*     */ package mzm.gsp.singlebattle.main;
/*     */ 
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import java.util.concurrent.locks.Lock;
/*     */ import java.util.concurrent.locks.ReadWriteLock;
/*     */ 
/*     */ public class SingleBattleMemberManager
/*     */ {
/*     */   private final Map<Integer, EachBattleTypeInfo> battleType2Info;
/*     */   private final ReadWriteLock lock;
/*     */   
/*     */   public SingleBattleMemberManager()
/*     */   {
/*  15 */     this.battleType2Info = new java.util.HashMap();
/*     */     
/*  17 */     this.lock = new java.util.concurrent.locks.ReentrantReadWriteLock(); }
/*     */   
/*  19 */   private static final SingleBattleMemberManager instance = new SingleBattleMemberManager();
/*     */   
/*     */   static SingleBattleMemberManager getInstance()
/*     */   {
/*  23 */     return instance;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getShouldMemberNum(int battleType)
/*     */   {
/*  34 */     return getBattleTypeInfo(battleType).getShouldRoleIdsNum();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getValidMemberNum(int battleType)
/*     */   {
/*  45 */     return getBattleTypeInfo(battleType).getValidRoleIdsNum();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   void removeBattleData(int battleType, long battleId)
/*     */   {
/*  56 */     getBattleTypeInfo(battleType).removeBattleInfo(battleId);
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
/*     */   void addShouldRoleIds(int battleType, long battleId, Set<Long> roleIds)
/*     */   {
/*  71 */     EachBattleTypeInfo battleTypeInfo = getBattleTypeInfo(battleType);
/*  72 */     battleTypeInfo.getBattleInfo(battleId, true).addShouldRoleIds(roleIds);
/*  73 */     battleTypeInfo.addShouldRoleIdsNum(roleIds.size());
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
/*     */   void addValidRoleId(int battleType, long battleId, long roleId)
/*     */   {
/*  88 */     EachBattleTypeInfo battleTypeInfo = getBattleTypeInfo(battleType);
/*  89 */     if (battleTypeInfo.getBattleInfo(battleId, true).addValidRoleId(roleId))
/*     */     {
/*  91 */       battleTypeInfo.addValidRoleIdsNum(1);
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
/*     */   void removeRoleAFOffLine(int battleType, long battleId, long roleId)
/*     */   {
/* 107 */     EachBattleTypeInfo battleTypeInfo = getBattleTypeInfo(battleType);
/* 108 */     battleTypeInfo.delValidRoleIdsNum(1);
/*     */     
/* 110 */     EachBattleInfo battleInfo = battleTypeInfo.getBattleInfo(battleId);
/* 111 */     if (battleInfo == null)
/*     */     {
/* 113 */       return;
/*     */     }
/* 115 */     battleInfo.rmRoleIdAFOffline(roleId);
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
/*     */   void removeRoleAFLeave(int battleType, long battleId, long roleId)
/*     */   {
/* 130 */     EachBattleTypeInfo battleTypeInfo = getBattleTypeInfo(battleType);
/* 131 */     battleTypeInfo.delValidRoleIdsNum(1);
/* 132 */     battleTypeInfo.delShouldRoleIdsNum(1);
/*     */     
/* 134 */     EachBattleInfo battleInfo = getBattleTypeInfo(battleType).getBattleInfo(battleId);
/* 135 */     if (battleInfo == null)
/*     */     {
/* 137 */       return;
/*     */     }
/* 139 */     battleInfo.rmRoleIdAFLeave(roleId);
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
/*     */   private EachBattleTypeInfo getBattleTypeInfo(int battleType)
/*     */   {
/* 154 */     EachBattleTypeInfo battleTypeInfo = null;
/*     */     
/* 156 */     this.lock.readLock().lock();
/*     */     try
/*     */     {
/* 159 */       battleTypeInfo = (EachBattleTypeInfo)this.battleType2Info.get(Integer.valueOf(battleType));
/*     */     }
/*     */     finally
/*     */     {
/* 163 */       this.lock.readLock().unlock();
/*     */     }
/* 165 */     if (battleTypeInfo != null)
/*     */     {
/* 167 */       return battleTypeInfo;
/*     */     }
/*     */     
/* 170 */     this.lock.writeLock().lock();
/*     */     try
/*     */     {
/* 173 */       battleTypeInfo = (EachBattleTypeInfo)this.battleType2Info.get(Integer.valueOf(battleType));
/* 174 */       EachBattleTypeInfo localEachBattleTypeInfo1; if (battleTypeInfo != null)
/*     */       {
/* 176 */         return battleTypeInfo;
/*     */       }
/*     */       
/* 179 */       battleTypeInfo = new EachBattleTypeInfo();
/* 180 */       this.battleType2Info.put(Integer.valueOf(battleType), battleTypeInfo);
/* 181 */       return battleTypeInfo;
/*     */     }
/*     */     finally
/*     */     {
/* 185 */       this.lock.writeLock().unlock();
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
/*     */   class EachBattleTypeInfo
/*     */   {
/* 200 */     private final Map<Long, SingleBattleMemberManager.EachBattleInfo> battleId2Info = new java.util.HashMap();
/*     */     
/*     */     private volatile int shouldRoleIdsNum;
/*     */     
/*     */     private volatile int validRoleIdsNum;
/* 205 */     private final ReadWriteLock battleTypeLock = new java.util.concurrent.locks.ReentrantReadWriteLock();
/*     */     
/*     */     EachBattleTypeInfo() {}
/*     */     
/* 209 */     int getShouldRoleIdsNum() { return this.shouldRoleIdsNum; }
/*     */     
/*     */ 
/*     */     int getValidRoleIdsNum()
/*     */     {
/* 214 */       return this.validRoleIdsNum;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     void removeBattleInfo(long battleId)
/*     */     {
/* 224 */       this.battleTypeLock.writeLock().lock();
/*     */       try
/*     */       {
/* 227 */         SingleBattleMemberManager.EachBattleInfo battleInfo = (SingleBattleMemberManager.EachBattleInfo)this.battleId2Info.remove(Long.valueOf(battleId));
/* 228 */         if (battleInfo == null) {
/*     */           return;
/*     */         }
/*     */         
/*     */ 
/* 233 */         int battleShouldNum = battleInfo.getShouldRoleIds().size();
/*     */         
/* 235 */         int finalNum = this.shouldRoleIdsNum - battleShouldNum;
/* 236 */         if (finalNum < 0)
/*     */         {
/* 238 */           this.shouldRoleIdsNum = 0;
/*     */         }
/*     */         else
/*     */         {
/* 242 */           this.shouldRoleIdsNum = finalNum;
/*     */         }
/*     */       }
/*     */       finally
/*     */       {
/* 247 */         this.battleTypeLock.writeLock().unlock();
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     void addShouldRoleIdsNum(int num)
/*     */     {
/* 258 */       this.battleTypeLock.writeLock().lock();
/*     */       try
/*     */       {
/* 261 */         this.shouldRoleIdsNum += num;
/*     */       }
/*     */       finally
/*     */       {
/* 265 */         this.battleTypeLock.writeLock().unlock();
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     void addValidRoleIdsNum(int num)
/*     */     {
/* 276 */       this.battleTypeLock.writeLock().lock();
/*     */       try
/*     */       {
/* 279 */         this.validRoleIdsNum += num;
/*     */       }
/*     */       finally
/*     */       {
/* 283 */         this.battleTypeLock.writeLock().unlock();
/*     */       }
/*     */     }
/*     */     
/*     */     void delShouldRoleIdsNum(int num)
/*     */     {
/* 289 */       this.battleTypeLock.writeLock().lock();
/*     */       try
/*     */       {
/* 292 */         int finalNum = this.shouldRoleIdsNum - num;
/* 293 */         if (finalNum < 0)
/*     */         {
/* 295 */           this.shouldRoleIdsNum = 0;
/*     */         }
/*     */         else
/*     */         {
/* 299 */           this.shouldRoleIdsNum = finalNum;
/*     */         }
/*     */       }
/*     */       finally
/*     */       {
/* 304 */         this.battleTypeLock.writeLock().unlock();
/*     */       }
/*     */     }
/*     */     
/*     */     void delValidRoleIdsNum(int num)
/*     */     {
/* 310 */       this.battleTypeLock.writeLock().lock();
/*     */       try
/*     */       {
/* 313 */         int finalValidNum = this.validRoleIdsNum - num;
/* 314 */         if (finalValidNum < 0)
/*     */         {
/* 316 */           this.validRoleIdsNum = 0;
/*     */         }
/*     */         else
/*     */         {
/* 320 */           this.validRoleIdsNum = finalValidNum;
/*     */         }
/*     */       }
/*     */       finally
/*     */       {
/* 325 */         this.battleTypeLock.writeLock().unlock();
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     SingleBattleMemberManager.EachBattleInfo getBattleInfo(long battleId)
/*     */     {
/* 337 */       return getBattleInfo(battleId, false);
/*     */     }
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
/*     */     SingleBattleMemberManager.EachBattleInfo getBattleInfo(long battleId, boolean create)
/*     */     {
/* 351 */       SingleBattleMemberManager.EachBattleInfo battleInfo = null;
/*     */       
/* 353 */       this.battleTypeLock.readLock().lock();
/*     */       try
/*     */       {
/* 356 */         battleInfo = (SingleBattleMemberManager.EachBattleInfo)this.battleId2Info.get(Long.valueOf(battleId));
/*     */       }
/*     */       finally
/*     */       {
/* 360 */         this.battleTypeLock.readLock().unlock();
/*     */       }
/* 362 */       if ((battleInfo != null) || (!create))
/*     */       {
/* 364 */         return battleInfo;
/*     */       }
/*     */       
/* 367 */       this.battleTypeLock.writeLock().lock();
/*     */       try
/*     */       {
/* 370 */         battleInfo = (SingleBattleMemberManager.EachBattleInfo)this.battleId2Info.get(Long.valueOf(battleId));
/* 371 */         SingleBattleMemberManager.EachBattleInfo localEachBattleInfo1; if (battleInfo != null)
/*     */         {
/* 373 */           return battleInfo;
/*     */         }
/*     */         
/* 376 */         battleInfo = new SingleBattleMemberManager.EachBattleInfo(SingleBattleMemberManager.this);
/* 377 */         this.battleId2Info.put(Long.valueOf(battleId), battleInfo);
/* 378 */         return battleInfo;
/*     */       }
/*     */       finally
/*     */       {
/* 382 */         this.battleTypeLock.writeLock().unlock();
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   class EachBattleInfo
/*     */   {
/*     */     private final Set<Long> shouldRoleIds;
/*     */     
/*     */ 
/*     */ 
/*     */     private final Set<Long> validRoleIds;
/*     */     
/*     */ 
/*     */ 
/*     */     EachBattleInfo()
/*     */     {
/* 402 */       this.shouldRoleIds = new java.util.HashSet();
/* 403 */       this.validRoleIds = new java.util.HashSet();
/*     */     }
/*     */     
/* 406 */     private final ReadWriteLock battleLock = new java.util.concurrent.locks.ReentrantReadWriteLock();
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     void addShouldRoleIds(Set<Long> roleIds)
/*     */     {
/* 415 */       if ((roleIds == null) || (roleIds.size() == 0))
/*     */       {
/* 417 */         return;
/*     */       }
/* 419 */       this.battleLock.writeLock().lock();
/*     */       try
/*     */       {
/* 422 */         this.shouldRoleIds.addAll(roleIds);
/*     */       }
/*     */       finally
/*     */       {
/* 426 */         this.battleLock.writeLock().unlock();
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     boolean addValidRoleId(long roleId)
/*     */     {
/* 437 */       this.battleLock.writeLock().lock();
/*     */       try
/*     */       {
/* 440 */         return this.validRoleIds.add(Long.valueOf(roleId));
/*     */       }
/*     */       finally
/*     */       {
/* 444 */         this.battleLock.writeLock().unlock();
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     void rmRoleIdAFLeave(long roleId)
/*     */     {
/* 455 */       this.battleLock.writeLock().lock();
/*     */       
/*     */       try
/*     */       {
/* 459 */         this.shouldRoleIds.remove(Long.valueOf(roleId));
/*     */         
/* 461 */         this.validRoleIds.remove(Long.valueOf(roleId));
/*     */       }
/*     */       finally
/*     */       {
/* 465 */         this.battleLock.writeLock().unlock();
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     void rmRoleIdAFOffline(long roleId)
/*     */     {
/* 476 */       this.battleLock.writeLock().lock();
/*     */       
/*     */       try
/*     */       {
/* 480 */         this.validRoleIds.remove(Long.valueOf(roleId));
/*     */       }
/*     */       finally
/*     */       {
/* 484 */         this.battleLock.writeLock().unlock();
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     Set<Long> getShouldRoleIds()
/*     */     {
/* 495 */       this.battleLock.readLock().lock();
/*     */       try
/*     */       {
/* 498 */         return this.shouldRoleIds;
/*     */       }
/*     */       finally
/*     */       {
/* 502 */         this.battleLock.readLock().unlock();
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     Set<Long> getValidRoleIds()
/*     */     {
/* 513 */       this.battleLock.readLock().lock();
/*     */       try
/*     */       {
/* 516 */         return this.validRoleIds;
/*     */       }
/*     */       finally
/*     */       {
/* 520 */         this.battleLock.readLock().unlock();
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\singlebattle\main\SingleBattleMemberManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */