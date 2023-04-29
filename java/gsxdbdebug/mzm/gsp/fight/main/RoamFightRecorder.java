/*     */ package mzm.gsp.fight.main;
/*     */ 
/*     */ import com.goldhuman.Common.Octets;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashSet;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import java.util.TreeMap;
/*     */ import java.util.concurrent.locks.Lock;
/*     */ import java.util.concurrent.locks.ReentrantLock;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.fight.SSyncRealtimeRecordEnterFight;
/*     */ import mzm.gsp.fight.SSyncRealtimeRecordFightEnd;
/*     */ import mzm.gsp.fight.SSyncRealtimeRecordRoundInfo;
/*     */ import mzm.gsp.fight.SSyncRealtimeRecordRoundPlay;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ class RoamFightRecorder
/*     */ {
/*  23 */   private final Lock lock = new ReentrantLock();
/*     */   
/*     */   private final long recordid;
/*  26 */   private final Set<Long> observers = new HashSet();
/*     */   
/*  28 */   private int notifyRound = 0;
/*  29 */   private int round = 0;
/*     */   
/*     */   private Octets startData;
/*     */   private Octets endData;
/*  33 */   private final Map<Integer, Octets> roundDataMap = new TreeMap();
/*     */   
/*  35 */   private volatile boolean dirty = false;
/*     */   
/*     */   RoamFightRecorder(long recordid)
/*     */   {
/*  39 */     this.recordid = recordid;
/*  40 */     this.notifyRound = 0;
/*  41 */     this.round = 0;
/*     */   }
/*     */   
/*     */   public void fightStart(Octets fightStart)
/*     */   {
/*  46 */     GameServer.logger().info(String.format("RoamFightRecorder.fightStart@receive fight start data|recordid=%d|round=%d|notify_round=%d", new Object[] { Long.valueOf(this.recordid), Integer.valueOf(this.round), Integer.valueOf(this.notifyRound) }));
/*     */     
/*     */ 
/*     */ 
/*  50 */     this.lock.lock();
/*     */     try
/*     */     {
/*  53 */       this.startData = fightStart;
/*     */       
/*  55 */       if (this.observers.isEmpty()) {
/*     */         return;
/*     */       }
/*     */       
/*     */ 
/*  60 */       OnlineManager.getInstance().sendMulti(makeFightStart(), this.observers);
/*     */     }
/*     */     finally
/*     */     {
/*  64 */       this.lock.unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean fightEnd(int maxRound, Octets fightEnd)
/*     */   {
/*  70 */     GameServer.logger().info(String.format("RoamFightRecorder.fightEnd@receive fight end data|recordid=%d|round=%d|notify_round=%d|max_round=%d", new Object[] { Long.valueOf(this.recordid), Integer.valueOf(this.round), Integer.valueOf(this.notifyRound), Integer.valueOf(maxRound) }));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*  75 */     this.lock.lock();
/*     */     try {
/*     */       boolean bool;
/*  78 */       if (doFightEnd(maxRound, fightEnd))
/*     */       {
/*  80 */         this.observers.clear();
/*  81 */         this.notifyRound = this.round;
/*     */         
/*  83 */         return true;
/*     */       }
/*     */       
/*  86 */       return false;
/*     */     }
/*     */     finally
/*     */     {
/*  90 */       this.lock.unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   private boolean doFightEnd(int maxRound, Octets fightEnd)
/*     */   {
/*  96 */     this.endData = fightEnd;
/*  97 */     this.round = maxRound;
/*     */     
/*  99 */     if (this.observers.isEmpty())
/*     */     {
/* 101 */       return true;
/*     */     }
/*     */     
/* 104 */     if (this.roundDataMap.size() == maxRound)
/*     */     {
/* 106 */       for (int i = this.notifyRound + 1; i <= maxRound; i++)
/*     */       {
/* 108 */         Octets roundData = (Octets)this.roundDataMap.get(Integer.valueOf(i));
/* 109 */         OnlineManager.getInstance().sendMulti(makeFightRound(i, roundData), this.observers);
/*     */       }
/* 111 */       OnlineManager.getInstance().sendMulti(makeFightEnd(), this.observers);
/*     */       
/* 113 */       return true;
/*     */     }
/*     */     
/* 116 */     this.dirty = true;
/* 117 */     List<Integer> noDataRounds = new ArrayList();
/* 118 */     for (int i = this.notifyRound + 1; i <= maxRound; i++)
/*     */     {
/* 120 */       if (!this.roundDataMap.containsKey(Integer.valueOf(i)))
/*     */       {
/* 122 */         noDataRounds.add(Integer.valueOf(i));
/*     */       }
/*     */     }
/*     */     
/* 126 */     GameServer.logger().warn(String.format("RoamFightRecorder.doFightEnd@record data is dirty|recordid=%d|round=%d|notify_round=%d|max_round=%d|no_data_rounds=%s", new Object[] { Long.valueOf(this.recordid), Integer.valueOf(this.round), Integer.valueOf(this.notifyRound), Integer.valueOf(maxRound), noDataRounds }));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 131 */     getRoundsData(noDataRounds);
/*     */     
/* 133 */     return false;
/*     */   }
/*     */   
/*     */   public void fightRound(int round, Octets roundData)
/*     */   {
/* 138 */     GameServer.logger().info(String.format("RoamFightRecorder.fightRound@receive round data|recordid=%d|round=%d|notify_round=%d|receive_round=%d", new Object[] { Long.valueOf(this.recordid), Integer.valueOf(this.round), Integer.valueOf(this.notifyRound), Integer.valueOf(round) }));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 143 */     this.lock.lock();
/*     */     
/*     */     try
/*     */     {
/* 147 */       this.roundDataMap.put(Integer.valueOf(round), roundData);
/*     */       
/*     */ 
/* 150 */       if (round < this.round)
/*     */       {
/* 152 */         if (!tryCleanDirty())
/*     */         {
/* 154 */           GameServer.logger().warn(String.format("RoamFightRecorder.fightRound@record data is still dirty|recordid=%d|round=%d|notify_round=%d|receive_round=%d", new Object[] { Long.valueOf(this.recordid), Integer.valueOf(this.round), Integer.valueOf(this.notifyRound), Integer.valueOf(round) }));
/*     */ 
/*     */         }
/*     */         
/*     */ 
/*     */ 
/*     */       }
/*     */       else
/*     */       {
/*     */ 
/* 164 */         int expectRound = this.round + 1;
/* 165 */         this.round = round;
/* 166 */         if (expectRound < this.round)
/*     */         {
/* 168 */           this.dirty = true;
/*     */           
/* 170 */           List<Integer> noDataRounds = new ArrayList();
/* 171 */           for (int i = expectRound; i < this.round; i++)
/*     */           {
/* 173 */             noDataRounds.add(Integer.valueOf(i));
/*     */           }
/*     */           
/* 176 */           GameServer.logger().warn(String.format("RoamFightRecorder.fightRound@record data is dirty|recordid=%d|round=%d|notify_round=%d|receive_round=%d|no_data_rounds=%s", new Object[] { Long.valueOf(this.recordid), Integer.valueOf(this.round), Integer.valueOf(this.notifyRound), Integer.valueOf(round), noDataRounds }));
/*     */           
/*     */ 
/*     */ 
/*     */ 
/* 181 */           getRoundsData(noDataRounds); return;
/*     */         }
/*     */       }
/*     */       
/*     */ 
/*     */ 
/* 187 */       if (this.round <= FightArgs.getInstance().roamFightRecordDelayNotifyRound)
/*     */       {
/* 189 */         if (this.observers.isEmpty()) {
/*     */           return;
/*     */         }
/*     */         
/*     */ 
/* 194 */         OnlineManager.getInstance().sendMulti(makeRoundInfo(), this.observers);
/*     */ 
/*     */       }
/*     */       else
/*     */       {
/* 199 */         this.notifyRound += 1;
/*     */         
/* 201 */         if (this.observers.isEmpty()) {
/*     */           return;
/*     */         }
/*     */         
/*     */ 
/* 206 */         Octets notifyRoundData = (Octets)this.roundDataMap.get(Integer.valueOf(this.notifyRound));
/* 207 */         if (notifyRoundData == null) {
/*     */           return;
/*     */         }
/*     */         
/* 211 */         OnlineManager.getInstance().sendMulti(makeFightRound(this.notifyRound, notifyRoundData), this.observers);
/*     */       }
/*     */     }
/*     */     finally {
/* 215 */       this.lock.unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   public AddObserverResult addObserver(long observerid)
/*     */   {
/* 221 */     this.lock.lock();
/*     */     try {
/*     */       AddObserverResult localAddObserverResult;
/* 224 */       if (this.endData != null)
/*     */       {
/* 226 */         return AddObserverResult.FightEnd;
/*     */       }
/*     */       
/* 229 */       if (this.dirty)
/*     */       {
/* 231 */         return AddObserverResult.RecordDataDirty;
/*     */       }
/*     */       
/* 234 */       if (!this.observers.add(Long.valueOf(observerid)))
/*     */       {
/* 236 */         return AddObserverResult.DuplicateAdd;
/*     */       }
/*     */       
/* 239 */       syncFightRecordInfo(observerid);
/*     */       
/* 241 */       return AddObserverResult.SUCCESS;
/*     */     }
/*     */     finally
/*     */     {
/* 245 */       this.lock.unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   public void onRoleLogin(long observerid)
/*     */   {
/* 251 */     this.lock.lock();
/*     */     try
/*     */     {
/* 254 */       if (this.round < 0) {
/*     */         return;
/*     */       }
/*     */       
/*     */ 
/* 259 */       if (!this.observers.contains(Long.valueOf(observerid))) {
/*     */         return;
/*     */       }
/*     */       
/*     */ 
/* 264 */       syncFightRecordInfo(observerid);
/*     */     }
/*     */     finally
/*     */     {
/* 268 */       this.lock.unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   public void onRoleLogoff(long observerid)
/*     */   {
/* 274 */     this.lock.lock();
/*     */     try
/*     */     {
/* 277 */       this.observers.remove(Long.valueOf(observerid));
/*     */     }
/*     */     finally
/*     */     {
/* 281 */       this.lock.unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   private void syncFightRecordInfo(long observerid)
/*     */   {
/* 287 */     if (this.startData == null)
/*     */     {
/* 289 */       return;
/*     */     }
/*     */     
/* 292 */     if (this.dirty)
/*     */     {
/* 294 */       return;
/*     */     }
/*     */     
/* 297 */     OnlineManager.getInstance().send(observerid, makeFightStart());
/*     */     
/* 299 */     if (this.round <= FightArgs.getInstance().roamFightRecordDelayNotifyRound)
/*     */     {
/* 301 */       OnlineManager.getInstance().send(observerid, makeRoundInfo());
/*     */       
/* 303 */       return;
/*     */     }
/*     */     
/* 306 */     for (int i = 1; i <= this.notifyRound; i++)
/*     */     {
/* 308 */       Octets roundData = (Octets)this.roundDataMap.get(Integer.valueOf(i));
/* 309 */       if (roundData != null)
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/* 314 */         OnlineManager.getInstance().send(observerid, makeFightRound(i, roundData));
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean removeObserver(long observerid) {
/* 320 */     this.lock.lock();
/*     */     try
/*     */     {
/* 323 */       return this.observers.remove(Long.valueOf(observerid));
/*     */     }
/*     */     finally
/*     */     {
/* 327 */       this.lock.unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   private final boolean tryCleanDirty()
/*     */   {
/* 333 */     for (int i = this.notifyRound + 1; i < this.round; i++)
/*     */     {
/* 335 */       if (!this.roundDataMap.containsKey(Integer.valueOf(i)))
/*     */       {
/* 337 */         return false;
/*     */       }
/*     */     }
/*     */     
/* 341 */     this.dirty = false;
/*     */     
/* 343 */     return true;
/*     */   }
/*     */   
/*     */   private final void getRoundsData(List<Integer> rounds)
/*     */   {
/* 348 */     if (rounds.isEmpty())
/*     */     {
/* 350 */       return;
/*     */     }
/*     */     
/* 353 */     GameServer.logger().warn(String.format("RoamFightRecorder.getRoundsData@try get rounds data|recordid=%d|round=%d|notify_round=%d|no_data_rounds=%s", new Object[] { Long.valueOf(this.recordid), Integer.valueOf(this.round), Integer.valueOf(this.notifyRound), rounds }));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private final SSyncRealtimeRecordRoundInfo makeRoundInfo()
/*     */   {
/* 362 */     SSyncRealtimeRecordRoundInfo syncRealtimeRecordRoundInfo = new SSyncRealtimeRecordRoundInfo();
/* 363 */     syncRealtimeRecordRoundInfo.recordid = this.recordid;
/* 364 */     syncRealtimeRecordRoundInfo.round = this.round;
/* 365 */     return syncRealtimeRecordRoundInfo;
/*     */   }
/*     */   
/*     */   private final SSyncRealtimeRecordEnterFight makeFightStart()
/*     */   {
/* 370 */     SSyncRealtimeRecordEnterFight syncRealtimeRecordEnterFight = new SSyncRealtimeRecordEnterFight();
/* 371 */     syncRealtimeRecordEnterFight.recordid = this.recordid;
/* 372 */     syncRealtimeRecordEnterFight.rounds = this.notifyRound;
/* 373 */     syncRealtimeRecordEnterFight.enter_fight_content = this.startData;
/* 374 */     syncRealtimeRecordEnterFight.is_realtime = 1;
/* 375 */     return syncRealtimeRecordEnterFight;
/*     */   }
/*     */   
/*     */   private final SSyncRealtimeRecordFightEnd makeFightEnd()
/*     */   {
/* 380 */     SSyncRealtimeRecordFightEnd syncRealtimeRecordFightEnd = new SSyncRealtimeRecordFightEnd();
/* 381 */     syncRealtimeRecordFightEnd.recordid = this.recordid;
/* 382 */     syncRealtimeRecordFightEnd.fight_end_content = this.endData;
/* 383 */     return syncRealtimeRecordFightEnd;
/*     */   }
/*     */   
/*     */   private final SSyncRealtimeRecordRoundPlay makeFightRound(int round, Octets roundData)
/*     */   {
/* 388 */     SSyncRealtimeRecordRoundPlay syncRealtimeRecordRoundPlay = new SSyncRealtimeRecordRoundPlay();
/* 389 */     syncRealtimeRecordRoundPlay.recordid = this.recordid;
/* 390 */     syncRealtimeRecordRoundPlay.round = round;
/* 391 */     syncRealtimeRecordRoundPlay.round_play_content = roundData;
/*     */     
/* 393 */     return syncRealtimeRecordRoundPlay;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\main\RoamFightRecorder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */