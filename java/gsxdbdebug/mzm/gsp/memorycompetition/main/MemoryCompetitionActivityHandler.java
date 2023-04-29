/*    */ package mzm.gsp.memorycompetition.main;
/*    */ 
/*    */ import java.util.List;
/*    */ import mzm.gsp.activity.main.ActivityHandler;
/*    */ import mzm.gsp.activity.main.ActivityHandler.ActivityStartType;
/*    */ import mzm.gsp.activity.main.ActivityStage;
/*    */ import mzm.gsp.activity2.confbean.SRomanticDanceConsts;
/*    */ import mzm.gsp.award.main.AwardReason;
/*    */ import mzm.gsp.map.main.ControllerInterface;
/*    */ import mzm.gsp.open.main.OpenInterface;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class MemoryCompetitionActivityHandler
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
/*    */ 
/*    */   public void onActivityStart(ActivityHandler.ActivityStartType activityStartType, int activityid)
/*    */   {
/* 38 */     if (activityid == SRomanticDanceConsts.getInstance().activity_cfg_id)
/*    */     {
/* 40 */       if (!OpenInterface.getOpenStatus(231))
/*    */       {
/* 42 */         return;
/*    */       }
/*    */       
/* 45 */       ControllerInterface.triggerController(SRomanticDanceConsts.getInstance().ControllerId);
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
/*    */   public void onActivityEnd(int activityid)
/*    */   {
/* 59 */     if (activityid == SRomanticDanceConsts.getInstance().activity_cfg_id)
/*    */     {
/*    */ 
/*    */ 
/* 63 */       ControllerInterface.collectController(SRomanticDanceConsts.getInstance().ControllerId);
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\memorycompetition\main\MemoryCompetitionActivityHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */