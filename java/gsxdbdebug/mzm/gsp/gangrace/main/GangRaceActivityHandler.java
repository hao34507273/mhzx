/*     */ package mzm.gsp.gangrace.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.activity.confbean.SGangRaceConsts;
/*     */ import mzm.gsp.activity.main.ActivityHandler.ActivityStartType;
/*     */ import mzm.gsp.activity.main.ActivityStage;
/*     */ import mzm.gsp.activity.main.ActivityStage.TimeBaseLine;
/*     */ import mzm.gsp.activity.main.ActivityStage.TimeLogic;
/*     */ import mzm.gsp.gang.main.GangInterface;
/*     */ import mzm.gsp.map.main.ControllerInterface;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.GangRaceGameInfo;
/*     */ import xbean.GangRaceRoleInfo;
/*     */ import xtable.Gangrace2gameinfo;
/*     */ import xtable.Role2gangraceinfo;
/*     */ 
/*     */ public class GangRaceActivityHandler implements mzm.gsp.activity.main.ActivityHandler
/*     */ {
/*  24 */   private int raceCount = 1;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public List<ActivityStage> getActivityStages()
/*     */   {
/*  31 */     this.raceCount = SGangRaceConsts.getInstance().raceCount;
/*  32 */     if (this.raceCount < 1) {
/*  33 */       this.raceCount = 1;
/*     */     }
/*  35 */     List<ActivityStage> stages = new ArrayList();
/*     */     
/*  37 */     stages.add(new ActivityStage(SGangRaceConsts.getInstance().voteTime, ActivityStage.TimeBaseLine.BEGIN, ActivityStage.TimeLogic.FIX));
/*  38 */     stages.add(new ActivityStage(SGangRaceConsts.getInstance().runTime, ActivityStage.TimeBaseLine.BEFORE, ActivityStage.TimeLogic.FIX));
/*     */     
/*  40 */     for (int i = 1; i < this.raceCount; i++) {
/*  41 */       stages.add(new ActivityStage(SGangRaceConsts.getInstance().voteTime, ActivityStage.TimeBaseLine.BEFORE, ActivityStage.TimeLogic.FIX));
/*  42 */       stages.add(new ActivityStage(SGangRaceConsts.getInstance().runTime, ActivityStage.TimeBaseLine.BEFORE, ActivityStage.TimeLogic.FIX));
/*     */     }
/*     */     
/*  45 */     return stages;
/*     */   }
/*     */   
/*     */   public void onActivityStart(ActivityHandler.ActivityStartType activityStartType, int activityid)
/*     */   {
/*  50 */     if (!mzm.gsp.open.main.OpenInterface.getOpenStatus(99)) {
/*  51 */       return;
/*     */     }
/*  53 */     if (GameServer.logger().isDebugEnabled()) {
/*  54 */       GameServer.logger().debug("帮派赛跑活动开启--------");
/*     */     }
/*     */     
/*  57 */     Set<Long> allGangIds = GangInterface.getAllGangIdSet();
/*     */     
/*  59 */     for (Iterator i$ = allGangIds.iterator(); i$.hasNext();) { long gangid = ((Long)i$.next()).longValue();
/*     */       
/*  61 */       long worldid = GangInterface.getGangWorldId(gangid);
/*  62 */       if (worldid > 0L) {
/*  63 */         ControllerInterface.triggerWorldController(worldid, SGangRaceConsts.getInstance().NpcControlId);
/*     */       }
/*     */     }
/*     */     Iterator i$;
/*  67 */     if ((activityStartType.isBigTurn()) || (activityStartType.isLittleTurnFirst()))
/*     */     {
/*     */ 
/*  70 */       xdb.Lockeys.lock(Gangrace2gameinfo.getTable(), allGangIds);
/*  71 */       for (i$ = allGangIds.iterator(); i$.hasNext();) { long gangid = ((Long)i$.next()).longValue();
/*  72 */         GangRaceGameInfo xGangRaceGameInfoBean = Gangrace2gameinfo.get(Long.valueOf(gangid));
/*  73 */         if (xGangRaceGameInfoBean != null) {
/*  74 */           Map<Integer, Integer> id2money = xGangRaceGameInfoBean.getRaceid2money();
/*  75 */           for (int i = 1; i <= 5; i++) {
/*  76 */             id2money.put(Integer.valueOf(i), Integer.valueOf(0));
/*     */           }
/*  78 */           xGangRaceGameInfoBean.setGameid(0);
/*  79 */           xGangRaceGameInfoBean.getCurgameroleids().clear();
/*     */           
/*  81 */           xGangRaceGameInfoBean.getAllroleids().clear();
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*  86 */     GangRaceManager.getInstance().activityBegin(this.raceCount);
/*     */   }
/*     */   
/*     */   public void onActivityStageStart(int stageIndex, boolean startAgain, int activityid)
/*     */   {
/*  91 */     int stage = stageIndex % 2;
/*  92 */     int round = stageIndex / 2;
/*  93 */     if (round < this.raceCount) {
/*  94 */       GangRaceManager.getInstance().changeStage(round, stage);
/*     */     }
/*     */     else {
/*  97 */       GangRaceManager.getInstance().changeStage(this.raceCount, -1);
/*     */     }
/*     */   }
/*     */   
/*     */   public void onActivityEnd(int activityid)
/*     */   {
/* 103 */     if (GameServer.logger().isDebugEnabled()) {
/* 104 */       GameServer.logger().debug("帮派赛跑活动结束---------");
/*     */     }
/*     */     
/* 107 */     Set<Long> allGangIds = GangInterface.getAllGangIdSet();
/*     */     
/* 109 */     for (Iterator i$ = allGangIds.iterator(); i$.hasNext();) { long gangid = ((Long)i$.next()).longValue();
/*     */       
/* 111 */       long worldid = GangInterface.getGangWorldId(gangid);
/* 112 */       if (worldid > 0L) {
/* 113 */         ControllerInterface.collectWorldController(worldid, SGangRaceConsts.getInstance().NpcControlId);
/*     */       }
/*     */     }
/*     */     
/* 117 */     GangRaceManager.getInstance().activityEnd();
/*     */   }
/*     */   
/*     */   public void initData(String userid, long roleId, int turn, int activityid)
/*     */   {
/* 122 */     GangRaceRoleInfo xGangRaceGameInfoBean = Role2gangraceinfo.get(Long.valueOf(roleId));
/* 123 */     if (xGangRaceGameInfoBean != null) {
/* 124 */       xGangRaceGameInfoBean.getRaceid2money().clear();
/*     */     }
/*     */   }
/*     */   
/*     */   public mzm.gsp.award.main.AwardReason getRecommendAwardReason()
/*     */   {
/* 130 */     return null;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gangrace\main\GangRaceActivityHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */