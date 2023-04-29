/*    */ package mzm.gsp.menpaistar.main;
/*    */ 
/*    */ import java.util.List;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.menpaistar.SCampaignChart;
/*    */ import mzm.gsp.menpaistar.confbean.SMenPaiStarConst;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ public class PCCampaignChart
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   private final int occupationid;
/*    */   private final int page;
/*    */   
/*    */   public PCCampaignChart(long roleid, int occupationid, int page)
/*    */   {
/* 20 */     this.roleid = roleid;
/* 21 */     this.occupationid = occupationid;
/* 22 */     this.page = page;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 28 */     if ((this.occupationid <= 0) || (this.page <= 0))
/*    */     {
/* 30 */       return false;
/*    */     }
/*    */     
/* 33 */     if (!MenPaiStarManager.canDoAction(this.roleid, 1007))
/*    */     {
/* 35 */       return false;
/*    */     }
/*    */     
/* 38 */     if (!MenPaiStarManager.isFunOpen(this.roleid))
/*    */     {
/* 40 */       return false;
/*    */     }
/*    */     
/* 43 */     int size = CampaignChartManager.size(this.occupationid);
/* 44 */     int totalPage = (int)Math.ceil(size * 1.0D / SMenPaiStarConst.getInstance().PAGE_SIZE);
/*    */     
/* 46 */     int serverPage = this.page - 1;
/* 47 */     if (this.page > totalPage)
/*    */     {
/* 49 */       if (totalPage > 0)
/*    */       {
/* 51 */         serverPage = totalPage - 1;
/*    */       }
/*    */     }
/*    */     
/* 55 */     List<CampaignChartObj> ranks = CampaignChartManager.getRanks(this.occupationid, serverPage);
/* 56 */     if (ranks == null)
/*    */     {
/* 58 */       GameServer.logger().error(String.format("[menpaistar]PCCampaignChart.processImp@get ranks failed|roleid=%d|occupationid=%d|page=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.occupationid), Integer.valueOf(this.page) }));
/*    */       
/*    */ 
/* 61 */       return false;
/*    */     }
/*    */     
/* 64 */     SCampaignChart rsp = new SCampaignChart();
/* 65 */     rsp.occupationid = this.occupationid;
/* 66 */     rsp.page = (serverPage + 1);
/* 67 */     rsp.total_page = (totalPage > 0 ? totalPage : 1);
/* 68 */     rsp.ranks = CampaignChartManager.trans(serverPage, ranks);
/* 69 */     OnlineManager.getInstance().send(this.roleid, rsp);
/*    */     
/* 71 */     GameServer.logger().info(String.format("[menpaistar]PCCampaignChart.processImp@query success|roleid=%d|occupationid=%d|page=%d|total_page=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.occupationid), Integer.valueOf(this.page), Integer.valueOf(totalPage) }));
/*    */     
/*    */ 
/*    */ 
/* 75 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\menpaistar\main\PCCampaignChart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */