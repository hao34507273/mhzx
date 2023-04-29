/*     */ package xtable;
/*     */ 
/*     */ import java.util.Map;
/*     */ import xbean.FactionCrossCompete;
/*     */ import xdb.TField;
/*     */ import xdb.TTable;
/*     */ 
/*     */ public class Faction_crosscompete
/*     */ {
/*     */   public static FactionCrossCompete get(Long key)
/*     */   {
/*  12 */     return (FactionCrossCompete)_Tables_.getInstance().faction_crosscompete.get(key);
/*     */   }
/*     */   
/*     */   public static FactionCrossCompete get(Long key, FactionCrossCompete value)
/*     */   {
/*  17 */     return (FactionCrossCompete)_Tables_.getInstance().faction_crosscompete.get(key, value);
/*     */   }
/*     */   
/*     */   public static void insert(Long key, FactionCrossCompete value)
/*     */   {
/*  22 */     _Tables_.getInstance().faction_crosscompete.insert(key, value);
/*     */   }
/*     */   
/*     */   public static void delete(Long key)
/*     */   {
/*  27 */     _Tables_.getInstance().faction_crosscompete.delete(key);
/*     */   }
/*     */   
/*     */   public static boolean add(Long key, FactionCrossCompete value)
/*     */   {
/*  32 */     return _Tables_.getInstance().faction_crosscompete.add(key, value);
/*     */   }
/*     */   
/*     */   public static boolean remove(Long key)
/*     */   {
/*  37 */     return _Tables_.getInstance().faction_crosscompete.remove(key);
/*     */   }
/*     */   
/*     */   public static xdb.TTableCache<Long, FactionCrossCompete> getCache()
/*     */   {
/*  42 */     return _Tables_.getInstance().faction_crosscompete.getCache();
/*     */   }
/*     */   
/*     */   public static TTable<Long, FactionCrossCompete> getTable()
/*     */   {
/*  47 */     return _Tables_.getInstance().faction_crosscompete;
/*     */   }
/*     */   
/*     */   public static FactionCrossCompete select(Long key)
/*     */   {
/*  52 */     (FactionCrossCompete)getTable().select(key, new TField()
/*     */     {
/*     */       public FactionCrossCompete get(FactionCrossCompete v)
/*     */       {
/*  56 */         return v.toData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectSignup_time(Long key)
/*     */   {
/*  63 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(FactionCrossCompete v)
/*     */       {
/*  67 */         return Long.valueOf(v.getSignup_time());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectWin_times(Long key)
/*     */   {
/*  74 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(FactionCrossCompete v)
/*     */       {
/*  78 */         return Integer.valueOf(v.getWin_times());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectLose_times(Long key)
/*     */   {
/*  85 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(FactionCrossCompete v)
/*     */       {
/*  89 */         return Integer.valueOf(v.getLose_times());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Map<Long, Integer> selectFactionid2matchtimes(Long key)
/*     */   {
/*  96 */     (Map)getTable().select(key, new TField()
/*     */     {
/*     */       public Map<Long, Integer> get(FactionCrossCompete v)
/*     */       {
/* 100 */         return v.getFactionid2matchtimesAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectMiss_turn_times(Long key)
/*     */   {
/* 107 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(FactionCrossCompete v)
/*     */       {
/* 111 */         return Integer.valueOf(v.getMiss_turn_times());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectOpponent(Long key)
/*     */   {
/* 118 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(FactionCrossCompete v)
/*     */       {
/* 122 */         return Long.valueOf(v.getOpponent());
/*     */       }
/*     */     });
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Faction_crosscompete.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */