/*     */ package xtable;
/*     */ 
/*     */ import java.util.Set;
/*     */ import xbean.DoublePoint;
/*     */ import xdb.TField;
/*     */ import xdb.TTable;
/*     */ 
/*     */ public class Role2doublepoint
/*     */ {
/*     */   public static DoublePoint get(Long key)
/*     */   {
/*  12 */     return (DoublePoint)_Tables_.getInstance().role2doublepoint.get(key);
/*     */   }
/*     */   
/*     */   public static DoublePoint get(Long key, DoublePoint value)
/*     */   {
/*  17 */     return (DoublePoint)_Tables_.getInstance().role2doublepoint.get(key, value);
/*     */   }
/*     */   
/*     */   public static void insert(Long key, DoublePoint value)
/*     */   {
/*  22 */     _Tables_.getInstance().role2doublepoint.insert(key, value);
/*     */   }
/*     */   
/*     */   public static void delete(Long key)
/*     */   {
/*  27 */     _Tables_.getInstance().role2doublepoint.delete(key);
/*     */   }
/*     */   
/*     */   public static boolean add(Long key, DoublePoint value)
/*     */   {
/*  32 */     return _Tables_.getInstance().role2doublepoint.add(key, value);
/*     */   }
/*     */   
/*     */   public static boolean remove(Long key)
/*     */   {
/*  37 */     return _Tables_.getInstance().role2doublepoint.remove(key);
/*     */   }
/*     */   
/*     */   public static xdb.TTableCache<Long, DoublePoint> getCache()
/*     */   {
/*  42 */     return _Tables_.getInstance().role2doublepoint.getCache();
/*     */   }
/*     */   
/*     */   public static TTable<Long, DoublePoint> getTable()
/*     */   {
/*  47 */     return _Tables_.getInstance().role2doublepoint;
/*     */   }
/*     */   
/*     */   public static DoublePoint select(Long key)
/*     */   {
/*  52 */     (DoublePoint)getTable().select(key, new TField()
/*     */     {
/*     */       public DoublePoint get(DoublePoint v)
/*     */       {
/*  56 */         return v.toData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectGettingpoolpointnum(Long key)
/*     */   {
/*  63 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(DoublePoint v)
/*     */       {
/*  67 */         return Integer.valueOf(v.getGettingpoolpointnum());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectFrozenpoolpointnum(Long key)
/*     */   {
/*  74 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(DoublePoint v)
/*     */       {
/*  78 */         return Integer.valueOf(v.getFrozenpoolpointnum());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectOffertimestamp(Long key)
/*     */   {
/*  85 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(DoublePoint v)
/*     */       {
/*  89 */         return Long.valueOf(v.getOffertimestamp());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectResetitemusetimestamp(Long key)
/*     */   {
/*  96 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(DoublePoint v)
/*     */       {
/* 100 */         return Long.valueOf(v.getResetitemusetimestamp());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectItemusecount(Long key)
/*     */   {
/* 107 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(DoublePoint v)
/*     */       {
/* 111 */         return Integer.valueOf(v.getItemusecount());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Set<Integer> selectSwitches(Long key)
/*     */   {
/* 118 */     (Set)getTable().select(key, new TField()
/*     */     {
/*     */       public Set<Integer> get(DoublePoint v)
/*     */       {
/* 122 */         return v.getSwitchesAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Set<Integer> selectSwitch_inits(Long key)
/*     */   {
/* 129 */     (Set)getTable().select(key, new TField()
/*     */     {
/*     */       public Set<Integer> get(DoublePoint v)
/*     */       {
/* 133 */         return v.getSwitch_initsAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2doublepoint.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */