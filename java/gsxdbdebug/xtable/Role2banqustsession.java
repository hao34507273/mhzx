/*    */ package xtable;
/*    */ 
/*    */ import xbean.BanquestSessionInfo;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ import xdb.TTableCache;
/*    */ 
/*    */ public class Role2banqustsession
/*    */ {
/*    */   public static BanquestSessionInfo get(Long key)
/*    */   {
/* 12 */     return (BanquestSessionInfo)_Tables_.getInstance().role2banqustsession.get(key);
/*    */   }
/*    */   
/*    */   public static BanquestSessionInfo get(Long key, BanquestSessionInfo value)
/*    */   {
/* 17 */     return (BanquestSessionInfo)_Tables_.getInstance().role2banqustsession.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, BanquestSessionInfo value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2banqustsession.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2banqustsession.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, BanquestSessionInfo value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2banqustsession.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2banqustsession.remove(key);
/*    */   }
/*    */   
/*    */   public static TTableCache<Long, BanquestSessionInfo> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2banqustsession.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, BanquestSessionInfo> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2banqustsession;
/*    */   }
/*    */   
/*    */   public static BanquestSessionInfo select(Long key)
/*    */   {
/* 52 */     (BanquestSessionInfo)getTable().select(key, new TField()
/*    */     {
/*    */       public BanquestSessionInfo get(BanquestSessionInfo v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Long selectBanquestendsessionid(Long key)
/*    */   {
/* 63 */     (Long)getTable().select(key, new TField()
/*    */     {
/*    */       public Long get(BanquestSessionInfo v)
/*    */       {
/* 67 */         return Long.valueOf(v.getBanquestendsessionid());
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Long selectBanquestsessionid(Long key)
/*    */   {
/* 74 */     (Long)getTable().select(key, new TField()
/*    */     {
/*    */       public Long get(BanquestSessionInfo v)
/*    */       {
/* 78 */         return Long.valueOf(v.getBanquestsessionid());
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Long selectClearcontrollersessionid(Long key)
/*    */   {
/* 85 */     (Long)getTable().select(key, new TField()
/*    */     {
/*    */       public Long get(BanquestSessionInfo v)
/*    */       {
/* 89 */         return Long.valueOf(v.getClearcontrollersessionid());
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2banqustsession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */