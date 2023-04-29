/*     */ package xtable;
/*     */ 
/*     */ import xbean.AddictionInfo;
/*     */ import xdb.TField;
/*     */ import xdb.TTable;
/*     */ import xdb.TTableCache;
/*     */ 
/*     */ public class User2addictioninfo
/*     */ {
/*     */   public static AddictionInfo get(String key)
/*     */   {
/*  12 */     return (AddictionInfo)_Tables_.getInstance().user2addictioninfo.get(key);
/*     */   }
/*     */   
/*     */   public static AddictionInfo get(String key, AddictionInfo value)
/*     */   {
/*  17 */     return (AddictionInfo)_Tables_.getInstance().user2addictioninfo.get(key, value);
/*     */   }
/*     */   
/*     */   public static void insert(String key, AddictionInfo value)
/*     */   {
/*  22 */     _Tables_.getInstance().user2addictioninfo.insert(key, value);
/*     */   }
/*     */   
/*     */   public static void delete(String key)
/*     */   {
/*  27 */     _Tables_.getInstance().user2addictioninfo.delete(key);
/*     */   }
/*     */   
/*     */   public static boolean add(String key, AddictionInfo value)
/*     */   {
/*  32 */     return _Tables_.getInstance().user2addictioninfo.add(key, value);
/*     */   }
/*     */   
/*     */   public static boolean remove(String key)
/*     */   {
/*  37 */     return _Tables_.getInstance().user2addictioninfo.remove(key);
/*     */   }
/*     */   
/*     */   public static TTableCache<String, AddictionInfo> getCache()
/*     */   {
/*  42 */     return _Tables_.getInstance().user2addictioninfo.getCache();
/*     */   }
/*     */   
/*     */   public static TTable<String, AddictionInfo> getTable()
/*     */   {
/*  47 */     return _Tables_.getInstance().user2addictioninfo;
/*     */   }
/*     */   
/*     */   public static AddictionInfo select(String key)
/*     */   {
/*  52 */     (AddictionInfo)getTable().select(key, new TField()
/*     */     {
/*     */       public AddictionInfo get(AddictionInfo v)
/*     */       {
/*  56 */         return v.toData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectIdentity(String key)
/*     */   {
/*  63 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(AddictionInfo v)
/*     */       {
/*  67 */         return Integer.valueOf(v.getIdentity());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectUpdate_time(String key)
/*     */   {
/*  74 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(AddictionInfo v)
/*     */       {
/*  78 */         return Long.valueOf(v.getUpdate_time());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectOnline_time(String key)
/*     */   {
/*  85 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(AddictionInfo v)
/*     */       {
/*  89 */         return Integer.valueOf(v.getOnline_time());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectTotal_online_time(String key)
/*     */   {
/*  96 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(AddictionInfo v)
/*     */       {
/* 100 */         return Integer.valueOf(v.getTotal_online_time());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Boolean selectReminded(String key)
/*     */   {
/* 107 */     (Boolean)getTable().select(key, new TField()
/*     */     {
/*     */       public Boolean get(AddictionInfo v)
/*     */       {
/* 111 */         return Boolean.valueOf(v.getReminded());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectKickout_type(String key)
/*     */   {
/* 118 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(AddictionInfo v)
/*     */       {
/* 122 */         return Integer.valueOf(v.getKickout_type());
/*     */       }
/*     */     });
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\User2addictioninfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */