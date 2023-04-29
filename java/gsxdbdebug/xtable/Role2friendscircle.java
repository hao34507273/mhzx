/*     */ package xtable;
/*     */ 
/*     */ import java.util.Map;
/*     */ import xbean.Role2FriendsCircleInfo;
/*     */ import xdb.TField;
/*     */ import xdb.TTable;
/*     */ 
/*     */ public class Role2friendscircle
/*     */ {
/*     */   public static Role2FriendsCircleInfo get(Long key)
/*     */   {
/*  12 */     return (Role2FriendsCircleInfo)_Tables_.getInstance().role2friendscircle.get(key);
/*     */   }
/*     */   
/*     */   public static Role2FriendsCircleInfo get(Long key, Role2FriendsCircleInfo value)
/*     */   {
/*  17 */     return (Role2FriendsCircleInfo)_Tables_.getInstance().role2friendscircle.get(key, value);
/*     */   }
/*     */   
/*     */   public static void insert(Long key, Role2FriendsCircleInfo value)
/*     */   {
/*  22 */     _Tables_.getInstance().role2friendscircle.insert(key, value);
/*     */   }
/*     */   
/*     */   public static void delete(Long key)
/*     */   {
/*  27 */     _Tables_.getInstance().role2friendscircle.delete(key);
/*     */   }
/*     */   
/*     */   public static boolean add(Long key, Role2FriendsCircleInfo value)
/*     */   {
/*  32 */     return _Tables_.getInstance().role2friendscircle.add(key, value);
/*     */   }
/*     */   
/*     */   public static boolean remove(Long key)
/*     */   {
/*  37 */     return _Tables_.getInstance().role2friendscircle.remove(key);
/*     */   }
/*     */   
/*     */   public static xdb.TTableCache<Long, Role2FriendsCircleInfo> getCache()
/*     */   {
/*  42 */     return _Tables_.getInstance().role2friendscircle.getCache();
/*     */   }
/*     */   
/*     */   public static TTable<Long, Role2FriendsCircleInfo> getTable()
/*     */   {
/*  47 */     return _Tables_.getInstance().role2friendscircle;
/*     */   }
/*     */   
/*     */   public static Role2FriendsCircleInfo select(Long key)
/*     */   {
/*  52 */     (Role2FriendsCircleInfo)getTable().select(key, new TField()
/*     */     {
/*     */       public Role2FriendsCircleInfo get(Role2FriendsCircleInfo v)
/*     */       {
/*  56 */         return v.toData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectTreasure_box_num(Long key)
/*     */   {
/*  63 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(Role2FriendsCircleInfo v)
/*     */       {
/*  67 */         return Integer.valueOf(v.getTreasure_box_num());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectToday_get_treasure_box_num(Long key)
/*     */   {
/*  74 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(Role2FriendsCircleInfo v)
/*     */       {
/*  78 */         return Integer.valueOf(v.getToday_get_treasure_box_num());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectLast_get_treasure_box_time(Long key)
/*     */   {
/*  85 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(Role2FriendsCircleInfo v)
/*     */       {
/*  89 */         return Long.valueOf(v.getLast_get_treasure_box_time());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectLast_week_popularity_value_refresh_time(Long key)
/*     */   {
/*  96 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(Role2FriendsCircleInfo v)
/*     */       {
/* 100 */         return Long.valueOf(v.getLast_week_popularity_value_refresh_time());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectCurrent_week_popularity_value(Long key)
/*     */   {
/* 107 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(Role2FriendsCircleInfo v)
/*     */       {
/* 111 */         return Integer.valueOf(v.getCurrent_week_popularity_value());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectTotal_popularity_value(Long key)
/*     */   {
/* 118 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(Role2FriendsCircleInfo v)
/*     */       {
/* 122 */         return Integer.valueOf(v.getTotal_popularity_value());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectReceive_gift_num(Long key)
/*     */   {
/* 129 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(Role2FriendsCircleInfo v)
/*     */       {
/* 133 */         return Integer.valueOf(v.getReceive_gift_num());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Map<Long, Integer> selectToday_tread_circle_role_id_map(Long key)
/*     */   {
/* 140 */     (Map)getTable().select(key, new TField()
/*     */     {
/*     */       public Map<Long, Integer> get(Role2FriendsCircleInfo v)
/*     */       {
/* 144 */         return v.getToday_tread_circle_role_id_mapAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectLast_tread_circle_time(Long key)
/*     */   {
/* 151 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(Role2FriendsCircleInfo v)
/*     */       {
/* 155 */         return Long.valueOf(v.getLast_tread_circle_time());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Map<Long, Integer> selectToday_tread_my_circle_role_id_map(Long key)
/*     */   {
/* 162 */     (Map)getTable().select(key, new TField()
/*     */     {
/*     */       public Map<Long, Integer> get(Role2FriendsCircleInfo v)
/*     */       {
/* 166 */         return v.getToday_tread_my_circle_role_id_mapAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectLast_tread_my_circle_time(Long key)
/*     */   {
/* 173 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(Role2FriendsCircleInfo v)
/*     */       {
/* 177 */         return Long.valueOf(v.getLast_tread_my_circle_time());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Map<Integer, Long> selectOwn_pendant_ornament_map(Long key)
/*     */   {
/* 184 */     (Map)getTable().select(key, new TField()
/*     */     {
/*     */       public Map<Integer, Long> get(Role2FriendsCircleInfo v)
/*     */       {
/* 188 */         return v.getOwn_pendant_ornament_mapAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Map<Integer, Long> selectOwn_rahmen_ornament_map(Long key)
/*     */   {
/* 195 */     (Map)getTable().select(key, new TField()
/*     */     {
/*     */       public Map<Integer, Long> get(Role2FriendsCircleInfo v)
/*     */       {
/* 199 */         return v.getOwn_rahmen_ornament_mapAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static xbean.FriendsCircleOrnamentItem selectCurrent_pendant_ornament(Long key)
/*     */   {
/* 206 */     (xbean.FriendsCircleOrnamentItem)getTable().select(key, new TField()
/*     */     {
/*     */       public xbean.FriendsCircleOrnamentItem get(Role2FriendsCircleInfo v)
/*     */       {
/* 210 */         return v.getCurrent_pendant_ornament().toData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static xbean.FriendsCircleOrnamentItem selectCurrent_rahmen_ornament(Long key)
/*     */   {
/* 217 */     (xbean.FriendsCircleOrnamentItem)getTable().select(key, new TField()
/*     */     {
/*     */       public xbean.FriendsCircleOrnamentItem get(Role2FriendsCircleInfo v)
/*     */       {
/* 221 */         return v.getCurrent_rahmen_ornament().toData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Map<Long, xbean.CrossServerFriendsCircleGift> selectCross_server_send_gift(Long key)
/*     */   {
/* 228 */     (Map)getTable().select(key, new TField()
/*     */     {
/*     */       public Map<Long, xbean.CrossServerFriendsCircleGift> get(Role2FriendsCircleInfo v)
/*     */       {
/* 232 */         return v.getCross_server_send_giftAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Map<Long, xbean.CrossServerFriendsCircleTread> selectCross_server_tread(Long key)
/*     */   {
/* 239 */     (Map)getTable().select(key, new TField()
/*     */     {
/*     */       public Map<Long, xbean.CrossServerFriendsCircleTread> get(Role2FriendsCircleInfo v)
/*     */       {
/* 243 */         return v.getCross_server_treadAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Map<Long, xbean.FriendsCircleGiftResult> selectBe_sent_gift(Long key)
/*     */   {
/* 250 */     (Map)getTable().select(key, new TField()
/*     */     {
/*     */       public Map<Long, xbean.FriendsCircleGiftResult> get(Role2FriendsCircleInfo v)
/*     */       {
/* 254 */         return v.getBe_sent_giftAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Map<Long, xbean.FriendsCircleTreadResult> selectBe_trod_result(Long key)
/*     */   {
/* 261 */     (Map)getTable().select(key, new TField()
/*     */     {
/*     */       public Map<Long, xbean.FriendsCircleTreadResult> get(Role2FriendsCircleInfo v)
/*     */       {
/* 265 */         return v.getBe_trod_resultAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Map<Long, xbean.FriendsCirclePlaceTreasureResult> selectPlace_treasure_result(Long key)
/*     */   {
/* 272 */     (Map)getTable().select(key, new TField()
/*     */     {
/*     */       public Map<Long, xbean.FriendsCirclePlaceTreasureResult> get(Role2FriendsCircleInfo v)
/*     */       {
/* 276 */         return v.getPlace_treasure_resultAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Boolean selectUpdate_ornament_result(Long key)
/*     */   {
/* 283 */     (Boolean)getTable().select(key, new TField()
/*     */     {
/*     */       public Boolean get(Role2FriendsCircleInfo v)
/*     */       {
/* 287 */         return Boolean.valueOf(v.getUpdate_ornament_result());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectToday_get_popularity_from_tread(Long key)
/*     */   {
/* 294 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(Role2FriendsCircleInfo v)
/*     */       {
/* 298 */         return Integer.valueOf(v.getToday_get_popularity_from_tread());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static java.util.List<Long> selectMy_black_role_list(Long key)
/*     */   {
/* 305 */     (java.util.List)getTable().select(key, new TField()
/*     */     {
/*     */       public java.util.List<Long> get(Role2FriendsCircleInfo v)
/*     */       {
/* 309 */         return v.getMy_black_role_listAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static java.util.Set<Long> selectCross_server_black_in_role_set(Long key)
/*     */   {
/* 316 */     (java.util.Set)getTable().select(key, new TField()
/*     */     {
/*     */       public java.util.Set<Long> get(Role2FriendsCircleInfo v)
/*     */       {
/* 320 */         return v.getCross_server_black_in_role_setAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Map<Long, xbean.CrossServerFriendsCircleBlackRole> selectCross_server_black_operator(Long key)
/*     */   {
/* 327 */     (Map)getTable().select(key, new TField()
/*     */     {
/*     */       public Map<Long, xbean.CrossServerFriendsCircleBlackRole> get(Role2FriendsCircleInfo v)
/*     */       {
/* 331 */         return v.getCross_server_black_operatorAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectRepair_tread(Long key)
/*     */   {
/* 338 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(Role2FriendsCircleInfo v)
/*     */       {
/* 342 */         return Integer.valueOf(v.getRepair_tread());
/*     */       }
/*     */     });
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2friendscircle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */