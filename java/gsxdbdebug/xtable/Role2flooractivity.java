/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.RoleFloorActivityInfo;
/*    */ import xbean.RoleFloorInfo;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Role2flooractivity
/*    */ {
/*    */   public static RoleFloorActivityInfo get(Long key)
/*    */   {
/* 12 */     return (RoleFloorActivityInfo)_Tables_.getInstance().role2flooractivity.get(key);
/*    */   }
/*    */   
/*    */   public static RoleFloorActivityInfo get(Long key, RoleFloorActivityInfo value)
/*    */   {
/* 17 */     return (RoleFloorActivityInfo)_Tables_.getInstance().role2flooractivity.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, RoleFloorActivityInfo value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2flooractivity.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2flooractivity.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, RoleFloorActivityInfo value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2flooractivity.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2flooractivity.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, RoleFloorActivityInfo> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2flooractivity.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, RoleFloorActivityInfo> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2flooractivity;
/*    */   }
/*    */   
/*    */   public static RoleFloorActivityInfo select(Long key)
/*    */   {
/* 52 */     (RoleFloorActivityInfo)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public RoleFloorActivityInfo get(RoleFloorActivityInfo v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Integer, RoleFloorInfo> selectActivityinfo(Long key)
/*    */   {
/* 63 */     (Map)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Map<Integer, RoleFloorInfo> get(RoleFloorActivityInfo v)
/*    */       {
/* 67 */         return v.getActivityinfoAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Integer, Integer> selectHelpdata(Long key)
/*    */   {
/* 74 */     (Map)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Map<Integer, Integer> get(RoleFloorActivityInfo v)
/*    */       {
/* 78 */         return v.getHelpdataAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2flooractivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */