/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.RoleWorshipInfo;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Role2worship
/*    */ {
/*    */   public static RoleWorshipInfo get(Long key)
/*    */   {
/* 12 */     return (RoleWorshipInfo)_Tables_.getInstance().role2worship.get(key);
/*    */   }
/*    */   
/*    */   public static RoleWorshipInfo get(Long key, RoleWorshipInfo value)
/*    */   {
/* 17 */     return (RoleWorshipInfo)_Tables_.getInstance().role2worship.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, RoleWorshipInfo value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2worship.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2worship.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, RoleWorshipInfo value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2worship.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2worship.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, RoleWorshipInfo> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2worship.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, RoleWorshipInfo> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2worship;
/*    */   }
/*    */   
/*    */   public static RoleWorshipInfo select(Long key)
/*    */   {
/* 52 */     (RoleWorshipInfo)getTable().select(key, new TField()
/*    */     {
/*    */       public RoleWorshipInfo get(RoleWorshipInfo v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Integer selectWorshipid(Long key)
/*    */   {
/* 63 */     (Integer)getTable().select(key, new TField()
/*    */     {
/*    */       public Integer get(RoleWorshipInfo v)
/*    */       {
/* 67 */         return Integer.valueOf(v.getWorshipid());
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Long, Integer> selectLastcycledata(Long key)
/*    */   {
/* 74 */     (Map)getTable().select(key, new TField()
/*    */     {
/*    */       public Map<Long, Integer> get(RoleWorshipInfo v)
/*    */       {
/* 78 */         return v.getLastcycledataAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Long, Integer> selectThiscycledata(Long key)
/*    */   {
/* 85 */     (Map)getTable().select(key, new TField()
/*    */     {
/*    */       public Map<Long, Integer> get(RoleWorshipInfo v)
/*    */       {
/* 89 */         return v.getThiscycledataAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Long selectCurfactionid(Long key)
/*    */   {
/* 96 */     (Long)getTable().select(key, new TField()
/*    */     {
/*    */       public Long get(RoleWorshipInfo v)
/*    */       {
/* :0 */         return Long.valueOf(v.getCurfactionid());
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2worship.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */