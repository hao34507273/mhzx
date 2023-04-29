/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.ActivityPointExchangeGlobalInfo;
/*    */ import xbean.ActivityPointExchangeMallGlobalInfo;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Activity2activitypointexchangeglobalinfo
/*    */ {
/*    */   public static ActivityPointExchangeGlobalInfo get(Long key)
/*    */   {
/* 12 */     return (ActivityPointExchangeGlobalInfo)_Tables_.getInstance().activity2activitypointexchangeglobalinfo.get(key);
/*    */   }
/*    */   
/*    */   public static ActivityPointExchangeGlobalInfo get(Long key, ActivityPointExchangeGlobalInfo value)
/*    */   {
/* 17 */     return (ActivityPointExchangeGlobalInfo)_Tables_.getInstance().activity2activitypointexchangeglobalinfo.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, ActivityPointExchangeGlobalInfo value)
/*    */   {
/* 22 */     _Tables_.getInstance().activity2activitypointexchangeglobalinfo.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().activity2activitypointexchangeglobalinfo.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, ActivityPointExchangeGlobalInfo value)
/*    */   {
/* 32 */     return _Tables_.getInstance().activity2activitypointexchangeglobalinfo.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().activity2activitypointexchangeglobalinfo.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, ActivityPointExchangeGlobalInfo> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().activity2activitypointexchangeglobalinfo.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, ActivityPointExchangeGlobalInfo> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().activity2activitypointexchangeglobalinfo;
/*    */   }
/*    */   
/*    */   public static ActivityPointExchangeGlobalInfo select(Long key)
/*    */   {
/* 52 */     (ActivityPointExchangeGlobalInfo)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public ActivityPointExchangeGlobalInfo get(ActivityPointExchangeGlobalInfo v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Integer, ActivityPointExchangeMallGlobalInfo> selectMallcfgid2mallinfo(Long key)
/*    */   {
/* 63 */     (Map)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Map<Integer, ActivityPointExchangeMallGlobalInfo> get(ActivityPointExchangeGlobalInfo v)
/*    */       {
/* 67 */         return v.getMallcfgid2mallinfoAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Activity2activitypointexchangeglobalinfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */