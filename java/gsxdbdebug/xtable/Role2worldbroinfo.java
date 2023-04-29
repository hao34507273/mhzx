/*    */ package xtable;
/*    */ 
/*    */ import xbean.WorldBroInfo;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ import xdb.TTableCache;
/*    */ 
/*    */ public class Role2worldbroinfo
/*    */ {
/*    */   public static WorldBroInfo get(Long key)
/*    */   {
/* 12 */     return (WorldBroInfo)_Tables_.getInstance().role2worldbroinfo.get(key);
/*    */   }
/*    */   
/*    */   public static WorldBroInfo get(Long key, WorldBroInfo value)
/*    */   {
/* 17 */     return (WorldBroInfo)_Tables_.getInstance().role2worldbroinfo.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, WorldBroInfo value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2worldbroinfo.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2worldbroinfo.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, WorldBroInfo value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2worldbroinfo.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2worldbroinfo.remove(key);
/*    */   }
/*    */   
/*    */   public static TTableCache<Long, WorldBroInfo> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2worldbroinfo.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, WorldBroInfo> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2worldbroinfo;
/*    */   }
/*    */   
/*    */   public static WorldBroInfo select(Long key)
/*    */   {
/* 52 */     (WorldBroInfo)getTable().select(key, new TField()
/*    */     {
/*    */       public WorldBroInfo get(WorldBroInfo v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Long selectLastbrotime(Long key)
/*    */   {
/* 63 */     (Long)getTable().select(key, new TField()
/*    */     {
/*    */       public Long get(WorldBroInfo v)
/*    */       {
/* 67 */         return Long.valueOf(v.getLastbrotime());
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2worldbroinfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */