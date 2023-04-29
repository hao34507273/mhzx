/*     */ package xtable;
/*     */ 
/*     */ import java.util.Map;
/*     */ import xbean.Properties;
/*     */ import xdb.TField;
/*     */ import xdb.TTable;
/*     */ 
/*     */ public class Role2properties
/*     */ {
/*     */   public static xdb.util.AutoKey<Long> getAutoKey()
/*     */   {
/*  12 */     return _Tables_.getInstance().role2properties.getAutoKey();
/*     */   }
/*     */   
/*     */   public static xdb.util.AutoKey<Long> getAutoKey(int localid)
/*     */   {
/*  17 */     return _Tables_.getInstance().role2properties.getAutoKey(localid);
/*     */   }
/*     */   
/*     */   public static Long nextKey()
/*     */   {
/*  22 */     return (Long)getAutoKey().next();
/*     */   }
/*     */   
/*     */   public static Long nextKey(int localid)
/*     */   {
/*  27 */     return (Long)getAutoKey(localid).next();
/*     */   }
/*     */   
/*     */   public static Long insert(Properties value)
/*     */   {
/*  32 */     Long next = nextKey();
/*  33 */     insert(next, value);
/*  34 */     return next;
/*     */   }
/*     */   
/*     */   public static Long insertWithLocalid(int localid, Properties value)
/*     */   {
/*  39 */     Long next = nextKey(localid);
/*  40 */     insertWithLocalid(localid, next, value);
/*  41 */     return next;
/*     */   }
/*     */   
/*     */   public static Properties get(Long key)
/*     */   {
/*  46 */     return (Properties)_Tables_.getInstance().role2properties.get(key);
/*     */   }
/*     */   
/*     */   public static Properties get(Long key, Properties value)
/*     */   {
/*  51 */     return (Properties)_Tables_.getInstance().role2properties.get(key, value);
/*     */   }
/*     */   
/*     */   public static void insert(Long key, Properties value)
/*     */   {
/*  56 */     _Tables_.getInstance().role2properties.insert(key, value);
/*     */   }
/*     */   
/*     */   public static void insertWithLocalid(int localid, Long key, Properties value)
/*     */   {
/*  61 */     _Tables_.getInstance().role2properties.insertWithLocalid(localid, key, value);
/*     */   }
/*     */   
/*     */   public static void delete(Long key)
/*     */   {
/*  66 */     _Tables_.getInstance().role2properties.delete(key);
/*     */   }
/*     */   
/*     */   public static boolean add(Long key, Properties value)
/*     */   {
/*  71 */     return _Tables_.getInstance().role2properties.add(key, value);
/*     */   }
/*     */   
/*     */   public static boolean addWithLocalid(int localid, Long key, Properties value)
/*     */   {
/*  76 */     return _Tables_.getInstance().role2properties.addWithLocalid(localid, key, value);
/*     */   }
/*     */   
/*     */   public static boolean remove(Long key)
/*     */   {
/*  81 */     return _Tables_.getInstance().role2properties.remove(key);
/*     */   }
/*     */   
/*     */   public static xdb.TTableCache<Long, Properties> getCache()
/*     */   {
/*  86 */     return _Tables_.getInstance().role2properties.getCache();
/*     */   }
/*     */   
/*     */   public static TTable<Long, Properties> getTable()
/*     */   {
/*  91 */     return _Tables_.getInstance().role2properties;
/*     */   }
/*     */   
/*     */   public static Properties select(Long key)
/*     */   {
/*  96 */     (Properties)getTable().select(key, new TField()
/*     */     {
/*     */       public Properties get(Properties v)
/*     */       {
/* 100 */         return v.toData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectLevel(Long key)
/*     */   {
/* 107 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(Properties v)
/*     */       {
/* 111 */         return Integer.valueOf(v.getLevel());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectExp(Long key)
/*     */   {
/* 118 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(Properties v)
/*     */       {
/* 122 */         return Integer.valueOf(v.getExp());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectHp(Long key)
/*     */   {
/* 129 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(Properties v)
/*     */       {
/* 133 */         return Integer.valueOf(v.getHp());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectMp(Long key)
/*     */   {
/* 140 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(Properties v)
/*     */       {
/* 144 */         return Integer.valueOf(v.getMp());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectAnger(Long key)
/*     */   {
/* 151 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(Properties v)
/*     */       {
/* 155 */         return Integer.valueOf(v.getAnger());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectVigor(Long key)
/*     */   {
/* 162 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(Properties v)
/*     */       {
/* 166 */         return Integer.valueOf(v.getVigor());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Map<Integer, xbean.BasicPropertiesSystem> selectPropertysysmap(Long key)
/*     */   {
/* 173 */     (Map)getTable().select(key, new TField()
/*     */     {
/*     */       public Map<Integer, xbean.BasicPropertiesSystem> get(Properties v)
/*     */       {
/* 177 */         return v.getPropertysysmapAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectActivitybpsys(Long key)
/*     */   {
/* 184 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(Properties v)
/*     */       {
/* 188 */         return Integer.valueOf(v.getActivitybpsys());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectTodaypropsysswitchcount(Long key)
/*     */   {
/* 195 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(Properties v)
/*     */       {
/* 199 */         return Integer.valueOf(v.getTodaypropsysswitchcount());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectTimestamp(Long key)
/*     */   {
/* 206 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(Properties v)
/*     */       {
/* 210 */         return Long.valueOf(v.getTimestamp());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static xbean.Location selectLocation(Long key)
/*     */   {
/* 217 */     (xbean.Location)getTable().select(key, new TField()
/*     */     {
/*     */       public xbean.Location get(Properties v)
/*     */       {
/* 221 */         return v.getLocation().toData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectGold(Long key)
/*     */   {
/* 228 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(Properties v)
/*     */       {
/* 232 */         return Long.valueOf(v.getGold());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectSilver(Long key)
/*     */   {
/* 239 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(Properties v)
/*     */       {
/* 243 */         return Long.valueOf(v.getSilver());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectGoldingot(Long key)
/*     */   {
/* 250 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(Properties v)
/*     */       {
/* 254 */         return Long.valueOf(v.getGoldingot());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectDyecolorid(Long key)
/*     */   {
/* 261 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(Properties v)
/*     */       {
/* 265 */         return Integer.valueOf(v.getDyecolorid());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectBaoshidu(Long key)
/*     */   {
/* 272 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(Properties v)
/*     */       {
/* 276 */         return Integer.valueOf(v.getBaoshidu());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectLastlogintime(Long key)
/*     */   {
/* 283 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(Properties v)
/*     */       {
/* 287 */         return Long.valueOf(v.getLastlogintime());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectLastlogofftime(Long key)
/*     */   {
/* 294 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(Properties v)
/*     */       {
/* 298 */         return Long.valueOf(v.getLastlogofftime());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectKeeponlinetime(Long key)
/*     */   {
/* 305 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(Properties v)
/*     */       {
/* 309 */         return Long.valueOf(v.getKeeponlinetime());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectFightvalue(Long key)
/*     */   {
/* 316 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(Properties v)
/*     */       {
/* 320 */         return Integer.valueOf(v.getFightvalue());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectLeveluptime(Long key)
/*     */   {
/* 327 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(Properties v)
/*     */       {
/* 331 */         return Long.valueOf(v.getLeveluptime());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectAccumulateleveluptime(Long key)
/*     */   {
/* 338 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(Properties v)
/*     */       {
/* 342 */         return Long.valueOf(v.getAccumulateleveluptime());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectVigorrefreshtime(Long key)
/*     */   {
/* 349 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(Properties v)
/*     */       {
/* 353 */         return Long.valueOf(v.getVigorrefreshtime());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectConvertxiulianexp(Long key)
/*     */   {
/* 360 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(Properties v)
/*     */       {
/* 364 */         return Integer.valueOf(v.getConvertxiulianexp());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static java.util.Set<Long> selectCompensates(Long key)
/*     */   {
/* 371 */     (java.util.Set)getTable().select(key, new TField()
/*     */     {
/*     */       public java.util.Set<Long> get(Properties v)
/*     */       {
/* 375 */         return v.getCompensatesAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Map<Integer, xbean.GatherMapItemInfo> selectGather_map_item_infos(Long key)
/*     */   {
/* 382 */     (Map)getTable().select(key, new TField()
/*     */     {
/*     */       public Map<Integer, xbean.GatherMapItemInfo> get(Properties v)
/*     */       {
/* 386 */         return v.getGather_map_item_infosAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectLastcalcuatetime(Long key)
/*     */   {
/* 393 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(Properties v)
/*     */       {
/* 397 */         return Long.valueOf(v.getLastcalcuatetime());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectDayonlineseconds(Long key)
/*     */   {
/* 404 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(Properties v)
/*     */       {
/* 408 */         return Integer.valueOf(v.getDayonlineseconds());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectOnlineseconds(Long key)
/*     */   {
/* 415 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(Properties v)
/*     */       {
/* 419 */         return Long.valueOf(v.getOnlineseconds());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectSend_recharge_times_tip_mail_no(Long key)
/*     */   {
/* 426 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(Properties v)
/*     */       {
/* 430 */         return Integer.valueOf(v.getSend_recharge_times_tip_mail_no());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectLevelupcurtime(Long key)
/*     */   {
/* 437 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(Properties v)
/*     */       {
/* 441 */         return Long.valueOf(v.getLevelupcurtime());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Map<Integer, xbean.TransferOccupationPropertiesSys> selectTransfer_occupation_property_sys_map(Long key)
/*     */   {
/* 448 */     (Map)getTable().select(key, new TField()
/*     */     {
/*     */       public Map<Integer, xbean.TransferOccupationPropertiesSys> get(Properties v)
/*     */       {
/* 452 */         return v.getTransfer_occupation_property_sys_mapAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Map<Integer, xbean.CoinInfo> selectCoins(Long key)
/*     */   {
/* 459 */     (Map)getTable().select(key, new TField()
/*     */     {
/*     */       public Map<Integer, xbean.CoinInfo> get(Properties v)
/*     */       {
/* 463 */         return v.getCoinsAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2properties.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */