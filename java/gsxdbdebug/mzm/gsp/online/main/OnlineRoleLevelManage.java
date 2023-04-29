/*     */ package mzm.gsp.online.main;
/*     */ 
/*     */ import com.goldhuman.Common.Octets;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.HashSet;
/*     */ import java.util.List;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.NavigableMap;
/*     */ import java.util.Set;
/*     */ import java.util.TreeMap;
/*     */ import java.util.concurrent.locks.Lock;
/*     */ import java.util.concurrent.locks.ReadWriteLock;
/*     */ import java.util.concurrent.locks.ReentrantReadWriteLock;
/*     */ import mzm.gsp.GameServer;
/*     */ import org.apache.log4j.Logger;
/*     */ import xio.Protocol;
/*     */ 
/*     */ 
/*     */ class OnlineRoleLevelManage
/*     */ {
/*  22 */   private static final OnlineRoleLevelManage instance = new OnlineRoleLevelManage();
/*     */   
/*     */   static OnlineRoleLevelManage getInstance() {
/*  25 */     return instance;
/*     */   }
/*     */   
/*  28 */   private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
/*     */   
/*  30 */   private NavigableMap<Integer, Set<Long>> navigableMap = new TreeMap();
/*     */   
/*     */   void addRole(int level, long roleid) {
/*  33 */     this.readWriteLock.writeLock().lock();
/*     */     try {
/*  35 */       Set<Long> roleids = (Set)this.navigableMap.get(Integer.valueOf(level));
/*  36 */       if (roleids == null) {
/*  37 */         roleids = new HashSet();
/*  38 */         this.navigableMap.put(Integer.valueOf(level), roleids);
/*     */       }
/*  40 */       roleids.add(Long.valueOf(roleid));
/*     */     }
/*     */     catch (Exception e) {}finally {
/*  43 */       this.readWriteLock.writeLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   void remRole(int level, long roleid) {
/*  48 */     this.readWriteLock.writeLock().lock();
/*     */     try {
/*  50 */       Set<Long> roleids = (Set)this.navigableMap.get(Integer.valueOf(level));
/*  51 */       if (roleids == null) {
/*  52 */         GameServer.logger().info(String.format("[OnlineRoleLevelManage]OnlineRoleLevelManage.remRole@level role is not exist|roleid=%d|level=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(level) }));
/*     */ 
/*     */ 
/*     */ 
/*     */       }
/*     */       else
/*     */       {
/*     */ 
/*     */ 
/*  61 */         roleids.remove(Long.valueOf(roleid));
/*  62 */         if (roleids.size() <= 0) {
/*  63 */           this.navigableMap.remove(Integer.valueOf(level));
/*     */         }
/*     */       }
/*     */     }
/*     */     catch (Exception e) {}finally {
/*  68 */       this.readWriteLock.writeLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   void updateRole(int fromLevel, int toLevel, long roleid) {
/*  73 */     this.readWriteLock.writeLock().lock();
/*     */     try {
/*  75 */       Set<Long> fromRoleids = (Set)this.navigableMap.get(Integer.valueOf(fromLevel));
/*  76 */       if (fromRoleids != null) {
/*  77 */         fromRoleids.remove(Long.valueOf(roleid));
/*  78 */         if (fromRoleids.size() <= 0) {
/*  79 */           this.navigableMap.remove(Integer.valueOf(fromLevel));
/*     */         }
/*     */       }
/*  82 */       Set<Long> toRoleids = (Set)this.navigableMap.get(Integer.valueOf(toLevel));
/*  83 */       if (toRoleids == null) {
/*  84 */         toRoleids = new HashSet();
/*  85 */         this.navigableMap.put(Integer.valueOf(toLevel), toRoleids);
/*     */       }
/*  87 */       toRoleids.add(Long.valueOf(roleid));
/*     */     }
/*     */     catch (Exception e) {}finally {
/*  90 */       this.readWriteLock.writeLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   Set<Long> getRoleSet(int fromLevel, int toLevel)
/*     */   {
/* 102 */     Set<Long> set = new HashSet();
/* 103 */     getRoles(fromLevel, toLevel, set);
/* 104 */     return set;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   List<Long> getRoleList(int fromLevel, int toLevel)
/*     */   {
/* 115 */     List<Long> roleids = new ArrayList();
/* 116 */     getRoles(fromLevel, toLevel, roleids);
/* 117 */     return roleids;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   void getRoles(int fromLevel, int toLevel, Collection<Long> roleids)
/*     */   {
/* 128 */     this.readWriteLock.readLock().lock();
/*     */     try {
/* 130 */       NavigableMap<Integer, Set<Long>> map = this.navigableMap.subMap(Integer.valueOf(fromLevel), true, Integer.valueOf(toLevel), true);
/* 131 */       for (Map.Entry<Integer, Set<Long>> entry : map.entrySet()) {
/* 132 */         roleids.addAll((Collection)entry.getValue());
/*     */       }
/*     */     }
/*     */     catch (Exception e) {}finally {
/* 136 */       this.readWriteLock.readLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   Set<Long> getRoleHigherThanSet(int level)
/*     */   {
/* 147 */     Set<Long> set = new HashSet();
/* 148 */     getRoleHigherThan(level, set);
/* 149 */     return set;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   List<Long> getRoleHigherThanList(int level)
/*     */   {
/* 159 */     List<Long> roleids = new ArrayList();
/* 160 */     getRoleHigherThan(level, roleids);
/* 161 */     return roleids;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   void getRoleHigherThan(int level, Collection<Long> roleids)
/*     */   {
/* 171 */     this.readWriteLock.readLock().lock();
/*     */     try {
/* 173 */       NavigableMap<Integer, Set<Long>> map = this.navigableMap.tailMap(Integer.valueOf(level), false);
/* 174 */       for (Map.Entry<Integer, Set<Long>> entry : map.entrySet()) {
/* 175 */         roleids.addAll((Collection)entry.getValue());
/*     */       }
/*     */     }
/*     */     catch (Exception e) {}finally {
/* 179 */       this.readWriteLock.readLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   List<Long> getRoleLowerThanList(int level)
/*     */   {
/* 190 */     List<Long> roleids = new ArrayList();
/* 191 */     getRoleLowerThan(level, roleids);
/* 192 */     return roleids;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   Set<Long> getRoleLowerThanSet(int level)
/*     */   {
/* 202 */     Set<Long> roleids = new HashSet();
/* 203 */     getRoleLowerThan(level, roleids);
/* 204 */     return roleids;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   void getRoleLowerThan(int level, Collection<Long> roleids)
/*     */   {
/* 214 */     this.readWriteLock.readLock().lock();
/*     */     try {
/* 216 */       NavigableMap<Integer, Set<Long>> map = this.navigableMap.headMap(Integer.valueOf(level), false);
/* 217 */       for (Map.Entry<Integer, Set<Long>> entry : map.entrySet()) {
/* 218 */         roleids.addAll((Collection)entry.getValue());
/*     */       }
/*     */     }
/*     */     catch (Exception e) {}finally {
/* 222 */       this.readWriteLock.readLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   void sendOnlineRoles(int levelfrom, int levelto, Protocol protocol) {
/* 227 */     this.readWriteLock.readLock().lock();
/*     */     try {
/* 229 */       NavigableMap<Integer, Set<Long>> map = this.navigableMap.subMap(Integer.valueOf(levelfrom), true, Integer.valueOf(levelto), true);
/* 230 */       for (Map.Entry<Integer, Set<Long>> entry : map.entrySet()) {
/* 231 */         OnlineManager.getInstance().sendMulti(protocol, (Collection)entry.getValue());
/*     */       }
/*     */     }
/*     */     catch (Exception e) {}finally {
/* 235 */       this.readWriteLock.readLock().unlock();
/*     */     }
/*     */   }
/*     */   
/*     */   void sendOnlineRoles(int levelfrom, int levelto, int ptype, Octets octets) {
/* 240 */     this.readWriteLock.readLock().lock();
/*     */     try {
/* 242 */       NavigableMap<Integer, Set<Long>> map = this.navigableMap.subMap(Integer.valueOf(levelfrom), true, Integer.valueOf(levelto), true);
/* 243 */       for (Map.Entry<Integer, Set<Long>> entry : map.entrySet()) {
/* 244 */         OnlineManager.getInstance().sendMulti(ptype, octets, (Collection)entry.getValue());
/*     */       }
/*     */     }
/*     */     catch (Exception e) {}finally {
/* 248 */       this.readWriteLock.readLock().unlock();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\online\main\OnlineRoleLevelManage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */