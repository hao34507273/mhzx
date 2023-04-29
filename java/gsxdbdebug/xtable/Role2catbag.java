/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.CatBag;
/*    */ import xbean.FeedInfo;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Role2catbag
/*    */ {
/*    */   public static CatBag get(Long key)
/*    */   {
/* 12 */     return (CatBag)_Tables_.getInstance().role2catbag.get(key);
/*    */   }
/*    */   
/*    */   public static CatBag get(Long key, CatBag value)
/*    */   {
/* 17 */     return (CatBag)_Tables_.getInstance().role2catbag.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, CatBag value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2catbag.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2catbag.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, CatBag value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2catbag.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2catbag.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, CatBag> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2catbag.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, CatBag> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2catbag;
/*    */   }
/*    */   
/*    */   public static CatBag select(Long key)
/*    */   {
/* 52 */     (CatBag)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public CatBag get(CatBag v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Long, xbean.CatInfo> selectCats(Long key)
/*    */   {
/* 63 */     (Map)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Map<Long, xbean.CatInfo> get(CatBag v)
/*    */       {
/* 67 */         return v.getCatsAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Long, xbean.Item> selectItems(Long key)
/*    */   {
/* 74 */     (Map)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Map<Long, xbean.Item> get(CatBag v)
/*    */       {
/* 78 */         return v.getItemsAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static FeedInfo selectFeed_info(Long key)
/*    */   {
/* 85 */     (FeedInfo)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public FeedInfo get(CatBag v)
/*    */       {
/* 89 */         return v.getFeed_info().toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Integer, Integer> selectAward_info(Long key)
/*    */   {
/* 96 */     (Map)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Map<Integer, Integer> get(CatBag v)
/*    */       {
/* :0 */         return v.getAward_infoAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2catbag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */