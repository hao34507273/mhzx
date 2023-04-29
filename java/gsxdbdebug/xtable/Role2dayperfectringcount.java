/*     */ package xtable;
/*     */ 
/*     */ import xbean.DayPerfectRingCout;
/*     */ import xdb.TField;
/*     */ import xdb.TTable;
/*     */ import xdb.TTableCache;
/*     */ 
/*     */ public class Role2dayperfectringcount
/*     */ {
/*     */   public static DayPerfectRingCout get(Long key)
/*     */   {
/*  12 */     return (DayPerfectRingCout)_Tables_.getInstance().role2dayperfectringcount.get(key);
/*     */   }
/*     */   
/*     */   public static DayPerfectRingCout get(Long key, DayPerfectRingCout value)
/*     */   {
/*  17 */     return (DayPerfectRingCout)_Tables_.getInstance().role2dayperfectringcount.get(key, value);
/*     */   }
/*     */   
/*     */   public static void insert(Long key, DayPerfectRingCout value)
/*     */   {
/*  22 */     _Tables_.getInstance().role2dayperfectringcount.insert(key, value);
/*     */   }
/*     */   
/*     */   public static void delete(Long key)
/*     */   {
/*  27 */     _Tables_.getInstance().role2dayperfectringcount.delete(key);
/*     */   }
/*     */   
/*     */   public static boolean add(Long key, DayPerfectRingCout value)
/*     */   {
/*  32 */     return _Tables_.getInstance().role2dayperfectringcount.add(key, value);
/*     */   }
/*     */   
/*     */   public static boolean remove(Long key)
/*     */   {
/*  37 */     return _Tables_.getInstance().role2dayperfectringcount.remove(key);
/*     */   }
/*     */   
/*     */   public static TTableCache<Long, DayPerfectRingCout> getCache()
/*     */   {
/*  42 */     return _Tables_.getInstance().role2dayperfectringcount.getCache();
/*     */   }
/*     */   
/*     */   public static TTable<Long, DayPerfectRingCout> getTable()
/*     */   {
/*  47 */     return _Tables_.getInstance().role2dayperfectringcount;
/*     */   }
/*     */   
/*     */   public static DayPerfectRingCout select(Long key)
/*     */   {
/*  52 */     (DayPerfectRingCout)getTable().select(key, new TField()
/*     */     {
/*     */       public DayPerfectRingCout get(DayPerfectRingCout v)
/*     */       {
/*  56 */         return v.toData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Boolean selectHasgiveup(Long key)
/*     */   {
/*  63 */     (Boolean)getTable().select(key, new TField()
/*     */     {
/*     */       public Boolean get(DayPerfectRingCout v)
/*     */       {
/*  67 */         return Boolean.valueOf(v.getHasgiveup());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectCurrentring(Long key)
/*     */   {
/*  74 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(DayPerfectRingCout v)
/*     */       {
/*  78 */         return Integer.valueOf(v.getCurrentring());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectCleantime(Long key)
/*     */   {
/*  85 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(DayPerfectRingCout v)
/*     */       {
/*  89 */         return Long.valueOf(v.getCleantime());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectShimencount(Long key)
/*     */   {
/*  96 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(DayPerfectRingCout v)
/*     */       {
/* 100 */         return Integer.valueOf(v.getShimencount());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectReservedexp(Long key)
/*     */   {
/* 107 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(DayPerfectRingCout v)
/*     */       {
/* 111 */         return Integer.valueOf(v.getReservedexp());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectExchangecount(Long key)
/*     */   {
/* 118 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(DayPerfectRingCout v)
/*     */       {
/* 122 */         return Integer.valueOf(v.getExchangecount());
/*     */       }
/*     */     });
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2dayperfectringcount.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */