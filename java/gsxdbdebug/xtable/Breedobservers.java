/*    */ package xtable;
/*    */ 
/*    */ import xbean.BreedObserver;
/*    */ import xdb.TTable;
/*    */ import xdb.TTableCache;
/*    */ 
/*    */ 
/*    */ public class Breedobservers
/*    */ {
/*    */   public static BreedObserver get(Long key)
/*    */   {
/* 12 */     return (BreedObserver)_Tables_.getInstance().breedobservers.get(key);
/*    */   }
/*    */   
/*    */   public static BreedObserver get(Long key, BreedObserver value)
/*    */   {
/* 17 */     return (BreedObserver)_Tables_.getInstance().breedobservers.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, BreedObserver value)
/*    */   {
/* 22 */     _Tables_.getInstance().breedobservers.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().breedobservers.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, BreedObserver value)
/*    */   {
/* 32 */     return _Tables_.getInstance().breedobservers.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().breedobservers.remove(key);
/*    */   }
/*    */   
/*    */   public static TTableCache<Long, BreedObserver> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().breedobservers.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, BreedObserver> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().breedobservers;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Breedobservers.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */