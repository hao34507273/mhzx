/*     */ package mzm.gsp.menpaipvp.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.activity.main.ActivityHandler;
/*     */ import mzm.gsp.activity.main.ActivityHandler.ActivityStartType;
/*     */ import mzm.gsp.activity.main.ActivityStage;
/*     */ import mzm.gsp.activity.main.ActivityStage.TimeBaseLine;
/*     */ import mzm.gsp.activity.main.ActivityStage.TimeLogic;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.fight.main.FightInterface;
/*     */ import mzm.gsp.map.main.ControllerInterface;
/*     */ import mzm.gsp.map.main.MapInterface;
/*     */ import mzm.gsp.menpaipvp.confbean.SMenpaiPVPConsts;
/*     */ import xbean.MenpaiPVP;
/*     */ import xtable.Menpaipvpscore;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class MenpaiPVPActivityHandler
/*     */   implements ActivityHandler
/*     */ {
/*     */   public void initData(String userid, long roleId, int turn, int activityid)
/*     */   {
/*  29 */     Menpaipvpscore.remove(Long.valueOf(roleId));
/*     */   }
/*     */   
/*     */   public AwardReason getRecommendAwardReason()
/*     */   {
/*  34 */     return null;
/*     */   }
/*     */   
/*     */   public List<ActivityStage> getActivityStages()
/*     */   {
/*  39 */     List<ActivityStage> stages = new ArrayList();
/*     */     
/*  41 */     ActivityStage prepare = new ActivityStage(MenpaiPVPConfigManager.getInstance().getPrepareStageMinutes(), ActivityStage.TimeBaseLine.BEGIN, ActivityStage.TimeLogic.FIX);
/*     */     
/*     */ 
/*  44 */     ActivityStage match = new ActivityStage(MenpaiPVPConfigManager.getInstance().getShutdownMatchBeforeEndMinutes(), ActivityStage.TimeBaseLine.END, ActivityStage.TimeLogic.FIX);
/*     */     
/*     */ 
/*  47 */     stages.add(prepare);
/*  48 */     stages.add(match);
/*     */     
/*  50 */     return stages;
/*     */   }
/*     */   
/*     */   public void onActivityStart(ActivityHandler.ActivityStartType startType, int activityid)
/*     */   {
/*  55 */     MenpaiPVPManager.logInfo("MenpaiPVPActivityHandler.onAcitivityStart@start", new Object[0]);
/*     */     
/*  57 */     if (startType.isBigTurn())
/*     */     {
/*     */ 
/*  60 */       MenpaiPVPManager.clearCharts();
/*     */     }
/*     */     
/*     */ 
/*  64 */     MenpaiPVP xMenpaiPVP = MenpaiPVPManager.getXMenpaiPVPIfNotExist();
/*  65 */     MenpaiPVPManager.initXMenpaiPVP(xMenpaiPVP);
/*     */     
/*     */ 
/*  68 */     ControllerInterface.triggerController(MenpaiPVPConfigManager.getInstance().getEnterController());
/*     */     
/*     */ 
/*  71 */     new AwardObserver();
/*     */   }
/*     */   
/*     */   public void onActivityStageStart(int stage, boolean startAgain, int activityid)
/*     */   {
/*  76 */     MenpaiPVPManager.logInfo("MenpaiPVPActivityHandler.onActivityStageStart@start|stage=%d", new Object[] { Integer.valueOf(stage) });
/*     */     
/*     */ 
/*  79 */     MenpaiPVP xMenpaiPVP = MenpaiPVPManager.getXMenpaiPVP(false);
/*  80 */     MenpaiPVPManager.broadcastStage(xMenpaiPVP, stage);
/*     */     
/*  82 */     switch (stage)
/*     */     {
/*     */ 
/*     */     case 1: 
/*  86 */       MenpaiPVPManager.matchFight(xMenpaiPVP);
/*     */       
/*     */ 
/*  89 */       new MatchObserver();
/*     */       
/*  91 */       break;
/*     */     
/*     */     case 2: 
/*  94 */       MatchObserver.clearInstance();
/*  95 */       break;
/*     */     
/*     */     default: 
/*  98 */       MenpaiPVPManager.logError("MenpaiPVPActivityHandler.onActivityStageStart@invalid stage|stage=%d|startAgain=%b", new Object[] { Integer.valueOf(stage), Boolean.valueOf(startAgain) });
/*     */     }
/*     */     
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void onActivityEnd(int activityid)
/*     */   {
/* 109 */     MenpaiPVP xMenpaiPVP = MenpaiPVPManager.getXMenpaiPVPIfNotExist();
/* 110 */     Iterator<Long> fightIter = xMenpaiPVP.getFights().iterator();
/* 111 */     while (fightIter.hasNext()) {
/* 112 */       long fightid = ((Long)fightIter.next()).longValue();
/*     */       
/* 114 */       FightInterface.endFightNonRealTime(fightid);
/* 115 */       fightIter.remove();
/*     */     }
/*     */     
/*     */ 
/* 119 */     xMenpaiPVP.setIsfinished(true);
/*     */     
/* 121 */     Iterator<Map.Entry<Integer, Long>> worldIter = xMenpaiPVP.getMenpai2world().entrySet().iterator();
/* 122 */     while (worldIter.hasNext()) {
/* 123 */       Map.Entry<Integer, Long> entry = (Map.Entry)worldIter.next();
/* 124 */       long worldid = ((Long)entry.getValue()).longValue();
/*     */       
/*     */ 
/* 127 */       MapInterface.dragAllRoleTo(worldid, MenpaiPVPConfigManager.getInstance().getLeaveMap());
/*     */       
/* 129 */       MapInterface.destroyWorld(worldid);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 134 */     ControllerInterface.collectController(MenpaiPVPConfigManager.getInstance().getEnterController());
/*     */     
/* 136 */     new DelayResultSession(SMenpaiPVPConsts.getInstance().DelayResultSeconds);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\menpaipvp\main\MenpaiPVPActivityHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */