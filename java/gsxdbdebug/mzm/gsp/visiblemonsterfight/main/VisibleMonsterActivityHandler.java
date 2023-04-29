/*    */ package mzm.gsp.visiblemonsterfight.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.gsp.activity.main.ActivityHandler;
/*    */ import mzm.gsp.activity.main.ActivityHandler.ActivityStartType;
/*    */ import mzm.gsp.activity.main.ActivityStage;
/*    */ import xbean.Role2VisibleMonsterInfo;
/*    */ import xbean.VisibleMonsterInfo;
/*    */ 
/*    */ public class VisibleMonsterActivityHandler implements ActivityHandler
/*    */ {
/*    */   public void initData(String userid, long roleId, int turn, int activityid)
/*    */   {
/* 14 */     Role2VisibleMonsterInfo xRole2VisibleMonsterInfo = xtable.Role2visiblemonster.get(Long.valueOf(roleId));
/* 15 */     if (xRole2VisibleMonsterInfo == null)
/*    */     {
/* 17 */       return;
/*    */     }
/*    */     
/* 20 */     VisibleMonsterInfo xVisibleMonsterInfo = (VisibleMonsterInfo)xRole2VisibleMonsterInfo.getActivity_visible_monster_map().get(Integer.valueOf(activityid));
/*    */     
/* 22 */     if (xVisibleMonsterInfo == null)
/*    */     {
/* 24 */       return;
/*    */     }
/*    */     
/* 27 */     xVisibleMonsterInfo.getMonster_type_times_map().clear();
/*    */   }
/*    */   
/*    */ 
/*    */   public void onActivityStart(ActivityHandler.ActivityStartType activityStartType, int activityCfgId)
/*    */   {
/* 33 */     if (activityStartType.isBigTurn())
/*    */     {
/* 35 */       VisibleMonsterActivity.clearGlobalMonsterKillTimes(activityCfgId);
/*    */     }
/*    */     
/* 38 */     startActivity(activityCfgId);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   static void startActivity(int activityCfgId)
/*    */   {
/* 50 */     VisibleMonsterActivity visibleMonsterActivity = VisibleMonsterFightManager.getInstance().getVisibleMonsterActivity(activityCfgId);
/*    */     
/* 52 */     if (visibleMonsterActivity == null)
/*    */     {
/* 54 */       return;
/*    */     }
/* 56 */     visibleMonsterActivity.startVisibleMonsterActivity();
/*    */   }
/*    */   
/*    */ 
/*    */   public void onActivityEnd(int activityid)
/*    */   {
/* 62 */     stopActivity(activityid);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   static void stopActivity(int activityCfgId)
/*    */   {
/* 73 */     VisibleMonsterActivity visibleMonsterActivity = VisibleMonsterFightManager.getInstance().getVisibleMonsterActivity(activityCfgId);
/*    */     
/* 75 */     if (visibleMonsterActivity == null)
/*    */     {
/* 77 */       return;
/*    */     }
/*    */     
/* 80 */     visibleMonsterActivity.stopVisibleMonsterActivity();
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public void onActivityStageStart(int stage, boolean startAgain, int activityid) {}
/*    */   
/*    */ 
/*    */ 
/*    */   public mzm.gsp.award.main.AwardReason getRecommendAwardReason()
/*    */   {
/* 92 */     return null;
/*    */   }
/*    */   
/*    */ 
/*    */   public java.util.List<ActivityStage> getActivityStages()
/*    */   {
/* 98 */     return null;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\visiblemonsterfight\main\VisibleMonsterActivityHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */