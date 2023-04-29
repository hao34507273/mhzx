/*    */ package xtable;
/*    */ 
/*    */ import java.util.List;
/*    */ import xbean.MarketLog;
/*    */ import xbean.SaleLog;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Role2marketlog
/*    */ {
/*    */   public static MarketLog get(Long key)
/*    */   {
/* 12 */     return (MarketLog)_Tables_.getInstance().role2marketlog.get(key);
/*    */   }
/*    */   
/*    */   public static MarketLog get(Long key, MarketLog value)
/*    */   {
/* 17 */     return (MarketLog)_Tables_.getInstance().role2marketlog.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, MarketLog value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2marketlog.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2marketlog.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, MarketLog value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2marketlog.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2marketlog.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, MarketLog> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2marketlog.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, MarketLog> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2marketlog;
/*    */   }
/*    */   
/*    */   public static MarketLog select(Long key)
/*    */   {
/* 52 */     (MarketLog)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public MarketLog get(MarketLog v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static List<SaleLog> selectSelllog(Long key)
/*    */   {
/* 63 */     (List)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public List<SaleLog> get(MarketLog v)
/*    */       {
/* 67 */         return v.getSelllogAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static List<SaleLog> selectBuylog(Long key)
/*    */   {
/* 74 */     (List)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public List<SaleLog> get(MarketLog v)
/*    */       {
/* 78 */         return v.getBuylogAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2marketlog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */