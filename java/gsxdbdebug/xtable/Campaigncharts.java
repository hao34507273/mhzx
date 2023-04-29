/*    */ package xtable;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.CampaignChart;
/*    */ import xbean.CampaignCharts;
/*    */ import xdb.TTable;
/*    */ 
/*    */ public class Campaigncharts
/*    */ {
/*    */   public static CampaignCharts get(Long key)
/*    */   {
/* 12 */     return (CampaignCharts)_Tables_.getInstance().campaigncharts.get(key);
/*    */   }
/*    */   
/*    */   public static CampaignCharts get(Long key, CampaignCharts value)
/*    */   {
/* 17 */     return (CampaignCharts)_Tables_.getInstance().campaigncharts.get(key, value);
/*    */   }
/*    */   
/*    */   public static void insert(Long key, CampaignCharts value)
/*    */   {
/* 22 */     _Tables_.getInstance().campaigncharts.insert(key, value);
/*    */   }
/*    */   
/*    */   public static void delete(Long key)
/*    */   {
/* 27 */     _Tables_.getInstance().campaigncharts.delete(key);
/*    */   }
/*    */   
/*    */   public static boolean add(Long key, CampaignCharts value)
/*    */   {
/* 32 */     return _Tables_.getInstance().campaigncharts.add(key, value);
/*    */   }
/*    */   
/*    */   public static boolean remove(Long key)
/*    */   {
/* 37 */     return _Tables_.getInstance().campaigncharts.remove(key);
/*    */   }
/*    */   
/*    */   public static xdb.TTableCache<Long, CampaignCharts> getCache()
/*    */   {
/* 42 */     return _Tables_.getInstance().campaigncharts.getCache();
/*    */   }
/*    */   
/*    */   public static TTable<Long, CampaignCharts> getTable()
/*    */   {
/* 47 */     return _Tables_.getInstance().campaigncharts;
/*    */   }
/*    */   
/*    */   public static CampaignCharts select(Long key)
/*    */   {
/* 52 */     (CampaignCharts)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public CampaignCharts get(CampaignCharts v)
/*    */       {
/* 56 */         return v.toData();
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   public static Map<Integer, CampaignChart> selectCharts(Long key)
/*    */   {
/* 63 */     (Map)getTable().select(key, new xdb.TField()
/*    */     {
/*    */       public Map<Integer, CampaignChart> get(CampaignCharts v)
/*    */       {
/* 67 */         return v.getChartsAsData();
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xtable\Campaigncharts.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */