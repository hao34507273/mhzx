/*    */ package mzm.gsp.coupledaily.main;
/*    */ 
/*    */ import mzm.gsp.timer.main.Session;
/*    */ 
/*    */ class PinTuPrepareSession extends Session
/*    */ {
/*    */   private final long partnerRoleId;
/*    */   
/*    */   public PinTuPrepareSession(long interval, long roleId, long partnerRoleId)
/*    */   {
/* 11 */     super(interval, roleId);
/* 12 */     this.partnerRoleId = partnerRoleId;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   protected void onTimeOut() {}
/*    */   
/*    */ 
/*    */ 
/*    */   public long getPartnerRoleId()
/*    */   {
/* 23 */     return this.partnerRoleId;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\coupledaily\main\PinTuPrepareSession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */