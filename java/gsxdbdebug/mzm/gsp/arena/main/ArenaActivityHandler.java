/*     */ package mzm.gsp.arena.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.activity.main.ActivityHandler.ActivityStartType;
/*     */ import mzm.gsp.activity.main.ActivityStage;
/*     */ import mzm.gsp.activity.main.ActivityStage.TimeBaseLine;
/*     */ import mzm.gsp.activity.main.ActivityStage.TimeLogic;
/*     */ import mzm.gsp.arena.confbean.SArenaConsts;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.map.main.ControllerInterface;
/*     */ import mzm.gsp.map.main.MapInterface;
/*     */ import mzm.gsp.team.main.TeamInterface;
/*     */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.Arena;
/*     */ import xbean.ArenaScore;
/*     */ import xbean.ArenaTmp;
/*     */ import xbean.Camp;
/*     */ 
/*     */ class ArenaActivityHandler implements mzm.gsp.activity.main.ActivityHandler
/*     */ {
/*     */   public void initData(String userid, long roleId, int turn, int activityid)
/*     */   {
/*  29 */     ArenaScore xScore = xtable.Arenascore.get(Long.valueOf(roleId));
/*  30 */     if (xScore == null) {
/*  31 */       return;
/*     */     }
/*  33 */     xScore.setCamp(-1);
/*  34 */     xScore.setScore(SArenaConsts.getInstance().InitScore);
/*  35 */     xScore.setAction_point(SArenaConsts.getInstance().InitActionPoint);
/*  36 */     xScore.setWin_times(0);
/*  37 */     xScore.setParticipated(false);
/*  38 */     xScore.getGet_awards().clear();
/*  39 */     xScore.getMatchroles().clear();
/*     */   }
/*     */   
/*     */   public AwardReason getRecommendAwardReason()
/*     */   {
/*  44 */     return null;
/*     */   }
/*     */   
/*     */   public List<ActivityStage> getActivityStages()
/*     */   {
/*  49 */     List<ActivityStage> stages = new ArrayList();
/*     */     
/*  51 */     ActivityStage prepare = new ActivityStage(SArenaConsts.getInstance().PrepareStageMinutes, ActivityStage.TimeBaseLine.BEGIN, ActivityStage.TimeLogic.FIX);
/*     */     
/*     */ 
/*  54 */     ActivityStage match1 = new ActivityStage(SArenaConsts.getInstance().Match1StageMinutes, ActivityStage.TimeBaseLine.BEFORE, ActivityStage.TimeLogic.FIX);
/*     */     
/*     */ 
/*  57 */     ActivityStage match2 = new ActivityStage(SArenaConsts.getInstance().ShutdownMatchBeforeEndMinutes, ActivityStage.TimeBaseLine.END, ActivityStage.TimeLogic.FIX);
/*     */     
/*     */ 
/*  60 */     stages.add(prepare);
/*  61 */     stages.add(match1);
/*  62 */     stages.add(match2);
/*     */     
/*  64 */     return stages;
/*     */   }
/*     */   
/*     */   public void onActivityStart(ActivityHandler.ActivityStartType startType, int activityid)
/*     */   {
/*  69 */     ArenaManager.logger.info("天下会武活动开启！");
/*     */     
/*  71 */     if (startType.isBigTurn()) {
/*  72 */       Arena xArena = ArenaManager.getXArenaIfNotExist();
/*  73 */       xArena.getCamps().clear();
/*  74 */       Set<Integer> camps = ArenaConfigManager.getInstance().getCampSet();
/*  75 */       for (Iterator i$ = camps.iterator(); i$.hasNext();) { int camp = ((Integer)i$.next()).intValue();
/*  76 */         Camp xCamp = xbean.Pod.newCamp();
/*  77 */         xCamp.setScore(0);
/*  78 */         xCamp.setRole_number(0);
/*  79 */         xArena.getCamps().put(Integer.valueOf(camp), xCamp);
/*     */       }
/*  81 */       xArena.setFinished(false);
/*     */       
/*     */ 
/*  84 */       ArenaManager.chart.clear();
/*     */     }
/*     */     
/*     */ 
/*  88 */     ArenaTmp xArenaTmp = ArenaManager.getXArenaTmpIfNotExist();
/*  89 */     long world = MapInterface.createWorld(Arrays.asList(new Integer[] { Integer.valueOf(SArenaConsts.getInstance().ActivityMap) }));
/*  90 */     xArenaTmp.setWorld(world);
/*  91 */     xArenaTmp.getFights().clear();
/*     */     
/*     */ 
/*  94 */     ControllerInterface.triggerController(SArenaConsts.getInstance().ControllerIn);
/*     */     
/*     */ 
/*  97 */     new AwardObserver();
/*     */     
/*     */ 
/* 100 */     ArenaTeamHandler teamHandler = new ArenaTeamHandler();
/* 101 */     TeamInterface.registerJoinTeam(world, teamHandler);
/* 102 */     TeamInterface.registerActivityTeam(world, teamHandler);
/*     */   }
/*     */   
/*     */ 
/*     */   public void onActivityStageStart(int stage, boolean startAgain, int activityid)
/*     */   {
/* 108 */     ArenaTmp xArenaTmp = ArenaManager.getXArenaTmp(false);
/* 109 */     ArenaManager.broadcastStage(xArenaTmp, stage);
/*     */     
/* 111 */     switch (stage) {
/*     */     case 1: 
/* 113 */       ArenaManager.logger.info("天下会武匹配阶段1开始，还能入场！");
/*     */       
/* 115 */       ArenaManager.matchFight();
/* 116 */       new MatchObserver();
/*     */       
/* 118 */       break;
/*     */     case 2: 
/* 120 */       ArenaManager.logger.info("天下会武匹配阶段2开始，隐藏入场npc，玩家不能再入场！");
/*     */       
/* 122 */       NoneRealTimeTaskManager.getInstance().addTask(new PCheckEnd());
/*     */       
/* 124 */       break;
/*     */     case 3: 
/* 126 */       ArenaManager.logger.info("天下会武匹配结束，关闭所有战斗，发奖！");
/*     */       
/*     */ 
/* 129 */       ArenaManager.onMatchEnd();
/*     */       
/* 131 */       break;
/*     */     default: 
/* 133 */       ArenaManager.logger.error("[Arena] wrong activity stage : " + stage);
/*     */     }
/*     */   }
/*     */   
/*     */   public void onActivityEnd(int activityid) {}
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\arena\main\ArenaActivityHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */