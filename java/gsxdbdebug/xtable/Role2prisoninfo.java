/*    */ package xtable;
/*    */ 
/*    */ import xbean.PrisonInfo;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ import xdb.TTableCache;
/*    */ 
/*    */ public class Role2prisoninfo
/*    */ {
/*    */   public static PrisonInfo get(Long key)
/*    */   {
/* 12 */     return (PrisonInfo)_Tables_.getInstance().role2prisoninfo.get(key);
/*    */   }
/*    */   
/*    */   public static PrisonInfo get(Long key, PrisonInfo value)
/*    */   {
/* 17 */     return (PrisonInfo)_Tables_.getInstance().role2prisoninfo.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, PrisonInfo value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2prisoninfo.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2prisoninfo.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, PrisonInfo value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2prisoninfo.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2prisoninfo.remove(key);
/*    */   }
/*    */   
/*    */   public static TTableCache<Long, PrisonInfo> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2prisoninfo.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, PrisonInfo> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2prisoninfo;
/*    */   }
/*    */   
/*    */   public static PrisonInfo select(Long key)
/*    */   {
/* 52 */     (PrisonInfo)getTable().select(key, new TField()
/*    */     {
/*    */       public PrisonInfo get(PrisonInfo v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Long selectEnterjailtimestamp(Long key)
/*    */   {
/* 63 */     (Long)getTable().select(key, new TField()
/*    */     {
/*    */       public Long get(PrisonInfo v)
/*    */       {
/* 67 */         return Long.valueOf(v.getEnterjailtimestamp());
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Long selectSessionid(Long key)
/*    */   {
/* 74 */     (Long)getTable().select(key, new TField()
/*    */     {
/*    */       public Long get(PrisonInfo v)
/*    */       {
/* 78 */         return Long.valueOf(v.getSessionid());
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Integer selectJailaction(Long key)
/*    */   {
/* 85 */     (Integer)getTable().select(key, new TField()
/*    */     {
/*    */       public Integer get(PrisonInfo v)
/*    */       {
/* 89 */         return Integer.valueOf(v.getJailaction());
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Long selectInjailonlinetime(Long key)
/*    */   {
/* 96 */     (Long)getTable().select(key, new TField()
/*    */     {
/*    */       public Long get(PrisonInfo v)
/*    */       {
/* :0 */         return Long.valueOf(v.getInjailonlinetime());
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2prisoninfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */