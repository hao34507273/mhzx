/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.AllActivityInfo;
/*    */ import xbean.SingleActivityInfo;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Role2singleinfo
/*    */ {
/*    */   public static AllActivityInfo get(Long key)
/*    */   {
/* 12 */     return (AllActivityInfo)_Tables_.getInstance().role2singleinfo.get(key);
/*    */   }
/*    */   
/*    */   public static AllActivityInfo get(Long key, AllActivityInfo value)
/*    */   {
/* 17 */     return (AllActivityInfo)_Tables_.getInstance().role2singleinfo.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, AllActivityInfo value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2singleinfo.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2singleinfo.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, AllActivityInfo value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2singleinfo.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2singleinfo.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, AllActivityInfo> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2singleinfo.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, AllActivityInfo> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2singleinfo;
/*    */   }
/*    */   
/*    */   public static AllActivityInfo select(Long key)
/*    */   {
/* 52 */     (AllActivityInfo)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public AllActivityInfo get(AllActivityInfo v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Integer, SingleActivityInfo> selectActivitydata(Long key)
/*    */   {
/* 63 */     (Map)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Map<Integer, SingleActivityInfo> get(AllActivityInfo v)
/*    */       {
/* 67 */         return v.getActivitydataAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2singleinfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */