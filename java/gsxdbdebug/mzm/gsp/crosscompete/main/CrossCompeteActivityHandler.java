/*     */ package mzm.gsp.crosscompete.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.activity.main.ActivityHandler;
/*     */ import mzm.gsp.activity.main.ActivityHandler.ActivityStartType;
/*     */ import mzm.gsp.activity.main.ActivityStage;
/*     */ import mzm.gsp.activity.main.ActivityStage.TimeBaseLine;
/*     */ import mzm.gsp.activity.main.ActivityStage.TimeLogic;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.crosscompete.confbean.SCrossCompeteConsts;
/*     */ import mzm.gsp.crosscompete.roam.PRoamDragAll2FightMap;
/*     */ import mzm.gsp.crosscompete.roam.PlayerScoreObserver;
/*     */ import mzm.gsp.crosscompete.roam.RClose;
/*     */ import mzm.gsp.crosscompete.roam.RForceCloseFights;
/*     */ import mzm.gsp.crosscompete.roam.RRoamInit;
/*     */ import mzm.gsp.crosscompete.roam.RRoamPrepare;
/*     */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*     */ import xbean.CrossCompete;
/*     */ import xbean.CrossCompeteAgainst;
/*     */ import xbean.CrossCompeteMatch;
/*     */ import xbean.RoleCrossCompete;
/*     */ 
/*     */ class CrossCompeteActivityHandler implements ActivityHandler
/*     */ {
/*     */   public List<ActivityStage> getActivityStages()
/*     */   {
/*  34 */     int prepareMinutes = SCrossCompeteConsts.getInstance().PrepareMinutes;
/*  35 */     int fightMinutes = SCrossCompeteConsts.getInstance().FightMinutes;
/*  36 */     if (GameServerInfoManager.isRoamServer())
/*     */     {
/*  38 */       prepareMinutes += SCrossCompeteConsts.getInstance().ProtectedMinutes;
/*  39 */       fightMinutes -= SCrossCompeteConsts.getInstance().ProtectedMinutes;
/*     */     }
/*     */     
/*  42 */     List<ActivityStage> stages = new ArrayList();
/*     */     
/*  44 */     ActivityStage signUp = new ActivityStage((int)TimeUnit.DAYS.toMinutes(SCrossCompeteConsts.getInstance().SignUpDays), ActivityStage.TimeBaseLine.BEGIN, ActivityStage.TimeLogic.FIX);
/*     */     
/*     */ 
/*     */ 
/*  48 */     ActivityStage match = new ActivityStage((int)TimeUnit.HOURS.toMinutes(SCrossCompeteConsts.getInstance().MatchHours), ActivityStage.TimeBaseLine.BEFORE, ActivityStage.TimeLogic.FIX);
/*     */     
/*     */ 
/*     */ 
/*  52 */     ActivityStage waitRemind = new ActivityStage((int)TimeUnit.HOURS.toMinutes(SCrossCompeteConsts.getInstance().MailRemindHours), ActivityStage.TimeBaseLine.BEFORE, ActivityStage.TimeLogic.FIX);
/*     */     
/*     */ 
/*     */ 
/*  56 */     ActivityStage waitCompete = new ActivityStage(SCrossCompeteConsts.getInstance().WaitMinutes - SCrossCompeteConsts.getInstance().EarlyCreateFactionMinutes, ActivityStage.TimeBaseLine.BEFORE, ActivityStage.TimeLogic.FIX);
/*     */     
/*     */ 
/*     */ 
/*  60 */     ActivityStage earlyCreateFaction1 = new ActivityStage(SCrossCompeteConsts.getInstance().EarlyCreateFactionMinutes, ActivityStage.TimeBaseLine.BEFORE, ActivityStage.TimeLogic.FIX);
/*     */     
/*     */ 
/*     */ 
/*  64 */     ActivityStage prepare1 = new ActivityStage(prepareMinutes, ActivityStage.TimeBaseLine.BEFORE, ActivityStage.TimeLogic.FIX);
/*     */     
/*     */ 
/*  67 */     ActivityStage fight1 = new ActivityStage(fightMinutes, ActivityStage.TimeBaseLine.BEFORE, ActivityStage.TimeLogic.FIX);
/*     */     
/*     */ 
/*  70 */     ActivityStage waitForceEnd1 = new ActivityStage(SCrossCompeteConsts.getInstance().WaitForceEndMinutes, ActivityStage.TimeBaseLine.BEFORE, ActivityStage.TimeLogic.FIX);
/*     */     
/*     */ 
/*     */ 
/*  74 */     ActivityStage rest = new ActivityStage(SCrossCompeteConsts.getInstance().RestMinutes - SCrossCompeteConsts.getInstance().EarlyCreateFactionMinutes, ActivityStage.TimeBaseLine.BEFORE, ActivityStage.TimeLogic.FIX);
/*     */     
/*     */ 
/*     */ 
/*  78 */     ActivityStage earlyCreateFaction2 = new ActivityStage(SCrossCompeteConsts.getInstance().EarlyCreateFactionMinutes, ActivityStage.TimeBaseLine.BEFORE, ActivityStage.TimeLogic.FIX);
/*     */     
/*     */ 
/*     */ 
/*  82 */     ActivityStage prepare2 = new ActivityStage(prepareMinutes, ActivityStage.TimeBaseLine.BEFORE, ActivityStage.TimeLogic.FIX);
/*     */     
/*     */ 
/*  85 */     ActivityStage fight2 = new ActivityStage(fightMinutes, ActivityStage.TimeBaseLine.BEFORE, ActivityStage.TimeLogic.FIX);
/*     */     
/*     */ 
/*  88 */     ActivityStage waitForceEnd2 = new ActivityStage(SCrossCompeteConsts.getInstance().WaitForceEndMinutes, ActivityStage.TimeBaseLine.BEFORE, ActivityStage.TimeLogic.FIX);
/*     */     
/*     */ 
/*     */ 
/*  92 */     stages.add(signUp);
/*  93 */     stages.add(match);
/*  94 */     stages.add(waitRemind);
/*  95 */     stages.add(waitCompete);
/*  96 */     stages.add(earlyCreateFaction1);
/*  97 */     stages.add(prepare1);
/*  98 */     stages.add(fight1);
/*  99 */     stages.add(waitForceEnd1);
/* 100 */     stages.add(rest);
/* 101 */     stages.add(earlyCreateFaction2);
/* 102 */     stages.add(prepare2);
/* 103 */     stages.add(fight2);
/* 104 */     stages.add(waitForceEnd2);
/*     */     
/* 106 */     return stages;
/*     */   }
/*     */   
/*     */   public AwardReason getRecommendAwardReason()
/*     */   {
/* 111 */     return null;
/*     */   }
/*     */   
/*     */   public void initData(String userid, long roleId, int turn, int activityid)
/*     */   {
/* 116 */     RoleCrossCompete xRoleCompete = CrossCompeteManager.createXRoleCrossCompeteIfNotExist(roleId);
/*     */     
/* 118 */     CrossCompeteManager.initXRoleCrossCompete(roleId, xRoleCompete);
/*     */   }
/*     */   
/*     */   public void onActivityEnd(int activityid)
/*     */   {
/* 123 */     CrossCompeteManager.logInfo("CrossCompeteActivityHandler.onActivityEnd", new Object[0]);
/* 124 */     close(false);
/*     */   }
/*     */   
/*     */ 
/*     */   public void onActivityStageStart(int stage, boolean startAgain, int activityid)
/*     */   {
/* 130 */     CrossCompeteManager.logInfo("CrossCompeteActivityHandler.onActivityStageStart|stage=%d|start_again=%b|activityid=%d", new Object[] { Integer.valueOf(stage), Boolean.valueOf(startAgain), Integer.valueOf(activityid) });
/*     */     
/*     */ 
/* 133 */     switch (stage)
/*     */     {
/*     */     case 1: 
/* 136 */       onMatchStage();
/* 137 */       break;
/*     */     case 2: 
/* 139 */       onMailRemindStage(startAgain);
/* 140 */       break;
/*     */     case 3: 
/* 142 */       onWaitCompeteStage(startAgain);
/* 143 */       break;
/*     */     case 4: 
/* 145 */       onEarlyCreateFactionStage(true);
/* 146 */       break;
/*     */     case 5: 
/* 148 */       onPrepareStage(true, startAgain);
/* 149 */       break;
/*     */     case 6: 
/* 151 */       onFightStage(true, startAgain);
/* 152 */       break;
/*     */     case 7: 
/* 154 */       onForceEndStage(true);
/* 155 */       break;
/*     */     case 8: 
/* 157 */       close(true);
/* 158 */       break;
/*     */     case 9: 
/* 160 */       onEarlyCreateFactionStage(false);
/* 161 */       break;
/*     */     case 10: 
/* 163 */       onPrepareStage(false, startAgain);
/* 164 */       break;
/*     */     case 11: 
/* 166 */       onFightStage(false, startAgain);
/* 167 */       break;
/*     */     case 12: 
/* 169 */       onForceEndStage(false);
/* 170 */       break;
/*     */     case 13: 
/* 172 */       close(false);
/* 173 */       break;
/*     */     default: 
/* 175 */       CrossCompeteManager.logError("CrossCompeteActivityHandler.onActivityStageStart@Unknown stage|stage=%d", new Object[] { Integer.valueOf(stage) });
/*     */     }
/*     */     
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void onActivityStart(ActivityHandler.ActivityStartType activityStartType, int activityid)
/*     */   {
/* 186 */     CrossCompeteManager.logInfo("CrossCompeteActivityHandler.onActivityStart", new Object[0]);
/* 187 */     if (!activityStartType.startAgain())
/*     */     {
/*     */ 
/*     */ 
/* 191 */       if (!GameServerInfoManager.isRoamServer()) {
/* 192 */         NoneRealTimeTaskManager.getInstance().addTask(new RInit());
/*     */       }
/*     */       else {
/* 195 */         NoneRealTimeTaskManager.getInstance().addTask(new RRoamInit());
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   private void onMatchStage()
/*     */   {
/* 202 */     if (!GameServerInfoManager.isRoamServer()) {
/* 203 */       int delaySeconds = CrossCompeteManager.randomDelaySeconds();
/* 204 */       new DelayReportSignUpSession(delaySeconds);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private void onMailRemindStage(boolean startAgain)
/*     */   {
/* 212 */     if ((!GameServerInfoManager.isRoamServer()) && 
/* 213 */       (!startAgain)) {
/* 214 */       NoneRealTimeTaskManager.getInstance().addTask(new RNotifyMatch());
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private void onWaitCompeteStage(boolean startAgain)
/*     */   {
/* 223 */     if (!GameServerInfoManager.isRoamServer()) {
/* 224 */       NoneRealTimeTaskManager.getInstance().addTask(new RRemind());
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private void onEarlyCreateFactionStage(boolean firstTime)
/*     */   {
/* 232 */     if (!GameServerInfoManager.isRoamServer()) {
/* 233 */       int delaySeconds = CrossCompeteManager.randomDelaySeconds();
/* 234 */       new DelayRequireRoamServersSession(delaySeconds, firstTime);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private void onPrepareStage(boolean firstTime, boolean startAgain)
/*     */   {
/* 242 */     if (GameServerInfoManager.isRoamServer())
/*     */     {
/*     */ 
/*     */ 
/* 246 */       NoneRealTimeTaskManager.getInstance().addTask(new RRoamPrepare(firstTime));
/*     */     }
/*     */   }
/*     */   
/*     */   private void onFightStage(boolean firstTime, boolean startAgain)
/*     */   {
/* 252 */     if (GameServerInfoManager.isRoamServer())
/*     */     {
/*     */ 
/*     */ 
/* 256 */       CrossCompeteManager.logInfo("CrossCompeteActivityHandler.processImp@fight stage, drag all player to fight map", new Object[0]);
/*     */       
/*     */ 
/* 259 */       CrossCompete xCompete = CrossCompeteManager.getXCrossCompete(true);
/* 260 */       if (xCompete == null) {
/* 261 */         return;
/*     */       }
/*     */       
/* 264 */       Iterator<Map.Entry<CrossCompeteMatch, CrossCompeteAgainst>> iter = xCompete.getAgainsts().entrySet().iterator();
/*     */       
/*     */ 
/* 267 */       while (iter.hasNext()) {
/* 268 */         Map.Entry<CrossCompeteMatch, CrossCompeteAgainst> entry = (Map.Entry)iter.next();
/* 269 */         CrossCompeteMatch cMatch = (CrossCompeteMatch)entry.getKey();
/* 270 */         CrossCompeteAgainst xAgainst = (CrossCompeteAgainst)entry.getValue();
/*     */         
/* 272 */         if (CrossCompeteConfigManager.isInFirstCompeteTime(xAgainst.getCompete_index()) == firstTime)
/*     */         {
/*     */ 
/*     */ 
/* 276 */           NoneRealTimeTaskManager.getInstance().addTask(new PRoamDragAll2FightMap(cMatch.getFront_factionid(), cMatch.getBehind_factionid()));
/*     */         }
/*     */       }
/*     */       
/*     */ 
/* 281 */       new PlayerScoreObserver();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void onForceEndStage(boolean firstTime)
/*     */   {
/* 291 */     if (GameServerInfoManager.isRoamServer())
/*     */     {
/*     */ 
/*     */ 
/* 295 */       NoneRealTimeTaskManager.getInstance().addTask(new RForceCloseFights(firstTime));
/*     */     }
/*     */   }
/*     */   
/*     */   private void close(boolean firstTime)
/*     */   {
/* 301 */     if (GameServerInfoManager.isRoamServer())
/*     */     {
/*     */ 
/*     */ 
/* 305 */       NoneRealTimeTaskManager.getInstance().addTask(new RClose(firstTime));
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crosscompete\main\CrossCompeteActivityHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */