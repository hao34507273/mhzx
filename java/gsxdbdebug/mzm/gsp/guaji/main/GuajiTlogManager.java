/*    */ package mzm.gsp.guaji.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
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
/*    */ public class GuajiTlogManager
/*    */ {
/*    */   static void tlogGuaji(long roleId, boolean isWin, int mapId, boolean isDouble)
/*    */   {
/* 22 */     String vGameIP = GameServerInfoManager.getHostIP();
/* 23 */     String userid = RoleInterface.getUserId(roleId);
/* 24 */     int rolelevel = RoleInterface.getLevel(roleId);
/*    */     
/* 26 */     Object[] colums = { vGameIP, userid, Long.valueOf(roleId), Integer.valueOf(rolelevel), Integer.valueOf(mapId), Integer.valueOf(isWin ? 1 : 0), Integer.valueOf(isDouble ? 1 : 0) };
/* 27 */     TLogManager.getInstance().addLog(roleId, "GuaJI", colums);
/*    */   }
/*    */   
/*    */   static void tlogAfterLose(List<Long> losers, int mapId)
/*    */   {
/* 32 */     for (Iterator i$ = losers.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*    */       
/* 34 */       tlogGuaji(roleId, false, mapId, false);
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\guaji\main\GuajiTlogManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */