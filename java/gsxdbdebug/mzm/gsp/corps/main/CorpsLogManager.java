/*     */ package mzm.gsp.corps.main;
/*     */ 
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.corps.event.LeaveCorpsEventArg.LeaveCorpsReason;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CorpsLogManager
/*     */ {
/*     */   private static final String CREATE_CORPS = "CreateCorps";
/*     */   private static final String JOIN_CORPS = "JoinCorps";
/*     */   private static final String LEAVE_CORPS = "LeaveCorps";
/*     */   private static final String CHANGE_CORPS_CAPTAIN = "ChangeCorpsCaptain";
/*     */   
/*     */   static void logCreateCorps(String userId, long roleId, long corpsId, Map<Integer, Set<Long>> duty2Members)
/*     */   {
/*  34 */     String vGameIP = GameServerInfoManager.getHostIP();
/*  35 */     int rolelevel = RoleInterface.getLevel(roleId);
/*     */     
/*  37 */     Object[] colums = { vGameIP, userId, Long.valueOf(roleId), Integer.valueOf(rolelevel), Long.valueOf(corpsId), duty2Members == null ? "" : duty2Members.toString() };
/*     */     
/*     */ 
/*  40 */     TLogManager.getInstance().addLog(roleId, "CreateCorps", colums);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void logJoinCorps(String userId, long roleId, long corpsId, long captainId, int duty, Map<Integer, Set<Long>> duty2Members)
/*     */   {
/*  54 */     String vGameIP = GameServerInfoManager.getHostIP();
/*  55 */     int rolelevel = RoleInterface.getLevel(roleId);
/*     */     
/*  57 */     Object[] colums = { vGameIP, userId, Long.valueOf(roleId), Integer.valueOf(rolelevel), Integer.valueOf(duty), Long.valueOf(corpsId), Long.valueOf(captainId), duty2Members == null ? "" : duty2Members.toString() };
/*     */     
/*     */ 
/*  60 */     TLogManager.getInstance().addLog(roleId, "JoinCorps", colums);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void logLeaveCorps(String userId, long roleId, long corpsId, long captainId, int duty, LeaveCorpsEventArg.LeaveCorpsReason reasonEnum, Map<Integer, Set<Long>> duty2Members)
/*     */   {
/*  74 */     String vGameIP = GameServerInfoManager.getHostIP();
/*  75 */     int rolelevel = RoleInterface.getLevel(roleId);
/*     */     
/*  77 */     int reason = -1;
/*     */     
/*  79 */     switch (reasonEnum)
/*     */     {
/*     */     case ACTIVE_LEAVE: 
/*  82 */       reason = 1;
/*  83 */       break;
/*     */     case FIRED: 
/*  85 */       reason = 2;
/*  86 */       break;
/*     */     }
/*     */     
/*     */     
/*  90 */     if (reason < 0)
/*     */     {
/*  92 */       return;
/*     */     }
/*     */     
/*  95 */     Object[] colums = { vGameIP, userId, Long.valueOf(roleId), Integer.valueOf(rolelevel), Integer.valueOf(duty), Long.valueOf(corpsId), Long.valueOf(captainId), Integer.valueOf(reason), duty2Members == null ? "" : duty2Members.toString() };
/*     */     
/*     */ 
/*  98 */     TLogManager.getInstance().addLog(roleId, "LeaveCorps", colums);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void logChangeCorpsCaptain(String userId, long roleId, long corpsId, long captainId, Map<Integer, Set<Long>> duty2Members)
/*     */   {
/* 112 */     String vGameIP = GameServerInfoManager.getHostIP();
/* 113 */     int rolelevel = RoleInterface.getLevel(roleId);
/*     */     
/* 115 */     Object[] colums = { vGameIP, userId, Long.valueOf(roleId), Integer.valueOf(rolelevel), Long.valueOf(corpsId), Long.valueOf(captainId), duty2Members == null ? "" : duty2Members.toString() };
/*     */     
/*     */ 
/* 118 */     TLogManager.getInstance().addLog(roleId, "ChangeCorpsCaptain", colums);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\corps\main\CorpsLogManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */