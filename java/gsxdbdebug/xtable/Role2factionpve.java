/*     */ package xtable;
/*     */ 
/*     */ import java.util.Map;
/*     */ import xbean.RoleFactionPVE;
/*     */ import xdb.TField;
/*     */ import xdb.TTable;
/*     */ 
/*     */ public class Role2factionpve
/*     */ {
/*     */   public static RoleFactionPVE get(Long key)
/*     */   {
/*  12 */     return (RoleFactionPVE)_Tables_.getInstance().role2factionpve.get(key);
/*     */   }
/*     */   
/*     */   public static RoleFactionPVE get(Long key, RoleFactionPVE value)
/*     */   {
/*  17 */     return (RoleFactionPVE)_Tables_.getInstance().role2factionpve.get(key, value);
/*     */   }
/*     */   
/*     */   public static void insert(Long key, RoleFactionPVE value)
/*     */   {
/*  22 */     _Tables_.getInstance().role2factionpve.insert(key, value);
/*     */   }
/*     */   
/*     */   public static void delete(Long key)
/*     */   {
/*  27 */     _Tables_.getInstance().role2factionpve.delete(key);
/*     */   }
/*     */   
/*     */   public static boolean add(Long key, RoleFactionPVE value)
/*     */   {
/*  32 */     return _Tables_.getInstance().role2factionpve.add(key, value);
/*     */   }
/*     */   
/*     */   public static boolean remove(Long key)
/*     */   {
/*  37 */     return _Tables_.getInstance().role2factionpve.remove(key);
/*     */   }
/*     */   
/*     */   public static xdb.TTableCache<Long, RoleFactionPVE> getCache()
/*     */   {
/*  42 */     return _Tables_.getInstance().role2factionpve.getCache();
/*     */   }
/*     */   
/*     */   public static TTable<Long, RoleFactionPVE> getTable()
/*     */   {
/*  47 */     return _Tables_.getInstance().role2factionpve;
/*     */   }
/*     */   
/*     */   public static RoleFactionPVE select(Long key)
/*     */   {
/*  52 */     (RoleFactionPVE)getTable().select(key, new TField()
/*     */     {
/*     */       public RoleFactionPVE get(RoleFactionPVE v)
/*     */       {
/*  56 */         return v.toData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectParticipate_millis(Long key)
/*     */   {
/*  63 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(RoleFactionPVE v)
/*     */       {
/*  67 */         return Long.valueOf(v.getParticipate_millis());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectParticipate_times(Long key)
/*     */   {
/*  74 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(RoleFactionPVE v)
/*     */       {
/*  78 */         return Integer.valueOf(v.getParticipate_times());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Map<Integer, Integer> selectGoal(Long key)
/*     */   {
/*  85 */     (Map)getTable().select(key, new TField()
/*     */     {
/*     */       public Map<Integer, Integer> get(RoleFactionPVE v)
/*     */       {
/*  89 */         return v.getGoalAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectGoal_times(Long key)
/*     */   {
/*  96 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(RoleFactionPVE v)
/*     */       {
/* 100 */         return Integer.valueOf(v.getGoal_times());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectParticipate_faction(Long key)
/*     */   {
/* 107 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(RoleFactionPVE v)
/*     */       {
/* 111 */         return Long.valueOf(v.getParticipate_faction());
/*     */       }
/*     */     });
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2factionpve.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */