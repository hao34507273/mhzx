/*    */ package mzm.gsp.crossserver.event;
/*    */ 
/*    */ import hub.CrossCompeteAgainst;
/*    */ import java.util.Collection;
/*    */ import java.util.List;
/*    */ 
/*    */ public class ReportCrossCompeteSignUpDoneArg
/*    */ {
/*    */   public final int result;
/*    */   public final long startTime;
/* 11 */   public final List<CrossCompeteAgainst> againsts = new java.util.ArrayList();
/* 12 */   public final List<Long> missTurnFactions = new java.util.ArrayList();
/*    */   
/*    */   public ReportCrossCompeteSignUpDoneArg(int result, long startTime, Collection<CrossCompeteAgainst> againsts, List<Long> missTurnFactions)
/*    */   {
/* 16 */     this.result = result;
/* 17 */     this.startTime = startTime;
/* 18 */     this.againsts.addAll(againsts);
/* 19 */     this.missTurnFactions.addAll(missTurnFactions);
/*    */   }
/*    */   
/*    */   public boolean isSuccess() {
/* 23 */     return this.result == 1;
/*    */   }
/*    */   
/*    */   public boolean isStartTimeErr() {
/* 27 */     return this.result == 2;
/*    */   }
/*    */   
/*    */   public boolean isMatching() {
/* 31 */     return this.result == 0;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\event\ReportCrossCompeteSignUpDoneArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */