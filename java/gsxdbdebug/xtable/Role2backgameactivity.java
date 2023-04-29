/*     */ package xtable;
/*     */ 
/*     */ import java.util.List;
/*     */ import xbean.BackGameActivityInfo;
/*     */ import xdb.TField;
/*     */ import xdb.TTable;
/*     */ 
/*     */ public class Role2backgameactivity
/*     */ {
/*     */   public static BackGameActivityInfo get(Long key)
/*     */   {
/*  12 */     return (BackGameActivityInfo)_Tables_.getInstance().role2backgameactivity.get(key);
/*     */   }
/*     */   
/*     */   public static BackGameActivityInfo get(Long key, BackGameActivityInfo value)
/*     */   {
/*  17 */     return (BackGameActivityInfo)_Tables_.getInstance().role2backgameactivity.get(key, value);
/*     */   }
/*     */   
/*     */   public static void insert(Long key, BackGameActivityInfo value)
/*     */   {
/*  22 */     _Tables_.getInstance().role2backgameactivity.insert(key, value);
/*     */   }
/*     */   
/*     */   public static void delete(Long key)
/*     */   {
/*  27 */     _Tables_.getInstance().role2backgameactivity.delete(key);
/*     */   }
/*     */   
/*     */   public static boolean add(Long key, BackGameActivityInfo value)
/*     */   {
/*  32 */     return _Tables_.getInstance().role2backgameactivity.add(key, value);
/*     */   }
/*     */   
/*     */   public static boolean remove(Long key)
/*     */   {
/*  37 */     return _Tables_.getInstance().role2backgameactivity.remove(key);
/*     */   }
/*     */   
/*     */   public static xdb.TTableCache<Long, BackGameActivityInfo> getCache()
/*     */   {
/*  42 */     return _Tables_.getInstance().role2backgameactivity.getCache();
/*     */   }
/*     */   
/*     */   public static TTable<Long, BackGameActivityInfo> getTable()
/*     */   {
/*  47 */     return _Tables_.getInstance().role2backgameactivity;
/*     */   }
/*     */   
/*     */   public static BackGameActivityInfo select(Long key)
/*     */   {
/*  52 */     (BackGameActivityInfo)getTable().select(key, new TField()
/*     */     {
/*     */       public BackGameActivityInfo get(BackGameActivityInfo v)
/*     */       {
/*  56 */         return v.toData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectActivity_id(Long key)
/*     */   {
/*  63 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(BackGameActivityInfo v)
/*     */       {
/*  67 */         return Integer.valueOf(v.getActivity_id());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectJoin_time(Long key)
/*     */   {
/*  74 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(BackGameActivityInfo v)
/*     */       {
/*  78 */         return Long.valueOf(v.getJoin_time());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectJoin_level(Long key)
/*     */   {
/*  85 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(BackGameActivityInfo v)
/*     */       {
/*  89 */         return Integer.valueOf(v.getJoin_level());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectJoin_recharge(Long key)
/*     */   {
/*  96 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(BackGameActivityInfo v)
/*     */       {
/* 100 */         return Integer.valueOf(v.getJoin_recharge());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectSign_count(Long key)
/*     */   {
/* 107 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(BackGameActivityInfo v)
/*     */       {
/* 111 */         return Integer.valueOf(v.getSign_count());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectLast_sign_time(Long key)
/*     */   {
/* 118 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(BackGameActivityInfo v)
/*     */       {
/* 122 */         return Long.valueOf(v.getLast_sign_time());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static List<Integer> selectAlready_get_point_awards(Long key)
/*     */   {
/* 129 */     (List)getTable().select(key, new TField()
/*     */     {
/*     */       public List<Integer> get(BackGameActivityInfo v)
/*     */       {
/* 133 */         return v.getAlready_get_point_awardsAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectLast_get_point_award_time(Long key)
/*     */   {
/* 140 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(BackGameActivityInfo v)
/*     */       {
/* 144 */         return Long.valueOf(v.getLast_get_point_award_time());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static List<Integer> selectAlready_get_exp_awards(Long key)
/*     */   {
/* 151 */     (List)getTable().select(key, new TField()
/*     */     {
/*     */       public List<Integer> get(BackGameActivityInfo v)
/*     */       {
/* 155 */         return v.getAlready_get_exp_awardsAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectLogin_count(Long key)
/*     */   {
/* 162 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(BackGameActivityInfo v)
/*     */       {
/* 166 */         return Integer.valueOf(v.getLogin_count());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectLast_login_time(Long key)
/*     */   {
/* 173 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(BackGameActivityInfo v)
/*     */       {
/* 177 */         return Long.valueOf(v.getLast_login_time());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Boolean selectHave_got_back_game_award(Long key)
/*     */   {
/* 184 */     (Boolean)getTable().select(key, new TField()
/*     */     {
/*     */       public Boolean get(BackGameActivityInfo v)
/*     */       {
/* 188 */         return Boolean.valueOf(v.getHave_got_back_game_award());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static java.util.Map<Integer, Integer> selectGift_buy_count_map(Long key)
/*     */   {
/* 195 */     (java.util.Map)getTable().select(key, new TField()
/*     */     {
/*     */       public java.util.Map<Integer, Integer> get(BackGameActivityInfo v)
/*     */       {
/* 199 */         return v.getGift_buy_count_mapAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectLast_buy_gift_time(Long key)
/*     */   {
/* 206 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(BackGameActivityInfo v)
/*     */       {
/* 210 */         return Long.valueOf(v.getLast_buy_gift_time());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectLast_get_task_award_time(Long key)
/*     */   {
/* 217 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(BackGameActivityInfo v)
/*     */       {
/* 221 */         return Long.valueOf(v.getLast_get_task_award_time());
/*     */       }
/*     */     });
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2backgameactivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */