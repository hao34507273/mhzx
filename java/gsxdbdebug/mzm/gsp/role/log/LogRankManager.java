/*     */ package mzm.gsp.role.log;
/*     */ 
/*     */ import java.util.Map;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.chart.confbean.ChartConsts;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import xbean.LogRankData;
/*     */ import xbean.Pod;
/*     */ import xbean.RecordData;
/*     */ import xbean.RoleRankData;
/*     */ import xdb.Procedure;
/*     */ import xtable.Logrolerank;
/*     */ 
/*     */ 
/*     */ public class LogRankManager
/*     */ {
/*     */   static int getCfgTopNum()
/*     */   {
/*  19 */     return ChartConsts.getInstance().ROLE_RANK_LOG_NUM;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static LogRankData getLogRankDataIfAbsent()
/*     */   {
/*  31 */     LogRankData xLogRankData = Logrolerank.get(Long.valueOf(GameServerInfoManager.getLocalId()));
/*  32 */     if (xLogRankData == null)
/*     */     {
/*  34 */       xLogRankData = Pod.newLogRankData();
/*  35 */       Logrolerank.insert(Long.valueOf(GameServerInfoManager.getLocalId()), xLogRankData);
/*     */     }
/*  37 */     return xLogRankData;
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
/*     */   static RecordData getXRecordDataIfAbsent(int logRankType, long curTime)
/*     */   {
/*  53 */     LogRankData xLogRankData = getLogRankDataIfAbsent();
/*  54 */     return getXRecordDataIfAbsent(logRankType, curTime, xLogRankData);
/*     */   }
/*     */   
/*     */   static RecordData getXRecordDataIfAbsent(int logRankType, long curTime, LogRankData xLogRankData)
/*     */   {
/*  59 */     RecordData xRecordData = (RecordData)xLogRankData.getType2rankdata().get(Integer.valueOf(logRankType));
/*  60 */     if (xRecordData == null)
/*     */     {
/*  62 */       xRecordData = Pod.newRecordData();
/*  63 */       xRecordData.setLastlogtime(curTime);
/*  64 */       xLogRankData.getType2rankdata().put(Integer.valueOf(logRankType), xRecordData);
/*     */     }
/*  66 */     return xRecordData;
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
/*     */   static void refreshLogRankdata(Map<Long, RoleRankData> rankDatas, long roleId, int rankValue, long curTime)
/*     */   {
/*  79 */     RoleRankData xRankData = (RoleRankData)rankDatas.get(Long.valueOf(roleId));
/*  80 */     if (xRankData == null)
/*     */     {
/*  82 */       xRankData = Pod.newRoleRankData();
/*  83 */       rankDatas.put(Long.valueOf(roleId), xRankData);
/*     */     }
/*  85 */     if (xRankData.getMaxvalue() >= rankValue)
/*     */     {
/*  87 */       return;
/*     */     }
/*     */     
/*  90 */     xRankData.setLogtime(curTime);
/*  91 */     xRankData.setMaxvalue(rankValue);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void logFVRankAsyn()
/*     */   {
/*  99 */     if (!isLogFVRankOpen())
/*     */     {
/* 101 */       return;
/*     */     }
/* 103 */     Procedure.execute(new PFVRank());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void logMFVRankAsyn()
/*     */   {
/* 111 */     if (!isLogMFVRankOpen())
/*     */     {
/* 113 */       return;
/*     */     }
/* 115 */     Procedure.execute(new PMFVRank());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static boolean isLogFVRankOpen()
/*     */   {
/* 125 */     if (!OpenInterface.getOpenStatus(178))
/*     */     {
/* 127 */       return false;
/*     */     }
/* 129 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static boolean isLogMFVRankOpen()
/*     */   {
/* 139 */     if (!OpenInterface.getOpenStatus(179))
/*     */     {
/* 141 */       return false;
/*     */     }
/* 143 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\log\LogRankManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */