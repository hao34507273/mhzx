/*     */ package xtable;
/*     */ 
/*     */ import java.util.Map;
/*     */ import xbean.Role2MountsInfo;
/*     */ import xdb.TField;
/*     */ import xdb.TTable;
/*     */ 
/*     */ public class Role2mounts
/*     */ {
/*     */   public static Role2MountsInfo get(Long key)
/*     */   {
/*  12 */     return (Role2MountsInfo)_Tables_.getInstance().role2mounts.get(key);
/*     */   }
/*     */   
/*     */   public static Role2MountsInfo get(Long key, Role2MountsInfo value)
/*     */   {
/*  17 */     return (Role2MountsInfo)_Tables_.getInstance().role2mounts.get(key, value);
/*     */   }
/*     */   
/*     */   public static void insert(Long key, Role2MountsInfo value)
/*     */   {
/*  22 */     _Tables_.getInstance().role2mounts.insert(key, value);
/*     */   }
/*     */   
/*     */   public static void delete(Long key)
/*     */   {
/*  27 */     _Tables_.getInstance().role2mounts.delete(key);
/*     */   }
/*     */   
/*     */   public static boolean add(Long key, Role2MountsInfo value)
/*     */   {
/*  32 */     return _Tables_.getInstance().role2mounts.add(key, value);
/*     */   }
/*     */   
/*     */   public static boolean remove(Long key)
/*     */   {
/*  37 */     return _Tables_.getInstance().role2mounts.remove(key);
/*     */   }
/*     */   
/*     */   public static xdb.TTableCache<Long, Role2MountsInfo> getCache()
/*     */   {
/*  42 */     return _Tables_.getInstance().role2mounts.getCache();
/*     */   }
/*     */   
/*     */   public static TTable<Long, Role2MountsInfo> getTable()
/*     */   {
/*  47 */     return _Tables_.getInstance().role2mounts;
/*     */   }
/*     */   
/*     */   public static Role2MountsInfo select(Long key)
/*     */   {
/*  52 */     (Role2MountsInfo)getTable().select(key, new TField()
/*     */     {
/*     */       public Role2MountsInfo get(Role2MountsInfo v)
/*     */       {
/*  56 */         return v.toData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Map<Long, xbean.MountsInfo> selectMounts_info_map(Long key)
/*     */   {
/*  63 */     (Map)getTable().select(key, new TField()
/*     */     {
/*     */       public Map<Long, xbean.MountsInfo> get(Role2MountsInfo v)
/*     */       {
/*  67 */         return v.getMounts_info_mapAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Map<Integer, xbean.BattleMountsInfo> selectBattle_mounts_info_map(Long key)
/*     */   {
/*  74 */     (Map)getTable().select(key, new TField()
/*     */     {
/*     */       public Map<Integer, xbean.BattleMountsInfo> get(Role2MountsInfo v)
/*     */       {
/*  78 */         return v.getBattle_mounts_info_mapAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Map<Long, xbean.AppearenceMountsInfo> selectAppearence_mounts_info_map(Long key)
/*     */   {
/*  85 */     (Map)getTable().select(key, new TField()
/*     */     {
/*     */       public Map<Long, xbean.AppearenceMountsInfo> get(Role2MountsInfo v)
/*     */       {
/*  89 */         return v.getAppearence_mounts_info_mapAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Long selectCurrent_ride_mounts_id(Long key)
/*     */   {
/*  96 */     (Long)getTable().select(key, new TField()
/*     */     {
/*     */       public Long get(Role2MountsInfo v)
/*     */       {
/* 100 */         return Long.valueOf(v.getCurrent_ride_mounts_id());
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Integer selectCurrent_chief_battle_mounts(Long key)
/*     */   {
/* 107 */     (Integer)getTable().select(key, new TField()
/*     */     {
/*     */       public Integer get(Role2MountsInfo v)
/*     */       {
/* 111 */         return Integer.valueOf(v.getCurrent_chief_battle_mounts());
/*     */       }
/*     */     });
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2mounts.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */