/*    */ package mzm.gsp.makeup.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.activity.main.ActivityHandler;
/*    */ import mzm.gsp.activity.main.ActivityHandler.ActivityStartType;
/*    */ import mzm.gsp.activity.main.ActivityStage;
/*    */ import mzm.gsp.activity4.confbean.SMakeUpActivityCfg;
/*    */ import xbean.GlobalMakeUpInfo;
/*    */ import xbean.MakeUpInfo;
/*    */ import xbean.MakeUpRecord;
/*    */ 
/*    */ public class MakeUpActivityHandler implements ActivityHandler
/*    */ {
/*    */   public void initData(String userid, long roleId, int turn, int activityid)
/*    */   {
/* 17 */     MakeUpInfo xMakeUpInfo = xtable.Role2makeupinfo.get(Long.valueOf(roleId));
/* 18 */     if (xMakeUpInfo == null)
/*    */     {
/* 20 */       return;
/*    */     }
/* 22 */     MakeUpRecord xMakeUpRecord = (MakeUpRecord)xMakeUpInfo.getActivityid2record().get(Integer.valueOf(activityid));
/* 23 */     if (xMakeUpRecord == null)
/*    */     {
/* 25 */       return;
/*    */     }
/* 27 */     xMakeUpRecord.getTurn2optionid().clear();
/*    */   }
/*    */   
/*    */ 
/*    */   public mzm.gsp.award.main.AwardReason getRecommendAwardReason()
/*    */   {
/* 33 */     return null;
/*    */   }
/*    */   
/*    */ 
/*    */   public java.util.List<ActivityStage> getActivityStages()
/*    */   {
/* 39 */     return null;
/*    */   }
/*    */   
/*    */ 
/*    */   public void onActivityStart(ActivityHandler.ActivityStartType activityStartType, int activityid)
/*    */   {
/* 45 */     if (GameServerInfoManager.isRoamServer())
/*    */     {
/*    */ 
/* 48 */       return;
/*    */     }
/* 50 */     SMakeUpActivityCfg cfg = SMakeUpActivityCfg.get(activityid);
/* 51 */     if (cfg == null)
/*    */     {
/* 53 */       return;
/*    */     }
/* 55 */     if ((activityStartType.isBigTurn()) || (activityStartType.isLittleTurnFirst()))
/*    */     {
/*    */ 
/* 58 */       MakeUpManager.startMakeup(activityid, cfg);
/* 59 */       return;
/*    */     }
/* 61 */     if (activityStartType.startAgain())
/*    */     {
/*    */ 
/* 64 */       MakeUpManager.reStartMakeup(activityid, cfg);
/* 65 */       return;
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
/* 79 */     GlobalMakeUpInfo xGlobalMakeupInfo = MakeUpManager.getGlobalMakeupInfo(activityid);
/* 80 */     if (xGlobalMakeupInfo == null)
/*    */     {
/* 82 */       return;
/*    */     }
/*    */     
/* 85 */     MakeUpObserverManager.getInstance().stopObserver(activityid);
/*    */     
/* 87 */     xGlobalMakeupInfo.setQuetioning(false);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\makeup\main\MakeUpActivityHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */