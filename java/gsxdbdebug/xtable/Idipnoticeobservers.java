/*    */ package xtable;
/*    */ 
/*    */ import xbean.IdipNoticeObserver;
/*    */ import xdb.TTable;
/*    */ import xdb.TTableCache;
/*    */ 
/*    */ 
/*    */ public class Idipnoticeobservers
/*    */ {
/*    */   public static IdipNoticeObserver get(Long key)
/*    */   {
/* 12 */     return (IdipNoticeObserver)_Tables_.getInstance().idipnoticeobservers.get(key);
/*    */   }
/*    */   
/*    */   public static IdipNoticeObserver get(Long key, IdipNoticeObserver value)
/*    */   {
/* 17 */     return (IdipNoticeObserver)_Tables_.getInstance().idipnoticeobservers.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, IdipNoticeObserver value)
/*    */   {
/* 22 */     _Tables_.getInstance().idipnoticeobservers.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().idipnoticeobservers.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, IdipNoticeObserver value)
/*    */   {
/* 32 */     return _Tables_.getInstance().idipnoticeobservers.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().idipnoticeobservers.remove(key);
/*    */   }
/*    */   
/*    */   public static TTableCache<Long, IdipNoticeObserver> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().idipnoticeobservers.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, IdipNoticeObserver> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().idipnoticeobservers;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Idipnoticeobservers.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */