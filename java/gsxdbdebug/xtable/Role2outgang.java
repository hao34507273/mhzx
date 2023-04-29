/*    */ package xtable;
/*    */ 
/*    */ import xbean.OutGangStatus;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ import xdb.TTableCache;
/*    */ 
/*    */ public class Role2outgang
/*    */ {
/*    */   public static OutGangStatus get(Long key)
/*    */   {
/* 12 */     return (OutGangStatus)_Tables_.getInstance().role2outgang.get(key);
/*    */   }
/*    */   
/*    */   public static OutGangStatus get(Long key, OutGangStatus value)
/*    */   {
/* 17 */     return (OutGangStatus)_Tables_.getInstance().role2outgang.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, OutGangStatus value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2outgang.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2outgang.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, OutGangStatus value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2outgang.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2outgang.remove(key);
/*    */   }
/*    */   
/*    */   public static TTableCache<Long, OutGangStatus> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2outgang.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, OutGangStatus> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2outgang;
/*    */   }
/*    */   
/*    */   public static OutGangStatus select(Long key)
/*    */   {
/* 52 */     (OutGangStatus)getTable().select(key, new TField()
/*    */     {
/*    */       public OutGangStatus get(OutGangStatus v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static String selectGroupopenid(Long key)
/*    */   {
/* 63 */     (String)getTable().select(key, new TField()
/*    */     {
/*    */       public String get(OutGangStatus v)
/*    */       {
/* 67 */         return v.getGroupopenid();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Long selectGangid(Long key)
/*    */   {
/* 74 */     (Long)getTable().select(key, new TField()
/*    */     {
/*    */       public Long get(OutGangStatus v)
/*    */       {
/* 78 */         return Long.valueOf(v.getGangid());
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Long selectCreatetime(Long key)
/*    */   {
/* 85 */     (Long)getTable().select(key, new TField()
/*    */     {
/*    */       public Long get(OutGangStatus v)
/*    */       {
/* 89 */         return Long.valueOf(v.getCreatetime());
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2outgang.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */