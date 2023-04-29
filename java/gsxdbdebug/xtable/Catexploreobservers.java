/*    */ package xtable;
/*    */ 
/*    */ import xbean.CatExploreObserver;
/*    */ import xdb.TTable;
/*    */ import xdb.TTableCache;
/*    */ 
/*    */ 
/*    */ public class Catexploreobservers
/*    */ {
/*    */   public static CatExploreObserver get(Long key)
/*    */   {
/* 12 */     return (CatExploreObserver)_Tables_.getInstance().catexploreobservers.get(key);
/*    */   }
/*    */   
/*    */   public static CatExploreObserver get(Long key, CatExploreObserver value)
/*    */   {
/* 17 */     return (CatExploreObserver)_Tables_.getInstance().catexploreobservers.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, CatExploreObserver value)
/*    */   {
/* 22 */     _Tables_.getInstance().catexploreobservers.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().catexploreobservers.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, CatExploreObserver value)
/*    */   {
/* 32 */     return _Tables_.getInstance().catexploreobservers.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().catexploreobservers.remove(key);
/*    */   }
/*    */   
/*    */   public static TTableCache<Long, CatExploreObserver> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().catexploreobservers.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, CatExploreObserver> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().catexploreobservers;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Catexploreobservers.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */