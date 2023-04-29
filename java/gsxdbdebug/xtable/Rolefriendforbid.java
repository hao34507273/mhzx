/*    */ package xtable;
/*    */ 
/*    */ import xbean.ForbidInfo;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ import xdb.TTableCache;
/*    */ 
/*    */ public class Rolefriendforbid
/*    */ {
/*    */   public static ForbidInfo get(Long key)
/*    */   {
/* 12 */     return (ForbidInfo)_Tables_.getInstance().rolefriendforbid.get(key);
/*    */   }
/*    */   
/*    */   public static ForbidInfo get(Long key, ForbidInfo value)
/*    */   {
/* 17 */     return (ForbidInfo)_Tables_.getInstance().rolefriendforbid.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, ForbidInfo value)
/*    */   {
/* 22 */     _Tables_.getInstance().rolefriendforbid.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().rolefriendforbid.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, ForbidInfo value)
/*    */   {
/* 32 */     return _Tables_.getInstance().rolefriendforbid.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().rolefriendforbid.remove(key);
/*    */   }
/*    */   
/*    */   public static TTableCache<Long, ForbidInfo> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().rolefriendforbid.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, ForbidInfo> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().rolefriendforbid;
/*    */   }
/*    */   
/*    */   public static ForbidInfo select(Long key)
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
/*    */   public static Long selectExpiretime(Long key)
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
/*    */   public static Long selectStarttime(Long key)
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
/*    */   public static String selectReason(Long key)
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


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Rolefriendforbid.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */