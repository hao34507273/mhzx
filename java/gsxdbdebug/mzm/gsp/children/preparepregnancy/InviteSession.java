/*    */ package mzm.gsp.children.preparepregnancy;
/*    */ 
/*    */ import mzm.gsp.timer.main.Session;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class InviteSession
/*    */   extends Session
/*    */ {
/*    */   private final long inviteeid;
/*    */   private final long marriageid;
/*    */   
/*    */   public InviteSession(long interval, long roleId, long inviteeid, long marriageid)
/*    */   {
/* 18 */     super(interval, roleId);
/* 19 */     this.inviteeid = inviteeid;
/* 20 */     this.marriageid = marriageid;
/*    */   }
/*    */   
/*    */ 
/*    */   protected void onTimeOut()
/*    */   {
/* 26 */     new POnInviteSessionTimeOut(getInviterid(), getInviteeid()).execute();
/*    */   }
/*    */   
/*    */   public long getInviterid()
/*    */   {
/* 31 */     return getOwerId();
/*    */   }
/*    */   
/*    */   public long getInviteeid()
/*    */   {
/* 36 */     return this.inviteeid;
/*    */   }
/*    */   
/*    */   public long getMarriageid()
/*    */   {
/* 41 */     return this.marriageid;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\preparepregnancy\InviteSession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */