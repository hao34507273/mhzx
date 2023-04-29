/*    */ package xtable;
/*    */ 
/*    */ import xbean.ForbidInfo;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ import xdb.TTableCache;
/*    */ 
/*    */ public class Userfriendforbid
/*    */ {
/*    */   public static ForbidInfo get(String key)
/*    */   {
/* 12 */     return (ForbidInfo)_Tables_.getInstance().userfriendforbid.get(key);
/*    */   }
/*    */   
/*    */   public static ForbidInfo get(String key, ForbidInfo value)
/*    */   {
/* 17 */     return (ForbidInfo)_Tables_.getInstance().userfriendforbid.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(String key, ForbidInfo value)
/*    */   {
/* 22 */     _Tables_.getInstance().userfriendforbid.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(String key)
/*    */   {
/* 27 */     _Tables_.getInstance().userfriendforbid.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(String key, ForbidInfo value)
/*    */   {
/* 32 */     return _Tables_.getInstance().userfriendforbid.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(String key)
/*    */   {
/* 37 */     return _Tables_.getInstance().userfriendforbid.remove(key);
/*    */   }
/*    */   
/*    */   public static TTableCache<String, ForbidInfo> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().userfriendforbid.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<String, ForbidInfo> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().userfriendforbid;
/*    */   }
/*    */   
/*    */   public static ForbidInfo select(String key)
/*    */   {
/* 52 */     (ForbidInfo)getTable().select(key, new TField()
/*    */     {
/*    */       public ForbidInfo get(ForbidInfo v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Long selectExpiretime(String key)
/*    */   {
/* 63 */     (Long)getTable().select(key, new TField()
/*    */     {
/*    */       public Long get(ForbidInfo v)
/*    */       {
/* 67 */         return Long.valueOf(v.getExpiretime());
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Long selectStarttime(String key)
/*    */   {
/* 74 */     (Long)getTable().select(key, new TField()
/*    */     {
/*    */       public Long get(ForbidInfo v)
/*    */       {
/* 78 */         return Long.valueOf(v.getStarttime());
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static String selectReason(String key)
/*    */   {
/* 85 */     (String)getTable().select(key, new TField()
/*    */     {
/*    */       public String get(ForbidInfo v)
/*    */       {
/* 89 */         return v.getReason();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Userfriendforbid.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */