/*    */ package mzm.gsp.breakegg.invite;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import mzm.gsp.online.event.PlayerLoginProcedure;
/*    */ import mzm.gsp.status.main.RoleStatusInterface;
/*    */ import mzm.gsp.timer.main.Session;
/*    */ import xbean.InviteConfirmBean;
/*    */ import xtable.Inviteconfirm_info;
/*    */ import xtable.Role2inviteconfirm_info;
/*    */ 
/*    */ public class POnRoleLogin extends PlayerLoginProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 15 */     long roleId = ((Long)this.arg).longValue();
/*    */     
/*    */ 
/*    */ 
/* 19 */     Long inviteConfirmId = Role2inviteconfirm_info.get(Long.valueOf(roleId));
/* 20 */     if (inviteConfirmId == null)
/*    */     {
/* 22 */       return true;
/*    */     }
/*    */     
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 29 */     InviteConfirmBean xInviteConfirmBean = Inviteconfirm_info.get(inviteConfirmId);
/* 30 */     if (xInviteConfirmBean == null)
/*    */     {
/* 32 */       if (RoleStatusInterface.containsStatus(roleId, 1861))
/*    */       {
/* 34 */         RoleStatusInterface.unsetStatus(roleId, 1861);
/*    */       }
/* 36 */       Role2inviteconfirm_info.remove(Long.valueOf(roleId));
/* 37 */       return true;
/*    */     }
/*    */     
/*    */ 
/*    */ 
/* 42 */     if (Session.getSession(xInviteConfirmBean.getSessionid()) == null)
/*    */     {
/* 44 */       InviteManager.destroyInviteInfo(roleId);
/* 45 */       return true;
/*    */     }
/*    */     
/*    */ 
/*    */ 
/* 50 */     InviteManager.sSynInviteJoinInfo(Arrays.asList(new Long[] { Long.valueOf(roleId) }), xInviteConfirmBean);
/* 51 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\breakegg\invite\POnRoleLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */