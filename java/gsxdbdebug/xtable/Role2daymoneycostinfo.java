/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.EachMoneyDayCostData;
/*    */ import xbean.MoneyCostDayData;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Role2daymoneycostinfo
/*    */ {
/*    */   public static MoneyCostDayData get(Long key)
/*    */   {
/* 12 */     return (MoneyCostDayData)_Tables_.getInstance().role2daymoneycostinfo.get(key);
/*    */   }
/*    */   
/*    */   public static MoneyCostDayData get(Long key, MoneyCostDayData value)
/*    */   {
/* 17 */     return (MoneyCostDayData)_Tables_.getInstance().role2daymoneycostinfo.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, MoneyCostDayData value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2daymoneycostinfo.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2daymoneycostinfo.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, MoneyCostDayData value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2daymoneycostinfo.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2daymoneycostinfo.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, MoneyCostDayData> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2daymoneycostinfo.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, MoneyCostDayData> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2daymoneycostinfo;
/*    */   }
/*    */   
/*    */   public static MoneyCostDayData select(Long key)
/*    */   {
/* 52 */     (MoneyCostDayData)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public MoneyCostDayData get(MoneyCostDayData v)
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
/*    */       public Long get(MoneyCostDayData v)
/*    */       {
/* 67 */         return Long.valueOf(v.getStarttime());
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Integer, EachMoneyDayCostData> selectMoneyinfo(Long key)
/*    */   {
/* 74 */     (Map)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Map<Integer, EachMoneyDayCostData> get(MoneyCostDayData v)
/*    */       {
/* 78 */         return v.getMoneyinfoAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2daymoneycostinfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */