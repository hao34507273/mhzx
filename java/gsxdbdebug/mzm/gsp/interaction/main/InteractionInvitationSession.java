/*    */ package mzm.gsp.interaction.main;
/*    */ 
/*    */ import mzm.gsp.interaction.confbean.SInteractionCfg;
/*    */ import mzm.gsp.timer.main.Session;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class InteractionInvitationSession
/*    */   extends Session
/*    */ {
/*    */   private final int interactionId;
/*    */   private final long activeRoleId;
/*    */   private final long passiveRoleId;
/*    */   
/*    */   InteractionInvitationSession(long interval, int interactionId, long activeRoleId, long passiveRoleId)
/*    */   {
/* 19 */     super(interval, activeRoleId);
/* 20 */     this.interactionId = interactionId;
/* 21 */     this.activeRoleId = activeRoleId;
/* 22 */     this.passiveRoleId = passiveRoleId;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   protected void onTimeOut()
/*    */   {
/* 31 */     SInteractionCfg interactionCfg = SInteractionCfg.get(this.interactionId);
/* 32 */     if (interactionCfg == null)
/* 33 */       return;
/* 34 */     if (interactionCfg.acceptInvitationOnTimeout)
/*    */     {
/* 36 */       new PAcceptInteractionInvitation(this.interactionId, this.activeRoleId, this.passiveRoleId).call();
/*    */     }
/*    */     else
/*    */     {
/* 40 */       new PDeclineInteractionInvitation(this.interactionId, this.activeRoleId, this.passiveRoleId, 0).call();
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\interaction\main\InteractionInvitationSession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */