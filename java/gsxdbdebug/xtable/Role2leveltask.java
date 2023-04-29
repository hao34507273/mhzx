/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.LevelTaskInfo;
/*    */ import xbean.OwnTaskData;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Role2leveltask
/*    */ {
/*    */   public static LevelTaskInfo get(Long key)
/*    */   {
/* 12 */     return (LevelTaskInfo)_Tables_.getInstance().role2leveltask.get(key);
/*    */   }
/*    */   
/*    */   public static LevelTaskInfo get(Long key, LevelTaskInfo value)
/*    */   {
/* 17 */     return (LevelTaskInfo)_Tables_.getInstance().role2leveltask.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, LevelTaskInfo value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2leveltask.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2leveltask.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, LevelTaskInfo value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2leveltask.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2leveltask.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, LevelTaskInfo> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2leveltask.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, LevelTaskInfo> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2leveltask;
/*    */   }
/*    */   
/*    */   public static LevelTaskInfo select(Long key)
/*    */   {
/* 52 */     (LevelTaskInfo)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public LevelTaskInfo get(LevelTaskInfo v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Integer, OwnTaskData> selectLevel2graphids(Long key)
/*    */   {
/* 63 */     (Map)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Map<Integer, OwnTaskData> get(LevelTaskInfo v)
/*    */       {
/* 67 */         return v.getLevel2graphidsAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2leveltask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */