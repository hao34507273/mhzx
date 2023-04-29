/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.WeightCorrectionCounter;
/*    */ import xbean.WeightCorrectionType2Count;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Role2weightcorrectioncount
/*    */ {
/*    */   public static WeightCorrectionType2Count get(Long key)
/*    */   {
/* 12 */     return (WeightCorrectionType2Count)_Tables_.getInstance().role2weightcorrectioncount.get(key);
/*    */   }
/*    */   
/*    */   public static WeightCorrectionType2Count get(Long key, WeightCorrectionType2Count value)
/*    */   {
/* 17 */     return (WeightCorrectionType2Count)_Tables_.getInstance().role2weightcorrectioncount.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, WeightCorrectionType2Count value)
/*    */   {
/* 22 */     _Tables_.getInstance().role2weightcorrectioncount.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().role2weightcorrectioncount.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, WeightCorrectionType2Count value)
/*    */   {
/* 32 */     return _Tables_.getInstance().role2weightcorrectioncount.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().role2weightcorrectioncount.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, WeightCorrectionType2Count> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().role2weightcorrectioncount.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, WeightCorrectionType2Count> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().role2weightcorrectioncount;
/*    */   }
/*    */   
/*    */   public static WeightCorrectionType2Count select(Long key)
/*    */   {
/* 52 */     (WeightCorrectionType2Count)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public WeightCorrectionType2Count get(WeightCorrectionType2Count v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Integer, WeightCorrectionCounter> selectWeightcorrectiontype2count(Long key)
/*    */   {
/* 63 */     (Map)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Map<Integer, WeightCorrectionCounter> get(WeightCorrectionType2Count v)
/*    */       {
/* 67 */         return v.getWeightcorrectiontype2countAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Role2weightcorrectioncount.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */