/*     */ package xtable;
/*     */ 
/*     */ import xbean.CircleTask;
/*     */ import xdb.TField;
/*     */ import xdb.TTable;
/*     */ import xdb.TTableCache;
/*     */ 
/*     */ public class Role2circletask
/*     */ {
/*     */   public static CircleTask get(Long key)
/*     */   {
/*  12 */     return (CircleTask)_Tables_.getInstance().role2circletask.get(key);
/*     */   }
/*     */   
/*     */   public static CircleTask get(Long key, CircleTask value)
/*     */   {
/*  17 */     return (CircleTask)_Tables_.getInstance().role2circletask.get(key, value);
/*     */   }
/*     */   
/*     */   public static void insert(Long key, CircleTask value)
/*     */   {
/*  22 */     _Tables_.getInstance().role2circletask.insert(key, value);
/*     */   }
/*     */   
/*     */   public static void delete(Long key)
/*     */   {
/*  27 */     _Tables_.getInstance().role2circletask.delete(key);
/*     */   }
/*     */   
/*     */   public static boolean add(Long key, CircleTask value)
/*     */   {
/*  32 */     return _Tables_.getInstance().role2circletask.add(key, value);
/*     */   }
/*     */   
/*     */   public static boolean remove(Long key)
/*     */   {
/*  37 */     return _Tables_.getInstance().role2circletask.remove(key);
/*     */   }
/*     */   
/*     */   public static TTableCache<Long, CircleTask> getCache()
/*     */   {
/*  42 */     return _Tables_.getInstance().role2circletask.getCache();
/*     */   }
/*     */   
/*     */   public static TTable<Long, CircleTask> getTable()
/*     */   {
/*  47 */     return _Tables_.getInstance().role2circletask;
/*     */   }
/*     */   
/*     */   public static CircleTask select(Long key)
/*     */   {
/*  52 */     (CircleTask)getTable().select(key, new TField()
/*     */     {
/*     */       public CircleTask get(CircleTask v)
/*     */       {
/*  56 */         return v.toData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectLegendendtime(Long key)
/*     */   {
/*  63 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(CircleTask v)
/*     */       {
/*  67 */         return Long.valueOf(v.getLegendendtime());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectRenxingcounter(Long key)
/*     */   {
/*  74 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(CircleTask v)
/*     */       {
/*  78 */         return Integer.valueOf(v.getRenxingcounter());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectTaskid(Long key)
/*     */   {
/*  85 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(CircleTask v)
/*     */       {
/*  89 */         return Integer.valueOf(v.getTaskid());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectFactioncontribution(Long key)
/*     */   {
/*  96 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(CircleTask v)
/*     */       {
/* 100 */         return Integer.valueOf(v.getFactioncontribution());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectFactioncontributionupdatetime(Long key)
/*     */   {
/* 107 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(CircleTask v)
/*     */       {
/* 111 */         return Long.valueOf(v.getFactioncontributionupdatetime());
/*     */       }
/*     */     });
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2circletask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */