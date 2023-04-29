/*    */ package mzm.gsp.ladder.main;
/*    */ 
/*    */ import mzm.gsp.util.DateTimeUtils;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.Ladder;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class POffLineReport
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   
/*    */   public POffLineReport(long roleid)
/*    */   {
/* 67 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 72 */     Ladder xLadder = LadderManager.getAndInitXLadder(this.roleid, true);
/* 73 */     if (xLadder == null) {
/* 74 */       return false;
/*    */     }
/* 76 */     Long beforeSeasonTime = LadderManager.getBeforeSessionTimeMilSec(DateTimeUtils.getCurrTimeInMillis());
/* 77 */     if (beforeSeasonTime != null) {
/* 78 */       LadderRankManager.getInstance().rank(this.roleid, beforeSeasonTime.longValue());
/*    */     }
/*    */     
/* 81 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\ladder\main\POffLineReport.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */