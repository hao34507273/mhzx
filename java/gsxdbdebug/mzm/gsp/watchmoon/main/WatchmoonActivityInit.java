/*    */ package mzm.gsp.watchmoon.main;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import java.util.List;
/*    */ import mzm.gsp.activity.main.ActivityHandler;
/*    */ import mzm.gsp.activity.main.ActivityHandler.ActivityStartType;
/*    */ import mzm.gsp.activity.main.ActivityStage;
/*    */ import mzm.gsp.activitycompensate.main.ActivityCompensateHandler;
/*    */ import mzm.gsp.award.main.AwardReason;
/*    */ import mzm.gsp.util.DateTimeUtils;
/*    */ import mzm.gsp.watchmoon.confbean.SWatchmoonConsts;
/*    */ import xbean.Watchmoon;
/*    */ import xtable.Role2watchmoon;
/*    */ 
/*    */ 
/*    */ public class WatchmoonActivityInit
/*    */   implements ActivityHandler, ActivityCompensateHandler
/*    */ {
/*    */   public List<ActivityStage> getActivityStages()
/*    */   {
/* 21 */     return null;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public AwardReason getRecommendAwardReason()
/*    */   {
/* 28 */     return null;
/*    */   }
/*    */   
/*    */ 
/*    */   public void initData(String useId, long roleId, int turn, int activityid)
/*    */   {
/* 34 */     Watchmoon xWatchmoon = Role2watchmoon.get(Long.valueOf(roleId));
/* 35 */     if ((xWatchmoon == null) || (xWatchmoon.getInvitetime() + WatchmoonManager.getWatchmoonMaxLengthTime() < DateTimeUtils.getCurrTimeInMillis()))
/*    */     {
/*    */ 
/*    */ 
/* 39 */       WatchmoonManager.forceRemoveRoleState(roleId);
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public void onActivityEnd(int activityid) {}
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public void onActivityStageStart(int stage, boolean startAgain, int activityid) {}
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public void onActivityStart(ActivityHandler.ActivityStartType activityStartType, int activityid) {}
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public List<Integer> getActivitySwitchList(int activityid)
/*    */   {
/* 69 */     return Arrays.asList(new Integer[] { Integer.valueOf(38) });
/*    */   }
/*    */   
/*    */ 
/*    */   public int getCompensateAwardTimes(long roleid, int count, int activityid)
/*    */   {
/* 75 */     if (count < 0)
/*    */     {
/* 77 */       return 0;
/*    */     }
/* 79 */     return Math.max(0, SWatchmoonConsts.getInstance().ACTIVITY_COMPENSATE_COUNT - count);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\watchmoon\main\WatchmoonActivityInit.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */