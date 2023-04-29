/*    */ package mzm.gsp.menpaistar.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.gsp.gm.SGMMessageTipRes;
/*    */ import mzm.gsp.menpaistar.SSyncCampaignFightResult;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import xbean.Campaign;
/*    */ import xbean.MenPaiStarCampaignInfo;
/*    */ 
/*    */ public class PGM_SetCampaign extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long gmRoleid;
/*    */   private final long roleid;
/*    */   
/*    */   public PGM_SetCampaign(long gmRoleid, long roleid)
/*    */   {
/* 17 */     this.gmRoleid = gmRoleid;
/* 18 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 24 */     MenPaiStarCampaignInfo xCampaignInfo = MenPaiStarManager.getAndInitXCampaignInfo(this.roleid);
/* 25 */     int occupationid = mzm.gsp.role.main.RoleInterface.getOccupationId(this.roleid);
/* 26 */     Campaign xCampaign = (Campaign)xCampaignInfo.getCampaigns().get(Integer.valueOf(occupationid));
/* 27 */     if (xCampaign == null)
/*    */     {
/* 29 */       xCampaign = xbean.Pod.newCampaign();
/* 30 */       xCampaignInfo.getCampaigns().put(Integer.valueOf(occupationid), xCampaign);
/*    */     }
/* 32 */     xCampaign.setCampaign(1);
/* 33 */     long now = mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis();
/* 34 */     xCampaign.getVote_award_info().setLast_time(now);
/* 35 */     MenPaiStarManager.updateCampaignRankAsync(this.roleid, mzm.gsp.role.main.RoleInterface.getName(this.roleid), occupationid, 0, now, 0, 0);
/*    */     
/*    */ 
/* 38 */     SSyncCampaignFightResult msg = new SSyncCampaignFightResult();
/* 39 */     msg.success = 1;
/* 40 */     OnlineManager.getInstance().send(this.roleid, msg);
/*    */     
/* 42 */     notifyClient("设置成功");
/*    */     
/* 44 */     return true;
/*    */   }
/*    */   
/*    */   private void notifyClient(String str)
/*    */   {
/* 49 */     SGMMessageTipRes messagetip = new SGMMessageTipRes();
/* 50 */     messagetip.result = Integer.MAX_VALUE;
/* 51 */     messagetip.args.add(str);
/* 52 */     OnlineManager.getInstance().sendAtOnce(this.gmRoleid, messagetip);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\menpaistar\main\PGM_SetCampaign.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */