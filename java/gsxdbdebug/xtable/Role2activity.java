/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.Activity;
/*    */ import xbean.ActivityBean;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Role2activity
/*    */ {
/*    */   public static Activity get(Long key)
/*    */   {
/* 12 */     return (Activity)_Tables_.getInstance().role2activity.get(key);
/*    */   }
/*    */   
/*    */   public static Activity get(Long key, Activity value)
/*    */   {
/* 17 */     return (Activity)_Tables_.getInstance().role2activity.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, Activity value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2activity.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2activity.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, Activity value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2activity.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2activity.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, Activity> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2activity.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, Activity> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2activity;
/*    */   }
/*    */   
/*    */   public static Activity select(Long key)
/*    */   {
/* 52 */     (Activity)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Activity get(Activity v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Integer, ActivityBean> selectActivitymap(Long key)
/*    */   {
/* 63 */     (Map)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Map<Integer, ActivityBean> get(Activity v)
/*    */       {
/* 67 */         return v.getActivitymapAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2activity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */