/*    */ package mzm.gsp.vote.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.VoteDatas;
/*    */ import xbean.VoteInfo;
/*    */ import xtable.Role2voteinfo;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PGM_GetVoteInfo
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final int activityId;
/*    */   
/*    */   public PGM_GetVoteInfo(long roleId, int activityId)
/*    */   {
/* 20 */     this.roleId = roleId;
/* 21 */     this.activityId = activityId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 27 */     if (!VoteManager.isActivityValid(this.activityId))
/*    */     {
/* 29 */       GmManager.getInstance().sendResultToGM(this.roleId, String.format("输入活动id有误！|activityId=%d", new Object[] { Integer.valueOf(this.activityId) }));
/* 30 */       return false;
/*    */     }
/* 32 */     VoteDatas xVoteDatas = getXVoteData();
/* 33 */     GmManager.getInstance().sendResultToGM(this.roleId, String.format("已投票：%s", new Object[] { xVoteDatas == null ? "[]" : VoteManager.getOwnVoteDataStr(xVoteDatas) }));
/*    */     
/* 35 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   private VoteDatas getXVoteData()
/*    */   {
/* 45 */     VoteInfo xVoteInfo = Role2voteinfo.select(Long.valueOf(this.roleId));
/* 46 */     if (xVoteInfo == null)
/*    */     {
/* 48 */       return null;
/*    */     }
/* 50 */     return (VoteDatas)xVoteInfo.getActivityid2votedata().get(Integer.valueOf(this.activityId));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\vote\main\PGM_GetVoteInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */