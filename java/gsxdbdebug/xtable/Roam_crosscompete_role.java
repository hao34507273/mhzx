/*     */ package xtable;
/*     */ 
/*     */ import xbean.RoamCrossCompeteRole;
/*     */ import xdb.TField;
/*     */ import xdb.TTable;
/*     */ import xdb.TTableCache;
/*     */ 
/*     */ public class Roam_crosscompete_role
/*     */ {
/*     */   public static RoamCrossCompeteRole get(Long key)
/*     */   {
/*  12 */     return (RoamCrossCompeteRole)_Tables_.getInstance().roam_crosscompete_role.get(key);
/*     */   }
/*     */   
/*     */   public static RoamCrossCompeteRole get(Long key, RoamCrossCompeteRole value)
/*     */   {
/*  17 */     return (RoamCrossCompeteRole)_Tables_.getInstance().roam_crosscompete_role.get(key, value);
/*     */   }
/*     */   
/*     */   public static void insert(Long key, RoamCrossCompeteRole value)
/*     */   {
/*  22 */     _Tables_.getInstance().roam_crosscompete_role.insert(key, value);
/*     */   }
/*     */   
/*     */   public static void delete(Long key)
/*     */   {
/*  27 */     _Tables_.getInstance().roam_crosscompete_role.delete(key);
/*     */   }
/*     */   
/*     */   public static boolean add(Long key, RoamCrossCompeteRole value)
/*     */   {
/*  32 */     return _Tables_.getInstance().roam_crosscompete_role.add(key, value);
/*     */   }
/*     */   
/*     */   public static boolean remove(Long key)
/*     */   {
/*  37 */     return _Tables_.getInstance().roam_crosscompete_role.remove(key);
/*     */   }
/*     */   
/*     */   public static TTableCache<Long, RoamCrossCompeteRole> getCache()
/*     */   {
/*  42 */     return _Tables_.getInstance().roam_crosscompete_role.getCache();
/*     */   }
/*     */   
/*     */   public static TTable<Long, RoamCrossCompeteRole> getTable()
/*     */   {
/*  47 */     return _Tables_.getInstance().roam_crosscompete_role;
/*     */   }
/*     */   
/*     */   public static RoamCrossCompeteRole select(Long key)
/*     */   {
/*  52 */     (RoamCrossCompeteRole)getTable().select(key, new TField()
/*     */     {
/*     */       public RoamCrossCompeteRole get(RoamCrossCompeteRole v)
/*     */       {
/*  56 */         return v.toData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectFactionid(Long key)
/*     */   {
/*  63 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(RoamCrossCompeteRole v)
/*     */       {
/*  67 */         return Long.valueOf(v.getFactionid());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectDuty(Long key)
/*     */   {
/*  74 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(RoamCrossCompeteRole v)
/*     */       {
/*  78 */         return Integer.valueOf(v.getDuty());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectAction_point(Long key)
/*     */   {
/*  85 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(RoamCrossCompeteRole v)
/*     */       {
/*  89 */         return Integer.valueOf(v.getAction_point());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectWin_times(Long key)
/*     */   {
/*  96 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(RoamCrossCompeteRole v)
/*     */       {
/* 100 */         return Integer.valueOf(v.getWin_times());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectLose_times(Long key)
/*     */   {
/* 107 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(RoamCrossCompeteRole v)
/*     */       {
/* 111 */         return Integer.valueOf(v.getLose_times());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectWin_streak(Long key)
/*     */   {
/* 118 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(RoamCrossCompeteRole v)
/*     */       {
/* 122 */         return Integer.valueOf(v.getWin_streak());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectWin_streak_awards(Long key)
/*     */   {
/* 129 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(RoamCrossCompeteRole v)
/*     */       {
/* 133 */         return Integer.valueOf(v.getWin_streak_awards());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectFinal_award(Long key)
/*     */   {
/* 140 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(RoamCrossCompeteRole v)
/*     */       {
/* 144 */         return Integer.valueOf(v.getFinal_award());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectEscape_times(Long key)
/*     */   {
/* 151 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(RoamCrossCompeteRole v)
/*     */       {
/* 155 */         return Integer.valueOf(v.getEscape_times());
/*     */       }
/*     */     });
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Roam_crosscompete_role.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */