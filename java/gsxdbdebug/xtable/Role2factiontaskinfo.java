/*    */ package xtable;
/*    */ 
/*    */ import xbean.FTaskInfo;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ import xdb.TTableCache;
/*    */ 
/*    */ public class Role2factiontaskinfo
/*    */ {
/*    */   public static FTaskInfo get(Long key)
/*    */   {
/* 12 */     return (FTaskInfo)_Tables_.getInstance().role2factiontaskinfo.get(key);
/*    */   }
/*    */   
/*    */   public static FTaskInfo get(Long key, FTaskInfo value)
/*    */   {
/* 17 */     return (FTaskInfo)_Tables_.getInstance().role2factiontaskinfo.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, FTaskInfo value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2factiontaskinfo.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2factiontaskinfo.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, FTaskInfo value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2factiontaskinfo.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2factiontaskinfo.remove(key);
/*    */   }
/*    */   
/*    */   public static TTableCache<Long, FTaskInfo> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2factiontaskinfo.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, FTaskInfo> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2factiontaskinfo;
/*    */   }
/*    */   
/*    */   public static FTaskInfo select(Long key)
/*    */   {
/* 52 */     (FTaskInfo)getTable().select(key, new TField()
/*    */     {
/*    */       public FTaskInfo get(FTaskInfo v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Boolean selectIsperfect(Long key)
/*    */   {
/* 63 */     (Boolean)getTable().select(key, new TField()
/*    */     {
/*    */       public Boolean get(FTaskInfo v)
/*    */       {
/* 67 */         return Boolean.valueOf(v.getIsperfect());
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2factiontaskinfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */