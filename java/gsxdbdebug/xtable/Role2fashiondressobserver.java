/*    */ package xtable;
/*    */ 
/*    */ import xbean.Role2FashionDressObserverInfo;
/*    */ import xdb.TTable;
/*    */ import xdb.TTableCache;
/*    */ 
/*    */ 
/*    */ public class Role2fashiondressobserver
/*    */ {
/*    */   public static Role2FashionDressObserverInfo get(Long key)
/*    */   {
/* 12 */     return (Role2FashionDressObserverInfo)_Tables_.getInstance().role2fashiondressobserver.get(key);
/*    */   }
/*    */   
/*    */   public static Role2FashionDressObserverInfo get(Long key, Role2FashionDressObserverInfo value)
/*    */   {
/* 17 */     return (Role2FashionDressObserverInfo)_Tables_.getInstance().role2fashiondressobserver.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, Role2FashionDressObserverInfo value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2fashiondressobserver.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2fashiondressobserver.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, Role2FashionDressObserverInfo value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2fashiondressobserver.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2fashiondressobserver.remove(key);
/*    */   }
/*    */   
/*    */   public static TTableCache<Long, Role2FashionDressObserverInfo> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2fashiondressobserver.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, Role2FashionDressObserverInfo> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2fashiondressobserver;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2fashiondressobserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */