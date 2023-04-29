/*    */ package mzm.gsp.crossbattle.bet;
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
/*    */ public class CrossBattleBetInterface
/*    */ {
/*    */   public static void setGrcRetryInterval(int param)
/*    */   {
/* 17 */     CrossBattleBetManager.GRC_RETRY_INTERVAL = param;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static void setGrcMaxTryTimes(int param)
/*    */   {
/* 28 */     CrossBattleBetManager.GRC_MAX_TRY_TIMES = param;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static void setGrcMaxDelay(int param)
/*    */   {
/* 39 */     CrossBattleBetManager.GRC_MAX_DELAY = param;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static void setGetRemoteRankMinDelayInSecond(int param)
/*    */   {
/* 50 */     CrossBattleBetManager.GET_REMOTE_RANK_MIN_DELAY_IN_SECOND = param;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static void setGetRemoteRankMaxDelayInSecond(int param)
/*    */   {
/* 61 */     CrossBattleBetManager.GET_REMOTE_RANK_MAX_DELAY_IN_SECOND = param;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public static void postInit()
/*    */   {
/* 69 */     CrossBattleBetManager.postInit();
/* 70 */     CrossBattleBetChartManager.getInstance().postInit();
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static void onActivityEnd(int activityCfgid)
/*    */   {
/* 81 */     CrossBattleBetChartManager.getInstance().onActivityEnd(activityCfgid);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\bet\CrossBattleBetInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */