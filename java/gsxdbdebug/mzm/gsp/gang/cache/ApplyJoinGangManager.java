/*     */ package mzm.gsp.gang.cache;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Random;
/*     */ import java.util.concurrent.locks.Lock;
/*     */ import java.util.concurrent.locks.ReentrantLock;
/*     */ import mzm.gsp.gang.confbean.SGangConst;
/*     */ import mzm.gsp.gang.main.GangManager;
/*     */ import xdb.Xdb;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ApplyJoinGangManager
/*     */ {
/*     */   private final ArrayList<Bucket> buckets;
/*     */   private final long refreshTime;
/*  22 */   private static volatile ApplyJoinGangManager instance = new ApplyJoinGangManager();
/*     */   
/*     */   public static ApplyJoinGangManager getInstance()
/*     */   {
/*  26 */     return instance;
/*     */   }
/*     */   
/*     */   private static void setInstance(ApplyJoinGangManager instance) {
/*  30 */     instance = instance;
/*     */   }
/*     */   
/*     */   public static void setInstance(ArrayList<ArrayList<Long>> weightGangs, ArrayList<Integer> weights, long refreshTime) {
/*  34 */     ApplyJoinGangManager ins = new ApplyJoinGangManager(weightGangs, weights, refreshTime);
/*  35 */     setInstance(ins);
/*     */   }
/*     */   
/*     */   private ApplyJoinGangManager()
/*     */   {
/*  40 */     this.buckets = new ArrayList();
/*  41 */     this.refreshTime = 0L;
/*     */   }
/*     */   
/*     */   private ApplyJoinGangManager(ArrayList<ArrayList<Long>> weightGangs, ArrayList<Integer> weights, long refreshTime) {
/*  45 */     Iterator<ArrayList<Long>> gangsIter = weightGangs.iterator();
/*  46 */     Iterator<Integer> weightIter = weights.iterator();
/*     */     
/*  48 */     this.buckets = new ArrayList();
/*  49 */     while ((gangsIter.hasNext()) && (weightIter.hasNext())) {
/*  50 */       ArrayList<Long> gangs = (ArrayList)gangsIter.next();
/*  51 */       int weight = ((Integer)weightIter.next()).intValue();
/*     */       
/*  53 */       Bucket bucket = new Bucket(weight, gangs);
/*  54 */       this.buckets.add(bucket);
/*     */     }
/*     */     
/*  57 */     this.refreshTime = refreshTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean needRefresh(long nowMillis)
/*     */   {
/*  67 */     return this.refreshTime + SGangConst.getInstance().applyRandomRefreshSeconds * 1000L < nowMillis;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public List<Long> getRandomApplyGangs(int count)
/*     */   {
/*  77 */     List<Long> applyGangs = new ArrayList();
/*  78 */     ArrayList<Integer> randomNumbers = getRandomApplyNumbers(count);
/*     */     
/*  80 */     Iterator<Integer> numberIter = randomNumbers.iterator();
/*  81 */     Iterator<Bucket> bucketIter = this.buckets.iterator();
/*     */     
/*  83 */     while ((numberIter.hasNext()) && (bucketIter.hasNext())) {
/*  84 */       int number = ((Integer)numberIter.next()).intValue();
/*  85 */       Bucket bucket = (Bucket)bucketIter.next();
/*     */       
/*  87 */       if (number > 0) {
/*  88 */         bucket.fillRandomGangs(applyGangs, number);
/*     */       }
/*     */     }
/*     */     
/*  92 */     if (GangManager.isDebugLogEnabled()) {
/*  93 */       GangManager.logDebug("GangCacheManager.getRandomApplyGangs@random apply gangs|count=%d|gangs=%s", new Object[] { Integer.valueOf(count), applyGangs });
/*     */     }
/*     */     
/*  96 */     return applyGangs;
/*     */   }
/*     */   
/*     */   private ArrayList<Integer> getRandomApplyNumbers(int count)
/*     */   {
/* 101 */     ArrayList<Integer> randomNumbers = new ArrayList();
/* 102 */     ArrayList<Integer> sizes = new ArrayList();
/*     */     
/* 104 */     ArrayList<Integer> weights = new ArrayList();
/* 105 */     ArrayList<Integer> indexes = new ArrayList();
/*     */     
/* 107 */     int sumWeight = 0;
/* 108 */     for (int i = 0; i < this.buckets.size(); i++) {
/* 109 */       Bucket bucket = (Bucket)this.buckets.get(i);
/* 110 */       int gangSize = bucket.getGangSize();
/* 111 */       sizes.add(Integer.valueOf(gangSize));
/* 112 */       randomNumbers.add(Integer.valueOf(0));
/*     */       
/* 114 */       if (gangSize > 0) {
/* 115 */         int w = bucket.getWeight();
/* 116 */         sumWeight += w;
/* 117 */         weights.add(Integer.valueOf(sumWeight));
/* 118 */         indexes.add(Integer.valueOf(i));
/*     */       }
/*     */     }
/*     */     
/* 122 */     while ((count > 0) && (sumWeight > 0)) {
/* 123 */       int r = Xdb.random().nextInt(sumWeight);
/*     */       
/* 125 */       for (int i = 0; i < weights.size(); i++) {
/* 126 */         int weight = ((Integer)weights.get(i)).intValue();
/* 127 */         if (r < weight) {
/* 128 */           int selectIndex = ((Integer)indexes.get(i)).intValue();
/* 129 */           randomNumbers.set(selectIndex, Integer.valueOf(((Integer)randomNumbers.get(selectIndex)).intValue() + 1));
/*     */           
/* 131 */           int size = ((Integer)sizes.get(selectIndex)).intValue();
/* 132 */           size--;
/* 133 */           if (size <= 0) {
/* 134 */             int minus = 0;
/* 135 */             if (i == 0) {
/* 136 */               minus = ((Integer)weights.get(0)).intValue();
/*     */             }
/*     */             else {
/* 139 */               minus = ((Integer)weights.get(i)).intValue() - ((Integer)weights.get(i - 1)).intValue();
/*     */             }
/* 141 */             for (int j = i + 1; j < indexes.size(); j++) {
/* 142 */               weights.set(j - 1, Integer.valueOf(((Integer)weights.get(j)).intValue() - minus));
/*     */             }
/* 144 */             weights.remove(weights.size() - 1);
/* 145 */             indexes.remove(i);
/* 146 */             sumWeight -= minus;
/* 147 */             break;
/*     */           }
/* 149 */           sizes.set(selectIndex, Integer.valueOf(size));
/*     */           
/*     */ 
/* 152 */           break;
/*     */         }
/*     */         
/* 155 */         if (i == weights.size() - 1) {
/* 156 */           GangManager.logError("ApplyJoinGangManager.getRandomApplyNumbers@random error, random greater than sum_weight|sum_weight=%d|random=%d", new Object[] { Integer.valueOf(sumWeight), Integer.valueOf(r) });
/*     */         }
/*     */       }
/*     */       
/*     */ 
/*     */ 
/* 162 */       count--;
/*     */     }
/*     */     
/* 165 */     if (GangManager.isDebugLogEnabled()) {
/* 166 */       ArrayList<Integer> tmpSizes = new ArrayList();
/* 167 */       ArrayList<Integer> tmpWeights = new ArrayList();
/*     */       
/* 169 */       for (int i = 0; i < this.buckets.size(); i++) {
/* 170 */         Bucket bucket = (Bucket)this.buckets.get(i);
/* 171 */         tmpSizes.add(Integer.valueOf(bucket.getGangSize()));
/* 172 */         tmpWeights.add(Integer.valueOf(bucket.getWeight()));
/*     */       }
/*     */       
/* 175 */       GangManager.logDebug("ApplyJoinGangManager.getRandomApplyNumbers@random numbers|sizes=%s|weights=%s|numbers=%s", new Object[] { tmpSizes, tmpWeights, randomNumbers });
/*     */     }
/*     */     
/*     */ 
/* 179 */     return randomNumbers;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 185 */     StringBuilder sb = new StringBuilder();
/* 186 */     sb.append("buckets=").append(this.buckets).append(",refreshTime=").append(this.refreshTime);
/* 187 */     return sb.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   private static class Bucket
/*     */   {
/*     */     private final int weight;
/*     */     
/*     */     private final ArrayList<Long> gangs;
/*     */     private int cursor;
/* 197 */     private Lock lock = new ReentrantLock();
/*     */     
/*     */     Bucket(int weight, ArrayList<Long> gangs) {
/* 200 */       this.weight = weight;
/* 201 */       this.gangs = gangs;
/* 202 */       this.cursor = 0;
/*     */     }
/*     */     
/*     */     void fillRandomGangs(List<Long> randomGangs, int count) {
/* 206 */       if (count <= 0) {
/* 207 */         return;
/*     */       }
/* 209 */       if (count > this.gangs.size()) {
/* 210 */         count = this.gangs.size();
/*     */       }
/* 212 */       int begin = 0;
/*     */       
/* 214 */       this.lock.lock();
/*     */       try {
/* 216 */         begin = this.cursor;
/* 217 */         this.cursor += count;
/* 218 */         if (this.cursor >= this.gangs.size()) {
/* 219 */           this.cursor %= this.gangs.size();
/*     */         }
/*     */       } finally {
/* 222 */         this.lock.unlock();
/*     */       }
/*     */       
/* 225 */       for (int i = 0; i < count; i++) {
/* 226 */         int index = (begin + i) % this.gangs.size();
/* 227 */         randomGangs.add(this.gangs.get(index));
/*     */       }
/*     */     }
/*     */     
/*     */     int getGangSize() {
/* 232 */       return this.gangs.size();
/*     */     }
/*     */     
/*     */     int getWeight() {
/* 236 */       return this.weight;
/*     */     }
/*     */     
/*     */     public String toString()
/*     */     {
/* 241 */       StringBuilder sb = new StringBuilder();
/* 242 */       sb.append("[weight=").append(this.weight).append(",gangs=").append(this.gangs).append(",cursor=");
/*     */       
/* 244 */       this.lock.lock();
/*     */       try {
/* 246 */         sb.append(this.cursor);
/*     */       } finally {
/* 248 */         this.lock.unlock();
/*     */       }
/*     */       
/* 251 */       sb.append("]");
/*     */       
/* 253 */       return sb.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\cache\ApplyJoinGangManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */