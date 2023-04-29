/*    */ package mzm.gsp.award.commonaward;
/*    */ 
/*    */ import java.util.List;
/*    */ import mzm.gsp.activity.main.ActivityHandler;
/*    */ import mzm.gsp.activity.main.ActivityHandler.ActivityStartType;
/*    */ import mzm.gsp.activity.main.ActivityStage;
/*    */ import mzm.gsp.award.gift.GlobalGiftManager;
/*    */ import mzm.gsp.award.main.AwardReason;
/*    */ import mzm.gsp.giftaward.confbean.STActivityId2UseType;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CommonAwardHandler
/*    */   implements ActivityHandler
/*    */ {
/*    */   public void initData(String userid, long roleId, int turn, int activityid) {}
/*    */   
/*    */   public AwardReason getRecommendAwardReason()
/*    */   {
/* 25 */     return null;
/*    */   }
/*    */   
/*    */ 
/*    */   public List<ActivityStage> getActivityStages()
/*    */   {
/* 31 */     return null;
/*    */   }
/*    */   
/*    */ 
/*    */   public void onActivityStart(ActivityHandler.ActivityStartType activityStartType, int activityid)
/*    */   {
/* 37 */     if (activityStartType.isBigTurn())
/*    */     {
/* 39 */       GlobalGiftManager.initXAwardGlobal(getUseTypeFromActivity(activityid));
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public void onActivityStageStart(int stage, boolean startAgain, int activityid) {}
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public void onActivityEnd(int activityid) {}
/*    */   
/*    */ 
/*    */ 
/*    */   int getUseTypeFromActivity(int activityId)
/*    */   {
/* 57 */     STActivityId2UseType stActivityId2UseType = STActivityId2UseType.get(activityId);
/* 58 */     if (stActivityId2UseType == null)
/*    */     {
/* 60 */       return -1;
/*    */     }
/* 62 */     return stActivityId2UseType.useType;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\award\commonaward\CommonAwardHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */