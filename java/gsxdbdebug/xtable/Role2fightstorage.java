/*    */ package xtable;
/*    */ 
/*    */ import xbean.FightStorage;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ import xdb.TTableCache;
/*    */ 
/*    */ public class Role2fightstorage
/*    */ {
/*    */   public static FightStorage get(Long key)
/*    */   {
/* 12 */     return (FightStorage)_Tables_.getInstance().role2fightstorage.get(key);
/*    */   }
/*    */   
/*    */   public static FightStorage get(Long key, FightStorage value)
/*    */   {
/* 17 */     return (FightStorage)_Tables_.getInstance().role2fightstorage.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, FightStorage value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2fightstorage.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2fightstorage.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, FightStorage value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2fightstorage.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2fightstorage.remove(key);
/*    */   }
/*    */   
/*    */   public static TTableCache<Long, FightStorage> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2fightstorage.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, FightStorage> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2fightstorage;
/*    */   }
/*    */   
/*    */   public static FightStorage select(Long key)
/*    */   {
/* 52 */     (FightStorage)getTable().select(key, new TField()
/*    */     {
/*    */       public FightStorage get(FightStorage v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Long selectLastestendtime(Long key)
/*    */   {
/* 63 */     (Long)getTable().select(key, new TField()
/*    */     {
/*    */       public Long get(FightStorage v)
/*    */       {
/* 67 */         return Long.valueOf(v.getLastestendtime());
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2fightstorage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */