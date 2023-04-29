/*     */ package mzm.gsp.avatar.frame;
/*     */ 
/*     */ import java.util.Map;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.avatar.confbean.SAvatarFrameConsts;
/*     */ import mzm.gsp.avatar.event.AvatarFrameChanged;
/*     */ import mzm.gsp.avatar.event.AvatarFrameChangedArg;
/*     */ import mzm.gsp.avatar.event.AvatarFrameChangedArg.Reason;
/*     */ import mzm.gsp.avatar.event.OwnedAvatarFrameCountChanged;
/*     */ import mzm.gsp.avatar.event.OwnedAvatarFrameCountChangedArg;
/*     */ import mzm.gsp.avatar.event.OwnedAvatarFrameCountChangedArg.Reason;
/*     */ import mzm.gsp.item.confbean.SAvatarFrameItemCfg;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.role.main.RoleOneByOneManager;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import xbean.Pod;
/*     */ import xbean.RoleAvatarFrame;
/*     */ import xbean.RoleAvatarFrameSessionInfo;
/*     */ import xtable.Role2avatar_frame;
/*     */ import xtable.Role2avatar_frame_session;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class AvatarFrameManager
/*     */ {
/*     */   static boolean isNotEnabled()
/*     */   {
/*  33 */     return !OpenInterface.getOpenStatus(456);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean inStatusCannotDoRelatedActions(long roleId)
/*     */   {
/*  41 */     return !RoleStatusInterface.checkCanSetStatus(roleId, 1751, true);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean notMeetRequiredLevel(long roleId)
/*     */   {
/*  49 */     return RoleInterface.getLevel(roleId) < SAvatarFrameConsts.getInstance().OPEN_LEVEL;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static RoleAvatarFrame getRoleAvatarFrame(long roleId, boolean holdLock)
/*     */   {
/*  57 */     return holdLock ? Role2avatar_frame.get(Long.valueOf(roleId)) : Role2avatar_frame.select(Long.valueOf(roleId));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static RoleAvatarFrame getOrCreateRoleAvatarFrame(long roleId)
/*     */   {
/*  66 */     RoleAvatarFrame xRoleAvatarFrame = getRoleAvatarFrame(roleId, true);
/*  67 */     if (xRoleAvatarFrame != null)
/*  68 */       return xRoleAvatarFrame;
/*  69 */     xRoleAvatarFrame = Pod.newRoleAvatarFrame();
/*  70 */     int defaultAvatarFrameId = SAvatarFrameConsts.getInstance().DEFAULT_AVATAR_FRAME_ID;
/*  71 */     xRoleAvatarFrame.setCurrent_avatar_frame(defaultAvatarFrameId);
/*  72 */     xRoleAvatarFrame.getAvatar_frames().put(Integer.valueOf(defaultAvatarFrameId), Integer.valueOf(0));
/*  73 */     Role2avatar_frame.add(Long.valueOf(roleId), xRoleAvatarFrame);
/*  74 */     return xRoleAvatarFrame;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static Map<Integer, Long> getRoleAvatarFrameSessionMap(long roleId, boolean holdLock)
/*     */   {
/*  82 */     RoleAvatarFrameSessionInfo xSessionInfo = holdLock ? Role2avatar_frame_session.get(Long.valueOf(roleId)) : Role2avatar_frame_session.select(Long.valueOf(roleId));
/*     */     
/*  84 */     return xSessionInfo == null ? null : xSessionInfo.getSessions();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static Map<Integer, Long> getOrCreateRoleAvatarFrameSessionMap(long roleId)
/*     */   {
/*  92 */     Map<Integer, Long> sessionMap = getRoleAvatarFrameSessionMap(roleId, true);
/*  93 */     if (sessionMap != null)
/*  94 */       return sessionMap;
/*  95 */     RoleAvatarFrameSessionInfo xSessionInfo = Pod.newRoleAvatarFrameSessionInfo();
/*  96 */     Role2avatar_frame_session.add(Long.valueOf(roleId), xSessionInfo);
/*  97 */     return xSessionInfo.getSessions();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static void triggerAvatarFrameChanged(long roleId, int avatarFrameId, AvatarFrameChangedArg.Reason reason)
/*     */   {
/* 105 */     AvatarFrameChangedArg arg = new AvatarFrameChangedArg(roleId, avatarFrameId, reason);
/* 106 */     TriggerEventsManger.getInstance().triggerEvent(new AvatarFrameChanged(), arg, RoleOneByOneManager.getInstance().getTaskOneByOne(Long.valueOf(roleId)));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void triggerOwnedAvatarFrameCountChanged(long roleId, OwnedAvatarFrameCountChangedArg.Reason reason)
/*     */   {
/* 115 */     OwnedAvatarFrameCountChangedArg arg = new OwnedAvatarFrameCountChangedArg(roleId, reason);
/* 116 */     TriggerEventsManger.getInstance().triggerEvent(new OwnedAvatarFrameCountChanged(), arg, RoleOneByOneManager.getInstance().getTaskOneByOne(Long.valueOf(roleId)));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static int removeAvatarFrameByItem(long roleId, int avatarFrameItemId)
/*     */   {
/* 127 */     SAvatarFrameItemCfg avatarFrameItemCfg = SAvatarFrameItemCfg.get(avatarFrameItemId);
/* 128 */     if (avatarFrameItemCfg == null)
/*     */     {
/* 130 */       return -1;
/*     */     }
/* 132 */     RoleAvatarFrame xRoleAvatarFrame = getRoleAvatarFrame(roleId, true);
/* 133 */     if (xRoleAvatarFrame == null)
/*     */     {
/* 135 */       return -1;
/*     */     }
/* 137 */     Integer oldExpireTime = (Integer)xRoleAvatarFrame.getAvatar_frames().get(Integer.valueOf(avatarFrameItemCfg.avatarFrameId));
/* 138 */     if (oldExpireTime == null)
/*     */     {
/* 140 */       return -1;
/*     */     }
/*     */     boolean changeExpireTimeOnly;
/*     */     boolean changeExpireTimeOnly;
/* 144 */     if (avatarFrameItemCfg.duration != 0)
/*     */     {
/* 146 */       int now = (int)(DateTimeUtils.getCurrTimeInMillis() / 1000L);
/* 147 */       int newExpireTime = oldExpireTime.intValue() - (int)(avatarFrameItemCfg.duration * 3600L);
/* 148 */       changeExpireTimeOnly = newExpireTime > now;
/*     */     }
/*     */     else
/*     */     {
/* 152 */       changeExpireTimeOnly = false;
/*     */     }
/*     */     
/* 155 */     if (changeExpireTimeOnly)
/*     */     {
/* 157 */       int newExpireTime = oldExpireTime.intValue() - (int)(avatarFrameItemCfg.duration * 3600L);
/* 158 */       xRoleAvatarFrame.getAvatar_frames().put(Integer.valueOf(avatarFrameItemCfg.avatarFrameId), Integer.valueOf(newExpireTime));
/* 159 */       Map<Integer, Long> xSessionInfo = getOrCreateRoleAvatarFrameSessionMap(roleId);
/* 160 */       AvatarFrameExpireManager.startSession(xSessionInfo, roleId, avatarFrameItemCfg.avatarFrameId, newExpireTime);
/*     */     }
/*     */     else
/*     */     {
/* 164 */       xRoleAvatarFrame.getAvatar_frames().remove(Integer.valueOf(avatarFrameItemCfg.avatarFrameId));
/* 165 */       triggerOwnedAvatarFrameCountChanged(roleId, OwnedAvatarFrameCountChangedArg.Reason.REMOVED_BY_COMMAND);
/*     */       
/* 167 */       if (avatarFrameItemCfg.avatarFrameId == xRoleAvatarFrame.getCurrent_avatar_frame())
/*     */       {
/* 169 */         int defaultAvatarFrameId = SAvatarFrameConsts.getInstance().DEFAULT_AVATAR_FRAME_ID;
/* 170 */         xRoleAvatarFrame.setCurrent_avatar_frame(defaultAvatarFrameId);
/* 171 */         triggerAvatarFrameChanged(roleId, defaultAvatarFrameId, AvatarFrameChangedArg.Reason.REMOVED_BY_COMMAND);
/*     */       }
/*     */     }
/*     */     
/* 175 */     int cutDuration = changeExpireTimeOnly ? avatarFrameItemCfg.duration : 0;
/* 176 */     AvatarFrameLogger.removeAvatarFrame(roleId, avatarFrameItemId, cutDuration);
/* 177 */     OnlineManager.getInstance().forceReconnect(roleId);
/* 178 */     return cutDuration;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\avatar\frame\AvatarFrameManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */