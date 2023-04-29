/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.ActivityCompensateGlobal;
/*    */ import xbean.ActivityCompensatesGlobal;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Activitycompensate_global
/*    */ {
/*    */   public static ActivityCompensatesGlobal get(Long key)
/*    */   {
/* 12 */     return (ActivityCompensatesGlobal)_Tables_.getInstance().activitycompensate_global.get(key);
/*    */   }
/*    */   
/*    */   public static ActivityCompensatesGlobal get(Long key, ActivityCompensatesGlobal value)
/*    */   {
/* 17 */     return (ActivityCompensatesGlobal)_Tables_.getInstance().activitycompensate_global.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, ActivityCompensatesGlobal value)
/*    */   {
/* 22 */     _Tables_.getInstance().activitycompensate_global.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().activitycompensate_global.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, ActivityCompensatesGlobal value)
/*    */   {
/* 32 */     return _Tables_.getInstance().activitycompensate_global.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().activitycompensate_global.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, ActivityCompensatesGlobal> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().activitycompensate_global.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, ActivityCompensatesGlobal> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().activitycompensate_global;
/*    */   }
/*    */   
/*    */   public static ActivityCompensatesGlobal select(Long key)
/*    */   {
/* 52 */     (ActivityCompensatesGlobal)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public ActivityCompensatesGlobal get(ActivityCompensatesGlobal v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Integer, ActivityCompensateGlobal> selectActivity2compensateglobal(Long key)
/*    */   {
/* 63 */     (Map)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Map<Integer, ActivityCompensateGlobal> get(ActivityCompensatesGlobal v)
/*    */       {
/* 67 */         return v.getActivity2compensateglobalAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Activitycompensate_global.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */