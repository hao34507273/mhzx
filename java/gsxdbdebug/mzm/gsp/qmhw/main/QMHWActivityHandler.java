/*     */ package mzm.gsp.qmhw.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.activity.main.ActivityHandler;
/*     */ import mzm.gsp.activity.main.ActivityHandler.ActivityStartType;
/*     */ import mzm.gsp.activity.main.ActivityStage;
/*     */ import mzm.gsp.activity.main.ActivityStage.TimeBaseLine;
/*     */ import mzm.gsp.activity.main.ActivityStage.TimeLogic;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.map.main.ControllerInterface;
/*     */ import mzm.gsp.map.main.MapInterface;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.qmhw.confbean.SQMHWCfgConsts;
/*     */ import mzm.gsp.team.main.TeamInterface;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.QMHWActivity;
/*     */ import xbean.RoleQMHWScore;
/*     */ 
/*     */ class QMHWActivityHandler implements ActivityHandler
/*     */ {
/*     */   public void initData(String userid, long roleId, int turn, int activityid)
/*     */   {
/*  30 */     RoleQMHWScore xRoleQMHWScore = QMHWManager.getXQMHWRoleCreateIfNotExist(roleId);
/*  31 */     xRoleQMHWScore.setContinuewincount(0);
/*  32 */     xRoleQMHWScore.setLosecount(0);
/*  33 */     xRoleQMHWScore.setScore(SQMHWCfgConsts.getInstance().INI_SCORE);
/*  34 */     xRoleQMHWScore.setWincount(0);
/*  35 */     xRoleQMHWScore.getGetawards().clear();
/*  36 */     xRoleQMHWScore.getGetjoinawards().clear();
/*  37 */     xRoleQMHWScore.getMatchroles().clear();
/*  38 */     xRoleQMHWScore.getLatestmatchroles().clear();
/*  39 */     xRoleQMHWScore.setExtendmatchscore(0);
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
/*  51 */     ActivityStage prepare = new ActivityStage(SQMHWCfgConsts.getInstance().PREPARE_TIME_MIN, ActivityStage.TimeBaseLine.BEGIN, ActivityStage.TimeLogic.FIX);
/*     */     
/*     */ 
/*  54 */     ActivityStage match = new ActivityStage(SQMHWCfgConsts.getInstance().LAST_MATH_TO_END_MIN, ActivityStage.TimeBaseLine.END, ActivityStage.TimeLogic.FIX);
/*     */     
/*     */ 
/*  57 */     stages.add(prepare);
/*  58 */     stages.add(match);
/*     */     
/*  60 */     return stages;
/*     */   }
/*     */   
/*     */   public void onActivityStart(ActivityHandler.ActivityStartType startType, int activityid)
/*     */   {
/*  65 */     GameServer.logger().info(String.format("[QMHW]QMHWActivityHandler.onActivityStart@气脉会武活动开始", new Object[0]));
/*  66 */     if (!OpenInterface.getOpenStatus(58)) {
/*  67 */       return;
/*     */     }
/*     */     
/*  70 */     QMHWActivity xQmhwActivity = QMHWManager.getXQmhwCreateIfNotExist();
/*     */     
/*  72 */     if (startType.isBigTurn())
/*     */     {
/*  74 */       if (xQmhwActivity.getHandleresult() == 1)
/*     */       {
/*  76 */         NoneRealTimeTaskManager.getInstance().addTask(new LogicProcedure()
/*     */         {
/*     */           protected boolean processImp() throws Exception
/*     */           {
/*  80 */             boolean ret = new PQMHWEndResult(-1L, false).call();
/*  81 */             QMHWChart.getInstance().clear();
/*  82 */             return ret;
/*     */           }
/*     */         });
/*     */       } else {
/*  86 */         QMHWChart.getInstance().clear();
/*     */       }
/*     */       
/*  89 */       NoneRealTimeTaskManager.getInstance().addTask(new LogicProcedure()
/*     */       {
/*     */         protected boolean processImp() throws Exception
/*     */         {
/*  93 */           QMHWChart.getInstance().saveToDB();
/*  94 */           return true;
/*     */         }
/*     */       });
/*     */     }
/*     */     
/*  99 */     long worldid = MapInterface.createWorld(Arrays.asList(new Integer[] { Integer.valueOf(SQMHWCfgConsts.getInstance().ACTIVITY_MAP_ID) }));
/* 100 */     xQmhwActivity.setWorldid(worldid);
/* 101 */     xQmhwActivity.getFightids().clear();
/*     */     
/* 103 */     NoneRealTimeTaskManager.getInstance().addTask(new LogicProcedure()
/*     */     {
/*     */       protected boolean processImp()
/*     */         throws Exception
/*     */       {
/* 108 */         QMHWActivity xQmhwActivity = QMHWManager.getXQmhwCreateIfNotExist();
/* 109 */         xQmhwActivity.setHandleresult(0);
/* 110 */         return true;
/*     */       }
/*     */       
/*     */ 
/* 114 */     });
/* 115 */     ControllerInterface.triggerController(SQMHWCfgConsts.getInstance().START_CONTROL_ID);
/*     */     
/*     */ 
/* 118 */     new AwardObserver();
/*     */     
/*     */ 
/* 121 */     QMHWTeamHandler teamHandler = new QMHWTeamHandler();
/* 122 */     TeamInterface.registerJoinTeam(worldid, teamHandler);
/* 123 */     TeamInterface.registerActivityTeam(worldid, teamHandler);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void onActivityStageStart(int stage, boolean startAgain, int activityid)
/*     */   {
/* 130 */     GameServer.logger().info(String.format("[QMHW]QMHWActivityHandler.onActivityStageStart@气脉会武阶段开始,当前阶段|stage=%d", new Object[] { Integer.valueOf(stage) }));
/*     */     
/*     */ 
/*     */ 
/* 134 */     QMHWActivity xQmhwActivity = QMHWManager.getQmhwActivity(false);
/* 135 */     QMHWManager.brocastStage(xQmhwActivity, stage);
/*     */     
/* 137 */     switch (stage)
/*     */     {
/*     */     case 1: 
/* 140 */       QMHWManager.matchFight();
/* 141 */       new MatchObserver();
/* 142 */       break;
/*     */     case 2: 
/*     */       break;
/*     */     
/*     */     default: 
/* 147 */       GameServer.logger().error(String.format("[QMHW]QMHWActivityHandler.onActivityStageStart@wrong stage|stage=%d", new Object[] { Integer.valueOf(stage) }));
/*     */     }
/*     */     
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void onActivityEnd(int activityid)
/*     */   {
/* 157 */     QMHWActivity xQmhwActivity = QMHWManager.getXQmhwCreateIfNotExist();
/*     */     
/* 159 */     long worldid = xQmhwActivity.getWorldid();
/*     */     
/* 161 */     ControllerInterface.collectController(SQMHWCfgConsts.getInstance().START_CONTROL_ID);
/*     */     
/* 163 */     TeamInterface.unRegisterJoinTeam(worldid);
/* 164 */     TeamInterface.unRegisterActivityTeam(worldid);
/*     */     
/* 166 */     xQmhwActivity.setHandleresult(1);
/*     */     
/*     */ 
/* 169 */     NoneRealTimeTaskManager.getInstance().addTask(new PQMHWEndResult(xQmhwActivity.getWorldid(), true));
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\qmhw\main\QMHWActivityHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */