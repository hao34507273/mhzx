/*    */ package xtable;
/*    */ 
/*    */ import xbean.SeasonMultiTaskInfo;
/*    */ import xbean.SeasonSingleTaskInfo;
/*    */ import xbean.SeasonTaskInfo;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Role2seasontaskinfo
/*    */ {
/*    */   public static SeasonTaskInfo get(Long key)
/*    */   {
/* 12 */     return (SeasonTaskInfo)_Tables_.getInstance().role2seasontaskinfo.get(key);
/*    */   }
/*    */   
/*    */   public static SeasonTaskInfo get(Long key, SeasonTaskInfo value)
/*    */   {
/* 17 */     return (SeasonTaskInfo)_Tables_.getInstance().role2seasontaskinfo.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, SeasonTaskInfo value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2seasontaskinfo.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2seasontaskinfo.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, SeasonTaskInfo value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2seasontaskinfo.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2seasontaskinfo.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, SeasonTaskInfo> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2seasontaskinfo.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, SeasonTaskInfo> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2seasontaskinfo;
/*    */   }
/*    */   
/*    */   public static SeasonTaskInfo select(Long key)
/*    */   {
/* 52 */     (SeasonTaskInfo)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public SeasonTaskInfo get(SeasonTaskInfo v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static SeasonSingleTaskInfo selectSingleinfo(Long key)
/*    */   {
/* 63 */     (SeasonSingleTaskInfo)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public SeasonSingleTaskInfo get(SeasonTaskInfo v)
/*    */       {
/* 67 */         return v.getSingleinfo().toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static SeasonMultiTaskInfo selectMultiinfo(Long key)
/*    */   {
/* 74 */     (SeasonMultiTaskInfo)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public SeasonMultiTaskInfo get(SeasonTaskInfo v)
/*    */       {
/* 78 */         return v.getMultiinfo().toData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2seasontaskinfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */