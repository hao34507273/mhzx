/*    */ package xtable;
/*    */ 
/*    */ import xbean.Role2MountsObserverInfo;
/*    */ import xdb.TTable;
/*    */ import xdb.TTableCache;
/*    */ 
/*    */ 
/*    */ public class Role2mountsobserver
/*    */ {
/*    */   public static Role2MountsObserverInfo get(Long key)
/*    */   {
/* 12 */     return (Role2MountsObserverInfo)_Tables_.getInstance().role2mountsobserver.get(key);
/*    */   }
/*    */   
/*    */   public static Role2MountsObserverInfo get(Long key, Role2MountsObserverInfo value)
/*    */   {
/* 17 */     return (Role2MountsObserverInfo)_Tables_.getInstance().role2mountsobserver.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, Role2MountsObserverInfo value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2mountsobserver.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2mountsobserver.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, Role2MountsObserverInfo value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2mountsobserver.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2mountsobserver.remove(key);
/*    */   }
/*    */   
/*    */   public static TTableCache<Long, Role2MountsObserverInfo> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2mountsobserver.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, Role2MountsObserverInfo> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2mountsobserver;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2mountsobserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */