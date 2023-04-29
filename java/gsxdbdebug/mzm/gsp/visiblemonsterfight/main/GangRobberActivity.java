/*     */ package mzm.gsp.visiblemonsterfight.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Random;
/*     */ import java.util.Set;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.activity.SSyncGangRobberEvent;
/*     */ import mzm.gsp.activity.SSyncVisibleMonsterReward;
/*     */ import mzm.gsp.activity.confbean.SActivityCfg;
/*     */ import mzm.gsp.activity.confbean.SGangRobberModifyCfg;
/*     */ import mzm.gsp.activity.confbean.SMonsterLevelAwardCfg;
/*     */ import mzm.gsp.activity.main.ActivityHandler.ActivityStartType;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityJoinResult;
/*     */ import mzm.gsp.activity.main.ActivityLogStatus;
/*     */ import mzm.gsp.activity.main.ActivityStage;
/*     */ import mzm.gsp.activity.main.ActivityStage.TimeBaseLine;
/*     */ import mzm.gsp.activity.main.ActivityStage.TimeLogic;
/*     */ import mzm.gsp.award.main.AwardInterface;
/*     */ import mzm.gsp.award.main.AwardModel;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.gang.main.GangInterface;
/*     */ import mzm.gsp.item.main.access.ItemAccessManager;
/*     */ import mzm.gsp.map.main.MapInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.timer.main.Observer;
/*     */ import mzm.gsp.timer.main.Session;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*     */ import mzm.gsp.visiblemonsterfight.confbean.SGangRobberConst;
/*     */ import mzm.gsp.visiblemonsterfight.confbean.SGangRobberRefreshCfg;
/*     */ import mzm.gsp.visiblemonsterfight.event.KillRobberArg;
/*     */ import mzm.gsp.visiblemonsterfight.main.robber.RobberEnterFightHandler;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.GangMonsterRobber;
/*     */ import xbean.GangRobber;
/*     */ import xbean.MonsterRobberRound;
/*     */ import xbean.Pod;
/*     */ import xtable.Gang;
/*     */ import xtable.Gangrobber;
/*     */ 
/*     */ public class GangRobberActivity implements IMonsterDeadHandle
/*     */ {
/*     */   private Observer activityObserver;
/*  56 */   private List<SMonsterLevelAwardCfg> levelAwardCfgs = new ArrayList();
/*     */   private AwardReason reason;
/*     */   private int activityType;
/*     */   private RobberEnterFightHandler handler;
/*     */   private Session delayNotifyObserver;
/*     */   private static final int RATE = 10000;
/*     */   
/*     */   public GangRobberActivity() throws Exception {
/*  64 */     this.reason = new AwardReason(LogReason.GANG_ROBBER_ACTIVITY_ADD);
/*  65 */     this.activityType = 2;
/*  66 */     ActivityInterface.registerActivityByLogicType(13, this);
/*  67 */     for (SMonsterLevelAwardCfg cfg : SMonsterLevelAwardCfg.getAll().values()) {
/*  68 */       if (cfg.activityId == SGangRobberConst.getInstance().ACTIVITYID) {
/*  69 */         this.levelAwardCfgs.add(cfg);
/*     */       }
/*     */     }
/*     */     
/*  73 */     for (Iterator i$ = SGangRobberConst.getInstance().awardids.iterator(); i$.hasNext();) { int awardid = ((Integer)i$.next()).intValue();
/*  74 */       ItemAccessManager.registerActivityReward(SGangRobberConst.getInstance().ACTIVITYID, awardid);
/*     */     }
/*  76 */     int activityStageSize = getActivityStages().size();
/*  77 */     int stageIndex = getIndexStage(activityStageSize);
/*  78 */     if (SGangRobberConst.getInstance().triggerTimes.size() != stageIndex) {
/*  79 */       throw new RuntimeException(String.format("[GangRobberActivity]GangRobberActivity.GangRobberActivity@帮派强盗阶段配置错误|stage=%d|controlerTimeSize=%d", new Object[] { Integer.valueOf(stageIndex), Integer.valueOf(SGangRobberConst.getInstance().triggerTimes.size()) }));
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public AwardReason getAwardReason()
/*     */   {
/*  87 */     return this.reason;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void initData(String userid, long roleId, int turn, int activityid) {}
/*     */   
/*     */ 
/*     */   public AwardReason getRecommendAwardReason()
/*     */   {
/*  97 */     return this.reason;
/*     */   }
/*     */   
/*     */   public List<ActivityStage> getActivityStages()
/*     */   {
/* 102 */     List<ActivityStage> stageList = new ArrayList();
/*     */     
/* 104 */     long activityDuration = ActivityInterface.getActivityDurationMinute(SGangRobberConst.getInstance().ACTIVITYID);
/* 105 */     long round = activityDuration / SGangRobberConst.getInstance().ROBBER_NEXT_ROUND_MINUTE;
/* 106 */     long extraMinute = activityDuration % SGangRobberConst.getInstance().ROBBER_NEXT_ROUND_MINUTE;
/* 107 */     if (extraMinute >= SGangRobberConst.getInstance().ROBBER_ROUND_INTERVAL_MINUTE) {
/* 108 */       round += 1L;
/*     */     }
/* 110 */     for (int i = 0; i < round; i++) {
/* 111 */       if (SGangRobberRefreshCfg.get(i + 1) == null) {
/* 112 */         throw new RuntimeException(String.format("[GangRobberActivity]GangRobberActivity.getActivityStages@do not exist SGangRobberRefreshCfg config|round=%d", new Object[] { Integer.valueOf(i + 1) }));
/*     */       }
/*     */       
/*     */ 
/*     */ 
/* 117 */       int roundMinute = SGangRobberConst.getInstance().ROBBER_NEXT_ROUND_MINUTE * i;
/* 118 */       if (i != 0) {
/* 119 */         stageList.add(new ActivityStage(roundMinute, ActivityStage.TimeBaseLine.BEGIN, ActivityStage.TimeLogic.FIX));
/*     */       }
/*     */       
/* 122 */       for (Iterator i$ = SGangRobberConst.getInstance().triggerTimes.iterator(); i$.hasNext();) { int triggerMin = ((Integer)i$.next()).intValue();
/* 123 */         stageList.add(new ActivityStage(roundMinute + triggerMin, ActivityStage.TimeBaseLine.BEGIN, ActivityStage.TimeLogic.FIX));
/*     */       }
/*     */       
/*     */ 
/* 127 */       if (i != round - 1L) {
/* 128 */         stageList.add(new ActivityStage(roundMinute + SGangRobberConst.getInstance().ROBBER_ROUND_INTERVAL_MINUTE, ActivityStage.TimeBaseLine.BEGIN, ActivityStage.TimeLogic.FIX));
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 133 */     return stageList;
/*     */   }
/*     */   
/*     */   public int toMinute(int sec) {
/* 137 */     return (int)TimeUnit.SECONDS.toMinutes(sec);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void onActivityStart(ActivityHandler.ActivityStartType activityStartType, int activityid)
/*     */   {
/* 145 */     boolean startAgain = (!activityStartType.isBigTurn()) && (!activityStartType.isLittleTurnFirst());
/* 146 */     onActivityStartStage(startAgain, 0);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void onActivityStartStage(boolean startAgain, int stage)
/*     */   {
/* 159 */     if (!OpenInterface.getOpenStatus(59)) {
/* 160 */       return;
/*     */     }
/*     */     
/* 163 */     Map<Long, Long> gangidToWorldids = new HashMap();
/*     */     
/* 165 */     Set<Long> gangids = GangInterface.getAllGangIdSet();
/* 166 */     for (Iterator i$ = gangids.iterator(); i$.hasNext();) { long gangid = ((Long)i$.next()).longValue();
/*     */       
/* 168 */       long worldId = GangInterface.getGangWorldId(gangid);
/* 169 */       if (worldId < 0L) {
/* 170 */         GameServer.logger().error("帮派活动开始的时候帮派地图还没有创建:gangid:" + gangid);
/*     */       }
/*     */       else {
/* 173 */         gangidToWorldids.put(Long.valueOf(gangid), Long.valueOf(worldId));
/*     */       }
/*     */     }
/*     */     
/* 177 */     GangRobber xGangRobber = Gangrobber.get(Long.valueOf(GameServerInfoManager.getLocalId()));
/* 178 */     if (xGangRobber == null) {
/* 179 */       xGangRobber = Pod.newGangRobber();
/* 180 */       Gangrobber.insert(Long.valueOf(GameServerInfoManager.getLocalId()), xGangRobber);
/*     */     }
/*     */     
/* 183 */     if ((stage == 0) && (!startAgain))
/*     */     {
/* 185 */       xGangRobber.getGangrobberdatas().clear();
/* 186 */       xGangRobber.getRoundopenset().clear();
/* 187 */       xGangRobber.setStage(0);
/*     */     }
/* 189 */     int storeStage = xGangRobber.getStage();
/* 190 */     int storeRound = getRound(storeStage);
/* 191 */     int nowRound = getRound(stage);
/* 192 */     if (storeRound > nowRound)
/*     */     {
/* 194 */       return;
/*     */     }
/* 196 */     if (stage > storeStage) {
/* 197 */       xGangRobber.setStage(stage);
/*     */     }
/*     */     Iterator i$;
/* 200 */     if (!startAgain) {
/* 201 */       if (isTurnOpen(nowRound, xGangRobber.getRoundopenset().size())) {
/* 202 */         xGangRobber.getRoundopenset().add(Integer.valueOf(nowRound));
/*     */       }
/*     */       else {
/* 205 */         return;
/*     */       }
/*     */       
/* 208 */       for (i$ = gangids.iterator(); i$.hasNext();) { long gangid = ((Long)i$.next()).longValue();
/* 209 */         GangMonsterRobber xMonsterRobber = (GangMonsterRobber)xGangRobber.getGangrobberdatas().get(Long.valueOf(gangid));
/* 210 */         if (xMonsterRobber == null) {
/* 211 */           xMonsterRobber = Pod.newGangMonsterRobber();
/* 212 */           xGangRobber.getGangrobberdatas().put(Long.valueOf(gangid), xMonsterRobber);
/*     */         } else {
/* 214 */           clearXMonsterRobberData(xMonsterRobber);
/*     */         }
/*     */       }
/*     */     } else {
/* 218 */       if (!xGangRobber.getRoundopenset().contains(Integer.valueOf(nowRound)))
/*     */       {
/* 220 */         return;
/*     */       }
/*     */       
/* 223 */       Iterator<Map.Entry<Long, Long>> gangidToWorldidIter = gangidToWorldids.entrySet().iterator();
/* 224 */       while (gangidToWorldidIter.hasNext()) {
/* 225 */         Map.Entry<Long, Long> gangIdToWorldidEntry = (Map.Entry)gangidToWorldidIter.next();
/* 226 */         if (!xGangRobber.getGangrobberdatas().containsKey(gangIdToWorldidEntry.getKey())) {
/* 227 */           gangidToWorldidIter.remove();
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 233 */     this.handler = new RobberEnterFightHandler();
/* 234 */     for (Map.Entry<Long, Long> gangIdToWorldEntry : gangidToWorldids.entrySet())
/*     */     {
/* 236 */       long worldId = ((Long)gangIdToWorldEntry.getValue()).longValue();
/* 237 */       MapInterface.registerMonsterFightHandler(worldId, this.handler);
/*     */     }
/*     */     
/* 240 */     this.delayNotifyObserver = new Session(SGangRobberConst.getInstance().ROBBER_COUNT_NOTIFY_DELAY_SEC, SGangRobberConst.getInstance().ACTIVITYID)
/*     */     {
/*     */ 
/*     */       protected void onTimeOut()
/*     */       {
/* 245 */         NoneRealTimeTaskManager.getInstance().addTask(new LogicProcedure()
/*     */         {
/*     */           protected boolean processImp() throws Exception {
/* 248 */             if (!ActivityInterface.isActivityOpen(SGangRobberConst.getInstance().ACTIVITYID)) {
/* 249 */               return false;
/*     */             }
/* 251 */             GangRobberActivity.this.activityObserver = new mzm.gsp.visiblemonsterfight.main.robber.ActivityWarningObserver();
/* 252 */             return true;
/*     */           }
/* 254 */         });
/* 255 */         GangRobberActivity.this.delayNotifyObserver = null;
/*     */       }
/*     */     };
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void clearXMonsterRobberData(GangMonsterRobber xMonsterRobber)
/*     */   {
/* 266 */     xMonsterRobber.getRobberrounddatas().clear();
/*     */   }
/*     */   
/*     */   static int getRound(int stage)
/*     */   {
/* 271 */     return stage / (1 + SGangRobberConst.getInstance().triggerTimes.size() + 1) + 1;
/*     */   }
/*     */   
/*     */   private boolean isTurnOpen(int turn, int totalOpenCount) {
/* 275 */     if (totalOpenCount >= SGangRobberConst.getInstance().maxRefreshCount) {
/* 276 */       return false;
/*     */     }
/* 278 */     SGangRobberRefreshCfg gangRobberRefreshCfg = SGangRobberRefreshCfg.get(turn);
/* 279 */     if ((gangRobberRefreshCfg.isJudgeCount) && 
/* 280 */       (totalOpenCount < gangRobberRefreshCfg.lessThanMustRefresh)) {
/* 281 */       return true;
/*     */     }
/*     */     
/* 284 */     return gangRobberRefreshCfg.rate > xdb.Xdb.random().nextInt(10000);
/*     */   }
/*     */   
/*     */   private int getIndexStage(int stage) {
/* 288 */     return stage % (1 + SGangRobberConst.getInstance().triggerTimes.size() + 1);
/*     */   }
/*     */   
/*     */   private boolean isInEndStage(int indexStage) {
/* 292 */     return indexStage == SGangRobberConst.getInstance().triggerTimes.size() + 1;
/*     */   }
/*     */   
/*     */ 
/*     */   public void onActivityStageStart(int stage, boolean startAgain, int activityid)
/*     */   {
/* 298 */     int indexStage = getIndexStage(stage);
/* 299 */     if (indexStage == 0) {
/* 300 */       onActivityStartStage(startAgain, stage);
/* 301 */       return;
/*     */     }
/*     */     
/* 304 */     GangRobber xGangRobber = Gangrobber.get(Long.valueOf(GameServerInfoManager.getLocalId()));
/* 305 */     int storeStage = xGangRobber.getStage();
/* 306 */     if (stage > storeStage) {
/* 307 */       xGangRobber.setStage(stage);
/*     */     }
/* 309 */     int storeRound = getRound(storeStage);
/* 310 */     int round = getRound(stage);
/*     */     
/*     */ 
/* 313 */     if (storeRound > round) {
/* 314 */       return;
/*     */     }
/*     */     
/*     */ 
/* 318 */     if (!xGangRobber.getRoundopenset().contains(Integer.valueOf(round))) {
/* 319 */       return;
/*     */     }
/*     */     
/* 322 */     if (isInEndStage(indexStage)) {
/* 323 */       onActivityEndStage(stage, xGangRobber);
/* 324 */       return;
/*     */     }
/*     */     
/* 327 */     int index = indexStage - 1;
/* 328 */     if (index < 0) {
/* 329 */       GameServer.logger().error("帮派强盗传递的阶段id值出错了!!!stage:" + stage);
/* 330 */       return;
/*     */     }
/*     */     
/* 333 */     Map<Integer, Integer> controlerid2Count = new HashMap();
/*     */     
/* 335 */     int needRefreshNum = indexStage * SGangRobberConst.getInstance().refreshMonsterNumPer;
/*     */     
/* 337 */     for (Map.Entry<Long, GangMonsterRobber> entry : xGangRobber.getGangrobberdatas().entrySet()) {
/* 338 */       long gangId = ((Long)entry.getKey()).longValue();
/* 339 */       GangMonsterRobber xGangMonsterRobber = (GangMonsterRobber)entry.getValue();
/* 340 */       MonsterRobberRound monsterRobberRound = (MonsterRobberRound)xGangMonsterRobber.getRobberrounddatas().get(Integer.valueOf(round));
/* 341 */       Iterator i$; if (monsterRobberRound != null) {
/* 342 */         for (int controlerIndex = 0; controlerIndex < SGangRobberConst.getInstance().controlers.size(); controlerIndex++) {
/* 343 */           int controlerid = ((Integer)SGangRobberConst.getInstance().controlers.get(controlerIndex)).intValue();
/* 344 */           if (controlerIndex >= SGangRobberConst.getInstance().monsterids.size()) {
/*     */             break;
/*     */           }
/* 347 */           int monsterid = ((Integer)SGangRobberConst.getInstance().monsterids.get(controlerIndex)).intValue();
/* 348 */           Integer deadCount = (Integer)monsterRobberRound.getDeadmonsterandcount().get(Integer.valueOf(monsterid));
/* 349 */           if (deadCount != null) {
/* 350 */             int maxKillNum = MapInterface.getPassiveMonsterMaxKilledTimes(monsterid);
/* 351 */             if (maxKillNum > 0) {
/* 352 */               deadCount = Integer.valueOf(deadCount.intValue() / maxKillNum);
/*     */             }
/*     */             
/* 355 */             int refreshNum = Math.min(SGangRobberConst.getInstance().refreshMonsterNumPer, needRefreshNum - deadCount.intValue());
/*     */             
/* 357 */             if (refreshNum > 0) {
/* 358 */               controlerid2Count.put(Integer.valueOf(controlerid), Integer.valueOf(refreshNum));
/*     */             }
/*     */           } else {
/* 361 */             controlerid2Count.put(Integer.valueOf(controlerid), Integer.valueOf(SGangRobberConst.getInstance().refreshMonsterNumPer));
/*     */           }
/*     */           
/*     */         }
/*     */       } else {
/* 366 */         for (i$ = SGangRobberConst.getInstance().controlers.iterator(); i$.hasNext();) { int controlerid = ((Integer)i$.next()).intValue();
/* 367 */           controlerid2Count.put(Integer.valueOf(controlerid), Integer.valueOf(SGangRobberConst.getInstance().refreshMonsterNumPer));
/*     */         }
/*     */       }
/* 370 */       NoneRealTimeTaskManager.getInstance().addTask(new PGangRobberActivityStage(gangId, indexStage, controlerid2Count));
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   private void onActivityEndStage(int stage, GangRobber xGangRobber)
/*     */   {
/* 377 */     if (this.delayNotifyObserver != null) {
/* 378 */       this.delayNotifyObserver.stopTimer();
/* 379 */       this.delayNotifyObserver = null;
/*     */     }
/*     */     
/* 382 */     if (this.activityObserver != null) {
/* 383 */       this.activityObserver.stopTimer();
/* 384 */       this.activityObserver = null;
/*     */     }
/* 386 */     for (Map.Entry<Long, GangMonsterRobber> gangMonsters : xGangRobber.getGangrobberdatas().entrySet()) {
/* 387 */       long gangId = ((Long)gangMonsters.getKey()).longValue();
/* 388 */       NoneRealTimeTaskManager.getInstance().addTask(new PGangRobberActivityEnd(gangId, this.handler, SGangRobberConst.getInstance().controlers));
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public void onActivityEnd(int activityid)
/*     */   {
/* 395 */     GangRobber xGangRobber = Gangrobber.get(Long.valueOf(GameServerInfoManager.getLocalId()));
/* 396 */     int stage = xGangRobber.getStage();
/* 397 */     xGangRobber.setStage(++stage);
/* 398 */     int round = getRound(stage);
/*     */     
/* 400 */     if (!xGangRobber.getRoundopenset().contains(Integer.valueOf(round))) {
/* 401 */       return;
/*     */     }
/* 403 */     onActivityEndStage(xGangRobber.getStage(), xGangRobber);
/*     */   }
/*     */   
/*     */ 
/*     */   public void init() {}
/*     */   
/*     */   public boolean checkMonster1(List<Integer> monsterIdList)
/*     */   {
/* 411 */     for (Integer mid : monsterIdList) {
/* 412 */       if (mzm.gsp.monster.main.MonsterInterface.getMonsterCategoryId(mid.intValue()) == SGangRobberConst.getInstance().VISIBLE_MONSTER_ID) {
/* 413 */         return true;
/*     */       }
/*     */     }
/* 416 */     return false;
/*     */   }
/*     */   
/*     */   public boolean handleMonsterDead(VisibleMonsterFightContext context)
/*     */   {
/* 421 */     boolean check1 = checkMonster1(context.monsterIdList);
/* 422 */     if (!check1) {
/* 423 */       return false;
/*     */     }
/* 425 */     Iterator<Long> roleIdIt = context.roleList.iterator();
/* 426 */     Long gangId = null;
/* 427 */     while (roleIdIt.hasNext()) {
/* 428 */       Long roleId = (Long)roleIdIt.next();
/* 429 */       long _gangId = GangInterface.getGangId(roleId.longValue());
/* 430 */       if (_gangId == 0L) {
/* 431 */         roleIdIt.remove();
/*     */ 
/*     */       }
/* 434 */       else if (GangInterface.getGangWorldId(_gangId) != context.worldId) {
/* 435 */         roleIdIt.remove();
/*     */       }
/*     */       else
/* 438 */         gangId = Long.valueOf(_gangId);
/*     */     }
/* 440 */     if (gangId == null) {
/* 441 */       return false;
/*     */     }
/* 443 */     handleAward(context, gangId.longValue());
/* 444 */     KillRobberArg arg = new KillRobberArg();
/* 445 */     arg.monsterCfgId = context.monsterCfgId;
/* 446 */     arg.roleIds.addAll(context.roleList);
/* 447 */     TriggerEventsManger.getInstance().triggerEvent(new mzm.gsp.visiblemonsterfight.event.KillGangRobber(), arg);
/* 448 */     xdb.Procedure.execute(new PAddDeadMonster(gangId.longValue(), context.monsterCfgId));
/* 449 */     return true;
/*     */   }
/*     */   
/*     */   class PAddDeadMonster extends LogicProcedure
/*     */   {
/*     */     private final long gangid;
/*     */     private final int monsterCfgid;
/*     */     
/*     */     public PAddDeadMonster(long gangid, int monsterCfgid) {
/* 458 */       this.gangid = gangid;
/* 459 */       this.monsterCfgid = monsterCfgid;
/*     */     }
/*     */     
/*     */     protected boolean processImp() throws Exception
/*     */     {
/* 464 */       lock(Gang.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.gangid) }));
/* 465 */       GangRobber xGangRobber = Gangrobber.get(Long.valueOf(GameServerInfoManager.getLocalId()));
/* 466 */       GangMonsterRobber xGangMonsterRobber = (GangMonsterRobber)xGangRobber.getGangrobberdatas().get(Long.valueOf(this.gangid));
/* 467 */       if (xGangMonsterRobber == null) {
/* 468 */         return false;
/*     */       }
/* 470 */       int stage = xGangRobber.getStage();
/* 471 */       int round = GangRobberActivity.getRound(stage);
/* 472 */       MonsterRobberRound xMonsterRobberRound = (MonsterRobberRound)xGangMonsterRobber.getRobberrounddatas().get(Integer.valueOf(round));
/* 473 */       if (xMonsterRobberRound == null) {
/* 474 */         xMonsterRobberRound = Pod.newMonsterRobberRound();
/* 475 */         xGangMonsterRobber.getRobberrounddatas().put(Integer.valueOf(round), xMonsterRobberRound);
/*     */       }
/* 477 */       Integer monsterCount = (Integer)xMonsterRobberRound.getDeadmonsterandcount().get(Integer.valueOf(this.monsterCfgid));
/* 478 */       if (monsterCount == null) {
/* 479 */         monsterCount = Integer.valueOf(0);
/*     */       }
/* 481 */       Integer localInteger1 = monsterCount;Integer localInteger2 = monsterCount = Integer.valueOf(monsterCount.intValue() + 1);
/* 482 */       xMonsterRobberRound.getDeadmonsterandcount().put(Integer.valueOf(this.monsterCfgid), monsterCount);
/*     */       
/* 484 */       if (!xMonsterRobberRound.getIsaward()) {
/* 485 */         int totoalDeadNum = 0;
/* 486 */         for (Map.Entry<Integer, Integer> monsteridToDeadCount : xMonsterRobberRound.getDeadmonsterandcount().entrySet())
/*     */         {
/* 488 */           totoalDeadNum += ((Integer)monsteridToDeadCount.getValue()).intValue();
/*     */         }
/* 490 */         if (totoalDeadNum >= SGangRobberConst.getInstance().deadCountCanAward)
/*     */         {
/* 492 */           GangInterface.addGangMoney(this.gangid, SGangRobberConst.getInstance().AWARD_GANG_MONEY);
/* 493 */           GangInterface.addLiHe(this.gangid, SGangRobberConst.getInstance().GANG_AWARD_ID);
/* 494 */           xMonsterRobberRound.setIsaward(true);
/*     */           
/* 496 */           SSyncGangRobberEvent sSyncGangRobberEvent = new SSyncGangRobberEvent();
/* 497 */           sSyncGangRobberEvent.result = 4;
/* 498 */           OnlineManager.getInstance().sendMulti(sSyncGangRobberEvent, GangInterface.getGangMemberList(this.gangid));
/*     */         }
/*     */       }
/*     */       
/* 502 */       int indexStage = GangRobberActivity.this.getIndexStage(stage);
/* 503 */       if ((GangRobberActivity.getLeftMonsterNum(xGangMonsterRobber, round) == 0) && (indexStage >= SGangRobberConst.getInstance().triggerTimes.size()) && (!GangRobberActivity.this.isInEndStage(indexStage)))
/*     */       {
/* 505 */         SSyncGangRobberEvent sSyncGangRobberEvent = new SSyncGangRobberEvent();
/* 506 */         sSyncGangRobberEvent.result = 2;
/* 507 */         OnlineManager.getInstance().sendMulti(sSyncGangRobberEvent, GangInterface.getGangMemberList(this.gangid));
/*     */       }
/*     */       
/* 510 */       return true;
/*     */     }
/*     */   }
/*     */   
/*     */   static int getLeftMonsterNum(GangMonsterRobber xGangMonsterRobber, int round) {
/* 515 */     int totalDeadNum = 0;
/* 516 */     MonsterRobberRound xMonsterRobberRound = (MonsterRobberRound)xGangMonsterRobber.getRobberrounddatas().get(Integer.valueOf(round));
/* 517 */     if (xMonsterRobberRound != null) {
/* 518 */       for (Map.Entry<Integer, Integer> monster2DeadNumEntry : xMonsterRobberRound.getDeadmonsterandcount().entrySet())
/*     */       {
/* 520 */         int monsterid = ((Integer)monster2DeadNumEntry.getKey()).intValue();
/* 521 */         int deadCount = ((Integer)monster2DeadNumEntry.getValue()).intValue();
/* 522 */         int maxKillNum = MapInterface.getPassiveMonsterMaxKilledTimes(monsterid);
/* 523 */         if (maxKillNum > 0) {
/* 524 */           deadCount /= maxKillNum;
/*     */         }
/* 526 */         totalDeadNum += deadCount;
/*     */       }
/*     */     }
/* 529 */     int controlerSize = SGangRobberConst.getInstance().controlers.size();
/* 530 */     int triggerSize = SGangRobberConst.getInstance().triggerTimes.size();
/* 531 */     int totalCount = controlerSize * SGangRobberConst.getInstance().refreshMonsterNumPer * triggerSize;
/*     */     
/* 533 */     int leftNum = totalCount - totalDeadNum;
/* 534 */     return leftNum;
/*     */   }
/*     */   
/*     */   public boolean handleMonsterWin(VisibleMonsterFightContext context)
/*     */   {
/* 539 */     boolean check1 = checkMonster1(context.monsterIdList);
/* 540 */     if (!check1) {
/* 541 */       return false;
/*     */     }
/*     */     
/* 544 */     for (Iterator i$ = context.roleList.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/* 545 */       int count = ActivityInterface.getActivityCount(mzm.gsp.role.main.RoleInterface.getUserId(roleid), roleid, SGangRobberConst.getInstance().ACTIVITYID, false);
/*     */       
/* 547 */       int recommendCount = ActivityInterface.getActivityCfg(SGangRobberConst.getInstance().ACTIVITYID).recommendCount;
/* 548 */       if (count >= recommendCount) {
/* 549 */         SSyncGangRobberEvent sSyncGangRobberEvent = new SSyncGangRobberEvent();
/* 550 */         sSyncGangRobberEvent.result = 3;
/* 551 */         OnlineManager.getInstance().sendAtOnce(roleid, sSyncGangRobberEvent);
/*     */       }
/*     */     }
/* 554 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private List<Long> filterRoleList(VisibleMonsterFightContext context, long gangId)
/*     */   {
/* 563 */     List<Long> needAwardRoleList = new ArrayList();
/* 564 */     Iterator<Long> it = context.roleList.iterator();
/* 565 */     while (it.hasNext()) {
/* 566 */       Long roleId = (Long)it.next();
/* 567 */       if (GangInterface.isGangMember(roleId.longValue(), gangId))
/*     */       {
/*     */ 
/* 570 */         needAwardRoleList.add(roleId); }
/*     */     }
/* 572 */     return needAwardRoleList;
/*     */   }
/*     */   
/*     */   public boolean handleAward(VisibleMonsterFightContext context, long gangId) {
/* 576 */     Map<Long, String> role2user = new HashMap();
/* 577 */     for (Iterator i$ = context.roleList.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/* 578 */       role2user.put(Long.valueOf(roleid), context.allUsers.get(Long.valueOf(roleid)));
/*     */     }
/* 580 */     ActivityJoinResult result = ActivityInterface.canJoinAndCheckInitActivityData(role2user, context.roleList, SGangRobberConst.getInstance().ACTIVITYID);
/*     */     
/* 582 */     if (!result.isCanJoin()) {
/* 583 */       return false;
/*     */     }
/*     */     
/* 586 */     List<Long> needAwardRoleList = filterRoleList(context, gangId);
/*     */     
/* 588 */     if (needAwardRoleList.isEmpty()) {
/* 589 */       return false;
/*     */     }
/*     */     
/* 592 */     boolean check1 = checkMonster1(context.monsterIdList);
/*     */     
/* 594 */     if (!check1) {
/* 595 */       return false;
/*     */     }
/*     */     
/* 598 */     boolean isFightOk = false;
/* 599 */     if (check1) {
/* 600 */       for (Long roleId : needAwardRoleList) {
/* 601 */         int count = ActivityInterface.getActivityCount((String)role2user.get(roleId), roleId.longValue(), SGangRobberConst.getInstance().ACTIVITYID, true);
/*     */         
/* 603 */         int recommendCount = ActivityInterface.getActivityCfg(SGangRobberConst.getInstance().ACTIVITYID).recommendCount;
/*     */         
/* 605 */         boolean sendDefalutMsg = count >= recommendCount;
/*     */         
/* 607 */         int modifyid = getModifyAwardId(count + 1);
/*     */         
/* 609 */         AwardModel awardModel = AwardInterface.award(getAwardId1(context), (String)context.allUsers.get(roleId), roleId.longValue(), modifyid, context.roleList, context.allRoles, false, sendDefalutMsg, new AwardReason(LogReason.GANG_ROBBER_ACTIVITY_ADD));
/*     */         
/*     */ 
/*     */ 
/* 613 */         if (!sendDefalutMsg) {
/* 614 */           sendReward(roleId.longValue(), awardModel, this.activityType);
/*     */         }
/*     */         
/* 617 */         if (count >= recommendCount - 1) {
/* 618 */           SSyncGangRobberEvent sSyncGangRobberEvent = new SSyncGangRobberEvent();
/* 619 */           sSyncGangRobberEvent.result = 3;
/* 620 */           OnlineManager.getInstance().send(roleId.longValue(), sSyncGangRobberEvent);
/*     */         }
/*     */       }
/*     */       
/* 624 */       isFightOk = true;
/*     */     }
/*     */     
/* 627 */     if (isFightOk) {
/* 628 */       addCounter(role2user, needAwardRoleList);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 634 */     return isFightOk;
/*     */   }
/*     */   
/*     */   private int getModifyAwardId(int count) {
/* 638 */     int modifyid = -1;
/* 639 */     for (SGangRobberModifyCfg gangRobberModifyCfg : SGangRobberModifyCfg.getAll().values()) {
/* 640 */       if (count <= gangRobberModifyCfg.count) break;
/* 641 */       modifyid = gangRobberModifyCfg.modifyid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 646 */     return modifyid;
/*     */   }
/*     */   
/*     */   public void sendReward(long roleId, AwardModel awardModel, int activityType) {
/* 650 */     if (awardModel == null)
/* 651 */       return;
/* 652 */     SSyncVisibleMonsterReward sSyncVisibleMonsterReward = new SSyncVisibleMonsterReward();
/* 653 */     sSyncVisibleMonsterReward.activitytype = activityType;
/* 654 */     AwardInterface.fillAwardBean(sSyncVisibleMonsterReward.awardbean, awardModel);
/* 655 */     OnlineManager.getInstance().send(roleId, sSyncVisibleMonsterReward);
/*     */   }
/*     */   
/*     */   public void addCounter(Map<Long, String> role2user, List<Long> roleList) {
/* 659 */     for (Long roleId : roleList) {
/* 660 */       String userid = (String)role2user.get(roleId);
/* 661 */       ActivityInterface.addActivityCount((String)role2user.get(roleId), roleId.longValue(), SGangRobberConst.getInstance().ACTIVITYID);
/*     */       
/* 663 */       int count = ActivityInterface.getActivityCount(userid, roleId.longValue(), SGangRobberConst.getInstance().ACTIVITYID, false);
/*     */       
/* 665 */       if (count >= SGangRobberConst.getInstance().REWARD_LIMIT) {
/* 666 */         ActivityInterface.tlogActivity(roleId.longValue(), SGangRobberConst.getInstance().ACTIVITYID, ActivityLogStatus.FINISH);
/*     */         
/* 668 */         ActivityInterface.logActivity(roleId.longValue(), SGangRobberConst.getInstance().ACTIVITYID, ActivityLogStatus.FINISH);
/*     */       }
/*     */       else {
/* 671 */         ActivityInterface.tlogActivity(roleId.longValue(), SGangRobberConst.getInstance().ACTIVITYID, ActivityLogStatus.ATTEND);
/*     */         
/* 673 */         ActivityInterface.logActivity(roleId.longValue(), SGangRobberConst.getInstance().ACTIVITYID, ActivityLogStatus.ATTEND);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public int getAwardId1(VisibleMonsterFightContext context)
/*     */   {
/* 680 */     int monsterCfgid = context.monsterCfgId;
/* 681 */     int index = SGangRobberConst.getInstance().monsterids.indexOf(Integer.valueOf(monsterCfgid));
/* 682 */     if ((index >= 0) && (index < SGangRobberConst.getInstance().awardids.size())) {
/* 683 */       return ((Integer)SGangRobberConst.getInstance().awardids.get(index)).intValue();
/*     */     }
/* 685 */     return ((Integer)SGangRobberConst.getInstance().awardids.get(0)).intValue();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\visiblemonsterfight\main\GangRobberActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */