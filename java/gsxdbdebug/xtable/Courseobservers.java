/*    */ package xtable;
/*    */ 
/*    */ import xbean.CourseObserver;
/*    */ import xdb.TTable;
/*    */ import xdb.TTableCache;
/*    */ 
/*    */ 
/*    */ public class Courseobservers
/*    */ {
/*    */   public static CourseObserver get(Long key)
/*    */   {
/* 12 */     return (CourseObserver)_Tables_.getInstance().courseobservers.get(key);
/*    */   }
/*    */   
/*    */   public static CourseObserver get(Long key, CourseObserver value)
/*    */   {
/* 17 */     return (CourseObserver)_Tables_.getInstance().courseobservers.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, CourseObserver value)
/*    */   {
/* 22 */     _Tables_.getInstance().courseobservers.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().courseobservers.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, CourseObserver value)
/*    */   {
/* 32 */     return _Tables_.getInstance().courseobservers.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().courseobservers.remove(key);
/*    */   }
/*    */   
/*    */   public static TTableCache<Long, CourseObserver> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().courseobservers.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, CourseObserver> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().courseobservers;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Courseobservers.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */