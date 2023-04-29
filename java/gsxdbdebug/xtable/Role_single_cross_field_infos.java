/*     */ package xtable;
/*     */ 
/*     */ import java.util.Map;
/*     */ import xbean.RoleSingleCrossFieldInfo;
/*     */ import xdb.TField;
/*     */ import xdb.TTable;
/*     */ 
/*     */ public class Role_single_cross_field_infos
/*     */ {
/*     */   public static RoleSingleCrossFieldInfo get(Long key)
/*     */   {
/*  12 */     return (RoleSingleCrossFieldInfo)_Tables_.getInstance().role_single_cross_field_infos.get(key);
/*     */   }
/*     */   
/*     */   public static RoleSingleCrossFieldInfo get(Long key, RoleSingleCrossFieldInfo value)
/*     */   {
/*  17 */     return (RoleSingleCrossFieldInfo)_Tables_.getInstance().role_single_cross_field_infos.get(key, value);
/*     */   }
/*     */   
/*     */   public static void insert(Long key, RoleSingleCrossFieldInfo value)
/*     */   {
/*  22 */     _Tables_.getInstance().role_single_cross_field_infos.insert(key, value);
/*     */   }
/*     */   
/*     */   public static void delete(Long key)
/*     */   {
/*  27 */     _Tables_.getInstance().role_single_cross_field_infos.delete(key);
/*     */   }
/*     */   
/*     */   public static boolean add(Long key, RoleSingleCrossFieldInfo value)
/*     */   {
/*  32 */     return _Tables_.getInstance().role_single_cross_field_infos.add(key, value);
/*     */   }
/*     */   
/*     */   public static boolean remove(Long key)
/*     */   {
/*  37 */     return _Tables_.getInstance().role_single_cross_field_infos.remove(key);
/*     */   }
/*     */   
/*     */   public static xdb.TTableCache<Long, RoleSingleCrossFieldInfo> getCache()
/*     */   {
/*  42 */     return _Tables_.getInstance().role_single_cross_field_infos.getCache();
/*     */   }
/*     */   
/*     */   public static TTable<Long, RoleSingleCrossFieldInfo> getTable()
/*     */   {
/*  47 */     return _Tables_.getInstance().role_single_cross_field_infos;
/*     */   }
/*     */   
/*     */   public static RoleSingleCrossFieldInfo select(Long key)
/*     */   {
/*  52 */     (RoleSingleCrossFieldInfo)getTable().select(key, new TField()
/*     */     {
/*     */       public RoleSingleCrossFieldInfo get(RoleSingleCrossFieldInfo v)
/*     */       {
/*  56 */         return v.toData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectActive_leave_field_timestamp(Long key)
/*     */   {
/*  63 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(RoleSingleCrossFieldInfo v)
/*     */       {
/*  67 */         return Long.valueOf(v.getActive_leave_field_timestamp());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Map<Integer, xbean.RoleSingleCrossFieldSeasonInfo> selectSeason_infos(Long key)
/*     */   {
/*  74 */     (Map)getTable().select(key, new TField()
/*     */     {
/*     */       public Map<Integer, xbean.RoleSingleCrossFieldSeasonInfo> get(RoleSingleCrossFieldInfo v)
/*     */       {
/*  78 */         return v.getSeason_infosAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectWeekly_point_sum(Long key)
/*     */   {
/*  85 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(RoleSingleCrossFieldInfo v)
/*     */       {
/*  89 */         return Integer.valueOf(v.getWeekly_point_sum());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectWeekly_point_sum_timestamp(Long key)
/*     */   {
/*  96 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(RoleSingleCrossFieldInfo v)
/*     */       {
/* 100 */         return Long.valueOf(v.getWeekly_point_sum_timestamp());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectDaily_award_times(Long key)
/*     */   {
/* 107 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(RoleSingleCrossFieldInfo v)
/*     */       {
/* 111 */         return Integer.valueOf(v.getDaily_award_times());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectDaily_award_times_timestamp(Long key)
/*     */   {
/* 118 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(RoleSingleCrossFieldInfo v)
/*     */       {
/* 122 */         return Long.valueOf(v.getDaily_award_times_timestamp());
/*     */       }
/*     */     });
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role_single_cross_field_infos.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */