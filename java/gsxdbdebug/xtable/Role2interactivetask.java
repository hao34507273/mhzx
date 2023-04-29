/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.InteractivetaskInfo;
/*    */ import xbean.InteractivetaskMap;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Role2interactivetask
/*    */ {
/*    */   public static InteractivetaskMap get(Long key)
/*    */   {
/* 12 */     return (InteractivetaskMap)_Tables_.getInstance().role2interactivetask.get(key);
/*    */   }
/*    */   
/*    */   public static InteractivetaskMap get(Long key, InteractivetaskMap value)
/*    */   {
/* 17 */     return (InteractivetaskMap)_Tables_.getInstance().role2interactivetask.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, InteractivetaskMap value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2interactivetask.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2interactivetask.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, InteractivetaskMap value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2interactivetask.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2interactivetask.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, InteractivetaskMap> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2interactivetask.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, InteractivetaskMap> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2interactivetask;
/*    */   }
/*    */   
/*    */   public static InteractivetaskMap select(Long key)
/*    */   {
/* 52 */     (InteractivetaskMap)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public InteractivetaskMap get(InteractivetaskMap v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Integer, InteractivetaskInfo> selectTypeid2task(Long key)
/*    */   {
/* 63 */     (Map)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Map<Integer, InteractivetaskInfo> get(InteractivetaskMap v)
/*    */       {
/* 67 */         return v.getTypeid2taskAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2interactivetask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */