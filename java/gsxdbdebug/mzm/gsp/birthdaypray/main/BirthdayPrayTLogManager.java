/*    */ package mzm.gsp.birthdaypray.main;
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
/*    */ public class BirthdayPrayTLogManager
/*    */ {
/*    */   private static final String TLOG_BIRTHDAY_PRAY_ACTIVITY = "BirthdayPrayActivity";
/*    */   
/*    */   public static void tlogBirthdayPray(long roleid, int activityid, int graphId, long worldCounter)
/*    */   {
/* 19 */     String vGameIP = GameServerInfoManager.getHostIP();
/* 20 */     String userid = RoleInterface.getUserId(roleid);
/* 21 */     int rolelevel = RoleInterface.getLevel(roleid);
/* 22 */     String logStr = String.format("%s|%s|%d|%d|%d|%d|%d", new Object[] { vGameIP, userid, Long.valueOf(roleid), Integer.valueOf(rolelevel), Integer.valueOf(activityid), Integer.valueOf(graphId), Long.valueOf(worldCounter) });
/*    */     
/* 24 */     TLogManager.getInstance().addLog(userid, "BirthdayPrayActivity", logStr);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\birthdaypray\main\BirthdayPrayTLogManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */