/*    */ package mzm.gsp.crossbattle.bet;
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
/*    */ public class CrossBattleBetTLogManager
/*    */ {
/*    */   public static final int ACTION_BET = 1;
/*    */   public static final int ACTION_SETTLE = 2;
/*    */   
/*    */   static void addRoundRobinBetTLog(long roleid, int activityCfgid, int action, int roundIndex, long corpsAid, long corpsBid, int currentFightState, long betCorpsid, int sortid)
/*    */   {
/* 20 */     String vGameIP = GameServerInfoManager.getHostIP();
/* 21 */     String userid = RoleInterface.getUserId(roleid);
/* 22 */     int rolelevel = RoleInterface.getLevel(roleid);
/* 23 */     String logStr = String.format("%s|%s|%d|%d|%d|%d|%d|%d|%d|%d|%d|%d", new Object[] { vGameIP, userid, Long.valueOf(roleid), Integer.valueOf(rolelevel), Integer.valueOf(activityCfgid), Integer.valueOf(action), Integer.valueOf(roundIndex), Long.valueOf(corpsAid), Long.valueOf(corpsBid), Integer.valueOf(currentFightState), Long.valueOf(betCorpsid), Integer.valueOf(sortid) });
/*    */     
/* 25 */     TLogManager.getInstance().addLog(roleid, "RoundRobinBetInCrossBattleForServer", logStr);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   static void addKnockoutBetTLog(long roleid, int activityCfgid, int action, int knockoutType, int fightZoneid, int stage, int fightIndex, long corpsAid, long corpsBid, int calFightResult, long betCorpsid, int betMoneyNum, boolean isBetSuccess, int returnMoneyNum)
/*    */   {
/* 33 */     String vGameIP = GameServerInfoManager.getHostIP();
/* 34 */     String userid = RoleInterface.getUserId(roleid);
/* 35 */     int rolelevel = RoleInterface.getLevel(roleid);
/* 36 */     String logStr = String.format("%s|%s|%d|%d|%d|%d|%d|%d|%d|%d|%d|%d|%d|%d|%d|%d|%d", new Object[] { vGameIP, userid, Long.valueOf(roleid), Integer.valueOf(rolelevel), Integer.valueOf(activityCfgid), Integer.valueOf(action), Integer.valueOf(knockoutType), Integer.valueOf(fightZoneid), Integer.valueOf(stage), Integer.valueOf(fightIndex), Long.valueOf(corpsAid), Long.valueOf(corpsBid), Integer.valueOf(calFightResult), Long.valueOf(betCorpsid), Integer.valueOf(betMoneyNum), Integer.valueOf(isBetSuccess ? 1 : 0), Integer.valueOf(returnMoneyNum) });
/*    */     
/*    */ 
/* 39 */     TLogManager.getInstance().addLog(roleid, "KnockoutBetInCrossBattleForServer", logStr);
/*    */   }
/*    */   
/*    */   static void addRankAwardTLog(long roleid, int activityCfgid, int chartType, int rank)
/*    */   {
/* 44 */     String vGameIP = GameServerInfoManager.getHostIP();
/* 45 */     String userid = RoleInterface.getUserId(roleid);
/* 46 */     int rolelevel = RoleInterface.getLevel(roleid);
/* 47 */     String logStr = String.format("%s|%s|%d|%d|%d|%d|%d", new Object[] { vGameIP, userid, Long.valueOf(roleid), Integer.valueOf(rolelevel), Integer.valueOf(activityCfgid), Integer.valueOf(chartType), Integer.valueOf(rank) });
/* 48 */     TLogManager.getInstance().addLog(roleid, "CrossBattleBetRankAwardForServer", logStr);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\bet\CrossBattleBetTLogManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */