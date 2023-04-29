/*    */ package mzm.gsp.hula.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import mzm.gsp.activity.main.ActivityHandler;
/*    */ import mzm.gsp.activity.main.ActivityHandler.ActivityStartType;
/*    */ import mzm.gsp.activity.main.ActivityStage;
/*    */ import mzm.gsp.activity.main.ActivityStage.TimeBaseLine;
/*    */ import mzm.gsp.activity.main.ActivityStage.TimeLogic;
/*    */ import mzm.gsp.award.main.AwardReason;
/*    */ import mzm.gsp.hula.confbean.SHulaCfgConsts;
/*    */ 
/*    */ 
/*    */ public class HulaActivityInit
/*    */   implements ActivityHandler
/*    */ {
/*    */   public void initData(String userid, long roleId, int turn, int activityid)
/*    */   {
/* 19 */     HulaManager.initRoleData(roleId, 0L);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public AwardReason getRecommendAwardReason()
/*    */   {
/* 26 */     return null;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public List<ActivityStage> getActivityStages()
/*    */   {
/* 38 */     List<ActivityStage> stageList = new ArrayList();
/*    */     
/*    */ 
/* 41 */     ActivityStage stay = new ActivityStage(SHulaCfgConsts.getInstance().PREPARE_MINUTES, ActivityStage.TimeBaseLine.BEGIN, ActivityStage.TimeLogic.FIX);
/* 42 */     stageList.add(stay);
/*    */     
/* 44 */     ActivityStage delete = new ActivityStage(SHulaCfgConsts.getInstance().DOUDOU_STAY_MINUTES, ActivityStage.TimeBaseLine.BEFORE, ActivityStage.TimeLogic.FIX);
/*    */     
/* 46 */     stageList.add(delete);
/*    */     
/* 48 */     for (int i = 1; i < SHulaCfgConsts.getInstance().TOTAL_TURNS; i++)
/*    */     {
/* 50 */       stay = new ActivityStage(SHulaCfgConsts.getInstance().DOUDOU_DELETE_MINUTES, ActivityStage.TimeBaseLine.BEFORE, ActivityStage.TimeLogic.FIX);
/* 51 */       stageList.add(stay);
/*    */       
/* 53 */       delete = new ActivityStage(SHulaCfgConsts.getInstance().DOUDOU_STAY_MINUTES, ActivityStage.TimeBaseLine.BEFORE, ActivityStage.TimeLogic.FIX);
/* 54 */       stageList.add(delete);
/*    */     }
/* 56 */     return stageList;
/*    */   }
/*    */   
/*    */ 
/*    */   public void onActivityStart(ActivityHandler.ActivityStartType activityStartType, int activityid)
/*    */   {
/* 62 */     HulaManager.onActivityStart(activityStartType, activityid);
/*    */   }
/*    */   
/*    */ 
/*    */   public void onActivityStageStart(int stage, boolean startAgain, int activityid)
/*    */   {
/* 68 */     HulaManager.onActivityStageStart(stage, startAgain, activityid);
/*    */   }
/*    */   
/*    */ 
/*    */   public void onActivityEnd(int activityid)
/*    */   {
/* 74 */     HulaManager.onActivityEnd(activityid);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\hula\main\HulaActivityInit.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */