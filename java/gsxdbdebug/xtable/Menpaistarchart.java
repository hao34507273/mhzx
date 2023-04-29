/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.MenPaiStarChart;
/*    */ import xbean.MenPaiStarChartInfo;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Menpaistarchart
/*    */ {
/*    */   public static MenPaiStarChart get(Long key)
/*    */   {
/* 12 */     return (MenPaiStarChart)_Tables_.getInstance().menpaistarchart.get(key);
/*    */   }
/*    */   
/*    */   public static MenPaiStarChart get(Long key, MenPaiStarChart value)
/*    */   {
/* 17 */     return (MenPaiStarChart)_Tables_.getInstance().menpaistarchart.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, MenPaiStarChart value)
/*    */   {
/* 22 */     _Tables_.getInstance().menpaistarchart.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().menpaistarchart.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, MenPaiStarChart value)
/*    */   {
/* 32 */     return _Tables_.getInstance().menpaistarchart.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().menpaistarchart.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, MenPaiStarChart> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().menpaistarchart.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, MenPaiStarChart> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().menpaistarchart;
/*    */   }
/*    */   
/*    */   public static MenPaiStarChart select(Long key)
/*    */   {
/* 52 */     (MenPaiStarChart)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public MenPaiStarChart get(MenPaiStarChart v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Integer, MenPaiStarChartInfo> selectCharts(Long key)
/*    */   {
/* 63 */     (Map)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Map<Integer, MenPaiStarChartInfo> get(MenPaiStarChart v)
/*    */       {
/* 67 */         return v.getChartsAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Menpaistarchart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */