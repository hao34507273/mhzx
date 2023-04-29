/*    */ package mzm.gsp.qingfu.event;
/*    */ 
/*    */ 
/*    */ public class PresentYuanbaoArg
/*    */ {
/*    */   public final String userid;
/*    */   
/*    */   public final long roleid;
/*    */   public final String billno;
/*    */   public final long oldTotalPresent;
/*    */   public final long present;
/*    */   public final long oldTotalPresentBind;
/*    */   public final long presentBind;
/*    */   
/*    */   public PresentYuanbaoArg(String userid, long roleid, String billno, long oldTotalPresent, long present, long oldTotalPresentBind, long presentBind)
/*    */   {
/* 17 */     this.userid = userid;
/* 18 */     this.roleid = roleid;
/* 19 */     this.billno = billno;
/* 20 */     this.oldTotalPresent = oldTotalPresent;
/* 21 */     this.present = present;
/* 22 */     this.oldTotalPresentBind = oldTotalPresentBind;
/* 23 */     this.presentBind = presentBind;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\qingfu\event\PresentYuanbaoArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */