/*    */ package mzm.gsp.avatar.frame;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Collections;
/*    */ import java.util.List;
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.tlog.TLogManager;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class AvatarFrameLogger
/*    */ {
/* 22 */   private static final Logger LOGGER = Logger.getLogger("AvatarFrame");
/*    */   private static final String TLOG_UNLOCK_FRAME = "UnlockAvatarFrame";
/*    */   private static final String TLOG_EXTEND_FRAME = "ExtendAvatarFrame";
/*    */   private static final String TLOG_FRAME_EXPIRED = "AvatarFrameExpired";
/*    */   private static final String TLOG_USE_FRAME = "UseAvatarFrame";
/*    */   private static final String TLOG_REMOVE_FRAME = "RemoveAvatarFrame";
/*    */   
/*    */   static void info(String str, Object... args)
/*    */   {
/* 31 */     LOGGER.info("[AvatarFrame]" + String.format(str, args));
/*    */   }
/*    */   
/*    */   static void error(String str, Object... args)
/*    */   {
/* 36 */     LOGGER.error("[AvatarFrame]" + String.format(str, args));
/*    */   }
/*    */   
/*    */   private static void tlog(long roleId, String event, Object... args)
/*    */   {
/* 41 */     String userId = RoleInterface.getUserId(roleId);
/* 42 */     if (userId == null)
/* 43 */       return;
/* 44 */     List<Object> list = new ArrayList();
/* 45 */     list.add(GameServerInfoManager.getHostIP());
/* 46 */     list.add(userId);
/* 47 */     list.add(Long.valueOf(roleId));
/* 48 */     list.add(Integer.valueOf(RoleInterface.getLevel(roleId)));
/* 49 */     Collections.addAll(list, args);
/* 50 */     TLogManager.getInstance().addLog(userId, event, list.toArray());
/*    */   }
/*    */   
/*    */   static void unlockAvatarFrame(long roleId, int avatarFrameId, int expireTime)
/*    */   {
/* 55 */     tlog(roleId, "UnlockAvatarFrame", new Object[] { Integer.valueOf(avatarFrameId), Integer.valueOf(expireTime) });
/*    */   }
/*    */   
/*    */   static void extendAvatarFrame(long roleId, int avatarId, int expireTime)
/*    */   {
/* 60 */     tlog(roleId, "ExtendAvatarFrame", new Object[] { Integer.valueOf(avatarId), Integer.valueOf(expireTime) });
/*    */   }
/*    */   
/*    */   static void avatarExpired(long roleId, int avatarId)
/*    */   {
/* 65 */     tlog(roleId, "AvatarFrameExpired", new Object[] { Integer.valueOf(avatarId) });
/*    */   }
/*    */   
/*    */   static void useAvatarFrame(long roleId, int avatarFrameId)
/*    */   {
/* 70 */     tlog(roleId, "UseAvatarFrame", new Object[] { Integer.valueOf(avatarFrameId) });
/*    */   }
/*    */   
/*    */   static void removeAvatarFrame(long roleId, int avatarFrameId, int duration)
/*    */   {
/* 75 */     tlog(roleId, "RemoveAvatarFrame", new Object[] { Integer.valueOf(avatarFrameId), Integer.valueOf(duration) });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\avatar\frame\AvatarFrameLogger.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */