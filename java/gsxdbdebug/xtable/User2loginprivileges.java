/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.UserLoginPrivilegeInfo;
/*    */ import xbean.UserLoginPrivileges;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class User2loginprivileges
/*    */ {
/*    */   public static UserLoginPrivileges get(String key)
/*    */   {
/* 12 */     return (UserLoginPrivileges)_Tables_.getInstance().user2loginprivileges.get(key);
/*    */   }
/*    */   
/*    */   public static UserLoginPrivileges get(String key, UserLoginPrivileges value)
/*    */   {
/* 17 */     return (UserLoginPrivileges)_Tables_.getInstance().user2loginprivileges.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(String key, UserLoginPrivileges value)
/*    */   {
/* 22 */     _Tables_.getInstance().user2loginprivileges.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(String key)
/*    */   {
/* 27 */     _Tables_.getInstance().user2loginprivileges.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(String key, UserLoginPrivileges value)
/*    */   {
/* 32 */     return _Tables_.getInstance().user2loginprivileges.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(String key)
/*    */   {
/* 37 */     return _Tables_.getInstance().user2loginprivileges.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<String, UserLoginPrivileges> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().user2loginprivileges.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<String, UserLoginPrivileges> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().user2loginprivileges;
/*    */   }
/*    */   
/*    */   public static UserLoginPrivileges select(String key)
/*    */   {
/* 52 */     (UserLoginPrivileges)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public UserLoginPrivileges get(UserLoginPrivileges v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Integer, UserLoginPrivilegeInfo> selectPrivileges(String key)
/*    */   {
/* 63 */     (Map)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Map<Integer, UserLoginPrivilegeInfo> get(UserLoginPrivileges v)
/*    */       {
/* 67 */         return v.getPrivilegesAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\User2loginprivileges.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */