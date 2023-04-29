/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.RoleAvatarSessionInfo;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Role2avatarsession
/*    */ {
/*    */   public static RoleAvatarSessionInfo get(Long key)
/*    */   {
/* 12 */     return (RoleAvatarSessionInfo)_Tables_.getInstance().role2avatarsession.get(key);
/*    */   }
/*    */   
/*    */   public static RoleAvatarSessionInfo get(Long key, RoleAvatarSessionInfo value)
/*    */   {
/* 17 */     return (RoleAvatarSessionInfo)_Tables_.getInstance().role2avatarsession.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, RoleAvatarSessionInfo value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2avatarsession.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2avatarsession.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, RoleAvatarSessionInfo value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2avatarsession.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2avatarsession.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, RoleAvatarSessionInfo> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2avatarsession.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, RoleAvatarSessionInfo> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2avatarsession;
/*    */   }
/*    */   
/*    */   public static RoleAvatarSessionInfo select(Long key)
/*    */   {
/* 52 */     (RoleAvatarSessionInfo)getTable().select(key, new TField()
/*    */     {
/*    */       public RoleAvatarSessionInfo get(RoleAvatarSessionInfo v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Integer, Long> select_expire_sessions(Long key)
/*    */   {
/* 63 */     (Map)getTable().select(key, new TField()
/*    */     {
/*    */       public Map<Integer, Long> get(RoleAvatarSessionInfo v)
/*    */       {
/* 67 */         return v.get_expire_sessionsAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2avatarsession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */