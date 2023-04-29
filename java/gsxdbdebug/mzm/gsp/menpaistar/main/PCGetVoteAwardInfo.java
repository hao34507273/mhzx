/*    */ package mzm.gsp.menpaistar.main;
/*    */ 
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.activity.main.ActivityJoinResult;
/*    */ import mzm.gsp.menpaistar.SGetVoteAwardInfoSuccess;
/*    */ import mzm.gsp.menpaistar.confbean.SMenPaiStarConst;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.Campaign;
/*    */ import xbean.MenPaiStarCampaignInfo;
/*    */ import xbean.VoteAwardInfo;
/*    */ 
/*    */ public class PCGetVoteAwardInfo extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   
/*    */   public PCGetVoteAwardInfo(long roleid)
/*    */   {
/* 19 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 25 */     if (!MenPaiStarManager.canDoAction(this.roleid, 1002))
/*    */     {
/* 27 */       return false;
/*    */     }
/*    */     
/* 30 */     if (!MenPaiStarManager.isFunOpen(this.roleid))
/*    */     {
/* 32 */       return false;
/*    */     }
/*    */     
/* 35 */     String userid = RoleInterface.getUserId(this.roleid);
/* 36 */     if (userid == null)
/*    */     {
/* 38 */       GameServer.logger().error(String.format("[menpaistar]PCGetVoteAwardInfo.processImp@userid is null|roleid=%d", new Object[] { Long.valueOf(this.roleid) }));
/*    */       
/* 40 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 44 */     int activityCfgid = SMenPaiStarConst.getInstance().ACTIVITY_CFG_ID;
/* 45 */     ActivityJoinResult joinResult = mzm.gsp.activity.main.ActivityInterface.canJoinAndCheckInitActivityData(userid, this.roleid, activityCfgid);
/*    */     
/* 47 */     if (!joinResult.isCanJoin())
/*    */     {
/* 49 */       GameServer.logger().error(String.format("[menpaistar]PCGetVoteAwardInfo.processImp@can not join activity|roleid=%d|activity_cfgid=%d|reason=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(activityCfgid), Integer.valueOf(joinResult.getReasonValue()) }));
/*    */       
/*    */ 
/*    */ 
/* 53 */       return false;
/*    */     }
/*    */     
/* 56 */     MenPaiStarCampaignInfo xCampaignInfo = xtable.Role2menpaistarcampaign.get(Long.valueOf(this.roleid));
/* 57 */     if (xCampaignInfo == null)
/*    */     {
/* 59 */       GameServer.logger().error(String.format("[menpaistar]PCGetVoteAwardInfo.processImp@xbean campaign info is null|roleid=%d", new Object[] { Long.valueOf(this.roleid) }));
/*    */       
/*    */ 
/* 62 */       return false;
/*    */     }
/*    */     
/* 65 */     int ocpid = RoleInterface.getOccupationId(this.roleid);
/* 66 */     Campaign xCampaign = (Campaign)xCampaignInfo.getCampaigns().get(Integer.valueOf(ocpid));
/* 67 */     if (xCampaign == null)
/*    */     {
/* 69 */       GameServer.logger().error(String.format("[menpaistar]PCGetVoteAwardInfo.processImp@xbean campaign is null|roleid=%d|occupationid=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(ocpid) }));
/*    */       
/*    */ 
/* 72 */       return false;
/*    */     }
/*    */     
/* 75 */     if (xCampaign.getCampaign() != 1)
/*    */     {
/* 77 */       GameServer.logger().error(String.format("[menpaistar]PCGetVoteAwardInfo.processImp@campaign invalid|roleid=%d|occupationid=%d|campaign=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(ocpid), Integer.valueOf(xCampaign.getCampaign()) }));
/*    */       
/*    */ 
/*    */ 
/* 81 */       return false;
/*    */     }
/*    */     
/* 84 */     SGetVoteAwardInfoSuccess rsp = new SGetVoteAwardInfoSuccess();
/* 85 */     rsp.vote_award_info.award = xCampaign.getVote_award_info().getAward();
/* 86 */     rsp.vote_award_info.num = xCampaign.getVote_award_info().getNum();
/* 87 */     mzm.gsp.online.main.OnlineManager.getInstance().send(this.roleid, rsp);
/*    */     
/* 89 */     GameServer.logger().info(String.format("[menpaistar]PCGetVoteAwardInfo.processImp@get info success|roleid=%d|occupationid=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(ocpid) }));
/*    */     
/*    */ 
/* 92 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\menpaistar\main\PCGetVoteAwardInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */