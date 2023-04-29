/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.Activity;
/*    */ import xbean.ActivityBean;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class User2activity
/*    */ {
/*    */   public static Activity get(String key)
/*    */   {
/* 12 */     return (Activity)_Tables_.getInstance().user2activity.get(key);
/*    */   }
/*    */   
/*    */   public static Activity get(String key, Activity value)
/*    */   {
/* 17 */     return (Activity)_Tables_.getInstance().user2activity.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(String key, Activity value)
/*    */   {
/* 22 */     _Tables_.getInstance().user2activity.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(String key)
/*    */   {
/* 27 */     _Tables_.getInstance().user2activity.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(String key, Activity value)
/*    */   {
/* 32 */     return _Tables_.getInstance().user2activity.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(String key)
/*    */   {
/* 37 */     return _Tables_.getInstance().user2activity.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<String, Activity> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().user2activity.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<String, Activity> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().user2activity;
/*    */   }
/*    */   
/*    */   public static Activity select(String key)
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
/*    */   public static Map<Integer, ActivityBean> selectActivitymap(String key)
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


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\User2activity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */