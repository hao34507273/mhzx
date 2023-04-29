/*    */ package xtable;
/*    */ 
/*    */ import xbean.FightAwardTip;
/*    */ import xdb.TTable;
/*    */ import xdb.TTableCache;
/*    */ 
/*    */ 
/*    */ public class Role2ladderfightawardtip
/*    */ {
/*    */   public static FightAwardTip get(Long key)
/*    */   {
/* 12 */     return (FightAwardTip)_Tables_.getInstance().role2ladderfightawardtip.get(key);
/*    */   }
/*    */   
/*    */   public static FightAwardTip get(Long key, FightAwardTip value)
/*    */   {
/* 17 */     return (FightAwardTip)_Tables_.getInstance().role2ladderfightawardtip.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, FightAwardTip value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2ladderfightawardtip.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2ladderfightawardtip.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, FightAwardTip value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2ladderfightawardtip.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2ladderfightawardtip.remove(key);
/*    */   }
/*    */   
/*    */   public static TTableCache<Long, FightAwardTip> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2ladderfightawardtip.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, FightAwardTip> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2ladderfightawardtip;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2ladderfightawardtip.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */