/*     */ package mzm.gsp.avatar.frame;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashSet;
/*     */ import java.util.LinkedList;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.avatar.SNotifyAvatarFrameExpired;
/*     */ import mzm.gsp.avatar.confbean.SAvatarFrameCfg;
/*     */ import mzm.gsp.avatar.confbean.SAvatarFrameConsts;
/*     */ import mzm.gsp.avatar.event.OwnedAvatarFrameCountChangedArg.Reason;
/*     */ import mzm.gsp.mail.main.MailInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.timer.main.Session;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import xbean.RoleAvatarFrame;
/*     */ 
/*     */ class AvatarFrameExpireManager
/*     */ {
/*     */   private static class ExpireSession extends Session
/*     */   {
/*     */     private final long roleId;
/*     */     private final int avatarFrameId;
/*     */     
/*     */     private ExpireSession(long interval, long roleId, int avatarFrameId)
/*     */     {
/*  30 */       super(roleId);
/*  31 */       this.roleId = roleId;
/*  32 */       this.avatarFrameId = avatarFrameId;
/*     */     }
/*     */     
/*     */ 
/*     */     protected void onTimeOut()
/*     */     {
/*  38 */       new mzm.gsp.util.LogicProcedure()
/*     */       {
/*     */         protected boolean processImp()
/*     */           throws Exception
/*     */         {
/*  43 */           RoleAvatarFrame xRoleAvatarFrame = AvatarFrameManager.getRoleAvatarFrame(AvatarFrameExpireManager.ExpireSession.this.roleId, true);
/*  44 */           if (xRoleAvatarFrame == null)
/*  45 */             return false;
/*  46 */           AvatarFrameExpireManager.handleExpiration(xRoleAvatarFrame, AvatarFrameExpireManager.ExpireSession.this.roleId, AvatarFrameExpireManager.ExpireSession.this.avatarFrameId, true);
/*  47 */           Map<Integer, Long> xSessionMap = AvatarFrameManager.getRoleAvatarFrameSessionMap(AvatarFrameExpireManager.ExpireSession.this.roleId, true);
/*  48 */           if (xSessionMap != null)
/*     */           {
/*  50 */             xSessionMap.remove(Integer.valueOf(AvatarFrameExpireManager.ExpireSession.this.avatarFrameId));
/*     */           }
/*  52 */           return true;
/*     */         }
/*     */       }.call();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static void handleExpiration(RoleAvatarFrame xRoleAvatarFrame, long roleId, int avatarFrameId, boolean sendProtocol)
/*     */   {
/*  66 */     int expireTime = ((Integer)xRoleAvatarFrame.getAvatar_frames().remove(Integer.valueOf(avatarFrameId))).intValue();
/*  67 */     AvatarFrameLogger.avatarExpired(roleId, avatarFrameId);
/*     */     
/*  69 */     if (avatarFrameId == xRoleAvatarFrame.getCurrent_avatar_frame())
/*     */     {
/*  71 */       int defaultAvatarFrameId = SAvatarFrameConsts.getInstance().DEFAULT_AVATAR_FRAME_ID;
/*  72 */       xRoleAvatarFrame.setCurrent_avatar_frame(defaultAvatarFrameId);
/*  73 */       AvatarFrameManager.triggerAvatarFrameChanged(roleId, defaultAvatarFrameId, mzm.gsp.avatar.event.AvatarFrameChangedArg.Reason.FRAME_EXPIRED);
/*     */     }
/*     */     
/*  76 */     AvatarFrameManager.triggerOwnedAvatarFrameCountChanged(roleId, OwnedAvatarFrameCountChangedArg.Reason.AVATAR_FRAME_EXPIRED);
/*     */     
/*     */ 
/*  79 */     if (sendProtocol)
/*     */     {
/*  81 */       SNotifyAvatarFrameExpired protocol = new SNotifyAvatarFrameExpired();
/*  82 */       protocol.current_avatar_frame_id = xRoleAvatarFrame.getCurrent_avatar_frame();
/*  83 */       protocol.expired_avatar_frame_ids.add(Integer.valueOf(avatarFrameId));
/*  84 */       OnlineManager.getInstance().send(roleId, protocol);
/*     */     }
/*     */     
/*  87 */     int mailId = SAvatarFrameConsts.getInstance().EXPIRE_MAIL_ID;
/*  88 */     SAvatarFrameCfg cfg = SAvatarFrameCfg.get(avatarFrameId);
/*  89 */     if (cfg == null)
/*  90 */       return;
/*  91 */     StringBuilder expireTimeStr = new StringBuilder(DateTimeUtils.formatTimestamp(expireTime * 1000L));
/*  92 */     List<String> contents = new ArrayList(7);
/*  93 */     contents.add(cfg.name);
/*  94 */     contents.add(expireTimeStr.substring(0, 4));
/*  95 */     contents.add(expireTimeStr.substring(4, 6));
/*  96 */     contents.add(expireTimeStr.substring(6, 8));
/*  97 */     contents.add(expireTimeStr.substring(8, 10));
/*  98 */     contents.add(expireTimeStr.substring(10, 12));
/*  99 */     contents.add(expireTimeStr.substring(12, 14));
/* 100 */     MailInterface.asynBuildAndSendMail(roleId, mailId, null, contents, new TLogArg(mzm.gsp.tlog.LogReason.AVATAR_FRAME_EXPIRED));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void cleanExpiredAvatarFrames(RoleAvatarFrame xRoleAvatarFrame, long roleId)
/*     */   {
/* 109 */     int now = (int)(DateTimeUtils.getCurrTimeInMillis() / 1000L);
/* 110 */     Set<Integer> expiredAvatarFrameIds = new HashSet();
/* 111 */     for (Map.Entry<Integer, Integer> entry : xRoleAvatarFrame.getAvatar_frames().entrySet())
/*     */     {
/* 113 */       if ((((Integer)entry.getValue()).intValue() != 0) && (((Integer)entry.getValue()).intValue() <= now))
/*     */       {
/* 115 */         expiredAvatarFrameIds.add(entry.getKey());
/*     */       }
/*     */     }
/* 118 */     for (Integer expiredAvatarFrameId : expiredAvatarFrameIds)
/*     */     {
/* 120 */       handleExpiration(xRoleAvatarFrame, roleId, expiredAvatarFrameId.intValue(), false);
/*     */     }
/*     */     
/* 123 */     SNotifyAvatarFrameExpired protocol = new SNotifyAvatarFrameExpired();
/* 124 */     protocol.current_avatar_frame_id = xRoleAvatarFrame.getCurrent_avatar_frame();
/* 125 */     protocol.expired_avatar_frame_ids.addAll(expiredAvatarFrameIds);
/* 126 */     OnlineManager.getInstance().send(roleId, protocol);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void startSessions(RoleAvatarFrame xRoleAvatarFrame, Map<Integer, Long> xSessionMap, long roleId)
/*     */   {
/* 136 */     stopSessions(xSessionMap, roleId);
/* 137 */     for (Map.Entry<Integer, Integer> entry : xRoleAvatarFrame.getAvatar_frames().entrySet())
/*     */     {
/* 139 */       if (((Integer)entry.getValue()).intValue() != 0)
/*     */       {
/* 141 */         startSession(xSessionMap, roleId, ((Integer)entry.getKey()).intValue(), ((Integer)entry.getValue()).intValue());
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void stopSessions(Map<Integer, Long> xSessionMap, long roleId)
/*     */   {
/* 152 */     for (Map.Entry<Integer, Long> entry : xSessionMap.entrySet())
/*     */     {
/* 154 */       Session.removeSession(((Long)entry.getValue()).longValue(), roleId);
/*     */     }
/* 156 */     xSessionMap.clear();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void startSession(Map<Integer, Long> xSessionMap, long roleId, int avatarFrameId, int expireTime)
/*     */   {
/* 166 */     int interval = expireTime - (int)(DateTimeUtils.getCurrTimeInMillis() / 1000L);
/* 167 */     if (interval <= 0)
/* 168 */       return;
/* 169 */     stopSession(xSessionMap, roleId, avatarFrameId);
/* 170 */     Session newSession = new ExpireSession(interval, roleId, avatarFrameId, null);
/* 171 */     xSessionMap.put(Integer.valueOf(avatarFrameId), Long.valueOf(newSession.getSessionId()));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void stopSession(Map<Integer, Long> xSessionMap, long roleId, int avatarFrameId)
/*     */   {
/* 180 */     Long sessionId = (Long)xSessionMap.get(Integer.valueOf(avatarFrameId));
/* 181 */     if (sessionId != null) {
/* 182 */       Session.removeSession(sessionId.longValue(), roleId);
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\avatar\frame\AvatarFrameExpireManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */