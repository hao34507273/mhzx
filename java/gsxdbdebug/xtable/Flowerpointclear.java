/*    */ package xtable;
/*    */ 
/*    */ import xbean.FlowerPointClear;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ import xdb.TTableCache;
/*    */ 
/*    */ public class Flowerpointclear
/*    */ {
/*    */   public static FlowerPointClear get(Long key)
/*    */   {
/* 12 */     return (FlowerPointClear)_Tables_.getInstance().flowerpointclear.get(key);
/*    */   }
/*    */   
/*    */   public static FlowerPointClear get(Long key, FlowerPointClear value)
/*    */   {
/* 17 */     return (FlowerPointClear)_Tables_.getInstance().flowerpointclear.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, FlowerPointClear value)
/*    */   {
/* 22 */     _Tables_.getInstance().flowerpointclear.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().flowerpointclear.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, FlowerPointClear value)
/*    */   {
/* 32 */     return _Tables_.getInstance().flowerpointclear.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().flowerpointclear.remove(key);
/*    */   }
/*    */   
/*    */   public static TTableCache<Long, FlowerPointClear> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().flowerpointclear.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, FlowerPointClear> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().flowerpointclear;
/*    */   }
/*    */   
/*    */   public static FlowerPointClear select(Long key)
/*    */   {
/* 52 */     (FlowerPointClear)getTable().select(key, new TField()
/*    */     {
/*    */       public FlowerPointClear get(FlowerPointClear v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Long selectFlowerrefreshtime(Long key)
/*    */   {
/* 63 */     (Long)getTable().select(key, new TField()
/*    */     {
/*    */       public Long get(FlowerPointClear v)
/*    */       {
/* 67 */         return Long.valueOf(v.getFlowerrefreshtime());
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Flowerpointclear.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */