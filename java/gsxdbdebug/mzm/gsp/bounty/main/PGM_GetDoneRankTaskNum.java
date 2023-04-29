/*    */ package mzm.gsp.bounty.main;
/*    */ 
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PGM_GetDoneRankTaskNum
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final int rank;
/*    */   
/*    */   public PGM_GetDoneRankTaskNum(long roleId, int rank)
/*    */   {
/* 18 */     this.roleId = roleId;
/* 19 */     this.rank = rank;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 25 */     int num = BountyInterface.getRankDoneTaskIdsNum(this.roleId, this.rank);
/* 26 */     String res = String.format("今日已完成%d星任务%d个", new Object[] { Integer.valueOf(this.rank), Integer.valueOf(num) });
/* 27 */     GmManager.getInstance().sendResultToGM(this.roleId, res);
/* 28 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\bounty\main\PGM_GetDoneRankTaskNum.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */