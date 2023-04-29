/*     */ package xtable;
/*     */ 
/*     */ import java.util.List;
/*     */ import xbean.Role2BackGameInfo;
/*     */ import xdb.TField;
/*     */ import xdb.TTable;
/*     */ 
/*     */ public class Role2backgame
/*     */ {
/*     */   public static Role2BackGameInfo get(Long key)
/*     */   {
/*  12 */     return (Role2BackGameInfo)_Tables_.getInstance().role2backgame.get(key);
/*     */   }
/*     */   
/*     */   public static Role2BackGameInfo get(Long key, Role2BackGameInfo value)
/*     */   {
/*  17 */     return (Role2BackGameInfo)_Tables_.getInstance().role2backgame.get(key, value);
/*     */   }
/*     */   
/*     */   public static void insert(Long key, Role2BackGameInfo value)
/*     */   {
/*  22 */     _Tables_.getInstance().role2backgame.insert(key, value);
/*     */   }
/*     */   
/*     */   public static void delete(Long key)
/*     */   {
/*  27 */     _Tables_.getInstance().role2backgame.delete(key);
/*     */   }
/*     */   
/*     */   public static boolean add(Long key, Role2BackGameInfo value)
/*     */   {
/*  32 */     return _Tables_.getInstance().role2backgame.add(key, value);
/*     */   }
/*     */   
/*     */   public static boolean remove(Long key)
/*     */   {
/*  37 */     return _Tables_.getInstance().role2backgame.remove(key);
/*     */   }
/*     */   
/*     */   public static xdb.TTableCache<Long, Role2BackGameInfo> getCache()
/*     */   {
/*  42 */     return _Tables_.getInstance().role2backgame.getCache();
/*     */   }
/*     */   
/*     */   public static TTable<Long, Role2BackGameInfo> getTable()
/*     */   {
/*  47 */     return _Tables_.getInstance().role2backgame;
/*     */   }
/*     */   
/*     */   public static Role2BackGameInfo select(Long key)
/*     */   {
/*  52 */     (Role2BackGameInfo)getTable().select(key, new TField()
/*     */     {
/*     */       public Role2BackGameInfo get(Role2BackGameInfo v)
/*     */       {
/*  56 */         return v.toData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectBack_state_start_time(Long key)
/*     */   {
/*  63 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(Role2BackGameInfo v)
/*     */       {
/*  67 */         return Long.valueOf(v.getBack_state_start_time());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectOffline_days(Long key)
/*     */   {
/*  74 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(Role2BackGameInfo v)
/*     */       {
/*  78 */         return Integer.valueOf(v.getOffline_days());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectBack_game_level(Long key)
/*     */   {
/*  85 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(Role2BackGameInfo v)
/*     */       {
/*  89 */         return Integer.valueOf(v.getBack_game_level());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectClear_score_time(Long key)
/*     */   {
/*  96 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(Role2BackGameInfo v)
/*     */       {
/* 100 */         return Long.valueOf(v.getClear_score_time());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static List<Integer> selectAleardy_awarded_score_index_list(Long key)
/*     */   {
/* 107 */     (List)getTable().select(key, new TField()
/*     */     {
/*     */       public List<Integer> get(Role2BackGameInfo v)
/*     */       {
/* 111 */         return v.getAleardy_awarded_score_index_listAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectActive_base_value(Long key)
/*     */   {
/* 118 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(Role2BackGameInfo v)
/*     */       {
/* 122 */         return Integer.valueOf(v.getActive_base_value());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectYuan_bao_save_amt_base_value(Long key)
/*     */   {
/* 129 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(Role2BackGameInfo v)
/*     */       {
/* 133 */         return Long.valueOf(v.getYuan_bao_save_amt_base_value());
/*     */       }
/*     */     });
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2backgame.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */