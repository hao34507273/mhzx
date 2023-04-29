/*    */ package mzm.gsp.indiana.main;
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
/*    */ public class IndianaTLogManager
/*    */ {
/*    */   static void addAttendTLog(long roleid, int activityCfgid, int turn, int sortid, int number)
/*    */   {
/* 17 */     String vGameIP = GameServerInfoManager.getHostIP();
/* 18 */     String userid = RoleInterface.getUserId(roleid);
/* 19 */     int rolelevel = RoleInterface.getLevel(roleid);
/* 20 */     String logStr = String.format("%s|%s|%d|%d|%d|%d|%d|%d", new Object[] { vGameIP, userid, Long.valueOf(roleid), Integer.valueOf(rolelevel), Integer.valueOf(activityCfgid), Integer.valueOf(turn), Integer.valueOf(sortid), Integer.valueOf(number) });
/*    */     
/* 22 */     TLogManager.getInstance().addLog(roleid, "AttendIndianaForServer", logStr);
/*    */   }
/*    */   
/*    */ 
/*    */   static void addAwardTLog(long roleid, int activityCfgid, int turn, int sortid, long number, int fixAwardid)
/*    */   {
/* 28 */     String vGameIP = GameServerInfoManager.getHostIP();
/* 29 */     String userid = RoleInterface.getUserId(roleid);
/* 30 */     int rolelevel = RoleInterface.getLevel(roleid);
/* 31 */     String logStr = String.format("%s|%s|%d|%d|%d|%d|%d|%d|%d", new Object[] { vGameIP, userid, Long.valueOf(roleid), Integer.valueOf(rolelevel), Integer.valueOf(activityCfgid), Integer.valueOf(turn), Integer.valueOf(sortid), Long.valueOf(number), Integer.valueOf(fixAwardid) });
/*    */     
/* 33 */     TLogManager.getInstance().addLog(roleid, "IndianaAwardForServer", logStr);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\indiana\main\IndianaTLogManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */