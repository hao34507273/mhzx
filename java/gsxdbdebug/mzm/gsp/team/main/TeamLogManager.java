/*    */ package mzm.gsp.team.main;
/*    */ 
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.tlog.TLogManager;
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
/*    */ public class TeamLogManager
/*    */ {
/*    */   static final int LEADER = 1;
/*    */   static final int MEMBER = 2;
/*    */   static final int INVITE_REPLY_TIME_OUT = 3;
/*    */   private static final String TLOG_ROLE_INVITE_OTHER = "PlayerInviteOther";
/*    */   private static final String TLOG_ROLE_REPLY_INVITE = "PlayerReplyOtherInvite";
/*    */   
/*    */   public static void logInviteOther(long roleId, long inviteeId, int inviterType)
/*    */   {
/* 36 */     tLogInviteOther(roleId, inviteeId, inviterType);
/*    */   }
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
/*    */ 
/*    */   public static void logReplyInvite(long roleId, long inviterId, int reply)
/*    */   {
/* 51 */     tLogReplyInvite(roleId, inviterId, reply);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   private static void tLogInviteOther(long roleId, long inviteeId, int inviterType)
/*    */   {
/* 63 */     String vGameIP = GameServerInfoManager.getHostIP();
/* 64 */     String userid = RoleInterface.getUserId(roleId);
/* 65 */     int inviterLevel = RoleInterface.getLevel(roleId);
/*    */     
/* 67 */     String inviteeUserId = RoleInterface.getUserId(inviteeId);
/* 68 */     int inviteeLevel = RoleInterface.getLevel(inviteeId);
/*    */     
/* 70 */     String logStr = String.format("%s|%s|%d|%d|%d|%s|%d|%d", new Object[] { vGameIP, userid, Long.valueOf(roleId), Integer.valueOf(inviterLevel), Integer.valueOf(inviterType), inviteeUserId, Long.valueOf(inviteeId), Integer.valueOf(inviteeLevel) });
/*    */     
/* 72 */     TLogManager.getInstance().addLog(roleId, "PlayerInviteOther", logStr);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   private static void tLogReplyInvite(long roleId, long inviterId, int reply)
/*    */   {
/* 84 */     String vGameIP = GameServerInfoManager.getHostIP();
/* 85 */     String userid = RoleInterface.getUserId(roleId);
/* 86 */     int inviteeLevel = RoleInterface.getLevel(roleId);
/*    */     
/* 88 */     String inviterUserId = RoleInterface.getUserId(inviterId);
/* 89 */     int inviterLevel = RoleInterface.getLevel(inviterId);
/*    */     
/* 91 */     String logStr = String.format("%s|%s|%d|%d|%s|%d|%d|%d", new Object[] { vGameIP, userid, Long.valueOf(roleId), Integer.valueOf(inviteeLevel), inviterUserId, Long.valueOf(inviterId), Integer.valueOf(inviterLevel), Integer.valueOf(reply) });
/*    */     
/* 93 */     TLogManager.getInstance().addLog(roleId, "PlayerReplyOtherInvite", logStr);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\team\main\TeamLogManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */