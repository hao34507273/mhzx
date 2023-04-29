/*    */ package mzm.gsp.personal.main;
/*    */ 
/*    */ import java.util.HashSet;
/*    */ import java.util.LinkedHashMap;
/*    */ import java.util.List;
/*    */ import java.util.Map.Entry;
/*    */ import java.util.Set;
/*    */ import java.util.concurrent.locks.Lock;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.personal.confbean.SNSConsts;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ public class ActiveRoleIdLRU
/*    */ {
/* 15 */   private static final Object EMPTY = new Object();
/*    */   
/* 17 */   private static final ActiveRoleIdLRU instance = new ActiveRoleIdLRU();
/*    */   
/*    */   public static ActiveRoleIdLRU getInstance()
/*    */   {
/* 21 */     return instance;
/*    */   }
/*    */   
/* 24 */   private final Lock lock = new java.util.concurrent.locks.ReentrantLock();
/* 25 */   private final RoleIdMap roleIdMap = new RoleIdMap(SNSConsts.getInstance().ACTIVE_ROLE_MAX);
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public void add(long roleId)
/*    */   {
/* 33 */     this.lock.lock();
/*    */     try
/*    */     {
/* 36 */       this.roleIdMap.put(Long.valueOf(roleId), EMPTY);
/*    */     }
/*    */     finally
/*    */     {
/* 40 */       this.lock.unlock();
/*    */     }
/*    */   }
/*    */   
/*    */   public Set<Long> getAll()
/*    */   {
/* 46 */     this.lock.lock();
/*    */     try
/*    */     {
/* 49 */       return new HashSet(this.roleIdMap.keySet());
/*    */     }
/*    */     finally
/*    */     {
/* 53 */       this.lock.unlock();
/*    */     }
/*    */   }
/*    */   
/*    */   public void fillRoles(List<Long> roles)
/*    */   {
/* 59 */     this.lock.lock();
/*    */     try
/*    */     {
/* 62 */       roles.addAll(this.roleIdMap.keySet());
/*    */     }
/*    */     finally
/*    */     {
/* 66 */       this.lock.unlock();
/*    */     }
/*    */   }
/*    */   
/*    */   private static class RoleIdMap
/*    */     extends LinkedHashMap<Long, Object>
/*    */   {
/*    */     private static final long serialVersionUID = 1L;
/*    */     private final int capacity;
/*    */     
/*    */     RoleIdMap(int capacity)
/*    */     {
/* 78 */       super(0.75F, true);
/* 79 */       this.capacity = capacity;
/*    */     }
/*    */     
/*    */ 
/*    */     protected boolean removeEldestEntry(Map.Entry<Long, Object> eldest)
/*    */     {
/* 85 */       if (size() > this.capacity)
/*    */       {
/* 87 */         GameServer.logger().info(String.format("[personal]RoleIdMap.removeEldestEntry@remove eldest entry|roleid=%d|size=%d|capacity=%d", new Object[] { eldest.getKey(), Integer.valueOf(size()), Integer.valueOf(this.capacity) }));
/*    */         
/*    */ 
/*    */ 
/* 91 */         return true;
/*    */       }
/* 93 */       return false;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\personal\main\ActiveRoleIdLRU.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */