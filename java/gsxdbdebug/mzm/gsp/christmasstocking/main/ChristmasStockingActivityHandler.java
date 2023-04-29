/*    */ package mzm.gsp.christmasstocking.main;
/*    */ 
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.activity.confbean.SActivityCfg;
/*    */ import mzm.gsp.activity.main.ActivityHandler;
/*    */ import mzm.gsp.activity.main.ActivityHandler.ActivityStartType;
/*    */ import mzm.gsp.activity.main.ActivityStage;
/*    */ import mzm.gsp.activity4.confbean.SChristmasStockingConsts;
/*    */ import mzm.gsp.award.main.AwardReason;
/*    */ import mzm.gsp.common.TimeCommonUtil;
/*    */ import mzm.gsp.open.main.OpenInterface;
/*    */ import mzm.gsp.util.DateTimeUtils;
/*    */ import xbean.Role2ChristmasStockingInfo;
/*    */ 
/*    */ public class ChristmasStockingActivityHandler implements ActivityHandler
/*    */ {
/*    */   public List<ActivityStage> getActivityStages()
/*    */   {
/* 20 */     return null;
/*    */   }
/*    */   
/*    */ 
/*    */   public AwardReason getRecommendAwardReason()
/*    */   {
/* 26 */     return null;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public void initData(String userid, long roleId, int turn, int activityid)
/*    */   {
/* 33 */     Role2ChristmasStockingInfo xRole2ChristmasStockingInfo = ChristmasStockingManager.getRole2ChristmasStockingInfo(roleId);
/* 34 */     xRole2ChristmasStockingInfo.getTargetroleid2selfhangnum().clear();
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public void onActivityEnd(int activityid)
/*    */   {
/* 42 */     SActivityCfg sActivityCfg = SActivityCfg.get(activityid);
/* 43 */     long activityEndTime = TimeCommonUtil.getLimitTimeEnd(sActivityCfg.activityLimitTimeid);
/* 44 */     long currentTime = DateTimeUtils.getCurrTimeInMillis();
/* 45 */     if (currentTime < activityEndTime)
/*    */     {
/* 47 */       return;
/*    */     }
/*    */     
/*    */ 
/* 51 */     long retainSecs = SChristmasStockingConsts.getInstance().AFTER_ACTIVITY_RETAIN_MINUTES * 60L;
/*    */     
/* 53 */     new RemoveTreeObserver(retainSecs);
/*    */   }
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
/*    */   public void onActivityStart(ActivityHandler.ActivityStartType activityStartType, int activityid)
/*    */   {
/* 67 */     if (!OpenInterface.getOpenStatus(582))
/*    */     {
/* 69 */       return;
/*    */     }
/*    */     
/*    */ 
/* 73 */     ChristmasStockingManager.triggerTreeAddEvent();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\christmasstocking\main\ChristmasStockingActivityHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */