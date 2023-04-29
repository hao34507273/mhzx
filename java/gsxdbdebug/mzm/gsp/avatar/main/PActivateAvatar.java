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
/*    */ 
/*    */ 
/*    */ public class PActivateAvatar
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final int avatarId;
/*    */   
/*    */   public PActivateAvatar(long roleId, int avatarId)
/*    */   {
/* 21 */     this.roleId = roleId;
/* 22 */     this.avatarId = avatarId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 28 */     if (!AvatarManager.isEnable())
/* 29 */       return false;
/* 30 */     if (!RoleStatusInterface.checkCanSetStatus(this.roleId, 1751, false)) {
/* 31 */       return false;
/*    */     }
/*    */     
/* 34 */     RoleAvatar xRoleAvatar = AvatarManager.getRoleAvatar(this.roleId, true);
/* 35 */     if (xRoleAvatar == null)
/* 36 */       return false;
/* 37 */     if (xRoleAvatar.get_active_avatar() == this.avatarId)
/*    */     {
/* 39 */       AvatarManager.info("PActivateAvatar.processImp()@same avatar|roleid=%d|avatar_cfgid=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.avatarId) });
/* 40 */       return false;
/*    */     }
/*    */     
/* 43 */     if (this.avatarId != 0)
/*    */     {
/*    */ 
/* 46 */       Integer expireTime = (Integer)xRoleAvatar.get_avatars().get(Integer.valueOf(this.avatarId));
/* 47 */       if (expireTime == null)
/*    */       {
/* 49 */         AvatarManager.sendActivateAvatarFailAtOnce(this.roleId, 0);
/* 50 */         AvatarManager.info("PActivateAvatar.processImp@locked|roleid=%d|avatar_cfgid=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.avatarId) });
/* 51 */         return false;
/*    */       }
/* 53 */       if (AvatarManager.isExpired(expireTime.intValue()))
/*    */       {
/* 55 */         AvatarManager.sendActivateAvatarFailAtOnce(this.roleId, 1);
/* 56 */         AvatarManager.info("PActivateAvatar.processImp@expired|roleid=%d|avatar_cfgid=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.avatarId) });
/* 57 */         return false;
/*    */       }
/*    */       
/*    */ 
/* 61 */       Map<Integer, Integer> propertyMap = AvatarManager.getAvatarProperties(this.avatarId);
/* 62 */       if (propertyMap.isEmpty())
/*    */       {
/* 64 */         AvatarManager.sendActivateAvatarFailAtOnce(this.roleId, 2);
/* 65 */         AvatarManager.info("[avatar]PActivateAvatar.processImp@no property|roleid=%d|avatar_cfgid=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.avatarId) });
/*    */         
/* 67 */         return false;
/*    */       }
/*    */     }
/*    */     
/* 71 */     int oldAvatarId = xRoleAvatar.get_active_avatar();
/* 72 */     xRoleAvatar.set_active_avatar(this.avatarId);
/* 73 */     AvatarManager.sendActivateAvatarSuccess(this.roleId, this.avatarId);
/* 74 */     AvatarManager.tlogActivateAvatar(this.roleId, oldAvatarId, this.avatarId);
/* 75 */     AvatarManager.triggerActivatedAvatarChangeEvent(this.roleId, 0);
/* 76 */     AvatarManager.info("PActivateAvatar.processImp()@done|roleid=%d|avatar_cfgid=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.avatarId) });
/* 77 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\avatar\main\PActivateAvatar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */