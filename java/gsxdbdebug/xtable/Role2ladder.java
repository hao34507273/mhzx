/*     */ package xtable;
/*     */ 
/*     */ import java.util.Set;
/*     */ import xbean.Ladder;
/*     */ import xdb.TField;
/*     */ import xdb.TTable;
/*     */ 
/*     */ public class Role2ladder
/*     */ {
/*     */   public static Ladder get(Long key)
/*     */   {
/*  12 */     return (Ladder)_Tables_.getInstance().role2ladder.get(key);
/*     */   }
/*     */   
/*     */   public static Ladder get(Long key, Ladder value)
/*     */   {
/*  17 */     return (Ladder)_Tables_.getInstance().role2ladder.get(key, value);
/*     */   }
/*     */   
/*     */   public static void insert(Long key, Ladder value)
/*     */   {
/*  22 */     _Tables_.getInstance().role2ladder.insert(key, value);
/*     */   }
/*     */   
/*     */   public static void delete(Long key)
/*     */   {
/*  27 */     _Tables_.getInstance().role2ladder.delete(key);
/*     */   }
/*     */   
/*     */   public static boolean add(Long key, Ladder value)
/*     */   {
/*  32 */     return _Tables_.getInstance().role2ladder.add(key, value);
/*     */   }
/*     */   
/*     */   public static boolean remove(Long key)
/*     */   {
/*  37 */     return _Tables_.getInstance().role2ladder.remove(key);
/*     */   }
/*     */   
/*     */   public static xdb.TTableCache<Long, Ladder> getCache()
/*     */   {
/*  42 */     return _Tables_.getInstance().role2ladder.getCache();
/*     */   }
/*     */   
/*     */   public static TTable<Long, Ladder> getTable()
/*     */   {
/*  47 */     return _Tables_.getInstance().role2ladder;
/*     */   }
/*     */   
/*     */   public static Ladder select(Long key)
/*     */   {
/*  52 */     (Ladder)getTable().select(key, new TField()
/*     */     {
/*     */       public Ladder get(Ladder v)
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
/*     */       public Integer get(Ladder v)
/*     */       {
/*  67 */         return Integer.valueOf(v.getScore());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectStage(Long key)
/*     */   {
/*  74 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(Ladder v)
/*     */       {
/*  78 */         return Integer.valueOf(v.getStage());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectWincount(Long key)
/*     */   {
/*  85 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(Ladder v)
/*     */       {
/*  89 */         return Integer.valueOf(v.getWincount());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectLosecount(Long key)
/*     */   {
/*  96 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(Ladder v)
/*     */       {
/* 100 */         return Integer.valueOf(v.getLosecount());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Set<Integer> selectAwardstages(Long key)
/*     */   {
/* 107 */     (Set)getTable().select(key, new TField()
/*     */     {
/*     */       public Set<Integer> get(Ladder v)
/*     */       {
/* 111 */         return v.getAwardstagesAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectInittime(Long key)
/*     */   {
/* 118 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(Ladder v)
/*     */       {
/* 122 */         return Long.valueOf(v.getInittime());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectWeekinittime(Long key)
/*     */   {
/* 129 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(Ladder v)
/*     */       {
/* 133 */         return Long.valueOf(v.getWeekinittime());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectWeekfightcount(Long key)
/*     */   {
/* 140 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(Ladder v)
/*     */       {
/* 144 */         return Integer.valueOf(v.getWeekfightcount());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectWeekgotfightscore(Long key)
/*     */   {
/* 151 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(Ladder v)
/*     */       {
/* 155 */         return Long.valueOf(v.getWeekgotfightscore());
/*     */       }
/*     */     });
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2ladder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */