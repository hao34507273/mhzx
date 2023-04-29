/*     */ package xtable;
/*     */ 
/*     */ import java.util.List;
/*     */ import xbean.CrossBattleOwn;
/*     */ import xdb.TField;
/*     */ import xdb.TTable;
/*     */ 
/*     */ public class Cross_battle_owns
/*     */ {
/*     */   public static CrossBattleOwn get(Long key)
/*     */   {
/*  12 */     return (CrossBattleOwn)_Tables_.getInstance().cross_battle_owns.get(key);
/*     */   }
/*     */   
/*     */   public static CrossBattleOwn get(Long key, CrossBattleOwn value)
/*     */   {
/*  17 */     return (CrossBattleOwn)_Tables_.getInstance().cross_battle_owns.get(key, value);
/*     */   }
/*     */   
/*     */   public static void insert(Long key, CrossBattleOwn value)
/*     */   {
/*  22 */     _Tables_.getInstance().cross_battle_owns.insert(key, value);
/*     */   }
/*     */   
/*     */   public static void delete(Long key)
/*     */   {
/*  27 */     _Tables_.getInstance().cross_battle_owns.delete(key);
/*     */   }
/*     */   
/*     */   public static boolean add(Long key, CrossBattleOwn value)
/*     */   {
/*  32 */     return _Tables_.getInstance().cross_battle_owns.add(key, value);
/*     */   }
/*     */   
/*     */   public static boolean remove(Long key)
/*     */   {
/*  37 */     return _Tables_.getInstance().cross_battle_owns.remove(key);
/*     */   }
/*     */   
/*     */   public static xdb.TTableCache<Long, CrossBattleOwn> getCache()
/*     */   {
/*  42 */     return _Tables_.getInstance().cross_battle_owns.getCache();
/*     */   }
/*     */   
/*     */   public static TTable<Long, CrossBattleOwn> getTable()
/*     */   {
/*  47 */     return _Tables_.getInstance().cross_battle_owns;
/*     */   }
/*     */   
/*     */   public static CrossBattleOwn select(Long key)
/*     */   {
/*  52 */     (CrossBattleOwn)getTable().select(key, new TField()
/*     */     {
/*     */       public CrossBattleOwn get(CrossBattleOwn v)
/*     */       {
/*  56 */         return v.toData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectStage(Long key)
/*     */   {
/*  63 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(CrossBattleOwn v)
/*     */       {
/*  67 */         return Integer.valueOf(v.getStage());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static java.util.Map<Long, xbean.AttendCorpsInfo> selectAttend_corps_infos(Long key)
/*     */   {
/*  74 */     (java.util.Map)getTable().select(key, new TField()
/*     */     {
/*     */       public java.util.Map<Long, xbean.AttendCorpsInfo> get(CrossBattleOwn v)
/*     */       {
/*  78 */         return v.getAttend_corps_infosAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static List<Long> selectVote_stage_direct_promotion_corps_list(Long key)
/*     */   {
/*  85 */     (List)getTable().select(key, new TField()
/*     */     {
/*     */       public List<Long> get(CrossBattleOwn v)
/*     */       {
/*  89 */         return v.getVote_stage_direct_promotion_corps_listAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static List<Long> selectRound_robin_point_rank_list(Long key)
/*     */   {
/*  96 */     (List)getTable().select(key, new TField()
/*     */     {
/*     */       public List<Long> get(CrossBattleOwn v)
/*     */       {
/* 100 */         return v.getRound_robin_point_rank_listAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectRound_robin_round_index(Long key)
/*     */   {
/* 107 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(CrossBattleOwn v)
/*     */       {
/* 111 */         return Integer.valueOf(v.getRound_robin_round_index());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static List<xbean.RoundRobinRoundInfo> selectRound_robin_round_infos(Long key)
/*     */   {
/* 118 */     (List)getTable().select(key, new TField()
/*     */     {
/*     */       public List<xbean.RoundRobinRoundInfo> get(CrossBattleOwn v)
/*     */       {
/* 122 */         return v.getRound_robin_round_infosAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static List<Long> selectRound_robin_stage_promotion_corps_list(Long key)
/*     */   {
/* 129 */     (List)getTable().select(key, new TField()
/*     */     {
/*     */       public List<Long> get(CrossBattleOwn v)
/*     */       {
/* 133 */         return v.getRound_robin_stage_promotion_corps_listAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Boolean selectReport_result_success(Long key)
/*     */   {
/* 140 */     (Boolean)getTable().select(key, new TField()
/*     */     {
/*     */       public Boolean get(CrossBattleOwn v)
/*     */       {
/* 144 */         return Boolean.valueOf(v.getReport_result_success());
/*     */       }
/*     */     });
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Cross_battle_owns.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */