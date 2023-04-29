/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.RoleWorldGoalInfo;
/*    */ import xbean.WorldGoalActivityInfo;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Role2worldgoalinfo
/*    */ {
/*    */   public static RoleWorldGoalInfo get(Long key)
/*    */   {
/* 12 */     return (RoleWorldGoalInfo)_Tables_.getInstance().role2worldgoalinfo.get(key);
/*    */   }
/*    */   
/*    */   public static RoleWorldGoalInfo get(Long key, RoleWorldGoalInfo value)
/*    */   {
/* 17 */     return (RoleWorldGoalInfo)_Tables_.getInstance().role2worldgoalinfo.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, RoleWorldGoalInfo value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2worldgoalinfo.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2worldgoalinfo.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, RoleWorldGoalInfo value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2worldgoalinfo.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2worldgoalinfo.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, RoleWorldGoalInfo> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2worldgoalinfo.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, RoleWorldGoalInfo> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2worldgoalinfo;
/*    */   }
/*    */   
/*    */   public static RoleWorldGoalInfo select(Long key)
/*    */   {
/* 52 */     (RoleWorldGoalInfo)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public RoleWorldGoalInfo get(RoleWorldGoalInfo v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Integer, WorldGoalActivityInfo> selectWorld_goal_activity_infos(Long key)
/*    */   {
/* 63 */     (Map)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Map<Integer, WorldGoalActivityInfo> get(RoleWorldGoalInfo v)
/*    */       {
/* 67 */         return v.getWorld_goal_activity_infosAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2worldgoalinfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */