/*    */ package xtable;
/*    */ 
/*    */ import xbean.StorageExp;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ import xdb.TTableCache;
/*    */ 
/*    */ public class Role2storageexp
/*    */ {
/*    */   public static StorageExp get(Long key)
/*    */   {
/* 12 */     return (StorageExp)_Tables_.getInstance().role2storageexp.get(key);
/*    */   }
/*    */   
/*    */   public static StorageExp get(Long key, StorageExp value)
/*    */   {
/* 17 */     return (StorageExp)_Tables_.getInstance().role2storageexp.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, StorageExp value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2storageexp.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2storageexp.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, StorageExp value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2storageexp.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2storageexp.remove(key);
/*    */   }
/*    */   
/*    */   public static TTableCache<Long, StorageExp> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2storageexp.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, StorageExp> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2storageexp;
/*    */   }
/*    */   
/*    */   public static StorageExp select(Long key)
/*    */   {
/* 52 */     (StorageExp)getTable().select(key, new TField()
/*    */     {
/*    */       public StorageExp get(StorageExp v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Long selectStorageexp(Long key)
/*    */   {
/* 63 */     (Long)getTable().select(key, new TField()
/*    */     {
/*    */       public Long get(StorageExp v)
/*    */       {
/* 67 */         return Long.valueOf(v.getStorageexp());
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Long selectNeedupdatestorageexp(Long key)
/*    */   {
/* 74 */     (Long)getTable().select(key, new TField()
/*    */     {
/*    */       public Long get(StorageExp v)
/*    */       {
/* 78 */         return Long.valueOf(v.getNeedupdatestorageexp());
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Long selectLastupdate(Long key)
/*    */   {
/* 85 */     (Long)getTable().select(key, new TField()
/*    */     {
/*    */       public Long get(StorageExp v)
/*    */       {
/* 89 */         return Long.valueOf(v.getLastupdate());
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2storageexp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */