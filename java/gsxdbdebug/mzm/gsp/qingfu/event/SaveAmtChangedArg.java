/*    */ package mzm.gsp.qingfu.event;
/*    */ 
/*    */ public class SaveAmtChangedArg
/*    */ {
/*    */   public final String userid;
/*    */   public final long oldSaveAmt;
/*    */   public final long currSaveAmt;
/*    */   
/*    */   public SaveAmtChangedArg(String userid, long oldSaveAmt, long currSaveAmt)
/*    */   {
/* 11 */     this.userid = userid;
/* 12 */     this.oldSaveAmt = oldSaveAmt;
/* 13 */     this.currSaveAmt = currSaveAmt;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\qingfu\event\SaveAmtChangedArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */