/*    */ package mzm.gsp.mergecompensation.main;
/*    */ 
/*    */ import java.text.SimpleDateFormat;
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.tlog.TLogManager;
/*    */ import mzm.gsp.util.DateTimeUtils;
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
/*    */ public class MergeCompensationTlogManager
/*    */ {
/*    */   static void addTlog(long zoneid, long mainZoneid, long mergeSystemTimestamp, long mergeTimeOffset, int serverLevel, long startTime, long timeOffset, int mainServerLevel, long mainStartTime, long mainTimeOffset, int deltaDay, boolean isDataAvailable)
/*    */   {
/* 35 */     String GameSvrId = String.valueOf(GameServerInfoManager.getZoneId());
/* 36 */     SimpleDateFormat sdf = DateTimeUtils.getSimpleDateFormat("yyyy-MM-dd HH:mm:ss");
/* 37 */     long time = DateTimeUtils.getCurrTimeInMillis();
/* 38 */     String dtEventTime = sdf.format(Long.valueOf(time));
/* 39 */     String vGameAppid = "0";
/* 40 */     int PlatID = -1;
/* 41 */     int iZoneAreaID = GameServerInfoManager.getZoneId();
/* 42 */     String vopenid = "0";
/*    */     
/* 44 */     String vGameIP = GameServerInfoManager.getHostIP();
/* 45 */     String logStr = String.format("%s|%s|%s|%d|%d|%s|%s|%d|%d|%d|%d|%d|%d|%d|%d|%d|%d|%d|%d", new Object[] { GameSvrId, dtEventTime, "0", Integer.valueOf(-1), Integer.valueOf(iZoneAreaID), "0", vGameIP, Long.valueOf(zoneid), Long.valueOf(mainZoneid), Long.valueOf(mergeSystemTimestamp), Long.valueOf(mergeTimeOffset), Integer.valueOf(serverLevel), Long.valueOf(startTime), Long.valueOf(timeOffset), Integer.valueOf(mainServerLevel), Long.valueOf(mainStartTime), Long.valueOf(mainTimeOffset), Integer.valueOf(deltaDay), Integer.valueOf(isDataAvailable ? 1 : 0) });
/*    */     
/*    */ 
/*    */ 
/* 49 */     TLogManager.getInstance().addLog("MergeCompensationForServer", logStr);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mergecompensation\main\MergeCompensationTlogManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */