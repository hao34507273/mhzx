/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.NoneRealTimePetYaoliRank;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Nonerealtimepetyaolirank
/*    */ {
/*    */   public static NoneRealTimePetYaoliRank get(Long key)
/*    */   {
/* 12 */     return (NoneRealTimePetYaoliRank)_Tables_.getInstance().nonerealtimepetyaolirank.get(key);
/*    */   }
/*    */   
/*    */   public static NoneRealTimePetYaoliRank get(Long key, NoneRealTimePetYaoliRank value)
/*    */   {
/* 17 */     return (NoneRealTimePetYaoliRank)_Tables_.getInstance().nonerealtimepetyaolirank.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, NoneRealTimePetYaoliRank value)
/*    */   {
/* 22 */     _Tables_.getInstance().nonerealtimepetyaolirank.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().nonerealtimepetyaolirank.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, NoneRealTimePetYaoliRank value)
/*    */   {
/* 32 */     return _Tables_.getInstance().nonerealtimepetyaolirank.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().nonerealtimepetyaolirank.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, NoneRealTimePetYaoliRank> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().nonerealtimepetyaolirank.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, NoneRealTimePetYaoliRank> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().nonerealtimepetyaolirank;
/*    */   }
/*    */   
/*    */   public static NoneRealTimePetYaoliRank select(Long key)
/*    */   {
/* 52 */     (NoneRealTimePetYaoliRank)getTable().select(key, new TField()
/*    */     {
/*    */       public NoneRealTimePetYaoliRank get(NoneRealTimePetYaoliRank v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static java.util.List<xbean.NoneRealTimePetYaoliBean> selectRankdatas(Long key)
/*    */   {
/* 63 */     (java.util.List)getTable().select(key, new TField()
/*    */     {
/*    */       public java.util.List<xbean.NoneRealTimePetYaoliBean> get(NoneRealTimePetYaoliRank v)
/*    */       {
/* 67 */         return v.getRankdatasAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Long, Integer> selectKeytorankchange(Long key)
/*    */   {
/* 74 */     (Map)getTable().select(key, new TField()
/*    */     {
/*    */       public Map<Long, Integer> get(NoneRealTimePetYaoliRank v)
/*    */       {
/* 78 */         return v.getKeytorankchangeAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Long selectSavetime(Long key)
/*    */   {
/* 85 */     (Long)getTable().select(key, new TField()
/*    */     {
/*    */       public Long get(NoneRealTimePetYaoliRank v)
/*    */       {
/* 89 */         return Long.valueOf(v.getSavetime());
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Long selectAwardtime(Long key)
/*    */   {
/* 96 */     (Long)getTable().select(key, new TField()
/*    */     {
/*    */       public Long get(NoneRealTimePetYaoliRank v)
/*    */       {
/* :0 */         return Long.valueOf(v.getAwardtime());
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Nonerealtimepetyaolirank.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */