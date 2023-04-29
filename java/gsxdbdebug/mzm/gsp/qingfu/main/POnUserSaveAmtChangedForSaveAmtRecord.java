/*    */ package mzm.gsp.qingfu.main;
/*    */ 
/*    */ import java.util.List;
/*    */ import mzm.gsp.util.DateTimeUtils;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.DaySaveAmtInfo;
/*    */ import xbean.Pod;
/*    */ import xbean.QingfuInfo;
/*    */ import xbean.RecentlyCashInfo;
/*    */ import xtable.Qingfu;
/*    */ 
/*    */ public class POnUserSaveAmtChangedForSaveAmtRecord
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final String userId;
/*    */   private final long oldSaveAmt;
/*    */   private final long currentSaveAmt;
/*    */   
/*    */   public POnUserSaveAmtChangedForSaveAmtRecord(String userId, long oldSaveAmt, long currentSaveAmt)
/*    */   {
/* 21 */     this.userId = userId;
/* 22 */     this.oldSaveAmt = oldSaveAmt;
/* 23 */     this.currentSaveAmt = currentSaveAmt;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 29 */     QingfuInfo xQingfuInfo = Qingfu.get(this.userId);
/* 30 */     if (xQingfuInfo == null)
/*    */     {
/* 32 */       return false;
/*    */     }
/*    */     
/* 35 */     RecentlyCashInfo xRecentlyCashInfo = xQingfuInfo.getRecently_cash_infos();
/* 36 */     long currentTimeMillis = DateTimeUtils.getCurrTimeInMillis();
/*    */     
/* 38 */     boolean isNeedAddNewCashDay = false;
/* 39 */     List<DaySaveAmtInfo> xDaySaveAmtInfoList = xRecentlyCashInfo.getDay_save_amt_list();
/* 40 */     if (xDaySaveAmtInfoList.size() == 0)
/*    */     {
/* 42 */       isNeedAddNewCashDay = true;
/*    */     }
/*    */     else
/*    */     {
/* 46 */       DaySaveAmtInfo xLastDaySaveAmtInfo = (DaySaveAmtInfo)xDaySaveAmtInfoList.get(xDaySaveAmtInfoList.size() - 1);
/* 47 */       long lastDayBeginTime = xLastDaySaveAmtInfo.getDay_begin_time();
/* 48 */       if (!DateTimeUtils.isInSameDay(currentTimeMillis, lastDayBeginTime))
/*    */       {
/* 50 */         isNeedAddNewCashDay = true;
/*    */       }
/*    */     }
/*    */     
/* 54 */     if (isNeedAddNewCashDay)
/*    */     {
/* 56 */       DaySaveAmtInfo xDaySaveAmtInfo = Pod.newDaySaveAmtInfo();
/* 57 */       xDaySaveAmtInfo.setDay_begin_time(DateTimeUtils.getBeginTimeOfCurrDay(currentTimeMillis));
/* 58 */       xDaySaveAmtInfo.setSave_amt(this.oldSaveAmt);
/* 59 */       xDaySaveAmtInfoList.add(xDaySaveAmtInfo);
/*    */     }
/*    */     
/* 62 */     SaveAmtRecordManager.updateSaveAmtRecordInfo(this.userId, currentTimeMillis, xRecentlyCashInfo, this.currentSaveAmt);
/*    */     
/* 64 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\qingfu\main\POnUserSaveAmtChangedForSaveAmtRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */