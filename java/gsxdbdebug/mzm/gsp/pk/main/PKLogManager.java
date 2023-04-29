/*    */ package mzm.gsp.pk.main;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ import java.util.ArrayList;
/*    */ import java.util.Arrays;
/*    */ import java.util.Collections;
/*    */ import java.util.List;
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.tlog.TLogManager;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ class PKLogManager
/*    */ {
/* 15 */   private static final Logger LOGGER = Logger.getLogger("pk");
/*    */   private static final String TLOG_PK_ENABLED = "PKEnabled";
/*    */   private static final String TLOG_PK_PROTECTION = "EnterPKProtectionState";
/*    */   
/* 19 */   static void info(String str) { LOGGER.info("[PK]" + str); }
/*    */   
/*    */ 
/*    */   static void error(String str)
/*    */   {
/* 24 */     LOGGER.error("[PK]" + str);
/*    */   }
/*    */   
/*    */ 
/*    */   private static final String TLOG_PK_FORCE_PROTECTION = "EnterPKForceProtectionState";
/*    */   private static final String TLOG_PK_STARTED = "PKStarted";
/*    */   private static void tlog(long roleId, String logName, Object... args)
/*    */   {
/* 32 */     String userId = RoleInterface.getUserId(roleId);
/* 33 */     if (userId == null)
/* 34 */       return;
/* 35 */     List<Object> list = new ArrayList();
/* 36 */     list.addAll(Arrays.asList(new Serializable[] { GameServerInfoManager.getHostIP(), userId, Long.valueOf(roleId), Integer.valueOf(RoleInterface.getLevel(roleId)) }));
/* 37 */     Collections.addAll(list, args);
/* 38 */     TLogManager.getInstance().addLog(userId, logName, list.toArray());
/*    */   }
/*    */   
/*    */ 
/*    */   private static final String TLOG_BIND_TARGET = "UsePKRevengeItemBindTarget";
/*    */   
/*    */   private static final String TLOG_QUERY_TARGET = "UsePKRevengeItemQueryTarget";
/*    */   
/*    */   private static final String TLOG_TRANSFER_TO_TARGET = "UsePKRevengeItemTransferToTarget";
/*    */   
/*    */   private static final String TLOG_ACCEPT_MORAL_VALUE_TASK = "AcceptMoralValueTask";
/*    */   
/*    */   private static final String TLOG_FINISH_MORAL_VALUE_TASK = "FinishMoralValueTask";
/*    */   static void tlogPKEnabled(long roleId, int expireTime)
/*    */   {
/* 53 */     tlog(roleId, "PKEnabled", new Object[] { Integer.valueOf(expireTime) });
/*    */   }
/*    */   
/*    */   static void tlogPKProtected(long roleId, int deathTimes, int expireTime)
/*    */   {
/* 58 */     tlog(roleId, "EnterPKProtectionState", new Object[] { Integer.valueOf(deathTimes), Integer.valueOf(expireTime) });
/*    */   }
/*    */   
/*    */   static void tlogPKForceProtected(long roleId, int expireTime)
/*    */   {
/* 63 */     tlog(roleId, "EnterPKForceProtectionState", new Object[] { Integer.valueOf(expireTime) });
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   static void tlogPKStarted(long roleId, int pkTimes, long targetRoleId, long teammateRoleId1, long teammateRoleId2, long teammateRoleId3, long teammateRoleId4, long targetRoleId1, long targetRoleId2, long targetRoleId3, long targetRoleId4)
/*    */   {
/* 70 */     tlog(roleId, "PKStarted", new Object[] { Integer.valueOf(pkTimes), Long.valueOf(targetRoleId), Long.valueOf(teammateRoleId1), Long.valueOf(teammateRoleId2), Long.valueOf(teammateRoleId3), Long.valueOf(teammateRoleId4), Long.valueOf(targetRoleId1), Long.valueOf(targetRoleId2), Long.valueOf(targetRoleId3), Long.valueOf(targetRoleId4) });
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   static void tlogRevengeItemBindTarget(long roleId, long targetRoleId)
/*    */   {
/* 77 */     tlog(roleId, "UsePKRevengeItemBindTarget", new Object[] { Long.valueOf(targetRoleId) });
/*    */   }
/*    */   
/*    */   static void tlogRevengeItemQueryTarget(long roleId, long targetRoleId)
/*    */   {
/* 82 */     tlog(roleId, "UsePKRevengeItemQueryTarget", new Object[] { Long.valueOf(targetRoleId) });
/*    */   }
/*    */   
/*    */   static void tlogRevengeItemTransferToTarget(long roleId, long targetRoleId)
/*    */   {
/* 87 */     tlog(roleId, "UsePKRevengeItemTransferToTarget", new Object[] { Long.valueOf(targetRoleId) });
/*    */   }
/*    */   
/*    */   static void tlogAcceptMoralValueTask(long roleId)
/*    */   {
/* 92 */     tlog(roleId, "AcceptMoralValueTask", new Object[0]);
/*    */   }
/*    */   
/*    */   static void tlogFinishMoralValueTask(long roleId)
/*    */   {
/* 97 */     tlog(roleId, "FinishMoralValueTask", new Object[0]);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pk\main\PKLogManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */