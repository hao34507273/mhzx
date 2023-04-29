/*     */ package mzm.gsp.crossbattle.knockout;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.TreeMap;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.crossbattle.GetFightStageEndCorpsInfo;
/*     */ import mzm.gsp.crossbattle.GetFightStageEndCorpsInfo_MapChampionStatue;
/*     */ import mzm.gsp.crossbattle.confbean.CrossBattleConsts;
/*     */ import mzm.gsp.crossbattle.confbean.KnockOutCfg;
/*     */ import mzm.gsp.crossbattle.confbean.SCrossBattleHistoryCfg;
/*     */ import mzm.gsp.crossbattle.confbean.SCrossBattleKnockOutCfg;
/*     */ import mzm.gsp.crossbattle.main.CrossBattleOneByOneManager;
/*     */ import mzm.gsp.grc.main.GrcInterface;
/*     */ import mzm.gsp.util.Pair;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.CrossBattleKnockoutActivityInfo;
/*     */ import xbean.CrossBattleKnockoutInfo;
/*     */ import xbean.FightAgainstInfo;
/*     */ import xbean.FightStageInfo;
/*     */ import xbean.FightZoneInfo;
/*     */ import xdb.Executor;
/*     */ import xdb.Xdb;
/*     */ 
/*     */ public class PQueryCrossBattleFinalChampion extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private int currentSession;
/*     */   private int activityCfgId;
/*     */   
/*     */   public PQueryCrossBattleFinalChampion(int currentSession)
/*     */   {
/*  36 */     this.currentSession = currentSession;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  42 */     SCrossBattleHistoryCfg sCrossBattleHistoryCfg = SCrossBattleHistoryCfg.get(this.currentSession);
/*  43 */     if (sCrossBattleHistoryCfg == null)
/*     */     {
/*  45 */       onQueryCrossBattleFinalChampionFailed(9);
/*  46 */       return false;
/*     */     }
/*     */     
/*  49 */     this.activityCfgId = sCrossBattleHistoryCfg.activity_cfg_id;
/*  50 */     long currentActivityBeginTime = mzm.gsp.activity.main.ActivityInterface.getActivityLimitTimeBegin(this.activityCfgId);
/*     */     
/*  52 */     if (currentActivityBeginTime > mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis())
/*     */     {
/*  54 */       TreeMap<Integer, SCrossBattleHistoryCfg> sCrossBattleHistoryCfgMap = (TreeMap)SCrossBattleHistoryCfg.getAll();
/*  55 */       Map.Entry<Integer, SCrossBattleHistoryCfg> lastCrossBattleSessionEntry = sCrossBattleHistoryCfgMap.lowerEntry(Integer.valueOf(this.currentSession));
/*     */       
/*  57 */       if (lastCrossBattleSessionEntry == null)
/*     */       {
/*  59 */         onQueryCrossBattleFinalChampionFailed(27);
/*     */         
/*     */ 
/*  62 */         CrossBattleKnockoutManager.triggerGetFinalChampionMapStatue(true, false, this.currentSession, new FightStageEndCorpsInfo());
/*     */         
/*  64 */         return true;
/*     */       }
/*     */       
/*     */ 
/*  68 */       this.currentSession = ((Integer)lastCrossBattleSessionEntry.getKey()).intValue();
/*  69 */       this.activityCfgId = ((SCrossBattleHistoryCfg)lastCrossBattleSessionEntry.getValue()).activity_cfg_id;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*  74 */     SCrossBattleKnockOutCfg sCrossBattleKnockOutCfg = SCrossBattleKnockOutCfg.get(this.activityCfgId);
/*  75 */     if (sCrossBattleKnockOutCfg == null)
/*     */     {
/*  77 */       onQueryCrossBattleFinalChampionFailed(6);
/*  78 */       return false;
/*     */     }
/*     */     
/*  81 */     KnockOutCfg knockOutCfg = (KnockOutCfg)sCrossBattleKnockOutCfg.knockOutTypeCfgMap.get(Integer.valueOf(2));
/*  82 */     if (knockOutCfg == null)
/*     */     {
/*  84 */       onQueryCrossBattleFinalChampionFailed(7);
/*  85 */       return false;
/*     */     }
/*     */     
/*  88 */     long globalActivityCfgId = mzm.gsp.GameServerInfoManager.toGlobalId(this.activityCfgId);
/*     */     
/*  90 */     CrossBattleKnockoutActivityInfo xCrossBattleKnockoutActivityInfo = xtable.Cross_battle_knockout.get(Long.valueOf(globalActivityCfgId));
/*     */     
/*  92 */     CrossBattleKnockoutInfo xCrossBattleKnockoutInfo = null;
/*  93 */     if (xCrossBattleKnockoutActivityInfo != null)
/*     */     {
/*  95 */       xCrossBattleKnockoutInfo = (CrossBattleKnockoutInfo)xCrossBattleKnockoutActivityInfo.getKnockout_info_map().get(Integer.valueOf(2));
/*     */     }
/*     */     
/*  98 */     FightZoneInfo xFightZoneInfo = null;
/*  99 */     if (xCrossBattleKnockoutInfo != null)
/*     */     {
/* 101 */       xFightZoneInfo = (FightZoneInfo)xCrossBattleKnockoutInfo.getFight_zone_info_map().get(Integer.valueOf(CrossBattleKnockoutManager.GLOBAL_FIGHT_ZONE));
/*     */     }
/*     */     
/* 104 */     if ((xCrossBattleKnockoutActivityInfo == null) || (xCrossBattleKnockoutInfo == null) || (xFightZoneInfo == null))
/*     */     {
/* 106 */       KnockOutHandler knockOutHandler = CrossBattleKnockoutManager.getKnockOutHandler(2);
/* 107 */       if (knockOutHandler == null)
/*     */       {
/* 109 */         onQueryCrossBattleFinalChampionFailed(13);
/* 110 */         return false;
/*     */       }
/*     */       
/* 113 */       long canGetKnockOutInfoTime = knockOutHandler.getCanGetKnockOutInfoTime(this.activityCfgId);
/* 114 */       if (canGetKnockOutInfoTime > mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis())
/*     */       {
/* 116 */         onQueryCrossBattleFinalChampionFailed(15);
/* 117 */         if (this.currentSession > 1)
/*     */         {
/* 119 */           new PQueryCrossBattleFinalChampion(this.currentSession - 1).execute();
/*     */         }
/*     */         else
/*     */         {
/* 123 */           CrossBattleKnockoutManager.triggerGetFinalChampionMapStatue(true, false, this.currentSession, new FightStageEndCorpsInfo());
/*     */         }
/*     */         
/* 126 */         return true;
/*     */       }
/* 128 */       mzm.gsp.crossbattle.GetKnockOutContext_GetFinalChampionCorpsInfo context = new mzm.gsp.crossbattle.GetKnockOutContext_GetFinalChampionCorpsInfo(this.currentSession, this.activityCfgId);
/*     */       
/*     */ 
/* 131 */       OctetsStream octetsStream = new OctetsStream();
/* 132 */       octetsStream.marshal(context);
/*     */       
/* 134 */       mzm.gsp.crossbattle.GetKnockOutContext getKnockOutContext = new mzm.gsp.crossbattle.GetKnockOutContext();
/* 135 */       getKnockOutContext.oper_type = 13;
/* 136 */       getKnockOutContext.content = octetsStream;
/*     */       
/* 138 */       Pair<Integer, Boolean> nowFightStagePair = CrossBattleKnockoutInterface.getNowFightStage(this.activityCfgId, 2);
/*     */       
/* 140 */       if (nowFightStagePair == null)
/*     */       {
/* 142 */         onQueryCrossBattleFinalChampionFailed(7);
/* 143 */         return false;
/*     */       }
/*     */       
/* 146 */       int nowKnockOutStage = ((Integer)nowFightStagePair.first).intValue();
/* 147 */       boolean isSendSuccess = GrcInterface.getCrossBattleKnockOutInfo(this.activityCfgId, 2, CrossBattleKnockoutManager.GLOBAL_FIGHT_ZONE, nowKnockOutStage, knockOutCfg.need_team_size, knockOutCfg.stage_name_list.size(), knockOutCfg.fight_times_every_stage, new OctetsStream().marshal(getKnockOutContext));
/*     */       
/*     */ 
/*     */ 
/* 151 */       if (!isSendSuccess)
/*     */       {
/* 153 */         Xdb.executor().schedule(new RRepeatGetCrossBattleKnockOutInfo(this.activityCfgId, 2, CrossBattleKnockoutManager.GLOBAL_FIGHT_ZONE, nowKnockOutStage, knockOutCfg.need_team_size, knockOutCfg.stage_name_list.size(), knockOutCfg.fight_times_every_stage, new OctetsStream().marshal(getKnockOutContext)), 60000L, TimeUnit.MICROSECONDS);
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 161 */       return isSendSuccess;
/*     */     }
/*     */     
/* 164 */     CrossBattleOneByOneManager.getInstance().addLogicProcedure(Integer.valueOf(this.activityCfgId), new PNotifyCrossBattleFinalChampionCorpsInfo(this.currentSession, this.activityCfgId));
/*     */     
/*     */ 
/* 167 */     StringBuilder sb = new StringBuilder();
/* 168 */     sb.append("[crossbattle_knockout]PQueryCrossBattleFinalChampion.processImp@get cross battle final champion req success");
/* 169 */     sb.append("|activity_cfg_id=").append(this.activityCfgId);
/* 170 */     sb.append("|session=").append(this.currentSession);
/*     */     
/* 172 */     GameServer.logger().info(sb.toString());
/* 173 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   private static class RRepeatGetCrossBattleKnockOutInfo
/*     */     implements Runnable
/*     */   {
/*     */     private final int activityCfgId;
/*     */     private final int knockOutType;
/*     */     private final int fightZoneId;
/*     */     private final int nowFightStage;
/*     */     private final int needTeamSize;
/*     */     private final int stageSize;
/*     */     private final int fightTimesEveryStage;
/*     */     public final OctetsStream octetsStream;
/*     */     public int repeatTimes;
/*     */     
/*     */     public RRepeatGetCrossBattleKnockOutInfo(int activityCfgId, int knockOutType, int fightZoneId, int nowFightStage, int needTeamSize, int stageSize, int fightTimesEveryStage, OctetsStream octetsStream)
/*     */     {
/* 192 */       this.activityCfgId = activityCfgId;
/* 193 */       this.knockOutType = knockOutType;
/* 194 */       this.fightZoneId = fightZoneId;
/* 195 */       this.nowFightStage = nowFightStage;
/* 196 */       this.needTeamSize = needTeamSize;
/* 197 */       this.stageSize = stageSize;
/* 198 */       this.fightTimesEveryStage = fightTimesEveryStage;
/* 199 */       this.octetsStream = octetsStream;
/* 200 */       this.repeatTimes += 1;
/*     */     }
/*     */     
/*     */ 
/*     */     public void run()
/*     */     {
/* 206 */       boolean isSendSuccess = GrcInterface.getCrossBattleKnockOutInfo(this.activityCfgId, this.knockOutType, this.fightZoneId, this.nowFightStage, this.needTeamSize, this.stageSize, this.fightTimesEveryStage, this.octetsStream);
/*     */       
/* 208 */       if (!isSendSuccess)
/*     */       {
/* 210 */         this.repeatTimes += 1;
/* 211 */         if (this.repeatTimes < 10)
/*     */         {
/* 213 */           Xdb.executor().schedule(this, 60000L, TimeUnit.MICROSECONDS);
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   private void onQueryCrossBattleFinalChampionFailed(int ret)
/*     */   {
/* 222 */     onQueryCrossBattleFinalChampionFailed(ret, null);
/*     */   }
/*     */   
/*     */   private void onQueryCrossBattleFinalChampionFailed(int ret, Map<String, Object> extraMap)
/*     */   {
/* 227 */     StringBuilder sb = new StringBuilder();
/* 228 */     sb.append("[crossbattle_knockout]PQueryCrossBattleFinalChampion.processImp@error");
/* 229 */     sb.append("|ret=").append(ret);
/* 230 */     sb.append("|current_activity_id=").append(this.activityCfgId);
/* 231 */     sb.append("|current_session=").append(this.currentSession);
/*     */     
/* 233 */     if ((extraMap != null) && (!extraMap.isEmpty()))
/*     */     {
/* 235 */       for (Map.Entry<String, Object> entry : extraMap.entrySet())
/*     */       {
/* 237 */         sb.append("|").append((String)entry.getKey()).append("=").append(entry.getValue());
/*     */       }
/*     */     }
/*     */     
/* 241 */     GameServer.logger().error(sb.toString());
/*     */   }
/*     */   
/*     */   public static class PNotifyCrossBattleFinalChampionCorpsInfo
/*     */     extends mzm.gsp.util.LogicProcedure
/*     */   {
/*     */     private final int session;
/*     */     private int activityCfgId;
/*     */     
/*     */     public PNotifyCrossBattleFinalChampionCorpsInfo(int session, int activityCfgId)
/*     */     {
/* 252 */       this.session = session;
/* 253 */       this.activityCfgId = activityCfgId;
/*     */     }
/*     */     
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/* 259 */       if (this.session > CrossBattleConsts.getInstance().cross_battle_session_num)
/*     */       {
/* 261 */         Map<String, Object> extraMap = new HashMap();
/* 262 */         extraMap.put("current_session", Integer.valueOf(CrossBattleConsts.getInstance().cross_battle_session_num));
/*     */         
/* 264 */         onNotifyFailed(8, extraMap);
/* 265 */         return false;
/*     */       }
/*     */       
/* 268 */       SCrossBattleKnockOutCfg sCrossBattleKnockOutCfg = SCrossBattleKnockOutCfg.get(this.activityCfgId);
/* 269 */       if (sCrossBattleKnockOutCfg == null)
/*     */       {
/* 271 */         onNotifyFailed(6);
/* 272 */         return false;
/*     */       }
/*     */       
/* 275 */       KnockOutCfg knockOutCfg = (KnockOutCfg)sCrossBattleKnockOutCfg.knockOutTypeCfgMap.get(Integer.valueOf(2));
/* 276 */       if (knockOutCfg == null)
/*     */       {
/* 278 */         onNotifyFailed(7);
/* 279 */         return false;
/*     */       }
/*     */       
/* 282 */       SCrossBattleHistoryCfg sCrossBattleHistoryCfg = SCrossBattleHistoryCfg.get(this.session);
/* 283 */       if (sCrossBattleHistoryCfg == null)
/*     */       {
/* 285 */         onNotifyFailed(9);
/* 286 */         return false;
/*     */       }
/*     */       
/* 289 */       this.activityCfgId = sCrossBattleHistoryCfg.activity_cfg_id;
/*     */       
/* 291 */       long globalActivityCfgid = mzm.gsp.GameServerInfoManager.toGlobalId(this.activityCfgId);
/* 292 */       CrossBattleKnockoutActivityInfo xCrossBattleKnockoutActivityInfo = xtable.Cross_battle_knockout.get(Long.valueOf(globalActivityCfgid));
/*     */       
/* 294 */       if (xCrossBattleKnockoutActivityInfo == null)
/*     */       {
/* 296 */         onNotifyFailed(3);
/* 297 */         return false;
/*     */       }
/*     */       
/* 300 */       CrossBattleKnockoutInfo xCrossBattleKnockoutInfo = (CrossBattleKnockoutInfo)xCrossBattleKnockoutActivityInfo.getKnockout_info_map().get(Integer.valueOf(2));
/*     */       
/* 302 */       if (xCrossBattleKnockoutInfo == null)
/*     */       {
/* 304 */         onNotifyFailed(4);
/* 305 */         return false;
/*     */       }
/*     */       
/* 308 */       FightZoneInfo xFightZoneInfo = (FightZoneInfo)xCrossBattleKnockoutInfo.getFight_zone_info_map().get(Integer.valueOf(CrossBattleKnockoutManager.GLOBAL_FIGHT_ZONE));
/*     */       
/* 310 */       if (xFightZoneInfo == null)
/*     */       {
/* 312 */         onNotifyFailed(5);
/* 313 */         return false;
/*     */       }
/*     */       
/* 316 */       Pair<Integer, Boolean> nowFightStagePair = CrossBattleKnockoutInterface.getNowFightStage(this.activityCfgId, 2);
/*     */       
/* 318 */       if (nowFightStagePair == null)
/*     */       {
/* 320 */         onNotifyFailed(7);
/* 321 */         return false;
/*     */       }
/*     */       
/* 324 */       int nowFightStage = ((Integer)nowFightStagePair.first).intValue();
/*     */       
/* 326 */       int championFirstStage = knockOutCfg.stage_time_point_cfg_id_list.size() - knockOutCfg.fight_times_every_stage + 1;
/*     */       
/* 328 */       if (((Integer)nowFightStagePair.first).intValue() < championFirstStage)
/*     */       {
/* 330 */         onNotifyFailed(16);
/* 331 */         if (this.session > 1)
/*     */         {
/* 333 */           new PQueryCrossBattleFinalChampion(this.session - 1).execute();
/*     */         }
/*     */         else
/*     */         {
/* 337 */           CrossBattleKnockoutManager.triggerGetFinalChampionMapStatue(true, false, this.session, new FightStageEndCorpsInfo());
/*     */         }
/*     */         
/* 340 */         return true;
/*     */       }
/*     */       
/* 343 */       FightStageInfo xFightStageInfo = (FightStageInfo)xFightZoneInfo.getFight_stage_info_map().get(Integer.valueOf(championFirstStage));
/* 344 */       if (xFightStageInfo == null)
/*     */       {
/* 346 */         onNotifyFailed(18);
/* 347 */         return false;
/*     */       }
/*     */       
/* 350 */       FightAgainstInfo xFightAgainstInfo = (FightAgainstInfo)xFightStageInfo.getFight_against_info_map().get(Integer.valueOf(1));
/* 351 */       if (xFightAgainstInfo == null)
/*     */       {
/* 353 */         onNotifyFailed(19);
/* 354 */         return false;
/*     */       }
/*     */       
/* 357 */       Pair<Long, Pair<Integer, Integer>> winPair = CrossBattleKnockoutManager.getWinCorpsId(xFightZoneInfo.getFight_stage_info_map(), xFightAgainstInfo.getA_corps_id(), xFightAgainstInfo.getB_corps_id(), nowFightStage, 1, knockOutCfg.fight_times_every_stage);
/*     */       
/*     */ 
/* 360 */       boolean isByeWin = CrossBattleKnockoutManager.isByeWin(xFightAgainstInfo);
/* 361 */       if ((((Long)winPair.first).longValue() == -1L) && (!isByeWin))
/*     */       {
/* 363 */         StringBuilder sb = new StringBuilder();
/* 364 */         sb.append("[crossbattle_knockout]PNotifyCrossBattleFinalHistoryFight.processImp@this session not has champion,draw!");
/* 365 */         sb.append("|session=").append(this.session);
/* 366 */         sb.append("|activity_cfg_id=").append(this.activityCfgId);
/* 367 */         sb.append("|now_fight_stage=").append(nowFightStage);
/* 368 */         GameServer.logger().info(sb.toString());
/*     */         
/* 370 */         onNotifyFailed(17);
/*     */         
/* 372 */         if (this.session > 1)
/*     */         {
/* 374 */           new PQueryCrossBattleFinalChampion(this.session - 1).execute();
/*     */         }
/*     */         else
/*     */         {
/* 378 */           CrossBattleKnockoutManager.triggerGetFinalChampionMapStatue(true, false, this.session, new FightStageEndCorpsInfo());
/*     */         }
/*     */         
/* 381 */         return true;
/*     */       }
/*     */       
/* 384 */       GetFightStageEndCorpsInfo_MapChampionStatue context = new GetFightStageEndCorpsInfo_MapChampionStatue(this.session);
/*     */       
/* 386 */       OctetsStream octetsStream = new OctetsStream();
/* 387 */       octetsStream.marshal(context);
/*     */       
/* 389 */       GetFightStageEndCorpsInfo getKnockOutContext = new GetFightStageEndCorpsInfo();
/* 390 */       getKnockOutContext.oper_type = 2;
/* 391 */       getKnockOutContext.content = octetsStream;
/*     */       
/* 393 */       int lastFightStage = -1;
/* 394 */       int totalStageSize = knockOutCfg.stage_time_point_cfg_id_list.size();
/* 395 */       if (isByeWin)
/*     */       {
/* 397 */         lastFightStage = totalStageSize - knockOutCfg.fight_times_every_stage + 1;
/*     */       }
/*     */       else
/*     */       {
/* 401 */         for (int lastStage = totalStageSize; lastStage > totalStageSize - knockOutCfg.fight_times_every_stage; lastStage--)
/*     */         {
/* 403 */           FightStageInfo xTempFightStageInfo = (FightStageInfo)xFightZoneInfo.getFight_stage_info_map().get(Integer.valueOf(lastStage));
/* 404 */           if (xTempFightStageInfo != null)
/*     */           {
/* 406 */             FightAgainstInfo xTempFightAgainstInfo = (FightAgainstInfo)xTempFightStageInfo.getFight_against_info_map().get(Integer.valueOf(1));
/*     */             
/* 408 */             if ((xTempFightAgainstInfo != null) && (xTempFightAgainstInfo.getCal_fight_result() != 0))
/*     */             {
/* 410 */               lastFightStage = lastStage;
/* 411 */               break;
/*     */             }
/*     */           }
/*     */         }
/*     */       }
/*     */       
/* 417 */       if (lastFightStage == -1)
/*     */       {
/* 419 */         Map<String, Object> extraMap = new HashMap();
/* 420 */         extraMap.put("last_fight_stage", Integer.valueOf(lastFightStage));
/* 421 */         onNotifyFailed(17);
/* 422 */         return false;
/*     */       }
/*     */       
/* 425 */       long championCorpsId = ((Long)winPair.first).longValue();
/* 426 */       if (isByeWin)
/*     */       {
/* 428 */         if (xFightAgainstInfo.getCal_fight_result() == FightResultEnum.A_BYE_WIN.fightResult)
/*     */         {
/* 430 */           championCorpsId = xFightAgainstInfo.getA_corps_id();
/*     */         }
/*     */         else
/*     */         {
/* 434 */           championCorpsId = xFightAgainstInfo.getB_corps_id();
/*     */         }
/*     */       }
/* 437 */       boolean isSendSuccess = GrcInterface.getCrossBattleStageFightEndCorpsInfo(this.activityCfgId, 2, lastFightStage, championCorpsId, new OctetsStream().marshal(getKnockOutContext));
/*     */       
/* 439 */       if (!isSendSuccess)
/*     */       {
/* 441 */         Xdb.executor().schedule(new RRepeatGetCrossBattleStageFightEndCorpsInfo(this.activityCfgId, 2, lastFightStage, championCorpsId, new OctetsStream().marshal(getKnockOutContext)), 60000L, TimeUnit.MILLISECONDS);
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 447 */       StringBuilder sb = new StringBuilder();
/* 448 */       sb.append("[crossbattle_knockout]PNotifyCrossBattleFinalChampionCorpsInfo.processImp@get success");
/* 449 */       sb.append("|session=").append(this.session);
/* 450 */       sb.append("|activity_cfg_id=").append(this.activityCfgId);
/*     */       
/* 452 */       GameServer.logger().info(sb.toString());
/*     */       
/* 454 */       return true;
/*     */     }
/*     */     
/*     */     private static class RRepeatGetCrossBattleStageFightEndCorpsInfo
/*     */       implements Runnable
/*     */     {
/*     */       private final int activityCfgId;
/*     */       private final int knockOutType;
/*     */       private final int lastFightStage;
/*     */       private final long winCorpsId;
/*     */       private final OctetsStream octetsStream;
/*     */       private int repeatTimes;
/*     */       
/*     */       public RRepeatGetCrossBattleStageFightEndCorpsInfo(int activityCfgId, int knockOutType, int lastFightStage, long winCorpsId, OctetsStream octetsStream)
/*     */       {
/* 469 */         this.activityCfgId = activityCfgId;
/* 470 */         this.knockOutType = knockOutType;
/* 471 */         this.lastFightStage = lastFightStage;
/* 472 */         this.winCorpsId = winCorpsId;
/* 473 */         this.octetsStream = octetsStream;
/* 474 */         this.repeatTimes = 0;
/*     */       }
/*     */       
/*     */ 
/*     */       public void run()
/*     */       {
/* 480 */         boolean isSendSuccess = GrcInterface.getCrossBattleStageFightEndCorpsInfo(this.activityCfgId, this.knockOutType, this.lastFightStage, this.winCorpsId, this.octetsStream);
/*     */         
/* 482 */         if (!isSendSuccess)
/*     */         {
/* 484 */           this.repeatTimes += 1;
/* 485 */           if (this.repeatTimes < 10)
/*     */           {
/* 487 */             Xdb.executor().schedule(this, 60000L, TimeUnit.MILLISECONDS);
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */     private void onNotifyFailed(int ret)
/*     */     {
/* 496 */       onNotifyFailed(ret, null);
/*     */     }
/*     */     
/*     */     private void onNotifyFailed(int ret, Map<String, Object> extraMap)
/*     */     {
/* 501 */       StringBuilder sb = new StringBuilder();
/* 502 */       sb.append("[crossbattle_knockout]PNotifyCrossBattleFinalChampionCorpsInfo.processImp@error");
/* 503 */       sb.append("|ret=").append(ret);
/* 504 */       sb.append("|session=").append(this.session);
/* 505 */       sb.append("|activity_cfg_id=").append(this.activityCfgId);
/*     */       
/* 507 */       if ((extraMap != null) && (!extraMap.isEmpty()))
/*     */       {
/* 509 */         for (Map.Entry<String, Object> entry : extraMap.entrySet())
/*     */         {
/* 511 */           sb.append("|").append((String)entry.getKey()).append("=").append(entry.getValue());
/*     */         }
/*     */       }
/*     */       
/* 515 */       GameServer.logger().error(sb.toString());
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\knockout\PQueryCrossBattleFinalChampion.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */