/*    */ package mzm.gsp.interaction.main;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import mzm.gsp.interaction.SNotifyCancelInteractionInvitation;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.status.main.RoleStatusInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xtable.Basic;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PCancelInteractionInvitation
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final int interactionId;
/*    */   private final long activeRoleId;
/*    */   private final long passiveRoleId;
/*    */   
/*    */   public PCancelInteractionInvitation(int interactionId, long activeRoleId, long passiveRoleId)
/*    */   {
/* 22 */     this.interactionId = interactionId;
/* 23 */     this.activeRoleId = activeRoleId;
/* 24 */     this.passiveRoleId = passiveRoleId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 30 */     if (!InteractionManager.isEnable()) {
/* 31 */       return false;
/*    */     }
/*    */     
/* 34 */     lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.activeRoleId), Long.valueOf(this.passiveRoleId) }));
/*    */     
/*    */ 
/* 37 */     if (!InteractionInvitationContext.exists(this.interactionId, this.activeRoleId, this.passiveRoleId)) {
/* 38 */       return false;
/*    */     }
/*    */     
/* 41 */     InteractionManager.recordFailedInteractionInvitation(this.activeRoleId, this.passiveRoleId);
/*    */     
/*    */ 
/* 44 */     RoleStatusInterface.unsetStatus(this.activeRoleId, 1831);
/* 45 */     RoleStatusInterface.unsetStatus(this.passiveRoleId, 1832);
/*    */     
/*    */ 
/* 48 */     notifyPassiveRoles();
/*    */     
/*    */ 
/* 51 */     InteractionInvitationContext.remove(this.activeRoleId);
/* 52 */     InteractionLogger.info("PCancelInteractionInvitation.processImp()@success|interaction_id=%d|active_roleid=%d|passive_roleid=%d", new Object[] { Integer.valueOf(this.interactionId), Long.valueOf(this.activeRoleId), Long.valueOf(this.passiveRoleId) });
/*    */     
/*    */ 
/* 55 */     return true;
/*    */   }
/*    */   
/*    */   private void notifyPassiveRoles()
/*    */   {
/* 60 */     SNotifyCancelInteractionInvitation notification = new SNotifyCancelInteractionInvitation();
/* 61 */     notification.interaction_id = this.interactionId;
/* 62 */     notification.active_role_id = this.activeRoleId;
/* 63 */     OnlineManager.getInstance().send(this.passiveRoleId, notification);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\interaction\main\PCancelInteractionInvitation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */