/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.ActivityCompensate;
/*    */ import xbean.ActivityCompensates;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Role2activitycompensate
/*    */ {
/*    */   public static ActivityCompensates get(Long key)
/*    */   {
/* 12 */     return (ActivityCompensates)_Tables_.getInstance().role2activitycompensate.get(key);
/*    */   }
/*    */   
/*    */   public static ActivityCompensates get(Long key, ActivityCompensates value)
/*    */   {
/* 17 */     return (ActivityCompensates)_Tables_.getInstance().role2activitycompensate.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, ActivityCompensates value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2activitycompensate.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2activitycompensate.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, ActivityCompensates value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2activitycompensate.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2activitycompensate.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, ActivityCompensates> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2activitycompensate.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, ActivityCompensates> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2activitycompensate;
/*    */   }
/*    */   
/*    */   public static ActivityCompensates select(Long key)
/*    */   {
/* 52 */     (ActivityCompensates)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public ActivityCompensates get(ActivityCompensates v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Integer, ActivityCompensate> selectCompensates(Long key)
/*    */   {
/* 63 */     (Map)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Map<Integer, ActivityCompensate> get(ActivityCompensates v)
/*    */       {
/* 67 */         return v.getCompensatesAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2activitycompensate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */