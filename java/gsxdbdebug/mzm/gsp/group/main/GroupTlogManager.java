/*    */ package mzm.gsp.group.main;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ public class GroupTlogManager
/*    */ {
/*    */   public static final int ACTION_GROUP_CREATE = 1;
/*    */   public static final int ACTION_GROUP_INVITE = 2;
/*    */   public static final int ACTION_GROUP_QUIT = 3;
/*    */   public static final int ACTION_GROUP_KICK = 4;
/*    */   public static final int ACTION_GROUP_DISSOLVE = 5;
/*    */   public static final int ACTION_GROUP_RENAME = 6;
/*    */   public static final int ACTION_GROUP_CHANGE_ANNOUNCEMENT = 7;
/*    */   public static final int ACTION_GROUP_SET_MESSAGE_STATE = 8;
/*    */   public static final int REASON_PLAYER_OPERATE = 1;
/*    */   public static final int REASON_ROLE_DELETE = 2;
/*    */   
/*    */   static void addGroupTlog(long roleid, int action, int reason, int groupType, long groupid, String groupName, long targetid, int messageState)
/*    */   {
/* 44 */     String vGameIP = GameServerInfoManager.getHostIP();
/* 45 */     String userid = RoleInterface.getUserId(roleid);
/* 46 */     int rolelevel = RoleInterface.getLevel(roleid);
/* 47 */     String logStr = String.format("%s|%s|%d|%d|%d|%d|%d|%d|%s|%d|%d|", new Object[] { vGameIP, userid, Long.valueOf(roleid), Integer.valueOf(rolelevel), Integer.valueOf(action), Integer.valueOf(reason), Integer.valueOf(groupType), Long.valueOf(groupid), groupName, Long.valueOf(targetid), Integer.valueOf(messageState) });
/*    */     
/* 49 */     TLogManager.getInstance().addLog(roleid, "GroupForServer", logStr);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\group\main\GroupTlogManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */