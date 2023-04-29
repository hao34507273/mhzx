/*    */ package mzm.gsp.cookiecake.main;
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
/*    */ public class CookieCakeTLogManager
/*    */ {
/*    */   private static final String TLOG_COOKIE_CAKE_ACTIVITY = "CookieCakeActivity";
/*    */   
/*    */   public static void tlogCookieCake(long roleid, int activityid, int createItemCfgid, int actionType, int createNum)
/*    */   {
/* 20 */     String vGameIP = GameServerInfoManager.getHostIP();
/* 21 */     String userid = RoleInterface.getUserId(roleid);
/* 22 */     int rolelevel = RoleInterface.getLevel(roleid);
/* 23 */     String logStr = String.format("%s|%s|%d|%d|%d|%d|%d|%d", new Object[] { vGameIP, userid, Long.valueOf(roleid), Integer.valueOf(rolelevel), Integer.valueOf(activityid), Integer.valueOf(createItemCfgid), Integer.valueOf(actionType), Integer.valueOf(createNum) });
/*    */     
/* 25 */     TLogManager.getInstance().addLog(userid, "CookieCakeActivity", logStr);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\cookiecake\main\CookieCakeTLogManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */