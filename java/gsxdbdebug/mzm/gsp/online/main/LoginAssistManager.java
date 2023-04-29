/*     */ package mzm.gsp.online.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.LinkedHashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import java.util.concurrent.locks.Lock;
/*     */ import java.util.concurrent.locks.ReadWriteLock;
/*     */ import java.util.concurrent.locks.ReentrantReadWriteLock;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.timer.main.Observer;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.LogicRunnable;
/*     */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*     */ import org.apache.log4j.Logger;
/*     */ import xdb.Executor;
/*     */ import xdb.Xdb;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class LoginAssistManager
/*     */ {
/*  26 */   private static final LoginAssistManager instance = new LoginAssistManager();
/*     */   
/*  28 */   private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
/*     */   
/*     */ 
/*  31 */   private Map<String, Long> protectMap = new LinkedHashMap()
/*     */   {
/*     */     private static final long serialVersionUID = -3L;
/*     */     
/*     */     protected boolean removeEldestEntry(Map.Entry<String, Long> eldest)
/*     */     {
/*  37 */       if (size() > LoginManager.getInstance().getMaxPlayerNumber()) {
/*  38 */         return true;
/*     */       }
/*  40 */       return false;
/*     */     }
/*     */   };
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  47 */   private Map<String, Map<Integer, Set<Integer>>> excuteLoginUser = new LinkedHashMap()
/*     */   {
/*     */     private static final long serialVersionUID = -1L;
/*     */     
/*     */     protected boolean removeEldestEntry(Map.Entry<String, Map<Integer, Set<Integer>>> eldest) {
/*  52 */       if (size() > LoginManager.getInstance().getMaxPlayerNumber()) {
/*  53 */         return true;
/*     */       }
/*  55 */       return false;
/*     */     }
/*     */   };
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  62 */   Map<String, Map<Integer, Set<Integer>>> excuteProtectMap = new HashMap();
/*     */   private LoginProtectObserver protectObserver;
/*     */   
/*     */   public static LoginAssistManager getInstance()
/*     */   {
/*  67 */     return instance;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void initObserver(int secends)
/*     */   {
/*  75 */     if (this.protectObserver != null) {
/*  76 */       this.protectObserver.stopTimer();
/*     */     }
/*  78 */     this.protectObserver = new LoginProtectObserver(secends);
/*     */   }
/*     */   
/*     */   public void gm_setLoginProtectSec(int secends) {
/*  82 */     LoginArgs.getInstance().loginProtectMil = (secends * 1000);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void gm_clear()
/*     */   {
/*  89 */     this.readWriteLock.writeLock().lock();
/*     */     try {
/*  91 */       this.protectMap.clear();
/*     */     }
/*     */     catch (Exception e) {}finally {
/*  94 */       this.readWriteLock.writeLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   public int getProtectSize() {
/*  99 */     this.readWriteLock.readLock().lock();
/*     */     try {
/* 101 */       return this.protectMap.size();
/*     */     }
/*     */     catch (Exception e) {}finally {
/* 104 */       this.readWriteLock.readLock().unlock();
/*     */     }
/* 106 */     return 0;
/*     */   }
/*     */   
/*     */   public boolean isInLoginProtect(String userid) {
/* 110 */     this.readWriteLock.readLock().lock();
/*     */     try {
/* 112 */       return this.protectMap.containsKey(userid);
/*     */     }
/*     */     catch (Exception e) {}finally {
/* 115 */       this.readWriteLock.readLock().unlock();
/*     */     }
/* 117 */     return false;
/*     */   }
/*     */   
/*     */   public void addProtectUser(String userid) {
/* 121 */     long curTimeMil = DateTimeUtils.getCurrTimeInMillis();
/* 122 */     this.readWriteLock.writeLock().lock();
/*     */     try {
/* 124 */       this.protectMap.put(userid, Long.valueOf(curTimeMil + LoginArgs.getInstance().loginProtectMil));
/*     */     }
/*     */     catch (Exception e) {}finally {
/* 127 */       this.readWriteLock.writeLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   public void addProtectUser(String userid, long endTimeMills) {
/* 132 */     this.readWriteLock.writeLock().lock();
/*     */     try {
/* 134 */       this.protectMap.put(userid, Long.valueOf(endTimeMills));
/*     */     }
/*     */     catch (Exception e) {}finally {
/* 137 */       this.readWriteLock.writeLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   public void remProtectUserOnLoginSuc(String userid) {
/* 142 */     this.readWriteLock.writeLock().lock();
/*     */     try {
/* 144 */       this.protectMap.remove(userid);
/* 145 */       this.excuteProtectMap.remove(userid);
/*     */     }
/*     */     catch (Exception e) {}finally {
/* 148 */       this.readWriteLock.writeLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   private class LoginProtectObserver extends Observer
/*     */   {
/*     */     public LoginProtectObserver(long intervalSeconds) {
/* 155 */       super();
/*     */     }
/*     */     
/*     */     public boolean update()
/*     */     {
/* 160 */       Xdb.executor().execute(new LogicRunnable()
/*     */       {
/*     */         public void process() throws Exception
/*     */         {
/* 164 */           long curTimeMil = DateTimeUtils.getCurrTimeInMillis();
/* 165 */           LoginAssistManager.this.readWriteLock.writeLock().lock();
/*     */           try {
/* 167 */             Iterator<Map.Entry<String, Long>> iterator = LoginAssistManager.this.protectMap.entrySet().iterator();
/* 168 */             String userid; int linksid; Iterator i$; while (iterator.hasNext()) {
/* 169 */               Map.Entry<String, Long> entry = (Map.Entry)iterator.next();
/* 170 */               long timeMils = ((Long)entry.getValue()).longValue();
/* 171 */               userid = (String)entry.getKey();
/* 172 */               if (curTimeMil < timeMils) break;
/* 173 */               iterator.remove();
/* 174 */               Map<Integer, Set<Integer>> linksidToLinkidMap = (Map)LoginAssistManager.this.excuteProtectMap.remove(userid);
/* 175 */               if (linksidToLinkidMap != null) {
/* 176 */                 for (Map.Entry<Integer, Set<Integer>> tempEntry : linksidToLinkidMap.entrySet()) {
/* 177 */                   linksid = ((Integer)tempEntry.getKey()).intValue();
/* 178 */                   for (i$ = ((Set)tempEntry.getValue()).iterator(); i$.hasNext();) { int linkid = ((Integer)i$.next()).intValue();
/* 179 */                     LoginAssistManager.this._innerAddExcuteLoginMap(userid, linksid, linkid);
/*     */                   }
/*     */                   
/*     */                 }
/*     */                 
/*     */               }
/*     */             }
/*     */           }
/*     */           catch (Exception e) {}finally
/*     */           {
/* 189 */             LoginAssistManager.this.readWriteLock.writeLock().unlock();
/*     */           }
/*     */         }
/* 192 */       });
/* 193 */       return true;
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
/*     */   public void addProtectExcuteMap(String userid, int linksid, int linkid)
/*     */   {
/* 206 */     this.readWriteLock.writeLock().lock();
/*     */     try {
/* 208 */       Map<Integer, Set<Integer>> linksids = (Map)this.excuteProtectMap.get(userid);
/* 209 */       if (linksids == null) {
/* 210 */         linksids = new HashMap();
/* 211 */         this.excuteProtectMap.put(userid, linksids);
/*     */       }
/* 213 */       Set<Integer> linkids = (Set)linksids.get(Integer.valueOf(linksid));
/* 214 */       if (linkids == null) {
/* 215 */         linkids = new HashSet();
/* 216 */         linksids.put(Integer.valueOf(linksid), linkids);
/*     */       }
/* 218 */       linkids.add(Integer.valueOf(linkid));
/*     */     }
/*     */     catch (Exception e) {}finally {
/* 221 */       this.readWriteLock.writeLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void remProtectExcuteMap(String userid, int linksid, int linkid)
/*     */   {
/* 233 */     this.readWriteLock.writeLock().lock();
/*     */     try {
/* 235 */       Map<Integer, Set<Integer>> linksids = (Map)this.excuteProtectMap.get(userid);
/* 236 */       if (linksids == null) {
/*     */         return;
/*     */       }
/* 239 */       Set<Integer> linkids = (Set)linksids.get(Integer.valueOf(linksid));
/* 240 */       if (linkids != null) {
/* 241 */         linkids.remove(Integer.valueOf(linkid));
/* 242 */         if (linkids.size() <= 0) {
/* 243 */           linksids.remove(Integer.valueOf(linksid));
/*     */         }
/*     */       }
/* 246 */       if (linksids.size() <= 0) {
/* 247 */         this.excuteProtectMap.remove(userid);
/*     */       }
/*     */     }
/*     */     catch (Exception e) {}finally {
/* 251 */       this.readWriteLock.writeLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean containsInExcuteQueue(String userid) {
/* 256 */     this.readWriteLock.readLock().lock();
/*     */     try {
/* 258 */       return this.excuteLoginUser.containsKey(userid);
/*     */     }
/*     */     catch (Exception e) {}finally {
/* 261 */       this.readWriteLock.readLock().unlock();
/*     */     }
/* 263 */     return false;
/*     */   }
/*     */   
/*     */   public int getExcuteLoginSize()
/*     */   {
/* 268 */     this.readWriteLock.readLock().lock();
/*     */     try {
/* 270 */       return this.excuteLoginUser.size();
/*     */     }
/*     */     catch (Exception e) {}finally {
/* 273 */       this.readWriteLock.readLock().unlock();
/*     */     }
/* 275 */     return 0;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   void gm_clearExcuteLoginQueue()
/*     */   {
/* 282 */     Map<String, Map<Integer, Set<Integer>>> copyLoginUserMap = new HashMap();
/*     */     
/* 284 */     this.readWriteLock.writeLock().lock();
/*     */     try {
/* 286 */       copyLoginUserMap.putAll(this.excuteLoginUser);
/* 287 */       this.excuteLoginUser.clear();
/*     */     }
/*     */     catch (Exception e) {}finally {
/* 290 */       this.readWriteLock.writeLock().unlock();
/*     */     }
/*     */     
/* 293 */     NoneRealTimeTaskManager.getInstance().addTask(new ClearLoginExctuteUser(copyLoginUserMap));
/*     */   }
/*     */   
/*     */   public boolean removeFormLoginExcuteQueue(String userid, int linksid, int linkid) {
/* 297 */     this.readWriteLock.writeLock().lock();
/* 298 */     boolean ret = false;
/*     */     try {
/* 300 */       Map<Integer, Set<Integer>> linksids = (Map)this.excuteLoginUser.get(userid);
/* 301 */       if (linksids == null) {
/* 302 */         return ret;
/*     */       }
/* 304 */       Object linkids = (Set)linksids.get(Integer.valueOf(linksid));
/* 305 */       if (linkids != null) {
/* 306 */         ret = ((Set)linkids).remove(Integer.valueOf(linkid));
/* 307 */         if (((Set)linkids).size() <= 0) {
/* 308 */           linksids.remove(Integer.valueOf(linksid));
/*     */         }
/*     */       }
/* 311 */       if (linksids.size() <= 0) {
/* 312 */         this.excuteLoginUser.remove(userid);
/*     */       }
/* 314 */       if (GameServer.logger().isDebugEnabled()) {
/* 315 */         GameServer.logger().debug(String.format("[Login]LoginManager.removeFormExcuteQueue@now excuteLoginUser size|size=%d|useid=%s|linksid=%d|linkid=%d", new Object[] { Integer.valueOf(this.excuteLoginUser.size()), userid, Integer.valueOf(linksid), Integer.valueOf(linkid) }));
/*     */       }
/*     */       
/*     */ 
/*     */     }
/*     */     catch (Exception e) {}finally
/*     */     {
/* 322 */       this.readWriteLock.writeLock().unlock();
/*     */     }
/* 324 */     return ret;
/*     */   }
/*     */   
/*     */   void addExcuteLoginMap(String userid, int linksid, int linkid) {
/* 328 */     this.readWriteLock.writeLock().lock();
/*     */     try {
/* 330 */       _innerAddExcuteLoginMap(userid, linksid, linkid);
/*     */     }
/*     */     catch (Exception e) {}finally {
/* 333 */       this.readWriteLock.writeLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void _innerAddExcuteLoginMap(String userid, int linksid, int linkid)
/*     */   {
/* 345 */     Map<Integer, Set<Integer>> linksids = (Map)this.excuteLoginUser.get(userid);
/* 346 */     if (linksids == null) {
/* 347 */       linksids = new HashMap();
/* 348 */       this.excuteLoginUser.put(userid, linksids);
/*     */     }
/* 350 */     Set<Integer> linkids = (Set)linksids.get(Integer.valueOf(linksid));
/* 351 */     if (linkids == null) {
/* 352 */       linkids = new HashSet();
/* 353 */       linksids.put(Integer.valueOf(linksid), linkids);
/*     */     }
/* 355 */     linkids.add(Integer.valueOf(linkid));
/* 356 */     if (GameServer.logger().isDebugEnabled()) {
/* 357 */       GameServer.logger().debug(String.format("[Login]LoginManager.addExcuteLoginQueue@now excuteLoginUser size|size=%d|useid=%s|linksid=%d|linkid=%d", new Object[] { Integer.valueOf(this.excuteLoginUser.size()), userid, Integer.valueOf(linksid), Integer.valueOf(linkid) }));
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
/*     */   public boolean isInOwnLogin(String userid)
/*     */   {
/* 371 */     this.readWriteLock.readLock().lock();
/*     */     try {
/* 373 */       return (this.excuteLoginUser.containsKey(userid)) || (this.protectMap.containsKey(userid));
/*     */     }
/*     */     catch (Exception e) {}finally {
/* 376 */       this.readWriteLock.readLock().unlock();
/*     */     }
/* 378 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   int getOwnLoginSize()
/*     */   {
/* 387 */     this.readWriteLock.readLock().lock();
/*     */     try {
/* 389 */       return this.excuteLoginUser.size() + this.protectMap.size();
/*     */     }
/*     */     catch (Exception e) {}finally {
/* 392 */       this.readWriteLock.readLock().unlock();
/*     */     }
/* 394 */     return 0;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\online\main\LoginAssistManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */