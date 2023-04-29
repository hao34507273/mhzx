/*     */ package mzm.gsp.qingfu.main;
/*     */ 
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import mzm.gsp.qingfu.confbean.SQingfuCfgConsts;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import xbean.DaySaveAmtInfo;
/*     */ import xbean.Pod;
/*     */ import xbean.RecentlyCashInfo;
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
/*     */ public class SaveAmtRecordManager
/*     */ {
/*     */   static void updateSaveAmtRecordInfo(String userId, long currentTimeMillis, RecentlyCashInfo xRecentlyCashInfo, long currentSaveAmt)
/*     */   {
/*  26 */     List<DaySaveAmtInfo> xDayCashAmtInfoList = xRecentlyCashInfo.getDay_save_amt_list();
/*     */     
/*  28 */     Iterator<DaySaveAmtInfo> iterator = xDayCashAmtInfoList.iterator();
/*  29 */     while (iterator.hasNext())
/*     */     {
/*  31 */       DaySaveAmtInfo xDayCashAmtInfo = (DaySaveAmtInfo)iterator.next();
/*  32 */       long deltaDays = (currentTimeMillis - xDayCashAmtInfo.getDay_begin_time()) / 86400000L + 1L;
/*     */       
/*     */ 
/*  35 */       if (deltaDays <= SQingfuCfgConsts.getInstance().RECENT_SAVE_AMT_RECORD_DAYS)
/*     */         break;
/*  37 */       iterator.remove();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  44 */     long lastWeekCashBaseAmt = -1L;
/*  45 */     long lastTwoWeekCashBaseAmt = -1L;
/*  46 */     long lastMonthCashBaseAmt = -1L;
/*  47 */     for (int index = xDayCashAmtInfoList.size() - 1; index >= 0; index--)
/*     */     {
/*  49 */       DaySaveAmtInfo xTempDaySaveAmtInfo = (DaySaveAmtInfo)xDayCashAmtInfoList.get(index);
/*  50 */       long deltaDay = (currentTimeMillis - xTempDaySaveAmtInfo.getDay_begin_time()) / 86400000L + 1L;
/*     */       
/*  52 */       if (deltaDay <= 7L)
/*     */       {
/*  54 */         lastWeekCashBaseAmt = xTempDaySaveAmtInfo.getSave_amt();
/*     */       }
/*     */       
/*  57 */       if (deltaDay <= 14L)
/*     */       {
/*  59 */         lastTwoWeekCashBaseAmt = xTempDaySaveAmtInfo.getSave_amt();
/*     */       }
/*     */       
/*  62 */       if (deltaDay <= 30L)
/*     */       {
/*  64 */         lastMonthCashBaseAmt = xTempDaySaveAmtInfo.getSave_amt();
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*  69 */     long newLastWeekCashAmt = currentSaveAmt - lastWeekCashBaseAmt;
/*  70 */     if (newLastWeekCashAmt != xRecentlyCashInfo.getLast_week_cash_amt())
/*     */     {
/*  72 */       xRecentlyCashInfo.setLast_week_cash_amt(lastWeekCashBaseAmt == -1L ? 0L : newLastWeekCashAmt);
/*     */     }
/*     */     
/*     */ 
/*  76 */     long newLastTwoWeekCashAmt = currentSaveAmt - lastTwoWeekCashBaseAmt;
/*  77 */     if (newLastTwoWeekCashAmt != xRecentlyCashInfo.getLast_two_week_cash_amt())
/*     */     {
/*  79 */       xRecentlyCashInfo.setLast_two_week_cash_amt(lastTwoWeekCashBaseAmt == -1L ? 0L : newLastTwoWeekCashAmt);
/*     */     }
/*     */     
/*     */ 
/*  83 */     long newLastMonthCashAmt = currentSaveAmt - lastMonthCashBaseAmt;
/*  84 */     if (newLastMonthCashAmt != xRecentlyCashInfo.getLast_month_cash_amt())
/*     */     {
/*  86 */       xRecentlyCashInfo.setLast_month_cash_amt(lastMonthCashBaseAmt == -1L ? 0L : newLastMonthCashAmt);
/*     */     }
/*     */     
/*     */ 
/*  90 */     xRecentlyCashInfo.setLast_cash_amt_refresh_time(currentTimeMillis);
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
/*     */   static void updateSaveAmtRecordInfo(String userId, long currentTimeMillis, RecentlyCashInfo xRecentlyCashInfo, DaySaveAmtInfo xLastDaySaveAmtInfo)
/*     */   {
/* 106 */     long currentSaveAmt = QingfuInterface.getSaveAmt(userId, true);
/* 107 */     if (xLastDaySaveAmtInfo.getSave_amt() < currentSaveAmt)
/*     */     {
/* 109 */       DaySaveAmtInfo xDaySaveAmtInfo = Pod.newDaySaveAmtInfo();
/* 110 */       xDaySaveAmtInfo.setDay_begin_time(DateTimeUtils.getBeginTimeOfCurrDay(currentTimeMillis));
/* 111 */       xDaySaveAmtInfo.setSave_amt(currentSaveAmt);
/*     */       
/* 113 */       xRecentlyCashInfo.getDay_save_amt_list().add(xDaySaveAmtInfo);
/*     */     }
/*     */     
/* 116 */     updateSaveAmtRecordInfo(userId, currentTimeMillis, xRecentlyCashInfo, currentSaveAmt);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\qingfu\main\SaveAmtRecordManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */