/*    */ package xtable;
/*    */ 
/*    */ import xbean.GMStatus;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ import xdb.TTableCache;
/*    */ 
/*    */ public class Gmstatus
/*    */ {
/*    */   public static GMStatus get(Long key)
/*    */   {
/* 12 */     return (GMStatus)_Tables_.getInstance().gmstatus.get(key);
/*    */   }
/*    */   
/*    */   public static GMStatus get(Long key, GMStatus value)
/*    */   {
/* 17 */     return (GMStatus)_Tables_.getInstance().gmstatus.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, GMStatus value)
/*    */   {
/* 22 */     _Tables_.getInstance().gmstatus.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().gmstatus.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, GMStatus value)
/*    */   {
/* 32 */     return _Tables_.getInstance().gmstatus.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().gmstatus.remove(key);
/*    */   }
/*    */   
/*    */   public static TTableCache<Long, GMStatus> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().gmstatus.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, GMStatus> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().gmstatus;
/*    */   }
/*    */   
/*    */   public static GMStatus select(Long key)
/*    */   {
/* 52 */     (GMStatus)getTable().select(key, new TField()
/*    */     {
/*    */       public GMStatus get(GMStatus v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Integer selectStatus(Long key)
/*    */   {
/* 63 */     (Integer)getTable().select(key, new TField()
/*    */     {
/*    */       public Integer get(GMStatus v)
/*    */       {
/* 67 */         return Integer.valueOf(v.getStatus());
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Gmstatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */