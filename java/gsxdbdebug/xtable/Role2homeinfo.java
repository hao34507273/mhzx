/*     */ package xtable;
/*     */ 
/*     */ import java.util.Map;
/*     */ import xbean.HomeInfo;
/*     */ import xdb.TField;
/*     */ import xdb.TTable;
/*     */ 
/*     */ public class Role2homeinfo
/*     */ {
/*     */   public static HomeInfo get(Long key)
/*     */   {
/*  12 */     return (HomeInfo)_Tables_.getInstance().role2homeinfo.get(key);
/*     */   }
/*     */   
/*     */   public static HomeInfo get(Long key, HomeInfo value)
/*     */   {
/*  17 */     return (HomeInfo)_Tables_.getInstance().role2homeinfo.get(key, value);
/*     */   }
/*     */   
/*     */   public static void insert(Long key, HomeInfo value)
/*     */   {
/*  22 */     _Tables_.getInstance().role2homeinfo.insert(key, value);
/*     */   }
/*     */   
/*     */   public static void delete(Long key)
/*     */   {
/*  27 */     _Tables_.getInstance().role2homeinfo.delete(key);
/*     */   }
/*     */   
/*     */   public static boolean add(Long key, HomeInfo value)
/*     */   {
/*  32 */     return _Tables_.getInstance().role2homeinfo.add(key, value);
/*     */   }
/*     */   
/*     */   public static boolean remove(Long key)
/*     */   {
/*  37 */     return _Tables_.getInstance().role2homeinfo.remove(key);
/*     */   }
/*     */   
/*     */   public static xdb.TTableCache<Long, HomeInfo> getCache()
/*     */   {
/*  42 */     return _Tables_.getInstance().role2homeinfo.getCache();
/*     */   }
/*     */   
/*     */   public static TTable<Long, HomeInfo> getTable()
/*     */   {
/*  47 */     return _Tables_.getInstance().role2homeinfo;
/*     */   }
/*     */   
/*     */   public static HomeInfo select(Long key)
/*     */   {
/*  52 */     (HomeInfo)getTable().select(key, new TField()
/*     */     {
/*     */       public HomeInfo get(HomeInfo v)
/*     */       {
/*  56 */         return v.toData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectHomelevel(Long key)
/*     */   {
/*  63 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(HomeInfo v)
/*     */       {
/*  67 */         return Integer.valueOf(v.getHomelevel());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectCleanliness(Long key)
/*     */   {
/*  74 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(HomeInfo v)
/*     */       {
/*  78 */         return Integer.valueOf(v.getCleanliness());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectPetroomlevel(Long key)
/*     */   {
/*  85 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(HomeInfo v)
/*     */       {
/*  89 */         return Integer.valueOf(v.getPetroomlevel());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectBedroomlevel(Long key)
/*     */   {
/*  96 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(HomeInfo v)
/*     */       {
/* 100 */         return Integer.valueOf(v.getBedroomlevel());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectDaycleancount(Long key)
/*     */   {
/* 107 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(HomeInfo v)
/*     */       {
/* 111 */         return Integer.valueOf(v.getDaycleancount());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectDrugroomlevel(Long key)
/*     */   {
/* 118 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(HomeInfo v)
/*     */       {
/* 122 */         return Integer.valueOf(v.getDrugroomlevel());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectKitchenlevel(Long key)
/*     */   {
/* 129 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(HomeInfo v)
/*     */       {
/* 133 */         return Integer.valueOf(v.getKitchenlevel());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectMaidroomlevel(Long key)
/*     */   {
/* 140 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(HomeInfo v)
/*     */       {
/* 144 */         return Integer.valueOf(v.getMaidroomlevel());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Map<Long, xbean.MaidInfo> selectUuid2maidinfo(Long key)
/*     */   {
/* 151 */     (Map)getTable().select(key, new TField()
/*     */     {
/*     */       public Map<Long, xbean.MaidInfo> get(HomeInfo v)
/*     */       {
/* 155 */         return v.getUuid2maidinfoAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectCurrentmaiduuid(Long key)
/*     */   {
/* 162 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(HomeInfo v)
/*     */       {
/* 166 */         return Long.valueOf(v.getCurrentmaiduuid());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Boolean selectIsmainhome(Long key)
/*     */   {
/* 173 */     (Boolean)getTable().select(key, new TField()
/*     */     {
/*     */       public Boolean get(HomeInfo v)
/*     */       {
/* 177 */         return Boolean.valueOf(v.getIsmainhome());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectUpdatetime(Long key)
/*     */   {
/* 184 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(HomeInfo v)
/*     */       {
/* 188 */         return Long.valueOf(v.getUpdatetime());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Map<Long, xbean.FurnitureInfo> selectMydisplayfurniture(Long key)
/*     */   {
/* 195 */     (Map)getTable().select(key, new TField()
/*     */     {
/*     */       public Map<Long, xbean.FurnitureInfo> get(HomeInfo v)
/*     */       {
/* 199 */         return v.getMydisplayfurnitureAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Map<Long, xbean.FurnitureInfo> selectPartnerdisplayfurniture(Long key)
/*     */   {
/* 206 */     (Map)getTable().select(key, new TField()
/*     */     {
/*     */       public Map<Long, xbean.FurnitureInfo> get(HomeInfo v)
/*     */       {
/* 210 */         return v.getPartnerdisplayfurnitureAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectCourtyardlevel(Long key)
/*     */   {
/* 217 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(HomeInfo v)
/*     */       {
/* 221 */         return Integer.valueOf(v.getCourtyardlevel());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectFengshui(Long key)
/*     */   {
/* 228 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(HomeInfo v)
/*     */       {
/* 232 */         return Integer.valueOf(v.getFengshui());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectWalluuid(Long key)
/*     */   {
/* 239 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(HomeInfo v)
/*     */       {
/* 243 */         return Long.valueOf(v.getWalluuid());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectFlooruuid(Long key)
/*     */   {
/* 250 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(HomeInfo v)
/*     */       {
/* 254 */         return Long.valueOf(v.getFlooruuid());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectCourt_yard_beautiful(Long key)
/*     */   {
/* 261 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(HomeInfo v)
/*     */       {
/* 265 */         return Integer.valueOf(v.getCourt_yard_beautiful());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectCourt_yard_cleanliness_refresh_time(Long key)
/*     */   {
/* 272 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(HomeInfo v)
/*     */       {
/* 276 */         return Long.valueOf(v.getCourt_yard_cleanliness_refresh_time());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectCourt_yard_cleanliness(Long key)
/*     */   {
/* 283 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(HomeInfo v)
/*     */       {
/* 287 */         return Integer.valueOf(v.getCourt_yard_cleanliness());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectCourt_yard_day_clean_count(Long key)
/*     */   {
/* 294 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(HomeInfo v)
/*     */       {
/* 298 */         return Integer.valueOf(v.getCourt_yard_day_clean_count());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectFence_uuid(Long key)
/*     */   {
/* 305 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(HomeInfo v)
/*     */       {
/* 309 */         return Long.valueOf(v.getFence_uuid());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectCourt_yard_terrain_uuid(Long key)
/*     */   {
/* 316 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(HomeInfo v)
/*     */       {
/* 320 */         return Long.valueOf(v.getCourt_yard_terrain_uuid());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectCourt_yard_road_uuid(Long key)
/*     */   {
/* 327 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(HomeInfo v)
/*     */       {
/* 331 */         return Long.valueOf(v.getCourt_yard_road_uuid());
/*     */       }
/*     */     });
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2homeinfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */