/*    */ package xtable;
/*    */ 
/*    */ import xbean.MallRefreshTime;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ import xdb.TTableCache;
/*    */ 
/*    */ public class Malltype2refreshtime
/*    */ {
/*    */   public static MallRefreshTime get(Long key)
/*    */   {
/* 12 */     return (MallRefreshTime)_Tables_.getInstance().malltype2refreshtime.get(key);
/*    */   }
/*    */   
/*    */   public static MallRefreshTime get(Long key, MallRefreshTime value)
/*    */   {
/* 17 */     return (MallRefreshTime)_Tables_.getInstance().malltype2refreshtime.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, MallRefreshTime value)
/*    */   {
/* 22 */     _Tables_.getInstance().malltype2refreshtime.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().malltype2refreshtime.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, MallRefreshTime value)
/*    */   {
/* 32 */     return _Tables_.getInstance().malltype2refreshtime.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().malltype2refreshtime.remove(key);
/*    */   }
/*    */   
/*    */   public static TTableCache<Long, MallRefreshTime> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().malltype2refreshtime.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, MallRefreshTime> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().malltype2refreshtime;
/*    */   }
/*    */   
/*    */   public static MallRefreshTime select(Long key)
/*    */   {
/* 52 */     (MallRefreshTime)getTable().select(key, new TField()
/*    */     {
/*    */       public MallRefreshTime get(MallRefreshTime v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Long selectRefreshtime(Long key)
/*    */   {
/* 63 */     (Long)getTable().select(key, new TField()
/*    */     {
/*    */       public Long get(MallRefreshTime v)
/*    */       {
/* 67 */         return Long.valueOf(v.getRefreshtime());
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Malltype2refreshtime.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */