/*    */ package mzm.gsp.chatbubble.main;
/*    */ 
/*    */ import java.text.SimpleDateFormat;
/*    */ import java.util.concurrent.TimeUnit;
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.tlog.TLogManager;
/*    */ import mzm.gsp.util.DateTimeUtils;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ChatBubbleTLogManager
/*    */ {
/*    */   static final String UNLOCK_LOG = "ChatBubbleUnlockLog";
/*    */   static final String RENEWAL_LOG = "ChatBubbleRenewalLog";
/*    */   static final String EXPIRE_LOG = "ChatBubbleExpireLog";
/*    */   static final String CHANGE_LOG = "ChatBubbleChangeLog";
/*    */   static final String REMOVE_LOG = "ChatBubbleRemoveLog";
/*    */   static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
/*    */   
/*    */   private static void doTLog(long roleId, String tLogName, Object[] logColumns)
/*    */   {
/* 23 */     String userid = RoleInterface.getUserId(roleId);
/*    */     
/* 25 */     logColumns[0] = GameServerInfoManager.getHostIP();
/* 26 */     logColumns[1] = userid;
/* 27 */     logColumns[2] = Long.valueOf(roleId);
/* 28 */     logColumns[3] = Integer.valueOf(RoleInterface.getLevel(roleId));
/*    */     
/* 30 */     TLogManager.getInstance().addLog(userid, tLogName, logColumns);
/*    */   }
/*    */   
/*    */   static void tLogUnLock(long roleId, long uuid, int chatBubbleCfgId, long expireTimeStampInSeconds)
/*    */   {
/* 35 */     SimpleDateFormat simpleDateFormat = DateTimeUtils.getSimpleDateFormat("yyyy-MM-dd HH:mm:ss");
/*    */     
/* 37 */     Object[] logColumns = new Object[7];
/* 38 */     logColumns[4] = Long.valueOf(uuid);
/* 39 */     logColumns[5] = Integer.valueOf(chatBubbleCfgId);
/* 40 */     logColumns[6] = simpleDateFormat.format(Long.valueOf(TimeUnit.SECONDS.toMillis(expireTimeStampInSeconds)));
/*    */     
/* 42 */     doTLog(roleId, "ChatBubbleUnlockLog", logColumns);
/*    */   }
/*    */   
/*    */ 
/*    */   static void tLogRenewal(long roleId, long uuid, int chatBubbleCfgId, long oldExpireTimeStampInSeconds, long newExpireTimeStampInSeconds)
/*    */   {
/* 48 */     SimpleDateFormat simpleDateFormat = DateTimeUtils.getSimpleDateFormat("yyyy-MM-dd HH:mm:ss");
/*    */     
/* 50 */     Object[] logColumns = new Object[8];
/* 51 */     logColumns[4] = Long.valueOf(uuid);
/* 52 */     logColumns[5] = Integer.valueOf(chatBubbleCfgId);
/* 53 */     logColumns[6] = simpleDateFormat.format(Long.valueOf(TimeUnit.SECONDS.toMillis(oldExpireTimeStampInSeconds)));
/* 54 */     logColumns[7] = simpleDateFormat.format(Long.valueOf(TimeUnit.SECONDS.toMillis(newExpireTimeStampInSeconds)));
/*    */     
/* 56 */     doTLog(roleId, "ChatBubbleRenewalLog", logColumns);
/*    */   }
/*    */   
/*    */   static void tLogExpire(long roleId, int chatBubbleCfgId, long expireTimeStampInSeconds)
/*    */   {
/* 61 */     SimpleDateFormat simpleDateFormat = DateTimeUtils.getSimpleDateFormat("yyyy-MM-dd HH:mm:ss");
/*    */     
/* 63 */     Object[] logColumns = new Object[6];
/* 64 */     logColumns[4] = Integer.valueOf(chatBubbleCfgId);
/* 65 */     logColumns[5] = simpleDateFormat.format(Long.valueOf(TimeUnit.SECONDS.toMillis(expireTimeStampInSeconds)));
/*    */     
/* 67 */     doTLog(roleId, "ChatBubbleExpireLog", logColumns);
/*    */   }
/*    */   
/*    */   static void tLogChange(long roleId, int oldChatBubbleCfgId, int newChatBubbleCfgId)
/*    */   {
/* 72 */     Object[] logColumns = new Object[6];
/* 73 */     logColumns[4] = Integer.valueOf(oldChatBubbleCfgId);
/* 74 */     logColumns[5] = Integer.valueOf(newChatBubbleCfgId);
/*    */     
/* 76 */     doTLog(roleId, "ChatBubbleChangeLog", logColumns);
/*    */   }
/*    */   
/*    */ 
/*    */   static void tLogRemove(long roleId, int chatBubbleCfgId, long reduceSeconds, long beforeExpireTimeStamp, long afterExpireTimeStamp)
/*    */   {
/* 82 */     SimpleDateFormat simpleDateFormat = DateTimeUtils.getSimpleDateFormat("yyyy-MM-dd HH:mm:ss");
/* 83 */     Object[] logColumns = new Object[8];
/* 84 */     logColumns[4] = Integer.valueOf(chatBubbleCfgId);
/* 85 */     logColumns[5] = Long.valueOf(reduceSeconds);
/* 86 */     logColumns[6] = simpleDateFormat.format(Long.valueOf(TimeUnit.SECONDS.toMillis(beforeExpireTimeStamp)));
/* 87 */     logColumns[7] = simpleDateFormat.format(Long.valueOf(TimeUnit.SECONDS.toMillis(afterExpireTimeStamp)));
/* 88 */     doTLog(roleId, "ChatBubbleRemoveLog", logColumns);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chatbubble\main\ChatBubbleTLogManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */