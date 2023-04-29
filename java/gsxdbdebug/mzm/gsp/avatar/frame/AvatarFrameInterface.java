/*     */ package mzm.gsp.avatar.frame;
/*     */ 
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.avatar.confbean.SAvatarFrameCfg;
/*     */ import mzm.gsp.avatar.confbean.SAvatarFrameConsts;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import xbean.RoleAvatarFrame;
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
/*     */ 
/*     */ 
/*     */ public class AvatarFrameInterface
/*     */ {
/*     */   public static int getCurrentAvatarFrameId(long roleId, boolean holdLock)
/*     */   {
/*  26 */     if (AvatarFrameManager.isNotEnabled())
/*  27 */       return SAvatarFrameConsts.getInstance().DEFAULT_AVATAR_FRAME_ID;
/*  28 */     RoleAvatarFrame xRoleAvatarFrame = AvatarFrameManager.getRoleAvatarFrame(roleId, holdLock);
/*  29 */     if (xRoleAvatarFrame == null) {
/*  30 */       return SAvatarFrameConsts.getInstance().DEFAULT_AVATAR_FRAME_ID;
/*     */     }
/*  32 */     return xRoleAvatarFrame.getCurrent_avatar_frame();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean hasAvatarFrame(long roleId, int avatarFrameId, boolean holdLock)
/*     */   {
/*  40 */     RoleAvatarFrame xRoleAvatarFrame = AvatarFrameManager.getRoleAvatarFrame(roleId, holdLock);
/*  41 */     if (xRoleAvatarFrame == null)
/*  42 */       return false;
/*  43 */     Integer expireTime = (Integer)xRoleAvatarFrame.getAvatar_frames().get(Integer.valueOf(avatarFrameId));
/*  44 */     if (expireTime == null)
/*  45 */       return false;
/*  46 */     if (expireTime.intValue() == 0)
/*  47 */       return true;
/*  48 */     int now = (int)(DateTimeUtils.getCurrTimeInMillis() / 1000L);
/*  49 */     return expireTime.intValue() > now;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public static int getAvatarFrameCount(long roleId, boolean holdLock)
/*     */   {
/*  57 */     return getAvatarFrameCount(roleId, true, holdLock);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static int getAvatarFrameCount(long roleId, boolean suitCurrentOccupationOnly, boolean holdLock)
/*     */   {
/*  66 */     RoleAvatarFrame xRoleAvatarFrame = AvatarFrameManager.getRoleAvatarFrame(roleId, holdLock);
/*  67 */     if (xRoleAvatarFrame == null) {
/*  68 */       return 1;
/*     */     }
/*  70 */     int count = 0;
/*  71 */     int now = (int)(DateTimeUtils.getCurrTimeInMillis() / 1000L);
/*  72 */     int currentOccupationId = RoleInterface.getOccupationId(roleId);
/*  73 */     for (Map.Entry<Integer, Integer> entry : xRoleAvatarFrame.getAvatar_frames().entrySet())
/*     */     {
/*  75 */       int avatarFrameId = ((Integer)entry.getKey()).intValue();
/*  76 */       int expireTime = ((Integer)entry.getValue()).intValue();
/*  77 */       if (suitCurrentOccupationOnly)
/*     */       {
/*  79 */         SAvatarFrameCfg avatarFrameCfg = SAvatarFrameCfg.get(avatarFrameId);
/*  80 */         if ((avatarFrameCfg == null) || (
/*     */         
/*  82 */           (avatarFrameCfg.factionLimit != 0) && (currentOccupationId != avatarFrameCfg.factionLimit))) {}
/*     */ 
/*     */       }
/*  85 */       else if ((expireTime == 0) || (expireTime > now)) {
/*  86 */         count++;
/*     */       } }
/*  88 */     return count;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static int removeAvatarFrameByItem(long roleId, int avatarFrameItemId)
/*     */   {
/* 100 */     return AvatarFrameManager.removeAvatarFrameByItem(roleId, avatarFrameItemId);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\avatar\frame\AvatarFrameInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */