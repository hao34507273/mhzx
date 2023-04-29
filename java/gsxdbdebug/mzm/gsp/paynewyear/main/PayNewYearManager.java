/*    */ package mzm.gsp.paynewyear.main;
/*    */ 
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.open.main.OpenInterface;
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
/*    */ public class PayNewYearManager
/*    */ {
/*    */   static boolean isPayNewYearSwitchOpen(long roleId)
/*    */   {
/* 23 */     if (!OpenInterface.getOpenStatus(201))
/*    */     {
/* 25 */       return false;
/*    */     }
/*    */     
/* 28 */     if (OpenInterface.isBanPlay(roleId, 201))
/*    */     {
/* 30 */       OpenInterface.sendBanPlayMsg(roleId, 201);
/* 31 */       return false;
/*    */     }
/*    */     
/* 34 */     return true;
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
/*    */   static void tlogPayNewYearTimes(String userId, long roleId, int roleLevel, String bePaiedUserId, long bePaiedRoleId, int paiedRoleLevel, int times)
/*    */   {
/* 52 */     StringBuilder sbLog = new StringBuilder();
/* 53 */     sbLog.append(GameServerInfoManager.getHostIP()).append('|');
/* 54 */     sbLog.append(userId).append('|');
/* 55 */     sbLog.append(roleId).append('|');
/* 56 */     sbLog.append(roleLevel).append('|');
/*    */     
/* 58 */     int bePaiedRoleLevel = RoleInterface.getLevel(bePaiedRoleId);
/* 59 */     sbLog.append(bePaiedRoleId).append('|');
/* 60 */     sbLog.append(bePaiedRoleLevel).append('|');
/* 61 */     sbLog.append(bePaiedUserId).append('|');
/* 62 */     sbLog.append(times);
/*    */     
/* 64 */     TLogManager.getInstance().addLog(roleId, "PayNewYearStatis", sbLog.toString());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\paynewyear\main\PayNewYearManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */