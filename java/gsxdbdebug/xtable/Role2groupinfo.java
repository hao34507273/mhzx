/*     */ package xtable;
/*     */ 
/*     */ import java.util.Map;
/*     */ import xbean.GroupInfo;
/*     */ import xbean.GroupSetting;
/*     */ import xdb.TTable;
/*     */ 
/*     */ public class Role2groupinfo
/*     */ {
/*     */   public static GroupInfo get(Long key)
/*     */   {
/*  12 */     return (GroupInfo)_Tables_.getInstance().role2groupinfo.get(key);
/*     */   }
/*     */   
/*     */   public static GroupInfo get(Long key, GroupInfo value)
/*     */   {
/*  17 */     return (GroupInfo)_Tables_.getInstance().role2groupinfo.get(key, value);
/*     */   }
/*     */   
/*     */   public static void insert(Long key, GroupInfo value)
/*     */   {
/*  22 */     _Tables_.getInstance().role2groupinfo.insert(key, value);
/*     */   }
/*     */   
/*     */   public static void delete(Long key)
/*     */   {
/*  27 */     _Tables_.getInstance().role2groupinfo.delete(key);
/*     */   }
/*     */   
/*     */   public static boolean add(Long key, GroupInfo value)
/*     */   {
/*  32 */     return _Tables_.getInstance().role2groupinfo.add(key, value);
/*     */   }
/*     */   
/*     */   public static boolean remove(Long key)
/*     */   {
/*  37 */     return _Tables_.getInstance().role2groupinfo.remove(key);
/*     */   }
/*     */   
/*     */   public static xdb.TTableCache<Long, GroupInfo> getCache()
/*     */   {
/*  42 */     return _Tables_.getInstance().role2groupinfo.getCache();
/*     */   }
/*     */   
/*     */   public static TTable<Long, GroupInfo> getTable()
/*     */   {
/*  47 */     return _Tables_.getInstance().role2groupinfo;
/*     */   }
/*     */   
/*     */   public static GroupInfo select(Long key)
/*     */   {
/*  52 */     (GroupInfo)getTable().select(key, new xdb.TField()
/*     */     {
/*     */       public GroupInfo get(GroupInfo v)
/*     */       {
/*  56 */         return v.toData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Map<Long, GroupSetting> selectCreate_same_zone_groupids(Long key)
/*     */   {
/*  63 */     (Map)getTable().select(key, new xdb.TField()
/*     */     {
/*     */       public Map<Long, GroupSetting> get(GroupInfo v)
/*     */       {
/*  67 */         return v.getCreate_same_zone_groupidsAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Map<Long, GroupSetting> selectJoin_same_zone_groupids(Long key)
/*     */   {
/*  74 */     (Map)getTable().select(key, new xdb.TField()
/*     */     {
/*     */       public Map<Long, GroupSetting> get(GroupInfo v)
/*     */       {
/*  78 */         return v.getJoin_same_zone_groupidsAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Map<Long, Long> selectOffline_group_join_infos(Long key)
/*     */   {
/*  85 */     (Map)getTable().select(key, new xdb.TField()
/*     */     {
/*     */       public Map<Long, Long> get(GroupInfo v)
/*     */       {
/*  89 */         return v.getOffline_group_join_infosAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Map<Long, Long> selectOffline_group_kick_infos(Long key)
/*     */   {
/*  96 */     (Map)getTable().select(key, new xdb.TField()
/*     */     {
/*     */       public Map<Long, Long> get(GroupInfo v)
/*     */       {
/* 100 */         return v.getOffline_group_kick_infosAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public static Map<Long, String> selectOffline_group_dissolve_infos(Long key)
/*     */   {
/* 107 */     (Map)getTable().select(key, new xdb.TField()
/*     */     {
/*     */       public Map<Long, String> get(GroupInfo v)
/*     */       {
/* 111 */         return v.getOffline_group_dissolve_infosAsData();
/*     */       }
/*     */     });
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2groupinfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */