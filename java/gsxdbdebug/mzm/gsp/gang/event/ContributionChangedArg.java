/*    */ package mzm.gsp.gang.event;
/*    */ 
/*    */ 
/*    */ public class ContributionChangedArg
/*    */ {
/*    */   public final long roleid;
/*    */   
/*    */   public final long oldCurContribution;
/*    */   
/*    */   public final long oldSumContribution;
/*    */   
/*    */   public final long newCurContribution;
/*    */   
/*    */   public final long newSumContribution;
/*    */   
/*    */   public ContributionChangedArg(long roleid, long oldCurContribution, long oldSumContribution, long newCurContribution, long newSumContribution)
/*    */   {
/* 18 */     this.roleid = roleid;
/* 19 */     this.oldCurContribution = oldCurContribution;
/* 20 */     this.oldSumContribution = oldSumContribution;
/* 21 */     this.newCurContribution = newCurContribution;
/* 22 */     this.newSumContribution = newSumContribution;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\event\ContributionChangedArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */