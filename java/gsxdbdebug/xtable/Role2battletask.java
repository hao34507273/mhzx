/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.BattleTaskData;
/*    */ import xbean.RoleBattleTaskData;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Role2battletask
/*    */ {
/*    */   public static RoleBattleTaskData get(Long key)
/*    */   {
/* 12 */     return (RoleBattleTaskData)_Tables_.getInstance().role2battletask.get(key);
/*    */   }
/*    */   
/*    */   public static RoleBattleTaskData get(Long key, RoleBattleTaskData value)
/*    */   {
/* 17 */     return (RoleBattleTaskData)_Tables_.getInstance().role2battletask.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, RoleBattleTaskData value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2battletask.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2battletask.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, RoleBattleTaskData value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2battletask.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2battletask.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, RoleBattleTaskData> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2battletask.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, RoleBattleTaskData> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2battletask;
/*    */   }
/*    */   
/*    */   public static RoleBattleTaskData select(Long key)
/*    */   {
/* 52 */     (RoleBattleTaskData)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public RoleBattleTaskData get(RoleBattleTaskData v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Integer, BattleTaskData> selectTaskdatas(Long key)
/*    */   {
/* 63 */     (Map)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Map<Integer, BattleTaskData> get(RoleBattleTaskData v)
/*    */       {
/* 67 */         return v.getTaskdatasAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Integer selectPoint(Long key)
/*    */   {
/* 74 */     (Integer)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Integer get(RoleBattleTaskData v)
/*    */       {
/* 78 */         return Integer.valueOf(v.getPoint());
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2battletask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */