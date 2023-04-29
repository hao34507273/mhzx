/*    */ package mzm.gsp.huanhun.main;
/*    */ 
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.tlog.TLogManager;
/*    */ import mzm.gsp.util.LogManager;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class HunLogManager
/*    */ {
/*    */   private static final String TLOG_HUN_HELP = "HuanHunHelp";
/*    */   
/*    */   public static boolean addHunHelpLog(long roleId, long helpRoleId, int status, int itemId)
/*    */   {
/* 21 */     zlogHuanHunHelp(roleId, helpRoleId, status, itemId);
/* 22 */     tlogHuanHunHelp(roleId, helpRoleId, status, itemId);
/* 23 */     return true;
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
/*    */   static boolean zlogHuanHunHelp(long roleId, long helpRoleId, int status, int itemId)
/*    */   {
/* 37 */     int platform = RoleInterface.getPlatform(roleId);
/* 38 */     String channel = RoleInterface.getChannel(roleId);
/* 39 */     String mac = RoleInterface.getMac(roleId);
/* 40 */     String userId = RoleInterface.getUserId(roleId);
/* 41 */     int level = RoleInterface.getLevel(roleId);
/* 42 */     String userid2 = "";
/* 43 */     if (status == 2)
/*    */     {
/* 45 */       userid2 = RoleInterface.getUserId(helpRoleId);
/*    */     }
/*    */     
/* 48 */     String logStr = String.format("%d|%s|%s|%s|%d|%d|%d|%d|%s|%d", new Object[] { Integer.valueOf(platform), channel, mac, userId, Long.valueOf(roleId), Integer.valueOf(level), Integer.valueOf(status), Integer.valueOf(itemId), userid2, Long.valueOf(helpRoleId) });
/*    */     
/* 50 */     LogManager.getInstance().addLog("helplog", logStr);
/*    */     
/* 52 */     return true;
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
/*    */   public static void tlogHuanHunHelp(long roleId, long helpRoleId, int status, int itemId)
/*    */   {
/* 67 */     String vGameIP = GameServerInfoManager.getHostIP();
/* 68 */     String userid = RoleInterface.getUserId(roleId);
/* 69 */     int rolelevel = RoleInterface.getLevel(roleId);
/*    */     
/* 71 */     String userid2 = "";
/* 72 */     if (status == 2)
/*    */     {
/* 74 */       userid2 = RoleInterface.getUserId(helpRoleId);
/*    */     }
/*    */     
/* 77 */     String logStr = String.format("%s|%s|%d|%d|%d|%d|%s|%d", new Object[] { vGameIP, userid, Long.valueOf(roleId), Integer.valueOf(rolelevel), Integer.valueOf(status), Integer.valueOf(itemId), userid2, Long.valueOf(helpRoleId) });
/*    */     
/* 79 */     TLogManager.getInstance().addLog(roleId, "HuanHunHelp", logStr);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\huanhun\main\HunLogManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */