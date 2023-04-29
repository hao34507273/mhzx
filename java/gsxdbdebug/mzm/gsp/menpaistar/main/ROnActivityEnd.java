/*    */ package mzm.gsp.menpaistar.main;
/*    */ 
/*    */ import java.util.List;
/*    */ import mzm.gsp.util.LogicRunnable;
/*    */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*    */ 
/*    */ public class ROnActivityEnd
/*    */   extends LogicRunnable
/*    */ {
/*    */   private final int ocpid;
/*    */   
/*    */   public ROnActivityEnd(int ocpid)
/*    */   {
/* 14 */     this.ocpid = ocpid;
/*    */   }
/*    */   
/*    */ 
/*    */   public void process()
/*    */     throws Exception
/*    */   {
/* 21 */     CampaignChartManager.canJoin(this.ocpid, false);
/*    */     
/*    */ 
/* 24 */     new PSetChampion(this.ocpid).call();
/*    */     
/*    */ 
/* 27 */     CampaignChart chart = CampaignChartManager.getChart(this.ocpid);
/* 28 */     if (chart != null)
/*    */     {
/* 30 */       List<CampaignChartObj> all = chart.getAllChartObjs();
/*    */       
/* 32 */       for (CampaignChartObj chartObj : all)
/*    */       {
/* 34 */         if (chartObj.getNum() > 0)
/*    */         {
/* 36 */           NoneRealTimeTaskManager.getInstance().addTask(new PReturnCost(chartObj.getRoleid()));
/*    */         }
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\menpaistar\main\ROnActivityEnd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */