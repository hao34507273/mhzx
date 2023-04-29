/*    */ package xtable;
/*    */ 
/*    */ import xbean.HeartBeatBean;
/*    */ import xdb.TTable;
/*    */ import xdb.TTableCache;
/*    */ 
/*    */ 
/*    */ public class Role2heartbeat
/*    */ {
/*    */   public static HeartBeatBean get(Long key)
/*    */   {
/* 12 */     return (HeartBeatBean)_Tables_.getInstance().role2heartbeat.get(key);
/*    */   }
/*    */   
/*    */   public static HeartBeatBean get(Long key, HeartBeatBean value)
/*    */   {
/* 17 */     return (HeartBeatBean)_Tables_.getInstance().role2heartbeat.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, HeartBeatBean value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2heartbeat.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2heartbeat.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, HeartBeatBean value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2heartbeat.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2heartbeat.remove(key);
/*    */   }
/*    */   
/*    */   public static TTableCache<Long, HeartBeatBean> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2heartbeat.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, HeartBeatBean> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2heartbeat;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2heartbeat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */