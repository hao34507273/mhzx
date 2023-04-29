/*    */ package mzm.gsp.interaction.main;
/*    */ 
/*    */ import java.util.Set;
/*    */ import mzm.gsp.status.event.RoleStatusChangeArg;
/*    */ import mzm.gsp.status.event.RoleStatusChangedProcedure;
/*    */ 
/*    */ public class POnRoleStatusChanged
/*    */   extends RoleStatusChangedProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 13 */     if (!InteractionManager.isEnable()) {
/* 14 */       return false;
/*    */     }
/* 16 */     if (((RoleStatusChangeArg)this.arg).addedset.contains(Integer.valueOf(0)))
/* 17 */       return InteractionManager.cancelOrDeclineInteractionInvitationOnEvent(((RoleStatusChangeArg)this.arg).roleid);
/* 18 */     if (((RoleStatusChangeArg)this.arg).addedset.contains(Integer.valueOf(10))) {
/* 19 */       return InteractionManager.cancelOrDeclineInteractionInvitationOnEvent(((RoleStatusChangeArg)this.arg).roleid);
/*    */     }
/* 21 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\interaction\main\POnRoleStatusChanged.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */