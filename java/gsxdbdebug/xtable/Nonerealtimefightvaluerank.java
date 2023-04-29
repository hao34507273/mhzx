/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.NoneRealTimeFightValueRank;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Nonerealtimefightvaluerank
/*    */ {
/*    */   public static NoneRealTimeFightValueRank get(Long key)
/*    */   {
/* 12 */     return (NoneRealTimeFightValueRank)_Tables_.getInstance().nonerealtimefightvaluerank.get(key);
/*    */   }
/*    */   
/*    */   public static NoneRealTimeFightValueRank get(Long key, NoneRealTimeFightValueRank value)
/*    */   {
/* 17 */     return (NoneRealTimeFightValueRank)_Tables_.getInstance().nonerealtimefightvaluerank.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, NoneRealTimeFightValueRank value)
/*    */   {
/* 22 */     _Tables_.getInstance().nonerealtimefightvaluerank.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().nonerealtimefightvaluerank.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, NoneRealTimeFightValueRank value)
/*    */   {
/* 32 */     return _Tables_.getInstance().nonerealtimefightvaluerank.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().nonerealtimefightvaluerank.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, NoneRealTimeFightValueRank> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().nonerealtimefightvaluerank.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, NoneRealTimeFightValueRank> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().nonerealtimefightvaluerank;
/*    */   }
/*    */   
/*    */   public static NoneRealTimeFightValueRank select(Long key)
/*    */   {
/* 52 */     (NoneRealTimeFightValueRank)getTable().select(key, new TField()
/*    */     {
/*    */       public NoneRealTimeFightValueRank get(NoneRealTimeFightValueRank v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static java.util.List<xbean.NoneRealRoleFightValueBean> selectRankdatas(Long key)
/*    */   {
/* 63 */     (java.util.List)getTable().select(key, new TField()
/*    */     {
/*    */       public java.util.List<xbean.NoneRealRoleFightValueBean> get(NoneRealTimeFightValueRank v)
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
/*    */       public Map<Long, Integer> get(NoneRealTimeFightValueRank v)
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
/*    */       public Long get(NoneRealTimeFightValueRank v)
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
/*    */       public Long get(NoneRealTimeFightValueRank v)
/*    */       {
/* :0 */         return Long.valueOf(v.getAwardtime());
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Nonerealtimefightvaluerank.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */