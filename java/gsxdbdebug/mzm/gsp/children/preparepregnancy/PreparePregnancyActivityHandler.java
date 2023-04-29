/*    */ package mzm.gsp.children.preparepregnancy;
/*    */ 
/*    */ import java.util.List;
/*    */ import mzm.gsp.activity.main.ActivityHandler;
/*    */ import mzm.gsp.activity.main.ActivityHandler.ActivityStartType;
/*    */ import mzm.gsp.activity.main.ActivityStage;
/*    */ import mzm.gsp.award.main.AwardReason;
/*    */ 
/*    */ 
/*    */ public class PreparePregnancyActivityHandler
/*    */   implements ActivityHandler
/*    */ {
/*    */   public List<ActivityStage> getActivityStages()
/*    */   {
/* 15 */     return null;
/*    */   }
/*    */   
/*    */ 
/*    */   public AwardReason getRecommendAwardReason()
/*    */   {
/* 21 */     return null;
/*    */   }
/*    */   
/*    */   public void initData(String userid, long roleId, int turn, int activityid) {}
/*    */   
/*    */   public void onActivityEnd(int activityid) {}
/*    */   
/*    */   public void onActivityStageStart(int stage, boolean startAgain, int activityid) {}
/*    */   
/*    */   public void onActivityStart(ActivityHandler.ActivityStartType activityStartType, int activityid) {}
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\preparepregnancy\PreparePregnancyActivityHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */