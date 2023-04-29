/*    */ package mzm.gsp.foolsday.main;
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
/*    */ public class FoolsDayTlogManager
/*    */ {
/*    */   static void addMakeChestTlog(long roleid, int activityCfgid, int itemCfgid, long uuid, int buffid, int costVigor, int makeChestNum)
/*    */   {
/* 27 */     String vGameIP = GameServerInfoManager.getHostIP();
/* 28 */     String userid = RoleInterface.getUserId(roleid);
/* 29 */     int rolelevel = RoleInterface.getLevel(roleid);
/* 30 */     String logStr = String.format("%s|%s|%d|%d|%d|%d|%d|%d|%d|%d", new Object[] { vGameIP, userid, Long.valueOf(roleid), Integer.valueOf(rolelevel), Integer.valueOf(activityCfgid), Integer.valueOf(itemCfgid), Long.valueOf(uuid), Integer.valueOf(buffid), Integer.valueOf(costVigor), Integer.valueOf(makeChestNum) });
/*    */     
/* 32 */     TLogManager.getInstance().addLog(roleid, "MakeChestForServer", logStr);
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
/*    */ 
/*    */ 
/*    */ 
/*    */   static void addOpenChestTlog(long roleid, long makerid, int activityCfgid, int itemCfgid, long uuid, int buffid, int addPoint, int currentPoint)
/*    */   {
/* 50 */     String vGameIP = GameServerInfoManager.getHostIP();
/* 51 */     String userid = RoleInterface.getUserId(roleid);
/* 52 */     int rolelevel = RoleInterface.getLevel(roleid);
/* 53 */     String logStr = String.format("%s|%s|%d|%d|%d|%d|%d|%d|%d|%d|%d", new Object[] { vGameIP, userid, Long.valueOf(roleid), Integer.valueOf(rolelevel), Long.valueOf(makerid), Integer.valueOf(activityCfgid), Integer.valueOf(itemCfgid), Long.valueOf(uuid), Integer.valueOf(buffid), Integer.valueOf(addPoint), Integer.valueOf(currentPoint) });
/*    */     
/* 55 */     TLogManager.getInstance().addLog(roleid, "OpenChestForServer", logStr);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\foolsday\main\FoolsDayTlogManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */