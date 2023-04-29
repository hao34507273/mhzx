/*    */ package mzm.gsp.jingji.main;
/*    */ 
/*    */ import java.util.List;
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.activity.confbean.JingjiActivityCfgConsts;
/*    */ import mzm.gsp.activity.main.ActivityHandler;
/*    */ import mzm.gsp.activity.main.ActivityHandler.ActivityStartType;
/*    */ import mzm.gsp.activity.main.ActivityStage;
/*    */ import mzm.gsp.award.main.AwardReason;
/*    */ import mzm.gsp.tlog.LogReason;
/*    */ import mzm.gsp.util.DateTimeUtils;
/*    */ import mzm.gsp.util.Pair;
/*    */ import xbean.JingjiPvp;
/*    */ import xbean.Pod;
/*    */ import xtable.Role2jingjipvp;
/*    */ 
/*    */ public class JingjiActivityInit implements ActivityHandler
/*    */ {
/*    */   public void initData(String userid, long roleId, int turn, int activityid)
/*    */   {
/* 21 */     JingjiPvp jingjiData = Role2jingjipvp.get(Long.valueOf(roleId));
/* 22 */     Pair<Long, Integer> pair = JingjiManager.getSeasonStarttimeAndMergeClear();
/* 23 */     long seasonstarttime = ((Long)pair.first).longValue();
/* 24 */     int mergeClear = ((Integer)pair.second).intValue();
/*    */     
/* 26 */     long now = DateTimeUtils.getCurrTimeInMillis();
/* 27 */     int oldFinghtCount = -1;
/* 28 */     if (jingjiData == null)
/*    */     {
/* 30 */       jingjiData = Pod.newJingjiPvp();
/* 31 */       Role2jingjipvp.insert(Long.valueOf(roleId), jingjiData);
/* 32 */       jingjiData.setLastseasonphase(0);
/* 33 */       jingjiData.setLastseasonendtime(seasonstarttime);
/* 34 */       jingjiData.setWinpoint(JingjiActivityCfgConsts.getInstance().INIT_WING_POINT_NUM);
/* 35 */       JingjiManager.asynAddTotalCount(1);
/* 36 */       if (mergeClear == 1)
/*    */       {
/*    */ 
/* 39 */         jingjiData.setMerge_cleared(1);
/*    */       }
/*    */       else
/*    */       {
/* 43 */         jingjiData.setMerge_cleared(0);
/*    */       }
/*    */     }
/*    */     else
/*    */     {
/* 48 */       oldFinghtCount = jingjiData.getFightcount();
/*    */     }
/* 50 */     JingjiManager.computeReserveExp(userid, roleId, oldFinghtCount, turn);
/*    */     
/* 52 */     jingjiData.setChallengecount(JingjiActivityCfgConsts.getInstance().DAY_OFFER_CHALLENGE_COUNT);
/* 53 */     jingjiData.setJifen(0);
/*    */     
/* 55 */     jingjiData.setFirstvictoryrewardid(-1);
/* 56 */     jingjiData.setFivefightrewardid(-1);
/* 57 */     jingjiData.setVictorycount(0);
/* 58 */     jingjiData.setFightcount(0);
/* 59 */     jingjiData.setBuycount(0);
/* 60 */     jingjiData.setBuychallengecount(0);
/* 61 */     jingjiData.setInittime(now);
/*    */     
/* 63 */     RoleJingjiChartInterface.rank(roleId, jingjiData.getWinpoint());
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public AwardReason getRecommendAwardReason()
/*    */   {
/* 70 */     AwardReason a = new AwardReason(LogReason.JINGJI_ACTIVITY_RECOMMEND_REWARD_ADD);
/* 71 */     return a;
/*    */   }
/*    */   
/*    */ 
/*    */   public List<ActivityStage> getActivityStages()
/*    */   {
/* 77 */     return null;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public void onActivityStart(ActivityHandler.ActivityStartType activityStartType, int activityid) {}
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public void onActivityStageStart(int stageIndex, boolean startAgain, int activityid) {}
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public void onActivityEnd(int activityid)
/*    */   {
/* 95 */     if (GameServerInfoManager.isRoamServer())
/*    */     {
/* 97 */       return;
/*    */     }
/* 99 */     JingjiManager.offerDayJingjiAward();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\jingji\main\JingjiActivityInit.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */