/*    */ package mzm.gsp.interaction.main;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import mzm.gsp.interaction.SNotifyDeclineInteractionInvitation;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.status.main.RoleStatusInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xtable.Basic;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PDeclineInteractionInvitation
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final int interactionId;
/*    */   private final long activeRoleId;
/*    */   private final long passiveRoleId;
/*    */   private final int reason;
/*    */   
/*    */   public PDeclineInteractionInvitation(int interactionId, long activeRoleId, long passiveRoleId, int reason)
/*    */   {
/* 25 */     this.interactionId = interactionId;
/* 26 */     this.activeRoleId = activeRoleId;
/* 27 */     this.passiveRoleId = passiveRoleId;
/* 28 */     this.reason = reason;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 34 */     if (!InteractionManager.isEnable()) {
/* 35 */       return false;
/*    */     }
/*    */     
/* 38 */     lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.activeRoleId), Long.valueOf(this.passiveRoleId) }));
/*    */     
/*    */ 
/* 41 */     if (!InteractionInvitationContext.exists(this.interactionId, this.activeRoleId, this.passiveRoleId)) {
/* 42 */       return false;
/*    */     }
/*    */     
/* 45 */     if (this.reason == 0)
/*    */     {
/* 47 */       InteractionManager.recordFailedInteractionInvitation(this.activeRoleId, this.passiveRoleId);
/*    */     }
/*    */     
/*    */ 
/* 51 */     RoleStatusInterface.unsetStatus(this.activeRoleId, 1831);
/* 52 */     RoleStatusInterface.unsetStatus(this.passiveRoleId, 1832);
/*    */     
/*    */ 
/* 55 */     notifyDeclined();
/*    */     
/*    */ 
/* 58 */     InteractionInvitationContext.remove(this.activeRoleId);
/* 59 */     InteractionLogger.info("PDeclineInteractionInvitation.processImp()@success|interaction_id=%d|active_roleid=%d|passive_roleid=%d", new Object[] { Integer.valueOf(this.interactionId), Long.valueOf(this.activeRoleId), Long.valueOf(this.passiveRoleId) });
/*    */     
/* 61 */     return true;
/*    */   }
/*    */   
/*    */   private void notifyDeclined()
/*    */   {
/* 66 */     SNotifyDeclineInteractionInvitation notification = new SNotifyDeclineInteractionInvitation();
/* 67 */     notification.interaction_id = this.interactionId;
/* 68 */     notification.passive_role_id = this.passiveRoleId;
/* 69 */     notification.reason = this.reason;
/* 70 */     OnlineManager.getInstance().send(this.activeRoleId, notification);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\interaction\main\PDeclineInteractionInvitation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */