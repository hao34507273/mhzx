/*    */ package mzm.gsp.activitypointexchange.main.handler;
/*    */ 
/*    */ import java.util.Calendar;
/*    */ import java.util.Map;
/*    */ import java.util.Map.Entry;
/*    */ import java.util.concurrent.TimeUnit;
/*    */ import mzm.gsp.activity3.confbean.SBackGameActivityCfg;
/*    */ import mzm.gsp.activity3.confbean.STBackGameActivityPointCfg;
/*    */ import mzm.gsp.activitypointexchange.main.ActivityPointExchangeManager;
/*    */ import mzm.gsp.backgameactivity.main.BackGameActivityInterface;
/*    */ import mzm.gsp.util.DateTimeUtils;
/*    */ import xbean.ActivityPointExchangeGoodsInfo;
/*    */ 
/*    */ 
/*    */ public class BackGameActivityPointExchangeHandler
/*    */   implements ActivityPointExchangeHandler
/*    */ {
/*    */   public void registerActivityPointExchangeHandler()
/*    */   {
/* 20 */     for (Map.Entry<Integer, SBackGameActivityCfg> entry : SBackGameActivityCfg.getAll().entrySet())
/*    */     {
/* 22 */       SBackGameActivityCfg backGameActivityCfg = (SBackGameActivityCfg)entry.getValue();
/* 23 */       ActivityPointExchangeManager.ACTIVITY_POINT_EXCHANGE_HANDLER_MAP.put(Integer.valueOf(backGameActivityCfg.activityId), this);
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean isMallOpenForRole(long roleId, int activityId, int mallCfgId)
/*    */   {
/* 30 */     return BackGameActivityInterface.isRoleInBackGameActivity(roleId, activityId);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public long getPointExchangeCountResetTime(int activityId, int mallCfgId, ActivityPointExchangeGoodsInfo xActivityPointExchangeGoodsInfo)
/*    */   {
/* 37 */     STBackGameActivityPointCfg backGameActivityPointCfg = getBackGameActivityPointCfg(activityId);
/* 38 */     if ((backGameActivityPointCfg == null) || (backGameActivityPointCfg.pointExchangeCountResetTime == -1))
/*    */     {
/* 40 */       return 0L;
/*    */     }
/*    */     
/* 43 */     return getResetTimeStamp(backGameActivityPointCfg.pointExchangeCountResetTime);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public long getManualRefreshCountResetTime(int activityId, int mallCfgId, ActivityPointExchangeGoodsInfo xActivityPointExchangeGoodsInfo)
/*    */   {
/* 50 */     STBackGameActivityPointCfg backGameActivityPointCfg = getBackGameActivityPointCfg(activityId);
/* 51 */     if ((backGameActivityPointCfg == null) || (backGameActivityPointCfg.manualRefreshCountResetTime == -1))
/*    */     {
/* 53 */       return 0L;
/*    */     }
/*    */     
/* 56 */     return getResetTimeStamp(backGameActivityPointCfg.manualRefreshCountResetTime);
/*    */   }
/*    */   
/*    */   private STBackGameActivityPointCfg getBackGameActivityPointCfg(int activityId)
/*    */   {
/* 61 */     SBackGameActivityCfg backGameActivityCfg = SBackGameActivityCfg.get(activityId);
/* 62 */     if (backGameActivityCfg == null)
/*    */     {
/* 64 */       return null;
/*    */     }
/* 66 */     return STBackGameActivityPointCfg.get(backGameActivityCfg.pointCfgId);
/*    */   }
/*    */   
/*    */   private long getResetTimeStamp(int cfgResetTimeInHourPerDay)
/*    */   {
/* 71 */     long currentTimeStamp = DateTimeUtils.getCurrTimeInMillis();
/* 72 */     Calendar calendar = DateTimeUtils.getCalendar();
/* 73 */     calendar.setTimeInMillis(currentTimeStamp);
/* 74 */     calendar.set(11, cfgResetTimeInHourPerDay);
/* 75 */     calendar.set(12, 0);
/* 76 */     calendar.set(13, 0);
/* 77 */     calendar.set(14, 0);
/*    */     
/* 79 */     long todayResetTimeStamp = calendar.getTimeInMillis();
/* 80 */     if (todayResetTimeStamp <= currentTimeStamp)
/*    */     {
/* 82 */       calendar.add(5, 1);
/*    */     }
/*    */     
/* 85 */     return TimeUnit.MILLISECONDS.toSeconds(calendar.getTimeInMillis());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activitypointexchange\main\handler\BackGameActivityPointExchangeHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */