/*     */ package mzm.gsp.competition.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.activity.main.ActivityHandler.ActivityStartType;
/*     */ import mzm.gsp.activity.main.ActivityStage;
/*     */ import mzm.gsp.activity.main.ActivityStage.TimeBaseLine;
/*     */ import mzm.gsp.activity.main.ActivityStage.TimeLogic;
/*     */ import mzm.gsp.competition.confbean.SCompetitionConsts;
/*     */ import mzm.gsp.competition.confbean.SCompetitionMercenaryConsts;
/*     */ import mzm.gsp.fight.main.FightInterface;
/*     */ import mzm.gsp.gang.main.GangInterface;
/*     */ import mzm.gsp.map.main.ControllerInterface;
/*     */ import mzm.gsp.util.LogicRunnable;
/*     */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.Competition;
/*     */ import xbean.CompetitionAgainst;
/*     */ import xbean.CompetitionMatch;
/*     */ import xbean.CompetitionTmp;
/*     */ import xbean.MercenaryFights;
/*     */ import xbean.RoleCompetition;
/*     */ import xtable.Role_competition;
/*     */ 
/*     */ class CompetitionActivityHandler implements mzm.gsp.activity.main.ActivityHandler, mzm.gsp.activitycompensate.main.ActivityCompensateHandler
/*     */ {
/*     */   public void initData(String userid, long roleId, int turn, int activityid)
/*     */   {
/*  33 */     RoleCompetition xRoleCompetition = Role_competition.get(Long.valueOf(roleId));
/*  34 */     if (xRoleCompetition == null) {
/*  35 */       return;
/*     */     }
/*  37 */     CompetitionManager.initXRoleCompetition(xRoleCompetition);
/*     */   }
/*     */   
/*     */   public mzm.gsp.award.main.AwardReason getRecommendAwardReason()
/*     */   {
/*  42 */     return null;
/*     */   }
/*     */   
/*     */   public List<ActivityStage> getActivityStages()
/*     */   {
/*  47 */     List<ActivityStage> stages = new ArrayList();
/*     */     
/*  49 */     ActivityStage notify = new ActivityStage(SCompetitionConsts.getInstance().AgainstBeforeHours * 60, ActivityStage.TimeBaseLine.BEGIN_BEFORE, ActivityStage.TimeLogic.FIX);
/*     */     
/*     */ 
/*  52 */     ActivityStage prepare = new ActivityStage(SCompetitionConsts.getInstance().PrepareStageMinutes, ActivityStage.TimeBaseLine.BEGIN, ActivityStage.TimeLogic.FIX);
/*     */     
/*     */ 
/*  55 */     ActivityStage competeWait = new ActivityStage(SCompetitionConsts.getInstance().CompeteWaitStageMinutes, ActivityStage.TimeBaseLine.BEFORE, ActivityStage.TimeLogic.FIX);
/*     */     
/*     */ 
/*  58 */     ActivityStage competeNormal = new ActivityStage(SCompetitionConsts.getInstance().CompeteNormalStageMinutes, ActivityStage.TimeBaseLine.BEFORE, ActivityStage.TimeLogic.FIX);
/*     */     
/*     */ 
/*  61 */     ActivityStage competeNoEnter = new ActivityStage(SCompetitionConsts.getInstance().ShutdownCompeteBeforeEndMinutes, ActivityStage.TimeBaseLine.END, ActivityStage.TimeLogic.RELATIVE);
/*     */     
/*     */ 
/*  64 */     stages.add(notify);
/*  65 */     stages.add(prepare);
/*  66 */     stages.add(competeWait);
/*  67 */     stages.add(competeNormal);
/*  68 */     stages.add(competeNoEnter);
/*     */     
/*  70 */     return stages;
/*     */   }
/*     */   
/*     */   public void onActivityStart(ActivityHandler.ActivityStartType activityStartType, int activityid)
/*     */   {
/*  75 */     CompetitionManager.logger.info("帮派竞赛活动开始！");
/*  76 */     if (!activityStartType.isBigTurn())
/*     */     {
/*     */ 
/*  79 */       if (!activityStartType.isLittleTurnFirst())
/*     */       {
/*     */ 
/*  82 */         if (!activityStartType.startAgain()) {}
/*     */       }
/*     */     }
/*     */     
/*  86 */     CompetitionManager.onActivityStart();
/*     */   }
/*     */   
/*     */   public void onActivityStageStart(int stageIndex, boolean startAgain, int activityid)
/*     */   {
/*  91 */     switch (stageIndex) {
/*     */     case -1: 
/*  93 */       onNotifyStage(startAgain);
/*  94 */       break;
/*     */     case 1: 
/*  96 */       onCompeteWaitStage(startAgain);
/*  97 */       break;
/*     */     case 2: 
/*  99 */       onCompeteNormalStage(startAgain);
/* 100 */       break;
/*     */     case 3: 
/* 102 */       onCompeteNoEnterStage(startAgain);
/* 103 */       break;
/*     */     
/*     */     case 4: 
/* 106 */       onTriggerMapItemStage(startAgain);
/* 107 */       break;
/*     */     case 0: default: 
/* 109 */       CompetitionManager.logger.error("Wrong Activity Stage of Competition: " + stageIndex);
/*     */     }
/*     */     
/*     */   }
/*     */   
/*     */ 
/*     */   public void onActivityEnd(int activityid)
/*     */   {
/* 117 */     CompetitionManager.logger.info("帮派竞赛活动结束！将所有玩家清除出场，销毁地图！");
/*     */     
/* 119 */     Competition xCompetition = CompetitionManager.getXCompetitionIfNotExist();
/* 120 */     Iterator<Map.Entry<CompetitionMatch, CompetitionAgainst>> iter = xCompetition.getAgainsts().entrySet().iterator();
/* 121 */     while (iter.hasNext()) {
/* 122 */       CompetitionMatch xMatch = (CompetitionMatch)((Map.Entry)iter.next()).getKey();
/* 123 */       NoneRealTimeTaskManager.getInstance().addTask(new POnFactionCompetitionEnd(xMatch.getFrontfaction()));
/*     */       
/* 125 */       NoneRealTimeTaskManager.getInstance().addTask(new POnFactionCompetitionEnd(xMatch.getBehindfaction()));
/*     */       
/* 127 */       iter.remove();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   private void onNotifyStage(boolean startAgain)
/*     */   {
/* 134 */     if (!startAgain) {
/* 135 */       CompetitionManager.logger.info("帮派竞赛生成对阵并邮件通知阶段开始！");
/*     */       
/* 137 */       List<MatchObjByActiveness> matchObjs = new ArrayList();
/*     */       
/* 139 */       long missTurnFactionid = CompetitionManager.getSortedMatchFactionsByActiveness(matchObjs);
/*     */       
/*     */ 
/* 142 */       Competition xCompetition = CompetitionManager.getXCompetitionIfNotExist();
/*     */       
/* 144 */       xCompetition.getAgainsts().clear();
/*     */       
/* 146 */       if (xCompetition.getMatchtimes() >= SCompetitionConsts.getInstance().MatchTimes) {
/* 147 */         xCompetition.getMatch2times().clear();
/* 148 */         xCompetition.setMatchtimes(0);
/*     */         
/* 150 */         xCompetition.getMiss_turns().clear();
/*     */       }
/*     */       
/* 153 */       if (missTurnFactionid > 0L) {
/* 154 */         CompetitionManager.addMissTurnTimes(xCompetition, missTurnFactionid);
/*     */       }
/*     */       
/*     */ 
/*     */ 
/* 159 */       CompetitionManager.matchByActiveness(xCompetition, matchObjs);
/*     */     }
/*     */   }
/*     */   
/*     */   private void onCompeteWaitStage(boolean startAgain)
/*     */   {
/* 165 */     CompetitionManager.logger.info("帮派竞赛比赛阶段开始（弃权前）！将等待地图的玩家拉入比赛地图中。");
/*     */     
/* 167 */     Competition xCompetition = CompetitionManager.getXCompetition(true);
/* 168 */     if (xCompetition == null) {
/* 169 */       return;
/*     */     }
/*     */     
/* 172 */     for (CompetitionMatch xMatch : xCompetition.getAgainsts().keySet())
/*     */     {
/* 174 */       NoneRealTimeTaskManager.getInstance().addTask(new PDragAllToCompeteMap(xMatch.getFrontfaction(), xMatch.getBehindfaction()));
/*     */     }
/*     */     
/*     */ 
/* 178 */     new PlayerScoreObserver();
/*     */     
/* 180 */     new MercenaryScoreObserver();
/*     */     
/* 182 */     new MercenaryObserver(SCompetitionMercenaryConsts.getInstance().MercenaryIntervalSeconds);
/*     */   }
/*     */   
/*     */ 
/*     */   private void onCompeteNormalStage(boolean startAgain)
/*     */   {
/* 188 */     CompetitionManager.logger.info("帮派竞赛比赛阶段开始（禁止入场前）！检查弃权情况，提前结束比赛。");
/*     */     
/* 190 */     if (!startAgain)
/*     */     {
/* 192 */       Competition xCompetition = CompetitionManager.getXCompetition(true);
/* 193 */       if (xCompetition == null) {
/* 194 */         return;
/*     */       }
/* 196 */       for (CompetitionMatch xMatch : xCompetition.getAgainsts().keySet()) {
/* 197 */         NoneRealTimeTaskManager.getInstance().addTask(new PCheckGiveUp(xMatch.getFrontfaction(), xMatch.getBehindfaction()));
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   private void onCompeteNoEnterStage(boolean startAgain)
/*     */   {
/* 205 */     CompetitionManager.logger.info("帮派竞赛比赛阶段开始（禁止入场）！检查提前结束比赛情况。");
/*     */     
/* 207 */     Competition xCompetition = CompetitionManager.getXCompetition(false);
/* 208 */     if (xCompetition == null) {
/* 209 */       return;
/*     */     }
/* 211 */     for (Map.Entry<CompetitionMatch, CompetitionAgainst> entry : xCompetition.getAgainsts().entrySet()) {
/* 212 */       CompetitionMatch xMatch = (CompetitionMatch)entry.getKey();
/* 213 */       CompetitionAgainst xAgainst = (CompetitionAgainst)entry.getValue();
/*     */       
/* 215 */       if (!xAgainst.getFinished())
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/* 220 */         long factionid1 = xMatch.getFrontfaction();
/* 221 */         long factionid2 = xMatch.getBehindfaction();
/*     */         
/* 223 */         final long world1 = GangInterface.getGangWorldId(factionid1);
/* 224 */         long world2 = GangInterface.getGangWorldId(factionid2);
/*     */         
/*     */ 
/* 227 */         NoneRealTimeTaskManager.getInstance().addTask(new LogicRunnable()
/*     */         {
/*     */           public void process() throws Exception
/*     */           {
/* 231 */             if (world1 >= 0L) {
/* 232 */               ControllerInterface.collectWorldController(world1, SCompetitionConsts.getInstance().ControllerIn);
/*     */             }
/* 234 */             if (this.val$world2 >= 0L) {
/* 235 */               ControllerInterface.collectWorldController(this.val$world2, SCompetitionConsts.getInstance().ControllerIn);
/*     */             }
/*     */             
/*     */           }
/*     */           
/* 240 */         });
/* 241 */         NoneRealTimeTaskManager.getInstance().addTask(new PCheckEnd(xMatch.getFrontfaction(), xMatch.getBehindfaction()));
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   private void onTriggerMapItemStage(boolean startAgain) {
/* 247 */     CompetitionManager.logger.info("帮派竞赛刷宝箱阶段开始！结束所有战斗，通知刷宝箱！");
/*     */     
/* 249 */     CompetitionTmp xCompetitionTmp = CompetitionManager.getXCompetitionTmp(false);
/* 250 */     if (xCompetitionTmp != null)
/*     */     {
/* 252 */       for (Iterator i$ = xCompetitionTmp.getFights().iterator(); i$.hasNext();) { long fightid = ((Long)i$.next()).longValue();
/*     */         
/* 254 */         FightInterface.endFightNonRealTime(fightid);
/*     */       }
/*     */       
/* 257 */       for (MercenaryFights xFights : xCompetitionTmp.getMercenary_fights().values()) {
/* 258 */         for (i$ = xFights.getFights().iterator(); i$.hasNext();) { long fightid = ((Long)i$.next()).longValue();
/*     */           
/* 260 */           FightInterface.endFightNonRealTime(fightid);
/*     */         }
/*     */       }
/*     */     }
/*     */     Iterator i$;
/* 265 */     Competition xCompetition = CompetitionManager.getXCompetition(false);
/* 266 */     if (xCompetition == null) {
/* 267 */       return;
/*     */     }
/* 269 */     for (Map.Entry<CompetitionMatch, CompetitionAgainst> entry : xCompetition.getAgainsts().entrySet()) {
/* 270 */       CompetitionMatch xMatch = (CompetitionMatch)entry.getKey();
/* 271 */       CompetitionAgainst xAgainst = (CompetitionAgainst)entry.getValue();
/*     */       
/* 273 */       if (!xAgainst.getFinished())
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/* 278 */         NoneRealTimeTaskManager.getInstance().addTask(new PResultByScore(xMatch.getFrontfaction(), xMatch.getBehindfaction()));
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public List<Integer> getActivitySwitchList(int activityid)
/*     */   {
/* 286 */     List<Integer> switchList = new ArrayList();
/* 287 */     return switchList;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getCompensateAwardTimes(long roleid, int count, int activityid)
/*     */   {
/* 293 */     RoleCompetition xRoleCompetition = Role_competition.get(Long.valueOf(roleid));
/* 294 */     if ((xRoleCompetition != null) && 
/* 295 */       (xRoleCompetition.getParticipated())) {
/* 296 */       return 0;
/*     */     }
/*     */     
/* 299 */     return 1;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\competition\main\CompetitionActivityHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */