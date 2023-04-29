/*    */ package mzm.gsp.alllotto.main;
/*    */ 
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import java.util.Map.Entry;
/*    */ import java.util.TreeMap;
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.activity.main.ActivityHandler;
/*    */ import mzm.gsp.activity.main.ActivityHandler.ActivityStartType;
/*    */ import mzm.gsp.activity.main.ActivityStage;
/*    */ import mzm.gsp.alllotto.confbean.SAllLottoCfg;
/*    */ import mzm.gsp.alllotto.confbean.SAllLottoConsts;
/*    */ import mzm.gsp.award.main.AwardReason;
/*    */ import mzm.gsp.util.DateTimeUtils;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class AllLottoActivityHandler
/*    */   implements ActivityHandler
/*    */ {
/*    */   public List<ActivityStage> getActivityStages()
/*    */   {
/* 24 */     return null;
/*    */   }
/*    */   
/*    */ 
/*    */   public AwardReason getRecommendAwardReason()
/*    */   {
/* 30 */     return null;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public void initData(String userid, long roleId, int turn, int activityid) {}
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public void onActivityEnd(int activityid) {}
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
/* 54 */     if (GameServerInfoManager.isRoamServer())
/*    */     {
/* 56 */       return;
/*    */     }
/* 58 */     long currTimeInMillis = DateTimeUtils.getCurrTimeInMillis();
/* 59 */     int currTimeInSec = (int)(currTimeInMillis / 1000L);
/* 60 */     SAllLottoCfg cfg = SAllLottoCfg.get(activityid);
/* 61 */     if (cfg == null)
/*    */     {
/* 63 */       return;
/*    */     }
/* 65 */     Map<Integer, Integer> tailMap = cfg.turn_time_infos.tailMap(Integer.valueOf(currTimeInSec), false);
/* 66 */     for (Map.Entry<Integer, Integer> entry : tailMap.entrySet())
/*    */     {
/* 68 */       int timestamp = ((Integer)entry.getKey()).intValue();
/* 69 */       int turn = ((Integer)entry.getValue()).intValue();
/* 70 */       if (timestamp - currTimeInSec > SAllLottoConsts.getInstance().AHEAD_REPORT_INTERVAL_IN_SECOND)
/*    */       {
/*    */ 
/*    */ 
/* 74 */         new ReportCandidateInfoSession(timestamp - SAllLottoConsts.getInstance().AHEAD_REPORT_INTERVAL_IN_SECOND - currTimeInSec, activityid, turn);
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\alllotto\main\AllLottoActivityHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */