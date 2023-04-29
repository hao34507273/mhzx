/*     */ package mzm.gsp.avatar.main;
/*     */ 
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import xbean.RoleAvatar;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class AvatarInterface
/*     */ {
/*     */   public static Map<Integer, Integer> getRoleAvatarProperties(long roleId)
/*     */   {
/*  18 */     return getRoleAvatarProperties(roleId, false);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static Map<Integer, Integer> getRoleAvatarProperties(long roleId, boolean holdRolelock)
/*     */   {
/*  29 */     RoleAvatar xRoleAvatar = AvatarManager.getRoleAvatar(roleId, holdRolelock);
/*  30 */     if (xRoleAvatar == null) {
/*  31 */       return AvatarManager.getAvatarProperties(0);
/*     */     }
/*  33 */     return AvatarManager.getAvatarProperties(xRoleAvatar.get_active_avatar());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public static int getCurrentAvatar(long roleId)
/*     */   {
/*  41 */     return getCurrentAvatar(roleId, false);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static int getCurrentAvatar(long roleId, boolean holdRolelock)
/*     */   {
/*  53 */     if (AvatarManager.isEnable())
/*     */     {
/*  55 */       RoleAvatar xRoleAvatar = AvatarManager.getRoleAvatar(roleId, holdRolelock);
/*  56 */       if (xRoleAvatar == null) {
/*  57 */         return AvatarManager.getRoleDefaultAvatarId(roleId);
/*     */       }
/*  59 */       return xRoleAvatar.get_current_avatar();
/*     */     }
/*     */     
/*  62 */     return AvatarManager.getRoleDefaultAvatarId(roleId);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static int getOwnedAvatarCount(long roleId, boolean suitCurrentOcpOnly, boolean holdRolelock)
/*     */   {
/*  75 */     RoleAvatar xRoleAvatar = AvatarManager.getRoleAvatar(roleId, holdRolelock);
/*  76 */     if ((AvatarManager.isEnable()) && (xRoleAvatar != null))
/*     */     {
/*  78 */       if (suitCurrentOcpOnly)
/*     */       {
/*  80 */         int count = 0;
/*  81 */         for (Integer avatarId : xRoleAvatar.get_avatars().keySet())
/*     */         {
/*  83 */           if (AvatarManager.canUseAvatar(roleId, avatarId.intValue()))
/*     */           {
/*  85 */             count++;
/*     */           }
/*     */         }
/*  88 */         return count;
/*     */       }
/*     */       
/*     */ 
/*  92 */       return xRoleAvatar.get_avatars().size();
/*     */     }
/*     */     
/*     */ 
/*  96 */     return 1;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean hasAvatars(long roleId, Set<Integer> avatarIds, boolean suitCurrentOcpOnly, boolean holdRolelock)
/*     */   {
/* 110 */     RoleAvatar xRoleAvatar = AvatarManager.getRoleAvatar(roleId, holdRolelock);
/* 111 */     if ((AvatarManager.isEnable()) && (xRoleAvatar != null))
/*     */     {
/* 113 */       Set<Integer> ownAvatars = xRoleAvatar.get_avatars().keySet();
/* 114 */       for (Integer avatarId : avatarIds)
/*     */       {
/* 116 */         if (!ownAvatars.contains(avatarId))
/* 117 */           return false;
/* 118 */         if (!AvatarManager.canUseAvatar(roleId, avatarId.intValue()))
/* 119 */           return false;
/*     */       }
/* 121 */       return true;
/*     */     }
/*     */     
/*     */ 
/* 125 */     return (avatarIds.size() <= 1) && (avatarIds.contains(Integer.valueOf(AvatarManager.getRoleDefaultAvatarId(roleId))));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static int removeAvatarByItem(long roleId, int avatarItemId)
/*     */   {
/* 137 */     return AvatarManager.removeAvatarByItem(roleId, avatarItemId);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\avatar\main\AvatarInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */