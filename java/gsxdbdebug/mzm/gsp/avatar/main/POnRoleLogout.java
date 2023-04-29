/*    */ package mzm.gsp.avatar.main;
/*    */ 
/*    */ import mzm.gsp.online.event.PlayerEnterProtectProcedure;
/*    */ import xbean.RoleAvatarSessionInfo;
/*    */ 
/*    */ 
/*    */ public class POnRoleLogout
/*    */   extends PlayerEnterProtectProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 13 */     RoleAvatarSessionInfo xSessionInfo = AvatarManager.getRoleAvatarSessionInfo(((Long)this.arg).longValue(), true);
/* 14 */     if (xSessionInfo != null)
/* 15 */       AvatarExpireSession.stopSessions(((Long)this.arg).longValue(), xSessionInfo);
/* 16 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\avatar\main\POnRoleLogout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */