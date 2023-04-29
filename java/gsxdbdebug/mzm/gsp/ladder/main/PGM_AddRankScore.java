/*    */ package mzm.gsp.ladder.main;
/*    */ 
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import xbean.Ladder;
/*    */ 
/*    */ public class PGM_AddRankScore extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long gmRoleid;
/*    */   private final long roleid;
/*    */   private final int addNum;
/*    */   
/*    */   public PGM_AddRankScore(long gmRoleid, long roleid, int addNum)
/*    */   {
/* 14 */     this.gmRoleid = gmRoleid;
/* 15 */     this.roleid = roleid;
/* 16 */     this.addNum = addNum;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 21 */     Ladder xLadder = LadderManager.getAndCreateXLadder(this.roleid);
/* 22 */     xLadder.setScore(xLadder.getScore() + this.addNum);
/* 23 */     LadderManager.getAndInitXLadder(this.roleid, true);
/* 24 */     Long befroeSeasonTime = LadderManager.getBeforeSessionTimeMilSec(mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis());
/* 25 */     if (befroeSeasonTime != null) {
/* 26 */       LadderRankManager.getInstance().rank(this.roleid, befroeSeasonTime.longValue());
/*    */     }
/* 28 */     GmManager.getInstance().sendResultToGM(this.gmRoleid, "增加匹配积分成功!!");
/* 29 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\ladder\main\PGM_AddRankScore.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */