/*     */ package xtable;
/*     */ 
/*     */ import java.util.Map;
/*     */ import xbean.FactionPVETmp;
/*     */ import xdb.TField;
/*     */ import xdb.TTable;
/*     */ 
/*     */ public class Factionpve_tmp
/*     */ {
/*     */   public static FactionPVETmp get(Long key)
/*     */   {
/*  12 */     return (FactionPVETmp)_Tables_.getInstance().factionpve_tmp.get(key);
/*     */   }
/*     */   
/*     */   public static FactionPVETmp get(Long key, FactionPVETmp value)
/*     */   {
/*  17 */     return (FactionPVETmp)_Tables_.getInstance().factionpve_tmp.get(key, value);
/*     */   }
/*     */   
/*     */   public static void insert(Long key, FactionPVETmp value)
/*     */   {
/*  22 */     _Tables_.getInstance().factionpve_tmp.insert(key, value);
/*     */   }
/*     */   
/*     */   public static void delete(Long key)
/*     */   {
/*  27 */     _Tables_.getInstance().factionpve_tmp.delete(key);
/*     */   }
/*     */   
/*     */   public static boolean add(Long key, FactionPVETmp value)
/*     */   {
/*  32 */     return _Tables_.getInstance().factionpve_tmp.add(key, value);
/*     */   }
/*     */   
/*     */   public static boolean remove(Long key)
/*     */   {
/*  37 */     return _Tables_.getInstance().factionpve_tmp.remove(key);
/*     */   }
/*     */   
/*     */   public static xdb.TTableCache<Long, FactionPVETmp> getCache()
/*     */   {
/*  42 */     return _Tables_.getInstance().factionpve_tmp.getCache();
/*     */   }
/*     */   
/*     */   public static TTable<Long, FactionPVETmp> getTable()
/*     */   {
/*  47 */     return _Tables_.getInstance().factionpve_tmp;
/*     */   }
/*     */   
/*     */   public static FactionPVETmp select(Long key)
/*     */   {
/*  52 */     (FactionPVETmp)getTable().select(key, new TField()
/*     */     {
/*     */       public FactionPVETmp get(FactionPVETmp v)
/*     */       {
/*  56 */         return v.toData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectWorld(Long key)
/*     */   {
/*  63 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(FactionPVETmp v)
/*     */       {
/*  67 */         return Long.valueOf(v.getWorld());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectStage(Long key)
/*     */   {
/*  74 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(FactionPVETmp v)
/*     */       {
/*  78 */         return Integer.valueOf(v.getStage());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectSessionid(Long key)
/*     */   {
/*  85 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(FactionPVETmp v)
/*     */       {
/*  89 */         return Long.valueOf(v.getSessionid());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Map<Integer, Integer> selectGoal(Long key)
/*     */   {
/*  96 */     (Map)getTable().select(key, new TField()
/*     */     {
/*     */       public Map<Integer, Integer> get(FactionPVETmp v)
/*     */       {
/* 100 */         return v.getGoalAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectEnd_sessionid(Long key)
/*     */   {
/* 107 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(FactionPVETmp v)
/*     */       {
/* 111 */         return Long.valueOf(v.getEnd_sessionid());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static java.util.Set<Long> selectFights(Long key)
/*     */   {
/* 118 */     (java.util.Set)getTable().select(key, new TField()
/*     */     {
/*     */       public java.util.Set<Long> get(FactionPVETmp v)
/*     */       {
/* 122 */         return v.getFightsAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Map<Integer, Integer> selectKilled_boss(Long key)
/*     */   {
/* 129 */     (Map)getTable().select(key, new TField()
/*     */     {
/*     */       public Map<Integer, Integer> get(FactionPVETmp v)
/*     */       {
/* 133 */         return v.getKilled_bossAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Factionpve_tmp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */