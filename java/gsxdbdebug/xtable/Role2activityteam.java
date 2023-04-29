/*    */ package xtable;
/*    */ 
/*    */ import xbean.ActivityTeamBean;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ import xdb.TTableCache;
/*    */ 
/*    */ public class Role2activityteam
/*    */ {
/*    */   public static ActivityTeamBean get(Long key)
/*    */   {
/* 12 */     return (ActivityTeamBean)_Tables_.getInstance().role2activityteam.get(key);
/*    */   }
/*    */   
/*    */   public static ActivityTeamBean get(Long key, ActivityTeamBean value)
/*    */   {
/* 17 */     return (ActivityTeamBean)_Tables_.getInstance().role2activityteam.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, ActivityTeamBean value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2activityteam.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2activityteam.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, ActivityTeamBean value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2activityteam.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2activityteam.remove(key);
/*    */   }
/*    */   
/*    */   public static TTableCache<Long, ActivityTeamBean> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2activityteam.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, ActivityTeamBean> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2activityteam;
/*    */   }
/*    */   
/*    */   public static ActivityTeamBean select(Long key)
/*    */   {
/* 52 */     (ActivityTeamBean)getTable().select(key, new TField()
/*    */     {
/*    */       public ActivityTeamBean get(ActivityTeamBean v)
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
/*    */       public Long get(ActivityTeamBean v)
/*    */       {
/* 67 */         return Long.valueOf(v.getSessionid());
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2activityteam.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */