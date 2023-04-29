/*    */ package xtable;
/*    */ 
/*    */ import xbean.AnimalLifeObserver;
/*    */ import xdb.TTable;
/*    */ import xdb.TTableCache;
/*    */ 
/*    */ 
/*    */ public class Animallifeobservers
/*    */ {
/*    */   public static AnimalLifeObserver get(Long key)
/*    */   {
/* 12 */     return (AnimalLifeObserver)_Tables_.getInstance().animallifeobservers.get(key);
/*    */   }
/*    */   
/*    */   public static AnimalLifeObserver get(Long key, AnimalLifeObserver value)
/*    */   {
/* 17 */     return (AnimalLifeObserver)_Tables_.getInstance().animallifeobservers.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, AnimalLifeObserver value)
/*    */   {
/* 22 */     _Tables_.getInstance().animallifeobservers.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().animallifeobservers.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, AnimalLifeObserver value)
/*    */   {
/* 32 */     return _Tables_.getInstance().animallifeobservers.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().animallifeobservers.remove(key);
/*    */   }
/*    */   
/*    */   public static TTableCache<Long, AnimalLifeObserver> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().animallifeobservers.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, AnimalLifeObserver> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().animallifeobservers;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Animallifeobservers.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */