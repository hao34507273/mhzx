/*    */ package mzm.gsp.menpaistar.main;
/*    */ 
/*    */ import mzm.gsp.gm.SGMMessageTipRes;
/*    */ import mzm.gsp.menpaistar.MenPaiStarInfo;
/*    */ import mzm.gsp.menpaistar.SGetMenPaiStarInfoSuccess;
/*    */ import mzm.gsp.menpaistar.SSyncVoteFightResult;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import xbean.MenPaiStarVoteInfo;
/*    */ 
/*    */ public class PGM_SetVote extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long gmRoleid;
/*    */   private final long roleid;
/*    */   
/*    */   public PGM_SetVote(long gmRoleid, long roleid)
/*    */   {
/* 17 */     this.gmRoleid = gmRoleid;
/* 18 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 25 */     MenPaiStarVoteInfo xVoteInfo = MenPaiStarManager.getAndInitXVoteInfo(this.roleid);
/* 26 */     xVoteInfo.setVote(1);
/* 27 */     xVoteInfo.setVote_num(0);
/*    */     
/* 29 */     MenPaiStarInfo menPaiStarInfo = new MenPaiStarInfo();
/* 30 */     MenPaiStarManager.fillCampaignInfo(this.roleid, menPaiStarInfo);
/* 31 */     MenPaiStarManager.fillVoteInfo(this.roleid, menPaiStarInfo);
/*    */     
/* 33 */     SGetMenPaiStarInfoSuccess rsp = new SGetMenPaiStarInfoSuccess(menPaiStarInfo);
/* 34 */     OnlineManager.getInstance().send(this.roleid, rsp);
/*    */     
/*    */ 
/* 37 */     SSyncVoteFightResult msg = new SSyncVoteFightResult();
/* 38 */     msg.success = 1;
/* 39 */     OnlineManager.getInstance().send(this.roleid, msg);
/*    */     
/* 41 */     notifyClient("设置成功");
/*    */     
/* 43 */     return true;
/*    */   }
/*    */   
/*    */   private void notifyClient(String str)
/*    */   {
/* 48 */     SGMMessageTipRes messagetip = new SGMMessageTipRes();
/* 49 */     messagetip.result = Integer.MAX_VALUE;
/* 50 */     messagetip.args.add(str);
/* 51 */     OnlineManager.getInstance().sendAtOnce(this.gmRoleid, messagetip);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\menpaistar\main\PGM_SetVote.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */