/*     */ package xtable;
/*     */ 
/*     */ import java.util.Map;
/*     */ import xbean.QingfuInfo;
/*     */ import xdb.TField;
/*     */ import xdb.TTable;
/*     */ 
/*     */ public class Qingfu
/*     */ {
/*     */   public static QingfuInfo get(String key)
/*     */   {
/*  12 */     return (QingfuInfo)_Tables_.getInstance().qingfu.get(key);
/*     */   }
/*     */   
/*     */   public static QingfuInfo get(String key, QingfuInfo value)
/*     */   {
/*  17 */     return (QingfuInfo)_Tables_.getInstance().qingfu.get(key, value);
/*     */   }
/*     */   
/*     */   public static void insert(String key, QingfuInfo value)
/*     */   {
/*  22 */     _Tables_.getInstance().qingfu.insert(key, value);
/*     */   }
/*     */   
/*     */   public static void delete(String key)
/*     */   {
/*  27 */     _Tables_.getInstance().qingfu.delete(key);
/*     */   }
/*     */   
/*     */   public static boolean add(String key, QingfuInfo value)
/*     */   {
/*  32 */     return _Tables_.getInstance().qingfu.add(key, value);
/*     */   }
/*     */   
/*     */   public static boolean remove(String key)
/*     */   {
/*  37 */     return _Tables_.getInstance().qingfu.remove(key);
/*     */   }
/*     */   
/*     */   public static xdb.TTableCache<String, QingfuInfo> getCache()
/*     */   {
/*  42 */     return _Tables_.getInstance().qingfu.getCache();
/*     */   }
/*     */   
/*     */   public static TTable<String, QingfuInfo> getTable()
/*     */   {
/*  47 */     return _Tables_.getInstance().qingfu;
/*     */   }
/*     */   
/*     */   public static QingfuInfo select(String key)
/*     */   {
/*  52 */     (QingfuInfo)getTable().select(key, new TField()
/*     */     {
/*     */       public QingfuInfo get(QingfuInfo v)
/*     */       {
/*  56 */         return v.toData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static String selectAppid(String key)
/*     */   {
/*  63 */     (String)getTable().select(key, new TField()
/*     */     {
/*     */       public String get(QingfuInfo v)
/*     */       {
/*  67 */         return v.getAppid();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectSave_amt(String key)
/*     */   {
/*  74 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(QingfuInfo v)
/*     */       {
/*  78 */         return Long.valueOf(v.getSave_amt());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectTotal_cash(String key)
/*     */   {
/*  85 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(QingfuInfo v)
/*     */       {
/*  89 */         return Long.valueOf(v.getTotal_cash());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectTotal_cost(String key)
/*     */   {
/*  96 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(QingfuInfo v)
/*     */       {
/* 100 */         return Long.valueOf(v.getTotal_cost());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectTotal_cost_bind(String key)
/*     */   {
/* 107 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(QingfuInfo v)
/*     */       {
/* 111 */         return Long.valueOf(v.getTotal_cost_bind());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectTotal_present(String key)
/*     */   {
/* 118 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(QingfuInfo v)
/*     */       {
/* 122 */         return Long.valueOf(v.getTotal_present());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectTotal_present_bind(String key)
/*     */   {
/* 129 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(QingfuInfo v)
/*     */       {
/* 133 */         return Long.valueOf(v.getTotal_present_bind());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectTotal_confirm_cost(String key)
/*     */   {
/* 140 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(QingfuInfo v)
/*     */       {
/* 144 */         return Long.valueOf(v.getTotal_confirm_cost());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectTotal_confirm_cost_bind(String key)
/*     */   {
/* 151 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(QingfuInfo v)
/*     */       {
/* 155 */         return Long.valueOf(v.getTotal_confirm_cost_bind());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectTotal_confirm_present(String key)
/*     */   {
/* 162 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(QingfuInfo v)
/*     */       {
/* 166 */         return Long.valueOf(v.getTotal_confirm_present());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectTotal_confirm_present_bind(String key)
/*     */   {
/* 173 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(QingfuInfo v)
/*     */       {
/* 177 */         return Long.valueOf(v.getTotal_confirm_present_bind());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static String selectTss_list(String key)
/*     */   {
/* 184 */     (String)getTable().select(key, new TField()
/*     */     {
/*     */       public String get(QingfuInfo v)
/*     */       {
/* 188 */         return v.getTss_list();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Map<String, xbean.TssSumInfo> selectTss_sum_map(String key)
/*     */   {
/* 195 */     (Map)getTable().select(key, new TField()
/*     */     {
/*     */       public Map<String, xbean.TssSumInfo> get(QingfuInfo v)
/*     */       {
/* 199 */         return v.getTss_sum_mapAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectFirst_recharge_status(String key)
/*     */   {
/* 206 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(QingfuInfo v)
/*     */       {
/* 210 */         return Integer.valueOf(v.getFirst_recharge_status());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectRecharge_times(String key)
/*     */   {
/* 217 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(QingfuInfo v)
/*     */       {
/* 221 */         return Integer.valueOf(v.getRecharge_times());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectStatis_recharge_first_consume_status(String key)
/*     */   {
/* 228 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(QingfuInfo v)
/*     */       {
/* 232 */         return Integer.valueOf(v.getStatis_recharge_first_consume_status());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Map<Integer, xbean.SaveAmtActivityInfo> selectSave_amt_activity_infos(String key)
/*     */   {
/* 239 */     (Map)getTable().select(key, new TField()
/*     */     {
/*     */       public Map<Integer, xbean.SaveAmtActivityInfo> get(QingfuInfo v)
/*     */       {
/* 243 */         return v.getSave_amt_activity_infosAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Map<Integer, xbean.LevelGrowthFundActivityInfo> selectLevel_growth_fund_activity_infos(String key)
/*     */   {
/* 250 */     (Map)getTable().select(key, new TField()
/*     */     {
/*     */       public Map<Integer, xbean.LevelGrowthFundActivityInfo> get(QingfuInfo v)
/*     */       {
/* 254 */         return v.getLevel_growth_fund_activity_infosAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Map<Integer, xbean.MonthCardActivityInfo> selectMoth_card_activity_infos(String key)
/*     */   {
/* 261 */     (Map)getTable().select(key, new TField()
/*     */     {
/*     */       public Map<Integer, xbean.MonthCardActivityInfo> get(QingfuInfo v)
/*     */       {
/* 265 */         return v.getMoth_card_activity_infosAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Map<Integer, xbean.AccumTotalCostActivityInfo> selectAccum_total_cost_activity_infos(String key)
/*     */   {
/* 272 */     (Map)getTable().select(key, new TField()
/*     */     {
/*     */       public Map<Integer, xbean.AccumTotalCostActivityInfo> get(QingfuInfo v)
/*     */       {
/* 276 */         return v.getAccum_total_cost_activity_infosAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Map<Integer, xbean.RMBGiftBagActivityInfo> selectRmb_gift_bag_activity_infos(String key)
/*     */   {
/* 283 */     (Map)getTable().select(key, new TField()
/*     */     {
/*     */       public Map<Integer, xbean.RMBGiftBagActivityInfo> get(QingfuInfo v)
/*     */       {
/* 287 */         return v.getRmb_gift_bag_activity_infosAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static xbean.RecentlyCashInfo selectRecently_cash_infos(String key)
/*     */   {
/* 294 */     (xbean.RecentlyCashInfo)getTable().select(key, new TField()
/*     */     {
/*     */       public xbean.RecentlyCashInfo get(QingfuInfo v)
/*     */       {
/* 298 */         return v.getRecently_cash_infos().toData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectTotal_cash_amt(String key)
/*     */   {
/* 305 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(QingfuInfo v)
/*     */       {
/* 309 */         return Long.valueOf(v.getTotal_cash_amt());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectInner_save_amt(String key)
/*     */   {
/* 316 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(QingfuInfo v)
/*     */       {
/* 320 */         return Long.valueOf(v.getInner_save_amt());
/*     */       }
/*     */     });
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Qingfu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */