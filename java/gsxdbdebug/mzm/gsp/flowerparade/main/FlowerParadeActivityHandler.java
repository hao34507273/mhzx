/*    */ package mzm.gsp.flowerparade.main;
/*    */ 
/*    */ import mzm.gsp.activity.main.ActivityHandler;
/*    */ import mzm.gsp.activity.main.ActivityHandler.ActivityStartType;
/*    */ import mzm.gsp.activity.main.ActivityStage;
/*    */ import mzm.gsp.award.main.AwardReason;
/*    */ import xbean.DanceAwardInfo;
/*    */ import xbean.RoleFlowerParadeRecord;
/*    */ import xtable.Role2flowerparaderecord;
/*    */ 
/*    */ public class FlowerParadeActivityHandler implements ActivityHandler
/*    */ {
/*    */   public void initData(String userid, long roleId, int turn, int activityid)
/*    */   {
/* 15 */     RoleFlowerParadeRecord xAwardCount = Role2flowerparaderecord.get(Long.valueOf(roleId));
/* 16 */     if (xAwardCount != null)
/*    */     {
/* 18 */       xAwardCount.setDanceawardcount(0);
/* 19 */       xAwardCount.setFollowawardcount(0);
/* 20 */       xAwardCount.setRedbagawardcount(0);
/*    */       
/* 22 */       xAwardCount.getPredanceawardinfo().setParadeindex(0L);
/* 23 */       xAwardCount.getPredanceawardinfo().setPos(-1);
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public AwardReason getRecommendAwardReason()
/*    */   {
/* 31 */     return null;
/*    */   }
/*    */   
/*    */ 
/*    */   public java.util.List<ActivityStage> getActivityStages()
/*    */   {
/* 37 */     return null;
/*    */   }
/*    */   
/*    */ 
/*    */   public void onActivityStart(ActivityHandler.ActivityStartType activityStartType, int activityid)
/*    */   {
/* 43 */     FlowerParadeManager.onActivityStart(activityid);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public void onActivityStageStart(int stage, boolean startAgain, int activityid) {}
/*    */   
/*    */ 
/*    */ 
/*    */   public void onActivityEnd(int activityid)
/*    */   {
/* 55 */     FlowerParadeManager.onActivityEnd(activityid);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\flowerparade\main\FlowerParadeActivityHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */