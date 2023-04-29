/*    */ package mzm.gsp.wanted.main;
/*    */ 
/*    */ import java.util.Collection;
/*    */ import mzm.gsp.tlog.TLogManager;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class WantedTlogManager
/*    */ {
/*    */   private static final String TLOG_ADD_ROLE_TO_WANTED = "AddRoleToWantedLog";
/*    */   private static final String TLOG_REMOVE_ROLE_FROM_WANTED = "RemoveRoleFromWantedLog";
/*    */   private static final String TLOG_WANTED_PVP_RESULT = "WantedPVPResultLog";
/*    */   private static final String TLOG_WANTED_PVE_RESULT = "WantedPVEResultLog";
/*    */   static final int TLOG_WANTED_SUCCESS = 1;
/*    */   static final int TLOG_WANTED_FAIL = 2;
/*    */   
/*    */   static void tlogAddRoleToWanted(long roleId, long moralValue)
/*    */   {
/* 22 */     TLogManager.getInstance().addLog(roleId, "AddRoleToWantedLog", new Object[] { Long.valueOf(roleId), Long.valueOf(moralValue) });
/*    */   }
/*    */   
/*    */   static void tlogRemoveRoleFromWanted(long roleId, long moralValue)
/*    */   {
/* 27 */     TLogManager.getInstance().addLog(roleId, "RemoveRoleFromWantedLog", new Object[] { Long.valueOf(roleId), Long.valueOf(moralValue) });
/*    */   }
/*    */   
/*    */ 
/*    */   static void tlogWantedPVPResult(long targetRoleId, Collection<Long> passiveRoleList, Collection<Long> passiveRoleWantedList, Collection<Long> activeRoleList, int fightResult)
/*    */   {
/* 33 */     TLogManager.getInstance().addLog(targetRoleId, "WantedPVPResultLog", new Object[] { Long.valueOf(targetRoleId), passiveRoleList, passiveRoleWantedList, activeRoleList, Integer.valueOf(fightResult) });
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   static void tlogWantedPVEResult(long targetRoleId, Collection<Long> roleList, Collection<Long> roleWantedList, int fightCount, int fightId, int fightResult)
/*    */   {
/* 40 */     TLogManager.getInstance().addLog(targetRoleId, "WantedPVEResultLog", new Object[] { Long.valueOf(targetRoleId), roleList, roleWantedList, Integer.valueOf(fightCount), Integer.valueOf(fightId), Integer.valueOf(fightResult) });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\wanted\main\WantedTlogManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */