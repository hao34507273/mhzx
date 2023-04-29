/*     */ package mzm.gsp.idip.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.LinkedList;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import java.util.concurrent.locks.Lock;
/*     */ import java.util.concurrent.locks.ReadWriteLock;
/*     */ import mzm.gsp.idip.ItemSwitchInfo;
/*     */ import mzm.gsp.idip.SyncItemSwitches;
/*     */ 
/*     */ public class ItemHideCache
/*     */ {
/*  16 */   private static final ItemHideCache instance = new ItemHideCache();
/*     */   
/*     */   public static ItemHideCache getInstance()
/*     */   {
/*  20 */     return instance;
/*     */   }
/*     */   
/*  23 */   private final Map<Integer, Set<Integer>> hideItems = new HashMap();
/*  24 */   private final ReadWriteLock rwLock = new java.util.concurrent.locks.ReentrantReadWriteLock();
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
/*     */   public void fillInfos(SyncItemSwitches msg)
/*     */   {
/*  38 */     this.rwLock.readLock().lock();
/*     */     try
/*     */     {
/*  41 */       for (Map.Entry<Integer, Set<Integer>> entry : this.hideItems.entrySet())
/*     */       {
/*  43 */         itemType = ((Integer)entry.getKey()).intValue();
/*  44 */         for (i$ = ((Set)entry.getValue()).iterator(); i$.hasNext();) { int cfgid = ((Integer)i$.next()).intValue();
/*     */           
/*  46 */           ItemSwitchInfo info = new ItemSwitchInfo();
/*  47 */           info.cfgid = cfgid;
/*  48 */           info.item_type = itemType;
/*  49 */           info.isopen = 0;
/*  50 */           msg.infos.add(info);
/*     */         }
/*     */       }
/*     */     } finally {
/*     */       int itemType;
/*     */       Iterator i$;
/*  56 */       this.rwLock.readLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean put(int itemType, int cfgid)
/*     */   {
/*  62 */     this.rwLock.writeLock().lock();
/*     */     try
/*     */     {
/*  65 */       Set<Integer> cfgids = (Set)this.hideItems.get(Integer.valueOf(itemType));
/*  66 */       if (cfgids == null)
/*     */       {
/*  68 */         cfgids = new java.util.HashSet();
/*  69 */         this.hideItems.put(Integer.valueOf(itemType), cfgids);
/*     */       }
/*  71 */       return cfgids.add(Integer.valueOf(cfgid));
/*     */     }
/*     */     finally
/*     */     {
/*  75 */       this.rwLock.writeLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean remove(int itemType, int cfgid)
/*     */   {
/*  81 */     this.rwLock.writeLock().lock();
/*     */     try
/*     */     {
/*  84 */       Set<Integer> cfgids = (Set)this.hideItems.get(Integer.valueOf(itemType));
/*  85 */       boolean bool; if (cfgids == null)
/*     */       {
/*  87 */         return false;
/*     */       }
/*  89 */       return cfgids.remove(Integer.valueOf(cfgid));
/*     */     }
/*     */     finally
/*     */     {
/*  93 */       this.rwLock.writeLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean isHide(int itemType, int cfgid)
/*     */   {
/*  99 */     this.rwLock.readLock().lock();
/*     */     try
/*     */     {
/* 102 */       Set<Integer> cfgids = (Set)this.hideItems.get(Integer.valueOf(itemType));
/* 103 */       boolean bool; if (cfgids == null)
/*     */       {
/* 105 */         return false;
/*     */       }
/* 107 */       return cfgids.contains(Integer.valueOf(cfgid));
/*     */     }
/*     */     finally
/*     */     {
/* 111 */       this.rwLock.readLock().unlock();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\idip\main\ItemHideCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */