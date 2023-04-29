/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.BadgeInfo;
/*    */ import xbean.RoleBadgesInfo;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Role2rolebadgesinfo
/*    */ {
/*    */   public static RoleBadgesInfo get(Long key)
/*    */   {
/* 12 */     return (RoleBadgesInfo)_Tables_.getInstance().role2rolebadgesinfo.get(key);
/*    */   }
/*    */   
/*    */   public static RoleBadgesInfo get(Long key, RoleBadgesInfo value)
/*    */   {
/* 17 */     return (RoleBadgesInfo)_Tables_.getInstance().role2rolebadgesinfo.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, RoleBadgesInfo value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2rolebadgesinfo.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2rolebadgesinfo.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, RoleBadgesInfo value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2rolebadgesinfo.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2rolebadgesinfo.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, RoleBadgesInfo> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2rolebadgesinfo.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, RoleBadgesInfo> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2rolebadgesinfo;
/*    */   }
/*    */   
/*    */   public static RoleBadgesInfo select(Long key)
/*    */   {
/* 52 */     (RoleBadgesInfo)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public RoleBadgesInfo get(RoleBadgesInfo v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Integer, BadgeInfo> selectBadgesinfo(Long key)
/*    */   {
/* 63 */     (Map)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Map<Integer, BadgeInfo> get(RoleBadgesInfo v)
/*    */       {
/* 67 */         return v.getBadgesinfoAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2rolebadgesinfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */