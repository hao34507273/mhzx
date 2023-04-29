/*     */ package mzm.gsp.fight.main;
/*     */ 
/*     */ import com.goldhuman.Common.Octets;
/*     */ import java.util.HashSet;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import java.util.concurrent.locks.Lock;
/*     */ import java.util.concurrent.locks.ReadWriteLock;
/*     */ import java.util.concurrent.locks.ReentrantReadWriteLock;
/*     */ import mzm.gsp.fight.SSyncRealtimeRecordEnterFight;
/*     */ import mzm.gsp.fight.SSyncRealtimeRecordFightEnd;
/*     */ import mzm.gsp.fight.SSyncRealtimeRecordRoundPlay;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ 
/*     */ 
/*     */ 
/*     */ class RoamFightRecorderCache
/*     */ {
/*     */   private final long recordid;
/*  20 */   private final ReadWriteLock rwLock = new ReentrantReadWriteLock();
/*     */   
/*  22 */   private final Set<Long> observers = new HashSet();
/*     */   
/*     */   private Octets startData;
/*     */   private Octets endData;
/*     */   private List<Octets> roundDataList;
/*  27 */   private volatile boolean ready = false;
/*     */   
/*     */   RoamFightRecorderCache(long recordid)
/*     */   {
/*  31 */     this.recordid = recordid;
/*     */   }
/*     */   
/*     */   public void removeObserver(long observerid)
/*     */   {
/*  36 */     this.rwLock.readLock().lock();
/*     */     try
/*     */     {
/*  39 */       if (this.observers.isEmpty()) {
/*     */         return;
/*     */       }
/*     */       
/*     */     }
/*     */     finally
/*     */     {
/*  46 */       this.rwLock.readLock().unlock();
/*     */     }
/*     */     
/*  49 */     this.rwLock.writeLock().lock();
/*     */     try
/*     */     {
/*  52 */       this.observers.remove(Long.valueOf(observerid));
/*     */     }
/*     */     finally
/*     */     {
/*  56 */       this.rwLock.writeLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   public void onReady(Octets fightStart, Octets fightEnd, List<Octets> roundDataList)
/*     */   {
/*  62 */     this.ready = true;
/*     */     
/*  64 */     this.rwLock.writeLock().lock();
/*     */     try
/*     */     {
/*  67 */       this.startData = fightStart;
/*  68 */       this.endData = fightEnd;
/*  69 */       this.roundDataList = roundDataList;
/*     */       
/*  71 */       if (this.observers.isEmpty()) {
/*     */         return;
/*     */       }
/*     */       
/*     */ 
/*  76 */       OnlineManager.getInstance().sendMulti(makeFightStart(), this.observers);
/*     */       
/*  78 */       int round = 0;
/*  79 */       for (Octets roundData : this.roundDataList)
/*     */       {
/*  81 */         OnlineManager.getInstance().sendMulti(makeFightRound(++round, roundData), this.observers);
/*     */       }
/*     */       
/*  84 */       OnlineManager.getInstance().sendMulti(makeFightEnd(), this.observers);
/*     */       
/*  86 */       this.observers.clear();
/*     */     }
/*     */     finally
/*     */     {
/*  90 */       this.rwLock.writeLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean isReady()
/*     */   {
/*  96 */     return this.ready;
/*     */   }
/*     */   
/*     */   public int trySyncFightRecordInfo(long observerid)
/*     */   {
/* 101 */     if (this.ready)
/*     */     {
/* 103 */       this.rwLock.readLock().lock();
/*     */       try
/*     */       {
/* 106 */         syncFightRecordInfo(observerid);
/*     */       }
/*     */       finally
/*     */       {
/* 110 */         this.rwLock.readLock().unlock();
/*     */       }
/*     */     }
/*     */     else
/*     */     {
/* 115 */       this.rwLock.writeLock().lock();
/*     */       try
/*     */       {
/* 118 */         if (this.ready)
/*     */         {
/* 120 */           syncFightRecordInfo(observerid);
/*     */ 
/*     */ 
/*     */         }
/* 124 */         else if (this.observers.add(Long.valueOf(observerid))) {
/*     */           int i;
/* 126 */           if (this.observers.size() == 1)
/*     */           {
/* 128 */             return 0;
/*     */           }
/*     */           
/* 131 */           return -1;
/*     */         }
/*     */         
/*     */       }
/*     */       finally
/*     */       {
/* 137 */         this.rwLock.writeLock().unlock();
/*     */       }
/*     */     }
/*     */     
/* 141 */     return 1;
/*     */   }
/*     */   
/*     */   private void syncFightRecordInfo(long observerid)
/*     */   {
/* 146 */     OnlineManager.getInstance().send(observerid, makeFightStart());
/*     */     
/* 148 */     int round = 0;
/* 149 */     for (Octets roundData : this.roundDataList)
/*     */     {
/* 151 */       OnlineManager.getInstance().send(observerid, makeFightRound(++round, roundData));
/*     */     }
/*     */     
/* 154 */     OnlineManager.getInstance().send(observerid, makeFightEnd());
/*     */   }
/*     */   
/*     */   private final SSyncRealtimeRecordEnterFight makeFightStart()
/*     */   {
/* 159 */     SSyncRealtimeRecordEnterFight syncRealtimeRecordEnterFight = new SSyncRealtimeRecordEnterFight();
/* 160 */     syncRealtimeRecordEnterFight.recordid = this.recordid;
/* 161 */     syncRealtimeRecordEnterFight.rounds = this.roundDataList.size();
/* 162 */     syncRealtimeRecordEnterFight.enter_fight_content = this.startData;
/* 163 */     syncRealtimeRecordEnterFight.is_realtime = 0;
/* 164 */     return syncRealtimeRecordEnterFight;
/*     */   }
/*     */   
/*     */   private final SSyncRealtimeRecordFightEnd makeFightEnd()
/*     */   {
/* 169 */     SSyncRealtimeRecordFightEnd syncRealtimeRecordFightEnd = new SSyncRealtimeRecordFightEnd();
/* 170 */     syncRealtimeRecordFightEnd.recordid = this.recordid;
/* 171 */     syncRealtimeRecordFightEnd.fight_end_content = this.endData;
/* 172 */     return syncRealtimeRecordFightEnd;
/*     */   }
/*     */   
/*     */   private final SSyncRealtimeRecordRoundPlay makeFightRound(int round, Octets roundData)
/*     */   {
/* 177 */     SSyncRealtimeRecordRoundPlay syncRealtimeRecordRoundPlay = new SSyncRealtimeRecordRoundPlay();
/* 178 */     syncRealtimeRecordRoundPlay.recordid = this.recordid;
/* 179 */     syncRealtimeRecordRoundPlay.round = round;
/* 180 */     syncRealtimeRecordRoundPlay.round_play_content = roundData;
/*     */     
/* 182 */     return syncRealtimeRecordRoundPlay;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\main\RoamFightRecorderCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */