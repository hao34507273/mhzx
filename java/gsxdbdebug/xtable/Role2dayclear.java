/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.RoleDayClearCounter;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Role2dayclear
/*    */ {
/*    */   public static RoleDayClearCounter get(Long key)
/*    */   {
/* 12 */     return (RoleDayClearCounter)_Tables_.getInstance().role2dayclear.get(key);
/*    */   }
/*    */   
/*    */   public static RoleDayClearCounter get(Long key, RoleDayClearCounter value)
/*    */   {
/* 17 */     return (RoleDayClearCounter)_Tables_.getInstance().role2dayclear.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, RoleDayClearCounter value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2dayclear.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2dayclear.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, RoleDayClearCounter value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2dayclear.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2dayclear.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, RoleDayClearCounter> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2dayclear.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, RoleDayClearCounter> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2dayclear;
/*    */   }
/*    */   
/*    */   public static RoleDayClearCounter select(Long key)
/*    */   {
/* 52 */     (RoleDayClearCounter)getTable().select(key, new TField()
/*    */     {
/*    */       public RoleDayClearCounter get(RoleDayClearCounter v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Integer, Integer> selectDatamap(Long key)
/*    */   {
/* 63 */     (Map)getTable().select(key, new TField()
/*    */     {
/*    */       public Map<Integer, Integer> get(RoleDayClearCounter v)
/*    */       {
/* 67 */         return v.getDatamapAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Long selectTimestamp(Long key)
/*    */   {
/* 74 */     (Long)getTable().select(key, new TField()
/*    */     {
/*    */       public Long get(RoleDayClearCounter v)
/*    */       {
/* 78 */         return Long.valueOf(v.getTimestamp());
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2dayclear.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */