/*    */ package mzm.gsp.menpaistar.main;
/*    */ 
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.util.LogicRunnable;
/*    */ 
/*    */ public class RUpdateCampaign extends LogicRunnable
/*    */ {
/*    */   private final CampaignChartObj chartObj;
/*    */   
/*    */   public RUpdateCampaign(CampaignChartObj chartObj)
/*    */   {
/* 12 */     this.chartObj = chartObj;
/*    */   }
/*    */   
/*    */   public void process()
/*    */     throws Exception
/*    */   {
/* 18 */     if (!CampaignChartManager.canJoin(this.chartObj.getOcpid()))
/*    */     {
/* 20 */       GameServer.logger().error(String.format("[menpaistar]RUpdateCampaign.process@can not join|roleid=%d|ocpid=%d|point=%d|award=%d|num=%d", new Object[] { Long.valueOf(this.chartObj.getRoleid()), Integer.valueOf(this.chartObj.getOcpid()), Integer.valueOf(this.chartObj.getPoint()), Integer.valueOf(this.chartObj.getAward()), Integer.valueOf(this.chartObj.getNum()) }));
/*    */       
/*    */ 
/*    */ 
/*    */ 
/* 25 */       return;
/*    */     }
/* 27 */     CampaignChartManager.rank(this.chartObj);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\menpaistar\main\RUpdateCampaign.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */