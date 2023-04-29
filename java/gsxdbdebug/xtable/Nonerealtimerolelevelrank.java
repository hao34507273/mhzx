/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.NoneRealTimeRoleLevelRank;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Nonerealtimerolelevelrank
/*    */ {
/*    */   public static NoneRealTimeRoleLevelRank get(Long key)
/*    */   {
/* 12 */     return (NoneRealTimeRoleLevelRank)_Tables_.getInstance().nonerealtimerolelevelrank.get(key);
/*    */   }
/*    */   
/*    */   public static NoneRealTimeRoleLevelRank get(Long key, NoneRealTimeRoleLevelRank value)
/*    */   {
/* 17 */     return (NoneRealTimeRoleLevelRank)_Tables_.getInstance().nonerealtimerolelevelrank.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, NoneRealTimeRoleLevelRank value)
/*    */   {
/* 22 */     _Tables_.getInstance().nonerealtimerolelevelrank.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().nonerealtimerolelevelrank.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, NoneRealTimeRoleLevelRank value)
/*    */   {
/* 32 */     return _Tables_.getInstance().nonerealtimerolelevelrank.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().nonerealtimerolelevelrank.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, NoneRealTimeRoleLevelRank> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().nonerealtimerolelevelrank.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, NoneRealTimeRoleLevelRank> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().nonerealtimerolelevelrank;
/*    */   }
/*    */   
/*    */   public static NoneRealTimeRoleLevelRank select(Long key)
/*    */   {
/* 52 */     (NoneRealTimeRoleLevelRank)getTable().select(key, new TField()
/*    */     {
/*    */       public NoneRealTimeRoleLevelRank get(NoneRealTimeRoleLevelRank v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static java.util.List<xbean.NoneRealRoleLevelBean> selectRankdatas(Long key)
/*    */   {
/* 63 */     (java.util.List)getTable().select(key, new TField()
/*    */     {
/*    */       public java.util.List<xbean.NoneRealRoleLevelBean> get(NoneRealTimeRoleLevelRank v)
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
/*    */       public Map<Long, Integer> get(NoneRealTimeRoleLevelRank v)
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
/*    */       public Long get(NoneRealTimeRoleLevelRank v)
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
/*    */       public Long get(NoneRealTimeRoleLevelRank v)
/*    */       {
/* :0 */         return Long.valueOf(v.getAwardtime());
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Nonerealtimerolelevelrank.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */