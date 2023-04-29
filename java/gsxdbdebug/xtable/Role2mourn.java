/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.XMTaskInfo;
/*    */ import xbean.XMournInfo;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Role2mourn
/*    */ {
/*    */   public static XMournInfo get(Long key)
/*    */   {
/* 12 */     return (XMournInfo)_Tables_.getInstance().role2mourn.get(key);
/*    */   }
/*    */   
/*    */   public static XMournInfo get(Long key, XMournInfo value)
/*    */   {
/* 17 */     return (XMournInfo)_Tables_.getInstance().role2mourn.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, XMournInfo value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2mourn.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2mourn.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, XMournInfo value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2mourn.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2mourn.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, XMournInfo> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2mourn.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, XMournInfo> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2mourn;
/*    */   }
/*    */   
/*    */   public static XMournInfo select(Long key)
/*    */   {
/* 52 */     (XMournInfo)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public XMournInfo get(XMournInfo v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Integer, XMTaskInfo> selectMourndatas(Long key)
/*    */   {
/* 63 */     (Map)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Map<Integer, XMTaskInfo> get(XMournInfo v)
/*    */       {
/* 67 */         return v.getMourndatasAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static XMTaskInfo selectLastmourndata(Long key)
/*    */   {
/* 74 */     (XMTaskInfo)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public XMTaskInfo get(XMournInfo v)
/*    */       {
/* 78 */         return v.getLastmourndata().toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static java.util.List<Integer> selectSort(Long key)
/*    */   {
/* 85 */     (java.util.List)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public java.util.List<Integer> get(XMournInfo v)
/*    */       {
/* 89 */         return v.getSortAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2mourn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */