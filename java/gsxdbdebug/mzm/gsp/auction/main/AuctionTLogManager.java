/*    */ package mzm.gsp.auction.main;
/*    */ 
/*    */ import java.text.SimpleDateFormat;
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.tlog.TLogManager;
/*    */ import mzm.gsp.util.DateTimeUtils;
/*    */ 
/*    */ 
/*    */ public class AuctionTLogManager
/*    */ {
/*    */   private static final String T_LOG_BID = "AuctionBidLog";
/*    */   private static final String T_LOG_REFUND = "AuctionRefundLog";
/*    */   private static final String T_LOG_SEND_ITEM = "AuctionSendItemLog";
/*    */   
/*    */   private static void doTLog(long roleId, String tLogName, Object[] logColumns)
/*    */   {
/* 18 */     String userId = RoleInterface.getUserId(roleId);
/*    */     
/* 20 */     logColumns[0] = GameServerInfoManager.getHostIP();
/* 21 */     logColumns[1] = userId;
/* 22 */     logColumns[2] = Long.valueOf(roleId);
/* 23 */     logColumns[3] = Integer.valueOf(RoleInterface.getLevel(roleId));
/*    */     
/* 25 */     TLogManager.getInstance().addLog(userId, tLogName, logColumns);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   static void tLogAuctionBidLog(long roleId, int activityId, long activityPeriodStartTimeStamp, long activityPeriodEndTimeStamp, int turnIndex, long turnStartTimeStamp, long turnEndTimeStamp, int itemCfgId, long itemBidLastEndTimeStamp, long itemBidCurrEndTimeStamp, long itemBidFinalEndTimeStamp, long lastBidderRoleId, long lastBidPrice, long currBidPrice)
/*    */   {
/* 34 */     SimpleDateFormat simpleDateFormat = DateTimeUtils.getSimpleDateFormat("yyyy-MM-dd HH:mm:ss");
/*    */     
/* 36 */     Object[] logColumns = new Object[17];
/* 37 */     logColumns[4] = Integer.valueOf(activityId);
/* 38 */     logColumns[5] = simpleDateFormat.format(Long.valueOf(activityPeriodStartTimeStamp));
/* 39 */     logColumns[6] = simpleDateFormat.format(Long.valueOf(activityPeriodEndTimeStamp));
/* 40 */     logColumns[7] = Integer.valueOf(turnIndex);
/* 41 */     logColumns[8] = simpleDateFormat.format(Long.valueOf(turnStartTimeStamp));
/* 42 */     logColumns[9] = simpleDateFormat.format(Long.valueOf(turnEndTimeStamp));
/* 43 */     logColumns[10] = Integer.valueOf(itemCfgId);
/* 44 */     logColumns[11] = simpleDateFormat.format(Long.valueOf(itemBidLastEndTimeStamp));
/* 45 */     logColumns[12] = simpleDateFormat.format(Long.valueOf(itemBidCurrEndTimeStamp));
/* 46 */     logColumns[13] = simpleDateFormat.format(Long.valueOf(itemBidFinalEndTimeStamp));
/* 47 */     logColumns[14] = Long.valueOf(lastBidderRoleId);
/* 48 */     logColumns[15] = Long.valueOf(lastBidPrice);
/* 49 */     logColumns[16] = Long.valueOf(currBidPrice);
/*    */     
/* 51 */     doTLog(roleId, "AuctionBidLog", logColumns);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   static void tLogAuctionRefund(int activityId, long activityPeriodStartTimeStamp, long activityPeriodEndTimeStamp, int turnIndex, long turnStartTimeStamp, long turnEndTimeStamp, int itemCfgId, long roleId, long moneyCount, int refundMailId, int logReason, String extraReason)
/*    */   {
/* 59 */     String GameSvrId = String.valueOf(GameServerInfoManager.getZoneId());
/* 60 */     SimpleDateFormat sdf = DateTimeUtils.getSimpleDateFormat("yyyy-MM-dd HH:mm:ss");
/* 61 */     long time = DateTimeUtils.getCurrTimeInMillis();
/* 62 */     String dtEventTime = sdf.format(Long.valueOf(time));
/*    */     
/* 64 */     String vGameAppid = "0";
/* 65 */     int PlatID = -1;
/* 66 */     int iZoneAreaID = GameServerInfoManager.getZoneId();
/* 67 */     String vopenid = "0";
/*    */     
/* 69 */     Object[] logColumns = { GameSvrId, dtEventTime, "0", Integer.valueOf(-1), Integer.valueOf(iZoneAreaID), "0", Integer.valueOf(activityId), sdf.format(Long.valueOf(activityPeriodStartTimeStamp)), sdf.format(Long.valueOf(activityPeriodEndTimeStamp)), Integer.valueOf(turnIndex), sdf.format(Long.valueOf(turnStartTimeStamp)), sdf.format(Long.valueOf(turnEndTimeStamp)), Integer.valueOf(itemCfgId), Long.valueOf(roleId), Long.valueOf(moneyCount), Integer.valueOf(refundMailId), Integer.valueOf(logReason), extraReason };
/*    */     
/*    */ 
/*    */ 
/*    */ 
/* 74 */     TLogManager.getInstance().addLog("AuctionRefundLog", logColumns);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   static void tLogAuctionSendItemLog(long roleId, int activityId, long activityPeriodStartTimeStamp, long activityPeriodEndTimeStamp, int turnIndex, long turnStartTimeStamp, long turnEndTimeStamp, int itemCfgId, long itemBidEndTimeStamp, long bidPrice)
/*    */   {
/* 81 */     SimpleDateFormat simpleDateFormat = DateTimeUtils.getSimpleDateFormat("yyyy-MM-dd HH:mm:ss");
/*    */     
/* 83 */     Object[] logColumns = new Object[13];
/* 84 */     logColumns[4] = Integer.valueOf(activityId);
/* 85 */     logColumns[5] = simpleDateFormat.format(Long.valueOf(activityPeriodStartTimeStamp));
/* 86 */     logColumns[6] = simpleDateFormat.format(Long.valueOf(activityPeriodEndTimeStamp));
/* 87 */     logColumns[7] = Integer.valueOf(turnIndex);
/* 88 */     logColumns[8] = simpleDateFormat.format(Long.valueOf(turnStartTimeStamp));
/* 89 */     logColumns[9] = simpleDateFormat.format(Long.valueOf(turnEndTimeStamp));
/* 90 */     logColumns[10] = Integer.valueOf(itemCfgId);
/* 91 */     logColumns[11] = simpleDateFormat.format(Long.valueOf(itemBidEndTimeStamp));
/* 92 */     logColumns[12] = Long.valueOf(bidPrice);
/*    */     
/* 94 */     doTLog(roleId, "AuctionSendItemLog", logColumns);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\auction\main\AuctionTLogManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */