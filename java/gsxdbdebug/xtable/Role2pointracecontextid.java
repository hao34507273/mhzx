/*    */ package xtable;
/*    */ 
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ import xdb.TTableCache;
/*    */ 
/*    */ 
/*    */ public class Role2pointracecontextid
/*    */ {
/*    */   public static Long get(Long key)
/*    */   {
/* 12 */     return (Long)_Tables_.getInstance().role2pointracecontextid.get(key);
/*    */   }
/*    */   
/*    */   public static Long get(Long key, Long value)
/*    */   {
/* 17 */     return (Long)_Tables_.getInstance().role2pointracecontextid.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, Long value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2pointracecontextid.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2pointracecontextid.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, Long value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2pointracecontextid.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2pointracecontextid.remove(key);
/*    */   }
/*    */   
/*    */   public static TTableCache<Long, Long> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2pointracecontextid.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, Long> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2pointracecontextid;
/*    */   }
/*    */   
/*    */   public static Long select(Long key)
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


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2pointracecontextid.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */