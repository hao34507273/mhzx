/*    */ package xtable;
/*    */ 
/*    */ import xbean.QQVipObservers;
/*    */ import xdb.TTable;
/*    */ import xdb.TTableCache;
/*    */ 
/*    */ 
/*    */ public class User2qqvipobservers
/*    */ {
/*    */   public static QQVipObservers get(String key)
/*    */   {
/* 12 */     return (QQVipObservers)_Tables_.getInstance().user2qqvipobservers.get(key);
/*    */   }
/*    */   
/*    */   public static QQVipObservers get(String key, QQVipObservers value)
/*    */   {
/* 17 */     return (QQVipObservers)_Tables_.getInstance().user2qqvipobservers.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(String key, QQVipObservers value)
/*    */   {
/* 22 */     _Tables_.getInstance().user2qqvipobservers.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(String key)
/*    */   {
/* 27 */     _Tables_.getInstance().user2qqvipobservers.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(String key, QQVipObservers value)
/*    */   {
/* 32 */     return _Tables_.getInstance().user2qqvipobservers.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(String key)
/*    */   {
/* 37 */     return _Tables_.getInstance().user2qqvipobservers.remove(key);
/*    */   }
/*    */   
/*    */   public static TTableCache<String, QQVipObservers> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().user2qqvipobservers.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<String, QQVipObservers> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().user2qqvipobservers;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\User2qqvipobservers.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */