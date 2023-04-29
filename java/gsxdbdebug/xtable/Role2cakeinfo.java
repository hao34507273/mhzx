/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.CakeData;
/*    */ import xbean.CakeInfo;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Role2cakeinfo
/*    */ {
/*    */   public static CakeInfo get(Long key)
/*    */   {
/* 12 */     return (CakeInfo)_Tables_.getInstance().role2cakeinfo.get(key);
/*    */   }
/*    */   
/*    */   public static CakeInfo get(Long key, CakeInfo value)
/*    */   {
/* 17 */     return (CakeInfo)_Tables_.getInstance().role2cakeinfo.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, CakeInfo value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2cakeinfo.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2cakeinfo.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, CakeInfo value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2cakeinfo.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2cakeinfo.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, CakeInfo> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2cakeinfo.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, CakeInfo> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2cakeinfo;
/*    */   }
/*    */   
/*    */   public static CakeInfo select(Long key)
/*    */   {
/* 52 */     (CakeInfo)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public CakeInfo get(CakeInfo v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Integer, CakeData> selectCakedatas(Long key)
/*    */   {
/* 63 */     (Map)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Map<Integer, CakeData> get(CakeInfo v)
/*    */       {
/* 67 */         return v.getCakedatasAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2cakeinfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */