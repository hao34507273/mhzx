/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.DropInfo;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Role2drop
/*    */ {
/*    */   public static DropInfo get(Long key)
/*    */   {
/* 12 */     return (DropInfo)_Tables_.getInstance().role2drop.get(key);
/*    */   }
/*    */   
/*    */   public static DropInfo get(Long key, DropInfo value)
/*    */   {
/* 17 */     return (DropInfo)_Tables_.getInstance().role2drop.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, DropInfo value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2drop.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2drop.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, DropInfo value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2drop.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2drop.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, DropInfo> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2drop.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, DropInfo> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2drop;
/*    */   }
/*    */   
/*    */   public static DropInfo select(Long key)
/*    */   {
/* 52 */     (DropInfo)getTable().select(key, new TField()
/*    */     {
/*    */       public DropInfo get(DropInfo v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Integer, Integer> selectDropcounts(Long key)
/*    */   {
/* 63 */     (Map)getTable().select(key, new TField()
/*    */     {
/*    */       public Map<Integer, Integer> get(DropInfo v)
/*    */       {
/* 67 */         return v.getDropcountsAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Long selectStarttime(Long key)
/*    */   {
/* 74 */     (Long)getTable().select(key, new TField()
/*    */     {
/*    */       public Long get(DropInfo v)
/*    */       {
/* 78 */         return Long.valueOf(v.getStarttime());
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2drop.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */