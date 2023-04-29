/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.NoneRealTimeMultiFightValueRank;
/*    */ import xdb.TField;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Nonerealtimemultifightvaluerank
/*    */ {
/*    */   public static NoneRealTimeMultiFightValueRank get(Long key)
/*    */   {
/* 12 */     return (NoneRealTimeMultiFightValueRank)_Tables_.getInstance().nonerealtimemultifightvaluerank.get(key);
/*    */   }
/*    */   
/*    */   public static NoneRealTimeMultiFightValueRank get(Long key, NoneRealTimeMultiFightValueRank value)
/*    */   {
/* 17 */     return (NoneRealTimeMultiFightValueRank)_Tables_.getInstance().nonerealtimemultifightvaluerank.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, NoneRealTimeMultiFightValueRank value)
/*    */   {
/* 22 */     _Tables_.getInstance().nonerealtimemultifightvaluerank.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().nonerealtimemultifightvaluerank.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, NoneRealTimeMultiFightValueRank value)
/*    */   {
/* 32 */     return _Tables_.getInstance().nonerealtimemultifightvaluerank.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().nonerealtimemultifightvaluerank.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, NoneRealTimeMultiFightValueRank> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().nonerealtimemultifightvaluerank.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, NoneRealTimeMultiFightValueRank> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().nonerealtimemultifightvaluerank;
/*    */   }
/*    */   
/*    */   public static NoneRealTimeMultiFightValueRank select(Long key)
/*    */   {
/* 52 */     (NoneRealTimeMultiFightValueRank)getTable().select(key, new TField()
/*    */     {
/*    */       public NoneRealTimeMultiFightValueRank get(NoneRealTimeMultiFightValueRank v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static java.util.List<xbean.NoneRealRoleMultiFightValueBean> selectRankdatas(Long key)
/*    */   {
/* 63 */     (java.util.List)getTable().select(key, new TField()
/*    */     {
/*    */       public java.util.List<xbean.NoneRealRoleMultiFightValueBean> get(NoneRealTimeMultiFightValueRank v)
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
/*    */       public Map<Long, Integer> get(NoneRealTimeMultiFightValueRank v)
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
/*    */       public Long get(NoneRealTimeMultiFightValueRank v)
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
/*    */       public Long get(NoneRealTimeMultiFightValueRank v)
/*    */       {
/* :0 */         return Long.valueOf(v.getAwardtime());
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Nonerealtimemultifightvaluerank.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */