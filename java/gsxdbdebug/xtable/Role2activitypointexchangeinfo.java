/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.ActivityPointExchangeInfo;
/*    */ import xbean.ActivityPointExchangeMallInfo;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Role2activitypointexchangeinfo
/*    */ {
/*    */   public static ActivityPointExchangeInfo get(Long key)
/*    */   {
/* 12 */     return (ActivityPointExchangeInfo)_Tables_.getInstance().role2activitypointexchangeinfo.get(key);
/*    */   }
/*    */   
/*    */   public static ActivityPointExchangeInfo get(Long key, ActivityPointExchangeInfo value)
/*    */   {
/* 17 */     return (ActivityPointExchangeInfo)_Tables_.getInstance().role2activitypointexchangeinfo.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, ActivityPointExchangeInfo value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2activitypointexchangeinfo.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2activitypointexchangeinfo.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, ActivityPointExchangeInfo value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2activitypointexchangeinfo.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2activitypointexchangeinfo.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, ActivityPointExchangeInfo> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2activitypointexchangeinfo.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, ActivityPointExchangeInfo> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2activitypointexchangeinfo;
/*    */   }
/*    */   
/*    */   public static ActivityPointExchangeInfo select(Long key)
/*    */   {
/* 52 */     (ActivityPointExchangeInfo)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public ActivityPointExchangeInfo get(ActivityPointExchangeInfo v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Integer, ActivityPointExchangeMallInfo> selectActivityid2mallinfo(Long key)
/*    */   {
/* 63 */     (Map)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Map<Integer, ActivityPointExchangeMallInfo> get(ActivityPointExchangeInfo v)
/*    */       {
/* 67 */         return v.getActivityid2mallinfoAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2activitypointexchangeinfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */