/*    */ package mzm.gsp.couple.main;
/*    */ 
/*    */ import mzm.gsp.timer.main.Session;
/*    */ 
/*    */ public class CoupleRideSession extends Session
/*    */ {
/*    */   private final long beInvitedid;
/*    */   
/*    */   public CoupleRideSession(long interval, long roleId, long beinvitedid) {
/* 10 */     super(interval, roleId);
/* 11 */     this.beInvitedid = beinvitedid;
/*    */   }
/*    */   
/*    */   public long getBeInvitedid() {
/* 15 */     return this.beInvitedid;
/*    */   }
/*    */   
/*    */   public long getInviteid() {
/* 19 */     return getOwerId();
/*    */   }
/*    */   
/*    */   protected void onTimeOut() {}
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\couple\main\CoupleRideSession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */