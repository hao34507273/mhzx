/*    */ package xtable;
/*    */ 
/*    */ import xbean.DoubleTime;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ import xdb.TTableCache;
/*    */ 
/*    */ public class Doubletime
/*    */ {
/*    */   public static DoubleTime get(Long key)
/*    */   {
/* 12 */     return (DoubleTime)_Tables_.getInstance().doubletime.get(key);
/*    */   }
/*    */   
/*    */   public static DoubleTime get(Long key, DoubleTime value)
/*    */   {
/* 17 */     return (DoubleTime)_Tables_.getInstance().doubletime.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, DoubleTime value)
/*    */   {
/* 22 */     _Tables_.getInstance().doubletime.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().doubletime.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, DoubleTime value)
/*    */   {
/* 32 */     return _Tables_.getInstance().doubletime.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().doubletime.remove(key);
/*    */   }
/*    */   
/*    */   public static TTableCache<Long, DoubleTime> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().doubletime.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, DoubleTime> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().doubletime;
/*    */   }
/*    */   
/*    */   public static DoubleTime select(Long key)
/*    */   {
/* 52 */     (DoubleTime)getTable().select(key, new TField()
/*    */     {
/*    */       public DoubleTime get(DoubleTime v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Long selectPointoffertime(Long key)
/*    */   {
/* 63 */     (Long)getTable().select(key, new TField()
/*    */     {
/*    */       public Long get(DoubleTime v)
/*    */       {
/* 67 */         return Long.valueOf(v.getPointoffertime());
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Long selectItemcountcleartime(Long key)
/*    */   {
/* 74 */     (Long)getTable().select(key, new TField()
/*    */     {
/*    */       public Long get(DoubleTime v)
/*    */       {
/* 78 */         return Long.valueOf(v.getItemcountcleartime());
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Doubletime.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */