/*    */ package xtable;
/*    */ 
/*    */ import xbean.RoleSingleCrossFieldResult;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ import xdb.TTableCache;
/*    */ 
/*    */ public class Role_single_cross_field_results
/*    */ {
/*    */   public static RoleSingleCrossFieldResult get(Long key)
/*    */   {
/* 12 */     return (RoleSingleCrossFieldResult)_Tables_.getInstance().role_single_cross_field_results.get(key);
/*    */   }
/*    */   
/*    */   public static RoleSingleCrossFieldResult get(Long key, RoleSingleCrossFieldResult value)
/*    */   {
/* 17 */     return (RoleSingleCrossFieldResult)_Tables_.getInstance().role_single_cross_field_results.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, RoleSingleCrossFieldResult value)
/*    */   {
/* 22 */     _Tables_.getInstance().role_single_cross_field_results.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role_single_cross_field_results.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, RoleSingleCrossFieldResult value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role_single_cross_field_results.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role_single_cross_field_results.remove(key);
/*    */   }
/*    */   
/*    */   public static TTableCache<Long, RoleSingleCrossFieldResult> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role_single_cross_field_results.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, RoleSingleCrossFieldResult> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role_single_cross_field_results;
/*    */   }
/*    */   
/*    */   public static Long selectSession_id(Long key)
/*    */   {
/* 52 */     (Long)getTable().select(key, new TField()
/*    */     {
/*    */       public Long get(RoleSingleCrossFieldResult v)
/*    */       {
/* 56 */         return Long.valueOf(v.getSession_id());
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role_single_cross_field_results.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */