/*    */ package xtable;
/*    */ 
/*    */ import xbean.OfflineExpReward;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ import xdb.TTableCache;
/*    */ 
/*    */ public class Role2offlineexpreward
/*    */ {
/*    */   public static OfflineExpReward get(Long key)
/*    */   {
/* 12 */     return (OfflineExpReward)_Tables_.getInstance().role2offlineexpreward.get(key);
/*    */   }
/*    */   
/*    */   public static OfflineExpReward get(Long key, OfflineExpReward value)
/*    */   {
/* 17 */     return (OfflineExpReward)_Tables_.getInstance().role2offlineexpreward.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, OfflineExpReward value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2offlineexpreward.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2offlineexpreward.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, OfflineExpReward value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2offlineexpreward.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2offlineexpreward.remove(key);
/*    */   }
/*    */   
/*    */   public static TTableCache<Long, OfflineExpReward> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2offlineexpreward.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, OfflineExpReward> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2offlineexpreward;
/*    */   }
/*    */   
/*    */   public static OfflineExpReward select(Long key)
/*    */   {
/* 52 */     (OfflineExpReward)getTable().select(key, new TField()
/*    */     {
/*    */       public OfflineExpReward get(OfflineExpReward v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Long selectDayofflinetime(Long key)
/*    */   {
/* 63 */     (Long)getTable().select(key, new TField()
/*    */     {
/*    */       public Long get(OfflineExpReward v)
/*    */       {
/* 67 */         return Long.valueOf(v.getDayofflinetime());
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2offlineexpreward.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */