/*    */ package mzm.gsp.couple.main;
/*    */ 
/*    */ public class DissolveCoupleRideRet {
/*    */   private Reason reason;
/*    */   
/*    */   public DissolveCoupleRideRet(Reason reason) {
/*  7 */     this.reason = reason;
/*    */   }
/*    */   
/*    */   public static enum Reason {
/* 11 */     NOT_IN_COUPLE_RIDE, 
/* 12 */     SUCCESS;
/*    */     
/*    */     private Reason() {}
/*    */   }
/*    */   
/* 17 */   public boolean isNotInCoupleRide() { return this.reason == Reason.NOT_IN_COUPLE_RIDE; }
/*    */   
/*    */   public boolean success()
/*    */   {
/* 21 */     return this.reason == Reason.SUCCESS;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\couple\main\DissolveCoupleRideRet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */