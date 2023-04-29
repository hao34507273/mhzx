/*    */ package mzm.gsp.award.watchdog;
/*    */ 
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.qingfu.main.QingfuInterface;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.tlog.TLogManager;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class RoleExpBarkHandler
/*    */   implements AwardBarkPro
/*    */ {
/*    */   public void doActionWhenBark(AwardBarkEventArg arg)
/*    */   {
/* 21 */     tlogRoleExpBark(arg);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static void tlogRoleExpBark(AwardBarkEventArg arg)
/*    */   {
/* 32 */     long roleId = arg.getRoleId();
/* 33 */     String userId = RoleInterface.getUserId(roleId);
/* 34 */     long totalCash = QingfuInterface.getTotalCash(userId, true);
/* 35 */     int occId = RoleInterface.getOccupationId(roleId);
/*    */     
/* 37 */     String vGameIP = GameServerInfoManager.getHostIP();
/* 38 */     int rolelevel = RoleInterface.getLevel(roleId);
/*    */     
/* 40 */     String logStr = String.format("%s|%s|%d|%d|%d|%d|%d|%d", new Object[] { vGameIP, userId, Long.valueOf(roleId), Integer.valueOf(rolelevel), Integer.valueOf(occId), Integer.valueOf(arg.getOrgRoleLv()), Long.valueOf(arg.getCurValueSum()), Long.valueOf(totalCash) });
/*    */     
/* 42 */     TLogManager.getInstance().addLog(roleId, "RoleExpBark", logStr);
/*    */     
/* 44 */     String fatalStr = String.format("RoleExpAbnormal|roleid=%d|rolelevel=%d|occupationid=%d|orginal_level=%d|current_value_sum=%d|total_cash=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(rolelevel), Integer.valueOf(occId), Integer.valueOf(arg.getOrgRoleLv()), Long.valueOf(arg.getCurValueSum()), Long.valueOf(totalCash) });
/*    */     
/*    */ 
/*    */ 
/* 48 */     GameServer.surveillanceLogger().fatal(fatalStr);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\award\watchdog\RoleExpBarkHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */