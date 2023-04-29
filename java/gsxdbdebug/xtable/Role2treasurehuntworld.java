/*     */ package xtable;
/*     */ 
/*     */ import java.util.Map;
/*     */ import xbean.Role2TreasureHuntWorldInfo;
/*     */ import xdb.TField;
/*     */ import xdb.TTable;
/*     */ 
/*     */ public class Role2treasurehuntworld
/*     */ {
/*     */   public static Role2TreasureHuntWorldInfo get(Long key)
/*     */   {
/*  12 */     return (Role2TreasureHuntWorldInfo)_Tables_.getInstance().role2treasurehuntworld.get(key);
/*     */   }
/*     */   
/*     */   public static Role2TreasureHuntWorldInfo get(Long key, Role2TreasureHuntWorldInfo value)
/*     */   {
/*  17 */     return (Role2TreasureHuntWorldInfo)_Tables_.getInstance().role2treasurehuntworld.get(key, value);
/*     */   }
/*     */   
/*     */   public static void insert(Long key, Role2TreasureHuntWorldInfo value)
/*     */   {
/*  22 */     _Tables_.getInstance().role2treasurehuntworld.insert(key, value);
/*     */   }
/*     */   
/*     */   public static void delete(Long key)
/*     */   {
/*  27 */     _Tables_.getInstance().role2treasurehuntworld.delete(key);
/*     */   }
/*     */   
/*     */   public static boolean add(Long key, Role2TreasureHuntWorldInfo value)
/*     */   {
/*  32 */     return _Tables_.getInstance().role2treasurehuntworld.add(key, value);
/*     */   }
/*     */   
/*     */   public static boolean remove(Long key)
/*     */   {
/*  37 */     return _Tables_.getInstance().role2treasurehuntworld.remove(key);
/*     */   }
/*     */   
/*     */   public static xdb.TTableCache<Long, Role2TreasureHuntWorldInfo> getCache()
/*     */   {
/*  42 */     return _Tables_.getInstance().role2treasurehuntworld.getCache();
/*     */   }
/*     */   
/*     */   public static TTable<Long, Role2TreasureHuntWorldInfo> getTable()
/*     */   {
/*  47 */     return _Tables_.getInstance().role2treasurehuntworld;
/*     */   }
/*     */   
/*     */   public static Role2TreasureHuntWorldInfo select(Long key)
/*     */   {
/*  52 */     (Role2TreasureHuntWorldInfo)getTable().select(key, new TField()
/*     */     {
/*     */       public Role2TreasureHuntWorldInfo get(Role2TreasureHuntWorldInfo v)
/*     */       {
/*  56 */         return v.toData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectWorld_id(Long key)
/*     */   {
/*  63 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(Role2TreasureHuntWorldInfo v)
/*     */       {
/*  67 */         return Long.valueOf(v.getWorld_id());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectChapter_cfg_id(Long key)
/*     */   {
/*  74 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(Role2TreasureHuntWorldInfo v)
/*     */       {
/*  78 */         return Integer.valueOf(v.getChapter_cfg_id());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectProcess(Long key)
/*     */   {
/*  85 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(Role2TreasureHuntWorldInfo v)
/*     */       {
/*  89 */         return Integer.valueOf(v.getProcess());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectSession_id(Long key)
/*     */   {
/*  96 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(Role2TreasureHuntWorldInfo v)
/*     */       {
/* 100 */         return Long.valueOf(v.getSession_id());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Map<Integer, Integer> selectTrigger_effect_map(Long key)
/*     */   {
/* 107 */     (Map)getTable().select(key, new TField()
/*     */     {
/*     */       public Map<Integer, Integer> get(Role2TreasureHuntWorldInfo v)
/*     */       {
/* 111 */         return v.getTrigger_effect_mapAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static java.util.Set<Integer> selectTrigger_buff_set(Long key)
/*     */   {
/* 118 */     (java.util.Set)getTable().select(key, new TField()
/*     */     {
/*     */       public java.util.Set<Integer> get(Role2TreasureHuntWorldInfo v)
/*     */       {
/* 122 */         return v.getTrigger_buff_setAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2treasurehuntworld.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */