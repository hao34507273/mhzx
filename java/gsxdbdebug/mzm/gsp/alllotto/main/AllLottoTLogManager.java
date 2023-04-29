/*    */ package mzm.gsp.alllotto.main;
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
/*    */ public class AllLottoTLogManager
/*    */ {
/*    */   static void addAwardTLog(long roleid, int activityCfgid, int turn, int fixAwardid)
/*    */   {
/* 17 */     String vGameIP = GameServerInfoManager.getHostIP();
/* 18 */     String userid = RoleInterface.getUserId(roleid);
/* 19 */     int rolelevel = RoleInterface.getLevel(roleid);
/* 20 */     String logStr = String.format("%s|%s|%d|%d|%d|%d|%d", new Object[] { vGameIP, userid, Long.valueOf(roleid), Integer.valueOf(rolelevel), Integer.valueOf(activityCfgid), Integer.valueOf(turn), Integer.valueOf(fixAwardid) });
/*    */     
/* 22 */     TLogManager.getInstance().addLog(roleid, "AllLottoAwardForServer", logStr);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\alllotto\main\AllLottoTLogManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */