/*    */ package xtable;
/*    */ 
/*    */ import xbean.GiveBirthObserver;
/*    */ import xdb.TTable;
/*    */ import xdb.TTableCache;
/*    */ 
/*    */ 
/*    */ public class Givebirthobservers
/*    */ {
/*    */   public static GiveBirthObserver get(Long key)
/*    */   {
/* 12 */     return (GiveBirthObserver)_Tables_.getInstance().givebirthobservers.get(key);
/*    */   }
/*    */   
/*    */   public static GiveBirthObserver get(Long key, GiveBirthObserver value)
/*    */   {
/* 17 */     return (GiveBirthObserver)_Tables_.getInstance().givebirthobservers.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, GiveBirthObserver value)
/*    */   {
/* 22 */     _Tables_.getInstance().givebirthobservers.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().givebirthobservers.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, GiveBirthObserver value)
/*    */   {
/* 32 */     return _Tables_.getInstance().givebirthobservers.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().givebirthobservers.remove(key);
/*    */   }
/*    */   
/*    */   public static TTableCache<Long, GiveBirthObserver> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().givebirthobservers.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, GiveBirthObserver> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().givebirthobservers;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Givebirthobservers.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */