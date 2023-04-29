/*    */ package xtable;
/*    */ 
/*    */ import xbean.BoxAwardContext;
/*    */ import xdb.TTable;
/*    */ import xdb.TTableCache;
/*    */ 
/*    */ 
/*    */ public class Boxawardcontext
/*    */ {
/*    */   public static BoxAwardContext get(Long key)
/*    */   {
/* 12 */     return (BoxAwardContext)_Tables_.getInstance().boxawardcontext.get(key);
/*    */   }
/*    */   
/*    */   public static BoxAwardContext get(Long key, BoxAwardContext value)
/*    */   {
/* 17 */     return (BoxAwardContext)_Tables_.getInstance().boxawardcontext.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, BoxAwardContext value)
/*    */   {
/* 22 */     _Tables_.getInstance().boxawardcontext.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().boxawardcontext.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, BoxAwardContext value)
/*    */   {
/* 32 */     return _Tables_.getInstance().boxawardcontext.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().boxawardcontext.remove(key);
/*    */   }
/*    */   
/*    */   public static TTableCache<Long, BoxAwardContext> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().boxawardcontext.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, BoxAwardContext> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().boxawardcontext;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Boxawardcontext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */