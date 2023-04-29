/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.MoneyDayData;
/*    */ import xbean.SingleMoneyDayData;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Role2daymoneyinfo
/*    */ {
/*    */   public static MoneyDayData get(Long key)
/*    */   {
/* 12 */     return (MoneyDayData)_Tables_.getInstance().role2daymoneyinfo.get(key);
/*    */   }
/*    */   
/*    */   public static MoneyDayData get(Long key, MoneyDayData value)
/*    */   {
/* 17 */     return (MoneyDayData)_Tables_.getInstance().role2daymoneyinfo.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, MoneyDayData value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2daymoneyinfo.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2daymoneyinfo.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, MoneyDayData value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2daymoneyinfo.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2daymoneyinfo.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, MoneyDayData> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2daymoneyinfo.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, MoneyDayData> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2daymoneyinfo;
/*    */   }
/*    */   
/*    */   public static MoneyDayData select(Long key)
/*    */   {
/* 52 */     (MoneyDayData)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public MoneyDayData get(MoneyDayData v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Long selectStarttime(Long key)
/*    */   {
/* 63 */     (Long)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Long get(MoneyDayData v)
/*    */       {
/* 67 */         return Long.valueOf(v.getStarttime());
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Integer, SingleMoneyDayData> selectMoneyinfo(Long key)
/*    */   {
/* 74 */     (Map)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Map<Integer, SingleMoneyDayData> get(MoneyDayData v)
/*    */       {
/* 78 */         return v.getMoneyinfoAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2daymoneyinfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */