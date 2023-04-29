/*     */ package xtable;
/*     */ 
/*     */ import xbean.Role2DoubleItemInfo;
/*     */ import xdb.TField;
/*     */ import xdb.TTable;
/*     */ import xdb.TTableCache;
/*     */ 
/*     */ public class Role2doubleitem
/*     */ {
/*     */   public static Role2DoubleItemInfo get(Long key)
/*     */   {
/*  12 */     return (Role2DoubleItemInfo)_Tables_.getInstance().role2doubleitem.get(key);
/*     */   }
/*     */   
/*     */   public static Role2DoubleItemInfo get(Long key, Role2DoubleItemInfo value)
/*     */   {
/*  17 */     return (Role2DoubleItemInfo)_Tables_.getInstance().role2doubleitem.get(key, value);
/*     */   }
/*     */   
/*     */   public static void insert(Long key, Role2DoubleItemInfo value)
/*     */   {
/*  22 */     _Tables_.getInstance().role2doubleitem.insert(key, value);
/*     */   }
/*     */   
/*     */   public static void delete(Long key)
/*     */   {
/*  27 */     _Tables_.getInstance().role2doubleitem.delete(key);
/*     */   }
/*     */   
/*     */   public static boolean add(Long key, Role2DoubleItemInfo value)
/*     */   {
/*  32 */     return _Tables_.getInstance().role2doubleitem.add(key, value);
/*     */   }
/*     */   
/*     */   public static boolean remove(Long key)
/*     */   {
/*  37 */     return _Tables_.getInstance().role2doubleitem.remove(key);
/*     */   }
/*     */   
/*     */   public static TTableCache<Long, Role2DoubleItemInfo> getCache()
/*     */   {
/*  42 */     return _Tables_.getInstance().role2doubleitem.getCache();
/*     */   }
/*     */   
/*     */   public static TTable<Long, Role2DoubleItemInfo> getTable()
/*     */   {
/*  47 */     return _Tables_.getInstance().role2doubleitem;
/*     */   }
/*     */   
/*     */   public static Role2DoubleItemInfo select(Long key)
/*     */   {
/*  52 */     (Role2DoubleItemInfo)getTable().select(key, new TField()
/*     */     {
/*     */       public Role2DoubleItemInfo get(Role2DoubleItemInfo v)
/*     */       {
/*  56 */         return v.toData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectToday_guarantee_times(Long key)
/*     */   {
/*  63 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(Role2DoubleItemInfo v)
/*     */       {
/*  67 */         return Integer.valueOf(v.getToday_guarantee_times());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectToday_guarantee_refresh_time(Long key)
/*     */   {
/*  74 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(Role2DoubleItemInfo v)
/*     */       {
/*  78 */         return Long.valueOf(v.getToday_guarantee_refresh_time());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectToday_trigger_times(Long key)
/*     */   {
/*  85 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(Role2DoubleItemInfo v)
/*     */       {
/*  89 */         return Integer.valueOf(v.getToday_trigger_times());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectToday_trigger_refresh_time(Long key)
/*     */   {
/*  96 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(Role2DoubleItemInfo v)
/*     */       {
/* 100 */         return Long.valueOf(v.getToday_trigger_refresh_time());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectGuarantee_not_trigger_times(Long key)
/*     */   {
/* 107 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(Role2DoubleItemInfo v)
/*     */       {
/* 111 */         return Integer.valueOf(v.getGuarantee_not_trigger_times());
/*     */       }
/*     */     });
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2doubleitem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */