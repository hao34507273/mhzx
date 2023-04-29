/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import java.util.Set;
/*    */ import xbean.Role2QingYuanInfo;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Role2qingyuan
/*    */ {
/*    */   public static Role2QingYuanInfo get(Long key)
/*    */   {
/* 12 */     return (Role2QingYuanInfo)_Tables_.getInstance().role2qingyuan.get(key);
/*    */   }
/*    */   
/*    */   public static Role2QingYuanInfo get(Long key, Role2QingYuanInfo value)
/*    */   {
/* 17 */     return (Role2QingYuanInfo)_Tables_.getInstance().role2qingyuan.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, Role2QingYuanInfo value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2qingyuan.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2qingyuan.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, Role2QingYuanInfo value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2qingyuan.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2qingyuan.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, Role2QingYuanInfo> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2qingyuan.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, Role2QingYuanInfo> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2qingyuan;
/*    */   }
/*    */   
/*    */   public static Role2QingYuanInfo select(Long key)
/*    */   {
/* 52 */     (Role2QingYuanInfo)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Role2QingYuanInfo get(Role2QingYuanInfo v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static java.util.List<Long> selectQing_yuan_role_list(Long key)
/*    */   {
/* 63 */     (java.util.List)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public java.util.List<Long> get(Role2QingYuanInfo v)
/*    */       {
/* 67 */         return v.getQing_yuan_role_listAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Long, xbean.QingYuanRoleInfo> selectQing_yuan_map_info(Long key)
/*    */   {
/* 74 */     (Map)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Map<Long, xbean.QingYuanRoleInfo> get(Role2QingYuanInfo v)
/*    */       {
/* 78 */         return v.getQing_yuan_map_infoAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Set<Integer> selectAleardy_used_appellation_cfg_id_set(Long key)
/*    */   {
/* 85 */     (Set)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Set<Integer> get(Role2QingYuanInfo v)
/*    */       {
/* 89 */         return v.getAleardy_used_appellation_cfg_id_setAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2qingyuan.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */