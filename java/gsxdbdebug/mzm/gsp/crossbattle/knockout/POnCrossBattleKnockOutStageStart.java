/*     */ package mzm.gsp.crossbattle.knockout;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.activity.confbean.SActivityCfg;
/*     */ import mzm.gsp.common.TimeCommonUtil;
/*     */ import mzm.gsp.common.confbean.STimePointCommonCfg;
/*     */ import mzm.gsp.corps.main.CorpsInfo;
/*     */ import mzm.gsp.corps.main.CorpsInterface;
/*     */ import mzm.gsp.crossbattle.GetFightStageCorpsIdList;
/*     */ import mzm.gsp.crossbattle.GetFightStageCorpsIdList_Award;
/*     */ import mzm.gsp.crossbattle.GetFightStageCorpsIdList_NotifyKnockOutCorpsId;
/*     */ import mzm.gsp.crossbattle.SCrossBattleFinalNormalRes;
/*     */ import mzm.gsp.crossbattle.SCrossBattleSelectionNormalRes;
/*     */ import mzm.gsp.crossbattle.SNotifySelectionMatchBegin;
/*     */ import mzm.gsp.crossbattle.confbean.CrossBattleConsts;
/*     */ import mzm.gsp.crossbattle.confbean.KnockOutCfg;
/*     */ import mzm.gsp.crossbattle.confbean.SCrossBattleKnockOutCfg;
/*     */ import mzm.gsp.crossbattle.event.KnockOutStageFightCalArg;
/*     */ import mzm.gsp.crossbattle.main.CrossBattleOneByOneManager;
/*     */ import mzm.gsp.crossbattle.point.CrossBattlePointInterface;
/*     */ import mzm.gsp.crossserver.main.KnockOutProcessContext;
/*     */ import mzm.gsp.crossserver.main.KnockOutRoleInfo;
/*     */ import mzm.gsp.crossserver.main.KnockOutTeamInfo;
/*     */ import mzm.gsp.grc.main.GrcInterface;
/*     */ import mzm.gsp.map.main.MapInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.team.main.TeamDispositionInfo;
/*     */ import mzm.gsp.team.main.TeamDpMember;
/*     */ import mzm.gsp.team.main.TeamInterface;
/*     */ import mzm.gsp.team.main.TeamManager;
/*     */ import mzm.gsp.timer.main.MilliObserver;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import mzm.gsp.util.Pair;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.CrossBattleKnockoutActivityInfo;
/*     */ import xbean.CrossBattleKnockoutInfo;
/*     */ import xbean.FightAgainstInfo;
/*     */ import xbean.FightCorpsInfo;
/*     */ import xbean.FightStageInfo;
/*     */ import xbean.FightZoneInfo;
/*     */ import xdb.Executor;
/*     */ import xdb.Lockeys;
/*     */ import xdb.Xdb;
/*     */ import xio.Protocol;
/*     */ import xtable.Cross_battle_knockout;
/*     */ import xtable.Cross_battle_knockout_own_server;
/*     */ 
/*     */ public class POnCrossBattleKnockOutStageStart extends mzm.gsp.util.LogicRunnable
/*     */ {
/*     */   private final int activityCfgId;
/*     */   private final int knockOutType;
/*     */   
/*     */   public POnCrossBattleKnockOutStageStart(int activityCfgId, int knockOutType)
/*     */   {
/*  68 */     this.activityCfgId = activityCfgId;
/*  69 */     this.knockOutType = knockOutType;
/*     */   }
/*     */   
/*     */   public void process()
/*     */     throws Exception
/*     */   {
/*  75 */     KnockOutHandler knockOutHandler = CrossBattleKnockoutManager.getKnockOutHandler(this.knockOutType);
/*  76 */     if (knockOutHandler == null)
/*     */     {
/*  78 */       return;
/*     */     }
/*     */     
/*  81 */     SCrossBattleKnockOutCfg sCrossBattleKnockOutCfg = SCrossBattleKnockOutCfg.get(this.activityCfgId);
/*     */     
/*  83 */     long currentTimeMillis = DateTimeUtils.getCurrTimeInMillis();
/*     */     
/*     */ 
/*  86 */     KnockOutCfg knockOutCfg = (KnockOutCfg)sCrossBattleKnockOutCfg.knockOutTypeCfgMap.get(Integer.valueOf(this.knockOutType));
/*  87 */     if (knockOutCfg == null)
/*     */     {
/*     */ 
/*  90 */       return;
/*     */     }
/*  92 */     SActivityCfg activityCfg = SActivityCfg.get(this.activityCfgId);
/*  93 */     if (activityCfg == null)
/*     */     {
/*  95 */       return;
/*     */     }
/*     */     
/*  98 */     long knockOutEndTime = knockOutHandler.getKnockOutEndTime(this.activityCfgId);
/*  99 */     long awardLeftTime = knockOutEndTime - currentTimeMillis;
/* 100 */     if (awardLeftTime > 0L)
/*     */     {
/* 102 */       new AwardKnockOutObserver(awardLeftTime, this.activityCfgId, this.knockOutType);
/*     */     }
/*     */     
/* 105 */     int fightStage = 1;
/* 106 */     for (Iterator i$ = knockOutCfg.stage_time_point_cfg_id_list.iterator(); i$.hasNext();) { int timePointCfgId = ((Integer)i$.next()).intValue();
/*     */       
/* 108 */       STimePointCommonCfg sTimePointCommonCfg = STimePointCommonCfg.get(timePointCfgId);
/* 109 */       if (sTimePointCommonCfg == null)
/*     */       {
/* 111 */         GameServer.logger().info(String.format("[crossbattle_knockout]POnCrossBattleKnockOutStageStart.process@no time point cfg|activity_cfg_id=%d|time_point_cfg_id=%d", new Object[] { Integer.valueOf(sCrossBattleKnockOutCfg.activity_cfg_id), Integer.valueOf(timePointCfgId) }));
/*     */         
/*     */ 
/*     */ 
/* 115 */         return;
/*     */       }
/*     */       
/* 118 */       long prepareWroldCreateTime = TimeCommonUtil.getTimePoint(sTimePointCommonCfg) - knockOutCfg.prepare_world_countdown * 60000L;
/*     */       
/*     */ 
/* 121 */       if (currentTimeMillis <= prepareWroldCreateTime)
/*     */       {
/* 123 */         new KnockOutStartObserver(prepareWroldCreateTime - currentTimeMillis, this.activityCfgId, this.knockOutType, fightStage, knockOutCfg.prepare_map_cfg_id, prepareWroldCreateTime);
/*     */ 
/*     */       }
/* 126 */       else if (currentTimeMillis - prepareWroldCreateTime < knockOutCfg.prepare_world_countdown * 60000L)
/*     */       {
/*     */ 
/* 129 */         new KnockOutStartObserver(0L, this.activityCfgId, this.knockOutType, fightStage, knockOutCfg.prepare_map_cfg_id, prepareWroldCreateTime);
/*     */       }
/*     */       
/*     */ 
/* 133 */       fightStage++;
/*     */     }
/*     */   }
/*     */   
/*     */   static class AwardKnockOutObserver extends MilliObserver
/*     */   {
/*     */     private final int activityCfgId;
/*     */     private final int knockOutType;
/*     */     
/*     */     public AwardKnockOutObserver(long intervalMilliSeconds, int activityCfgId, int knockOutType)
/*     */     {
/* 144 */       super();
/* 145 */       this.activityCfgId = activityCfgId;
/* 146 */       this.knockOutType = knockOutType;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean update()
/*     */     {
/* 152 */       CrossBattleOneByOneManager.getInstance().addLogicProcedure(Integer.valueOf(CrossBattleConsts.getInstance().CURRENT_ACTIVITY_CFG_ID), new POnCrossBattleKnockOutStageStart.PAwardKnockOut(this.activityCfgId, this.knockOutType));
/*     */       
/*     */ 
/* 155 */       return false;
/*     */     }
/*     */   }
/*     */   
/*     */   static class PAwardKnockOut
/*     */     extends LogicProcedure
/*     */   {
/*     */     private final int activityCfgId;
/*     */     private final int knockOutType;
/*     */     
/*     */     public PAwardKnockOut(int activityCfgId, int knockOutType)
/*     */     {
/* 167 */       this.activityCfgId = activityCfgId;
/* 168 */       this.knockOutType = knockOutType;
/*     */     }
/*     */     
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/* 174 */       SCrossBattleKnockOutCfg sCrossBattleKnockOutCfg = SCrossBattleKnockOutCfg.get(this.activityCfgId);
/* 175 */       if (sCrossBattleKnockOutCfg == null)
/*     */       {
/* 177 */         return false;
/*     */       }
/*     */       
/* 180 */       KnockOutCfg knockOutCfg = (KnockOutCfg)sCrossBattleKnockOutCfg.knockOutTypeCfgMap.get(Integer.valueOf(this.knockOutType));
/* 181 */       if (knockOutCfg == null)
/*     */       {
/* 183 */         return false;
/*     */       }
/*     */       
/* 186 */       int maxFightZone = CrossBattlePointInterface.getZoneNum();
/*     */       
/* 188 */       int maxFightIndexId = CrossBattleKnockoutManager.getMaxFightIndexId(knockOutCfg.need_team_size, 1, knockOutCfg.fight_times_every_stage);
/*     */       
/*     */ 
/* 191 */       GetFightStageCorpsIdList_Award context = new GetFightStageCorpsIdList_Award();
/* 192 */       OctetsStream octetsStream = new OctetsStream();
/* 193 */       octetsStream.marshal(context);
/*     */       
/* 195 */       GetFightStageCorpsIdList getFightStageCorpsIdList = new GetFightStageCorpsIdList();
/* 196 */       getFightStageCorpsIdList.oper_type = 2;
/* 197 */       getFightStageCorpsIdList.content = octetsStream;
/*     */       
/* 199 */       boolean isSendSuccess = GrcInterface.getNotifyKnockOutCorpsIdList(this.activityCfgId, this.knockOutType, 1, maxFightIndexId, maxFightZone, GameServerInfoManager.getZoneIds(), new OctetsStream().marshal(getFightStageCorpsIdList));
/*     */       
/*     */ 
/*     */ 
/* 203 */       return isSendSuccess;
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static class KnockOutStartObserver
/*     */     extends MilliObserver
/*     */   {
/*     */     private final int activityCfgId;
/*     */     
/*     */ 
/*     */ 
/*     */     private final int knockOutType;
/*     */     
/*     */ 
/*     */ 
/*     */     private final int fightStage;
/*     */     
/*     */ 
/*     */ 
/*     */     private final int mapCfgId;
/*     */     
/*     */ 
/*     */     private final long worldBeginTime;
/*     */     
/*     */ 
/*     */ 
/*     */     public KnockOutStartObserver(long intervalMilliSeconds, int activityCfgId, int knockOutType, int knockOutStage, int mapCfgId, long worldBeginTime)
/*     */     {
/* 234 */       super();
/* 235 */       this.activityCfgId = activityCfgId;
/* 236 */       this.knockOutType = knockOutType;
/* 237 */       this.fightStage = knockOutStage;
/* 238 */       this.mapCfgId = mapCfgId;
/* 239 */       this.worldBeginTime = worldBeginTime;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean update()
/*     */     {
/* 245 */       CrossBattleOneByOneManager.getInstance().addLogicProcedure(Integer.valueOf(CrossBattleConsts.getInstance().CURRENT_ACTIVITY_CFG_ID), new POnCrossBattleKnockOutStageStart.POnKnockOutStart(this.activityCfgId, this.knockOutType, this.fightStage, this.mapCfgId, this.worldBeginTime));
/*     */       
/*     */ 
/*     */ 
/* 249 */       return false;
/*     */     }
/*     */   }
/*     */   
/*     */   private static class POnKnockOutStart
/*     */     extends LogicProcedure
/*     */   {
/*     */     private final int activityCfgId;
/*     */     private final int knockOutType;
/*     */     private final int fightStage;
/*     */     private final int mapCfgId;
/*     */     private final long worldBeginTime;
/*     */     
/*     */     public POnKnockOutStart(int activityCfgId, int knockOutType, int fightStage, int mapCfgId, long worldBeginTime)
/*     */     {
/* 264 */       this.activityCfgId = activityCfgId;
/* 265 */       this.knockOutType = knockOutType;
/* 266 */       this.fightStage = fightStage;
/* 267 */       this.mapCfgId = mapCfgId;
/* 268 */       this.worldBeginTime = worldBeginTime;
/*     */     }
/*     */     
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/* 274 */       Long selectionPrepareWorldId = CrossBattleKnockOutPrepareWorldManager.getInstance().getPrepareWorldId();
/* 275 */       if (selectionPrepareWorldId != null)
/*     */       {
/* 277 */         Map<String, Object> extraMap = new HashMap();
/* 278 */         extraMap.put("prepare_world_id", selectionPrepareWorldId);
/* 279 */         onKnockOutStartFail(-1, extraMap);
/* 280 */         return false;
/*     */       }
/*     */       
/* 283 */       int nowActivityCfgId = CrossBattleConsts.getInstance().CURRENT_ACTIVITY_CFG_ID;
/* 284 */       SCrossBattleKnockOutCfg sCrossBattleKnockOutCfg = SCrossBattleKnockOutCfg.get(nowActivityCfgId);
/* 285 */       if (sCrossBattleKnockOutCfg == null)
/*     */       {
/* 287 */         Map<String, Object> extraMap = new HashMap();
/* 288 */         extraMap.put("activity_cfg_id", Integer.valueOf(nowActivityCfgId));
/* 289 */         onKnockOutStartFail(-2, extraMap);
/*     */         
/* 291 */         return false;
/*     */       }
/*     */       
/* 294 */       KnockOutCfg knockOutCfg = (KnockOutCfg)sCrossBattleKnockOutCfg.knockOutTypeCfgMap.get(Integer.valueOf(this.knockOutType));
/* 295 */       if (knockOutCfg == null)
/*     */       {
/* 297 */         return false;
/*     */       }
/*     */       
/* 300 */       int maxFightZone = CrossBattleKnockoutManager.getMaxFightZone(nowActivityCfgId, this.knockOutType);
/* 301 */       if (maxFightZone < 0)
/*     */       {
/* 303 */         return false;
/*     */       }
/*     */       
/* 306 */       int maxFightIndexId = CrossBattleKnockoutManager.getMaxFightIndexId(knockOutCfg.need_team_size, this.fightStage, knockOutCfg.fight_times_every_stage);
/*     */       
/* 308 */       if (maxFightIndexId < 0)
/*     */       {
/* 310 */         return false;
/*     */       }
/*     */       
/* 313 */       long calLeftTime = (knockOutCfg.fight_last_time + 10 + knockOutCfg.prepare_world_countdown) * 60000L;
/*     */       
/*     */ 
/* 316 */       new POnCrossBattleKnockOutStageStart.KnockOutStageFightCalObserver(calLeftTime, this.activityCfgId, this.knockOutType, this.fightStage);
/*     */       
/* 318 */       long worldId = MapInterface.createWorld(Arrays.asList(new Integer[] { Integer.valueOf(knockOutCfg.prepare_map_cfg_id) }));
/*     */       
/*     */ 
/* 321 */       CrossBattleKnockOutMapTeamHandler teamHandler = new CrossBattleKnockOutMapTeamHandler();
/* 322 */       TeamInterface.registerJoinTeam(worldId, teamHandler);
/*     */       
/* 324 */       long endTime = this.worldBeginTime + knockOutCfg.prepare_world_countdown * 60000L;
/* 325 */       CrossBattleKnockOutPrepareWorldManager.getInstance().setPrepareWorldId(worldId, endTime, this.knockOutType, false);
/*     */       
/*     */ 
/* 328 */       new POnCrossBattleKnockOutStageStart.KnockOutMatchMillObserver(endTime - DateTimeUtils.getCurrTimeInMillis() + 2000L, this.knockOutType, this.fightStage);
/*     */       
/*     */ 
/* 331 */       GetFightStageCorpsIdList_NotifyKnockOutCorpsId context = new GetFightStageCorpsIdList_NotifyKnockOutCorpsId();
/* 332 */       OctetsStream octetsStream = new OctetsStream();
/* 333 */       octetsStream.marshal(context);
/*     */       
/* 335 */       GetFightStageCorpsIdList getFightStageCorpsIdList = new GetFightStageCorpsIdList();
/* 336 */       getFightStageCorpsIdList.oper_type = 1;
/* 337 */       getFightStageCorpsIdList.content = octetsStream;
/*     */       
/* 339 */       boolean isSendSuccess = GrcInterface.getNotifyKnockOutCorpsIdList(nowActivityCfgId, this.knockOutType, this.fightStage, maxFightIndexId, maxFightZone, GameServerInfoManager.getZoneIds(), new OctetsStream().marshal(getFightStageCorpsIdList));
/*     */       
/*     */ 
/* 342 */       if (!isSendSuccess)
/*     */       {
/* 344 */         Xdb.executor().schedule(new POnCrossBattleKnockOutStageStart.RRepeatGetNotifyKnockOutCorpsIdList(nowActivityCfgId, this.knockOutType, this.fightStage, maxFightIndexId, maxFightZone, 1, getFightStageCorpsIdList), 60000L, TimeUnit.MILLISECONDS);
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 350 */       StringBuilder sBuilder = new StringBuilder();
/* 351 */       sBuilder.append("|activity_cfg_id=").append(this.activityCfgId);
/* 352 */       sBuilder.append("|knock_out_type=").append(this.knockOutType);
/* 353 */       sBuilder.append("|fight_stage=").append(this.fightStage);
/* 354 */       sBuilder.append("|map_cfg_id=").append(this.mapCfgId);
/* 355 */       sBuilder.append("|world_begin_time=").append(this.worldBeginTime);
/* 356 */       sBuilder.append("|is_send_success=").append(isSendSuccess);
/*     */       
/* 358 */       GameServer.logger().info(Boolean.valueOf(isSendSuccess));
/*     */       
/* 360 */       return true;
/*     */     }
/*     */     
/*     */     private void onKnockOutStartFail(int ret, Map<String, Object> extraMap)
/*     */     {
/* 365 */       StringBuilder sb = new StringBuilder();
/* 366 */       sb.append("[crossbattle_knockout]POnKnockOutStart.processImp@error");
/* 367 */       sb.append("|ret=").append(ret);
/* 368 */       sb.append("|activity_cfg_id=").append(this.activityCfgId);
/* 369 */       sb.append("|knock_out_type=").append(this.knockOutType);
/* 370 */       sb.append("|fight_stage=").append(this.fightStage);
/* 371 */       sb.append("|map_cfg_id=").append(this.mapCfgId);
/* 372 */       sb.append("|world_begin_time=").append(this.worldBeginTime);
/*     */       
/* 374 */       if ((extraMap != null) && (!extraMap.isEmpty()))
/*     */       {
/* 376 */         for (Map.Entry<String, Object> entry : extraMap.entrySet())
/*     */         {
/* 378 */           sb.append("|").append((String)entry.getKey()).append("=").append(entry.getValue());
/*     */         }
/*     */       }
/* 381 */       GameServer.logger().error(sb.toString());
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   private static class RRepeatGetNotifyKnockOutCorpsIdList
/*     */     implements Runnable
/*     */   {
/*     */     private final int activityCfgId;
/*     */     
/*     */     private final int knockOutType;
/*     */     
/*     */     private final int fightStage;
/*     */     
/*     */     private final int maxFightIndexId;
/*     */     
/*     */     private final int maxFightZone;
/*     */     
/*     */     private int repeatTimes;
/*     */     
/*     */     private GetFightStageCorpsIdList getFightStageCorpsIdList;
/*     */     
/*     */     public RRepeatGetNotifyKnockOutCorpsIdList(int activityCfgId, int knockOutType, int fightStage, int maxFightIndexId, int maxFightZone, int repeatTimes, GetFightStageCorpsIdList getFightStageCorpsIdList)
/*     */     {
/* 405 */       this.activityCfgId = activityCfgId;
/* 406 */       this.knockOutType = knockOutType;
/* 407 */       this.fightStage = fightStage;
/* 408 */       this.maxFightIndexId = maxFightIndexId;
/* 409 */       this.maxFightZone = maxFightZone;
/* 410 */       this.repeatTimes = repeatTimes;
/* 411 */       this.getFightStageCorpsIdList = getFightStageCorpsIdList;
/*     */     }
/*     */     
/*     */ 
/*     */     public void run()
/*     */     {
/* 417 */       StringBuilder contextBuilder = new StringBuilder();
/* 418 */       contextBuilder.append("|activity_cfg_id=").append(this.activityCfgId);
/* 419 */       contextBuilder.append("|knock_out_type=").append(this.knockOutType);
/* 420 */       contextBuilder.append("|fight_stage=").append(this.fightStage);
/* 421 */       contextBuilder.append("|repeat_times=").append(this.repeatTimes);
/*     */       
/* 423 */       boolean isSendSuccess = GrcInterface.getNotifyKnockOutCorpsIdList(this.activityCfgId, this.knockOutType, this.fightStage, this.maxFightIndexId, this.maxFightZone, GameServerInfoManager.getZoneIds(), new OctetsStream().marshal(this.getFightStageCorpsIdList));
/*     */       
/*     */ 
/* 426 */       if ((!isSendSuccess) && (this.repeatTimes < 10))
/*     */       {
/* 428 */         this.repeatTimes += 1;
/* 429 */         Xdb.executor().schedule(this, 60000L, TimeUnit.MILLISECONDS);
/*     */         
/* 431 */         StringBuilder sBuilder = new StringBuilder();
/* 432 */         sBuilder.append("[crossbattle_knockout]RRepeatGetNotifyKnockOutCorpsIdList.send fail");
/* 433 */         sBuilder.append(contextBuilder.toString());
/*     */         
/* 435 */         GameServer.logger().info(sBuilder.toString());
/*     */       }
/*     */       
/* 438 */       StringBuilder sBuilder = new StringBuilder();
/* 439 */       sBuilder.append("[crossbattle_knockout]RRepeatGetNotifyKnockOutCorpsIdList.send ");
/* 440 */       sBuilder.append(contextBuilder.toString());
/* 441 */       sBuilder.append("|is_send_success=").append(isSendSuccess);
/* 442 */       sBuilder.append("repeat_times=").append(this.repeatTimes);
/*     */       
/* 444 */       GameServer.logger().info(sBuilder.toString());
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   private static class KnockOutStageFightCalObserver
/*     */     extends MilliObserver
/*     */   {
/*     */     private final int activityCfgId;
/*     */     private final int knockOutType;
/*     */     private final int fightStage;
/*     */     
/*     */     public KnockOutStageFightCalObserver(long intervalMilliSeconds, int activityCfgId, int knockOutType, int fightStage)
/*     */     {
/* 458 */       super();
/* 459 */       this.activityCfgId = activityCfgId;
/* 460 */       this.knockOutType = knockOutType;
/* 461 */       this.fightStage = fightStage;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean update()
/*     */     {
/* 467 */       CrossBattleOneByOneManager.getInstance().addLogicProcedure(Integer.valueOf(CrossBattleConsts.getInstance().CURRENT_ACTIVITY_CFG_ID), new POnCrossBattleKnockOutStageStart.PKnockOutStageFightCal(this.activityCfgId, this.knockOutType, this.fightStage));
/*     */       
/*     */ 
/* 470 */       return false;
/*     */     }
/*     */   }
/*     */   
/*     */   private static class PKnockOutStageFightCal
/*     */     extends LogicProcedure
/*     */   {
/*     */     private final int activityCfgId;
/*     */     private final int knockOutType;
/*     */     private final int fightStage;
/*     */     
/*     */     public PKnockOutStageFightCal(int activityCfgId, int knockOutType, int fightStage)
/*     */     {
/* 483 */       this.activityCfgId = activityCfgId;
/* 484 */       this.knockOutType = knockOutType;
/* 485 */       this.fightStage = fightStage;
/*     */     }
/*     */     
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/* 491 */       if (!CrossBattleKnockoutManager.isCrossBattleKnockOutSwitchOpen(this.activityCfgId, this.knockOutType))
/*     */       {
/* 493 */         StringBuilder stringBuilder = new StringBuilder();
/* 494 */         stringBuilder.append("[crossbattle_knockout]POnCrossBattleKnockOutStageStart.PKnockOutStageFightCal.processImp@idip switch not open");
/* 495 */         stringBuilder.append("|activity_cfg_id=").append(this.activityCfgId);
/* 496 */         stringBuilder.append("|knock_out_type=").append(this.knockOutType);
/* 497 */         stringBuilder.append("|fight_stage=").append(this.fightStage);
/*     */         
/* 499 */         GameServer.logger().error(stringBuilder.toString());
/* 500 */         return false;
/*     */       }
/*     */       
/*     */ 
/* 504 */       long globalActivityCfgId = GameServerInfoManager.toGlobalId(this.activityCfgId);
/* 505 */       Cross_battle_knockout.remove(Long.valueOf(globalActivityCfgId));
/* 506 */       Cross_battle_knockout_own_server.remove(Long.valueOf(globalActivityCfgId));
/*     */       
/*     */ 
/* 509 */       KnockOutStageFightCalArg knockOutStageFightCalArg = new KnockOutStageFightCalArg(this.activityCfgId, this.knockOutType, this.fightStage);
/*     */       
/*     */ 
/* 512 */       TriggerEventsManger.getInstance().triggerEvent(new mzm.gsp.crossbattle.event.KnockOutStageFightCal(), knockOutStageFightCalArg, CrossBattleOneByOneManager.getInstance().getTaskOneByOne(Integer.valueOf(this.activityCfgId)));
/*     */       
/*     */ 
/* 515 */       StringBuilder stringBuilder = new StringBuilder();
/* 516 */       stringBuilder.append("[crossbattle_knockout]POnCrossBattleKnockOutStageStart.PKnockOutStageFightCal.processImp@trigger stage fight cal");
/* 517 */       stringBuilder.append("|activity_cfg_id=").append(this.activityCfgId);
/* 518 */       stringBuilder.append("|knock_out_type=").append(this.knockOutType);
/* 519 */       stringBuilder.append("|fight_stage=").append(this.fightStage);
/*     */       
/* 521 */       GameServer.logger().info(stringBuilder.toString());
/* 522 */       return true;
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static class KnockOutMatchMillObserver
/*     */     extends MilliObserver
/*     */   {
/*     */     private final int fightStage;
/*     */     
/*     */     private final int knockOutType;
/*     */     
/*     */ 
/*     */     public KnockOutMatchMillObserver(long intervalMilliSeconds, int knockOutType, int fightStage)
/*     */     {
/* 538 */       super();
/* 539 */       this.knockOutType = knockOutType;
/* 540 */       this.fightStage = fightStage;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean update()
/*     */     {
/* 546 */       new POnCrossBattleKnockOutStageStart.PKnockOutMatch(this.fightStage, this.knockOutType).execute();
/*     */       
/* 548 */       StringBuilder sb = new StringBuilder();
/* 549 */       sb.append("[crossbattle_knockout]KnockOutMatchMillObserver.update@observer execute");
/* 550 */       sb.append("|activity_cfg_id=").append(CrossBattleConsts.getInstance().CURRENT_ACTIVITY_CFG_ID);
/* 551 */       sb.append("|fight_stage=").append(this.fightStage);
/* 552 */       sb.append("|knock_out_type=").append(this.knockOutType);
/*     */       
/* 554 */       GameServer.logger().info(sb.toString());
/* 555 */       return false;
/*     */     }
/*     */   }
/*     */   
/*     */   private static class PKnockOutMatch
/*     */     extends LogicProcedure
/*     */   {
/*     */     private final int knockOutStage;
/*     */     private final int knockOutType;
/*     */     
/*     */     public PKnockOutMatch(int knockOutStage, int knockOutType)
/*     */     {
/* 567 */       this.knockOutStage = knockOutStage;
/* 568 */       this.knockOutType = knockOutType;
/*     */     }
/*     */     
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/* 574 */       Long worldId = CrossBattleKnockOutPrepareWorldManager.getInstance().getPrepareWorldId();
/* 575 */       if (worldId == null)
/*     */       {
/* 577 */         return false;
/*     */       }
/*     */       
/* 580 */       List<Long> teamIdList = MapInterface.getAllTeamInWorld(worldId.longValue());
/*     */       
/* 582 */       Lockeys.lock(xtable.Team.getTable(), teamIdList);
/*     */       
/* 584 */       for (Iterator i$ = teamIdList.iterator(); i$.hasNext();) { long teamId = ((Long)i$.next()).longValue();
/*     */         
/* 586 */         new POnCrossBattleKnockOutStageStart.PKnockOutTeamMatch(teamId, this.knockOutStage, this.knockOutType).execute();
/*     */       }
/*     */       
/* 589 */       StringBuilder sb = new StringBuilder();
/* 590 */       sb.append("[crossbattle_knockout]PKnockOutMatch.update@observer execute");
/* 591 */       sb.append("|activity_cfg_id=").append(CrossBattleConsts.getInstance().CURRENT_ACTIVITY_CFG_ID);
/* 592 */       sb.append("|knock_out_stage=").append(this.knockOutStage);
/* 593 */       sb.append("|knock_out_type=").append(this.knockOutType);
/* 594 */       sb.append("|team_id_list=").append(teamIdList.toString());
/*     */       
/* 596 */       GameServer.logger().info(sb.toString());
/* 597 */       return true;
/*     */     }
/*     */   }
/*     */   
/*     */   private static class PKnockOutTeamMatch extends LogicProcedure
/*     */   {
/*     */     private final long teamId;
/*     */     private final int fightStage;
/*     */     private final int knockOutType;
/*     */     
/*     */     public PKnockOutTeamMatch(long teamId, int selectionStage, int knockOutType)
/*     */     {
/* 609 */       this.teamId = teamId;
/* 610 */       this.fightStage = selectionStage;
/* 611 */       this.knockOutType = knockOutType;
/*     */     }
/*     */     
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/* 617 */       StringBuilder logBuilder = new StringBuilder();
/* 618 */       logBuilder.append("[crossbattle_knockout]PKnockOutTeamMatch.processImp@team in world,begin match");
/* 619 */       logBuilder.append("|team_id=").append(this.teamId);
/* 620 */       logBuilder.append("|fight_stage=").append(this.fightStage);
/* 621 */       logBuilder.append("|knock_out_type=").append(this.knockOutType);
/* 622 */       GameServer.logger().info(logBuilder.toString());
/*     */       
/* 624 */       SCrossBattleKnockOutCfg sCrossBattleKnockOutCfg = SCrossBattleKnockOutCfg.get(CrossBattleConsts.getInstance().CURRENT_ACTIVITY_CFG_ID);
/* 625 */       if (sCrossBattleKnockOutCfg == null)
/*     */       {
/* 627 */         logBuilder.append("|error=cross battle knock out cfg null");
/* 628 */         logBuilder.append("|current_activity_cfg_id=").append(CrossBattleConsts.getInstance().CURRENT_ACTIVITY_CFG_ID);
/* 629 */         GameServer.logger().error(logBuilder.toString());
/* 630 */         return false;
/*     */       }
/*     */       
/* 633 */       KnockOutCfg knockOutCfg = (KnockOutCfg)sCrossBattleKnockOutCfg.knockOutTypeCfgMap.get(Integer.valueOf(this.knockOutType));
/* 634 */       if (knockOutCfg == null)
/*     */       {
/* 636 */         logBuilder.append("|error=knock out cfg null");
/* 637 */         GameServer.logger().error(logBuilder.toString());
/* 638 */         return false;
/*     */       }
/*     */       
/* 641 */       TeamDispositionInfo teamDispositionInfo = TeamManager.getTeamDispInfo(this.teamId);
/* 642 */       if (teamDispositionInfo == null)
/*     */       {
/* 644 */         logBuilder.append("|error=team disposition info null");
/* 645 */         GameServer.logger().error(logBuilder.toString());
/* 646 */         return false;
/*     */       }
/*     */       
/* 649 */       List<TeamDpMember> teamDpMembers = teamDispositionInfo.getDisposition();
/* 650 */       List<Long> teamRoleIdList = new ArrayList();
/* 651 */       for (TeamDpMember teamDpMember : teamDpMembers)
/*     */       {
/* 653 */         teamRoleIdList.add(Long.valueOf(teamDpMember.teamdispositionmember_id));
/*     */       }
/*     */       
/* 656 */       if (teamRoleIdList.isEmpty())
/*     */       {
/* 658 */         logBuilder.append("|error=team role id list empty");
/*     */         
/* 660 */         GameServer.logger().error(logBuilder.toString());
/* 661 */         return false;
/*     */       }
/*     */       
/* 664 */       if (teamRoleIdList.size() < knockOutCfg.need_team_member_num)
/*     */       {
/* 666 */         logBuilder.append("|team_role_id_list=").append(teamRoleIdList);
/* 667 */         logBuilder.append("|need_team_member_num=").append(knockOutCfg.need_team_member_num);
/* 668 */         logBuilder.append("|error=team role id list size not enough");
/* 669 */         GameServer.logger().error(logBuilder.toString());
/*     */         
/* 671 */         Protocol xProtocol = getNormalResProtocol(35);
/*     */         
/* 673 */         OnlineManager.getInstance().sendMultiAtOnce(xProtocol, teamRoleIdList);
/*     */         
/* 675 */         List<Long> teamMemberRoleIdList = TeamInterface.getTeamMemberList(this.teamId, false);
/*     */         
/* 677 */         MapInterface.transferAllRole(teamMemberRoleIdList, MapInterface.getBigWorldid(), knockOutCfg.out_map_cfg_id, knockOutCfg.out_map_transfer_x, knockOutCfg.out_map_transfer_y);
/*     */         
/* 679 */         for (Iterator i$ = teamMemberRoleIdList.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*     */           
/* 681 */           new CrossBattleKnockOutPrepareWorldManager.PUnSetKnockOutWorldStatus(roleId).execute();
/*     */         }
/* 683 */         return false;
/*     */       }
/*     */       
/* 686 */       lock(xtable.Role2properties.getTable(), teamRoleIdList);
/* 687 */       long leaderRoleId = ((Long)teamRoleIdList.get(0)).longValue();
/* 688 */       long ownCorpsId = CorpsInterface.getRoleCorpsId(leaderRoleId, true);
/*     */       
/* 690 */       logBuilder.append("|own_corps_id=").append(ownCorpsId);
/*     */       
/* 692 */       if (ownCorpsId == -1L)
/*     */       {
/* 694 */         logBuilder.append("|error=no corps id");
/* 695 */         GameServer.logger().error(logBuilder.toString());
/* 696 */         return false;
/*     */       }
/*     */       
/* 699 */       CorpsInfo corpsInfo = CorpsInterface.getCorpsInfoByCorpsId(ownCorpsId, true);
/* 700 */       if (corpsInfo == null)
/*     */       {
/* 702 */         logBuilder.append("|error=corps info null");
/*     */         
/* 704 */         GameServer.logger().error(logBuilder.toString());
/* 705 */         return false;
/*     */       }
/*     */       
/* 708 */       int nowActivityCfgId = CrossBattleConsts.getInstance().CURRENT_ACTIVITY_CFG_ID;
/*     */       
/* 710 */       long globalActivityCfgid = GameServerInfoManager.toGlobalId(nowActivityCfgId);
/* 711 */       CrossBattleKnockoutActivityInfo xCrossBattleKnockoutActivityInfo = Cross_battle_knockout.get(Long.valueOf(globalActivityCfgid));
/* 712 */       if (xCrossBattleKnockoutActivityInfo == null)
/*     */       {
/* 714 */         logBuilder.append("|error=no crossbattle activity db data");
/* 715 */         logBuilder.append("|activity_cfg_id=").append(nowActivityCfgId);
/* 716 */         logBuilder.append("|global_activity_cfg_id=").append(globalActivityCfgid);
/*     */         
/* 718 */         GameServer.logger().error(logBuilder.toString());
/* 719 */         return false;
/*     */       }
/*     */       
/* 722 */       CrossBattleKnockoutInfo xCrossBattleKnockoutInfo = (CrossBattleKnockoutInfo)xCrossBattleKnockoutActivityInfo.getKnockout_info_map().get(Integer.valueOf(this.knockOutType));
/*     */       
/* 724 */       if (xCrossBattleKnockoutInfo == null)
/*     */       {
/* 726 */         logBuilder.append("|error=no crossbattle knock out type db data");
/*     */         
/* 728 */         GameServer.logger().error(logBuilder.toString());
/* 729 */         return false;
/*     */       }
/*     */       
/* 732 */       int corpsFightZoneId = CrossBattleKnockoutManager.getFightZone(corpsInfo.getCorpsId(), nowActivityCfgId, this.knockOutType);
/*     */       
/* 734 */       logBuilder.append("|fight_zone_id=").append(corpsFightZoneId);
/*     */       
/* 736 */       if (corpsFightZoneId < 0)
/*     */       {
/* 738 */         logBuilder.append("|error=no crossbattle fight zone");
/*     */         
/* 740 */         GameServer.logger().error(logBuilder.toString());
/* 741 */         return false;
/*     */       }
/*     */       
/* 744 */       FightZoneInfo xFightZoneInfo = (FightZoneInfo)xCrossBattleKnockoutInfo.getFight_zone_info_map().get(Integer.valueOf(corpsFightZoneId));
/* 745 */       if (xFightZoneInfo == null)
/*     */       {
/* 747 */         logBuilder.append("|error=no crossbattle fight zone db data");
/*     */         
/* 749 */         GameServer.logger().error(logBuilder.toString());
/* 750 */         return false;
/*     */       }
/*     */       
/* 753 */       Pair<Integer, Boolean> nowStagePair = CrossBattleKnockoutInterface.getNowFightStage(this.knockOutType);
/* 754 */       if (nowStagePair == null)
/*     */       {
/* 756 */         logBuilder.append("|error=now stage pair null");
/*     */         
/* 758 */         GameServer.logger().error(logBuilder.toString());
/* 759 */         return false;
/*     */       }
/*     */       
/* 762 */       logBuilder.append("|now_fight_stage=").append(nowStagePair.first);
/* 763 */       logBuilder.append("|is_need_refresh=").append(nowStagePair.second);
/* 764 */       if (((Integer)nowStagePair.first).intValue() != this.fightStage)
/*     */       {
/* 766 */         logBuilder.append("|error=now stage pair not match");
/*     */         
/* 768 */         GameServer.logger().error(logBuilder.toString());
/* 769 */         return false;
/*     */       }
/*     */       
/* 772 */       FightStageInfo xFightStageInfo = (FightStageInfo)xFightZoneInfo.getFight_stage_info_map().get(Integer.valueOf(this.fightStage));
/* 773 */       if (xFightStageInfo == null)
/*     */       {
/* 775 */         logBuilder.append("|error= no fight stage data");
/*     */         
/* 777 */         GameServer.logger().error(logBuilder.toString());
/* 778 */         return false;
/*     */       }
/*     */       
/* 781 */       long opponentCorpsId = -1L;
/* 782 */       int fightIndexId = -1;
/* 783 */       FightAgainstInfo xFightAgainstInfo = null;
/* 784 */       for (Map.Entry<Integer, FightAgainstInfo> xFightEntryInfo : xFightStageInfo.getFight_against_info_map().entrySet())
/*     */       {
/* 786 */         xFightAgainstInfo = (FightAgainstInfo)xFightEntryInfo.getValue();
/* 787 */         if (xFightAgainstInfo.getA_corps_id() == ownCorpsId)
/*     */         {
/* 789 */           opponentCorpsId = xFightAgainstInfo.getB_corps_id();
/* 790 */           fightIndexId = ((Integer)xFightEntryInfo.getKey()).intValue();
/* 791 */           break;
/*     */         }
/*     */         
/* 794 */         if (xFightAgainstInfo.getB_corps_id() == ownCorpsId)
/*     */         {
/* 796 */           opponentCorpsId = xFightAgainstInfo.getA_corps_id();
/* 797 */           fightIndexId = ((Integer)xFightEntryInfo.getKey()).intValue();
/* 798 */           break;
/*     */         }
/*     */       }
/*     */       
/* 802 */       logBuilder.append("|opponent_corps_id=").append(opponentCorpsId);
/* 803 */       logBuilder.append("|cal_fight_result=").append(xFightAgainstInfo.getCal_fight_result());
/* 804 */       logBuilder.append("|fight_index_id=").append(fightIndexId);
/*     */       
/* 806 */       if ((opponentCorpsId == Integer.valueOf("-1").intValue()) || (fightIndexId == Integer.valueOf("-1").intValue()) || (xFightAgainstInfo.getCal_fight_result() != 0))
/*     */       {
/*     */ 
/*     */ 
/* 810 */         logBuilder.append("|error=aleardy has fight result");
/*     */         
/* 812 */         GameServer.logger().info(logBuilder.toString());
/* 813 */         return false;
/*     */       }
/*     */       
/* 816 */       if ((this.fightStage > 1) && ((this.fightStage - 1) % knockOutCfg.fight_times_every_stage != 0))
/*     */       {
/* 818 */         long corpsIdA = xFightAgainstInfo.getA_corps_id();
/* 819 */         long corpsIdB = xFightAgainstInfo.getB_corps_id();
/*     */         
/* 821 */         Pair<Long, Pair<Integer, Integer>> winCorpsIdPair = CrossBattleKnockoutManager.getWinCorpsId(xFightZoneInfo.getFight_stage_info_map(), corpsIdA, corpsIdB, this.fightStage - 1, fightIndexId, knockOutCfg.fight_times_every_stage);
/*     */         
/*     */ 
/* 824 */         if (((Long)winCorpsIdPair.first).longValue() != -1L)
/*     */         {
/* 826 */           return false;
/*     */         }
/*     */       }
/*     */       
/*     */ 
/* 831 */       String opponentCorpsName = "";
/* 832 */       FightCorpsInfo xOpponentCorpsInfo = (FightCorpsInfo)xFightZoneInfo.getFight_corps_info_map().get(Long.valueOf(opponentCorpsId));
/* 833 */       if (xOpponentCorpsInfo != null)
/*     */       {
/* 835 */         opponentCorpsName = xOpponentCorpsInfo.getCorps_name();
/*     */       }
/*     */       
/* 838 */       String ownCorpsName = "";
/* 839 */       FightCorpsInfo xOwnCorpsInfo = (FightCorpsInfo)xFightZoneInfo.getFight_corps_info_map().get(Long.valueOf(ownCorpsId));
/* 840 */       if (xOpponentCorpsInfo != null)
/*     */       {
/* 842 */         ownCorpsName = xOwnCorpsInfo.getCorps_name();
/*     */       }
/*     */       
/* 845 */       KnockOutTeamInfo knockOutTeamInfo = new KnockOutTeamInfo(ownCorpsId, ownCorpsName, corpsInfo.getCorpsBadgeId(), GameServerInfoManager.getZoneId(), opponentCorpsId, opponentCorpsName);
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 850 */       for (Iterator i$ = teamRoleIdList.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*     */         
/* 852 */         String userId = RoleInterface.getUserId(roleId);
/* 853 */         String roleName = RoleInterface.getName(roleId);
/* 854 */         int roleLevel = RoleInterface.getLevel(roleId);
/* 855 */         int gender = RoleInterface.getGender(roleId);
/* 856 */         int occupation = RoleInterface.getOccupationId(roleId);
/* 857 */         int avatarId = mzm.gsp.avatar.main.AvatarInterface.getCurrentAvatar(roleId, true);
/*     */         
/* 859 */         KnockOutRoleInfo knockOutRoleInfo = new KnockOutRoleInfo(userId, roleId, roleName, roleLevel, gender, occupation, avatarId);
/*     */         
/*     */ 
/* 862 */         knockOutTeamInfo.getCrossBattleRoleInfoList().add(knockOutRoleInfo);
/*     */       }
/* 864 */       KnockOutProcessContext processContext = new KnockOutProcessContext();
/*     */       
/* 866 */       boolean ret = mzm.gsp.status.main.RoleStatusInterface.setStatus(teamRoleIdList, 1371, true);
/* 867 */       if (!ret)
/*     */       {
/* 869 */         logBuilder.append("error=set selection final match fail");
/*     */         
/* 871 */         GameServer.logger().info(logBuilder.toString());
/* 872 */         return false;
/*     */       }
/*     */       
/* 875 */       long matchId = mzm.gsp.crossserver.main.CrossServerInterface.joinSelectionOrFianl(this.knockOutType, this.fightStage, leaderRoleId, fightIndexId, knockOutTeamInfo, processContext);
/*     */       
/* 877 */       if (matchId < 0L)
/*     */       {
/* 879 */         SCrossBattleSelectionNormalRes sCrossBattleSelectionNormalRes = new SCrossBattleSelectionNormalRes();
/* 880 */         sCrossBattleSelectionNormalRes.ret = 3;
/*     */         
/* 882 */         logBuilder.append("|error=start join match fail");
/* 883 */         logBuilder.append("|own_corps_id=").append(ownCorpsId);
/* 884 */         logBuilder.append("|activity_cfg_id=").append(nowActivityCfgId);
/* 885 */         logBuilder.append("|global_activity_cfg_id=").append(globalActivityCfgid);
/* 886 */         logBuilder.append("|fight_zone_id=").append(corpsFightZoneId);
/* 887 */         logBuilder.append("|now_fight_stage=").append(nowStagePair.first);
/* 888 */         logBuilder.append("|is_need_refresh=").append(nowStagePair.second);
/* 889 */         logBuilder.append("|opponent_corps_id=").append(opponentCorpsId);
/* 890 */         logBuilder.append("|cal_fight_result=").append(xFightAgainstInfo.getCal_fight_result());
/* 891 */         logBuilder.append("|fight_index_id=").append(fightIndexId);
/* 892 */         logBuilder.append("|team_role_id_list=").append(teamRoleIdList);
/*     */         
/* 894 */         GameServer.logger().error(logBuilder.toString());
/*     */         
/* 896 */         return false;
/*     */       }
/* 898 */       for (Iterator i$ = teamRoleIdList.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*     */         
/* 900 */         xtable.Role2selectionfinalcontextid.insert(Long.valueOf(roleid), Long.valueOf(matchId));
/*     */       }
/* 902 */       SNotifySelectionMatchBegin sNotifySelectionMatchBegin = new SNotifySelectionMatchBegin();
/* 903 */       OnlineManager.getInstance().sendMulti(sNotifySelectionMatchBegin, teamRoleIdList);
/*     */       
/* 905 */       logBuilder.append("|error=start join match succeed");
/* 906 */       logBuilder.append("|own_corps_id=").append(ownCorpsId);
/* 907 */       logBuilder.append("|activity_cfg_id=").append(nowActivityCfgId);
/* 908 */       logBuilder.append("|global_activity_cfg_id=").append(globalActivityCfgid);
/* 909 */       logBuilder.append("|fight_zone_id=").append(corpsFightZoneId);
/* 910 */       logBuilder.append("|now_fight_stage=").append(nowStagePair.first);
/* 911 */       logBuilder.append("|is_need_refresh=").append(nowStagePair.second);
/* 912 */       logBuilder.append("|opponent_corps_id=").append(opponentCorpsId);
/* 913 */       logBuilder.append("|cal_fight_result=").append(xFightAgainstInfo.getCal_fight_result());
/* 914 */       logBuilder.append("|fight_index_id=").append(fightIndexId);
/* 915 */       logBuilder.append("|team_role_id_list=").append(teamRoleIdList);
/*     */       
/* 917 */       GameServer.logger().info(logBuilder.toString());
/*     */       
/* 919 */       return true;
/*     */     }
/*     */     
/*     */     private Protocol getNormalResProtocol(int ret)
/*     */     {
/* 924 */       switch (this.knockOutType)
/*     */       {
/*     */       case 1: 
/* 927 */         SCrossBattleSelectionNormalRes sCrossBattleSelectionNormalRes = new SCrossBattleSelectionNormalRes();
/* 928 */         sCrossBattleSelectionNormalRes.ret = ret;
/* 929 */         return sCrossBattleSelectionNormalRes;
/*     */       
/*     */       case 2: 
/* 932 */         SCrossBattleFinalNormalRes sCrossBattleFinalNormalRes = new SCrossBattleFinalNormalRes();
/* 933 */         sCrossBattleFinalNormalRes.ret = ret;
/* 934 */         return sCrossBattleFinalNormalRes;
/*     */       }
/* 936 */       return null;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\knockout\POnCrossBattleKnockOutStageStart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */