/*    */ package xtable;
/*    */ 
/*    */ import xbean.FashionObserverInfo;
/*    */ import xdb.TTable;
/*    */ import xdb.TTableCache;
/*    */ 
/*    */ 
/*    */ public class Role2fashionobserver
/*    */ {
/*    */   public static FashionObserverInfo get(Long key)
/*    */   {
/* 12 */     return (FashionObserverInfo)_Tables_.getInstance().role2fashionobserver.get(key);
/*    */   }
/*    */   
/*    */   public static FashionObserverInfo get(Long key, FashionObserverInfo value)
/*    */   {
/* 17 */     return (FashionObserverInfo)_Tables_.getInstance().role2fashionobserver.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, FashionObserverInfo value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2fashionobserver.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2fashionobserver.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, FashionObserverInfo value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2fashionobserver.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2fashionobserver.remove(key);
/*    */   }
/*    */   
/*    */   public static TTableCache<Long, FashionObserverInfo> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2fashionobserver.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, FashionObserverInfo> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2fashionobserver;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2fashionobserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */