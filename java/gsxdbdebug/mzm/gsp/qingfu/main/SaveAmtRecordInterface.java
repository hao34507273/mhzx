/*     */ package mzm.gsp.qingfu.main;
/*     */ 
/*     */ import java.util.List;
/*     */ import mzm.gsp.qingfu.confbean.SQingfuCfgConsts;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import xbean.DaySaveAmtInfo;
/*     */ import xbean.QingfuInfo;
/*     */ import xbean.RecentlyCashInfo;
/*     */ import xtable.Qingfu;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SaveAmtRecordInterface
/*     */ {
/*     */   public static long getLastWeekSaveAmt(String userId)
/*     */   {
/*  18 */     QingfuInfo xQingfuInfo = Qingfu.get(userId);
/*  19 */     if (xQingfuInfo == null)
/*     */     {
/*  21 */       return 0L;
/*     */     }
/*     */     
/*  24 */     RecentlyCashInfo xRecentlyCashInfo = xQingfuInfo.getRecently_cash_infos();
/*  25 */     List<DaySaveAmtInfo> xDaySaveAmtInfoList = xRecentlyCashInfo.getDay_save_amt_list();
/*  26 */     if (xDaySaveAmtInfoList.isEmpty())
/*     */     {
/*  28 */       return 0L;
/*     */     }
/*     */     
/*  31 */     long currentTimeMillis = DateTimeUtils.getCurrTimeInMillis();
/*  32 */     if (DateTimeUtils.isInSameDay(currentTimeMillis, xRecentlyCashInfo.getLast_cash_amt_refresh_time()))
/*     */     {
/*  34 */       return xRecentlyCashInfo.getLast_week_cash_amt();
/*     */     }
/*     */     
/*  37 */     DaySaveAmtInfo xLastDaySaveAmtInfo = (DaySaveAmtInfo)xDaySaveAmtInfoList.get(xDaySaveAmtInfoList.size() - 1);
/*  38 */     SaveAmtRecordManager.updateSaveAmtRecordInfo(userId, currentTimeMillis, xRecentlyCashInfo, xLastDaySaveAmtInfo);
/*     */     
/*  40 */     return xRecentlyCashInfo.getLast_two_week_cash_amt();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static long getLastTwoWeekSaveAmt(String userId)
/*     */   {
/*  51 */     QingfuInfo xQingfuInfo = Qingfu.get(userId);
/*  52 */     if (xQingfuInfo == null)
/*     */     {
/*  54 */       return 0L;
/*     */     }
/*     */     
/*  57 */     RecentlyCashInfo xRecentlyCashInfo = xQingfuInfo.getRecently_cash_infos();
/*  58 */     List<DaySaveAmtInfo> xDaySaveAmtInfoList = xRecentlyCashInfo.getDay_save_amt_list();
/*  59 */     if (xDaySaveAmtInfoList.isEmpty())
/*     */     {
/*  61 */       return 0L;
/*     */     }
/*     */     
/*  64 */     long currentTimeMillis = DateTimeUtils.getCurrTimeInMillis();
/*  65 */     if (DateTimeUtils.isInSameDay(currentTimeMillis, xRecentlyCashInfo.getLast_cash_amt_refresh_time()))
/*     */     {
/*  67 */       return xRecentlyCashInfo.getLast_two_week_cash_amt();
/*     */     }
/*     */     
/*     */ 
/*  71 */     DaySaveAmtInfo xLastDaySaveAmtInfo = (DaySaveAmtInfo)xDaySaveAmtInfoList.get(xDaySaveAmtInfoList.size() - 1);
/*  72 */     SaveAmtRecordManager.updateSaveAmtRecordInfo(userId, currentTimeMillis, xRecentlyCashInfo, xLastDaySaveAmtInfo);
/*     */     
/*  74 */     return xRecentlyCashInfo.getLast_two_week_cash_amt();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static long getLastOneMonthSaveAmt(String userId)
/*     */   {
/*  85 */     QingfuInfo xQingfuInfo = Qingfu.get(userId);
/*  86 */     if (xQingfuInfo == null)
/*     */     {
/*  88 */       return 0L;
/*     */     }
/*     */     
/*  91 */     RecentlyCashInfo xRecentlyCashInfo = xQingfuInfo.getRecently_cash_infos();
/*  92 */     List<DaySaveAmtInfo> xDaySaveAmtInfoList = xRecentlyCashInfo.getDay_save_amt_list();
/*  93 */     if (xDaySaveAmtInfoList.isEmpty())
/*     */     {
/*  95 */       return 0L;
/*     */     }
/*     */     
/*  98 */     long currentTimeMillis = DateTimeUtils.getCurrTimeInMillis();
/*  99 */     if (DateTimeUtils.isInSameDay(currentTimeMillis, xRecentlyCashInfo.getLast_cash_amt_refresh_time()))
/*     */     {
/* 101 */       return xRecentlyCashInfo.getLast_month_cash_amt();
/*     */     }
/*     */     
/*     */ 
/* 105 */     DaySaveAmtInfo xLastDaySaveAmtInfo = (DaySaveAmtInfo)xDaySaveAmtInfoList.get(xDaySaveAmtInfoList.size() - 1);
/* 106 */     SaveAmtRecordManager.updateSaveAmtRecordInfo(userId, currentTimeMillis, xRecentlyCashInfo, xLastDaySaveAmtInfo);
/*     */     
/* 108 */     return xRecentlyCashInfo.getLast_month_cash_amt();
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
/*     */   public static long getRecentlySaveAmt(String userId, int days)
/*     */   {
/* 121 */     if (days <= 0)
/*     */     {
/* 123 */       return 0L;
/*     */     }
/*     */     
/* 126 */     QingfuInfo xQingfuInfo = Qingfu.get(userId);
/* 127 */     if (xQingfuInfo == null)
/*     */     {
/* 129 */       return 0L;
/*     */     }
/*     */     
/* 132 */     RecentlyCashInfo xRecentlyCashInfo = xQingfuInfo.getRecently_cash_infos();
/* 133 */     List<DaySaveAmtInfo> xDaySaveAmtInfoList = xRecentlyCashInfo.getDay_save_amt_list();
/* 134 */     if (xDaySaveAmtInfoList.isEmpty())
/*     */     {
/* 136 */       return 0L;
/*     */     }
/*     */     
/* 139 */     if (days >= SQingfuCfgConsts.getInstance().RECENT_SAVE_AMT_RECORD_DAYS)
/*     */     {
/* 141 */       return getLastOneMonthSaveAmt(userId);
/*     */     }
/*     */     
/* 144 */     long currentSaveAmt = QingfuInterface.getSaveAmt(userId, true);
/* 145 */     long baseSaveAmt = -1L;
/* 146 */     long currentTimeMillis = DateTimeUtils.getCurrTimeInMillis();
/* 147 */     for (int index = xDaySaveAmtInfoList.size() - 1; index >= 0; index--)
/*     */     {
/* 149 */       DaySaveAmtInfo xTempDaySaveAmtInfo = (DaySaveAmtInfo)xDaySaveAmtInfoList.get(index);
/* 150 */       long deltaDay = (currentTimeMillis - xTempDaySaveAmtInfo.getDay_begin_time()) / 86400000L + 1L;
/*     */       
/* 152 */       if (deltaDay > days)
/*     */         break;
/* 154 */       baseSaveAmt = xTempDaySaveAmtInfo.getSave_amt();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 160 */     if (baseSaveAmt == -1L)
/*     */     {
/* 162 */       return 0L;
/*     */     }
/* 164 */     return currentSaveAmt - baseSaveAmt;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\qingfu\main\SaveAmtRecordInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */