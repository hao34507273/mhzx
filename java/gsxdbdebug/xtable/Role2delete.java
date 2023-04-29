/*    */ package xtable;
/*    */ 
/*    */ import xbean.DeleteState;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ import xdb.TTableCache;
/*    */ 
/*    */ public class Role2delete
/*    */ {
/*    */   public static DeleteState get(Long key)
/*    */   {
/* 12 */     return (DeleteState)_Tables_.getInstance().role2delete.get(key);
/*    */   }
/*    */   
/*    */   public static DeleteState get(Long key, DeleteState value)
/*    */   {
/* 17 */     return (DeleteState)_Tables_.getInstance().role2delete.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, DeleteState value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2delete.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2delete.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, DeleteState value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2delete.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2delete.remove(key);
/*    */   }
/*    */   
/*    */   public static TTableCache<Long, DeleteState> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2delete.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, DeleteState> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2delete;
/*    */   }
/*    */   
/*    */   public static DeleteState select(Long key)
/*    */   {
/* 52 */     (DeleteState)getTable().select(key, new TField()
/*    */     {
/*    */       public DeleteState get(DeleteState v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Integer selectDeletestate(Long key)
/*    */   {
/* 63 */     (Integer)getTable().select(key, new TField()
/*    */     {
/*    */       public Integer get(DeleteState v)
/*    */       {
/* 67 */         return Integer.valueOf(v.getDeletestate());
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Long selectDeleteendtime(Long key)
/*    */   {
/* 74 */     (Long)getTable().select(key, new TField()
/*    */     {
/*    */       public Long get(DeleteState v)
/*    */       {
/* 78 */         return Long.valueOf(v.getDeleteendtime());
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2delete.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */