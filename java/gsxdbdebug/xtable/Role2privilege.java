/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.PrivilegeAwardInfo;
/*    */ import xbean.RolePrivilegeInfo;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Role2privilege
/*    */ {
/*    */   public static RolePrivilegeInfo get(Long key)
/*    */   {
/* 12 */     return (RolePrivilegeInfo)_Tables_.getInstance().role2privilege.get(key);
/*    */   }
/*    */   
/*    */   public static RolePrivilegeInfo get(Long key, RolePrivilegeInfo value)
/*    */   {
/* 17 */     return (RolePrivilegeInfo)_Tables_.getInstance().role2privilege.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, RolePrivilegeInfo value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2privilege.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2privilege.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, RolePrivilegeInfo value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2privilege.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2privilege.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, RolePrivilegeInfo> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2privilege.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, RolePrivilegeInfo> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2privilege;
/*    */   }
/*    */   
/*    */   public static RolePrivilegeInfo select(Long key)
/*    */   {
/* 52 */     (RolePrivilegeInfo)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public RolePrivilegeInfo get(RolePrivilegeInfo v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Integer, PrivilegeAwardInfo> selectFreshman_award_infos(Long key)
/*    */   {
/* 63 */     (Map)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Map<Integer, PrivilegeAwardInfo> get(RolePrivilegeInfo v)
/*    */       {
/* 67 */         return v.getFreshman_award_infosAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Integer, PrivilegeAwardInfo> selectLogin_award_infos(Long key)
/*    */   {
/* 74 */     (Map)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Map<Integer, PrivilegeAwardInfo> get(RolePrivilegeInfo v)
/*    */       {
/* 78 */         return v.getLogin_award_infosAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2privilege.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */