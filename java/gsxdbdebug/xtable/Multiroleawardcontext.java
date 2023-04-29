/*    */ package xtable;
/*    */ 
/*    */ import xbean.MultiRoleAwardContext;
/*    */ import xdb.TTable;
/*    */ import xdb.TTableCache;
/*    */ 
/*    */ 
/*    */ public class Multiroleawardcontext
/*    */ {
/*    */   public static MultiRoleAwardContext get(Long key)
/*    */   {
/* 12 */     return (MultiRoleAwardContext)_Tables_.getInstance().multiroleawardcontext.get(key);
/*    */   }
/*    */   
/*    */   public static MultiRoleAwardContext get(Long key, MultiRoleAwardContext value)
/*    */   {
/* 17 */     return (MultiRoleAwardContext)_Tables_.getInstance().multiroleawardcontext.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, MultiRoleAwardContext value)
/*    */   {
/* 22 */     _Tables_.getInstance().multiroleawardcontext.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().multiroleawardcontext.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, MultiRoleAwardContext value)
/*    */   {
/* 32 */     return _Tables_.getInstance().multiroleawardcontext.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().multiroleawardcontext.remove(key);
/*    */   }
/*    */   
/*    */   public static TTableCache<Long, MultiRoleAwardContext> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().multiroleawardcontext.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, MultiRoleAwardContext> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().multiroleawardcontext;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Multiroleawardcontext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */