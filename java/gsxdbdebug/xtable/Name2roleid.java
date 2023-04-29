/*    */ package xtable;
/*    */ 
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ import xdb.TTableCache;
/*    */ 
/*    */ 
/*    */ public class Name2roleid
/*    */ {
/*    */   public static Long get(String key)
/*    */   {
/* 12 */     return (Long)_Tables_.getInstance().name2roleid.get(key);
/*    */   }
/*    */   
/*    */   public static Long get(String key, Long value)
/*    */   {
/* 17 */     return (Long)_Tables_.getInstance().name2roleid.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(String key, Long value)
/*    */   {
/* 22 */     _Tables_.getInstance().name2roleid.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(String key)
/*    */   {
/* 27 */     _Tables_.getInstance().name2roleid.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(String key, Long value)
/*    */   {
/* 32 */     return _Tables_.getInstance().name2roleid.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(String key)
/*    */   {
/* 37 */     return _Tables_.getInstance().name2roleid.remove(key);
/*    */   }
/*    */   
/*    */   public static TTableCache<String, Long> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().name2roleid.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<String, Long> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().name2roleid;
/*    */   }
/*    */   
/*    */   public static Long select(String key)
/*    */   {
/* 52 */     (Long)getTable().select(key, new TField()
/*    */     {
/*    */       public Long get(Long v)
/*    */       {
/* 56 */         return v;
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Name2roleid.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */