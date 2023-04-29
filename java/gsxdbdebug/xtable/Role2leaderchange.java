/*    */ package xtable;
/*    */ 
/*    */ import xbean.LeaderChangeBean;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ import xdb.TTableCache;
/*    */ 
/*    */ public class Role2leaderchange
/*    */ {
/*    */   public static LeaderChangeBean get(Long key)
/*    */   {
/* 12 */     return (LeaderChangeBean)_Tables_.getInstance().role2leaderchange.get(key);
/*    */   }
/*    */   
/*    */   public static LeaderChangeBean get(Long key, LeaderChangeBean value)
/*    */   {
/* 17 */     return (LeaderChangeBean)_Tables_.getInstance().role2leaderchange.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, LeaderChangeBean value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2leaderchange.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2leaderchange.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, LeaderChangeBean value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2leaderchange.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2leaderchange.remove(key);
/*    */   }
/*    */   
/*    */   public static TTableCache<Long, LeaderChangeBean> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2leaderchange.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, LeaderChangeBean> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2leaderchange;
/*    */   }
/*    */   
/*    */   public static LeaderChangeBean select(Long key)
/*    */   {
/* 52 */     (LeaderChangeBean)getTable().select(key, new TField()
/*    */     {
/*    */       public LeaderChangeBean get(LeaderChangeBean v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Long selectSessionid(Long key)
/*    */   {
/* 63 */     (Long)getTable().select(key, new TField()
/*    */     {
/*    */       public Long get(LeaderChangeBean v)
/*    */       {
/* 67 */         return Long.valueOf(v.getSessionid());
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2leaderchange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */