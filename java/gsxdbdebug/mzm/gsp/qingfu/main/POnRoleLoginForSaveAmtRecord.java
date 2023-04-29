/*    */ package mzm.gsp.qingfu.main;
/*    */ 
/*    */ import java.util.List;
/*    */ import mzm.gsp.util.DateTimeUtils;
/*    */ import xbean.DaySaveAmtInfo;
/*    */ import xbean.RecentlyCashInfo;
/*    */ 
/*    */ public class POnRoleLoginForSaveAmtRecord extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final String userId;
/*    */   
/*    */   public POnRoleLoginForSaveAmtRecord(String userId)
/*    */   {
/* 14 */     this.userId = userId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 20 */     xbean.QingfuInfo xQingfuInfo = xtable.Qingfu.get(this.userId);
/* 21 */     if (xQingfuInfo == null)
/*    */     {
/* 23 */       return false;
/*    */     }
/*    */     
/* 26 */     long currentTimeMillis = DateTimeUtils.getCurrTimeInMillis();
/*    */     
/* 28 */     RecentlyCashInfo xRecentlyCashInfo = xQingfuInfo.getRecently_cash_infos();
/* 29 */     List<DaySaveAmtInfo> xDayCashAmtInfoList = xRecentlyCashInfo.getDay_save_amt_list();
/*    */     
/* 31 */     long currentSaveAmt = QingfuInterface.getSaveAmt(this.userId, true);
/*    */     
/* 33 */     boolean isNeedAddNewCashDay = false;
/* 34 */     if (!xDayCashAmtInfoList.isEmpty())
/*    */     {
/* 36 */       DaySaveAmtInfo xLastDaySaveAmtInfo = (DaySaveAmtInfo)xDayCashAmtInfoList.get(xDayCashAmtInfoList.size() - 1);
/* 37 */       boolean isInSameDay = DateTimeUtils.isInSameDay(currentTimeMillis, xLastDaySaveAmtInfo.getDay_begin_time());
/* 38 */       if ((!isInSameDay) && (xLastDaySaveAmtInfo.getSave_amt() != currentSaveAmt))
/*    */       {
/* 40 */         isNeedAddNewCashDay = true;
/*    */       }
/*    */     }
/* 43 */     else if (currentSaveAmt != 0L)
/*    */     {
/* 45 */       isNeedAddNewCashDay = true;
/*    */     }
/*    */     
/* 48 */     if (isNeedAddNewCashDay)
/*    */     {
/* 50 */       DaySaveAmtInfo xDaySaveAmtInfo = xbean.Pod.newDaySaveAmtInfo();
/* 51 */       xDaySaveAmtInfo.setDay_begin_time(DateTimeUtils.getBeginTimeOfCurrDay(currentTimeMillis));
/* 52 */       xDaySaveAmtInfo.setSave_amt(currentSaveAmt);
/*    */       
/* 54 */       xDayCashAmtInfoList.add(xDaySaveAmtInfo);
/*    */     }
/*    */     
/* 57 */     SaveAmtRecordManager.updateSaveAmtRecordInfo(this.userId, currentTimeMillis, xRecentlyCashInfo, currentSaveAmt);
/*    */     
/* 59 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\qingfu\main\POnRoleLoginForSaveAmtRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */