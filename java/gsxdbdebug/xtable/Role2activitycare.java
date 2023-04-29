/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.ActivityCareMap;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Role2activitycare
/*    */ {
/*    */   public static ActivityCareMap get(Long key)
/*    */   {
/* 12 */     return (ActivityCareMap)_Tables_.getInstance().role2activitycare.get(key);
/*    */   }
/*    */   
/*    */   public static ActivityCareMap get(Long key, ActivityCareMap value)
/*    */   {
/* 17 */     return (ActivityCareMap)_Tables_.getInstance().role2activitycare.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, ActivityCareMap value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2activitycare.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2activitycare.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, ActivityCareMap value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2activitycare.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2activitycare.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, ActivityCareMap> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2activitycare.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, ActivityCareMap> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2activitycare;
/*    */   }
/*    */   
/*    */   public static ActivityCareMap select(Long key)
/*    */   {
/* 52 */     (ActivityCareMap)getTable().select(key, new TField()
/*    */     {
/*    */       public ActivityCareMap get(ActivityCareMap v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Integer, Integer> selectActivitycaremap(Long key)
/*    */   {
/* 63 */     (Map)getTable().select(key, new TField()
/*    */     {
/*    */       public Map<Integer, Integer> get(ActivityCareMap v)
/*    */       {
/* 67 */         return v.getActivitycaremapAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2activitycare.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */