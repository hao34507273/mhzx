/*    */ package mzm.gsp.gang.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import mzm.gsp.util.LogicRunnable;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class RClearCombineApplyList
/*    */   extends LogicRunnable
/*    */ {
/*    */   private final long gangid;
/*    */   private final List<Long> applicants;
/*    */   
/*    */   RClearCombineApplyList(long gangid, List<Long> applicants)
/*    */   {
/* 19 */     this.gangid = gangid;
/* 20 */     this.applicants = applicants;
/*    */   }
/*    */   
/*    */   public void process() throws Exception
/*    */   {
/* 25 */     Iterator<Long> iter = this.applicants.iterator();
/* 26 */     while (iter.hasNext()) {
/* 27 */       long applicantid = ((Long)iter.next()).longValue();
/*    */       
/* 29 */       boolean ret = new PCancelCombineApply(this.gangid, applicantid, true).call();
/*    */       
/* 31 */       if (ret) {
/* 32 */         GangManager.logInfo("RClearCombineApplyList.process@cancel apply succeed|gangid=%d|applicants=%s|applicantid=%d", new Object[] { Long.valueOf(this.gangid), this.applicants, Long.valueOf(applicantid) });
/*    */       }
/*    */       else {
/* 35 */         GangManager.logInfo("RClearCombineApplyList.process@cancel apply failed|gangid=%d|applicants=%s|applicantid=%d", new Object[] { Long.valueOf(this.gangid), this.applicants, Long.valueOf(applicantid) });
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\main\RClearCombineApplyList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */