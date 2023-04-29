/*    */ package xtable;
/*    */ 
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ import xdb.TTableCache;
/*    */ 
/*    */ 
/*    */ public class Role2bandstandsessionid
/*    */ {
/*    */   public static Long get(Long key)
/*    */   {
/* 12 */     return (Long)_Tables_.getInstance().role2bandstandsessionid.get(key);
/*    */   }
/*    */   
/*    */   public static Long get(Long key, Long value)
/*    */   {
/* 17 */     return (Long)_Tables_.getInstance().role2bandstandsessionid.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, Long value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2bandstandsessionid.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2bandstandsessionid.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, Long value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2bandstandsessionid.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2bandstandsessionid.remove(key);
/*    */   }
/*    */   
/*    */   public static TTableCache<Long, Long> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2bandstandsessionid.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, Long> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2bandstandsessionid;
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


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2bandstandsessionid.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */