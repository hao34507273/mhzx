/*    */ package xtable;
/*    */ 
/*    */ import xbean.IdipMarqueeObserver;
/*    */ import xdb.TTable;
/*    */ import xdb.TTableCache;
/*    */ 
/*    */ 
/*    */ public class Idipmarqueeobservers
/*    */ {
/*    */   public static IdipMarqueeObserver get(Long key)
/*    */   {
/* 12 */     return (IdipMarqueeObserver)_Tables_.getInstance().idipmarqueeobservers.get(key);
/*    */   }
/*    */   
/*    */   public static IdipMarqueeObserver get(Long key, IdipMarqueeObserver value)
/*    */   {
/* 17 */     return (IdipMarqueeObserver)_Tables_.getInstance().idipmarqueeobservers.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, IdipMarqueeObserver value)
/*    */   {
/* 22 */     _Tables_.getInstance().idipmarqueeobservers.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().idipmarqueeobservers.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, IdipMarqueeObserver value)
/*    */   {
/* 32 */     return _Tables_.getInstance().idipmarqueeobservers.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().idipmarqueeobservers.remove(key);
/*    */   }
/*    */   
/*    */   public static TTableCache<Long, IdipMarqueeObserver> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().idipmarqueeobservers.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, IdipMarqueeObserver> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().idipmarqueeobservers;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Idipmarqueeobservers.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */