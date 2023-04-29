/*    */ package mzm.gsp.market.search;
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
/*    */ public class MarketTlogManager
/*    */ {
/*    */   static void tlogMarketsearch(long roleid, int searchtype, int subid, AbstractCondition<?> condition, int state)
/*    */   {
/* 21 */     String logName = "Marketsearch";
/* 22 */     String vGameIP = GameServerInfoManager.getHostIP();
/* 23 */     String userid = RoleInterface.getUserId(roleid);
/* 24 */     int rolelevel = RoleInterface.getLevel(roleid);
/*    */     
/* 26 */     String logStr = String.format("%s|%s|%d|%d|%d|%d|%s|%d", new Object[] { vGameIP, userid, Long.valueOf(roleid), Integer.valueOf(rolelevel), Integer.valueOf(searchtype), Integer.valueOf(subid), condition.toString(), Integer.valueOf(state) });
/*    */     
/* 28 */     TLogManager.getInstance().addLog(roleid, logName, logStr);
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
/*    */   static void tlogMarketcustomized(long roleid, int searchtype, int subid, AbstractCondition<?> condition)
/*    */   {
/* 42 */     String logName = "Marketcustomized";
/* 43 */     String vGameIP = GameServerInfoManager.getHostIP();
/* 44 */     String userid = RoleInterface.getUserId(roleid);
/* 45 */     int rolelevel = RoleInterface.getLevel(roleid);
/*    */     
/* 47 */     String logStr = String.format("%s|%s|%d|%d|%d|%d|%s", new Object[] { vGameIP, userid, Long.valueOf(roleid), Integer.valueOf(rolelevel), Integer.valueOf(searchtype), Integer.valueOf(subid), condition.toString() });
/*    */     
/* 49 */     TLogManager.getInstance().addLog(roleid, logName, logStr);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\market\search\MarketTlogManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */