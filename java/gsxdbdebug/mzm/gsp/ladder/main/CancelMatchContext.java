/*    */ package mzm.gsp.ladder.main;
/*    */ 
/*    */ import java.util.List;
/*    */ 
/*    */ public class CancelMatchContext
/*    */ {
/*    */   public final long teamid;
/*    */   public final int cancelid;
/*  9 */   public final List<Long> cancelReadyRoleids = new java.util.ArrayList();
/*    */   
/*    */   public CancelMatchContext(long teamid, int cancelid, List<Long> cancelReadyRoleids) {
/* 12 */     this.teamid = teamid;
/* 13 */     this.cancelid = cancelid;
/* 14 */     this.cancelReadyRoleids.addAll(cancelReadyRoleids);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\ladder\main\CancelMatchContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */