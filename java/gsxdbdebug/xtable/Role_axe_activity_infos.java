/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.AxeActivityInfo;
/*    */ import xbean.RoleAxeActivityInfo;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Role_axe_activity_infos
/*    */ {
/*    */   public static RoleAxeActivityInfo get(Long key)
/*    */   {
/* 12 */     return (RoleAxeActivityInfo)_Tables_.getInstance().role_axe_activity_infos.get(key);
/*    */   }
/*    */   
/*    */   public static RoleAxeActivityInfo get(Long key, RoleAxeActivityInfo value)
/*    */   {
/* 17 */     return (RoleAxeActivityInfo)_Tables_.getInstance().role_axe_activity_infos.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, RoleAxeActivityInfo value)
/*    */   {
/* 22 */     _Tables_.getInstance().role_axe_activity_infos.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role_axe_activity_infos.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, RoleAxeActivityInfo value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role_axe_activity_infos.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role_axe_activity_infos.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, RoleAxeActivityInfo> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role_axe_activity_infos.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, RoleAxeActivityInfo> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role_axe_activity_infos;
/*    */   }
/*    */   
/*    */   public static RoleAxeActivityInfo select(Long key)
/*    */   {
/* 52 */     (RoleAxeActivityInfo)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public RoleAxeActivityInfo get(RoleAxeActivityInfo v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Integer, AxeActivityInfo> selectAxe_activity_infos(Long key)
/*    */   {
/* 63 */     (Map)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Map<Integer, AxeActivityInfo> get(RoleAxeActivityInfo v)
/*    */       {
/* 67 */         return v.getAxe_activity_infosAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role_axe_activity_infos.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */