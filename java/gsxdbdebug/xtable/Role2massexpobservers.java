/*    */ package xtable;
/*    */ 
/*    */ import xbean.MassExpObserver;
/*    */ import xdb.TTable;
/*    */ import xdb.TTableCache;
/*    */ 
/*    */ 
/*    */ public class Role2massexpobservers
/*    */ {
/*    */   public static MassExpObserver get(Long key)
/*    */   {
/* 12 */     return (MassExpObserver)_Tables_.getInstance().role2massexpobservers.get(key);
/*    */   }
/*    */   
/*    */   public static MassExpObserver get(Long key, MassExpObserver value)
/*    */   {
/* 17 */     return (MassExpObserver)_Tables_.getInstance().role2massexpobservers.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, MassExpObserver value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2massexpobservers.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2massexpobservers.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, MassExpObserver value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2massexpobservers.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2massexpobservers.remove(key);
/*    */   }
/*    */   
/*    */   public static TTableCache<Long, MassExpObserver> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2massexpobservers.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, MassExpObserver> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2massexpobservers;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2massexpobservers.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */