/*    */ package mzm.gsp.menpaistar.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import java.util.Map.Entry;
/*    */ import xbean.CampaignChart;
/*    */ import xbean.CampaignCharts;
/*    */ import xtable.Campaigncharts;
/*    */ import xtable.Menpaistarchart;
/*    */ 
/*    */ public class PMenPaiStarMerge extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 14 */     long mainKey = mzm.gsp.MergeMain.getMainZoneid();
/* 15 */     long viceKey = mzm.gsp.MergeMain.getViceZoneid();
/*    */     
/*    */ 
/* 18 */     lock(xdb.Lockeys.get(xtable.Menpaistar.getTable(), new Object[] { Long.valueOf(mainKey), Long.valueOf(viceKey) }));
/* 19 */     lock(xdb.Lockeys.get(Campaigncharts.getTable(), new Object[] { Long.valueOf(mainKey), Long.valueOf(viceKey) }));
/* 20 */     lock(xdb.Lockeys.get(Menpaistarchart.getTable(), new Object[] { Long.valueOf(mainKey), Long.valueOf(viceKey) }));
/*    */     
/*    */ 
/* 23 */     xtable.Menpaistar.remove(Long.valueOf(viceKey));
/*    */     
/*    */ 
/* 26 */     CampaignCharts xViceCampaignCharts = Campaigncharts.get(Long.valueOf(viceKey));
/* 27 */     CampaignCharts xMainCampaignCharts; if (xViceCampaignCharts != null)
/*    */     {
/* 29 */       xMainCampaignCharts = Campaigncharts.get(Long.valueOf(mainKey));
/* 30 */       if (xMainCampaignCharts == null)
/*    */       {
/* 32 */         xMainCampaignCharts = xbean.Pod.newCampaignCharts();
/* 33 */         Campaigncharts.insert(Long.valueOf(mainKey), xMainCampaignCharts);
/*    */       }
/*    */       
/* 36 */       for (Map.Entry<Integer, CampaignChart> xEntry : xViceCampaignCharts.getCharts().entrySet())
/*    */       {
/* 38 */         int ocpid = ((Integer)xEntry.getKey()).intValue();
/* 39 */         CampaignChart xViceCampaignChart = (CampaignChart)xEntry.getValue();
/* 40 */         if (!xViceCampaignChart.getRanks().isEmpty())
/*    */         {
/*    */ 
/*    */ 
/*    */ 
/* 45 */           CampaignChart xMainCampaignChart = (CampaignChart)xMainCampaignCharts.getCharts().get(Integer.valueOf(ocpid));
/* 46 */           if (xMainCampaignChart == null)
/*    */           {
/* 48 */             xMainCampaignChart = xbean.Pod.newCampaignChart();
/* 49 */             xMainCampaignCharts.getCharts().put(Integer.valueOf(ocpid), xMainCampaignChart);
/*    */           }
/* 51 */           xMainCampaignChart.getRanks().addAll(xViceCampaignChart.getRanks());
/*    */         }
/*    */       }
/*    */     }
/* 55 */     Campaigncharts.remove(Long.valueOf(viceKey));
/*    */     
/*    */ 
/* 58 */     Menpaistarchart.remove(Long.valueOf(mainKey));
/* 59 */     Menpaistarchart.remove(Long.valueOf(viceKey));
/*    */     
/* 61 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\menpaistar\main\PMenPaiStarMerge.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */