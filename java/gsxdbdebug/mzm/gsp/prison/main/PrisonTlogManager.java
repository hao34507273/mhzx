/*    */ package mzm.gsp.prison.main;
/*    */ 
/*    */ import java.util.Collection;
/*    */ import java.util.List;
/*    */ import mzm.gsp.tlog.TLogManager;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PrisonTlogManager
/*    */ {
/*    */   private static final String TLOG_JAIL_BREAK = "JailBreakLog";
/*    */   private static final String TLOG_JAIL_DELIVERY = "JailDeliveryLog";
/*    */   private static final String TLOG_PUT_ROLE_IN_JAIL = "PutRoleInJailLog";
/*    */   private static final String TLOG_LET_ROLE_OUT_OF_JAIL = "LetRoleOutOfJailLog";
/*    */   static final int TLOG_JAIL_FIGHT_SUCCESS = 1;
/*    */   static final int TLOG_JAIL_FIGHT_FAIL = 2;
/*    */   
/*    */   static void tlogJailBreak(List<Long> playerList, int fightId, int fightResult)
/*    */   {
/* 23 */     TLogManager.getInstance().addLog(((Long)playerList.get(0)).longValue(), "JailBreakLog", new Object[] { playerList, Integer.valueOf(fightId), Integer.valueOf(fightResult) });
/*    */   }
/*    */   
/*    */   static void tlogJailDelivery(Collection playerList, long targetRoleId, int fightId, int fightResult)
/*    */   {
/* 28 */     TLogManager.getInstance().addLog(targetRoleId, "JailDeliveryLog", new Object[] { playerList, Long.valueOf(targetRoleId), Integer.valueOf(fightId), Integer.valueOf(fightResult) });
/*    */   }
/*    */   
/*    */   static void tlogLetRoleOutOfJail(long roleId)
/*    */   {
/* 33 */     TLogManager.getInstance().addLog(roleId, "LetRoleOutOfJailLog", new Object[] { Long.valueOf(roleId) });
/*    */   }
/*    */   
/*    */   static void tlogPutRoleInJail(long roleId)
/*    */   {
/* 38 */     TLogManager.getInstance().addLog(roleId, "PutRoleInJailLog", new Object[] { Long.valueOf(roleId) });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\prison\main\PrisonTlogManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */