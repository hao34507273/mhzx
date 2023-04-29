/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.ActivityGlobalBean;
/*    */ import xbean.OpenBeanStore;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Activity
/*    */ {
/*    */   public static ActivityGlobalBean get(Long key)
/*    */   {
/* 12 */     return (ActivityGlobalBean)_Tables_.getInstance().activity.get(key);
/*    */   }
/*    */   
/*    */   public static ActivityGlobalBean get(Long key, ActivityGlobalBean value)
/*    */   {
/* 17 */     return (ActivityGlobalBean)_Tables_.getInstance().activity.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, ActivityGlobalBean value)
/*    */   {
/* 22 */     _Tables_.getInstance().activity.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().activity.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, ActivityGlobalBean value)
/*    */   {
/* 32 */     return _Tables_.getInstance().activity.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().activity.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, ActivityGlobalBean> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().activity.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, ActivityGlobalBean> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().activity;
/*    */   }
/*    */   
/*    */   public static ActivityGlobalBean select(Long key)
/*    */   {
/* 52 */     (ActivityGlobalBean)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public ActivityGlobalBean get(ActivityGlobalBean v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Integer, OpenBeanStore> selectActivityopenmap(Long key)
/*    */   {
/* 63 */     (Map)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Map<Integer, OpenBeanStore> get(ActivityGlobalBean v)
/*    */       {
/* 67 */         return v.getActivityopenmapAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Activity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */