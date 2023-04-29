/*    */ package mzm.gsp.groupshopping.main;
/*    */ 
/*    */ import java.util.Calendar;
/*    */ import mzm.gsp.common.confbean.STimeLimitCommonCfg;
/*    */ import mzm.gsp.groupshopping.confbean.SBigGroupShoppingItemCfg;
/*    */ import mzm.gsp.timer.main.Session;
/*    */ import mzm.gsp.util.DateTimeUtils;
/*    */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class BigGroupShoppingStartSession
/*    */   extends Session
/*    */ {
/*    */   private final int activityId;
/*    */   private final int groupShoppingItemCfgId;
/*    */   
/*    */   private BigGroupShoppingStartSession(long interval, int activityId, int groupShoppingItemCfgId)
/*    */   {
/* 21 */     super(interval, 0L);
/* 22 */     this.activityId = activityId;
/* 23 */     this.groupShoppingItemCfgId = groupShoppingItemCfgId;
/*    */   }
/*    */   
/*    */ 
/*    */   protected void onTimeOut()
/*    */   {
/* 29 */     NoneRealTimeTaskManager.getInstance().addTask(new PCreateBigShoppingGroup(this.activityId, this.groupShoppingItemCfgId));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   static boolean start(int activityId, int groupShoppingItemCfgId)
/*    */   {
/* 38 */     SBigGroupShoppingItemCfg groupShoppingItemCfg = SBigGroupShoppingItemCfg.get(groupShoppingItemCfgId);
/* 39 */     if (groupShoppingItemCfg == null)
/* 40 */       return false;
/* 41 */     STimeLimitCommonCfg timeLimitCfg = STimeLimitCommonCfg.get(groupShoppingItemCfg.timeLimitCfgId);
/* 42 */     if (timeLimitCfg == null) {
/* 43 */       return false;
/*    */     }
/* 45 */     Calendar calendar = DateTimeUtils.getCalendar();
/* 46 */     calendar.set(timeLimitCfg.startYear, timeLimitCfg.startMonth - 1, timeLimitCfg.startDay, timeLimitCfg.startHour, timeLimitCfg.startMinute);
/*    */     
/* 48 */     long startTime = calendar.getTimeInMillis();
/* 49 */     long now = DateTimeUtils.getCurrTimeInMillis();
/* 50 */     if (now < startTime)
/*    */     {
/* 52 */       int interval = (int)((startTime - now) / 1000L);
/* 53 */       new BigGroupShoppingStartSession(interval, activityId, groupShoppingItemCfgId);
/* 54 */       return true;
/*    */     }
/*    */     
/* 57 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\groupshopping\main\BigGroupShoppingStartSession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */