/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.MenpaiPVPChart;
/*    */ import xbean.MenpaiPVPCharts;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Menpaipvpcharts
/*    */ {
/*    */   public static MenpaiPVPCharts get(Long key)
/*    */   {
/* 12 */     return (MenpaiPVPCharts)_Tables_.getInstance().menpaipvpcharts.get(key);
/*    */   }
/*    */   
/*    */   public static MenpaiPVPCharts get(Long key, MenpaiPVPCharts value)
/*    */   {
/* 17 */     return (MenpaiPVPCharts)_Tables_.getInstance().menpaipvpcharts.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, MenpaiPVPCharts value)
/*    */   {
/* 22 */     _Tables_.getInstance().menpaipvpcharts.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().menpaipvpcharts.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, MenpaiPVPCharts value)
/*    */   {
/* 32 */     return _Tables_.getInstance().menpaipvpcharts.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().menpaipvpcharts.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, MenpaiPVPCharts> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().menpaipvpcharts.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, MenpaiPVPCharts> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().menpaipvpcharts;
/*    */   }
/*    */   
/*    */   public static MenpaiPVPCharts select(Long key)
/*    */   {
/* 52 */     (MenpaiPVPCharts)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public MenpaiPVPCharts get(MenpaiPVPCharts v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Integer, MenpaiPVPChart> selectCharts(Long key)
/*    */   {
/* 63 */     (Map)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Map<Integer, MenpaiPVPChart> get(MenpaiPVPCharts v)
/*    */       {
/* 67 */         return v.getChartsAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Menpaipvpcharts.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */