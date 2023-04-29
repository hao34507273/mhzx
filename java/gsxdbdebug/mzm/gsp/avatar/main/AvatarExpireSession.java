/*     */ package mzm.gsp.avatar.main;
/*     */ 
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.avatar.event.OwnedAvatarCountChangedArg.Reason;
/*     */ import mzm.gsp.timer.main.Session;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import xbean.RoleAvatar;
/*     */ import xbean.RoleAvatarSessionInfo;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class AvatarExpireSession
/*     */   extends Session
/*     */ {
/*     */   private final long roleId;
/*     */   private final int avatarId;
/*     */   
/*     */   private AvatarExpireSession(long interval, long roleId, int avatarId)
/*     */   {
/*  22 */     super(interval, roleId);
/*  23 */     this.roleId = roleId;
/*  24 */     this.avatarId = avatarId;
/*     */   }
/*     */   
/*     */ 
/*     */   protected void onTimeOut()
/*     */   {
/*  30 */     new PNotifyExpiredAvatar(null).execute();
/*     */   }
/*     */   
/*     */   private class PNotifyExpiredAvatar
/*     */     extends LogicProcedure
/*     */   {
/*     */     private PNotifyExpiredAvatar() {}
/*     */     
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/*  41 */       if (!AvatarManager.isEnable()) {
/*  42 */         return false;
/*     */       }
/*  44 */       RoleAvatar xRoleAvatar = AvatarManager.getRoleAvatar(AvatarExpireSession.this.roleId, true);
/*  45 */       RoleAvatarSessionInfo xSessionInfo = AvatarManager.getRoleAvatarSessionInfo(AvatarExpireSession.this.roleId, true);
/*  46 */       if ((xRoleAvatar == null) || (xSessionInfo == null)) {
/*  47 */         return false;
/*     */       }
/*  49 */       Integer expireTime = (Integer)xRoleAvatar.get_avatars().remove(Integer.valueOf(AvatarExpireSession.this.avatarId));
/*  50 */       if (expireTime == null) {
/*  51 */         return false;
/*     */       }
/*  53 */       xSessionInfo.get_expire_sessions().remove(Integer.valueOf(AvatarExpireSession.this.avatarId));
/*     */       
/*     */ 
/*  56 */       if (xRoleAvatar.get_current_avatar() == AvatarExpireSession.this.avatarId)
/*     */       {
/*  58 */         int newAvatarId = AvatarManager.getRoleDefaultAvatarId(AvatarExpireSession.this.roleId);
/*  59 */         xRoleAvatar.set_current_avatar(newAvatarId);
/*  60 */         AvatarManager.triggerCurrentAvatarChangeEvent(AvatarExpireSession.this.roleId, 1);
/*     */       }
/*     */       
/*     */ 
/*  64 */       if (xRoleAvatar.get_active_avatar() == AvatarExpireSession.this.avatarId)
/*     */       {
/*  66 */         xRoleAvatar.set_active_avatar(0);
/*  67 */         AvatarManager.triggerActivatedAvatarChangeEvent(AvatarExpireSession.this.roleId, 1);
/*     */       }
/*     */       
/*  70 */       AvatarManager.notifyExpiredAvatars(AvatarExpireSession.this.roleId, xRoleAvatar.get_current_avatar(), xRoleAvatar.get_active_avatar(), AvatarExpireSession.this.avatarId, expireTime.intValue());
/*     */       
/*  72 */       AvatarManager.sendAvatarExpireMail(AvatarExpireSession.this.roleId, AvatarExpireSession.this.avatarId, expireTime.intValue());
/*  73 */       AvatarManager.triggerOwnedAvatarCountChangedEvent(AvatarExpireSession.this.roleId, OwnedAvatarCountChangedArg.Reason.AVATAR_EXPIRED);
/*  74 */       AvatarManager.tlogAvatarExpired(AvatarExpireSession.this.roleId, AvatarExpireSession.this.avatarId, expireTime.intValue());
/*  75 */       AvatarManager.info("AvatarExpireSession.PNotifyExpiredAvatar.processImp()@done|roleid=%d|avatar_cfgid=%d", new Object[] { Long.valueOf(AvatarExpireSession.this.roleId), Integer.valueOf(AvatarExpireSession.this.avatarId) });
/*     */       
/*  77 */       return true;
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static void startSession(long roleId, int avatarId, int expireTime)
/*     */   {
/*  86 */     long interval = expireTime - DateTimeUtils.getCurrTimeInMillis() / 1000L;
/*  87 */     if (interval <= 0L) {
/*  88 */       return;
/*     */     }
/*  90 */     RoleAvatarSessionInfo xRoleAvatarSessionInfo = AvatarManager.getOrCreateRoleAvatarSessionInfo(roleId);
/*  91 */     stopSession(roleId, avatarId, xRoleAvatarSessionInfo);
/*     */     
/*  93 */     AvatarExpireSession session = new AvatarExpireSession(interval, roleId, avatarId);
/*  94 */     xRoleAvatarSessionInfo.get_expire_sessions().put(Integer.valueOf(avatarId), Long.valueOf(session.getSessionId()));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void startSessions(long roleId, RoleAvatar xRoleAvatar, RoleAvatarSessionInfo xSessionInfo)
/*     */   {
/* 103 */     for (Map.Entry<Integer, Integer> e : xRoleAvatar.get_avatars().entrySet())
/*     */     {
/* 105 */       int avatarId = ((Integer)e.getKey()).intValue();
/* 106 */       int expireTime = ((Integer)e.getValue()).intValue();
/* 107 */       if (expireTime != 0)
/*     */       {
/* 109 */         long interval = expireTime - DateTimeUtils.getCurrTimeInMillis() / 1000L;
/* 110 */         if (interval > 0L)
/*     */         {
/* 112 */           stopSession(roleId, avatarId, xSessionInfo);
/* 113 */           AvatarExpireSession session = new AvatarExpireSession(interval, roleId, avatarId);
/* 114 */           xSessionInfo.get_expire_sessions().put(Integer.valueOf(avatarId), Long.valueOf(session.getSessionId()));
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static void stopSession(long roleId, int avatarId, RoleAvatarSessionInfo xSessionInfo)
/*     */   {
/* 125 */     Long sessionId = (Long)xSessionInfo.get_expire_sessions().remove(Integer.valueOf(avatarId));
/* 126 */     if (sessionId != null) {
/* 127 */       Session.removeSession(sessionId.longValue(), roleId);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   static void stopSessions(long roleId, RoleAvatarSessionInfo xSessionInfo)
/*     */   {
/* 135 */     for (Long sessionId : xSessionInfo.get_expire_sessions().values())
/* 136 */       Session.removeSession(sessionId.longValue(), roleId);
/* 137 */     xSessionInfo.get_expire_sessions().clear();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\avatar\main\AvatarExpireSession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */