/*     */ package mzm.gsp.award.gem;
/*     */ 
/*     */ import java.util.Random;
/*     */ import java.util.concurrent.locks.Lock;
/*     */ import java.util.concurrent.locks.ReentrantLock;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.award.confbean.STGemTable;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ import xdb.Xdb;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ItemCountInfo
/*     */ {
/*     */   private long _gemKey;
/*     */   private int _count;
/*     */   private int _awardNum;
/*     */   private long _startTime;
/*     */   private boolean _isAwarded;
/*     */   private int _curCircle;
/*  28 */   private final Lock locker = new ReentrantLock();
/*     */   
/*     */   public ItemCountInfo(long gemKey)
/*     */   {
/*  32 */     this._gemKey = gemKey;
/*  33 */     this._isAwarded = false;
/*  34 */     this._startTime = DateTimeUtils.getCurrTimeInMillis();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   CountInfoCopy getSnapshot()
/*     */   {
/*  44 */     this.locker.lock();
/*     */     try
/*     */     {
/*  47 */       return new CountInfoCopy(this._gemKey, this._count, this._awardNum, this._startTime, this._isAwarded, this._curCircle);
/*     */     }
/*     */     finally
/*     */     {
/*  51 */       this.locker.unlock();
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
/*     */   void init(long gemKey, int count, int awardNum, long startTime, boolean isAward, int curCircle)
/*     */   {
/*  66 */     this.locker.lock();
/*     */     try
/*     */     {
/*  69 */       this._gemKey = gemKey;
/*  70 */       this._count = count;
/*  71 */       this._awardNum = awardNum;
/*  72 */       this._startTime = startTime;
/*  73 */       this._isAwarded = isAward;
/*  74 */       this._curCircle = curCircle;
/*     */     }
/*     */     finally
/*     */     {
/*  78 */       this.locker.unlock();
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
/*     */   AddCountRes addCount(STGemTable cfg, boolean canAward)
/*     */   {
/*  96 */     long nowMillis = DateTimeUtils.getCurrTimeInMillis();
/*     */     
/*  98 */     this.locker.lock();
/*     */     try
/*     */     {
/* 101 */       checkCfgAndReset(cfg, nowMillis);
/* 102 */       int countMax = getCountUp(cfg, this._curCircle);
/*     */       
/* 104 */       boolean needAward = false;
/* 105 */       if (canAward)
/*     */       {
/* 107 */         needAward = needAward(cfg, this._awardNum, this._count, this._curCircle, this._isAwarded);
/*     */       }
/*     */       
/* 110 */       if (needAward)
/*     */       {
/* 112 */         this._isAwarded = true;
/* 113 */         this._awardNum += 1;
/*     */       }
/* 115 */       this._count += 1;
/*     */       
/* 117 */       if (this._count >= countMax)
/*     */       {
/* 119 */         resetCount();
/*     */       }
/*     */       
/* 122 */       return new AddCountRes(this._gemKey, this._count, this._awardNum, this._startTime, this._isAwarded, this._curCircle, needAward);
/*     */     }
/*     */     finally
/*     */     {
/* 126 */       this.locker.unlock();
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
/*     */   private void checkCfgAndReset(STGemTable cfg, long nowMillis)
/*     */   {
/* 145 */     if (needResetCycle(this._startTime, cfg.cycle, nowMillis))
/*     */     {
/* 147 */       resetCycle(nowMillis);
/*     */     }
/* 149 */     int countMax = getCountUp(cfg, this._curCircle);
/* 150 */     if (this._count >= countMax)
/*     */     {
/* 152 */       resetCount();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void resetCount()
/*     */   {
/* 163 */     this._count = 0;
/* 164 */     this._isAwarded = false;
/* 165 */     int oldCircle = this._curCircle;
/* 166 */     this._curCircle = (oldCircle + 1);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void resetCycle(long nowMillis)
/*     */   {
/* 178 */     this._count = 0;
/* 179 */     this._awardNum = 0;
/* 180 */     this._isAwarded = false;
/* 181 */     this._startTime = nowMillis;
/* 182 */     this._curCircle = 0;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   long getInterval(int cycle)
/*     */   {
/* 194 */     return cycle * 86400000L;
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
/*     */   long getEndTime(long startTime, int cycle)
/*     */   {
/* 208 */     return startTime + getInterval(cycle);
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
/*     */   boolean needResetCycle(long startTime, int cycle, long curTime)
/*     */   {
/* 224 */     return curTime > getEndTime(startTime, cycle);
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
/*     */   boolean needAward(STGemTable cfg, int alAwardNum, int curCount, int curCircle, boolean isAward)
/*     */   {
/* 242 */     if (isAward)
/*     */     {
/* 244 */       return false;
/*     */     }
/* 246 */     if (alAwardNum >= cfg.awardMax)
/*     */     {
/* 248 */       return false;
/*     */     }
/* 250 */     return needAward(getLeftCount(cfg, alAwardNum, curCount, curCircle));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean needAward(int leftCount)
/*     */   {
/* 262 */     if (leftCount <= 0)
/*     */     {
/* 264 */       GameServer.logger().error(String.format("[awardGem]ItemCountInfo.needAward@ leftcount is zero!", new Object[0]));
/* 265 */       return false;
/*     */     }
/* 267 */     return Xdb.random().nextInt(leftCount) == 0;
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
/*     */   static int getLeftCount(STGemTable cfg, int alAwardNum, int curCount, int curCircle)
/*     */   {
/* 283 */     return getCountUp(cfg, curCircle) - curCount;
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
/*     */   static int getCountUp(STGemTable cfg, int curCircle)
/*     */   {
/* 296 */     return curCircle <= 0 ? cfg.littleCount : cfg.bigCount;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\award\gem\ItemCountInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */