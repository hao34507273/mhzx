/*    */ package mzm.gsp.task.surprise;
/*    */ 
/*    */ import java.text.SimpleDateFormat;
/*    */ import java.util.HashMap;
/*    */ import java.util.HashSet;
/*    */ import java.util.Map;
/*    */ import java.util.Map.Entry;
/*    */ import java.util.Set;
/*    */ import java.util.concurrent.TimeUnit;
/*    */ import mzm.gsp.util.DateTimeUtils;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SurpriseTaskScheduleInfo
/*    */ {
/* 16 */   Set<Integer> doneGraphIds = new HashSet();
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 21 */   Map<Integer, Map<Integer, Long>> needMonitorInfo = new HashMap();
/*    */   
/*    */   String getSessionOverTime()
/*    */   {
/* 25 */     long curTime = DateTimeUtils.getCurrTimeInMillis();
/* 26 */     StringBuffer sb = new StringBuffer();
/* 27 */     for (Map.Entry<Integer, Map<Integer, Long>> entry : this.needMonitorInfo.entrySet())
/*    */     {
/* 29 */       serverlLevel = ((Integer)entry.getKey()).intValue();
/* 30 */       for (Map.Entry<Integer, Long> entry1 : ((Map)entry.getValue()).entrySet())
/*    */       {
/* 32 */         int needDay = ((Integer)entry1.getKey()).intValue();
/* 33 */         long second = ((Long)entry1.getValue()).longValue();
/*    */         
/* 35 */         String dateStr = getTimeDate(curTime + TimeUnit.SECONDS.toMillis(second));
/* 36 */         sb.append("\r\n").append("needServerLevel=").append(serverlLevel).append("|needDays=").append(needDay).append("|").append(dateStr);
/*    */       }
/*    */     }
/*    */     int serverlLevel;
/* 40 */     return sb.toString();
/*    */   }
/*    */   
/*    */   private String getTimeDate(long time)
/*    */   {
/* 45 */     SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
/* 46 */     String startDate = sdf.format(Long.valueOf(time));
/* 47 */     return startDate;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\task\surprise\SurpriseTaskScheduleInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */