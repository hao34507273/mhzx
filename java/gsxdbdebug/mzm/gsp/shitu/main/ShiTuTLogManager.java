/*     */ package mzm.gsp.shitu.main;
/*     */ 
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import xbean.ShiTuTask;
/*     */ import xbean.ShiTuTaskInfo;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ShiTuTLogManager
/*     */ {
/*     */   private static final String TLOG_SHITU_TASK_MASTER = "ShiTuTaskMaster";
/*     */   private static final String TLOG_SHITU_TASK_APPRENTICE = "ShiTuTaskApprentice";
/*     */   private static final String TLOG_SHITU_RECOMMEND = "ShiTuRecommend";
/*     */   
/*     */   static void tlogShiTuTaskMaster(long masterRoleId, String masterUserId, long apprenticeRoleId, String apprenticeUserId, ShiTuTaskInfo xShiTuTaskInfo)
/*     */   {
/*  40 */     int masterRoleLevel = RoleInterface.getLevel(masterRoleId);
/*  41 */     int apprenticeRoleLevel = RoleInterface.getLevel(apprenticeRoleId);
/*     */     
/*  43 */     StringBuilder sbLog = new StringBuilder();
/*  44 */     sbLog.append(GameServerInfoManager.getHostIP()).append('|');
/*  45 */     sbLog.append(masterUserId).append('|');
/*  46 */     sbLog.append(masterRoleId).append('|');
/*  47 */     sbLog.append(masterRoleLevel).append('|');
/*     */     
/*  49 */     sbLog.append(apprenticeUserId).append('|');
/*  50 */     sbLog.append(apprenticeRoleId).append('|');
/*  51 */     sbLog.append(apprenticeRoleLevel).append('|');
/*     */     
/*  53 */     StringBuilder sb = new StringBuilder();
/*  54 */     for (Map.Entry<Integer, ShiTuTask> entry : xShiTuTaskInfo.getTask_infos().entrySet())
/*     */     {
/*  56 */       sb.append(entry.getKey());
/*  57 */       sb.append(":");
/*  58 */       sb.append(((ShiTuTask)entry.getValue()).getTask_id());
/*  59 */       sb.append("、");
/*     */     }
/*  61 */     sbLog.append(sb.toString()).append('|');
/*  62 */     sbLog.append(xShiTuTaskInfo.getPublish_state());
/*  63 */     TLogManager.getInstance().addLog(masterRoleId, "ShiTuTaskMaster", sbLog.toString());
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
/*     */ 
/*     */ 
/*     */ 
/*     */   static void tlogShiTuTaskApprentice(long apprenticeRoleId, String apprenticeUserId, ShiTuTaskInfo xShiTuTaskInfo)
/*     */   {
/*  80 */     int apprenticeRoleLevel = RoleInterface.getLevel(apprenticeRoleId);
/*     */     
/*  82 */     StringBuilder sbLog = new StringBuilder();
/*  83 */     sbLog.append(GameServerInfoManager.getHostIP()).append('|');
/*     */     
/*  85 */     sbLog.append(apprenticeUserId).append('|');
/*  86 */     sbLog.append(apprenticeRoleId).append('|');
/*  87 */     sbLog.append(apprenticeRoleLevel).append('|');
/*     */     
/*  89 */     StringBuilder sb = new StringBuilder();
/*  90 */     for (Map.Entry<Integer, ShiTuTask> entry : xShiTuTaskInfo.getTask_infos().entrySet())
/*     */     {
/*  92 */       sb.append(entry.getKey());
/*  93 */       sb.append(":");
/*  94 */       sb.append(((ShiTuTask)entry.getValue()).getTask_id());
/*  95 */       sb.append("、");
/*     */     }
/*  97 */     sbLog.append(sb.toString()).append('|');
/*  98 */     sbLog.append(xShiTuTaskInfo.getPublish_state());
/*  99 */     TLogManager.getInstance().addLog(apprenticeRoleId, "ShiTuTaskApprentice", sbLog.toString());
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void tlogShiTuRecommend(long apprenticeRoleId, String apprenticeUserId, Set<Long> recommendRoleIds, ShiTuRecommendEnum operator)
/*     */   {
/* 118 */     int apprenticeRoleLevel = RoleInterface.getLevel(apprenticeRoleId);
/*     */     
/* 120 */     StringBuilder sbLog = new StringBuilder();
/* 121 */     sbLog.append(GameServerInfoManager.getHostIP()).append('|');
/*     */     
/* 123 */     sbLog.append(apprenticeUserId).append('|');
/* 124 */     sbLog.append(apprenticeRoleId).append('|');
/* 125 */     sbLog.append(apprenticeRoleLevel).append('|');
/*     */     
/* 127 */     sbLog.append(recommendRoleIds.toString()).append('|');
/* 128 */     sbLog.append(operator.getOperator());
/* 129 */     TLogManager.getInstance().addLog(apprenticeRoleId, "ShiTuRecommend", sbLog.toString());
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\shitu\main\ShiTuTLogManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */