/*    */ package xtable;
/*    */ 
/*    */ import xbean.OnlineRoleInfo;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ import xdb.TTableCache;
/*    */ 
/*    */ public class Onlineroleinfo
/*    */ {
/*    */   public static OnlineRoleInfo get(Long key)
/*    */   {
/* 12 */     return (OnlineRoleInfo)_Tables_.getInstance().onlineroleinfo.get(key);
/*    */   }
/*    */   
/*    */   public static OnlineRoleInfo get(Long key, OnlineRoleInfo value)
/*    */   {
/* 17 */     return (OnlineRoleInfo)_Tables_.getInstance().onlineroleinfo.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, OnlineRoleInfo value)
/*    */   {
/* 22 */     _Tables_.getInstance().onlineroleinfo.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().onlineroleinfo.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, OnlineRoleInfo value)
/*    */   {
/* 32 */     return _Tables_.getInstance().onlineroleinfo.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().onlineroleinfo.remove(key);
/*    */   }
/*    */   
/*    */   public static TTableCache<Long, OnlineRoleInfo> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().onlineroleinfo.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, OnlineRoleInfo> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().onlineroleinfo;
/*    */   }
/*    */   
/*    */   public static OnlineRoleInfo select(Long key)
/*    */   {
/* 52 */     (OnlineRoleInfo)getTable().select(key, new TField()
/*    */     {
/*    */       public OnlineRoleInfo get(OnlineRoleInfo v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Integer selectOnlinestatus(Long key)
/*    */   {
/* 63 */     (Integer)getTable().select(key, new TField()
/*    */     {
/*    */       public Integer get(OnlineRoleInfo v)
/*    */       {
/* 67 */         return Integer.valueOf(v.getOnlinestatus());
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Long selectOfflineprotectsessionid(Long key)
/*    */   {
/* 74 */     (Long)getTable().select(key, new TField()
/*    */     {
/*    */       public Long get(OnlineRoleInfo v)
/*    */       {
/* 78 */         return Long.valueOf(v.getOfflineprotectsessionid());
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Onlineroleinfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */