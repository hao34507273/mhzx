/*    */ package mzm.gsp.coupledaily.main;
/*    */ 
/*    */ import mzm.gsp.timer.main.Session;
/*    */ 
/*    */ 
/*    */ 
/*    */ class XinYouLingXiPrepareSession
/*    */   extends Session
/*    */ {
/*    */   private final long partnerRoleId;
/*    */   
/*    */   public XinYouLingXiPrepareSession(long interval, long roleId, long partnerRoleId)
/*    */   {
/* 14 */     super(interval, roleId);
/* 15 */     this.partnerRoleId = partnerRoleId;
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
/* 26 */     return this.partnerRoleId;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\coupledaily\main\XinYouLingXiPrepareSession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */