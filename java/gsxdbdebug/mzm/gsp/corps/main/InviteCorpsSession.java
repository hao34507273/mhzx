/*    */ package mzm.gsp.corps.main;
/*    */ 
/*    */ import mzm.gsp.corps.confbean.CorpsConsts;
/*    */ import mzm.gsp.timer.main.Session;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class InviteCorpsSession
/*    */   extends Session
/*    */ {
/*    */   private final long invitee;
/*    */   private final long corpsId;
/*    */   
/*    */   InviteCorpsSession(long inviter, long invitee, long corpsId)
/*    */   {
/* 21 */     super(CorpsConsts.getInstance().INVITE_INTERVAL, inviter);
/* 22 */     this.invitee = invitee;
/* 23 */     this.corpsId = corpsId;
/*    */   }
/*    */   
/*    */   public long getInviter()
/*    */   {
/* 28 */     return super.getOwerId();
/*    */   }
/*    */   
/*    */   public long getInvitee()
/*    */   {
/* 33 */     return this.invitee;
/*    */   }
/*    */   
/*    */   public long getCorpsId()
/*    */   {
/* 38 */     return this.corpsId;
/*    */   }
/*    */   
/*    */ 
/*    */   protected void onTimeOut()
/*    */   {
/* 44 */     new InviteTimeOut(null).execute();
/*    */   }
/*    */   
/*    */   private class InviteTimeOut extends LogicProcedure
/*    */   {
/*    */     private InviteTimeOut() {}
/*    */     
/*    */     protected boolean processImp() throws Exception
/*    */     {
/* 53 */       CorpsManager.rmInvitedRecord(InviteCorpsSession.this.corpsId, InviteCorpsSession.this.invitee);
/* 54 */       return true;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\corps\main\InviteCorpsSession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */