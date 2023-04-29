/*     */ package mzm.gsp.question.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import mzm.gsp.activity.main.ActivityHandler;
/*     */ import mzm.gsp.activity.main.ActivityHandler.ActivityStartType;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityStage;
/*     */ import mzm.gsp.activity.main.ActivityStage.TimeBaseLine;
/*     */ import mzm.gsp.activity.main.ActivityStage.TimeLogic;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.bulletin.SBulletinInfo;
/*     */ import mzm.gsp.bulletin.main.BulletinInterface;
/*     */ import mzm.gsp.map.main.ControllerInterface;
/*     */ import mzm.gsp.question.confbean.KeJuQuestionConsts;
/*     */ import xbean.KeJuInfo;
/*     */ import xbean.Pod;
/*     */ import xtable.Role2keju;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class KeJuQuestionActivity
/*     */   implements ActivityHandler
/*     */ {
/*     */   public static final int STAGE_XIANGSHI = 0;
/*     */   public static final int STAGE_HUISHI = 1;
/*     */   public static final int STAGE_READY = 2;
/*     */   public static final int STAGE_DIANSHI = 3;
/*     */   
/*     */   public void initData(String userid, long roleId, int turn, int activityid)
/*     */   {
/*  34 */     KeJuInfo xKeJuInfo = Role2keju.get(Long.valueOf(roleId));
/*  35 */     if (xKeJuInfo == null)
/*     */     {
/*  37 */       xKeJuInfo = Pod.newKeJuInfo();
/*  38 */       Role2keju.add(Long.valueOf(roleId), xKeJuInfo);
/*     */     }
/*     */     
/*  41 */     xKeJuInfo.getQuestionlist().clear();
/*  42 */     xKeJuInfo.setState(1);
/*  43 */     xKeJuInfo.setPunishtime(0);
/*  44 */     xKeJuInfo.setIspasshuishi(false);
/*  45 */     xKeJuInfo.getQuestionlist().addAll(KeJuQuestionManager.getInstance().randomQuestionByType(1));
/*  46 */     xKeJuInfo.setAnswernum(0);
/*  47 */     xKeJuInfo.setRightnum(0);
/*  48 */     xKeJuInfo.setPunishtime(0);
/*  49 */     xKeJuInfo.setFinishtime(0L);
/*     */     
/*  51 */     int activityStage = ActivityInterface.getActivityStage(KeJuQuestionConsts.getInstance().ACTIVITY_ID);
/*     */     
/*  53 */     KeJuQuestionManager.getInstance().syncKeJuState(roleId, xKeJuInfo, activityStage);
/*     */   }
/*     */   
/*     */ 
/*     */   public AwardReason getRecommendAwardReason()
/*     */   {
/*  59 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */   public List<ActivityStage> getActivityStages()
/*     */   {
/*  65 */     List<ActivityStage> stageList = new ArrayList();
/*     */     
/*  67 */     stageList.add(new ActivityStage(KeJuQuestionConsts.getInstance().XIANGSHI_PERSIST_MINUTE, ActivityStage.TimeBaseLine.BEGIN, ActivityStage.TimeLogic.FIX));
/*     */     
/*     */ 
/*     */ 
/*  71 */     stageList.add(new ActivityStage(KeJuQuestionConsts.getInstance().HUISHI_PERSIST_MINUTE, ActivityStage.TimeBaseLine.BEFORE, ActivityStage.TimeLogic.FIX));
/*     */     
/*     */ 
/*  74 */     stageList.add(new ActivityStage(KeJuQuestionConsts.getInstance().HUISHI_REST_MINUTE, ActivityStage.TimeBaseLine.BEFORE, ActivityStage.TimeLogic.FIX));
/*     */     
/*     */ 
/*  77 */     return stageList;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void onActivityStart(ActivityHandler.ActivityStartType activityStartType, int activityid)
/*     */   {
/*  84 */     if (!activityStartType.startAgain())
/*     */     {
/*  86 */       KeJuQuestionManager.getInstance().initKejuActivityInfo();
/*     */     }
/*     */     
/*     */ 
/*  90 */     ControllerInterface.triggerController(KeJuQuestionConsts.getInstance().XIANGSHI_NPC_CONTROLLER_ID);
/*  91 */     ControllerInterface.triggerController(KeJuQuestionConsts.getInstance().HUISHI_NPC_CONTROLLER_ID);
/*  92 */     ControllerInterface.triggerController(KeJuQuestionConsts.getInstance().DIANSHI_NPC_CONTROLLER_ID);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void onActivityStageStart(int stage, boolean startAgain, int activityid)
/*     */   {
/*  99 */     if (startAgain)
/*     */     {
/* 101 */       if ((stage == 2) || (stage == 3))
/*     */       {
/* 103 */         KeJuQuestionManager.getInstance().createDiuanshiWorld();
/* 104 */         new KejuAwardObserver(TimeUnit.MINUTES.toSeconds(KeJuQuestionConsts.getInstance().AWARD_INTERVAL));
/*     */       }
/*     */       
/* 107 */       return;
/*     */     }
/*     */     
/* 110 */     if (stage != 0)
/*     */     {
/*     */ 
/*     */ 
/*     */ 
/* 115 */       if (stage == 1)
/*     */       {
/* 117 */         KeJuQuestionManager.getInstance().synRoleState(stage);
/*     */       }
/* 119 */       else if (stage == 2)
/*     */       {
/* 121 */         KeJuQuestionManager.getInstance().filterDianShiApp();
/*     */         
/* 123 */         SBulletinInfo sBulletinInfo = new SBulletinInfo();
/* 124 */         sBulletinInfo.bulletintype = 25;
/* 125 */         BulletinInterface.sendBulletin(sBulletinInfo);
/*     */         
/* 127 */         KeJuQuestionManager.getInstance().createDiuanshiWorld();
/* 128 */         new KejuAwardObserver(TimeUnit.MINUTES.toSeconds(KeJuQuestionConsts.getInstance().AWARD_INTERVAL));
/*     */ 
/*     */       }
/* 131 */       else if (stage == 3)
/*     */       {
/*     */ 
/* 134 */         KeJuQuestionManager.getInstance().initDianshiData();
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void onActivityEnd(int activityid)
/*     */   {
/* 145 */     KeJuQuestionManager.getInstance().closeNpcAndWorld();
/*     */     
/* 147 */     KeJuQuestionManager.getInstance().offerAwardMail();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\question\main\KeJuQuestionActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */