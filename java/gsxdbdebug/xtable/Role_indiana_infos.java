/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.RoleIndianaActivityInfo;
/*    */ import xbean.RoleIndianaInfo;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Role_indiana_infos
/*    */ {
/*    */   public static RoleIndianaInfo get(Long key)
/*    */   {
/* 12 */     return (RoleIndianaInfo)_Tables_.getInstance().role_indiana_infos.get(key);
/*    */   }
/*    */   
/*    */   public static RoleIndianaInfo get(Long key, RoleIndianaInfo value)
/*    */   {
/* 17 */     return (RoleIndianaInfo)_Tables_.getInstance().role_indiana_infos.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, RoleIndianaInfo value)
/*    */   {
/* 22 */     _Tables_.getInstance().role_indiana_infos.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role_indiana_infos.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, RoleIndianaInfo value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role_indiana_infos.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role_indiana_infos.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, RoleIndianaInfo> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role_indiana_infos.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, RoleIndianaInfo> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role_indiana_infos;
/*    */   }
/*    */   
/*    */   public static RoleIndianaInfo select(Long key)
/*    */   {
/* 52 */     (RoleIndianaInfo)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public RoleIndianaInfo get(RoleIndianaInfo v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Integer, RoleIndianaActivityInfo> selectActivity_infos(Long key)
/*    */   {
/* 63 */     (Map)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Map<Integer, RoleIndianaActivityInfo> get(RoleIndianaInfo v)
/*    */       {
/* 67 */         return v.getActivity_infosAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role_indiana_infos.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */