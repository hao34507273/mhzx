/*    */ package mzm.gsp.menpaistar.main;
/*    */ 
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.activity.main.ActivityJoinResult;
/*    */ import mzm.gsp.menpaistar.MenPaiStarInfo;
/*    */ import mzm.gsp.menpaistar.SGetMenPaiStarInfoSuccess;
/*    */ import mzm.gsp.menpaistar.confbean.SMenPaiStarConst;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ public class PCGetMenPaiStarInfo extends LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   
/*    */   public PCGetMenPaiStarInfo(long roleid)
/*    */   {
/* 20 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 26 */     if (!MenPaiStarManager.canDoAction(this.roleid, 1001))
/*    */     {
/* 28 */       return false;
/*    */     }
/*    */     
/* 31 */     if (!MenPaiStarManager.isFunOpen(this.roleid))
/*    */     {
/* 33 */       return false;
/*    */     }
/*    */     
/* 36 */     String userid = RoleInterface.getUserId(this.roleid);
/* 37 */     if (userid == null)
/*    */     {
/* 39 */       GameServer.logger().error(String.format("[menpaistar]PCGetMenPaiStarInfo.processImp@userid is null|roleid=%d", new Object[] { Long.valueOf(this.roleid) }));
/*    */       
/* 41 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 45 */     int activityCfgid = SMenPaiStarConst.getInstance().ACTIVITY_CFG_ID;
/* 46 */     ActivityJoinResult joinResult = ActivityInterface.canJoinAndCheckInitActivityData(userid, this.roleid, activityCfgid);
/*    */     
/* 48 */     if (!joinResult.isCanJoin())
/*    */     {
/* 50 */       GameServer.logger().error(String.format("[menpaistar]PCGetMenPaiStarInfo.processImp@can not join activity|roleid=%d|activity_cfgid=%d|reason=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(activityCfgid), Integer.valueOf(joinResult.getReasonValue()) }));
/*    */       
/*    */ 
/*    */ 
/* 54 */       return false;
/*    */     }
/*    */     
/* 57 */     MenPaiStarInfo menPaiStarInfo = new MenPaiStarInfo();
/* 58 */     MenPaiStarManager.fillCampaignInfo(this.roleid, menPaiStarInfo);
/* 59 */     MenPaiStarManager.fillVoteInfo(this.roleid, menPaiStarInfo);
/*    */     
/* 61 */     SGetMenPaiStarInfoSuccess rsp = new SGetMenPaiStarInfoSuccess(menPaiStarInfo);
/* 62 */     OnlineManager.getInstance().send(this.roleid, rsp);
/*    */     
/* 64 */     GameServer.logger().info(String.format("[menpaistar]PGetMenPaiStarInfo.processImp@get info success|roleid=%d", new Object[] { Long.valueOf(this.roleid) }));
/*    */     
/* 66 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\menpaistar\main\PCGetMenPaiStarInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */