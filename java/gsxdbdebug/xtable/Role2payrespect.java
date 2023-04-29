/*    */ package xtable;
/*    */ 
/*    */ import xbean.Role2PayRespectInfo;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ import xdb.TTableCache;
/*    */ 
/*    */ public class Role2payrespect
/*    */ {
/*    */   public static Role2PayRespectInfo get(Long key)
/*    */   {
/* 12 */     return (Role2PayRespectInfo)_Tables_.getInstance().role2payrespect.get(key);
/*    */   }
/*    */   
/*    */   public static Role2PayRespectInfo get(Long key, Role2PayRespectInfo value)
/*    */   {
/* 17 */     return (Role2PayRespectInfo)_Tables_.getInstance().role2payrespect.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, Role2PayRespectInfo value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2payrespect.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2payrespect.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, Role2PayRespectInfo value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2payrespect.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2payrespect.remove(key);
/*    */   }
/*    */   
/*    */   public static TTableCache<Long, Role2PayRespectInfo> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2payrespect.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, Role2PayRespectInfo> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2payrespect;
/*    */   }
/*    */   
/*    */   public static Role2PayRespectInfo select(Long key)
/*    */   {
/* 52 */     (Role2PayRespectInfo)getTable().select(key, new TField()
/*    */     {
/*    */       public Role2PayRespectInfo get(Role2PayRespectInfo v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Boolean selectMaster_is_paying_respect(Long key)
/*    */   {
/* 63 */     (Boolean)getTable().select(key, new TField()
/*    */     {
/*    */       public Boolean get(Role2PayRespectInfo v)
/*    */       {
/* 67 */         return Boolean.valueOf(v.getMaster_is_paying_respect());
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Boolean selectApprentice_is_paying_respect(Long key)
/*    */   {
/* 74 */     (Boolean)getTable().select(key, new TField()
/*    */     {
/*    */       public Boolean get(Role2PayRespectInfo v)
/*    */       {
/* 78 */         return Boolean.valueOf(v.getApprentice_is_paying_respect());
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2payrespect.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */