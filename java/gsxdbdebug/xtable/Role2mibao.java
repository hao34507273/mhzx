/*     */ package xtable;
/*     */ 
/*     */ import java.util.Map;
/*     */ import xbean.Role2MiBaoInfo;
/*     */ import xdb.TField;
/*     */ import xdb.TTable;
/*     */ 
/*     */ public class Role2mibao
/*     */ {
/*     */   public static Role2MiBaoInfo get(Long key)
/*     */   {
/*  12 */     return (Role2MiBaoInfo)_Tables_.getInstance().role2mibao.get(key);
/*     */   }
/*     */   
/*     */   public static Role2MiBaoInfo get(Long key, Role2MiBaoInfo value)
/*     */   {
/*  17 */     return (Role2MiBaoInfo)_Tables_.getInstance().role2mibao.get(key, value);
/*     */   }
/*     */   
/*     */   public static void insert(Long key, Role2MiBaoInfo value)
/*     */   {
/*  22 */     _Tables_.getInstance().role2mibao.insert(key, value);
/*     */   }
/*     */   
/*     */   public static void delete(Long key)
/*     */   {
/*  27 */     _Tables_.getInstance().role2mibao.delete(key);
/*     */   }
/*     */   
/*     */   public static boolean add(Long key, Role2MiBaoInfo value)
/*     */   {
/*  32 */     return _Tables_.getInstance().role2mibao.add(key, value);
/*     */   }
/*     */   
/*     */   public static boolean remove(Long key)
/*     */   {
/*  37 */     return _Tables_.getInstance().role2mibao.remove(key);
/*     */   }
/*     */   
/*     */   public static xdb.TTableCache<Long, Role2MiBaoInfo> getCache()
/*     */   {
/*  42 */     return _Tables_.getInstance().role2mibao.getCache();
/*     */   }
/*     */   
/*     */   public static TTable<Long, Role2MiBaoInfo> getTable()
/*     */   {
/*  47 */     return _Tables_.getInstance().role2mibao;
/*     */   }
/*     */   
/*     */   public static Role2MiBaoInfo select(Long key)
/*     */   {
/*  52 */     (Role2MiBaoInfo)getTable().select(key, new TField()
/*     */     {
/*     */       public Role2MiBaoInfo get(Role2MiBaoInfo v)
/*     */       {
/*  56 */         return v.toData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectBuy_times_today(Long key)
/*     */   {
/*  63 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(Role2MiBaoInfo v)
/*     */       {
/*  67 */         return Integer.valueOf(v.getBuy_times_today());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectCurrent_score(Long key)
/*     */   {
/*  74 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(Role2MiBaoInfo v)
/*     */       {
/*  78 */         return Integer.valueOf(v.getCurrent_score());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectCurrent_lucky_value(Long key)
/*     */   {
/*  85 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(Role2MiBaoInfo v)
/*     */       {
/*  89 */         return Integer.valueOf(v.getCurrent_lucky_value());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectCurrent_index_id(Long key)
/*     */   {
/*  96 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(Role2MiBaoInfo v)
/*     */       {
/* 100 */         return Integer.valueOf(v.getCurrent_index_id());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectShould_exchange_score_limit_end_time(Long key)
/*     */   {
/* 107 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(Role2MiBaoInfo v)
/*     */       {
/* 111 */         return Long.valueOf(v.getShould_exchange_score_limit_end_time());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectShould_exchange_score_limit_begin_time(Long key)
/*     */   {
/* 118 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(Role2MiBaoInfo v)
/*     */       {
/* 122 */         return Long.valueOf(v.getShould_exchange_score_limit_begin_time());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Boolean selectIs_exchange_score(Long key)
/*     */   {
/* 129 */     (Boolean)getTable().select(key, new TField()
/*     */     {
/*     */       public Boolean get(Role2MiBaoInfo v)
/*     */       {
/* 133 */         return Boolean.valueOf(v.getIs_exchange_score());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Map<Integer, Integer> selectLimit_item_draw_times_map(Long key)
/*     */   {
/* 140 */     (Map)getTable().select(key, new TField()
/*     */     {
/*     */       public Map<Integer, Integer> get(Role2MiBaoInfo v)
/*     */       {
/* 144 */         return v.getLimit_item_draw_times_mapAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2mibao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */