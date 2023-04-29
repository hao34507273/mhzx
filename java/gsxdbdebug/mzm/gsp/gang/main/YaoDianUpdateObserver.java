/*    */ package mzm.gsp.gang.main;
/*    */ 
/*    */ import java.util.Calendar;
/*    */ import java.util.Set;
/*    */ import java.util.concurrent.TimeUnit;
/*    */ import mzm.gsp.common.TimeCommonUtil;
/*    */ import mzm.gsp.gang.confbean.SGangConst;
/*    */ import mzm.gsp.timer.main.MilliObserver;
/*    */ import mzm.gsp.util.DateTimeUtils;
/*    */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class YaoDianUpdateObserver
/*    */   extends MilliObserver
/*    */ {
/* 19 */   private static Logger logger = Logger.getLogger(YaoDianUpdateObserver.class);
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public YaoDianUpdateObserver(long intervalMilliSeconds)
/*    */   {
/* 26 */     super(intervalMilliSeconds);
/* 27 */     if (logger.isDebugEnabled()) {
/* 28 */       logger.debug("帮派药店开启，将在" + TimeCommonUtil.format(intervalMilliSeconds + DateTimeUtils.getCurrTimeInMillis(), "yyyy-MM-dd HH:mm:ss"));
/*    */     }
/*    */   }
/*    */   
/*    */   public boolean update()
/*    */   {
/* 34 */     Set<Long> gangIdSet = GangManager.getAllGangIdSet();
/* 35 */     for (Long gangId : gangIdSet) {
/* 36 */       NoneRealTimeTaskManager.getInstance().addTask(new PYaoDianUpdate(gangId.longValue()));
/*    */     }
/* 38 */     nextUpdate();
/* 39 */     if (logger.isDebugEnabled()) {
/* 40 */       logger.debug("帮派药店更新结束");
/*    */     }
/* 42 */     return false;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   static void nextUpdate()
/*    */   {
/* 50 */     long now = DateTimeUtils.getCurrTimeInMillis();
/* 51 */     Calendar calendar = DateTimeUtils.getCalendar();
/* 52 */     calendar.setTimeInMillis(now);
/* 53 */     calendar.set(12, 0);
/* 54 */     calendar.set(13, 0);
/* 55 */     calendar.set(14, 0);
/*    */     
/* 57 */     long pastPreBegin = now - calendar.getTimeInMillis();
/* 58 */     long interval = TimeUnit.MINUTES.toMillis(SGangConst.getInstance().GANG_YAODIAN_REFRESH_INTERVAL_M);
/* 59 */     long bestTime = interval - pastPreBegin;
/* 60 */     if (bestTime < 0L)
/*    */     {
/* 62 */       long nextPreBegin = 3600000L - pastPreBegin;
/* 63 */       bestTime = nextPreBegin + interval;
/*    */     }
/* 65 */     new YaoDianUpdateObserver(bestTime);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\main\YaoDianUpdateObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */