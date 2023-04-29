/*    */ package mzm.gsp.menpaistar.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import xbean.Campaign;
/*    */ import xbean.VoteAwardInfo;
/*    */ 
/*    */ public class CampaignChart extends mzm.gsp.chart.main.RankManagerNew<Long, CampaignChartObj>
/*    */ {
/*    */   private final int ocpid;
/*    */   
/*    */   public CampaignChart(int capacity, int extraSize, int ocpid)
/*    */   {
/* 14 */     super(capacity, extraSize);
/* 15 */     this.ocpid = ocpid;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public void saveToDB()
/*    */   {
/* 22 */     xbean.CampaignChart xCampaignChart = MenPaiStarManager.getAndInitXCampaignChart(this.ocpid);
/*    */     
/*    */ 
/* 25 */     List<Long> ranks = xCampaignChart.getRanks();
/* 26 */     ranks.clear();
/*    */     
/* 28 */     List<CampaignChartObj> objs = getAllChartObjs();
/* 29 */     for (CampaignChartObj obj : objs)
/*    */     {
/* 31 */       ranks.add(Long.valueOf(obj.getRoleid()));
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public void rankDataFromDB()
/*    */   {
/* 39 */     xbean.CampaignChart xCampaignChart = MenPaiStarManager.getAndInitXCampaignChart(this.ocpid);
/* 40 */     for (Iterator i$ = xCampaignChart.getRanks().iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*    */       
/*    */ 
/* 43 */       xbean.MenPaiStarCampaignInfo xCampaignInfo = xtable.Role2menpaistarcampaign.select(Long.valueOf(roleid));
/* 44 */       if (xCampaignInfo != null)
/*    */       {
/*    */ 
/*    */ 
/*    */ 
/* 49 */         Campaign xCampaign = (Campaign)xCampaignInfo.getCampaigns().get(Integer.valueOf(this.ocpid));
/* 50 */         if ((xCampaign != null) && 
/*    */         
/*    */ 
/*    */ 
/* 54 */           (xCampaign.getCampaign() == 1))
/*    */         {
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 60 */           VoteAwardInfo xVoteAwardInfo = xCampaign.getVote_award_info();
/* 61 */           rank(new CampaignChartObj(roleid, this.ocpid, xCampaign.getPoint(), xCampaign.getUpdate_point_time(), mzm.gsp.role.main.RoleInterface.getName(roleid), xVoteAwardInfo.getAward(), xVoteAwardInfo.getNum()));
/*    */         }
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\menpaistar\main\CampaignChart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */