/*    */ package mzm.gsp.gang.main;
/*    */ 
/*    */ import java.util.Collection;
/*    */ import java.util.Iterator;
/*    */ 
/*    */ class RClearJoinApplicants extends mzm.gsp.util.LogicRunnable
/*    */ {
/*    */   private final long gangid;
/*    */   private final Collection<Long> applicants;
/*    */   
/*    */   RClearJoinApplicants(long gangid, Collection<Long> applicants)
/*    */   {
/* 13 */     this.gangid = gangid;
/* 14 */     this.applicants = applicants;
/*    */   }
/*    */   
/*    */   public void process() throws Exception
/*    */   {
/* 19 */     for (Iterator i$ = this.applicants.iterator(); i$.hasNext();) { long applicant = ((Long)i$.next()).longValue();
/* 20 */       new PRemoveApplyGang(applicant, this.gangid).call();
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\main\RClearJoinApplicants.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */