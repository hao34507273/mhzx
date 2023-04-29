/*    */ package mzm.gsp.avatar.main;
/*    */ 
/*    */ import mzm.gsp.online.event.PlayerLoginProcedure;
/*    */ import xbean.RoleAvatar;
/*    */ import xbean.RoleAvatarSessionInfo;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class POnRoleLogin
/*    */   extends PlayerLoginProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 17 */     if (!AvatarManager.checkRoleLevel(((Long)this.arg).longValue())) {
/* 18 */       return false;
/*    */     }
/* 20 */     RoleAvatar xRoleAvatar = AvatarManager.getOrCreateRoleAvatar(((Long)this.arg).longValue());
/* 21 */     AvatarManager.clearUnavailableAvatars(((Long)this.arg).longValue(), xRoleAvatar);
/* 22 */     AvatarManager.syncAvatarInfo(((Long)this.arg).longValue(), xRoleAvatar);
/*    */     
/* 24 */     RoleAvatarSessionInfo xSessionInfo = AvatarManager.getOrCreateRoleAvatarSessionInfo(((Long)this.arg).longValue());
/* 25 */     AvatarExpireSession.startSessions(((Long)this.arg).longValue(), xRoleAvatar, xSessionInfo);
/*    */     
/* 27 */     AvatarManager.info("POnRoleLogin.processImp()@done|roleid=%d", new Object[] { this.arg });
/* 28 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\avatar\main\POnRoleLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */