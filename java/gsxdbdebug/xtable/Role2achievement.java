/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.ActivityAchievementInfo;
/*    */ import xbean.Role2AchievementInfo;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Role2achievement
/*    */ {
/*    */   public static Role2AchievementInfo get(Long key)
/*    */   {
/* 12 */     return (Role2AchievementInfo)_Tables_.getInstance().role2achievement.get(key);
/*    */   }
/*    */   
/*    */   public static Role2AchievementInfo get(Long key, Role2AchievementInfo value)
/*    */   {
/* 17 */     return (Role2AchievementInfo)_Tables_.getInstance().role2achievement.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, Role2AchievementInfo value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2achievement.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2achievement.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, Role2AchievementInfo value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2achievement.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2achievement.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, Role2AchievementInfo> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2achievement.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, Role2AchievementInfo> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2achievement;
/*    */   }
/*    */   
/*    */   public static Role2AchievementInfo select(Long key)
/*    */   {
/* 52 */     (Role2AchievementInfo)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Role2AchievementInfo get(Role2AchievementInfo v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Integer, ActivityAchievementInfo> selectActivity_achievement_info(Long key)
/*    */   {
/* 63 */     (Map)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Map<Integer, ActivityAchievementInfo> get(Role2AchievementInfo v)
/*    */       {
/* 67 */         return v.getActivity_achievement_infoAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2achievement.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */