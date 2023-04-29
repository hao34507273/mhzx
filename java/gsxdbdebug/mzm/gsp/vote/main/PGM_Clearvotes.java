/*    */ package mzm.gsp.vote.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.VoteInfo;
/*    */ import xtable.Role2voteinfo;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PGM_Clearvotes
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final int activityId;
/*    */   
/*    */   public PGM_Clearvotes(long roleId, int activityId)
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
/*    */     
/* 33 */     clearXVoteData();
/* 34 */     GmManager.getInstance().sendResultToGM(this.roleId, "清空投票成功！");
/* 35 */     return true;
/*    */   }
/*    */   
/*    */   private void clearXVoteData()
/*    */   {
/* 40 */     VoteInfo xVoteInfo = Role2voteinfo.get(Long.valueOf(this.roleId));
/* 41 */     if (xVoteInfo == null)
/*    */     {
/* 43 */       return;
/*    */     }
/* 45 */     xVoteInfo.getActivityid2votedata().remove(Integer.valueOf(this.activityId));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\vote\main\PGM_Clearvotes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */