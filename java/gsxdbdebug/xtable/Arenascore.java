/*     */ package xtable;
/*     */ 
/*     */ import java.util.Map;
/*     */ import xbean.ArenaScore;
/*     */ import xdb.TField;
/*     */ import xdb.TTable;
/*     */ 
/*     */ public class Arenascore
/*     */ {
/*     */   public static ArenaScore get(Long key)
/*     */   {
/*  12 */     return (ArenaScore)_Tables_.getInstance().arenascore.get(key);
/*     */   }
/*     */   
/*     */   public static ArenaScore get(Long key, ArenaScore value)
/*     */   {
/*  17 */     return (ArenaScore)_Tables_.getInstance().arenascore.get(key, value);
/*     */   }
/*     */   
/*     */   public static void insert(Long key, ArenaScore value)
/*     */   {
/*  22 */     _Tables_.getInstance().arenascore.insert(key, value);
/*     */   }
/*     */   
/*     */   public static void delete(Long key)
/*     */   {
/*  27 */     _Tables_.getInstance().arenascore.delete(key);
/*     */   }
/*     */   
/*     */   public static boolean add(Long key, ArenaScore value)
/*     */   {
/*  32 */     return _Tables_.getInstance().arenascore.add(key, value);
/*     */   }
/*     */   
/*     */   public static boolean remove(Long key)
/*     */   {
/*  37 */     return _Tables_.getInstance().arenascore.remove(key);
/*     */   }
/*     */   
/*     */   public static xdb.TTableCache<Long, ArenaScore> getCache()
/*     */   {
/*  42 */     return _Tables_.getInstance().arenascore.getCache();
/*     */   }
/*     */   
/*     */   public static TTable<Long, ArenaScore> getTable()
/*     */   {
/*  47 */     return _Tables_.getInstance().arenascore;
/*     */   }
/*     */   
/*     */   public static ArenaScore select(Long key)
/*     */   {
/*  52 */     (ArenaScore)getTable().select(key, new TField()
/*     */     {
/*     */       public ArenaScore get(ArenaScore v)
/*     */       {
/*  56 */         return v.toData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectCamp(Long key)
/*     */   {
/*  63 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(ArenaScore v)
/*     */       {
/*  67 */         return Integer.valueOf(v.getCamp());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectScore(Long key)
/*     */   {
/*  74 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(ArenaScore v)
/*     */       {
/*  78 */         return Integer.valueOf(v.getScore());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectAction_point(Long key)
/*     */   {
/*  85 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(ArenaScore v)
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
/*     */       public Integer get(ArenaScore v)
/*     */       {
/* 100 */         return Integer.valueOf(v.getWin_times());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static java.util.Set<Integer> selectGet_awards(Long key)
/*     */   {
/* 107 */     (java.util.Set)getTable().select(key, new TField()
/*     */     {
/*     */       public java.util.Set<Integer> get(ArenaScore v)
/*     */       {
/* 111 */         return v.getGet_awardsAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Boolean selectParticipated(Long key)
/*     */   {
/* 118 */     (Boolean)getTable().select(key, new TField()
/*     */     {
/*     */       public Boolean get(ArenaScore v)
/*     */       {
/* 122 */         return Boolean.valueOf(v.getParticipated());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Map<Long, Integer> selectMatchroles(Long key)
/*     */   {
/* 129 */     (Map)getTable().select(key, new TField()
/*     */     {
/*     */       public Map<Long, Integer> get(ArenaScore v)
/*     */       {
/* 133 */         return v.getMatchrolesAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Arenascore.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */