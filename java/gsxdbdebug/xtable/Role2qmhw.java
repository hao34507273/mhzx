/*     */ package xtable;
/*     */ 
/*     */ import java.util.Set;
/*     */ import xbean.RoleQMHWScore;
/*     */ import xdb.TField;
/*     */ import xdb.TTable;
/*     */ 
/*     */ public class Role2qmhw
/*     */ {
/*     */   public static RoleQMHWScore get(Long key)
/*     */   {
/*  12 */     return (RoleQMHWScore)_Tables_.getInstance().role2qmhw.get(key);
/*     */   }
/*     */   
/*     */   public static RoleQMHWScore get(Long key, RoleQMHWScore value)
/*     */   {
/*  17 */     return (RoleQMHWScore)_Tables_.getInstance().role2qmhw.get(key, value);
/*     */   }
/*     */   
/*     */   public static void insert(Long key, RoleQMHWScore value)
/*     */   {
/*  22 */     _Tables_.getInstance().role2qmhw.insert(key, value);
/*     */   }
/*     */   
/*     */   public static void delete(Long key)
/*     */   {
/*  27 */     _Tables_.getInstance().role2qmhw.delete(key);
/*     */   }
/*     */   
/*     */   public static boolean add(Long key, RoleQMHWScore value)
/*     */   {
/*  32 */     return _Tables_.getInstance().role2qmhw.add(key, value);
/*     */   }
/*     */   
/*     */   public static boolean remove(Long key)
/*     */   {
/*  37 */     return _Tables_.getInstance().role2qmhw.remove(key);
/*     */   }
/*     */   
/*     */   public static xdb.TTableCache<Long, RoleQMHWScore> getCache()
/*     */   {
/*  42 */     return _Tables_.getInstance().role2qmhw.getCache();
/*     */   }
/*     */   
/*     */   public static TTable<Long, RoleQMHWScore> getTable()
/*     */   {
/*  47 */     return _Tables_.getInstance().role2qmhw;
/*     */   }
/*     */   
/*     */   public static RoleQMHWScore select(Long key)
/*     */   {
/*  52 */     (RoleQMHWScore)getTable().select(key, new TField()
/*     */     {
/*     */       public RoleQMHWScore get(RoleQMHWScore v)
/*     */       {
/*  56 */         return v.toData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectScore(Long key)
/*     */   {
/*  63 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(RoleQMHWScore v)
/*     */       {
/*  67 */         return Integer.valueOf(v.getScore());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectWincount(Long key)
/*     */   {
/*  74 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(RoleQMHWScore v)
/*     */       {
/*  78 */         return Integer.valueOf(v.getWincount());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectLosecount(Long key)
/*     */   {
/*  85 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(RoleQMHWScore v)
/*     */       {
/*  89 */         return Integer.valueOf(v.getLosecount());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectContinuewincount(Long key)
/*     */   {
/*  96 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(RoleQMHWScore v)
/*     */       {
/* 100 */         return Integer.valueOf(v.getContinuewincount());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Set<Integer> selectGetawards(Long key)
/*     */   {
/* 107 */     (Set)getTable().select(key, new TField()
/*     */     {
/*     */       public Set<Integer> get(RoleQMHWScore v)
/*     */       {
/* 111 */         return v.getGetawardsAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Set<Integer> selectGetjoinawards(Long key)
/*     */   {
/* 118 */     (Set)getTable().select(key, new TField()
/*     */     {
/*     */       public Set<Integer> get(RoleQMHWScore v)
/*     */       {
/* 122 */         return v.getGetjoinawardsAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static java.util.Map<Long, Integer> selectMatchroles(Long key)
/*     */   {
/* 129 */     (java.util.Map)getTable().select(key, new TField()
/*     */     {
/*     */       public java.util.Map<Long, Integer> get(RoleQMHWScore v)
/*     */       {
/* 133 */         return v.getMatchrolesAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectExtendmatchscore(Long key)
/*     */   {
/* 140 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(RoleQMHWScore v)
/*     */       {
/* 144 */         return Integer.valueOf(v.getExtendmatchscore());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Set<Long> selectLatestmatchroles(Long key)
/*     */   {
/* 151 */     (Set)getTable().select(key, new TField()
/*     */     {
/*     */       public Set<Long> get(RoleQMHWScore v)
/*     */       {
/* 155 */         return v.getLatestmatchrolesAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2qmhw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */