/*    */ package mzm.gsp.xiaohuikuaipao.main;
/*    */ 
/*    */ import java.util.Collection;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.tlog.TLogManager;
/*    */ 
/*    */ 
/*    */ public class XiaoHuiKuaiPaoTLogManager
/*    */ {
/*    */   private static final String T_LOG_OUTER_DRAW = "XiaoHuiKuaiPaoOuterDrawLog";
/*    */   private static final String T_LOG_INNER_DRAW = "XiaoHuiKuaiPaoInnerDrawLog";
/*    */   private static final String T_LOG_POINT_EXCHANGE = "XiaoHuiKuaiPaoPointExchangeLog";
/*    */   private static final String T_LOG_OUTER_TURN_CONVERT_POINT = "XiaoHuiKuaiPaoOuterTurnConvertToPointLog";
/*    */   
/*    */   private static void doTLog(long roleId, String tLogName, Object[] logColumns)
/*    */   {
/* 19 */     String userid = RoleInterface.getUserId(roleId);
/*    */     
/* 21 */     logColumns[0] = GameServerInfoManager.getHostIP();
/* 22 */     logColumns[1] = userid;
/* 23 */     logColumns[2] = Long.valueOf(roleId);
/* 24 */     logColumns[3] = Integer.valueOf(RoleInterface.getLevel(roleId));
/*    */     
/* 26 */     TLogManager.getInstance().addLog(userid, tLogName, logColumns);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   static void tLogOuterDraw(long roleId, int activityId, int costYuanBao, Map<Integer, Integer> costItems, Map<Integer, Integer> awardItems, int drawCount, int stepCount, int lastIndex, int currentIndex, int lastAccumulateTurnCount, int currentAccumulateTurnCount, int lastTicketCount, int currentTicketCount)
/*    */   {
/* 34 */     Object[] logColumns = new Object[16];
/* 35 */     logColumns[4] = Integer.valueOf(activityId);
/* 36 */     logColumns[5] = Integer.valueOf(costYuanBao);
/* 37 */     logColumns[6] = costItems.toString();
/* 38 */     logColumns[7] = awardItems.toString();
/* 39 */     logColumns[8] = Integer.valueOf(drawCount);
/* 40 */     logColumns[9] = Integer.valueOf(stepCount);
/* 41 */     logColumns[10] = Integer.valueOf(lastIndex);
/* 42 */     logColumns[11] = Integer.valueOf(currentIndex);
/* 43 */     logColumns[12] = Integer.valueOf(lastAccumulateTurnCount);
/* 44 */     logColumns[13] = Integer.valueOf(currentAccumulateTurnCount);
/* 45 */     logColumns[14] = Integer.valueOf(lastTicketCount);
/* 46 */     logColumns[15] = Integer.valueOf(currentTicketCount);
/*    */     
/* 48 */     doTLog(roleId, "XiaoHuiKuaiPaoOuterDrawLog", logColumns);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   static void tLogInnerDraw(long roleId, int activityId, int hitIndex, int hitTypeId, Map<Integer, Integer> awardItems, int lastTicketCount, int currentTicketCount, Collection<Integer> lastHitIndexList, Collection<Integer> currentHitIndexList, Collection<Integer> lastHitRandomTextTableTypeIdList, Collection<Integer> currentHitRandomTextTableTypeIdList)
/*    */   {
/* 57 */     Object[] logColumns = new Object[14];
/* 58 */     logColumns[4] = Integer.valueOf(activityId);
/* 59 */     logColumns[5] = Integer.valueOf(hitIndex);
/* 60 */     logColumns[6] = Integer.valueOf(hitTypeId);
/* 61 */     logColumns[7] = awardItems.toString();
/* 62 */     logColumns[8] = Integer.valueOf(lastTicketCount);
/* 63 */     logColumns[9] = Integer.valueOf(currentTicketCount);
/* 64 */     logColumns[10] = lastHitIndexList.toString();
/* 65 */     logColumns[11] = currentHitIndexList.toString();
/* 66 */     logColumns[12] = lastHitRandomTextTableTypeIdList.toString();
/* 67 */     logColumns[13] = currentHitRandomTextTableTypeIdList.toString();
/*    */     
/* 69 */     doTLog(roleId, "XiaoHuiKuaiPaoInnerDrawLog", logColumns);
/*    */   }
/*    */   
/*    */ 
/*    */   static void tLogPointExchange(long roleId, int activityId, int pointExchangeCfgId, int count, long lastPointCount, long currentPointCount, int lastExchangeCount, int currentExchangeCount)
/*    */   {
/* 75 */     Object[] logColumns = new Object[11];
/* 76 */     logColumns[4] = Integer.valueOf(activityId);
/* 77 */     logColumns[5] = Integer.valueOf(pointExchangeCfgId);
/* 78 */     logColumns[6] = Integer.valueOf(count);
/* 79 */     logColumns[7] = Long.valueOf(lastPointCount);
/* 80 */     logColumns[8] = Long.valueOf(currentPointCount);
/* 81 */     logColumns[9] = Integer.valueOf(lastExchangeCount);
/* 82 */     logColumns[10] = Integer.valueOf(currentExchangeCount);
/*    */     
/* 84 */     doTLog(roleId, "XiaoHuiKuaiPaoPointExchangeLog", logColumns);
/*    */   }
/*    */   
/*    */   static void tLogOuterTurnConvertPoint(long roleId, int compensateActivityId, int xhkpActivityId, int outerTurnCount, int pointCount)
/*    */   {
/* 89 */     Object[] logColumns = new Object[8];
/* 90 */     logColumns[4] = Integer.valueOf(compensateActivityId);
/* 91 */     logColumns[5] = Integer.valueOf(xhkpActivityId);
/* 92 */     logColumns[6] = Integer.valueOf(outerTurnCount);
/* 93 */     logColumns[7] = Integer.valueOf(pointCount);
/*    */     
/* 95 */     doTLog(roleId, "XiaoHuiKuaiPaoOuterTurnConvertToPointLog", logColumns);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\xiaohuikuaipao\main\XiaoHuiKuaiPaoTLogManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */