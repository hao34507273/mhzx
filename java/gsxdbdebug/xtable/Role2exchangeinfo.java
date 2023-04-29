/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.ExchangeActivityInfo;
/*    */ import xbean.ExchangeInfo;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Role2exchangeinfo
/*    */ {
/*    */   public static ExchangeInfo get(Long key)
/*    */   {
/* 12 */     return (ExchangeInfo)_Tables_.getInstance().role2exchangeinfo.get(key);
/*    */   }
/*    */   
/*    */   public static ExchangeInfo get(Long key, ExchangeInfo value)
/*    */   {
/* 17 */     return (ExchangeInfo)_Tables_.getInstance().role2exchangeinfo.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, ExchangeInfo value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2exchangeinfo.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2exchangeinfo.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, ExchangeInfo value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2exchangeinfo.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2exchangeinfo.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, ExchangeInfo> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2exchangeinfo.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, ExchangeInfo> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2exchangeinfo;
/*    */   }
/*    */   
/*    */   public static ExchangeInfo select(Long key)
/*    */   {
/* 52 */     (ExchangeInfo)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public ExchangeInfo get(ExchangeInfo v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Integer, ExchangeActivityInfo> selectExchange_activity_infos(Long key)
/*    */   {
/* 63 */     (Map)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Map<Integer, ExchangeActivityInfo> get(ExchangeInfo v)
/*    */       {
/* 67 */         return v.getExchange_activity_infosAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2exchangeinfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */