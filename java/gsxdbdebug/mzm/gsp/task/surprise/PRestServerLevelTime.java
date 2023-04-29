/*     */ package mzm.gsp.task.surprise;
/*     */ 
/*     */ import java.util.Calendar;
/*     */ import java.util.Map;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.gm.main.GmManager;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.Pair;
/*     */ import xbean.LevelStartTimeData;
/*     */ import xtable.Levelstarttime;
/*     */ 
/*     */ public class PRestServerLevelTime extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final String startDate;
/*     */   
/*     */   public PRestServerLevelTime(long roleId, String startDate)
/*     */   {
/*  20 */     this.roleId = roleId;
/*  21 */     this.startDate = startDate;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  27 */     SurpriseOptionResult res = resetServerLevelTime(this.startDate);
/*  28 */     if (res == SurpriseOptionResult.SUCCESS)
/*     */     {
/*  30 */       GmManager.getInstance().sendResultToGM(this.roleId, "设置成功！");
/*  31 */       return true;
/*     */     }
/*  33 */     if (res == SurpriseOptionResult.FORMAT_ERROR)
/*     */     {
/*  35 */       GmManager.getInstance().sendResultToGM(this.roleId, "时间格式错误(yyyymmddhhMMss).");
/*  36 */       return false;
/*     */     }
/*  38 */     if (res == SurpriseOptionResult.OVER_CURRENT_TIME_ERROR)
/*     */     {
/*  40 */       GmManager.getInstance().sendResultToGM(this.roleId, "设置时间不能大于当前时间！");
/*  41 */       return false;
/*     */     }
/*  43 */     GmManager.getInstance().sendResultToGM(this.roleId, "未知错误！");
/*  44 */     return false;
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
/*     */   public static SurpriseOptionResult resetServerLevelTime(long startDate)
/*     */   {
/*  60 */     if (startDate > DateTimeUtils.getCurrTimeInMillis())
/*     */     {
/*  62 */       return SurpriseOptionResult.OVER_CURRENT_TIME_ERROR;
/*     */     }
/*  64 */     return new InitCurServerLevelStartTime(startDate).call() ? SurpriseOptionResult.SUCCESS : SurpriseOptionResult.UNKNOWN_ERROR;
/*     */   }
/*     */   
/*     */ 
/*     */   static SurpriseOptionResult resetServerLevelTime(String startDate)
/*     */   {
/*  70 */     Pair<SurpriseOptionResult, Long> pair = getAwardTimeMills(startDate);
/*  71 */     if (pair.first != SurpriseOptionResult.SUCCESS)
/*     */     {
/*  73 */       return (SurpriseOptionResult)pair.first;
/*     */     }
/*  75 */     if (((Long)pair.second).longValue() <= 0L)
/*     */     {
/*  77 */       return SurpriseOptionResult.UNKNOWN_ERROR;
/*     */     }
/*  79 */     if (((Long)pair.second).longValue() > DateTimeUtils.getCurrTimeInMillis())
/*     */     {
/*  81 */       return SurpriseOptionResult.OVER_CURRENT_TIME_ERROR;
/*     */     }
/*     */     
/*  84 */     return new InitCurServerLevelStartTime(((Long)pair.second).longValue()).call() ? SurpriseOptionResult.SUCCESS : SurpriseOptionResult.UNKNOWN_ERROR;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static String getServerLevelTime()
/*     */   {
/*  95 */     return ServerLevelCache.getInstance().getServerLevelInfoString();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static class InitCurServerLevelStartTime
/*     */     extends mzm.gsp.util.LogicProcedure
/*     */   {
/*     */     private final long initTime;
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     InitCurServerLevelStartTime(long initTime)
/*     */     {
/* 114 */       this.initTime = initTime;
/*     */     }
/*     */     
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/* 120 */       int curServerLevel = mzm.gsp.server.main.ServerInterface.getCurrentServerLevel();
/*     */       
/* 122 */       LevelStartTimeData xLevelStartTimeData = Levelstarttime.get(Long.valueOf(GameServerInfoManager.getLocalId()));
/* 123 */       if (xLevelStartTimeData == null)
/*     */       {
/* 125 */         Levelstarttime.insert(Long.valueOf(GameServerInfoManager.getLocalId()), xLevelStartTimeData = xbean.Pod.newLevelStartTimeData());
/*     */       }
/*     */       
/*     */ 
/* 129 */       xLevelStartTimeData.getServerlevel2starttime().clear();
/*     */       
/* 131 */       xLevelStartTimeData.getServerlevel2starttime().put(Integer.valueOf(curServerLevel), Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(this.initTime)));
/*     */       
/* 133 */       ServerLevelCache.getInstance().initServerLevelStartTime(xLevelStartTimeData.getServerlevel2starttime());
/* 134 */       return true;
/*     */     }
/*     */   }
/*     */   
/*     */   private static Pair<SurpriseOptionResult, Long> getAwardTimeMills(String timeStr)
/*     */   {
/* 140 */     Pair<SurpriseOptionResult, Long> pair = new Pair(SurpriseOptionResult.UNKNOWN_ERROR, Long.valueOf(-1L));
/* 141 */     if (timeStr.length() != 14)
/*     */     {
/* 143 */       pair.first = SurpriseOptionResult.FORMAT_ERROR;
/* 144 */       pair.second = Long.valueOf(-1L);
/* 145 */       return pair;
/*     */     }
/*     */     try
/*     */     {
/* 149 */       int year = Integer.parseInt(timeStr.substring(0, 4));
/* 150 */       int month = Integer.parseInt(timeStr.substring(4, 6)) - 1;
/* 151 */       int day = Integer.parseInt(timeStr.substring(6, 8));
/* 152 */       int hour = Integer.parseInt(timeStr.substring(8, 10));
/* 153 */       int minute = Integer.parseInt(timeStr.substring(10, 12));
/* 154 */       int second = Integer.parseInt(timeStr.substring(12, 14));
/* 155 */       Calendar calendar = DateTimeUtils.getCalendar();
/* 156 */       calendar.clear();
/* 157 */       calendar.set(year, month, day, hour, minute, second);
/* 158 */       pair.first = SurpriseOptionResult.SUCCESS;
/* 159 */       pair.second = Long.valueOf(calendar.getTimeInMillis());
/* 160 */       return pair;
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 164 */       pair.first = SurpriseOptionResult.UNKNOWN_ERROR;
/* 165 */       pair.second = Long.valueOf(-1L); }
/* 166 */     return pair;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\task\surprise\PRestServerLevelTime.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */