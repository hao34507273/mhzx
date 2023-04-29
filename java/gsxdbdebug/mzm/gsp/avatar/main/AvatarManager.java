/*     */ package mzm.gsp.avatar.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.HashSet;
/*     */ import java.util.LinkedList;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.avatar.AvatarInfo;
/*     */ import mzm.gsp.avatar.SActivateAvatarFail;
/*     */ import mzm.gsp.avatar.SNotifyExpiredAvatar;
/*     */ import mzm.gsp.avatar.SNotifyExtendedAvatar;
/*     */ import mzm.gsp.avatar.SNotifyNewAvatar;
/*     */ import mzm.gsp.avatar.SSyncAvatarInfo;
/*     */ import mzm.gsp.avatar.confbean.PropertyBean;
/*     */ import mzm.gsp.avatar.confbean.SAvatarCfg;
/*     */ import mzm.gsp.avatar.confbean.SAvatarConsts;
/*     */ import mzm.gsp.avatar.event.ActivateAvatarArg;
/*     */ import mzm.gsp.avatar.event.OwnedAvatarCountChangedArg.Reason;
/*     */ import mzm.gsp.avatar.event.SetAvatarArg;
/*     */ import mzm.gsp.item.confbean.SAvatarUnlockCfg;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.OccupationManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.role.main.RoleOneByOneManager;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.RoleAvatar;
/*     */ import xbean.RoleAvatarSessionInfo;
/*     */ import xtable.Role2avatar;
/*     */ import xtable.Role2avatarsession;
/*     */ 
/*     */ class AvatarManager
/*     */ {
/*     */   private static final String TLOG_UNLOCK = "UnlockAvatar";
/*     */   private static final String TLOG_EXTEND = "ExtendAvatar";
/*     */   private static final String TLOG_EXPIRED = "AvatarExpired";
/*     */   private static final String TLOG_USE = "UseAvatar";
/*     */   private static final String TLOG_ACTIVATE = "ActivateAvatar";
/*     */   private static final String TLOG_REMOVE = "RemoveAvatar";
/*     */   
/*     */   static boolean isEnable()
/*     */   {
/*  46 */     return mzm.gsp.open.main.OpenInterface.getOpenStatus(314);
/*     */   }
/*     */   
/*     */ 
/*     */   static boolean checkRoleLevel(long roleId)
/*     */   {
/*  52 */     return RoleInterface.getLevel(roleId) >= SAvatarConsts.getInstance().OPEN_LEVEL;
/*     */   }
/*     */   
/*     */ 
/*     */   private static void tlog(long roleId, String event, Object... args)
/*     */   {
/*  58 */     String userId = RoleInterface.getUserId(roleId);
/*  59 */     if (userId == null)
/*  60 */       return;
/*  61 */     List<Object> list = new ArrayList();
/*  62 */     list.add(mzm.gsp.GameServerInfoManager.getHostIP());
/*  63 */     list.add(userId);
/*  64 */     list.add(Long.valueOf(roleId));
/*  65 */     list.add(Integer.valueOf(RoleInterface.getLevel(roleId)));
/*  66 */     Collections.addAll(list, args);
/*  67 */     mzm.gsp.tlog.TLogManager.getInstance().addLog(userId, event, list.toArray());
/*     */   }
/*     */   
/*     */   static void tlogUnlockAvatar(long roleId, int avatarId, int expireTime)
/*     */   {
/*  72 */     tlog(roleId, "UnlockAvatar", new Object[] { Integer.valueOf(avatarId), Integer.valueOf(expireTime) });
/*     */   }
/*     */   
/*     */   static void tlogExtendAvatar(long roleId, int avatarId, int expireTime)
/*     */   {
/*  77 */     tlog(roleId, "ExtendAvatar", new Object[] { Integer.valueOf(avatarId), Integer.valueOf(expireTime) });
/*     */   }
/*     */   
/*     */   static void tlogAvatarExpired(long roleId, int avatarId, int expireTime)
/*     */   {
/*  82 */     tlog(roleId, "AvatarExpired", new Object[] { Integer.valueOf(avatarId), Integer.valueOf(expireTime) });
/*     */   }
/*     */   
/*     */   static void tlogUseAvatar(long roleId, int oldAvatarId, int newAvatarId)
/*     */   {
/*  87 */     tlog(roleId, "UseAvatar", new Object[] { Integer.valueOf(oldAvatarId), Integer.valueOf(newAvatarId) });
/*     */   }
/*     */   
/*     */   static void tlogActivateAvatar(long roleId, int oldAvatarId, int newAvatarId)
/*     */   {
/*  92 */     tlog(roleId, "ActivateAvatar", new Object[] { Integer.valueOf(oldAvatarId), Integer.valueOf(newAvatarId) });
/*     */   }
/*     */   
/*     */   static void tlogRemoveAvatar(long roleId, int avatarId, int duration)
/*     */   {
/*  97 */     tlog(roleId, "RemoveAvatar", new Object[] { Integer.valueOf(avatarId), Integer.valueOf(duration) });
/*     */   }
/*     */   
/*     */ 
/* 101 */   private static Logger logger = Logger.getLogger("avatar");
/*     */   
/*     */   static void info(String str, Object... args) {
/* 104 */     logger.info(String.format("[avatar]" + str, args));
/*     */   }
/*     */   
/*     */   static void error(String str, Object... args) {
/* 108 */     logger.error(String.format("[avatar]" + str, args));
/*     */   }
/*     */   
/*     */ 
/*     */   static void syncAvatarInfo(long roleId, RoleAvatar xRoleAvatar)
/*     */   {
/* 114 */     SSyncAvatarInfo protocol = new SSyncAvatarInfo();
/* 115 */     protocol.current_avatar = xRoleAvatar.get_current_avatar();
/* 116 */     protocol.active_avatar = xRoleAvatar.get_active_avatar();
/* 117 */     for (Map.Entry<Integer, Integer> e : xRoleAvatar.get_avatars().entrySet())
/*     */     {
/* 119 */       if (canUseAvatar(roleId, ((Integer)e.getKey()).intValue()))
/*     */       {
/* 121 */         AvatarInfo avatarInfo = new AvatarInfo();
/* 122 */         avatarInfo.avatar = ((Integer)e.getKey()).intValue();
/* 123 */         avatarInfo.expire_time = ((Integer)e.getValue()).intValue();
/* 124 */         protocol.unlocked_avatars.add(avatarInfo);
/*     */       }
/*     */     }
/* 127 */     OnlineManager.getInstance().send(roleId, protocol);
/*     */   }
/*     */   
/*     */   static void notifyNewAvatar(long roleId, int avatarId, int expireTime) {
/* 131 */     SNotifyNewAvatar protocol = new SNotifyNewAvatar();
/* 132 */     AvatarInfo avatarInfo = new AvatarInfo();
/* 133 */     avatarInfo.avatar = avatarId;
/* 134 */     avatarInfo.expire_time = expireTime;
/* 135 */     protocol.new_avatars.addAll(Collections.singletonList(avatarInfo));
/* 136 */     OnlineManager.getInstance().send(roleId, protocol);
/*     */   }
/*     */   
/*     */   static void notifyExtendedAvatars(long roleId, int avatarId, int expireTime) {
/* 140 */     SNotifyExtendedAvatar protocol = new SNotifyExtendedAvatar();
/* 141 */     AvatarInfo avatarInfo = new AvatarInfo();
/* 142 */     avatarInfo.avatar = avatarId;
/* 143 */     avatarInfo.expire_time = expireTime;
/* 144 */     protocol.extended_avatars.addAll(Collections.singletonList(avatarInfo));
/* 145 */     OnlineManager.getInstance().send(roleId, protocol);
/*     */   }
/*     */   
/*     */   static void notifyExpiredAvatars(long roleId, int currentAvatarId, int activeAvatarId, int expiredAvatarId, int expireTime)
/*     */   {
/* 150 */     SNotifyExpiredAvatar protocol = new SNotifyExpiredAvatar();
/* 151 */     protocol.current_avatar = currentAvatarId;
/* 152 */     protocol.active_avatar = activeAvatarId;
/* 153 */     AvatarInfo avatarInfo = new AvatarInfo();
/* 154 */     avatarInfo.avatar = expiredAvatarId;
/* 155 */     avatarInfo.expire_time = expireTime;
/* 156 */     protocol.expired_avatars.addAll(Collections.singletonList(avatarInfo));
/* 157 */     OnlineManager.getInstance().send(roleId, protocol);
/*     */   }
/*     */   
/*     */   static void sendSetAvatarSuccess(long roleId, int avatarId) {
/* 161 */     mzm.gsp.avatar.SSetAvatarSuccess protocol = new mzm.gsp.avatar.SSetAvatarSuccess();
/* 162 */     protocol.avatar = avatarId;
/* 163 */     OnlineManager.getInstance().send(roleId, protocol);
/*     */   }
/*     */   
/*     */   static void sendSetAvatarFailAtOnce(long roleId, int reason) {
/* 167 */     mzm.gsp.avatar.SSetAvatarFail protocol = new mzm.gsp.avatar.SSetAvatarFail();
/* 168 */     protocol.retcode = reason;
/* 169 */     OnlineManager.getInstance().sendAtOnce(roleId, protocol);
/*     */   }
/*     */   
/*     */   static void sendActivateAvatarSuccess(long roleId, int avatarId) {
/* 173 */     mzm.gsp.avatar.SActivateAvatarSuccess protocol = new mzm.gsp.avatar.SActivateAvatarSuccess();
/* 174 */     protocol.avatar = avatarId;
/* 175 */     OnlineManager.getInstance().send(roleId, protocol);
/*     */   }
/*     */   
/*     */   static void sendActivateAvatarFailAtOnce(long roleId, int reason) {
/* 179 */     SActivateAvatarFail protocol = new SActivateAvatarFail();
/* 180 */     protocol.retcode = reason;
/* 181 */     OnlineManager.getInstance().sendAtOnce(roleId, protocol);
/*     */   }
/*     */   
/*     */   static void sendUseUnlockItemFailAtOnce(long roleId, int reason) {
/* 185 */     mzm.gsp.avatar.SUseUnlockItemFail protocol = new mzm.gsp.avatar.SUseUnlockItemFail();
/* 186 */     protocol.retcode = reason;
/* 187 */     OnlineManager.getInstance().sendAtOnce(roleId, protocol);
/*     */   }
/*     */   
/*     */ 
/*     */   static void triggerCurrentAvatarChangeEvent(long roleId, int changeReason)
/*     */   {
/* 193 */     SetAvatarArg arg = new SetAvatarArg(roleId, changeReason);
/* 194 */     TriggerEventsManger.getInstance().triggerEvent(new mzm.gsp.avatar.event.SetAvatar(), arg, RoleOneByOneManager.getInstance().getTaskOneByOne(Long.valueOf(roleId)));
/*     */   }
/*     */   
/*     */   static void triggerActivatedAvatarChangeEvent(long roleId, int changeReason)
/*     */   {
/* 199 */     ActivateAvatarArg arg = new ActivateAvatarArg(roleId, changeReason);
/* 200 */     TriggerEventsManger.getInstance().triggerEvent(new mzm.gsp.avatar.event.ActivateAvatar(), arg, RoleOneByOneManager.getInstance().getTaskOneByOne(Long.valueOf(roleId)));
/*     */   }
/*     */   
/*     */   static void triggerOwnedAvatarCountChangedEvent(long roleId, OwnedAvatarCountChangedArg.Reason reason)
/*     */   {
/* 205 */     mzm.gsp.avatar.event.OwnedAvatarCountChangedArg arg = new mzm.gsp.avatar.event.OwnedAvatarCountChangedArg(roleId, reason);
/* 206 */     TriggerEventsManger.getInstance().triggerEvent(new mzm.gsp.avatar.event.OwnedAvatarCountChanged(), arg, RoleOneByOneManager.getInstance().getTaskOneByOne(Long.valueOf(roleId)));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static RoleAvatar getRoleAvatar(long roleId, boolean holdRolelock)
/*     */   {
/* 215 */     return holdRolelock ? Role2avatar.get(Long.valueOf(roleId)) : Role2avatar.select(Long.valueOf(roleId));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static RoleAvatar getOrCreateRoleAvatar(long roleId)
/*     */   {
/* 223 */     RoleAvatar xRoleAvatar = Role2avatar.get(Long.valueOf(roleId));
/* 224 */     if (xRoleAvatar == null)
/*     */     {
/*     */ 
/* 227 */       int defaultAvatarId = getRoleDefaultAvatarId(roleId);
/* 228 */       xRoleAvatar = xbean.Pod.newRoleAvatar();
/* 229 */       xRoleAvatar.set_current_avatar(defaultAvatarId);
/* 230 */       xRoleAvatar.set_active_avatar(0);
/* 231 */       xRoleAvatar.get_avatars().put(Integer.valueOf(defaultAvatarId), Integer.valueOf(0));
/* 232 */       Role2avatar.insert(Long.valueOf(roleId), xRoleAvatar);
/*     */     }
/* 234 */     return xRoleAvatar;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static RoleAvatarSessionInfo getRoleAvatarSessionInfo(long roleId, boolean holdRolelock)
/*     */   {
/* 242 */     return holdRolelock ? Role2avatarsession.get(Long.valueOf(roleId)) : Role2avatarsession.select(Long.valueOf(roleId));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static RoleAvatarSessionInfo getOrCreateRoleAvatarSessionInfo(long roleId)
/*     */   {
/* 250 */     RoleAvatarSessionInfo xSessionInfo = Role2avatarsession.get(Long.valueOf(roleId));
/* 251 */     if (xSessionInfo == null)
/*     */     {
/* 253 */       xSessionInfo = xbean.Pod.newRoleAvatarSessionInfo();
/* 254 */       Role2avatarsession.insert(Long.valueOf(roleId), xSessionInfo);
/*     */     }
/* 256 */     return xSessionInfo;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static int getRoleDefaultAvatarId(long roleId)
/*     */   {
/* 264 */     return getDefaultAvatarId(RoleInterface.getOccupationId(roleId), RoleInterface.getGender(roleId));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static int getDefaultAvatarId(int faction, int gender)
/*     */   {
/* 274 */     return OccupationManager.getInstance().getOccupationDefaultAvatarId(faction, gender);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static Map<Integer, Integer> getAvatarProperties(int avatarId)
/*     */   {
/* 282 */     Map<Integer, Integer> map = new java.util.HashMap();
/* 283 */     if (avatarId != 0)
/*     */     {
/* 285 */       SAvatarCfg sAvatarCfg = SAvatarCfg.get(avatarId);
/* 286 */       if (sAvatarCfg == null) {
/* 287 */         return map;
/*     */       }
/* 289 */       List<PropertyBean> properties = sAvatarCfg.properties;
/* 290 */       for (PropertyBean i : properties)
/* 291 */         if (i.property != 0)
/* 292 */           map.put(Integer.valueOf(i.property), Integer.valueOf(i.value));
/*     */     }
/* 294 */     return map;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static int getAvatarExpireTimeFromNow(int itemId)
/*     */   {
/* 302 */     SAvatarUnlockCfg unlockCfg = SAvatarUnlockCfg.get(itemId);
/* 303 */     if (unlockCfg == null) {
/* 304 */       return -1;
/*     */     }
/* 306 */     int duration = unlockCfg.duration;
/* 307 */     return duration == 0 ? 0 : (int)(DateTimeUtils.getCurrTimeInMillis() / 1000L + duration * 3600L);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean isExpired(int expireTime)
/*     */   {
/* 317 */     return (expireTime != 0) && (expireTime <= (int)(DateTimeUtils.getCurrTimeInMillis() / 1000L));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static void clearUnavailableAvatars(long roleId, RoleAvatar xRoleAvatar)
/*     */   {
/* 325 */     clearUnavailableAvatars(roleId, RoleInterface.getOccupationId(roleId), xRoleAvatar);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static void clearUnavailableAvatars(long roleId, int factionId, RoleAvatar xRoleAvatar)
/*     */   {
/* 333 */     int gender = RoleInterface.getGender(roleId);
/* 334 */     HashSet<Integer> availableAvatars = new HashSet();
/* 335 */     HashSet<Integer> expiredAvatars = new HashSet();
/* 336 */     boolean hasUnavailableAvatarForNewFaction = false;
/* 337 */     for (Map.Entry<Integer, Integer> entry : xRoleAvatar.get_avatars().entrySet())
/*     */     {
/*     */ 
/* 340 */       if (isExpired(((Integer)entry.getValue()).intValue()))
/*     */       {
/* 342 */         expiredAvatars.add(entry.getKey());
/* 343 */         AvatarExpireSession.removeSession(roleId, ((Integer)entry.getKey()).intValue());
/* 344 */         tlogAvatarExpired(roleId, ((Integer)entry.getKey()).intValue(), ((Integer)entry.getValue()).intValue());
/*     */ 
/*     */ 
/*     */ 
/*     */       }
/* 349 */       else if (!canUseAvatar(factionId, gender, ((Integer)entry.getKey()).intValue()))
/*     */       {
/* 351 */         hasUnavailableAvatarForNewFaction = true;
/* 352 */         AvatarExpireSession.removeSession(roleId, ((Integer)entry.getKey()).intValue());
/*     */       }
/*     */       else
/*     */       {
/* 356 */         availableAvatars.add(entry.getKey());
/*     */       } }
/* 358 */     for (Integer expiredAvatarId : expiredAvatars)
/*     */     {
/* 360 */       Integer expireTime = (Integer)xRoleAvatar.get_avatars().remove(expiredAvatarId);
/* 361 */       if (expireTime != null) {
/* 362 */         sendAvatarExpireMail(roleId, expiredAvatarId.intValue(), expireTime.intValue());
/*     */       }
/*     */     }
/*     */     
/* 366 */     int currentAvatarId = xRoleAvatar.get_current_avatar();
/* 367 */     if (!availableAvatars.contains(Integer.valueOf(currentAvatarId)))
/*     */     {
/* 369 */       int newAvatarId = getDefaultAvatarId(factionId, gender);
/* 370 */       xRoleAvatar.set_current_avatar(newAvatarId);
/* 371 */       if (expiredAvatars.contains(Integer.valueOf(currentAvatarId))) {
/* 372 */         triggerCurrentAvatarChangeEvent(roleId, 1);
/*     */       } else {
/* 374 */         triggerCurrentAvatarChangeEvent(roleId, 2);
/*     */       }
/*     */     }
/*     */     
/* 378 */     int activeAvatarId = xRoleAvatar.get_active_avatar();
/* 379 */     if (activeAvatarId != 0)
/*     */     {
/* 381 */       if (!availableAvatars.contains(Integer.valueOf(activeAvatarId)))
/*     */       {
/* 383 */         xRoleAvatar.set_active_avatar(0);
/* 384 */         if (expiredAvatars.contains(Integer.valueOf(activeAvatarId))) {
/* 385 */           triggerActivatedAvatarChangeEvent(roleId, 1);
/*     */         } else {
/* 387 */           triggerActivatedAvatarChangeEvent(roleId, 2);
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 392 */     if (!expiredAvatars.isEmpty()) {
/* 393 */       triggerOwnedAvatarCountChangedEvent(roleId, OwnedAvatarCountChangedArg.Reason.AVATAR_EXPIRED);
/* 394 */     } else if (hasUnavailableAvatarForNewFaction) {
/* 395 */       triggerOwnedAvatarCountChangedEvent(roleId, OwnedAvatarCountChangedArg.Reason.OCCUPATION_CHANGED);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   static boolean canUseAvatar(long roleId, int avatarId)
/*     */   {
/* 403 */     return canUseAvatar(RoleInterface.getOccupationId(roleId), RoleInterface.getGender(roleId), avatarId);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private static boolean canUseAvatar(int factionId, int gender, int avatarId)
/*     */   {
/* 411 */     SAvatarCfg avatarCfg = SAvatarCfg.get(avatarId);
/* 412 */     if (avatarCfg == null) {
/* 413 */       return false;
/*     */     }
/* 415 */     if ((avatarCfg.factionLimit != 0) && (avatarCfg.factionLimit != factionId)) {
/* 416 */       return false;
/*     */     }
/* 418 */     if ((avatarCfg.genderLimit != 0) && (avatarCfg.genderLimit != gender)) {
/* 419 */       return false;
/*     */     }
/* 421 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static void sendAvatarExpireMail(long roleId, int avatarId, int expireTime)
/*     */   {
/* 429 */     SAvatarCfg avatarCfg = SAvatarCfg.get(avatarId);
/* 430 */     if (avatarCfg == null)
/* 431 */       return;
/* 432 */     int mailId = SAvatarConsts.getInstance().EXPIRE_MAIL_ID;
/* 433 */     mzm.gsp.tlog.TLogArg tLogArg = new mzm.gsp.tlog.TLogArg(mzm.gsp.tlog.LogReason.AVATAR_EXPIRED);
/* 434 */     ArrayList<String> contentArgs = new ArrayList();
/* 435 */     contentArgs.add(avatarCfg.name);
/* 436 */     StringBuilder sb = new StringBuilder(DateTimeUtils.formatTimestamp(expireTime * 1000L));
/* 437 */     contentArgs.add(sb.substring(0, 4));
/* 438 */     contentArgs.add(sb.substring(4, 6));
/* 439 */     contentArgs.add(sb.substring(6, 8));
/* 440 */     contentArgs.add(sb.substring(8, 10));
/* 441 */     contentArgs.add(sb.substring(10, 12));
/* 442 */     contentArgs.add(sb.substring(12, 14));
/* 443 */     mzm.gsp.mail.main.MailInterface.asynBuildAndSendMail(roleId, mailId, null, contentArgs, tLogArg);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static int removeAvatarByItem(long roleId, int avatarItemId)
/*     */   {
/* 453 */     SAvatarUnlockCfg avatarUnlockCfg = SAvatarUnlockCfg.get(avatarItemId);
/* 454 */     if (avatarUnlockCfg == null)
/*     */     {
/* 456 */       return -1;
/*     */     }
/* 458 */     RoleAvatar xRoleAvatar = getRoleAvatar(roleId, true);
/* 459 */     if (xRoleAvatar == null)
/*     */     {
/* 461 */       return -1;
/*     */     }
/* 463 */     Integer oldExpireTime = (Integer)xRoleAvatar.get_avatars().get(Integer.valueOf(avatarUnlockCfg.avatarId));
/* 464 */     if (oldExpireTime == null)
/*     */     {
/* 466 */       return -1;
/*     */     }
/*     */     boolean changeExpireTimeOnly;
/*     */     boolean changeExpireTimeOnly;
/* 470 */     if (avatarUnlockCfg.duration != 0)
/*     */     {
/* 472 */       int now = (int)(DateTimeUtils.getCurrTimeInMillis() / 1000L);
/* 473 */       int newExpireTime = oldExpireTime.intValue() - (int)(avatarUnlockCfg.duration * 3600L);
/* 474 */       changeExpireTimeOnly = newExpireTime > now;
/*     */     }
/*     */     else
/*     */     {
/* 478 */       changeExpireTimeOnly = false;
/*     */     }
/*     */     
/* 481 */     if (changeExpireTimeOnly)
/*     */     {
/* 483 */       int newExpireTime = oldExpireTime.intValue() - (int)(avatarUnlockCfg.duration * 3600L);
/* 484 */       xRoleAvatar.get_avatars().put(Integer.valueOf(avatarUnlockCfg.avatarId), Integer.valueOf(newExpireTime));
/* 485 */       AvatarExpireSession.startSession(roleId, avatarUnlockCfg.avatarId, newExpireTime);
/*     */     }
/*     */     else
/*     */     {
/* 489 */       xRoleAvatar.get_avatars().remove(Integer.valueOf(avatarUnlockCfg.avatarId));
/* 490 */       triggerOwnedAvatarCountChangedEvent(roleId, OwnedAvatarCountChangedArg.Reason.REMOVED_BY_COMMAND);
/* 491 */       RoleAvatarSessionInfo xSessionInfo = getRoleAvatarSessionInfo(roleId, true);
/* 492 */       if (xSessionInfo != null)
/*     */       {
/* 494 */         AvatarExpireSession.stopSession(roleId, avatarUnlockCfg.avatarId, xSessionInfo);
/*     */       }
/*     */       
/* 497 */       int defaultAvatarId = getRoleDefaultAvatarId(roleId);
/* 498 */       if (xRoleAvatar.get_current_avatar() == avatarUnlockCfg.avatarId)
/*     */       {
/* 500 */         xRoleAvatar.set_current_avatar(defaultAvatarId);
/* 501 */         triggerCurrentAvatarChangeEvent(roleId, 4);
/*     */       }
/* 503 */       if (xRoleAvatar.get_active_avatar() == avatarUnlockCfg.avatarId)
/*     */       {
/* 505 */         xRoleAvatar.set_active_avatar(defaultAvatarId);
/* 506 */         triggerActivatedAvatarChangeEvent(roleId, 4);
/*     */       }
/*     */     }
/*     */     
/* 510 */     int cutDuration = changeExpireTimeOnly ? avatarUnlockCfg.duration : 0;
/* 511 */     tlogRemoveAvatar(roleId, avatarUnlockCfg.avatarId, cutDuration);
/* 512 */     OnlineManager.getInstance().forceReconnect(roleId);
/* 513 */     return cutDuration;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\avatar\main\AvatarManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */