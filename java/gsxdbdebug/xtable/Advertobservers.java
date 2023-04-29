/*    */ package xtable;
/*    */ 
/*    */ import xbean.AdvertObserver;
/*    */ import xdb.TTable;
/*    */ import xdb.TTableCache;
/*    */ 
/*    */ 
/*    */ public class Advertobservers
/*    */ {
/*    */   public static AdvertObserver get(Long key)
/*    */   {
/* 12 */     return (AdvertObserver)_Tables_.getInstance().advertobservers.get(key);
/*    */   }
/*    */   
/*    */   public static AdvertObserver get(Long key, AdvertObserver value)
/*    */   {
/* 17 */     return (AdvertObserver)_Tables_.getInstance().advertobservers.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, AdvertObserver value)
/*    */   {
/* 22 */     _Tables_.getInstance().advertobservers.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().advertobservers.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, AdvertObserver value)
/*    */   {
/* 32 */     return _Tables_.getInstance().advertobservers.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().advertobservers.remove(key);
/*    */   }
/*    */   
/*    */   public static TTableCache<Long, AdvertObserver> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().advertobservers.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, AdvertObserver> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().advertobservers;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Advertobservers.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */