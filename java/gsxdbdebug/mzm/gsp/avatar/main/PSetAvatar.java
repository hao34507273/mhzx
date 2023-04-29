/*    */ package mzm.gsp.avatar.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.gsp.status.main.RoleStatusInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.RoleAvatar;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PSetAvatar
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final int avatarId;
/*    */   
/*    */   public PSetAvatar(long roleId, int avatarId)
/*    */   {
/* 19 */     this.roleId = roleId;
/* 20 */     this.avatarId = avatarId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 26 */     if (!AvatarManager.isEnable())
/* 27 */       return false;
/* 28 */     if (!RoleStatusInterface.checkCanSetStatus(this.roleId, 1751, false)) {
/* 29 */       return false;
/*    */     }
/*    */     
/* 32 */     RoleAvatar xRoleAvatar = AvatarManager.getRoleAvatar(this.roleId, true);
/* 33 */     if (xRoleAvatar == null)
/* 34 */       return false;
/* 35 */     if (xRoleAvatar.get_current_avatar() == this.avatarId)
/*    */     {
/* 37 */       AvatarManager.info("PSetAvatar.processImp@same avatar|roleid=%d|avatar_cfgid=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.avatarId) });
/* 38 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 42 */     Integer expireTime = (Integer)xRoleAvatar.get_avatars().get(Integer.valueOf(this.avatarId));
/* 43 */     if (expireTime == null)
/*    */     {
/* 45 */       AvatarManager.sendSetAvatarFailAtOnce(this.roleId, 0);
/* 46 */       AvatarManager.info("PSetAvatar.processImp@locked|roleid=%d|avatarid=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.avatarId) });
/* 47 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 51 */     if (AvatarManager.isExpired(expireTime.intValue()))
/*    */     {
/* 53 */       AvatarManager.sendSetAvatarFailAtOnce(this.roleId, 1);
/* 54 */       AvatarManager.info("[avatar]PSetAvatar.processImp@expired|roleid=%d|avatar_cfgid=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.avatarId) });
/* 55 */       return false;
/*    */     }
/*    */     
/* 58 */     int oldAvatarId = xRoleAvatar.get_current_avatar();
/* 59 */     xRoleAvatar.set_current_avatar(this.avatarId);
/* 60 */     AvatarManager.sendSetAvatarSuccess(this.roleId, this.avatarId);
/* 61 */     AvatarManager.tlogUseAvatar(this.roleId, oldAvatarId, this.avatarId);
/* 62 */     AvatarManager.triggerCurrentAvatarChangeEvent(this.roleId, 0);
/* 63 */     AvatarManager.info("[avatar]PSetAvatar.processImp@done|roleId=%d|avatarId=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.avatarId) });
/* 64 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\avatar\main\PSetAvatar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */