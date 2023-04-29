/*     */ package mzm.gsp.crosscompete.roam;
/*     */ 
/*     */ import java.util.concurrent.locks.Lock;
/*     */ import java.util.concurrent.locks.ReadWriteLock;
/*     */ import java.util.concurrent.locks.ReentrantReadWriteLock;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class RoamEnterRole
/*     */ {
/*     */   public final long roleid;
/*     */   public final String userid;
/*  15 */   private boolean bDataPrepared = false;
/*  16 */   private boolean bLogin = false;
/*  17 */   private boolean bTeamRestore = false;
/*  18 */   private boolean bKicked = false;
/*     */   
/*  20 */   private ReadWriteLock lock = new ReentrantReadWriteLock();
/*     */   
/*     */   public RoamEnterRole(long roleid, String userid) {
/*  23 */     this.roleid = roleid;
/*  24 */     this.userid = userid;
/*     */   }
/*     */   
/*     */   public boolean isLogin() {
/*  28 */     this.lock.readLock().lock();
/*     */     try {
/*  30 */       return this.bLogin;
/*     */     } finally {
/*  32 */       this.lock.readLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean setLogin() {
/*  37 */     this.lock.writeLock().lock();
/*     */     try { boolean bool;
/*  39 */       if (this.bKicked) {
/*  40 */         return false;
/*     */       }
/*  42 */       this.bLogin = true;
/*  43 */       return true;
/*     */     } finally {
/*  45 */       this.lock.writeLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean isDataPrepared() {
/*  50 */     this.lock.readLock().lock();
/*     */     try {
/*  52 */       return this.bDataPrepared;
/*     */     } finally {
/*  54 */       this.lock.readLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean setDataPrepared() {
/*  59 */     this.lock.writeLock().lock();
/*     */     try { boolean bool;
/*  61 */       if (this.bKicked) {
/*  62 */         return false;
/*     */       }
/*  64 */       this.bDataPrepared = true;
/*  65 */       return true;
/*     */     } finally {
/*  67 */       this.lock.writeLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean isTeamRestore() {
/*  72 */     this.lock.readLock().lock();
/*     */     try {
/*  74 */       return this.bTeamRestore;
/*     */     } finally {
/*  76 */       this.lock.readLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean setTeamRestore() {
/*  81 */     this.lock.writeLock().lock();
/*     */     try { boolean bool;
/*  83 */       if (this.bKicked) {
/*  84 */         return false;
/*     */       }
/*  86 */       this.bTeamRestore = true;
/*  87 */       return true;
/*     */     } finally {
/*  89 */       this.lock.writeLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean setKicked() {
/*  94 */     this.lock.writeLock().lock();
/*     */     try { boolean bool;
/*  96 */       if (this.bLogin) {
/*  97 */         return false;
/*     */       }
/*  99 */       this.bKicked = true;
/* 100 */       return true;
/*     */     } finally {
/* 102 */       this.lock.writeLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean isKicked() {
/* 107 */     this.lock.readLock().lock();
/*     */     try {
/* 109 */       return this.bKicked;
/*     */     } finally {
/* 111 */       this.lock.readLock().unlock();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crosscompete\roam\RoamEnterRole.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */