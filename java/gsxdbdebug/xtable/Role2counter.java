/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.RoleCounterInfo;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Role2counter
/*    */ {
/*    */   public static RoleCounterInfo get(Long key)
/*    */   {
/* 12 */     return (RoleCounterInfo)_Tables_.getInstance().role2counter.get(key);
/*    */   }
/*    */   
/*    */   public static RoleCounterInfo get(Long key, RoleCounterInfo value)
/*    */   {
/* 17 */     return (RoleCounterInfo)_Tables_.getInstance().role2counter.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, RoleCounterInfo value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2counter.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2counter.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, RoleCounterInfo value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2counter.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2counter.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, RoleCounterInfo> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2counter.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, RoleCounterInfo> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2counter;
/*    */   }
/*    */   
/*    */   public static RoleCounterInfo select(Long key)
/*    */   {
/* 52 */     (RoleCounterInfo)getTable().select(key, new TField()
/*    */     {
/*    */       public RoleCounterInfo get(RoleCounterInfo v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Integer, Integer> selectCounter_info(Long key)
/*    */   {
/* 63 */     (Map)getTable().select(key, new TField()
/*    */     {
/*    */       public Map<Integer, Integer> get(RoleCounterInfo v)
/*    */       {
/* 67 */         return v.getCounter_infoAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2counter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */