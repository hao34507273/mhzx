/*    */ package mzm.gsp.breakegg.main;
/*    */ 
/*    */ import java.util.List;
/*    */ import mzm.gsp.breakegg.invite.InviteConfirmContext;
/*    */ import mzm.gsp.breakegg.invite.InviteConfirmHandler;
/*    */ import xio.Protocol;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class BreakEggConfirmHandler
/*    */   implements InviteConfirmHandler
/*    */ {
/*    */   public Protocol getExtroInfoProtocol(InviteConfirmContext context)
/*    */   {
/* 15 */     return null;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean afterInviteSuccess(List<Long> roleIds, InviteConfirmContext context)
/*    */   {
/* 21 */     if (!(context instanceof BreakEggInviteConfirmContext))
/*    */     {
/* 23 */       return false;
/*    */     }
/* 25 */     BreakEggInterface.startBreakEgg(((BreakEggInviteConfirmContext)context).activityCfgId, roleIds);
/* 26 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean afterInviteFail(List<Long> roleIds, InviteConfirmContext context)
/*    */   {
/* 32 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\breakegg\main\BreakEggConfirmHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */