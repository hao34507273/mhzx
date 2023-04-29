/*    */ package xtable;
/*    */ 
/*    */ import xbean.Role2AchievementObserver;
/*    */ import xdb.TTable;
/*    */ import xdb.TTableCache;
/*    */ 
/*    */ 
/*    */ public class Role2achievementobserver
/*    */ {
/*    */   public static Role2AchievementObserver get(Long key)
/*    */   {
/* 12 */     return (Role2AchievementObserver)_Tables_.getInstance().role2achievementobserver.get(key);
/*    */   }
/*    */   
/*    */   public static Role2AchievementObserver get(Long key, Role2AchievementObserver value)
/*    */   {
/* 17 */     return (Role2AchievementObserver)_Tables_.getInstance().role2achievementobserver.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, Role2AchievementObserver value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2achievementobserver.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2achievementobserver.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, Role2AchievementObserver value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2achievementobserver.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2achievementobserver.remove(key);
/*    */   }
/*    */   
/*    */   public static TTableCache<Long, Role2AchievementObserver> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2achievementobserver.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, Role2AchievementObserver> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2achievementobserver;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2achievementobserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */