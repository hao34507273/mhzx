/*    */ package mzm.gsp.breakegg.invite;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class InviteConfirmInterface
/*    */ {
/*    */   public static void sendInviteConfirm(long roleId, int inviteType, InviteConfirmContext context)
/*    */   {
/* 19 */     InviteManager.sendInviteConfirm(roleId, inviteType, context);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static void registerConfirmHandler(int inviteType, InviteConfirmHandler handler)
/*    */   {
/* 34 */     InviteManager.registerConfirmHandler(inviteType, handler);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static boolean isInInviteConfirm(long roleId)
/*    */   {
/* 46 */     return InviteManager.isInInviteConfirm(roleId);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\breakegg\invite\InviteConfirmInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */