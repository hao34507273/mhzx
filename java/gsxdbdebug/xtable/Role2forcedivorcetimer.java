/*    */ package xtable;
/*    */ 
/*    */ import xbean.ForcedDivorceTimer;
/*    */ import xdb.TTable;
/*    */ import xdb.TTableCache;
/*    */ 
/*    */ 
/*    */ public class Role2forcedivorcetimer
/*    */ {
/*    */   public static ForcedDivorceTimer get(Long key)
/*    */   {
/* 12 */     return (ForcedDivorceTimer)_Tables_.getInstance().role2forcedivorcetimer.get(key);
/*    */   }
/*    */   
/*    */   public static ForcedDivorceTimer get(Long key, ForcedDivorceTimer value)
/*    */   {
/* 17 */     return (ForcedDivorceTimer)_Tables_.getInstance().role2forcedivorcetimer.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, ForcedDivorceTimer value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2forcedivorcetimer.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2forcedivorcetimer.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, ForcedDivorceTimer value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2forcedivorcetimer.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2forcedivorcetimer.remove(key);
/*    */   }
/*    */   
/*    */   public static TTableCache<Long, ForcedDivorceTimer> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2forcedivorcetimer.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, ForcedDivorceTimer> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2forcedivorcetimer;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2forcedivorcetimer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */