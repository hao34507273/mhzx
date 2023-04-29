/*     */ package xtable;
/*     */ 
/*     */ import xbean.RoleGatherData;
/*     */ import xdb.TField;
/*     */ import xdb.TTable;
/*     */ import xdb.TTableCache;
/*     */ 
/*     */ public class Role2gatherdata
/*     */ {
/*     */   public static RoleGatherData get(Long key)
/*     */   {
/*  12 */     return (RoleGatherData)_Tables_.getInstance().role2gatherdata.get(key);
/*     */   }
/*     */   
/*     */   public static RoleGatherData get(Long key, RoleGatherData value)
/*     */   {
/*  17 */     return (RoleGatherData)_Tables_.getInstance().role2gatherdata.get(key, value);
/*     */   }
/*     */   
/*     */   public static void insert(Long key, RoleGatherData value)
/*     */   {
/*  22 */     _Tables_.getInstance().role2gatherdata.insert(key, value);
/*     */   }
/*     */   
/*     */   public static void delete(Long key)
/*     */   {
/*  27 */     _Tables_.getInstance().role2gatherdata.delete(key);
/*     */   }
/*     */   
/*     */   public static boolean add(Long key, RoleGatherData value)
/*     */   {
/*  32 */     return _Tables_.getInstance().role2gatherdata.add(key, value);
/*     */   }
/*     */   
/*     */   public static boolean remove(Long key)
/*     */   {
/*  37 */     return _Tables_.getInstance().role2gatherdata.remove(key);
/*     */   }
/*     */   
/*     */   public static TTableCache<Long, RoleGatherData> getCache()
/*     */   {
/*  42 */     return _Tables_.getInstance().role2gatherdata.getCache();
/*     */   }
/*     */   
/*     */   public static TTable<Long, RoleGatherData> getTable()
/*     */   {
/*  47 */     return _Tables_.getInstance().role2gatherdata;
/*     */   }
/*     */   
/*     */   public static RoleGatherData select(Long key)
/*     */   {
/*  52 */     (RoleGatherData)getTable().select(key, new TField()
/*     */     {
/*     */       public RoleGatherData get(RoleGatherData v)
/*     */       {
/*  56 */         return v.toData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectTotalsource(Long key)
/*     */   {
/*  63 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(RoleGatherData v)
/*     */       {
/*  67 */         return Integer.valueOf(v.getTotalsource());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectTotalcount(Long key)
/*     */   {
/*  74 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(RoleGatherData v)
/*     */       {
/*  78 */         return Integer.valueOf(v.getTotalcount());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectPoint(Long key)
/*     */   {
/*  85 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(RoleGatherData v)
/*     */       {
/*  89 */         return Integer.valueOf(v.getPoint());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectGatherinstanceid(Long key)
/*     */   {
/*  96 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(RoleGatherData v)
/*     */       {
/* 100 */         return Long.valueOf(v.getGatherinstanceid());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectGathersessionid(Long key)
/*     */   {
/* 107 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(RoleGatherData v)
/*     */       {
/* 111 */         return Long.valueOf(v.getGathersessionid());
/*     */       }
/*     */     });
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2gatherdata.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */